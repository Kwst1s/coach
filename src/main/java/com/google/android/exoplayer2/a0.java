package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.e;

/* compiled from: SeekParameters */
public final class a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final a0 f4725c;

    /* renamed from: d  reason: collision with root package name */
    public static final a0 f4726d;

    /* renamed from: a  reason: collision with root package name */
    public final long f4727a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4728b;

    static {
        a0 a0Var = new a0(0, 0);
        f4725c = a0Var;
        new a0(Long.MAX_VALUE, Long.MAX_VALUE);
        new a0(Long.MAX_VALUE, 0);
        new a0(0, Long.MAX_VALUE);
        f4726d = a0Var;
    }

    public a0(long j2, long j3) {
        boolean z = true;
        e.a(j2 >= 0);
        e.a(j3 < 0 ? false : z);
        this.f4727a = j2;
        this.f4728b = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        if (this.f4727a == a0Var.f4727a && this.f4728b == a0Var.f4728b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f4727a) * 31) + ((int) this.f4728b);
    }
}
