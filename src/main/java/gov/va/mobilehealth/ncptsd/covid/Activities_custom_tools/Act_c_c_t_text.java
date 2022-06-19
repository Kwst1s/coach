package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;

public class Act_c_c_t_text extends f implements View.OnClickListener {
    private Toolbar u;
    private EditText v;
    private Button w;
    private String x;

    class a implements DialogInterface.OnClickListener {
        a(Act_c_c_t_text act_c_c_t_text) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void onClick(View view) {
        if (view.getId() != this.w.getId()) {
            return;
        }
        if (!this.v.getText().toString().isEmpty()) {
            Intent intent = new Intent();
            intent.putExtra("text", this.v.getText().toString());
            setResult(-1, intent);
            finish();
            return;
        }
        b.a h2 = j.h(this, getString(R.string.please_input_a_text));
        h2.k(R.string.ok, new a(this));
        h2.a().show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.x = getIntent().getStringExtra("text");
        }
        setContentView(R.layout.act_c_c_t_text);
        this.u = (Toolbar) findViewById(R.id.c_c_t_text_toolbar);
        this.v = (EditText) findViewById(R.id.c_c_t_text_edt_text);
        this.w = (Button) findViewById(R.id.c_c_t_text_btn_save);
        m.R0(this, findViewById(R.id.c_c_t_text_layout));
        this.w.setOnClickListener(this);
        String str = this.x;
        if (str != null) {
            this.v.setText(str);
        }
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
