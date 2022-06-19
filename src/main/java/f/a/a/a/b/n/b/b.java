package f.a.a.a.b.n.b;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext_content;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_new_goal;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;

/* compiled from: Frag_create_goal_txt */
public class b extends vainstrum.Components.b {
    private Act_new_goal c0;
    private EditText d0;
    private ImageView e0;
    private LinearLayout f0;

    /* compiled from: Frag_create_goal_txt */
    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() != 0) {
                b.this.c0.e0(true);
            } else {
                b.this.c0.e0(false);
            }
        }
    }

    /* renamed from: f.a.a.a.b.n.b.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_create_goal_txt */
    class View$OnFocusChangeListenerC0215b implements View.OnFocusChangeListener {
        View$OnFocusChangeListenerC0215b() {
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                b.this.Y1(view);
            }
        }
    }

    /* compiled from: Frag_create_goal_txt */
    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(b.this.p1(), Act_jtext_content.class);
            intent.putExtra("title", b.this.Q(R.string.help_c));
            intent.putExtra("content", j.N(b.this.p1(), "goals_help.json"));
            b.this.F1(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
    }

    public void X1() {
        Act_new_goal act_new_goal;
        if (!this.d0.getText().toString().isEmpty() && (act_new_goal = this.c0) != null) {
            act_new_goal.g0(this.d0.getText().toString());
            this.c0.Z();
        }
        Y1(this.d0);
    }

    public void Y1(View view) {
        ((InputMethodManager) n().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_new_goal) n();
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_create_goal_txt, viewGroup, false);
        this.d0 = (EditText) inflate.findViewById(R.id.create_goal_txt_edt);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.create_goal_layout_examples);
        this.e0 = (ImageView) inflate.findViewById(R.id.create_goal_img_help);
        this.d0.addTextChangedListener(new a());
        this.d0.setOnFocusChangeListener(new View$OnFocusChangeListenerC0215b());
        try {
            g0.k(n1(), D(), this.f0, j.N(n(), "create_goal_hint.json"), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.e0.setOnClickListener(new c());
        return inflate;
    }
}
