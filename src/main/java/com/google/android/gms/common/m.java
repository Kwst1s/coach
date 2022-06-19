package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class m implements Parcelable.Creator<a> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i4 = SafeParcelReader.i(k2);
            if (i4 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i4 == 2) {
                i3 = SafeParcelReader.m(parcel, k2);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.c(parcel, k2, PendingIntent.CREATOR);
            } else if (i4 != 4) {
                SafeParcelReader.p(parcel, k2);
            } else {
                str = SafeParcelReader.d(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new a(i2, i3, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}
