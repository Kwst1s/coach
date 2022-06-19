package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RecentlyNonNull;
import c.e.a.a.b.a.e;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class BasePendingResult<R extends h> extends f<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7153a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final a<R> f7154b = new a<>(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f7155c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<f.a> f7156d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private i<? super R> f7157e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<k0> f7158f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    private R f7159g;

    /* renamed from: h  reason: collision with root package name */
    private Status f7160h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f7161i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7162j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7163k;
    @KeepName
    private b mResultGuardian;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class a<R extends h> extends e {
        public a(@RecentlyNonNull Looper looper) {
            super(looper);
        }

        public final void a(@RecentlyNonNull i<? super R> iVar, @RecentlyNonNull R r) {
            BasePendingResult.h(iVar);
            n.f(iVar);
            sendMessage(obtainMessage(1, new Pair(iVar, r)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.common.api.i */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(@RecentlyNonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Pair pair = (Pair) message.obj;
                i iVar = (i) pair.first;
                h hVar = (h) pair.second;
                try {
                    iVar.a(hVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.g(hVar);
                    throw e2;
                }
            } else if (i2 != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).b(Status.f7129h);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class b {
        private b() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            BasePendingResult.g(BasePendingResult.this.f7159g);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, q0 q0Var) {
            this();
        }
    }

    static {
        new q0();
    }

    @Deprecated
    BasePendingResult() {
        new WeakReference(null);
    }

    public static void g(h hVar) {
        if (hVar instanceof g) {
            try {
                ((g) hVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(hVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <R extends h> i<R> h(i<R> iVar) {
        return iVar;
    }

    private final void i(R r) {
        this.f7159g = r;
        this.f7160h = r.g();
        this.f7155c.countDown();
        if (this.f7162j) {
            this.f7157e = null;
        } else {
            i<? super R> iVar = this.f7157e;
            if (iVar != null) {
                this.f7154b.removeMessages(2);
                this.f7154b.a(iVar, j());
            } else if (this.f7159g instanceof g) {
                this.mResultGuardian = new b(this, null);
            }
        }
        ArrayList<f.a> arrayList = this.f7156d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            f.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f7160h);
        }
        this.f7156d.clear();
    }

    private final R j() {
        R r;
        synchronized (this.f7153a) {
            n.i(!this.f7161i, "Result has already been consumed.");
            n.i(c(), "Result is not ready.");
            r = this.f7159g;
            this.f7159g = null;
            this.f7157e = null;
            this.f7161i = true;
        }
        k0 andSet = this.f7158f.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        n.f(r);
        return r;
    }

    /* access modifiers changed from: protected */
    public abstract R a(@RecentlyNonNull Status status);

    @Deprecated
    public final void b(@RecentlyNonNull Status status) {
        synchronized (this.f7153a) {
            if (!c()) {
                d(a(status));
                this.f7163k = true;
            }
        }
    }

    public final boolean c() {
        return this.f7155c.getCount() == 0;
    }

    public final void d(@RecentlyNonNull R r) {
        synchronized (this.f7153a) {
            if (this.f7163k || this.f7162j) {
                g(r);
                return;
            }
            c();
            boolean z = true;
            n.i(!c(), "Results have already been set");
            if (this.f7161i) {
                z = false;
            }
            n.i(z, "Result has already been consumed");
            i(r);
        }
    }
}
