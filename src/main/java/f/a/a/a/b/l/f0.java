package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_treatment_locator */
public class f0 extends b implements View.OnClickListener, TextWatcher {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private gov.va.mobilehealth.ncptsd.covid.CComp.f0 g0;
    private EditText h0;
    private EditText i0;
    private EditText j0;
    private EditText k0;
    private EditText l0;
    private Button m0;
    private Button n0;
    private int o0 = 1;
    private boolean p0 = true;
    private b0 q0;
    private b0 r0;
    private a0 s0;
    private int t0;
    private String u0;
    private Boolean v0;
    private Boolean w0;
    private BroadcastReceiver x0;

    /* compiled from: Frag_tool_treatment_locator */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (f0.this.t0 == -1) {
                f0.this.c0.finish();
                return;
            }
            h W1 = h.W1(f0.this.q0, f0.this.s0, f0.this.t0, f0.this.u0);
            W1.V1(f0.this.R1());
            f0.this.c0.W(W1, f0.this.Q(R.string.distress_meter));
        }
    }

    public f0() {
        Boolean bool = Boolean.FALSE;
        this.v0 = bool;
        this.w0 = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: c2 */
    public /* synthetic */ void d2(View view, boolean z) {
        this.h0.selectAll();
        this.o0 = 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void f2(View view, boolean z) {
        this.h0.selectAll();
        this.o0 = 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ void h2(View view, boolean z) {
        this.h0.selectAll();
        this.o0 = 3;
    }

    /* access modifiers changed from: private */
    /* renamed from: i2 */
    public /* synthetic */ void j2(View view, boolean z) {
        this.h0.selectAll();
        this.o0 = 4;
    }

    /* access modifiers changed from: private */
    /* renamed from: k2 */
    public /* synthetic */ void l2(View view, boolean z) {
        this.h0.selectAll();
        this.o0 = 5;
    }

    public static f0 m2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        f0 f0Var = new f0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        f0Var.v1(bundle);
        return f0Var;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.x0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.x0 = new a();
        try {
            n().registerReceiver(this.x0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    public void afterTextChanged(Editable editable) {
        this.p0 = true;
    }

    public void b2() {
        String obj = this.h0.getText().toString();
        String obj2 = this.i0.getText().toString();
        String obj3 = this.j0.getText().toString();
        String obj4 = this.k0.getText().toString();
        String obj5 = this.l0.getText().toString();
        if (obj.equals("_") || obj2.equals("_") || obj3.equals("_") || obj4.equals("_") || obj5.equals("_")) {
            this.m0.setEnabled(false);
        } else {
            this.m0.setEnabled(true);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void n2(boolean z) {
        int i2 = this.o0;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            if (z) {
                                s.a(this.m0);
                                this.m0.requestFocus();
                                j.d(n(), this.l0);
                                return;
                            }
                            this.k0.requestFocus();
                        }
                    } else if (z) {
                        this.l0.requestFocus();
                    } else {
                        this.j0.requestFocus();
                    }
                } else if (z) {
                    this.k0.requestFocus();
                } else {
                    this.i0.requestFocus();
                }
            } else if (z) {
                this.j0.requestFocus();
            } else {
                this.h0.requestFocus();
            }
        } else if (z) {
            this.i0.requestFocus();
        } else {
            this.k0.requestFocus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.q0 = (b0) bundle.getSerializable("tool");
            this.r0 = (b0) bundle.getSerializable("selected_tool");
            this.s0 = (a0) bundle.getSerializable("symptom");
            this.t0 = bundle.getInt("old_distress");
            this.u0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.q0 = (b0) u().getSerializable("tool");
            this.r0 = (b0) u().getSerializable("selected_tool");
            this.s0 = (a0) u().getSerializable("symptom");
            this.t0 = u().getInt("old_distress");
            this.u0 = u().getString("last_tool_name");
            d.u(n(), this.r0.g());
        }
    }

    public void onClick(View view) {
        String str = this.h0.getText().toString() + this.i0.getText().toString() + this.j0.getText().toString() + this.k0.getText().toString() + this.l0.getText().toString();
        if (view.getId() == this.m0.getId()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://therapists.psychologytoday.com/rms/prof_results.php?search=" + str));
            F1(intent);
        }
        if (view.getId() == this.n0.getId()) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(String.format("https://www.va.gov/find-locations/?zoomLevel=4&page=1&address=%s&facilityType=health&serviceType", str)));
            F1(intent2);
        }
        if (view.getId() == this.d0.getId()) {
            this.w0 = Boolean.valueOf(m.o(n(), this.r0, this.d0, this.e0, this.w0, this.v0));
            this.v0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.v0 = Boolean.valueOf(m.n(n(), this.r0, this.d0, this.e0, this.w0, this.v0));
            this.w0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.s0, this.q0, this.t0);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence.length() < 1) {
            int i5 = this.o0;
            if (i5 == 1) {
                this.p0 = false;
                this.h0.setText("_");
            } else if (i5 == 2) {
                this.p0 = false;
                this.i0.setText("_");
            } else if (i5 == 3) {
                this.p0 = false;
                this.j0.setText("_");
            } else if (i5 == 4) {
                this.p0 = false;
                this.k0.setText("_");
            } else if (i5 == 5) {
                this.p0 = false;
                this.l0.setText("_");
            }
            n2(false);
            this.p0 = true;
        } else if (this.p0) {
            n2(true);
        }
        b2();
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_treatment_locator, viewGroup, false);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.h0 = (EditText) inflate.findViewById(R.id.t_locator_edt_1);
        this.i0 = (EditText) inflate.findViewById(R.id.t_locator_edt_2);
        this.j0 = (EditText) inflate.findViewById(R.id.t_locator_edt_3);
        this.k0 = (EditText) inflate.findViewById(R.id.t_locator_edt_4);
        this.l0 = (EditText) inflate.findViewById(R.id.t_locator_edt_5);
        this.m0 = (Button) inflate.findViewById(R.id.t_locator_btn_mental_health_providers);
        this.n0 = (Button) inflate.findViewById(R.id.t_locator_btn_samsha);
        double r = (double) j.r(n());
        Double.isNaN(r);
        int i2 = (int) (r / 2.5d);
        this.g0.getLayoutParams().width = i2;
        this.g0.getLayoutParams().height = i2;
        this.g0.a(n());
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        if (this.s0 == null) {
            this.f0.setVisibility(8);
        }
        this.h0.setOnFocusChangeListener(new l(this));
        this.i0.setOnFocusChangeListener(new k(this));
        this.j0.setOnFocusChangeListener(new m(this));
        this.k0.setOnFocusChangeListener(new j(this));
        this.l0.setOnFocusChangeListener(new i(this));
        this.h0.addTextChangedListener(this);
        this.i0.addTextChangedListener(this);
        this.j0.addTextChangedListener(this);
        this.k0.addTextChangedListener(this);
        this.l0.addTextChangedListener(this);
        m.f0(this.r0.d(), this.d0, this.e0);
        this.w0 = Boolean.valueOf(m.C0(n(), this.r0.d(), this.d0, false));
        this.v0 = Boolean.valueOf(m.B0(n(), this.r0.d(), this.e0, false));
        return inflate;
    }
}
