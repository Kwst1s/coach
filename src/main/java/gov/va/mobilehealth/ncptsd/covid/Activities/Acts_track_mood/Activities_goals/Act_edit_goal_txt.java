package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;

public class Act_edit_goal_txt extends f {
    private Toolbar u;
    private TextView v;
    private ImageView w;
    private EditText x;
    private String y;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Act_edit_goal_txt.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            k.b.d.p(Act_edit_goal_txt.this.getApplicationContext());
            Intent intent = new Intent();
            intent.putExtra("content", Act_edit_goal_txt.this.x.getText().toString());
            Act_edit_goal_txt.this.setResult(-1, intent);
            Act_edit_goal_txt.this.finish();
        }
    }

    class c implements View.OnFocusChangeListener {
        c() {
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                Act_edit_goal_txt.this.hideKeyboard(view);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                Act_edit_goal_txt.this.hideKeyboard(view);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void hideKeyboard(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.y = getIntent().getStringExtra("content");
        setContentView(R.layout.act_edit_goal_txt);
        this.u = (Toolbar) findViewById(R.id.edit_goal_txt_toolbar);
        this.w = (ImageView) findViewById(R.id.edit_goal_txt_img_cancel);
        this.v = (TextView) findViewById(R.id.edit_goal_txt_txt_save);
        this.x = (EditText) findViewById(R.id.edit_goal_txt_edt);
        this.w.setOnClickListener(new a());
        this.v.setOnClickListener(new b());
        this.x.setOnFocusChangeListener(new c());
        this.x.setText(this.y);
        this.x.setOnFocusChangeListener(new d());
        j.L(this);
        T(this.u);
        M().x(false);
        M().s(false);
        M().t(false);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        j.d(this, this.x);
        super.onPause();
    }
}
