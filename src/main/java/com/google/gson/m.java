package com.google.gson;

import com.google.gson.u.g;
import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject */
public final class m extends k {

    /* renamed from: a  reason: collision with root package name */
    private final g<String, k> f8311a = new g<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f8311a.equals(this.f8311a));
    }

    public void h(String str, k kVar) {
        g<String, k> gVar = this.f8311a;
        if (kVar == null) {
            kVar = l.f8310a;
        }
        gVar.put(str, kVar);
    }

    public int hashCode() {
        return this.f8311a.hashCode();
    }

    public Set<Map.Entry<String, k>> i() {
        return this.f8311a.entrySet();
    }
}
