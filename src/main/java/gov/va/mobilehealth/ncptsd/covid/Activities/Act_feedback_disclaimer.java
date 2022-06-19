package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import k.b.d;

public class Act_feedback_disclaimer extends f {
    private Toolbar u;
    private AppCompatButton v;
    private LinearLayout w;
    private LinearLayout x;
    private AppCompatCheckBox y;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            j.u(Act_feedback_disclaimer.this.getApplicationContext()).putBoolean("feedback_disclaimer", !Act_feedback_disclaimer.this.y.isChecked()).apply();
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "mobilementalhealth@va.gov", null));
            intent.putExtra("android.intent.extra.SUBJECT", Act_feedback_disclaimer.this.getString(R.string.email_subj));
            Act_feedback_disclaimer.this.startActivity(Intent.createChooser(intent, "Send Email"));
            Act_feedback_disclaimer.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Act_feedback_disclaimer.this.y.setChecked(!Act_feedback_disclaimer.this.y.isChecked());
        }
    }

    class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                LinearLayout linearLayout = Act_feedback_disclaimer.this.x;
                linearLayout.setContentDescription(Act_feedback_disclaimer.this.getString(R.string.do_not_show_again) + " " + Act_feedback_disclaimer.this.getString(R.string.checked) + Act_feedback_disclaimer.this.getString(R.string.button));
                return;
            }
            LinearLayout linearLayout2 = Act_feedback_disclaimer.this.x;
            linearLayout2.setContentDescription(Act_feedback_disclaimer.this.getString(R.string.do_not_show_again) + " " + Act_feedback_disclaimer.this.getString(R.string.unchecked) + Act_feedback_disclaimer.this.getString(R.string.button));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_feedback_disclaimer);
        this.u = (Toolbar) findViewById(R.id.send_feedback_disclaimer_toolbar);
        this.v = (AppCompatButton) findViewById(R.id.send_feedback_disclaimer_btn_understand);
        this.x = (LinearLayout) findViewById(R.id.send_feedback_disclaimer_layout_check);
        this.w = (LinearLayout) findViewById(R.id.send_feedback_disclaimer_container);
        this.y = (AppCompatCheckBox) findViewById(R.id.send_feedback_disclaimer_layout_checkbox);
        try {
            g0.k(this, getLayoutInflater(), this.w, j.N(getApplicationContext(), "feedback_disclaimer.json"), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.v.setOnClickListener(new a());
        LinearLayout linearLayout = this.x;
        linearLayout.setContentDescription(getString(R.string.do_not_show_message_again) + " " + getString(R.string.checked) + getString(R.string.button));
        this.x.setOnClickListener(new b());
        this.y.setOnCheckedChangeListener(new c());
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
