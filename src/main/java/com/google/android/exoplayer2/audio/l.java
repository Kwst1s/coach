package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.lang.reflect.Method;

/* compiled from: AudioTrackPositionTracker */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final a f4802a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f4803b;

    /* renamed from: c  reason: collision with root package name */
    private AudioTrack f4804c;

    /* renamed from: d  reason: collision with root package name */
    private int f4805d;

    /* renamed from: e  reason: collision with root package name */
    private int f4806e;

    /* renamed from: f  reason: collision with root package name */
    private k f4807f;

    /* renamed from: g  reason: collision with root package name */
    private int f4808g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4809h;

    /* renamed from: i  reason: collision with root package name */
    private long f4810i;

    /* renamed from: j  reason: collision with root package name */
    private long f4811j;

    /* renamed from: k  reason: collision with root package name */
    private long f4812k;
    private Method l;
    private long m;
    private boolean n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;
    private int t;
    private int u;
    private long v;
    private long w;
    private long x;
    private long y;

    /* compiled from: AudioTrackPositionTracker */
    public interface a {
        void a(int i2, long j2);

        void b(long j2, long j3, long j4, long j5);

        void c(long j2, long j3, long j4, long j5);

        void d(long j2);
    }

    public l(a aVar) {
        e.e(aVar);
        this.f4802a = aVar;
        if (d0.f7006a >= 18) {
            try {
                this.l = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f4803b = new long[10];
    }

    private boolean a() {
        if (this.f4809h) {
            AudioTrack audioTrack = this.f4804c;
            e.e(audioTrack);
            return audioTrack.getPlayState() == 2 && e() == 0;
        }
    }

    private long b(long j2) {
        return (j2 * 1000000) / ((long) this.f4808g);
    }

    private long e() {
        AudioTrack audioTrack = this.f4804c;
        e.e(audioTrack);
        AudioTrack audioTrack2 = audioTrack;
        if (this.v != -9223372036854775807L) {
            return Math.min(this.y, this.x + ((((SystemClock.elapsedRealtime() * 1000) - this.v) * ((long) this.f4808g)) / 1000000));
        }
        int playState = audioTrack2.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack2.getPlaybackHeadPosition());
        if (this.f4809h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.s = this.q;
            }
            playbackHeadPosition += this.s;
        }
        if (d0.f7006a <= 28) {
            if (playbackHeadPosition == 0 && this.q > 0 && playState == 3) {
                if (this.w == -9223372036854775807L) {
                    this.w = SystemClock.elapsedRealtime();
                }
                return this.q;
            }
            this.w = -9223372036854775807L;
        }
        if (this.q > playbackHeadPosition) {
            this.r++;
        }
        this.q = playbackHeadPosition;
        return playbackHeadPosition + (this.r << 32);
    }

    private long f() {
        return b(e());
    }

    private void l(long j2, long j3) {
        k kVar = this.f4807f;
        e.e(kVar);
        k kVar2 = kVar;
        if (kVar2.f(j2)) {
            long c2 = kVar2.c();
            long b2 = kVar2.b();
            if (Math.abs(c2 - j2) > 5000000) {
                this.f4802a.c(b2, c2, j2, j3);
                kVar2.g();
            } else if (Math.abs(b(b2) - j3) > 5000000) {
                this.f4802a.b(b2, c2, j2, j3);
                kVar2.g();
            } else {
                kVar2.a();
            }
        }
    }

    private void m() {
        long f2 = f();
        if (f2 != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.f4812k >= 30000) {
                long[] jArr = this.f4803b;
                int i2 = this.t;
                jArr[i2] = f2 - nanoTime;
                this.t = (i2 + 1) % 10;
                int i3 = this.u;
                if (i3 < 10) {
                    this.u = i3 + 1;
                }
                this.f4812k = nanoTime;
                this.f4811j = 0;
                int i4 = 0;
                while (true) {
                    int i5 = this.u;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f4811j += this.f4803b[i4] / ((long) i5);
                    i4++;
                }
            }
            if (!this.f4809h) {
                l(nanoTime, f2);
                n(nanoTime);
            }
        }
    }

    private void n(long j2) {
        Method method;
        if (this.o && (method = this.l) != null && j2 - this.p >= 500000) {
            try {
                AudioTrack audioTrack = this.f4804c;
                e.e(audioTrack);
                Integer num = (Integer) method.invoke(audioTrack, new Object[0]);
                d0.f(num);
                long intValue = (((long) num.intValue()) * 1000) - this.f4810i;
                this.m = intValue;
                long max = Math.max(intValue, 0L);
                this.m = max;
                if (max > 5000000) {
                    this.f4802a.d(max);
                    this.m = 0;
                }
            } catch (Exception unused) {
                this.l = null;
            }
            this.p = j2;
        }
    }

    private static boolean o(int i2) {
        return d0.f7006a < 23 && (i2 == 5 || i2 == 6);
    }

    private void r() {
        this.f4811j = 0;
        this.u = 0;
        this.t = 0;
        this.f4812k = 0;
    }

    public int c(long j2) {
        return this.f4806e - ((int) (j2 - (e() * ((long) this.f4805d))));
    }

    public long d(boolean z) {
        long j2;
        AudioTrack audioTrack = this.f4804c;
        e.e(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            m();
        }
        long nanoTime = System.nanoTime() / 1000;
        k kVar = this.f4807f;
        e.e(kVar);
        k kVar2 = kVar;
        if (kVar2.d()) {
            long b2 = b(kVar2.b());
            if (!kVar2.e()) {
                return b2;
            }
            return b2 + (nanoTime - kVar2.c());
        }
        if (this.u == 0) {
            j2 = f();
        } else {
            j2 = nanoTime + this.f4811j;
        }
        return !z ? j2 - this.m : j2;
    }

    public void g(long j2) {
        this.x = e();
        this.v = SystemClock.elapsedRealtime() * 1000;
        this.y = j2;
    }

    public boolean h(long j2) {
        return j2 > e() || a();
    }

    public boolean i() {
        AudioTrack audioTrack = this.f4804c;
        e.e(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    public boolean j(long j2) {
        return this.w != -9223372036854775807L && j2 > 0 && SystemClock.elapsedRealtime() - this.w >= 200;
    }

    public boolean k(long j2) {
        a aVar;
        AudioTrack audioTrack = this.f4804c;
        e.e(audioTrack);
        int playState = audioTrack.getPlayState();
        if (this.f4809h) {
            if (playState == 2) {
                this.n = false;
                return false;
            } else if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z = this.n;
        boolean h2 = h(j2);
        this.n = h2;
        if (z && !h2 && playState != 1 && (aVar = this.f4802a) != null) {
            aVar.a(this.f4806e, d.b(this.f4810i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.v != -9223372036854775807L) {
            return false;
        }
        k kVar = this.f4807f;
        e.e(kVar);
        kVar.h();
        return true;
    }

    public void q() {
        r();
        this.f4804c = null;
        this.f4807f = null;
    }

    public void s(AudioTrack audioTrack, int i2, int i3, int i4) {
        this.f4804c = audioTrack;
        this.f4805d = i3;
        this.f4806e = i4;
        this.f4807f = new k(audioTrack);
        this.f4808g = audioTrack.getSampleRate();
        this.f4809h = o(i2);
        boolean N = d0.N(i2);
        this.o = N;
        this.f4810i = N ? b((long) (i4 / i3)) : -9223372036854775807L;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.n = false;
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.m = 0;
    }

    public void t() {
        k kVar = this.f4807f;
        e.e(kVar);
        kVar.h();
    }
}
