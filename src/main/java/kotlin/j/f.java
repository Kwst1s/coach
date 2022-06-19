package kotlin.j;

import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
public class f extends e {
    public static final <T> boolean c(T[] tArr, T t) {
        kotlin.m.b.f.e(tArr, "$this$contains");
        return d(tArr, t) >= 0;
    }

    public static final <T> int d(T[] tArr, T t) {
        kotlin.m.b.f.e(tArr, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (kotlin.m.b.f.a(t, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static char e(char[] cArr) {
        kotlin.m.b.f.e(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T f(T[] tArr) {
        kotlin.m.b.f.e(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }
}
