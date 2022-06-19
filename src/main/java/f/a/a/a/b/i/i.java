package f.a.a.a.b.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.e0;
import f.a.a.a.b.d.u;
import f.a.a.a.b.h.c;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage_help;
import java.util.ArrayList;
import vainstrum.Components.b;

/* compiled from: Frag_help_screens */
public class i extends b {
    private Act_manage_help c0;
    private RecyclerView d0;
    private ArrayList<u> e0;

    public static i X1(ArrayList<u> arrayList) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putSerializable("screens", arrayList);
        iVar.v1(bundle);
        return iVar;
    }

    public void W1(u uVar) {
        this.c0.X(c.Z1(uVar, true), uVar.c());
    }

    public void Y1() {
        this.d0.setAdapter(new e0(this, this.e0, Q(R.string.manage_help_topics)));
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage_help) n();
        if (u() != null) {
            this.e0 = (ArrayList) u().getSerializable("screens");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_learn_screens, (ViewGroup) null);
        this.d0 = (RecyclerView) inflate.findViewById(R.id.learn_rview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(n());
        linearLayoutManager.E2(1);
        this.d0.setHasFixedSize(true);
        this.d0.setLayoutManager(linearLayoutManager);
        Y1();
        return inflate;
    }
}
