package com.example.Method;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_512Change {
	public String Change(String input) throws NoSuchAlgorithmException{
		    StringBuffer sb = new StringBuffer();
		    MessageDigest md = MessageDigest.getInstance("SHA-512");
		    md.update(input.getBytes());
		    byte[] msgb = md.digest();
		    for (int i = 0; i < msgb.length; i++) {
		       byte temp = msgb[i];
		       String str = Integer.toHexString(temp & 0xFF);
		       while (str.length() < 2) {
		          str = "0" + str;
		       }
		       str = str.substring(str.length() - 2);
		       sb.append(str);
		      }
		return sb.toString();
	}
}
