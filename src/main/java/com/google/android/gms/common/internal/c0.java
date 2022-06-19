package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class c0 extends a {
    public static final Parcelable.Creator<c0> CREATOR = new e0();

    /* renamed from: b  reason: collision with root package name */
    private final int f7325b;

    /* renamed from: c  reason: collision with root package name */
    private final Account f7326c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7327d;

    /* renamed from: e  reason: collision with root package name */
    private final GoogleSignInAccount f7328e;

    c0(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f7325b = i2;
        this.f7326c = account;
        this.f7327d = i3;
        this.f7328e = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7325b);
        b.i(parcel, 2, this.f7326c, i2, false);
        b.f(parcel, 3, this.f7327d);
        b.i(parcel, 4, this.f7328e, i2, false);
        b.b(parcel, a2);
    }

    public c0(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
