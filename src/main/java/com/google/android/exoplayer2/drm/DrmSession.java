package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.drm.o;
import java.util.Map;

@TargetApi(16)
public interface DrmSession<T extends o> {

    public static class DrmSessionException extends Exception {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }

    Map<String, String> a();

    T b();

    DrmSessionException c();

    int getState();
}
