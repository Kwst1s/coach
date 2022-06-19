package c.e.a.a.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.c0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class m implements Parcelable.Creator<k> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        int i2 = 0;
        c0 c0Var = null;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i3 = SafeParcelReader.i(k2);
            if (i3 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i3 != 2) {
                SafeParcelReader.p(parcel, k2);
            } else {
                c0Var = (c0) SafeParcelReader.c(parcel, k2, c0.CREATOR);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new k(i2, c0Var);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k[] newArray(int i2) {
        return new k[i2];
    }
}
