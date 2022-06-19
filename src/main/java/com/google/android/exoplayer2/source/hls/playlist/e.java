package com.google.android.exoplayer2.source.hls.playlist;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.offline.c;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsMediaPlaylist */
public final class e extends f {

    /* renamed from: d  reason: collision with root package name */
    public final int f6467d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6468e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6469f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6470g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6471h;

    /* renamed from: i  reason: collision with root package name */
    public final long f6472i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6473j;

    /* renamed from: k  reason: collision with root package name */
    public final long f6474k;
    public final boolean l;
    public final boolean m;
    public final l n;
    public final List<a> o;
    public final long p;

    /* compiled from: HlsMediaPlaylist */
    public static final class a implements Comparable<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final String f6475b;

        /* renamed from: c  reason: collision with root package name */
        public final a f6476c;

        /* renamed from: d  reason: collision with root package name */
        public final long f6477d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6478e;

        /* renamed from: f  reason: collision with root package name */
        public final long f6479f;

        /* renamed from: g  reason: collision with root package name */
        public final l f6480g;

        /* renamed from: h  reason: collision with root package name */
        public final String f6481h;

        /* renamed from: i  reason: collision with root package name */
        public final String f6482i;

        /* renamed from: j  reason: collision with root package name */
        public final long f6483j;

        /* renamed from: k  reason: collision with root package name */
        public final long f6484k;
        public final boolean l;

        public a(String str, long j2, long j3) {
            this(str, null, BuildConfig.FLAVOR, 0, -1, -9223372036854775807L, null, null, null, j2, j3, false);
        }

        /* renamed from: a */
        public int compareTo(Long l2) {
            if (this.f6479f > l2.longValue()) {
                return 1;
            }
            return this.f6479f < l2.longValue() ? -1 : 0;
        }

        public a(String str, a aVar, String str2, long j2, int i2, long j3, l lVar, String str3, String str4, long j4, long j5, boolean z) {
            this.f6475b = str;
            this.f6476c = aVar;
            this.f6477d = j2;
            this.f6478e = i2;
            this.f6479f = j3;
            this.f6480g = lVar;
            this.f6481h = str3;
            this.f6482i = str4;
            this.f6483j = j4;
            this.f6484k = j5;
            this.l = z;
        }
    }

    public e(int i2, String str, List<String> list, long j2, long j3, boolean z, int i3, long j4, int i4, long j5, boolean z2, boolean z3, boolean z4, l lVar, List<a> list2) {
        super(str, list, z2);
        this.f6467d = i2;
        this.f6469f = j3;
        this.f6470g = z;
        this.f6471h = i3;
        this.f6472i = j4;
        this.f6473j = i4;
        this.f6474k = j5;
        this.l = z3;
        this.m = z4;
        this.n = lVar;
        this.o = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar = list2.get(list2.size() - 1);
            this.p = aVar.f6479f + aVar.f6477d;
        } else {
            this.p = 0;
        }
        this.f6468e = j2 == -9223372036854775807L ? -9223372036854775807L : j2 >= 0 ? j2 : this.p + j2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.exoplayer2.offline.a
    public /* bridge */ /* synthetic */ f a(List list) {
        b(list);
        return this;
    }

    public e b(List<c> list) {
        return this;
    }

    public e c(long j2, int i2) {
        return new e(this.f6467d, this.f6485a, this.f6486b, this.f6468e, j2, true, i2, this.f6472i, this.f6473j, this.f6474k, this.f6487c, this.l, this.m, this.n, this.o);
    }

    public e d() {
        if (this.l) {
            return this;
        }
        return new e(this.f6467d, this.f6485a, this.f6486b, this.f6468e, this.f6469f, this.f6470g, this.f6471h, this.f6472i, this.f6473j, this.f6474k, this.f6487c, true, this.m, this.n, this.o);
    }

    public long e() {
        return this.f6469f + this.p;
    }

    public boolean f(e eVar) {
        if (eVar == null) {
            return true;
        }
        long j2 = this.f6472i;
        long j3 = eVar.f6472i;
        if (j2 > j3) {
            return true;
        }
        if (j2 < j3) {
            return false;
        }
        int size = this.o.size();
        int size2 = eVar.o.size();
        if (size > size2) {
            return true;
        }
        if (size != size2 || !this.l || eVar.l) {
            return false;
        }
        return true;
    }
}
