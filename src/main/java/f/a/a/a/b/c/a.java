package f.a.a.a.b.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.g;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_crisis_resources;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_sublist;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_CS_Adapter.kt */
public final class a extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<b0> f9095c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<g> f9096d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9097e = 1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9098f;

    /* renamed from: g  reason: collision with root package name */
    private final com.chauthai.swipereveallayout.b f9099g = new com.chauthai.swipereveallayout.b();

    /* renamed from: h  reason: collision with root package name */
    private final Activity f9100h;

    /* renamed from: i  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.a> f9101i;

    /* renamed from: j  reason: collision with root package name */
    private final d0 f9102j;

    /* renamed from: f.a.a.a.b.c.a$a  reason: collision with other inner class name */
    /* compiled from: Item_CS_Adapter.kt */
    public final class C0184a extends RecyclerView.d0 {
        private SwipeRevealLayout t;
        private LinearLayout u;
        private AppCompatTextView v;
        private ImageView w;
        private FrameLayout x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0184a(a aVar, View view) {
            super(view);
            f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_sp_elem_layout_swipe);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.chauthai.swipereveallayout.SwipeRevealLayout");
            this.t = (SwipeRevealLayout) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_sp_elem_layout);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.u = (LinearLayout) findViewById2;
            View findViewById3 = this.f1565a.findViewById(R.id.item_sp_elem_txt);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.v = (AppCompatTextView) findViewById3;
            View findViewById4 = this.f1565a.findViewById(R.id.item_sp_elem_drag_handler);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.w = (ImageView) findViewById4;
            View findViewById5 = this.f1565a.findViewById(R.id.item_sp_elem_remove_btn);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.FrameLayout");
            this.x = (FrameLayout) findViewById5;
        }

        public final ImageView M() {
            return this.w;
        }

        public final LinearLayout N() {
            return this.u;
        }

        public final SwipeRevealLayout O() {
            return this.t;
        }

        public final FrameLayout P() {
            return this.x;
        }

        public final AppCompatTextView Q() {
            return this.v;
        }
    }

    /* compiled from: Item_CS_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f9103b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9104c;

        b(a aVar, RecyclerView.d0 d0Var) {
            this.f9103b = aVar;
            this.f9104c = d0Var;
        }

        public final void onClick(View view) {
            this.f9103b.C(this.f9104c.j());
        }
    }

    /* compiled from: Item_CS_Adapter.kt */
    static final class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f9105b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9106c;

        c(a aVar, RecyclerView.d0 d0Var) {
            this.f9105b = aVar;
            this.f9106c = d0Var;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f9105b.A()) {
                return false;
            }
            f.d(motionEvent, "event");
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f9105b.E(true);
            this.f9105b.B().a(this.f9106c);
            return false;
        }
    }

    /* compiled from: Item_CS_Adapter.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f9107b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.a f9108c;

        d(a aVar, f.a.a.a.b.e.a aVar2) {
            this.f9107b = aVar;
            this.f9108c = aVar2;
        }

        public final void onClick(View view) {
            b0 b0Var;
            boolean z;
            int size = this.f9107b.z().size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    b0Var = null;
                    z = false;
                    break;
                }
                g gVar = this.f9107b.z().get(i3);
                f.d(gVar, "ctools[j]");
                g gVar2 = gVar;
                if (this.f9108c.d() == gVar2.c()) {
                    b0Var = new b0(gVar2.c(), gVar2.e(), gVar2.e(), null, null);
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                int size2 = this.f9107b.y().size();
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    b0 b0Var2 = this.f9107b.y().get(i2);
                    f.d(b0Var2, "all_tools[j]");
                    b0 b0Var3 = b0Var2;
                    if (this.f9108c.d() == b0Var3.d()) {
                        b0Var = b0Var3;
                        break;
                    }
                    i2++;
                }
            }
            if (b0Var != null) {
                if (b0Var.d() >= 100) {
                    k.b.d.k("Custom tool");
                } else {
                    k.b.d.k(this.f9108c.c());
                }
                if (b0Var.e() != null) {
                    Intent intent = new Intent(this.f9107b.x(), Act_tool_sublist.class);
                    intent.putExtra("tool", b0Var);
                    this.f9107b.x().startActivity(intent);
                } else if (b0Var.d() == -100) {
                    this.f9107b.x().startActivity(new Intent(this.f9107b.x(), Act_crisis_resources.class));
                } else {
                    Intent intent2 = new Intent(this.f9107b.x(), Act_manage.class);
                    intent2.putExtra("tool", b0Var);
                    this.f9107b.x().startActivity(intent2);
                }
            }
        }
    }

    public a(Activity activity, ArrayList<f.a.a.a.b.e.a> arrayList, d0 d0Var) {
        f.e(activity, "act");
        f.e(arrayList, "items");
        f.e(d0Var, "listener");
        this.f9100h = activity;
        this.f9101i = arrayList;
        this.f9102j = d0Var;
        ArrayList<b0> p0 = m.p0(activity);
        f.d(p0, "C_F_PTSD.loadClusteredTools(act)");
        this.f9095c = p0;
        ArrayList<g> q0 = new u(activity).q0();
        f.d(q0, "DBHelper(act).allCustomTools");
        this.f9096d = q0;
    }

    public final boolean A() {
        return this.f9098f;
    }

    public final d0 B() {
        return this.f9102j;
    }

    public void C(int i2) {
        this.f9101i.remove(i2);
        k(i2);
    }

    public void D(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f9101i, i4, i5);
                i4 = i5;
            }
        } else {
            int i6 = i3 + 1;
            if (i2 >= i6) {
                int i7 = i2;
                while (true) {
                    Collections.swap(this.f9101i, i7, i7 - 1);
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
        }
        j(i2, i3);
    }

    public final void E(boolean z) {
        this.f9098f = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9101i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9097e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof C0184a) {
            f.a.a.a.b.e.a aVar = this.f9101i.get(i2);
            f.d(aVar, "items[position]");
            f.a.a.a.b.e.a aVar2 = aVar;
            C0184a aVar3 = (C0184a) d0Var;
            this.f9099g.d(aVar3.O(), Integer.toString(aVar2.a()));
            aVar3.Q().setText(aVar2.c());
            aVar3.P().setOnClickListener(new b(this, d0Var));
            aVar3.M().setOnTouchListener(new c(this, d0Var));
            if (aVar2.d() != -1) {
                aVar3.N().setOnClickListener(new d(this, aVar2));
            } else {
                aVar3.N().setOnClickListener(null);
            }
            aVar3.N().setContentDescription(aVar2.c());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9100h).inflate(R.layout.item_sp_elem, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…m_sp_elem, parent, false)");
        return new C0184a(this, inflate);
    }

    public final Activity x() {
        return this.f9100h;
    }

    public final ArrayList<b0> y() {
        return this.f9095c;
    }

    public final ArrayList<g> z() {
        return this.f9096d;
    }
}
