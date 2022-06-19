package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class p extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<p> CREATOR = new v0();

    /* renamed from: b  reason: collision with root package name */
    private final int f7396b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7397c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7398d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7399e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7400f;

    public p(int i2, boolean z, boolean z2, int i3, int i4) {
        this.f7396b = i2;
        this.f7397c = z;
        this.f7398d = z2;
        this.f7399e = i3;
        this.f7400f = i4;
    }

    public int k() {
        return this.f7399e;
    }

    public int l() {
        return this.f7400f;
    }

    public boolean m() {
        return this.f7397c;
    }

    public boolean n() {
        return this.f7398d;
    }

    public int o() {
        return this.f7396b;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, o());
        b.c(parcel, 2, m());
        b.c(parcel, 3, n());
        b.f(parcel, 4, k());
        b.f(parcel, 5, l());
        b.b(parcel, a2);
    }
}
