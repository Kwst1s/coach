package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f7256b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ e.a f7257c;

    s(e.a aVar, int i2) {
        this.f7257c = aVar;
        this.f7256b = i2;
    }

    public final void run() {
        this.f7257c.d(this.f7256b);
    }
}
