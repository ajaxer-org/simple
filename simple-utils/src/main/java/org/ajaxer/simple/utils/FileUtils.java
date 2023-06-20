package org.ajaxer.simple.utils;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class FileUtils
{
	private FileUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static final int ONE_BYTE = 1024;

	/**
	 * <p> return true if given file is <b>not</b> <code>null</code> and do <code>exists</code></p>
	 *
	 * @since v0.0.1
	 */
	public static boolean isValid(File file)
	{
		return file != null && file.exists();
	}

	/**
	 * <p> return true if given file is <code>null</code> or do <b>not</b> <code>exists</code> </p>
	 *
	 * @since v0.0.1
	 */
	public static boolean isNotValid(File file)
	{
		return !isValid(file);
	}

	/**
	 * <p> return true if given path is <b>not</b> <code>null</code> and do <code>exists</code></p>
	 *
	 * @since v0.0.1
	 */
	public static boolean isValid(String path)
	{
		return path != null && new File(path).exists();
	}

	/**
	 * <p> return true if given path is <code>null</code> or do <b>not</b> <code>exists</code> </p>
	 *
	 * @since v0.0.1
	 */
	public static boolean isNotValid(String path)
	{
		return !isValid(path);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equals(String file0, String file1)
	{
		return equals(new File(file0), new File(file1));
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equals(File file0, File file1)
	{
		String hash0 = HashUtils.getSHA1Hash(file0);
		log.info("file0: {}, hash0: {}", file0, hash0);

		String hash1 = HashUtils.getSHA1Hash(file1);
		log.info("file1: {}, hash1: {}", file1, hash1);

		return hash0.equals(hash1);
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> readLines(File file) throws IOException
	{
		log.debug("file: {}", file);
		ExceptionUtils.throwWhenNull(file);

		List<String> lines = new ArrayList<>();

		try (FileInputStream fileInputStream = new FileInputStream(file);
		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream)))
		{
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				lines.add(line);
			}
		}

		return lines;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> readLines(String path) throws IOException
	{
		log.debug("path: {}", path);
		ExceptionUtils.throwWhenBlank(path);

		return readLines(new File(path));
	}

	/**
	 * @since v0.0.1
	 */
	public static String readFile(String path) throws IOException
	{
		log.debug("path: {}", path);
		ExceptionUtils.throwWhenBlank(path);

		return readFile(new File(path));
	}

	/**
	 * @since v0.0.1
	 */
	public static String readFile(File file) throws IOException
	{
		log.debug("file: {}", file);

		List<String> lines = readLines(file);
		if (CollectionUtils.isBlank(lines))
			return null;

		return String.join(System.lineSeparator(), lines);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(String path, String msg, boolean append) throws IOException
	{
		log.debug("path: {}", path);
		ExceptionUtils.throwWhenBlank(path);

		writeFile(new File(path), msg, append);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(File file, String msg, boolean append) throws IOException
	{
		log.debug("file: {}, append: {}, msg: {}", file, append, msg);
		ExceptionUtils.throwWhenNull(file);

		try (FileOutputStream fileOutputStream = new FileOutputStream(file, append))
		{
			fileOutputStream.write(msg.getBytes());
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(String path, String msg) throws IOException
	{
		log.debug("path: {}", path);
		writeFile(path, msg, true);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(File file, String msg) throws IOException
	{
		writeFile(file, msg, true);
	}

	/**
	 * @since v0.0.1
	 */
	@SneakyThrows
	public static <T extends Serializable> T readSerializedObject(String path, Class<T> tClass)
	{
		log.debug("tClass: {}, path: {}", tClass, path);
		ExceptionUtils.throwWhenBlank(path);

		return readSerializedObject(new File(path), tClass);
	}

	/**
	 * @since v0.0.1
	 */
	@SneakyThrows
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T readSerializedObject(File file, Class<T> tClass)
	{
		log.debug("tClass:{}, file: {}", tClass, file);
		ExceptionUtils.throwWhenNull(file);

		try (FileInputStream fileInputStream = new FileInputStream(file);
		     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
		{
			return (T) objectInputStream.readObject();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T extends Serializable> void writeSerializedObject(String path, T t) throws IOException
	{
		log.debug("path: {}, t: {}", path, t);
		ExceptionUtils.throwWhenBlank(path);

		writeSerializedObject(new File(path), t);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T extends Serializable> void writeSerializedObject(File file, T t) throws IOException
	{
		log.debug("file: {}, t: {}", file, t);
		ExceptionUtils.throwWhenNull(file);

		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
		     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
		{
			objectOutputStream.writeObject(t);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T readXmlObject(String path, Class<T> tClass) throws IOException
	{
		log.debug("tClass: {}, path: {}", tClass, path);
		ExceptionUtils.throwWhenBlank(path);
		ExceptionUtils.throwWhenNull(tClass);

		return readXmlObject(new File(path), tClass);
	}

	/**
	 * @since v0.0.1
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readXmlObject(File file, Class<T> tClass) throws IOException
	{
		log.debug("tClass: {}, file: {}", tClass, file);
		ExceptionUtils.throwWhenNull(file);
		ExceptionUtils.throwWhenNull(tClass);

		try (FileInputStream fileInputStream = new FileInputStream(file);
		     XMLDecoder xMLDecoder = new XMLDecoder(fileInputStream))
		{
			return (T) xMLDecoder.readObject();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeXmlObject(String path, T t) throws IOException
	{
		log.debug("path: {}, t: {}", path, t);
		ExceptionUtils.throwWhenBlank(path);

		writeXmlObject(new File(path), t);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeXmlObject(File file, T t) throws IOException
	{
		log.debug("file: {}, t: {}", file, t);
		ExceptionUtils.throwWhenNull(file);

		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
		     XMLEncoder xMLEncoder = new XMLEncoder(fileOutputStream))
		{
			xMLEncoder.writeObject(t);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T readJsonObject(String path, Class<T> tClass) throws IOException
	{
		log.debug("tClass: {}, path: {}", tClass, path);
		ExceptionUtils.throwWhenBlank(path);
		ExceptionUtils.throwWhenNull(tClass);

		return readJsonObject(new File(path), tClass);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T readJsonObject(File file, Class<T> tClass) throws IOException
	{
		log.debug("tClass: {}, file: {}", tClass, file);
		ExceptionUtils.throwWhenNull(file);
		ExceptionUtils.throwWhenNull(tClass);

		String fileData = readFile(file);
		return JsonUtils.getGson().fromJson(fileData, tClass);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeJsonObject(String path, T t) throws IOException
	{
		log.debug("path: {}, t: {}", path, t);
		ExceptionUtils.throwWhenBlank(path);

		writeJsonObject(new File(path), t);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeJsonObject(File file, T t) throws IOException
	{
		log.debug("file: {}, t: {}", file, t);
		ExceptionUtils.throwWhenNull(file);

		String jsonString = JsonUtils.getGson().toJson(t);
		writeFile(file, jsonString, false);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile() throws IOException
	{
		return createTempFile(null, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String prefix, String suffix) throws IOException
	{
		return createTempFile(prefix, StringUtils.getUUID(), suffix);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String fileName) throws IOException
	{
		return createTempFile(null, fileName, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String prefix, String filename, String suffix) throws IOException
	{
		log.debug("prefix: {}, filename: {}, suffix: {}", prefix, filename, suffix);

		ExceptionUtils.throwWhenBlank(filename, "filename cannot be blank");

		prefix = prefix == null ? "" : prefix.trim();
		suffix = suffix == null ? "" : suffix.trim();

		File file = new File(SystemUtils.getTempDirectory(), prefix + filename + suffix);
		if (file.exists())
		{
			throw new FileAlreadyExistsException(file.getAbsolutePath());
		}
		return file.createNewFile() ? file : null;
	}

	/**
	 * @since v0.0.1
	 */
	public static long copy(String source, String target) throws IOException
	{
		log.debug("source: {}, target: {}", source, target);
		ExceptionUtils.throwWhenBlank(source);
		ExceptionUtils.throwWhenBlank(target);

		return copy(new File(source), new File(target));
	}

	/**
	 * @since v0.0.1
	 */
	public static long copy(File source, File target) throws IOException
	{
		log.debug("source: {}, target: {}", source, target);
		ExceptionUtils.throwWhenNull(source);
		ExceptionUtils.throwWhenNull(target);

		ExceptionUtils.throwWhenFalse(source.exists(), new FileNotFoundException());
		ExceptionUtils.throwWhenFalse(target.exists(), new FileNotFoundException());

		try (FileInputStream fileInputStream = new FileInputStream(source);
		     FileOutputStream fileOutputStream = new FileOutputStream(target))
		{
			return copy(fileInputStream, fileOutputStream);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException
	{
		log.debug("inputStream: {}, outputStream: {}", inputStream, outputStream);
		ExceptionUtils.throwWhenNull(inputStream);
		ExceptionUtils.throwWhenNull(outputStream);

		return copy(FileUtils.ONE_BYTE, inputStream, outputStream);
	}

	/**
	 * @since v0.0.1
	 */
	public static long copy(int bufferSize, InputStream inputStream, OutputStream outputStream) throws IOException
	{
		log.debug("bufferSize: {}, inputStream: {}, outputStream: {}", bufferSize, inputStream, outputStream);

		ExceptionUtils.throwWhenTrue(bufferSize <= 0, "bufferSize cannot be less or equals to zero");
		ExceptionUtils.throwWhenNull(inputStream);
		ExceptionUtils.throwWhenNull(outputStream);

		int i;
		byte[] buffer = new byte[bufferSize];
		long totalReadBytes = 0L;

		while ((i = inputStream.read(buffer)) != -1)
		{
			outputStream.write(buffer, 0, i);
			totalReadBytes += i;
		}

		log.debug("totalReadBytes: {}", totalReadBytes);
		outputStream.flush();

		return totalReadBytes;
	}

	/**
	 * <code>/home/user/files/some-text-file.txt</code> will give you <code>txt</code>
	 *
	 * @since v0.0.1
	 */
	public static String getExtension(String text)
	{
		if (StringUtils.isBlank(text))
			return null;

		return text.contains(".")
				? text.substring(text.lastIndexOf(".") + 1)
				: null;
	}

	/**
	 * @since v0.0.1
	 */
	public static String getExtension(String text, boolean withDot)
	{
		String ext = getExtension(text);
		return ext == null ? null : (withDot ? ("." + ext) : ext);
	}

	/**
	 * @since v0.0.1
	 */
	public static void delete(String file, boolean recursive)
	{
		log.debug("file: {}, recursive: {}", file, recursive);
		delete(new File(file), recursive);
	}

	/**
	 * @since v0.0.1
	 */
	public static void delete(File file, boolean recursive)
	{
		log.debug("file: {}, recursive: {}", file, recursive);

		if (!file.exists())
			return;

		if (file.isDirectory())
		{
			File[] children = file.listFiles();
			if (ArrayUtils.isNotBlank(children))
			{
				for (File child : children)
				{
					if (child.isFile())
						delete(child, false);

					if (child.isDirectory() && recursive)
						delete(child, true);
				}
			}
		}

		log.info("[{}] \t {}", file.delete(), file.getAbsolutePath());
	}
}
