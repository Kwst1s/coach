package i.k0.h;

import i.e0;
import i.g0;
import i.q;
import i.r;
import i.x;
import i.y;
import j.f;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: HttpHeaders */
public final class e {
    static {
        f.i("\"\\");
        f.i("\t ,=");
    }

    public static long a(x xVar) {
        return j(xVar.c("Content-Length"));
    }

    public static long b(g0 g0Var) {
        return a(g0Var.K());
    }

    public static boolean c(g0 g0Var) {
        if (g0Var.S().g().equals("HEAD")) {
            return false;
        }
        int G = g0Var.G();
        if (((G >= 100 && G < 200) || G == 204 || G == 304) && b(g0Var) == -1 && !"chunked".equalsIgnoreCase(g0Var.I("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static boolean d(x xVar) {
        return k(xVar).contains("*");
    }

    public static boolean e(g0 g0Var) {
        return d(g0Var.K());
    }

    public static int f(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static void g(r rVar, y yVar, x xVar) {
        if (rVar != r.f10617a) {
            List<q> f2 = q.f(yVar, xVar);
            if (!f2.isEmpty()) {
                rVar.b(yVar, f2);
            }
        }
    }

    public static int h(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int i(String str, int i2) {
        while (i2 < str.length() && ((r0 = str.charAt(i2)) == ' ' || r0 == '\t')) {
            i2++;
        }
        return i2;
    }

    private static long j(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static Set<String> k(x xVar) {
        Set<String> emptySet = Collections.emptySet();
        int h2 = xVar.h();
        for (int i2 = 0; i2 < h2; i2++) {
            if ("Vary".equalsIgnoreCase(xVar.e(i2))) {
                String i3 = xVar.i(i2);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : i3.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    private static Set<String> l(g0 g0Var) {
        return k(g0Var.K());
    }

    public static x m(x xVar, x xVar2) {
        Set<String> k2 = k(xVar2);
        if (k2.isEmpty()) {
            return i.k0.e.f10447c;
        }
        x.a aVar = new x.a();
        int h2 = xVar.h();
        for (int i2 = 0; i2 < h2; i2++) {
            String e2 = xVar.e(i2);
            if (k2.contains(e2)) {
                aVar.a(e2, xVar.i(i2));
            }
        }
        return aVar.d();
    }

    public static x n(g0 g0Var) {
        return m(g0Var.N().S().e(), g0Var.K());
    }

    public static boolean o(g0 g0Var, x xVar, e0 e0Var) {
        for (String str : l(g0Var)) {
            if (!Objects.equals(xVar.j(str), e0Var.d(str))) {
                return false;
            }
        }
        return true;
    }
}
