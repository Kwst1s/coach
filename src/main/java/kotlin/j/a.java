package kotlin.j;

import java.util.Collection;
import java.util.Iterator;
import kotlin.m.b.b;
import kotlin.m.b.c;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: Collections.kt */
public final class a<T> implements Collection<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T[] f10776b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10777c;

    public a(T[] tArr, boolean z) {
        f.e(tArr, "values");
        this.f10776b = tArr;
        this.f10777c = z;
    }

    public int a() {
        return this.f10776b.length;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return f.c(this.f10776b, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        f.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f10776b.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return b.a(this.f10776b);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    public final Object[] toArray() {
        return i.a(this.f10776b, this.f10777c);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) c.b(this, tArr);
    }
}
