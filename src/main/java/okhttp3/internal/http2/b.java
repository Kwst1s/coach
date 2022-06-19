package okhttp3.internal.http2;

import i.k0.e;
import j.f;

/* compiled from: Header */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final f f10881d = f.i(":");

    /* renamed from: e  reason: collision with root package name */
    public static final f f10882e = f.i(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final f f10883f = f.i(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final f f10884g = f.i(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final f f10885h = f.i(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final f f10886i = f.i(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final f f10887a;

    /* renamed from: b  reason: collision with root package name */
    public final f f10888b;

    /* renamed from: c  reason: collision with root package name */
    final int f10889c;

    public b(String str, String str2) {
        this(f.i(str), f.i(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f10887a.equals(bVar.f10887a) || !this.f10888b.equals(bVar.f10888b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f10887a.hashCode()) * 31) + this.f10888b.hashCode();
    }

    public String toString() {
        return e.n("%s: %s", this.f10887a.w(), this.f10888b.w());
    }

    public b(f fVar, String str) {
        this(fVar, f.i(str));
    }

    public b(f fVar, f fVar2) {
        this.f10887a = fVar;
        this.f10888b = fVar2;
        this.f10889c = fVar.r() + 32 + fVar2.r();
    }
}
