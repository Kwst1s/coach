package com.google.android.exoplayer2.text.r;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.r.e;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WebvttDecoder */
public final class g extends b {
    private final f n = new f();
    private final s o = new s();
    private final e.b p = new e.b();
    private final a q = new a();
    private final List<d> r = new ArrayList();

    public g() {
        super("WebvttDecoder");
    }

    private static int D(s sVar) {
        int i2 = -1;
        int i3 = 0;
        while (i2 == -1) {
            i3 = sVar.c();
            String l = sVar.l();
            if (l == null) {
                i2 = 0;
            } else if ("STYLE".equals(l)) {
                i2 = 2;
            } else {
                i2 = "NOTE".startsWith(l) ? 1 : 3;
            }
        }
        sVar.K(i3);
        return i2;
    }

    private static void E(s sVar) {
        do {
        } while (!TextUtils.isEmpty(sVar.l()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public i z(byte[] bArr, int i2, boolean z) {
        this.o.I(bArr, i2);
        this.p.c();
        this.r.clear();
        try {
            h.e(this.o);
            do {
            } while (!TextUtils.isEmpty(this.o.l()));
            ArrayList arrayList = new ArrayList();
            while (true) {
                int D = D(this.o);
                if (D == 0) {
                    return new i(arrayList);
                }
                if (D == 1) {
                    E(this.o);
                } else if (D == 2) {
                    if (arrayList.isEmpty()) {
                        this.o.l();
                        d d2 = this.q.d(this.o);
                        if (d2 != null) {
                            this.r.add(d2);
                        }
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (D == 3 && this.n.h(this.o, this.p, this.r)) {
                    arrayList.add(this.p.a());
                    this.p.c();
                }
            }
        } catch (ParserException e2) {
            throw new SubtitleDecoderException(e2);
        }
    }
}
