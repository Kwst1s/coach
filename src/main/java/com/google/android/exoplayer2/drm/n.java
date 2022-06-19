package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.o;
import com.google.android.exoplayer2.util.e;
import java.util.Map;

/* compiled from: ErrorStateDrmSession */
public final class n<T extends o> implements DrmSession<T> {

    /* renamed from: a  reason: collision with root package name */
    private final DrmSession.DrmSessionException f5012a;

    public n(DrmSession.DrmSessionException drmSessionException) {
        e.e(drmSessionException);
        this.f5012a = drmSessionException;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> a() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public T b() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public DrmSession.DrmSessionException c() {
        return this.f5012a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}
