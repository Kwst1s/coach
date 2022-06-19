package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
final class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ u f7264b;

    v(u uVar) {
        this.f7264b = uVar;
    }

    public final void run() {
        this.f7264b.f7261a.f7193b.e(String.valueOf(this.f7264b.f7261a.f7193b.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
