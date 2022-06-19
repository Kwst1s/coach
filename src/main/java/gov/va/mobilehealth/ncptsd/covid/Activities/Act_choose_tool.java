package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.s0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class Act_choose_tool extends f implements View.OnClickListener {
    private Toolbar u;
    private AppCompatTextView v;
    private AppCompatTextView w;
    private RecyclerView x;
    private ArrayList<b0> y;

    public void W(int i2) {
        boolean z = false;
        for (int i3 = 0; i3 < this.y.size(); i3++) {
            if (this.y.get(i3).d() == i2) {
                this.y.get(i3).l(true);
                z = true;
            } else {
                this.y.get(i3).l(false);
            }
        }
        if (z) {
            this.w.setAlpha(1.0f);
            this.w.setClickable(true);
            this.w.setContentDescription(getString(R.string.save_btn));
            return;
        }
        this.w.setAlpha(0.5f);
        this.w.setClickable(false);
        this.w.setContentDescription(getString(R.string.save_btn_inactive));
    }

    public void Y() {
        boolean z;
        ArrayList<g> q0 = new u(getApplicationContext()).q0();
        ArrayList<b0> p0 = m.p0(getApplicationContext());
        this.y = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        JSONArray g2 = o.g(this);
        int i2 = 0;
        while (true) {
            try {
                boolean z2 = true;
                if (i2 >= q0.size()) {
                    break;
                }
                g gVar = q0.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= g2.length()) {
                        z2 = false;
                        break;
                    } else if (g2.getInt(i3) == gVar.c()) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    arrayList.add(new b0(gVar.c(), gVar.e(), gVar.e(), null, null));
                }
                i2++;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        for (int i4 = 0; i4 < p0.size(); i4++) {
            b0 b0Var = p0.get(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= g2.length()) {
                    z = false;
                    break;
                } else if (g2.getInt(i5) == b0Var.d()) {
                    z = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (!z) {
                arrayList.add(b0Var);
            }
        }
        Collections.sort(arrayList, d.f9921b);
        if (arrayList.size() != 0) {
            this.y.addAll(arrayList);
        }
        this.x.setAdapter(new s0(this, this.y));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(gov.va.mobilehealth.ncptsd.covid.CComp.b0.c(context, j.x()));
    }

    public void onClick(View view) {
        if (view.getId() == this.v.getId()) {
            finish();
        }
        if (view.getId() == this.w.getId()) {
            b0 b0Var = null;
            int i2 = 0;
            while (true) {
                if (i2 >= this.y.size()) {
                    break;
                } else if (this.y.get(i2).j()) {
                    b0Var = this.y.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
            if (b0Var != null) {
                Intent intent = new Intent();
                intent.putExtra("tool", b0Var);
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_add_favorite);
        this.u = (Toolbar) findViewById(R.id.add_favorite_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.add_favorite_txt_cancel);
        this.w = (AppCompatTextView) findViewById(R.id.add_favorite_txt_save);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.add_favorite_rview);
        this.x = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.x.setHasFixedSize(true);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        T(this.u);
        M().x(false);
        M().s(false);
        M().t(false);
        Y();
    }
}
