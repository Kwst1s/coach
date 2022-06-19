package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* compiled from: ResamplingAudioProcessor */
final class r implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f4834b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4835c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f4836d = 0;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f4837e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f4838f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4839g;

    public r() {
        ByteBuffer byteBuffer = AudioProcessor.f4729a;
        this.f4837e = byteBuffer;
        this.f4838f = byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.f4839g && this.f4838f == AudioProcessor.f4729a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        flush();
        this.f4834b = -1;
        this.f4835c = -1;
        this.f4836d = 0;
        this.f4837e = AudioProcessor.f4729a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f4838f;
        this.f4838f = AudioProcessor.f4729a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.f4838f = AudioProcessor.f4729a;
        this.f4839g = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        this.f4839g = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h() {
        int i2 = this.f4836d;
        return (i2 == 0 || i2 == 2) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[LOOP:2: B:23:0x0081->B:24:0x0083, LOOP_START, PHI: r0 
      PHI: (r0v2 int) = (r0v0 int), (r0v3 int) binds: [B:14:0x0041, B:24:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(java.nio.ByteBuffer r8) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.r.i(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int j() {
        return this.f4835c;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean k(int i2, int i3, int i4) {
        if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        } else if (this.f4834b == i2 && this.f4835c == i3 && this.f4836d == i4) {
            return false;
        } else {
            this.f4834b = i2;
            this.f4835c = i3;
            this.f4836d = i4;
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int l() {
        return this.f4834b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int m() {
        return 2;
    }
}
