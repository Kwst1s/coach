package kotlin.j;

import java.util.Iterator;

/* compiled from: Iterators.kt */
public abstract class u implements Iterator<Integer> {
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(b());
    }

    public abstract int b();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
