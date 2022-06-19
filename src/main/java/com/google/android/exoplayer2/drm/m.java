package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.android.exoplayer2.drm.o;

@TargetApi(16)
/* compiled from: DrmSessionManager */
public interface m<T extends o> {
    DrmSession<T> a(Looper looper, l lVar);

    boolean d(l lVar);

    void f(DrmSession<T> drmSession);
}
