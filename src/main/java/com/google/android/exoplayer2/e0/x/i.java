package com.google.android.exoplayer2.e0.x;

import android.util.SparseArray;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.text.k.d;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DefaultTsPayloadReaderFactory */
public final class i implements e0.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f5491a;

    /* renamed from: b  reason: collision with root package name */
    private final List<l> f5492b;

    public i(int i2) {
        this(i2, Collections.singletonList(l.A(null, "application/cea-608", 0, null)));
    }

    private z c(e0.b bVar) {
        return new z(e(bVar));
    }

    private g0 d(e0.b bVar) {
        return new g0(e(bVar));
    }

    private List<l> e(e0.b bVar) {
        int i2;
        String str;
        List<byte[]> list;
        if (f(32)) {
            return this.f5492b;
        }
        s sVar = new s(bVar.f5450d);
        List<l> list2 = this.f5492b;
        while (sVar.a() > 0) {
            int y = sVar.y();
            int c2 = sVar.c() + sVar.y();
            if (y == 134) {
                list2 = new ArrayList<>();
                int y2 = sVar.y() & 31;
                for (int i3 = 0; i3 < y2; i3++) {
                    String v = sVar.v(3);
                    int y3 = sVar.y();
                    boolean z = true;
                    boolean z2 = (y3 & 128) != 0;
                    if (z2) {
                        i2 = y3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte y4 = (byte) sVar.y();
                    sVar.L(1);
                    if (z2) {
                        if ((y4 & 64) == 0) {
                            z = false;
                        }
                        list = d.a(z);
                    } else {
                        list = null;
                    }
                    list2.add(l.C(null, str, null, -1, 0, v, i2, null, Long.MAX_VALUE, list));
                }
            }
            sVar.K(c2);
        }
        return list2;
    }

    private boolean f(int i2) {
        return (i2 & this.f5491a) != 0;
    }

    @Override // com.google.android.exoplayer2.e0.x.e0.c
    public SparseArray<e0> a() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.e0.x.e0.c
    public e0 b(int i2, e0.b bVar) {
        if (i2 == 2) {
            return new t(new m(d(bVar)));
        }
        if (i2 == 3 || i2 == 4) {
            return new t(new r(bVar.f5448b));
        }
        if (i2 != 15) {
            if (i2 != 17) {
                if (i2 == 21) {
                    return new t(new p());
                }
                if (i2 != 27) {
                    if (i2 == 36) {
                        return new t(new o(c(bVar)));
                    }
                    if (i2 == 89) {
                        return new t(new k(bVar.f5449c));
                    }
                    if (i2 != 138) {
                        if (i2 != 129) {
                            if (i2 != 130) {
                                if (i2 != 134) {
                                    if (i2 != 135) {
                                        return null;
                                    }
                                } else if (f(16)) {
                                    return null;
                                } else {
                                    return new y(new a0());
                                }
                            }
                        }
                        return new t(new f(bVar.f5448b));
                    }
                    return new t(new j(bVar.f5448b));
                } else if (f(4)) {
                    return null;
                } else {
                    return new t(new n(c(bVar), f(1), f(8)));
                }
            } else if (f(2)) {
                return null;
            } else {
                return new t(new q(bVar.f5448b));
            }
        } else if (f(2)) {
            return null;
        } else {
            return new t(new h(false, bVar.f5448b));
        }
    }

    public i(int i2, List<l> list) {
        this.f5491a = i2;
        this.f5492b = list;
    }
}
