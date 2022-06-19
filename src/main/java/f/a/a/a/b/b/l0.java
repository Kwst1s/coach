package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.t;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext_content;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_sp_help_adapter */
public class l0 extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f8974c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<t> f8975d;

    /* compiled from: Item_sp_help_adapter */
    public static class a extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;

        public a(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_sp_help_layout_horizontal);
            this.u = (TextView) view.findViewById(R.id.item_sp_help_txt);
        }
    }

    public l0(Activity activity, ArrayList<t> arrayList) {
        this.f8974c = activity;
        this.f8975d = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(t tVar, View view) {
        d.k(tVar.d());
        Intent intent = new Intent(this.f8974c, Act_jtext_content.class);
        intent.putExtra("title", tVar.c());
        intent.putExtra("content", tVar.a());
        this.f8974c.startActivity(intent);
    }

    /* renamed from: A */
    public a o(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sp_help, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8975d.size();
    }

    /* renamed from: z */
    public void m(a aVar, int i2) {
        t tVar = this.f8975d.get(i2);
        aVar.u.setText(tVar.d());
        m.E0(this.f8974c, aVar.u, tVar.d());
        aVar.t.setOnClickListener(new i(this, tVar));
    }
}
