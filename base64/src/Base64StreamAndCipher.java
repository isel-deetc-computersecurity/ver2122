import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Base64StreamAndCipher {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        SecretKey key = gen.generateKey();

        // init cipher to encrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] iv = cipher.getIV();
        // encrypt
        byte[] rawBytes = cipher.doFinal("hello world".getBytes());
        // save in Base64
        FileOutputStream baseOut = new FileOutputStream("test_file.cif");
        Base64OutputStream out = new Base64OutputStream(baseOut);
        // write some extra info (just to show it is possible)
        out.write(new byte[]{'e','x','t','r','a'});
        out.write(rawBytes);
        out.close();

        //...

        // read and decode Base64 bytes
        FileInputStream baseIn = new FileInputStream("test_file.cif");
        Base64InputStream in = new Base64InputStream(baseIn);
        int value;
        rawBytes = in.readAllBytes();
        in.close();
        // init cipher to decrypt, and decrypt skipping the first 5 bytes
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] msgBytes = cipher.doFinal(rawBytes, 5, rawBytes.length-5);
        String msg = new String(msgBytes);
        System.out.println(msg);
    }
}