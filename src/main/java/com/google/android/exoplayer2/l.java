package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.h0.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Format */
public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();
    public final String A;
    public final int B;
    private int C;

    /* renamed from: b  reason: collision with root package name */
    public final String f5971b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5972c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5973d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5974e;

    /* renamed from: f  reason: collision with root package name */
    public final com.google.android.exoplayer2.f0.a f5975f;

    /* renamed from: g  reason: collision with root package name */
    public final String f5976g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5977h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5978i;

    /* renamed from: j  reason: collision with root package name */
    public final List<byte[]> f5979j;

    /* renamed from: k  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.l f5980k;
    public final long l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;
    public final int r;
    public final byte[] s;
    public final i t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* compiled from: Format */
    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* renamed from: b */
        public l[] newArray(int i2) {
            return new l[i2];
        }
    }

    l(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, i iVar, int i8, int i9, int i10, int i11, int i12, int i13, String str6, int i14, long j2, List<byte[]> list, com.google.android.exoplayer2.drm.l lVar, com.google.android.exoplayer2.f0.a aVar) {
        this.f5971b = str;
        this.f5972c = str2;
        this.f5976g = str3;
        this.f5977h = str4;
        this.f5974e = str5;
        this.f5973d = i2;
        this.f5978i = i3;
        this.m = i4;
        this.n = i5;
        this.o = f2;
        int i15 = i6;
        this.p = i15 == -1 ? 0 : i15;
        this.q = f3 == -1.0f ? 1.0f : f3;
        this.s = bArr;
        this.r = i7;
        this.t = iVar;
        this.u = i8;
        this.v = i9;
        this.w = i10;
        int i16 = i11;
        this.x = i16 == -1 ? 0 : i16;
        int i17 = i12;
        this.y = i17 == -1 ? 0 : i17;
        this.z = i13;
        this.A = str6;
        this.B = i14;
        this.l = j2;
        this.f5979j = list == null ? Collections.emptyList() : list;
        this.f5980k = lVar;
        this.f5975f = aVar;
    }

    public static l A(String str, String str2, int i2, String str3) {
        return B(str, str2, i2, str3, null);
    }

    public static l B(String str, String str2, int i2, String str3, com.google.android.exoplayer2.drm.l lVar) {
        return C(str, str2, null, -1, i2, str3, -1, lVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static l C(String str, String str2, String str3, int i2, int i3, String str4, int i4, com.google.android.exoplayer2.drm.l lVar, long j2, List<byte[]> list) {
        return new l(str, null, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, i4, j2, list, lVar, null);
    }

    public static l D(String str, String str2, String str3, int i2, int i3, String str4, com.google.android.exoplayer2.drm.l lVar, long j2) {
        return C(str, str2, str3, i2, i3, str4, -1, lVar, j2, Collections.emptyList());
    }

    public static l E(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, float f2, List<byte[]> list, int i5) {
        return new l(str, str2, str3, str4, str5, i2, -1, i3, i4, f2, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i5, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static l F(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, com.google.android.exoplayer2.drm.l lVar) {
        return G(str, str2, str3, i2, i3, i4, i5, f2, list, i6, f3, null, -1, null, lVar);
    }

    public static l G(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, i iVar, com.google.android.exoplayer2.drm.l lVar) {
        return new l(str, null, null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, iVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, lVar, null);
    }

    public static l q(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, List<byte[]> list, int i5, String str6) {
        return new l(str, str2, str3, str4, str5, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, -1, -1, -1, i5, str6, -1, Long.MAX_VALUE, list, null, null);
    }

    public static l r(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, com.google.android.exoplayer2.drm.l lVar, int i9, String str4, com.google.android.exoplayer2.f0.a aVar) {
        return new l(str, null, null, str2, str3, i2, i3, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i4, i5, i6, i7, i8, i9, str4, -1, Long.MAX_VALUE, list, lVar, aVar);
    }

    public static l s(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, com.google.android.exoplayer2.drm.l lVar, int i7, String str4) {
        return r(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, lVar, i7, str4, null);
    }

    public static l t(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, com.google.android.exoplayer2.drm.l lVar, int i6, String str4) {
        return s(str, str2, str3, i2, i3, i4, i5, -1, list, lVar, i6, str4);
    }

    public static l u(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6) {
        return new l(str, str2, str3, str4, str5, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str6, -1, Long.MAX_VALUE, null, null, null);
    }

    public static l v(String str, String str2, String str3, int i2, int i3, List<byte[]> list, String str4, com.google.android.exoplayer2.drm.l lVar) {
        return new l(str, null, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, -1, Long.MAX_VALUE, list, lVar, null);
    }

    public static l w(String str, String str2, long j2) {
        return new l(str, null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null);
    }

    public static l x(String str, String str2, String str3, int i2, com.google.android.exoplayer2.drm.l lVar) {
        return new l(str, null, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, lVar, null);
    }

    public static l y(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6) {
        return z(str, str2, str3, str4, str5, i2, i3, str6, -1);
    }

    public static l z(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, int i4) {
        return new l(str, str2, str3, str4, str5, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str6, i4, Long.MAX_VALUE, null, null, null);
    }

    public int H() {
        int i2;
        int i3 = this.m;
        if (i3 == -1 || (i2 = this.n) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public boolean I(l lVar) {
        if (this.f5979j.size() != lVar.f5979j.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f5979j.size(); i2++) {
            if (!Arrays.equals(this.f5979j.get(i2), lVar.f5979j.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        int i3 = this.C;
        if ((i3 == 0 || (i2 = lVar.C) == 0 || i3 == i2) && this.f5973d == lVar.f5973d && this.f5978i == lVar.f5978i && this.m == lVar.m && this.n == lVar.n && Float.compare(this.o, lVar.o) == 0 && this.p == lVar.p && Float.compare(this.q, lVar.q) == 0 && this.r == lVar.r && this.u == lVar.u && this.v == lVar.v && this.w == lVar.w && this.x == lVar.x && this.y == lVar.y && this.l == lVar.l && this.z == lVar.z && d0.b(this.f5971b, lVar.f5971b) && d0.b(this.f5972c, lVar.f5972c) && d0.b(this.A, lVar.A) && this.B == lVar.B && d0.b(this.f5976g, lVar.f5976g) && d0.b(this.f5977h, lVar.f5977h) && d0.b(this.f5974e, lVar.f5974e) && d0.b(this.f5980k, lVar.f5980k) && d0.b(this.f5975f, lVar.f5975f) && d0.b(this.t, lVar.t) && Arrays.equals(this.s, lVar.s) && I(lVar)) {
            return true;
        }
        return false;
    }

    public l g(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, String str5) {
        return new l(str, str2, this.f5976g, str3, str4, i2, this.f5978i, i3, i4, this.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, i5, str5, this.B, this.l, this.f5979j, this.f5980k, this.f5975f);
    }

    public int hashCode() {
        if (this.C == 0) {
            String str = this.f5971b;
            int i2 = 0;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f5976g;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f5977h;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f5974e;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f5973d) * 31) + this.m) * 31) + this.n) * 31) + this.u) * 31) + this.v) * 31;
            String str5 = this.A;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.B) * 31;
            com.google.android.exoplayer2.drm.l lVar = this.f5980k;
            int hashCode6 = (hashCode5 + (lVar == null ? 0 : lVar.hashCode())) * 31;
            com.google.android.exoplayer2.f0.a aVar = this.f5975f;
            int hashCode7 = (hashCode6 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            String str6 = this.f5972c;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            this.C = ((((((((((((((((((((hashCode7 + i2) * 31) + this.f5978i) * 31) + ((int) this.l)) * 31) + Float.floatToIntBits(this.o)) * 31) + Float.floatToIntBits(this.q)) * 31) + this.p) * 31) + this.r) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z;
        }
        return this.C;
    }

    public l k(com.google.android.exoplayer2.drm.l lVar) {
        return new l(this.f5971b, this.f5972c, this.f5976g, this.f5977h, this.f5974e, this.f5973d, this.f5978i, this.m, this.n, this.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.l, this.f5979j, lVar, this.f5975f);
    }

    public l l(int i2, int i3) {
        return new l(this.f5971b, this.f5972c, this.f5976g, this.f5977h, this.f5974e, this.f5973d, this.f5978i, this.m, this.n, this.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, i2, i3, this.z, this.A, this.B, this.l, this.f5979j, this.f5980k, this.f5975f);
    }

    public l m(l lVar) {
        String str;
        String str2;
        if (this == lVar) {
            return this;
        }
        int g2 = p.g(this.f5977h);
        String str3 = lVar.f5971b;
        String str4 = lVar.f5972c;
        if (str4 == null) {
            str4 = this.f5972c;
        }
        String str5 = ((g2 == 3 || g2 == 1) && (str2 = lVar.A) != null) ? str2 : this.A;
        int i2 = this.f5973d;
        if (i2 == -1) {
            i2 = lVar.f5973d;
        }
        String str6 = this.f5974e;
        if (str6 == null) {
            String x2 = d0.x(lVar.f5974e, g2);
            if (d0.e0(x2).length == 1) {
                str = x2;
                float f2 = this.o;
                return new l(str3, str4, this.f5976g, this.f5977h, str, i2, this.f5978i, this.m, this.n, (f2 == -1.0f || g2 != 2) ? f2 : lVar.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z | lVar.z, str5, this.B, this.l, this.f5979j, com.google.android.exoplayer2.drm.l.m(lVar.f5980k, this.f5980k), this.f5975f);
            }
        }
        str = str6;
        float f22 = this.o;
        return new l(str3, str4, this.f5976g, this.f5977h, str, i2, this.f5978i, this.m, this.n, (f22 == -1.0f || g2 != 2) ? f22 : lVar.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z | lVar.z, str5, this.B, this.l, this.f5979j, com.google.android.exoplayer2.drm.l.m(lVar.f5980k, this.f5980k), this.f5975f);
    }

    public l n(int i2) {
        return new l(this.f5971b, this.f5972c, this.f5976g, this.f5977h, this.f5974e, this.f5973d, i2, this.m, this.n, this.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.l, this.f5979j, this.f5980k, this.f5975f);
    }

    public l o(com.google.android.exoplayer2.f0.a aVar) {
        return new l(this.f5971b, this.f5972c, this.f5976g, this.f5977h, this.f5974e, this.f5973d, this.f5978i, this.m, this.n, this.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.l, this.f5979j, this.f5980k, aVar);
    }

    public l p(long j2) {
        return new l(this.f5971b, this.f5972c, this.f5976g, this.f5977h, this.f5974e, this.f5973d, this.f5978i, this.m, this.n, this.o, this.p, this.q, this.s, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, j2, this.f5979j, this.f5980k, this.f5975f);
    }

    public String toString() {
        return "Format(" + this.f5971b + ", " + this.f5972c + ", " + this.f5976g + ", " + this.f5977h + ", " + this.f5974e + ", " + this.f5973d + ", " + this.A + ", [" + this.m + ", " + this.n + ", " + this.o + "], [" + this.u + ", " + this.v + "])";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5971b);
        parcel.writeString(this.f5972c);
        parcel.writeString(this.f5976g);
        parcel.writeString(this.f5977h);
        parcel.writeString(this.f5974e);
        parcel.writeInt(this.f5973d);
        parcel.writeInt(this.f5978i);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeFloat(this.o);
        parcel.writeInt(this.p);
        parcel.writeFloat(this.q);
        d0.j0(parcel, this.s != null);
        byte[] bArr = this.s;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.r);
        parcel.writeParcelable(this.t, i2);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
        parcel.writeLong(this.l);
        int size = this.f5979j.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.f5979j.get(i3));
        }
        parcel.writeParcelable(this.f5980k, 0);
        parcel.writeParcelable(this.f5975f, 0);
    }

    l(Parcel parcel) {
        this.f5971b = parcel.readString();
        this.f5972c = parcel.readString();
        this.f5976g = parcel.readString();
        this.f5977h = parcel.readString();
        this.f5974e = parcel.readString();
        this.f5973d = parcel.readInt();
        this.f5978i = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readFloat();
        this.p = parcel.readInt();
        this.q = parcel.readFloat();
        this.s = d0.W(parcel) ? parcel.createByteArray() : null;
        this.r = parcel.readInt();
        this.t = (i) parcel.readParcelable(i.class.getClassLoader());
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.l = parcel.readLong();
        int readInt = parcel.readInt();
        this.f5979j = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f5979j.add(parcel.createByteArray());
        }
        this.f5980k = (com.google.android.exoplayer2.drm.l) parcel.readParcelable(com.google.android.exoplayer2.drm.l.class.getClassLoader());
        this.f5975f = (com.google.android.exoplayer2.f0.a) parcel.readParcelable(com.google.android.exoplayer2.f0.a.class.getClassLoader());
    }
}
