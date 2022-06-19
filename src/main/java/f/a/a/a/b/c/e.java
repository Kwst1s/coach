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
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step3_places;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_Choose_Places_Adapter.kt */
public final class e extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9135c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Act_sp_step3_places f9136d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.c> f9137e;

    /* compiled from: Item_Choose_Places_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;
        private AppCompatCheckBox v;
        private AppCompatImageView w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            f.e(view, "view");
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

    /* compiled from: Item_Choose_Places_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f9138b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.c f9139c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9140d;

        b(e eVar, f.a.a.a.b.e.c cVar, RecyclerView.d0 d0Var) {
            this.f9138b = eVar;
            this.f9139c = cVar;
            this.f9140d = d0Var;
        }

        public final void onClick(View view) {
            f.a.a.a.b.e.c cVar = this.f9139c;
            cVar.h(!cVar.d());
            ((a) this.f9140d).M().setChecked(this.f9139c.d());
            if (this.f9139c.d()) {
                LinearLayout O = ((a) this.f9140d).O();
                O.setContentDescription(this.f9139c.c() + " " + this.f9138b.x().getString(R.string.checked) + " " + this.f9138b.x().getString(R.string.button));
                LinearLayout O2 = ((a) this.f9140d).O();
                O2.announceForAccessibility(this.f9139c.c() + " " + this.f9138b.x().getString(R.string.checked) + " " + this.f9138b.x().getString(R.string.button));
            } else {
                LinearLayout O3 = ((a) this.f9140d).O();
                O3.setContentDescription(this.f9139c.c() + " " + this.f9138b.x().getString(R.string.button));
                LinearLayout O4 = ((a) this.f9140d).O();
                O4.announceForAccessibility(this.f9139c.c() + " " + this.f9138b.x().getString(R.string.button));
            }
            this.f9138b.x().X();
        }
    }

    /* compiled from: Item_Choose_Places_Adapter.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f9141b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.c f9142c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9143d;

        c(e eVar, f.a.a.a.b.e.c cVar, RecyclerView.d0 d0Var) {
            this.f9141b = eVar;
            this.f9142c = cVar;
            this.f9143d = d0Var;
        }

        public final void onClick(View view) {
            o.d(this.f9141b.x(), this.f9142c.a());
            this.f9141b.y().remove(((a) this.f9143d).j());
            this.f9141b.k(((a) this.f9143d).j());
            this.f9141b.x().X();
        }
    }

    public e(Act_sp_step3_places act_sp_step3_places, ArrayList<f.a.a.a.b.e.c> arrayList) {
        f.e(act_sp_step3_places, "act");
        f.e(arrayList, "items");
        this.f9136d = act_sp_step3_places;
        this.f9137e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9137e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9135c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.c cVar = this.f9137e.get(i2);
            f.d(cVar, "items[position]");
            f.a.a.a.b.e.c cVar2 = cVar;
            a aVar = (a) d0Var;
            aVar.P().setText(cVar2.c());
            aVar.M().setChecked(cVar2.d());
            aVar.O().setOnClickListener(new b(this, cVar2, d0Var));
            aVar.N().setVisibility(0);
            aVar.N().setOnClickListener(new c(this, cVar2, d0Var));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9136d).inflate(R.layout.item_sp_checkbox, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…_checkbox, parent, false)");
        return new a(this, inflate);
    }

    public final Act_sp_step3_places x() {
        return this.f9136d;
    }

    public final ArrayList<f.a.a.a.b.e.c> y() {
        return this.f9137e;
    }
}
