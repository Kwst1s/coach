package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class e0 implements Parcelable.Creator<c0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0 createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            int i4 = SafeParcelReader.i(k2);
            if (i4 == 1) {
                i2 = SafeParcelReader.m(parcel, k2);
            } else if (i4 == 2) {
                account = (Account) SafeParcelReader.c(parcel, k2, Account.CREATOR);
            } else if (i4 == 3) {
                i3 = SafeParcelReader.m(parcel, k2);
            } else if (i4 != 4) {
                SafeParcelReader.p(parcel, k2);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.c(parcel, k2, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.h(parcel, q);
        return new c0(i2, account, i3, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0[] newArray(int i2) {
        return new c0[i2];
    }
}
