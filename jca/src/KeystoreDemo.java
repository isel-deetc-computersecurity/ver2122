import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class KeystoreDemo {
    public static void main(String[] args) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(
            new FileInputStream("C:\\work\\isel\\ensino\\SI\\ver2122\\aula07-09\\pfx\\Alice_1.pfx"),
            "changeit".toCharArray()
        );
        Enumeration<String> entries = ks.aliases();
        while(entries.hasMoreElements()) {
            String alias = entries.nextElement();
            System.out.println();
            System.out.println(ks.getKey(alias, "changeit".toCharArray()));
        }
    }
}
