package com.google.android.exoplayer2.source.dash.k;

import android.net.Uri;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.dash.f;
import com.google.android.exoplayer2.source.dash.k.j;
import java.util.Collections;
import java.util.List;

/* compiled from: Representation */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final l f6287a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6288b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6289c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f6290d;

    /* renamed from: e  reason: collision with root package name */
    private final h f6291e;

    /* compiled from: Representation */
    public static class b extends i implements f {

        /* renamed from: f  reason: collision with root package name */
        private final j.a f6292f;

        public b(String str, long j2, l lVar, String str2, j.a aVar, List<d> list) {
            super(str, j2, lVar, str2, aVar, list);
            this.f6292f = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public long a(long j2, long j3) {
            return this.f6292f.f(j2, j3);
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public long b(long j2) {
            return this.f6292f.g(j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public long c(long j2, long j3) {
            return this.f6292f.e(j2, j3);
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public h d(long j2) {
            return this.f6292f.h(this, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public boolean e() {
            return this.f6292f.i();
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public long f() {
            return this.f6292f.c();
        }

        @Override // com.google.android.exoplayer2.source.dash.f
        public int g(long j2) {
            return this.f6292f.d(j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.k.i
        public String h() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.i
        public f i() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.i
        public h j() {
            return null;
        }
    }

    /* compiled from: Representation */
    public static class c extends i {

        /* renamed from: f  reason: collision with root package name */
        private final String f6293f;

        /* renamed from: g  reason: collision with root package name */
        private final h f6294g;

        /* renamed from: h  reason: collision with root package name */
        private final k f6295h;

        public c(String str, long j2, l lVar, String str2, j.e eVar, List<d> list, String str3, long j3) {
            super(str, j2, lVar, str2, eVar, list);
            String str4;
            Uri.parse(str2);
            h c2 = eVar.c();
            this.f6294g = c2;
            k kVar = null;
            if (str3 != null) {
                str4 = str3;
            } else if (str != null) {
                str4 = str + "." + lVar.f5971b + "." + j2;
            } else {
                str4 = null;
            }
            this.f6293f = str4;
            this.f6295h = c2 == null ? new k(new h(null, 0, j3)) : kVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.i
        public String h() {
            return this.f6293f;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.i
        public f i() {
            return this.f6295h;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.i
        public h j() {
            return this.f6294g;
        }
    }

    public static i l(String str, long j2, l lVar, String str2, j jVar, List<d> list) {
        return m(str, j2, lVar, str2, jVar, list, null);
    }

    public static i m(String str, long j2, l lVar, String str2, j jVar, List<d> list, String str3) {
        if (jVar instanceof j.e) {
            return new c(str, j2, lVar, str2, (j.e) jVar, list, str3, -1);
        }
        if (jVar instanceof j.a) {
            return new b(str, j2, lVar, str2, (j.a) jVar, list);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String h();

    public abstract f i();

    public abstract h j();

    public h k() {
        return this.f6291e;
    }

    private i(String str, long j2, l lVar, String str2, j jVar, List<d> list) {
        List<d> list2;
        this.f6287a = lVar;
        this.f6288b = str2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.f6290d = list2;
        this.f6291e = jVar.a(this);
        this.f6289c = jVar.b();
    }
}
