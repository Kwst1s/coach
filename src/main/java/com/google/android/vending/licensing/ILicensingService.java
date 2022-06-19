package com.google.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ILicensingService extends IInterface {

    public static abstract class a extends Binder implements ILicensingService {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.vending.licensing.ILicensingService$a$a  reason: collision with other inner class name */
        public static class C0162a implements ILicensingService {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8227a;

            C0162a(IBinder iBinder) {
                this.f8227a = iBinder;
            }

            @Override // com.google.android.vending.licensing.ILicensingService
            public void K(long j2, String str, d dVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f8227a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f8227a;
            }
        }

        public static ILicensingService e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ILicensingService)) {
                return new C0162a(iBinder);
            }
            return (ILicensingService) queryLocalInterface;
        }
    }

    void K(long j2, String str, d dVar);
}
