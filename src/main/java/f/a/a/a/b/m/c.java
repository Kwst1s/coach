package f.a.a.a.b.m;

import android.content.Intent;
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
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;

/* compiled from: Frag_tool_learn_treatment_locator */
public class c extends vainstrum.Components.b implements View.OnClickListener, TextWatcher {
    private EditText c0;
    private EditText d0;
    private EditText e0;
    private EditText f0;
    private EditText g0;
    private Button h0;
    private Button i0;
    private Button j0;
    private int k0 = 1;
    private boolean l0 = true;

    /* compiled from: Frag_tool_learn_treatment_locator */
    class a implements View.OnFocusChangeListener {
        a() {
        }

        public void onFocusChange(View view, boolean z) {
            c.this.c0.selectAll();
            c.this.k0 = 1;
        }
    }

    /* compiled from: Frag_tool_learn_treatment_locator */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        public void onFocusChange(View view, boolean z) {
            c.this.c0.selectAll();
            c.this.k0 = 2;
        }
    }

    /* renamed from: f.a.a.a.b.m.c$c  reason: collision with other inner class name */
    /* compiled from: Frag_tool_learn_treatment_locator */
    class View$OnFocusChangeListenerC0213c implements View.OnFocusChangeListener {
        View$OnFocusChangeListenerC0213c() {
        }

        public void onFocusChange(View view, boolean z) {
            c.this.c0.selectAll();
            c.this.k0 = 3;
        }
    }

    /* compiled from: Frag_tool_learn_treatment_locator */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z) {
            c.this.c0.selectAll();
            c.this.k0 = 4;
        }
    }

    /* compiled from: Frag_tool_learn_treatment_locator */
    class e implements View.OnFocusChangeListener {
        e() {
        }

        public void onFocusChange(View view, boolean z) {
            c.this.c0.selectAll();
            c.this.k0 = 5;
        }
    }

    public void Y1() {
        String obj = this.c0.getText().toString();
        String obj2 = this.d0.getText().toString();
        String obj3 = this.e0.getText().toString();
        String obj4 = this.f0.getText().toString();
        String obj5 = this.g0.getText().toString();
        if (obj.equals("_") || obj2.equals("_") || obj3.equals("_") || obj4.equals("_") || obj5.equals("_")) {
            this.i0.setEnabled(false);
            this.h0.setEnabled(false);
            return;
        }
        this.i0.setEnabled(true);
        this.h0.setEnabled(true);
    }

    public void Z1(boolean z) {
        int i2 = this.k0;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            if (z) {
                                s.a(this.h0);
                                this.h0.requestFocus();
                                j.d(n(), this.g0);
                                return;
                            }
                            this.f0.requestFocus();
                        }
                    } else if (z) {
                        this.g0.requestFocus();
                    } else {
                        this.e0.requestFocus();
                    }
                } else if (z) {
                    this.f0.requestFocus();
                } else {
                    this.d0.requestFocus();
                }
            } else if (z) {
                this.e0.requestFocus();
            } else {
                this.c0.requestFocus();
            }
        } else if (z) {
            this.d0.requestFocus();
        } else {
            this.f0.requestFocus();
        }
    }

    public void afterTextChanged(Editable editable) {
        this.l0 = true;
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onClick(View view) {
        String str = this.c0.getText().toString() + this.d0.getText().toString() + this.e0.getText().toString() + this.f0.getText().toString() + this.g0.getText().toString();
        if (view.getId() == this.i0.getId()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://therapists.psychologytoday.com/rms/prof_results.php?search=" + str));
            F1(intent);
        }
        if (view.getId() == this.h0.getId()) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(String.format("https://www.va.gov/find-locations/?zoomLevel=4&page=1&address=%s&facilityType=health&serviceType", str)));
            F1(intent2);
        }
        if (view.getId() == this.j0.getId()) {
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setData(Uri.parse("https://findtreatment.samhsa.gov/locator"));
            F1(intent3);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence.length() < 1) {
            int i5 = this.k0;
            if (i5 == 1) {
                this.l0 = false;
                this.c0.setText("_");
            } else if (i5 == 2) {
                this.l0 = false;
                this.d0.setText("_");
            } else if (i5 == 3) {
                this.l0 = false;
                this.e0.setText("_");
            } else if (i5 == 4) {
                this.l0 = false;
                this.f0.setText("_");
            } else if (i5 == 5) {
                this.l0 = false;
                this.g0.setText("_");
            }
            Z1(false);
            this.l0 = true;
        } else if (this.l0) {
            Z1(true);
        }
        Y1();
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_treatment_locator, viewGroup, false);
        inflate.findViewById(R.id.bottom_tool_layout).setVisibility(8);
        this.c0 = (EditText) inflate.findViewById(R.id.t_locator_edt_1);
        this.d0 = (EditText) inflate.findViewById(R.id.t_locator_edt_2);
        this.e0 = (EditText) inflate.findViewById(R.id.t_locator_edt_3);
        this.f0 = (EditText) inflate.findViewById(R.id.t_locator_edt_4);
        this.g0 = (EditText) inflate.findViewById(R.id.t_locator_edt_5);
        this.h0 = (Button) inflate.findViewById(R.id.t_locator_btn_veteran_affairs_treatment);
        this.i0 = (Button) inflate.findViewById(R.id.t_locator_btn_mental_health_providers);
        this.j0 = (Button) inflate.findViewById(R.id.t_locator_btn_samsha);
        this.h0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        if (b0.a(n()).equals("es")) {
            inflate.findViewById(R.id.t_locator_note).setVisibility(8);
        } else {
            inflate.findViewById(R.id.t_locator_note).setVisibility(0);
        }
        this.c0.setOnFocusChangeListener(new a());
        this.d0.setOnFocusChangeListener(new b());
        this.e0.setOnFocusChangeListener(new View$OnFocusChangeListenerC0213c());
        this.f0.setOnFocusChangeListener(new d());
        this.g0.setOnFocusChangeListener(new e());
        this.c0.addTextChangedListener(this);
        this.d0.addTextChangedListener(this);
        this.e0.addTextChangedListener(this);
        this.f0.addTextChangedListener(this);
        this.g0.addTextChangedListener(this);
        return inflate;
    }
}
