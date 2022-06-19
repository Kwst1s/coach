package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.f;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DefaultBandwidthMeter */
public final class m implements e, x {

    /* renamed from: j  reason: collision with root package name */
    public static final Map<String, int[]> f6938j = h();

    /* renamed from: k  reason: collision with root package name */
    public static final long[] f6939k = {5700000, 3400000, 1900000, 1000000, 400000};
    public static final long[] l = {169000, 129000, 114000, 102000, 87000};
    public static final long[] m = {2100000, 1300000, 950000, 700000, 400000};
    public static final long[] n = {6900000, 4300000, 2700000, 1600000, 450000};

    /* renamed from: a  reason: collision with root package name */
    private final j<e.a> f6940a;

    /* renamed from: b  reason: collision with root package name */
    private final v f6941b;

    /* renamed from: c  reason: collision with root package name */
    private final f f6942c;

    /* renamed from: d  reason: collision with root package name */
    private int f6943d;

    /* renamed from: e  reason: collision with root package name */
    private long f6944e;

    /* renamed from: f  reason: collision with root package name */
    private long f6945f;

    /* renamed from: g  reason: collision with root package name */
    private long f6946g;

    /* renamed from: h  reason: collision with root package name */
    private long f6947h;

    /* renamed from: i  reason: collision with root package name */
    private long f6948i;

    /* compiled from: DefaultBandwidthMeter */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6949a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f6950b;

        /* renamed from: c  reason: collision with root package name */
        private e.a f6951c;

        /* renamed from: d  reason: collision with root package name */
        private SparseArray<Long> f6952d;

        /* renamed from: e  reason: collision with root package name */
        private int f6953e;

        /* renamed from: f  reason: collision with root package name */
        private f f6954f;

        @Deprecated
        public b() {
            this(null);
        }

        private static int[] b(String str) {
            int[] iArr = m.f6938j.get(str);
            if (iArr == null) {
                return new int[]{2, 2, 2, 2};
            }
            return iArr;
        }

        private static SparseArray<Long> c(String str) {
            int[] b2 = b(str);
            SparseArray<Long> sparseArray = new SparseArray<>(6);
            sparseArray.append(0, 1000000L);
            long[] jArr = m.f6939k;
            sparseArray.append(2, Long.valueOf(jArr[b2[0]]));
            sparseArray.append(3, Long.valueOf(m.l[b2[1]]));
            sparseArray.append(4, Long.valueOf(m.m[b2[2]]));
            sparseArray.append(5, Long.valueOf(m.n[b2[3]]));
            sparseArray.append(7, Long.valueOf(jArr[b2[0]]));
            return sparseArray;
        }

        public m a() {
            e.a aVar;
            Long l = this.f6952d.get(d0.F(this.f6949a));
            if (l == null) {
                l = this.f6952d.get(0);
            }
            m mVar = new m(l.longValue(), this.f6953e, this.f6954f);
            Handler handler = this.f6950b;
            if (!(handler == null || (aVar = this.f6951c) == null)) {
                mVar.g(handler, aVar);
            }
            return mVar;
        }

