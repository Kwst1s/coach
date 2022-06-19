package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g0.h;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.d0;

/* compiled from: DefaultLoadControl */
public class e implements n {

    /* renamed from: a  reason: collision with root package name */
    private final l f5017a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5018b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5019c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5020d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5021e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5022f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5023g;

    /* renamed from: h  reason: collision with root package name */
    private final PriorityTaskManager f5024h;

    /* renamed from: i  reason: collision with root package name */
    private final long f5025i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f5026j;

    /* renamed from: k  reason: collision with root package name */
    private int f5027k;
    private boolean l;

    public e() {
        this(new l(true, 65536));
    }

    private static void j(int i2, int i3, String str, String str2) {
        boolean z = i2 >= i3;
        com.google.android.exoplayer2.util.e.b(z, str + " cannot be less than " + str2);
    }

    private void l(boolean z) {
        this.f5027k = 0;
        PriorityTaskManager priorityTaskManager = this.f5024h;
        if (priorityTaskManager == null || !this.l) {
            this.l = false;
            if (z) {
                this.f5017a.g();
                return;
            }
            return;
        }
        priorityTaskManager.b(0);
        throw null;
    }

    @Override // com.google.android.exoplayer2.n
    public void a() {
        l(false);
    }

    @Override // com.google.android.exoplayer2.n
    public boolean b(long j2, float f2, boolean z) {
        long I = d0.I(j2, f2);
        long j3 = z ? this.f5021e : this.f5020d;
        return j3 <= 0 || I >= j3 || (!this.f5023g && this.f5017a.f() >= this.f5027k);
    }

    @Override // com.google.android.exoplayer2.n
    public boolean c() {
        return this.f5026j;
    }

    @Override // com.google.android.exoplayer2.n
    public boolean d(long j2, float f2) {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.f5017a.f() >= this.f5027k;
        boolean z4 = this.l;
        long j3 = this.f5018b;
        if (f2 > 1.0f) {
            j3 = Math.min(d0.D(j3, f2), this.f5019c);
        }
        if (j2 < j3) {
            if (!this.f5023g && z3) {
                z2 = false;
            }
            this.l = z2;
        } else if (j2 > this.f5019c || z3) {
            this.l = false;
        }
        PriorityTaskManager priorityTaskManager = this.f5024h;
        if (priorityTaskManager == null || (z = this.l) == z4) {
            return this.l;
        }
        if (z) {
            priorityTaskManager.a(0);
            throw null;
        }
        priorityTaskManager.b(0);
        throw null;
    }

    @Override // com.google.android.exoplayer2.n
    public void e(x[] xVarArr, c0 c0Var, h hVar) {
        int i2 = this.f5022f;
        if (i2 == -1) {
            i2 = k(xVarArr, hVar);
        }
        this.f5027k = i2;
        this.f5017a.h(i2);
    }

    @Override // com.google.android.exoplayer2.n
    public void f() {
        l(true);
    }

    @Override // com.google.android.exoplayer2.n
    public d g() {
        return this.f5017a;
    }

    @Override // com.google.android.exoplayer2.n
    public void h() {
        l(true);
    }

    @Override // com.google.android.exoplayer2.n
    public long i() {
        return this.f5025i;
    }

    /* access modifiers changed from: protected */
    public int k(x[] xVarArr, h hVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < xVarArr.length; i3++) {
            if (hVar.a(i3) != null) {
                i2 += d0.A(xVarArr[i3].g());
            }
        }
        return i2;
    }

    @Deprecated
    public e(l lVar) {
        this(lVar, 15000, 50000, 2500, 5000, -1, true);
    }

    @Deprecated
    public e(l lVar, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this(lVar, i2, i3, i4, i5, i6, z, null);
    }

    @Deprecated
    public e(l lVar, int i2, int i3, int i4, int i5, int i6, boolean z, PriorityTaskManager priorityTaskManager) {
        this(lVar, i2, i3, i4, i5, i6, z, priorityTaskManager, 0, false);
    }

    protected e(l lVar, int i2, int i3, int i4, int i5, int i6, boolean z, PriorityTaskManager priorityTaskManager, int i7, boolean z2) {
        j(i4, 0, "bufferForPlaybackMs", "0");
        j(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        j(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        j(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        j(i3, i2, "maxBufferMs", "minBufferMs");
        j(i7, 0, "backBufferDurationMs", "0");
        this.f5017a = lVar;
        this.f5018b = d.a((long) i2);
        this.f5019c = d.a((long) i3);
        this.f5020d = d.a((long) i4);
        this.f5021e = d.a((long) i5);
        this.f5022f = i6;
        this.f5023g = z;
        this.f5025i = d.a((long) i7);
        this.f5026j = z2;
    }
}
