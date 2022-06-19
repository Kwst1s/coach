package f.a.a.a.b.n.c;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.p;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp.Act_assessment;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import vainstrum.Components.LinearLayoutTracking;
import vainstrum.Components.b;

/* compiled from: Frag_assessment_questionary */
public class g extends b implements View.OnClickListener {
    private Act_assessment c0;
    private LinearLayout d0;
    private LinearLayoutTracking e0;
    private LinearLayoutTracking f0;
    private LinearLayoutTracking g0;
    private LinearLayoutTracking h0;
    private LinearLayoutTracking i0;
    private AppCompatImageView j0;
    private AppCompatImageView k0;
    private AppCompatImageView l0;
    private AppCompatImageView m0;
    private AppCompatImageView n0;
    private AppCompatTextView o0;
    private AppCompatTextView p0;
    private AppCompatTextView q0;
    private AppCompatTextView r0;
    private AppCompatTextView s0;
    private int t0;
    private int u0;
    private ArrayList<p> v0;
    private int w0 = -1;
    private boolean x0 = false;
    private boolean y0 = false;

    /* compiled from: Frag_assessment_questionary */
    class a implements Runnable {
        a() {
        }

        public void run() {
            g.this.e0.setOnClickListener(g.this);
            g.this.f0.setOnClickListener(g.this);
            g.this.g0.setOnClickListener(g.this);
            g.this.h0.setOnClickListener(g.this);
            g.this.i0.setOnClickListener(g.this);
        }
    }

    public static g e2(int i2, int i3, ArrayList<p> arrayList) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putInt("question", i2);
        bundle.putInt("points", i3);
        bundle.putSerializable("q_points", arrayList);
        gVar.v1(bundle);
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        this.y0 = false;
        m.P0(n(), this.d0, m.z(this.c0, this.t0), R.dimen.txt_normal, R.dimen.padding_x_small, false);
        if (this.t0 + 1 == 20) {
            this.x0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putInt("question", this.t0);
        bundle.putInt("points", this.u0);
        bundle.putInt("points_selected", this.w0);
        bundle.putSerializable("q_points", this.v0);
        super.K0(bundle);
    }

    public void b2() {
        if (this.v0 == null) {
            this.v0 = new ArrayList<>();
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.v0.size()) {
                break;
            } else if (this.v0.get(i2).c() == this.t0) {
                this.v0.remove(i2);
                this.v0.add(i2, new p(this.t0, this.w0));
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            this.v0.add(new p(this.t0, this.w0));
        }
    }

    public void c2() {
        if (this.x0) {
            h c2 = h.c2(this.w0 + this.u0, this.v0, false, null);
            c2.V1(R1());
            this.c0.W(c2, Q(R.string.results));
            return;
        }
        int i2 = this.t0 + 1;
        g e2 = e2(i2, this.w0 + this.u0, this.v0);
        e2.V1(R1());
        Act_assessment act_assessment = this.c0;
        act_assessment.W(e2, Q(R.string.question) + " " + Integer.toString(i2 + 1) + " " + Q(R.string.of) + " " + Integer.toString(20));
    }

