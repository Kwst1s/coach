package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.q0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.FABTracking;

public class Act_tool_sublist extends f {
    private b0 A;
    private ArrayList<b0> B;
    private Boolean C;
    private Boolean D;
    private RecyclerView u;
    private Toolbar v;
    private AppCompatTextView w;
    private AppCompatImageView x;
    private FABTracking y;
    private FABTracking z;

    public Act_tool_sublist() {
        Boolean bool = Boolean.FALSE;
        this.C = bool;
        this.D = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X(View view) {
        this.D = Boolean.valueOf(m.o(this, this.A, this.y, this.z, this.D, this.C));
        this.C = Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void Z(View view) {
        this.C = Boolean.valueOf(m.n(this, this.A, this.y, this.z, this.D, this.C));
        this.D = Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(View view) {
        Intent intent = new Intent(getApplicationContext(), Act_cluster_tool_intro.class);
        intent.putExtra("selected_tool", this.A);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(gov.va.mobilehealth.ncptsd.covid.CComp.b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.A = (b0) getIntent().getSerializableExtra("tool");
        setContentView(R.layout.act_tool_sublist);
        this.u = (RecyclerView) findViewById(R.id.tool_sublist_rview);
        this.x = (AppCompatImageView) findViewById(R.id.tool_sublist_img_info);
        this.v = (Toolbar) findViewById(R.id.tool_sublist_toolbar);
        this.w = (AppCompatTextView) findViewById(R.id.tool_sublist_txt_title);
        this.y = (FABTracking) findViewById(R.id.tool_sublist_btn_thumb_up);
        this.z = (FABTracking) findViewById(R.id.tool_sublist_btn_thumb_down);
        this.u.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.u.setHasFixedSize(true);
        this.w.setText(this.A.a());
        this.B = m.s0(getApplicationContext(), this.A.e());
        ((LinearLayout.LayoutParams) this.v.getLayoutParams()).setMargins(0, j.v(this), 0, 0);
        this.u.setAdapter(new q0(this, this.B, null, null, null));
        this.y.setOnClickListener(new e0(this));
        this.z.setOnClickListener(new d0(this));
        this.D = Boolean.valueOf(m.C0(this, this.A.d(), this.y, false));
        this.C = Boolean.valueOf(m.B0(this, this.A.d(), this.z, false));
        s.p(this, this.A.a());
        if (this.A.i()) {
            this.x.setVisibility(0);
            this.x.setOnClickListener(new c0(this));
        }
        T(this.v);
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
