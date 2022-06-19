package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
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
import java.util.Collections;
import k.b.d;

/* compiled from: Item_tools_favorite_adapter */
public class t0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f9037c;

    /* renamed from: d  reason: collision with root package name */
    private k f9038d;

    /* renamed from: e  reason: collision with root package name */
    private d0 f9039e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<b0> f9040f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Integer> f9041g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9042h = false;

    /* renamed from: i  reason: collision with root package name */
    private final com.chauthai.swipereveallayout.b f9043i = new com.chauthai.swipereveallayout.b();

    /* compiled from: Item_tools_favorite_adapter */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f9044b;

        a(c cVar) {
            this.f9044b = cVar;
        }

        public void onClick(View view) {
            t0.this.B(this.f9044b.j());
        }
    }

    /* compiled from: Item_tools_favorite_adapter */
    public static class b extends RecyclerView.d0 {
        protected TextView t;

        public b(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.item_learn_screen_header_txt);
            this.t = textView;
            textView.setFocusable(true);
        }
    }

    /* compiled from: Item_tools_favorite_adapter */
    public static class c extends RecyclerView.d0 {
        protected SwipeRevealLayout t;
        protected FrameLayout u;
        protected LinearLayout v;
        protected TextView w;
        protected CircleImageView x;
        protected ImageView y;

        public c(Activity activity, View view, d0 d0Var) {
            super(view);
            this.t = (SwipeRevealLayout) view.findViewById(R.id.item_tool_layout);
            this.u = (FrameLayout) view.findViewById(R.id.item_tool_unfavorite_button);
            this.v = (LinearLayout) view.findViewById(R.id.item_tool_layout_horizontal);
            this.w = (TextView) view.findViewById(R.id.item_tool_txt);
            this.x = (CircleImageView) view.findViewById(R.id.item_tool_img);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_tool_drag_handle);
            this.y = imageView;
            if (d0Var != null) {
                imageView.setVisibility(0);
            }
        }
    }

    public t0(Activity activity, ArrayList<b0> arrayList, ArrayList<Integer> arrayList2, d0 d0Var, k kVar) {
        this.f9037c = activity;
        this.f9038d = kVar;
        this.f9040f = arrayList;
        this.f9041g = arrayList2;
        this.f9039e = d0Var;
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
            Intent intent = new Intent(this.f9037c, Act_tool_sublist.class);
            intent.putExtra("tool", b0Var);
            this.f9037c.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f9037c, Act_manage.class);
        intent2.putExtra("tool", b0Var);
        this.f9037c.startActivity(intent2);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ boolean A(RecyclerView.d0 d0Var, View view, MotionEvent motionEvent) {
        if (this.f9042h || motionEvent.getAction() != 0) {
            return false;
        }
        this.f9042h = true;
        this.f9039e.a(d0Var);
        return false;
    }

    public void B(int i2) {
        m.w0(this.f9037c, this.f9040f.get(i2).d(), "thumbup");
        d.j(this.f9037c, "30602");
        this.f9040f.remove(i2);
        this.f9041g.remove(i2);
        k(i2);
        k kVar = this.f9038d;
        if (kVar != null) {
            kVar.s2();
            this.f9038d.e2();
        }
        m.M0(this.f9037c.getApplication(), true);
    }

    public void C(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f9040f, i4, i5);
                Collections.swap(this.f9041g, i4, i5);
                i4 = i5;
            }
        } else {
            for (int i6 = i2; i6 > i3; i6--) {
                int i7 = i6 - 1;
                Collections.swap(this.f9040f, i6, i7);
                Collections.swap(this.f9041g, i6, i7);
            }
        }
        j(i2, i3);
        m.M0(this.f9037c.getApplication(), true);
    }

    public void D(c cVar, int i2, String str) {
        if (str.equals(g.X)) {
            cVar.x.setImageResource(R.drawable.tool_text);
        } else if (str.equals(g.Z)) {
            cVar.x.setImageResource(R.drawable.tool_music);
        } else if (str.equals(g.b0)) {
            cVar.x.setImageResource(R.drawable.tool_video);
        } else if (str.equals(g.Y)) {
            cVar.x.setImageResource(R.drawable.tool_memo);
        } else {
            f.a.a.a.b.d.g y0 = new u(this.f9037c).y0(i2 - g.W);
            if (y0.d() != null) {
                x i3 = t.g().i(y0.d());
                i3.i(new gov.va.mobilehealth.ncptsd.covid.CComp.t());
                i3.h(j.r(this.f9037c) / 5, j.r(this.f9037c) / 5);
                i3.g();
                i3.a();
                i3.e(cVar.x);
                return;
            }
            cVar.x.setImageResource(R.drawable.tool_photo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9040f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        ArrayList<b0> arrayList = this.f9040f;
        if (arrayList != null) {
            return arrayList.get(i2).h() ? 1 : 0;
        }
        return super.e(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof c) {
            b0 b0Var = this.f9040f.get(i2);
            c cVar = (c) d0Var;
            this.f9043i.d(cVar.t, Integer.toString(b0Var.d()));
            cVar.w.setText(b0Var.g());
            if (b0Var.d() > g.W) {
                f.a.a.a.b.d.g y0 = new u(this.f9037c).y0(m.C(b0Var.d()));
                D(cVar, y0.c(), y0.f());
            } else {
                CircleImageView circleImageView = cVar.x;
                Activity activity = this.f9037c;
                circleImageView.setImageResource(j.m(activity, "t" + Integer.toString(b0Var.d())));
            }
            if (b0Var.d() == -1) {
                if (this.f9039e != null) {
                    m.F0(this.f9037c, cVar.v, b0Var.g(), d0Var.j() + 1);
                } else {
                    m.E0(this.f9037c, cVar.v, b0Var.g());
                }
            } else if (this.f9039e != null) {
                m.F0(this.f9037c, cVar.v, b0Var.g(), d0Var.j() + 1);
            } else {
                m.E0(this.f9037c, cVar.v, b0Var.g());
            }
            cVar.v.setOnClickListener(new n(this, b0Var));
            cVar.u.setOnClickListener(new a(cVar));
            cVar.y.setOnTouchListener(new o(this, d0Var));
        } else if (d0Var instanceof b) {
            b bVar = (b) d0Var;
            bVar.t.setText(this.f9040f.get(d0Var.j()).g());
            TextView textView = bVar.t;
            textView.setContentDescription(this.f9040f.get(d0Var.j()).g() + " " + this.f9037c.getString(R.string.heading));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 != 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_learn_screen_header, viewGroup, false));
        }
        return new c(this.f9037c, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_fav, viewGroup, false), this.f9039e);
    }
}
