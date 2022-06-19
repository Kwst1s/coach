package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.e;
import java.util.Arrays;

/* compiled from: TrackGroup */
public final class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f6079b;

    /* renamed from: c  reason: collision with root package name */
    private final l[] f6080c;

    /* renamed from: d  reason: collision with root package name */
    private int f6081d;

    /* compiled from: TrackGroup */
    static class a implements Parcelable.Creator<b0> {
        a() {
        }

        /* renamed from: a */
        public b0 createFromParcel(Parcel parcel) {
            return new b0(parcel);
        }

        /* renamed from: b */
        public b0[] newArray(int i2) {
            return new b0[i2];
        }
    }

    public b0(l... lVarArr) {
        e.f(lVarArr.length > 0);
        this.f6080c = lVarArr;
        this.f6079b = lVarArr.length;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.f6079b != b0Var.f6079b || !Arrays.equals(this.f6080c, b0Var.f6080c)) {
            return false;
        }
        return true;
    }

    public l g(int i2) {
        return this.f6080c[i2];
    }

    public int hashCode() {
        if (this.f6081d == 0) {
            this.f6081d = 527 + Arrays.hashCode(this.f6080c);
        }
        return this.f6081d;
    }

    public int k(l lVar) {
        int i2 = 0;
        while (true) {
            l[] lVarArr = this.f6080c;
            if (i2 >= lVarArr.length) {
                return -1;
            }
            if (lVar == lVarArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6079b);
        for (int i3 = 0; i3 < this.f6079b; i3++) {
            parcel.writeParcelable(this.f6080c[i3], 0);
        }
    }

    b0(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f6079b = readInt;
        this.f6080c = new l[readInt];
        for (int i2 = 0; i2 < this.f6079b; i2++) {
            this.f6080c[i2] = (l) parcel.readParcelable(l.class.getClassLoader());
        }
    }
}
