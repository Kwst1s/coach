package f.a.a.a.b.c;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import f.a.a.a.b.e.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_WS_Adapter.kt */
public final class j extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9185c = 1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9186d;

    /* renamed from: e  reason: collision with root package name */
    private final com.chauthai.swipereveallayout.b f9187e = new com.chauthai.swipereveallayout.b();

    /* renamed from: f  reason: collision with root package name */
    private final Activity f9188f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<e> f9189g;

    /* renamed from: h  reason: collision with root package name */
    private final d0 f9190h;

    /* compiled from: Item_WS_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private SwipeRevealLayout t;
        private LinearLayout u;
        private AppCompatTextView v;
        private ImageView w;
        private FrameLayout x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar, View view) {
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

    /* compiled from: Item_WS_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f9191b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9192c;

        b(j jVar, RecyclerView.d0 d0Var) {
            this.f9191b = jVar;
            this.f9192c = d0Var;
        }

        public final void onClick(View view) {
            this.f9191b.z(this.f9192c.j());
        }
    }

    /* compiled from: Item_WS_Adapter.kt */
    static final class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f9193b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9194c;

        c(j jVar, RecyclerView.d0 d0Var) {
            this.f9193b = jVar;
            this.f9194c = d0Var;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f9193b.x() || motionEvent.getAction() != 0) {
                return false;
            }
            this.f9193b.B(true);
            this.f9193b.y().a(this.f9194c);
            return false;
        }
    }

    public j(Activity activity, ArrayList<e> arrayList, d0 d0Var) {
        f.e(activity, "act");
        f.e(arrayList, "items");
        f.e(d0Var, "listener");
        this.f9188f = activity;
        this.f9189g = arrayList;
        this.f9190h = d0Var;
    }

    public void A(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f9189g, i4, i5);
                i4 = i5;
            }
        } else {
            int i6 = i3 + 1;
            if (i2 >= i6) {
                int i7 = i2;
                while (true) {
                    Collections.swap(this.f9189g, i7, i7 - 1);
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
        this.f9186d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9189g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9185c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            e eVar = this.f9189g.get(i2);
            f.d(eVar, "items[position]");
            e eVar2 = eVar;
            a aVar = (a) d0Var;
            this.f9187e.d(aVar.O(), Integer.toString(eVar2.a()));
            aVar.Q().setText(eVar2.c());
            aVar.P().setOnClickListener(new b(this, d0Var));
            aVar.M().setOnTouchListener(new c(this, d0Var));
            aVar.N().setContentDescription(eVar2.c());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9188f).inflate(R.layout.item_sp_elem, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…m_sp_elem, parent, false)");
        return new a(this, inflate);
    }

    public final boolean x() {
        return this.f9186d;
    }

    public final d0 y() {
        return this.f9190h;
    }

    public void z(int i2) {
        this.f9189g.remove(i2);
        k(i2);
    }
}
