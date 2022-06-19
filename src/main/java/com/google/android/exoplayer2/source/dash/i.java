package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.f0.g.c;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.dash.k.e;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.util.d0;

/* access modifiers changed from: package-private */
/* compiled from: EventSampleStream */
public final class i implements y {

    /* renamed from: b  reason: collision with root package name */
    private final l f6214b;

    /* renamed from: c  reason: collision with root package name */
    private final c f6215c = new c();

    /* renamed from: d  reason: collision with root package name */
    private long[] f6216d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6217e;

    /* renamed from: f  reason: collision with root package name */
    private e f6218f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6219g;

    /* renamed from: h  reason: collision with root package name */
    private int f6220h;

    /* renamed from: i  reason: collision with root package name */
    private long f6221i = -9223372036854775807L;

    public i(e eVar, l lVar, boolean z) {
        this.f6214b = lVar;
        this.f6218f = eVar;
        this.f6216d = eVar.f6270b;
        d(eVar, z);
    }

    @Override // com.google.android.exoplayer2.source.y
    public void a() {
    }

    public String b() {
        return this.f6218f.a();
    }

    public void c(long j2) {
        boolean z = true;
        int c2 = d0.c(this.f6216d, j2, true, false);
        this.f6220h = c2;
        if (!this.f6217e || c2 != this.f6216d.length) {
            z = false;
        }
        if (!z) {
            j2 = -9223372036854775807L;
        }
        this.f6221i = j2;
    }

    public void d(e eVar, boolean z) {
        int i2 = this.f6220h;
        long j2 = i2 == 0 ? -9223372036854775807L : this.f6216d[i2 - 1];
        this.f6217e = z;
        this.f6218f = eVar;
        long[] jArr = eVar.f6270b;
        this.f6216d = jArr;
        long j3 = this.f6221i;
        if (j3 != -9223372036854775807L) {
            c(j3);
        } else if (j2 != -9223372036854775807L) {
            this.f6220h = d0.c(jArr, j2, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.y
    public int h(m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z) {
        if (z || !this.f6219g) {
            mVar.f5981a = this.f6214b;
            this.f6219g = true;
            return -5;
        }
        int i2 = this.f6220h;
        if (i2 != this.f6216d.length) {
            this.f6220h = i2 + 1;
            c cVar = this.f6215c;
            e eVar2 = this.f6218f;
            byte[] a2 = cVar.a(eVar2.f6269a[i2], eVar2.f6273e);
            if (a2 == null) {
                return -3;
            }
            eVar.n(a2.length);
            eVar.l(1);
            eVar.f4951d.put(a2);
            eVar.f4952e = this.f6216d[i2];
            return -4;
        } else if (this.f6217e) {
            return -3;
        } else {
            eVar.l(4);
            return -4;
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public int n(long j2) {
        int max = Math.max(this.f6220h, d0.c(this.f6216d, j2, true, false));
        int i2 = max - this.f6220h;
        this.f6220h = max;
        return i2;
    }
}
