package com.google.android.exoplayer2.f0.i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SpliceInsertCommand */
public final class d extends b {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final long f5768b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5769c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5770d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5771e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5772f;

    /* renamed from: g  reason: collision with root package name */
    public final long f5773g;

    /* renamed from: h  reason: collision with root package name */
    public final long f5774h;

    /* renamed from: i  reason: collision with root package name */
    public final List<b> f5775i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f5776j;

    /* renamed from: k  reason: collision with root package name */
    public final long f5777k;
    public final int l;
    public final int m;
    public final int n;

    /* access modifiers changed from: package-private */
    /* compiled from: SpliceInsertCommand */
    public static class a implements Parcelable.Creator<d> {
        a() {
        }

        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        /* renamed from: b */
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    /* compiled from: SpliceInsertCommand */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f5778a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5779b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5780c;

        /* synthetic */ b(int i2, long j2, long j3, a aVar) {
            this(i2, j2, j3);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f5778a);
            parcel.writeLong(this.f5779b);
            parcel.writeLong(this.f5780c);
        }

        private b(int i2, long j2, long j3) {
            this.f5778a = i2;
            this.f5779b = j2;
            this.f5780c = j3;
        }
    }

    /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }

    static d g(s sVar, long j2, a0 a0Var) {
        boolean z;
        int i2;
        int i3;
        int i4;
        long j3;
        boolean z2;
        List list;
        long j4;
        boolean z3;
        boolean z4;
        long j5;
        boolean z5;
        long A = sVar.A();
        boolean z6 = (sVar.y() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int y = sVar.y();
            boolean z7 = (y & 128) != 0;
            boolean z8 = (y & 64) != 0;
            boolean z9 = (y & 32) != 0;
            boolean z10 = (y & 16) != 0;
            long k2 = (!z8 || z10) ? -9223372036854775807L : g.k(sVar, j2);
            if (!z8) {
                int y2 = sVar.y();
                ArrayList arrayList = new ArrayList(y2);
                for (int i5 = 0; i5 < y2; i5++) {
                    int y3 = sVar.y();
                    long k3 = !z10 ? g.k(sVar, j2) : -9223372036854775807L;
                    arrayList.add(new b(y3, k3, a0Var.b(k3), null));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long y4 = (long) sVar.y();
                boolean z11 = (128 & y4) != 0;
                j5 = ((((y4 & 1) << 32) | sVar.A()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                j5 = -9223372036854775807L;
            }
            i4 = sVar.E();
            z = z8;
            i3 = sVar.y();
            i2 = sVar.y();
            list = emptyList;
            z2 = z5;
            j3 = j5;
            z3 = z10;
            z4 = z7;
            j4 = k2;
        } else {
            list = emptyList;
            z4 = false;
            z3 = false;
            j4 = -9223372036854775807L;
            z2 = false;
            j3 = -9223372036854775807L;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z = false;
        }
        return new d(A, z6, z4, z, z3, j4, a0Var.b(j4), list, z2, j3, i4, i3, i2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f5768b);
        parcel.writeByte(this.f5769c ? (byte) 1 : 0);
        parcel.writeByte(this.f5770d ? (byte) 1 : 0);
        parcel.writeByte(this.f5771e ? (byte) 1 : 0);
        parcel.writeByte(this.f5772f ? (byte) 1 : 0);
        parcel.writeLong(this.f5773g);
        parcel.writeLong(this.f5774h);
        int size = this.f5775i.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f5775i.get(i3).b(parcel);
        }
        parcel.writeByte(this.f5776j ? (byte) 1 : 0);
        parcel.writeLong(this.f5777k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }

    private d(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<b> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f5768b = j2;
        this.f5769c = z;
        this.f5770d = z2;
        this.f5771e = z3;
        this.f5772f = z4;
        this.f5773g = j3;
        this.f5774h = j4;
        this.f5775i = Collections.unmodifiableList(list);
        this.f5776j = z5;
        this.f5777k = j5;
        this.l = i2;
        this.m = i3;
        this.n = i4;
    }

    private d(Parcel parcel) {
        this.f5768b = parcel.readLong();
        boolean z = false;
        this.f5769c = parcel.readByte() == 1;
        this.f5770d = parcel.readByte() == 1;
        this.f5771e = parcel.readByte() == 1;
        this.f5772f = parcel.readByte() == 1;
        this.f5773g = parcel.readLong();
        this.f5774h = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(b.a(parcel));
        }
        this.f5775i = Collections.unmodifiableList(arrayList);
        this.f5776j = parcel.readByte() == 1 ? true : z;
        this.f5777k = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
    }
}
