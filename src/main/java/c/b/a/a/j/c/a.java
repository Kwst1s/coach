package c.b.a.a.j.c;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.Surface;
import c.b.a.a.m.c;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.c0.a;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.j;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.drm.q;
import com.google.android.exoplayer2.drm.r;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.g0.a;
import com.google.android.exoplayer2.g0.e;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.h0.o;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.upstream.m;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ExoMediaPlayer */
public class a extends t.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3083a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.g f3084b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.g0.c f3085c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0128a f3086d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f3087e;

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArrayList<c.b.a.a.j.d.b> f3088f = new CopyOnWriteArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f3089g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    private boolean f3090h = false;

    /* renamed from: i  reason: collision with root package name */
    private g f3091i = new g();

    /* renamed from: j  reason: collision with root package name */
    private c.b.a.a.m.c f3092j = new c.b.a.a.m.c();

    /* renamed from: k  reason: collision with root package name */
    private Surface f3093k;
    private s l;
    private u m;
    private List<x> n;
    private m o = new m();
    private c.b.a.a.j.d.a p;
    private c.b.a.a.j.d.d q;
    private c.b.a.a.j.d.c r;
    private c.b.a.a.k.a s;
    private PowerManager.WakeLock t = null;
    private c u = new c();
    private int v;
    protected float w = 1.0f;
    private com.google.android.exoplayer2.c0.a x;

    /* compiled from: ExoMediaPlayer */
    private class b implements c.b {
        private b() {
        }

        @Override // c.b.a.a.m.c.b
        public void a() {
            if (a.this.s != null) {
                a.this.s.d(a.this.y());
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoMediaPlayer */
    public class c implements k {
        private c() {
        }

        @Override // com.google.android.exoplayer2.drm.k
        public /* synthetic */ void G() {
            j.b(this);
        }

        @Override // com.google.android.exoplayer2.drm.k
        public void H() {
        }

        @Override // com.google.android.exoplayer2.drm.k
        public /* synthetic */ void L() {
            j.a(this);
        }

        @Override // com.google.android.exoplayer2.drm.k
        public void b(Exception exc) {
            if (a.this.r != null) {
                a.this.r.b(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.k
        public void v() {
        }
    }

    /* compiled from: ExoMediaPlayer */
    private class d implements o, com.google.android.exoplayer2.audio.j, i, com.google.android.exoplayer2.f0.e {
        private d() {
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void B(Surface surface) {
            a.this.x.B(surface);
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void E(com.google.android.exoplayer2.d0.d dVar) {
            a.this.x.E(dVar);
        }

        @Override // com.google.android.exoplayer2.audio.j
        public void F(String str, long j2, long j3) {
            a.this.x.F(str, j2, j3);
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void I(int i2, long j2) {
            a.this.x.I(i2, j2);
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void a(int i2, int i3, int i4, float f2) {
            Iterator it = a.this.f3088f.iterator();
            while (it.hasNext()) {
                ((c.b.a.a.j.d.b) it.next()).a(i2, i3, i4, f2);
            }
            a.this.x.a(i2, i3, i4, f2);
        }

        @Override // com.google.android.exoplayer2.text.i
        public void b(List<com.google.android.exoplayer2.text.a> list) {
            if (a.this.p != null) {
                a.this.p.b(list);
            }
        }

        @Override // com.google.android.exoplayer2.audio.j
        public void d(int i2) {
            a.this.v = i2;
            a.this.x.d(i2);
        }

        @Override // com.google.android.exoplayer2.audio.j
        public void e(int i2, long j2, long j3) {
            if (a.this.r != null) {
                a.this.r.e(i2, j2, j3);
            }
            a.this.x.e(i2, j2, j3);
        }

        @Override // com.google.android.exoplayer2.f0.e
        public void g(com.google.android.exoplayer2.f0.a aVar) {
            if (a.this.q != null) {
                a.this.q.g(aVar);
            }
            a.this.x.g(aVar);
        }

        @Override // com.google.android.exoplayer2.audio.j
        public void k(com.google.android.exoplayer2.d0.d dVar) {
            a.this.v = 0;
            a.this.x.k(dVar);
        }

        @Override // com.google.android.exoplayer2.audio.j
        public void n(com.google.android.exoplayer2.d0.d dVar) {
            a.this.x.n(dVar);
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void o(String str, long j2, long j3) {
            a.this.x.o(str, j2, j3);
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void t(l lVar) {
            a.this.x.t(lVar);
        }

        @Override // com.google.android.exoplayer2.h0.o
        public void u(com.google.android.exoplayer2.d0.d dVar) {
            a.this.x.u(dVar);
        }

        @Override // com.google.android.exoplayer2.audio.j
        public void x(l lVar) {
            a.this.x.x(lVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoMediaPlayer */
    public class e implements s {
        private e() {
        }

        @Override // com.google.android.exoplayer2.drm.s
        public byte[] a(UUID uuid, p.a aVar) {
            return a.this.l != null ? a.this.l.a(uuid, aVar) : new byte[0];
        }

        @Override // com.google.android.exoplayer2.drm.s
        public byte[] b(UUID uuid, p.c cVar) {
            return a.this.l != null ? a.this.l.b(uuid, cVar) : new byte[0];
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ExoMediaPlayer */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        final List<Integer> f3098a;

        public f(a aVar, List<Integer> list, int i2, int i3) {
            this.f3098a = Collections.unmodifiableList(list);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoMediaPlayer */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private int[] f3099a;

        private g() {
            this.f3099a = new int[]{1, 1, 1, 1};
        }

        public int a() {
            return this.f3099a[3];
        }

        public int b(boolean z, int i2) {
            return (z ? -268435456 : 0) | i2;
        }

        public boolean c() {
            return (this.f3099a[3] & -268435456) != 0;
        }

        public boolean d(int[] iArr, boolean z) {
            int i2 = z ? 268435455 : -1;
            int length = this.f3099a.length - iArr.length;
            int i3 = length;
            boolean z2 = true;
            while (true) {
                int[] iArr2 = this.f3099a;
                if (i3 >= iArr2.length) {
                    return z2;
                }
                z2 &= (iArr2[i3] & i2) == (iArr[i3 - length] & i2);
                i3++;
            }
        }

        public void e() {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f3099a;
                if (i2 < iArr.length) {
                    iArr[i2] = 1;
                    i2++;
                } else {
                    return;
                }
            }
        }

        public void f(boolean z, int i2) {
            int b2 = b(z, i2);
            int[] iArr = this.f3099a;
            if (iArr[3] != b2) {
                iArr[0] = iArr[1];
                iArr[1] = iArr[2];
                iArr[2] = iArr[3];
                iArr[3] = i2;
            }
        }
    }

    public a(Context context) {
        this.f3083a = context;
        this.f3092j.b(1000);
        this.f3092j.a(new b());
        Handler handler = new Handler();
        this.f3087e = handler;
        d dVar = new d();
        c.b.a.a.j.e.a aVar = new c.b.a.a.j.e.a(context, handler, dVar, dVar, dVar, dVar);
        com.google.android.exoplayer2.drm.m<q> w2 = w();
        aVar.f(w2);
        this.n = aVar.e();
        a.C0128a aVar2 = new a.C0128a(this.o);
        this.f3086d = aVar2;
        com.google.android.exoplayer2.g0.c cVar = new com.google.android.exoplayer2.g0.c(aVar2);
        this.f3085c = cVar;
        n eVar = c.b.a.a.a.f3056e != null ? c.b.a.a.a.f3056e : new com.google.android.exoplayer2.e();
        List<x> list = this.n;
        com.google.android.exoplayer2.g b2 = h.b((x[]) list.toArray(new x[list.size()]), cVar, eVar);
        this.f3084b = b2;
        b2.r(this);
        com.google.android.exoplayer2.c0.a a2 = new a.C0119a().a(b2, com.google.android.exoplayer2.util.f.f7015a);
        this.x = a2;
        b2.r(a2);
        c0(w2);
    }

    private void O() {
        boolean l2 = this.f3084b.l();
        int H = H();
        int b2 = this.f3091i.b(l2, H);
        if (b2 != this.f3091i.a()) {
            this.f3091i.f(l2, H);
            if (b2 == 3) {
                S(true);
            } else if (b2 == 1 || b2 == 4) {
                S(false);
            }
            boolean d2 = this.f3091i.d(new int[]{100, 2, 3}, true) | this.f3091i.d(new int[]{2, 100, 3}, true) | this.f3091i.d(new int[]{100, 3, 2, 3}, true);
            Iterator<c.b.a.a.j.d.b> it = this.f3088f.iterator();
            while (it.hasNext()) {
                c.b.a.a.j.d.b next = it.next();
                next.z(l2, H);
                if (d2) {
                    next.w();
                }
            }
        }
    }

    private void S(boolean z) {
        if (!z || this.s == null) {
            this.f3092j.d();
        } else {
            this.f3092j.c();
        }
    }

    public long A(boolean z) {
        long currentPosition = this.f3084b.getCurrentPosition();
        if (z) {
            return currentPosition;
        }
        b0 u2 = this.f3084b.u();
        int min = Math.min(u2.q() - 1, this.f3084b.w());
        long j2 = 0;
        b0.c cVar = new b0.c();
        for (int i2 = 0; i2 < min; i2++) {
            u2.n(i2, cVar);
            j2 += cVar.c();
        }
        return j2 + currentPosition;
    }

    public long B() {
        return this.f3084b.getDuration();
    }

    /* access modifiers changed from: protected */
    public c.b.a.a.d C(int i2) {
        if (i2 == 1) {
            return c.b.a.a.d.AUDIO;
        }
        if (i2 == 2) {
            return c.b.a.a.d.VIDEO;
        }
        if (i2 == 3) {
            return c.b.a.a.d.CLOSED_CAPTION;
        }
        if (i2 != 4) {
            return null;
        }
        return c.b.a.a.d.METADATA;
    }

    /* access modifiers changed from: protected */
    public f E(c.b.a.a.d dVar, int i2, e.a aVar) {
        int i3;
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        if (aVar != null) {
            int i5 = 0;
            int i6 = -1;
            i3 = -1;
            for (int i7 = 0; i7 < aVar.a(); i7++) {
                if (dVar == C(aVar.b(i7))) {
                    arrayList.add(Integer.valueOf(i7));
                    int i8 = aVar.c(i7).f6087b;
                    if (i5 + i8 <= i2) {
                        i5 += i8;
                    } else if (i6 == -1) {
                        i3 = i2 - i5;
                        i6 = i7;
                    }
                }
            }
            i4 = i6;
        } else {
            i3 = -1;
        }
        return new f(this, arrayList, i4, i3);
    }

    public boolean F() {
        return this.f3084b.l();
    }

    public float G() {
        return this.f3084b.d().f6053a;
    }

    public int H() {
        return this.f3084b.n();
    }

    public float I() {
        return this.w;
    }

    public b J() {
        b0 u2 = this.f3084b.u();
        if (u2.r()) {
            return null;
        }
        int w2 = this.f3084b.w();
        return new b(this.f3084b.j(), w2, this.f3084b.q(), u2.o(w2, new b0.c(), true));
    }

    public void K() {
        if (!this.f3090h && this.m != null) {
            if (!this.n.isEmpty()) {
                this.f3084b.stop();
            }
            this.f3091i.e();
            this.f3084b.b(this.m);
            this.f3090h = true;
            this.f3089g.set(false);
        }
    }

    public void L() {
        S(false);
        this.f3088f.clear();
        u uVar = this.m;
        if (uVar != null) {
            uVar.f(this.x);
        }
        this.f3093k = null;
        this.f3084b.a();
        d0(false);
    }

    public void M(com.google.android.exoplayer2.c0.b bVar) {
        this.x.V(bVar);
    }

    public void N(c.b.a.a.j.d.b bVar) {
        if (bVar != null) {
            this.f3088f.remove(bVar);
        }
    }

    public void P(long j2) {
        Q(j2, false);
    }

    public void Q(long j2, boolean z) {
        this.x.U();
        if (z) {
            this.f3084b.e(j2);
            g gVar = this.f3091i;
            gVar.f(gVar.c(), 100);
            return;
        }
        b0 u2 = this.f3084b.u();
        int q2 = u2.q();
        long j3 = 0;
        b0.c cVar = new b0.c();
        for (int i2 = 0; i2 < q2; i2++) {
            u2.n(i2, cVar);
            long c2 = cVar.c();
            if (j3 >= j2 || j2 > j3 + c2) {
                j3 += c2;
            } else {
                this.f3084b.i(i2, j2 - j3);
                g gVar2 = this.f3091i;
                gVar2.f(gVar2.c(), 100);
                return;
            }
        }
        Log.e("ExoMediaPlayer", "Unable to seek across windows, falling back to in-window seeking");
        this.f3084b.e(j2);
        g gVar3 = this.f3091i;
        gVar3.f(gVar3.c(), 100);
    }

    /* access modifiers changed from: protected */
    public void R(int i2, int i3, Object obj, boolean z) {
        if (!this.n.isEmpty()) {
            ArrayList<v> arrayList = new ArrayList();
            for (x xVar : this.n) {
                if (xVar.g() == i2) {
                    v c2 = this.f3084b.c(xVar);
                    c2.n(i3);
                    c2.m(obj);
                    arrayList.add(c2);
                }
            }
            if (z) {
                t(arrayList);
                return;
            }
            for (v vVar : arrayList) {
                vVar.l();
            }
        }
    }

    public void T(c.b.a.a.k.a aVar) {
        this.s = aVar;
        S(aVar != null);
    }

    public void U(c.b.a.a.j.d.a aVar) {
        this.p = aVar;
    }

    public void V(s sVar) {
        this.l = sVar;
    }

    public void W(u uVar) {
        u uVar2 = this.m;
        if (uVar2 != null) {
            uVar2.f(this.x);
            this.x.W();
        }
        if (uVar != null) {
            uVar.e(this.f3087e, this.x);
        }
        this.m = uVar;
        this.f3090h = false;
        K();
    }

    public void X(c.b.a.a.j.d.d dVar) {
        this.q = dVar;
    }

    public void Y(boolean z) {
        this.f3084b.f(z);
        d0(z);
    }

    public void Z(int i2) {
        this.f3084b.setRepeatMode(i2);
    }

    public void a0(Surface surface) {
        this.f3093k = surface;
        R(2, 1, surface, false);
    }

    public void b0(Uri uri) {
        W(uri != null ? c.b.a.a.a.f3057f.e(this.f3083a, this.f3087e, uri, this.o) : null);
    }

    /* access modifiers changed from: protected */
    public void c0(com.google.android.exoplayer2.drm.m<q> mVar) {
        if (mVar instanceof DefaultDrmSessionManager) {
            ((DefaultDrmSessionManager) mVar).i(this.f3087e, this.x);
        }
    }

    /* access modifiers changed from: protected */
    public void d0(boolean z) {
        PowerManager.WakeLock wakeLock = this.t;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.t.acquire(1000);
            } else if (!z && this.t.isHeld()) {
                this.t.release();
            }
        }
    }

    public void e0() {
        if (!this.f3089g.getAndSet(true)) {
            this.f3084b.f(false);
            this.f3084b.stop();
        }
    }

    @Override // com.google.android.exoplayer2.t.b
    public void h(boolean z, int i2) {
        O();
    }

    public void o(com.google.android.exoplayer2.c0.b bVar) {
        this.x.M(bVar);
    }

    @Override // com.google.android.exoplayer2.t.b
    public void q(ExoPlaybackException exoPlaybackException) {
        Iterator<c.b.a.a.j.d.b> it = this.f3088f.iterator();
        while (it.hasNext()) {
            it.next().B(this, exoPlaybackException);
        }
    }

    public void r(c.b.a.a.j.d.b bVar) {
        if (bVar != null) {
            this.f3088f.add(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public void t(List<v> list) {
        boolean z = false;
        for (v vVar : list) {
            boolean z2 = true;
            while (z2) {
                try {
                    vVar.a();
                    z2 = false;
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public void u() {
        Surface surface = this.f3093k;
        if (surface != null) {
            surface.release();
        }
        this.f3093k = null;
        R(2, 1, null, false);
    }

    public void v() {
        this.f3090h = false;
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.drm.m<q> w() {
        if (Build.VERSION.SDK_INT < 18) {
            return null;
        }
        UUID uuid = com.google.android.exoplayer2.d.f4926d;
        try {
            DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid, r.v(uuid), new e(), null);
            defaultDrmSessionManager.i(this.f3087e, this.u);
            return defaultDrmSessionManager;
        } catch (Exception e2) {
            Log.d("ExoMediaPlayer", "Unable to create a DrmSessionManager due to an exception", e2);
            return null;
        }
    }

    public Map<c.b.a.a.d, c0> x() {
        if (H() == 1) {
            return null;
        }
        b.e.a aVar = new b.e.a();
        e.a f2 = this.f3085c.f();
        if (f2 == null) {
            return aVar;
        }
        c.b.a.a.d[] dVarArr = {c.b.a.a.d.AUDIO, c.b.a.a.d.VIDEO, c.b.a.a.d.CLOSED_CAPTION, c.b.a.a.d.METADATA};
        for (int i2 = 0; i2 < 4; i2++) {
            c.b.a.a.d dVar = dVarArr[i2];
            ArrayList arrayList = new ArrayList();
            for (Integer num : E(dVar, 0, f2).f3098a) {
                c0 c2 = f2.c(num.intValue());
                for (int i3 = 0; i3 < c2.f6087b; i3++) {
                    arrayList.add(c2.g(i3));
                }
            }
            if (!arrayList.isEmpty()) {
                aVar.put(dVar, new c0((com.google.android.exoplayer2.source.b0[]) arrayList.toArray(new com.google.android.exoplayer2.source.b0[arrayList.size()])));
            }
        }
        return aVar;
    }

    public int y() {
        return this.f3084b.o();
    }

    public long z() {
        return A(false);
    }
}
