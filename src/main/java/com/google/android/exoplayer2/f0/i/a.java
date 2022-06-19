package com.google.android.exoplayer2.f0.i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s;

/* compiled from: PrivateCommand */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new C0127a();

    /* renamed from: b  reason: collision with root package name */
    public final long f5762b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5763c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5764d;

    /* renamed from: com.google.android.exoplayer2.f0.i.a$a  reason: collision with other inner class name */
    /* compiled from: PrivateCommand */
    static class C0127a implements Parcelable.Creator<a> {
        C0127a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(Parcel parcel, C0127a aVar) {
        this(parcel);
    }

    static a g(s sVar, int i2, long j2) {
        long A = sVar.A();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        sVar.h(bArr, 0, i3);
        return new a(A, bArr, j2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f5762b);
        parcel.writeLong(this.f5763c);
        parcel.writeInt(this.f5764d.length);
        parcel.writeByteArray(this.f5764d);
    }

    private a(long j2, byte[] bArr, long j3) {
        this.f5762b = j3;
        this.f5763c = j2;
        this.f5764d = bArr;
    }

    private a(Parcel parcel) {
        this.f5762b = parcel.readLong();
        this.f5763c = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.f5764d = bArr;
        parcel.readByteArray(bArr);
    }
}
