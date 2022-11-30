package psp_practica_3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashMaker {
	private MessageDigest md;
	
	public HashMaker(String algorithm) {
		try {
			this.initializeMessageDigest(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	private void initializeMessageDigest(String algorithm) throws NoSuchAlgorithmException {
		md = MessageDigest.getInstance(algorithm);
	}
	
	public String hash(String str) {
		byte[] b = str.getBytes();
		md.update(b);
		return Base64.getEncoder().encodeToString(md.digest());
	}
	
	public static String hashSHA512(String str) {
		HashMaker hm = new HashMaker("SHA-512");
		return hm.hash(str);
	}
	
	public static String hashSHA1(String str) {
		HashMaker hm = new HashMaker("SHA-1");
		return hm.hash(str);
	}
	
	public static String hashMD2(String str) {
		HashMaker hm = new HashMaker("MD-2");
		return hm.hash(str);
	}
	
}
