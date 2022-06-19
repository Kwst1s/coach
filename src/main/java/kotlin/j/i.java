package kotlin.j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
public class i {
    public static final <T> Object[] a(T[] tArr, boolean z) {
        f.e(tArr, "$this$copyToArrayOfAny");
        if (!z || !f.a(tArr.getClass(), Object[].class)) {
            tArr = (T[]) Arrays.copyOf(tArr, tArr.length, Object[].class);
        }
        f.d(tArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return tArr;
    }

    public static <T> List<T> b(T t) {
        List<T> singletonList = Collections.singletonList(t);
        f.d(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