    public void d2(int i2) {
        this.w0 = i2;
        b2();
        c2();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_assessment) n();
        if (bundle != null) {
            this.t0 = bundle.getInt("question");
            this.u0 = bundle.getInt("points");
            this.v0 = (ArrayList) bundle.getSerializable("q_points");
            this.w0 = bundle.getInt("points_selected");
        } else if (u() != null) {
            this.t0 = u().getInt("question");
            this.u0 = u().getInt("points");
            this.v0 = (ArrayList) u().getSerializable("q_points");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.e0.getId() && !this.y0) {
            this.y0 = true;
            d2(0);
        }
        if (view.getId() == this.f0.getId() && !this.y0) {
            this.y0 = true;
            d2(1);
        }
        if (view.getId() == this.g0.getId() && !this.y0) {
            this.y0 = true;
            d2(2);
        }
        if (view.getId() == this.h0.getId() && !this.y0) {
            this.y0 = true;
            d2(3);
        }
        if (view.getId() == this.i0.getId() && !this.y0) {
            this.y0 = true;
            d2(4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_questionary, (ViewGroup) null);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.question_layout_text);
        this.e0 = (LinearLayoutTracking) inflate.findViewById(R.id.question_btn_not_at_all);
        this.f0 = (LinearLayoutTracking) inflate.findViewById(R.id.question_btn_a_little_bit);
        this.g0 = (LinearLayoutTracking) inflate.findViewById(R.id.question_btn_moderately);
        this.h0 = (LinearLayoutTracking) inflate.findViewById(R.id.question_btn_quite_a_bit);
        this.i0 = (LinearLayoutTracking) inflate.findViewById(R.id.question_btn_extremely);
        this.j0 = (AppCompatImageView) inflate.findViewById(R.id.question_check_not_at_all);
        this.k0 = (AppCompatImageView) inflate.findViewById(R.id.question_check_a_little_bit);
        this.l0 = (AppCompatImageView) inflate.findViewById(R.id.question_check_moderately);
        this.m0 = (AppCompatImageView) inflate.findViewById(R.id.question_check_quite_a_bit);
        this.n0 = (AppCompatImageView) inflate.findViewById(R.id.question_check_extremely);
        this.o0 = (AppCompatTextView) inflate.findViewById(R.id.question_txt_not_at_all);
        this.p0 = (AppCompatTextView) inflate.findViewById(R.id.question_txt_a_little_bit);
        this.q0 = (AppCompatTextView) inflate.findViewById(R.id.question_txt_moderately);
        this.r0 = (AppCompatTextView) inflate.findViewById(R.id.question_txt_quite_a_bit);
        this.s0 = (AppCompatTextView) inflate.findViewById(R.id.question_txt_extremely);
        new Handler().postDelayed(new a(), 500);
        ArrayList<p> arrayList = this.v0;
        if (arrayList != null && this.t0 < arrayList.size()) {
            int a2 = this.v0.get(this.t0).a();
            if (a2 == 0) {
                this.e0.setBackgroundResource(R.drawable.btn_blue_very_rounded);
                this.o0.setTextColor(-1);
                this.j0.setVisibility(0);
                String charSequence = this.f0.getContentDescription().toString();
                LinearLayoutTracking linearLayoutTracking = this.f0;
                linearLayoutTracking.setContentDescription(charSequence + " " + Q(R.string.selected));
            } else if (a2 == 1) {
                this.f0.setBackgroundResource(R.drawable.btn_blue_very_rounded);
                this.p0.setTextColor(-1);
                this.k0.setVisibility(0);
                String charSequence2 = this.f0.getContentDescription().toString();
                LinearLayoutTracking linearLayoutTracking2 = this.f0;
                linearLayoutTracking2.setContentDescription(charSequence2 + " " + Q(R.string.selected));
            } else if (a2 == 2) {
                this.g0.setBackgroundResource(R.drawable.btn_blue_very_rounded);
                this.q0.setTextColor(-1);
                this.l0.setVisibility(0);
                String charSequence3 = this.g0.getContentDescription().toString();
                LinearLayoutTracking linearLayoutTracking3 = this.g0;
                linearLayoutTracking3.setContentDescription(charSequence3 + " " + Q(R.string.selected));
            } else if (a2 == 3) {
                this.h0.setBackgroundResource(R.drawable.btn_blue_very_rounded);
                this.r0.setTextColor(-1);
                this.m0.setVisibility(0);
                String charSequence4 = this.h0.getContentDescription().toString();
                LinearLayoutTracking linearLayoutTracking4 = this.h0;
                linearLayoutTracking4.setContentDescription(charSequence4 + " " + Q(R.string.selected));
            } else if (a2 == 4) {
                this.i0.setBackgroundResource(R.drawable.btn_blue_very_rounded);
                this.s0.setTextColor(-1);
                this.n0.setVisibility(0);
                String charSequence5 = this.i0.getContentDescription().toString();
                LinearLayoutTracking linearLayoutTracking5 = this.i0;
                linearLayoutTracking5.setContentDescription(charSequence5 + " " + Q(R.string.selected));
            }
        }
        this.y0 = false;
        return inflate;
    }
}
