package f.a.a.a.b.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.e.e;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step1_my_ws;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: Item_Choose_WS_Adapter.kt */
public final class f extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9144c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Act_sp_step1_my_ws f9145d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<e> f9146e;

    /* compiled from: Item_Choose_WS_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;
        private AppCompatCheckBox v;
        private AppCompatImageView w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar, View view) {
            super(view);
            kotlin.m.b.f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_sp_checkbox_layout);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.t = (LinearLayout) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_sp_checkbox_txt_txt);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.u = (AppCompatTextView) findViewById2;
            View findViewById3 = this.f1565a.findViewById(R.id.item_sp_checkbox_checkbox);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatCheckBox");
            this.v = (AppCompatCheckBox) findViewById3;
            View findViewById4 = this.f1565a.findViewById(R.id.item_sp_checkbox_icon_delete);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.w = (AppCompatImageView) findViewById4;
        }

        public final AppCompatCheckBox M() {
            return this.v;
        }

        public final AppCompatImageView N() {
            return this.w;
        }

        public final LinearLayout O() {
            return this.t;
        }

        public final AppCompatTextView P() {
            return this.u;
        }
    }

    /* compiled from: Item_Choose_WS_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9147b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f9148c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9149d;

        b(f fVar, e eVar, RecyclerView.d0 d0Var) {
            this.f9147b = fVar;
            this.f9148c = eVar;
            this.f9149d = d0Var;
        }

        public final void onClick(View view) {
            e eVar = this.f9148c;
            eVar.h(!eVar.d());
            ((a) this.f9149d).M().setChecked(this.f9148c.d());
            if (this.f9148c.d()) {
                LinearLayout O = ((a) this.f9149d).O();
                O.setContentDescription(this.f9148c.c() + " " + this.f9147b.x().getString(R.string.checked) + " " + this.f9147b.x().getString(R.string.button));
                LinearLayout O2 = ((a) this.f9149d).O();
                O2.announceForAccessibility(this.f9148c.c() + " " + this.f9147b.x().getString(R.string.checked) + " " + this.f9147b.x().getString(R.string.button));
            } else {
                LinearLayout O3 = ((a) this.f9149d).O();
                O3.setContentDescription(this.f9148c.c() + " " + this.f9147b.x().getString(R.string.button));
                LinearLayout O4 = ((a) this.f9149d).O();
                O4.announceForAccessibility(this.f9148c.c() + " " + this.f9147b.x().getString(R.string.button));
            }
            this.f9147b.x().X();
        }
    }

    /* compiled from: Item_Choose_WS_Adapter.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9150b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f9151c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9152d;

        c(f fVar, e eVar, RecyclerView.d0 d0Var) {
            this.f9150b = fVar;
            this.f9151c = eVar;
            this.f9152d = d0Var;
        }

        public final void onClick(View view) {
            o.e(this.f9150b.x(), this.f9151c.a());
            this.f9150b.y().remove(((a) this.f9152d).j());
            this.f9150b.k(((a) this.f9152d).j());
            this.f9150b.x().X();
        }
    }

    public f(Act_sp_step1_my_ws act_sp_step1_my_ws, ArrayList<e> arrayList) {
        kotlin.m.b.f.e(act_sp_step1_my_ws, "act");
        kotlin.m.b.f.e(arrayList, "items");
        this.f9145d = act_sp_step1_my_ws;
        this.f9146e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9146e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9144c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        kotlin.m.b.f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            e eVar = this.f9146e.get(i2);
            kotlin.m.b.f.d(eVar, "items[position]");
            e eVar2 = eVar;
            a aVar = (a) d0Var;
            aVar.P().setText(eVar2.c());
            aVar.M().setChecked(eVar2.d());
            aVar.O().setOnClickListener(new b(this, eVar2, d0Var));
            if (eVar2.e()) {
                aVar.N().setVisibility(0);
                aVar.N().setOnClickListener(new c(this, eVar2, d0Var));
                return;
            }
            aVar.N().setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        kotlin.m.b.f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9145d).inflate(R.layout.item_sp_checkbox, viewGroup, false);
        kotlin.m.b.f.d(inflate, "LayoutInflater.from(act)…_checkbox, parent, false)");
        return new a(this, inflate);
    }

    public final Act_sp_step1_my_ws x() {
        return this.f9145d;
    }

    public final ArrayList<e> y() {
        return this.f9146e;
    }
}
