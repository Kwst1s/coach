package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: GeobFrame */
public final class g extends i {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5738c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5739d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5740e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f5741f;

    /* compiled from: GeobFrame */
    static class a implements Parcelable.Creator<g> {
        a() {
        }

        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* renamed from: b */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    }

    public g(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f5738c = str;
        this.f5739d = str2;
        this.f5740e = str3;
        this.f5741f = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!d0.b(this.f5738c, gVar.f5738c) || !d0.b(this.f5739d, gVar.f5739d) || !d0.b(this.f5740e, gVar.f5740e) || !Arrays.equals(this.f5741f, gVar.f5741f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f5738c;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5739d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f5740e;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Arrays.hashCode(this.f5741f);
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": mimeType=" + this.f5738c + ", filename=" + this.f5739d + ", description=" + this.f5740e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5738c);
        parcel.writeString(this.f5739d);
        parcel.writeString(this.f5740e);
        parcel.writeByteArray(this.f5741f);
    }

    g(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5738c = readString;
        String readString2 = parcel.readString();
        d0.f(readString2);
        this.f5739d = readString2;
        String readString3 = parcel.readString();
        d0.f(readString3);
        this.f5740e = readString3;
        byte[] createByteArray = parcel.createByteArray();
        d0.f(createByteArray);
        this.f5741f = createByteArray;
    }
}
