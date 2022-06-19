package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class i extends k implements Iterable<k> {

    /* renamed from: b  reason: collision with root package name */
    private final List<k> f8309b = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f8309b.equals(this.f8309b));
    }

    public void h(k kVar) {
        if (kVar == null) {
            kVar = l.f8310a;
        }
        this.f8309b.add(kVar);
    }

    public int hashCode() {
        return this.f8309b.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f8309b.iterator();
    }
}
