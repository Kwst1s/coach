package h.a.a.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import h.a.a.a.f;

/* access modifiers changed from: package-private */
/* compiled from: MediaCodecAudioDecoder */
public class e extends f {
    private a s;

    public e(h hVar, boolean z, int i2, f.b bVar, a aVar) {
        super(hVar, z, i2, bVar);
        this.s = aVar;
        p();
    }

    /* access modifiers changed from: protected */
    @Override // h.a.a.a.f
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        super.a(mediaCodec, mediaFormat);
        this.s.l(mediaFormat);
    }

    /* access modifiers changed from: protected */
    @Override // h.a.a.a.f
    public void n(MediaFormat mediaFormat) {
        this.s.l(mediaFormat);
    }

    @Override // h.a.a.a.f
    public void u(f.a aVar, long j2) {
        this.s.w(aVar.f10227b, aVar.f10228c);
        r(aVar);
    }

    /* access modifiers changed from: protected */
    @Override // h.a.a.a.f
    public boolean x() {
        if (!m()) {
            return this.s.k() < 200000;
        }
        return super.x();
    }
}
