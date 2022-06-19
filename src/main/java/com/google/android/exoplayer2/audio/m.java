package com.google.android.exoplayer2.audio;

/* compiled from: AuxEffectInfo */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final int f4813a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4814b;

    public m(int i2, float f2) {
        this.f4813a = i2;
        this.f4814b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f4813a == mVar.f4813a && Float.compare(mVar.f4814b, this.f4814b) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f4813a) * 31) + Float.floatToIntBits(this.f4814b);
    }
}
