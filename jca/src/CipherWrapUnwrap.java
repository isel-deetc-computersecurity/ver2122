import javax.crypto.*;
import java.security.*;
import java.util.*;

class Main {  
  public static void main(String[] args) throws Exception{
    KeyPairGenerator kp = KeyPairGenerator.getInstance("RSA");
    KeyPair pair = kp.generateKeyPair();
    KeyGenerator gen = KeyGenerator.getInstance("AES");
    SecretKey key = gen.generateKey();
    Cipher c = Cipher.getInstance("RSA");
    c.init(Cipher.WRAP_MODE, pair.getPublic());

    byte[] transmittedKey = c.wrap(key);
    
    c.init(Cipher.UNWRAP_MODE, pair.getPrivate());
    SecretKey key_copy = (SecretKey) c.unwrap(transmittedKey, "AES", Cipher.SECRET_KEY);
    System.out.println(Arrays.equals(key.getEncoded(), key_copy.getEncoded()));
  } 
}
