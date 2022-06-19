package c.e.a.a.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class i implements Parcelable.Creator<j> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i2 = SafeParcelReader.i(k2);
            if (i2 == 1) {
                arrayList = SafeParcelReader.e(parcel, k2);
            } else if (i2 != 2) {
                SafeParcelReader.p(parcel, k2);
            } else {
                str = SafeParcelReader.d(parcel, k2);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new j(arrayList, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i2) {
        return new j[i2];
    }
}
