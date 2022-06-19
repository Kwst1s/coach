package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: TrackGroupArray */
public final class c0 implements Parcelable {
    public static final Parcelable.Creator<c0> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f6086e = new c0(new b0[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f6087b;

    /* renamed from: c  reason: collision with root package name */
    private final b0[] f6088c;

    /* renamed from: d  reason: collision with root package name */
    private int f6089d;

    /* compiled from: TrackGroupArray */
    static class a implements Parcelable.Creator<c0> {
        a() {
        }

        /* renamed from: a */
        public c0 createFromParcel(Parcel parcel) {
            return new c0(parcel);
        }

        /* renamed from: b */
        public c0[] newArray(int i2) {
            return new c0[i2];
        }
    }

    public c0(b0... b0VarArr) {
        this.f6088c = b0VarArr;
        this.f6087b = b0VarArr.length;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (this.f6087b != c0Var.f6087b || !Arrays.equals(this.f6088c, c0Var.f6088c)) {
            return false;
        }
        return true;
    }

    public b0 g(int i2) {
        return this.f6088c[i2];
    }

    public int hashCode() {
        if (this.f6089d == 0) {
            this.f6089d = Arrays.hashCode(this.f6088c);
        }
        return this.f6089d;
    }

    public int k(b0 b0Var) {
        for (int i2 = 0; i2 < this.f6087b; i2++) {
            if (this.f6088c[i2] == b0Var) {
                return i2;
            }
        }
        return -1;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6087b);
        for (int i3 = 0; i3 < this.f6087b; i3++) {
            parcel.writeParcelable(this.f6088c[i3], 0);
        }
    }

    c0(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f6087b = readInt;
        this.f6088c = new b0[readInt];
        for (int i2 = 0; i2 < this.f6087b; i2++) {
            this.f6088c[i2] = (b0) parcel.readParcelable(b0.class.getClassLoader());
        }
    }
}
