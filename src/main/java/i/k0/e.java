package i.k0;

import i.f0;
import i.h0;
import i.x;
import i.y;
import j.c;
import j.f;
import j.m;
import j.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.http2.b;

/* compiled from: Util */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f10445a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f10446b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final x f10447c = x.g(new String[0]);

    /* renamed from: d  reason: collision with root package name */
    public static final h0 f10448d;

    /* renamed from: e  reason: collision with root package name */
    public static final TimeZone f10449e = TimeZone.getTimeZone("GMT");

    /* renamed from: f  reason: collision with root package name */
    public static final Comparator<String> f10450f = a.f10440b;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f10451g;

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f10452h = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        f10445a = bArr;
        Method method = null;
        f10448d = h0.F(null, bArr);
        f0.c(null, bArr);
        m.d(f.f("efbbbf"), f.f("feff"), f.f("fffe"), f.f("0000ffff"), f.f("ffff0000"));
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f10451g = method;
    }

    public static X509TrustManager A() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public static boolean B(y yVar, y yVar2) {
        return yVar.l().equals(yVar2.l()) && yVar.w() == yVar2.w() && yVar.B().equals(yVar2.B());
    }

    public static boolean C(t tVar, int i2, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c2 = tVar.c().e() ? tVar.c().c() - nanoTime : Long.MAX_VALUE;
        tVar.c().d(Math.min(c2, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            c cVar = new c();
            while (tVar.v(cVar, 8192) != -1) {
                cVar.E();
            }
            if (c2 == Long.MAX_VALUE) {
                tVar.c().a();
            } else {
                tVar.c().d(nanoTime + c2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c2 == Long.MAX_VALUE) {
                tVar.c().a();
            } else {
                tVar.c().d(nanoTime + c2);
            }
            return false;
        } catch (Throwable th) {
            if (c2 == Long.MAX_VALUE) {
                tVar.c().a();
            } else {
                tVar.c().d(nanoTime + c2);
            }
            throw th;
        }
    }

    public static int D(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int E(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (!(charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ')) {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static ThreadFactory F(String str, boolean z) {
        return new b(str, z);
    }

    public static List<b> G(x xVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < xVar.h(); i2++) {
            arrayList.add(new b(xVar.e(i2), xVar.i(i2)));
        }
        return arrayList;
    }

    public static x H(List<b> list) {
        x.a aVar = new x.a();
        for (b bVar : list) {
            c.f10443a.b(aVar, bVar.f10887a.w(), bVar.f10888b.w());
        }
        return aVar.d();
    }

    public static String I(String str, int i2, int i3) {
        int D = D(str, i2, i3);
        return str.substring(D, E(str, D, i3));
    }

    public static boolean J(String str) {
        return f10452h.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = f10451g;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static String b(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = j(str, 0, str.length());
            } else {
                inetAddress = j(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return v(address);
            }
            if (address.length == 4) {
                return inetAddress.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !g(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void c(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void e(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!x(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] f(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    private static boolean g(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int h(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    private static boolean i(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        if (i5 != i4 + 4) {
            return false;
        }
        return true;
    }

    @Nullable
    private static InetAddress j(String str, int i2, int i3) {
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= i3) {
                break;
            } else if (i4 == 16) {
                return null;
            } else {
                int i7 = i2 + 2;
                if (i7 > i3 || !str.regionMatches(i2, "::", 0, 2)) {
                    if (i4 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !i(str, i6, i3, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i2;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i4 += 2;
                    i5 = i4;
                    if (i7 == i3) {
                        break;
                    }
                    i6 = i7;
                }
                i2 = i6;
                int i8 = 0;
                while (i2 < i3) {
                    int h2 = h(str.charAt(i2));
                    if (h2 == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + h2;
                    i2++;
                }
                int i9 = i2 - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((i8 >>> 8) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        if (i4 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i11 = i4 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int k(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int l(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean m(t tVar, int i2, TimeUnit timeUnit) {
        try {
            return C(tVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static String n(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String o(String str, @Nullable String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
            return str2;
        }
    }

    public static String p(y yVar, boolean z) {
        String str;
        if (yVar.l().contains(":")) {
            str = "[" + yVar.l() + "]";
        } else {
            str = yVar.l();
        }
        if (!z && yVar.w() == y.d(yVar.B())) {
            return str;
        }
        return str + ":" + yVar.w();
    }

    public static <T> List<T> q(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    @SafeVarargs
    public static <T> List<T> r(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> s(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int t(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static int u(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    private static String v(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        c cVar = new c();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                cVar.a0(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.a0(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.a0(58);
                }
                cVar.c0((long) (((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)));
                i2 += 2;
            }
        }
        return cVar.P();
    }

    public static String[] w(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean x(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    static /* synthetic */ Thread y(String str, boolean z, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static boolean z(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
