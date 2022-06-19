package com.google.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: ILicenseResultListener */
public interface d extends IInterface {

    /* compiled from: ILicenseResultListener */
    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
                J(parcel.readInt(), parcel.readString(), parcel.readString());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
                return true;
            }
        }
    }

    void J(int i2, String str, String str2);
}
