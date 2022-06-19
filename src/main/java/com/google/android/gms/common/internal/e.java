package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class e extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<e> CREATOR = new i0();

    /* renamed from: b  reason: collision with root package name */
    private final p f7348b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7349c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7350d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f7351e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7352f;

    public e(@RecentlyNonNull p pVar, boolean z, boolean z2, int[] iArr, int i2) {
        this.f7348b = pVar;
        this.f7349c = z;
        this.f7350d = z2;
        this.f7351e = iArr;
        this.f7352f = i2;
    }

    public int k() {
        return this.f7352f;
    }

    @RecentlyNullable
    public int[] l() {
        return this.f7351e;
    }

    public boolean m() {
        return this.f7349c;
    }

    public boolean n() {
        return this.f7350d;
    }

    @RecentlyNonNull
    public p o() {
        return this.f7348b;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.i(parcel, 1, o(), i2, false);
        b.c(parcel, 2, m());
        b.c(parcel, 3, n());
        b.g(parcel, 4, l(), false);
        b.f(parcel, 5, k());
        b.b(parcel, a2);
    }
}
