package com.google.android.exoplayer2.source.dash.k;

import com.google.android.exoplayer2.util.d0;

/* compiled from: Descriptor */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f6266a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6267b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6268c;

    public d(String str, String str2, String str3) {
        this.f6266a = str;
        this.f6267b = str2;
        this.f6268c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!d0.b(this.f6266a, dVar.f6266a) || !d0.b(this.f6267b, dVar.f6267b) || !d0.b(this.f6268c, dVar.f6268c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f6266a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f6267b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6268c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }
}
