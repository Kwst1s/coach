package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.h;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class n0 implements ServiceConnection, p0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<ServiceConnection, ServiceConnection> f7386a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f7387b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7388c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f7389d;

    /* renamed from: e  reason: collision with root package name */
    private final h.a f7390e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f7391f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ l0 f7392g;

    public n0(l0 l0Var, h.a aVar) {
        this.f7392g = l0Var;
        this.f7390e = aVar;
    }

    public final void a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f7386a.put(serviceConnection, serviceConnection2);
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        this.f7386a.remove(serviceConnection);
    }

    public final void c(String str) {
        this.f7387b = 3;
        boolean c2 = this.f7392g.f7380g.c(this.f7392g.f7378e, str, this.f7390e.a(this.f7392g.f7378e), this, this.f7390e.e());
        this.f7388c = c2;
        if (c2) {
            this.f7392g.f7379f.sendMessageDelayed(this.f7392g.f7379f.obtainMessage(1, this.f7390e), this.f7392g.f7382i);
            return;
        }
        this.f7387b = 2;
        try {
            this.f7392g.f7380g.b(this.f7392g.f7378e, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean d() {
        return this.f7388c;
    }

    public final boolean e(ServiceConnection serviceConnection) {
        return this.f7386a.containsKey(serviceConnection);
    }

    public final int f() {
        return this.f7387b;
    }

    public final void g(String str) {
        this.f7392g.f7379f.removeMessages(1, this.f7390e);
        this.f7392g.f7380g.b(this.f7392g.f7378e, this);
        this.f7388c = false;
        this.f7387b = 2;
    }

    public final boolean h() {
        return this.f7386a.isEmpty();
    }

    public final IBinder i() {
        return this.f7389d;
    }

    public final ComponentName j() {
        return this.f7391f;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f7392g.f7377d) {
            this.f7392g.f7379f.removeMessages(1, this.f7390e);
            this.f7389d = iBinder;
            this.f7391f = componentName;
            for (ServiceConnection serviceConnection : this.f7386a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f7387b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7392g.f7377d) {
            this.f7392g.f7379f.removeMessages(1, this.f7390e);
            this.f7389d = null;
            this.f7391f = componentName;
            for (ServiceConnection serviceConnection : this.f7386a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f7387b = 2;
        }
    }
}
