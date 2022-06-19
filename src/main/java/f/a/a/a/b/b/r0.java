package f.a.a.a.b.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import de.hdodenhof.circleimageview.CircleImageView;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_add_favorite;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_tools_add_favorite_adapter */
public class r0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Act_add_favorite f9022c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<b0> f9023d;

    /* compiled from: Item_tools_add_favorite_adapter */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b0 f9024b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f9025c;

        a(b0 b0Var, b bVar) {
            this.f9024b = b0Var;
            this.f9025c = bVar;
        }

        public void onClick(View view) {
            b0 b0Var = this.f9024b;
            b0Var.l(!b0Var.j());
            r0.this.f9022c.W();
            if (this.f9024b.j()) {
                if (this.f9024b.d() > g.W) {
                    d.k("Tool Selected Custom Tool");
                } else {
                    d.k("Tool Selected " + this.f9024b.g());
                }
                Act_add_favorite act_add_favorite = r0.this.f9022c;
                LinearLayout linearLayout = this.f9025c.t;
                m.E0(act_add_favorite, linearLayout, this.f9024b.g() + " " + r0.this.f9022c.getString(R.string.selected));
                this.f9025c.w.setVisibility(0);
                return;
            }
            if (this.f9024b.d() > g.W) {
                d.k("Tool Deselected Custom Tool");
            } else {
                d.k("Tool Deselected " + this.f9024b.g());
            }
            m.E0(r0.this.f9022c, this.f9025c.t, this.f9024b.g());
            this.f9025c.w.setVisibility(8);
        }
    }

    /* compiled from: Item_tools_add_favorite_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected CircleImageView v;
        protected AppCompatImageView w;

        public b(Activity activity, View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_tool_layout_horizontal);
            this.u = (TextView) view.findViewById(R.id.item_tool_txt);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_tool_drag_handle);
            this.v = (CircleImageView) view.findViewById(R.id.item_tool_img);
            this.w = (AppCompatImageView) view.findViewById(R.id.item_tool_check);
        }
    }

    public r0(Act_add_favorite act_add_favorite, ArrayList<b0> arrayList) {
        this.f9022c = act_add_favorite;
        this.f9023d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9023d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        b0 b0Var = this.f9023d.get(i2);
        b bVar = (b) d0Var;
        bVar.u.setText(b0Var.g());
        if (b0Var.d() > g.W) {
            f.a.a.a.b.d.g y0 = new u(this.f9022c).y0(m.C(b0Var.d()));
            y(bVar, y0.c(), y0.f());
        } else {
            CircleImageView circleImageView = bVar.v;
            Act_add_favorite act_add_favorite = this.f9022c;
            circleImageView.setImageResource(j.m(act_add_favorite, "t" + Integer.toString(b0Var.d())));
        }
        if (b0Var.j()) {
            Act_add_favorite act_add_favorite2 = this.f9022c;
            LinearLayout linearLayout = bVar.t;
            m.E0(act_add_favorite2, linearLayout, b0Var.g() + " " + this.f9022c.getString(R.string.selected));
            bVar.w.setVisibility(0);
        } else {
            m.E0(this.f9022c, bVar.t, b0Var.g());
            bVar.w.setVisibility(8);
        }
        bVar.t.setOnClickListener(new a(b0Var, bVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        return new b(this.f9022c, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_add_fav, viewGroup, false));
    }

    public void y(b bVar, int i2, String str) {
        if (str.equals(g.X)) {
            bVar.v.setImageResource(R.drawable.tool_text);
        } else if (str.equals(g.Z)) {
            bVar.v.setImageResource(R.drawable.tool_music);
        } else if (str.equals(g.b0)) {
            bVar.v.setImageResource(R.drawable.tool_video);
        } else if (str.equals(g.Y)) {
            bVar.v.setImageResource(R.drawable.tool_memo);
        } else {
            f.a.a.a.b.d.g y0 = new u(this.f9022c).y0(i2 - g.W);
            if (y0.d() != null) {
                x i3 = t.g().i(y0.d());
                i3.i(new gov.va.mobilehealth.ncptsd.covid.CComp.t());
                i3.h(j.r(this.f9022c) / 5, j.r(this.f9022c) / 5);
                i3.g();
                i3.a();
                i3.e(bVar.v);
                return;
            }
            bVar.v.setImageResource(R.drawable.tool_photo);
        }
    }
}
