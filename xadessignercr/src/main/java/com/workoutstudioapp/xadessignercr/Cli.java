package com.workoutstudioapp.xadessignercr;

public class Cli {
	public static void main(String[] args) {
		
		String action = null;
		// sign
		String keyPath = null;
		String keyPassword = null;
		String xmlInPath = null;
		String xmlOutPath = null;
		// send
		String endPoint = null;
		String xmlPath = null;
		String username = null;
		String password = null;
		
		if (args.length != 5) {
			showUsage();
			System.exit(-1);
		}
		action = args[0];
		if ("sign_factura".equals(action)) {
			keyPath = args[1];
			keyPassword = args[2];
			xmlInPath = args[3];
			xmlOutPath = args[4];
			Signer signer = new Signer();
			signer.sign(keyPath, keyPassword, xmlInPath, xmlOutPath);
			System.exit(0);
		} else if ("send_factura".equals(action)) {
			endPoint = args[1];
			xmlPath = args[2];
			username = args[3];
			password = args[4];
			Sender sender = new Sender();
			sender.send(endPoint, xmlPath, username, password);
			System.exit(0);
		} else if ("sign_nota_credito".equals(action)) {
			keyPath = args[1];
			keyPassword = args[2];
			xmlInPath = args[3];
			xmlOutPath = args[4];
			Signer signer = new Signer();
			signer.sign_nota_credito(keyPath, keyPassword, xmlInPath, xmlOutPath);
			System.exit(0);
		} else if ("send_nota_credito".equals(action)) {
			endPoint = args[1];
			xmlPath = args[2];
			username = args[3];
			password = args[4];
			Sender sender = new Sender();
			sender.send_nota_credito(endPoint, xmlPath, username, password);
			System.exit(0);
		}else if ("sign_nota_debito".equals(action)) {
			keyPath = args[1];
			keyPassword = args[2];
			xmlInPath = args[3];
			xmlOutPath = args[4];
			Signer signer = new Signer();
			signer.sign_nota_debito(keyPath, keyPassword, xmlInPath, xmlOutPath);
			System.exit(0);
		} else if ("send_nota_debito".equals(action)) {
			endPoint = args[1];
			xmlPath = args[2];
			username = args[3];
			password = args[4];
			Sender sender = new Sender();
			sender.send_nota_debito(endPoint, xmlPath, username, password);
			System.exit(0);
		}else if ("sign_tiquete".equals(action)) {
			keyPath = args[1];
			keyPassword = args[2];
			xmlInPath = args[3];
			xmlOutPath = args[4];
			Signer signer = new Signer();
			signer.sign_tiquete(keyPath, keyPassword, xmlInPath, xmlOutPath);
			System.exit(0);
		} else if ("send_tiquete".equals(action)) {
			endPoint = args[1];
			xmlPath = args[2];
			username = args[3];
			password = args[4];
			Sender sender = new Sender();
			sender.send_tiquete(endPoint, xmlPath, username, password);
			System.exit(0);
		}else if ("query".equals(action)) {
			endPoint = args[1];
			xmlPath = args[2];
			username = args[3];
			password = args[4];
			Sender sender = new Sender();
			sender.query(endPoint, xmlPath, username, password);
			System.exit(0);
		} else {
			showUsage();
			System.exit(-1);
		}
	}
	public static void showUsage() {
		System.out.println("Usage:");
		System.out.println("java -jar xades-signer-cr sign_factura <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>");
		System.out.println("java -jar xades-signer-cr send_factura <endPoint> <xmlPath> <username> <password>");
		System.out.println("java -jar xades-signer-cr sign_nota_debito <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>");
		System.out.println("java -jar xades-signer-cr send_nota_debito <endPoint> <xmlPath> <username> <password>");
		System.out.println("java -jar xades-signer-cr sign_nota_credito <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>");
		System.out.println("java -jar xades-signer-cr send_nota_credito <endPoint> <xmlPath> <username> <password>");
		System.out.println("java -jar xades-signer-cr sign_tiquete <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>");
		System.out.println("java -jar xades-signer-cr send_tiquete <endPoint> <xmlPath> <username> <password>");
		System.out.println("java -jar xades-signer-cr query <endPoint> <xmlPath> <username> <password>");
	}
}
