package com.google.android.gms.common.api.internal;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final i f7275b;

    /* renamed from: c  reason: collision with root package name */
    private final IBinder f7276c;

    z(i iVar, IBinder iBinder) {
        this.f7275b = iVar;
        this.f7276c = iBinder;
    }

    public final void run() {
        this.f7275b.r(this.f7276c);
    }
}
