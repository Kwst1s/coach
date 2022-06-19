package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.h0.h;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: VideoTagPayloadReader */
public final class e extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private final s f5696b = new s(q.f7040a);

    /* renamed from: c  reason: collision with root package name */
    private final s f5697c = new s(4);

    /* renamed from: d  reason: collision with root package name */
    private int f5698d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5699e;

    /* renamed from: f  reason: collision with root package name */
    private int f5700f;

    public e(com.google.android.exoplayer2.e0.q qVar) {
        super(qVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(s sVar) {
        int y = sVar.y();
        int i2 = (y >> 4) & 15;
        int i3 = y & 15;
        if (i3 == 7) {
            this.f5700f = i2;
            return i2 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(s sVar, long j2) {
        int y = sVar.y();
        long k2 = j2 + (((long) sVar.k()) * 1000);
        if (y == 0 && !this.f5699e) {
            s sVar2 = new s(new byte[sVar.a()]);
            sVar.h(sVar2.f7062a, 0, sVar.a());
            h b2 = h.b(sVar2);
            this.f5698d = b2.f5878b;
            this.f5678a.d(l.F(null, "video/avc", null, -1, -1, b2.f5879c, b2.f5880d, -1.0f, b2.f5877a, -1, b2.f5881e, null));
            this.f5699e = true;
        } else if (y == 1 && this.f5699e) {
            byte[] bArr = this.f5697c.f7062a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i2 = 4 - this.f5698d;
            int i3 = 0;
            while (sVar.a() > 0) {
                sVar.h(this.f5697c.f7062a, i2, this.f5698d);
                this.f5697c.K(0);
                int C = this.f5697c.C();
                this.f5696b.K(0);
                this.f5678a.a(this.f5696b, 4);
                this.f5678a.a(sVar, C);
                i3 = i3 + 4 + C;
            }
            this.f5678a.c(k2, this.f5700f == 1 ? 1 : 0, i3, 0, null);
        }
    }
}
