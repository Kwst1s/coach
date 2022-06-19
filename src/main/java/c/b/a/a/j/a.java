package c.b.a.a.j;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Surface;
import c.b.a.a.j.d.d;
import c.b.a.a.k.e;
import com.devbrackets.android.exomedia.core.exception.NativeMediaPlaybackException;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.c0.b;
import com.google.android.exoplayer2.g0.h;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.v;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: ListenerMux */
public class a implements c.b.a.a.j.d.b, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, c.b.a.a.k.a, d, com.google.android.exoplayer2.c0.b {

    /* renamed from: a  reason: collision with root package name */
    private Handler f3070a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    private c f3071b;

    /* renamed from: c  reason: collision with root package name */
    private c.b.a.a.k.d f3072c;

    /* renamed from: d  reason: collision with root package name */
    private c.b.a.a.k.b f3073d;

    /* renamed from: e  reason: collision with root package name */
    private c.b.a.a.k.a f3074e;

    /* renamed from: f  reason: collision with root package name */
    private e f3075f;

    /* renamed from: g  reason: collision with root package name */
    private c.b.a.a.k.c f3076g;

    /* renamed from: h  reason: collision with root package name */
    private d f3077h;

    /* renamed from: i  reason: collision with root package name */
    private com.google.android.exoplayer2.c0.b f3078i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<c.b.a.a.j.g.a> f3079j = new WeakReference<>(null);

    /* renamed from: k  reason: collision with root package name */
    private boolean f3080k = false;
    private boolean l = false;
    private boolean m = false;

    /* access modifiers changed from: package-private */
    /* renamed from: c.b.a.a.j.a$a  reason: collision with other inner class name */
    /* compiled from: ListenerMux */
    public class RunnableC0066a implements Runnable {
        RunnableC0066a() {
        }

