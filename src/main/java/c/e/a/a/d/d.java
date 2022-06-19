package c.e.a.a.d;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g<c.e.a.a.d.b.a> f3235a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.g<c.e.a.a.d.b.a> f3236b;

    /* renamed from: c  reason: collision with root package name */
    public static final a.AbstractC0141a<c.e.a.a.d.b.a, a> f3237c;

    /* renamed from: d  reason: collision with root package name */
    private static final a.AbstractC0141a<c.e.a.a.d.b.a, e> f3238d;

    static {
        a.g<c.e.a.a.d.b.a> gVar = new a.g<>();
        f3235a = gVar;
        a.g<c.e.a.a.d.b.a> gVar2 = new a.g<>();
        f3236b = gVar2;
        c cVar = new c();
        f3237c = cVar;
        f fVar = new f();
        f3238d = fVar;
        new Scope("profile");
        new Scope("email");
        new a("SignIn.API", cVar, gVar);
        new a("SignIn.INTERNAL_API", fVar, gVar2);
    }
}
