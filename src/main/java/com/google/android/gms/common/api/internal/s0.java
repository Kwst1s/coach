package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.c;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class s0 implements a<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c f7258a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ r0 f7259b;

    s0(r0 r0Var, c cVar) {
        this.f7259b = r0Var;
        this.f7258a = cVar;
    }

    @Override // com.google.android.gms.tasks.a
    public final void a(b<TResult> bVar) {
        this.f7259b.f7255b.remove(this.f7258a);
    }
}
