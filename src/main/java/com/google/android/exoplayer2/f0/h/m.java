package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;

/* compiled from: TextInformationFrame */
public final class m extends i {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5758c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5759d;

    /* compiled from: TextInformationFrame */
    static class a implements Parcelable.Creator<m> {
        a() {
        }

        /* renamed from: a */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        /* renamed from: b */
        public m[] newArray(int i2) {
            return new m[i2];
        }
    }

    public m(String str, String str2, String str3) {
        super(str);
        this.f5758c = str2;
        this.f5759d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (!this.f5747b.equals(mVar.f5747b) || !d0.b(this.f5758c, mVar.f5758c) || !d0.b(this.f5759d, mVar.f5759d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f5747b.hashCode()) * 31;
        String str = this.f5758c;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5759d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": value=" + this.f5759d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5747b);
        parcel.writeString(this.f5758c);
        parcel.writeString(this.f5759d);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    m(android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = r2.readString()
            com.google.android.exoplayer2.util.d0.f(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            java.lang.String r0 = r2.readString()
            r1.f5758c = r0
            java.lang.String r2 = r2.readString()
            com.google.android.exoplayer2.util.d0.f(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.f5759d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f0.h.m.<init>(android.os.Parcel):void");
    }
}
