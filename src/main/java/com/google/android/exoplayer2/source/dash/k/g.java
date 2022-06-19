package com.google.android.exoplayer2.source.dash.k;

import com.google.android.exoplayer2.util.d0;

/* compiled from: ProgramInformation */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f6278a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6279b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6280c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6281d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6282e;

    public g(String str, String str2, String str3, String str4, String str5) {
        this.f6278a = str;
        this.f6279b = str2;
        this.f6280c = str3;
        this.f6281d = str4;
        this.f6282e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!d0.b(this.f6278a, gVar.f6278a) || !d0.b(this.f6279b, gVar.f6279b) || !d0.b(this.f6280c, gVar.f6280c) || !d0.b(this.f6281d, gVar.f6281d) || !d0.b(this.f6282e, gVar.f6282e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f6278a;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6279b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6280c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f6281d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f6282e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }
}
