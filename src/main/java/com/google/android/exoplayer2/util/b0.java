package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;

/* compiled from: TraceUtil */
public final class b0 {
    public static void a(String str) {
        if (d0.f7006a >= 18) {
            b(str);
        }
    }

    @TargetApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (d0.f7006a >= 18) {
            d();
        }
    }

    @TargetApi(18)
    private static void d() {
        Trace.endSection();
    }
}
