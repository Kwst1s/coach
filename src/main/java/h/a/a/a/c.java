package h.a.a.a;

import android.util.Log;
import h.a.a.a.f;
import h.a.a.a.i;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Decoders */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f10210c = "c";

    /* renamed from: a  reason: collision with root package name */
    private List<f> f10211a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private g f10212b;

    public void a(f fVar) {
        this.f10211a.add(fVar);
        if (fVar instanceof g) {
            this.f10212b = (g) fVar;
        } else if (fVar instanceof e) {
            e eVar = (e) fVar;
        }
    }

    public f.a b(boolean z) {
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!z2) {
                    f.a aVar = null;
                    int i2 = 0;
                    for (f fVar : this.f10211a) {
                        while (true) {
                            f.a c2 = fVar.c();
                            if (c2 == null) {
                                break;
                            } else if (fVar == this.f10212b) {
                                aVar = c2;
                                break;
                            } else {
                                fVar.u(c2, 0);
                            }
                        }
                        do {
                        } while (fVar.o(false));
                        if (fVar.l()) {
                            i2++;
                        }
                    }
                    if (aVar != null) {
                        return aVar;
                    }
                    if (!z) {
                        return null;
                    }
                    if (i2 == this.f10211a.size()) {
                        z2 = true;
                    }
                } else {
                    Log.d(f10210c, "EOS NULL");
                    return null;
                }
            }
        }
    }

    public void c() {
        for (f fVar : this.f10211a) {
            fVar.d();
        }
    }

    public long d() {
        long j2 = Long.MAX_VALUE;
        for (f fVar : this.f10211a) {
            j2 = Math.min(fVar.f(), j2);
        }
        if (j2 == Long.MAX_VALUE) {
            return -1;
        }
        return j2;
    }

    public long e() {
        long j2 = Long.MAX_VALUE;
        for (f fVar : this.f10211a) {
            long h2 = fVar.h();
            if (h2 != Long.MIN_VALUE && j2 > h2) {
                j2 = h2;
            }
        }
        return j2;
    }

    public List<f> f() {
        return this.f10211a;
    }

    public long g() {
        long j2 = -1;
        for (f fVar : this.f10211a) {
            long j3 = fVar.j();
            if (j3 > j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public g h() {
        return this.f10212b;
    }

    public boolean i() {
        for (f fVar : this.f10211a) {
            if (!fVar.k()) {
                return false;
            }
        }
        return true;
    }

    public boolean j() {
        int i2 = 0;
        for (f fVar : this.f10211a) {
            if (fVar.l()) {
                i2++;
            }
        }
        if (i2 == this.f10211a.size()) {
            return true;
        }
        return false;
    }

    public void k() {
        for (f fVar : this.f10211a) {
            try {
                fVar.q();
            } catch (Exception e2) {
                Log.e(f10210c, "release failed", e2);
            }
        }
        this.f10211a.clear();
    }

    public void l() {
        for (f fVar : this.f10211a) {
            fVar.t();
        }
    }

    public void m(i.n nVar, long j2) {
        for (f fVar : this.f10211a) {
            fVar.w(nVar, j2);
        }
    }
}
