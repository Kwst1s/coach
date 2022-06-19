package f.a.a.a.b.c;

import android.annotation.SuppressLint;
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
import f.a.a.a.b.j.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* compiled from: Item_EnvIdeas_Adapter.kt */
public final class g extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9153c = 1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9154d;

    /* renamed from: e  reason: collision with root package name */
    private final com.chauthai.swipereveallayout.b f9155e = new com.chauthai.swipereveallayout.b();

    /* renamed from: f  reason: collision with root package name */
    private final f f9156f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.b> f9157g;

    /* renamed from: h  reason: collision with root package name */
    private final d0 f9158h;

    /* compiled from: Item_EnvIdeas_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private SwipeRevealLayout t;
        private LinearLayout u;
        private AppCompatTextView v;
        private ImageView w;
        private FrameLayout x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, View view) {
            super(view);
            kotlin.m.b.f.e(view, "view");
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

    /* compiled from: Item_EnvIdeas_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f9159b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9160c;

        b(g gVar, RecyclerView.d0 d0Var) {
            this.f9159b = gVar;
            this.f9160c = d0Var;
        }

        public final void onClick(View view) {
            this.f9159b.z(this.f9160c.j());
        }
    }

    /* compiled from: Item_EnvIdeas_Adapter.kt */
    static final class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f9161b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9162c;

        c(g gVar, RecyclerView.d0 d0Var) {
            this.f9161b = gVar;
            this.f9162c = d0Var;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f9161b.x()) {
                return false;
            }
            kotlin.m.b.f.d(motionEvent, "event");
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f9161b.B(true);
            this.f9161b.y().a(this.f9162c);
            return false;
        }
    }

    public g(f fVar, ArrayList<f.a.a.a.b.e.b> arrayList, d0 d0Var) {
        kotlin.m.b.f.e(fVar, "frag");
        kotlin.m.b.f.e(arrayList, "items");
        kotlin.m.b.f.e(d0Var, "listener");
        this.f9156f = fVar;
        this.f9157g = arrayList;
        this.f9158h = d0Var;
    }

    public void A(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f9157g, i4, i5);
                i4 = i5;
            }
        } else {
            int i6 = i3 + 1;
            if (i2 >= i6) {
                int i7 = i2;
                while (true) {
                    Collections.swap(this.f9157g, i7, i7 - 1);
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
        }
        j(i2, i3);
    }

    public final void B(boolean z) {
        this.f9154d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9157g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9153c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void m(RecyclerView.d0 d0Var, int i2) {
        kotlin.m.b.f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.b bVar = this.f9157g.get(i2);
            kotlin.m.b.f.d(bVar, "items[position]");
            f.a.a.a.b.e.b bVar2 = bVar;
            a aVar = (a) d0Var;
            this.f9155e.d(aVar.O(), Integer.toString(bVar2.c()));
            aVar.Q().setText(bVar2.d());
            aVar.P().setOnClickListener(new b(this, d0Var));
            aVar.M().setOnTouchListener(new c(this, d0Var));
            aVar.N().setContentDescription(bVar2.d());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        kotlin.m.b.f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9156f.Z1()).inflate(R.layout.item_sp_elem, viewGroup, false);
        kotlin.m.b.f.d(inflate, "LayoutInflater.from(frag…m_sp_elem, parent, false)");
        return new a(this, inflate);
    }

    public final boolean x() {
        return this.f9154d;
    }

    public final d0 y() {
        return this.f9158h;
    }

    public void z(int i2) {
        this.f9157g.remove(i2);
        k(i2);
        this.f9156f.e2();
        this.f9156f.h2();
    }
}
