package i.k0.m;

import i.k0.k.e;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* compiled from: CertificateChainCleaner */
public abstract class c {
    public static c b(X509TrustManager x509TrustManager) {
        return e.j().c(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str);
}
