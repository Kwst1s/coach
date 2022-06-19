package com.bumptech.glide.r;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache */
public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f4375a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private long f4376b;

    /* renamed from: c  reason: collision with root package name */
    private long f4377c;

    public g(long j2) {
        this.f4376b = j2;
    }

    private void f() {
        m(this.f4376b);
    }

    public void b() {
        m(0);
    }

    public synchronized Y g(T t) {
        return this.f4375a.get(t);
    }

    public synchronized long h() {
        return this.f4376b;
    }

    /* access modifiers changed from: protected */
    public int i(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void j(T t, Y y) {
    }

    public synchronized Y k(T t, Y y) {
        long i2 = (long) i(y);
        if (i2 >= this.f4376b) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.f4377c += i2;
        }
        Y put = this.f4375a.put(t, y);
        if (put != null) {
            this.f4377c -= (long) i(put);
            if (!put.equals(y)) {
                j(t, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(T t) {
        Y remove;
        remove = this.f4375a.remove(t);
        if (remove != null) {
            this.f4377c -= (long) i(remove);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public synchronized void m(long j2) {
        while (this.f4377c > j2) {
            Iterator<Map.Entry<T, Y>> it = this.f4375a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f4377c -= (long) i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
