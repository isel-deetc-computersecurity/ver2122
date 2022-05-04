import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class SSLDemo {
    public static void main(String[] args) throws IOException {
        SSLSocketFactory sslFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        SSLSocket client = (SSLSocket)
            sslFactory.createSocket("docs.oracle.com", 443);
        client.startHandshake();
        SSLSession session = client.getSession();
        System.out.println("Cipher suite: " + session.getCipherSuite());
        System.out.println("Certificate: " + session.getPeerCertificates()[0]);
        client.close();
    }
}
