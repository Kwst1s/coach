package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
abstract class q extends p {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference<byte[]> f7431c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<byte[]> f7432b = f7431c;

    q(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] T();

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.p
    public final byte[] i() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f7432b.get();
            if (bArr == null) {
                bArr = T();
                this.f7432b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
