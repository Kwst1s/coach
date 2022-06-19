package f.a.a.a.b.c;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_Places_Adapter.kt */
public final class h extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9163c = 1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9164d;

    /* renamed from: e  reason: collision with root package name */
    private final com.chauthai.swipereveallayout.b f9165e = new com.chauthai.swipereveallayout.b();

    /* renamed from: f  reason: collision with root package name */
    private final f.a.a.a.b.j.c f9166f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.c> f9167g;

    /* renamed from: h  reason: collision with root package name */
    private final d0 f9168h;

    /* compiled from: Item_Places_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private SwipeRevealLayout t;
        private AppCompatTextView u;
        private ImageView v;
        private FrameLayout w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, View view) {
            super(view);
            f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_sp_elem_layout_swipe);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.chauthai.swipereveallayout.SwipeRevealLayout");
            this.t = (SwipeRevealLayout) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_sp_elem_txt);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.u = (AppCompatTextView) findViewById2;
            View findViewById3 = this.f1565a.findViewById(R.id.item_sp_elem_drag_handler);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            this.v = (ImageView) findViewById3;
            View findViewById4 = this.f1565a.findViewById(R.id.item_sp_elem_remove_btn);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.FrameLayout");
            this.w = (FrameLayout) findViewById4;
        }

        public final ImageView M() {
            return this.v;
        }

        public final SwipeRevealLayout N() {
            return this.t;
        }

        public final FrameLayout O() {
            return this.w;
        }

        public final AppCompatTextView P() {
            return this.u;
        }
    }

    /* compiled from: Item_Places_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f9169b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9170c;

        b(h hVar, RecyclerView.d0 d0Var) {
            this.f9169b = hVar;
            this.f9170c = d0Var;
        }

        public final void onClick(View view) {
            this.f9169b.z(this.f9170c.j());
        }
    }

    /* compiled from: Item_Places_Adapter.kt */
    static final class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f9171b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9172c;

        c(h hVar, RecyclerView.d0 d0Var) {
            this.f9171b = hVar;
            this.f9172c = d0Var;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f9171b.x()) {
                return false;
            }
            f.d(motionEvent, "event");
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f9171b.B(true);
            this.f9171b.y().a(this.f9172c);
            return false;
        }
    }

    public h(f.a.a.a.b.j.c cVar, ArrayList<f.a.a.a.b.e.c> arrayList, d0 d0Var) {
        f.e(cVar, "frag");
        f.e(arrayList, "items");
        f.e(d0Var, "listener");
        this.f9166f = cVar;
        this.f9167g = arrayList;
        this.f9168h = d0Var;
    }

    public void A(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f9167g, i4, i5);
                i4 = i5;
            }
        } else {
            int i6 = i3 + 1;
            if (i2 >= i6) {
                int i7 = i2;
                while (true) {
                    Collections.swap(this.f9167g, i7, i7 - 1);
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
        this.f9164d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9167g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9163c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.c cVar = this.f9167g.get(i2);
            f.d(cVar, "items[position]");
            f.a.a.a.b.e.c cVar2 = cVar;
            a aVar = (a) d0Var;
            this.f9165e.d(aVar.N(), Integer.toString(cVar2.a()));
            aVar.P().setText(cVar2.c());
            aVar.O().setOnClickListener(new b(this, d0Var));
            aVar.M().setOnTouchListener(new c(this, d0Var));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9166f.Z1()).inflate(R.layout.item_sp_elem, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(frag…m_sp_elem, parent, false)");
        return new a(this, inflate);
    }

    public final boolean x() {
        return this.f9164d;
    }

    public final d0 y() {
        return this.f9168h;
    }

    public void z(int i2) {
        this.f9167g.remove(i2);
        k(i2);
        this.f9166f.e2();
        this.f9166f.h2();
    }
}
