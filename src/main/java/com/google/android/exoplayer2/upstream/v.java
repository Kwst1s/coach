package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* compiled from: ParsingLoadable */
public final class v<T> implements Loader.e {

    /* renamed from: a  reason: collision with root package name */
    public final k f6981a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6982b;

    /* renamed from: c  reason: collision with root package name */
    private final w f6983c;

    /* renamed from: d  reason: collision with root package name */
    private final a<? extends T> f6984d;

    /* renamed from: e  reason: collision with root package name */
    private volatile T f6985e;

    /* compiled from: ParsingLoadable */
    public interface a<T> {
        T a(Uri uri, InputStream inputStream);
    }

    public v(i iVar, Uri uri, int i2, a<? extends T> aVar) {
        this(iVar, new k(uri, 3), i2, aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() {
        this.f6983c.i();
        j jVar = new j(this.f6983c, this.f6981a);
        try {
            jVar.E();
            Uri e2 = this.f6983c.e();
            e.e(e2);
            this.f6985e = (T) this.f6984d.a(e2, jVar);
        } finally {
            d0.k(jVar);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() {
    }

    public long c() {
        return this.f6983c.f();
    }

    public Map<String, List<String>> d() {
        return this.f6983c.h();
    }

    public final T e() {
        return this.f6985e;
    }

    public Uri f() {
        return this.f6983c.g();
    }

    public v(i iVar, k kVar, int i2, a<? extends T> aVar) {
        this.f6983c = new w(iVar);
        this.f6981a = kVar;
        this.f6982b = i2;
        this.f6984d = aVar;
    }
}
