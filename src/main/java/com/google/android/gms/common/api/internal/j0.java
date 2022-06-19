package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.c;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class j0 extends n<A, ResultT> {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ n.a f7234d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j0(n.a aVar, c[] cVarArr, boolean z, int i2) {
        super(cVarArr, z, i2);
        this.f7234d = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.n
    public final void b(A a2, com.google.android.gms.tasks.c<ResultT> cVar) {
        this.f7234d.f7239a.a(a2, cVar);
    }
}
