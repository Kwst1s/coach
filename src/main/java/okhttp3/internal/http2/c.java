package okhttp3.internal.http2;

import com.github.mikephil.charting.BuildConfig;
import j.e;
import j.f;
import j.l;
import j.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* compiled from: Hpack */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final b[] f10890a;

    /* renamed from: b  reason: collision with root package name */
    static final Map<f, Integer> f10891b = b();

    /* compiled from: Hpack */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f10892a;

        /* renamed from: b  reason: collision with root package name */
        private final e f10893b;

        /* renamed from: c  reason: collision with root package name */
        private final int f10894c;

        /* renamed from: d  reason: collision with root package name */
        private int f10895d;

        /* renamed from: e  reason: collision with root package name */
        b[] f10896e;

        /* renamed from: f  reason: collision with root package name */
        int f10897f;

        /* renamed from: g  reason: collision with root package name */
        int f10898g;

        /* renamed from: h  reason: collision with root package name */
        int f10899h;

        a(int i2, t tVar) {
            this(i2, i2, tVar);
        }

        private void a() {
            int i2 = this.f10895d;
            int i3 = this.f10899h;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                d(i3 - i2);
            }
        }

        private void b() {
            Arrays.fill(this.f10896e, (Object) null);
            this.f10897f = this.f10896e.length - 1;
            this.f10898g = 0;
            this.f10899h = 0;
        }

        private int c(int i2) {
            return this.f10897f + 1 + i2;
        }

        private int d(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f10896e.length;
                while (true) {
                    length--;
                    i3 = this.f10897f;
                    if (length < i3 || i2 <= 0) {
                        b[] bVarArr = this.f10896e;
                        System.arraycopy(bVarArr, i3 + 1, bVarArr, i3 + 1 + i4, this.f10898g);
                        this.f10897f += i4;
                    } else {
                        b[] bVarArr2 = this.f10896e;
                        i2 -= bVarArr2[length].f10889c;
                        this.f10899h -= bVarArr2[length].f10889c;
                        this.f10898g--;
                        i4++;
                    }
                }
                b[] bVarArr3 = this.f10896e;
                System.arraycopy(bVarArr3, i3 + 1, bVarArr3, i3 + 1 + i4, this.f10898g);
                this.f10897f += i4;
            }
            return i4;
        }

        private f f(int i2) {
            if (h(i2)) {
                return c.f10890a[i2].f10887a;
            }
            int c2 = c(i2 - c.f10890a.length);
            if (c2 >= 0) {
                b[] bVarArr = this.f10896e;
                if (c2 < bVarArr.length) {
                    return bVarArr[c2].f10887a;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private void g(int i2, b bVar) {
            this.f10892a.add(bVar);
            int i3 = bVar.f10889c;
            if (i2 != -1) {
                i3 -= this.f10896e[c(i2)].f10889c;
            }
            int i4 = this.f10895d;
            if (i3 > i4) {
                b();
                return;
            }
            int d2 = d((this.f10899h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f10898g + 1;
                b[] bVarArr = this.f10896e;
                if (i5 > bVarArr.length) {
                    b[] bVarArr2 = new b[(bVarArr.length * 2)];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f10897f = this.f10896e.length - 1;
                    this.f10896e = bVarArr2;
                }
                int i6 = this.f10897f;
                this.f10897f = i6 - 1;
                this.f10896e[i6] = bVar;
                this.f10898g++;
            } else {
                this.f10896e[i2 + c(i2) + d2] = bVar;
            }
            this.f10899h += i3;
        }

        private boolean h(int i2) {
            return i2 >= 0 && i2 <= c.f10890a.length - 1;
        }

        private int i() {
            return this.f10893b.readByte() & 255;
        }

        private void l(int i2) {
            if (h(i2)) {
                this.f10892a.add(c.f10890a[i2]);
                return;
            }
            int c2 = c(i2 - c.f10890a.length);
            if (c2 >= 0) {
                b[] bVarArr = this.f10896e;
                if (c2 < bVarArr.length) {
                    this.f10892a.add(bVarArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private void n(int i2) {
            g(-1, new b(f(i2), j()));
        }

        private void o() {
            f j2 = j();
            c.a(j2);
            g(-1, new b(j2, j()));
        }

        private void p(int i2) {
            this.f10892a.add(new b(f(i2), j()));
        }

        private void q() {
            f j2 = j();
            c.a(j2);
            this.f10892a.add(new b(j2, j()));
        }

        public List<b> e() {
            ArrayList arrayList = new ArrayList(this.f10892a);
            this.f10892a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public f j() {
            int i2 = i();
            boolean z = (i2 & 128) == 128;
            int m = m(i2, 127);
            if (z) {
                return f.m(j.f().c(this.f10893b.q((long) m)));
            }
            return this.f10893b.g((long) m);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            while (!this.f10893b.o()) {
                int readByte = this.f10893b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = m(readByte, 31);
                    this.f10895d = m;
                    if (m < 0 || m > this.f10894c) {
                        throw new IOException("Invalid dynamic table size update " + this.f10895d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    q();
                } else {
                    p(m(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i2, int i3) {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int i6 = i();
                if ((i6 & 128) == 0) {
                    return i3 + (i6 << i5);
                }
                i3 += (i6 & 127) << i5;
                i5 += 7;
            }
        }

        a(int i2, int i3, t tVar) {
            this.f10892a = new ArrayList();
            b[] bVarArr = new b[8];
            this.f10896e = bVarArr;
            this.f10897f = bVarArr.length - 1;
            this.f10898g = 0;
            this.f10899h = 0;
            this.f10894c = i2;
            this.f10895d = i3;
            this.f10893b = l.d(tVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Hpack */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final j.c f10900a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10901b;

        /* renamed from: c  reason: collision with root package name */
        private int f10902c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f10903d;

        /* renamed from: e  reason: collision with root package name */
        int f10904e;

        /* renamed from: f  reason: collision with root package name */
        b[] f10905f;

        /* renamed from: g  reason: collision with root package name */
        int f10906g;

        /* renamed from: h  reason: collision with root package name */
        int f10907h;

        /* renamed from: i  reason: collision with root package name */
        int f10908i;

        b(j.c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            int i2 = this.f10904e;
            int i3 = this.f10908i;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                c(i3 - i2);
            }
        }

        private void b() {
            Arrays.fill(this.f10905f, (Object) null);
            this.f10906g = this.f10905f.length - 1;
            this.f10907h = 0;
            this.f10908i = 0;
        }

        private int c(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f10905f.length;
                while (true) {
                    length--;
                    i3 = this.f10906g;
                    if (length < i3 || i2 <= 0) {
                        b[] bVarArr = this.f10905f;
                        System.arraycopy(bVarArr, i3 + 1, bVarArr, i3 + 1 + i4, this.f10907h);
                        b[] bVarArr2 = this.f10905f;
                        int i5 = this.f10906g;
                        Arrays.fill(bVarArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.f10906g += i4;
                    } else {
                        b[] bVarArr3 = this.f10905f;
                        i2 -= bVarArr3[length].f10889c;
                        this.f10908i -= bVarArr3[length].f10889c;
                        this.f10907h--;
                        i4++;
                    }
                }
                b[] bVarArr4 = this.f10905f;
                System.arraycopy(bVarArr4, i3 + 1, bVarArr4, i3 + 1 + i4, this.f10907h);
                b[] bVarArr22 = this.f10905f;
                int i52 = this.f10906g;
                Arrays.fill(bVarArr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.f10906g += i4;
            }
            return i4;
        }

        private void d(b bVar) {
            int i2 = bVar.f10889c;
            int i3 = this.f10904e;
            if (i2 > i3) {
                b();
                return;
            }
            c((this.f10908i + i2) - i3);
            int i4 = this.f10907h + 1;
            b[] bVarArr = this.f10905f;
            if (i4 > bVarArr.length) {
                b[] bVarArr2 = new b[(bVarArr.length * 2)];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.f10906g = this.f10905f.length - 1;
                this.f10905f = bVarArr2;
            }
            int i5 = this.f10906g;
            this.f10906g = i5 - 1;
            this.f10905f[i5] = bVar;
            this.f10907h++;
            this.f10908i += i2;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.f10904e;
            if (i3 != min) {
                if (min < i3) {
                    this.f10902c = Math.min(this.f10902c, min);
                }
                this.f10903d = true;
                this.f10904e = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(f fVar) {
            if (!this.f10901b || j.f().e(fVar) >= fVar.r()) {
                h(fVar.r(), 127, 0);
                this.f10900a.W(fVar);
                return;
            }
            j.c cVar = new j.c();
            j.f().d(fVar, cVar);
            f N = cVar.N();
            h(N.r(), 127, 128);
            this.f10900a.W(N);
        }

        /* access modifiers changed from: package-private */
        public void g(List<b> list) {
            int i2;
            int i3;
            if (this.f10903d) {
                int i4 = this.f10902c;
                if (i4 < this.f10904e) {
                    h(i4, 31, 32);
                }
                this.f10903d = false;
                this.f10902c = Integer.MAX_VALUE;
                h(this.f10904e, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                b bVar = list.get(i5);
                f u = bVar.f10887a.u();
                f fVar = bVar.f10888b;
                Integer num = c.f10891b.get(u);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        b[] bVarArr = c.f10890a;
                        if (Objects.equals(bVarArr[i3 - 1].f10888b, fVar)) {
                            i2 = i3;
                        } else if (Objects.equals(bVarArr[i3].f10888b, fVar)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.f10906g + 1;
                    int length = this.f10905f.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Objects.equals(this.f10905f[i6].f10887a, u)) {
                            if (Objects.equals(this.f10905f[i6].f10888b, fVar)) {
                                i3 = c.f10890a.length + (i6 - this.f10906g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.f10906g) + c.f10890a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    h(i3, 127, 128);
                } else if (i2 == -1) {
                    this.f10900a.a0(64);
                    f(u);
                    f(fVar);
                    d(bVar);
                } else if (!u.s(b.f10881d) || b.f10886i.equals(u)) {
                    h(i2, 63, 64);
                    f(fVar);
                    d(bVar);
                } else {
                    h(i2, 15, 0);
                    f(fVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f10900a.a0(i2 | i4);
                return;
            }
            this.f10900a.a0(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f10900a.a0(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f10900a.a0(i5);
        }

        b(int i2, boolean z, j.c cVar) {
            this.f10902c = Integer.MAX_VALUE;
            b[] bVarArr = new b[8];
            this.f10905f = bVarArr;
            this.f10906g = bVarArr.length - 1;
            this.f10907h = 0;
            this.f10908i = 0;
            this.f10904e = i2;
            this.f10901b = z;
            this.f10900a = cVar;
        }
    }

    static {
        f fVar = b.f10883f;
        f fVar2 = b.f10884g;
        f fVar3 = b.f10885h;
        f fVar4 = b.f10882e;
        f10890a = new b[]{new b(b.f10886i, BuildConfig.FLAVOR), new b(fVar, "GET"), new b(fVar, "POST"), new b(fVar2, "/"), new b(fVar2, "/index.html"), new b(fVar3, "http"), new b(fVar3, "https"), new b(fVar4, "200"), new b(fVar4, "204"), new b(fVar4, "206"), new b(fVar4, "304"), new b(fVar4, "400"), new b(fVar4, "404"), new b(fVar4, "500"), new b("accept-charset", BuildConfig.FLAVOR), new b("accept-encoding", "gzip, deflate"), new b("accept-language", BuildConfig.FLAVOR), new b("accept-ranges", BuildConfig.FLAVOR), new b("accept", BuildConfig.FLAVOR), new b("access-control-allow-origin", BuildConfig.FLAVOR), new b("age", BuildConfig.FLAVOR), new b("allow", BuildConfig.FLAVOR), new b("authorization", BuildConfig.FLAVOR), new b("cache-control", BuildConfig.FLAVOR), new b("content-disposition", BuildConfig.FLAVOR), new b("content-encoding", BuildConfig.FLAVOR), new b("content-language", BuildConfig.FLAVOR), new b("content-length", BuildConfig.FLAVOR), new b("content-location", BuildConfig.FLAVOR), new b("content-range", BuildConfig.FLAVOR), new b("content-type", BuildConfig.FLAVOR), new b("cookie", BuildConfig.FLAVOR), new b("date", BuildConfig.FLAVOR), new b("etag", BuildConfig.FLAVOR), new b("expect", BuildConfig.FLAVOR), new b("expires", BuildConfig.FLAVOR), new b("from", BuildConfig.FLAVOR), new b("host", BuildConfig.FLAVOR), new b("if-match", BuildConfig.FLAVOR), new b("if-modified-since", BuildConfig.FLAVOR), new b("if-none-match", BuildConfig.FLAVOR), new b("if-range", BuildConfig.FLAVOR), new b("if-unmodified-since", BuildConfig.FLAVOR), new b("last-modified", BuildConfig.FLAVOR), new b("link", BuildConfig.FLAVOR), new b("location", BuildConfig.FLAVOR), new b("max-forwards", BuildConfig.FLAVOR), new b("proxy-authenticate", BuildConfig.FLAVOR), new b("proxy-authorization", BuildConfig.FLAVOR), new b("range", BuildConfig.FLAVOR), new b("referer", BuildConfig.FLAVOR), new b("refresh", BuildConfig.FLAVOR), new b("retry-after", BuildConfig.FLAVOR), new b("server", BuildConfig.FLAVOR), new b("set-cookie", BuildConfig.FLAVOR), new b("strict-transport-security", BuildConfig.FLAVOR), new b("transfer-encoding", BuildConfig.FLAVOR), new b("user-agent", BuildConfig.FLAVOR), new b("vary", BuildConfig.FLAVOR), new b("via", BuildConfig.FLAVOR), new b("www-authenticate", BuildConfig.FLAVOR)};
    }

    static f a(f fVar) {
        int r = fVar.r();
        for (int i2 = 0; i2 < r; i2++) {
            byte j2 = fVar.j(i2);
            if (j2 >= 65 && j2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.w());
            }
        }
        return fVar;
    }

    private static Map<f, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f10890a.length);
        int i2 = 0;
        while (true) {
            b[] bVarArr = f10890a;
            if (i2 >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i2].f10887a)) {
                linkedHashMap.put(bVarArr[i2].f10887a, Integer.valueOf(i2));
            }
            i2++;
        }
    }
}
