package com.google.android.exoplayer2.source;

/* compiled from: CompositeSequenceableLoader */
public class n implements z {

    /* renamed from: b  reason: collision with root package name */
    protected final z[] f6526b;

    public n(z[] zVarArr) {
        this.f6526b = zVarArr;
    }

    @Override // com.google.android.exoplayer2.source.z
    public final long c() {
        long j2 = Long.MAX_VALUE;
        for (z zVar : this.f6526b) {
            long c2 = zVar.c();
            if (c2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, c2);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.z
    public final long d() {
        long j2 = Long.MAX_VALUE;
        for (z zVar : this.f6526b) {
            long d2 = zVar.d();
            if (d2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, d2);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        boolean z = false;
        while (true) {
            long c2 = c();
            if (c2 == Long.MIN_VALUE) {
                break;
            }
            z[] zVarArr = this.f6526b;
            boolean z2 = false;
            for (z zVar : zVarArr) {
                long c3 = zVar.c();
                boolean z3 = c3 != Long.MIN_VALUE && c3 <= j2;
                if (c3 == c2 || z3) {
                    z2 |= zVar.f(j2);
                }
            }
            z |= z2;
            if (!z2) {
                break;
            }
        }
        return z;
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void g(long j2) {
        for (z zVar : this.f6526b) {
            zVar.g(j2);
        }
    }
}
