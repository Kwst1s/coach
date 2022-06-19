package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.g0.i;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.f;

/* compiled from: ExoPlayerFactory */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static e f5856a;

    private static synchronized e a() {
        e eVar;
        synchronized (h.class) {
            if (f5856a == null) {
                f5856a = new m.b().a();
            }
            eVar = f5856a;
        }
        return eVar;
    }

    public static g b(x[] xVarArr, i iVar, n nVar) {
        return c(xVarArr, iVar, nVar, d0.C());
    }

    public static g c(x[] xVarArr, i iVar, n nVar, Looper looper) {
        return d(xVarArr, iVar, nVar, a(), looper);
    }

    public static g d(x[] xVarArr, i iVar, n nVar, e eVar, Looper looper) {
        return new i(xVarArr, iVar, nVar, eVar, f.f7015a, looper);
    }
}
