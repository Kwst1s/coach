package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: BaseDataSource */
public abstract class f implements i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6909a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<x> f6910b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private int f6911c;

    /* renamed from: d  reason: collision with root package name */
    private k f6912d;

    protected f(boolean z) {
        this.f6909a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public /* synthetic */ Map c() {
        return h.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final void d(x xVar) {
        if (!this.f6910b.contains(xVar)) {
            this.f6910b.add(xVar);
            this.f6911c++;
        }
    }

    /* access modifiers changed from: protected */
    public final void f(int i2) {
        k kVar = this.f6912d;
        d0.f(kVar);
        k kVar2 = kVar;
        for (int i3 = 0; i3 < this.f6911c; i3++) {
            this.f6910b.get(i3).d(this, kVar2, this.f6909a, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        k kVar = this.f6912d;
        d0.f(kVar);
        k kVar2 = kVar;
        for (int i2 = 0; i2 < this.f6911c; i2++) {
            this.f6910b.get(i2).c(this, kVar2, this.f6909a);
        }
        this.f6912d = null;
    }

    /* access modifiers changed from: protected */
    public final void h(k kVar) {
        for (int i2 = 0; i2 < this.f6911c; i2++) {
            this.f6910b.get(i2).f(this, kVar, this.f6909a);
        }
    }

    /* access modifiers changed from: protected */
    public final void i(k kVar) {
        this.f6912d = kVar;
        for (int i2 = 0; i2 < this.f6911c; i2++) {
            this.f6910b.get(i2).e(this, kVar, this.f6909a);
        }
    }
}
