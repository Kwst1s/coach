package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.c;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class g<T extends IInterface> extends c<T> implements a.f {
    private final Set<Scope> x;
    private final Account y;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected g(@androidx.annotation.RecentlyNonNull android.content.Context r10, @androidx.annotation.RecentlyNonNull android.os.Looper r11, int r12, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.d r13, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.d r14, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.j r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.h r3 = com.google.android.gms.common.internal.h.b(r10)
            com.google.android.gms.common.d r4 = com.google.android.gms.common.d.m()
            com.google.android.gms.common.internal.n.f(r14)
            r7 = r14
            com.google.android.gms.common.api.internal.d r7 = (com.google.android.gms.common.api.internal.d) r7
            com.google.android.gms.common.internal.n.f(r15)
            r8 = r15
            com.google.android.gms.common.api.internal.j r8 = (com.google.android.gms.common.api.internal.j) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.g.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.d, com.google.android.gms.common.api.internal.d, com.google.android.gms.common.api.internal.j):void");
    }

    private static c.a k0(d dVar) {
        if (dVar == null) {
            return null;
        }
        return new x(dVar);
    }

    private static c.b l0(j jVar) {
        if (jVar == null) {
            return null;
        }
        return new y(jVar);
    }

    private final Set<Scope> m0(Set<Scope> set) {
        j0(set);
        for (Scope scope : set) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> c() {
        return o() ? this.x : Collections.emptySet();
    }

    /* access modifiers changed from: protected */
    public Set<Scope> j0(@RecentlyNonNull Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.c
    @RecentlyNullable
    public final Account t() {
        return this.y;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    @RecentlyNonNull
    public final Set<Scope> z() {
        return this.x;
    }

    @Deprecated
    protected g(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, int i2, @RecentlyNonNull d dVar, @RecentlyNonNull com.google.android.gms.common.api.d dVar2, @RecentlyNonNull e eVar) {
        this(context, looper, i2, dVar, (d) dVar2, (j) eVar);
    }

    private g(Context context, Looper looper, h hVar, com.google.android.gms.common.d dVar, int i2, d dVar2, d dVar3, j jVar) {
        super(context, looper, hVar, dVar, i2, k0(dVar3), l0(jVar), dVar2.g());
        this.y = dVar2.a();
        Set<Scope> c2 = dVar2.c();
        m0(c2);
        this.x = c2;
    }
}
