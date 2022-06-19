package f.a.a.a.b.b;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;

/* compiled from: FavoriteItemTouchHelper */
public class s extends f.AbstractC0027f {

    /* renamed from: d  reason: collision with root package name */
    private t0 f9027d;

    public s(t0 t0Var, LinearLayoutManager linearLayoutManager) {
        this.f9027d = t0Var;
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
        d0Var2.j();
        this.f9027d.C(d0Var.j(), d0Var2.j());
        return true;
    }
}
