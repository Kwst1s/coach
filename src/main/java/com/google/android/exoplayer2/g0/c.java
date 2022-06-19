package com.google.android.exoplayer2.g0;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.g0.e;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DefaultTrackSelector */
public class c extends e {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f5816e = new int[0];

    /* renamed from: c  reason: collision with root package name */
    private final g.a f5817c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<C0130c> f5818d = new AtomicReference<>(C0130c.v);

    /* access modifiers changed from: private */
    /* compiled from: DefaultTrackSelector */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f5819a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5820b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5821c;

        public a(int i2, int i3, String str) {
            this.f5819a = i2;
            this.f5820b = i3;
            this.f5821c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5819a == aVar.f5819a && this.f5820b == aVar.f5820b && TextUtils.equals(this.f5821c, aVar.f5821c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f5819a * 31) + this.f5820b) * 31;
            String str = this.f5821c;
            return i2 + (str != null ? str.hashCode() : 0);
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: DefaultTrackSelector */
    public static final class b implements Comparable<b> {

        /* renamed from: b  reason: collision with root package name */
        private final C0130c f5822b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5823c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5824d;

        /* renamed from: e  reason: collision with root package name */
        private final int f5825e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5826f;

        /* renamed from: g  reason: collision with root package name */
        private final int f5827g;

        /* renamed from: h  reason: collision with root package name */
        private final int f5828h;

        public b(l lVar, C0130c cVar, int i2) {
            this.f5822b = cVar;
            int i3 = 0;
            this.f5823c = c.v(i2, false) ? 1 : 0;
            this.f5824d = c.n(lVar, cVar.f5831d) ? 1 : 0;
            this.f5825e = (lVar.z & 1) != 0 ? 1 : i3;
            this.f5826f = lVar.u;
            this.f5827g = lVar.v;
            this.f5828h = lVar.f5973d;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int l;
            int i2 = this.f5823c;
            int i3 = bVar.f5823c;
            if (i2 != i3) {
                return c.l(i2, i3);
            }
            int i4 = this.f5824d;
            int i5 = bVar.f5824d;
            if (i4 != i5) {
                return c.l(i4, i5);
            }
            int i6 = this.f5825e;
            int i7 = bVar.f5825e;
            if (i6 != i7) {
                return c.l(i6, i7);
            }
            if (this.f5822b.p) {
                return c.l(bVar.f5828h, this.f5828h);
            }
            int i8 = 1;
            if (i2 != 1) {
                i8 = -1;
            }
            int i9 = this.f5826f;
            int i10 = bVar.f5826f;
            if (i9 != i10) {
                l = c.l(i9, i10);
            } else {
                int i11 = this.f5827g;
                int i12 = bVar.f5827g;
                if (i11 != i12) {
                    l = c.l(i11, i12);
                } else {
                    l = c.l(this.f5828h, bVar.f5828h);
                }
            }
            return i8 * l;
        }
    }

    /* renamed from: com.google.android.exoplayer2.g0.c$c  reason: collision with other inner class name */
    /* compiled from: DefaultTrackSelector */
    public static final class C0130c implements Parcelable {
        public static final Parcelable.Creator<C0130c> CREATOR = new a();
        public static final C0130c v = new C0130c();

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<Map<c0, d>> f5829b;

        /* renamed from: c  reason: collision with root package name */
        private final SparseBooleanArray f5830c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5831d;

        /* renamed from: e  reason: collision with root package name */
        public final String f5832e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f5833f;

        /* renamed from: g  reason: collision with root package name */
        public final int f5834g;

        /* renamed from: h  reason: collision with root package name */
        public final int f5835h;

        /* renamed from: i  reason: collision with root package name */
        public final int f5836i;

        /* renamed from: j  reason: collision with root package name */
        public final int f5837j;

        /* renamed from: k  reason: collision with root package name */
        public final int f5838k;
        public final boolean l;
        public final int m;
        public final int n;
        public final boolean o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        public final boolean s;
        public final boolean t;
        public final int u;

        /* renamed from: com.google.android.exoplayer2.g0.c$c$a */
        /* compiled from: DefaultTrackSelector */
        static class a implements Parcelable.Creator<C0130c> {
            a() {
            }

