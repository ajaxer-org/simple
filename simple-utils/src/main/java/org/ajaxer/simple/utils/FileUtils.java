package org.ajaxer.simple.utils;

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
	public static List<String> readLines(File file)
	{
		log.debug("file: {}", file);
		List<String> lines = new ArrayList<>();

		try (FileInputStream fileInputStream = new FileInputStream(file);
			 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream)))
		{
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				lines.add(line);
			}
		} catch (Exception e)
		{
			log.error("Exception", e);
			ExceptionUtils.rethrow(e);
		}

		return lines;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> readLines(String file)
	{
		return readLines(new File(file));
	}

	/**
	 * @since v0.0.1
	 */
	public static String readFile(String file)
	{
		return readFile(new File(file));
	}

	/**
	 * @since v0.0.1
	 */
	public static String readFile(File file)
	{
		log.debug("file: {}", file);
		StringBuilder builder = new StringBuilder();

		List<String> lines = readLines(file);
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
	public static void writeFile(String filePath, String msg, boolean append)
	{
		writeFile(new File(filePath), msg, append);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeFile(File file, String msg, boolean append)
	{
		log.debug("file: {}, append: {}, msg: {}", file, append, msg);
		try (FileOutputStream fileOutputStream = new FileOutputStream(file, append))
		{
			fileOutputStream.write(msg.getBytes());
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static Object readSerializedObject(String filePath)
	{
		log.debug("filePath: {}", filePath);
		return readSerializedObject(new File(filePath));
	}

	/**
	 * @since v0.0.1
	 */
	public static Object readSerializedObject(File file)
	{
		log.debug("file: {}", file);
		try (FileInputStream fileInputStream = new FileInputStream(file);
			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
		{
			return objectInputStream.readObject();
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeSerializedObject(String filePath, Object object)
	{
		log.debug("filePath: {}, object: {}", filePath, object);
		writeSerializedObject(new File(filePath), object);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeSerializedObject(File file, Object object)
	{
		log.debug("file: {}, object: {}", file, object);
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
			 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
		{
			objectOutputStream.writeObject(object);
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static Object readXmlObject(String filePath)
	{
		log.debug("file: {}", filePath);
		return readXmlObject(new File(filePath));
	}

	/**
	 * @since v0.0.1
	 */
	public static Object readXmlObject(File file)
	{
		log.debug("file: {}", file);
		try (FileInputStream fileInputStream = new FileInputStream(file);
			 XMLDecoder xMLDecoder = new XMLDecoder(fileInputStream))
		{
			return xMLDecoder.readObject();
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeXmlObject(String filePath, Object object)
	{
		log.debug("filePath: {}, object: {}", filePath, object);
		writeXmlObject(new File(filePath), object);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeXmlObject(File file, Object object)
	{
		log.debug("file: {}, object: {}", file, object);
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
			 XMLEncoder xMLEncoder = new XMLEncoder(fileOutputStream))
		{
			xMLEncoder.writeObject(object);
		} catch (Exception ex)
		{
			log.error("Exception", ex);
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T readJsonObject(Class<T> outputClass, String file)
	{
		return readJsonObject(outputClass, new File(file));
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T readJsonObject(Class<T> outputClass, File file)
	{
		log.debug("outputClass: {}, file: {}, object", outputClass, file);
		String fileData = readFile(file);
		return JsonUtils.getGson().fromJson(fileData, outputClass);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeJsonObject(String file, Object object)
	{
		writeJsonObject(new File(file), object);
	}

	/**
	 * @since v0.0.1
	 */
	public static void writeJsonObject(File file, Object object)
	{
		log.debug("file: {}, object: {}", file, object);
		String jsonString = JsonUtils.getGson().toJson(object);
		writeFile(file, jsonString, false);
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile() throws FileAlreadyExistsException
	{
		return createTempFile(StringUtils.getUUID());
	}

	/**
	 * @since v0.0.1
	 */
	public static File createTempFile(String tempFileName) throws FileAlreadyExistsException
	{
		log.debug("tempFileName: {}", tempFileName);
		File file = new File(SystemUtils.getTempDirectory(), tempFileName);
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
