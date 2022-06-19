package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class c extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<c> CREATOR = new n();

    /* renamed from: b  reason: collision with root package name */
    private final String f7280b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private final int f7281c;

    /* renamed from: d  reason: collision with root package name */
    private final long f7282d;

    public c(@RecentlyNonNull String str, long j2) {
        this.f7280b = str;
        this.f7282d = j2;
        this.f7281c = -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (((k() == null || !k().equals(cVar.k())) && (k() != null || cVar.k() != null)) || l() != cVar.l()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return m.b(k(), Long.valueOf(l()));
    }

    @RecentlyNonNull
    public String k() {
        return this.f7280b;
    }

    public long l() {
        long j2 = this.f7282d;
        return j2 == -1 ? (long) this.f7281c : j2;
    }

    @RecentlyNonNull
    public String toString() {
        m.a c2 = m.c(this);
        c2.a("name", k());
        c2.a("version", Long.valueOf(l()));
        return c2.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.j(parcel, 1, k(), false);
        b.f(parcel, 2, this.f7281c);
        b.h(parcel, 3, l());
        b.b(parcel, a2);
    }

    public c(@RecentlyNonNull String str, int i2, long j2) {
        this.f7280b = str;
        this.f7281c = i2;
        this.f7282d = j2;
    }
}
