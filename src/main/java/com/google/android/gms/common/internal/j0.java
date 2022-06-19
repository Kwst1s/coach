package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class j0 implements Parcelable.Creator<f> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        c[] cVarArr = null;
        c[] cVarArr2 = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < q) {
            int k2 = SafeParcelReader.k(parcel);
            switch (SafeParcelReader.i(k2)) {
                case 1:
                    i2 = SafeParcelReader.m(parcel, k2);
                    break;
                case 2:
                    i3 = SafeParcelReader.m(parcel, k2);
                    break;
                case 3:
                    i4 = SafeParcelReader.m(parcel, k2);
                    break;
                case 4:
                    str = SafeParcelReader.d(parcel, k2);
                    break;
                case 5:
                    iBinder = SafeParcelReader.l(parcel, k2);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.f(parcel, k2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel, k2);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.c(parcel, k2, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.p(parcel, k2);
                    break;
                case 10:
                    cVarArr = (c[]) SafeParcelReader.f(parcel, k2, c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (c[]) SafeParcelReader.f(parcel, k2, c.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.j(parcel, k2);
                    break;
                case 13:
                    i5 = SafeParcelReader.m(parcel, k2);
                    break;
                case 14:
                    z2 = SafeParcelReader.j(parcel, k2);
                    break;
                case 15:
                    str2 = SafeParcelReader.d(parcel, k2);
                    break;
            }
        }
        SafeParcelReader.h(parcel, q);
        return new f(i2, i3, i4, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z, i5, z2, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i2) {
        return new f[i2];
    }
}
