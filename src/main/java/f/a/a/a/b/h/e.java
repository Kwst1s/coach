package f.a.a.a.b.h;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.h0;
import f.a.a.a.b.d.n;
import f.a.a.a.b.d.u;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn_category;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import k.b.d;

/* compiled from: Frag_learn_screens */
public class e extends Fragment {
    private RecyclerView X;
    private n Y;

    public static e L1(n nVar) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putSerializable("learn", nVar);
        eVar.v1(bundle);
        return eVar;
    }

    public void K1(u uVar, int i2) {
        d.k(uVar.c());
        if (n() instanceof Act_tabs) {
            ((Act_tabs) n()).Z(g.L1(this.Y, i2), uVar.c());
        } else if (n() instanceof Act_single_covid_learn_category) {
            ((Act_single_covid_learn_category) n()).W(g.L1(this.Y, i2), uVar.c());
        }
    }

    public void M1() {
        this.X.setAdapter(new h0(this, this.Y.c()));
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.Y = (n) u().getSerializable("learn");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_learn_screens, (ViewGroup) null);
        this.X = (RecyclerView) inflate.findViewById(R.id.learn_rview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(n());
        linearLayoutManager.E2(1);
        this.X.setHasFixedSize(true);
        this.X.setLayoutManager(linearLayoutManager);
        M1();
        return inflate;
    }
}
