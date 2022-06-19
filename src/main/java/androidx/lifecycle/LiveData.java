package androidx.lifecycle;

import androidx.lifecycle.e;
import b.b.a.b.b;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: i  reason: collision with root package name */
    static final Object f1432i = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f1433a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private b<o<? super T>, LiveData<T>.a> f1434b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    int f1435c = 0;

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f1436d;

    /* renamed from: e  reason: collision with root package name */
    volatile Object f1437e;

    /* renamed from: f  reason: collision with root package name */
    private int f1438f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1439g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1440h;

    class LifecycleBoundObserver extends LiveData<T>.a implements g {

        /* renamed from: e  reason: collision with root package name */
        final i f1441e;

        LifecycleBoundObserver(i iVar, o<? super T> oVar) {
            super(oVar);
            this.f1441e = iVar;
        }

        @Override // androidx.lifecycle.g
        public void d(i iVar, e.a aVar) {
            if (this.f1441e.c().b() == e.b.DESTROYED) {
                LiveData.this.g(this.f1443a);
            } else {
                h(k());
            }
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.a
        public void i() {
            this.f1441e.c().c(this);
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.a
        public boolean j(i iVar) {
            return this.f1441e == iVar;
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.a
        public boolean k() {
            return this.f1441e.c().b().a(e.b.STARTED);
        }
    }

    /* access modifiers changed from: private */
    public abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final o<? super T> f1443a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1444b;

        /* renamed from: c  reason: collision with root package name */
        int f1445c = -1;

        a(o<? super T> oVar) {
            this.f1443a = oVar;
        }

        /* access modifiers changed from: package-private */
        public void h(boolean z) {
            if (z != this.f1444b) {
                this.f1444b = z;
                LiveData liveData = LiveData.this;
                int i2 = liveData.f1435c;
                int i3 = 1;
                boolean z2 = i2 == 0;
                if (!z) {
                    i3 = -1;
                }
                liveData.f1435c = i2 + i3;
                if (z2 && z) {
                    liveData.e();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.f1435c == 0 && !this.f1444b) {
                    liveData2.f();
                }
                if (this.f1444b) {
                    LiveData.this.c(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
        }

        /* access modifiers changed from: package-private */
        public boolean j(i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean k();
    }

    public LiveData() {
        Object obj = f1432i;
        this.f1437e = obj;
        this.f1436d = obj;
        this.f1438f = -1;
    }

    static void a(String str) {
        if (!b.b.a.a.a.b().a()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f1444b) {
            if (!aVar.k()) {
                aVar.h(false);
                return;
            }
            int i2 = aVar.f1445c;
            int i3 = this.f1438f;
            if (i2 < i3) {
                aVar.f1445c = i3;
                aVar.f1443a.a((Object) this.f1436d);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(LiveData<T>.a aVar) {
        if (this.f1439g) {
            this.f1440h = true;
            return;
        }
        this.f1439g = true;
        do {
            this.f1440h = false;
            if (aVar == null) {
                b<K, V>.d d2 = this.f1434b.d();
                while (d2.hasNext()) {
                    b((a) ((Map.Entry) d2.next()).getValue());
                    if (this.f1440h) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.f1440h);
        this.f1439g = false;
    }

    public void d(i iVar, o<? super T> oVar) {
        a("observe");
        if (iVar.c().b() != e.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(iVar, oVar);
            LiveData<T>.a g2 = this.f1434b.g(oVar, lifecycleBoundObserver);
            if (g2 != null && !g2.j(iVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (g2 == null) {
                iVar.c().a(lifecycleBoundObserver);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    public void g(o<? super T> oVar) {
        a("removeObserver");
        LiveData<T>.a h2 = this.f1434b.h(oVar);
        if (h2 != null) {
            h2.i();
            h2.h(false);
        }
    }

    /* access modifiers changed from: protected */
    public void h(T t) {
        a("setValue");
        this.f1438f++;
        this.f1436d = t;
        c(null);
    }
}
