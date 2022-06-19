package kotlin.j;

import java.util.Collection;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
public class k extends j {
    public static <T> int f(Iterable<? extends T> iterable, int i2) {
        f.e(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
