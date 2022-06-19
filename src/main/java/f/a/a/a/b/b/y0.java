package f.a.a.a.b.b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.s;
import f.a.a.a.b.d.i;
import f.a.a.a.b.n.b.d;
import java.util.ArrayList;
import kotlin.m.b.f;

/* compiled from: PagerGoalGraphsAdapter.kt */
public final class y0 extends s {

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<i> f9083i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y0(m mVar) {
        super(mVar);
        f.e(mVar, "fragmentManager");
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        ArrayList<i> arrayList = this.f9083i;
        f.c(arrayList);
        return arrayList.size();
    }

    @Override // androidx.fragment.app.s
    public Fragment s(int i2) {
        d.a aVar = d.d0;
        ArrayList<i> arrayList = this.f9083i;
        f.c(arrayList);
        i iVar = arrayList.get(i2);
        f.d(iVar, "goals!![position]");
        return aVar.b(iVar);
    }

    public final void t(ArrayList<i> arrayList) {
        this.f9083i = arrayList;
    }
}
