package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.github.mikephil.charting.BuildConfig;
import com.squareup.picasso.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* access modifiers changed from: package-private */
/* compiled from: Dispatcher */
public class i {

    /* renamed from: a  reason: collision with root package name */
    final b f8697a;

    /* renamed from: b  reason: collision with root package name */
    final Context f8698b;

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f8699c;

    /* renamed from: d  reason: collision with root package name */
    final j f8700d;

    /* renamed from: e  reason: collision with root package name */
    final Map<String, c> f8701e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    final Map<Object, a> f8702f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<Object, a> f8703g = new WeakHashMap();

    /* renamed from: h  reason: collision with root package name */
    final Set<Object> f8704h = new LinkedHashSet();

    /* renamed from: i  reason: collision with root package name */
    final Handler f8705i;

    /* renamed from: j  reason: collision with root package name */
    final Handler f8706j;

    /* renamed from: k  reason: collision with root package name */
    final d f8707k;
    final a0 l;
    final List<c> m;
    final c n;
    final boolean o;
    boolean p;

    /* compiled from: Dispatcher */
    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final i f8708a;

        /* renamed from: com.squareup.picasso.i$a$a  reason: collision with other inner class name */
        /* compiled from: Dispatcher */
        class RunnableC0177a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Message f8709b;

