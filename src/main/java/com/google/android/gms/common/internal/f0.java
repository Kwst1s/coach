package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class f0 implements Parcelable.Creator<d0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0 createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i3 == 2) {
                iBinder = SafeParcelReader.l(parcel, k2);
            } else if (i3 == 3) {
                aVar = (a) SafeParcelReader.c(parcel, k2, a.CREATOR);
            } else if (i3 == 4) {
                z = SafeParcelReader.j(parcel, k2);
            } else if (i3 != 5) {
                SafeParcelReader.p(parcel, k2);
            } else {
                z2 = SafeParcelReader.j(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new d0(i2, iBinder, aVar, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0[] newArray(int i2) {
        return new d0[i2];
    }
}
