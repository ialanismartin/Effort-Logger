package application;

import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Encryption {
	
	//fields are private so that external classes cannot view or modify them, ensuring privacy
	private Cipher encryptCipher;
	private Cipher decryptCipher;
	private SecretKey key;
	
	/* This constructor takes an int argument keySize, whose value could be 128, 192, or 256, 
	 * and creates a key that has this specified key size. The constructor uses this key to initialize 
	 * the encryption and decryption ciphers. */
	public Encryption(int keySize) throws Exception{
		//generating a key of chosen size keySize
		this.key = generateKey(keySize);
		this.encryptCipher = Cipher.getInstance("AES/GCM/NoPadding");
		this.encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		
		this.decryptCipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec spec = new GCMParameterSpec(128, this.encryptCipher.getIV());
		this.decryptCipher.init(Cipher.DECRYPT_MODE, key, spec);
	}
	
	/* Takes an int representing the key size as a parameter and returns a key to use for encryption/decryption.
	 * The argument keySize could be 128, 192, or 256. If an invalid keySize is entered, this method will 
	 * throw an Invalid Parameter Exception.*/
	private SecretKey generateKey(int keySize) throws Exception{
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(keySize);
		SecretKey key = generator.generateKey();
		return key;
	}
	
	/* Takes a String message to encrypt and returns a String of encoded characters.*/
	public String encrypt(String message) throws Exception {
		byte[] encryptedMessage = this.encryptCipher.doFinal(message.getBytes()); //encrypts message in bytes
		return Base64.getEncoder().encodeToString(encryptedMessage); //converts message from a byte array to a String
	}

	/* Takes a String encoded message and returns a String of decoded characters. The decrypt method throws a 
	 * Bad Tag exception if the key that initializes the decryption cipher is different from the key that initializes the
	 * encryption cipher. */
	public String decrypt(String encryptedMessage) throws Exception{
		//converts a String into bytes and decrypts it
		byte[] decryptedMessage = this.decryptCipher.doFinal(Base64.getDecoder().decode(encryptedMessage)); 
		return new String(decryptedMessage);
	}
	
	
}
