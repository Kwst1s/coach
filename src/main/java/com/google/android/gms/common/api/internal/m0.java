package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.c;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class m0 extends d0<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    private final h<?> f7235c;

    public m0(h<?> hVar, c<Boolean> cVar) {
        super(4, cVar);
        this.f7235c = hVar;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final /* bridge */ /* synthetic */ void d(r0 r0Var, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final com.google.android.gms.common.c[] g(e.a<?> aVar) {
        c0 c0Var = aVar.A().get(this.f7235c);
        if (c0Var == null) {
            return null;
        }
        return c0Var.f7178a.b();
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final boolean h(e.a<?> aVar) {
        c0 c0Var = aVar.A().get(this.f7235c);
        if (c0Var == null) {
            return false;
        }
        c0Var.f7178a.d();
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.d0
    public final void i(e.a<?> aVar) {
        c0 remove = aVar.A().remove(this.f7235c);
        if (remove != null) {
            remove.f7179b.a(aVar.t(), this.f7181b);
            remove.f7178a.a();
            return;
        }
        this.f7181b.e((T) Boolean.FALSE);
    }
}
