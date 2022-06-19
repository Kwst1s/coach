package f.a.a.a.b.b;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.s;
import java.util.ArrayList;
import vainstrum.Components.b;

/* compiled from: PagerFrags */
public class x0 extends s {

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<b> f9080i;

    public x0(m mVar) {
        super(mVar);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.f9080i.size();
    }

    @Override // androidx.fragment.app.s
    public Fragment s(int i2) {
        return this.f9080i.get(i2);
    }

    public void t(Activity activity, ArrayList<b> arrayList) {
        this.f9080i = arrayList;
    }
}
