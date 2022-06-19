package com.google.android.exoplayer2.f0.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: ChapterTocFrame */
public final class e extends i {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final String f5730c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5731d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5732e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f5733f;

    /* renamed from: g  reason: collision with root package name */
    private final i[] f5734g;

    /* compiled from: ChapterTocFrame */
    static class a implements Parcelable.Creator<e> {
        a() {
        }

        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: b */
        public e[] newArray(int i2) {
            return new e[i2];
        }
    }

    public e(String str, boolean z, boolean z2, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f5730c = str;
        this.f5731d = z;
        this.f5732e = z2;
        this.f5733f = strArr;
        this.f5734g = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f5731d != eVar.f5731d || this.f5732e != eVar.f5732e || !d0.b(this.f5730c, eVar.f5730c) || !Arrays.equals(this.f5733f, eVar.f5733f) || !Arrays.equals(this.f5734g, eVar.f5734g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2 = (((527 + (this.f5731d ? 1 : 0)) * 31) + (this.f5732e ? 1 : 0)) * 31;
        String str = this.f5730c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5730c);
        parcel.writeByte(this.f5731d ? (byte) 1 : 0);
        parcel.writeByte(this.f5732e ? (byte) 1 : 0);
        parcel.writeStringArray(this.f5733f);
        parcel.writeInt(this.f5734g.length);
        for (i iVar : this.f5734g) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    e(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        d0.f(readString);
        this.f5730c = readString;
        boolean z = true;
        this.f5731d = parcel.readByte() != 0;
        this.f5732e = parcel.readByte() == 0 ? false : z;
        this.f5733f = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f5734g = new i[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f5734g[i2] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }
}
