package f.a.a.a.b.b;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import f.a.a.a.b.c.a;
import f.a.a.a.b.c.g;
import f.a.a.a.b.c.h;
import f.a.a.a.b.c.i;
import f.a.a.a.b.c.j;

/* compiled from: SPItemTouchHelper */
public class z0 extends f.AbstractC0027f {

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.g f9094d;

    public z0(RecyclerView.g gVar) {
        this.f9094d = gVar;
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public void B(RecyclerView.d0 d0Var, int i2) {
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public int k(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return f.AbstractC0027f.t(3, 4);
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public boolean q() {
        return false;
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public boolean r() {
        return true;
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        if (d0Var.l() != d0Var2.l()) {
            return false;
        }
        RecyclerView.g gVar = this.f9094d;
        if (gVar instanceof j) {
            ((j) gVar).A(d0Var.j(), d0Var2.j());
            return true;
        } else if (gVar instanceof a) {
            ((a) gVar).D(d0Var.j(), d0Var2.j());
            return true;
        } else if (gVar instanceof h) {
            ((h) gVar).A(d0Var.j(), d0Var2.j());
            return true;
        } else if (gVar instanceof i) {
            ((i) gVar).B(d0Var.j(), d0Var2.j());
            return true;
        } else if (!(gVar instanceof g)) {
            return false;
        } else {
            ((g) gVar).A(d0Var.j(), d0Var2.j());
            return true;
        }
    }
}
