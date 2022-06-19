package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class t implements Parcelable.Creator<r> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        int i2 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i3 != 2) {
                SafeParcelReader.p(parcel, k2);
            } else {
                arrayList = SafeParcelReader.g(parcel, k2, b0.CREATOR);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new r(i2, arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r[] newArray(int i2) {
        return new r[i2];
    }
}
