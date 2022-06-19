package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: PlayerEmsgHandler */
public final class j implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final d f6222b;

    /* renamed from: c  reason: collision with root package name */
    private final b f6223c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.f0.g.b f6224d = new com.google.android.exoplayer2.f0.g.b();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f6225e = d0.q(this);

    /* renamed from: f  reason: collision with root package name */
    private final TreeMap<Long, Long> f6226f = new TreeMap<>();

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.exoplayer2.source.dash.k.b f6227g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6228h;

    /* renamed from: i  reason: collision with root package name */
    private long f6229i;

    /* renamed from: j  reason: collision with root package name */
    private long f6230j = -9223372036854775807L;

    /* renamed from: k  reason: collision with root package name */
    private long f6231k = -9223372036854775807L;
    private boolean l;
    private boolean m;

    /* access modifiers changed from: private */
    /* compiled from: PlayerEmsgHandler */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f6232a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6233b;

        public a(long j2, long j3) {
            this.f6232a = j2;
            this.f6233b = j3;
        }
    }

    /* compiled from: PlayerEmsgHandler */
    public interface b {
        void a();

        void b(long j2);

        void c();
    }

    /* compiled from: PlayerEmsgHandler */
    public final class c implements q {

        /* renamed from: a  reason: collision with root package name */
        private final x f6234a;

        /* renamed from: b  reason: collision with root package name */
        private final m f6235b = new m();

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.f0.d f6236c = new com.google.android.exoplayer2.f0.d();

        c(x xVar) {
            this.f6234a = xVar;
        }

        private com.google.android.exoplayer2.f0.d e() {
            this.f6236c.f();
            if (this.f6234a.y(this.f6235b, this.f6236c, false, false, 0) != -4) {
                return null;
            }
            this.f6236c.o();
            return this.f6236c;
        }

        private void i(long j2, long j3) {
            j.this.f6225e.sendMessage(j.this.f6225e.obtainMessage(2, new a(j2, j3)));
        }

        private void j() {
            j.this.f6225e.sendMessage(j.this.f6225e.obtainMessage(1));
        }

        private void k() {
            while (this.f6234a.u()) {
                com.google.android.exoplayer2.f0.d e2 = e();
                if (e2 != null) {
                    long j2 = e2.f4952e;
                    com.google.android.exoplayer2.f0.g.a aVar = (com.google.android.exoplayer2.f0.g.a) j.this.f6224d.a(e2).g(0);
                    if (j.j(aVar.f5709b, aVar.f5710c)) {
                        l(j2, aVar);
                    }
                }
            }
            this.f6234a.l();
        }

        private void l(long j2, com.google.android.exoplayer2.f0.g.a aVar) {
            long f2 = j.f(aVar);
            if (f2 != -9223372036854775807L) {
                if (j.i(aVar)) {
                    j();
                } else {
                    i(j2, f2);
                }
            }
        }

        @Override // com.google.android.exoplayer2.e0.q
        public void a(s sVar, int i2) {
            this.f6234a.a(sVar, i2);
        }

        @Override // com.google.android.exoplayer2.e0.q
        public int b(h hVar, int i2, boolean z) {
            return this.f6234a.b(hVar, i2, z);
        }

        @Override // com.google.android.exoplayer2.e0.q
        public void c(long j2, int i2, int i3, int i4, q.a aVar) {
            this.f6234a.c(j2, i2, i3, i4, aVar);
            k();
        }

        @Override // com.google.android.exoplayer2.e0.q
        public void d(l lVar) {
            this.f6234a.d(lVar);
        }

        public boolean f(long j2) {
            return j.this.l(j2);
        }

        public boolean g(com.google.android.exoplayer2.source.d0.d dVar) {
            return j.this.m(dVar);
        }

        public void h(com.google.android.exoplayer2.source.d0.d dVar) {
            j.this.q(dVar);
        }

        public void m() {
            this.f6234a.C();
        }
    }

    public j(com.google.android.exoplayer2.source.dash.k.b bVar, b bVar2, d dVar) {
        this.f6227g = bVar;
        this.f6223c = bVar2;
        this.f6222b = dVar;
    }

    private Map.Entry<Long, Long> e(long j2) {
        return this.f6226f.ceilingEntry(Long.valueOf(j2));
    }

    /* access modifiers changed from: private */
    public static long f(com.google.android.exoplayer2.f0.g.a aVar) {
        try {
            return d0.U(d0.t(aVar.f5714g));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    private void g(long j2, long j3) {
        Long l2 = this.f6226f.get(Long.valueOf(j3));
        if (l2 == null) {
            this.f6226f.put(Long.valueOf(j3), Long.valueOf(j2));
        } else if (l2.longValue() > j2) {
            this.f6226f.put(Long.valueOf(j3), Long.valueOf(j2));
        }
    }

    private void h() {
        this.f6228h = true;
        p();
    }

    /* access modifiers changed from: private */
    public static boolean i(com.google.android.exoplayer2.f0.g.a aVar) {
        return aVar.f5712e == 0 && aVar.f5711d == 0;
    }

    public static boolean j(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    private void k() {
        long j2 = this.f6231k;
        if (j2 == -9223372036854775807L || j2 != this.f6230j) {
            this.l = true;
            this.f6231k = this.f6230j;
            this.f6223c.a();
        }
    }

    private void o() {
        this.f6223c.b(this.f6229i);
    }

    private void p() {
        this.f6223c.c();
    }

    private void s() {
        Iterator<Map.Entry<Long, Long>> it = this.f6226f.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f6227g.f6250h) {
                it.remove();
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (this.m) {
            return true;
        }
        int i2 = message.what;
        if (i2 == 1) {
            h();
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            a aVar = (a) message.obj;
            g(aVar.f6232a, aVar.f6233b);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(long r7) {
        /*
            r6 = this;
            com.google.android.exoplayer2.source.dash.k.b r0 = r6.f6227g
            boolean r1 = r0.f6246d
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r1 = r6.l
            r3 = 1
            if (r1 == 0) goto L_0x000e
            return r3
        L_0x000e:
            boolean r1 = r6.f6228h
            if (r1 == 0) goto L_0x0014
        L_0x0012:
            r2 = 1
            goto L_0x003a
        L_0x0014:
            long r0 = r0.f6250h
            java.util.Map$Entry r0 = r6.e(r0)
            if (r0 == 0) goto L_0x003a
            java.lang.Object r1 = r0.getValue()
            java.lang.Long r1 = (java.lang.Long) r1
            long r4 = r1.longValue()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x003a
            java.lang.Object r7 = r0.getKey()
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            r6.f6229i = r7
            r6.o()
            goto L_0x0012
        L_0x003a:
            if (r2 == 0) goto L_0x003f
            r6.k()
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.j.l(long):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean m(com.google.android.exoplayer2.source.d0.d dVar) {
        if (!this.f6227g.f6246d) {
            return false;
        }
        if (this.l) {
            return true;
        }
        long j2 = this.f6230j;
        if (!(j2 != -9223372036854775807L && j2 < dVar.f6103f)) {
            return false;
        }
        k();
        return true;
    }

    public c n() {
        return new c(new x(this.f6222b));
    }

    /* access modifiers changed from: package-private */
    public void q(com.google.android.exoplayer2.source.d0.d dVar) {
        long j2 = this.f6230j;
        if (j2 != -9223372036854775807L || dVar.f6104g > j2) {
            this.f6230j = dVar.f6104g;
        }
    }

    public void r() {
        this.m = true;
        this.f6225e.removeCallbacksAndMessages(null);
    }

    public void t(com.google.android.exoplayer2.source.dash.k.b bVar) {
        this.l = false;
        this.f6229i = -9223372036854775807L;
        this.f6227g = bVar;
        s();
    }
}
