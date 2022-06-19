package com.google.android.exoplayer2.offline;

/* compiled from: StreamKey */
public final class c implements Comparable<c> {

    /* renamed from: b  reason: collision with root package name */
    public final int f6021b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6022c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6023d;

    public c(int i2, int i3, int i4) {
        this.f6021b = i2;
        this.f6022c = i3;
        this.f6023d = i4;
    }

    /* renamed from: a */
    public int compareTo(c cVar) {
        int i2 = this.f6021b - cVar.f6021b;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f6022c - cVar.f6022c;
        return i3 == 0 ? this.f6023d - cVar.f6023d : i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f6021b == cVar.f6021b && this.f6022c == cVar.f6022c && this.f6023d == cVar.f6023d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f6021b * 31) + this.f6022c) * 31) + this.f6023d;
    }

    public String toString() {
        return this.f6021b + "." + this.f6022c + "." + this.f6023d;
    }
}
