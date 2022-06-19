package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class v0 implements Parcelable.Creator<p> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i5 = SafeParcelReader.i(k2);
            if (i5 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i5 == 2) {
                z = SafeParcelReader.j(parcel, k2);
            } else if (i5 == 3) {
                z2 = SafeParcelReader.j(parcel, k2);
            } else if (i5 == 4) {
                i3 = SafeParcelReader.m(parcel, k2);
            } else if (i5 != 5) {
                SafeParcelReader.p(parcel, k2);
            } else {
                i4 = SafeParcelReader.m(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new p(i2, z, z2, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p[] newArray(int i2) {
        return new p[i2];
    }
}
