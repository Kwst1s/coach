package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: ApicFrame */
public final class b extends i {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5719c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5720d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5721e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f5722f;

    /* compiled from: ApicFrame */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f5719c = str;
        this.f5720d = str2;
        this.f5721e = i2;
        this.f5722f = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5721e != bVar.f5721e || !d0.b(this.f5719c, bVar.f5719c) || !d0.b(this.f5720d, bVar.f5720d) || !Arrays.equals(this.f5722f, bVar.f5722f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2 = (527 + this.f5721e) * 31;
        String str = this.f5719c;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5720d;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode + i3) * 31) + Arrays.hashCode(this.f5722f);
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": mimeType=" + this.f5719c + ", description=" + this.f5720d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5719c);
        parcel.writeString(this.f5720d);
        parcel.writeInt(this.f5721e);
        parcel.writeByteArray(this.f5722f);
    }

    b(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5719c = readString;
        String readString2 = parcel.readString();
        d0.f(readString2);
        this.f5720d = readString2;
        this.f5721e = parcel.readInt();
        byte[] createByteArray = parcel.createByteArray();
        d0.f(createByteArray);
        this.f5722f = createByteArray;
    }
}
