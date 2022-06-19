package b.r;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.r.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet */
public class q extends m {
    private ArrayList<m> K = new ArrayList<>();
    private boolean L = true;
    int M;
    boolean N = false;
    private int O = 0;

    /* compiled from: TransitionSet */
    class a extends n {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f2931b;

        a(q qVar, m mVar) {
            this.f2931b = mVar;
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            this.f2931b.U();
            mVar.Q(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TransitionSet */
    public static class b extends n {

        /* renamed from: b  reason: collision with root package name */
        q f2932b;

        b(q qVar) {
            this.f2932b = qVar;
        }

        @Override // b.r.m.f, b.r.n
        public void a(m mVar) {
            q qVar = this.f2932b;
            if (!qVar.N) {
                qVar.b0();
                this.f2932b.N = true;
            }
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            q qVar = this.f2932b;
            int i2 = qVar.M - 1;
            qVar.M = i2;
            if (i2 == 0) {
                qVar.N = false;
                qVar.q();
            }
            mVar.Q(this);
        }
    }

    private void g0(m mVar) {
        this.K.add(mVar);
        mVar.s = this;
    }

    private void p0() {
        b bVar = new b(this);
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.M = this.K.size();
    }

    @Override // b.r.m
    public void O(View view) {
        super.O(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).O(view);
        }
    }

    @Override // b.r.m
    public void S(View view) {
        super.S(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).S(view);
        }
    }

    /* access modifiers changed from: protected */
    @Override // b.r.m
    public void U() {
        if (this.K.isEmpty()) {
            b0();
            q();
            return;
        }
        p0();
        if (!this.L) {
            for (int i2 = 1; i2 < this.K.size(); i2++) {
                this.K.get(i2 - 1).a(new a(this, this.K.get(i2)));
            }
            m mVar = this.K.get(0);
            if (mVar != null) {
                mVar.U();
                return;
            }
            return;
        }
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    @Override // b.r.m
    public /* bridge */ /* synthetic */ m V(long j2) {
        l0(j2);
        return this;
    }

    @Override // b.r.m
    public void W(m.e eVar) {
        super.W(eVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).W(eVar);
        }
    }

    @Override // b.r.m
    public void Y(g gVar) {
        super.Y(gVar);
        this.O |= 4;
        if (this.K != null) {
            for (int i2 = 0; i2 < this.K.size(); i2++) {
                this.K.get(i2).Y(gVar);
            }
        }
    }

    @Override // b.r.m
    public void Z(p pVar) {
        super.Z(pVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).Z(pVar);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.r.m
    public String c0(String str) {
        String c0 = super.c0(str);
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(c0);
            sb.append("\n");
            sb.append(this.K.get(i2).c0(str + "  "));
            c0 = sb.toString();
        }
        return c0;
    }

    /* renamed from: d0 */
    public q a(m.f fVar) {
        super.a(fVar);
        return this;
    }

    /* renamed from: e0 */
    public q b(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).b(view);
        }
        super.b(view);
        return this;
    }

    public q f0(m mVar) {
        g0(mVar);
        long j2 = this.f2908d;
        if (j2 >= 0) {
            mVar.V(j2);
        }
        if ((this.O & 1) != 0) {
            mVar.X(t());
        }
        if ((this.O & 2) != 0) {
            mVar.Z(x());
        }
        if ((this.O & 4) != 0) {
            mVar.Y(w());
        }
        if ((this.O & 8) != 0) {
            mVar.W(s());
        }
        return this;
    }

    @Override // b.r.m
    public void g(s sVar) {
        if (H(sVar.f2937b)) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.H(sVar.f2937b)) {
                    next.g(sVar);
                    sVar.f2938c.add(next);
                }
            }
        }
    }

    public m h0(int i2) {
        if (i2 < 0 || i2 >= this.K.size()) {
            return null;
        }
        return this.K.get(i2);
    }

    /* access modifiers changed from: package-private */
    @Override // b.r.m
    public void i(s sVar) {
        super.i(sVar);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).i(sVar);
        }
    }

    public int i0() {
        return this.K.size();
    }

    @Override // b.r.m
    public void j(s sVar) {
        if (H(sVar.f2937b)) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.H(sVar.f2937b)) {
                    next.j(sVar);
                    sVar.f2938c.add(next);
                }
            }
        }
    }

    /* renamed from: j0 */
    public q Q(m.f fVar) {
        super.Q(fVar);
        return this;
    }

    /* renamed from: k0 */
    public q R(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).R(view);
        }
        super.R(view);
        return this;
    }

    public q l0(long j2) {
        ArrayList<m> arrayList;
        super.V(j2);
        if (this.f2908d >= 0 && (arrayList = this.K) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.K.get(i2).V(j2);
            }
        }
        return this;
    }

    /* renamed from: m0 */
    public q X(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<m> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.K.get(i2).X(timeInterpolator);
            }
        }
        super.X(timeInterpolator);
        return this;
    }

    @Override // b.r.m
    /* renamed from: n */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.K = new ArrayList<>();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            qVar.g0(this.K.get(i2).clone());
        }
        return qVar;
    }

    public q n0(int i2) {
        if (i2 == 0) {
            this.L = true;
        } else if (i2 == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    /* renamed from: o0 */
    public q a0(long j2) {
        super.a0(j2);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // b.r.m
    public void p(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long z = z();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.K.get(i2);
            if (z > 0 && (this.L || i2 == 0)) {
                long z2 = mVar.z();
                if (z2 > 0) {
                    mVar.a0(z2 + z);
                } else {
                    mVar.a0(z);
                }
            }
            mVar.p(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
