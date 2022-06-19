package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.upstream.v;
import java.util.Collections;
import java.util.List;

/* compiled from: DefaultHlsPlaylistParserFactory */
public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f6437a;

    public b() {
        this(Collections.emptyList());
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public v.a<f> a(d dVar) {
        return new com.google.android.exoplayer2.offline.b(new g(dVar), this.f6437a);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public v.a<f> b() {
        return new com.google.android.exoplayer2.offline.b(new g(), this.f6437a);
    }

    public b(List<c> list) {
        this.f6437a = list;
    }
}
