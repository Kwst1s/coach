package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.d0.d;
import com.google.android.exoplayer2.d0.e;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.z;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecRenderer extends c {
    private static final byte[] h0 = d0.w("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private float A;
    private float B;
    private boolean C;
    private ArrayDeque<a> D;
    private DecoderInitializationException E;
    private a F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private ByteBuffer[] Q;
    private ByteBuffer[] R;
    private long S;
    private int T;
    private int U;
    private ByteBuffer V;
    private boolean W;
    private boolean X;
    private int Y;
    private int Z;
    private boolean a0;
    private boolean b0;
    private boolean c0;
    private boolean d0;
    private boolean e0;
    private boolean f0;
    protected d g0;

    /* renamed from: k  reason: collision with root package name */
    private final b f5982k;
    private final m<q> l;
    private final boolean m;
    private final float n;
    private final e o;
    private final e p;
    private final com.google.android.exoplayer2.m q;
    private final z<l> r;
    private final List<Long> s;
    private final MediaCodec.BufferInfo t;
    private l u;
    private l v;
    private l w;
    private DrmSession<q> x;
    private DrmSession<q> y;
    private MediaCodec z;

    public MediaCodecRenderer(int i2, b bVar, m<q> mVar, boolean z2, float f2) {
        super(i2);
        com.google.android.exoplayer2.util.e.f(d0.f7006a >= 16);
        com.google.android.exoplayer2.util.e.e(bVar);
        this.f5982k = bVar;
        this.l = mVar;
        this.m = z2;
        this.n = f2;
        this.o = new e(0);
        this.p = e.r();
        this.q = new com.google.android.exoplayer2.m();
        this.r = new z<>();
        this.s = new ArrayList();
        this.t = new MediaCodec.BufferInfo();
        this.Y = 0;
        this.Z = 0;
        this.B = -1.0f;
        this.A = 1.0f;
    }

    private void A0() {
        this.T = -1;
        this.o.f4951d = null;
    }

    private void B0() {
        this.U = -1;
        this.V = null;
    }

    private boolean D0(long j2) {
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.s.get(i2).longValue() == j2) {
                this.s.remove(i2);
                return true;
            }
        }
        return false;
    }

    private boolean E0(boolean z2) {
        DrmSession<q> drmSession = this.x;
        if (drmSession == null || (!z2 && this.m)) {
            return false;
        }
        int state = drmSession.getState();
        if (state == 1) {
            throw ExoPlaybackException.a(this.x.c(), y());
        } else if (state != 4) {
            return true;
        } else {
            return false;
        }
    }

    private void G0() {
        l lVar = this.u;
        if (lVar != null && d0.f7006a >= 23) {
            float d02 = d0(this.A, lVar, z());
            if (this.B != d02) {
                this.B = d02;
                if (this.z != null && this.Z == 0) {
                    if (d02 == -1.0f && this.C) {
                        w0();
                    } else if (d02 == -1.0f) {
                    } else {
                        if (this.C || d02 > this.n) {
                            Bundle bundle = new Bundle();
                            bundle.putFloat("operating-rate", d02);
                            this.z.setParameters(bundle);
                            this.C = true;
                        }
                    }
                }
            }
        }
    }

    private int L(String str) {
        int i2 = d0.f7006a;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = d0.f7009d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i2 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = d0.f7007b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private static boolean M(String str, l lVar) {
        return d0.f7006a < 21 && lVar.f5979j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean N(String str) {
        int i2 = d0.f7006a;
        return (i2 <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (i2 <= 19 && "hb2000".equals(d0.f7007b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean O(String str) {
        return d0.f7006a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean P(a aVar) {
        String str = aVar.f5999a;
        return (d0.f7006a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) || ("Amazon".equals(d0.f7008c) && "AFTS".equals(d0.f7009d) && aVar.f6004f);
    }

    private static boolean Q(String str) {
        int i2 = d0.f7006a;
        return i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && d0.f7009d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean R(String str, l lVar) {
        if (d0.f7006a > 18 || lVar.u != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean S(String str) {
        return d0.f7009d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private boolean U() {
        if ("Amazon".equals(d0.f7008c)) {
            String str = d0.f7009d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean V(long j2, long j3) {
        boolean z2;
        int i2;
        if (!j0()) {
            if (!this.L || !this.b0) {
                i2 = this.z.dequeueOutputBuffer(this.t, f0());
            } else {
                try {
                    i2 = this.z.dequeueOutputBuffer(this.t, f0());
                } catch (IllegalStateException unused) {
                    s0();
                    if (this.d0) {
                        x0();
                    }
                    return false;
                }
            }
            if (i2 < 0) {
                if (i2 == -2) {
                    v0();
                    return true;
                } else if (i2 == -3) {
                    u0();
                    return true;
                } else {
                    if (this.P && (this.c0 || this.Z == 2)) {
                        s0();
                    }
                    return false;
                }
            } else if (this.O) {
                this.O = false;
                this.z.releaseOutputBuffer(i2, false);
                return true;
            } else {
                MediaCodec.BufferInfo bufferInfo = this.t;
                if (bufferInfo.size != 0 || (bufferInfo.flags & 4) == 0) {
                    this.U = i2;
                    ByteBuffer i0 = i0(i2);
                    this.V = i0;
                    if (i0 != null) {
                        i0.position(this.t.offset);
                        ByteBuffer byteBuffer = this.V;
                        MediaCodec.BufferInfo bufferInfo2 = this.t;
                        byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                    }
                    this.W = D0(this.t.presentationTimeUs);
                    H0(this.t.presentationTimeUs);
                } else {
                    s0();
                    return false;
                }
            }
        }
        if (!this.L || !this.b0) {
            MediaCodec mediaCodec = this.z;
            ByteBuffer byteBuffer2 = this.V;
            int i3 = this.U;
            MediaCodec.BufferInfo bufferInfo3 = this.t;
            z2 = t0(j2, j3, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.W, this.w);
        } else {
            try {
                MediaCodec mediaCodec2 = this.z;
                ByteBuffer byteBuffer3 = this.V;
                int i4 = this.U;
                MediaCodec.BufferInfo bufferInfo4 = this.t;
                z2 = t0(j2, j3, mediaCodec2, byteBuffer3, i4, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.W, this.w);
            } catch (IllegalStateException unused2) {
                s0();
                if (this.d0) {
                    x0();
                }
                return false;
            }
        }
        if (z2) {
            q0(this.t.presentationTimeUs);
            boolean z3 = (this.t.flags & 4) != 0;
            B0();
            if (!z3) {
                return true;
            }
            s0();
        }
        return false;
    }

    private boolean W() {
        int i2;
        int i3;
        MediaCodec mediaCodec = this.z;
        if (mediaCodec == null || this.Z == 2 || this.c0) {
            return false;
        }
        if (this.T < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
            this.T = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.o.f4951d = h0(dequeueInputBuffer);
            this.o.f();
        }
        if (this.Z == 1) {
            if (!this.P) {
                this.b0 = true;
                this.z.queueInputBuffer(this.T, 0, 0, 0, 4);
                A0();
            }
            this.Z = 2;
            return false;
        } else if (this.N) {
            this.N = false;
            ByteBuffer byteBuffer = this.o.f4951d;
            byte[] bArr = h0;
            byteBuffer.put(bArr);
            this.z.queueInputBuffer(this.T, 0, bArr.length, 0, 0);
            A0();
            this.a0 = true;
            return true;
        } else {
            if (this.e0) {
                i3 = -4;
                i2 = 0;
            } else {
                if (this.Y == 1) {
                    for (int i4 = 0; i4 < this.u.f5979j.size(); i4++) {
                        this.o.f4951d.put(this.u.f5979j.get(i4));
                    }
                    this.Y = 2;
                }
                i2 = this.o.f4951d.position();
                i3 = H(this.q, this.o, false);
            }
            if (i3 == -3) {
                return false;
            }
            if (i3 == -5) {
                if (this.Y == 2) {
                    this.o.f();
                    this.Y = 1;
                }
                o0(this.q.f5981a);
                return true;
            } else if (this.o.j()) {
                if (this.Y == 2) {
                    this.o.f();
                    this.Y = 1;
                }
                this.c0 = true;
                if (!this.a0) {
                    s0();
                    return false;
                }
                try {
                    if (!this.P) {
                        this.b0 = true;
                        this.z.queueInputBuffer(this.T, 0, 0, 0, 4);
                        A0();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw ExoPlaybackException.a(e2, y());
                }
            } else if (!this.f0 || this.o.k()) {
                this.f0 = false;
                boolean p2 = this.o.p();
                boolean E0 = E0(p2);
                this.e0 = E0;
                if (E0) {
                    return false;
                }
                if (this.I && !p2) {
                    com.google.android.exoplayer2.util.q.b(this.o.f4951d);
                    if (this.o.f4951d.position() == 0) {
                        return true;
                    }
                    this.I = false;
                }
                try {
                    e eVar = this.o;
                    long j2 = eVar.f4952e;
                    if (eVar.i()) {
                        this.s.add(Long.valueOf(j2));
                    }
                    l lVar = this.v;
                    if (lVar != null) {
                        this.r.a(j2, lVar);
                        this.v = null;
                    }
                    this.o.o();
                    r0(this.o);
                    if (p2) {
                        this.z.queueSecureInputBuffer(this.T, 0, g0(this.o, i2), j2, 0);
                    } else {
                        this.z.queueInputBuffer(this.T, 0, this.o.f4951d.limit(), j2, 0);
                    }
                    A0();
                    this.a0 = true;
                    this.Y = 0;
                    this.g0.f4943c++;
                    return true;
                } catch (MediaCodec.CryptoException e3) {
                    throw ExoPlaybackException.a(e3, y());
                }
            } else {
                this.o.f();
                if (this.Y == 2) {
                    this.Y = 1;
                }
                return true;
            }
        }
    }

    private List<a> Y(boolean z2) {
        List<a> e02 = e0(this.f5982k, this.u, z2);
        if (e02.isEmpty() && z2) {
            e02 = e0(this.f5982k, this.u, false);
            if (!e02.isEmpty()) {
                com.google.android.exoplayer2.util.m.f("MediaCodecRenderer", "Drm session requires secure decoder for " + this.u.f5977h + ", but no secure decoder available. Trying to proceed with " + e02 + ".");
            }
        }
        return e02;
    }

    private void a0(MediaCodec mediaCodec) {
        if (d0.f7006a < 21) {
            this.Q = mediaCodec.getInputBuffers();
            this.R = mediaCodec.getOutputBuffers();
        }
    }

    private static MediaCodec.CryptoInfo g0(e eVar, int i2) {
        MediaCodec.CryptoInfo a2 = eVar.f4950c.a();
        if (i2 == 0) {
            return a2;
        }
        if (a2.numBytesOfClearData == null) {
            a2.numBytesOfClearData = new int[1];
        }
        int[] iArr = a2.numBytesOfClearData;
        iArr[0] = iArr[0] + i2;
        return a2;
    }

    private ByteBuffer h0(int i2) {
        if (d0.f7006a >= 21) {
            return this.z.getInputBuffer(i2);
        }
        return this.Q[i2];
    }

    private ByteBuffer i0(int i2) {
        if (d0.f7006a >= 21) {
            return this.z.getOutputBuffer(i2);
        }
        return this.R[i2];
    }

    private boolean j0() {
        return this.U >= 0;
    }

    private void k0(a aVar, MediaCrypto mediaCrypto) {
        String str = aVar.f5999a;
        G0();
        boolean z2 = this.B > this.n;
        MediaCodec mediaCodec = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b0.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            b0.c();
            b0.a("configureCodec");
            T(aVar, createByCodecName, this.u, mediaCrypto, z2 ? this.B : -1.0f);
            this.C = z2;
            b0.c();
            b0.a("startCodec");
            createByCodecName.start();
            b0.c();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            a0(createByCodecName);
            this.z = createByCodecName;
            this.F = aVar;
            n0(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Exception e2) {
            if (0 != 0) {
                z0();
                mediaCodec.release();
            }
            throw e2;
        }
    }

    private boolean l0(MediaCrypto mediaCrypto, boolean z2) {
        if (this.D == null) {
            try {
                this.D = new ArrayDeque<>(Y(z2));
                this.E = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(this.u, e2, z2, -49998);
            }
        }
        if (!this.D.isEmpty()) {
            do {
                a peekFirst = this.D.peekFirst();
                if (!C0(peekFirst)) {
                    return false;
                }
                try {
                    k0(peekFirst, mediaCrypto);
                    return true;
                } catch (Exception e3) {
                    com.google.android.exoplayer2.util.m.g("MediaCodecRenderer", "Failed to initialize decoder: " + peekFirst, e3);
                    this.D.removeFirst();
                    DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.u, e3, z2, peekFirst.f5999a);
                    if (this.E == null) {
                        this.E = decoderInitializationException;
                    } else {
                        this.E = this.E.d(decoderInitializationException);
                    }
                    if (this.D.isEmpty()) {
                        throw this.E;
                    }
                }
            } while (this.D.isEmpty());
            throw this.E;
        }
        throw new DecoderInitializationException(this.u, (Throwable) null, z2, -49999);
    }

    private void s0() {
        if (this.Z == 2) {
            x0();
            m0();
            return;
        }
        this.d0 = true;
        y0();
    }

    private void u0() {
        if (d0.f7006a < 21) {
            this.R = this.z.getOutputBuffers();
        }
    }

    private void v0() {
        MediaFormat outputFormat = this.z.getOutputFormat();
        if (this.G != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.O = true;
            return;
        }
        if (this.M) {
            outputFormat.setInteger("channel-count", 1);
        }
        p0(this.z, outputFormat);
    }

    private void w0() {
        this.D = null;
        if (this.a0) {
            this.Z = 1;
            return;
        }
        x0();
        m0();
    }

    private void z0() {
        if (d0.f7006a < 21) {
            this.Q = null;
            this.R = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void B() {
        this.u = null;
        this.D = null;
        try {
            x0();
            try {
                DrmSession<q> drmSession = this.x;
                if (drmSession != null) {
                    this.l.f(drmSession);
                }
                try {
                    DrmSession<q> drmSession2 = this.y;
                    if (!(drmSession2 == null || drmSession2 == this.x)) {
                        this.l.f(drmSession2);
                    }
                } finally {
                    this.x = null;
                    this.y = null;
                }
            } catch (Throwable th) {
                DrmSession<q> drmSession3 = this.y;
                if (!(drmSession3 == null || drmSession3 == this.x)) {
                    this.l.f(drmSession3);
                }
                throw th;
            } finally {
                this.x = null;
                this.y = null;
            }
        } catch (Throwable th2) {
            try {
                DrmSession<q> drmSession4 = this.y;
                if (!(drmSession4 == null || drmSession4 == this.x)) {
                    this.l.f(drmSession4);
                }
                throw th2;
            } finally {
                this.x = null;
                this.y = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void C(boolean z2) {
        this.g0 = new d();
    }

    /* access modifiers changed from: protected */
    public boolean C0(a aVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void D(long j2, boolean z2) {
        this.c0 = false;
        this.d0 = false;
        if (this.z != null) {
            X();
        }
        this.r.c();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void E() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void F() {
    }

    /* access modifiers changed from: protected */
    public abstract int F0(b bVar, m<q> mVar, l lVar);

    /* access modifiers changed from: protected */
    public final l H0(long j2) {
        l h2 = this.r.h(j2);
        if (h2 != null) {
            this.w = h2;
        }
        return h2;
    }

    /* access modifiers changed from: protected */
    public abstract int K(MediaCodec mediaCodec, a aVar, l lVar, l lVar2);

    /* access modifiers changed from: protected */
    public abstract void T(a aVar, MediaCodec mediaCodec, l lVar, MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public void X() {
        this.S = -9223372036854775807L;
        A0();
        B0();
        this.f0 = true;
        this.e0 = false;
        this.W = false;
        this.s.clear();
        this.N = false;
        this.O = false;
        if (this.J || (this.K && this.b0)) {
            x0();
            m0();
        } else if (this.Z != 0) {
            x0();
            m0();
        } else {
            this.z.flush();
            this.a0 = false;
        }
        if (this.X && this.u != null) {
            this.Y = 1;
        }
    }

    /* access modifiers changed from: protected */
    public final MediaCodec Z() {
        return this.z;
    }

    @Override // com.google.android.exoplayer2.y
    public final int a(l lVar) {
        try {
            return F0(this.f5982k, this.l, lVar);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw ExoPlaybackException.a(e2, y());
        }
    }

    @Override // com.google.android.exoplayer2.x
    public boolean b() {
        return this.d0;
    }

    /* access modifiers changed from: protected */
    public final a b0() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public boolean c0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract float d0(float f2, l lVar, l[] lVarArr);

    @Override // com.google.android.exoplayer2.x
    public boolean e() {
        return this.u != null && !this.e0 && (A() || j0() || (this.S != -9223372036854775807L && SystemClock.elapsedRealtime() < this.S));
    }

    /* access modifiers changed from: protected */
    public List<a> e0(b bVar, l lVar, boolean z2) {
        return bVar.b(lVar.f5977h, z2);
    }

    /* access modifiers changed from: protected */
    public long f0() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.y, com.google.android.exoplayer2.c
    public final int k() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.x
    public void l(long j2, long j3) {
        if (this.d0) {
            y0();
            return;
        }
        if (this.u == null) {
            this.p.f();
            int H2 = H(this.q, this.p, true);
            if (H2 == -5) {
                o0(this.q.f5981a);
            } else if (H2 == -4) {
                com.google.android.exoplayer2.util.e.f(this.p.j());
                this.c0 = true;
                s0();
                return;
            } else {
                return;
            }
        }
        m0();
        if (this.z != null) {
            b0.a("drainAndFeed");
            do {
            } while (V(j2, j3));
            do {
            } while (W());
            b0.c();
        } else {
            this.g0.f4944d += I(j2);
            this.p.f();
            int H3 = H(this.q, this.p, false);
            if (H3 == -5) {
                o0(this.q.f5981a);
            } else if (H3 == -4) {
                com.google.android.exoplayer2.util.e.f(this.p.j());
                this.c0 = true;
                s0();
            }
        }
        this.g0.a();
    }

    /* access modifiers changed from: protected */
    public final void m0() {
        l lVar;
        boolean z2;
        if (this.z == null && (lVar = this.u) != null) {
            DrmSession<q> drmSession = this.y;
            this.x = drmSession;
            String str = lVar.f5977h;
            MediaCrypto mediaCrypto = null;
            boolean z3 = false;
            if (drmSession != null) {
                q b2 = drmSession.b();
                if (b2 != null) {
                    mediaCrypto = b2.a();
                    z2 = b2.b(str);
                } else if (this.x.c() != null) {
                    z2 = false;
                } else {
                    return;
                }
                if (U()) {
                    int state = this.x.getState();
                    if (state == 1) {
                        throw ExoPlaybackException.a(this.x.c(), y());
                    } else if (state != 4) {
                        return;
                    }
                }
            } else {
                z2 = false;
            }
            try {
                if (l0(mediaCrypto, z2)) {
                    String str2 = this.F.f5999a;
                    this.G = L(str2);
                    this.H = S(str2);
                    this.I = M(str2, this.u);
                    this.J = Q(str2);
                    this.K = N(str2);
                    this.L = O(str2);
                    this.M = R(str2, this.u);
                    if (P(this.F) || c0()) {
                        z3 = true;
                    }
                    this.P = z3;
                    this.S = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    A0();
                    B0();
                    this.f0 = true;
                    this.g0.f4941a++;
                }
            } catch (DecoderInitializationException e2) {
                throw ExoPlaybackException.a(e2, y());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void n0(String str, long j2, long j3);

    @Override // com.google.android.exoplayer2.x, com.google.android.exoplayer2.c
    public final void o(float f2) {
        this.A = f2;
        G0();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (r6.n == r0.n) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o0(com.google.android.exoplayer2.l r6) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.o0(com.google.android.exoplayer2.l):void");
    }

    /* access modifiers changed from: protected */
    public abstract void p0(MediaCodec mediaCodec, MediaFormat mediaFormat);

    /* access modifiers changed from: protected */
    public abstract void q0(long j2);

    /* access modifiers changed from: protected */
    public abstract void r0(e eVar);

    /* access modifiers changed from: protected */
    public abstract boolean t0(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2, l lVar);

    /* access modifiers changed from: protected */
    public void x0() {
        this.S = -9223372036854775807L;
        A0();
        B0();
        this.e0 = false;
        this.W = false;
        this.s.clear();
        z0();
        this.F = null;
        this.X = false;
        this.a0 = false;
        this.I = false;
        this.J = false;
        this.G = 0;
        this.H = false;
        this.K = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.b0 = false;
        this.Y = 0;
        this.Z = 0;
        this.C = false;
        MediaCodec mediaCodec = this.z;
        if (mediaCodec != null) {
            this.g0.f4942b++;
            try {
                mediaCodec.stop();
                try {
                    this.z.release();
                    this.z = null;
                    DrmSession<q> drmSession = this.x;
                    if (drmSession != null && this.y != drmSession) {
                        try {
                            this.l.f(drmSession);
                        } finally {
                            this.x = null;
                        }
                    }
                } catch (Throwable th) {
                    this.z = null;
                    DrmSession<q> drmSession2 = this.x;
                    if (!(drmSession2 == null || this.y == drmSession2)) {
                        this.l.f(drmSession2);
                    }
                    throw th;
                } finally {
                    this.x = null;
                }
            } catch (Throwable th2) {
                this.z = null;
                DrmSession<q> drmSession3 = this.x;
                if (!(drmSession3 == null || this.y == drmSession3)) {
                    try {
                        this.l.f(drmSession3);
                    } finally {
                        this.x = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void y0() {
    }

    public static class DecoderInitializationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final String f5983b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5984c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5985d;

        /* renamed from: e  reason: collision with root package name */
        public final String f5986e;

        public DecoderInitializationException(l lVar, Throwable th, boolean z, int i2) {
            this("Decoder init failed: [" + i2 + "], " + lVar, th, lVar.f5977h, z, null, c(i2), null);
        }

        private static String c(int i2) {
            String str = i2 < 0 ? "neg_" : BuildConfig.FLAVOR;
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private DecoderInitializationException d(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.f5983b, this.f5984c, this.f5985d, this.f5986e, decoderInitializationException);
        }

        @TargetApi(21)
        private static String e(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(l lVar, Throwable th, boolean z, String str) {
            this("Decoder init failed: " + str + ", " + lVar, th, lVar.f5977h, z, str, d0.f7006a >= 21 ? e(th) : null, null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z, String str3, String str4, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.f5983b = str2;
            this.f5984c = z;
            this.f5985d = str3;
            this.f5986e = str4;
        }
    }
}
