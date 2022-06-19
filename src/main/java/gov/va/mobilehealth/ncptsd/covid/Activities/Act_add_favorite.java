package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.r0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.Collections;

public class Act_add_favorite extends f implements View.OnClickListener {
    private Toolbar u;
    private AppCompatTextView v;
    private AppCompatTextView w;
    private RecyclerView x;
    private ArrayList<b0> y;

    public void W() {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= this.y.size()) {
                z = false;
                break;
            } else if (this.y.get(i2).j()) {
                z = true;
                break;
            } else {
                i2++;
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

    public void a0() {
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            b0 b0Var = this.y.get(i2);
            if (b0Var.j()) {
                m.o(this, b0Var, null, null, Boolean.valueOf(m.C0(getApplicationContext(), b0Var.d(), null, false)), Boolean.valueOf(m.B0(getApplicationContext(), b0Var.d(), null, false)));
            }
        }
        m.M0(getApplication(), true);
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(gov.va.mobilehealth.ncptsd.covid.CComp.b0.c(context, j.x()));
    }

    public void b0() {
        ArrayList<g> q0 = new u(getApplicationContext()).q0();
        ArrayList<b0> p0 = m.p0(getApplicationContext());
        this.y = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < q0.size(); i2++) {
            g gVar = q0.get(i2);
            if (m.m0(getApplicationContext(), q0.get(i2).c(), "thumbdown")) {
                arrayList3.add(new b0(gVar.c(), gVar.e(), gVar.e(), null, null));
            } else if (!m.m0(getApplicationContext(), gVar.c(), "thumbup")) {
                arrayList.add(new b0(gVar.c(), gVar.e(), gVar.e(), null, null));
            }
        }
        for (int i3 = 0; i3 < p0.size(); i3++) {
            if (m.m0(getApplicationContext(), p0.get(i3).d(), "thumbdown")) {
                arrayList3.add(p0.get(i3));
            } else if (!m.m0(getApplicationContext(), p0.get(i3).d(), "thumbup")) {
                arrayList2.add(p0.get(i3));
            }
        }
        Collections.sort(arrayList, c.f9919b);
        Collections.sort(arrayList2, a.f9915b);
        Collections.sort(arrayList3, b.f9917b);
        if (arrayList.size() != 0) {
            this.y.addAll(arrayList);
        }
        if (arrayList2.size() != 0) {
            this.y.addAll(arrayList2);
        }
        if (arrayList3.size() != 0) {
            this.y.addAll(arrayList3);
        }
        this.x.setAdapter(new r0(this, this.y));
    }

    public void onClick(View view) {
        if (view.getId() == this.v.getId()) {
            finish();
        }
        if (view.getId() == this.w.getId()) {
            a0();
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
        b0();
        W();
    }
}
