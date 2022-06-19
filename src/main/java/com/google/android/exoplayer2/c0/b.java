package com.google.android.exoplayer2.c0;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.d0.d;
import com.google.android.exoplayer2.g0.h;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import java.io.IOException;

/* compiled from: AnalyticsListener */
public interface b {

    /* compiled from: AnalyticsListener */
    public static final class a {
        public a(long j2, b0 b0Var, int i2, u.a aVar, long j3, long j4, long j5) {
        }
    }

    void A(a aVar, int i2, d dVar);

    void C(a aVar, com.google.android.exoplayer2.f0.a aVar2);

    void D(a aVar, int i2);

    void E(a aVar, int i2, d dVar);

    void F(a aVar, boolean z, int i2);

    void G(a aVar);

    void H(a aVar);

    void I(a aVar);

    void J(a aVar);

    void K(a aVar, c0 c0Var, h hVar);

    void L(a aVar, int i2);

    void M(a aVar, v.c cVar);

    void N(a aVar, ExoPlaybackException exoPlaybackException);

    void O(a aVar, v.c cVar);

    void b(a aVar, int i2, long j2, long j3);

    void c(a aVar, int i2, int i3, int i4, float f2);

    void e(a aVar, v.b bVar, v.c cVar);

    void f(a aVar, int i2, long j2);

    void h(a aVar, v.b bVar, v.c cVar);

    void i(a aVar, int i2, l lVar);

    void j(a aVar);

    void k(a aVar);

    void l(a aVar, int i2, String str, long j2);

    void m(a aVar, int i2);

    void n(a aVar, Exception exc);

    void o(a aVar);

    void p(a aVar, int i2);

    void q(a aVar);

    void r(a aVar, v.b bVar, v.c cVar);

    void s(a aVar, s sVar);

    void t(a aVar);

    void u(a aVar, boolean z);

    void v(a aVar, int i2, long j2, long j3);

    void x(a aVar, Surface surface);

    void y(a aVar, v.b bVar, v.c cVar, IOException iOException, boolean z);
}
