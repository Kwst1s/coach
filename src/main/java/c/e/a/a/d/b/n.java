package c.e.a.a.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.a;
import com.google.android.gms.common.internal.d0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class n implements Parcelable.Creator<l> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        a aVar = null;
        d0 d0Var = null;
        int i2 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i3 == 2) {
                aVar = (a) SafeParcelReader.c(parcel, k2, a.CREATOR);
            } else if (i3 != 3) {
                SafeParcelReader.p(parcel, k2);
            } else {
                d0Var = (d0) SafeParcelReader.c(parcel, k2, d0.CREATOR);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new l(i2, aVar, d0Var);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i2) {
        return new l[i2];
    }
}
