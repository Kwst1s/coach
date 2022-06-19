package com.google.android.exoplayer2.h0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: ColorInfo */
public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f5882b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5883c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5884d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f5885e;

    /* renamed from: f  reason: collision with root package name */
    private int f5886f;

    /* compiled from: ColorInfo */
    static class a implements Parcelable.Creator<i> {
        a() {
        }

        /* renamed from: a */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        /* renamed from: b */
        public i[] newArray(int i2) {
            return new i[0];
        }
    }

    public i(int i2, int i3, int i4, byte[] bArr) {
        this.f5882b = i2;
        this.f5883c = i3;
        this.f5884d = i4;
        this.f5885e = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f5882b == iVar.f5882b && this.f5883c == iVar.f5883c && this.f5884d == iVar.f5884d && Arrays.equals(this.f5885e, iVar.f5885e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f5886f == 0) {
            this.f5886f = ((((((527 + this.f5882b) * 31) + this.f5883c) * 31) + this.f5884d) * 31) + Arrays.hashCode(this.f5885e);
        }
        return this.f5886f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f5882b);
        sb.append(", ");
        sb.append(this.f5883c);
        sb.append(", ");
        sb.append(this.f5884d);
        sb.append(", ");
        sb.append(this.f5885e != null);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5882b);
        parcel.writeInt(this.f5883c);
        parcel.writeInt(this.f5884d);
        d0.j0(parcel, this.f5885e != null);
        byte[] bArr = this.f5885e;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    i(Parcel parcel) {
        this.f5882b = parcel.readInt();
        this.f5883c = parcel.readInt();
        this.f5884d = parcel.readInt();
        this.f5885e = d0.W(parcel) ? parcel.createByteArray() : null;
    }
}