            RunnableC0177a(a aVar, Message message) {
                this.f8709b = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f8709b.what);
            }
        }

        a(Looper looper, i iVar) {
            super(looper);
            this.f8708a = iVar;
        }

        public void handleMessage(Message message) {
            boolean z = false;
            switch (message.what) {
                case 1:
                    this.f8708a.v((a) message.obj);
                    return;
                case 2:
                    this.f8708a.o((a) message.obj);
                    return;
                case 3:
                case 8:
                default:
                    t.p.post(new RunnableC0177a(this, message));
                    return;
                case 4:
                    this.f8708a.p((c) message.obj);
                    return;
                case 5:
                    this.f8708a.u((c) message.obj);
                    return;
                case 6:
                    this.f8708a.q((c) message.obj, false);
                    return;
                case 7:
                    this.f8708a.n();
                    return;
                case 9:
                    this.f8708a.r((NetworkInfo) message.obj);
                    return;
                case 10:
                    i iVar = this.f8708a;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    iVar.m(z);
                    return;
                case 11:
                    this.f8708a.s(message.obj);
                    return;
                case 12:
                    this.f8708a.t(message.obj);
                    return;
            }
        }
    }

    /* compiled from: Dispatcher */
    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* compiled from: Dispatcher */
    static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final i f8710a;

        c(i iVar) {
            this.f8710a = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f8710a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f8710a.f8698b.registerReceiver(this, intentFilter);
        }

        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f8710a.b(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f8710a.f(((ConnectivityManager) d0.n(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    i(Context context, ExecutorService executorService, Handler handler, j jVar, d dVar, a0 a0Var) {
        b bVar = new b();
        this.f8697a = bVar;
        bVar.start();
        d0.h(bVar.getLooper());
        this.f8698b = context;
        this.f8699c = executorService;
        this.f8705i = new a(bVar.getLooper(), this);
        this.f8700d = jVar;
        this.f8706j = handler;
        this.f8707k = dVar;
        this.l = a0Var;
        this.m = new ArrayList(4);
        this.p = d0.p(context);
        this.o = d0.o(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar = new c(this);
        this.n = cVar;
        cVar.a();
    }

    private void a(c cVar) {
        if (!cVar.u()) {
            Bitmap bitmap = cVar.n;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.m.add(cVar);
            if (!this.f8705i.hasMessages(7)) {
                this.f8705i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void i() {
        if (!this.f8702f.isEmpty()) {
            Iterator<a> it = this.f8702f.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                it.remove();
                if (next.g().n) {
                    d0.s("Dispatcher", "replaying", next.i().d());
                }
                w(next, false);
            }
        }
    }

    private void j(List<c> list) {
        if (!(list == null || list.isEmpty() || !list.get(0).q().n)) {
            StringBuilder sb = new StringBuilder();
            for (c cVar : list) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(d0.j(cVar));
            }
            d0.s("Dispatcher", "delivered", sb.toString());
        }
    }

    private void k(a aVar) {
        Object k2 = aVar.k();
        if (k2 != null) {
            aVar.f8643k = true;
            this.f8702f.put(k2, aVar);
        }
    }

    private void l(c cVar) {
        a h2 = cVar.h();
        if (h2 != null) {
            k(h2);
        }
        List<a> i2 = cVar.i();
        if (i2 != null) {
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                k(i2.get(i3));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        Handler handler = this.f8705i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* access modifiers changed from: package-private */
    public void c(a aVar) {
        Handler handler = this.f8705i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar) {
        Handler handler = this.f8705i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    /* access modifiers changed from: package-private */
    public void e(c cVar) {
        Handler handler = this.f8705i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: package-private */
    public void f(NetworkInfo networkInfo) {
        Handler handler = this.f8705i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* access modifiers changed from: package-private */
    public void g(c cVar) {
        Handler handler = this.f8705i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500);
    }

    /* access modifiers changed from: package-private */
    public void h(a aVar) {
        Handler handler = this.f8705i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z) {
        this.p = z;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.f8706j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void o(a aVar) {
        String d2 = aVar.d();
        c cVar = this.f8701e.get(d2);
        if (cVar != null) {
            cVar.f(aVar);
            if (cVar.c()) {
                this.f8701e.remove(d2);
                if (aVar.g().n) {
                    d0.s("Dispatcher", "canceled", aVar.i().d());
                }
            }
        }
        if (this.f8704h.contains(aVar.j())) {
            this.f8703g.remove(aVar.k());
            if (aVar.g().n) {
                d0.t("Dispatcher", "canceled", aVar.i().d(), "because paused request got canceled");
            }
        }
        a remove = this.f8702f.remove(aVar.k());
        if (remove != null && remove.g().n) {
            d0.t("Dispatcher", "canceled", remove.i().d(), "from replaying");
        }
    }

    /* access modifiers changed from: package-private */
    public void p(c cVar) {
        if (p.c(cVar.p())) {
            this.f8707k.b(cVar.n(), cVar.s());
        }
        this.f8701e.remove(cVar.n());
        a(cVar);
        if (cVar.q().n) {
            d0.t("Dispatcher", "batched", d0.j(cVar), "for completion");
        }
    }

    /* access modifiers changed from: package-private */
    public void q(c cVar, boolean z) {
        if (cVar.q().n) {
            String j2 = d0.j(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : BuildConfig.FLAVOR);
            d0.t("Dispatcher", "batched", j2, sb.toString());
        }
        this.f8701e.remove(cVar.n());
        a(cVar);
    }

    /* access modifiers changed from: package-private */
    public void r(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f8699c;
        if (executorService instanceof v) {
            ((v) executorService).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Object obj) {
        if (this.f8704h.add(obj)) {
            Iterator<c> it = this.f8701e.values().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean z = next.q().n;
                a h2 = next.h();
                List<a> i2 = next.i();
                boolean z2 = i2 != null && !i2.isEmpty();
                if (h2 != null || z2) {
                    if (h2 != null && h2.j().equals(obj)) {
                        next.f(h2);
                        this.f8703g.put(h2.k(), h2);
                        if (z) {
                            d0.t("Dispatcher", "paused", h2.f8634b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = i2.size() - 1; size >= 0; size--) {
                            a aVar = i2.get(size);
                            if (aVar.j().equals(obj)) {
                                next.f(aVar);
                                this.f8703g.put(aVar.k(), aVar);
                                if (z) {
                                    d0.t("Dispatcher", "paused", aVar.f8634b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.c()) {
                        it.remove();
                        if (z) {
                            d0.t("Dispatcher", "canceled", d0.j(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Object obj) {
        if (this.f8704h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<a> it = this.f8703g.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.j().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.f8706j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public void u(c cVar) {
        if (!cVar.u()) {
            boolean z = false;
            if (this.f8699c.isShutdown()) {
                q(cVar, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.o) {
                networkInfo = ((ConnectivityManager) d0.n(this.f8698b, "connectivity")).getActiveNetworkInfo();
            }
            if (cVar.w(this.p, networkInfo)) {
                if (cVar.q().n) {
                    d0.s("Dispatcher", "retrying", d0.j(cVar));
                }
                if (cVar.k() instanceof r.a) {
                    cVar.f8681j |= q.NO_CACHE.f8737b;
                }
                cVar.o = this.f8699c.submit(cVar);
                return;
            }
            if (this.o && cVar.x()) {
                z = true;
            }
            q(cVar, z);
            if (z) {
                l(cVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(a aVar) {
        w(aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void w(a aVar, boolean z) {
        if (this.f8704h.contains(aVar.j())) {
            this.f8703g.put(aVar.k(), aVar);
            if (aVar.g().n) {
                String d2 = aVar.f8634b.d();
                d0.t("Dispatcher", "paused", d2, "because tag '" + aVar.j() + "' is paused");
                return;
            }
            return;
        }
        c cVar = this.f8701e.get(aVar.d());
        if (cVar != null) {
            cVar.b(aVar);
        } else if (!this.f8699c.isShutdown()) {
            c g2 = c.g(aVar.g(), this, this.f8707k, this.l, aVar);
            g2.o = this.f8699c.submit(g2);
            this.f8701e.put(aVar.d(), g2);
            if (z) {
                this.f8702f.remove(aVar.k());
            }
            if (aVar.g().n) {
                d0.s("Dispatcher", "enqueued", aVar.f8634b.d());
            }
        } else if (aVar.g().n) {
            d0.t("Dispatcher", "ignored", aVar.f8634b.d(), "because shut down");
        }
    }
}
