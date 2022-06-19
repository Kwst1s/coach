package com.google.android.exoplayer2.g0;

import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.y;

/* compiled from: TrackSelector */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private e f5851a;

    /* compiled from: TrackSelector */
    public interface a {
    }

    /* access modifiers changed from: protected */
    public final e a() {
        e eVar = this.f5851a;
        com.google.android.exoplayer2.util.e.e(eVar);
        return eVar;
    }

    public final void b(a aVar, e eVar) {
        this.f5851a = eVar;
    }

    public abstract void c(Object obj);

    public abstract j d(y[] yVarArr, c0 c0Var);
}
