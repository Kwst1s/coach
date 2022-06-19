package j;

import com.github.mikephil.charting.BuildConfig;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Buffer */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f10661d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    p f10662b;

    /* renamed from: c  reason: collision with root package name */
    long f10663c;

    /* access modifiers changed from: package-private */
    /* compiled from: Buffer */
    public class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f10663c, 2147483647L);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f10663c > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            return c.this.M(bArr, i2, i3);
        }
    }

    @Override // j.e
    public long A(byte b2) {
        return K(b2, 0, Long.MAX_VALUE);
    }

    @Override // j.e
    public boolean B(long j2, f fVar) {
        return L(j2, fVar, 0, fVar.r());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r8 != r9) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r15.f10662b = r6.b();
        j.q.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        r6.f10697b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r1 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
    @Override // j.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long C() {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: j.c.C():long");
    }

    @Override // j.e
    public InputStream D() {
        return new a();
    }

    public final void E() {
        try {
            b(this.f10663c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: F */
    public c clone() {
        c cVar = new c();
        if (this.f10663c == 0) {
            return cVar;
        }
        p d2 = this.f10662b.d();
        cVar.f10662b = d2;
        d2.f10702g = d2;
        d2.f10701f = d2;
        p pVar = this.f10662b;
        while (true) {
            pVar = pVar.f10701f;
            if (pVar != this.f10662b) {
                cVar.f10662b.f10702g.c(pVar.d());
            } else {
                cVar.f10663c = this.f10663c;
                return cVar;
            }
        }
    }

    public final long G() {
        long j2 = this.f10663c;
        if (j2 == 0) {
            return 0;
        }
        p pVar = this.f10662b.f10702g;
        int i2 = pVar.f10698c;
        return (i2 >= 8192 || !pVar.f10700e) ? j2 : j2 - ((long) (i2 - pVar.f10697b));
    }

    public final c H(c cVar, long j2, long j3) {
        if (cVar != null) {
            v.b(this.f10663c, j2, j3);
            if (j3 == 0) {
                return this;
            }
            cVar.f10663c += j3;
            p pVar = this.f10662b;
            while (true) {
                int i2 = pVar.f10698c;
                int i3 = pVar.f10697b;
                if (j2 < ((long) (i2 - i3))) {
                    break;
                }
                j2 -= (long) (i2 - i3);
                pVar = pVar.f10701f;
            }
            while (j3 > 0) {
                p d2 = pVar.d();
                int i4 = (int) (((long) d2.f10697b) + j2);
                d2.f10697b = i4;
                d2.f10698c = Math.min(i4 + ((int) j3), d2.f10698c);
                p pVar2 = cVar.f10662b;
                if (pVar2 == null) {
                    d2.f10702g = d2;
                    d2.f10701f = d2;
                    cVar.f10662b = d2;
                } else {
                    pVar2.f10702g.c(d2);
                }
                j3 -= (long) (d2.f10698c - d2.f10697b);
                pVar = pVar.f10701f;
                j2 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c I() {
        return this;
    }

    public final byte J(long j2) {
        int i2;
        v.b(this.f10663c, j2, 1);
        long j3 = this.f10663c;
        if (j3 - j2 > j2) {
            p pVar = this.f10662b;
            while (true) {
                int i3 = pVar.f10698c;
                int i4 = pVar.f10697b;
                long j4 = (long) (i3 - i4);
                if (j2 < j4) {
                    return pVar.f10696a[i4 + ((int) j2)];
                }
                j2 -= j4;
                pVar = pVar.f10701f;
            }
        } else {
            long j5 = j2 - j3;
            p pVar2 = this.f10662b;
            do {
                pVar2 = pVar2.f10702g;
                int i5 = pVar2.f10698c;
                i2 = pVar2.f10697b;
                j5 += (long) (i5 - i2);
            } while (j5 < 0);
            return pVar2.f10696a[i2 + ((int) j5)];
        }
    }

    public long K(byte b2, long j2, long j3) {
        p pVar;
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f10663c), Long.valueOf(j2), Long.valueOf(j3)));
        }
        long j5 = this.f10663c;
        long j6 = j3 > j5 ? j5 : j3;
        if (j2 == j6 || (pVar = this.f10662b) == null) {
            return -1;
        }
        if (j5 - j2 < j2) {
            while (j5 > j2) {
                pVar = pVar.f10702g;
                j5 -= (long) (pVar.f10698c - pVar.f10697b);
            }
        } else {
            while (true) {
                long j7 = ((long) (pVar.f10698c - pVar.f10697b)) + j4;
                if (j7 >= j2) {
                    break;
                }
                pVar = pVar.f10701f;
                j4 = j7;
            }
            j5 = j4;
        }
        long j8 = j2;
        while (j5 < j6) {
            byte[] bArr = pVar.f10696a;
            int min = (int) Math.min((long) pVar.f10698c, (((long) pVar.f10697b) + j6) - j5);
            for (int i2 = (int) ((((long) pVar.f10697b) + j8) - j5); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - pVar.f10697b)) + j5;
                }
            }
            j5 += (long) (pVar.f10698c - pVar.f10697b);
            pVar = pVar.f10701f;
            j8 = j5;
        }
        return -1;
    }

    public boolean L(long j2, f fVar, int i2, int i3) {
        if (j2 < 0 || i2 < 0 || i3 < 0 || this.f10663c - j2 < ((long) i3) || fVar.r() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (J(((long) i4) + j2) != fVar.j(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public int M(byte[] bArr, int i2, int i3) {
        v.b((long) bArr.length, (long) i2, (long) i3);
        p pVar = this.f10662b;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(i3, pVar.f10698c - pVar.f10697b);
        System.arraycopy(pVar.f10696a, pVar.f10697b, bArr, i2, min);
        int i4 = pVar.f10697b + min;
        pVar.f10697b = i4;
        this.f10663c -= (long) min;
        if (i4 == pVar.f10698c) {
            this.f10662b = pVar.b();
            q.a(pVar);
        }
        return min;
    }

    public f N() {
        return new f(k());
    }

    public String O(long j2, Charset charset) {
        v.b(this.f10663c, 0, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j2 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        } else if (j2 == 0) {
            return BuildConfig.FLAVOR;
        } else {
            p pVar = this.f10662b;
            if (((long) pVar.f10697b) + j2 > ((long) pVar.f10698c)) {
                return new String(q(j2), charset);
            }
            String str = new String(pVar.f10696a, pVar.f10697b, (int) j2, charset);
            int i2 = (int) (((long) pVar.f10697b) + j2);
            pVar.f10697b = i2;
            this.f10663c -= j2;
            if (i2 == pVar.f10698c) {
                this.f10662b = pVar.b();
                q.a(pVar);
            }
            return str;
        }
    }

    public String P() {
        try {
            return O(this.f10663c, v.f10711a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String Q(long j2) {
        return O(j2, v.f10711a);
    }

    /* access modifiers changed from: package-private */
    public String R(long j2) {
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (J(j3) == 13) {
                String Q = Q(j3);
                b(2);
                return Q;
            }
        }
        String Q2 = Q(j2);
        b(1);
        return Q2;
    }

    public final long S() {
        return this.f10663c;
    }

    public final f T() {
        long j2 = this.f10663c;
        if (j2 <= 2147483647L) {
            return U((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f10663c);
    }

    public final f U(int i2) {
        if (i2 == 0) {
            return f.f10666f;
        }
        return new r(this, i2);
    }

    /* access modifiers changed from: package-private */
    public p V(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        p pVar = this.f10662b;
        if (pVar == null) {
            p b2 = q.b();
            this.f10662b = b2;
            b2.f10702g = b2;
            b2.f10701f = b2;
            return b2;
        }
        p pVar2 = pVar.f10702g;
        if (pVar2.f10698c + i2 <= 8192 && pVar2.f10700e) {
            return pVar2;
        }
        p b3 = q.b();
        pVar2.c(b3);
        return b3;
    }

    public c W(f fVar) {
        if (fVar != null) {
            fVar.x(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public c X(byte[] bArr) {
        if (bArr != null) {
            Y(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c Y(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = (long) i3;
            v.b((long) bArr.length, (long) i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                p V = V(1);
                int min = Math.min(i4 - i2, 8192 - V.f10698c);
                System.arraycopy(bArr, i2, V.f10696a, V.f10698c, min);
                i2 += min;
                V.f10698c += min;
            }
            this.f10663c += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long Z(t tVar) {
        if (tVar != null) {
            long j2 = 0;
            while (true) {
                long v = tVar.v(this, 8192);
                if (v == -1) {
                    return j2;
                }
                j2 += v;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    @Override // j.e, j.d
    public c a() {
        return this;
    }

    public c a0(int i2) {
        p V = V(1);
        byte[] bArr = V.f10696a;
        int i3 = V.f10698c;
        V.f10698c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f10663c++;
        return this;
    }

    @Override // j.e
    public void b(long j2) {
        while (j2 > 0) {
            p pVar = this.f10662b;
            if (pVar != null) {
                int min = (int) Math.min(j2, (long) (pVar.f10698c - pVar.f10697b));
                long j3 = (long) min;
                this.f10663c -= j3;
                j2 -= j3;
                p pVar2 = this.f10662b;
                int i2 = pVar2.f10697b + min;
                pVar2.f10697b = i2;
                if (i2 == pVar2.f10698c) {
                    this.f10662b = pVar2.b();
                    q.a(pVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public c b0(long j2) {
        if (j2 == 0) {
            a0(48);
            return this;
        }
        boolean z = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                g0("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        p V = V(i2);
        byte[] bArr = V.f10696a;
        int i3 = V.f10698c + i2;
        while (j2 != 0) {
            i3--;
            bArr[i3] = f10661d[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        V.f10698c += i2;
        this.f10663c += (long) i2;
        return this;
    }

    @Override // j.s, j.t
    public u c() {
        return u.f10707d;
    }

    public c c0(long j2) {
        if (j2 == 0) {
            a0(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        p V = V(numberOfTrailingZeros);
        byte[] bArr = V.f10696a;
        int i2 = V.f10698c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f10661d[(int) (15 & j2)];
            j2 >>>= 4;
        }
        V.f10698c += numberOfTrailingZeros;
        this.f10663c += (long) numberOfTrailingZeros;
        return this;
    }

    @Override // java.lang.AutoCloseable, j.s, j.t, java.io.Closeable, java.nio.channels.Channel
    public void close() {
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d d(byte[] bArr, int i2, int i3) {
        Y(bArr, i2, i3);
        return this;
    }

    public c d0(int i2) {
        p V = V(4);
        byte[] bArr = V.f10696a;
        int i3 = V.f10698c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        V.f10698c = i6 + 1;
        this.f10663c += 4;
        return this;
    }

    @Override // j.s
    public void e(c cVar, long j2) {
        int i2;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            v.b(cVar.f10663c, 0, j2);
            while (j2 > 0) {
                p pVar = cVar.f10662b;
                if (j2 < ((long) (pVar.f10698c - pVar.f10697b))) {
                    p pVar2 = this.f10662b;
                    p pVar3 = pVar2 != null ? pVar2.f10702g : null;
                    if (pVar3 != null && pVar3.f10700e) {
                        long j3 = ((long) pVar3.f10698c) + j2;
                        if (pVar3.f10699d) {
                            i2 = 0;
                        } else {
                            i2 = pVar3.f10697b;
                        }
                        if (j3 - ((long) i2) <= 8192) {
                            pVar.f(pVar3, (int) j2);
                            cVar.f10663c -= j2;
                            this.f10663c += j2;
                            return;
                        }
                    }
                    cVar.f10662b = pVar.e((int) j2);
                }
                p pVar4 = cVar.f10662b;
                long j4 = (long) (pVar4.f10698c - pVar4.f10697b);
                cVar.f10662b = pVar4.b();
                p pVar5 = this.f10662b;
                if (pVar5 == null) {
                    this.f10662b = pVar4;
                    pVar4.f10702g = pVar4;
                    pVar4.f10701f = pVar4;
                } else {
                    pVar5.f10702g.c(pVar4);
                    pVar4.a();
                }
                cVar.f10663c -= j4;
                this.f10663c += j4;
                j2 -= j4;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public c e0(int i2) {
        p V = V(2);
        byte[] bArr = V.f10696a;
        int i3 = V.f10698c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        V.f10698c = i4 + 1;
        this.f10663c += 2;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j2 = this.f10663c;
        if (j2 != cVar.f10663c) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        p pVar = this.f10662b;
        p pVar2 = cVar.f10662b;
        int i2 = pVar.f10697b;
        int i3 = pVar2.f10697b;
        while (j3 < this.f10663c) {
            long min = (long) Math.min(pVar.f10698c - i2, pVar2.f10698c - i3);
            int i4 = 0;
            while (((long) i4) < min) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (pVar.f10696a[i2] != pVar2.f10696a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == pVar.f10698c) {
                pVar = pVar.f10701f;
                i2 = pVar.f10697b;
            }
            if (i3 == pVar2.f10698c) {
                pVar2 = pVar2.f10701f;
                i3 = pVar2.f10697b;
            }
            j3 += min;
        }
        return true;
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d f(long j2) {
        c0(j2);
        return this;
    }

    public c f0(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i2);
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(v.f10711a)) {
            h0(str, i2, i3);
            return this;
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            Y(bytes, 0, bytes.length);
            return this;
        }
    }

    @Override // j.d, j.s, java.io.Flushable
    public void flush() {
    }

    @Override // j.e
    public f g(long j2) {
        return new f(q(j2));
    }

    public c g0(String str) {
        h0(str, 0, str.length());
        return this;
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d h(int i2) {
        e0(i2);
        return this;
    }

    public c h0(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    p V = V(1);
                    byte[] bArr = V.f10696a;
                    int i4 = V.f10698c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = V.f10698c;
                    int i7 = (i4 + i5) - i6;
                    V.f10698c = i6 + i7;
                    this.f10663c += (long) i7;
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        a0((charAt >> 6) | 192);
                        a0((charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        a0((charAt >> '\f') | 224);
                        a0(((charAt >> 6) & 63) | 128);
                        a0((charAt & '?') | 128);
                    } else {
                        int i8 = i2 + 1;
                        char charAt3 = i8 < i3 ? str.charAt(i8) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            a0(63);
                            i2 = i8;
                        } else {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            a0((i9 >> 18) | 240);
                            a0(((i9 >> 12) & 63) | 128);
                            a0(((i9 >> 6) & 63) | 128);
                            a0((i9 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i2++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
    }

    public int hashCode() {
        p pVar = this.f10662b;
        if (pVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = pVar.f10698c;
            for (int i4 = pVar.f10697b; i4 < i3; i4++) {
                i2 = (i2 * 31) + pVar.f10696a[i4];
            }
            pVar = pVar.f10701f;
        } while (pVar != this.f10662b);
        return i2;
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d i(int i2) {
        d0(i2);
        return this;
    }

    public c i0(int i2) {
        if (i2 < 128) {
            a0(i2);
        } else if (i2 < 2048) {
            a0((i2 >> 6) | 192);
            a0((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                a0((i2 >> 12) | 224);
                a0(((i2 >> 6) & 63) | 128);
                a0((i2 & 63) | 128);
            } else {
                a0(63);
            }
        } else if (i2 <= 1114111) {
            a0((i2 >> 18) | 240);
            a0(((i2 >> 12) & 63) | 128);
            a0(((i2 >> 6) & 63) | 128);
            a0((i2 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }

    public boolean isOpen() {
        return true;
    }

    @Override // j.e
    public String j() {
        return w(Long.MAX_VALUE);
    }

    @Override // j.e
    public byte[] k() {
        try {
            return q(this.f10663c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // j.e
    public int m() {
        return v.c(readInt());
    }

    @Override // j.e
    public c n() {
        return this;
    }

    @Override // j.e
    public boolean o() {
        return this.f10663c == 0;
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d p(int i2) {
        a0(i2);
        return this;
    }

    @Override // j.e
    public byte[] q(long j2) {
        v.b(this.f10663c, 0, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[((int) j2)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d r(byte[] bArr) {
        X(bArr);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        p pVar = this.f10662b;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), pVar.f10698c - pVar.f10697b);
        byteBuffer.put(pVar.f10696a, pVar.f10697b, min);
        int i2 = pVar.f10697b + min;
        pVar.f10697b = i2;
        this.f10663c -= (long) min;
        if (i2 == pVar.f10698c) {
            this.f10662b = pVar.b();
            q.a(pVar);
        }
        return min;
    }

    @Override // j.e
    public byte readByte() {
        long j2 = this.f10663c;
        if (j2 != 0) {
            p pVar = this.f10662b;
            int i2 = pVar.f10697b;
            int i3 = pVar.f10698c;
            int i4 = i2 + 1;
            byte b2 = pVar.f10696a[i2];
            this.f10663c = j2 - 1;
            if (i4 == i3) {
                this.f10662b = pVar.b();
                q.a(pVar);
            } else {
                pVar.f10697b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // j.e
    public void readFully(byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            int M = M(bArr, i2, bArr.length - i2);
            if (M != -1) {
                i2 += M;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // j.e
    public int readInt() {
        long j2 = this.f10663c;
        if (j2 >= 4) {
            p pVar = this.f10662b;
            int i2 = pVar.f10697b;
            int i3 = pVar.f10698c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = pVar.f10696a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            this.f10663c = j2 - 4;
            if (i9 == i3) {
                this.f10662b = pVar.b();
                q.a(pVar);
            } else {
                pVar.f10697b = i9;
            }
            return i10;
        }
        throw new IllegalStateException("size < 4: " + this.f10663c);
    }

    @Override // j.e
    public short readShort() {
        long j2 = this.f10663c;
        if (j2 >= 2) {
            p pVar = this.f10662b;
            int i2 = pVar.f10697b;
            int i3 = pVar.f10698c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = pVar.f10696a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f10663c = j2 - 2;
            if (i5 == i3) {
                this.f10662b = pVar.b();
                q.a(pVar);
            } else {
                pVar.f10697b = i5;
            }
            return (short) i6;
        }
        throw new IllegalStateException("size < 2: " + this.f10663c);
    }

    @Override // j.e
    public short s() {
        return v.d(readShort());
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d t() {
        I();
        return this;
    }

    public String toString() {
        return T().toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r8 == false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return -r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return r3;
     */
    @Override // j.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long u() {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: j.c.u():long");
    }

    @Override // j.t
    public long v(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 >= 0) {
            long j3 = this.f10663c;
            if (j3 == 0) {
                return -1;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            cVar.e(this, j2);
            return j2;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
    }

    @Override // j.e
    public String w(long j2) {
        if (j2 >= 0) {
            long j3 = Long.MAX_VALUE;
            if (j2 != Long.MAX_VALUE) {
                j3 = j2 + 1;
            }
            long K = K((byte) 10, 0, j3);
            if (K != -1) {
                return R(K);
            }
            if (j3 < S() && J(j3 - 1) == 13 && J(j3) == 10) {
                return R(j3);
            }
            c cVar = new c();
            H(cVar, 0, Math.min(32L, S()));
            throw new EOFException("\\n not found: limit=" + Math.min(S(), j2) + " content=" + cVar.N().k() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                p V = V(1);
                int min = Math.min(i2, 8192 - V.f10698c);
                byteBuffer.get(V.f10696a, V.f10698c, min);
                i2 -= min;
                V.f10698c += min;
            }
            this.f10663c += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // j.e
    public void x(long j2) {
        if (this.f10663c < j2) {
            throw new EOFException();
        }
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d y(String str) {
        g0(str);
        return this;
    }

    @Override // j.d
    public /* bridge */ /* synthetic */ d z(long j2) {
        b0(j2);
        return this;
    }
}
