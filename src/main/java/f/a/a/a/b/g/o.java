package f.a.a.a.b.g;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.u0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.g;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_new_reminders;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.h0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_home */
public class o extends b implements View.OnClickListener {
    private Act_home c0;
    private LinearLayout d0;
    private RelativeLayout e0;
    private LinearLayout f0;
    private LinearLayout g0;
    private LinearLayout h0;
    private LinearLayout i0;
    private LinearLayout j0;
    private AppCompatTextView k0;
    private AppCompatTextView l0;
    private ImageView m0;
    private ImageView n0;
    private ImageView o0;
    private RecyclerView p0;
    private ImageView q0;
    private ImageView r0;
    private h0 s0;
    private LinearLayoutManager t0;
    private int u0 = 0;
    private int v0 = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_home */
    public class a extends RecyclerView.t {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            View h2 = o.this.s0.h(o.this.t0);
            o oVar = o.this;
            oVar.u0 = oVar.t0.i0(h2);
            Log.d("CUR ITEM", Integer.toString(o.this.u0));
            if (o.this.u0 == -1) {
                return;
            }
            if (o.this.u0 == 0) {
                o.this.q0.setVisibility(4);
                if (o.this.u0 + 3 >= o.this.v0) {
                    o.this.r0.setVisibility(4);
                } else {
                    o.this.r0.setVisibility(0);
                }
            } else {
                o.this.q0.setVisibility(0);
                if (o.this.u0 + 3 >= o.this.v0) {
                    o.this.r0.setVisibility(4);
                } else {
                    o.this.r0.setVisibility(0);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        if (m.F(n().getApplication())) {
            d2();
        }
        AppCompatTextView appCompatTextView = this.l0;
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.c0.d0());
        }
        m.b1(p1());
        this.o0.setImageResource(m.Z(n1()));
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        super.N0(view, bundle);
        s.b(this.q0);
    }

    public void d2() {
        boolean z;
        u uVar = new u(n());
        ArrayList<b0> p02 = m.p0(n());
        ArrayList<g> q02 = uVar.q0();
        ArrayList<Integer> S = m.S(n());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < S.size(); i2++) {
            int intValue = S.get(i2).intValue();
            int i3 = 0;
            while (true) {
                if (i3 >= q02.size()) {
                    z = false;
                    break;
                }
                g gVar = q02.get(i3);
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
                    if (i4 >= p02.size()) {
                        break;
                    }
                    b0 b0Var = p02.get(i4);
                    if (intValue == b0Var.d()) {
                        arrayList.add(b0Var);
                        break;
                    }
                    i4++;
                }
            }
        }
        if (m.g0(n())) {
            arrayList.add(new b0(-100, Q(R.string.crisis_resources), Q(R.string.crisis_resources), null, null));
        }
        if (m.k0(n())) {
            arrayList.add(new b0(-101, Q(R.string.safety_plan), Q(R.string.safety_plan), null, null));
        }
        this.v0 = arrayList.size();
        this.p0.setAdapter(new u0((Act_home) n(), arrayList));
        m.M0(n().getApplication(), false);
    }

    public void e2() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(n(), 0, false);
        this.t0 = linearLayoutManager;
        this.p0.setLayoutManager(linearLayoutManager);
        h0 h0Var = new h0();
        this.s0 = h0Var;
        h0Var.b(this.p0);
        this.p0.l(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_home) n();
        super.o0(bundle);
    }

    public void onClick(View view) {
        if (view.getId() == this.m0.getId()) {
            this.c0.r0();
        }
        if (view.getId() == this.n0.getId()) {
            F1(new Intent(n(), Act_new_reminders.class));
        }
        if (view.getId() == this.i0.getId()) {
            d.j(n(), "15106");
            Intent intent = new Intent(n(), Act_tabs.class);
            intent.putExtra("cur_tab", 0);
            F1(intent);
        }
        if (view.getId() == this.h0.getId()) {
            d.j(n(), "14920");
            Intent intent2 = new Intent(n(), Act_tabs.class);
            intent2.putExtra("cur_tab", 1);
            F1(intent2);
        }
        if (view.getId() == this.g0.getId()) {
            d.j(n(), "14584");
            Intent intent3 = new Intent(n(), Act_tabs.class);
            intent3.putExtra("cur_tab", 2);
            F1(intent3);
        }
        if (view.getId() == this.j0.getId()) {
            d.j(n(), "15215");
            Intent intent4 = new Intent(n(), Act_tabs.class);
            intent4.putExtra("cur_tab", 3);
            F1(intent4);
        }
        if (view.getId() == this.q0.getId()) {
            d.j(n(), "15218");
            int i2 = this.u0;
            if (i2 != 0) {
                this.p0.s1(i2 - 1);
            }
        }
        if (view.getId() == this.r0.getId()) {
            d.j(n(), "15219");
            int i3 = this.u0;
            if (i3 + 1 < this.v0 + 1) {
                this.p0.s1(i3 + 4);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (m.c(n())) {
            view = layoutInflater.inflate(R.layout.frag_home_w_quotes, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R.layout.frag_home, viewGroup, false);
        }
        this.f0 = (LinearLayout) view.findViewById(R.id.frag_home_layout);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.frag_home_layout_top);
        this.e0 = (RelativeLayout) view.findViewById(R.id.frag_home_layout_center);
        this.d0 = (LinearLayout) view.findViewById(R.id.frag_home_layout_bottom);
        this.g0 = (LinearLayout) view.findViewById(R.id.frag_home_layout_manage_symptoms);
        this.h0 = (LinearLayout) view.findViewById(R.id.frag_home_layout_mood_check);
        this.i0 = (LinearLayout) view.findViewById(R.id.frag_home_layout_learn);
        this.j0 = (LinearLayout) view.findViewById(R.id.frag_home_layout_support);
        this.k0 = (AppCompatTextView) view.findViewById(R.id.home_txt_title);
        this.m0 = (ImageView) view.findViewById(R.id.home_icon_drawer);
        this.n0 = (ImageView) view.findViewById(R.id.home_icon_reminders);
        this.p0 = (RecyclerView) view.findViewById(R.id.frag_home_rview_favorite);
        this.q0 = (ImageView) view.findViewById(R.id.frag_home_img_left);
        this.r0 = (ImageView) view.findViewById(R.id.frag_home_img_right);
        this.l0 = (AppCompatTextView) view.findViewById(R.id.frag_home_quote_text);
        this.o0 = (ImageView) view.findViewById(R.id.frag_home_img_track_symptoms);
        this.m0.setOnClickListener(this);
        this.n0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        e2();
        this.k0.setText(R.string.app_name);
        this.p0.setHasFixedSize(true);
        ViewGroup.LayoutParams layoutParams = this.d0.getLayoutParams();
        double q = (double) j.q(n1());
        Double.isNaN(q);
        layoutParams.height = (int) (q / 6.5d);
        if (m.c(n())) {
            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.frag_home_sview_layout_quote);
            ((LinearLayout) view.findViewById(R.id.frag_home_layout_quote)).setVisibility(0);
            nestedScrollView.setBackgroundColor(b.h.d.a.b(n(), R.color.colorPrimary));
            nestedScrollView.getLayoutParams().height = j.q(n1()) / 6;
            ((LinearLayout.LayoutParams) this.e0.getLayoutParams()).weight = 1.0f;
        } else {
            this.f0.setBackgroundResource(R.drawable.app_bg);
            ((LinearLayout.LayoutParams) this.e0.getLayoutParams()).weight = 1.0f;
        }
        m.M0(n().getApplication(), true);
        d.l(n(), "home", "view", null);
        return view;
    }
}
