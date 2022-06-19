package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: BinaryFrame */
public final class c extends i {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f5723c;

    /* compiled from: BinaryFrame */
    static class a implements Parcelable.Creator<c> {
        a() {
        }

        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: b */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    }

    public c(String str, byte[] bArr) {
        super(str);
        this.f5723c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f5747b.equals(cVar.f5747b) || !Arrays.equals(this.f5723c, cVar.f5723c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f5747b.hashCode()) * 31) + Arrays.hashCode(this.f5723c);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5747b);
        parcel.writeByteArray(this.f5723c);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    c(android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = r2.readString()
            com.google.android.exoplayer2.util.d0.f(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            byte[] r2 = r2.createByteArray()
            com.google.android.exoplayer2.util.d0.f(r2)
            byte[] r2 = (byte[]) r2
            r1.f5723c = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f0.h.c.<init>(android.os.Parcel):void");
    }
}
