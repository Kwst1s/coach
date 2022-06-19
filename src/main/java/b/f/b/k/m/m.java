package b.f.b.k.m;

import b.f.b.k.f;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: RunGroup */
public class m {

    /* renamed from: d  reason: collision with root package name */
    public static int f2391d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2392a;

    /* renamed from: b  reason: collision with root package name */
    p f2393b = null;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<p> f2394c = new ArrayList<>();

    public m(p pVar, int i2) {
        f2391d++;
        this.f2393b = pVar;
    }

    private long c(f fVar, long j2) {
        p pVar = fVar.f2371d;
        if (pVar instanceof k) {
            return j2;
        }
        int size = fVar.f2378k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f2378k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f2371d != pVar) {
                    j3 = Math.min(j3, c(fVar2, ((long) fVar2.f2373f) + j2));
                }
            }
        }
        if (fVar != pVar.f2411i) {
            return j3;
        }
        long j4 = j2 - pVar.j();
        return Math.min(Math.min(j3, c(pVar.f2410h, j4)), j4 - ((long) pVar.f2410h.f2373f));
    }

    private long d(f fVar, long j2) {
        p pVar = fVar.f2371d;
        if (pVar instanceof k) {
            return j2;
        }
        int size = fVar.f2378k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f2378k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f2371d != pVar) {
                    j3 = Math.max(j3, d(fVar2, ((long) fVar2.f2373f) + j2));
                }
            }
        }
        if (fVar != pVar.f2410h) {
            return j3;
        }
        long j4 = j2 + pVar.j();
        return Math.max(Math.max(j3, d(pVar.f2411i, j4)), j4 - ((long) pVar.f2411i.f2373f));
    }

    public void a(p pVar) {
        this.f2394c.add(pVar);
    }

    public long b(f fVar, int i2) {
        int i3;
        long j2;
        p pVar = this.f2393b;
        long j3 = 0;
        if (pVar instanceof c) {
            if (((c) pVar).f2408f != i2) {
                return 0;
            }
        } else if (i2 == 0) {
            if (!(pVar instanceof l)) {
                return 0;
            }
        } else if (!(pVar instanceof n)) {
            return 0;
        }
        f fVar2 = (i2 == 0 ? fVar.f2328d : fVar.f2329e).f2410h;
        f fVar3 = (i2 == 0 ? fVar.f2328d : fVar.f2329e).f2411i;
        boolean contains = pVar.f2410h.l.contains(fVar2);
        boolean contains2 = this.f2393b.f2411i.l.contains(fVar3);
        long j4 = this.f2393b.j();
        if (contains && contains2) {
            long d2 = d(this.f2393b.f2410h, 0);
            long c2 = c(this.f2393b.f2411i, 0);
            long j5 = d2 - j4;
            p pVar2 = this.f2393b;
            int i4 = pVar2.f2411i.f2373f;
            if (j5 >= ((long) (-i4))) {
                j5 += (long) i4;
            }
            int i5 = pVar2.f2410h.f2373f;
            long j6 = ((-c2) - j4) - ((long) i5);
            if (j6 >= ((long) i5)) {
                j6 -= (long) i5;
            }
            float o = pVar2.f2404b.o(i2);
            if (o > Utils.FLOAT_EPSILON) {
                j3 = (long) ((((float) j6) / o) + (((float) j5) / (1.0f - o)));
            }
            float f2 = (float) j3;
            long j7 = ((long) ((f2 * o) + 0.5f)) + j4 + ((long) ((f2 * (1.0f - o)) + 0.5f));
            p pVar3 = this.f2393b;
            j2 = ((long) pVar3.f2410h.f2373f) + j7;
            i3 = pVar3.f2411i.f2373f;
        } else if (contains) {
            f fVar4 = this.f2393b.f2410h;
            return Math.max(d(fVar4, (long) fVar4.f2373f), ((long) this.f2393b.f2410h.f2373f) + j4);
        } else if (contains2) {
            f fVar5 = this.f2393b.f2411i;
            return Math.max(-c(fVar5, (long) fVar5.f2373f), ((long) (-this.f2393b.f2411i.f2373f)) + j4);
        } else {
            p pVar4 = this.f2393b;
            j2 = ((long) pVar4.f2410h.f2373f) + pVar4.j();
            i3 = this.f2393b.f2411i.f2373f;
        }
        return j2 - ((long) i3);
    }
}
