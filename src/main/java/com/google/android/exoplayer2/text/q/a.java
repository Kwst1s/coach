package com.google.android.exoplayer2.text.q;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: Tx3gDecoder */
public final class a extends b {
    private static final int u = d0.B("styl");
    private static final int v = d0.B("tbox");
    private final s n = new s();
    private boolean o;
    private int p;
    private int q;
    private String r;
    private float s;
    private int t;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        H(list);
    }

    private void C(s sVar, SpannableStringBuilder spannableStringBuilder) {
        D(sVar.a() >= 12);
        int E = sVar.E();
        int E2 = sVar.E();
        sVar.L(2);
        int y = sVar.y();
        sVar.L(1);
        int j2 = sVar.j();
        F(spannableStringBuilder, y, this.p, E, E2, 0);
        E(spannableStringBuilder, j2, this.q, E, E2, 0);
    }

    private static void D(boolean z) {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    private static void F(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z = true;
            boolean z2 = (i2 & 1) != 0;
            boolean z3 = (i2 & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            if ((i2 & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
            }
        }
    }

    private static void G(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2, int i3, int i4) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, i4 | 33);
        }
    }

    private void H(List<byte[]> list) {
        String str = "sans-serif";
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.p = bArr[24];
            this.q = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            if ("Serif".equals(d0.u(bArr, 43, bArr.length - 43))) {
                str = "serif";
            }
            this.r = str;
            int i2 = bArr[25] * 20;
            this.t = i2;
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.o = z;
            if (z) {
                float f2 = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i2);
                this.s = f2;
                this.s = d0.m(f2, Utils.FLOAT_EPSILON, 0.95f);
                return;
            }
            this.s = 0.85f;
            return;
        }
        this.p = 0;
        this.q = -1;
        this.r = str;
        this.o = false;
        this.s = 0.85f;
    }

    private static String I(s sVar) {
        char e2;
        D(sVar.a() >= 2);
        int E = sVar.E();
        if (E == 0) {
            return BuildConfig.FLAVOR;
        }
        if (sVar.a() < 2 || ((e2 = sVar.e()) != 65279 && e2 != 65534)) {
            return sVar.w(E, Charset.forName("UTF-8"));
        }
        return sVar.w(E, Charset.forName("UTF-16"));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.b
    public d z(byte[] bArr, int i2, boolean z) {
        this.n.I(bArr, i2);
        String I = I(this.n);
        if (I.isEmpty()) {
            return b.f6814c;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(I);
        F(spannableStringBuilder, this.p, 0, 0, spannableStringBuilder.length(), 16711680);
        E(spannableStringBuilder, this.q, -1, 0, spannableStringBuilder.length(), 16711680);
        G(spannableStringBuilder, this.r, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f2 = this.s;
        while (this.n.a() >= 8) {
            int c2 = this.n.c();
            int j2 = this.n.j();
            int j3 = this.n.j();
            boolean z2 = true;
            if (j3 == u) {
                if (this.n.a() < 2) {
                    z2 = false;
                }
                D(z2);
                int E = this.n.E();
                for (int i3 = 0; i3 < E; i3++) {
                    C(this.n, spannableStringBuilder);
                }
            } else if (j3 == v && this.o) {
                if (this.n.a() < 2) {
                    z2 = false;
                }
                D(z2);
                f2 = d0.m(((float) this.n.E()) / ((float) this.t), Utils.FLOAT_EPSILON, 0.95f);
            }
            this.n.K(c2 + j2);
        }
        return new b(new com.google.android.exoplayer2.text.a(spannableStringBuilder, null, f2, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }
}
