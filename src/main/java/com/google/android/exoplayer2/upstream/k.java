package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.e;
import java.util.Arrays;

/* compiled from: DataSpec */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f6922a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6923b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f6924c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6925d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6926e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6927f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6928g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6929h;

    public k(Uri uri, int i2) {
        this(uri, 0, -1, null, i2);
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return "GET";
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "HEAD";
        }
        throw new AssertionError(i2);
    }

    public final String a() {
        return b(this.f6923b);
    }

    public boolean c(int i2) {
        return (this.f6929h & i2) == i2;
    }

    public k d(long j2) {
        long j3 = this.f6927f;
        long j4 = -1;
        if (j3 != -1) {
            j4 = j3 - j2;
        }
        return e(j2, j4);
    }

    public k e(long j2, long j3) {
        if (j2 == 0 && this.f6927f == j3) {
            return this;
        }
        return new k(this.f6922a, this.f6923b, this.f6924c, this.f6925d + j2, this.f6926e + j2, j3, this.f6928g, this.f6929h);
    }

    public String toString() {
        return "DataSpec[" + a() + " " + this.f6922a + ", " + Arrays.toString(this.f6924c) + ", " + this.f6925d + ", " + this.f6926e + ", " + this.f6927f + ", " + this.f6928g + ", " + this.f6929h + "]";
    }

    public k(Uri uri, long j2, long j3, String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    public k(Uri uri, long j2, long j3, String str, int i2) {
        this(uri, j2, j2, j3, str, i2);
    }

    public k(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public k(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        this(uri, bArr != null ? 2 : 1, bArr, j2, j3, j4, str, i2);
    }

    public k(Uri uri, int i2, byte[] bArr, long j2, long j3, long j4, String str, int i3) {
        byte[] bArr2 = bArr;
        boolean z = true;
        e.a(j2 >= 0);
        e.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        e.a(z);
        this.f6922a = uri;
        this.f6923b = i2;
        this.f6924c = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f6925d = j2;
        this.f6926e = j3;
        this.f6927f = j4;
        this.f6928g = str;
        this.f6929h = i3;
    }
}
