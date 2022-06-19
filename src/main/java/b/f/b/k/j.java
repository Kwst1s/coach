package b.f.b.k;

import b.f.b.d;
import b.f.b.k.e;

/* compiled from: Optimizer */
public class j {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f2344a = new boolean[3];

    static void a(f fVar, d dVar, e eVar) {
        eVar.l = -1;
        eVar.m = -1;
        e.b bVar = fVar.Q[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.Q[0] == e.b.MATCH_PARENT) {
            int i2 = eVar.F.f2311g;
            int R = fVar.R() - eVar.H.f2311g;
            d dVar2 = eVar.F;
            dVar2.f2313i = dVar.q(dVar2);
            d dVar3 = eVar.H;
            dVar3.f2313i = dVar.q(dVar3);
            dVar.f(eVar.F.f2313i, i2);
            dVar.f(eVar.H.f2313i, R);
            eVar.l = 2;
            eVar.y0(i2, R);
        }
        if (fVar.Q[1] != bVar2 && eVar.Q[1] == e.b.MATCH_PARENT) {
            int i3 = eVar.G.f2311g;
            int v = fVar.v() - eVar.I.f2311g;
            d dVar4 = eVar.G;
            dVar4.f2313i = dVar.q(dVar4);
            d dVar5 = eVar.I;
            dVar5.f2313i = dVar.q(dVar5);
            dVar.f(eVar.G.f2313i, i3);
            dVar.f(eVar.I.f2313i, v);
            if (eVar.Y > 0 || eVar.Q() == 8) {
                d dVar6 = eVar.J;
                dVar6.f2313i = dVar.q(dVar6);
                dVar.f(eVar.J.f2313i, eVar.Y + i3);
            }
            eVar.m = 2;
            eVar.P0(i3, v);
        }
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
