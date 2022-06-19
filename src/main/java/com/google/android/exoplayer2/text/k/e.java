package com.google.android.exoplayer2.text.k;

import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.g;
import com.google.android.exoplayer2.text.h;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* access modifiers changed from: package-private */
/* compiled from: CeaDecoder */
public abstract class e implements com.google.android.exoplayer2.text.e {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<b> f6701a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<h> f6702b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<b> f6703c;

    /* renamed from: d  reason: collision with root package name */
    private b f6704d;

    /* renamed from: e  reason: collision with root package name */
    private long f6705e;

    /* renamed from: f  reason: collision with root package name */
    private long f6706f;

    /* access modifiers changed from: private */
    /* compiled from: CeaDecoder */
    public static final class b extends g implements Comparable<b> {

        /* renamed from: h  reason: collision with root package name */
        private long f6707h;

        private b() {
        }

        /* renamed from: t */
        public int compareTo(b bVar) {
            if (j() == bVar.j()) {
                long j2 = this.f4952e - bVar.f4952e;
                if (j2 == 0) {
                    j2 = this.f6707h - bVar.f6707h;
                    if (j2 == 0) {
                        return 0;
                    }
                }
                if (j2 > 0) {
                    return 1;
                }
                return -1;
            } else if (j()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    /* compiled from: CeaDecoder */
    private final class c extends h {
        private c() {
        }

        @Override // com.google.android.exoplayer2.d0.f
        public final void m() {
            e.this.m(this);
        }
    }

    public e() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f6701a.add(new b());
        }
        this.f6702b = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f6702b.add(new c());
        }
        this.f6703c = new PriorityQueue<>();
    }

    private void l(b bVar) {
        bVar.f();
        this.f6701a.add(bVar);
    }

    @Override // com.google.android.exoplayer2.d0.c
    public void a() {
    }

    @Override // com.google.android.exoplayer2.text.e
    public void b(long j2) {
        this.f6705e = j2;
    }

    /* access modifiers changed from: protected */
    public abstract d f();

    @Override // com.google.android.exoplayer2.d0.c
    public void flush() {
        this.f6706f = 0;
        this.f6705e = 0;
        while (!this.f6703c.isEmpty()) {
            l(this.f6703c.poll());
        }
        b bVar = this.f6704d;
        if (bVar != null) {
            l(bVar);
            this.f6704d = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void g(g gVar);

    /* renamed from: h */
    public g e() {
        com.google.android.exoplayer2.util.e.f(this.f6704d == null);
        if (this.f6701a.isEmpty()) {
            return null;
        }
        b pollFirst = this.f6701a.pollFirst();
        this.f6704d = pollFirst;
        return pollFirst;
    }

    /* renamed from: i */
    public h d() {
        if (this.f6702b.isEmpty()) {
            return null;
        }
        while (!this.f6703c.isEmpty() && this.f6703c.peek().f4952e <= this.f6705e) {
            b poll = this.f6703c.poll();
            if (poll.j()) {
                h pollFirst = this.f6702b.pollFirst();
                pollFirst.e(4);
                l(poll);
                return pollFirst;
            }
            g(poll);
            if (j()) {
                d f2 = f();
                if (!poll.i()) {
                    h pollFirst2 = this.f6702b.pollFirst();
                    pollFirst2.n(poll.f4952e, f2, Long.MAX_VALUE);
                    l(poll);
                    return pollFirst2;
                }
            }
            l(poll);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean j();

    /* renamed from: k */
    public void c(g gVar) {
        com.google.android.exoplayer2.util.e.a(gVar == this.f6704d);
        if (gVar.i()) {
            l(this.f6704d);
        } else {
            b bVar = this.f6704d;
            long j2 = this.f6706f;
            this.f6706f = 1 + j2;
            bVar.f6707h = j2;
            this.f6703c.add(this.f6704d);
        }
        this.f6704d = null;
    }

    /* access modifiers changed from: protected */
    public void m(h hVar) {
        hVar.f();
        this.f6702b.add(hVar);
    }
}
