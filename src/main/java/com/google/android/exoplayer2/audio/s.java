package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: SilenceSkippingAudioProcessor */
public final class s implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f4840b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4841c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f4842d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4843e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f4844f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f4845g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4846h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f4847i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f4848j;

    /* renamed from: k  reason: collision with root package name */
    private int f4849k;
    private int l;
    private int m;
    private boolean n;
    private long o;

    public s() {
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4844f = byteBuffer;
        this.f4845g = byteBuffer;
        byte[] bArr = d0.f7011f;
        this.f4847i = bArr;
        this.f4848j = bArr;
    }

    private int a(long j2) {
        return (int) ((j2 * ((long) this.f4841c)) / 1000000);
    }

    private int c(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (Math.abs((int) byteBuffer.get(limit)) > 4) {
                int i2 = this.f4842d;
                return ((limit / i2) * i2) + i2;
            }
        }
        return byteBuffer.position();
    }

    private int d(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.get(position)) > 4) {
                int i2 = this.f4842d;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }

    private void o(ByteBuffer byteBuffer) {
        q(byteBuffer.remaining());
        this.f4844f.put(byteBuffer);
        this.f4844f.flip();
        this.f4845g = this.f4844f;
    }

    private void p(byte[] bArr, int i2) {
        q(i2);
        this.f4844f.put(bArr, 0, i2);
        this.f4844f.flip();
        this.f4845g = this.f4844f;
    }

    private void q(int i2) {
        if (this.f4844f.capacity() < i2) {
            this.f4844f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f4844f.clear();
        }
        if (i2 > 0) {
            this.n = true;
        }
    }

    private void r(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int d2 = d(byteBuffer);
        int position = d2 - byteBuffer.position();
        byte[] bArr = this.f4847i;
        int length = bArr.length;
        int i2 = this.l;
        int i3 = length - i2;
        if (d2 >= limit || position >= i3) {
            int min = Math.min(position, i3);
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer.get(this.f4847i, this.l, min);
            int i4 = this.l + min;
            this.l = i4;
            byte[] bArr2 = this.f4847i;
            if (i4 == bArr2.length) {
                if (this.n) {
                    p(bArr2, this.m);
                    this.o += (long) ((this.l - (this.m * 2)) / this.f4842d);
                } else {
                    this.o += (long) ((i4 - this.m) / this.f4842d);
                }
                v(byteBuffer, this.f4847i, this.l);
                this.l = 0;
                this.f4849k = 2;
            }
            byteBuffer.limit(limit);
            return;
        }
        p(bArr, i2);
        this.l = 0;
        this.f4849k = 0;
    }

    private void s(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f4847i.length));
        int c2 = c(byteBuffer);
        if (c2 == byteBuffer.position()) {
            this.f4849k = 1;
        } else {
            byteBuffer.limit(c2);
            o(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void t(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int d2 = d(byteBuffer);
        byteBuffer.limit(d2);
        this.o += (long) (byteBuffer.remaining() / this.f4842d);
        v(byteBuffer, this.f4848j, this.m);
        if (d2 < limit) {
            p(this.f4848j, this.m);
            this.f4849k = 0;
            byteBuffer.limit(limit);
        }
    }

    private void v(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int min = Math.min(byteBuffer.remaining(), this.m);
        int i3 = this.m - min;
        System.arraycopy(bArr, i2 - i3, this.f4848j, 0, i3);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f4848j, i3, min);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.f4846h && this.f4845g == AudioProcessor.f4729a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        this.f4843e = false;
        flush();
        this.f4844f = AudioProcessor.f4729a;
        this.f4840b = -1;
        this.f4841c = -1;
        this.m = 0;
        byte[] bArr = d0.f7011f;
        this.f4847i = bArr;
        this.f4848j = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f4845g;
        this.f4845g = AudioProcessor.f4729a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (h()) {
            int a2 = a(150000) * this.f4842d;
            if (this.f4847i.length != a2) {
                this.f4847i = new byte[a2];
            }
            int a3 = a(20000) * this.f4842d;
            this.m = a3;
            if (this.f4848j.length != a3) {
                this.f4848j = new byte[a3];
            }
        }
        this.f4849k = 0;
        this.f4845g = AudioProcessor.f4729a;
        this.f4846h = false;
        this.o = 0;
        this.l = 0;
        this.n = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        this.f4846h = true;
        int i2 = this.l;
        if (i2 > 0) {
            p(this.f4847i, i2);
        }
        if (!this.n) {
            this.o += (long) (this.m / this.f4842d);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h() {
        return this.f4841c != -1 && this.f4843e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.f4845g.hasRemaining()) {
            int i2 = this.f4849k;
            if (i2 == 0) {
                s(byteBuffer);
            } else if (i2 == 1) {
                r(byteBuffer);
            } else if (i2 == 2) {
                t(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int j() {
        return this.f4840b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean k(int i2, int i3, int i4) {
        if (i4 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        } else if (this.f4841c == i2 && this.f4840b == i3) {
            return false;
        } else {
            this.f4841c = i2;
            this.f4840b = i3;
            this.f4842d = i3 * 2;
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int l() {
        return this.f4841c;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int m() {
        return 2;
    }

    public long n() {
        return this.o;
    }

    public void u(boolean z) {
        this.f4843e = z;
        flush();
    }
}
