package f.a.a.a.b.c;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.j.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_SP_Contacts_Adapter.kt */
public final class i extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9173c = 1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9174d;

    /* renamed from: e  reason: collision with root package name */
    private final com.chauthai.swipereveallayout.b f9175e = new com.chauthai.swipereveallayout.b();

    /* renamed from: f  reason: collision with root package name */
    private final Fragment f9176f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.d> f9177g;

    /* renamed from: h  reason: collision with root package name */
    private final d0 f9178h;

    /* compiled from: Item_SP_Contacts_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private SwipeRevealLayout t;
        private LinearLayout u;
        private AppCompatTextView v;
        private AppCompatTextView w;
        private ImageView x;
        private FrameLayout y;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i iVar, View view) {
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
            View findViewById4 = this.f1565a.findViewById(R.id.item_sp_elem_txt_2);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.w = (AppCompatTextView) findViewById4;
            View findViewById5 = this.f1565a.findViewById(R.id.item_sp_elem_drag_handler);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
            this.x = (ImageView) findViewById5;
            View findViewById6 = this.f1565a.findViewById(R.id.item_sp_elem_remove_btn);
            Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.FrameLayout");
            this.y = (FrameLayout) findViewById6;
        }

        public final ImageView M() {
            return this.x;
        }

        public final LinearLayout N() {
            return this.u;
        }

        public final SwipeRevealLayout O() {
            return this.t;
        }

        public final FrameLayout P() {
            return this.y;
        }

        public final AppCompatTextView Q() {
            return this.v;
        }

        public final AppCompatTextView R() {
            return this.w;
        }
    }

    /* compiled from: Item_SP_Contacts_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f9179b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9180c;

        b(i iVar, RecyclerView.d0 d0Var) {
            this.f9179b = iVar;
            this.f9180c = d0Var;
        }

        public final void onClick(View view) {
            this.f9179b.A(this.f9180c.j());
        }
    }

    /* compiled from: Item_SP_Contacts_Adapter.kt */
    static final class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f9181b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9182c;

        c(i iVar, RecyclerView.d0 d0Var) {
            this.f9181b = iVar;
            this.f9182c = d0Var;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f9181b.x()) {
                return false;
            }
            f.d(motionEvent, "event");
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f9181b.C(true);
            this.f9181b.z().a(this.f9182c);
            return false;
        }
    }

    /* compiled from: Item_SP_Contacts_Adapter.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f9183b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.d f9184c;

        d(i iVar, f.a.a.a.b.e.d dVar) {
            this.f9183b = iVar;
            this.f9184c = dVar;
        }

        public final void onClick(View view) {
            if (this.f9184c.e() != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(this.f9184c.a())));
                this.f9183b.y().F1(intent);
            }
        }
    }

    public i(Fragment fragment, ArrayList<f.a.a.a.b.e.d> arrayList, d0 d0Var) {
        f.e(fragment, "frag");
        f.e(arrayList, "items");
        f.e(d0Var, "listener");
        this.f9176f = fragment;
        this.f9177g = arrayList;
        this.f9178h = d0Var;
    }

    public void A(int i2) {
        this.f9177g.remove(i2);
        k(i2);
        Fragment fragment = this.f9176f;
        if (fragment instanceof f.a.a.a.b.j.c) {
            ((f.a.a.a.b.j.c) fragment).e2();
            ((f.a.a.a.b.j.c) this.f9176f).h2();
        } else if (fragment instanceof f.a.a.a.b.j.f) {
            ((f.a.a.a.b.j.f) fragment).e2();
            ((f.a.a.a.b.j.f) this.f9176f).h2();
        }
        Fragment fragment2 = this.f9176f;
        if (fragment2 instanceof e) {
            ((e) fragment2).e2();
            ((e) this.f9176f).f2();
        }
    }

    public void B(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f9177g, i4, i5);
                i4 = i5;
            }
        } else {
            int i6 = i3 + 1;
            if (i2 >= i6) {
                int i7 = i2;
                while (true) {
                    Collections.swap(this.f9177g, i7, i7 - 1);
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
        }
        j(i2, i3);
    }

    public final void C(boolean z) {
        this.f9174d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9177g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9173c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.d dVar = this.f9177g.get(i2);
            f.d(dVar, "items[position]");
            f.a.a.a.b.e.d dVar2 = dVar;
            a aVar = (a) d0Var;
            this.f9175e.d(aVar.O(), String.valueOf(dVar2.c()));
            aVar.Q().setText(dVar2.d());
            StringBuilder sb = new StringBuilder(dVar2.d());
            if (dVar2.f() != null) {
                StringBuilder sb2 = new StringBuilder();
                if (dVar2.f() != null) {
                    String f2 = dVar2.f();
                    f.c(f2);
                    sb2.append(f2);
                }
                sb.append(", ");
                sb.append(sb2.toString());
                aVar.R().setText(sb2);
                aVar.R().setVisibility(0);
            } else {
                aVar.R().setVisibility(8);
            }
            aVar.P().setOnClickListener(new b(this, d0Var));
            aVar.M().setOnTouchListener(new c(this, d0Var));
            aVar.N().setOnClickListener(new d(this, dVar2));
            LinearLayout N = aVar.N();
            N.setContentDescription(sb.toString() + " " + this.f9176f.Q(R.string.button));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9176f.n1()).inflate(R.layout.item_sp_elem, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(frag…m_sp_elem, parent, false)");
        return new a(this, inflate);
    }

    public final boolean x() {
        return this.f9174d;
    }

    public final Fragment y() {
        return this.f9176f;
    }

    public final d0 z() {
        return this.f9178h;
    }
}
