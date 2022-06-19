package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class r extends a {
    public static final Parcelable.Creator<r> CREATOR = new t();

    /* renamed from: b  reason: collision with root package name */
    private final int f7409b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private List<b0> f7410c;

    public r(int i2, @Nullable List<b0> list) {
        this.f7409b = i2;
        this.f7410c = list;
    }

    public final int k() {
        return this.f7409b;
    }

    public final void l(b0 b0Var) {
        if (this.f7410c == null) {
            this.f7410c = new ArrayList();
        }
        this.f7410c.add(b0Var);
    }

    @Nullable
    public final List<b0> m() {
        return this.f7410c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7409b);
        b.m(parcel, 2, this.f7410c, false);
        b.b(parcel, a2);
    }
}
