package com.bumptech.glide.r;

import b.e.a;
import b.e.g;

/* compiled from: CachedHashCodeArrayMap */
public final class b<K, V> extends a<K, V> {

    /* renamed from: j  reason: collision with root package name */
    private int f4365j;

    @Override // b.e.g
    public void clear() {
        this.f4365j = 0;
        super.clear();
    }

    @Override // b.e.g
    public int hashCode() {
        if (this.f4365j == 0) {
            this.f4365j = super.hashCode();
        }
        return this.f4365j;
    }

    @Override // b.e.g
    public void j(g<? extends K, ? extends V> gVar) {
        this.f4365j = 0;
        super.j(gVar);
    }

    @Override // b.e.g
    public V k(int i2) {
        this.f4365j = 0;
        return (V) super.k(i2);
    }

    @Override // b.e.g
    public V l(int i2, V v) {
        this.f4365j = 0;
        return (V) super.l(i2, v);
    }

    @Override // java.util.Map, b.e.g
    public V put(K k2, V v) {
        this.f4365j = 0;
        return (V) super.put(k2, v);
    }
}
