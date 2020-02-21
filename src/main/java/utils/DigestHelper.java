package utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/1/20
 *
 * 常用算法：MD2、MD5、SHA、SHA-1、SHA-256、SHA-384、SHA-512
 */
public class DigestHelper {
	public static final String MD2 = "MD2";
	public static final String MD5 = "MD5";
	public static final String SHA1 = "SHA-1";
	public static final String SHA256 = "SHA-256";
	public static final String SHA384 = "SHA-384";
	public static final String SHA512 = "SHA-512";
	

	 /* 将字节数组换成16进制的字符串*/
	public static String byteArrayToHex(byte[] byteArray) {
		StringBuilder sb = new StringBuilder();
		for (int n=0; n < byteArray.length; n++) {
			int v = byteArray[n];
			if (v < 0)v += 256;
			if (v < 16) sb.append(0);
			sb.append(Integer.toHexString(v));
		}
		return sb.toString();
	}

	public static String digest(int bufferSize,InputStream input,String algorithm) throws IOException{
		try {
			// 获取转换器实例
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			// read的过程中进行MD5处理，直到读完文件
			byte[] buffer = new byte[bufferSize];
			for(int len;(len = input.read(buffer)) != -1;) {
				messageDigest.update(buffer, 0, len);
	        }
			// 拿到结果，也是字节数组，包含16个元素
			byte[] resultByteArray = messageDigest.digest();
			// 把字节数组转换成字符串
			return byteArrayToHex(resultByteArray);
		} catch (NoSuchAlgorithmException e) {
			return null;
		} finally {
			try {input.close();} catch (Exception e) {}
		}
	}

	public static String digest(InputStream input,String algorithm) throws IOException{
		return digest(1024*512, input, algorithm);
	}

	public static String digest(byte[] bytes,String algorithm) throws IOException{
		return digest(new ByteArrayInputStream(bytes), algorithm);
	}

	public static String digest(String text,String algorithm) throws IOException{
		return digest(text.getBytes(), algorithm);
	}

	public static String digest(File file,String algorithm) throws IOException{
		return digest(new FileInputStream(file), algorithm);
	}

	public static String md5(String text){
		try {
			return DigestHelper.digest(text, DigestHelper.MD5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String sha1(String text){
		try {
			return DigestHelper.digest(text, DigestHelper.SHA1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String sha512(String text){
		try {
			return DigestHelper.digest(text, DigestHelper.SHA512);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
