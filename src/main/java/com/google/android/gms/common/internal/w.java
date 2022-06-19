package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class w extends u {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Intent f7416b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Activity f7417c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ int f7418d;

    w(Intent intent, Activity activity, int i2) {
        this.f7416b = intent;
        this.f7417c = activity;
        this.f7418d = i2;
    }

    @Override // com.google.android.gms.common.internal.u
    public final void b() {
        Intent intent = this.f7416b;
        if (intent != null) {
            this.f7417c.startActivityForResult(intent, this.f7418d);
        }
    }
}
