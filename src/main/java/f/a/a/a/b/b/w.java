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
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_assessment_detail;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_assess_history_adapter */
public class w extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f9065c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<f.a.a.a.b.d.b> f9066d;

    /* renamed from: e  reason: collision with root package name */
    private int f9067e;

    /* renamed from: f  reason: collision with root package name */
    private SimpleDateFormat f9068f = new SimpleDateFormat("MMM dd, yyyy");

    /* compiled from: Item_assess_history_adapter */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.d.b f9069b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9070c;

        a(f.a.a.a.b.d.b bVar, int i2) {
            this.f9069b = bVar;
            this.f9070c = i2;
        }

        public void onClick(View view) {
            d.k("Assessment Detail");
            Intent intent = new Intent(w.this.f9065c, Act_assessment_detail.class);
            intent.putExtra("assess_data", this.f9069b);
            intent.putExtra("type", w.this.f9067e);
            if (this.f9070c + 1 != w.this.f9066d.size()) {
                intent.putExtra("previous_assess_data", (Serializable) w.this.f9066d.get(this.f9070c + 1));
            }
            w.this.f9065c.startActivity(intent);
        }
    }

    /* compiled from: Item_assess_history_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected TextView v;

        public b(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_assess_history_layout_horizontal);
            this.u = (TextView) view.findViewById(R.id.item_assess_history_txt_date);
            this.v = (TextView) view.findViewById(R.id.item_assess_history_txt_score);
        }
    }

    public w(Activity activity, ArrayList<f.a.a.a.b.d.b> arrayList, int i2) {
        this.f9065c = activity;
        this.f9066d = arrayList;
        this.f9067e = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9066d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.a.a.a.b.d.b bVar = this.f9066d.get(i2);
        b bVar2 = (b) d0Var;
        bVar2.u.setText(this.f9068f.format(Long.valueOf(bVar.a())));
        TextView textView = bVar2.v;
        textView.setText(this.f9065c.getString(R.string.score) + ": " + bVar.c());
        StringBuilder sb = new StringBuilder(this.f9065c.getString(R.string.on) + " " + s.e(bVar.a()));
        sb.append(this.f9065c.getString(R.string.score) + " " + bVar.c());
        sb.append(this.f9065c.getString(R.string.button));
        bVar2.t.setContentDescription(sb.toString());
        bVar2.t.setOnClickListener(new a(bVar, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_assess_history, viewGroup, false));
    }
}
