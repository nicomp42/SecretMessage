package main;

import secretMessage.SecretMessage;

public class Main {

	public static void main(String[] args) {
		String test = SecretMessage.encode("Secret Message Here");
		//System.out.println(test);
		//System.out.println(SecretMessage.decode(test));
		
		SecretMessage s = new SecretMessage();
		s.setMessage(test);

		SecretMessage.writeSecretMessage(s, "SecretMessage.dat");
		
		SecretMessage s1 = SecretMessage.readSecretMessage("SecretMessage.dat");
		System.out.println(SecretMessage.decode(s1.getMessage()));
	}
}
