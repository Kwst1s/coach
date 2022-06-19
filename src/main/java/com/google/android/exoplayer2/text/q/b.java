package com.google.android.exoplayer2.text.q;

import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.e;
import java.util.Collections;
import java.util.List;

/* compiled from: Tx3gSubtitle */
final class b implements d {

    /* renamed from: c  reason: collision with root package name */
    public static final b f6814c = new b();

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f6815b;

    public b(a aVar) {
        this.f6815b = Collections.singletonList(aVar);
    }

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        e.a(i2 == 0);
        return 0;
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        return j2 >= 0 ? this.f6815b : Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return 1;
    }

    private b() {
        this.f6815b = Collections.emptyList();
    }
}
