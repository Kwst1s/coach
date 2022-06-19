package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.j;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.d0.e;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.p;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

@TargetApi(16)
/* compiled from: MediaCodecAudioRenderer */
public class q extends MediaCodecRenderer implements o {
    private final Context i0;
    private final j.a j0;
    private final AudioSink k0;
    private final long[] l0;
    private int m0;
    private boolean n0;
    private boolean o0;
    private boolean p0;
    private MediaFormat q0;
    private int r0;
    private int s0;
    private int t0;
    private int u0;
    private long v0;
    private boolean w0;
    private boolean x0;
    private long y0;
    private int z0;

    /* compiled from: MediaCodecAudioRenderer */
    private final class b implements AudioSink.a {
        private b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a() {
            q.this.R0();
            q.this.x0 = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(int i2, long j2, long j3) {
            q.this.j0.b(i2, j2, j3);
            q.this.S0(i2, j2, j3);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d(int i2) {
            q.this.j0.a(i2);
            q.this.Q0(i2);
        }
    }

    public q(Context context, com.google.android.exoplayer2.mediacodec.b bVar, m<com.google.android.exoplayer2.drm.q> mVar, boolean z, Handler handler, j jVar, i iVar, AudioProcessor... audioProcessorArr) {
        this(context, bVar, mVar, z, handler, jVar, new DefaultAudioSink(iVar, audioProcessorArr));
    }

    private static boolean L0(String str) {
        if (d0.f7006a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(d0.f7008c)) {
            String str2 = d0.f7007b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean M0(String str) {
        if (d0.f7006a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(d0.f7008c)) {
            String str2 = d0.f7007b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private int N0(com.google.android.exoplayer2.mediacodec.a aVar, l lVar) {
        PackageManager packageManager;
        int i2 = d0.f7006a;
        if (i2 < 24 && "OMX.google.raw.decoder".equals(aVar.f5999a)) {
            boolean z = true;
            if (i2 == 23 && (packageManager = this.i0.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) {
                z = false;
            }
            if (z) {
                return -1;
            }
        }
        return lVar.f5978i;
    }

    private void T0() {
        long k2 = this.k0.k(b());
        if (k2 != Long.MIN_VALUE) {
            if (!this.x0) {
                k2 = Math.max(this.v0, k2);
            }
            this.v0 = k2;
            this.x0 = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void B() {
        try {
            this.y0 = -9223372036854775807L;
            this.z0 = 0;
            this.k0.a();
            try {
                super.B();
            } finally {
                this.g0.a();
                this.j0.d(this.g0);
            }
        } catch (Throwable th) {
            super.B();
            throw th;
        } finally {
            this.g0.a();
            this.j0.d(this.g0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void C(boolean z) {
        super.C(z);
        this.j0.e(this.g0);
        int i2 = x().f7103a;
        if (i2 != 0) {
            this.k0.t(i2);
        } else {
            this.k0.l();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void D(long j2, boolean z) {
        super.D(j2, z);
        this.k0.e();
        this.v0 = j2;
        this.w0 = true;
        this.x0 = true;
        this.y0 = -9223372036854775807L;
        this.z0 = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void E() {
        super.E();
        this.k0.j();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void F() {
        T0();
        this.k0.c();
        super.F();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int F0(com.google.android.exoplayer2.mediacodec.b bVar, m<com.google.android.exoplayer2.drm.q> mVar, l lVar) {
        boolean z;
        String str = lVar.f5977h;
        if (!p.k(str)) {
            return 0;
        }
        int i2 = d0.f7006a >= 21 ? 32 : 0;
        boolean J = c.J(mVar, lVar.f5980k);
        int i3 = 4;
        int i4 = 8;
        if (J && K0(str) && bVar.a() != null) {
            return i2 | 8 | 4;
        }
        if (("audio/raw".equals(str) && !this.k0.o(lVar.w)) || !this.k0.o(2)) {
            return 1;
        }
        com.google.android.exoplayer2.drm.l lVar2 = lVar.f5980k;
        if (lVar2 != null) {
            z = false;
            for (int i5 = 0; i5 < lVar2.f5005e; i5++) {
                z |= lVar2.n(i5).f5011g;
            }
        } else {
            z = false;
        }
        List<com.google.android.exoplayer2.mediacodec.a> b2 = bVar.b(lVar.f5977h, z);
        if (b2.isEmpty()) {
            if (!z || bVar.b(lVar.f5977h, false).isEmpty()) {
                return 1;
            }
            return 2;
        } else if (!J) {
            return 2;
        } else {
            com.google.android.exoplayer2.mediacodec.a aVar = b2.get(0);
            boolean j2 = aVar.j(lVar);
            if (j2 && aVar.k(lVar)) {
                i4 = 16;
            }
            if (!j2) {
                i3 = 3;
            }
            return i4 | i2 | i3;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void G(l[] lVarArr, long j2) {
        super.G(lVarArr, j2);
        if (this.y0 != -9223372036854775807L) {
            int i2 = this.z0;
            if (i2 == this.l0.length) {
                com.google.android.exoplayer2.util.m.f("MediaCodecAudioRenderer", "Too many stream changes, so dropping change at " + this.l0[this.z0 - 1]);
            } else {
                this.z0 = i2 + 1;
            }
            this.l0[this.z0 - 1] = this.y0;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int K(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.a aVar, l lVar, l lVar2) {
        if (N0(aVar, lVar2) <= this.m0 && aVar.l(lVar, lVar2, true) && lVar.x == 0 && lVar.y == 0 && lVar2.x == 0 && lVar2.y == 0) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean K0(String str) {
        int c2 = p.c(str);
        return c2 != 0 && this.k0.o(c2);
    }

    /* access modifiers changed from: protected */
    public int O0(com.google.android.exoplayer2.mediacodec.a aVar, l lVar, l[] lVarArr) {
        int N0 = N0(aVar, lVar);
        if (lVarArr.length == 1) {
            return N0;
        }
        for (l lVar2 : lVarArr) {
            if (aVar.l(lVar, lVar2, false)) {
                N0 = Math.max(N0, N0(aVar, lVar2));
            }
        }
        return N0;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat P0(l lVar, String str, int i2, float f2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", lVar.u);
        mediaFormat.setInteger("sample-rate", lVar.v);
        com.google.android.exoplayer2.mediacodec.c.e(mediaFormat, lVar.f5979j);
        com.google.android.exoplayer2.mediacodec.c.d(mediaFormat, "max-input-size", i2);
        if (d0.f7006a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public void Q0(int i2) {
    }

    /* access modifiers changed from: protected */
    public void R0() {
    }

    /* access modifiers changed from: protected */
    public void S0(int i2, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void T(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, l lVar, MediaCrypto mediaCrypto, float f2) {
        this.m0 = O0(aVar, lVar, z());
        this.o0 = L0(aVar.f5999a);
        this.p0 = M0(aVar.f5999a);
        this.n0 = aVar.f6005g;
        String str = aVar.f6000b;
        if (str == null) {
            str = "audio/raw";
        }
        MediaFormat P0 = P0(lVar, str, this.m0, f2);
        mediaCodec.configure(P0, (Surface) null, mediaCrypto, 0);
        if (this.n0) {
            this.q0 = P0;
            P0.setString("mime", lVar.f5977h);
            return;
        }
        this.q0 = null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.x
    public boolean b() {
        return super.b() && this.k0.b();
    }

    @Override // com.google.android.exoplayer2.util.o
    public s d() {
        return this.k0.d();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float d0(float f2, l lVar, l[] lVarArr) {
        int i2 = -1;
        for (l lVar2 : lVarArr) {
            int i3 = lVar2.v;
            if (i3 != -1) {
                i2 = Math.max(i2, i3);
            }
        }
        if (i2 == -1) {
            return -1.0f;
        }
        return f2 * ((float) i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.x
    public boolean e() {
        return this.k0.i() || super.e();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.a> e0(com.google.android.exoplayer2.mediacodec.b bVar, l lVar, boolean z) {
        com.google.android.exoplayer2.mediacodec.a a2;
        if (!K0(lVar.f5977h) || (a2 = bVar.a()) == null) {
            return super.e0(bVar, lVar, z);
        }
        return Collections.singletonList(a2);
    }

    @Override // com.google.android.exoplayer2.util.o
    public s f(s sVar) {
        return this.k0.f(sVar);
    }

    @Override // com.google.android.exoplayer2.v.b, com.google.android.exoplayer2.c
    public void m(int i2, Object obj) {
        if (i2 == 2) {
            this.k0.r(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.k0.n((h) obj);
        } else if (i2 != 5) {
            super.m(i2, obj);
        } else {
            this.k0.p((m) obj);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void n0(String str, long j2, long j3) {
        this.j0.c(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void o0(l lVar) {
        super.o0(lVar);
        this.j0.f(lVar);
        this.r0 = "audio/raw".equals(lVar.f5977h) ? lVar.w : 2;
        this.s0 = lVar.u;
        this.t0 = lVar.x;
        this.u0 = lVar.y;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void p0(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i2;
        int[] iArr;
        int i3;
        MediaFormat mediaFormat2 = this.q0;
        if (mediaFormat2 != null) {
            i2 = p.c(mediaFormat2.getString("mime"));
            mediaFormat = this.q0;
        } else {
            i2 = this.r0;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.o0 || integer != 6 || (i3 = this.s0) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i3];
            for (int i4 = 0; i4 < this.s0; i4++) {
                iArr[i4] = i4;
            }
        }
        try {
            this.k0.g(i2, integer, integer2, 0, iArr, this.t0, this.u0);
        } catch (AudioSink.ConfigurationException e2) {
            throw ExoPlaybackException.a(e2, y());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void q0(long j2) {
        while (this.z0 != 0 && j2 >= this.l0[0]) {
            this.k0.q();
            int i2 = this.z0 - 1;
            this.z0 = i2;
            long[] jArr = this.l0;
            System.arraycopy(jArr, 1, jArr, 0, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void r0(e eVar) {
        if (this.w0 && !eVar.i()) {
            if (Math.abs(eVar.f4952e - this.v0) > 500000) {
                this.v0 = eVar.f4952e;
            }
            this.w0 = false;
        }
        this.y0 = Math.max(eVar.f4952e, this.y0);
    }

    @Override // com.google.android.exoplayer2.x, com.google.android.exoplayer2.c
    public o t() {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean t0(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z, l lVar) {
        if (this.p0 && j4 == 0 && (i3 & 4) != 0) {
            long j5 = this.y0;
            if (j5 != -9223372036854775807L) {
                j4 = j5;
            }
        }
        if (this.n0 && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.g0.f4946f++;
            this.k0.q();
            return true;
        } else {
            try {
                if (!this.k0.s(byteBuffer, j4)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i2, false);
                this.g0.f4945e++;
                return true;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e2) {
                throw ExoPlaybackException.a(e2, y());
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.o
    public long v() {
        if (getState() == 2) {
            T0();
        }
        return this.v0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void y0() {
        try {
            this.k0.h();
        } catch (AudioSink.WriteException e2) {
            throw ExoPlaybackException.a(e2, y());
        }
    }

    public q(Context context, com.google.android.exoplayer2.mediacodec.b bVar, m<com.google.android.exoplayer2.drm.q> mVar, boolean z, Handler handler, j jVar, AudioSink audioSink) {
        super(1, bVar, mVar, z, 44100.0f);
        this.i0 = context.getApplicationContext();
        this.k0 = audioSink;
        this.y0 = -9223372036854775807L;
        this.l0 = new long[10];
        this.j0 = new j.a(handler, jVar);
        audioSink.m(new b());
    }
}
