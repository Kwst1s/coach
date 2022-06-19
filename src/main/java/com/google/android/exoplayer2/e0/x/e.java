package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;

/* compiled from: Ac3Extractor */
public final class e implements g {

    /* renamed from: e  reason: collision with root package name */
    private static final int f5440e = d0.B("ID3");

    /* renamed from: a  reason: collision with root package name */
    private final long f5441a;

    /* renamed from: b  reason: collision with root package name */
    private final f f5442b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5443c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5444d;

    static {
        a aVar = a.f5404a;
    }

    public e() {
        this(0);
    }

    static /* synthetic */ g[] b() {
        return new g[]{new e()};
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5442b.f(iVar, new e0.d(0, 1));
        iVar.h();
        iVar.e(new o.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5444d = false;
        this.f5442b.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0032, code lost:
        r8.e();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        if ((r4 - r3) < 8192) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        return false;
     */
    @Override // com.google.android.exoplayer2.e0.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(com.google.android.exoplayer2.e0.h r8) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.x.e.f(com.google.android.exoplayer2.e0.h):boolean");
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        int a2 = hVar.a(this.f5443c.f7062a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f5443c.K(0);
        this.f5443c.J(a2);
        if (!this.f5444d) {
            this.f5442b.d(this.f5441a, true);
            this.f5444d = true;
        }
        this.f5442b.c(this.f5443c);
        return 0;
    }

    public e(long j2) {
        this.f5441a = j2;
        this.f5442b = new f();
        this.f5443c = new s(2786);
    }
}
