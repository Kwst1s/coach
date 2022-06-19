package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.c;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class n0<ResultT> extends l0 {

    /* renamed from: b  reason: collision with root package name */
    private final n<a.b, ResultT> f7243b;

    /* renamed from: c  reason: collision with root package name */
    private final c<ResultT> f7244c;

    /* renamed from: d  reason: collision with root package name */
    private final m f7245d;

    public n0(int i2, n<a.b, ResultT> nVar, c<ResultT> cVar, m mVar) {
        super(i2);
        this.f7244c = cVar;
        this.f7243b = nVar;
        this.f7245d = mVar;
        if (i2 == 2 && nVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void b(Status status) {
        this.f7244c.d(this.f7245d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void c(e.a<?> aVar) {
        try {
            this.f7243b.b(aVar.t(), this.f7244c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            b(p.f(e3));
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void d(r0 r0Var, boolean z) {
        r0Var.b(this.f7244c, z);
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void e(Exception exc) {
        this.f7244c.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final com.google.android.gms.common.c[] g(e.a<?> aVar) {
        return this.f7243b.d();
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final boolean h(e.a<?> aVar) {
        return this.f7243b.c();
    }
}
