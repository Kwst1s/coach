package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: ChapterFrame */
public final class d extends i {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5724c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5725d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5726e;

    /* renamed from: f  reason: collision with root package name */
    public final long f5727f;

    /* renamed from: g  reason: collision with root package name */
    public final long f5728g;

    /* renamed from: h  reason: collision with root package name */
    private final i[] f5729h;

    /* compiled from: ChapterFrame */
    static class a implements Parcelable.Creator<d> {
        a() {
        }

        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: b */
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    public d(String str, int i2, int i3, long j2, long j3, i[] iVarArr) {
        super("CHAP");
        this.f5724c = str;
        this.f5725d = i2;
        this.f5726e = i3;
        this.f5727f = j2;
        this.f5728g = j3;
        this.f5729h = iVarArr;
    }

    @Override // com.google.android.exoplayer2.f0.h.i
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f5725d == dVar.f5725d && this.f5726e == dVar.f5726e && this.f5727f == dVar.f5727f && this.f5728g == dVar.f5728g && d0.b(this.f5724c, dVar.f5724c) && Arrays.equals(this.f5729h, dVar.f5729h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = (((((((527 + this.f5725d) * 31) + this.f5726e) * 31) + ((int) this.f5727f)) * 31) + ((int) this.f5728g)) * 31;
        String str = this.f5724c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5724c);
        parcel.writeInt(this.f5725d);
        parcel.writeInt(this.f5726e);
        parcel.writeLong(this.f5727f);
        parcel.writeLong(this.f5728g);
        parcel.writeInt(this.f5729h.length);
        for (i iVar : this.f5729h) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    d(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5724c = readString;
        this.f5725d = parcel.readInt();
        this.f5726e = parcel.readInt();
        this.f5727f = parcel.readLong();
        this.f5728g = parcel.readLong();
        int readInt = parcel.readInt();
        this.f5729h = new i[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f5729h[i2] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }
}
