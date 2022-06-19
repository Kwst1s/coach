package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.util.d0;

/* compiled from: BasePlayer */
public abstract class b implements t {

    /* renamed from: a  reason: collision with root package name */
    protected final b0.c f4884a = new b0.c();

    private int y() {
        int t = t();
        if (t == 1) {
            return 0;
        }
        return t;
    }

    @Override // com.google.android.exoplayer2.t
    public final void e(long j2) {
        i(w(), j2);
    }

    @Override // com.google.android.exoplayer2.t
    public final int j() {
        b0 u = u();
        if (u.r()) {
            return -1;
        }
        return u.l(w(), y(), v());
    }

    @Override // com.google.android.exoplayer2.t
    public final int o() {
        long k2 = k();
        long duration = getDuration();
        if (k2 == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return d0.n((int) ((k2 * 100) / duration), 0, 100);
    }

    @Override // com.google.android.exoplayer2.t
    public final int q() {
        b0 u = u();
        if (u.r()) {
            return -1;
        }
        return u.e(w(), y(), v());
    }

    @Override // com.google.android.exoplayer2.t
    public final void stop() {
        m(false);
    }

    public final long x() {
        b0 u = u();
        if (u.r()) {
            return -9223372036854775807L;
        }
        return u.n(w(), this.f4884a).c();
    }
}
