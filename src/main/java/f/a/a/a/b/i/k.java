package f.a.a.a.b.i;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import f.a.a.a.b.b.n0;
import f.a.a.a.b.b.q0;
import f.a.a.a.b.b.s;
import f.a.a.a.b.b.t0;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.g;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_add_favorite;
import gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools.Act_create_tool;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.Collections;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_manage */
public class k extends b {
    private TabLayout c0;
    private RecyclerView d0;
    private RecyclerView e0;
    private RecyclerView f0;
    private FloatingActionButton g0;
    private AppCompatButton h0;
    private ArrayList<a0> i0;
    private ArrayList<b0> j0;
    private ArrayList<Integer> k0;
    private LinearLayoutManager l0;
    private f m0;
    private int n0 = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_manage */
    public class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            int g2 = gVar.g();
            if (g2 == 0) {
                gVar.m(R.string.challenges_tab);
            } else if (g2 == 1) {
                gVar.m(R.string.tools_tab);
            } else if (g2 == 2) {
                gVar.m(R.string.favorites_subtab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
            k.this.n0 = gVar.g();
            if (gVar.g() == 0) {
                k.this.n().setTitle(k.this.Q(R.string.challenges));
                m.A0(k.this.n(), k.this.Q(R.string.challenges));
                d.j(k.this.n(), "19211");
                j.u(k.this.n()).putInt("lastmanage_tab", 0).apply();
                k.this.d0.setVisibility(0);
                k.this.e0.setVisibility(8);
                k.this.f0.setVisibility(8);
                k.this.h0.setVisibility(8);
                k.this.g0.l();
            } else if (gVar.g() == 1) {
                k.this.n().setTitle(k.this.Q(R.string.tools));
                m.A0(k.this.n(), k.this.Q(R.string.tools));
                d.j(k.this.n(), "19315");
                j.u(k.this.n()).putInt("lastmanage_tab", 1).apply();
                k.this.d0.setVisibility(8);
                k.this.e0.setVisibility(0);
                k.this.f0.setVisibility(8);
                k.this.h0.setVisibility(8);
                k.this.g0.t();
            } else {
                k.this.n().setTitle(k.this.Q(R.string.favorites));
                m.A0(k.this.n(), k.this.Q(R.string.favorites));
                d.j(k.this.n(), "19551");
                j.u(k.this.n()).putInt("lastmanage_tab", 2).apply();
                k.this.d0.setVisibility(8);
                k.this.e0.setVisibility(8);
                k.this.f0.setVisibility(0);
                k.this.g0.l();
                if (k.this.k0 == null) {
                    k kVar = k.this;
                    kVar.k0 = m.S(kVar.n());
                }
                if (k.this.k0.isEmpty()) {
                    k.this.h0.setVisibility(0);
                } else {
                    k.this.h0.setVisibility(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f2 */
    public /* synthetic */ void g2(View view) {
        F1(new Intent(n(), Act_add_favorite.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: h2 */
    public /* synthetic */ void i2(View view) {
        F1(new Intent(n(), Act_create_tool.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: j2 */
    public /* synthetic */ void k2(RecyclerView.d0 d0Var) {
        this.m0.H(d0Var);
    }

    public static k o2(int i2) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putInt("curTab", i2);
        kVar.v1(bundle);
        return kVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        m.x0(n(), this.k0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        if (m.G(n().getApplication())) {
            s2();
            q2();
            if (this.n0 == 2) {
                if (this.k0.isEmpty()) {
                    this.h0.setVisibility(0);
                } else {
                    this.h0.setVisibility(8);
                }
            }
        }
        m.N0(n().getApplication(), false);
        super.J0();
    }

    public void e2() {
        if (this.k0.isEmpty()) {
            this.h0.setVisibility(0);
        } else {
            this.h0.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.n0 = u().getInt("curTab");
        }
    }

    public void p2() {
        if (j.D(p1())) {
            this.c0.setTabMode(0);
        } else {
            this.c0.setTabMode(1);
        }
        TabLayout tabLayout = this.c0;
        TabLayout.g x = tabLayout.x();
        x.s(R.string.challenges);
        x.n(Q(R.string.challenges_tab));
        tabLayout.d(x);
        TabLayout tabLayout2 = this.c0;
        TabLayout.g x2 = tabLayout2.x();
        x2.s(R.string.tools);
        x2.n(Q(R.string.tools_tab));
        tabLayout2.d(x2);
        TabLayout tabLayout3 = this.c0;
        TabLayout.g x3 = tabLayout3.x();
        x3.s(R.string.favorites);
        x3.n(Q(R.string.favorites_subtab));
        tabLayout3.d(x3);
        this.c0.c(new a());
        if (this.n0 == 0) {
            this.n0 = j.s(n()).getInt("lastmanage_tab", 0);
        }
        this.c0.w(this.n0).l();
    }

    public void q2() {
        boolean z;
        ArrayList<g> q0 = new u(n()).q0();
        this.k0 = m.S(n());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.k0.size(); i2++) {
            int intValue = this.k0.get(i2).intValue();
            int i3 = 0;
            while (true) {
                if (i3 >= q0.size()) {
                    z = false;
                    break;
                }
                g gVar = q0.get(i3);
                if (intValue == gVar.c()) {
                    arrayList.add(new b0(gVar.c(), gVar.e(), gVar.e(), null, null));
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                int i4 = 0;
                while (true) {
                    if (i4 >= this.j0.size()) {
                        break;
                    }
                    b0 b0Var = this.j0.get(i4);
                    if (intValue == b0Var.d()) {
                        arrayList.add(b0Var);
                        break;
                    }
                    i4++;
                }
            }
        }
        t0 t0Var = new t0(n(), arrayList, this.k0, new a(this), this);
        this.f0.setAdapter(t0Var);
        f fVar = this.m0;
        if (fVar != null) {
            fVar.m(null);
        }
        f fVar2 = new f(new s(t0Var, this.l0));
        this.m0 = fVar2;
        fVar2.m(this.f0);
    }

    public void r2() {
        this.d0.setAdapter(new n0(n(), this.i0));
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_manage, (ViewGroup) null);
        this.c0 = (TabLayout) inflate.findViewById(R.id.manage_tablayout);
        this.d0 = (RecyclerView) inflate.findViewById(R.id.manage_rview_symptoms);
        this.e0 = (RecyclerView) inflate.findViewById(R.id.manage_rview_tools);
        this.f0 = (RecyclerView) inflate.findViewById(R.id.manage_rview_favorites);
        this.g0 = (FloatingActionButton) inflate.findViewById(R.id.manage_btn_create_tool);
        this.h0 = (AppCompatButton) inflate.findViewById(R.id.manage_btn_add_favorite);
        this.i0 = m.q0(n());
        this.j0 = m.p0(n());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(n());
        linearLayoutManager.E2(1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(n());
        linearLayoutManager2.E2(1);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(n());
        this.l0 = linearLayoutManager3;
        linearLayoutManager3.E2(1);
        this.d0.setHasFixedSize(true);
        this.d0.setLayoutManager(linearLayoutManager2);
        this.e0.setHasFixedSize(true);
        this.e0.setLayoutManager(linearLayoutManager);
        this.f0.setHasFixedSize(true);
        this.f0.setLayoutManager(this.l0);
        this.h0.setOnClickListener(new f(this));
        this.g0.setOnClickListener(new e(this));
        if (j.t(n(), "favorites_lost", false)) {
            j.V(n(), Q(R.string.one_favorites_lost));
            j.u(n()).putBoolean("favorites_lost", false).apply();
        }
        p2();
        r2();
        s2();
        q2();
        d.e(gov.va.mobilehealth.ncptsd.covid.CComp.g.C0);
        return inflate;
    }

    public void s2() {
        ArrayList<g> q0 = new u(n()).q0();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < q0.size(); i2++) {
            g gVar = q0.get(i2);
            if (m.m0(n(), q0.get(i2).c(), "thumbdown")) {
                arrayList4.add(new b0(gVar.c(), gVar.e(), gVar.e(), null, null));
            } else {
                arrayList2.add(new b0(gVar.c(), gVar.e(), gVar.e(), null, null));
            }
        }
        for (int i3 = 0; i3 < this.j0.size(); i3++) {
            if (m.m0(n(), this.j0.get(i3).d(), "thumbdown")) {
                arrayList4.add(this.j0.get(i3));
            } else {
                arrayList3.add(this.j0.get(i3));
            }
        }
        Collections.sort(arrayList2, c.f9387b);
        Collections.sort(arrayList3, b.f9386b);
        Collections.sort(arrayList4, d.f9388b);
        if (arrayList2.size() != 0) {
            arrayList.addAll(arrayList2);
        }
        if (arrayList3.size() != 0) {
            arrayList.addAll(arrayList3);
        }
        if (arrayList4.size() != 0) {
            arrayList.add(new b0(Q(R.string.rejected)));
            arrayList.addAll(arrayList4);
        }
        this.e0.setAdapter(new q0(n(), arrayList, null, null, null));
    }
}
