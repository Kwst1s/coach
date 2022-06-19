package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.a;
import com.google.android.gms.common.api.internal.e;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
final class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a f7265b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ e.c f7266c;

    w(e.c cVar, a aVar) {
        this.f7266c = cVar;
        this.f7265b = aVar;
    }

    public final void run() {
        e.a aVar = (e.a) e.this.m.get(this.f7266c.f7206b);
        if (aVar != null) {
            if (this.f7265b.o()) {
                this.f7266c.f7209e = true;
                if (this.f7266c.f7205a.o()) {
                    this.f7266c.e();
                    return;
                }
                try {
                    this.f7266c.f7205a.d(null, this.f7266c.f7205a.c());
                } catch (SecurityException e2) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                    this.f7266c.f7205a.e("Failed to get service from broker.");
                    aVar.i(new a(10));
                }
            } else {
                aVar.i(this.f7265b);
            }
        }
    }
}
