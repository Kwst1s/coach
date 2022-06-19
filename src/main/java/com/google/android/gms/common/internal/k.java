package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
final class k implements l {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f7376a;

    k(IBinder iBinder) {
        this.f7376a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f7376a;
    }

    @Override // com.google.android.gms.common.internal.l
    public final void x(j jVar, f fVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            if (fVar != null) {
                obtain.writeInt(1);
                fVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7376a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
