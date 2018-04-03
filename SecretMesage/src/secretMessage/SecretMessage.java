/*********************************************************
 * This class is serializable and also encodes/decodes strings
 * Bill Nicholson
 * nicholdw@ucmail.u.edu
 */
package secretMessage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SecretMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public static String encode(String string) {
		StringBuilder result = new StringBuilder();
		String space = "";
		for (int i = 0; i < string.length(); i++){
			result.append(space);
		    char c = string.charAt(i);        
		    result.append((char)(c+i+1));
		    space = " ";
		}
		return result.toString();
	}
	public static String decode(String string) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < string.length(); i++){
			if (string.substring(i, i+1).equals(" ")) {continue;}

		    char c = string.charAt(i);        
		    result.append((char)(c-(i/2+1)));
		}
		return result.toString();
	}
	/***
	 * Write a SecretMessage object to a file
	 * @param secretMessage The SecretMessage object
	 * @param fileName The target file
	 * @return True on success, false otherwise
	 */
	public static boolean writeSecretMessage(SecretMessage secretMessage, String fileName) {
		boolean status = true;
		ObjectOutputStream oStream = null;
		try {
			// Needs to be wrapped in try/catch
			oStream = new ObjectOutputStream(new FileOutputStream(fileName));
			oStream.writeObject(secretMessage);		// Writes to the root directory of the Eclipse project			
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		} finally {
			try {oStream.close();} catch (Exception ex) {} // Eat the exception. Is this a good idea?
		}
		return status;
	}

}
