package c.b.a.a.j.g.d;

/* compiled from: ScaleType */
public enum b {
    CENTER,
    CENTER_CROP,
    CENTER_INSIDE,
    FIT_CENTER,
    FIT_XY,
    NONE;

    public static b a(int i2) {
        if (i2 < 0 || i2 > NONE.ordinal()) {
            return NONE;
        }
        return values()[i2];
    }
}
