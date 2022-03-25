import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.Arrays;

public class DemoKeys {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // symmetric key generator
        KeyGenerator secretKeyGen = KeyGenerator.getInstance("AES");
        SecretKey secretKey = secretKeyGen.generateKey();
        byte[] rawKey = secretKey.getEncoded();
        System.out.println(Arrays.toString(rawKey));

        // asymmetric key generator
        KeyPairGenerator pairGen = KeyPairGenerator.getInstance("RSA");
        KeyPair pair = pairGen.generateKeyPair();

        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        System.out.println("Public key: " + publicKey);
        System.out.println("Private key: " + privateKey);


    }
}
