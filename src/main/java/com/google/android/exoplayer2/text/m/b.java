package com.google.android.exoplayer2.text.m;

import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.d;
import java.util.List;

/* compiled from: PgsSubtitle */
final class b implements d {

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f6771b;

    public b(List<a> list) {
        this.f6771b = list;
    }

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        return this.f6771b;
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return 1;
    }
}
