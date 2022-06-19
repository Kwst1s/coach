package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class h0 extends a {
    public static final Parcelable.Creator<h0> CREATOR = new g0();

    /* renamed from: b  reason: collision with root package name */
    Bundle f7372b;

    /* renamed from: c  reason: collision with root package name */
    c[] f7373c;

    /* renamed from: d  reason: collision with root package name */
    private int f7374d;

    /* renamed from: e  reason: collision with root package name */
    e f7375e;

    h0(Bundle bundle, c[] cVarArr, int i2, e eVar) {
        this.f7372b = bundle;
        this.f7373c = cVarArr;
        this.f7374d = i2;
        this.f7375e = eVar;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.d(parcel, 1, this.f7372b, false);
        b.l(parcel, 2, this.f7373c, i2, false);
        b.f(parcel, 3, this.f7374d);
        b.i(parcel, 4, this.f7375e, i2, false);
        b.b(parcel, a2);
    }

    public h0() {
    }
}
