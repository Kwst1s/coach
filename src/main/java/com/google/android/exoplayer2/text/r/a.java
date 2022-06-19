package com.google.android.exoplayer2.text.r;

import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
/* compiled from: CssParser */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f6816c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: a  reason: collision with root package name */
    private final s f6817a = new s();

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f6818b = new StringBuilder();

    private void a(d dVar, String str) {
        if (!BuildConfig.FLAVOR.equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f6816c.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    dVar.v(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] c0 = d0.c0(str, "\\.");
            String str2 = c0[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                dVar.u(str2.substring(0, indexOf2));
                dVar.t(str2.substring(indexOf2 + 1));
            } else {
                dVar.u(str2);
            }
            if (c0.length > 1) {
                dVar.s((String[]) Arrays.copyOfRange(c0, 1, c0.length));
            }
        }
    }

    private static boolean b(s sVar) {
        int c2 = sVar.c();
        int d2 = sVar.d();
        byte[] bArr = sVar.f7062a;
        if (c2 + 2 > d2) {
            return false;
        }
        int i2 = c2 + 1;
        if (bArr[c2] != 47) {
            return false;
        }
        int i3 = i2 + 1;
        if (bArr[i2] != 42) {
            return false;
        }
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= d2) {
                sVar.L(d2 - sVar.c());
                return true;
            } else if (((char) bArr[i3]) == '*' && ((char) bArr[i4]) == '/') {
                i3 = i4 + 1;
                d2 = i3;
            } else {
                i3 = i4;
            }
        }
    }

    private static boolean c(s sVar) {
        char j2 = j(sVar, sVar.c());
        if (j2 != '\t' && j2 != '\n' && j2 != '\f' && j2 != '\r' && j2 != ' ') {
            return false;
        }
        sVar.L(1);
        return true;
    }

    private static String e(s sVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int c2 = sVar.c();
        int d2 = sVar.d();
        while (c2 < d2 && !z) {
            char c3 = (char) sVar.f7062a[c2];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z = true;
            } else {
                c2++;
                sb.append(c3);
            }
        }
        sVar.L(c2 - sVar.c());
        return sb.toString();
    }

    static String f(s sVar, StringBuilder sb) {
        m(sVar);
        if (sVar.a() == 0) {
            return null;
        }
        String e2 = e(sVar, sb);
        if (!BuildConfig.FLAVOR.equals(e2)) {
            return e2;
        }
        return BuildConfig.FLAVOR + ((char) sVar.y());
    }

    private static String g(s sVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int c2 = sVar.c();
            String f2 = f(sVar, sb);
            if (f2 == null) {
                return null;
            }
            if ("}".equals(f2) || ";".equals(f2)) {
                sVar.K(c2);
                z = true;
            } else {
                sb2.append(f2);
            }
        }
        return sb2.toString();
    }

    private static String h(s sVar, StringBuilder sb) {
        m(sVar);
        if (sVar.a() < 5 || !"::cue".equals(sVar.v(5))) {
            return null;
        }
        int c2 = sVar.c();
        String f2 = f(sVar, sb);
        if (f2 == null) {
            return null;
        }
        if ("{".equals(f2)) {
            sVar.K(c2);
            return BuildConfig.FLAVOR;
        }
        String k2 = "(".equals(f2) ? k(sVar) : null;
        String f3 = f(sVar, sb);
        if (!")".equals(f3) || f3 == null) {
            return null;
        }
        return k2;
    }

    private static void i(s sVar, d dVar, StringBuilder sb) {
        m(sVar);
        String e2 = e(sVar, sb);
        if (!BuildConfig.FLAVOR.equals(e2) && ":".equals(f(sVar, sb))) {
            m(sVar);
            String g2 = g(sVar, sb);
            if (g2 != null && !BuildConfig.FLAVOR.equals(g2)) {
                int c2 = sVar.c();
                String f2 = f(sVar, sb);
                if (!";".equals(f2)) {
                    if ("}".equals(f2)) {
                        sVar.K(c2);
                    } else {
                        return;
                    }
                }
                if ("color".equals(e2)) {
                    dVar.p(h.c(g2));
                } else if ("background-color".equals(e2)) {
                    dVar.n(h.c(g2));
                } else if ("text-decoration".equals(e2)) {
                    if ("underline".equals(g2)) {
                        dVar.w(true);
                    }
                } else if ("font-family".equals(e2)) {
                    dVar.q(g2);
                } else if ("font-weight".equals(e2)) {
                    if ("bold".equals(g2)) {
                        dVar.o(true);
                    }
                } else if ("font-style".equals(e2) && "italic".equals(g2)) {
                    dVar.r(true);
                }
            }
        }
    }

    private static char j(s sVar, int i2) {
        return (char) sVar.f7062a[i2];
    }

    private static String k(s sVar) {
        int c2 = sVar.c();
        int d2 = sVar.d();
        boolean z = false;
        while (c2 < d2 && !z) {
            int i2 = c2 + 1;
            z = ((char) sVar.f7062a[c2]) == ')';
            c2 = i2;
        }
        return sVar.v((c2 - 1) - sVar.c()).trim();
    }

    static void l(s sVar) {
        do {
        } while (!TextUtils.isEmpty(sVar.l()));
    }

    static void m(s sVar) {
        while (true) {
            boolean z = true;
            while (sVar.a() > 0 && z) {
                if (!c(sVar) && !b(sVar)) {
                    z = false;
                }
            }
            return;
        }
    }

    public d d(s sVar) {
        this.f6818b.setLength(0);
        int c2 = sVar.c();
        l(sVar);
        this.f6817a.I(sVar.f7062a, sVar.c());
        this.f6817a.K(c2);
        String h2 = h(this.f6817a, this.f6818b);
        if (h2 == null || !"{".equals(f(this.f6817a, this.f6818b))) {
            return null;
        }
        d dVar = new d();
        a(dVar, h2);
        String str = null;
        boolean z = false;
        while (!z) {
            int c3 = this.f6817a.c();
            str = f(this.f6817a, this.f6818b);
            boolean z2 = str == null || "}".equals(str);
            if (!z2) {
                this.f6817a.K(c3);
                i(this.f6817a, dVar, this.f6818b);
            }
            z = z2;
        }
        if ("}".equals(str)) {
            return dVar;
        }
        return null;
    }
}
