package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: GooglePlayJobCallback */
public final class h implements o {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4615a;

    public h(IBinder iBinder) {
        this.f4615a = iBinder;
    }

    @Override // com.firebase.jobdispatcher.o
    public void a(int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
            obtain.writeInt(i2);
            this.f4615a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            obtain.recycle();
            obtain2.recycle();
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
    }
}
