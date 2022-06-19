package com.google.android.exoplayer2;

import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.util.e;

/* compiled from: PlaybackParameters */
public final class s {

    /* renamed from: e  reason: collision with root package name */
    public static final s f6052e = new s(1.0f);

    /* renamed from: a  reason: collision with root package name */
    public final float f6053a;

    /* renamed from: b  reason: collision with root package name */
    public final float f6054b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6055c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6056d;

    public s(float f2) {
        this(f2, 1.0f, false);
    }

    public long a(long j2) {
        return j2 * ((long) this.f6056d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f6053a == sVar.f6053a && this.f6054b == sVar.f6054b && this.f6055c == sVar.f6055c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + Float.floatToRawIntBits(this.f6053a)) * 31) + Float.floatToRawIntBits(this.f6054b)) * 31) + (this.f6055c ? 1 : 0);
    }

    public s(float f2, float f3, boolean z) {
        boolean z2 = true;
        e.a(f2 > Utils.FLOAT_EPSILON);
        e.a(f3 <= Utils.FLOAT_EPSILON ? false : z2);
        this.f6053a = f2;
        this.f6054b = f3;
        this.f6055c = z;
        this.f6056d = Math.round(f2 * 1000.0f);
    }
}
