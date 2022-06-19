package i.k0.k;

import i.b0;
import i.c0;
import i.k0.m.a;
import i.k0.m.b;
import j.c;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f10569a = i();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f10570b = Logger.getLogger(b0.class.getName());

    public static List<String> b(List<c0> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            c0 c0Var = list.get(i2);
            if (c0Var != c0.HTTP_1_0) {
                arrayList.add(c0Var.toString());
            }
        }
        return arrayList;
    }

    static byte[] e(List<c0> list) {
        c cVar = new c();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            c0 c0Var = list.get(i2);
            if (c0Var != c0.HTTP_1_0) {
                cVar.a0(c0Var.toString().length());
                cVar.g0(c0Var.toString());
            }
        }
        return cVar.k();
    }

    private static e i() {
        b s;
        e u = a.u();
        if (u != null) {
            return u;
        }
        if (p() && (s = b.s()) != null) {
            return s;
        }
        d s2 = d.s();
        if (s2 != null) {
            return s2;
        }
        e s3 = c.s();
        if (s3 != null) {
            return s3;
        }
        return new e();
    }

    public static e j() {
        return f10569a;
    }

    public static boolean p() {
        if ("conscrypt".equals(i.k0.e.o("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(SSLSocket sSLSocket) {
    }

    public i.k0.m.c c(X509TrustManager x509TrustManager) {
        return new a(d(x509TrustManager));
    }

    public i.k0.m.e d(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, @Nullable String str, List<c0> list) {
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i2) {
        socket.connect(inetSocketAddress, i2);
    }

    public String k() {
        return "OkHttp";
    }

    public SSLContext l() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    @Nullable
    public String m(SSLSocket sSLSocket) {
        return null;
    }

    @Nullable
    public Object n(String str) {
        if (f10570b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean o(String str) {
        return true;
    }

    public void q(int i2, String str, @Nullable Throwable th) {
        f10570b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void r(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        q(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
