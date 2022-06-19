package com.google.android.exoplayer2.f0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: Metadata */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0125a();

    /* renamed from: b  reason: collision with root package name */
    private final b[] f5705b;

    /* renamed from: com.google.android.exoplayer2.f0.a$a  reason: collision with other inner class name */
    /* compiled from: Metadata */
    static class C0125a implements Parcelable.Creator<a> {
        C0125a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[0];
        }
    }

    /* compiled from: Metadata */
    public interface b extends Parcelable {
    }

    public a(b... bVarArr) {
        this.f5705b = bVarArr == null ? new b[0] : bVarArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f5705b, ((a) obj).f5705b);
    }

    public b g(int i2) {
        return this.f5705b[i2];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5705b);
    }

    public int k() {
        return this.f5705b.length;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5705b.length);
        for (b bVar : this.f5705b) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public a(List<? extends b> list) {
        if (list != null) {
            b[] bVarArr = new b[list.size()];
            this.f5705b = bVarArr;
            list.toArray(bVarArr);
            return;
        }
        this.f5705b = new b[0];
    }

    a(Parcel parcel) {
        this.f5705b = new b[parcel.readInt()];
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f5705b;
            if (i2 < bVarArr.length) {
                bVarArr[i2] = (b) parcel.readParcelable(b.class.getClassLoader());
                i2++;
            } else {
                return;
            }
        }
    }
}
