package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import c.e.a.a.b.b.d;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.k.a;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class l0 extends h {
    @GuardedBy("connectionStatus")

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<h.a, n0> f7377d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final Context f7378e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f7379f;

    /* renamed from: g  reason: collision with root package name */
    private final a f7380g;

    /* renamed from: h  reason: collision with root package name */
    private final long f7381h;

    /* renamed from: i  reason: collision with root package name */
    private final long f7382i;

    l0(Context context) {
        this.f7378e = context.getApplicationContext();
        this.f7379f = new d(context.getMainLooper(), new m0(this));
        this.f7380g = a.a();
        this.f7381h = 5000;
        this.f7382i = 300000;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.h
    public final boolean d(h.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        n.g(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7377d) {
            n0 n0Var = this.f7377d.get(aVar);
            if (n0Var == null) {
                n0Var = new n0(this, aVar);
                n0Var.a(serviceConnection, serviceConnection, str);
                n0Var.c(str);
                this.f7377d.put(aVar, n0Var);
            } else {
                this.f7379f.removeMessages(0, aVar);
                if (!n0Var.e(serviceConnection)) {
                    n0Var.a(serviceConnection, serviceConnection, str);
                    int f2 = n0Var.f();
                    if (f2 == 1) {
                        serviceConnection.onServiceConnected(n0Var.j(), n0Var.i());
                    } else if (f2 == 2) {
                        n0Var.c(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = n0Var.d();
        }
        return d2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.h
    public final void e(h.a aVar, ServiceConnection serviceConnection, String str) {
        n.g(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7377d) {
            n0 n0Var = this.f7377d.get(aVar);
            if (n0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (n0Var.e(serviceConnection)) {
                n0Var.b(serviceConnection, str);
                if (n0Var.h()) {
                    this.f7379f.sendMessageDelayed(this.f7379f.obtainMessage(0, aVar), this.f7381h);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
