import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

class Check {
/*
    private static final String ALGO = "DES";
    private static final byte[] keyValue = new byte[] { (byte)0xC2, (byte)0xA6, (byte)0xCA, (byte)0x2D, (byte)0xF5, (byte)0x45, (byte)0xEB, (byte)0x03 };

public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        String Da = Data+"#"+new Date();
        byte[] encVal = c.doFinal(Da.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
		System.out.println("**************************************");
		System.out.println("Input is "+Data);
		System.out.println("Input to encrypt is "+Da);
		System.out.println("Encrypted value is "+encryptedValue);
		System.out.println("Input to encrypt length is "+Da.length());
		System.out.println("Encrypted value length is "+encryptedValue.length());
		System.out.println("**************************************");
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue).split("#")[0];
        System.out.println("**************************************");
		System.out.println("Input to Decrypt Value is "+encryptedData);
		System.out.println("Input to Decrypt Value length is "+encryptedData.length());
		System.out.println("Decrypted Value is "+new String(decValue));
		System.out.println("Decrypted Value is "+decryptedValue);
		System.out.println("**************************************");
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
	}
	*/

    private static final String ALGO = "DES";
    //private static final byte[] keyValue = new byte[] { (byte)0xC3, (byte)0xA6, (byte)0xCA, (byte)0x2D, (byte)0xF5, (byte)0x45, (byte)0xEB, (byte)0x03 };
    private static final byte[] keyValue = new byte[] { (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32, (byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03 };

	static Key key = null;
	static Cipher en = null;
	static Cipher de = null;

	static{
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
			byte[] encVal = en.doFinal(Da.getBytes());
			String encryptedValue = new BASE64Encoder().encode(encVal).replaceAll("=","king");
			//encryptedValue = encryptedValue.replaceAll(" ","");
			System.out.println("**************************************");
			System.out.println("Input is "+Data);
			System.out.println("Input to encrypt is "+Da);
			System.out.println("Encrypted value is "+encryptedValue);
			System.out.println("Input to encrypt length is "+Da.length());
			System.out.println("Encrypted value length is "+encryptedValue.length());
			return encryptedValue;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
    }

    public static String decrypt(String encryptedData) throws Exception{
		try{
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData.replaceAll("king","="));
			byte[] decValue = de.doFinal(decordedValue);
			String decryptedValue = new String(decValue).split("#")[0];
			System.out.println("Input to decrypt is "+encryptedData);
			System.out.println("Input to decrypt length is "+encryptedData.length());
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

}
public class StringEncription {

    public static String main(String[] args) throws Exception {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Password : ");
			String password = br.readLine();
			String passwordEnc = Check.encrypt(password);
			String passwordDec = Check.decrypt(passwordEnc);
			return passwordDec;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;		
    }
}
