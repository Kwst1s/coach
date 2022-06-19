package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import k.b.d;
import org.json.JSONObject;

/* compiled from: Act_cluster_tool_intro.kt */
public final class Act_cluster_tool_intro extends f {
    public b0 u;
    private HashMap v;

    public View W(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(o.cluster_intro_txt_toolbar);
        kotlin.m.b.f.d(appCompatTextView, "cluster_intro_txt_toolbar");
        b0 b0Var = this.u;
        if (b0Var != null) {
            appCompatTextView.setText(b0Var.a());
            b0 b0Var2 = this.u;
            if (b0Var2 != null) {
                s.p(this, b0Var2.a());
                StringBuilder sb = new StringBuilder();
                sb.append(g.f10086f);
                sb.append(File.separator);
                b0 b0Var3 = this.u;
                if (b0Var3 != null) {
                    sb.append(String.valueOf(b0Var3.d()));
                    sb.append(".json");
                    JSONObject jSONObject = new JSONObject(j.N(getApplicationContext(), sb.toString()));
                    String string = jSONObject.getString("image");
                    String string2 = jSONObject.getString("content");
                    ((ImageView) W(o.cluster_intro_img)).setImageResource(j.m(this, string));
                    g0.k(this, getLayoutInflater(), (LinearLayout) W(o.cluster_intro_layout_content), string2, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                    return;
                }
                kotlin.m.b.f.p("selected_tool");
                throw null;
            }
            kotlin.m.b.f.p("selected_tool");
            throw null;
        }
        kotlin.m.b.f.p("selected_tool");
        throw null;
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
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("selected_tool");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Data.Tool");
        this.u = (b0) serializableExtra;
        setContentView(R.layout.act_cluster_tool_intro);
        ImageView imageView = (ImageView) W(o.cluster_intro_img);
        kotlin.m.b.f.d(imageView, "cluster_intro_img");
        imageView.getLayoutParams().height = m.H(this);
        X();
        T((Toolbar) W(o.cluster_intro_toolbar));
        a M = M();
        if (M != null) {
            M.x(true);
        }
        a M2 = M();
        if (M2 != null) {
            M2.s(true);
        }
        a M3 = M();
        if (M3 != null) {
            M3.t(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
