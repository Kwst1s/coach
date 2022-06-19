package kotlin.j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
public class n extends m {
    public static <T> void g(List<T> list, Comparator<? super T> comparator) {
        f.e(list, "$this$sortWith");
        f.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
