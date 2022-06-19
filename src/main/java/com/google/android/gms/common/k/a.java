package com.google.android.gms.common.k;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p0;
import com.google.android.gms.common.util.b;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f7423b = new Object();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f7424c;

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<ServiceConnection, ServiceConnection> f7425a = new ConcurrentHashMap<>();

    private a() {
    }

    @RecentlyNonNull
    public static a a() {
        if (f7424c == null) {
            synchronized (f7423b) {
                if (f7424c == null) {
                    f7424c = new a();
                }
            }
        }
        a aVar = f7424c;
        n.f(aVar);
        return aVar;
    }

    @SuppressLint({"UntrackedBindService"})
    private final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z) {
        boolean z2;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z2 = false;
        } else {
            z2 = b.a(context, component.getPackageName());
        }
        if (z2) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        } else if (!e(serviceConnection)) {
            return context.bindService(intent, serviceConnection, i2);
        } else {
            ServiceConnection putIfAbsent = this.f7425a.putIfAbsent(serviceConnection, serviceConnection);
            if (!(putIfAbsent == null || serviceConnection == putIfAbsent)) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                boolean bindService = context.bindService(intent, serviceConnection, i2);
                return !bindService ? bindService : bindService;
            } finally {
                this.f7425a.remove(serviceConnection, serviceConnection);
            }
        }
    }

    private static boolean e(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof p0);
    }

    @SuppressLint({"UntrackedBindService"})
    public void b(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        if (!e(serviceConnection) || !this.f7425a.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService(this.f7425a.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
                }
            } finally {
                this.f7425a.remove(serviceConnection);
            }
        }
    }

    public final boolean c(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, int i2) {
        return d(context, str, intent, serviceConnection, i2, true);
    }
}
