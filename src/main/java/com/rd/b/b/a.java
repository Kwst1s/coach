package com.rd.b.b;

import com.github.mikephil.charting.utils.Utils;
import com.rd.b.b.b;
import com.rd.b.d.c;
import com.rd.b.d.d;
import com.rd.b.d.e;
import com.rd.b.d.f;
import com.rd.b.d.g;
import com.rd.b.d.h;
import com.rd.b.d.i;
import com.rd.b.d.j;
import com.rd.b.d.k;

/* compiled from: AnimationController */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f8477a;

    /* renamed from: b  reason: collision with root package name */
    private b.a f8478b;

    /* renamed from: c  reason: collision with root package name */
    private com.rd.b.d.b f8479c;

    /* renamed from: d  reason: collision with root package name */
    private com.rd.c.c.a f8480d;

    /* renamed from: e  reason: collision with root package name */
    private float f8481e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8482f;

    /* access modifiers changed from: package-private */
    /* renamed from: com.rd.b.b.a$a  reason: collision with other inner class name */
    /* compiled from: AnimationController */
    public static /* synthetic */ class C0172a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8483a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
            // Method dump skipped, instructions count: 121
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.b.b.a.C0172a.<clinit>():void");
        }
    }

    public a(com.rd.c.c.a aVar, b.a aVar2) {
        this.f8477a = new b(aVar2);
        this.f8478b = aVar2;
        this.f8480d = aVar;
    }

    private void a() {
        switch (C0172a.f8483a[this.f8480d.b().ordinal()]) {
            case 1:
                this.f8478b.a(null);
                return;
            case 2:
                c();
                return;
            case 3:
                h();
                return;
            case 4:
                m();
                return;
            case 5:
                f();
                return;
            case 6:
                j();
                return;
            case 7:
                l();
                return;
            case 8:
                d();
                return;
            case 9:
                k();
                return;
            case 10:
                i();
                return;
            default:
                return;
        }
    }

    private void c() {
        int p = this.f8480d.p();
        int t = this.f8480d.t();
        long a2 = this.f8480d.a();
        c a3 = this.f8477a.a();
        a3.l(t, p);
        a3.b(a2);
        if (this.f8482f) {
            a3.d(this.f8481e);
        } else {
            a3.e();
        }
        this.f8479c = a3;
    }

    private void d() {
        int q = this.f8480d.z() ? this.f8480d.q() : this.f8480d.f();
        int r = this.f8480d.z() ? this.f8480d.r() : this.f8480d.q();
        int a2 = com.rd.e.a.a(this.f8480d, q);
        int a3 = com.rd.e.a.a(this.f8480d, r);
        int l = this.f8480d.l();
        int j2 = this.f8480d.j();
        if (this.f8480d.g() != com.rd.c.c.b.HORIZONTAL) {
            l = j2;
        }
        int m = this.f8480d.m();
        int i2 = (m * 3) + l;
        int i3 = m + l;
        long a4 = this.f8480d.a();
        d b2 = this.f8477a.b();
        b2.i(a4);
        b2.m(a2, a3, i2, i3, m);
        if (this.f8482f) {
            b2.d(this.f8481e);
        } else {
            b2.e();
        }
        this.f8479c = b2;
    }

    private void f() {
        int p = this.f8480d.p();
        int t = this.f8480d.t();
        int m = this.f8480d.m();
        int s = this.f8480d.s();
        long a2 = this.f8480d.a();
        e c2 = this.f8477a.c();
        c2.q(t, p, m, s);
        c2.b(a2);
        if (this.f8482f) {
            c2.d(this.f8481e);
        } else {
            c2.e();
        }
        this.f8479c = c2;
    }

    private void h() {
        int p = this.f8480d.p();
        int t = this.f8480d.t();
        int m = this.f8480d.m();
        float o = this.f8480d.o();
        long a2 = this.f8480d.a();
        f d2 = this.f8477a.d();
        d2.p(t, p, m, o);
        d2.b(a2);
        if (this.f8482f) {
            d2.d(this.f8481e);
        } else {
            d2.e();
        }
        this.f8479c = d2;
    }

    private void i() {
        int p = this.f8480d.p();
        int t = this.f8480d.t();
        int m = this.f8480d.m();
        float o = this.f8480d.o();
        long a2 = this.f8480d.a();
        g e2 = this.f8477a.e();
        e2.p(t, p, m, o);
        e2.b(a2);
        if (this.f8482f) {
            e2.d(this.f8481e);
        } else {
            e2.e();
        }
        this.f8479c = e2;
    }

    private void j() {
        int q = this.f8480d.z() ? this.f8480d.q() : this.f8480d.f();
        int r = this.f8480d.z() ? this.f8480d.r() : this.f8480d.q();
        int a2 = com.rd.e.a.a(this.f8480d, q);
        int a3 = com.rd.e.a.a(this.f8480d, r);
        long a4 = this.f8480d.a();
        h f2 = this.f8477a.f();
        f2.l(a2, a3);
        f2.b(a4);
        if (this.f8482f) {
            f2.d(this.f8481e);
        } else {
            f2.e();
        }
        this.f8479c = f2;
    }

    private void k() {
        int q = this.f8480d.z() ? this.f8480d.q() : this.f8480d.f();
        int r = this.f8480d.z() ? this.f8480d.r() : this.f8480d.q();
        int a2 = com.rd.e.a.a(this.f8480d, q);
        int a3 = com.rd.e.a.a(this.f8480d, r);
        long a4 = this.f8480d.a();
        i g2 = this.f8477a.g();
        g2.l(a2, a3);
        g2.b(a4);
        if (this.f8482f) {
            g2.d(this.f8481e);
        } else {
            g2.e();
        }
        this.f8479c = g2;
    }

    private void l() {
        int q = this.f8480d.z() ? this.f8480d.q() : this.f8480d.f();
        int r = this.f8480d.z() ? this.f8480d.r() : this.f8480d.q();
        int a2 = com.rd.e.a.a(this.f8480d, q);
        int a3 = com.rd.e.a.a(this.f8480d, r);
        boolean z = r > q;
        int m = this.f8480d.m();
        long a4 = this.f8480d.a();
        j h2 = this.f8477a.h();
        h2.n(a2, a3, m, z);
        h2.j(a4);
        if (this.f8482f) {
            h2.d(this.f8481e);
        } else {
            h2.e();
        }
        this.f8479c = h2;
    }

    private void m() {
        int q = this.f8480d.z() ? this.f8480d.q() : this.f8480d.f();
        int r = this.f8480d.z() ? this.f8480d.r() : this.f8480d.q();
        k j2 = this.f8477a.i().n(com.rd.e.a.a(this.f8480d, q), com.rd.e.a.a(this.f8480d, r), this.f8480d.m(), r > q).j(this.f8480d.a());
        if (this.f8482f) {
            j2.d(this.f8481e);
        } else {
            j2.e();
        }
        this.f8479c = j2;
    }

    public void b() {
        this.f8482f = false;
        this.f8481e = Utils.FLOAT_EPSILON;
        a();
    }

    public void e() {
        com.rd.b.d.b bVar = this.f8479c;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void g(float f2) {
        this.f8482f = true;
        this.f8481e = f2;
        a();
    }
}
