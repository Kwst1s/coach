package com.google.android.exoplayer2.d0;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.d0;

/* compiled from: CryptoInfo */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4929a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f4930b;

    /* renamed from: c  reason: collision with root package name */
    public int f4931c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f4932d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f4933e;

    /* renamed from: f  reason: collision with root package name */
    public int f4934f;

    /* renamed from: g  reason: collision with root package name */
    public int f4935g;

    /* renamed from: h  reason: collision with root package name */
    public int f4936h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaCodec.CryptoInfo f4937i;

    /* renamed from: j  reason: collision with root package name */
    private final C0120b f4938j;

    /* access modifiers changed from: private */
    @TargetApi(24)
    /* renamed from: com.google.android.exoplayer2.d0.b$b  reason: collision with other inner class name */
    /* compiled from: CryptoInfo */
    public static final class C0120b {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f4939a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f4940b;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void b(int i2, int i3) {
            this.f4940b.set(i2, i3);
            this.f4939a.setPattern(this.f4940b);
        }

        private C0120b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f4939a = cryptoInfo;
            this.f4940b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public b() {
        int i2 = d0.f7006a;
        C0120b bVar = null;
        MediaCodec.CryptoInfo b2 = i2 >= 16 ? b() : null;
        this.f4937i = b2;
        this.f4938j = i2 >= 24 ? new C0120b(b2) : bVar;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void d() {
        MediaCodec.CryptoInfo cryptoInfo = this.f4937i;
        cryptoInfo.numSubSamples = this.f4934f;
        cryptoInfo.numBytesOfClearData = this.f4932d;
        cryptoInfo.numBytesOfEncryptedData = this.f4933e;
        cryptoInfo.key = this.f4930b;
        cryptoInfo.iv = this.f4929a;
        cryptoInfo.mode = this.f4931c;
        if (d0.f7006a >= 24) {
            this.f4938j.b(this.f4935g, this.f4936h);
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        return this.f4937i;
    }

    public void c(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f4934f = i2;
        this.f4932d = iArr;
        this.f4933e = iArr2;
        this.f4930b = bArr;
        this.f4929a = bArr2;
        this.f4931c = i3;
        this.f4935g = i4;
        this.f4936h = i5;
        if (d0.f7006a >= 16) {
            d();
        }
    }
}
