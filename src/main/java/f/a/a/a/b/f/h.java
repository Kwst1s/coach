package f.a.a.a.b.f;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.c;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;

/* compiled from: Dialog_DisclaimerFeedback */
public class h extends c {
    private AppCompatButton l0;
    private AppCompatTextView m0;
    private LinearLayout n0;
    private AppCompatCheckBox o0;
    private int p0;

    /* compiled from: Dialog_DisclaimerFeedback */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            h.this.o0.setChecked(!h.this.o0.isChecked());
            if (h.this.o0.isChecked()) {
                d.k(h.this.Q(R.string.do_not_show_again));
                return;
            }
            d.k(h.this.Q(R.string.do_not_show_again) + " selected");
        }
    }

    /* compiled from: Dialog_DisclaimerFeedback */
    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                LinearLayout linearLayout = h.this.n0;
                linearLayout.setContentDescription(h.this.Q(R.string.do_not_show_again) + " " + h.this.Q(R.string.checked) + h.this.Q(R.string.button));
                return;
            }
            LinearLayout linearLayout2 = h.this.n0;
            linearLayout2.setContentDescription(h.this.Q(R.string.do_not_show_again) + " " + h.this.Q(R.string.unchecked) + h.this.Q(R.string.button));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Y1 */
    public /* synthetic */ void Z1(View view) {
        d.k(Q(R.string.i_understand));
        if (this.p0 == 0) {
            j.u(n()).putBoolean("feedback_disclaimer", !this.o0.isChecked()).apply();
            if (b0.a(p1()).equals("es")) {
                j.M(n1(), "https://redcap.stanford.edu/surveys/?s=M3WJT33M4D");
            } else {
                j.M(n1(), "https://redcap.stanford.edu/surveys/?s=NPH4YWATPM");
            }
        } else {
            j.u(n()).putBoolean("feedback_disclaimer2", !this.o0.isChecked()).apply();
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.putExtra("android.intent.extra.EMAIL", new String[]{"mobileux@va.gov"});
            intent2.putExtra("android.intent.extra.SUBJECT", Q(R.string.email_subj));
            intent2.setSelector(intent);
            F1(Intent.createChooser(intent2, "Send email..."));
        }
        M1();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void L0() {
        super.L0();
        Dialog O1 = O1();
        if (O1 != null) {
            double r = (double) j.r(n());
            Double.isNaN(r);
            O1.getWindow().setLayout((int) (r / 1.1d), -2);
        }
    }

    public void X1(int i2) {
        this.p0 = i2;
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.dialog_frag_disclaimer_feedback, viewGroup, false);
        this.l0 = (AppCompatButton) inflate.findViewById(R.id.dialog_disclaimer_btn_understand);
        this.n0 = (LinearLayout) inflate.findViewById(R.id.dialog_disclaimer_layout_check);
        this.m0 = (AppCompatTextView) inflate.findViewById(R.id.dialog_disclaimer_feedback);
        this.o0 = (AppCompatCheckBox) inflate.findViewById(R.id.dialog_disclaimer_layout_checkbox);
        if (this.p0 == 0) {
            str = j.N(n(), "feedback_disclaimer.txt");
        } else {
            str = j.N(n(), "feedback_disclaimer2.txt");
        }
        this.m0.setText(str);
        this.m0.setContentDescription(str);
        this.l0.setOnClickListener(new a(this));
        LinearLayout linearLayout = this.n0;
        linearLayout.setContentDescription(Q(R.string.do_not_show_message_again) + " " + Q(R.string.checked) + Q(R.string.button));
        this.n0.setOnClickListener(new a());
        this.o0.setOnCheckedChangeListener(new b());
        s.a(this.m0);
        return inflate;
    }
}
