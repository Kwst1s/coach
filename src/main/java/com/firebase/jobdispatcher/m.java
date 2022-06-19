package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IRemoteJobService */
public interface m extends IInterface {

    /* compiled from: IRemoteJobService */
    public static abstract class a extends Binder implements m {

        /* access modifiers changed from: private */
        /* renamed from: com.firebase.jobdispatcher.m$a$a  reason: collision with other inner class name */
        /* compiled from: IRemoteJobService */
        public static class C0118a implements m {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4620a;

            C0118a(IBinder iBinder) {
                this.f4620a = iBinder;
            }

            @Override // com.firebase.jobdispatcher.m
            public void H(Bundle bundle, boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IRemoteJobService");
                    int i2 = 0;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f4620a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4620a;
            }

            @Override // com.firebase.jobdispatcher.m
            public void s(Bundle bundle, l lVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IRemoteJobService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f4620a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static m e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IRemoteJobService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof m)) {
                return new C0118a(iBinder);
            }
            return (m) queryLocalInterface;
        }
    }

    void H(Bundle bundle, boolean z);

    void s(Bundle bundle, l lVar);
}
