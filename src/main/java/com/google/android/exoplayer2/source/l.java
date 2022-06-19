package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BaseMediaSource */
public abstract class l implements u {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<u.b> f6512b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private final v.a f6513c = new v.a();

    /* renamed from: d  reason: collision with root package name */
    private g f6514d;

    /* renamed from: e  reason: collision with root package name */
    private b0 f6515e;

    /* renamed from: f  reason: collision with root package name */
    private Object f6516f;

    @Override // com.google.android.exoplayer2.source.u
    public final void e(Handler handler, v vVar) {
        this.f6513c.a(handler, vVar);
    }

    @Override // com.google.android.exoplayer2.source.u
    public final void f(v vVar) {
        this.f6513c.M(vVar);
    }

    @Override // com.google.android.exoplayer2.source.u
    public final void h(u.b bVar) {
        this.f6512b.remove(bVar);
        if (this.f6512b.isEmpty()) {
            this.f6514d = null;
            this.f6515e = null;
            this.f6516f = null;
            o();
        }
    }

    @Override // com.google.android.exoplayer2.source.u
    public final void i(g gVar, boolean z, u.b bVar, x xVar) {
        g gVar2 = this.f6514d;
        e.a(gVar2 == null || gVar2 == gVar);
        this.f6512b.add(bVar);
        if (this.f6514d == null) {
            this.f6514d = gVar;
            m(gVar, z, xVar);
            return;
        }
        b0 b0Var = this.f6515e;
        if (b0Var != null) {
            bVar.c(this, b0Var, this.f6516f);
        }
    }

    /* access modifiers changed from: protected */
    public final v.a j(u.a aVar) {
        return this.f6513c.P(0, aVar, 0);
    }

    /* access modifiers changed from: protected */
    public final v.a l(u.a aVar, long j2) {
        e.a(aVar != null);
        return this.f6513c.P(0, aVar, j2);
    }

    /* access modifiers changed from: protected */
    public abstract void m(g gVar, boolean z, x xVar);

    /* access modifiers changed from: protected */
    public final void n(b0 b0Var, Object obj) {
        this.f6515e = b0Var;
        this.f6516f = obj;
        Iterator<u.b> it = this.f6512b.iterator();
        while (it.hasNext()) {
            it.next().c(this, b0Var, obj);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void o();
}
