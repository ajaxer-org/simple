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
	/**
	 * @since v0.0.1
	 */
	public static final int BUFFER_SIZE = 1024;

	/**
	 * @since v0.0.1
	 */
	public static final int ONE_BYTE = 1024;

	/**
	 * @since v0.0.1
	 */
	public static List<String> readLines(File file) throws IOException
	{
		log.debug("file: {}", file);
		SimpleUtils.throwWhenNull(file);

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
		StringUtils.throwWhenBlank(path);

		return readLines(new File(path));
	}

	/**
	 * @since v0.0.1
	 */
	public static String readFile(String path) throws IOException
	{
		log.debug("path: {}", path);
		StringUtils.throwWhenBlank(path);

		return readFile(new File(path));
	}

	/**
	 * @since v0.0.1
	 */
	public static String readFile(File file) throws IOException
	{
		log.debug("file: {}", file);
		StringBuilder builder = new StringBuilder();

		List<String> lines = readLines(file);
		if (CollectionUtils.isBlank(lines))
		{
			return builder.toString();
		}

		for (int i = 0; i < lines.size(); i++)
		{
			builder.append(lines.get(i));

			if (i + 1 != lines.size())
			{
				// DO NOT ADD NEW LINE AT THE END
				builder.append(System.lineSeparator());
			}
		}

		return builder.toString();
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(String path, String msg, boolean append) throws IOException
	{
		log.debug("path: {}", path);
		StringUtils.throwWhenBlank(path);

		writeFile(new File(path), msg, append);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(File file, String msg, boolean append) throws IOException
	{
		log.debug("file: {}, append: {}, msg: {}", file, append, msg);
		SimpleUtils.throwWhenNull(file);

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
		StringUtils.throwWhenBlank(path);

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
		SimpleUtils.throwWhenNull(file);

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
		StringUtils.throwWhenBlank(path);

		writeSerializedObject(new File(path), t);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T extends Serializable> void writeSerializedObject(File file, T t) throws IOException
	{
		log.debug("file: {}, t: {}", file, t);
		SimpleUtils.throwWhenNull(file);

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
		StringUtils.throwWhenBlank(path);
		SimpleUtils.throwWhenNull(tClass);

		return readXmlObject(new File(path), tClass);
	}

	/**
	 * @since v0.0.1
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readXmlObject(File file, Class<T> tClass) throws IOException
	{
		log.debug("tClass: {}, file: {}", tClass, file);
		SimpleUtils.throwWhenNull(file);
		SimpleUtils.throwWhenNull(tClass);

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
		StringUtils.throwWhenBlank(path);

		writeXmlObject(new File(path), t);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeXmlObject(File file, T t) throws IOException
	{
		log.debug("file: {}, t: {}", file, t);
		SimpleUtils.throwWhenNull(file);

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
		StringUtils.throwWhenBlank(path);
		SimpleUtils.throwWhenNull(tClass);

		return readJsonObject(new File(path), tClass);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T readJsonObject(File file, Class<T> tClass) throws IOException
	{
		log.debug("tClass: {}, file: {}", tClass, file);
		SimpleUtils.throwWhenNull(file);
		SimpleUtils.throwWhenNull(tClass);

		String fileData = readFile(file);
		return JsonUtils.getGson().fromJson(fileData, tClass);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeJsonObject(String path, T t) throws IOException
	{
		log.debug("path: {}, t: {}", path, t);
		StringUtils.throwWhenBlank(path);

		writeJsonObject(new File(path), t);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void writeJsonObject(File file, T t) throws IOException
	{
		log.debug("file: {}, t: {}", file, t);
		SimpleUtils.throwWhenNull(file);

		String jsonString = JsonUtils.getGson().toJson(t);
		writeFile(file, jsonString, false);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile()
	{
		return createTempFile(null, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String prefix, String suffix)
	{
		try
		{
			return createTempFile(prefix + StringUtils.getUUID() + suffix);
		} catch (FileAlreadyExistsException e)
		{
			return createTempFile();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String fileName) throws FileAlreadyExistsException
	{
		return createTempFile(null, fileName, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String prefix, String filename, String suffix) throws FileAlreadyExistsException
	{
		log.debug("prefix: {}, filename: {}, suffix: {}", prefix, filename, suffix);

		StringUtils.throwWhenBlank(filename, "filename cannot be blank");

		prefix = prefix == null ? "" : prefix.trim();
		suffix = suffix == null ? "" : suffix.trim();

		File file = new File(SystemUtils.getTempDirectory(), prefix + filename + suffix);
		if (file.exists())
		{
			throw new FileAlreadyExistsException(file.getAbsolutePath());
		}
		return file;
	}

	/**
	 * @since v0.0.1
	 */
	public static void copy(String source, String target)
	{
		log.debug("source: {}, target: {}", source, target);
		copy(new File(source), new File(target));
	}

	/**
	 * @since v0.0.1
	 */
	public static void copy(File source, File target)
	{
		log.debug("source: {}, target: {}", source, target);
		try (FileInputStream fileInputStream = new FileInputStream(source);
			 FileOutputStream fileOutputStream = new FileOutputStream(target))
		{
			copyBytes(fileInputStream, fileOutputStream);
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void copyBytes(InputStream inputStream, OutputStream outputStream)
	{
		log.debug("inputStream: {}, outputStream: {}", inputStream, outputStream);
		copyBytes(FileUtils.BUFFER_SIZE, inputStream, outputStream);
	}

	/**
	 * @since v0.0.1
	 */
	public static void copyBytes(int bufferSize, InputStream inputStream, OutputStream outputStream)
	{
		log.debug("bufferSize: {}, inputStream: {}, outputStream: {}", bufferSize, inputStream, outputStream);
		try
		{
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
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * <code>/home/user/files/some-text-file.txt</code> will give you <code>txt</code>
	 *
	 * @since v0.0.1
	 */
	public static String getExtension(String text)
	{
		if (text.contains("."))
		{
			return text.substring(text.lastIndexOf(".") + 1);
		}

		return null;
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
		{
			return;
		}

		if (recursive && file.isDirectory())
		{
			//noinspection ConstantConditions
			for (File childFile : file.listFiles())
			{
				//noinspection ConstantConditions
				delete(childFile, recursive);
			}
		}

		// deleting
		log.info("[{}] \t {}", file.delete(), file.getAbsolutePath());
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
		log.debug("file0: {}, hash0: {}", file0, hash0);

		String hash1 = HashUtils.getSHA1Hash(file1);
		log.debug("file1: {}, hash1: {}", file1, hash1);

		return hash0.equals(hash1);
	}
}
