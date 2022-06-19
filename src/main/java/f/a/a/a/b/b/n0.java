package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_symptoms_adapter */
public class n0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private int f8985c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f8986d = 1;

    /* renamed from: e  reason: collision with root package name */
    private Activity f8987e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a0> f8988f;

    /* compiled from: Item_symptoms_adapter */
    public static class a extends RecyclerView.d0 {
        protected LinearLayout t;
        protected ImageView u;
        protected TextView v;

        public a(Activity activity, View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_symptom_layout_horizontal);
            this.u = (ImageView) view.findViewById(R.id.item_symptom_img);
            this.v = (TextView) view.findViewById(R.id.item_symptom_txt);
        }
    }

    /* compiled from: Item_symptoms_adapter */
    public static class b extends RecyclerView.d0 {
        protected TextView t;

        public b(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.item_header_txt);
        }
    }

    public n0(Activity activity, ArrayList<a0> arrayList) {
        this.f8987e = activity;
        this.f8988f = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(a0 a0Var, View view) {
        d.k(a0Var.c());
        m.a1(this.f8987e, a0Var.a());
        Intent intent = new Intent(this.f8987e, Act_manage.class);
        intent.putExtra("symptom", a0Var);
        this.f8987e.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8988f.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        if (i2 == 0) {
            return this.f8985c;
        }
        return this.f8986d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof a) {
            a aVar = (a) d0Var;
            a0 a0Var = this.f8988f.get(i2 - 1);
            Activity activity = this.f8987e;
            aVar.u.setImageResource(j.m(activity, "sy_" + a0Var.a()));
            aVar.v.setText(a0Var.c());
            m.E0(this.f8987e, aVar.v, a0Var.c());
            aVar.t.setOnClickListener(new j(this, a0Var));
        } else if (d0Var instanceof b) {
            ((b) d0Var).t.setText(R.string.what_would_like_help);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 != this.f8986d) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_header_symptoms, viewGroup, false));
        }
        return new a(this.f8987e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_symptoms, viewGroup, false));
    }
}
