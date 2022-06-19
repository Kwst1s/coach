package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.i;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.h;
import f.a.a.a.b.d.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_my_feelings_recap;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import k.b.d;

/* compiled from: Item_my_feelings_adapter */
public class j0 extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f8959c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<o> f8960d;

    /* renamed from: e  reason: collision with root package name */
    private SimpleDateFormat f8961e = new SimpleDateFormat("EEEE, MMM d, yyyy", Locale.getDefault());

    /* access modifiers changed from: package-private */
    /* compiled from: Item_my_feelings_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8962b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ o f8963c;

        a(int i2, o oVar) {
            this.f8962b = i2;
            this.f8963c = oVar;
        }

        public void onClick(View view) {
            d.k("Feeling " + (this.f8962b + 1));
            Intent intent = new Intent(j0.this.f8959c, Act_my_feelings_recap.class);
            intent.putExtra("myfeeling", this.f8963c);
            j0.this.f8959c.startActivity(intent);
        }
    }

    /* compiled from: Item_my_feelings_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected View u;
        protected TextView v;
        protected TextView w;
        protected TextView x;
        protected LinearLayout y;
        protected View z;

        public b(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_my_feelings_layout);
            this.u = view.findViewById(R.id.item_my_feelings_color_line);
            this.v = (TextView) view.findViewById(R.id.item_my_feelings_txt_stress);
            this.w = (TextView) view.findViewById(R.id.item_my_feelings_txt_date);
            this.x = (TextView) view.findViewById(R.id.item_my_feelings_txt_stress_perc);
            this.y = (LinearLayout) view.findViewById(R.id.item_my_feelings_layout_feelings);
            this.z = view.findViewById(R.id.item_my_feelings_space_feelings);
        }
    }

    public j0(Activity activity, ArrayList<o> arrayList) {
        this.f8959c = activity;
        this.f8960d = arrayList;
    }

    /* renamed from: A */
    public void m(b bVar, int i2) {
        o oVar = this.f8960d.get(i2);
        TextView textView = bVar.x;
        textView.setText(Integer.toString(oVar.e()) + "%");
        bVar.v.setText(z(oVar.e()));
        bVar.w.setText(j.c(this.f8961e.format(Long.valueOf(oVar.a()))));
        bVar.u.setBackgroundColor(y(oVar.e()));
        String C = C(oVar, bVar);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(oVar.e()) + "%");
        sb.append(" ");
        sb.append(this.f8959c.getString(z(oVar.e())));
        sb.append(";");
        sb.append(this.f8959c.getString(R.string.on) + this.f8961e.format(Long.valueOf(oVar.a())));
        sb.append("\n");
        sb.append(C);
        bVar.t.setContentDescription(sb);
        bVar.t.setOnClickListener(new a(i2, oVar));
    }

    /* renamed from: B */
    public b o(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_feelings, viewGroup, false));
    }

    public String C(o oVar, b bVar) {
        StringBuilder sb = new StringBuilder();
        bVar.y.removeAllViews();
        if (oVar.c().isEmpty()) {
            bVar.z.setVisibility(8);
        } else {
            bVar.z.setVisibility(0);
        }
        LayoutInflater from = LayoutInflater.from(this.f8959c);
        ArrayList<h> c2 = oVar.c();
        for (int i2 = 0; i2 < c2.size(); i2++) {
            h hVar = c2.get(i2);
            View inflate = from.inflate(R.layout.item_feeling, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.feeling_txt_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.feeling_txt_feelings);
            StringBuilder sb2 = new StringBuilder();
            sb.append(hVar.a() + "; ");
            int i3 = 0;
            while (i3 < hVar.c().size()) {
                sb2.append(hVar.c().get(i3).a());
                sb.append(hVar.c().get(i3).a());
                i3++;
                if (i3 < hVar.c().size()) {
                    sb2.append(", ");
                    sb.append(", ");
                }
            }
            textView.setText(hVar.a());
            textView2.setText(sb2);
            bVar.y.addView(inflate);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8960d.size();
    }

    public int y(int i2) {
        switch (i2 / 10) {
            case 1:
                return Color.rgb(68, 160, 162);
            case 2:
                return Color.rgb(68, 176, 130);
            case 3:
                return Color.rgb(68, 202, 82);
            case 4:
                return Color.rgb(132, 224, 42);
            case 5:
                return Color.rgb(132, 202, 98);
            case 6:
                return Color.rgb(226, 220, 110);
            case 7:
                return Color.rgb(255, 151, (int) i.D0);
            case 8:
                return Color.rgb(255, (int) i.D0, (int) i.D0);
            case 9:
                return Color.rgb(212, 82, 82);
            case 10:
                return Color.rgb(151, 19, 19);
            default:
                return Color.rgb(50, (int) b.a.j.I0, 166);
        }
    }

    public int z(int i2) {
        switch (i2 / 10) {
            case 0:
                return R.string.peace_serenity;
            case 1:
                return R.string.relaxed_no_stressed;
            case 2:
                return R.string.bit_upset;
            case 3:
                return R.string.slightly_upset;
            case 4:
                return R.string.mild_stress;
            case 5:
                return R.string.mild_to_moderate;
            case 6:
                return R.string.moderate_stress;
            case 7:
                return R.string.moderate_high;
            case 8:
                return R.string.high_stress;
            case 9:
                return R.string.high_to_extreme;
            case 10:
                return R.string.extreme_stress;
            default:
                return R.string.none;
        }
    }
}
