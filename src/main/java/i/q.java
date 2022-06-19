package i;

import i.k0.e;
import i.k0.h.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: Cookie */
public final class q {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f10606j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f10607k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f10608a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10609b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10610c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10611d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10612e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10613f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f10614g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10615h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f10616i;

    private q(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f10608a = str;
        this.f10609b = str2;
        this.f10610c = j2;
        this.f10611d = str3;
        this.f10612e = str4;
        this.f10613f = z;
        this.f10614g = z2;
        this.f10616i = z3;
        this.f10615h = z4;
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || e.J(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static i.q d(long r23, i.y r25, java.lang.String r26) {
        /*
        // Method dump skipped, instructions count: 311
        */
        throw new UnsupportedOperationException("Method not decompiled: i.q.d(long, i.y, java.lang.String):i.q");
    }

    @Nullable
    public static q e(y yVar, String str) {
        return d(System.currentTimeMillis(), yVar, str);
    }

    public static List<q> f(y yVar, x xVar) {
        List<String> j2 = xVar.j("Set-Cookie");
        int size = j2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            q e2 = e(yVar, j2.get(i2));
            if (e2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String g(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String b2 = e.b(str);
            if (b2 != null) {
                return b2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long h(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 != -1 || !matcher.usePattern(l).matches()) {
                if (i7 == -1) {
                    Pattern pattern = f10607k;
                    if (matcher.usePattern(pattern).matches()) {
                        i7 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(f10606j).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i6 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(e.f10449e);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    public String c() {
        return this.f10608a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (qVar.f10608a.equals(this.f10608a) && qVar.f10609b.equals(this.f10609b) && qVar.f10611d.equals(this.f10611d) && qVar.f10612e.equals(this.f10612e) && qVar.f10610c == this.f10610c && qVar.f10613f == this.f10613f && qVar.f10614g == this.f10614g && qVar.f10615h == this.f10615h && qVar.f10616i == this.f10616i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f10610c;
        return ((((((((((((((((527 + this.f10608a.hashCode()) * 31) + this.f10609b.hashCode()) * 31) + this.f10611d.hashCode()) * 31) + this.f10612e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f10613f ? 1 : 0)) * 31) + (!this.f10614g ? 1 : 0)) * 31) + (!this.f10615h ? 1 : 0)) * 31) + (!this.f10616i ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public String j(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10608a);
        sb.append('=');
        sb.append(this.f10609b);
        if (this.f10615h) {
            if (this.f10610c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(d.a(new Date(this.f10610c)));
            }
        }
        if (!this.f10616i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f10611d);
        }
        sb.append("; path=");
        sb.append(this.f10612e);
        if (this.f10613f) {
            sb.append("; secure");
        }
        if (this.f10614g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f10609b;
    }

    public String toString() {
        return j(false);
    }
}
