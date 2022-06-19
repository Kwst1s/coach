package com.google.android.exoplayer2.f0.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: EventMessage */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0126a();

    /* renamed from: b  reason: collision with root package name */
    public final String f5709b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5710c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5711d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5712e;

    /* renamed from: f  reason: collision with root package name */
    public final long f5713f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f5714g;

    /* renamed from: h  reason: collision with root package name */
    private int f5715h;

    /* renamed from: com.google.android.exoplayer2.f0.g.a$a  reason: collision with other inner class name */
    /* compiled from: EventMessage */
    static class C0126a implements Parcelable.Creator<a> {
        C0126a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a(String str, String str2, long j2, long j3, byte[] bArr, long j4) {
        this.f5709b = str;
        this.f5710c = str2;
        this.f5711d = j2;
        this.f5713f = j3;
        this.f5714g = bArr;
        this.f5712e = j4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f5712e != aVar.f5712e || this.f5711d != aVar.f5711d || this.f5713f != aVar.f5713f || !d0.b(this.f5709b, aVar.f5709b) || !d0.b(this.f5710c, aVar.f5710c) || !Arrays.equals(this.f5714g, aVar.f5714g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f5715h == 0) {
            String str = this.f5709b;
            int i2 = 0;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f5710c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j2 = this.f5712e;
            long j3 = this.f5711d;
            long j4 = this.f5713f;
            this.f5715h = ((((((((hashCode + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + Arrays.hashCode(this.f5714g);
        }
        return this.f5715h;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f5709b + ", id=" + this.f5713f + ", value=" + this.f5710c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5709b);
        parcel.writeString(this.f5710c);
        parcel.writeLong(this.f5712e);
        parcel.writeLong(this.f5711d);
        parcel.writeLong(this.f5713f);
        parcel.writeByteArray(this.f5714g);
    }

    a(Parcel parcel) {
        String readString = parcel.readString();
        d0.f(readString);
        this.f5709b = readString;
        String readString2 = parcel.readString();
        d0.f(readString2);
        this.f5710c = readString2;
        this.f5712e = parcel.readLong();
        this.f5711d = parcel.readLong();
        this.f5713f = parcel.readLong();
        byte[] createByteArray = parcel.createByteArray();
        d0.f(createByteArray);
        this.f5714g = createByteArray;
    }
}
