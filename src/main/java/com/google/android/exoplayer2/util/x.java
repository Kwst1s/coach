package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: SystemClock */
final class x implements f {
    x() {
    }

    @Override // com.google.android.exoplayer2.util.f
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.f
    public l b(Looper looper, Handler.Callback callback) {
        return new y(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.f
    public long c() {
        return SystemClock.elapsedRealtime();
    }
}
