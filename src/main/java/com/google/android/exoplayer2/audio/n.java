package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: ChannelMappingAudioProcessor */
final class n implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f4815b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4816c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int[] f4817d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4818e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f4819f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f4820g;

    /* renamed from: h  reason: collision with root package name */
    private ByteBuffer f4821h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4822i;

    public n() {
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4820g = byteBuffer;
        this.f4821h = byteBuffer;
    }

    public void a(int[] iArr) {
        this.f4817d = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.f4822i && this.f4821h == AudioProcessor.f4729a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        flush();
        this.f4820g = AudioProcessor.f4729a;
        this.f4815b = -1;
        this.f4816c = -1;
        this.f4819f = null;
        this.f4817d = null;
        this.f4818e = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f4821h;
        this.f4821h = AudioProcessor.f4729a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.f4821h = AudioProcessor.f4729a;
        this.f4822i = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        this.f4822i = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h() {
        return this.f4818e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        e.f(this.f4819f != null);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.f4815b * 2)) * this.f4819f.length * 2;
        if (this.f4820g.capacity() < length) {
            this.f4820g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f4820g.clear();
        }
        while (position < limit) {
            for (int i2 : this.f4819f) {
                this.f4820g.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f4815b * 2;
        }
        byteBuffer.position(limit);
        this.f4820g.flip();
        this.f4821h = this.f4820g;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int j() {
        int[] iArr = this.f4819f;
        return iArr == null ? this.f4815b : iArr.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean k(int i2, int i3, int i4) {
        boolean z = !Arrays.equals(this.f4817d, this.f4819f);
        int[] iArr = this.f4817d;
        this.f4819f = iArr;
        if (iArr == null) {
            this.f4818e = false;
            return z;
        } else if (i4 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        } else if (!z && this.f4816c == i2 && this.f4815b == i3) {
            return false;
        } else {
            this.f4816c = i2;
            this.f4815b = i3;
            this.f4818e = i3 != iArr.length;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f4819f;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 < i3) {
                    this.f4818e = (i6 != i5) | this.f4818e;
                    i5++;
                } else {
                    throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int l() {
        return this.f4816c;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int m() {
        return 2;
    }
}