        public void run() {
            a.this.W();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ListenerMux */
    public class b implements Runnable {
        b() {
        }

        public void run() {
            if (a.this.f3073d != null) {
                a.this.f3073d.a();
            }
        }
    }

    /* compiled from: ListenerMux */
    public static abstract class c {
        public void a(int i2) {
        }

        public abstract void b(c.b.a.a.j.c.a aVar, Exception exc);

        public abstract void c();

        public abstract void d();

        public abstract void e(boolean z);

        public abstract void f();

        public abstract void g(int i2, int i3, int i4, float f2);

        public abstract boolean h(long j2);
    }

    public a(c cVar) {
        this.f3071b = cVar;
    }

    private void T() {
        if (this.f3071b.h(1000)) {
            this.l = true;
            this.f3070a.post(new b());
        }
    }

    private boolean U(Exception exc) {
        c.b.a.a.k.c cVar = this.f3076g;
        return cVar != null && cVar.a(exc);
    }

    private void V() {
        this.f3080k = true;
        this.f3070a.post(new RunnableC0066a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void W() {
        this.f3071b.d();
        c.b.a.a.k.d dVar = this.f3072c;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void A(b.a aVar, int i2, com.google.android.exoplayer2.d0.d dVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.A(aVar, i2, dVar);
        }
    }

    @Override // c.b.a.a.j.d.b
    public void B(c.b.a.a.j.c.a aVar, Exception exc) {
        this.f3071b.c();
        this.f3071b.b(aVar, exc);
        U(exc);
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void C(b.a aVar, com.google.android.exoplayer2.f0.a aVar2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.C(aVar, aVar2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void D(b.a aVar, int i2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.D(aVar, i2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void E(b.a aVar, int i2, com.google.android.exoplayer2.d0.d dVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.E(aVar, i2, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void F(b.a aVar, boolean z, int i2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.F(aVar, z, i2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void G(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.G(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void H(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.H(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void I(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.I(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void J(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.J(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void K(b.a aVar, c0 c0Var, h hVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.K(aVar, c0Var, hVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void L(b.a aVar, int i2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.L(aVar, i2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void M(b.a aVar, v.c cVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.M(aVar, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void N(b.a aVar, ExoPlaybackException exoPlaybackException) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.N(aVar, exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void O(b.a aVar, v.c cVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.O(aVar, cVar);
        }
    }

    public void R(c.b.a.a.j.g.a aVar) {
        this.m = true;
        this.f3079j = new WeakReference<>(aVar);
    }

    public boolean S() {
        return this.f3080k;
    }

    public void X(com.google.android.exoplayer2.c0.b bVar) {
        this.f3078i = bVar;
    }

    public void Y(d dVar) {
        this.f3077h = dVar;
    }

    public void Z(boolean z) {
        this.l = z;
    }

    @Override // c.b.a.a.j.d.b
    public void a(int i2, int i3, int i4, float f2) {
        this.f3071b.g(i2, i3, i4, f2);
    }

    public void a0(boolean z) {
        this.f3080k = z;
        this.f3071b.e(true);
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void b(b.a aVar, int i2, long j2, long j3) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.b(aVar, i2, j2, j3);
        }
    }

    public void b0(c.b.a.a.k.a aVar) {
        this.f3074e = aVar;
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void c(b.a aVar, int i2, int i3, int i4, float f2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.c(aVar, i2, i3, i4, f2);
        }
    }

    public void c0(c.b.a.a.k.b bVar) {
        this.f3073d = bVar;
    }

    @Override // c.b.a.a.k.a
    public void d(int i2) {
        this.f3071b.a(i2);
        c.b.a.a.k.a aVar = this.f3074e;
        if (aVar != null) {
            aVar.d(i2);
        }
    }

    public void d0(c.b.a.a.k.c cVar) {
        this.f3076g = cVar;
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void e(b.a aVar, v.b bVar, v.c cVar) {
        com.google.android.exoplayer2.c0.b bVar2 = this.f3078i;
        if (bVar2 != null) {
            bVar2.e(aVar, bVar, cVar);
        }
    }

    public void e0(c.b.a.a.k.d dVar) {
        this.f3072c = dVar;
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void f(b.a aVar, int i2, long j2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.f(aVar, i2, j2);
        }
    }

    public void f0(e eVar) {
        this.f3075f = eVar;
    }

    @Override // c.b.a.a.j.d.d
    public void g(com.google.android.exoplayer2.f0.a aVar) {
        d dVar = this.f3077h;
        if (dVar != null) {
            dVar.g(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void h(b.a aVar, v.b bVar, v.c cVar) {
        com.google.android.exoplayer2.c0.b bVar2 = this.f3078i;
        if (bVar2 != null) {
            bVar2.h(aVar, bVar, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void i(b.a aVar, int i2, l lVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.i(aVar, i2, lVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void j(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.j(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void k(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void l(b.a aVar, int i2, String str, long j2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.l(aVar, i2, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void m(b.a aVar, int i2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.m(aVar, i2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void n(b.a aVar, Exception exc) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.n(aVar, exc);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void o(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.o(aVar);
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        d(i2);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        c.b.a.a.k.b bVar = this.f3073d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return U(new NativeMediaPlaybackException(i2, i3));
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        V();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        e eVar = this.f3075f;
        if (eVar != null) {
            eVar.w();
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void p(b.a aVar, int i2) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.p(aVar, i2);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void q(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.q(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void r(b.a aVar, v.b bVar, v.c cVar) {
        com.google.android.exoplayer2.c0.b bVar2 = this.f3078i;
        if (bVar2 != null) {
            bVar2.r(aVar, bVar, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void s(b.a aVar, s sVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.s(aVar, sVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void t(b.a aVar) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.t(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void u(b.a aVar, boolean z) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.u(aVar, z);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void v(b.a aVar, int i2, long j2, long j3) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.v(aVar, i2, j2, j3);
        }
    }

    @Override // c.b.a.a.k.e
    public void w() {
        this.f3071b.f();
        e eVar = this.f3075f;
        if (eVar != null) {
            eVar.w();
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void x(b.a aVar, Surface surface) {
        com.google.android.exoplayer2.c0.b bVar = this.f3078i;
        if (bVar != null) {
            bVar.x(aVar, surface);
        }
    }

    @Override // com.google.android.exoplayer2.c0.b
    public void y(b.a aVar, v.b bVar, v.c cVar, IOException iOException, boolean z) {
        com.google.android.exoplayer2.c0.b bVar2 = this.f3078i;
        if (bVar2 != null) {
            bVar2.y(aVar, bVar, cVar, iOException, z);
        }
    }

    @Override // c.b.a.a.j.d.b
    public void z(boolean z, int i2) {
        if (i2 == 4) {
            this.f3071b.c();
            if (!this.l) {
                T();
            }
        } else if (i2 == 3 && !this.f3080k) {
            V();
        }
        if (i2 == 3 && z) {
            this.f3071b.e(false);
        }
        if (i2 == 1 && this.m) {
            this.m = false;
            c.b.a.a.j.g.a aVar = this.f3079j.get();
            if (aVar != null) {
                aVar.i();
                this.f3079j = new WeakReference<>(null);
            }
        }
    }
}
