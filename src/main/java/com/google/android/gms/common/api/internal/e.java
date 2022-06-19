package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.common.util.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class e implements Handler.Callback {
    @RecentlyNonNull
    public static final Status s = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status t = new Status(4, "The user must be signed in to make this API call.");
    private static final Object u = new Object();
    @GuardedBy("lock")
    private static e v;

    /* renamed from: b  reason: collision with root package name */
    private long f7182b = 5000;

    /* renamed from: c  reason: collision with root package name */
    private long f7183c = 120000;

    /* renamed from: d  reason: collision with root package name */
    private long f7184d = 10000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7185e = false;

    /* renamed from: f  reason: collision with root package name */
    private r f7186f;

    /* renamed from: g  reason: collision with root package name */
    private s f7187g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f7188h;

    /* renamed from: i  reason: collision with root package name */
    private final d f7189i;

    /* renamed from: j  reason: collision with root package name */
    private final z f7190j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f7191k = new AtomicInteger(1);
    private final AtomicInteger l = new AtomicInteger(0);
    private final Map<b<?>, a<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")
    private t0 n;
    @GuardedBy("lock")
    private final Set<b<?>> o = new b.e.b();
    private final Set<b<?>> p = new b.e.b();
    @NotOnlyInitialized
    private final Handler q;
    private volatile boolean r = true;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public class a<O extends a.d> implements com.google.android.gms.common.api.d, com.google.android.gms.common.api.e {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<p> f7192a = new LinkedList();
        @NotOnlyInitialized

        /* renamed from: b  reason: collision with root package name */
        private final a.f f7193b;

        /* renamed from: c  reason: collision with root package name */
        private final b<O> f7194c;

        /* renamed from: d  reason: collision with root package name */
        private final r0 f7195d;

        /* renamed from: e  reason: collision with root package name */
        private final Set<o0> f7196e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        private final Map<h<?>, c0> f7197f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        private final int f7198g;

        /* renamed from: h  reason: collision with root package name */
        private final e0 f7199h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f7200i;

        /* renamed from: j  reason: collision with root package name */
        private final List<b> f7201j = new ArrayList();

        /* renamed from: k  reason: collision with root package name */
        private com.google.android.gms.common.a f7202k = null;
        private int l = 0;

        public a(com.google.android.gms.common.api.c<O> cVar) {
            a.f f2 = cVar.f(e.this.q.getLooper(), this);
            this.f7193b = f2;
            this.f7194c = cVar.c();
            this.f7195d = new r0();
            this.f7198g = cVar.e();
            if (f2.o()) {
                this.f7199h = cVar.g(e.this.f7188h, e.this.q);
            } else {
                this.f7199h = null;
            }
        }

        private final void B(com.google.android.gms.common.a aVar) {
            for (o0 o0Var : this.f7196e) {
                String str = null;
                if (m.a(aVar, com.google.android.gms.common.a.f7118f)) {
                    str = this.f7193b.j();
                }
                o0Var.b(this.f7194c, aVar, str);
            }
            this.f7196e.clear();
        }

        private final void C(p pVar) {
            pVar.d(this.f7195d, L());
            try {
                pVar.c(this);
            } catch (DeadObjectException unused) {
                e(1);
                this.f7193b.e("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.f7193b.getClass().getName()), th);
            }
        }

        private final Status D(com.google.android.gms.common.a aVar) {
            return e.m(this.f7194c, aVar);
        }

        /* access modifiers changed from: private */
        public final void P() {
            E();
            B(com.google.android.gms.common.a.f7118f);
            R();
            Iterator<c0> it = this.f7197f.values().iterator();
            while (it.hasNext()) {
                c0 next = it.next();
                if (a(next.f7178a.b()) != null) {
                    it.remove();
                } else {
                    try {
                        next.f7178a.c(this.f7193b, new com.google.android.gms.tasks.c<>());
                    } catch (DeadObjectException unused) {
                        e(3);
                        this.f7193b.e("DeadObjectException thrown while calling register listener method.");
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            Q();
            S();
        }

        private final void Q() {
            ArrayList arrayList = new ArrayList(this.f7192a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                p pVar = (p) obj;
                if (!this.f7193b.b()) {
                    return;
                }
                if (y(pVar)) {
                    this.f7192a.remove(pVar);
                }
            }
        }

        private final void R() {
            if (this.f7200i) {
                e.this.q.removeMessages(11, this.f7194c);
                e.this.q.removeMessages(9, this.f7194c);
                this.f7200i = false;
            }
        }

        private final void S() {
            e.this.q.removeMessages(12, this.f7194c);
            e.this.q.sendMessageDelayed(e.this.q.obtainMessage(12, this.f7194c), e.this.f7184d);
        }

        private final com.google.android.gms.common.c a(com.google.android.gms.common.c[] cVarArr) {
            if (!(cVarArr == null || cVarArr.length == 0)) {
                com.google.android.gms.common.c[] i2 = this.f7193b.i();
                if (i2 == null) {
                    i2 = new com.google.android.gms.common.c[0];
                }
                b.e.a aVar = new b.e.a(i2.length);
                for (com.google.android.gms.common.c cVar : i2) {
                    aVar.put(cVar.k(), Long.valueOf(cVar.l()));
                }
                for (com.google.android.gms.common.c cVar2 : cVarArr) {
                    Long l2 = (Long) aVar.get(cVar2.k());
                    if (l2 == null || l2.longValue() < cVar2.l()) {
                        return cVar2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final void d(int i2) {
            E();
            this.f7200i = true;
            this.f7195d.a(i2, this.f7193b.k());
            e.this.q.sendMessageDelayed(Message.obtain(e.this.q, 9, this.f7194c), e.this.f7182b);
            e.this.q.sendMessageDelayed(Message.obtain(e.this.q, 11, this.f7194c), e.this.f7183c);
            e.this.f7190j.c();
            for (c0 c0Var : this.f7197f.values()) {
                c0Var.f7180c.run();
            }
        }

        private final void g(com.google.android.gms.common.a aVar, Exception exc) {
            n.c(e.this.q);
            e0 e0Var = this.f7199h;
            if (e0Var != null) {
                e0Var.V();
            }
            E();
            e.this.f7190j.c();
            B(aVar);
            if (this.f7193b instanceof com.google.android.gms.common.internal.q.e) {
                e.this.f7185e = true;
                e.this.q.sendMessageDelayed(e.this.q.obtainMessage(19), 300000);
            }
            if (aVar.k() == 4) {
                h(e.t);
            } else if (this.f7192a.isEmpty()) {
                this.f7202k = aVar;
            } else if (exc != null) {
                n.c(e.this.q);
                j(null, exc, false);
            } else if (!e.this.r) {
                h(D(aVar));
            } else {
                j(D(aVar), null, true);
                if (!this.f7192a.isEmpty() && !x(aVar) && !e.this.i(aVar, this.f7198g)) {
                    if (aVar.k() == 18) {
                        this.f7200i = true;
                    }
                    if (this.f7200i) {
                        e.this.q.sendMessageDelayed(Message.obtain(e.this.q, 9, this.f7194c), e.this.f7182b);
                    } else {
                        h(D(aVar));
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void h(Status status) {
            n.c(e.this.q);
            j(status, null, false);
        }

        private final void j(Status status, Exception exc, boolean z) {
            n.c(e.this.q);
            boolean z2 = true;
            boolean z3 = status == null;
            if (exc != null) {
                z2 = false;
            }
            if (z3 != z2) {
                Iterator<p> it = this.f7192a.iterator();
                while (it.hasNext()) {
                    p next = it.next();
                    if (!z || next.f7251a == 2) {
                        if (status != null) {
                            next.b(status);
                        } else {
                            next.e(exc);
                        }
                        it.remove();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Status XOR exception should be null");
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void o(b bVar) {
            if (!this.f7201j.contains(bVar) || this.f7200i) {
                return;
            }
            if (!this.f7193b.b()) {
                J();
            } else {
                Q();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final boolean s(boolean z) {
            n.c(e.this.q);
            if (!this.f7193b.b() || this.f7197f.size() != 0) {
                return false;
            }
            if (this.f7195d.d()) {
                if (z) {
                    S();
                }
                return false;
            }
            this.f7193b.e("Timing out service connection.");
            return true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void w(b bVar) {
            com.google.android.gms.common.c[] g2;
            if (this.f7201j.remove(bVar)) {
                e.this.q.removeMessages(15, bVar);
                e.this.q.removeMessages(16, bVar);
                com.google.android.gms.common.c cVar = bVar.f7204b;
                ArrayList arrayList = new ArrayList(this.f7192a.size());
                for (p pVar : this.f7192a) {
                    if ((pVar instanceof l0) && (g2 = ((l0) pVar).g(this)) != null && com.google.android.gms.common.util.a.b(g2, cVar)) {
                        arrayList.add(pVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    p pVar2 = (p) obj;
                    this.f7192a.remove(pVar2);
                    pVar2.e(new UnsupportedApiCallException(cVar));
                }
            }
        }

        private final boolean x(com.google.android.gms.common.a aVar) {
            synchronized (e.u) {
                if (e.this.n != null) {
                    if (e.this.o.contains(this.f7194c)) {
                        e.this.n.a(aVar, this.f7198g);
                        throw null;
                    }
                }
            }
            return false;
        }

        private final boolean y(p pVar) {
            if (!(pVar instanceof l0)) {
                C(pVar);
                return true;
            }
            l0 l0Var = (l0) pVar;
            com.google.android.gms.common.c a2 = a(l0Var.g(this));
            if (a2 == null) {
                C(pVar);
                return true;
            }
            String name = this.f7193b.getClass().getName();
            String k2 = a2.k();
            long l2 = a2.l();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(k2).length());
            sb.append(name);
            sb.append(" could not execute call because it requires feature (");
            sb.append(k2);
            sb.append(", ");
            sb.append(l2);
            sb.append(").");
            Log.w("GoogleApiManager", sb.toString());
            if (!e.this.r || !l0Var.h(this)) {
                l0Var.e(new UnsupportedApiCallException(a2));
                return true;
            }
            b bVar = new b(this.f7194c, a2, null);
            int indexOf = this.f7201j.indexOf(bVar);
            if (indexOf >= 0) {
                b bVar2 = this.f7201j.get(indexOf);
                e.this.q.removeMessages(15, bVar2);
                e.this.q.sendMessageDelayed(Message.obtain(e.this.q, 15, bVar2), e.this.f7182b);
                return false;
            }
            this.f7201j.add(bVar);
            e.this.q.sendMessageDelayed(Message.obtain(e.this.q, 15, bVar), e.this.f7182b);
            e.this.q.sendMessageDelayed(Message.obtain(e.this.q, 16, bVar), e.this.f7183c);
            com.google.android.gms.common.a aVar = new com.google.android.gms.common.a(2, null);
            if (x(aVar)) {
                return false;
            }
            e.this.i(aVar, this.f7198g);
            return false;
        }

        public final Map<h<?>, c0> A() {
            return this.f7197f;
        }

        public final void E() {
            n.c(e.this.q);
            this.f7202k = null;
        }

        public final com.google.android.gms.common.a F() {
            n.c(e.this.q);
            return this.f7202k;
        }

        public final void G() {
            n.c(e.this.q);
            if (this.f7200i) {
                J();
            }
        }

        public final void H() {
            Status status;
            n.c(e.this.q);
            if (this.f7200i) {
                R();
                if (e.this.f7189i.f(e.this.f7188h) == 18) {
                    status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
                } else {
                    status = new Status(22, "API failed to connect while resuming due to an unknown error.");
                }
                h(status);
                this.f7193b.e("Timing out connection while resuming.");
            }
        }

        public final boolean I() {
            return s(true);
        }

        public final void J() {
            n.c(e.this.q);
            if (!this.f7193b.b() && !this.f7193b.h()) {
                try {
                    int b2 = e.this.f7190j.b(e.this.f7188h, this.f7193b);
                    if (b2 != 0) {
                        com.google.android.gms.common.a aVar = new com.google.android.gms.common.a(b2, null);
                        String name = this.f7193b.getClass().getName();
                        String valueOf = String.valueOf(aVar);
                        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 35 + String.valueOf(valueOf).length());
                        sb.append("The service for ");
                        sb.append(name);
                        sb.append(" is not available: ");
                        sb.append(valueOf);
                        Log.w("GoogleApiManager", sb.toString());
                        i(aVar);
                        return;
                    }
                    e eVar = e.this;
                    a.f fVar = this.f7193b;
                    c cVar = new c(fVar, this.f7194c);
                    if (fVar.o()) {
                        e0 e0Var = this.f7199h;
                        n.f(e0Var);
                        e0Var.X(cVar);
                    }
                    try {
                        this.f7193b.m(cVar);
                    } catch (SecurityException e2) {
                        g(new com.google.android.gms.common.a(10), e2);
                    }
                } catch (IllegalStateException e3) {
                    g(new com.google.android.gms.common.a(10), e3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean K() {
            return this.f7193b.b();
        }

        public final boolean L() {
            return this.f7193b.o();
        }

        public final int M() {
            return this.f7198g;
        }

        /* access modifiers changed from: package-private */
        public final int N() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public final void O() {
            this.l++;
        }

        public final void c() {
            n.c(e.this.q);
            h(e.s);
            this.f7195d.f();
            for (h hVar : (h[]) this.f7197f.keySet().toArray(new h[0])) {
                p(new m0(hVar, new com.google.android.gms.tasks.c()));
            }
            B(new com.google.android.gms.common.a(4));
            if (this.f7193b.b()) {
                this.f7193b.a(new u(this));
            }
        }

        @Override // com.google.android.gms.common.api.internal.d
        public final void e(int i2) {
            if (Looper.myLooper() == e.this.q.getLooper()) {
                d(i2);
            } else {
                e.this.q.post(new s(this, i2));
            }
        }

        public final void f(com.google.android.gms.common.a aVar) {
            n.c(e.this.q);
            a.f fVar = this.f7193b;
            String name = fVar.getClass().getName();
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 25 + String.valueOf(valueOf).length());
            sb.append("onSignInFailed for ");
            sb.append(name);
            sb.append(" with ");
            sb.append(valueOf);
            fVar.e(sb.toString());
            i(aVar);
        }

        @Override // com.google.android.gms.common.api.internal.j
        public final void i(com.google.android.gms.common.a aVar) {
            g(aVar, null);
        }

        @Override // com.google.android.gms.common.api.internal.d
        public final void k(Bundle bundle) {
            if (Looper.myLooper() == e.this.q.getLooper()) {
                P();
            } else {
                e.this.q.post(new t(this));
            }
        }

        public final void p(p pVar) {
            n.c(e.this.q);
            if (!this.f7193b.b()) {
                this.f7192a.add(pVar);
                com.google.android.gms.common.a aVar = this.f7202k;
                if (aVar == null || !aVar.n()) {
                    J();
                } else {
                    i(this.f7202k);
                }
            } else if (y(pVar)) {
                S();
            } else {
                this.f7192a.add(pVar);
            }
        }

        public final void q(o0 o0Var) {
            n.c(e.this.q);
            this.f7196e.add(o0Var);
        }

        public final a.f t() {
            return this.f7193b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public class c implements h0, c.AbstractC0144c {

        /* renamed from: a  reason: collision with root package name */
        private final a.f f7205a;

        /* renamed from: b  reason: collision with root package name */
        private final b<?> f7206b;

        /* renamed from: c  reason: collision with root package name */
        private i f7207c = null;

        /* renamed from: d  reason: collision with root package name */
        private Set<Scope> f7208d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7209e = false;

        public c(a.f fVar, b<?> bVar) {
            this.f7205a = fVar;
            this.f7206b = bVar;
        }

        /* access modifiers changed from: private */
        public final void e() {
            i iVar;
            if (this.f7209e && (iVar = this.f7207c) != null) {
                this.f7205a.d(iVar, this.f7208d);
            }
        }

        @Override // com.google.android.gms.common.internal.c.AbstractC0144c
        public final void a(com.google.android.gms.common.a aVar) {
            e.this.q.post(new w(this, aVar));
        }

        @Override // com.google.android.gms.common.api.internal.h0
        public final void b(i iVar, Set<Scope> set) {
            if (iVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                c(new com.google.android.gms.common.a(4));
                return;
            }
            this.f7207c = iVar;
            this.f7208d = set;
            e();
        }

        @Override // com.google.android.gms.common.api.internal.h0
        public final void c(com.google.android.gms.common.a aVar) {
            a aVar2 = (a) e.this.m.get(this.f7206b);
            if (aVar2 != null) {
                aVar2.f(aVar);
            }
        }
    }

    private e(Context context, Looper looper, d dVar) {
        this.f7188h = context;
        c.e.a.a.b.a.e eVar = new c.e.a.a.b.a.e(looper, this);
        this.q = eVar;
        this.f7189i = dVar;
        this.f7190j = new z(dVar);
        if (f.a(context)) {
            this.r = false;
        }
        eVar.sendMessage(eVar.obtainMessage(6));
    }

    @RecentlyNonNull
    public static e d(@RecentlyNonNull Context context) {
        e eVar;
        synchronized (u) {
            if (v == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                v = new e(context.getApplicationContext(), handlerThread.getLooper(), d.m());
            }
            eVar = v;
        }
        return eVar;
    }

    private final <T> void h(com.google.android.gms.tasks.c<T> cVar, int i2, com.google.android.gms.common.api.c<?> cVar2) {
        y b2;
        if (i2 != 0 && (b2 = y.b(this, i2, cVar2.c())) != null) {
            com.google.android.gms.tasks.b<T> a2 = cVar.a();
            Handler handler = this.q;
            handler.getClass();
            a2.b(q.a(handler), b2);
        }
    }

    /* access modifiers changed from: private */
    public static Status m(b<?> bVar, com.google.android.gms.common.a aVar) {
        String b2 = bVar.b();
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 63 + String.valueOf(valueOf).length());
        sb.append("API: ");
        sb.append(b2);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(aVar, sb.toString());
    }

    private final a<?> p(com.google.android.gms.common.api.c<?> cVar) {
        b<?> c2 = cVar.c();
        a<?> aVar = this.m.get(c2);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.m.put(c2, aVar);
        }
        if (aVar.L()) {
            this.p.add(c2);
        }
        aVar.J();
        return aVar;
    }

    private final void y() {
        r rVar = this.f7186f;
        if (rVar != null) {
            if (rVar.k() > 0 || s()) {
                z().h(rVar);
            }
            this.f7186f = null;
        }
    }

    private final s z() {
        if (this.f7187g == null) {
            this.f7187g = new com.google.android.gms.common.internal.q.d(this.f7188h);
        }
        return this.f7187g;
    }

    /* access modifiers changed from: package-private */
    public final a c(b<?> bVar) {
        return this.m.get(bVar);
    }

    public final void e(@RecentlyNonNull com.google.android.gms.common.api.c<?> cVar) {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final <O extends a.d, ResultT> void f(@RecentlyNonNull com.google.android.gms.common.api.c<O> cVar, int i2, @RecentlyNonNull n<a.b, ResultT> nVar, @RecentlyNonNull com.google.android.gms.tasks.c<ResultT> cVar2, @RecentlyNonNull m mVar) {
        h(cVar2, nVar.e(), cVar);
        n0 n0Var = new n0(i2, nVar, cVar2, mVar);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(4, new b0(n0Var, this.l.get(), cVar)));
    }

    /* access modifiers changed from: package-private */
    public final void g(b0 b0Var, int i2, long j2, int i3) {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(18, new x(b0Var, i2, j2, i3)));
    }

    public boolean handleMessage(@RecentlyNonNull Message message) {
        int i2 = message.what;
        long j2 = 300000;
        a<?> aVar = null;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f7184d = j2;
                this.q.removeMessages(12);
                for (b<?> bVar : this.m.keySet()) {
                    Handler handler = this.q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f7184d);
                }
                break;
            case 2:
                o0 o0Var = (o0) message.obj;
                Iterator<b<?>> it = o0Var.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        b<?> next = it.next();
                        a<?> aVar2 = this.m.get(next);
                        if (aVar2 == null) {
                            o0Var.b(next, new com.google.android.gms.common.a(13), null);
                            break;
                        } else if (aVar2.K()) {
                            o0Var.b(next, com.google.android.gms.common.a.f7118f, aVar2.t().j());
                        } else {
                            com.google.android.gms.common.a F = aVar2.F();
                            if (F != null) {
                                o0Var.b(next, F, null);
                            } else {
                                aVar2.q(o0Var);
                                aVar2.J();
                            }
                        }
                    }
                }
            case 3:
                for (a<?> aVar3 : this.m.values()) {
                    aVar3.E();
                    aVar3.J();
                }
                break;
            case 4:
            case 8:
            case 13:
                b0 b0Var = (b0) message.obj;
                a<?> aVar4 = this.m.get(b0Var.f7172c.c());
                if (aVar4 == null) {
                    aVar4 = p(b0Var.f7172c);
                }
                if (!aVar4.L() || this.l.get() == b0Var.f7171b) {
                    aVar4.p(b0Var.f7170a);
                    break;
                } else {
                    b0Var.f7170a.b(s);
                    aVar4.c();
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                com.google.android.gms.common.a aVar5 = (com.google.android.gms.common.a) message.obj;
                Iterator<a<?>> it2 = this.m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        if (next2.M() == i3) {
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    if (aVar5.k() == 13) {
                        String d2 = this.f7189i.d(aVar5.k());
                        String l2 = aVar5.l();
                        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 69 + String.valueOf(l2).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(d2);
                        sb.append(": ");
                        sb.append(l2);
                        aVar.h(new Status(17, sb.toString()));
                        break;
                    } else {
                        aVar.h(m(((a) aVar).f7194c, aVar5));
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.f7188h.getApplicationContext() instanceof Application) {
                    c.c((Application) this.f7188h.getApplicationContext());
                    c.b().a(new r(this));
                    if (!c.b().e(true)) {
                        this.f7184d = 300000;
                        break;
                    }
                }
                break;
            case 7:
                p((com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).G();
                    break;
                }
                break;
            case 10:
                for (b<?> bVar2 : this.p) {
                    a<?> remove = this.m.remove(bVar2);
                    if (remove != null) {
                        remove.c();
                    }
                }
                this.p.clear();
                break;
            case 11:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).H();
                    break;
                }
                break;
            case 12:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).I();
                    break;
                }
                break;
            case 14:
                u0 u0Var = (u0) message.obj;
                b<?> a2 = u0Var.a();
                if (!this.m.containsKey(a2)) {
                    u0Var.b().c(Boolean.FALSE);
                    break;
                } else {
                    u0Var.b().c(Boolean.valueOf(this.m.get(a2).s(false)));
                    break;
                }
            case 15:
                b bVar3 = (b) message.obj;
                if (this.m.containsKey(bVar3.f7203a)) {
                    this.m.get(bVar3.f7203a).o(bVar3);
                    break;
                }
                break;
            case 16:
                b bVar4 = (b) message.obj;
                if (this.m.containsKey(bVar4.f7203a)) {
                    this.m.get(bVar4.f7203a).w(bVar4);
                    break;
                }
                break;
            case 17:
                y();
                break;
            case 18:
                x xVar = (x) message.obj;
                if (xVar.f7269c == 0) {
                    z().h(new r(xVar.f7268b, Arrays.asList(xVar.f7267a)));
                    break;
                } else {
                    r rVar = this.f7186f;
                    if (rVar != null) {
                        List<b0> m2 = rVar.m();
                        if (this.f7186f.k() != xVar.f7268b || (m2 != null && m2.size() >= xVar.f7270d)) {
                            this.q.removeMessages(17);
                            y();
                        } else {
                            this.f7186f.l(xVar.f7267a);
                        }
                    }
                    if (this.f7186f == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(xVar.f7267a);
                        this.f7186f = new r(xVar.f7268b, arrayList);
                        Handler handler2 = this.q;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), xVar.f7269c);
                        break;
                    }
                }
                break;
            case 19:
                this.f7185e = false;
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean i(com.google.android.gms.common.a aVar, int i2) {
        return this.f7189i.u(this.f7188h, aVar, i2);
    }

    public final int k() {
        return this.f7191k.getAndIncrement();
    }

    public final void n(@RecentlyNonNull com.google.android.gms.common.a aVar, int i2) {
        if (!i(aVar, i2)) {
            Handler handler = this.q;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, aVar));
        }
    }

    public final void q() {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* access modifiers changed from: package-private */
    public final boolean s() {
        if (this.f7185e) {
            return false;
        }
        p a2 = o.b().a();
        if (a2 != null && !a2.m()) {
            return false;
        }
        int a3 = this.f7190j.a(this.f7188h, 203390000);
        if (a3 == -1 || a3 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final b<?> f7203a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.gms.common.c f7204b;

        private b(b<?> bVar, com.google.android.gms.common.c cVar) {
            this.f7203a = bVar;
            this.f7204b = cVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (!m.a(this.f7203a, bVar.f7203a) || !m.a(this.f7204b, bVar.f7204b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return m.b(this.f7203a, this.f7204b);
        }

        public final String toString() {
            m.a c2 = m.c(this);
            c2.a("key", this.f7203a);
            c2.a("feature", this.f7204b);
            return c2.toString();
        }

        /* synthetic */ b(b bVar, com.google.android.gms.common.c cVar, r rVar) {
            this(bVar, cVar);
        }
    }
}
