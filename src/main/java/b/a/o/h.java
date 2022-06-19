package b.a.o;

import android.view.View;
import android.view.animation.Interpolator;
import b.h.k.a0;
import b.h.k.y;
import b.h.k.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<y> f2097a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f2098b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f2099c;

    /* renamed from: d  reason: collision with root package name */
    z f2100d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2101e;

    /* renamed from: f  reason: collision with root package name */
    private final a0 f2102f = new a();

    /* compiled from: ViewPropertyAnimatorCompatSet */
    class a extends a0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2103a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f2104b = 0;

        a() {
        }

        @Override // b.h.k.z
        public void b(View view) {
            int i2 = this.f2104b + 1;
            this.f2104b = i2;
            if (i2 == h.this.f2097a.size()) {
                z zVar = h.this.f2100d;
                if (zVar != null) {
                    zVar.b(null);
                }
                d();
            }
        }

        @Override // b.h.k.z, b.h.k.a0
        public void c(View view) {
            if (!this.f2103a) {
                this.f2103a = true;
                z zVar = h.this.f2100d;
                if (zVar != null) {
                    zVar.c(null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f2104b = 0;
            this.f2103a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f2101e) {
            Iterator<y> it = this.f2097a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f2101e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2101e = false;
    }

    public h c(y yVar) {
        if (!this.f2101e) {
            this.f2097a.add(yVar);
        }
        return this;
    }

    public h d(y yVar, y yVar2) {
        this.f2097a.add(yVar);
        yVar2.h(yVar.c());
        this.f2097a.add(yVar2);
        return this;
    }

    public h e(long j2) {
        if (!this.f2101e) {
            this.f2098b = j2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f2101e) {
            this.f2099c = interpolator;
        }
        return this;
    }

    public h g(z zVar) {
        if (!this.f2101e) {
            this.f2100d = zVar;
        }
        return this;
    }

    public void h() {
        if (!this.f2101e) {
            Iterator<y> it = this.f2097a.iterator();
            while (it.hasNext()) {
                y next = it.next();
                long j2 = this.f2098b;
                if (j2 >= 0) {
                    next.d(j2);
                }
                Interpolator interpolator = this.f2099c;
                if (interpolator != null) {
                    next.e(interpolator);
                }
                if (this.f2100d != null) {
                    next.f(this.f2102f);
                }
                next.j();
            }
            this.f2101e = true;
        }
    }
}
