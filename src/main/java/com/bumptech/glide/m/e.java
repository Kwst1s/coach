package com.bumptech.glide.m;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.m.c;
import com.bumptech.glide.r.j;

/* compiled from: DefaultConnectivityMonitor */
final class e implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Context f4249b;

    /* renamed from: c  reason: collision with root package name */
    final c.a f4250c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4251d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4252e;

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f4253f = new a();

    /* compiled from: DefaultConnectivityMonitor */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f4251d;
            eVar.f4251d = eVar.l(context);
            if (z != e.this.f4251d) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f4251d);
                }
                e eVar2 = e.this;
                eVar2.f4250c.a(eVar2.f4251d);
            }
        }
    }

    e(Context context, c.a aVar) {
        this.f4249b = context.getApplicationContext();
        this.f4250c = aVar;
    }

    private void m() {
        if (!this.f4252e) {
            this.f4251d = l(this.f4249b);
            try {
                this.f4249b.registerReceiver(this.f4253f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f4252e = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e2);
                }
            }
        }
    }

    private void n() {
        if (this.f4252e) {
            this.f4249b.unregisterReceiver(this.f4253f);
            this.f4252e = false;
        }
    }

    @Override // com.bumptech.glide.m.i
    public void a() {
        m();
    }

    @Override // com.bumptech.glide.m.i
    public void e() {
        n();
    }

    @Override // com.bumptech.glide.m.i
    public void k() {
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean l(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        j.d(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }
}
