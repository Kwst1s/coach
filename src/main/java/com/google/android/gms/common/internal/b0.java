package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class b0 extends a {
    public static final Parcelable.Creator<b0> CREATOR = new a0();

    /* renamed from: b  reason: collision with root package name */
    private final int f7294b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7295c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7296d;

    /* renamed from: e  reason: collision with root package name */
    private final long f7297e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7298f;

    public b0(int i2, int i3, int i4, long j2, long j3) {
        this.f7294b = i2;
        this.f7295c = i3;
        this.f7296d = i4;
        this.f7297e = j2;
        this.f7298f = j3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7294b);
        b.f(parcel, 2, this.f7295c);
        b.f(parcel, 3, this.f7296d);
        b.h(parcel, 4, this.f7297e);
        b.h(parcel, 5, this.f7298f);
        b.b(parcel, a2);
    }
}
