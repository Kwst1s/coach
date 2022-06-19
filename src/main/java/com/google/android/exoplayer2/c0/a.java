package com.google.android.exoplayer2.c0;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.j;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.c0.b;
import com.google.android.exoplayer2.d0.d;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.f0.e;
import com.google.android.exoplayer2.g0.h;
import com.google.android.exoplayer2.h0.o;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AnalyticsCollector */
public class a implements t.b, e, j, o, v, e.a, k {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArraySet<b> f4908a;

    /* renamed from: b  reason: collision with root package name */
    private final f f4909b;

    /* renamed from: c  reason: collision with root package name */
    private final b0.c f4910c;

    /* renamed from: d  reason: collision with root package name */
    private final c f4911d;

    /* renamed from: e  reason: collision with root package name */
    private t f4912e;

    /* renamed from: com.google.android.exoplayer2.c0.a$a  reason: collision with other inner class name */
    /* compiled from: AnalyticsCollector */
    public static class C0119a {
        public a a(t tVar, f fVar) {
            return new a(tVar, fVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AnalyticsCollector */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final u.a f4913a;

        /* renamed from: b  reason: collision with root package name */
        public final b0 f4914b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4915c;

        public b(u.a aVar, b0 b0Var, int i2) {
            this.f4913a = aVar;
            this.f4914b = b0Var;
            this.f4915c = i2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AnalyticsCollector */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<b> f4916a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<u.a, b> f4917b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private final b0.b f4918c = new b0.b();

        /* renamed from: d  reason: collision with root package name */
        private b f4919d;

        /* renamed from: e  reason: collision with root package name */
        private b f4920e;

        /* renamed from: f  reason: collision with root package name */
        private b0 f4921f = b0.f4885a;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4922g;

        private void p() {
            if (!this.f4916a.isEmpty()) {
                this.f4919d = this.f4916a.get(0);
            }
        }

        private b q(b bVar, b0 b0Var) {
            int b2 = b0Var.b(bVar.f4913a.f6613a);
            if (b2 == -1) {
                return bVar;
            }
            return new b(bVar.f4913a, b0Var, b0Var.f(b2, this.f4918c).f4888c);
        }

        public b b() {
            return this.f4919d;
        }

        public b c() {
            if (this.f4916a.isEmpty()) {
                return null;
            }
            ArrayList<b> arrayList = this.f4916a;
            return arrayList.get(arrayList.size() - 1);
        }

        public b d(u.a aVar) {
            return this.f4917b.get(aVar);
        }

        public b e() {
            if (this.f4916a.isEmpty() || this.f4921f.r() || this.f4922g) {
                return null;
            }
            return this.f4916a.get(0);
        }

        public b f() {
            return this.f4920e;
        }

        public boolean g() {
            return this.f4922g;
        }

        public void h(int i2, u.a aVar) {
            b bVar = new b(aVar, this.f4921f.b(aVar.f6613a) != -1 ? this.f4921f : b0.f4885a, i2);
            this.f4916a.add(bVar);
            this.f4917b.put(aVar, bVar);
            if (this.f4916a.size() == 1 && !this.f4921f.r()) {
                p();
            }
        }

        public boolean i(u.a aVar) {
            b remove = this.f4917b.remove(aVar);
            if (remove == null) {
                return false;
            }
            this.f4916a.remove(remove);
            b bVar = this.f4920e;
            if (bVar == null || !aVar.equals(bVar.f4913a)) {
                return true;
            }
            this.f4920e = this.f4916a.isEmpty() ? null : this.f4916a.get(0);
            return true;
        }

        public void j(int i2) {
            p();
        }

        public void k(u.a aVar) {
            this.f4920e = this.f4917b.get(aVar);
        }

        public void l() {
            this.f4922g = false;
            p();
        }

        public void m() {
            this.f4922g = true;
        }

        public void n(b0 b0Var) {
            for (int i2 = 0; i2 < this.f4916a.size(); i2++) {
                b q = q(this.f4916a.get(i2), b0Var);
                this.f4916a.set(i2, q);
                this.f4917b.put(q.f4913a, q);
            }
            b bVar = this.f4920e;
            if (bVar != null) {
                this.f4920e = q(bVar, b0Var);
            }
            this.f4921f = b0Var;
            p();
        }

        public b o(int i2) {
            b bVar = null;
            for (int i3 = 0; i3 < this.f4916a.size(); i3++) {
                b bVar2 = this.f4916a.get(i3);
                int b2 = this.f4921f.b(bVar2.f4913a.f6613a);
                if (b2 != -1 && this.f4921f.f(b2, this.f4918c).f4888c == i2) {
                    if (bVar != null) {
                        return null;
                    }
                    bVar = bVar2;
                }
            }
            return bVar;
        }
    }

    protected a(t tVar, f fVar) {
        if (tVar != null) {
            this.f4912e = tVar;
        }
        com.google.android.exoplayer2.util.e.e(fVar);
        this.f4909b = fVar;
        this.f4908a = new CopyOnWriteArraySet<>();
        this.f4911d = new c();
        this.f4910c = new b0.c();
    }

    private b.a O(b bVar) {
        com.google.android.exoplayer2.util.e.e(this.f4912e);
        if (bVar == null) {
            int w = this.f4912e.w();
            b o = this.f4911d.o(w);
            if (o == null) {
                b0 u = this.f4912e.u();
                if (!(w < u.q())) {
                    u = b0.f4885a;
                }
                return N(u, w, null);
            }
            bVar = o;
        }
        return N(bVar.f4914b, bVar.f4915c, bVar.f4913a);
    }

    private b.a P() {
        return O(this.f4911d.b());
    }

    private b.a Q() {
        return O(this.f4911d.c());
    }

    private b.a R(int i2, u.a aVar) {
        com.google.android.exoplayer2.util.e.e(this.f4912e);
        if (aVar != null) {
            b d2 = this.f4911d.d(aVar);
            if (d2 != null) {
                return O(d2);
            }
            return N(b0.f4885a, i2, aVar);
        }
        b0 u = this.f4912e.u();
        if (!(i2 < u.q())) {
            u = b0.f4885a;
        }
        return N(u, i2, null);
    }

    private b.a S() {
        return O(this.f4911d.e());
    }

    private b.a T() {
        return O(this.f4911d.f());
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void A(int i2, u.a aVar) {
        this.f4911d.h(i2, aVar);
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().k(R);
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void B(Surface surface) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().x(T, surface);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e.a
    public final void C(int i2, long j2, long j3) {
        b.a Q = Q();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().b(Q, i2, j2, j3);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void D(c0 c0Var, h hVar) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().K(S, c0Var, hVar);
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void E(d dVar) {
        b.a P = P();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().E(P, 2, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.audio.j
    public final void F(String str, long j2, long j3) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().l(T, 1, str, j3);
        }
    }

    @Override // com.google.android.exoplayer2.drm.k
    public final void G() {
        b.a P = P();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().o(P);
        }
    }

    @Override // com.google.android.exoplayer2.drm.k
    public final void H() {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().J(T);
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void I(int i2, long j2) {
        b.a P = P();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().f(P, i2, j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void J(int i2, u.a aVar, v.c cVar) {
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().O(R, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void K(int i2, u.a aVar, v.c cVar) {
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().M(R, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.drm.k
    public final void L() {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().G(T);
        }
    }

    public void M(b bVar) {
        this.f4908a.add(bVar);
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public b.a N(b0 b0Var, int i2, u.a aVar) {
        if (b0Var.r()) {
            aVar = null;
        }
        long c2 = this.f4909b.c();
        boolean z = true;
        boolean z2 = b0Var == this.f4912e.u() && i2 == this.f4912e.w();
        long j2 = 0;
        if (aVar != null && aVar.a()) {
            if (!(z2 && this.f4912e.p() == aVar.f6614b && this.f4912e.s() == aVar.f6615c)) {
                z = false;
            }
            if (z) {
                j2 = this.f4912e.getCurrentPosition();
            }
        } else if (z2) {
            j2 = this.f4912e.g();
        } else if (!b0Var.r()) {
            j2 = b0Var.n(i2, this.f4910c).a();
        }
        return new b.a(c2, b0Var, i2, aVar, j2, this.f4912e.getCurrentPosition(), this.f4912e.h());
    }

    public final void U() {
        if (!this.f4911d.g()) {
            b.a S = S();
            this.f4911d.m();
            Iterator<b> it = this.f4908a.iterator();
            while (it.hasNext()) {
                it.next().t(S);
            }
        }
    }

    public void V(b bVar) {
        this.f4908a.remove(bVar);
    }

    public final void W() {
        for (b bVar : new ArrayList(this.f4911d.f4916a)) {
            w(bVar.f4915c, bVar.f4913a);
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void a(int i2, int i3, int i4, float f2) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().c(T, i2, i3, i4, f2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.k
    public final void b(Exception exc) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().n(T, exc);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void c(int i2) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().D(S, i2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.j
    public final void d(int i2) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().L(T, i2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.j
    public final void e(int i2, long j2, long j3) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().v(T, i2, j2, j3);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void f(s sVar) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().s(S, sVar);
        }
    }

    @Override // com.google.android.exoplayer2.f0.e
    public final void g(com.google.android.exoplayer2.f0.a aVar) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().C(S, aVar);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void h(boolean z, int i2) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().F(S, z, i2);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void i(boolean z) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().u(S, z);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void j(int i2) {
        this.f4911d.j(i2);
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().m(S, i2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.j
    public final void k(d dVar) {
        b.a P = P();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().E(P, 1, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void l(int i2, u.a aVar, v.b bVar, v.c cVar) {
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().r(R, bVar, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void m(int i2, u.a aVar, v.b bVar, v.c cVar, IOException iOException, boolean z) {
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().y(R, bVar, cVar, iOException, z);
        }
    }

    @Override // com.google.android.exoplayer2.audio.j
    public final void n(d dVar) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().A(S, 1, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void o(String str, long j2, long j3) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().l(T, 2, str, j3);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void p(b0 b0Var, Object obj, int i2) {
        this.f4911d.n(b0Var);
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().p(S, i2);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void q(ExoPlaybackException exoPlaybackException) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().N(S, exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void r(int i2, u.a aVar, v.b bVar, v.c cVar) {
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().e(R, bVar, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public final void s() {
        if (this.f4911d.g()) {
            this.f4911d.l();
            b.a S = S();
            Iterator<b> it = this.f4908a.iterator();
            while (it.hasNext()) {
                it.next().j(S);
            }
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void t(l lVar) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().i(T, 2, lVar);
        }
    }

    @Override // com.google.android.exoplayer2.h0.o
    public final void u(d dVar) {
        b.a S = S();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().A(S, 2, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.drm.k
    public final void v() {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().q(T);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void w(int i2, u.a aVar) {
        b.a R = R(i2, aVar);
        if (this.f4911d.i(aVar)) {
            Iterator<b> it = this.f4908a.iterator();
            while (it.hasNext()) {
                it.next().I(R);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.j
    public final void x(l lVar) {
        b.a T = T();
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().i(T, 1, lVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void y(int i2, u.a aVar) {
        this.f4911d.k(aVar);
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().H(R);
        }
    }

    @Override // com.google.android.exoplayer2.source.v
    public final void z(int i2, u.a aVar, v.b bVar, v.c cVar) {
        b.a R = R(i2, aVar);
        Iterator<b> it = this.f4908a.iterator();
        while (it.hasNext()) {
            it.next().h(R, bVar, cVar);
        }
    }
}
