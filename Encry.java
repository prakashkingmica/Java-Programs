
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

// EXCEPTIONS
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;

public class Encry {

    private static final String ALGO = "DES";
    //private static final byte[] keyValue = new byte[] { (byte)0xC3, (byte)0xA6, (byte)0xCA, (byte)0x2D, (byte)0xF5, (byte)0x45, (byte)0xEB, (byte)0x03 };
   // private static final byte[] keyValue = new byte[] { (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32, (byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03 };
    private static final byte[] keyValue = new byte[] { (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32, (byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03 };
    //private static final byte[] keyValue = new byte[] { (byte)0xC3, (byte)0xA6, (byte)0xCA, (byte)0x6D, (byte)0xF5, (byte)0x45, (byte)0xEB, (byte)0xA3 };

	static Key key = null;
	static Cipher en = null;
	static Cipher de = null;

	public Encry(){
		try{
			key = generateKey();
			en = Cipher.getInstance(ALGO);
			de = Cipher.getInstance(ALGO);
			en.init(Cipher.ENCRYPT_MODE, key);
			de.init(Cipher.DECRYPT_MODE, key);
		} catch (NoSuchPaddingException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (InvalidKeyException e) {
		} catch (Exception e) {
		}
	}

	public static String encrypt(String Data) throws Exception{
		try{
			String Da = Data+"#"+new Date();
			//String Da = Data+"#"+DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(new Date()).replaceAll(" ", "");
			byte[] encVal = en.doFinal(Da.getBytes());
			String encryptedValue = new BASE64Encoder().encode(encVal);
			System.out.println("**************************************");
			System.out.println("JetAAA file");
			System.out.println("Input is "+Data);
			System.out.println("Input to encrypt is "+Da);
			System.out.println("Encrypted value is "+encryptedValue);
			System.out.println("Encrypted Value length is "+encryptedValue.length());
			encryptedValue = encryptedValue.replaceAll("=","king");
			encryptedValue = encryptedValue.replaceAll("\\+","plus");
			encryptedValue = encryptedValue.replaceAll("\"","quote");
			System.out.println("Encrypted value Again is "+encryptedValue);
			System.out.println("Encrypted value length Again is "+encryptedValue.length());
			System.out.println("**************************************");
			return encryptedValue;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
    }

    public static String decrypt(String encryptedData) throws Exception{
		try{
			System.out.println("**************************************");
			System.out.println("JetAAA file");
			System.out.println("Input to decrypt is "+encryptedData);
			System.out.println("Input to decrypt length is "+encryptedData.length());
			encryptedData = encryptedData.replaceAll("quote","\"");
			encryptedData = encryptedData.replaceAll("plus","\\+");
			encryptedData = encryptedData.replaceAll("king","=");
			System.out.println("Input to decrypt Again is "+encryptedData);
			System.out.println("Input to decrypt length Again is "+encryptedData.length());
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			byte[] decValue = de.doFinal(decordedValue);
			String decryptedValue = new String(decValue).split("#")[0];
			System.out.println("Decrypted Value is "+new String(decValue));
			System.out.println("Output Value is "+decryptedValue);
			System.out.println("**************************************");
			return decryptedValue;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
    }
    private static Key generateKey() throws Exception {
		try{
        	Key key = new SecretKeySpec(keyValue, ALGO);
			return key;
		}catch(Exception e){
			return null;
		}
	}
	public String testUsingPassPhrase(String secretString,int num) throws Exception{
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("number is "+num);
		try{
			if(num==1){
				return encrypt(secretString);
			}else if(num==2){
				return decrypt(secretString);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			return null;
	}

}