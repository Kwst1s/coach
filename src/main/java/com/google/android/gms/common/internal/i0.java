package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class i0 implements Parcelable.Creator<e> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        p pVar = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                pVar = (p) SafeParcelReader.c(parcel, k2, p.CREATOR);
            } else if (i3 == 2) {
                z = SafeParcelReader.j(parcel, k2);
            } else if (i3 == 3) {
                z2 = SafeParcelReader.j(parcel, k2);
            } else if (i3 == 4) {
                iArr = SafeParcelReader.b(parcel, k2);
            } else if (i3 != 5) {
                SafeParcelReader.p(parcel, k2);
            } else {
                i2 = SafeParcelReader.m(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new e(pVar, z, z2, iArr, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i2) {
        return new e[i2];
    }
}
