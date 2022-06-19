package i.k0.k;

import android.os.Build;
import android.util.Log;
import i.c0;
import i.k0.m.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* access modifiers changed from: package-private */
/* compiled from: AndroidPlatform */
public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f10546c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f10547d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f10548e;

    /* renamed from: f  reason: collision with root package name */
    private final Method f10549f;

    /* renamed from: g  reason: collision with root package name */
    private final Method f10550g;

    /* renamed from: h  reason: collision with root package name */
    private final b f10551h = b.b();

    /* renamed from: i.k0.k.a$a  reason: collision with other inner class name */
    /* compiled from: AndroidPlatform */
    static final class C0237a extends i.k0.m.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f10552a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f10553b;

        C0237a(Object obj, Method method) {
            this.f10552a = obj;
            this.f10553b = method;
        }

        @Override // i.k0.m.c
        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f10553b.invoke(this.f10552a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0237a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Method f10554a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f10555b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f10556c;

        b(Method method, Method method2, Method method3) {
            this.f10554a = method;
            this.f10555b = method2;
            this.f10556c = method3;
        }

        static b b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new b(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public Object a(String str) {
            Method method = this.f10554a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f10555b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f10556c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: AndroidPlatform */
    static final class c implements e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f10557a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f10558b;

        c(X509TrustManager x509TrustManager, Method method) {
            this.f10558b = method;
            this.f10557a = x509TrustManager;
        }

        @Override // i.k0.m.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f10558b.invoke(this.f10557a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw new AssertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f10557a.equals(cVar.f10557a) || !this.f10558b.equals(cVar.f10558b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f10557a.hashCode() + (this.f10558b.hashCode() * 31);
        }
    }

    a(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        this.f10546c = cls2;
        this.f10547d = method;
        this.f10548e = method2;
        this.f10549f = method3;
        this.f10550g = method4;
    }

    private boolean s(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.o(str);
        }
    }

    private boolean t(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return s(str, cls, obj);
        }
    }

    @Nullable
    public static e u() {
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return new a(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE), cls2.getMethod("setHostname", String.class), cls2.getMethod("getAlpnSelectedProtocol", new Class[0]), cls2.getMethod("setAlpnProtocols", byte[].class));
                } catch (NoSuchMethodException unused) {
                }
            }
            throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // i.k0.k.e
    public i.k0.m.c c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0237a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // i.k0.k.e
    public e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // i.k0.k.e
    public void g(SSLSocket sSLSocket, String str, List<c0> list) {
        if (this.f10546c.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.f10547d.invoke(sSLSocket, Boolean.TRUE);
                    this.f10548e.invoke(sSLSocket, str);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    throw new AssertionError(e2);
                }
            }
            this.f10550g.invoke(sSLSocket, e.e(list));
        }
    }

    @Override // i.k0.k.e
    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i2) {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (i.k0.e.x(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e3);
            }
            throw e3;
        }
    }

    @Override // i.k0.k.e
    public SSLContext l() {
        boolean z = true;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16 || i2 >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    @Override // i.k0.k.e
    @Nullable
    public String m(SSLSocket sSLSocket) {
        if (!this.f10546c.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f10549f.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // i.k0.k.e
    @Nullable
    public Object n(String str) {
        return this.f10551h.a(str);
    }

    @Override // i.k0.k.e
    public boolean o(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return t(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.o(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            throw new AssertionError("unable to determine cleartext support", e2);
        }
    }

    @Override // i.k0.k.e
    public void q(int i2, String str, @Nullable Throwable th) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    @Override // i.k0.k.e
    public void r(String str, Object obj) {
        if (!this.f10551h.c(obj)) {
            q(5, str, null);
        }
    }
}
