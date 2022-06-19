package com.google.android.exoplayer2.text.p;

import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.d0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: TtmlSubtitle */
public final class f implements d {

    /* renamed from: b  reason: collision with root package name */
    private final b f6810b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f6811c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, e> f6812d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, c> f6813e;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.f6810b = bVar;
        this.f6813e = map2;
        this.f6812d = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f6811c = bVar.j();
    }

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        int c2 = d0.c(this.f6811c, j2, false, false);
        if (c2 < this.f6811c.length) {
            return c2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        return this.f6811c[i2];
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        return this.f6810b.h(j2, this.f6812d, this.f6813e);
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return this.f6811c.length;
    }
}
