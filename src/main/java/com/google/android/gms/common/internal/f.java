package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class f extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<f> CREATOR = new j0();

    /* renamed from: b  reason: collision with root package name */
    private final int f7353b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7354c;

    /* renamed from: d  reason: collision with root package name */
    private int f7355d;

    /* renamed from: e  reason: collision with root package name */
    String f7356e;

    /* renamed from: f  reason: collision with root package name */
    IBinder f7357f;

    /* renamed from: g  reason: collision with root package name */
    Scope[] f7358g;

    /* renamed from: h  reason: collision with root package name */
    Bundle f7359h;

    /* renamed from: i  reason: collision with root package name */
    Account f7360i;

    /* renamed from: j  reason: collision with root package name */
    c[] f7361j;

    /* renamed from: k  reason: collision with root package name */
    c[] f7362k;
    private boolean l;
    private int m;
    boolean n;
    private final String o;

    public f(int i2, String str) {
        this.f7353b = 6;
        this.f7355d = e.f7288a;
        this.f7354c = i2;
        this.l = true;
        this.o = str;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7353b);
        b.f(parcel, 2, this.f7354c);
        b.f(parcel, 3, this.f7355d);
        b.j(parcel, 4, this.f7356e, false);
        b.e(parcel, 5, this.f7357f, false);
        b.l(parcel, 6, this.f7358g, i2, false);
        b.d(parcel, 7, this.f7359h, false);
        b.i(parcel, 8, this.f7360i, i2, false);
        b.l(parcel, 10, this.f7361j, i2, false);
        b.l(parcel, 11, this.f7362k, i2, false);
        b.c(parcel, 12, this.l);
        b.f(parcel, 13, this.m);
        b.c(parcel, 14, this.n);
        b.j(parcel, 15, this.o, false);
        b.b(parcel, a2);
    }

    f(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2, String str2) {
        this.f7353b = i2;
        this.f7354c = i3;
        this.f7355d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f7356e = "com.google.android.gms";
        } else {
            this.f7356e = str;
        }
        if (i2 < 2) {
            this.f7360i = iBinder != null ? a.k(i.a.i(iBinder)) : null;
        } else {
            this.f7357f = iBinder;
            this.f7360i = account;
        }
        this.f7358g = scopeArr;
        this.f7359h = bundle;
        this.f7361j = cVarArr;
        this.f7362k = cVarArr2;
        this.l = z;
        this.m = i5;
        this.n = z2;
        this.o = str2;
    }
}
