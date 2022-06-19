package h.a.a.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import h.a.a.a.f;
import h.a.a.a.i;

/* access modifiers changed from: package-private */
/* compiled from: MediaCodecVideoDecoder */
public class g extends f {
    private Surface s;
    private boolean t;

    public g(h hVar, boolean z, int i2, f.b bVar, Surface surface, boolean z2) {
        super(hVar, z, i2, bVar);
        this.s = surface;
        this.t = z2;
        p();
    }

    private long z(long j2, h hVar, MediaCodec mediaCodec) {
        mediaCodec.flush();
        hVar.l(j2, 0);
        if (hVar.c() == j2) {
            Log.d(this.f10215a, "skip fastseek, already there");
            return j2;
        }
        y();
        o(false);
        hVar.l(j2, 0);
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i2 = 0;
        while (hVar.a() && i2 < 20) {
            long c2 = j2 - hVar.c();
            if (c2 >= 0 && c2 < j3) {
                j4 = hVar.c();
                j3 = c2;
            }
            if (c2 < 0) {
                i2++;
            }
        }
        hVar.l(j4, 0);
        while (hVar.c() != j4) {
            hVar.a();
        }
        Log.d(this.f10215a, "exact fastseek match:       " + hVar.c());
        return j4;
    }

    public int A() {
        MediaFormat i2 = i();
        if (i2 != null) {
            return i2.getInteger("height");
        }
        return 0;
    }

    public int B() {
        MediaFormat i2 = i();
        if (i2 == null || !i2.containsKey("rotation-degrees")) {
            return 0;
        }
        return i2.getInteger("rotation-degrees");
    }

    public int C() {
        MediaFormat i2 = i();
        if (i2 != null) {
            return (int) (((float) i2.getInteger("height")) * i2.getFloat("mpx-dar"));
        }
        return 0;
    }

    @TargetApi(21)
    public void D(f.a aVar, long j2) {
        g().releaseOutputBuffer(aVar.f10226a, System.nanoTime() + (j2 * 1000));
        s(aVar);
    }

    public void E(f.a aVar, boolean z) {
        g().releaseOutputBuffer(aVar.f10226a, z);
        s(aVar);
    }

    public void F(Surface surface) {
        if (surface != null) {
            this.s = surface;
            p();
            return;
        }
        throw new RuntimeException("surface must not be null");
    }

    /* access modifiers changed from: protected */
    @Override // h.a.a.a.f
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        mediaCodec.configure(mediaFormat, this.s, (MediaCrypto) null, 0);
    }

    @Override // h.a.a.a.f
    @SuppressLint({"NewApi"})
    public void u(f.a aVar, long j2) {
        if (this.t) {
            D(aVar, j2);
        } else {
            E(aVar, true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // h.a.a.a.f
    public f.a v(i.n nVar, long j2, h hVar, MediaCodec mediaCodec) {
        long j3 = j2 / 1000;
        f.a v = super.v(nVar, j2, hVar, mediaCodec);
        long j4 = -1;
        if (nVar == i.n.FAST || nVar == i.n.FAST_TO_CLOSEST_SYNC || nVar == i.n.FAST_TO_PREVIOUS_SYNC || nVar == i.n.FAST_TO_NEXT_SYNC) {
            Log.d(this.f10215a, "fast seek to " + j2 + " arrived at " + v.f10228c);
        } else if (nVar == i.n.FAST_EXACT) {
            E(v, false);
            z(j2, hVar, mediaCodec);
            f.a b2 = b(true, true);
            Log.d(this.f10215a, "fast_exact seek to " + j2 + " arrived at " + b2.f10228c);
            if (b2.f10228c < j2) {
                Log.d(this.f10215a, "presentation is behind...");
            }
            return b2;
        } else if (nVar == i.n.PRECISE || nVar == i.n.EXACT) {
            int i2 = 0;
            long j5 = -1;
            j4 = v.f10228c / 1000;
            while (j4 < j3) {
                if (i2 == 0) {
                    Log.d(this.f10215a, "skipping frames...");
                }
                i2++;
                if (l()) {
                    j3 = v.f10228c / 1000;
                }
                if (v.f10229d) {
                    Log.d(this.f10215a, "end of stream reached, seeking to last frame");
                    E(v, false);
                    return v(nVar, j5, hVar, mediaCodec);
                }
                j5 = v.f10228c;
                E(v, false);
                v = b(true, true);
                j4 = v.f10228c / 1000;
            }
            Log.d(this.f10215a, "frame new position:         " + v.f10228c);
            Log.d(this.f10215a, "seeking finished, skipped " + i2 + " frames");
            if (nVar == i.n.EXACT && j4 > j3) {
                if (i2 == 0) {
                    Log.w(this.f10215a, "this should never happen");
                } else {
                    Log.d(this.f10215a, "exact seek: repeat seek for previous frame at " + j5);
                    E(v, false);
                    return v(nVar, j5, hVar, mediaCodec);
                }
            }
        }
        if (j4 == j3) {
            Log.d(this.f10215a, "exact seek match!");
        }
        return v;
    }
}
