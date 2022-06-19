package com.google.android.gms.common.internal.q;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class e extends g<b> {
    public e(Context context, Looper looper, d dVar, com.google.android.gms.common.api.internal.d dVar2, j jVar) {
        super(context, looper, 270, dVar, dVar2, jVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final String B() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final String C() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final boolean F() {
        return true;
    }

    @Override // com.google.android.gms.common.api.a.f, com.google.android.gms.common.internal.c
    public final int g() {
        return 203390000;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        if (queryLocalInterface instanceof b) {
            return (b) queryLocalInterface;
        }
        return new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final c[] u() {
        return c.e.a.a.b.a.d.f3217b;
    }
}
