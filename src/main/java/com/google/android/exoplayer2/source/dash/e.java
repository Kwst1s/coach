package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.j;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DashMediaSource */
public final class e extends l {
    private IOException A;
    private Handler B;
    private Uri C;
    private Uri D;
    private com.google.android.exoplayer2.source.dash.k.b E;
    private boolean F;
    private long G;
    private long H;
    private long I;
    private int J;
    private long K;
    private boolean L;
    private int M;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6165g;

    /* renamed from: h  reason: collision with root package name */
    private final i.a f6166h;

    /* renamed from: i  reason: collision with root package name */
    private final c.a f6167i;

    /* renamed from: j  reason: collision with root package name */
    private final o f6168j;

    /* renamed from: k  reason: collision with root package name */
    private final t f6169k;
    private final long l;
    private final boolean m;
    private final v.a n;
    private final v.a<? extends com.google.android.exoplayer2.source.dash.k.b> o;
    private final f p;
    private final Object q;
    private final SparseArray<d> r;
    private final Runnable s;
    private final Runnable t;
    private final j.b u;
    private final u v;
    private final Object w;
    private com.google.android.exoplayer2.upstream.i x;
    private Loader y;
    private x z;

    /* access modifiers changed from: private */
    /* compiled from: DashMediaSource */
    public static final class b extends b0 {

        /* renamed from: b  reason: collision with root package name */
        private final long f6170b;

        /* renamed from: c  reason: collision with root package name */
        private final long f6171c;

        /* renamed from: d  reason: collision with root package name */
        private final int f6172d;

        /* renamed from: e  reason: collision with root package name */
        private final long f6173e;

        /* renamed from: f  reason: collision with root package name */
        private final long f6174f;

        /* renamed from: g  reason: collision with root package name */
        private final long f6175g;

        /* renamed from: h  reason: collision with root package name */
        private final com.google.android.exoplayer2.source.dash.k.b f6176h;

        /* renamed from: i  reason: collision with root package name */
        private final Object f6177i;

        public b(long j2, long j3, int i2, long j4, long j5, long j6, com.google.android.exoplayer2.source.dash.k.b bVar, Object obj) {
            this.f6170b = j2;
            this.f6171c = j3;
            this.f6172d = i2;
            this.f6173e = j4;
            this.f6174f = j5;
            this.f6175g = j6;
            this.f6176h = bVar;
            this.f6177i = obj;
        }

        private long t(long j2) {
            f i2;
            long j3 = this.f6175g;
            com.google.android.exoplayer2.source.dash.k.b bVar = this.f6176h;
            if (!bVar.f6246d) {
                return j3;
            }
            if (j2 > 0) {
                j3 += j2;
                if (j3 > this.f6174f) {
                    return -9223372036854775807L;
                }
            }
            long j4 = this.f6173e + j3;
            long g2 = bVar.g(0);
            int i3 = 0;
            while (i3 < this.f6176h.e() - 1 && j4 >= g2) {
                j4 -= g2;
                i3++;
                g2 = this.f6176h.g(i3);
            }
            com.google.android.exoplayer2.source.dash.k.f d2 = this.f6176h.d(i3);
            int a2 = d2.a(2);
            return (a2 == -1 || (i2 = d2.f6276c.get(a2).f6240c.get(0).i()) == null || i2.g(g2) == 0) ? j3 : (j3 + i2.b(i2.a(j4, g2))) - j4;
        }

