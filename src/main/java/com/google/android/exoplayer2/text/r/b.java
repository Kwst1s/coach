package com.google.android.exoplayer2.text.r;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.r.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: Mp4WebvttDecoder */
public final class b extends com.google.android.exoplayer2.text.b {
    private static final int p = d0.B("payl");
    private static final int q = d0.B("sttg");
    private static final int r = d0.B("vttc");
    private final s n = new s();
    private final e.b o = new e.b();

    public b() {
        super("Mp4WebvttDecoder");
    }

    private static a D(s sVar, e.b bVar, int i2) {
        bVar.c();
        while (i2 > 0) {
            if (i2 >= 8) {
                int j2 = sVar.j();
                int j3 = sVar.j();
                int i3 = j2 - 8;
                String u = d0.u(sVar.f7062a, sVar.c(), i3);
                sVar.L(i3);
                i2 = (i2 - 8) - i3;
                if (j3 == q) {
                    f.j(u, bVar);
                } else if (j3 == p) {
                    f.k(null, u.trim(), bVar, Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        return bVar.a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public c z(byte[] bArr, int i2, boolean z) {
        this.n.I(bArr, i2);
        ArrayList arrayList = new ArrayList();
        while (this.n.a() > 0) {
            if (this.n.a() >= 8) {
                int j2 = this.n.j();
                if (this.n.j() == r) {
                    arrayList.add(D(this.n, this.o, j2 - 8));
                } else {
                    this.n.L(j2 - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new c(arrayList);
    }
}
