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
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import de.hdodenhof.circleimageview.CircleImageView;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_add_favorite;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_crisis_resources;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_sublist;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_tools_home_adapter */
public class u0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Act_home f9054c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<b0> f9055d;

    /* compiled from: Item_tools_home_adapter */
    public static class a extends RecyclerView.d0 {
        protected ImageView t;
        protected LinearLayout u;

        public a(View view, Activity activity) {
            super(view);
            this.u = (LinearLayout) view.findViewById(R.id.home_tool_add_layout);
            this.t = (ImageView) view.findViewById(R.id.home_tool_add_img);
            TextView textView = (TextView) view.findViewById(R.id.home_tool_txt);
            double r = (double) (j.r(activity) - (((int) j.e(36.0f, activity)) * 2));
            Double.isNaN(r);
            this.u.getLayoutParams().width = (int) (r / 3.5d);
            int r2 = j.G(activity) ? j.r(activity) / 8 : j.r(activity) / 10;
            this.t.getLayoutParams().width = r2;
            this.t.getLayoutParams().height = r2;
        }
    }

    /* compiled from: Item_tools_home_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected CircleImageView u;
        protected TextView v;

        public b(View view, Activity activity) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.home_tool_layout);
            this.u = (CircleImageView) view.findViewById(R.id.home_tool_img);
            this.v = (TextView) view.findViewById(R.id.home_tool_txt);
            this.t.getLayoutParams().width = (j.r(activity) - (((int) j.e(36.0f, activity)) * 2)) / 4;
            int r = j.G(activity) ? j.r(activity) / 8 : j.r(activity) / 10;
            this.u.getLayoutParams().width = r;
            this.u.getLayoutParams().height = r;
        }
    }

    public u0(Act_home act_home, ArrayList<b0> arrayList) {
        this.f9054c = act_home;
        this.f9055d = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(b0 b0Var, View view) {
        if (b0Var.d() >= 100) {
            d.k("Custom tool");
        } else {
            d.k(b0Var.g());
        }
        if (b0Var.e() != null) {
            Intent intent = new Intent(this.f9054c, Act_tool_sublist.class);
            intent.putExtra("tool", b0Var);
            this.f9054c.startActivity(intent);
        } else if (b0Var.d() == -100) {
            this.f9054c.startActivity(new Intent(this.f9054c, Act_crisis_resources.class));
        } else if (b0Var.d() == -101) {
            this.f9054c.e0();
        } else {
            Intent intent2 = new Intent(this.f9054c, Act_manage.class);
            intent2.putExtra("tool", b0Var);
            this.f9054c.startActivity(intent2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(View view) {
        d.j(this.f9054c, "15289");
        this.f9054c.startActivity(new Intent(this.f9054c, Act_add_favorite.class));
    }

    public void B(b bVar, int i2, String str) {
        if (str.equals(g.X)) {
            bVar.u.setImageResource(R.drawable.tool_text);
        } else if (str.equals(g.Z)) {
            bVar.u.setImageResource(R.drawable.tool_music);
        } else if (str.equals(g.b0)) {
            bVar.u.setImageResource(R.drawable.tool_video);
        } else if (str.equals(g.Y)) {
            bVar.u.setImageResource(R.drawable.tool_memo);
        } else {
            f.a.a.a.b.d.g y0 = new u(this.f9054c).y0(i2 - g.W);
            if (y0.d() != null) {
                x i3 = t.g().i(y0.d());
                i3.i(new gov.va.mobilehealth.ncptsd.covid.CComp.t());
                i3.h(j.r(this.f9054c) / 5, j.r(this.f9054c) / 5);
                i3.g();
                i3.a();
                i3.e(bVar.u);
                return;
            }
            bVar.u.setImageResource(R.drawable.tool_photo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9055d.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        ArrayList<b0> arrayList = this.f9055d;
        if (arrayList != null) {
            return i2 >= arrayList.size() ? 1 : 0;
        }
        return super.e(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof b) {
            b0 b0Var = this.f9055d.get(i2);
            b bVar = (b) d0Var;
            bVar.v.setText(b0Var.g());
            m.E0(this.f9054c, bVar.t, b0Var.g());
            if (b0Var.d() > g.W) {
                f.a.a.a.b.d.g y0 = new u(this.f9054c).y0(m.C(b0Var.d()));
                B(bVar, y0.c(), y0.f());
            } else if (b0Var.d() >= 100) {
                bVar.u.setBackgroundResource(R.drawable.accent_round);
                CircleImageView circleImageView = bVar.u;
                Act_home act_home = this.f9054c;
                circleImageView.setImageResource(j.m(act_home, "t" + b0Var.d()));
            } else if (b0Var.d() == -100) {
                bVar.u.setBackgroundResource(R.drawable.accent_round);
                bVar.u.setImageResource(R.drawable.vet_crisis_line);
            } else if (b0Var.d() == -101) {
                bVar.u.setBackgroundResource(R.drawable.white_round);
                bVar.u.setImageResource(R.drawable.icon_sp_plan);
            } else {
                bVar.u.setBackgroundResource(R.drawable.accent_round);
                CircleImageView circleImageView2 = bVar.u;
                Act_home act_home2 = this.f9054c;
                circleImageView2.setImageResource(j.m(act_home2, "t" + b0Var.d()));
            }
            bVar.t.setOnClickListener(new q(this, b0Var));
        } else if (d0Var instanceof a) {
            ((a) d0Var).u.setOnClickListener(new p(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_home, viewGroup, false), this.f9054c);
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_home_add, viewGroup, false), this.f9054c);
    }
}
