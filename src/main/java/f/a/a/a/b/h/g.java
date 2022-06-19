package f.a.a.a.b.h;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.x0;
import f.a.a.a.b.d.n;
import f.a.a.a.b.d.u;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Fragment_learn_pager */
public class g extends Fragment {
    private n X;
    private int Y;
    private ViewPager Z;

    /* compiled from: Fragment_learn_pager */
    class a implements ViewPager.j {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f9383b;

        a(ArrayList arrayList) {
            this.f9383b = arrayList;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i2) {
            if (g.this.n1() instanceof Act_tabs) {
                ((Act_tabs) g.this.n1()).d0(g.this.X.c().get(i2).c());
            } else if (g.this.n1() instanceof Act_single_covid_learn) {
                ((Act_single_covid_learn) g.this.n1()).b0(g.this.X.c().get(i2).c());
            }
            for (int i3 = 0; i3 < this.f9383b.size(); i3++) {
                if (i2 == i3) {
                    ((b) this.f9383b.get(i3)).T1(false);
                } else {
                    ((b) this.f9383b.get(i3)).T1(true);
                }
            }
            d.r(g.this.n(), g.this.X.c().get(i2).c());
        }
    }

    public static g L1(n nVar, int i2) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("learn", nVar);
        bundle.putInt("position", i2);
        gVar.v1(bundle);
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.X = (n) u().getSerializable("learn");
            this.Y = u().getInt("position");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_learn_pager, viewGroup, false);
        this.Z = (ViewPager) inflate.findViewById(R.id.learn_pager_pager);
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.X.c().size(); i2++) {
            u uVar = this.X.c().get(i2);
            if (uVar.g()) {
                b L = m.L(Math.abs(uVar.d()), uVar.c());
                L.V1(n().getTitle().toString());
                arrayList.add(L);
            } else if (uVar.d() == 2010) {
                d a2 = d.g0.a(uVar);
                a2.Z1(false);
                a2.V1(n().getTitle().toString());
                arrayList.add(a2);
            } else {
                c Y1 = c.Y1(uVar);
                Y1.a2(false);
                Y1.V1(n().getTitle().toString());
                arrayList.add(Y1);
            }
        }
        x0 x0Var = new x0(v());
        x0Var.t(n(), arrayList);
        this.Z.c(new a(arrayList));
        this.Z.setAdapter(x0Var);
        this.Z.setCurrentItem(this.Y);
        if (this.Y == 0) {
            d.r(n(), this.X.c().get(this.Y).c());
            if (n1() instanceof Act_single_covid_learn) {
                ((Act_single_covid_learn) n1()).b0(this.X.c().get(0).c());
            }
        }
        if (j.t(n(), "ftime_learn", true)) {
            j.V(n(), Q(R.string.swipe_left_more_topics));
            j.u(n()).putBoolean("ftime_learn", false).apply();
        }
        return inflate;
    }
}
