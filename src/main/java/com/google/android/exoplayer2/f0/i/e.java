package com.google.android.exoplayer2.f0.i;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SpliceNullCommand */
public final class e extends b {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* compiled from: SpliceNullCommand */
    static class a implements Parcelable.Creator<e> {
        a() {
        }

        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e();
        }

        /* renamed from: b */
        public e[] newArray(int i2) {
            return new e[i2];
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }
}
