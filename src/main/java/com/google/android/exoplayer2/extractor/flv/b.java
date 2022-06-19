package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.s;
import java.util.Collections;

/* access modifiers changed from: package-private */
/* compiled from: AudioTagPayloadReader */
public final class b extends TagPayloadReader {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f5680e = {5512, 11025, 22050, 44100};

    /* renamed from: b  reason: collision with root package name */
    private boolean f5681b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5682c;

    /* renamed from: d  reason: collision with root package name */
    private int f5683d;

    public b(q qVar) {
        super(qVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(s sVar) {
        if (!this.f5681b) {
            int y = sVar.y();
            int i2 = (y >> 4) & 15;
            this.f5683d = i2;
            if (i2 == 2) {
                this.f5678a.d(l.t(null, "audio/mpeg", null, -1, -1, 1, f5680e[(y >> 2) & 3], null, null, 0, null));
                this.f5682c = true;
            } else if (i2 == 7 || i2 == 8) {
                this.f5678a.d(l.s(null, i2 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", null, -1, -1, 1, 8000, (y & 1) == 1 ? 2 : 3, null, null, 0, null));
                this.f5682c = true;
            } else if (i2 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f5683d);
            }
            this.f5681b = true;
        } else {
            sVar.L(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(s sVar, long j2) {
        if (this.f5683d == 2) {
            int a2 = sVar.a();
            this.f5678a.a(sVar, a2);
            this.f5678a.c(j2, 1, a2, 0, null);
            return;
        }
        int y = sVar.y();
        if (y == 0 && !this.f5682c) {
            int a3 = sVar.a();
            byte[] bArr = new byte[a3];
            sVar.h(bArr, 0, a3);
            Pair<Integer, Integer> j3 = g.j(bArr);
            this.f5678a.d(l.t(null, "audio/mp4a-latm", null, -1, -1, ((Integer) j3.second).intValue(), ((Integer) j3.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.f5682c = true;
        } else if (this.f5683d != 10 || y == 1) {
            int a4 = sVar.a();
            this.f5678a.a(sVar, a4);
            this.f5678a.c(j2, 1, a4, 0, null);
        }
    }
}
