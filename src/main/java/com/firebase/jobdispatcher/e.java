package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import b.e.g;
import com.firebase.jobdispatcher.l;
import com.firebase.jobdispatcher.q;

/* compiled from: ExecutionDelegator */
class e {

    /* renamed from: e  reason: collision with root package name */
    private static final g<String, s> f4604e = new g<>();

    /* renamed from: a  reason: collision with root package name */
    private final l f4605a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Context f4606b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4607c;

    /* renamed from: d  reason: collision with root package name */
    private final b f4608d;

    /* compiled from: ExecutionDelegator */
    class a extends l.a {
        a() {
        }

        @Override // com.firebase.jobdispatcher.l
        public void M(Bundle bundle, int i2) {
            q.b c2 = GooglePlayReceiver.d().c(bundle);
            if (c2 == null) {
                Log.wtf("FJD.ExternalReceiver", "jobFinished: unknown invocation provided");
            } else {
                e.this.c(c2.l(), i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ExecutionDelegator */
    public interface b {
        void a(q qVar, int i2);
    }

    e(Context context, b bVar, b bVar2) {
        this.f4606b = context;
        this.f4607c = bVar;
        this.f4608d = bVar2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(q qVar, int i2) {
        s sVar;
        g<String, s> gVar = f4604e;
        synchronized (gVar) {
            sVar = gVar.get(qVar.i());
        }
        if (sVar != null) {
            sVar.c(qVar);
            if (sVar.i()) {
                synchronized (gVar) {
                    gVar.remove(qVar.i());
                }
            }
        }
        this.f4607c.a(qVar, i2);
    }

    static void d(q qVar, boolean z) {
        s sVar;
        g<String, s> gVar = f4604e;
        synchronized (gVar) {
            sVar = gVar.get(qVar.i());
        }
        if (sVar != null) {
            sVar.d(qVar, z);
            if (sVar.i()) {
                synchronized (gVar) {
                    gVar.remove(qVar.i());
                }
            }
        }
    }

    private boolean e(q qVar, s sVar) {
        try {
            return this.f4606b.bindService(new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE").setClassName(this.f4606b, qVar.i()), sVar, 1);
        } catch (SecurityException e2) {
            Log.e("FJD.ExternalReceiver", "Failed to bind to " + qVar.i() + ": " + e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(q qVar) {
        if (qVar != null) {
            if (!this.f4608d.a(qVar)) {
                if (Log.isLoggable("FJD.ExternalReceiver", 3)) {
                    Log.d("FJD.ExternalReceiver", "Not executing job because constraints still unmet. Job: " + qVar);
                }
                this.f4607c.a(qVar, 1);
                return;
            }
            if (Log.isLoggable("FJD.ExternalReceiver", 3)) {
                Log.d("FJD.ExternalReceiver", "Proceeding to execute job because constraints met. Job: " + qVar);
            }
            g<String, s> gVar = f4604e;
            synchronized (gVar) {
                s sVar = gVar.get(qVar.i());
                if (sVar != null) {
                    sVar.f(qVar);
                    return;
                }
                s sVar2 = new s(this.f4605a, this.f4606b);
                gVar.put(qVar.i(), sVar2);
                sVar2.f(qVar);
                if (!e(qVar, sVar2)) {
                    Log.e("FJD.ExternalReceiver", "Unable to bind to " + qVar.i());
                    sVar2.h();
                }
            }
        }
    }
}
