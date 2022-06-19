package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.d0;

/* compiled from: WavUtil */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4881a = d0.B("RIFF");

    /* renamed from: b  reason: collision with root package name */
    public static final int f4882b = d0.B("WAVE");

    /* renamed from: c  reason: collision with root package name */
    public static final int f4883c = d0.B("fmt ");

    static {
        d0.B("data");
    }

    public static int a(int i2, int i3) {
        if (i2 != 1) {
            if (i2 == 3) {
                return i3 == 32 ? 4 : 0;
            }
            if (i2 != 65534) {
                if (i2 != 6) {
                    return i2 != 7 ? 0 : 268435456;
                }
                return 536870912;
            }
        }
        return d0.G(i3);
    }
}
