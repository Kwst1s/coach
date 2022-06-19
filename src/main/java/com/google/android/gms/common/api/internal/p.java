package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f7251a;

    public p(int i2) {
        this.f7251a = i2;
    }

    /* access modifiers changed from: private */
    public static Status f(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void b(Status status);

    public abstract void c(e.a<?> aVar);

    public abstract void d(r0 r0Var, boolean z);

    public abstract void e(Exception exc);
}
