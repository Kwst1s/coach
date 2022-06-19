package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;

/* compiled from: DefaultHttpDataSourceFactory */
public final class q extends HttpDataSource.a {

    /* renamed from: b  reason: collision with root package name */
    private final String f6975b;

    /* renamed from: c  reason: collision with root package name */
    private final x f6976c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6977d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6978e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6979f;

    public q(String str, x xVar) {
        this(str, xVar, 8000, 8000, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public p c(HttpDataSource.b bVar) {
        p pVar = new p(this.f6975b, null, this.f6977d, this.f6978e, this.f6979f, bVar);
        x xVar = this.f6976c;
        if (xVar != null) {
            pVar.d(xVar);
        }
        return pVar;
    }

    public q(String str, x xVar, int i2, int i3, boolean z) {
        this.f6975b = str;
        this.f6976c = xVar;
        this.f6977d = i2;
        this.f6978e = i3;
        this.f6979f = z;
    }
}
