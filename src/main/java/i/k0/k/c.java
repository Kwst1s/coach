package i.k0.k;

import i.c0;
import i.k0.e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* access modifiers changed from: package-private */
/* compiled from: Jdk8WithJettyBootPlatform */
public class c extends e {

    /* renamed from: c  reason: collision with root package name */
    private final Method f10559c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f10560d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f10561e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f10562f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f10563g;

    /* compiled from: Jdk8WithJettyBootPlatform */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f10564a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10565b;

        /* renamed from: c  reason: collision with root package name */
        String f10566c;

        a(List<String> list) {
            this.f10564a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = e.f10446b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f10565b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f10564a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = (String) list.get(i2);
                        if (this.f10564a.contains(str)) {
                            this.f10566c = str;
                            return str;
                        }
                    }
                    String str2 = this.f10564a.get(0);
                    this.f10566c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f10566c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f10559c = method;
        this.f10560d = method2;
        this.f10561e = method3;
        this.f10562f = cls;
        this.f10563g = cls2;
    }

    public static e s() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider", true, null);
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider", true, null);
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider", true, null);
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // i.k0.k.e
    public void a(SSLSocket sSLSocket) {
        try {
            this.f10561e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // i.k0.k.e
    public void g(SSLSocket sSLSocket, String str, List<c0> list) {
        List<String> b2 = e.b(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f10562f, this.f10563g}, new a(b2));
            this.f10559c.invoke(null, sSLSocket, newProxyInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // i.k0.k.e
    @Nullable
    public String m(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f10560d.invoke(null, sSLSocket));
            boolean z = aVar.f10565b;
            if (!z && aVar.f10566c == null) {
                e.j().q(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            } else if (z) {
                return null;
            } else {
                return aVar.f10566c;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
