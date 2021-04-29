package revisao;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptacao {
	public static String encryption(String senha) {
		String sha1 = null;
		byte[] result = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(senha.getBytes("UTF-8"));

			result = crypt.digest();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StringBuilder senhaHex = new StringBuilder();
		
		for (byte b : result) {
	           senhaHex.append(String.format("%02X", 0xFF & b));
	    }
		
		sha1 = senhaHex.toString();
		return sha1;

	}
}
