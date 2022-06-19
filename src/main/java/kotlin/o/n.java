package kotlin.o;

import kotlin.m.b.f;

public class n extends m {
    public static final boolean a(String str, int i2, String str2, int i3, int i4, boolean z) {
        f.e(str, "$this$regionMatches");
        f.e(str2, "other");
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    public static final String b(String str, String str2, String str3, boolean z) {
        f.e(str, "$this$replace");
        f.e(str2, "oldValue");
        f.e(str3, "newValue");
        int i2 = 0;
        int g2 = o.g(str, str2, 0, z);
        if (g2 < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = kotlin.n.f.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i2, g2);
                sb.append(str3);
                i2 = g2 + length;
                if (g2 >= str.length()) {
                    break;
                }
                g2 = o.g(str, str2, g2 + i3, z);
            } while (g2 > 0);
            sb.append((CharSequence) str, i2, str.length());
            String sb2 = sb.toString();
            f.d(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String c(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(str, str2, str3, z);
    }
}
