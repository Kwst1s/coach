package c.e.a.a.d.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class d implements Parcelable.Creator<b> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i4 = SafeParcelReader.i(k2);
            if (i4 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i4 == 2) {
                i3 = SafeParcelReader.m(parcel, k2);
            } else if (i4 != 3) {
                SafeParcelReader.p(parcel, k2);
            } else {
                intent = (Intent) SafeParcelReader.c(parcel, k2, Intent.CREATOR);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new b(i2, i3, intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}
