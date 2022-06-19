package g.a.a.a.b.d.d;

import java.io.Serializable;
import java.util.Map;
import kotlin.m.b.f;

/* compiled from: MBSection.kt */
public final class a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private Map<String, ? extends g.a.a.a.b.d.a.a> f9813b;

    public a(long j2, int i2, Map<String, ? extends g.a.a.a.b.d.a.a> map, long j3) {
        f.f(map, "data");
        this.f9813b = map;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends g.a.a.a.b.d.a.a>, java.util.Map<java.lang.String, g.a.a.a.b.d.a.a> */
    public final Map<String, g.a.a.a.b.d.a.a> a() {
        return this.f9813b;
    }
}
