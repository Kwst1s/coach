package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public abstract class c<T extends IInterface> {
    private static final com.google.android.gms.common.c[] w = new com.google.android.gms.common.c[0];

    /* renamed from: a  reason: collision with root package name */
    private volatile String f7299a = null;

    /* renamed from: b  reason: collision with root package name */
    private q0 f7300b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f7301c;

    /* renamed from: d  reason: collision with root package name */
    private final h f7302d;

    /* renamed from: e  reason: collision with root package name */
    final Handler f7303e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f7304f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private final Object f7305g = new Object();
    @GuardedBy("mServiceBrokerLock")

    /* renamed from: h  reason: collision with root package name */
    private l f7306h;
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    protected AbstractC0144c f7307i;
    @GuardedBy("mLock")

    /* renamed from: j  reason: collision with root package name */
    private T f7308j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<h<?>> f7309k = new ArrayList<>();
    @GuardedBy("mLock")
    private i l;
    @GuardedBy("mLock")
    private int m = 1;
    private final a n;
    private final b o;
    private final int p;
    private final String q;
    private volatile String r;
    private com.google.android.gms.common.a s = null;
    private boolean t = false;
    private volatile h0 u = null;
    @RecentlyNonNull
    protected AtomicInteger v = new AtomicInteger(0);

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public interface a {
        void e(int i2);

        void k(Bundle bundle);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public interface b {
        void i(@RecentlyNonNull com.google.android.gms.common.a aVar);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public interface AbstractC0144c {
        void a(@RecentlyNonNull com.google.android.gms.common.a aVar);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    protected class d implements AbstractC0144c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.c.AbstractC0144c
        public void a(@RecentlyNonNull com.google.android.gms.common.a aVar) {
            if (aVar.o()) {
                c cVar = c.this;
                cVar.d(null, cVar.z());
            } else if (c.this.o != null) {
                c.this.o.i(aVar);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public interface e {
        void a();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    private abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        private final int f7311d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f7312e;

        protected f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            this.f7311d = i2;
            this.f7312e = bundle;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.c.h
        public final /* synthetic */ void a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                c.this.U(1, null);
            } else if (this.f7311d != 0) {
                c.this.U(1, null);
                Bundle bundle = this.f7312e;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                }
                f(new com.google.android.gms.common.a(this.f7311d, pendingIntent));
            } else if (!g()) {
                c.this.U(1, null);
                f(new com.google.android.gms.common.a(8, null));
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.c.h
        public final void b() {
        }

        /* access modifiers changed from: protected */
        public abstract void f(com.google.android.gms.common.a aVar);

        /* access modifiers changed from: protected */
        public abstract boolean g();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    final class g extends c.e.a.a.b.b.d {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.b();
            hVar.d();
        }

        private static boolean b(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        public final void handleMessage(Message message) {
            com.google.android.gms.common.a aVar;
            com.google.android.gms.common.a aVar2;
            if (c.this.v.get() == message.arg1) {
                int i2 = message.what;
                if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !c.this.s()) || message.what == 5)) && !c.this.h()) {
                    a(message);
                    return;
                }
                int i3 = message.what;
                PendingIntent pendingIntent = null;
                if (i3 == 4) {
                    c.this.s = new com.google.android.gms.common.a(message.arg2);
                    if (!c.this.d0() || c.this.t) {
                        if (c.this.s != null) {
                            aVar2 = c.this.s;
                        } else {
                            aVar2 = new com.google.android.gms.common.a(8);
                        }
                        c.this.f7307i.a(aVar2);
                        c.this.H(aVar2);
                        return;
                    }
                    c.this.U(3, null);
                } else if (i3 == 5) {
                    if (c.this.s != null) {
                        aVar = c.this.s;
                    } else {
                        aVar = new com.google.android.gms.common.a(8);
                    }
                    c.this.f7307i.a(aVar);
                    c.this.H(aVar);
                } else if (i3 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    com.google.android.gms.common.a aVar3 = new com.google.android.gms.common.a(message.arg2, pendingIntent);
                    c.this.f7307i.a(aVar3);
                    c.this.H(aVar3);
                } else if (i3 == 6) {
                    c.this.U(5, null);
                    if (c.this.n != null) {
                        c.this.n.e(message.arg2);
                    }
                    c.this.I(message.arg2);
                    c.this.Z(5, 1, null);
                } else if (i3 == 2 && !c.this.b()) {
                    a(message);
                } else if (b(message)) {
                    ((h) message.obj).c();
                } else {
                    int i4 = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i4);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            } else if (b(message)) {
                a(message);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public abstract class h<TListener> {

        /* renamed from: a  reason: collision with root package name */
        private TListener f7315a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7316b = false;

        public h(TListener tlistener) {
            this.f7315a = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void a(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void b();

        public final void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f7315a;
                if (this.f7316b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e2) {
                    b();
                    throw e2;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.f7316b = true;
            }
            d();
        }

        public final void d() {
            e();
            synchronized (c.this.f7309k) {
                c.this.f7309k.remove(this);
            }
        }

        public final void e() {
            synchronized (this) {
                this.f7315a = null;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public final class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final int f7318a;

        public i(int i2) {
            this.f7318a = i2;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            l lVar;
            if (iBinder == null) {
                c.this.S(16);
                return;
            }
            synchronized (c.this.f7305g) {
                c cVar = c.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                    lVar = new k(iBinder);
                } else {
                    lVar = (l) queryLocalInterface;
                }
                cVar.f7306h = lVar;
            }
            c.this.T(0, null, this.f7318a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.f7305g) {
                c.this.f7306h = null;
            }
            Handler handler = c.this.f7303e;
            handler.sendMessage(handler.obtainMessage(6, this.f7318a, 1));
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static final class j extends j.a {

        /* renamed from: a  reason: collision with root package name */
        private c f7320a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7321b;

        public j(c cVar, int i2) {
            this.f7320a = cVar;
            this.f7321b = i2;
        }

        @Override // com.google.android.gms.common.internal.j
        public final void A(int i2, IBinder iBinder, h0 h0Var) {
            c cVar = this.f7320a;
            n.g(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            n.f(h0Var);
            cVar.Y(h0Var);
            R(i2, iBinder, h0Var.f7372b);
        }

        @Override // com.google.android.gms.common.internal.j
        public final void L(int i2, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.j
        public final void R(int i2, IBinder iBinder, Bundle bundle) {
            n.g(this.f7320a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f7320a.J(i2, iBinder, bundle, this.f7321b);
            this.f7320a = null;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public final class k extends f {

        /* renamed from: g  reason: collision with root package name */
        private final IBinder f7322g;

        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f7322g = iBinder;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.c.f
        public final void f(com.google.android.gms.common.a aVar) {
            if (c.this.o != null) {
                c.this.o.i(aVar);
            }
            c.this.H(aVar);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.c.f
        public final boolean g() {
            try {
                IBinder iBinder = this.f7322g;
                n.f(iBinder);
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if (!c.this.B().equals(interfaceDescriptor)) {
                    String B = c.this.B();
                    StringBuilder sb = new StringBuilder(String.valueOf(B).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(B);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface r = c.this.r(this.f7322g);
                if (r == null || (!c.this.Z(2, 4, r) && !c.this.Z(3, 4, r))) {
                    return false;
                }
                c.this.s = null;
                Bundle v = c.this.v();
                if (c.this.n == null) {
                    return true;
                }
                c.this.n.k(v);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public final class l extends f {
        public l(int i2, Bundle bundle) {
            super(i2, null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.c.f
        public final void f(com.google.android.gms.common.a aVar) {
            if (!c.this.s() || !c.this.d0()) {
                c.this.f7307i.a(aVar);
                c.this.H(aVar);
                return;
            }
            c.this.S(16);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.c.f
        public final boolean g() {
            c.this.f7307i.a(com.google.android.gms.common.a.f7118f);
            return true;
        }
    }

    protected c(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull h hVar, @RecentlyNonNull com.google.android.gms.common.e eVar, int i2, a aVar, b bVar, String str) {
        n.g(context, "Context must not be null");
        this.f7301c = context;
        n.g(looper, "Looper must not be null");
        n.g(hVar, "Supervisor must not be null");
        this.f7302d = hVar;
        n.g(eVar, "API availability must not be null");
        this.f7303e = new g(looper);
        this.p = i2;
        this.n = aVar;
        this.o = bVar;
        this.q = str;
    }

    private final String R() {
        String str = this.q;
        return str == null ? this.f7301c.getClass().getName() : str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void S(int i2) {
        int i3;
        if (b0()) {
            i3 = 5;
            this.t = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.f7303e;
        handler.sendMessage(handler.obtainMessage(i3, this.v.get(), 16));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void U(int i2, T t2) {
        q0 q0Var;
        q0 q0Var2;
        boolean z = false;
        if ((i2 == 4) == (t2 != null)) {
            z = true;
        }
        n.a(z);
        synchronized (this.f7304f) {
            this.m = i2;
            this.f7308j = t2;
            if (i2 == 1) {
                i iVar = this.l;
                if (iVar != null) {
                    h hVar = this.f7302d;
                    String a2 = this.f7300b.a();
                    n.f(a2);
                    hVar.c(a2, this.f7300b.b(), this.f7300b.c(), iVar, R(), this.f7300b.d());
                    this.l = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                i iVar2 = this.l;
                if (!(iVar2 == null || (q0Var2 = this.f7300b) == null)) {
                    String a3 = q0Var2.a();
                    String b2 = this.f7300b.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(a3).length() + 70 + String.valueOf(b2).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(a3);
                    sb.append(" on ");
                    sb.append(b2);
                    Log.e("GmsClient", sb.toString());
                    h hVar2 = this.f7302d;
                    String a4 = this.f7300b.a();
                    n.f(a4);
                    hVar2.c(a4, this.f7300b.b(), this.f7300b.c(), iVar2, R(), this.f7300b.d());
                    this.v.incrementAndGet();
                }
                i iVar3 = new i(this.v.get());
                this.l = iVar3;
                if (this.m != 3 || y() == null) {
                    q0Var = new q0(D(), C(), false, h.a(), F());
                } else {
                    q0Var = new q0(w().getPackageName(), y(), true, h.a(), false);
                }
                this.f7300b = q0Var;
                if (!q0Var.d() || g() >= 17895000) {
                    h hVar3 = this.f7302d;
                    String a5 = this.f7300b.a();
                    n.f(a5);
                    if (!hVar3.d(new h.a(a5, this.f7300b.b(), this.f7300b.c(), this.f7300b.d()), iVar3, R())) {
                        String a6 = this.f7300b.a();
                        String b3 = this.f7300b.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(a6).length() + 34 + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(a6);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.e("GmsClient", sb2.toString());
                        T(16, null, this.v.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.f7300b.a());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i2 == 4) {
                n.f(t2);
                G(t2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void Y(h0 h0Var) {
        p pVar;
        this.u = h0Var;
        if (N()) {
            e eVar = h0Var.f7375e;
            o b2 = o.b();
            if (eVar == null) {
                pVar = null;
            } else {
                pVar = eVar.o();
            }
            b2.c(pVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean Z(int i2, int i3, T t2) {
        synchronized (this.f7304f) {
            if (this.m != i2) {
                return false;
            }
            U(i3, t2);
            return true;
        }
    }

    private final boolean b0() {
        boolean z;
        synchronized (this.f7304f) {
            z = this.m == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean d0() {
        if (this.t || TextUtils.isEmpty(B()) || TextUtils.isEmpty(y())) {
            return false;
        }
        try {
            Class.forName(B());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @RecentlyNonNull
    public final T A() {
        T t2;
        synchronized (this.f7304f) {
            if (this.m != 5) {
                q();
                T t3 = this.f7308j;
                n.g(t3, "Client is connected but service is null");
                t2 = t3;
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    /* access modifiers changed from: protected */
    public abstract String B();

    /* access modifiers changed from: protected */
    public abstract String C();

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public String D() {
        return "com.google.android.gms";
    }

    @RecentlyNullable
    public e E() {
        h0 h0Var = this.u;
        if (h0Var == null) {
            return null;
        }
        return h0Var.f7375e;
    }

    /* access modifiers changed from: protected */
    public boolean F() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void G(@RecentlyNonNull T t2) {
        System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void H(@RecentlyNonNull com.google.android.gms.common.a aVar) {
        aVar.k();
        System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void I(int i2) {
        System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void J(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f7303e;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    public boolean K() {
        return false;
    }

    public void L(@RecentlyNonNull String str) {
        this.r = str;
    }

    public void M(int i2) {
        Handler handler = this.f7303e;
        handler.sendMessage(handler.obtainMessage(6, this.v.get(), i2));
    }

    public boolean N() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void T(int i2, Bundle bundle, int i3) {
        Handler handler = this.f7303e;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, null)));
    }

    public void a(@RecentlyNonNull e eVar) {
        eVar.a();
    }

    public boolean b() {
        boolean z;
        synchronized (this.f7304f) {
            z = this.m == 4;
        }
        return z;
    }

    public void d(i iVar, @RecentlyNonNull Set<Scope> set) {
        Bundle x = x();
        f fVar = new f(this.p, this.r);
        fVar.f7356e = this.f7301c.getPackageName();
        fVar.f7359h = x;
        if (set != null) {
            fVar.f7358g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (o()) {
            Account t2 = t();
            if (t2 == null) {
                t2 = new Account("<<default account>>", "com.google");
            }
            fVar.f7360i = t2;
            if (iVar != null) {
                fVar.f7357f = iVar.asBinder();
            }
        } else if (K()) {
            fVar.f7360i = t();
        }
        fVar.f7361j = w;
        fVar.f7362k = u();
        if (N()) {
            fVar.n = true;
        }
        try {
            synchronized (this.f7305g) {
                l lVar = this.f7306h;
                if (lVar != null) {
                    lVar.x(new j(this, this.v.get()), fVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            M(3);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            J(8, null, null, this.v.get());
        }
    }

    public void e(@RecentlyNonNull String str) {
        this.f7299a = str;
        n();
    }

    public boolean f() {
        return true;
    }

    public int g() {
        return com.google.android.gms.common.e.f7288a;
    }

    public boolean h() {
        boolean z;
        synchronized (this.f7304f) {
            int i2 = this.m;
            if (i2 != 2) {
                if (i2 != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @RecentlyNullable
    public final com.google.android.gms.common.c[] i() {
        h0 h0Var = this.u;
        if (h0Var == null) {
            return null;
        }
        return h0Var.f7373c;
    }

    @RecentlyNonNull
    public String j() {
        q0 q0Var;
        if (b() && (q0Var = this.f7300b) != null) {
            return q0Var.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @RecentlyNullable
    public String k() {
        return this.f7299a;
    }

    public void m(@RecentlyNonNull AbstractC0144c cVar) {
        n.g(cVar, "Connection progress callbacks cannot be null.");
        this.f7307i = cVar;
        U(2, null);
    }

    public void n() {
        this.v.incrementAndGet();
        synchronized (this.f7309k) {
            int size = this.f7309k.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f7309k.get(i2).e();
            }
            this.f7309k.clear();
        }
        synchronized (this.f7305g) {
            this.f7306h = null;
        }
        U(1, null);
    }

    public boolean o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void q() {
        if (!b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    @RecentlyNullable
    public abstract T r(@RecentlyNonNull IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean s() {
        return false;
    }

    @RecentlyNullable
    public Account t() {
        return null;
    }

    @RecentlyNonNull
    public com.google.android.gms.common.c[] u() {
        return w;
    }

    @RecentlyNullable
    public Bundle v() {
        return null;
    }

    @RecentlyNonNull
    public final Context w() {
        return this.f7301c;
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public Bundle x() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    @RecentlyNullable
    public String y() {
        return null;
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public Set<Scope> z() {
        return Collections.emptySet();
    }
}
