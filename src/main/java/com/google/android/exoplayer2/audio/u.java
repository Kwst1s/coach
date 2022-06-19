package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: SonicAudioProcessor */
public final class u implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f4861b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4862c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float f4863d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f4864e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f4865f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f4866g;

    /* renamed from: h  reason: collision with root package name */
    private t f4867h;

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f4868i;

    /* renamed from: j  reason: collision with root package name */
    private ShortBuffer f4869j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f4870k;
    private long l;
    private long m;
    private boolean n;

    public u() {
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4868i = byteBuffer;
        this.f4869j = byteBuffer.asShortBuffer();
        this.f4870k = byteBuffer;
        this.f4866g = -1;
    }

    public long a(long j2) {
        long j3 = this.m;
        if (j3 >= 1024) {
            int i2 = this.f4865f;
            int i3 = this.f4862c;
            if (i2 == i3) {
                return d0.Z(j2, this.l, j3);
            }
            return d0.Z(j2, this.l * ((long) i2), j3 * ((long) i3));
        }
        double d2 = (double) this.f4863d;
        double d3 = (double) j2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (long) (d2 * d3);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        t tVar;
        return this.n && ((tVar = this.f4867h) == null || tVar.j() == 0);
    }

    public float c(float f2) {
        float m2 = d0.m(f2, 0.1f, 8.0f);
        if (this.f4864e != m2) {
            this.f4864e = m2;
            this.f4867h = null;
        }
        flush();
        return m2;
    }

    public float d(float f2) {
        float m2 = d0.m(f2, 0.1f, 8.0f);
        if (this.f4863d != m2) {
            this.f4863d = m2;
            this.f4867h = null;
        }
        flush();
        return m2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        this.f4863d = 1.0f;
        this.f4864e = 1.0f;
        this.f4861b = -1;
        this.f4862c = -1;
        this.f4865f = -1;
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4868i = byteBuffer;
        this.f4869j = byteBuffer.asShortBuffer();
        this.f4870k = byteBuffer;
        this.f4866g = -1;
        this.f4867h = null;
        this.l = 0;
        this.m = 0;
        this.n = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f4870k;
        this.f4870k = AudioProcessor.f4729a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (h()) {
            t tVar = this.f4867h;
            if (tVar == null) {
                this.f4867h = new t(this.f4862c, this.f4861b, this.f4863d, this.f4864e, this.f4865f);
            } else {
                tVar.i();
            }
        }
        this.f4870k = AudioProcessor.f4729a;
        this.l = 0;
        this.m = 0;
        this.n = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        e.f(this.f4867h != null);
        this.f4867h.r();
        this.n = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h() {
        return this.f4862c != -1 && (Math.abs(this.f4863d - 1.0f) >= 0.01f || Math.abs(this.f4864e - 1.0f) >= 0.01f || this.f4865f != this.f4862c);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        e.f(this.f4867h != null);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.l += (long) remaining;
            this.f4867h.s(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int j2 = this.f4867h.j() * this.f4861b * 2;
        if (j2 > 0) {
            if (this.f4868i.capacity() < j2) {
                ByteBuffer order = ByteBuffer.allocateDirect(j2).order(ByteOrder.nativeOrder());
                this.f4868i = order;
                this.f4869j = order.asShortBuffer();
            } else {
                this.f4868i.clear();
                this.f4869j.clear();
            }
            this.f4867h.k(this.f4869j);
            this.m += (long) j2;
            this.f4868i.limit(j2);
            this.f4870k = this.f4868i;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int j() {
        return this.f4861b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean k(int i2, int i3, int i4) {
        if (i4 == 2) {
            int i5 = this.f4866g;
            if (i5 == -1) {
                i5 = i2;
            }
            if (this.f4862c == i2 && this.f4861b == i3 && this.f4865f == i5) {
                return false;
            }
            this.f4862c = i2;
            this.f4861b = i3;
            this.f4865f = i5;
            this.f4867h = null;
            return true;
        }
        throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int l() {
        return this.f4865f;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int m() {
        return 2;
    }
}
