package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.text.r.h;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttExtractor */
public final class p implements g {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f6428g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f6429h = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private final String f6430a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f6431b;

    /* renamed from: c  reason: collision with root package name */
    private final s f6432c = new s();

    /* renamed from: d  reason: collision with root package name */
    private i f6433d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f6434e = new byte[1024];

    /* renamed from: f  reason: collision with root package name */
    private int f6435f;

    public p(String str, a0 a0Var) {
        this.f6430a = str;
        this.f6431b = a0Var;
    }

    private q b(long j2) {
        q a2 = this.f6433d.a(0, 3);
        a2.d(l.D(null, "text/vtt", null, -1, 0, this.f6430a, null, j2));
        this.f6433d.h();
        return a2;
    }

    private void d() {
        s sVar = new s(this.f6434e);
        h.e(sVar);
        long j2 = 0;
        long j3 = 0;
        while (true) {
            String l = sVar.l();
            if (TextUtils.isEmpty(l)) {
                Matcher a2 = h.a(sVar);
                if (a2 == null) {
                    b(0);
                    return;
                }
                long d2 = h.d(a2.group(1));
                long b2 = this.f6431b.b(a0.i((j2 + d2) - j3));
                q b3 = b(b2 - d2);
                this.f6432c.I(this.f6434e, this.f6435f);
                b3.a(this.f6432c, this.f6435f);
                b3.c(b2, 1, this.f6435f, 0, null);
                return;
            } else if (l.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f6428g.matcher(l);
                if (matcher.find()) {
                    Matcher matcher2 = f6429h.matcher(l);
                    if (matcher2.find()) {
                        j3 = h.d(matcher.group(1));
                        j2 = a0.f(Long.parseLong(matcher2.group(1)));
                    } else {
                        throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + l);
                    }
                } else {
                    throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + l);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f6433d = iVar;
        iVar.e(new o.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(com.google.android.exoplayer2.e0.h hVar) {
        hVar.h(this.f6434e, 0, 6, false);
        this.f6432c.I(this.f6434e, 6);
        if (h.b(this.f6432c)) {
            return true;
        }
        hVar.h(this.f6434e, 6, 3, false);
        this.f6432c.I(this.f6434e, 9);
        return h.b(this.f6432c);
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(com.google.android.exoplayer2.e0.h hVar, n nVar) {
        int i2;
        int d2 = (int) hVar.d();
        int i3 = this.f6435f;
        byte[] bArr = this.f6434e;
        if (i3 == bArr.length) {
            if (d2 != -1) {
                i2 = d2;
            } else {
                i2 = bArr.length;
            }
            this.f6434e = Arrays.copyOf(bArr, (i2 * 3) / 2);
        }
        byte[] bArr2 = this.f6434e;
        int i4 = this.f6435f;
        int a2 = hVar.a(bArr2, i4, bArr2.length - i4);
        if (a2 != -1) {
            int i5 = this.f6435f + a2;
            this.f6435f = i5;
            if (d2 == -1 || i5 != d2) {
                return 0;
            }
        }
        d();
        return -1;
    }
}
