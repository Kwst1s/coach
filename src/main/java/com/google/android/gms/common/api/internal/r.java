package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class r implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f7253a;

    r(e eVar) {
        this.f7253a = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z) {
        this.f7253a.q.sendMessage(this.f7253a.q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
