package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class a0 implements Parcelable.Creator<b0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b0 createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i5 = SafeParcelReader.i(k2);
            if (i5 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i5 == 2) {
                i3 = SafeParcelReader.m(parcel, k2);
            } else if (i5 == 3) {
                i4 = SafeParcelReader.m(parcel, k2);
            } else if (i5 == 4) {
                j2 = SafeParcelReader.n(parcel, k2);
            } else if (i5 != 5) {
                SafeParcelReader.p(parcel, k2);
            } else {
                j3 = SafeParcelReader.n(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new b0(i2, i3, i4, j2, j3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b0[] newArray(int i2) {
        return new b0[i2];
    }
}
