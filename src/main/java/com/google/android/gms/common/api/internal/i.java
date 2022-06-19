package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.n;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class i implements ServiceConnection, a.f {

    /* renamed from: a  reason: collision with root package name */
    private final String f7224a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7225b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f7226c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f7227d;

    /* renamed from: e  reason: collision with root package name */
    private final d f7228e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f7229f;

    /* renamed from: g  reason: collision with root package name */
    private final j f7230g;

    /* renamed from: h  reason: collision with root package name */
    private IBinder f7231h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7232i;

    /* renamed from: j  reason: collision with root package name */
    private String f7233j;

    private final void p() {
        if (Thread.currentThread() != this.f7229f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    private final void t(String str) {
        String valueOf = String.valueOf(this.f7231h);
        boolean z = this.f7232i;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(valueOf).length());
        sb.append(str);
        sb.append(" binder: ");
        sb.append(valueOf);
        sb.append(", isConnecting: ");
        sb.append(z);
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void a(@RecentlyNonNull c.e eVar) {
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean b() {
        p();
        return this.f7231h != null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final Set<Scope> c() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void d(com.google.android.gms.common.internal.i iVar, Set<Scope> set) {
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void e(@RecentlyNonNull String str) {
        p();
        this.f7233j = str;
        n();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean f() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final int g() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean h() {
        p();
        return this.f7232i;
    }

    @Override // com.google.android.gms.common.api.a.f
    @RecentlyNonNull
    public final com.google.android.gms.common.c[] i() {
        return new com.google.android.gms.common.c[0];
    }

    @Override // com.google.android.gms.common.api.a.f
    @RecentlyNonNull
    public final String j() {
        String str = this.f7224a;
        if (str != null) {
            return str;
        }
        n.f(this.f7226c);
        return this.f7226c.getPackageName();
    }

    @Override // com.google.android.gms.common.api.a.f
    @RecentlyNullable
    public final String k() {
        return this.f7233j;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void m(@RecentlyNonNull c.AbstractC0144c cVar) {
        p();
        t("Connect started.");
        if (b()) {
            try {
                e("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f7226c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f7224a).setAction(this.f7225b);
            }
            boolean bindService = this.f7227d.bindService(intent, this, h.a());
            this.f7232i = bindService;
            if (!bindService) {
                this.f7231h = null;
                this.f7230g.i(new com.google.android.gms.common.a(16));
            }
            t("Finished connect.");
        } catch (SecurityException e2) {
            this.f7232i = false;
            this.f7231h = null;
            throw e2;
        }
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void n() {
        p();
        t("Disconnect called.");
        try {
            this.f7227d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f7232i = false;
        this.f7231h = null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean o() {
        return false;
    }

    public final void onServiceConnected(@RecentlyNonNull ComponentName componentName, @RecentlyNonNull IBinder iBinder) {
        this.f7229f.post(new z(this, iBinder));
    }

    public final void onServiceDisconnected(@RecentlyNonNull ComponentName componentName) {
        this.f7229f.post(new a0(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q() {
        this.f7232i = false;
        this.f7231h = null;
        t("Disconnected.");
        this.f7228e.e(1);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(IBinder iBinder) {
        this.f7232i = false;
        this.f7231h = iBinder;
        t("Connected.");
        this.f7228e.k(new Bundle());
    }

    public final void s(String str) {
    }
}
