package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;

/* compiled from: UrlLinkFrame */
public final class n extends i {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5760c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5761d;

    /* compiled from: UrlLinkFrame */
    static class a implements Parcelable.Creator<n> {
        a() {
        }

        /* renamed from: a */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        /* renamed from: b */
        public n[] newArray(int i2) {
            return new n[i2];
        }
    }

    public n(String str, String str2, String str3) {
        super(str);
        this.f5760c = str2;
        this.f5761d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f5747b.equals(nVar.f5747b) || !d0.b(this.f5760c, nVar.f5760c) || !d0.b(this.f5761d, nVar.f5761d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f5747b.hashCode()) * 31;
        String str = this.f5760c;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5761d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": url=" + this.f5761d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5747b);
        parcel.writeString(this.f5760c);
        parcel.writeString(this.f5761d);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    n(android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = r2.readString()
            com.google.android.exoplayer2.util.d0.f(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            java.lang.String r0 = r2.readString()
            r1.f5760c = r0
            java.lang.String r2 = r2.readString()
            com.google.android.exoplayer2.util.d0.f(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.f5761d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f0.h.n.<init>(android.os.Parcel):void");
    }
}
