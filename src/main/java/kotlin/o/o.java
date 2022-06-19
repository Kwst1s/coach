package kotlin.o;

import kotlin.m.b.f;
import kotlin.n.a;
import kotlin.n.c;

public class o extends n {
    public static boolean d(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        f.e(charSequence, "$this$contains");
        f.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (k(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (i(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static final int e(CharSequence charSequence) {
        f.e(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int f(CharSequence charSequence, char c2, int i2, boolean z) {
        f.e(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return l(charSequence, new char[]{c2}, i2, z);
    }

    public static final int g(CharSequence charSequence, String str, int i2, boolean z) {
        f.e(charSequence, "$this$indexOf");
        f.e(str, "string");
        if (z || !(charSequence instanceof String)) {
            return i(charSequence, str, i2, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i2);
    }

    private static final int h(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        a aVar;
        if (!z2) {
            aVar = new c(kotlin.n.f.a(i2, 0), kotlin.n.f.b(i3, charSequence.length()));
        } else {
            aVar = kotlin.n.f.c(kotlin.n.f.b(i2, e(charSequence)), kotlin.n.f.a(i3, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a2 = aVar.a();
            int b2 = aVar.b();
            int c2 = aVar.c();
            if (c2 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (!m(charSequence2, 0, charSequence, a2, charSequence2.length(), z)) {
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
            return a2;
        }
        int a3 = aVar.a();
        int b3 = aVar.b();
        int c3 = aVar.c();
        if (c3 >= 0) {
            if (a3 > b3) {
                return -1;
            }
        } else if (a3 < b3) {
            return -1;
        }
        while (!n.a((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z)) {
            if (a3 == b3) {
                return -1;
            }
            a3 += c3;
        }
        return a3;
    }

    static /* synthetic */ int i(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return h(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int j(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return f(charSequence, c2, i2, z);
    }

    public static /* synthetic */ int k(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return g(charSequence, str, i2, z);
    }

    public static final int l(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        boolean z2;
        f.e(charSequence, "$this$indexOfAny");
        f.e(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int i3 = kotlin.n.f.a(i2, 0);
            int e2 = e(charSequence);
            if (i3 > e2) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(i3);
                int length = cArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z2 = false;
                        break;
                    } else if (b.a(cArr[i4], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return i3;
                }
                if (i3 == e2) {
                    return -1;
                }
                i3++;
            }
        } else {
            return ((String) charSequence).indexOf(kotlin.j.f.e(cArr), i2);
        }
    }

    public static final boolean m(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        f.e(charSequence, "$this$regionMatchesImpl");
        f.e(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!b.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }
}
