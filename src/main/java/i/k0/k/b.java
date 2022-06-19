package i.k0.k;

import i.c0;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

/* compiled from: ConscryptPlatform */
public class b extends e {
    private b() {
    }

    public static b s() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new b();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider t() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // i.k0.k.e
    public void f(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // i.k0.k.e
    public void g(SSLSocket sSLSocket, String str, List<c0> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) e.b(list).toArray(new String[0]));
            return;
        }
        super.g(sSLSocket, str, list);
    }

    @Override // i.k0.k.e
    public SSLContext l() {
        try {
            return SSLContext.getInstance("TLSv1.3", t());
        } catch (NoSuchAlgorithmException e2) {
            try {
                return SSLContext.getInstance("TLS", t());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e2);
            }
        }
    }

    @Override // i.k0.k.e
    @Nullable
    public String m(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.m(sSLSocket);
    }
}
