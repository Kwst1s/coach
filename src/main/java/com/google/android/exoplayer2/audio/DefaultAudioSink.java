package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.l;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class DefaultAudioSink implements AudioSink {
    public static boolean a0 = false;
    public static boolean b0 = false;
    private long A;
    private ByteBuffer B;
    private int C;
    private int D;
    private long E;
    private long F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private long L;
    private float M;
    private AudioProcessor[] N;
    private ByteBuffer[] O;
    private ByteBuffer P;
    private ByteBuffer Q;
    private byte[] R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private int W;
    private m X;
    private boolean Y;
    private long Z;

    /* renamed from: a  reason: collision with root package name */
    private final i f4730a;

    /* renamed from: b  reason: collision with root package name */
    private final c f4731b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4732c;

    /* renamed from: d  reason: collision with root package name */
    private final n f4733d;

    /* renamed from: e  reason: collision with root package name */
    private final v f4734e;

    /* renamed from: f  reason: collision with root package name */
    private final AudioProcessor[] f4735f;

    /* renamed from: g  reason: collision with root package name */
    private final AudioProcessor[] f4736g;

    /* renamed from: h  reason: collision with root package name */
    private final ConditionVariable f4737h;

    /* renamed from: i  reason: collision with root package name */
    private final l f4738i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque<e> f4739j;

    /* renamed from: k  reason: collision with root package name */
    private AudioSink.a f4740k;
    private AudioTrack l;
    private AudioTrack m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private h t;
    private boolean u;
    private boolean v;
    private int w;
    private s x;
    private s y;
    private long z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        /* synthetic */ InvalidAudioTrackTimestampException(String str, a aVar) {
            this(str);
        }

        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AudioTrack f4741b;

        a(AudioTrack audioTrack) {
            this.f4741b = audioTrack;
        }

        public void run() {
            try {
                this.f4741b.flush();
                this.f4741b.release();
            } finally {
                DefaultAudioSink.this.f4737h.open();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends Thread {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AudioTrack f4743b;

        b(DefaultAudioSink defaultAudioSink, AudioTrack audioTrack) {
            this.f4743b = audioTrack;
        }

        public void run() {
            this.f4743b.release();
        }
    }

    public interface c {
        s a(s sVar);

        long b();

        long c(long j2);

        AudioProcessor[] d();
    }

    public static class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final AudioProcessor[] f4744a;

        /* renamed from: b  reason: collision with root package name */
        private final s f4745b;

        /* renamed from: c  reason: collision with root package name */
        private final u f4746c;

        public d(AudioProcessor... audioProcessorArr) {
            AudioProcessor[] audioProcessorArr2 = (AudioProcessor[]) Arrays.copyOf(audioProcessorArr, audioProcessorArr.length + 2);
            this.f4744a = audioProcessorArr2;
            s sVar = new s();
            this.f4745b = sVar;
            u uVar = new u();
            this.f4746c = uVar;
            audioProcessorArr2[audioProcessorArr.length] = sVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = uVar;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public s a(s sVar) {
            this.f4745b.u(sVar.f6055c);
            return new s(this.f4746c.d(sVar.f6053a), this.f4746c.c(sVar.f6054b), sVar.f6055c);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public long b() {
            return this.f4745b.n();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public long c(long j2) {
            return this.f4746c.a(j2);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public AudioProcessor[] d() {
            return this.f4744a;
        }
    }

    /* access modifiers changed from: private */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private final s f4747a;

        /* renamed from: b  reason: collision with root package name */
        private final long f4748b;

        /* renamed from: c  reason: collision with root package name */
        private final long f4749c;

        /* synthetic */ e(s sVar, long j2, long j3, a aVar) {
            this(sVar, j2, j3);
        }

        private e(s sVar, long j2, long j3) {
            this.f4747a = sVar;
            this.f4748b = j2;
            this.f4749c = j3;
        }
    }

    private final class f implements l.a {
        private f() {
        }

        @Override // com.google.android.exoplayer2.audio.l.a
        public void a(int i2, long j2) {
            if (DefaultAudioSink.this.f4740k != null) {
                DefaultAudioSink.this.f4740k.b(i2, j2, SystemClock.elapsedRealtime() - DefaultAudioSink.this.Z);
            }
        }

        @Override // com.google.android.exoplayer2.audio.l.a
        public void b(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.L() + ", " + DefaultAudioSink.this.M();
            if (!DefaultAudioSink.b0) {
                m.f("AudioTrack", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str, null);
        }

        @Override // com.google.android.exoplayer2.audio.l.a
        public void c(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.L() + ", " + DefaultAudioSink.this.M();
            if (!DefaultAudioSink.b0) {
                m.f("AudioTrack", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str, null);
        }

        @Override // com.google.android.exoplayer2.audio.l.a
        public void d(long j2) {
            m.f("AudioTrack", "Ignoring impossibly large audio latency: " + j2);
        }

        /* synthetic */ f(DefaultAudioSink defaultAudioSink, a aVar) {
            this();
        }
    }

    public DefaultAudioSink(i iVar, AudioProcessor[] audioProcessorArr) {
        this(iVar, audioProcessorArr, false);
    }

    private long A(long j2) {
        long j3;
        long D2;
        e eVar = null;
        while (!this.f4739j.isEmpty() && j2 >= this.f4739j.getFirst().f4749c) {
            eVar = this.f4739j.remove();
        }
        if (eVar != null) {
            this.y = eVar.f4747a;
            this.A = eVar.f4749c;
            this.z = eVar.f4748b - this.L;
        }
        if (this.y.f6053a == 1.0f) {
            return (j2 + this.z) - this.A;
        }
        if (this.f4739j.isEmpty()) {
            j3 = this.z;
            D2 = this.f4731b.c(j2 - this.A);
        } else {
            j3 = this.z;
            D2 = d0.D(j2 - this.A, this.y.f6053a);
        }
        return j3 + D2;
    }

    @TargetApi(21)
    private AudioTrack B() {
        AudioAttributes audioAttributes;
        if (this.Y) {
            audioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributes = this.t.a();
        }
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.r).setEncoding(this.s).setSampleRate(this.q).build();
        int i2 = this.W;
        return new AudioTrack(audioAttributes, build, this.w, 1, i2 != 0 ? i2 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean C() {
        /*
            r9 = this;
            int r0 = r9.T
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.u
            if (r0 == 0) goto L_0x000d
            r0 = 0
            goto L_0x0010
        L_0x000d:
            com.google.android.exoplayer2.audio.AudioProcessor[] r0 = r9.N
            int r0 = r0.length
        L_0x0010:
            r9.T = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.T
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.N
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.g()
        L_0x0028:
            r9.S(r7)
            boolean r0 = r4.b()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.T
            int r0 = r0 + r2
            r9.T = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.Q
            if (r0 == 0) goto L_0x0044
            r9.Y(r0, r7)
            java.nio.ByteBuffer r0 = r9.Q
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.T = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.C():boolean");
    }

    private long D(long j2) {
        return (j2 * ((long) this.q)) / 1000000;
    }

    private void E() {
        int i2 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.N;
            if (i2 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                audioProcessor.flush();
                this.O[i2] = audioProcessor.f();
                i2++;
            } else {
                return;
            }
        }
    }

    private long F(long j2) {
        return (j2 * 1000000) / ((long) this.q);
    }

    private AudioProcessor[] G() {
        return this.o ? this.f4736g : this.f4735f;
    }

    private static int H(int i2, boolean z2) {
        int i3 = d0.f7006a;
        if (i3 <= 28 && !z2) {
            if (i2 == 7) {
                i2 = 8;
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                i2 = 6;
            }
        }
        if (i3 <= 26 && "fugu".equals(d0.f7007b) && !z2 && i2 == 1) {
            i2 = 2;
        }
        return d0.v(i2);
    }

    private int I() {
        if (this.n) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.q, this.r, this.s);
            com.google.android.exoplayer2.util.e.f(minBufferSize != -2);
            return d0.n(minBufferSize * 4, ((int) D(250000)) * this.G, (int) Math.max((long) minBufferSize, D(750000) * ((long) this.G)));
        }
        int K2 = K(this.s);
        if (this.s == 5) {
            K2 *= 2;
        }
        return (int) ((((long) K2) * 250000) / 1000000);
    }

    private static int J(int i2, ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return o.e(byteBuffer);
        }
        if (i2 == 5) {
            return g.b();
        }
        if (i2 == 6) {
            return g.h(byteBuffer);
        }
        if (i2 == 14) {
            int a2 = g.a(byteBuffer);
            if (a2 == -1) {
                return 0;
            }
            return g.i(byteBuffer, a2) * 16;
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i2);
    }

    private static int K(int i2) {
        if (i2 == 5) {
            return 80000;
        }
        if (i2 == 6) {
            return 768000;
        }
        if (i2 == 7) {
            return 192000;
        }
        if (i2 == 8) {
            return 2250000;
        }
        if (i2 == 14) {
            return 3062500;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long L() {
        return this.n ? this.E / ((long) this.D) : this.F;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long M() {
        return this.n ? this.H / ((long) this.G) : this.I;
    }

    private void N() {
        this.f4737h.block();
        AudioTrack O2 = O();
        this.m = O2;
        int audioSessionId = O2.getAudioSessionId();
        if (a0 && d0.f7006a < 21) {
            AudioTrack audioTrack = this.l;
            if (!(audioTrack == null || audioSessionId == audioTrack.getAudioSessionId())) {
                T();
            }
            if (this.l == null) {
                this.l = P(audioSessionId);
            }
        }
        if (this.W != audioSessionId) {
            this.W = audioSessionId;
            AudioSink.a aVar = this.f4740k;
            if (aVar != null) {
                aVar.d(audioSessionId);
            }
        }
        this.y = this.v ? this.f4731b.a(this.y) : s.f6052e;
        X();
        this.f4738i.s(this.m, this.s, this.G, this.w);
        U();
        int i2 = this.X.f4813a;
        if (i2 != 0) {
            this.m.attachAuxEffect(i2);
            this.m.setAuxEffectSendLevel(this.X.f4814b);
        }
    }

    private AudioTrack O() {
        AudioTrack audioTrack;
        if (d0.f7006a >= 21) {
            audioTrack = B();
        } else {
            int J2 = d0.J(this.t.f4781c);
            if (this.W == 0) {
                audioTrack = new AudioTrack(J2, this.q, this.r, this.s, this.w, 1);
            } else {
                audioTrack = new AudioTrack(J2, this.q, this.r, this.s, this.w, 1, this.W);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new AudioSink.InitializationException(state, this.q, this.r, this.w);
    }

    private AudioTrack P(int i2) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i2);
    }

    private long Q(long j2) {
        return (j2 * 1000000) / ((long) this.p);
    }

    private boolean R() {
        return this.m != null;
    }

    private void S(long j2) {
        ByteBuffer byteBuffer;
        int length = this.N.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.O[i2 - 1];
            } else {
                byteBuffer = this.P;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f4729a;
                }
            }
            if (i2 == length) {
                Y(byteBuffer, j2);
            } else {
                AudioProcessor audioProcessor = this.N[i2];
                audioProcessor.i(byteBuffer);
                ByteBuffer f2 = audioProcessor.f();
                this.O[i2] = f2;
                if (f2.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    private void T() {
        AudioTrack audioTrack = this.l;
        if (audioTrack != null) {
            this.l = null;
            new b(this, audioTrack).start();
        }
    }

    private void U() {
        if (R()) {
            if (d0.f7006a >= 21) {
                V(this.m, this.M);
            } else {
                W(this.m, this.M);
            }
        }
    }

    @TargetApi(21)
    private static void V(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void W(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void X() {
        ArrayList arrayList = new ArrayList();
        AudioProcessor[] G2 = G();
        for (AudioProcessor audioProcessor : G2) {
            if (audioProcessor.h()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.N = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.O = new ByteBuffer[size];
        E();
    }

    private void Y(ByteBuffer byteBuffer, long j2) {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.Q;
            boolean z2 = true;
            int i2 = 0;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.e.a(byteBuffer2 == byteBuffer);
            } else {
                this.Q = byteBuffer;
                if (d0.f7006a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.R;
                    if (bArr == null || bArr.length < remaining) {
                        this.R = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.R, 0, remaining);
                    byteBuffer.position(position);
                    this.S = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (d0.f7006a < 21) {
                int c2 = this.f4738i.c(this.H);
                if (c2 > 0 && (i2 = this.m.write(this.R, this.S, Math.min(remaining2, c2))) > 0) {
                    this.S += i2;
                    byteBuffer.position(byteBuffer.position() + i2);
                }
            } else if (this.Y) {
                if (j2 == -9223372036854775807L) {
                    z2 = false;
                }
                com.google.android.exoplayer2.util.e.f(z2);
                i2 = a0(this.m, byteBuffer, remaining2, j2);
            } else {
                i2 = Z(this.m, byteBuffer, remaining2);
            }
            this.Z = SystemClock.elapsedRealtime();
            if (i2 >= 0) {
                boolean z3 = this.n;
                if (z3) {
                    this.H += (long) i2;
                }
                if (i2 == remaining2) {
                    if (!z3) {
                        this.I += (long) this.J;
                    }
                    this.Q = null;
                    return;
                }
                return;
            }
            throw new AudioSink.WriteException(i2);
        }
    }

    @TargetApi(21)
    private static int Z(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @TargetApi(21)
    private int a0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.B == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.B = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.B.putInt(1431633921);
        }
        if (this.C == 0) {
            this.B.putInt(4, i2);
            this.B.putLong(8, j2 * 1000);
            this.B.position(0);
            this.C = i2;
        }
        int remaining = this.B.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.B, remaining, 1);
            if (write < 0) {
                this.C = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int Z2 = Z(audioTrack, byteBuffer, i2);
        if (Z2 < 0) {
            this.C = 0;
            return Z2;
        }
        this.C -= Z2;
        return Z2;
    }

    private long z(long j2) {
        return j2 + F(this.f4731b.b());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a() {
        e();
        T();
        for (AudioProcessor audioProcessor : this.f4735f) {
            audioProcessor.e();
        }
        for (AudioProcessor audioProcessor2 : this.f4736g) {
            audioProcessor2.e();
        }
        this.W = 0;
        this.V = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return !R() || (this.U && !i());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c() {
        this.V = false;
        if (R() && this.f4738i.p()) {
            this.m.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public s d() {
        return this.y;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e() {
        if (R()) {
            this.E = 0;
            this.F = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            s sVar = this.x;
            if (sVar != null) {
                this.y = sVar;
                this.x = null;
            } else if (!this.f4739j.isEmpty()) {
                this.y = this.f4739j.getLast().f4747a;
            }
            this.f4739j.clear();
            this.z = 0;
            this.A = 0;
            this.f4734e.c();
            this.P = null;
            this.Q = null;
            E();
            this.U = false;
            this.T = -1;
            this.B = null;
            this.C = 0;
            this.K = 0;
            if (this.f4738i.i()) {
                this.m.pause();
            }
            AudioTrack audioTrack = this.m;
            this.m = null;
            this.f4738i.q();
            this.f4737h.close();
            new a(audioTrack).start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public s f(s sVar) {
        if (!R() || this.v) {
            s sVar2 = this.x;
            if (sVar2 == null) {
                sVar2 = !this.f4739j.isEmpty() ? this.f4739j.getLast().f4747a : this.y;
            }
            if (!sVar.equals(sVar2)) {
                if (R()) {
                    this.x = sVar;
                } else {
                    this.y = this.f4731b.a(sVar);
                }
            }
            return this.y;
        }
        s sVar3 = s.f6052e;
        this.y = sVar3;
        return sVar3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7) {
        this.p = i4;
        this.n = d0.N(i2);
        boolean z2 = true;
        int i8 = 0;
        this.o = this.f4732c && o(1073741824) && d0.M(i2);
        if (this.n) {
            this.D = d0.H(i2, i3);
        }
        boolean z3 = this.n && i2 != 4;
        if (!z3 || this.o) {
            z2 = false;
        }
        this.v = z2;
        if (d0.f7006a < 21 && i3 == 8 && iArr == null) {
            int[] iArr2 = new int[6];
            for (int i9 = 0; i9 < 6; i9++) {
                iArr2[i9] = i9;
            }
            iArr = iArr2;
        }
        if (z3) {
            this.f4734e.d(i6, i7);
            this.f4733d.a(iArr);
            AudioProcessor[] G2 = G();
            int length = G2.length;
            int i10 = 0;
            while (i8 < length) {
                AudioProcessor audioProcessor = G2[i8];
                try {
                    i10 |= audioProcessor.k(i4, i3, i2);
                    if (audioProcessor.h()) {
                        i3 = audioProcessor.j();
                        i4 = audioProcessor.l();
                        i2 = audioProcessor.m();
                    }
                    i8++;
                } catch (AudioProcessor.UnhandledFormatException e2) {
                    throw new AudioSink.ConfigurationException(e2);
                }
            }
            i8 = i10;
        }
        int H2 = H(i3, this.n);
        if (H2 == 0) {
            throw new AudioSink.ConfigurationException("Unsupported channel count: " + i3);
        } else if (i8 != 0 || !R() || this.s != i2 || this.q != i4 || this.r != H2) {
            e();
            this.u = z3;
            this.q = i4;
            this.r = H2;
            this.s = i2;
            this.G = this.n ? d0.H(i2, i3) : -1;
            if (i5 == 0) {
                i5 = I();
            }
            this.w = i5;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h() {
        if (!this.U && R() && C()) {
            this.f4738i.g(M());
            this.m.stop();
            this.C = 0;
            this.U = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean i() {
        return R() && this.f4738i.h(M());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j() {
        this.V = true;
        if (R()) {
            this.f4738i.t();
            this.m.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long k(boolean z2) {
        if (!R() || this.K == 0) {
            return Long.MIN_VALUE;
        }
        return this.L + z(A(Math.min(this.f4738i.d(z2), F(M()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l() {
        if (this.Y) {
            this.Y = false;
            this.W = 0;
            e();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m(AudioSink.a aVar) {
        this.f4740k = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void n(h hVar) {
        if (!this.t.equals(hVar)) {
            this.t = hVar;
            if (!this.Y) {
                e();
                this.W = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean o(int i2) {
        if (!d0.N(i2)) {
            i iVar = this.f4730a;
            if (iVar == null || !iVar.c(i2)) {
                return false;
            }
            return true;
        } else if (i2 != 4 || d0.f7006a >= 21) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p(m mVar) {
        if (!this.X.equals(mVar)) {
            int i2 = mVar.f4813a;
            float f2 = mVar.f4814b;
            AudioTrack audioTrack = this.m;
            if (audioTrack != null) {
                if (this.X.f4813a != i2) {
                    audioTrack.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.m.setAuxEffectSendLevel(f2);
                }
            }
            this.X = mVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void q() {
        if (this.K == 1) {
            this.K = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void r(float f2) {
        if (this.M != f2) {
            this.M = f2;
            U();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean s(ByteBuffer byteBuffer, long j2) {
        ByteBuffer byteBuffer2 = this.P;
        com.google.android.exoplayer2.util.e.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!R()) {
            N();
            if (this.V) {
                j();
            }
        }
        if (!this.f4738i.k(M())) {
            return false;
        }
        if (this.P == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.n && this.J == 0) {
                int J2 = J(this.s, byteBuffer);
                this.J = J2;
                if (J2 == 0) {
                    return true;
                }
            }
            if (this.x != null) {
                if (!C()) {
                    return false;
                }
                s sVar = this.x;
                this.x = null;
                this.f4739j.add(new e(this.f4731b.a(sVar), Math.max(0L, j2), F(M()), null));
                X();
            }
            if (this.K == 0) {
                this.L = Math.max(0L, j2);
                this.K = 1;
            } else {
                long Q2 = this.L + Q(L() - this.f4734e.a());
                if (this.K == 1 && Math.abs(Q2 - j2) > 200000) {
                    m.c("AudioTrack", "Discontinuity detected [expected " + Q2 + ", got " + j2 + "]");
                    this.K = 2;
                }
                if (this.K == 2) {
                    long j3 = j2 - Q2;
                    this.L += j3;
                    this.K = 1;
                    AudioSink.a aVar = this.f4740k;
                    if (!(aVar == null || j3 == 0)) {
                        aVar.a();
                    }
                }
            }
            if (this.n) {
                this.E += (long) byteBuffer.remaining();
            } else {
                this.F += (long) this.J;
            }
            this.P = byteBuffer;
        }
        if (this.u) {
            S(j2);
        } else {
            Y(this.P, j2);
        }
        if (!this.P.hasRemaining()) {
            this.P = null;
            return true;
        } else if (!this.f4738i.j(M())) {
            return false;
        } else {
            m.f("AudioTrack", "Resetting stalled audio track");
            e();
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t(int i2) {
        com.google.android.exoplayer2.util.e.f(d0.f7006a >= 21);
        if (!this.Y || this.W != i2) {
            this.Y = true;
            this.W = i2;
            e();
        }
    }

    public DefaultAudioSink(i iVar, AudioProcessor[] audioProcessorArr, boolean z2) {
        this(iVar, new d(audioProcessorArr), z2);
    }

    public DefaultAudioSink(i iVar, c cVar, boolean z2) {
        this.f4730a = iVar;
        com.google.android.exoplayer2.util.e.e(cVar);
        this.f4731b = cVar;
        this.f4732c = z2;
        this.f4737h = new ConditionVariable(true);
        this.f4738i = new l(new f(this, null));
        n nVar = new n();
        this.f4733d = nVar;
        v vVar = new v();
        this.f4734e = vVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new r(), nVar, vVar);
        Collections.addAll(arrayList, cVar.d());
        this.f4735f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[arrayList.size()]);
        this.f4736g = new AudioProcessor[]{new p()};
        this.M = 1.0f;
        this.K = 0;
        this.t = h.f4778e;
        this.W = 0;
        this.X = new m(0, Utils.FLOAT_EPSILON);
        this.y = s.f6052e;
        this.T = -1;
        this.N = new AudioProcessor[0];
        this.O = new ByteBuffer[0];
        this.f4739j = new ArrayDeque<>();
    }
}
