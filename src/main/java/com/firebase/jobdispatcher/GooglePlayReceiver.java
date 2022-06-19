package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.Pair;
import b.e.g;
import com.firebase.jobdispatcher.e;
import com.firebase.jobdispatcher.n;
import com.firebase.jobdispatcher.q;
import com.firebase.jobdispatcher.t;

public class GooglePlayReceiver extends Service implements e.b {

    /* renamed from: h  reason: collision with root package name */
    private static final p f4592h = new p("com.firebase.jobdispatcher.");

    /* renamed from: i  reason: collision with root package name */
    private static final g<String, g<String, o>> f4593i = new g<>(1);

    /* renamed from: b  reason: collision with root package name */
    private final f f4594b = new f();

    /* renamed from: c  reason: collision with root package name */
    Messenger f4595c;

    /* renamed from: d  reason: collision with root package name */
    d f4596d;

    /* renamed from: e  reason: collision with root package name */
    ValidationEnforcer f4597e;

    /* renamed from: f  reason: collision with root package name */
    private e f4598f;

    /* renamed from: g  reason: collision with root package name */
    private int f4599g;

    private synchronized d c() {
        if (this.f4596d == null) {
            this.f4596d = new g(getApplicationContext());
        }
        return this.f4596d;
    }

    static p d() {
        return f4592h;
    }

    private synchronized Messenger e() {
        if (this.f4595c == null) {
            this.f4595c = new Messenger(new j(Looper.getMainLooper(), this));
        }
        return this.f4595c;
    }

    private synchronized ValidationEnforcer f() {
        if (this.f4597e == null) {
            this.f4597e = new ValidationEnforcer(c().a());
        }
        return this.f4597e;
    }

    private static boolean g(r rVar, int i2) {
        if (!rVar.g() || !(rVar.b() instanceof t.a) || i2 == 1) {
            return false;
        }
        return true;
    }

    static void h(n nVar) {
        g<String, g<String, o>> gVar = f4593i;
        synchronized (gVar) {
            g<String, o> gVar2 = gVar.get(nVar.i());
            if (gVar2 != null) {
                if (gVar2.get(nVar.a()) != null) {
                    q.b bVar = new q.b();
                    bVar.s(nVar.a());
                    bVar.r(nVar.i());
                    bVar.t(nVar.b());
                    e.d(bVar.l(), false);
                }
            }
        }
    }

    private void k(q qVar) {
        n.b bVar = new n.b(f(), qVar);
        bVar.t(true);
        c().b(bVar.s());
    }

    private static void l(o oVar, int i2) {
        try {
            oVar.a(i2);
        } catch (Throwable th) {
            Log.e("FJD.GooglePlayReceiver", "Encountered error running callback: " + th.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r0.isEmpty() == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        stopSelf(r5.f4599g);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        if (r0.isEmpty() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        stopSelf(r5.f4599g);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0051, code lost:
        if (g(r6, r7) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        k(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005e, code lost:
        if (android.util.Log.isLoggable("FJD.GooglePlayReceiver", 2) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0060, code lost:
        android.util.Log.v("FJD.GooglePlayReceiver", "sending jobFinished for " + r6.a() + " = " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
        l(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008a, code lost:
        if (r0.isEmpty() == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008c, code lost:
        stopSelf(r5.f4599g);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0091, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        monitor-enter(r0);
     */
    @Override // com.firebase.jobdispatcher.e.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.firebase.jobdispatcher.q r6, int r7) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.a(com.firebase.jobdispatcher.q, int):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized e b() {
        if (this.f4598f == null) {
            this.f4598f = new e(this, this, new b(getApplicationContext()));
        }
        return this.f4598f;
    }

    /* access modifiers changed from: package-private */
    public q i(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
            return null;
        }
        Pair<o, Bundle> b2 = this.f4594b.b(extras);
        if (b2 != null) {
            return j((o) b2.first, (Bundle) b2.second);
        }
        Log.i("FJD.GooglePlayReceiver", "no callback found");
        return null;
    }

    /* access modifiers changed from: package-private */
    public q j(o oVar, Bundle bundle) {
        q d2 = f4592h.d(bundle);
        if (d2 == null) {
            Log.e("FJD.GooglePlayReceiver", "unable to decode job");
            l(oVar, 2);
            return null;
        }
        g<String, g<String, o>> gVar = f4593i;
        synchronized (gVar) {
            g<String, o> gVar2 = gVar.get(d2.i());
            if (gVar2 == null) {
                gVar2 = new g<>(1);
                gVar.put(d2.i(), gVar2);
            }
            gVar2.put(d2.a(), oVar);
        }
        return d2;
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || Build.VERSION.SDK_INT < 21 || !"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return null;
        }
        return e().getBinder();
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        try {
            super.onStartCommand(intent, i2, i3);
            if (intent == null) {
                Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
                g<String, g<String, o>> gVar = f4593i;
                synchronized (gVar) {
                    this.f4599g = i3;
                    if (gVar.isEmpty()) {
                        stopSelf(this.f4599g);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                b().b(i(intent));
                g<String, g<String, o>> gVar2 = f4593i;
                synchronized (gVar2) {
                    this.f4599g = i3;
                    if (gVar2.isEmpty()) {
                        stopSelf(this.f4599g);
                    }
                }
                return 2;
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                g<String, g<String, o>> gVar3 = f4593i;
                synchronized (gVar3) {
                    this.f4599g = i3;
                    if (gVar3.isEmpty()) {
                        stopSelf(this.f4599g);
                    }
                }
                return 2;
            } else {
                Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
                g<String, g<String, o>> gVar4 = f4593i;
                synchronized (gVar4) {
                    this.f4599g = i3;
                    if (gVar4.isEmpty()) {
                        stopSelf(this.f4599g);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            g<String, g<String, o>> gVar5 = f4593i;
            synchronized (gVar5) {
                this.f4599g = i3;
                if (gVar5.isEmpty()) {
                    stopSelf(this.f4599g);
                }
                throw th;
            }
        }
    }
}
