package i.k0.k;

import com.github.mikephil.charting.BuildConfig;
import i.c0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* access modifiers changed from: package-private */
/* compiled from: Jdk9Platform */
public final class d extends e {

    /* renamed from: c  reason: collision with root package name */
    final Method f10567c;

    /* renamed from: d  reason: collision with root package name */
    final Method f10568d;

    d(Method method, Method method2) {
        this.f10567c = method;
        this.f10568d = method2;
    }

    public static d s() {
        try {
            return new d(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // i.k0.k.e
    public void g(SSLSocket sSLSocket, String str, List<c0> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> b2 = e.b(list);
            this.f10567c.invoke(sSLParameters, b2.toArray(new String[b2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to set SSL parameters", e2);
        }
    }

    @Override // i.k0.k.e
    @Nullable
    public String m(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f10568d.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals(BuildConfig.FLAVOR)) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
