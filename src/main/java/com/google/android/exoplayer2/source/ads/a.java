package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.e;
import java.util.Arrays;

/* compiled from: AdPlaybackState */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f6068f = new a(new long[0]);

    /* renamed from: a  reason: collision with root package name */
    public final int f6069a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f6070b;

    /* renamed from: c  reason: collision with root package name */
    public final C0131a[] f6071c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6072d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6073e;

    /* renamed from: com.google.android.exoplayer2.source.ads.a$a  reason: collision with other inner class name */
    /* compiled from: AdPlaybackState */
    public static final class C0131a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6074a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri[] f6075b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f6076c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f6077d;

        public C0131a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        public int a() {
            return b(-1);
        }

        public int b(int i2) {
            int i3 = i2 + 1;
            while (true) {
                int[] iArr = this.f6076c;
                if (i3 >= iArr.length || iArr[i3] == 0 || iArr[i3] == 1) {
                    return i3;
                }
                i3++;
            }
            return i3;
        }

        public boolean c() {
            return this.f6074a == -1 || a() < this.f6074a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0131a.class != obj.getClass()) {
                return false;
            }
            C0131a aVar = (C0131a) obj;
            if (this.f6074a != aVar.f6074a || !Arrays.equals(this.f6075b, aVar.f6075b) || !Arrays.equals(this.f6076c, aVar.f6076c) || !Arrays.equals(this.f6077d, aVar.f6077d)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((this.f6074a * 31) + Arrays.hashCode(this.f6075b)) * 31) + Arrays.hashCode(this.f6076c)) * 31) + Arrays.hashCode(this.f6077d);
        }

        private C0131a(int i2, int[] iArr, Uri[] uriArr, long[] jArr) {
            e.a(iArr.length == uriArr.length);
            this.f6074a = i2;
            this.f6076c = iArr;
            this.f6075b = uriArr;
            this.f6077d = jArr;
        }
    }

    public a(long... jArr) {
        int length = jArr.length;
        this.f6069a = length;
        this.f6070b = Arrays.copyOf(jArr, length);
        this.f6071c = new C0131a[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.f6071c[i2] = new C0131a();
        }
        this.f6072d = 0;
        this.f6073e = -9223372036854775807L;
    }

    private boolean c(long j2, int i2) {
        long j3 = this.f6070b[i2];
        if (j3 == Long.MIN_VALUE) {
            long j4 = this.f6073e;
            if (j4 == -9223372036854775807L || j2 < j4) {
                return true;
            }
            return false;
        } else if (j2 < j3) {
            return true;
        } else {
            return false;
        }
    }

    public int a(long j2) {
        int i2 = 0;
        while (true) {
            long[] jArr = this.f6070b;
            if (i2 < jArr.length && jArr[i2] != Long.MIN_VALUE && (j2 >= jArr[i2] || !this.f6071c[i2].c())) {
                i2++;
            }
        }
        if (i2 < this.f6070b.length) {
            return i2;
        }
        return -1;
    }

    public int b(long j2) {
        int length = this.f6070b.length - 1;
        while (length >= 0 && c(j2, length)) {
            length--;
        }
        if (length < 0 || !this.f6071c[length].c()) {
            return -1;
        }
        return length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f6069a == aVar.f6069a && this.f6072d == aVar.f6072d && this.f6073e == aVar.f6073e && Arrays.equals(this.f6070b, aVar.f6070b) && Arrays.equals(this.f6071c, aVar.f6071c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f6069a * 31) + ((int) this.f6072d)) * 31) + ((int) this.f6073e)) * 31) + Arrays.hashCode(this.f6070b)) * 31) + Arrays.hashCode(this.f6071c);
    }
}
