package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.c;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
abstract class d0<T> extends l0 {

    /* renamed from: b  reason: collision with root package name */
    protected final c<T> f7181b;

    public d0(int i2, c<T> cVar) {
        super(i2);
        this.f7181b = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public void b(Status status) {
        this.f7181b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void c(e.a<?> aVar) {
        try {
            i(aVar);
        } catch (DeadObjectException e2) {
            b(p.f(e2));
            throw e2;
        } catch (RemoteException e3) {
            b(p.f(e3));
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.p
    public void e(Exception exc) {
        this.f7181b.d(exc);
    }

    /* access modifiers changed from: protected */
    public abstract void i(e.a<?> aVar);
}
