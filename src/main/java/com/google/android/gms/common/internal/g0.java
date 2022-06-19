package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class g0 implements Parcelable.Creator<h0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h0 createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        Bundle bundle = null;
        c[] cVarArr = null;
        e eVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                bundle = SafeParcelReader.a(parcel, k2);
            } else if (i3 == 2) {
                cVarArr = (c[]) SafeParcelReader.f(parcel, k2, c.CREATOR);
            } else if (i3 == 3) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i3 != 4) {
                SafeParcelReader.p(parcel, k2);
            } else {
                eVar = (e) SafeParcelReader.c(parcel, k2, e.CREATOR);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new h0(bundle, cVarArr, i2, eVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h0[] newArray(int i2) {
        return new h0[i2];
    }
}
