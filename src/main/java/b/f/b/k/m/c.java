package b.f.b.k.m;

import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChainRun */
public class c extends p {

    /* renamed from: k  reason: collision with root package name */
    ArrayList<p> f2359k = new ArrayList<>();
    private int l;

    public c(e eVar, int i2) {
        super(eVar);
        this.f2408f = i2;
        q();
    }

    private void q() {
        e eVar = this.f2404b;
        e J = eVar.J(this.f2408f);
        while (true) {
            eVar = J;
            if (eVar == null) {
                break;
            }
            J = eVar.J(this.f2408f);
        }
        this.f2404b = eVar;
        this.f2359k.add(eVar.L(this.f2408f));
        e H = eVar.H(this.f2408f);
        while (H != null) {
            this.f2359k.add(H.L(this.f2408f));
            H = H.H(this.f2408f);
        }
        Iterator<p> it = this.f2359k.iterator();
        while (it.hasNext()) {
            p next = it.next();
            int i2 = this.f2408f;
            if (i2 == 0) {
                next.f2404b.f2326b = this;
            } else if (i2 == 1) {
                next.f2404b.f2327c = this;
            }
        }
        if ((this.f2408f == 0 && ((f) this.f2404b.I()).x1()) && this.f2359k.size() > 1) {
            ArrayList<p> arrayList = this.f2359k;
            this.f2404b = arrayList.get(arrayList.size() - 1).f2404b;
        }
        this.l = this.f2408f == 0 ? this.f2404b.x() : this.f2404b.N();
    }

    private e r() {
        for (int i2 = 0; i2 < this.f2359k.size(); i2++) {
            p pVar = this.f2359k.get(i2);
            if (pVar.f2404b.Q() != 8) {
                return pVar.f2404b;
            }
        }
        return null;
    }

    private e s() {
        for (int size = this.f2359k.size() - 1; size >= 0; size--) {
            p pVar = this.f2359k.get(size);
            if (pVar.f2404b.Q() != 8) {
                return pVar.f2404b;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a6, code lost:
        if (r1 != r7) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01cc, code lost:
        if (r1 != r7) goto L_0x01ce;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00eb  */
    @Override // b.f.b.k.m.d, b.f.b.k.m.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(b.f.b.k.m.d r26) {
        /*
        // Method dump skipped, instructions count: 1090
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.c.a(b.f.b.k.m.d):void");
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void d() {
        Iterator<p> it = this.f2359k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f2359k.size();
        if (size >= 1) {
            e eVar = this.f2359k.get(0).f2404b;
            e eVar2 = this.f2359k.get(size - 1).f2404b;
            if (this.f2408f == 0) {
                d dVar = eVar.F;
                d dVar2 = eVar2.H;
                f i2 = i(dVar, 0);
                int e2 = dVar.e();
                e r = r();
                if (r != null) {
                    e2 = r.F.e();
                }
                if (i2 != null) {
                    b(this.f2410h, i2, e2);
                }
                f i3 = i(dVar2, 0);
                int e3 = dVar2.e();
                e s = s();
                if (s != null) {
                    e3 = s.H.e();
                }
                if (i3 != null) {
                    b(this.f2411i, i3, -e3);
                }
            } else {
                d dVar3 = eVar.G;
                d dVar4 = eVar2.I;
                f i4 = i(dVar3, 1);
                int e4 = dVar3.e();
                e r2 = r();
                if (r2 != null) {
                    e4 = r2.G.e();
                }
                if (i4 != null) {
                    b(this.f2410h, i4, e4);
                }
                f i5 = i(dVar4, 1);
                int e5 = dVar4.e();
                e s2 = s();
                if (s2 != null) {
                    e5 = s2.I.e();
                }
                if (i5 != null) {
                    b(this.f2411i, i5, -e5);
                }
            }
            this.f2410h.f2368a = this;
            this.f2411i.f2368a = this;
        }
    }

    @Override // b.f.b.k.m.p
    public void e() {
        for (int i2 = 0; i2 < this.f2359k.size(); i2++) {
            this.f2359k.get(i2).e();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void f() {
        this.f2405c = null;
        Iterator<p> it = this.f2359k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // b.f.b.k.m.p
    public long j() {
        int size = this.f2359k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.f2359k.get(i2);
            j2 = j2 + ((long) pVar.f2410h.f2373f) + pVar.j() + ((long) pVar.f2411i.f2373f);
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public boolean m() {
        int size = this.f2359k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f2359k.get(i2).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f2408f == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator<p> it = this.f2359k.iterator();
        while (it.hasNext()) {
            sb2 = ((sb2 + "<") + it.next()) + "> ";
        }
        return sb2;
    }
}
