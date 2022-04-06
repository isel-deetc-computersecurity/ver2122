import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;

public class X509CertificateDemo {
    public static void main(String[] args) throws CertificateException, IOException {
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(".cer filename");
        Certificate cert = factory.generateCertificate(fis);
        PublicKey publicKey = cert.getPublicKey();
        //... use public key
        System.out.println(cert);
    }
}
