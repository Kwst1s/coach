package com.google.android.exoplayer2.h0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.d0.d;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.q;
import com.google.android.exoplayer2.h0.o;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.p;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
/* compiled from: MediaCodecVideoRenderer */
public class l extends MediaCodecRenderer {
    private static final int[] U0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean V0;
    private static boolean W0;
    private int A0;
    private int B0;
    private long C0;
    private int D0;
    private float E0 = -1.0f;
    private int F0 = -1;
    private int G0 = -1;
    private int H0;
    private float I0 = -1.0f;
    private int J0;
    private int K0;
    private int L0;
    private float M0;
    private boolean N0;
    private int O0;
    c P0;
    private long Q0 = -9223372036854775807L;
    private long R0 = -9223372036854775807L;
    private int S0;
    private m T0;
    private final Context i0;
    private final n j0;
    private final o.a k0;
    private final long l0;
    private final int m0;
    private final boolean n0 = M0();
    private final long[] o0 = new long[10];
    private final long[] p0 = new long[10];
    private b q0;
    private boolean r0;
    private Surface s0;
    private Surface t0;
    private int u0 = 1;
    private boolean v0;
    private long w0;
    private long x0 = -9223372036854775807L;
    private long y0;
    private int z0;

    /* access modifiers changed from: protected */
    /* compiled from: MediaCodecVideoRenderer */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f5898a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5899b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5900c;

