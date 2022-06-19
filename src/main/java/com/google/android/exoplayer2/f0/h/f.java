package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;

/* compiled from: CommentFrame */
public final class f extends i {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5735c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5736d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5737e;

    /* compiled from: CommentFrame */
    static class a implements Parcelable.Creator<f> {
        a() {
        }

        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: b */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    public f(String str, String str2, String str3) {
        super("COMM");
        this.f5735c = str;
        this.f5736d = str2;
        this.f5737e = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!d0.b(this.f5736d, fVar.f5736d) || !d0.b(this.f5735c, fVar.f5735c) || !d0.b(this.f5737e, fVar.f5737e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f5735c;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5736d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f5737e;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public String toString() {
        return this.f5747b + ": language=" + this.f5735c + ", description=" + this.f5736d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5747b);
        parcel.writeString(this.f5735c);
        parcel.writeString(this.f5737e);
    }

    f(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5735c = readString;
        String readString2 = parcel.readString();
        d0.f(readString2);
        this.f5736d = readString2;
        String readString3 = parcel.readString();
        d0.f(readString3);
        this.f5737e = readString3;
    }
}
