package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.e;
import androidx.lifecycle.r;

/* compiled from: ProcessLifecycleOwner */
public class q implements i {

    /* renamed from: j  reason: collision with root package name */
    private static final q f1481j = new q();

    /* renamed from: b  reason: collision with root package name */
    private int f1482b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1483c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1484d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1485e = true;

    /* renamed from: f  reason: collision with root package name */
    private Handler f1486f;

    /* renamed from: g  reason: collision with root package name */
    private final j f1487g = new j(this);

    /* renamed from: h  reason: collision with root package name */
    private Runnable f1488h = new a();

    /* renamed from: i  reason: collision with root package name */
    r.a f1489i = new b();

    /* compiled from: ProcessLifecycleOwner */
    class a implements Runnable {
        a() {
        }

        public void run() {
            q.this.i();
            q.this.j();
        }
    }

    /* compiled from: ProcessLifecycleOwner */
    class b implements r.a {
        b() {
        }

        @Override // androidx.lifecycle.r.a
        public void a() {
            q.this.d();
        }

        @Override // androidx.lifecycle.r.a
        public void b() {
        }

        @Override // androidx.lifecycle.r.a
        public void c() {
            q.this.b();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ProcessLifecycleOwner */
    public class c extends b {

        /* compiled from: ProcessLifecycleOwner */
        class a extends b {
            a() {
            }

            public void onActivityPostResumed(Activity activity) {
                q.this.b();
            }

            public void onActivityPostStarted(Activity activity) {
                q.this.d();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.b
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                r.f(activity).h(q.this.f1489i);
            }
        }

        @Override // androidx.lifecycle.b
        public void onActivityPaused(Activity activity) {
            q.this.a();
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.b
        public void onActivityStopped(Activity activity) {
            q.this.g();
        }
    }

    private q() {
    }

    public static i k() {
        return f1481j;
    }

    static void l(Context context) {
        f1481j.h(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.f1483c - 1;
        this.f1483c = i2;
        if (i2 == 0) {
            this.f1486f.postDelayed(this.f1488h, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2 = this.f1483c + 1;
        this.f1483c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.f1484d) {
            this.f1487g.i(e.a.ON_RESUME);
            this.f1484d = false;
            return;
        }
        this.f1486f.removeCallbacks(this.f1488h);
    }

    @Override // androidx.lifecycle.i
    public e c() {
        return this.f1487g;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int i2 = this.f1482b + 1;
        this.f1482b = i2;
        if (i2 == 1 && this.f1485e) {
            this.f1487g.i(e.a.ON_START);
            this.f1485e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f1482b--;
        j();
    }

    /* access modifiers changed from: package-private */
    public void h(Context context) {
        this.f1486f = new Handler();
        this.f1487g.i(e.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.f1483c == 0) {
            this.f1484d = true;
            this.f1487g.i(e.a.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.f1482b == 0 && this.f1484d) {
            this.f1487g.i(e.a.ON_STOP);
            this.f1485e = true;
        }
    }
}