        public b(Context context) {
            Context context2;
            if (context == null) {
                context2 = null;
            } else {
                context2 = context.getApplicationContext();
            }
            this.f6949a = context2;
            this.f6952d = c(d0.z(context));
            this.f6953e = 2000;
            this.f6954f = f.f7015a;
        }
    }

    private static Map<String, int[]> h() {
        HashMap hashMap = new HashMap();
        hashMap.put("AD", new int[]{1, 0, 0, 0});
        hashMap.put("AE", new int[]{1, 3, 4, 4});
        hashMap.put("AF", new int[]{4, 4, 3, 2});
        hashMap.put("AG", new int[]{3, 2, 1, 2});
        hashMap.put("AI", new int[]{1, 0, 0, 2});
        hashMap.put("AL", new int[]{1, 1, 1, 1});
        hashMap.put("AM", new int[]{2, 2, 4, 3});
        hashMap.put("AO", new int[]{2, 4, 2, 0});
        hashMap.put("AR", new int[]{2, 3, 2, 3});
        hashMap.put("AS", new int[]{3, 4, 4, 1});
        hashMap.put("AT", new int[]{0, 1, 0, 0});
        hashMap.put("AU", new int[]{0, 3, 0, 0});
        hashMap.put("AW", new int[]{1, 1, 0, 4});
        hashMap.put("AX", new int[]{0, 1, 0, 0});
        hashMap.put("AZ", new int[]{3, 3, 2, 2});
        hashMap.put("BA", new int[]{1, 1, 1, 2});
        hashMap.put("BB", new int[]{0, 1, 0, 0});
        hashMap.put("BD", new int[]{2, 1, 3, 2});
        hashMap.put("BE", new int[]{0, 0, 0, 0});
        hashMap.put("BF", new int[]{4, 4, 4, 1});
        hashMap.put("BG", new int[]{0, 0, 0, 1});
        hashMap.put("BH", new int[]{2, 1, 3, 4});
        hashMap.put("BI", new int[]{4, 3, 4, 4});
        hashMap.put("BJ", new int[]{4, 3, 4, 3});
        hashMap.put("BL", new int[]{1, 0, 1, 2});
        hashMap.put("BM", new int[]{1, 0, 0, 0});
        hashMap.put("BN", new int[]{4, 3, 3, 3});
        hashMap.put("BO", new int[]{2, 2, 1, 2});
        hashMap.put("BQ", new int[]{1, 1, 2, 4});
        hashMap.put("BR", new int[]{2, 3, 2, 2});
        hashMap.put("BS", new int[]{1, 1, 0, 2});
        hashMap.put("BT", new int[]{3, 0, 2, 1});
        hashMap.put("BW", new int[]{4, 4, 2, 3});
        hashMap.put("BY", new int[]{1, 1, 1, 1});
        hashMap.put("BZ", new int[]{2, 3, 3, 1});
        hashMap.put("CA", new int[]{0, 2, 2, 3});
        hashMap.put("CD", new int[]{4, 4, 2, 1});
        hashMap.put("CF", new int[]{4, 4, 3, 3});
        hashMap.put("CG", new int[]{4, 4, 4, 4});
        hashMap.put("CH", new int[]{0, 0, 0, 0});
        hashMap.put("CI", new int[]{4, 4, 4, 4});
        hashMap.put("CK", new int[]{2, 4, 2, 0});
        hashMap.put("CL", new int[]{2, 2, 2, 3});
        hashMap.put("CM", new int[]{3, 4, 3, 1});
        hashMap.put("CN", new int[]{2, 0, 1, 2});
        hashMap.put("CO", new int[]{2, 3, 2, 1});
        hashMap.put("CR", new int[]{2, 2, 4, 4});
        hashMap.put("CU", new int[]{4, 4, 4, 1});
        hashMap.put("CV", new int[]{2, 2, 2, 4});
        hashMap.put("CW", new int[]{1, 1, 0, 0});
        hashMap.put("CX", new int[]{1, 2, 2, 2});
        hashMap.put("CY", new int[]{1, 1, 0, 0});
        hashMap.put("CZ", new int[]{0, 1, 0, 0});
        hashMap.put("DE", new int[]{0, 2, 2, 2});
        hashMap.put("DJ", new int[]{3, 4, 4, 0});
        hashMap.put("DK", new int[]{0, 0, 0, 0});
        hashMap.put("DM", new int[]{2, 0, 3, 4});
        hashMap.put("DO", new int[]{3, 3, 4, 4});
        hashMap.put("DZ", new int[]{3, 3, 4, 4});
        hashMap.put("EC", new int[]{2, 3, 3, 1});
        hashMap.put("EE", new int[]{0, 0, 0, 0});
        hashMap.put("EG", new int[]{3, 3, 1, 1});
        hashMap.put("EH", new int[]{2, 0, 2, 3});
        hashMap.put("ER", new int[]{4, 2, 2, 2});
        hashMap.put("ES", new int[]{0, 0, 1, 1});
        hashMap.put("ET", new int[]{4, 4, 4, 0});
        hashMap.put("FI", new int[]{0, 0, 1, 0});
        hashMap.put("FJ", new int[]{3, 2, 3, 3});
        hashMap.put("FK", new int[]{3, 4, 2, 1});
        hashMap.put("FM", new int[]{4, 2, 4, 0});
        hashMap.put("FO", new int[]{0, 0, 0, 1});
        hashMap.put("FR", new int[]{1, 0, 2, 1});
        hashMap.put("GA", new int[]{3, 3, 2, 1});
        hashMap.put("GB", new int[]{0, 1, 3, 2});
        hashMap.put("GD", new int[]{2, 0, 3, 0});
        hashMap.put("GE", new int[]{1, 1, 0, 3});
        hashMap.put("GF", new int[]{1, 2, 4, 4});
        hashMap.put("GG", new int[]{0, 1, 0, 0});
        hashMap.put("GH", new int[]{3, 2, 2, 2});
        hashMap.put("GI", new int[]{0, 0, 0, 1});
        hashMap.put("GL", new int[]{2, 4, 1, 4});
        hashMap.put("GM", new int[]{4, 3, 3, 0});
        hashMap.put("GN", new int[]{4, 4, 3, 4});
        hashMap.put("GP", new int[]{2, 2, 1, 3});
        hashMap.put("GQ", new int[]{4, 4, 3, 1});
        hashMap.put("GR", new int[]{1, 1, 0, 1});
        hashMap.put("GT", new int[]{3, 2, 3, 4});
        hashMap.put("GU", new int[]{1, 0, 4, 4});
        hashMap.put("GW", new int[]{4, 4, 4, 0});
        hashMap.put("GY", new int[]{3, 4, 1, 0});
        hashMap.put("HK", new int[]{0, 2, 3, 4});
        hashMap.put("HN", new int[]{3, 3, 2, 2});
        hashMap.put("HR", new int[]{1, 0, 0, 2});
        hashMap.put("HT", new int[]{3, 3, 3, 3});
        hashMap.put("HU", new int[]{0, 0, 1, 0});
        hashMap.put("ID", new int[]{2, 3, 3, 4});
        hashMap.put("IE", new int[]{0, 0, 1, 1});
        hashMap.put("IL", new int[]{0, 1, 1, 3});
        hashMap.put("IM", new int[]{0, 1, 0, 1});
        hashMap.put("IN", new int[]{2, 3, 3, 4});
        hashMap.put("IO", new int[]{4, 2, 2, 2});
        hashMap.put("IQ", new int[]{3, 3, 4, 3});
        hashMap.put("IR", new int[]{3, 2, 4, 4});
        hashMap.put("IS", new int[]{0, 0, 0, 0});
        hashMap.put("IT", new int[]{1, 0, 1, 3});
        hashMap.put("JE", new int[]{0, 0, 0, 1});
        hashMap.put("JM", new int[]{3, 3, 3, 2});
        hashMap.put("JO", new int[]{1, 1, 1, 2});
        hashMap.put("JP", new int[]{0, 1, 1, 2});
        hashMap.put("KE", new int[]{3, 3, 3, 3});
        hashMap.put("KG", new int[]{2, 2, 3, 3});
        hashMap.put("KH", new int[]{1, 0, 4, 4});
        hashMap.put("KI", new int[]{4, 4, 4, 4});
        hashMap.put("KM", new int[]{4, 4, 2, 2});
        hashMap.put("KN", new int[]{1, 0, 1, 3});
        hashMap.put("KP", new int[]{1, 2, 2, 2});
        hashMap.put("KR", new int[]{0, 4, 0, 2});
        hashMap.put("KW", new int[]{1, 2, 1, 2});
        hashMap.put("KY", new int[]{1, 1, 0, 2});
        hashMap.put("KZ", new int[]{1, 2, 2, 3});
        hashMap.put("LA", new int[]{3, 2, 2, 2});
        hashMap.put("LB", new int[]{3, 2, 0, 0});
        hashMap.put("LC", new int[]{2, 2, 1, 0});
        hashMap.put("LI", new int[]{0, 0, 1, 2});
        hashMap.put("LK", new int[]{1, 1, 2, 2});
        hashMap.put("LR", new int[]{3, 4, 3, 1});
        hashMap.put("LS", new int[]{3, 3, 2, 0});
        hashMap.put("LT", new int[]{0, 0, 0, 1});
        hashMap.put("LU", new int[]{0, 0, 1, 0});
        hashMap.put("LV", new int[]{0, 0, 0, 0});
        hashMap.put("LY", new int[]{4, 4, 4, 4});
        hashMap.put("MA", new int[]{2, 1, 2, 2});
        hashMap.put("MC", new int[]{1, 0, 1, 0});
        hashMap.put("MD", new int[]{1, 1, 0, 0});
        hashMap.put("ME", new int[]{1, 2, 2, 3});
        hashMap.put("MF", new int[]{1, 4, 3, 3});
        hashMap.put("MG", new int[]{3, 4, 1, 2});
        hashMap.put("MH", new int[]{4, 0, 2, 3});
        hashMap.put("MK", new int[]{1, 0, 0, 1});
        hashMap.put("ML", new int[]{4, 4, 4, 4});
        hashMap.put("MM", new int[]{2, 3, 1, 2});
        hashMap.put("MN", new int[]{2, 2, 2, 4});
        hashMap.put("MO", new int[]{0, 1, 4, 4});
        hashMap.put("MP", new int[]{0, 0, 4, 4});
        hashMap.put("MQ", new int[]{1, 1, 1, 3});
        hashMap.put("MR", new int[]{4, 2, 4, 2});
        hashMap.put("MS", new int[]{1, 2, 1, 2});
        hashMap.put("MT", new int[]{0, 0, 0, 0});
        hashMap.put("MU", new int[]{2, 2, 4, 4});
        hashMap.put("MV", new int[]{4, 2, 0, 1});
        hashMap.put("MW", new int[]{3, 2, 1, 1});
        hashMap.put("MX", new int[]{2, 4, 3, 1});
        hashMap.put("MY", new int[]{2, 3, 3, 3});
        hashMap.put("MZ", new int[]{3, 3, 2, 4});
        hashMap.put("NA", new int[]{4, 2, 1, 1});
        hashMap.put("NC", new int[]{2, 1, 3, 3});
        hashMap.put("NE", new int[]{4, 4, 4, 4});
        hashMap.put("NF", new int[]{0, 2, 2, 2});
        hashMap.put("NG", new int[]{3, 4, 2, 2});
        hashMap.put("NI", new int[]{3, 4, 3, 3});
        hashMap.put("NL", new int[]{0, 1, 3, 2});
        hashMap.put("NO", new int[]{0, 0, 1, 0});
        hashMap.put("NP", new int[]{2, 3, 2, 2});
        hashMap.put("NR", new int[]{4, 3, 4, 1});
        hashMap.put("NU", new int[]{4, 2, 2, 2});
        hashMap.put("NZ", new int[]{0, 0, 0, 1});
        hashMap.put("OM", new int[]{2, 2, 1, 3});
        hashMap.put("PA", new int[]{1, 3, 2, 3});
        hashMap.put("PE", new int[]{2, 2, 4, 4});
        hashMap.put("PF", new int[]{2, 2, 0, 1});
        hashMap.put("PG", new int[]{4, 4, 4, 4});
        hashMap.put("PH", new int[]{3, 0, 4, 4});
        hashMap.put("PK", new int[]{3, 3, 3, 3});
        hashMap.put("PL", new int[]{1, 0, 1, 3});
        hashMap.put("PM", new int[]{0, 2, 2, 3});
        hashMap.put("PR", new int[]{2, 3, 4, 3});
        hashMap.put("PS", new int[]{2, 3, 0, 4});
        hashMap.put("PT", new int[]{1, 1, 1, 1});
        hashMap.put("PW", new int[]{3, 2, 3, 0});
        hashMap.put("PY", new int[]{2, 1, 3, 3});
        hashMap.put("QA", new int[]{2, 3, 1, 2});
        hashMap.put("RE", new int[]{1, 1, 2, 2});
        hashMap.put("RO", new int[]{0, 1, 1, 3});
        hashMap.put("RS", new int[]{1, 1, 0, 0});
        hashMap.put("RU", new int[]{0, 1, 1, 1});
        hashMap.put("RW", new int[]{3, 4, 3, 1});
        hashMap.put("SA", new int[]{3, 2, 2, 3});
        hashMap.put("SB", new int[]{4, 4, 3, 0});
        hashMap.put("SC", new int[]{4, 2, 0, 1});
        hashMap.put("SD", new int[]{3, 4, 4, 4});
        hashMap.put("SE", new int[]{0, 0, 0, 0});
        hashMap.put("SG", new int[]{1, 2, 3, 3});
        hashMap.put("SH", new int[]{4, 2, 2, 2});
        hashMap.put("SI", new int[]{0, 1, 0, 0});
        hashMap.put("SJ", new int[]{3, 2, 0, 2});
        hashMap.put("SK", new int[]{0, 1, 0, 1});
        hashMap.put("SL", new int[]{4, 3, 2, 4});
        hashMap.put("SM", new int[]{1, 0, 1, 1});
        hashMap.put("SN", new int[]{4, 4, 4, 2});
        hashMap.put("SO", new int[]{4, 4, 4, 3});
        hashMap.put("SR", new int[]{3, 2, 2, 3});
        hashMap.put("SS", new int[]{4, 3, 4, 2});
        hashMap.put("ST", new int[]{3, 2, 2, 2});
        hashMap.put("SV", new int[]{2, 3, 2, 3});
        hashMap.put("SX", new int[]{2, 4, 2, 0});
        hashMap.put("SY", new int[]{4, 4, 2, 0});
        hashMap.put("SZ", new int[]{3, 4, 1, 1});
        hashMap.put("TC", new int[]{2, 1, 2, 1});
        hashMap.put("TD", new int[]{4, 4, 4, 3});
        hashMap.put("TG", new int[]{3, 2, 2, 0});
        hashMap.put("TH", new int[]{1, 3, 4, 4});
        hashMap.put("TJ", new int[]{4, 4, 4, 4});
        hashMap.put("TL", new int[]{4, 2, 4, 4});
        hashMap.put("TM", new int[]{4, 1, 3, 3});
        hashMap.put("TN", new int[]{2, 2, 1, 2});
        hashMap.put("TO", new int[]{2, 3, 3, 1});
        hashMap.put("TR", new int[]{1, 2, 0, 2});
        hashMap.put("TT", new int[]{2, 1, 1, 0});
        hashMap.put("TV", new int[]{4, 2, 2, 4});
        hashMap.put("TW", new int[]{0, 0, 0, 1});
        hashMap.put("TZ", new int[]{3, 3, 3, 2});
        hashMap.put("UA", new int[]{0, 2, 1, 3});
        hashMap.put("UG", new int[]{4, 3, 2, 2});
        hashMap.put("US", new int[]{0, 1, 3, 3});
        hashMap.put("UY", new int[]{2, 1, 2, 2});
        hashMap.put("UZ", new int[]{4, 3, 2, 4});
        hashMap.put("VA", new int[]{1, 2, 2, 2});
        hashMap.put("VC", new int[]{2, 0, 3, 2});
        hashMap.put("VE", new int[]{3, 4, 4, 3});
        hashMap.put("VG", new int[]{3, 1, 3, 4});
        hashMap.put("VI", new int[]{1, 0, 2, 4});
        hashMap.put("VN", new int[]{0, 2, 4, 4});
        hashMap.put("VU", new int[]{4, 1, 3, 2});
        hashMap.put("WS", new int[]{3, 2, 3, 0});
        hashMap.put("XK", new int[]{1, 2, 1, 0});
        hashMap.put("YE", new int[]{4, 4, 4, 2});
        hashMap.put("YT", new int[]{3, 1, 1, 2});
        hashMap.put("ZA", new int[]{2, 3, 1, 2});
        hashMap.put("ZM", new int[]{3, 3, 3, 1});
        hashMap.put("ZW", new int[]{3, 3, 2, 1});
        return Collections.unmodifiableMap(hashMap);
    }

    private void j(int i2, long j2, long j3) {
        this.f6940a.b(new a(i2, j2, j3));
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public x a() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized long b() {
        return this.f6948i;
    }

    @Override // com.google.android.exoplayer2.upstream.x
    public synchronized void c(i iVar, k kVar, boolean z) {
        if (z) {
            com.google.android.exoplayer2.util.e.f(this.f6943d > 0);
            long c2 = this.f6942c.c();
            int i2 = (int) (c2 - this.f6944e);
            long j2 = (long) i2;
            this.f6946g += j2;
            long j3 = this.f6947h;
            long j4 = this.f6945f;
            this.f6947h = j3 + j4;
            if (i2 > 0) {
                this.f6941b.a((int) Math.sqrt((double) j4), (float) ((8000 * j4) / j2));
                if (this.f6946g >= 2000 || this.f6947h >= 524288) {
                    this.f6948i = (long) this.f6941b.d(0.5f);
                }
            }
            j(i2, this.f6945f, this.f6948i);
            int i3 = this.f6943d - 1;
            this.f6943d = i3;
            if (i3 > 0) {
                this.f6944e = c2;
            }
            this.f6945f = 0;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.x
    public synchronized void d(i iVar, k kVar, boolean z, int i2) {
        if (z) {
            this.f6945f += (long) i2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.x
    public synchronized void e(i iVar, k kVar, boolean z) {
        if (z) {
            if (this.f6943d == 0) {
                this.f6944e = this.f6942c.c();
            }
            this.f6943d++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.x
    public void f(i iVar, k kVar, boolean z) {
    }

    public void g(Handler handler, e.a aVar) {
        this.f6940a.a(handler, aVar);
    }

    public m() {
        this(1000000, 2000, f.f7015a);
    }

    private m(long j2, int i2, f fVar) {
        this.f6940a = new j<>();
        this.f6941b = new v(i2);
        this.f6942c = fVar;
        this.f6948i = j2;
    }
}
