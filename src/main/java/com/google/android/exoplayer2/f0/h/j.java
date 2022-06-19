package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;

/* compiled from: InternalFrame */
public final class j extends i {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5748c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5749d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5750e;

    /* compiled from: InternalFrame */
    static class a implements Parcelable.Creator<j> {
        a() {
        }

        /* renamed from: a */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* renamed from: b */
        public j[] newArray(int i2) {
            return new j[i2];
        }
    }

    public j(String str, String str2, String str3) {
        super("----");
        this.f5748c = str;
        this.f5749d = str2;
        this.f5750e = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (!d0.b(this.f5749d, jVar.f5749d) || !d0.b(this.f5748c, jVar.f5748c) || !d0.b(this.f5750e, jVar.f5750e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f5748c;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5749d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f5750e;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": domain=" + this.f5748c + ", description=" + this.f5749d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5747b);
        parcel.writeString(this.f5748c);
        parcel.writeString(this.f5750e);
    }

    j(Parcel parcel) {
        super("----");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5748c = readString;
        String readString2 = parcel.readString();
        d0.f(readString2);
        this.f5749d = readString2;
        String readString3 = parcel.readString();
        d0.f(readString3);
        this.f5750e = readString3;
    }
}
