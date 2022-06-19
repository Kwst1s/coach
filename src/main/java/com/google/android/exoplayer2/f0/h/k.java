package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: MlltFrame */
public final class k extends i {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final int f5751c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5752d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5753e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f5754f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f5755g;

    /* compiled from: MlltFrame */
    static class a implements Parcelable.Creator<k> {
        a() {
        }

        /* renamed from: a */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* renamed from: b */
        public k[] newArray(int i2) {
            return new k[i2];
        }
    }

    public k(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f5751c = i2;
        this.f5752d = i3;
        this.f5753e = i4;
        this.f5754f = iArr;
        this.f5755g = iArr2;
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f5751c == kVar.f5751c && this.f5752d == kVar.f5752d && this.f5753e == kVar.f5753e && Arrays.equals(this.f5754f, kVar.f5754f) && Arrays.equals(this.f5755g, kVar.f5755g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f5751c) * 31) + this.f5752d) * 31) + this.f5753e) * 31) + Arrays.hashCode(this.f5754f)) * 31) + Arrays.hashCode(this.f5755g);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5751c);
        parcel.writeInt(this.f5752d);
        parcel.writeInt(this.f5753e);
        parcel.writeIntArray(this.f5754f);
        parcel.writeIntArray(this.f5755g);
    }

    k(Parcel parcel) {
        super("MLLT");
        this.f5751c = parcel.readInt();
        this.f5752d = parcel.readInt();
        this.f5753e = parcel.readInt();
        this.f5754f = parcel.createIntArray();
        this.f5755g = parcel.createIntArray();
    }
}
