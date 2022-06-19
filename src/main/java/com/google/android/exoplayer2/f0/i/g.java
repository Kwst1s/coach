package com.google.android.exoplayer2.f0.i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;

/* compiled from: TimeSignalCommand */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final long f5795b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5796c;

    /* compiled from: TimeSignalCommand */
    static class a implements Parcelable.Creator<g> {
        a() {
        }

        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), null);
        }

        /* renamed from: b */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    }

    /* synthetic */ g(long j2, long j3, a aVar) {
        this(j2, j3);
    }

    static g g(s sVar, long j2, a0 a0Var) {
        long k2 = k(sVar, j2);
        return new g(k2, a0Var.b(k2));
    }

    static long k(s sVar, long j2) {
        long y = (long) sVar.y();
        if ((128 & y) != 0) {
            return 8589934591L & ((((y & 1) << 32) | sVar.A()) + j2);
        }
        return -9223372036854775807L;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f5795b);
        parcel.writeLong(this.f5796c);
    }

    private g(long j2, long j3) {
        this.f5795b = j2;
        this.f5796c = j3;
    }
}
