package com.google.android.exoplayer2.e0;

/* compiled from: SeekPoint */
public final class p {

    /* renamed from: c  reason: collision with root package name */
    public static final p f5100c = new p(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f5101a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5102b;

    public p(long j2, long j3) {
        this.f5101a = j2;
        this.f5102b = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f5101a == pVar.f5101a && this.f5102b == pVar.f5102b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f5101a) * 31) + ((int) this.f5102b);
    }

    public String toString() {
        return "[timeUs=" + this.f5101a + ", position=" + this.f5102b + "]";
    }
}
