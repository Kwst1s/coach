package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: PrivFrame */
public final class l extends i {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5756c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5757d;

    /* compiled from: PrivFrame */
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

    public l(String str, byte[] bArr) {
        super("PRIV");
        this.f5756c = str;
        this.f5757d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (!d0.b(this.f5756c, lVar.f5756c) || !Arrays.equals(this.f5757d, lVar.f5757d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f5756c;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f5757d);
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": owner=" + this.f5756c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5756c);
        parcel.writeByteArray(this.f5757d);
    }

    l(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5756c = readString;
        byte[] createByteArray = parcel.createByteArray();
        d0.f(createByteArray);
        this.f5757d = createByteArray;
    }
}
