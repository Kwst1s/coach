package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.d0.f;
import java.util.List;

/* compiled from: SubtitleOutputBuffer */
public abstract class h extends f implements d {

    /* renamed from: e  reason: collision with root package name */
    private d f6661e;

    /* renamed from: f  reason: collision with root package name */
    private long f6662f;

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        return this.f6661e.a(j2 - this.f6662f);
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        return this.f6661e.b(i2) + this.f6662f;
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        return this.f6661e.c(j2 - this.f6662f);
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return this.f6661e.d();
    }

    @Override // com.google.android.exoplayer2.d0.a
    public void f() {
        super.f();
        this.f6661e = null;
    }

    public void n(long j2, d dVar, long j3) {
        this.f4954c = j2;
        this.f6661e = dVar;
        if (j3 != Long.MAX_VALUE) {
            j2 = j3;
        }
        this.f6662f = j2;
    }
}
