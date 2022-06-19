package com.bumptech.glide.m;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import com.bumptech.glide.i;
import com.bumptech.glide.r.k;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class l implements Handler.Callback {

    /* renamed from: g  reason: collision with root package name */
    private static final b f4262g = new a();

    /* renamed from: b  reason: collision with root package name */
    private volatile i f4263b;

    /* renamed from: c  reason: collision with root package name */
    final Map<FragmentManager, k> f4264c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map<m, o> f4265d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f4266e;

    /* renamed from: f  reason: collision with root package name */
    private final b f4267f;

    /* compiled from: RequestManagerRetriever */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.m.l.b
        public i a(com.bumptech.glide.b bVar, h hVar, m mVar, Context context) {
            return new i(bVar, hVar, mVar, context);
        }
    }

    /* compiled from: RequestManagerRetriever */
    public interface b {
        i a(com.bumptech.glide.b bVar, h hVar, m mVar, Context context);
    }

    public l(b bVar) {
        new b.e.a();
        new b.e.a();
        new Bundle();
        this.f4267f = bVar == null ? f4262g : bVar;
        this.f4266e = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @Deprecated
    private i c(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z) {
        k i2 = i(fragmentManager, fragment, z);
        i e2 = i2.e();
        if (e2 != null) {
            return e2;
        }
        i a2 = this.f4267f.a(com.bumptech.glide.b.c(context), i2.c(), i2.f(), context);
        i2.k(a2);
        return a2;
    }

    private i g(Context context) {
        if (this.f4263b == null) {
            synchronized (this) {
                if (this.f4263b == null) {
                    this.f4263b = this.f4267f.a(com.bumptech.glide.b.c(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f4263b;
    }

    private k i(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f4264c.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.j(fragment);
            if (z) {
                kVar.c().d();
            }
            this.f4264c.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f4266e.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    private o k(m mVar, androidx.fragment.app.Fragment fragment, boolean z) {
        o oVar = (o) mVar.Y("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f4265d.get(mVar)) == null) {
            oVar = new o();
            oVar.U1(fragment);
            if (z) {
                oVar.M1().d();
            }
            this.f4265d.put(mVar, oVar);
            u j2 = mVar.j();
            j2.f(oVar, "com.bumptech.glide.manager");
            j2.j();
            this.f4266e.obtainMessage(2, mVar).sendToTarget();
        }
        return oVar;
    }

    private static boolean l(Context context) {
        Activity b2 = b(context);
        return b2 == null || !b2.isFinishing();
    }

    private i m(Context context, m mVar, androidx.fragment.app.Fragment fragment, boolean z) {
        o k2 = k(mVar, fragment, z);
        i O1 = k2.O1();
        if (O1 != null) {
            return O1;
        }
        i a2 = this.f4267f.a(com.bumptech.glide.b.c(context), k2.M1(), k2.P1(), context);
        k2.V1(a2);
        return a2;
    }

    public i d(Activity activity) {
        if (k.o()) {
            return e(activity.getApplicationContext());
        }
        a(activity);
        return c(activity, activity.getFragmentManager(), null, l(activity));
    }

    public i e(Context context) {
        if (context != null) {
            if (k.p() && !(context instanceof Application)) {
                if (context instanceof d) {
                    return f((d) context);
                }
                if (context instanceof Activity) {
                    return d((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return e(contextWrapper.getBaseContext());
                    }
                }
            }
            return g(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public i f(d dVar) {
        if (k.o()) {
            return e(dVar.getApplicationContext());
        }
        a(dVar);
        return m(dVar, dVar.C(), null, l(dVar));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public k h(Activity activity) {
        return i(activity.getFragmentManager(), null, l(activity));
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2 = message.what;
        Object obj4 = null;
        boolean z = true;
        if (i2 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.f4264c.remove(obj3);
        } else if (i2 != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
            }
            return z;
        } else {
            obj3 = (m) message.obj;
            obj2 = this.f4265d.remove(obj3);
        }
        obj4 = obj2;
        obj = obj3;
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        return z;
    }

    /* access modifiers changed from: package-private */
    public o j(Context context, m mVar) {
        return k(mVar, null, l(context));
    }
}
