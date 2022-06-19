package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class l implements Parcelable.Creator<Scope> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i3 != 2) {
                SafeParcelReader.p(parcel, k2);
            } else {
                str = SafeParcelReader.d(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new Scope(i2, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i2) {
        return new Scope[i2];
    }
}
