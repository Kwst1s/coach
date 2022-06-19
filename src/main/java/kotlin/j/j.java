package kotlin.j;

import java.util.ArrayList;
import java.util.List;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: Collections.kt */
public class j extends i {
    public static <T> List<T> c() {
        return t.f10779b;
    }

    public static <T> List<T> d(T... tArr) {
        f.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new a(tArr, true));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> e(List<? extends T> list) {
        f.e(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return c();
        }
        if (size != 1) {
            return list;
        }
        return i.b(list.get(0));
    }
}
