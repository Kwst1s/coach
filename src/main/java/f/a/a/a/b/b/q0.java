package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import f.a.a.a.b.i.k;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_sublist;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_tools_adapter */
public class q0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f9017c;

    /* renamed from: d  reason: collision with root package name */
    private d0 f9018d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<b0> f9019e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9020f = false;

    /* compiled from: Item_tools_adapter */
    public static class a extends RecyclerView.d0 {
        protected TextView t;

        public a(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.item_learn_screen_header_txt);
            this.t = textView;
            textView.setFocusable(true);
        }
    }

    /* compiled from: Item_tools_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected CircleImageView v;
        protected ImageView w;
        protected AppCompatImageView x;

        public b(Activity activity, View view, d0 d0Var) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_tool_layout_horizontal);
            this.u = (TextView) view.findViewById(R.id.item_tool_txt);
            this.v = (CircleImageView) view.findViewById(R.id.item_tool_img);
            this.w = (ImageView) view.findViewById(R.id.item_tool_drag_handle);
            this.x = (AppCompatImageView) view.findViewById(R.id.item_tool_audio_icon);
            if (d0Var != null) {
                this.w.setVisibility(0);
            }
        }
    }

    public q0(Activity activity, ArrayList<b0> arrayList, ArrayList<Integer> arrayList2, d0 d0Var, k kVar) {
        this.f9017c = activity;
        this.f9019e = arrayList;
        this.f9018d = d0Var;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(b0 b0Var, View view) {
        if (b0Var.d() > g.W) {
            d.k("Custom Tool");
        } else {
            d.k(b0Var.g());
        }
        if (b0Var.e() != null) {
            Intent intent = new Intent(this.f9017c, Act_tool_sublist.class);
            intent.putExtra("tool", b0Var);
            this.f9017c.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f9017c, Act_manage.class);
        intent2.putExtra("tool", b0Var);
        this.f9017c.startActivity(intent2);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ boolean A(RecyclerView.d0 d0Var, View view, MotionEvent motionEvent) {
        if (this.f9020f || motionEvent.getAction() != 0) {
            return false;
        }
        this.f9020f = true;
        this.f9018d.a(d0Var);
        return false;
    }

    public void B(b bVar, int i2, String str) {
        if (str.equals(g.X)) {
            bVar.v.setImageResource(R.drawable.tool_text);
        } else if (str.equals(g.Z)) {
            bVar.v.setImageResource(R.drawable.tool_music);
        } else if (str.equals(g.b0)) {
            bVar.v.setImageResource(R.drawable.tool_video);
        } else if (str.equals(g.Y)) {
            bVar.v.setImageResource(R.drawable.tool_memo);
        } else {
            f.a.a.a.b.d.g y0 = new u(this.f9017c).y0(i2 - g.W);
            if (y0.d() != null) {
                x i3 = t.g().i(y0.d());
                i3.i(new gov.va.mobilehealth.ncptsd.covid.CComp.t());
                i3.h(j.r(this.f9017c) / 5, j.r(this.f9017c) / 5);
                i3.g();
                i3.a();
                i3.e(bVar.v);
                return;
            }
            bVar.v.setImageResource(R.drawable.tool_photo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9019e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        ArrayList<b0> arrayList = this.f9019e;
        if (arrayList != null) {
            return arrayList.get(i2).h() ? 1 : 0;
        }
        return super.e(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        int i3;
        if (d0Var instanceof b) {
            b0 b0Var = this.f9019e.get(i2);
            b bVar = (b) d0Var;
            bVar.u.setText(b0Var.g());
            if (gov.va.mobilehealth.ncptsd.covid.CComp.k.f10124a.p(b0Var.d())) {
                bVar.x.setVisibility(0);
            } else {
                bVar.x.setVisibility(8);
            }
            if (b0Var.d() > g.W) {
                f.a.a.a.b.d.g y0 = new u(this.f9017c).y0(m.C(b0Var.d()));
                B(bVar, y0.c(), y0.f());
            } else {
                if (b0Var.d() < 8 || b0Var.d() > 10) {
                    Activity activity = this.f9017c;
                    i3 = j.m(activity, "t" + b0Var.d());
                } else {
                    Activity activity2 = this.f9017c;
                    i3 = j.m(activity2, "tround" + b0Var.d());
                }
                bVar.v.setImageResource(i3);
            }
            if (b0Var.d() == -1) {
                if (this.f9018d != null) {
                    m.F0(this.f9017c, bVar.t, b0Var.g(), d0Var.j() + 1);
                } else {
                    m.E0(this.f9017c, bVar.t, b0Var.g());
                }
            } else if (this.f9018d != null) {
                m.F0(this.f9017c, bVar.t, b0Var.g(), d0Var.j() + 1);
            } else {
                m.E0(this.f9017c, bVar.t, b0Var.g());
            }
            bVar.t.setOnClickListener(new m(this, b0Var));
            bVar.w.setOnTouchListener(new l(this, d0Var));
        } else if (d0Var instanceof a) {
            a aVar = (a) d0Var;
            aVar.t.setText(this.f9019e.get(d0Var.j()).g());
            TextView textView = aVar.t;
            textView.setContentDescription(this.f9019e.get(d0Var.j()).g() + " " + this.f9017c.getString(R.string.heading));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 != 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_learn_screen_header, viewGroup, false));
        }
        return new b(this.f9017c, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool, viewGroup, false), this.f9018d);
    }
}
