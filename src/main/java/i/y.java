package i;

import com.github.mikephil.charting.BuildConfig;
import i.k0.e;
import j.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: HttpUrl */
public final class y {

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f10633i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f10634a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10635b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10636c;

    /* renamed from: d  reason: collision with root package name */
    final String f10637d;

    /* renamed from: e  reason: collision with root package name */
    final int f10638e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f10639f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f10640g;

    /* renamed from: h  reason: collision with root package name */
    private final String f10641h;

    /* compiled from: HttpUrl */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        String f10642a;

        /* renamed from: b  reason: collision with root package name */
        String f10643b = BuildConfig.FLAVOR;

        /* renamed from: c  reason: collision with root package name */
        String f10644c = BuildConfig.FLAVOR;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        String f10645d;

        /* renamed from: e  reason: collision with root package name */
        int f10646e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f10647f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        List<String> f10648g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        String f10649h;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f10647f = arrayList;
            arrayList.add(BuildConfig.FLAVOR);
        }

        @Nullable
        private static String b(String str, int i2, int i3) {
            return e.b(y.r(str, i2, i3, false));
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int i(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(y.a(str, i2, i3, BuildConfig.FLAVOR, false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private void k() {
            List<String> list = this.f10647f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f10647f.isEmpty()) {
                this.f10647f.add(BuildConfig.FLAVOR);
                return;
            }
            List<String> list2 = this.f10647f;
            list2.set(list2.size() - 1, BuildConfig.FLAVOR);
        }

        private static int m(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private void n(String str, int i2, int i3, boolean z, boolean z2) {
            String a2 = y.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!f(a2)) {
                if (g(a2)) {
                    k();
                    return;
                }
                List<String> list = this.f10647f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f10647f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f10647f.add(a2);
                }
                if (z) {
                    this.f10647f.add(BuildConfig.FLAVOR);
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void p(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f10647f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f10647f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f10647f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = i.k0.e.l(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.n(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i.y.a.p(java.lang.String, int, int):void");
        }

        private static int r(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i2;
                        }
                    }
                }
            }
            return -1;
        }

        private static int s(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public y a() {
            if (this.f10642a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f10645d != null) {
                return new y(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            int i2 = this.f10646e;
            return i2 != -1 ? i2 : y.d(this.f10642a);
        }

        public a d(@Nullable String str) {
            this.f10648g = str != null ? y.y(y.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a e(String str) {
            Objects.requireNonNull(str, "host == null");
            String b2 = b(str, 0, str.length());
            if (b2 != null) {
                this.f10645d = b2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* access modifiers changed from: package-private */
        public a h(@Nullable y yVar, String str) {
            int l;
            int i2;
            int D = e.D(str, 0, str.length());
            int E = e.E(str, D, str.length());
            int r = r(str, D, E);
            if (r != -1) {
                if (str.regionMatches(true, D, "https:", 0, 6)) {
                    this.f10642a = "https";
                    D += 6;
                } else if (str.regionMatches(true, D, "http:", 0, 5)) {
                    this.f10642a = "http";
                    D += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, r) + "'");
                }
            } else if (yVar != null) {
                this.f10642a = yVar.f10634a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int s = s(str, D, E);
            char c2 = '?';
            char c3 = '#';
            if (s >= 2 || yVar == null || !yVar.f10634a.equals(this.f10642a)) {
                int i3 = D + s;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    l = e.l(str, i3, E, "@/\\?#");
                    char charAt = l != E ? str.charAt(l) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        int m = m(str, i3, l);
                        int i4 = m + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int k2 = e.k(str, i3, l, ':');
                                i2 = l;
                                String a2 = y.a(str, i3, k2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    a2 = this.f10643b + "%40" + a2;
                                }
                                this.f10643b = a2;
                                if (k2 != i2) {
                                    this.f10644c = y.a(str, k2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = l;
                                this.f10644c += "%40" + y.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            }
                            i3 = i2 + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                int m2 = m(str, i3, l);
                int i42 = m2 + 1;
                if (i42 < l) {
                    this.f10645d = b(str, i3, m2);
                    int i5 = i(str, i42, l);
                    this.f10646e = i5;
                    if (i5 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i42, l) + '\"');
                    }
                } else {
                    this.f10645d = b(str, i3, m2);
                    this.f10646e = y.d(this.f10642a);
                }
                if (this.f10645d != null) {
                    D = l;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, m2) + '\"');
                }
            } else {
                this.f10643b = yVar.j();
                this.f10644c = yVar.f();
                this.f10645d = yVar.f10637d;
                this.f10646e = yVar.f10638e;
                this.f10647f.clear();
                this.f10647f.addAll(yVar.h());
                if (D == E || str.charAt(D) == '#') {
                    d(yVar.i());
                }
            }
            int l2 = e.l(str, D, E, "?#");
            p(str, D, l2);
            if (l2 < E && str.charAt(l2) == '?') {
                int k3 = e.k(str, l2, E, '#');
                this.f10648g = y.y(y.a(str, l2 + 1, k3, " \"'<>#", true, false, true, true, null));
                l2 = k3;
            }
            if (l2 < E && str.charAt(l2) == '#') {
                this.f10649h = y.a(str, 1 + l2, E, BuildConfig.FLAVOR, true, false, false, false, null);
            }
            return this;
        }

        public a j(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f10644c = y.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a l(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            this.f10646e = i2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a o() {
            int size = this.f10647f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f10647f.set(i2, y.b(this.f10647f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f10648g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f10648g.get(i3);
                    if (str != null) {
                        this.f10648g.set(i3, y.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f10649h;
            if (str2 != null) {
                this.f10649h = y.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a q(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.f10642a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f10642a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a t(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f10643b = y.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f10642a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f10643b.isEmpty() || !this.f10644c.isEmpty()) {
                sb.append(this.f10643b);
                if (!this.f10644c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f10644c);
                }
                sb.append('@');
            }
            String str2 = this.f10645d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f10645d);
                    sb.append(']');
                } else {
                    sb.append(this.f10645d);
                }
            }
            if (!(this.f10646e == -1 && this.f10642a == null)) {
                int c2 = c();
                String str3 = this.f10642a;
                if (str3 == null || c2 != y.d(str3)) {
                    sb.append(':');
                    sb.append(c2);
                }
            }
            y.q(sb, this.f10647f);
            if (this.f10648g != null) {
                sb.append('?');
                y.n(sb, this.f10648g);
            }
            if (this.f10649h != null) {
                sb.append('#');
                sb.append(this.f10649h);
            }
            return sb.toString();
        }
    }

    y(a aVar) {
        this.f10634a = aVar.f10642a;
        this.f10635b = s(aVar.f10643b, false);
        this.f10636c = s(aVar.f10644c, false);
        this.f10637d = aVar.f10645d;
        this.f10638e = aVar.c();
        t(aVar.f10647f, false);
        List<String> list = aVar.f10648g;
        String str = null;
        this.f10639f = list != null ? t(list, true) : null;
        String str2 = aVar.f10649h;
        this.f10640g = str2 != null ? s(str2, false) : str;
        this.f10641h = aVar.toString();
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || v(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            c cVar = new c();
            cVar.h0(str, i2, i4);
            c(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.P();
        }
        return str.substring(i2, i3);
    }

    static String b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    static void c(c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.g0(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !v(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        cVar2.i0(codePointAt);
                    } else {
                        cVar2.f0(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!cVar2.o()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.a0(37);
                        char[] cArr = f10633i;
                        cVar.a0(cArr[(readByte >> 4) & 15]);
                        cVar.a0(cArr[readByte & 15]);
                    }
                } else {
                    cVar.i0(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static y k(String str) {
        a aVar = new a();
        aVar.h(null, str);
        return aVar.a();
    }

    static void n(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static void q(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    static String r(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                c cVar = new c();
                cVar.h0(str, i2, i4);
                u(cVar, str, i4, i3, z);
                return cVar.P();
            }
        }
        return str.substring(i2, i3);
    }

    static String s(String str, boolean z) {
        return r(str, 0, str.length(), z);
    }

    private List<String> t(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? s(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void u(c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int h2 = e.h(str.charAt(i2 + 1));
                int h3 = e.h(str.charAt(i4));
                if (!(h2 == -1 || h3 == -1)) {
                    cVar.a0((h2 << 4) + h3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                cVar.a0(32);
                i2 += Character.charCount(codePointAt);
            }
            cVar.i0(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean v(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || e.h(str.charAt(i2 + 1)) == -1 || e.h(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    static List<String> y(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public y A(String str) {
        a p = p(str);
        if (p != null) {
            return p.a();
        }
        return null;
    }

    public String B() {
        return this.f10634a;
    }

    public URI C() {
        a o = o();
        o.o();
        String aVar = o.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Nullable
    public String e() {
        if (this.f10640g == null) {
            return null;
        }
        return this.f10641h.substring(this.f10641h.indexOf(35) + 1);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof y) && ((y) obj).f10641h.equals(this.f10641h);
    }

    public String f() {
        if (this.f10636c.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int indexOf = this.f10641h.indexOf(64);
        return this.f10641h.substring(this.f10641h.indexOf(58, this.f10634a.length() + 3) + 1, indexOf);
    }

    public String g() {
        int indexOf = this.f10641h.indexOf(47, this.f10634a.length() + 3);
        String str = this.f10641h;
        return this.f10641h.substring(indexOf, e.l(str, indexOf, str.length(), "?#"));
    }

    public List<String> h() {
        int indexOf = this.f10641h.indexOf(47, this.f10634a.length() + 3);
        String str = this.f10641h;
        int l = e.l(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < l) {
            int i2 = indexOf + 1;
            int k2 = e.k(this.f10641h, i2, l, '/');
            arrayList.add(this.f10641h.substring(i2, k2));
            indexOf = k2;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f10641h.hashCode();
    }

    @Nullable
    public String i() {
        if (this.f10639f == null) {
            return null;
        }
        int indexOf = this.f10641h.indexOf(63) + 1;
        String str = this.f10641h;
        return this.f10641h.substring(indexOf, e.k(str, indexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f10635b.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f10634a.length() + 3;
        String str = this.f10641h;
        return this.f10641h.substring(length, e.l(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.f10637d;
    }

    public boolean m() {
        return this.f10634a.equals("https");
    }

    public a o() {
        a aVar = new a();
        aVar.f10642a = this.f10634a;
        aVar.f10643b = j();
        aVar.f10644c = f();
        aVar.f10645d = this.f10637d;
        aVar.f10646e = this.f10638e != d(this.f10634a) ? this.f10638e : -1;
        aVar.f10647f.clear();
        aVar.f10647f.addAll(h());
        aVar.d(i());
        aVar.f10649h = e();
        return aVar;
    }

    @Nullable
    public a p(String str) {
        try {
            a aVar = new a();
            aVar.h(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f10641h;
    }

    public int w() {
        return this.f10638e;
    }

    @Nullable
    public String x() {
        if (this.f10639f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        n(sb, this.f10639f);
        return sb.toString();
    }

    public String z() {
        a p = p("/...");
        p.t(BuildConfig.FLAVOR);
        p.j(BuildConfig.FLAVOR);
        return p.a().toString();
    }
}
