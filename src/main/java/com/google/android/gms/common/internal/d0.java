package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class d0 extends a {
    public static final Parcelable.Creator<d0> CREATOR = new f0();

    /* renamed from: b  reason: collision with root package name */
    private final int f7343b;

    /* renamed from: c  reason: collision with root package name */
    private IBinder f7344c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.gms.common.a f7345d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7346e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7347f;

    d0(int i2, IBinder iBinder, com.google.android.gms.common.a aVar, boolean z, boolean z2) {
        this.f7343b = i2;
        this.f7344c = iBinder;
        this.f7345d = aVar;
        this.f7346e = z;
        this.f7347f = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f7345d.equals(d0Var.f7345d) && m.a(k(), d0Var.k());
    }

    public final i k() {
        IBinder iBinder = this.f7344c;
        if (iBinder == null) {
            return null;
        }
        return i.a.i(iBinder);
    }

    public final com.google.android.gms.common.a l() {
        return this.f7345d;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7343b);
        b.e(parcel, 2, this.f7344c, false);
        b.i(parcel, 3, this.f7345d, i2, false);
        b.c(parcel, 4, this.f7346e);
        b.c(parcel, 5, this.f7347f);
        b.b(parcel, a2);
    }
}
