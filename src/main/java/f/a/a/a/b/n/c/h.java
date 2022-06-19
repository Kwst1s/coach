package f.a.a.a.b.n.c;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.j;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.p;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import k.b.d;
import org.json.JSONException;
import org.json.JSONObject;
import vainstrum.Components.b;

/* compiled from: Frag_assessment_results */
public class h extends b {
    private int c0;
    private ArrayList<p> d0;
    private boolean e0;
    private f.a.a.a.b.d.b f0;
    private LinearLayout g0;
    private TextView h0;
    private Button i0;
    private boolean j0 = false;

    /* compiled from: Frag_assessment_results */
    class a implements Runnable {
        a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(View view) {
            if (!h.this.j0) {
                if (!h.this.e0) {
                    h.this.j0 = true;
                    u uVar = new u(h.this.n());
                    f.a.a.a.b.d.b A0 = uVar.A0(j.I0);
                    uVar.l(new f.a.a.a.b.d.b(System.currentTimeMillis(), h.this.d0, h.this.c0), j.I0);
                    d.g(h.this.n(), "PTSDsymptoms", m.i(h.this.n(), h.this.d0), h.this.c0);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("score", h.this.c0);
                        if (A0 != null) {
                            long currentTimeMillis = System.currentTimeMillis() - A0.a();
                            jSONObject.put("change_score", h.this.c0 - A0.c());
                            jSONObject.put("days", TimeUnit.MILLISECONDS.toDays(currentTimeMillis));
                        } else {
                            jSONObject.put("change_score", JSONObject.NULL);
                            jSONObject.put("days", JSONObject.NULL);
                        }
                        d.l(h.this.n(), "pcl5", "assessment", jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                h.this.n().finish();
            }
        }

        public void run() {
            h.this.i0.setOnClickListener(new c(this));
        }
    }

    public static h c2(int i2, ArrayList<p> arrayList, boolean z, f.a.a.a.b.d.b bVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putInt("points", i2);
        bundle.putSerializable("q_points", arrayList);
        bundle.putBoolean("noSave", z);
        bundle.putSerializable("prevData", bVar);
        hVar.v1(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        this.j0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.c0 = u().getInt("points");
            this.d0 = (ArrayList) u().getSerializable("q_points");
            this.e0 = u().getBoolean("noSave");
            this.f0 = (f.a.a.a.b.d.b) u().getSerializable("prevData");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Calendar.getInstance().setTimeInMillis(gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getLong("next_assessment", System.currentTimeMillis()));
        View inflate = layoutInflater.inflate(R.layout.frag_assessment_results, (ViewGroup) null);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.assessment_results_content);
        this.h0 = (TextView) inflate.findViewById(R.id.assessment_results_txt_score);
        this.i0 = (Button) inflate.findViewById(R.id.assessment_results_btn_done);
        new Handler().postDelayed(new a(), 400);
        if (this.e0) {
            this.i0.setVisibility(8);
        }
        this.j0 = false;
        this.h0.setText(Integer.toString(this.c0));
        g0.k(n(), D(), this.g0, m.Q(n(), this.c0, this.e0, this.f0), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        return inflate;
    }
}
