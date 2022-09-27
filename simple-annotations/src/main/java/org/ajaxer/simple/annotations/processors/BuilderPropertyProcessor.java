package org.ajaxer.simple.annotations.processors;

import com.google.auto.service.AutoService;
import org.ajaxer.simple.annotations.BuilderProperty;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Shakir
 * @version 2022-09-23
 * @since 0.0.2
 */
@SuppressWarnings("unused")
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("org.ajaxer.simple.annotations.BuilderProperty")
public class BuilderPropertyProcessor extends AbstractProcessor
{
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
	{
		for (TypeElement annotation : annotations)
		{
			Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

			annotatedElements.forEach(annotatedElement -> checkForDefaultConstructor(((TypeElement) annotatedElement.getEnclosingElement())));

			Map<Boolean, List<Element>> annotatedMethods = annotatedElements
					.stream()
					.collect(Collectors.partitioningBy(element -> ((ExecutableType) element.asType())
							.getParameterTypes().size() == 1 && element.getSimpleName().toString().startsWith("set")));

			List<Element> setters = annotatedMethods.get(true);
			List<Element> otherMethods = annotatedMethods.get(false);

			otherMethods.forEach(element -> processingEnv
					.getMessager()
					.printMessage(Diagnostic.Kind.ERROR, "@" + BuilderProperty.class.getSimpleName() + " must be applied to a setXxx method with a single argument", element));

			if (setters.isEmpty())
			{
				continue;
			}

			String className = ((TypeElement) setters.get(0).getEnclosingElement()).getQualifiedName().toString();

			Map<String, String> setterMap = setters
					.stream()
					.collect(Collectors.toMap(setter -> setter.getSimpleName().toString(), setter -> ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString()));

			try
			{
				writeBuilderFile(className, setterMap);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return true;
	}

	private void checkForDefaultConstructor(TypeElement type)
	{
		for (ExecutableElement cons : ElementFilter.constructorsIn(type.getEnclosedElements()))
		{
			if (cons.getParameters().isEmpty()) return;
		}
		// Couldn't find any default constructor here
		processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, type.getQualifiedName() + " is missing a default constructor", type);
	}

	private void writeBuilderFile(String className, Map<String, String> setterMap) throws IOException
	{

		String packageName = null;
		int lastDot = className.lastIndexOf('.');
		if (lastDot > 0)
		{
			packageName = className.substring(0, lastDot);
		}

		String simpleClassName = className.substring(lastDot + 1);
		String builderClassName = className + "Builder";
		String builderSimpleClassName = builderClassName.substring(lastDot + 1);

		JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(builderClassName);
		try (PrintWriter out = new PrintWriter(builderFile.openWriter()))
		{
			if (packageName != null)
			{
				out.print("package " + packageName + ";");
				out.println();
			}

			out.print("public class " + builderSimpleClassName + " {");
			out.println();

			out.print("public " + builderSimpleClassName + " () {}");

			out.print("private " + simpleClassName + " object = new " + simpleClassName + "();");
			out.println();

			out.print("public " + simpleClassName + " build() { return object; }");
			out.println();

			setterMap.forEach((methodName, argumentType) -> {
				out.print("public " + builderSimpleClassName + " " + methodName + "(" + argumentType + " value) ");
				out.print("{ object." + methodName + "(value); return this; }");
				out.println();
			});

			out.println("}");
		}
	}
}