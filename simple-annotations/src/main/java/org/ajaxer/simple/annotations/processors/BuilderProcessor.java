package org.ajaxer.simple.annotations.processors;

import com.google.auto.service.AutoService;
import org.ajaxer.simple.annotations.Builder;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static javax.lang.model.element.ElementKind.FIELD;

/**
 * @author Shakir
 * @version 2022-09-18
 * @since 0.0.2
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("org.ajaxer.simple.annotations.Builder")
public class BuilderProcessor extends AbstractProcessor
{
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
	{
		annotations.forEach(annotation -> roundEnv.getElementsAnnotatedWith(Builder.class).forEach(this::generateBuilderFile));
		return true;
	}

	private void generateBuilderFile(Element element)
	{
		//Employee
		String className = element.getSimpleName().toString();
		//org.ajaxer.package
		String packageName = element.getEnclosingElement().toString();
		//EmployeeBuilder
		String builderName = className + "Builder";
		//org.ajaxer.package.EmployeeBuilder
		String builderFullName = packageName + "." + builderName;

		//get all getters
		List<? extends Element> fields = element.getEnclosedElements().stream().filter(e -> FIELD.equals(e.getKind())).collect(Collectors.toList());

		try (PrintWriter writer = new PrintWriter(processingEnv.getFiler().createSourceFile(builderFullName).openWriter()))
		{
			//package org.ajaxer.package;
			writer.println(String.format("package %s;", packageName));

			//public class EmployeeBuilder;
			writer.println(String.format("public class %s", builderName));
			writer.println("{");

			//private int age;
			//private String name;
			fields.forEach(field -> writer.print(String.format("private %s %s;", field.asType().toString(), field.getSimpleName())));

			writer.println();

			//public int age(int value) {age = value; return this;}
			fields.forEach(field -> writer.print(String.format("public %s %s(%s value) {%s = value; return this;}",
															   builderName,
															   field.getSimpleName(),
															   field.asType().toString(),
															   field.getSimpleName())));

			//public Employee build() { new Employee(age, name);}
			writer.println(String.format("public %s build() { return new %s(%s); }",
										 className,
										 className,
										 fields.stream().map(Element::getSimpleName).collect(joining(", "))));
			writer.println("}");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
