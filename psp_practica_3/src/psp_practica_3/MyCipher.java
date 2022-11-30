package psp_practica_3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class MyCipher {
	
	private Cipher encoder;
	private SecretKey secretkey;
	public MyCipher(String method) {
		this.generateCipher(method);
	}
	
	private void generateCipher(String method) {
		try {
			KeyGenerator kgenerator = KeyGenerator.getInstance(method);
			this.secretkey = kgenerator.generateKey();
			this.encoder = Cipher.getInstance(method);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
		
	public byte[] encode(String str) {
		try {
			this.encoder.init(Cipher.ENCRYPT_MODE, secretkey);
			return this.encoder.doFinal(str.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String decode(byte[] input) {
		try {
			this.encoder.init(Cipher.DECRYPT_MODE, secretkey);
			return new String(this.encoder.doFinal(input));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static MyCipher getCipher() {
		return new MyCipher("DES");
	}
}
