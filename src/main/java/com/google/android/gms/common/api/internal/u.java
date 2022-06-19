package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.c;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class u implements c.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e.a f7261a;

    u(e.a aVar) {
        this.f7261a = aVar;
    }

    @Override // com.google.android.gms.common.internal.c.e
    public final void a() {
        e.this.q.post(new v(this));
    }
}
