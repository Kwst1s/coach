package com.google.android.exoplayer2.d0;

import com.google.android.exoplayer2.d0.e;
import com.google.android.exoplayer2.d0.f;
import java.lang.Exception;
import java.util.ArrayDeque;

/* compiled from: SimpleDecoder */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f4956a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4957b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f4958c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<O> f4959d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f4960e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f4961f;

    /* renamed from: g  reason: collision with root package name */
    private int f4962g;

    /* renamed from: h  reason: collision with root package name */
    private int f4963h;

    /* renamed from: i  reason: collision with root package name */
    private I f4964i;

    /* renamed from: j  reason: collision with root package name */
    private E f4965j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4966k;
    private boolean l;
    private int m;

    /* compiled from: SimpleDecoder */
    class a extends Thread {
        a() {
        }

        public void run() {
            g.this.u();
        }
    }

    protected g(I[] iArr, O[] oArr) {
        this.f4960e = iArr;
        this.f4962g = iArr.length;
        for (int i2 = 0; i2 < this.f4962g; i2++) {
            this.f4960e[i2] = h();
        }
        this.f4961f = oArr;
        this.f4963h = oArr.length;
        for (int i3 = 0; i3 < this.f4963h; i3++) {
            this.f4961f[i3] = i();
        }
        a aVar = new a();
        this.f4956a = aVar;
        aVar.start();
    }

    private boolean g() {
        return !this.f4958c.isEmpty() && this.f4963h > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.j() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.e(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.i() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.e(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r6.f4965j = k(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r6.f4965j = j(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r6.f4965j = j(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean l() {
        /*
        // Method dump skipped, instructions count: 155
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d0.g.l():boolean");
    }

    private void o() {
        if (g()) {
            this.f4957b.notify();
        }
    }

    private void p() {
        E e2 = this.f4965j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void r(I i2) {
        i2.f();
        I[] iArr = this.f4960e;
        int i3 = this.f4962g;
        this.f4962g = i3 + 1;
        iArr[i3] = i2;
    }

    private void t(O o) {
        o.f();
        O[] oArr = this.f4961f;
        int i2 = this.f4963h;
        this.f4963h = i2 + 1;
        oArr[i2] = o;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (l());
    }

    @Override // com.google.android.exoplayer2.d0.c
    public void a() {
        synchronized (this.f4957b) {
            this.l = true;
            this.f4957b.notify();
        }
        try {
            this.f4956a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.google.android.exoplayer2.d0.c
    public final void flush() {
        synchronized (this.f4957b) {
            this.f4966k = true;
            this.m = 0;
            I i2 = this.f4964i;
            if (i2 != null) {
                r(i2);
                this.f4964i = null;
            }
            while (!this.f4958c.isEmpty()) {
                r(this.f4958c.removeFirst());
            }
            while (!this.f4959d.isEmpty()) {
                this.f4959d.removeFirst().m();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract I h();

    /* access modifiers changed from: protected */
    public abstract O i();

    /* access modifiers changed from: protected */
    public abstract E j(Throwable th);

    /* access modifiers changed from: protected */
    public abstract E k(I i2, O o, boolean z);

    /* renamed from: m */
    public final I e() {
        I i2;
        synchronized (this.f4957b) {
            p();
            com.google.android.exoplayer2.util.e.f(this.f4964i == null);
            int i3 = this.f4962g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f4960e;
                int i4 = i3 - 1;
                this.f4962g = i4;
                i2 = iArr[i4];
            }
            this.f4964i = i2;
        }
        return i2;
    }

    /* renamed from: n */
    public final O d() {
        synchronized (this.f4957b) {
            p();
            if (this.f4959d.isEmpty()) {
                return null;
            }
            return this.f4959d.removeFirst();
        }
    }

    /* renamed from: q */
    public final void c(I i2) {
        synchronized (this.f4957b) {
            p();
            com.google.android.exoplayer2.util.e.a(i2 == this.f4964i);
            this.f4958c.addLast(i2);
            o();
            this.f4964i = null;
        }
    }

    /* access modifiers changed from: protected */
    public void s(O o) {
        synchronized (this.f4957b) {
            t(o);
            o();
        }
    }

    /* access modifiers changed from: protected */
    public final void v(int i2) {
        com.google.android.exoplayer2.util.e.f(this.f4962g == this.f4960e.length);
        for (I i3 : this.f4960e) {
            i3.n(i2);
        }
    }
}
