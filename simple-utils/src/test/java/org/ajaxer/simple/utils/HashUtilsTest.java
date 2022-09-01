package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Shakir
 * @version 2022-09-01
 * @since v0.0.1
 */
@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HashUtilsTest
{
	private File testFile;
	private final String message = "ajaxer";
	private final String key = "org";

	@BeforeAll
	void beforeEach() throws IOException
	{
		testFile = new File(FileUtilsTest.class.getClassLoader().getResource("file-utils-test-data.txt").getFile());
	}

	@Nested
	class Hash
	{
		@Test
		void when_msg_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash((String) null, HashUtils.MD5));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash("", HashUtils.MD5));
		}

		@Test
		void when_hash_type_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(message, (String) null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(message, (String) null));
		}

		@Test
		void with_md5_hash()
		{
			// https://emn178.github.io/online-tools/md5.html
			String actual = "8c5a756d2579468dfd023e5fc3eb4acf";
			String result1 = HashUtils.getHash(message, HashUtils.MD5);
			String result2 = HashUtils.getMD5Hash(message);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertEquals(32, result1.length());
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void with_sha1_hash()
		{
			// https://emn178.github.io/online-tools/sha1.html
			String actual = "4f4b91d02dcbaeaa96ecb30241a9acccd1912ef9";

			String result1 = HashUtils.getHash(message, HashUtils.SHA_1);
			String result2 = HashUtils.getSHA1Hash(message);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertEquals(40, result1.length());
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void with_sha224_hash()
		{
			// https://emn178.github.io/online-tools/sha224.html
			String actual = "685957b0d887dfd0133e3f94f468779893b8fea1da7134965d342601";

			String result1 = HashUtils.getHash(message, HashUtils.SHA_224);
			String result2 = HashUtils.getSHA224Hash(message);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertEquals(56, result1.length());
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void with_sha256_hash()
		{
			// https://emn178.github.io/online-tools/sha256.html
			String actual = "26cecd442e283d4afe779c257713381c4d571c46c67fd9b471cb16e75a4106ed";

			String result1 = HashUtils.getHash(message, HashUtils.SHA_256);
			String result2 = HashUtils.getSHA256Hash(message);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(64, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void with_sha384_hash()
		{
			// https://emn178.github.io/online-tools/sha384.html
			String actual = "f83bf4d997f55cd9171255fc149acfcd57a3401cecff651512d5dfcb51a2d188540465fb98330c4dfb794b0400b2c71d";

			String result1 = HashUtils.getHash(message, HashUtils.SHA_384);
			String result2 = HashUtils.getSHA384Hash(message);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(96, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void with_sha512_hash()
		{
			// https://emn178.github.io/online-tools/sha512.html
			String actual = "7b2a8536c03bba2bdfb36b56fc7fc8eba09215460920e7e1c4b1bf856a9c4103ae496228aee1292c74d982c6d87e51228514be6278c17d2cfd9facd620e528f7";

			String result1 = HashUtils.getHash(message, HashUtils.SHA_512);
			String result2 = HashUtils.getSHA512Hash(message);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(128, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}
	}

	@Nested
	class HashWithKey
	{
		@Test
		void when_msg_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(null, key, HashUtils.HMAC_SHA1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash("", key, HashUtils.HMAC_SHA1));
		}

		@Test
		void when_key_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(message, null, HashUtils.HMAC_SHA1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(message, "", HashUtils.HMAC_SHA1));
		}

		@Test
		void when_hash_type_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(message, key, null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(message, key, ""));
			Assertions.assertThrows(NoSuchAlgorithmException.class, () -> HashUtils.getHash(message, key, "UNKNOWN-HASH-TYPE"));
		}

		@Test
		void with_sha1_hash()
		{
			String result1 = HashUtils.getHash(message, key, HashUtils.HMAC_SHA1);
			String result2 = HashUtils.getSHA1Hash(message, key);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(40, result1.length());
			Assertions.assertTrue(result2.equals(result1));
		}

		@Test
		void with_sha224_hash()
		{
			String result1 = HashUtils.getHash(message, key, HashUtils.HMAC_SHA224);
			String result2 = HashUtils.getSHA224Hash(message, key);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(56, result1.length());
			Assertions.assertTrue(result2.equals(result1));
		}

		@Test
		void with_sha256_hash()
		{
			String result1 = HashUtils.getHash(message, key, HashUtils.HMAC_SHA256);
			String result2 = HashUtils.getSHA256Hash(message, key);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(64, result1.length());
			Assertions.assertTrue(result2.equals(result1));
		}

		@Test
		void with_sha384_hash()
		{
			String result1 = HashUtils.getHash(message, key, HashUtils.HMAC_SHA384);
			String result2 = HashUtils.getSHA384Hash(message, key);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(96, result1.length());
			Assertions.assertTrue(result2.equals(result1));
		}

		@Test
		void with_sha512_hash()
		{
			String result1 = HashUtils.getHash(message, key, HashUtils.HMAC_SHA512);
			String result2 = HashUtils.getSHA512Hash(message, key);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(128, result1.length());
			Assertions.assertTrue(result2.equals(result1));
		}
	}

	@Nested
	class HashWithFile
	{
		@Test
		void when_file_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash((File) null, HashUtils.MD5));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash((File) null, HashUtils.MD5));
		}

		@Test
		void when_hash_type_is_blank()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(testFile, null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> HashUtils.getHash(testFile, ""));
			Assertions.assertThrows(NoSuchAlgorithmException.class, () -> HashUtils.getHash(testFile, "UNKNOWN-HASH-TYPE"));
		}

		@Test
		void md5_hash()
		{
			// https://emn178.github.io/online-tools/md5_checksum.html
			String actual = "6ded54177f49ffafbd76978bd886d8f2";

			String result1 = HashUtils.getHash(testFile, HashUtils.MD5);
			String result2 = HashUtils.getMD5Hash(testFile);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(32, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void sha1_hash()
		{
			// https://emn178.github.io/online-tools/sha1_checksum.html
			String actual = "42ea874c16fc44bee88ff7080dd942ea1b47361f";

			String result1 = HashUtils.getHash(testFile, HashUtils.SHA_1);
			String result2 = HashUtils.getSHA1Hash(testFile);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(40, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void sha224_hash()
		{
			// https://emn178.github.io/online-tools/sha224_checksum.html
			String actual = "b7100b411d610213943234996e520446fc95b3042ec9db264b4726b3";

			String result1 = HashUtils.getHash(testFile, HashUtils.SHA_224);
			String result2 = HashUtils.getSHA224Hash(testFile);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(56, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void sha256_hash()
		{
			// https://emn178.github.io/online-tools/sha256_checksum.html
			String actual = "5eefdde652792ec3048823cbd2aed0351d9b27444e26124f0ab1d8c877807672";

			String result1 = HashUtils.getHash(testFile, HashUtils.SHA_256);
			String result2 = HashUtils.getSHA256Hash(testFile);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(64, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void sha384_hash()
		{
			// https://emn178.github.io/online-tools/sha384_file_hash.html
			String actual = "29247626231446561f565fd1ebf3337190f12ca23efa7654821a50564744c5a275e6b6e63f56e8683b418f9df8bdd798";

			String result1 = HashUtils.getHash(testFile, HashUtils.SHA_384);
			String result2 = HashUtils.getSHA384Hash(testFile);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(96, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}

		@Test
		void sha512_hash()
		{
			// https://emn178.github.io/online-tools/sha256_checksum.html
			String actual = "a9e28cc7235c191c3b5da0ac64bac0e83c44f0fe5b65350ac071dadc2486fcc93fc4d0a1e9408d28e012baf2dededa0631f6475f4c98b985184c3ac9fef71d19";

			String result1 = HashUtils.getHash(testFile, HashUtils.SHA_512);
			String result2 = HashUtils.getSHA512Hash(testFile);
			log.info("result1: {}", result1);
			log.info("result2: {}", result2);

			Assertions.assertNotNull(result1);
			Assertions.assertNotNull(result2);
			Assertions.assertEquals(128, result1.length());
			Assertions.assertTrue(result2.equals(result1));
			Assertions.assertTrue(result1.equals(actual));
		}
	}
}