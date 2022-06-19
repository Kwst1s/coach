package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            switch (SafeParcelReader.i(k2)) {
                case 1:
                    i2 = SafeParcelReader.m(parcel, k2);
                    break;
                case 2:
                    str = SafeParcelReader.d(parcel, k2);
                    break;
                case 3:
                    str2 = SafeParcelReader.d(parcel, k2);
                    break;
                case 4:
                    str3 = SafeParcelReader.d(parcel, k2);
                    break;
                case 5:
                    str4 = SafeParcelReader.d(parcel, k2);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.c(parcel, k2, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.d(parcel, k2);
                    break;
                case 8:
                    j2 = SafeParcelReader.n(parcel, k2);
                    break;
                case 9:
                    str6 = SafeParcelReader.d(parcel, k2);
                    break;
                case 10:
                    arrayList = SafeParcelReader.g(parcel, k2, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.d(parcel, k2);
                    break;
                case 12:
                    str8 = SafeParcelReader.d(parcel, k2);
                    break;
                default:
                    SafeParcelReader.p(parcel, k2);
                    break;
            }
        }
        SafeParcelReader.h(parcel, q);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
