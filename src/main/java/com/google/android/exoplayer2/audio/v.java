package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: TrimmingAudioProcessor */
final class v implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private boolean f4871b;

    /* renamed from: c  reason: collision with root package name */
    private int f4872c;

    /* renamed from: d  reason: collision with root package name */
    private int f4873d;

    /* renamed from: e  reason: collision with root package name */
    private int f4874e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f4875f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f4876g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4877h;

    /* renamed from: i  reason: collision with root package name */
    private int f4878i;

    /* renamed from: j  reason: collision with root package name */
    private ByteBuffer f4879j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f4880k;
    private byte[] l = d0.f7011f;
    private int m;
    private boolean n;
    private long o;

    public v() {
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4879j = byteBuffer;
        this.f4880k = byteBuffer;
    }

    public long a() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.n && this.m == 0 && this.f4880k == AudioProcessor.f4729a;
    }

    public void c() {
        this.o = 0;
    }

    public void d(int i2, int i3) {
        this.f4872c = i2;
        this.f4873d = i3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        flush();
        this.f4879j = AudioProcessor.f4729a;
        this.f4874e = -1;
        this.f4875f = -1;
        this.l = d0.f7011f;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f4880k;
        if (this.n && this.m > 0 && byteBuffer == AudioProcessor.f4729a) {
            int capacity = this.f4879j.capacity();
            int i2 = this.m;
            if (capacity < i2) {
                this.f4879j = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
            } else {
                this.f4879j.clear();
            }
            this.f4879j.put(this.l, 0, this.m);
            this.m = 0;
            this.f4879j.flip();
            byteBuffer = this.f4879j;
        }
        this.f4880k = AudioProcessor.f4729a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.f4880k = AudioProcessor.f4729a;
        this.n = false;
        if (this.f4877h) {
            this.f4878i = 0;
        }
        this.m = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        this.n = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h() {
        return this.f4871b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            this.f4877h = true;
            int min = Math.min(i2, this.f4878i);
            this.o += (long) (min / this.f4876g);
            this.f4878i -= min;
            byteBuffer.position(position + min);
            if (this.f4878i <= 0) {
                int i3 = i2 - min;
                int length = (this.m + i3) - this.l.length;
                if (this.f4879j.capacity() < length) {
                    this.f4879j = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
                } else {
                    this.f4879j.clear();
                }
                int n2 = d0.n(length, 0, this.m);
                this.f4879j.put(this.l, 0, n2);
                int n3 = d0.n(length - n2, 0, i3);
                byteBuffer.limit(byteBuffer.position() + n3);
                this.f4879j.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - n3;
                int i5 = this.m - n2;
                this.m = i5;
                byte[] bArr = this.l;
                System.arraycopy(bArr, n2, bArr, 0, i5);
                byteBuffer.get(this.l, this.m, i4);
                this.m += i4;
                this.f4879j.flip();
                this.f4880k = this.f4879j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int j() {
        return this.f4874e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean k(int i2, int i3, int i4) {
        if (i4 == 2) {
            int i5 = this.m;
            if (i5 > 0) {
                this.o += (long) (i5 / this.f4876g);
            }
            this.f4874e = i3;
            this.f4875f = i2;
            int H = d0.H(2, i3);
            this.f4876g = H;
            int i6 = this.f4873d;
            this.l = new byte[(i6 * H)];
            this.m = 0;
            int i7 = this.f4872c;
            this.f4878i = H * i7;
            boolean z = this.f4871b;
            boolean z2 = (i7 == 0 && i6 == 0) ? false : true;
            this.f4871b = z2;
            this.f4877h = false;
            if (z != z2) {
                return true;
            }
            return false;
        }
        throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int l() {
        return this.f4875f;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int m() {
        return 2;
    }
}
