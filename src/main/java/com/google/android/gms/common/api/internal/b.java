package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.m;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7166a;

    /* renamed from: b  reason: collision with root package name */
    private final a<O> f7167b;

    /* renamed from: c  reason: collision with root package name */
    private final O f7168c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7169d;

    private b(a<O> aVar, O o, String str) {
        this.f7167b = aVar;
        this.f7168c = o;
        this.f7169d = str;
        this.f7166a = m.b(aVar, o, str);
    }

    @RecentlyNonNull
    public static <O extends a.d> b<O> a(@RecentlyNonNull a<O> aVar, O o, String str) {
        return new b<>(aVar, o, str);
    }

    @RecentlyNonNull
    public final String b() {
        return this.f7167b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return m.a(this.f7167b, bVar.f7167b) && m.a(this.f7168c, bVar.f7168c) && m.a(this.f7169d, bVar.f7169d);
    }

    public final int hashCode() {
        return this.f7166a;
    }
}
