package com.google.android.gms.common.internal.q;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.b;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class d extends c<a.d.c> implements s {

    /* renamed from: i  reason: collision with root package name */
    private static final a.g<e> f7402i;

    /* renamed from: j  reason: collision with root package name */
    private static final a.AbstractC0141a<e, a.d.c> f7403j;

    /* renamed from: k  reason: collision with root package name */
    private static final a<a.d.c> f7404k;

    static {
        a.g<e> gVar = new a.g<>();
        f7402i = gVar;
        f fVar = new f();
        f7403j = fVar;
        f7404k = new a<>("ClientTelemetry.API", fVar, gVar);
    }

    public d(Context context) {
        super(context, f7404k, a.d.f7139a, c.a.f7148c);
    }

    static final /* synthetic */ void k(r rVar, e eVar, com.google.android.gms.tasks.c cVar) {
        ((b) eVar.A()).h(rVar);
        cVar.c(null);
    }

    @Override // com.google.android.gms.common.internal.s
    public final b<Void> h(r rVar) {
        n.a a2 = n.a();
        a2.d(c.e.a.a.b.a.d.f3216a);
        a2.c(false);
        a2.b(new c(rVar));
        return b(a2.a());
    }
}
