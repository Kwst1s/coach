package com.google.android.gms.common.internal.q;

import android.os.IBinder;
import android.os.Parcel;
import c.e.a.a.b.a.b;
import c.e.a.a.b.a.c;
import com.google.android.gms.common.internal.r;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class a extends b implements b {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // com.google.android.gms.common.internal.q.b
    public final void h(r rVar) {
        Parcel e2 = e();
        c.c(e2, rVar);
        k(1, e2);
    }
}
