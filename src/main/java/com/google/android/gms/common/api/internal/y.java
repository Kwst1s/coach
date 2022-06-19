package com.google.android.gms.common.api.internal;

import androidx.constraintlayout.widget.i;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class y<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e f7271a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7272b;

    /* renamed from: c  reason: collision with root package name */
    private final b<?> f7273c;

    /* renamed from: d  reason: collision with root package name */
    private final long f7274d;

    private y(e eVar, int i2, b<?> bVar, long j2) {
        this.f7271a = eVar;
        this.f7272b = i2;
        this.f7273c = bVar;
        this.f7274d = j2;
    }

    static <T> y<T> b(e eVar, int i2, b<?> bVar) {
        if (!eVar.s()) {
            return null;
        }
        boolean z = true;
        p a2 = o.b().a();
        if (a2 != null) {
            if (!a2.m()) {
                return null;
            }
            z = a2.n();
            e.a c2 = eVar.c(bVar);
            if (c2 != null && c2.t().b() && (c2.t() instanceof c)) {
                com.google.android.gms.common.internal.e c3 = c(c2, i2);
                if (c3 == null) {
                    return null;
                }
                c2.O();
                z = c3.n();
            }
        }
        return new y<>(eVar, i2, bVar, z ? System.currentTimeMillis() : 0);
    }

    private static com.google.android.gms.common.internal.e c(e.a<?> aVar, int i2) {
        int[] l;
        com.google.android.gms.common.internal.e E = ((c) aVar.t()).E();
        if (E != null) {
            boolean z = false;
            if (E.m() && ((l = E.l()) == null || com.google.android.gms.common.util.a.a(l, i2))) {
                z = true;
            }
            if (z && aVar.N() < E.k()) {
                return E;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.tasks.a
    public final void a(b<T> bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2;
        long j3;
        int i7;
        if (this.f7271a.s()) {
            boolean z = true;
            boolean z2 = this.f7274d > 0;
            p a2 = o.b().a();
            if (a2 == null) {
                i4 = 5000;
                i3 = 0;
                i2 = 100;
            } else if (a2.m()) {
                z2 &= a2.n();
                i4 = a2.k();
                int l = a2.l();
                int o = a2.o();
                e.a c2 = this.f7271a.c(this.f7273c);
                if (c2 != null && c2.t().b() && (c2.t() instanceof c)) {
                    com.google.android.gms.common.internal.e c3 = c(c2, this.f7272b);
                    if (c3 != null) {
                        if (!c3.n() || this.f7274d <= 0) {
                            z = false;
                        }
                        l = c3.k();
                        z2 = z;
                    } else {
                        return;
                    }
                }
                i3 = o;
                i2 = l;
            } else {
                return;
            }
            e eVar = this.f7271a;
            if (bVar.g()) {
                i6 = 0;
                i5 = 0;
            } else {
                if (bVar.e()) {
                    i6 = 100;
                } else {
                    Exception c4 = bVar.c();
                    if (c4 instanceof ApiException) {
                        Status a3 = ((ApiException) c4).a();
                        int l2 = a3.l();
                        com.google.android.gms.common.a k2 = a3.k();
                        if (k2 == null) {
                            i7 = -1;
                        } else {
                            i7 = k2.k();
                        }
                        i5 = i7;
                        i6 = l2;
                    } else {
                        i6 = i.B0;
                    }
                }
                i5 = -1;
            }
            if (z2) {
                j3 = this.f7274d;
                j2 = System.currentTimeMillis();
            } else {
                j3 = 0;
                j2 = 0;
            }
            eVar.g(new b0(this.f7272b, i6, i5, j3, j2), i3, (long) i4, i2);
        }
    }
}
