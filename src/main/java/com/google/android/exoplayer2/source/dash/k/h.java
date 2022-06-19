package com.google.android.exoplayer2.source.dash.k;

import android.net.Uri;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.util.c0;

/* compiled from: RangedUri */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final long f6283a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6284b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6285c;

    /* renamed from: d  reason: collision with root package name */
    private int f6286d;

    public h(String str, long j2, long j3) {
        this.f6285c = str == null ? BuildConfig.FLAVOR : str;
        this.f6283a = j2;
        this.f6284b = j3;
    }

    public h a(h hVar, String str) {
        String c2 = c(str);
        if (hVar != null && c2.equals(hVar.c(str))) {
            long j2 = this.f6284b;
            long j3 = -1;
            if (j2 != -1) {
                long j4 = this.f6283a;
                if (j4 + j2 == hVar.f6283a) {
                    long j5 = hVar.f6284b;
                    if (j5 != -1) {
                        j3 = j2 + j5;
                    }
                    return new h(c2, j4, j3);
                }
            }
            long j6 = hVar.f6284b;
            if (j6 != -1) {
                long j7 = hVar.f6283a;
                if (j7 + j6 == this.f6283a) {
                    if (j2 != -1) {
                        j3 = j6 + j2;
                    }
                    return new h(c2, j7, j3);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return c0.d(str, this.f6285c);
    }

    public String c(String str) {
        return c0.c(str, this.f6285c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f6283a == hVar.f6283a && this.f6284b == hVar.f6284b && this.f6285c.equals(hVar.f6285c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f6286d == 0) {
            this.f6286d = ((((527 + ((int) this.f6283a)) * 31) + ((int) this.f6284b)) * 31) + this.f6285c.hashCode();
        }
        return this.f6286d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f6285c + ", start=" + this.f6283a + ", length=" + this.f6284b + ")";
    }
}