            /* renamed from: a */
            public C0130c createFromParcel(Parcel parcel) {
                return new C0130c(parcel);
            }

            /* renamed from: b */
            public C0130c[] newArray(int i2) {
                return new C0130c[i2];
            }
        }

        private C0130c() {
            this(new SparseArray(), new SparseBooleanArray(), null, null, false, 0, false, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        private static boolean g(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean k(SparseArray<Map<c0, d>> sparseArray, SparseArray<Map<c0, d>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                if (indexOfKey < 0 || !l(sparseArray.valueAt(i2), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean l(java.util.Map<com.google.android.exoplayer2.source.c0, com.google.android.exoplayer2.g0.c.d> r4, java.util.Map<com.google.android.exoplayer2.source.c0, com.google.android.exoplayer2.g0.c.d> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.c0 r1 = (com.google.android.exoplayer2.source.c0) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.d0.b(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g0.c.C0130c.l(java.util.Map, java.util.Map):boolean");
        }

        private static SparseArray<Map<c0, d>> p(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<c0, d>> sparseArray = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    hashMap.put((c0) parcel.readParcelable(c0.class.getClassLoader()), (d) parcel.readParcelable(d.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void q(Parcel parcel, SparseArray<Map<c0, d>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                Map<c0, d> valueAt = sparseArray.valueAt(i2);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<c0, d> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0130c.class != obj.getClass()) {
                return false;
            }
            C0130c cVar = (C0130c) obj;
            if (this.f5833f == cVar.f5833f && this.f5834g == cVar.f5834g && this.p == cVar.p && this.q == cVar.q && this.r == cVar.r && this.s == cVar.s && this.f5835h == cVar.f5835h && this.f5836i == cVar.f5836i && this.f5837j == cVar.f5837j && this.l == cVar.l && this.t == cVar.t && this.o == cVar.o && this.m == cVar.m && this.n == cVar.n && this.f5838k == cVar.f5838k && this.u == cVar.u && TextUtils.equals(this.f5831d, cVar.f5831d) && TextUtils.equals(this.f5832e, cVar.f5832e) && g(this.f5830c, cVar.f5830c) && k(this.f5829b, cVar.f5829b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int i3 = (((((((((((((((((((((((((((((((this.f5833f ? 1 : 0) * 31) + this.f5834g) * 31) + (this.p ? 1 : 0)) * 31) + (this.q ? 1 : 0)) * 31) + (this.r ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + this.f5835h) * 31) + this.f5836i) * 31) + this.f5837j) * 31) + (this.l ? 1 : 0)) * 31) + (this.t ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + this.m) * 31) + this.n) * 31) + this.f5838k) * 31) + this.u) * 31;
            String str = this.f5831d;
            int i4 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i5 = (i3 + i2) * 31;
            String str2 = this.f5832e;
            if (str2 != null) {
                i4 = str2.hashCode();
            }
            return i5 + i4;
        }

        public final boolean m(int i2) {
            return this.f5830c.get(i2);
        }

        public final d n(int i2, c0 c0Var) {
            Map<c0, d> map = this.f5829b.get(i2);
            if (map != null) {
                return map.get(c0Var);
            }
            return null;
        }

        public final boolean o(int i2, c0 c0Var) {
            Map<c0, d> map = this.f5829b.get(i2);
            return map != null && map.containsKey(c0Var);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            q(parcel, this.f5829b);
            parcel.writeSparseBooleanArray(this.f5830c);
            parcel.writeString(this.f5831d);
            parcel.writeString(this.f5832e);
            d0.j0(parcel, this.f5833f);
            parcel.writeInt(this.f5834g);
            d0.j0(parcel, this.p);
            d0.j0(parcel, this.q);
            d0.j0(parcel, this.r);
            d0.j0(parcel, this.s);
            parcel.writeInt(this.f5835h);
            parcel.writeInt(this.f5836i);
            parcel.writeInt(this.f5837j);
            parcel.writeInt(this.f5838k);
            d0.j0(parcel, this.l);
            d0.j0(parcel, this.t);
            parcel.writeInt(this.m);
            parcel.writeInt(this.n);
            d0.j0(parcel, this.o);
            parcel.writeInt(this.u);
        }

        C0130c(SparseArray<Map<c0, d>> sparseArray, SparseBooleanArray sparseBooleanArray, String str, String str2, boolean z, int i2, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, int i6, boolean z6, boolean z7, int i7, int i8, boolean z8, int i9) {
            this.f5829b = sparseArray;
            this.f5830c = sparseBooleanArray;
            this.f5831d = d0.S(str);
            this.f5832e = d0.S(str2);
            this.f5833f = z;
            this.f5834g = i2;
            this.p = z2;
            this.q = z3;
            this.r = z4;
            this.s = z5;
            this.f5835h = i3;
            this.f5836i = i4;
            this.f5837j = i5;
            this.f5838k = i6;
            this.l = z6;
            this.t = z7;
            this.m = i7;
            this.n = i8;
            this.o = z8;
            this.u = i9;
        }

        C0130c(Parcel parcel) {
            this.f5829b = p(parcel);
            this.f5830c = parcel.readSparseBooleanArray();
            this.f5831d = parcel.readString();
            this.f5832e = parcel.readString();
            this.f5833f = d0.W(parcel);
            this.f5834g = parcel.readInt();
            this.p = d0.W(parcel);
            this.q = d0.W(parcel);
            this.r = d0.W(parcel);
            this.s = d0.W(parcel);
            this.f5835h = parcel.readInt();
            this.f5836i = parcel.readInt();
            this.f5837j = parcel.readInt();
            this.f5838k = parcel.readInt();
            this.l = d0.W(parcel);
            this.t = d0.W(parcel);
            this.m = parcel.readInt();
            this.n = parcel.readInt();
            this.o = d0.W(parcel);
            this.u = parcel.readInt();
        }
    }

    /* compiled from: DefaultTrackSelector */
    public static final class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public final int f5839b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f5840c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5841d;

        /* compiled from: DefaultTrackSelector */
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

        d(Parcel parcel) {
            this.f5839b = parcel.readInt();
            int readByte = parcel.readByte();
            this.f5841d = readByte;
            int[] iArr = new int[readByte];
            this.f5840c = iArr;
            parcel.readIntArray(iArr);
        }

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
            if (this.f5839b != dVar.f5839b || !Arrays.equals(this.f5840c, dVar.f5840c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f5839b * 31) + Arrays.hashCode(this.f5840c);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f5839b);
            parcel.writeInt(this.f5840c.length);
            parcel.writeIntArray(this.f5840c);
        }
    }

    public c(g.a aVar) {
        this.f5817c = aVar;
    }

    private static g A(c0 c0Var, int[][] iArr, int i2, C0130c cVar, g.a aVar, e eVar) {
        c0 c0Var2 = c0Var;
        int i3 = cVar.s ? 24 : 16;
        boolean z = cVar.r && (i2 & i3) != 0;
        int i4 = 0;
        while (i4 < c0Var2.f6087b) {
            b0 g2 = c0Var2.g(i4);
            int[] s = s(g2, iArr[i4], z, i3, cVar.f5835h, cVar.f5836i, cVar.f5837j, cVar.f5838k, cVar.m, cVar.n, cVar.o);
            if (s.length > 0) {
                com.google.android.exoplayer2.util.e.e(aVar);
                return aVar.a(g2, eVar, s);
            }
            i4++;
            c0Var2 = c0Var;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        if (k(r2.f5973d, r10) < 0) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.g0.g D(com.google.android.exoplayer2.source.c0 r18, int[][] r19, com.google.android.exoplayer2.g0.c.C0130c r20) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g0.c.D(com.google.android.exoplayer2.source.c0, int[][], com.google.android.exoplayer2.g0.c$c):com.google.android.exoplayer2.g0.g");
    }

    private static int k(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    /* access modifiers changed from: private */
    public static int l(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    private static void m(b0 b0Var, int[] iArr, int i2, String str, int i3, int i4, int i5, int i6, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!x(b0Var.g(intValue), str, iArr[intValue], i2, i3, i4, i5, i6)) {
                list.remove(size);
            }
        }
    }

    protected static boolean n(l lVar, String str) {
        return str != null && TextUtils.equals(str, d0.S(lVar.A));
    }

    protected static boolean o(l lVar) {
        return TextUtils.isEmpty(lVar.A) || n(lVar, "und");
    }

    private static int p(b0 b0Var, int[] iArr, a aVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < b0Var.f6079b; i3++) {
            if (w(b0Var.g(i3), iArr[i3], aVar)) {
                i2++;
            }
        }
        return i2;
    }

    private static int[] q(b0 b0Var, int[] iArr, boolean z) {
        int p;
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < b0Var.f6079b; i3++) {
            l g2 = b0Var.g(i3);
            a aVar2 = new a(g2.u, g2.v, z ? null : g2.f5977h);
            if (hashSet.add(aVar2) && (p = p(b0Var, iArr, aVar2)) > i2) {
                i2 = p;
                aVar = aVar2;
            }
        }
        if (i2 <= 1) {
            return f5816e;
        }
        int[] iArr2 = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < b0Var.f6079b; i5++) {
            l g3 = b0Var.g(i5);
            int i6 = iArr[i5];
            com.google.android.exoplayer2.util.e.e(aVar);
            if (w(g3, i6, aVar)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return iArr2;
    }

    private static int r(b0 b0Var, int[] iArr, int i2, String str, int i3, int i4, int i5, int i6, List<Integer> list) {
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            int intValue = list.get(i8).intValue();
            if (x(b0Var.g(intValue), str, iArr[intValue], i2, i3, i4, i5, i6)) {
                i7++;
            }
        }
        return i7;
    }

    private static int[] s(b0 b0Var, int[] iArr, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        String str;
        int r;
        if (b0Var.f6079b < 2) {
            return f5816e;
        }
        List<Integer> u = u(b0Var, i7, i8, z2);
        if (u.size() < 2) {
            return f5816e;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i9 = 0;
            for (int i10 = 0; i10 < u.size(); i10++) {
                String str3 = b0Var.g(u.get(i10).intValue()).f5977h;
                if (hashSet.add(str3) && (r = r(b0Var, iArr, i2, str3, i3, i4, i5, i6, u)) > i9) {
                    i9 = r;
                    str2 = str3;
                }
            }
            str = str2;
        } else {
            str = null;
        }
        m(b0Var, iArr, i2, str, i3, i4, i5, i6, u);
        return u.size() < 2 ? f5816e : d0.g0(u);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point t(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.d0.h(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.d0.h(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g0.c.t(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> u(b0 b0Var, int i2, int i3, boolean z) {
        int i4;
        ArrayList arrayList = new ArrayList(b0Var.f6079b);
        for (int i5 = 0; i5 < b0Var.f6079b; i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
        if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < b0Var.f6079b; i7++) {
                l g2 = b0Var.g(i7);
                int i8 = g2.m;
                if (i8 > 0 && (i4 = g2.n) > 0) {
                    Point t = t(z, i2, i3, i8, i4);
                    int i9 = g2.m;
                    int i10 = g2.n;
                    int i11 = i9 * i10;
                    if (i9 >= ((int) (((float) t.x) * 0.98f)) && i10 >= ((int) (((float) t.y) * 0.98f)) && i11 < i6) {
                        i6 = i11;
                    }
                }
            }
            if (i6 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int H = b0Var.g(((Integer) arrayList.get(size)).intValue()).H();
                    if (H == -1 || H > i6) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean v(int i2, boolean z) {
        int i3 = i2 & 7;
        return i3 == 4 || (z && i3 == 3);
    }

    private static boolean w(l lVar, int i2, a aVar) {
        if (!v(i2, false) || lVar.u != aVar.f5819a || lVar.v != aVar.f5820b) {
            return false;
        }
        String str = aVar.f5821c;
        if (str == null || TextUtils.equals(str, lVar.f5977h)) {
            return true;
        }
        return false;
    }

    private static boolean x(l lVar, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!v(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str != null && !d0.b(lVar.f5977h, str)) {
            return false;
        }
        int i8 = lVar.m;
        if (i8 != -1 && i8 > i4) {
            return false;
        }
        int i9 = lVar.n;
        if (i9 != -1 && i9 > i5) {
            return false;
        }
        float f2 = lVar.o;
        if (f2 != -1.0f && f2 > ((float) i6)) {
            return false;
        }
        int i10 = lVar.f5973d;
        if (i10 == -1 || i10 <= i7) {
            return true;
        }
        return false;
    }

    private static void y(e.a aVar, int[][][] iArr, z[] zVarArr, g[] gVarArr, int i2) {
        boolean z;
        if (i2 != 0) {
            boolean z2 = false;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                if (i3 >= aVar.a()) {
                    z = true;
                    break;
                }
                int b2 = aVar.b(i3);
                g gVar = gVarArr[i3];
                if ((b2 == 1 || b2 == 2) && gVar != null && z(iArr[i3], aVar.c(i3), gVar)) {
                    if (b2 == 1) {
                        if (i5 != -1) {
                            break;
                        }
                        i5 = i3;
                    } else if (i4 != -1) {
                        break;
                    } else {
                        i4 = i3;
                    }
                }
                i3++;
            }
            z = false;
            if (!(i5 == -1 || i4 == -1)) {
                z2 = true;
            }
            if (z && z2) {
                z zVar = new z(i2);
                zVarArr[i5] = zVar;
                zVarArr[i4] = zVar;
            }
        }
    }

    private static boolean z(int[][] iArr, c0 c0Var, g gVar) {
        if (gVar == null) {
            return false;
        }
        int k2 = c0Var.k(gVar.j());
        for (int i2 = 0; i2 < gVar.length(); i2++) {
            if ((iArr[k2][gVar.e(i2)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public g[] B(e.a aVar, int[][][] iArr, int[] iArr2, C0130c cVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        b bVar;
        int a2 = aVar.a();
        g[] gVarArr = new g[a2];
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i2 = 2;
            i3 = 1;
            if (i7 >= a2) {
                break;
            }
            if (2 == aVar.b(i7)) {
                if (!z) {
                    gVarArr[i7] = G(aVar.c(i7), iArr[i7], iArr2[i7], cVar, this.f5817c);
                    z = gVarArr[i7] != null;
                }
                if (aVar.c(i7).f6087b <= 0) {
                    i3 = 0;
                }
                i8 |= i3;
            }
            i7++;
        }
        b bVar2 = null;
        int i9 = -1;
        int i10 = -1;
        int i11 = 0;
        int i12 = Integer.MIN_VALUE;
        while (i11 < a2) {
            int b2 = aVar.b(i11);
            if (b2 != i3) {
                if (b2 != i2) {
                    if (b2 != 3) {
                        gVarArr[i11] = E(b2, aVar.c(i11), iArr[i11], cVar);
                    } else {
                        Pair<g, Integer> F = F(aVar.c(i11), iArr[i11], cVar);
                        if (F != null && ((Integer) F.second).intValue() > i12) {
                            if (i10 != -1) {
                                gVarArr[i10] = null;
                            }
                            gVarArr[i11] = (g) F.first;
                            i12 = ((Integer) F.second).intValue();
                            i10 = i11;
                            i4 = i10;
                            i11 = i4 + 1;
                            i2 = 2;
                            i3 = 1;
                        }
                    }
                }
                i6 = i9;
                bVar = bVar2;
                i5 = i10;
                i4 = i11;
            } else {
                i6 = i9;
                bVar = bVar2;
                i5 = i10;
                i4 = i11;
                Pair<g, b> C = C(aVar.c(i11), iArr[i11], iArr2[i11], cVar, i8 != 0 ? null : this.f5817c);
                if (C != null && (bVar == null || ((b) C.second).compareTo(bVar) > 0)) {
                    if (i6 != -1) {
                        gVarArr[i6] = null;
                    }
                    gVarArr[i4] = (g) C.first;
                    bVar2 = (b) C.second;
                    i10 = i5;
                    i9 = i4;
                    i11 = i4 + 1;
                    i2 = 2;
                    i3 = 1;
                }
            }
            bVar2 = bVar;
            i9 = i6;
            i10 = i5;
            i11 = i4 + 1;
            i2 = 2;
            i3 = 1;
        }
        return gVarArr;
    }

    /* access modifiers changed from: protected */
    public Pair<g, b> C(c0 c0Var, int[][] iArr, int i2, C0130c cVar, g.a aVar) {
        g gVar = null;
        b bVar = null;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < c0Var.f6087b; i5++) {
            b0 g2 = c0Var.g(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < g2.f6079b; i6++) {
                if (v(iArr2[i6], cVar.t)) {
                    b bVar2 = new b(g2.g(i6), cVar, iArr2[i6]);
                    if (bVar == null || bVar2.compareTo(bVar) > 0) {
                        i3 = i5;
                        i4 = i6;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        b0 g3 = c0Var.g(i3);
        if (!cVar.q && !cVar.p && aVar != null) {
            int[] q = q(g3, iArr[i3], cVar.r);
            if (q.length > 0) {
                gVar = aVar.a(g3, a(), q);
            }
        }
        if (gVar == null) {
            gVar = new d(g3, i4);
        }
        com.google.android.exoplayer2.util.e.e(bVar);
        return Pair.create(gVar, bVar);
    }

    /* access modifiers changed from: protected */
    public g E(int i2, c0 c0Var, int[][] iArr, C0130c cVar) {
        b0 b0Var = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < c0Var.f6087b; i5++) {
            b0 g2 = c0Var.g(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < g2.f6079b; i6++) {
                if (v(iArr2[i6], cVar.t)) {
                    int i7 = 1;
                    if ((g2.g(i6).z & 1) != 0) {
                        i7 = 2;
                    }
                    if (v(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i4) {
                        b0Var = g2;
                        i3 = i6;
                        i4 = i7;
                    }
                }
            }
        }
        if (b0Var == null) {
            return null;
        }
        return new d(b0Var, i3);
    }

    /* access modifiers changed from: protected */
    public Pair<g, Integer> F(c0 c0Var, int[][] iArr, C0130c cVar) {
        b0 b0Var = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < c0Var.f6087b; i4++) {
            b0 g2 = c0Var.g(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < g2.f6079b; i5++) {
                if (v(iArr2[i5], cVar.t)) {
                    l g3 = g2.g(i5);
                    int i6 = g3.z & (cVar.f5834g ^ -1);
                    int i7 = 1;
                    boolean z = (i6 & 1) != 0;
                    boolean z2 = (i6 & 2) != 0;
                    boolean n = n(g3, cVar.f5832e);
                    if (n || (cVar.f5833f && o(g3))) {
                        i7 = (z ? 8 : !z2 ? 6 : 4) + (n ? 1 : 0);
                    } else if (z) {
                        i7 = 3;
                    } else if (z2) {
                        if (n(g3, cVar.f5831d)) {
                            i7 = 2;
                        }
                    }
                    if (v(iArr2[i5], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i3) {
                        b0Var = g2;
                        i2 = i5;
                        i3 = i7;
                    }
                }
            }
        }
        if (b0Var == null) {
            return null;
        }
        return Pair.create(new d(b0Var, i2), Integer.valueOf(i3));
    }

    /* access modifiers changed from: protected */
    public g G(c0 c0Var, int[][] iArr, int i2, C0130c cVar, g.a aVar) {
        g A = (cVar.q || cVar.p || aVar == null) ? null : A(c0Var, iArr, i2, cVar, aVar, a());
        return A == null ? D(c0Var, iArr, cVar) : A;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.g0.e
    public final Pair<z[], g[]> i(e.a aVar, int[][][] iArr, int[] iArr2) {
        C0130c cVar = this.f5818d.get();
        int a2 = aVar.a();
        g[] B = B(aVar, iArr, iArr2, cVar);
        for (int i2 = 0; i2 < a2; i2++) {
            if (cVar.m(i2)) {
                B[i2] = null;
            } else {
                c0 c2 = aVar.c(i2);
                if (cVar.o(i2, c2)) {
                    d n = cVar.n(i2, c2);
                    if (n == null) {
                        B[i2] = null;
                    } else if (n.f5841d == 1) {
                        B[i2] = new d(c2.g(n.f5839b), n.f5840c[0]);
                    } else {
                        g.a aVar2 = this.f5817c;
                        com.google.android.exoplayer2.util.e.e(aVar2);
                        B[i2] = aVar2.a(c2.g(n.f5839b), a(), n.f5840c);
                    }
                }
            }
        }
        z[] zVarArr = new z[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            zVarArr[i3] = !cVar.m(i3) && (aVar.b(i3) == 6 || B[i3] != null) ? z.f7102b : null;
        }
        y(aVar, iArr, zVarArr, B, cVar.u);
        return Pair.create(zVarArr, B);
    }
}
