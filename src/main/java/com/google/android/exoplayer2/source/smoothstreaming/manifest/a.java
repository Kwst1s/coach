package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: SsManifest */
public class a implements com.google.android.exoplayer2.offline.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final int f6592a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6593b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6594c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6595d;

    /* renamed from: e  reason: collision with root package name */
    public final C0134a f6596e;

    /* renamed from: f  reason: collision with root package name */
    public final b[] f6597f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6598g;

    /* renamed from: h  reason: collision with root package name */
    public final long f6599h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a  reason: collision with other inner class name */
    /* compiled from: SsManifest */
    public static class C0134a {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f6600a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f6601b;

        public C0134a(UUID uuid, byte[] bArr) {
            this.f6600a = uuid;
            this.f6601b = bArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(int i2, int i3, long j2, long j3, long j4, int i4, boolean z, C0134a aVar, b[] bVarArr) {
        this(i2, i3, j3 == 0 ? -9223372036854775807L : d0.Z(j3, 1000000, j2), j4 != 0 ? d0.Z(j4, 1000000, j2) : -9223372036854775807L, i4, z, aVar, bVarArr);
    }

    /* renamed from: b */
    public final a a(List<c> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            c cVar = (c) arrayList.get(i2);
            b bVar2 = this.f6597f[cVar.f6022c];
            if (!(bVar2 == bVar || bVar == null)) {
                arrayList2.add(bVar.b((l[]) arrayList3.toArray(new l[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f6611j[cVar.f6023d]);
            i2++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((l[]) arrayList3.toArray(new l[0])));
        }
        return new a(this.f6592a, this.f6593b, this.f6598g, this.f6599h, this.f6594c, this.f6595d, this.f6596e, (b[]) arrayList2.toArray(new b[0]));
    }

    /* compiled from: SsManifest */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6602a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6603b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6604c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6605d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6606e;

        /* renamed from: f  reason: collision with root package name */
        public final int f6607f;

        /* renamed from: g  reason: collision with root package name */
        public final int f6608g;

        /* renamed from: h  reason: collision with root package name */
        public final int f6609h;

        /* renamed from: i  reason: collision with root package name */
        public final String f6610i;

        /* renamed from: j  reason: collision with root package name */
        public final l[] f6611j;

        /* renamed from: k  reason: collision with root package name */
        public final int f6612k;
        private final String l;
        private final String m;
        private final List<Long> n;
        private final long[] o;
        private final long p;

        public b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, l[] lVarArr, List<Long> list, long j3) {
            this(str, str2, i2, str3, j2, str4, i3, i4, i5, i6, str5, lVarArr, list, d0.a0(list, 1000000, j2), d0.Z(j3, 1000000, j2));
        }

        public Uri a(int i2, int i3) {
            boolean z = true;
            e.f(this.f6611j != null);
            e.f(this.n != null);
            if (i3 >= this.n.size()) {
                z = false;
            }
            e.f(z);
            String num = Integer.toString(this.f6611j[i2].f5973d);
            String l2 = this.n.get(i3).toString();
            return c0.d(this.l, this.m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l2).replace("{start_time}", l2));
        }

        public b b(l[] lVarArr) {
            return new b(this.l, this.m, this.f6602a, this.f6603b, this.f6604c, this.f6605d, this.f6606e, this.f6607f, this.f6608g, this.f6609h, this.f6610i, lVarArr, this.n, this.o, this.p);
        }

        public long c(int i2) {
            if (i2 == this.f6612k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i2 + 1] - jArr[i2];
        }

        public int d(long j2) {
            return d0.e(this.o, j2, true, true);
        }

        public long e(int i2) {
            return this.o[i2];
        }

        private b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, l[] lVarArr, List<Long> list, long[] jArr, long j3) {
            this.l = str;
            this.m = str2;
            this.f6602a = i2;
            this.f6603b = str3;
            this.f6604c = j2;
            this.f6605d = str4;
            this.f6606e = i3;
            this.f6607f = i4;
            this.f6608g = i5;
            this.f6609h = i6;
            this.f6610i = str5;
            this.f6611j = lVarArr;
            this.n = list;
            this.o = jArr;
            this.p = j3;
            this.f6612k = list.size();
        }
    }

    private a(int i2, int i3, long j2, long j3, int i4, boolean z, C0134a aVar, b[] bVarArr) {
        this.f6592a = i2;
        this.f6593b = i3;
        this.f6598g = j2;
        this.f6599h = j3;
        this.f6594c = i4;
        this.f6595d = z;
        this.f6596e = aVar;
        this.f6597f = bVarArr;
    }
}
