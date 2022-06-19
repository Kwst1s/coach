package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class Status extends a implements h, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new m();
    @RecentlyNonNull

    /* renamed from: g  reason: collision with root package name */
    public static final Status f7128g = new Status(0);
    @RecentlyNonNull

    /* renamed from: h  reason: collision with root package name */
    public static final Status f7129h = new Status(15);
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    public static final Status f7130i = new Status(16);

    /* renamed from: b  reason: collision with root package name */
    private final int f7131b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7132c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7133d;

    /* renamed from: e  reason: collision with root package name */
    private final PendingIntent f7134e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.gms.common.a f7135f;

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this(i2, i3, str, pendingIntent, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f7131b != status.f7131b || this.f7132c != status.f7132c || !m.a(this.f7133d, status.f7133d) || !m.a(this.f7134e, status.f7134e) || !m.a(this.f7135f, status.f7135f)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.h
    @RecentlyNonNull
    public final Status g() {
        return this;
    }

    public final int hashCode() {
        return m.b(Integer.valueOf(this.f7131b), Integer.valueOf(this.f7132c), this.f7133d, this.f7134e, this.f7135f);
    }

    @RecentlyNullable
    public final com.google.android.gms.common.a k() {
        return this.f7135f;
    }

    public final int l() {
        return this.f7132c;
    }

    @RecentlyNullable
    public final String m() {
        return this.f7133d;
    }

    public final boolean n() {
        return this.f7134e != null;
    }

    @RecentlyNonNull
    public final String o() {
        String str = this.f7133d;
        if (str != null) {
            return str;
        }
        return b.a(this.f7132c);
    }

    @RecentlyNonNull
    public final String toString() {
        m.a c2 = m.c(this);
        c2.a("statusCode", o());
        c2.a("resolution", this.f7134e);
        return c2.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, l());
        b.j(parcel, 2, m(), false);
        b.i(parcel, 3, this.f7134e, i2, false);
        b.i(parcel, 4, k(), i2, false);
        b.f(parcel, 1000, this.f7131b);
        b.b(parcel, a2);
    }

    Status(int i2, int i3, String str, PendingIntent pendingIntent, com.google.android.gms.common.a aVar) {
        this.f7131b = i2;
        this.f7132c = i3;
        this.f7133d = str;
        this.f7134e = pendingIntent;
        this.f7135f = aVar;
    }

    public Status(int i2) {
        this(i2, (String) null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    public Status(@RecentlyNonNull com.google.android.gms.common.a aVar, @RecentlyNonNull String str) {
        this(aVar, str, 17);
    }

    @Deprecated
    public Status(@RecentlyNonNull com.google.android.gms.common.a aVar, @RecentlyNonNull String str, int i2) {
        this(1, i2, str, aVar.m(), aVar);
    }
}