        public b(int i2, int i3, int i4) {
            this.f5898a = i2;
            this.f5899b = i3;
            this.f5900c = i4;
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(23)
    /* compiled from: MediaCodecVideoRenderer */
    public final class c implements MediaCodec.OnFrameRenderedListener {
        public void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
            l lVar = l.this;
            if (this == lVar.P0) {
                lVar.c1(j2);
            }
        }

        private c(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    public l(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j2, m<q> mVar, boolean z, Handler handler, o oVar, int i2) {
        super(2, bVar, mVar, z, 30.0f);
        this.l0 = j2;
        this.m0 = i2;
        Context applicationContext = context.getApplicationContext();
        this.i0 = applicationContext;
        this.j0 = new n(applicationContext);
        this.k0 = new o.a(handler, oVar);
        J0();
    }

    private void I0() {
        MediaCodec Z;
        this.v0 = false;
        if (d0.f7006a >= 23 && this.N0 && (Z = Z()) != null) {
            this.P0 = new c(Z);
        }
    }

    private void J0() {
        this.J0 = -1;
        this.K0 = -1;
        this.M0 = -1.0f;
        this.L0 = -1;
    }

    @TargetApi(21)
    private static void L0(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private static boolean M0() {
        return d0.f7006a <= 22 && "foster".equals(d0.f7007b) && "NVIDIA".equals(d0.f7008c);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int O0(com.google.android.exoplayer2.mediacodec.a aVar, String str, int i2, int i3) {
        char c2;
        int i4;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        str.hashCode();
        int i5 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 2:
            case 4:
                i4 = i2 * i3;
                i5 = 2;
                break;
            case 1:
            case 5:
                i4 = i2 * i3;
                break;
            case 3:
                String str2 = d0.f7009d;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(d0.f7008c) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !aVar.f6004f)))) {
                    i4 = d0.h(i2, 16) * d0.h(i3, 16) * 16 * 16;
                    i5 = 2;
                    break;
                } else {
                    return -1;
                }
                break;
            default:
                return -1;
        }
        return (i4 * 3) / (i5 * 2);
    }

    private static Point P0(com.google.android.exoplayer2.mediacodec.a aVar, com.google.android.exoplayer2.l lVar) {
        int i2 = lVar.n;
        int i3 = lVar.m;
        boolean z = i2 > i3;
        int i4 = z ? i2 : i3;
        if (z) {
            i2 = i3;
        }
        float f2 = ((float) i2) / ((float) i4);
        int[] iArr = U0;
        for (int i5 : iArr) {
            int i6 = (int) (((float) i5) * f2);
            if (i5 <= i4 || i6 <= i2) {
                break;
            }
            if (d0.f7006a >= 21) {
                int i7 = z ? i6 : i5;
                if (!z) {
                    i5 = i6;
                }
                Point b2 = aVar.b(i7, i5);
                if (aVar.q(b2.x, b2.y, (double) lVar.o)) {
                    return b2;
                }
            } else {
                int h2 = d0.h(i5, 16) * 16;
                int h3 = d0.h(i6, 16) * 16;
                if (h2 * h3 <= MediaCodecUtil.m()) {
                    int i8 = z ? h3 : h2;
                    if (!z) {
                        h2 = h3;
                    }
                    return new Point(i8, h2);
                }
            }
        }
        return null;
    }

    private static int R0(com.google.android.exoplayer2.mediacodec.a aVar, com.google.android.exoplayer2.l lVar) {
        if (lVar.f5978i == -1) {
            return O0(aVar, lVar.f5977h, lVar.m, lVar.n);
        }
        int size = lVar.f5979j.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += lVar.f5979j.get(i3).length;
        }
        return lVar.f5978i + i2;
    }

    private static boolean T0(long j2) {
        return j2 < -30000;
    }

    private static boolean U0(long j2) {
        return j2 < -500000;
    }

    private void W0() {
        if (this.z0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.k0.c(this.z0, elapsedRealtime - this.y0);
            this.z0 = 0;
            this.y0 = elapsedRealtime;
        }
    }

    private void Y0() {
        int i2 = this.F0;
        if (i2 != -1 || this.G0 != -1) {
            if (this.J0 != i2 || this.K0 != this.G0 || this.L0 != this.H0 || this.M0 != this.I0) {
                this.k0.u(i2, this.G0, this.H0, this.I0);
                this.J0 = this.F0;
                this.K0 = this.G0;
                this.L0 = this.H0;
                this.M0 = this.I0;
            }
        }
    }

    private void Z0() {
        if (this.v0) {
            this.k0.t(this.s0);
        }
    }

    private void a1() {
        int i2 = this.J0;
        if (i2 != -1 || this.K0 != -1) {
            this.k0.u(i2, this.K0, this.L0, this.M0);
        }
    }

    private void b1(long j2, long j3, com.google.android.exoplayer2.l lVar) {
        m mVar = this.T0;
        if (mVar != null) {
            mVar.a(j2, j3, lVar);
        }
    }

    private void d1(MediaCodec mediaCodec, int i2, int i3) {
        this.F0 = i2;
        this.G0 = i3;
        float f2 = this.E0;
        this.I0 = f2;
        if (d0.f7006a >= 21) {
            int i4 = this.D0;
            if (i4 == 90 || i4 == 270) {
                this.F0 = i3;
                this.G0 = i2;
                this.I0 = 1.0f / f2;
            }
        } else {
            this.H0 = this.D0;
        }
        mediaCodec.setVideoScalingMode(this.u0);
    }

    private void g1() {
        this.x0 = this.l0 > 0 ? SystemClock.elapsedRealtime() + this.l0 : -9223372036854775807L;
    }

    @TargetApi(23)
    private static void h1(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private void i1(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.t0;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.mediacodec.a b0 = b0();
                if (b0 != null && m1(b0)) {
                    surface = j.m(this.i0, b0.f6004f);
                    this.t0 = surface;
                }
            }
        }
        if (this.s0 != surface) {
            this.s0 = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec Z = Z();
                if (d0.f7006a < 23 || Z == null || surface == null || this.r0) {
                    x0();
                    m0();
                } else {
                    h1(Z, surface);
                }
            }
            if (surface == null || surface == this.t0) {
                J0();
                I0();
                return;
            }
            a1();
            I0();
            if (state == 2) {
                g1();
            }
        } else if (surface != null && surface != this.t0) {
            a1();
            Z0();
        }
    }

    private boolean m1(com.google.android.exoplayer2.mediacodec.a aVar) {
        return d0.f7006a >= 23 && !this.N0 && !K0(aVar.f5999a) && (!aVar.f6004f || j.l(this.i0));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void B() {
        this.F0 = -1;
        this.G0 = -1;
        this.I0 = -1.0f;
        this.E0 = -1.0f;
        this.R0 = -9223372036854775807L;
        this.Q0 = -9223372036854775807L;
        this.S0 = 0;
        J0();
        I0();
        this.j0.d();
        this.P0 = null;
        this.N0 = false;
        try {
            super.B();
        } finally {
            this.g0.a();
            this.k0.b(this.g0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void C(boolean z) {
        super.C(z);
        int i2 = x().f7103a;
        this.O0 = i2;
        this.N0 = i2 != 0;
        this.k0.d(this.g0);
        this.j0.e();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean C0(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.s0 != null || m1(aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void D(long j2, boolean z) {
        super.D(j2, z);
        I0();
        this.w0 = -9223372036854775807L;
        this.A0 = 0;
        this.Q0 = -9223372036854775807L;
        int i2 = this.S0;
        if (i2 != 0) {
            this.R0 = this.o0[i2 - 1];
            this.S0 = 0;
        }
        if (z) {
            g1();
        } else {
            this.x0 = -9223372036854775807L;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void E() {
        super.E();
        this.z0 = 0;
        this.y0 = SystemClock.elapsedRealtime();
        this.C0 = SystemClock.elapsedRealtime() * 1000;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.c
    public void F() {
        this.x0 = -9223372036854775807L;
        W0();
        super.F();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int F0(com.google.android.exoplayer2.mediacodec.b bVar, m<q> mVar, com.google.android.exoplayer2.l lVar) {
        boolean z;
        int i2 = 0;
        if (!p.m(lVar.f5977h)) {
            return 0;
        }
        com.google.android.exoplayer2.drm.l lVar2 = lVar.f5980k;
        if (lVar2 != null) {
            z = false;
            for (int i3 = 0; i3 < lVar2.f5005e; i3++) {
                z |= lVar2.n(i3).f5011g;
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
        } else if (!com.google.android.exoplayer2.c.J(mVar, lVar2)) {
            return 2;
        } else {
            com.google.android.exoplayer2.mediacodec.a aVar = b2.get(0);
            boolean j2 = aVar.j(lVar);
            int i4 = aVar.k(lVar) ? 16 : 8;
            if (aVar.f6003e) {
                i2 = 32;
            }
            return (j2 ? 4 : 3) | i4 | i2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void G(com.google.android.exoplayer2.l[] lVarArr, long j2) {
        if (this.R0 == -9223372036854775807L) {
            this.R0 = j2;
        } else {
            int i2 = this.S0;
            if (i2 == this.o0.length) {
                com.google.android.exoplayer2.util.m.f("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.o0[this.S0 - 1]);
            } else {
                this.S0 = i2 + 1;
            }
            long[] jArr = this.o0;
            int i3 = this.S0;
            jArr[i3 - 1] = j2;
            this.p0[i3 - 1] = this.Q0;
        }
        super.G(lVarArr, j2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int K(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.a aVar, com.google.android.exoplayer2.l lVar, com.google.android.exoplayer2.l lVar2) {
        if (!aVar.l(lVar, lVar2, true)) {
            return 0;
        }
        int i2 = lVar2.m;
        b bVar = this.q0;
        if (i2 > bVar.f5898a || lVar2.n > bVar.f5899b || R0(aVar, lVar2) > this.q0.f5900c) {
            return 0;
        }
        if (lVar.I(lVar2)) {
            return 1;
        }
        return 3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x05c8 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean K0(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 2210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h0.l.K0(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public void N0(MediaCodec mediaCodec, int i2, long j2) {
        b0.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        b0.c();
        o1(1);
    }

    /* access modifiers changed from: protected */
    public b Q0(com.google.android.exoplayer2.mediacodec.a aVar, com.google.android.exoplayer2.l lVar, com.google.android.exoplayer2.l[] lVarArr) {
        int O02;
        int i2 = lVar.m;
        int i3 = lVar.n;
        int R02 = R0(aVar, lVar);
        if (lVarArr.length == 1) {
            if (!(R02 == -1 || (O02 = O0(aVar, lVar.f5977h, lVar.m, lVar.n)) == -1)) {
                R02 = Math.min((int) (((float) R02) * 1.5f), O02);
            }
            return new b(i2, i3, R02);
        }
        boolean z = false;
        for (com.google.android.exoplayer2.l lVar2 : lVarArr) {
            if (aVar.l(lVar, lVar2, false)) {
                int i4 = lVar2.m;
                z |= i4 == -1 || lVar2.n == -1;
                i2 = Math.max(i2, i4);
                i3 = Math.max(i3, lVar2.n);
                R02 = Math.max(R02, R0(aVar, lVar2));
            }
        }
        if (z) {
            com.google.android.exoplayer2.util.m.f("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3);
            Point P02 = P0(aVar, lVar);
            if (P02 != null) {
                i2 = Math.max(i2, P02.x);
                i3 = Math.max(i3, P02.y);
                R02 = Math.max(R02, O0(aVar, lVar.f5977h, i2, i3));
                com.google.android.exoplayer2.util.m.f("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i2 + "x" + i3);
            }
        }
        return new b(i2, i3, R02);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat S0(com.google.android.exoplayer2.l lVar, b bVar, float f2, boolean z, int i2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", lVar.f5977h);
        mediaFormat.setInteger("width", lVar.m);
        mediaFormat.setInteger("height", lVar.n);
        com.google.android.exoplayer2.mediacodec.c.e(mediaFormat, lVar.f5979j);
        com.google.android.exoplayer2.mediacodec.c.c(mediaFormat, "frame-rate", lVar.o);
        com.google.android.exoplayer2.mediacodec.c.d(mediaFormat, "rotation-degrees", lVar.p);
        com.google.android.exoplayer2.mediacodec.c.b(mediaFormat, lVar.t);
        mediaFormat.setInteger("max-width", bVar.f5898a);
        mediaFormat.setInteger("max-height", bVar.f5899b);
        com.google.android.exoplayer2.mediacodec.c.d(mediaFormat, "max-input-size", bVar.f5900c);
        if (d0.f7006a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (z) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            L0(mediaFormat, i2);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void T(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, com.google.android.exoplayer2.l lVar, MediaCrypto mediaCrypto, float f2) {
        b Q02 = Q0(aVar, lVar, z());
        this.q0 = Q02;
        MediaFormat S02 = S0(lVar, Q02, f2, this.n0, this.O0);
        if (this.s0 == null) {
            e.f(m1(aVar));
            if (this.t0 == null) {
                this.t0 = j.m(this.i0, aVar.f6004f);
            }
            this.s0 = this.t0;
        }
        mediaCodec.configure(S02, this.s0, mediaCrypto, 0);
        if (d0.f7006a >= 23 && this.N0) {
            this.P0 = new c(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public boolean V0(MediaCodec mediaCodec, int i2, long j2, long j3) {
        int I = I(j3);
        if (I == 0) {
            return false;
        }
        this.g0.f4949i++;
        o1(this.B0 + I);
        X();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void X() {
        super.X();
        this.B0 = 0;
    }

    /* access modifiers changed from: package-private */
    public void X0() {
        if (!this.v0) {
            this.v0 = true;
            this.k0.t(this.s0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean c0() {
        return this.N0;
    }

    /* access modifiers changed from: protected */
    public void c1(long j2) {
        com.google.android.exoplayer2.l H02 = H0(j2);
        if (H02 != null) {
            d1(Z(), H02.m, H02.n);
        }
        Y0();
        X0();
        q0(j2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float d0(float f2, com.google.android.exoplayer2.l lVar, com.google.android.exoplayer2.l[] lVarArr) {
        float f3 = -1.0f;
        for (com.google.android.exoplayer2.l lVar2 : lVarArr) {
            float f4 = lVar2.o;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.x
    public boolean e() {
        Surface surface;
        if (super.e() && (this.v0 || (((surface = this.t0) != null && this.s0 == surface) || Z() == null || this.N0))) {
            this.x0 = -9223372036854775807L;
            return true;
        } else if (this.x0 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.x0) {
                return true;
            }
            this.x0 = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void e1(MediaCodec mediaCodec, int i2, long j2) {
        Y0();
        b0.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        b0.c();
        this.C0 = SystemClock.elapsedRealtime() * 1000;
        this.g0.f4945e++;
        this.A0 = 0;
        X0();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void f1(MediaCodec mediaCodec, int i2, long j2, long j3) {
        Y0();
        b0.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        b0.c();
        this.C0 = SystemClock.elapsedRealtime() * 1000;
        this.g0.f4945e++;
        this.A0 = 0;
        X0();
    }

    /* access modifiers changed from: protected */
    public boolean j1(long j2, long j3) {
        return U0(j2);
    }

    /* access modifiers changed from: protected */
    public boolean k1(long j2, long j3) {
        return T0(j2);
    }

    /* access modifiers changed from: protected */
    public boolean l1(long j2, long j3) {
        return T0(j2) && j3 > 100000;
    }

    @Override // com.google.android.exoplayer2.v.b, com.google.android.exoplayer2.c
    public void m(int i2, Object obj) {
        if (i2 == 1) {
            i1((Surface) obj);
        } else if (i2 == 4) {
            this.u0 = ((Integer) obj).intValue();
            MediaCodec Z = Z();
            if (Z != null) {
                Z.setVideoScalingMode(this.u0);
            }
        } else if (i2 == 6) {
            this.T0 = (m) obj;
        } else {
            super.m(i2, obj);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void n0(String str, long j2, long j3) {
        this.k0.a(str, j2, j3);
        this.r0 = K0(str);
    }

    /* access modifiers changed from: protected */
    public void n1(MediaCodec mediaCodec, int i2, long j2) {
        b0.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        b0.c();
        this.g0.f4946f++;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void o0(com.google.android.exoplayer2.l lVar) {
        super.o0(lVar);
        this.k0.e(lVar);
        this.E0 = lVar.q;
        this.D0 = lVar.p;
    }

    /* access modifiers changed from: protected */
    public void o1(int i2) {
        d dVar = this.g0;
        dVar.f4947g += i2;
        this.z0 += i2;
        int i3 = this.A0 + i2;
        this.A0 = i3;
        dVar.f4948h = Math.max(i3, dVar.f4948h);
        int i4 = this.m0;
        if (i4 > 0 && this.z0 >= i4) {
            W0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void p0(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i2;
        int i3;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i2 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i2 = mediaFormat.getInteger("width");
        }
        if (z) {
            i3 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i3 = mediaFormat.getInteger("height");
        }
        d1(mediaCodec, i2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void q0(long j2) {
        this.B0--;
        while (true) {
            int i2 = this.S0;
            if (i2 != 0 && j2 >= this.p0[0]) {
                long[] jArr = this.o0;
                this.R0 = jArr[0];
                int i3 = i2 - 1;
                this.S0 = i3;
                System.arraycopy(jArr, 1, jArr, 0, i3);
                long[] jArr2 = this.p0;
                System.arraycopy(jArr2, 1, jArr2, 0, this.S0);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void r0(com.google.android.exoplayer2.d0.e eVar) {
        this.B0++;
        this.Q0 = Math.max(eVar.f4952e, this.Q0);
        if (d0.f7006a < 23 && this.N0) {
            c1(eVar.f4952e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean t0(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z, com.google.android.exoplayer2.l lVar) {
        if (this.w0 == -9223372036854775807L) {
            this.w0 = j2;
        }
        long j5 = j4 - this.R0;
        if (z) {
            n1(mediaCodec, i2, j5);
            return true;
        }
        long j6 = j4 - j2;
        if (this.s0 != this.t0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            boolean z2 = getState() == 2;
            if (!this.v0 || (z2 && l1(j6, elapsedRealtime - this.C0))) {
                long nanoTime = System.nanoTime();
                b1(j5, nanoTime, lVar);
                if (d0.f7006a >= 21) {
                    f1(mediaCodec, i2, j5, nanoTime);
                    return true;
                }
                e1(mediaCodec, i2, j5);
                return true;
            }
            if (z2 && j2 != this.w0) {
                long nanoTime2 = System.nanoTime();
                long b2 = this.j0.b(j4, ((j6 - (elapsedRealtime - j3)) * 1000) + nanoTime2);
                long j7 = (b2 - nanoTime2) / 1000;
                if (j1(j7, j3) && V0(mediaCodec, i2, j5, j2)) {
                    return false;
                }
                if (k1(j7, j3)) {
                    N0(mediaCodec, i2, j5);
                    return true;
                } else if (d0.f7006a >= 21) {
                    if (j7 < 50000) {
                        b1(j5, b2, lVar);
                        f1(mediaCodec, i2, j5, b2);
                        return true;
                    }
                } else if (j7 < 30000) {
                    if (j7 > 11000) {
                        try {
                            Thread.sleep((j7 - 10000) / 1000);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            return false;
                        }
                    }
                    b1(j5, b2, lVar);
                    e1(mediaCodec, i2, j5);
                    return true;
                }
            }
            return false;
        } else if (!T0(j6)) {
            return false;
        } else {
            n1(mediaCodec, i2, j5);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void x0() {
        try {
            super.x0();
            this.B0 = 0;
            Surface surface = this.t0;
            if (surface != null) {
                if (this.s0 == surface) {
                    this.s0 = null;
                }
                surface.release();
                this.t0 = null;
            }
        } catch (Throwable th) {
            this.B0 = 0;
            if (this.t0 != null) {
                Surface surface2 = this.s0;
                Surface surface3 = this.t0;
                if (surface2 == surface3) {
                    this.s0 = null;
                }
                surface3.release();
                this.t0 = null;
            }
            throw th;
        }
    }
}
