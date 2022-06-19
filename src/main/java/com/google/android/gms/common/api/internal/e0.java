package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.e.a.a.d.b.c;
import c.e.a.a.d.b.l;
import c.e.a.a.d.g;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d0;
import com.google.android.gms.common.internal.n;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class e0 extends c implements d, e {

    /* renamed from: h  reason: collision with root package name */
    private static a.AbstractC0141a<? extends g, c.e.a.a.d.a> f7211h = c.e.a.a.d.d.f3237c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7212a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f7213b;

    /* renamed from: c  reason: collision with root package name */
    private final a.AbstractC0141a<? extends g, c.e.a.a.d.a> f7214c;

    /* renamed from: d  reason: collision with root package name */
    private Set<Scope> f7215d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.gms.common.internal.d f7216e;

    /* renamed from: f  reason: collision with root package name */
    private g f7217f;

    /* renamed from: g  reason: collision with root package name */
    private h0 f7218g;

    public e0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar) {
        this(context, handler, dVar, f7211h);
    }

    /* access modifiers changed from: private */
    public final void Y(l lVar) {
        com.google.android.gms.common.a k2 = lVar.k();
        if (k2.o()) {
            d0 l = lVar.l();
            n.f(l);
            d0 d0Var = l;
            com.google.android.gms.common.a l2 = d0Var.l();
            if (!l2.o()) {
                String valueOf = String.valueOf(l2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f7218g.c(l2);
                this.f7217f.n();
                return;
            }
            this.f7218g.b(d0Var.k(), this.f7215d);
        } else {
            this.f7218g.c(k2);
        }
        this.f7217f.n();
    }

    public final void V() {
        g gVar = this.f7217f;
        if (gVar != null) {
            gVar.n();
        }
    }

    public final void X(h0 h0Var) {
        g gVar = this.f7217f;
        if (gVar != null) {
            gVar.n();
        }
        this.f7216e.f(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0141a<? extends g, c.e.a.a.d.a> aVar = this.f7214c;
        Context context = this.f7212a;
        Looper looper = this.f7213b.getLooper();
        com.google.android.gms.common.internal.d dVar = this.f7216e;
        this.f7217f = (g) aVar.a(context, looper, dVar, dVar.h(), this, this);
        this.f7218g = h0Var;
        Set<Scope> set = this.f7215d;
        if (set == null || set.isEmpty()) {
            this.f7213b.post(new g0(this));
        } else {
            this.f7217f.p();
        }
    }

    @Override // com.google.android.gms.common.api.internal.d
    public final void e(int i2) {
        this.f7217f.n();
    }

    @Override // com.google.android.gms.common.api.internal.j
    public final void i(com.google.android.gms.common.a aVar) {
        this.f7218g.c(aVar);
    }

    @Override // com.google.android.gms.common.api.internal.d
    public final void k(Bundle bundle) {
        this.f7217f.l(this);
    }

    @Override // c.e.a.a.d.b.f
    public final void q(l lVar) {
        this.f7213b.post(new f0(this, lVar));
    }

    private e0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar, a.AbstractC0141a<? extends g, c.e.a.a.d.a> aVar) {
        this.f7212a = context;
        this.f7213b = handler;
        n.g(dVar, "ClientSettings must not be null");
        this.f7216e = dVar;
        this.f7215d = dVar.e();
        this.f7214c = aVar;
    }
}
