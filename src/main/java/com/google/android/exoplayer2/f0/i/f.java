package com.google.android.exoplayer2.f0.i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SpliceScheduleCommand */
public final class f extends b {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f5781b;

    /* access modifiers changed from: package-private */
    /* compiled from: SpliceScheduleCommand */
    public static class a implements Parcelable.Creator<f> {
        a() {
        }

        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel, null);
        }

        /* renamed from: b */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    /* compiled from: SpliceScheduleCommand */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f5782a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5783b;

        /* synthetic */ b(int i2, long j2, a aVar) {
            this(i2, j2);
        }

        /* access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void d(Parcel parcel) {
            parcel.writeInt(this.f5782a);
            parcel.writeLong(this.f5783b);
        }

        private b(int i2, long j2) {
            this.f5782a = i2;
            this.f5783b = j2;
        }
    }

    /* synthetic */ f(Parcel parcel, a aVar) {
        this(parcel);
    }

    static f g(s sVar) {
        int y = sVar.y();
        ArrayList arrayList = new ArrayList(y);
        for (int i2 = 0; i2 < y; i2++) {
            arrayList.add(c.e(sVar));
        }
        return new f(arrayList);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int size = this.f5781b.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f5781b.get(i3).f(parcel);
        }
    }

    private f(List<c> list) {
        this.f5781b = Collections.unmodifiableList(list);
    }

    private f(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(c.d(parcel));
        }
        this.f5781b = Collections.unmodifiableList(arrayList);
    }

    /* compiled from: SpliceScheduleCommand */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f5784a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5785b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5786c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5787d;

        /* renamed from: e  reason: collision with root package name */
        public final long f5788e;

        /* renamed from: f  reason: collision with root package name */
        public final List<b> f5789f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5790g;

        /* renamed from: h  reason: collision with root package name */
        public final long f5791h;

        /* renamed from: i  reason: collision with root package name */
        public final int f5792i;

        /* renamed from: j  reason: collision with root package name */
        public final int f5793j;

        /* renamed from: k  reason: collision with root package name */
        public final int f5794k;

        private c(long j2, boolean z, boolean z2, boolean z3, List<b> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f5784a = j2;
            this.f5785b = z;
            this.f5786c = z2;
            this.f5787d = z3;
            this.f5789f = Collections.unmodifiableList(list);
            this.f5788e = j3;
            this.f5790g = z4;
            this.f5791h = j4;
            this.f5792i = i2;
            this.f5793j = i3;
            this.f5794k = i4;
        }

        /* access modifiers changed from: private */
        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        /* access modifiers changed from: private */
        public static c e(s sVar) {
            boolean z;
            int i2;
            int i3;
            int i4;
            long j2;
            boolean z2;
            long j3;
            ArrayList arrayList;
            boolean z3;
            long j4;
            boolean z4;
            long A = sVar.A();
            boolean z5 = (sVar.y() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (!z5) {
                int y = sVar.y();
                boolean z6 = (y & 128) != 0;
                boolean z7 = (y & 64) != 0;
                boolean z8 = (y & 32) != 0;
                long A2 = z7 ? sVar.A() : -9223372036854775807L;
                if (!z7) {
                    int y2 = sVar.y();
                    ArrayList arrayList3 = new ArrayList(y2);
                    for (int i5 = 0; i5 < y2; i5++) {
                        arrayList3.add(new b(sVar.y(), sVar.A(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long y3 = (long) sVar.y();
                    boolean z9 = (128 & y3) != 0;
                    j4 = ((((y3 & 1) << 32) | sVar.A()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    j4 = -9223372036854775807L;
                }
                int E = sVar.E();
                int y4 = sVar.y();
                z = z7;
                i2 = sVar.y();
                j2 = j4;
                arrayList = arrayList2;
                i4 = E;
                i3 = y4;
                j3 = A2;
                z2 = z4;
                z3 = z6;
            } else {
                arrayList = arrayList2;
                z3 = false;
                j3 = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                z = false;
            }
            return new c(A, z5, z3, z, arrayList, j3, z2, j2, i4, i3, i2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void f(Parcel parcel) {
            parcel.writeLong(this.f5784a);
            parcel.writeByte(this.f5785b ? (byte) 1 : 0);
            parcel.writeByte(this.f5786c ? (byte) 1 : 0);
            parcel.writeByte(this.f5787d ? (byte) 1 : 0);
            int size = this.f5789f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f5789f.get(i2).d(parcel);
            }
            parcel.writeLong(this.f5788e);
            parcel.writeByte(this.f5790g ? (byte) 1 : 0);
            parcel.writeLong(this.f5791h);
            parcel.writeInt(this.f5792i);
            parcel.writeInt(this.f5793j);
            parcel.writeInt(this.f5794k);
        }

        private c(Parcel parcel) {
            this.f5784a = parcel.readLong();
            boolean z = false;
            this.f5785b = parcel.readByte() == 1;
            this.f5786c = parcel.readByte() == 1;
            this.f5787d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(b.c(parcel));
            }
            this.f5789f = Collections.unmodifiableList(arrayList);
            this.f5788e = parcel.readLong();
            this.f5790g = parcel.readByte() == 1 ? true : z;
            this.f5791h = parcel.readLong();
            this.f5792i = parcel.readInt();
            this.f5793j = parcel.readInt();
            this.f5794k = parcel.readInt();
        }
    }
}
