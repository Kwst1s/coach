package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.k0;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.s;
import f.a.a.a.b.i.h;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav.Act_rewarding_good_behavior_add_reward;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.m.b.d;
import kotlin.m.b.f;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_rewarding_good_behavior.kt */
public final class b0 extends vainstrum.Components.b implements View.OnClickListener {
    private static final String n0 = "tool";
    private static final String o0 = "selected_tool";
    private static final String p0 = "symptom";
    private static final String q0 = "old_distress";
    private static final String r0 = "last_tool_name";
    public static final a s0 = new a(null);
    private Act_manage c0;
    private f.a.a.a.b.d.b0 d0;
    private f.a.a.a.b.d.b0 e0;
    private a0 f0;
    private int g0;
    private String h0;
    private boolean i0;
    private boolean j0;
    private BroadcastReceiver k0;
    public ArrayList<s> l0;
    private HashMap m0;

    /* compiled from: Frag_tool_rewarding_good_behavior.kt */
    public static final class a {
        private a() {
        }

        public final b0 a(f.a.a.a.b.d.b0 b0Var, f.a.a.a.b.d.b0 b0Var2, a0 a0Var, int i2, String str) {
            b0 b0Var3 = new b0();
            Bundle bundle = new Bundle();
            bundle.putSerializable(b0.n0, b0Var);
            bundle.putSerializable(b0.o0, b0Var2);
            bundle.putSerializable(b0.p0, a0Var);
            bundle.putInt(b0.q0, i2);
            bundle.putString(b0.r0, str);
            b0Var3.v1(bundle);
            return b0Var3;
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* compiled from: Frag_tool_rewarding_good_behavior.kt */
    public static final class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b0 f9460a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(b0 b0Var) {
            this.f9460a = b0Var;
        }

        public void onReceive(Context context, Intent intent) {
            f.e(context, "context");
            f.e(intent, "intent");
            if (!f.a(intent.getAction(), "gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (this.f9460a.g0 == -1) {
                Act_manage act_manage = this.f9460a.c0;
                f.c(act_manage);
                act_manage.finish();
                return;
            }
            h W1 = h.W1(this.f9460a.h2(), this.f9460a.g2(), this.f9460a.g0, this.f9460a.h0);
            f.d(W1, "frag");
            W1.V1(this.f9460a.R1());
            Act_manage act_manage2 = this.f9460a.c0;
            f.c(act_manage2);
            act_manage2.W(W1, this.f9460a.Q(R.string.distress_meter));
        }
    }

    /* compiled from: Frag_tool_rewarding_good_behavior.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b0 f9461b;

        c(b0 b0Var) {
            this.f9461b = b0Var;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9461b.p1(), Act_rewarding_good_behavior_add_reward.class);
            intent.putExtra("fromNone", false);
            this.f9461b.F1(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n1().unregisterReceiver(this.k0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.k0 = new b(this);
        n1().registerReceiver(this.k0, intentFilter);
        i2();
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        f.e(view, "view");
        super.N0(view, bundle);
        int i2 = o.rewarding_good_behavior_img;
        ImageView imageView = (ImageView) X1(i2);
        f.d(imageView, "rewarding_good_behavior_img");
        imageView.getLayoutParams().height = m.H(n());
        ((ImageView) X1(i2)).setImageResource(R.drawable.img_rew_new_behavior);
        int i3 = o.bottom_tool_btn_thumb_up;
        ((FABTracking) X1(i3)).setOnClickListener(this);
        int i4 = o.bottom_tool_btn_thumb_down;
        ((FABTracking) X1(i4)).setOnClickListener(this);
        ((ButtonTracking) X1(o.bottom_tool_btn_new_tool)).setOnClickListener(this);
        f.a.a.a.b.d.b0 b0Var = this.e0;
        f.c(b0Var);
        m.f0(b0Var.d(), (FABTracking) X1(i3), (FABTracking) X1(i4));
        androidx.fragment.app.d n = n();
        f.a.a.a.b.d.b0 b0Var2 = this.e0;
        f.c(b0Var2);
        this.j0 = m.C0(n, b0Var2.d(), (FABTracking) X1(i3), false);
        androidx.fragment.app.d n2 = n();
        f.a.a.a.b.d.b0 b0Var3 = this.e0;
        f.c(b0Var3);
        this.i0 = m.B0(n2, b0Var3.d(), (FABTracking) X1(i4), false);
        try {
            g0.k(n(), D(), (LinearLayout) X1(o.rewarding_good_behavior_layout_container), j.N(n(), g.K), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i5 = o.bottom_tool_btn_add;
        ((FABTracking) X1(i5)).setOnClickListener(new c(this));
        FABTracking fABTracking = (FABTracking) X1(i5);
        f.d(fABTracking, "bottom_tool_btn_add");
        fABTracking.setContentDescription(Q(R.string.add_i_message));
        if (this.f0 == null) {
            ButtonTracking buttonTracking = (ButtonTracking) X1(o.bottom_tool_btn_new_tool);
            f.d(buttonTracking, "bottom_tool_btn_new_tool");
            buttonTracking.setVisibility(8);
        }
        int i6 = o.rewarding_good_behavior_rview;
        RecyclerView recyclerView = (RecyclerView) X1(i6);
        f.d(recyclerView, "rewarding_good_behavior_rview");
        recyclerView.setLayoutManager(new LinearLayoutManager(n()));
        ((RecyclerView) X1(i6)).setHasFixedSize(true);
    }

    public void W1() {
        HashMap hashMap = this.m0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.m0 == null) {
            this.m0 = new HashMap();
        }
        View view = (View) this.m0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.m0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final a0 g2() {
        return this.f0;
    }

    public final f.a.a.a.b.d.b0 h2() {
        return this.d0;
    }

    public final void i2() {
        Context p1 = p1();
        f.d(p1, "requireContext()");
        ArrayList<s> K = new y(p1).K();
        this.l0 = K;
        if (K == null) {
            f.p("rgbs");
            throw null;
        } else if (!K.isEmpty()) {
            ((LinearLayout) X1(o.rewarding_good_behavior_layout_total)).setBackgroundResource(R.drawable.app_bg);
            LinearLayout linearLayout = (LinearLayout) X1(o.rewarding_good_behavior_layout_no_elements);
            f.d(linearLayout, "rewarding_good_behavior_layout_no_elements");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) X1(o.rewarding_good_behavior_layout);
            f.d(linearLayout2, "rewarding_good_behavior_layout");
            linearLayout2.setVisibility(0);
            androidx.fragment.app.d n1 = n1();
            f.d(n1, "requireActivity()");
            ArrayList<s> arrayList = this.l0;
            if (arrayList != null) {
                k0 k0Var = new k0(n1, arrayList);
                RecyclerView recyclerView = (RecyclerView) X1(o.rewarding_good_behavior_rview);
                f.d(recyclerView, "rewarding_good_behavior_rview");
                recyclerView.setAdapter(k0Var);
                return;
            }
            f.p("rgbs");
            throw null;
        } else {
            ((LinearLayout) X1(o.rewarding_good_behavior_layout_total)).setBackgroundColor(b.h.d.a.b(p1(), R.color.grey_hh_light));
            LinearLayout linearLayout3 = (LinearLayout) X1(o.rewarding_good_behavior_layout_no_elements);
            f.d(linearLayout3, "rewarding_good_behavior_layout_no_elements");
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = (LinearLayout) X1(o.rewarding_good_behavior_layout);
            f.d(linearLayout4, "rewarding_good_behavior_layout");
            linearLayout4.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        androidx.fragment.app.d n1 = n1();
        Objects.requireNonNull(n1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage");
        this.c0 = (Act_manage) n1;
        Bundle o1 = o1();
        String str = o0;
        if (o1.containsKey(str)) {
            this.d0 = (f.a.a.a.b.d.b0) o1().getSerializable(str);
        }
        if (o1().containsKey(str)) {
            this.e0 = (f.a.a.a.b.d.b0) o1().getSerializable(str);
        }
        Bundle o12 = o1();
        String str2 = p0;
        if (o12.containsKey(str2)) {
            this.f0 = (a0) o1().getSerializable(str2);
        }
        this.g0 = o1().getInt(q0);
        this.h0 = o1().getString(r0);
        androidx.fragment.app.d n = n();
        f.a.a.a.b.d.b0 b0Var = this.e0;
        k.b.d.u(n, b0Var != null ? b0Var.g() : null);
    }

    public void onClick(View view) {
        f.c(view);
        int id = view.getId();
        int i2 = o.bottom_tool_btn_thumb_up;
        FABTracking fABTracking = (FABTracking) X1(i2);
        f.d(fABTracking, "bottom_tool_btn_thumb_up");
        if (id == fABTracking.getId()) {
            this.j0 = m.o(n(), this.e0, (FABTracking) X1(i2), (FABTracking) X1(o.bottom_tool_btn_thumb_down), Boolean.valueOf(this.j0), Boolean.valueOf(this.i0));
            this.i0 = false;
        }
        int id2 = view.getId();
        int i3 = o.bottom_tool_btn_thumb_down;
        FABTracking fABTracking2 = (FABTracking) X1(i3);
        f.d(fABTracking2, "bottom_tool_btn_thumb_down");
        if (id2 == fABTracking2.getId()) {
            this.i0 = m.n(n(), this.e0, (FABTracking) X1(i2), (FABTracking) X1(i3), Boolean.valueOf(this.j0), Boolean.valueOf(this.i0));
            this.j0 = false;
        }
        int id3 = view.getId();
        ButtonTracking buttonTracking = (ButtonTracking) X1(o.bottom_tool_btn_new_tool);
        f.d(buttonTracking, "bottom_tool_btn_new_tool");
        if (id3 == buttonTracking.getId()) {
            m.c0(true, this.c0, this.f0, this.d0, this.g0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_tool_rewarding_good_behavior, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
