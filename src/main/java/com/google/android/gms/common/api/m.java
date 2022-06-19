package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class m implements Parcelable.Creator<Status> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i4 = SafeParcelReader.i(k2);
            if (i4 == 1) {
                i3 = SafeParcelReader.m(parcel, k2);
            } else if (i4 == 2) {
                str = SafeParcelReader.d(parcel, k2);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.c(parcel, k2, PendingIntent.CREATOR);
            } else if (i4 == 4) {
                aVar = (a) SafeParcelReader.c(parcel, k2, a.CREATOR);
            } else if (i4 != 1000) {
                SafeParcelReader.p(parcel, k2);
            } else {
                i2 = SafeParcelReader.m(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new Status(i2, i3, str, pendingIntent, aVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i2) {
        return new Status[i2];
    }
}
