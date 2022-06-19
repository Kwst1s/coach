package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.util.e;

/* access modifiers changed from: package-private */
/* compiled from: HlsSampleStream */
public final class m implements y {

    /* renamed from: b  reason: collision with root package name */
    private final int f6414b;

    /* renamed from: c  reason: collision with root package name */
    private final n f6415c;

    /* renamed from: d  reason: collision with root package name */
    private int f6416d = -1;

    public m(n nVar, int i2) {
        this.f6415c = nVar;
        this.f6414b = i2;
    }

    private boolean c() {
        int i2 = this.f6416d;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }

    @Override // com.google.android.exoplayer2.source.y
    public void a() {
        if (this.f6416d != -2) {
            this.f6415c.L();
            return;
        }
        throw new SampleQueueMappingException(this.f6415c.o().g(this.f6414b).g(0).f5977h);
    }

    public void b() {
        e.a(this.f6416d == -1);
        this.f6416d = this.f6415c.u(this.f6414b);
    }

    public void d() {
        if (this.f6416d != -1) {
            this.f6415c.b0(this.f6414b);
            this.f6416d = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public boolean e() {
        return this.f6416d == -3 || (c() && this.f6415c.G(this.f6416d));
    }

    @Override // com.google.android.exoplayer2.source.y
    public int h(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z) {
        if (c()) {
            return this.f6415c.S(this.f6416d, mVar, eVar, z);
        }
        return -3;
    }

    @Override // com.google.android.exoplayer2.source.y
    public int n(long j2) {
        if (c()) {
            return this.f6415c.a0(this.f6416d, j2);
        }
        return 0;
    }
}
