package kotlin.m.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: ArrayIterator.kt */
public final class a<T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    private int f10782b;

    /* renamed from: c  reason: collision with root package name */
    private final T[] f10783c;

    public a(T[] tArr) {
        f.e(tArr, "array");
        this.f10783c = tArr;
    }

    public boolean hasNext() {
        return this.f10782b < this.f10783c.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f10783c;
            int i2 = this.f10782b;
            this.f10782b = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f10782b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
