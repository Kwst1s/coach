package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IJobCallback */
public interface l extends IInterface {

    /* compiled from: IJobCallback */
    public static abstract class a extends Binder implements l {
        public a() {
            attachInterface(this, "com.firebase.jobdispatcher.IJobCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.firebase.jobdispatcher.IJobCallback");
                M(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.firebase.jobdispatcher.IJobCallback");
                return true;
            }
        }
    }

    void M(Bundle bundle, int i2);
}
