package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: f  reason: collision with root package name */
    private static final c f7173f = new c();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f7174b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f7175c = new AtomicBoolean();
    @GuardedBy("sInstance")

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f7176d = new ArrayList<>();
    @GuardedBy("sInstance")

    /* renamed from: e  reason: collision with root package name */
    private boolean f7177e = false;

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public interface a {
        void a(boolean z);
    }

    private c() {
    }

    @RecentlyNonNull
    public static c b() {
        return f7173f;
    }

    public static void c(@RecentlyNonNull Application application) {
        c cVar = f7173f;
        synchronized (cVar) {
            if (!cVar.f7177e) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f7177e = true;
            }
        }
    }

    private final void f(boolean z) {
        synchronized (f7173f) {
            ArrayList<a> arrayList = this.f7176d;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                a aVar = arrayList.get(i2);
                i2++;
                aVar.a(z);
            }
        }
    }

    public final void a(@RecentlyNonNull a aVar) {
        synchronized (f7173f) {
            this.f7176d.add(aVar);
        }
    }

    public final boolean d() {
        return this.f7174b.get();
    }

    @TargetApi(16)
    public final boolean e(boolean z) {
        if (!this.f7175c.get()) {
            if (!g.a()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f7175c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f7174b.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(@RecentlyNonNull Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f7174b.compareAndSet(true, false);
        this.f7175c.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean compareAndSet = this.f7174b.compareAndSet(true, false);
        this.f7175c.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f7174b.compareAndSet(false, true)) {
            this.f7175c.set(true);
            f(true);
        }
    }
}
