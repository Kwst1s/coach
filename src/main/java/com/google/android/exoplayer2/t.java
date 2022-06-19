package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g0.h;
import com.google.android.exoplayer2.source.c0;

/* compiled from: Player */
public interface t {

    @Deprecated
    /* compiled from: Player */
    public static abstract class a implements b {
        @Override // com.google.android.exoplayer2.t.b
        public /* synthetic */ void D(c0 c0Var, h hVar) {
            u.f(this, c0Var, hVar);
        }

        @Deprecated
        public void a(b0 b0Var, Object obj) {
        }

        @Override // com.google.android.exoplayer2.t.b
        public /* synthetic */ void c(int i2) {
            u.d(this, i2);
        }

        @Override // com.google.android.exoplayer2.t.b
        public /* synthetic */ void f(s sVar) {
            u.b(this, sVar);
        }

        @Override // com.google.android.exoplayer2.t.b
        public /* synthetic */ void i(boolean z) {
            u.a(this, z);
        }

        @Override // com.google.android.exoplayer2.t.b
        public /* synthetic */ void j(int i2) {
            u.c(this, i2);
        }

        @Override // com.google.android.exoplayer2.t.b
        public void p(b0 b0Var, Object obj, int i2) {
            a(b0Var, obj);
        }

        @Override // com.google.android.exoplayer2.t.b
        public /* synthetic */ void s() {
            u.e(this);
        }
    }

    /* compiled from: Player */
    public interface b {
        void D(c0 c0Var, h hVar);

        void c(int i2);

        void f(s sVar);

        void h(boolean z, int i2);

        void i(boolean z);

        void j(int i2);

        void p(b0 b0Var, Object obj, int i2);

        void q(ExoPlaybackException exoPlaybackException);

        void s();
    }

    void a();

    s d();

    void e(long j2);

    void f(boolean z);

    long g();

    long getCurrentPosition();

    long getDuration();

    long h();

    void i(int i2, long j2);

    int j();

    long k();

    boolean l();

    void m(boolean z);

    int n();

    int o();

    int p();

    int q();

    void r(b bVar);

    int s();

    void setRepeatMode(int i2);

    void stop();

    int t();

    b0 u();

    boolean v();

    int w();
}
