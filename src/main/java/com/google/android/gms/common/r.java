package com.google.android.gms.common;

import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class r extends p {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f7433b;

    r(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f7433b = bArr;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.p
    public final byte[] i() {
        return this.f7433b;
    }
}
