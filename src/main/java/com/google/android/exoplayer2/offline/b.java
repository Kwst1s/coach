package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.a;
import com.google.android.exoplayer2.upstream.v;
import java.io.InputStream;
import java.util.List;

/* compiled from: FilteringManifestParser */
public final class b<T extends a<T>> implements v.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final v.a<T> f6019a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f6020b;

    public b(v.a<T> aVar, List<c> list) {
        this.f6019a = aVar;
        this.f6020b = list;
    }

    /* renamed from: b */
    public T a(Uri uri, InputStream inputStream) {
        T a2 = this.f6019a.a(uri, inputStream);
        List<c> list = this.f6020b;
        return (list == null || list.isEmpty()) ? a2 : (T) ((a) a2.a(this.f6020b));
    }
}
