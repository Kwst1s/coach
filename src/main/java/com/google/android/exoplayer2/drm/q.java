package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.util.e;

@TargetApi(16)
/* compiled from: FrameworkMediaCrypto */
public final class q implements o {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCrypto f5013a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5014b;

    public q(MediaCrypto mediaCrypto, boolean z) {
        e.e(mediaCrypto);
        this.f5013a = mediaCrypto;
        this.f5014b = z;
    }

    public MediaCrypto a() {
        return this.f5013a;
    }

    public boolean b(String str) {
        return !this.f5014b && this.f5013a.requiresSecureDecoderComponent(str);
    }
}
