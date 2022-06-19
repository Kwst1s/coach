package kotlin.j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
public class e extends d {
    public static final <T> List<T> a(T[] tArr) {
        f.e(tArr, "$this$asList");
        List<T> a2 = g.a(tArr);
        f.d(a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static final <T> void b(T[] tArr, Comparator<? super T> comparator) {
        f.e(tArr, "$this$sortWith");
        f.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