        @Override // com.google.android.exoplayer2.b0
        public int b(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f6172d) >= 0 && intValue < i()) {
                return intValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.b0
        public b0.b g(int i2, b0.b bVar, boolean z) {
            com.google.android.exoplayer2.util.e.c(i2, 0, i());
            Integer num = null;
            String str = z ? this.f6176h.d(i2).f6274a : null;
            if (z) {
                num = Integer.valueOf(this.f6172d + i2);
            }
            bVar.n(str, num, 0, this.f6176h.g(i2), com.google.android.exoplayer2.d.a(this.f6176h.d(i2).f6275b - this.f6176h.d(0).f6275b) - this.f6173e);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.b0
        public int i() {
            return this.f6176h.e();
        }

        @Override // com.google.android.exoplayer2.b0
        public Object m(int i2) {
            com.google.android.exoplayer2.util.e.c(i2, 0, i());
            return Integer.valueOf(this.f6172d + i2);
        }

        @Override // com.google.android.exoplayer2.b0
        public b0.c p(int i2, b0.c cVar, boolean z, long j2) {
            com.google.android.exoplayer2.util.e.c(i2, 0, 1);
            cVar.e(z ? this.f6177i : null, this.f6170b, this.f6171c, true, this.f6176h.f6246d, t(j2), this.f6174f, 0, i() - 1, this.f6173e);
            return cVar;
        }

        @Override // com.google.android.exoplayer2.b0
        public int q() {
            return 1;
        }
    }

    /* compiled from: DashMediaSource */
    private final class c implements j.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.source.dash.j.b
        public void a() {
            e.this.A();
        }

        @Override // com.google.android.exoplayer2.source.dash.j.b
        public void b(long j2) {
            e.this.z(j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.j.b
        public void c() {
            e.this.y();
        }
    }

    /* compiled from: DashMediaSource */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final c.a f6179a;

        /* renamed from: b  reason: collision with root package name */
        private final i.a f6180b;

        /* renamed from: c  reason: collision with root package name */
        private v.a<? extends com.google.android.exoplayer2.source.dash.k.b> f6181c;

        /* renamed from: d  reason: collision with root package name */
        private o f6182d = new p();

        /* renamed from: e  reason: collision with root package name */
        private t f6183e = new r();

        /* renamed from: f  reason: collision with root package name */
        private long f6184f = 30000;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6185g;

        /* renamed from: h  reason: collision with root package name */
        private Object f6186h;

        public d(c.a aVar, i.a aVar2) {
            com.google.android.exoplayer2.util.e.e(aVar);
            this.f6179a = aVar;
            this.f6180b = aVar2;
        }

        public e a(Uri uri) {
            if (this.f6181c == null) {
                this.f6181c = new com.google.android.exoplayer2.source.dash.k.c();
            }
            com.google.android.exoplayer2.util.e.e(uri);
            return new e(null, uri, this.f6180b, this.f6181c, this.f6179a, this.f6182d, this.f6183e, this.f6184f, this.f6185g, this.f6186h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.source.dash.e$e  reason: collision with other inner class name */
    /* compiled from: DashMediaSource */
    public static final class C0132e implements v.a<Long> {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f6187a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        C0132e() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8"))).readLine();
            try {
                Matcher matcher = f6187a.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(group).getTime();
                    if (!"Z".equals(matcher.group(2))) {
                        long j2 = "+".equals(matcher.group(4)) ? 1 : -1;
                        long parseLong = Long.parseLong(matcher.group(5));
                        String group2 = matcher.group(7);
                        time -= j2 * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60) * 1000);
                    }
                    return Long.valueOf(time);
                }
                throw new ParserException("Couldn't parse timestamp: " + readLine);
            } catch (ParseException e2) {
                throw new ParserException(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DashMediaSource */
    public final class f implements Loader.b<com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.dash.k.b>> {
        private f() {
        }

        /* renamed from: a */
        public void k(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.dash.k.b> vVar, long j2, long j3, boolean z) {
            e.this.B(vVar, j2, j3);
        }

        /* renamed from: b */
        public void q(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.dash.k.b> vVar, long j2, long j3) {
            e.this.C(vVar, j2, j3);
        }

        /* renamed from: c */
        public Loader.c p(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.dash.k.b> vVar, long j2, long j3, IOException iOException, int i2) {
            return e.this.D(vVar, j2, j3, iOException);
        }
    }

    /* compiled from: DashMediaSource */
    final class g implements u {
        g() {
        }

        private void b() {
            if (e.this.A != null) {
                throw e.this.A;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.u
        public void a() {
            e.this.y.a();
            b();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DashMediaSource */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6190a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6191b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6192c;

        private h(boolean z, long j2, long j3) {
            this.f6190a = z;
            this.f6191b = j2;
            this.f6192c = j3;
        }

        public static h a(com.google.android.exoplayer2.source.dash.k.f fVar, long j2) {
            boolean z;
            boolean z2;
            long j3;
            int size = fVar.f6276c.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                }
                int i4 = fVar.f6276c.get(i3).f6239b;
                if (i4 == 1 || i4 == 2) {
                    z = true;
                } else {
                    i3++;
                }
            }
            long j4 = Long.MAX_VALUE;
            int i5 = 0;
            boolean z3 = false;
            long j5 = 0;
            boolean z4 = false;
            while (i5 < size) {
                com.google.android.exoplayer2.source.dash.k.a aVar = fVar.f6276c.get(i5);
                if (!z || aVar.f6239b != 3) {
                    f i6 = aVar.f6240c.get(i2).i();
                    if (i6 == null) {
                        return new h(true, 0, j2);
                    }
                    z3 |= i6.e();
                    int g2 = i6.g(j2);
                    if (g2 == 0) {
                        z2 = z;
                        j3 = 0;
                        j5 = 0;
                        z4 = true;
                    } else if (!z4) {
                        z2 = z;
                        long f2 = i6.f();
                        j5 = Math.max(j5, i6.b(f2));
                        if (g2 != -1) {
                            long j6 = (f2 + ((long) g2)) - 1;
                            j3 = Math.min(j4, i6.b(j6) + i6.c(j6, j2));
                        } else {
                            j3 = j4;
                        }
                    }
                    i5++;
                    j4 = j3;
                    z = z2;
                    i2 = 0;
                }
                z2 = z;
                j3 = j4;
                i5++;
                j4 = j3;
                z = z2;
                i2 = 0;
            }
            return new h(z3, j5, j4);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DashMediaSource */
    public final class i implements Loader.b<com.google.android.exoplayer2.upstream.v<Long>> {
        private i() {
        }

        /* renamed from: a */
        public void k(com.google.android.exoplayer2.upstream.v<Long> vVar, long j2, long j3, boolean z) {
            e.this.B(vVar, j2, j3);
        }

        /* renamed from: b */
        public void q(com.google.android.exoplayer2.upstream.v<Long> vVar, long j2, long j3) {
            e.this.E(vVar, j2, j3);
        }

        /* renamed from: c */
        public Loader.c p(com.google.android.exoplayer2.upstream.v<Long> vVar, long j2, long j3, IOException iOException, int i2) {
            return e.this.F(vVar, j2, j3, iOException);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DashMediaSource */
    public static final class j implements v.a<Long> {
        private j() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) {
            return Long.valueOf(d0.U(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        k.a("goog.exo.dash");
    }

    private void G(IOException iOException) {
        m.d("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        I(true);
    }

    private void H(long j2) {
        this.I = j2;
        I(true);
    }

    private void I(boolean z2) {
        long j2;
        boolean z3;
        long j3;
        long j4;
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            int keyAt = this.r.keyAt(i2);
            if (keyAt >= this.M) {
                this.r.valueAt(i2).I(this.E, keyAt - this.M);
            }
        }
        int e2 = this.E.e() - 1;
        h a2 = h.a(this.E.d(0), this.E.g(0));
        h a3 = h.a(this.E.d(e2), this.E.g(e2));
        long j5 = a2.f6191b;
        long j6 = a3.f6192c;
        if (!this.E.f6246d || a3.f6190a) {
            j2 = j5;
            z3 = false;
        } else {
            j6 = Math.min((u() - com.google.android.exoplayer2.d.a(this.E.f6243a)) - com.google.android.exoplayer2.d.a(this.E.d(e2).f6275b), j6);
            long j7 = this.E.f6248f;
            if (j7 != -9223372036854775807L) {
                long a4 = j6 - com.google.android.exoplayer2.d.a(j7);
                while (a4 < 0 && e2 > 0) {
                    e2--;
                    a4 += this.E.g(e2);
                }
                if (e2 == 0) {
                    j4 = Math.max(j5, a4);
                } else {
                    j4 = this.E.g(0);
                }
                j5 = j4;
            }
            j2 = j5;
            z3 = true;
        }
        long j8 = j6 - j2;
        for (int i3 = 0; i3 < this.E.e() - 1; i3++) {
            j8 += this.E.g(i3);
        }
        com.google.android.exoplayer2.source.dash.k.b bVar = this.E;
        if (bVar.f6246d) {
            long j9 = this.l;
            if (!this.m) {
                long j10 = bVar.f6249g;
                if (j10 != -9223372036854775807L) {
                    j9 = j10;
                }
            }
            long a5 = j8 - com.google.android.exoplayer2.d.a(j9);
            if (a5 < 5000000) {
                a5 = Math.min(5000000L, j8 / 2);
            }
            j3 = a5;
        } else {
            j3 = 0;
        }
        com.google.android.exoplayer2.source.dash.k.b bVar2 = this.E;
        long b2 = bVar2.f6243a + bVar2.d(0).f6275b + com.google.android.exoplayer2.d.b(j2);
        com.google.android.exoplayer2.source.dash.k.b bVar3 = this.E;
        n(new b(bVar3.f6243a, b2, this.M, j2, j8, j3, bVar3, this.w), bVar3);
        if (!this.f6165g) {
            this.B.removeCallbacks(this.t);
            long j11 = 5000;
            if (z3) {
                this.B.postDelayed(this.t, 5000);
            }
            if (this.F) {
                O();
            } else if (z2) {
                com.google.android.exoplayer2.source.dash.k.b bVar4 = this.E;
                if (bVar4.f6246d) {
                    long j12 = bVar4.f6247e;
                    if (j12 != -9223372036854775807L) {
                        if (j12 != 0) {
                            j11 = j12;
                        }
                        M(Math.max(0L, (this.G + j11) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    private void J(com.google.android.exoplayer2.source.dash.k.m mVar) {
        String str = mVar.f6314a;
        if (d0.b(str, "urn:mpeg:dash:utc:direct:2014") || d0.b(str, "urn:mpeg:dash:utc:direct:2012")) {
            K(mVar);
        } else if (d0.b(str, "urn:mpeg:dash:utc:http-iso:2014") || d0.b(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            L(mVar, new C0132e());
        } else if (d0.b(str, "urn:mpeg:dash:utc:http-xsdate:2014") || d0.b(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            L(mVar, new j());
        } else {
            G(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void K(com.google.android.exoplayer2.source.dash.k.m mVar) {
        try {
            H(d0.U(mVar.f6315b) - this.H);
        } catch (ParserException e2) {
            G(e2);
        }
    }

    private void L(com.google.android.exoplayer2.source.dash.k.m mVar, v.a<Long> aVar) {
        N(new com.google.android.exoplayer2.upstream.v(this.x, Uri.parse(mVar.f6315b), 5, aVar), new i(), 1);
    }

    private void M(long j2) {
        this.B.postDelayed(this.s, j2);
    }

    private <T> void N(com.google.android.exoplayer2.upstream.v<T> vVar, Loader.b<com.google.android.exoplayer2.upstream.v<T>> bVar, int i2) {
        this.n.H(vVar.f6981a, vVar.f6982b, this.y.l(vVar, bVar, i2));
    }

    /* access modifiers changed from: private */
    public void O() {
        Uri uri;
        this.B.removeCallbacks(this.s);
        if (this.y.h()) {
            this.F = true;
            return;
        }
        synchronized (this.q) {
            uri = this.D;
        }
        this.F = false;
        N(new com.google.android.exoplayer2.upstream.v(this.x, uri, 4, this.o), this.p, this.f6169k.b(4));
    }

    private long t() {
        return (long) Math.min((this.J - 1) * 1000, 5000);
    }

    private long u() {
        if (this.I != 0) {
            return com.google.android.exoplayer2.d.a(SystemClock.elapsedRealtime() + this.I);
        }
        return com.google.android.exoplayer2.d.a(System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x() {
        I(false);
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.B.removeCallbacks(this.t);
        O();
    }

    /* access modifiers changed from: package-private */
    public void B(com.google.android.exoplayer2.upstream.v<?> vVar, long j2, long j3) {
        this.n.y(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.dash.k.b> r18, long r19, long r21) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.e.C(com.google.android.exoplayer2.upstream.v, long, long):void");
    }

    /* access modifiers changed from: package-private */
    public Loader.c D(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.dash.k.b> vVar, long j2, long j3, IOException iOException) {
        boolean z2 = iOException instanceof ParserException;
        this.n.E(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c(), iOException, z2);
        return z2 ? Loader.f6880f : Loader.f6878d;
    }

    /* access modifiers changed from: package-private */
    public void E(com.google.android.exoplayer2.upstream.v<Long> vVar, long j2, long j3) {
        this.n.B(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c());
        H(vVar.e().longValue() - j2);
    }

    /* access modifiers changed from: package-private */
    public Loader.c F(com.google.android.exoplayer2.upstream.v<Long> vVar, long j2, long j3, IOException iOException) {
        this.n.E(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c(), iOException, true);
        G(iOException);
        return Loader.f6879e;
    }

    @Override // com.google.android.exoplayer2.source.u
    public com.google.android.exoplayer2.source.t a(u.a aVar, com.google.android.exoplayer2.upstream.d dVar) {
        int intValue = ((Integer) aVar.f6613a).intValue() - this.M;
        d dVar2 = new d(this.M + intValue, this.E, intValue, this.f6167i, this.z, this.f6169k, l(aVar, this.E.d(intValue).f6275b), this.I, this.v, dVar, this.f6168j, this.u);
        this.r.put(dVar2.f6148b, dVar2);
        return dVar2;
    }

    @Override // com.google.android.exoplayer2.source.u
    public void b() {
        this.v.a();
    }

    @Override // com.google.android.exoplayer2.source.u
    public void c(com.google.android.exoplayer2.source.t tVar) {
        d dVar = (d) tVar;
        dVar.E();
        this.r.remove(dVar.f6148b);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void m(com.google.android.exoplayer2.g gVar, boolean z2, x xVar) {
        this.z = xVar;
        if (this.f6165g) {
            I(false);
            return;
        }
        this.x = this.f6166h.a();
        this.y = new Loader("Loader:DashMediaSource");
        this.B = new Handler();
        O();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void o() {
        this.F = false;
        this.x = null;
        Loader loader = this.y;
        if (loader != null) {
            loader.j();
            this.y = null;
        }
        this.G = 0;
        this.H = 0;
        this.E = this.f6165g ? this.E : null;
        this.D = this.C;
        this.A = null;
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.B = null;
        }
        this.I = 0;
        this.J = 0;
        this.K = -9223372036854775807L;
        this.L = false;
        this.M = 0;
        this.r.clear();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        this.L = true;
    }

    /* access modifiers changed from: package-private */
    public void z(long j2) {
        long j3 = this.K;
        if (j3 == -9223372036854775807L || j3 < j2) {
            this.K = j2;
        }
    }

    private e(com.google.android.exoplayer2.source.dash.k.b bVar, Uri uri, i.a aVar, v.a<? extends com.google.android.exoplayer2.source.dash.k.b> aVar2, c.a aVar3, o oVar, t tVar, long j2, boolean z2, Object obj) {
        this.C = uri;
        this.E = bVar;
        this.D = uri;
        this.f6166h = aVar;
        this.o = aVar2;
        this.f6167i = aVar3;
        this.f6169k = tVar;
        this.l = j2;
        this.m = z2;
        this.f6168j = oVar;
        this.w = obj;
        boolean z3 = bVar != null;
        this.f6165g = z3;
        this.n = j(null);
        this.q = new Object();
        this.r = new SparseArray<>();
        this.u = new c();
        this.K = -9223372036854775807L;
        if (z3) {
            com.google.android.exoplayer2.util.e.f(!bVar.f6246d);
            this.p = null;
            this.s = null;
            this.t = null;
            this.v = new u.a();
            return;
        }
        this.p = new f();
        this.v = new g();
        this.s = new a(this);
        this.t = new b(this);
    }
}
