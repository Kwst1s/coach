package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class Scope extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new l();

    /* renamed from: b  reason: collision with root package name */
    private final int f7126b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7127c;

    Scope(int i2, String str) {
        n.e(str, "scopeUri must not be null or empty");
        this.f7126b = i2;
        this.f7127c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f7127c.equals(((Scope) obj).f7127c);
    }

    public final int hashCode() {
        return this.f7127c.hashCode();
    }

    @RecentlyNonNull
    public final String k() {
        return this.f7127c;
    }

    @RecentlyNonNull
    public final String toString() {
        return this.f7127c;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7126b);
        b.j(parcel, 2, k(), false);
        b.b(parcel, a2);
    }

    public Scope(@RecentlyNonNull String str) {
        this(1, str);
    }
}
