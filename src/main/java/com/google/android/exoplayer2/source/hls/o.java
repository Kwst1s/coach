package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.a0;

/* compiled from: TimestampAdjusterProvider */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<a0> f6427a = new SparseArray<>();

    public a0 a(int i2) {
        a0 a0Var = this.f6427a.get(i2);
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0Var2 = new a0(Long.MAX_VALUE);
        this.f6427a.put(i2, a0Var2);
        return a0Var2;
    }

    public void b() {
        this.f6427a.clear();
    }
}
