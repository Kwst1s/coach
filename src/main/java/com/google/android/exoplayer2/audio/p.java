package com.google.android.exoplayer2.audio;

import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: FloatResamplingAudioProcessor */
final class p implements AudioProcessor {

    /* renamed from: h  reason: collision with root package name */
    private static final int f4826h = Float.floatToIntBits(Float.NaN);

    /* renamed from: b  reason: collision with root package name */
    private int f4827b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4828c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f4829d = 0;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f4830e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f4831f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4832g;

    public p() {
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4830e = byteBuffer;
        this.f4831f = byteBuffer;
    }

    private static void a(int i2, ByteBuffer byteBuffer) {
        double d2 = (double) i2;
        Double.isNaN(d2);
        int floatToIntBits = Float.floatToIntBits((float) (d2 * 4.656612875245797E-10d));
        if (floatToIntBits == f4826h) {
            floatToIntBits = Float.floatToIntBits(Utils.FLOAT_EPSILON);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.f4832g && this.f4831f == AudioProcessor.f4729a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        flush();
        this.f4827b = -1;
        this.f4828c = -1;
        this.f4829d = 0;
        this.f4830e = AudioProcessor.f4729a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f4831f;
        this.f4831f = AudioProcessor.f4729a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.f4831f = AudioProcessor.f4729a;
        this.f4832g = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        this.f4832g = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h() {
        return d0.M(this.f4829d);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        boolean z = this.f4829d == 1073741824;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (!z) {
            i2 = (i2 / 3) * 4;
        }
        if (this.f4830e.capacity() < i2) {
            this.f4830e = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f4830e.clear();
        }
        if (z) {
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), this.f4830e);
                position += 4;
            }
        } else {
            while (position < limit) {
                a(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), this.f4830e);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f4830e.flip();
        this.f4831f = this.f4830e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int j() {
        return this.f4828c;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean k(int i2, int i3, int i4) {
        if (!d0.M(i4)) {
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        } else if (this.f4827b == i2 && this.f4828c == i3 && this.f4829d == i4) {
            return false;
        } else {
            this.f4827b = i2;
            this.f4828c = i3;
            this.f4829d = i4;
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int l() {
        return this.f4827b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int m() {
        return 4;
    }
}
