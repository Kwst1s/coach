package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class o {

    /* renamed from: b  reason: collision with root package name */
    private static o f7393b;

    /* renamed from: c  reason: collision with root package name */
    private static final p f7394c = new p(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private p f7395a;

    private o() {
    }

    @RecentlyNonNull
    public static synchronized o b() {
        o oVar;
        synchronized (o.class) {
            if (f7393b == null) {
                f7393b = new o();
            }
            oVar = f7393b;
        }
        return oVar;
    }

    @RecentlyNullable
    public final p a() {
        return this.f7395a;
    }

    public final synchronized void c(p pVar) {
        if (pVar == null) {
            this.f7395a = f7394c;
            return;
        }
        p pVar2 = this.f7395a;
        if (pVar2 == null || pVar2.o() < pVar.o()) {
            this.f7395a = pVar;
        }
    }
}
