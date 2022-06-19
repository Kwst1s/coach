package com.google.android.exoplayer2.source.d0;

import android.net.Uri;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.util.e;
import java.util.List;
import java.util.Map;

/* compiled from: Chunk */
public abstract class d implements Loader.e {

    /* renamed from: a  reason: collision with root package name */
    public final k f6098a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6099b;

    /* renamed from: c  reason: collision with root package name */
    public final l f6100c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6101d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f6102e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6103f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6104g;

    /* renamed from: h  reason: collision with root package name */
    protected final w f6105h;

    public d(i iVar, k kVar, int i2, l lVar, int i3, Object obj, long j2, long j3) {
        this.f6105h = new w(iVar);
        e.e(kVar);
        this.f6098a = kVar;
        this.f6099b = i2;
        this.f6100c = lVar;
        this.f6101d = i3;
        this.f6102e = obj;
        this.f6103f = j2;
        this.f6104g = j3;
    }

    public final long c() {
        return this.f6105h.f();
    }

    public final long d() {
        return this.f6104g - this.f6103f;
    }

    public final Map<String, List<String>> e() {
        return this.f6105h.h();
    }

    public final Uri f() {
        return this.f6105h.g();
    }
}
