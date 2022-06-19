package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.a;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsPlaylist */
public abstract class f implements a<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f6485a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f6486b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6487c;

    protected f(String str, List<String> list, boolean z) {
        this.f6485a = str;
        this.f6486b = Collections.unmodifiableList(list);
        this.f6487c = z;
    }
}
