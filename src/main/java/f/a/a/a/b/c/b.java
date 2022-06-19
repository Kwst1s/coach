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
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step2_coping_strategies;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_Choose_CS_Adapter.kt */
public final class b extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9109c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Act_sp_step2_coping_strategies f9110d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.a> f9111e;

    /* compiled from: Item_Choose_CS_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;
        private AppCompatCheckBox v;
        private AppCompatImageView w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
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

    /* renamed from: f.a.a.a.b.c.b$b  reason: collision with other inner class name */
    /* compiled from: Item_Choose_CS_Adapter.kt */
    static final class View$OnClickListenerC0185b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9112b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.a f9113c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9114d;

        View$OnClickListenerC0185b(b bVar, f.a.a.a.b.e.a aVar, RecyclerView.d0 d0Var) {
            this.f9112b = bVar;
            this.f9113c = aVar;
            this.f9114d = d0Var;
        }

        public final void onClick(View view) {
            f.a.a.a.b.e.a aVar = this.f9113c;
            aVar.i(!aVar.e());
            ((a) this.f9114d).M().setChecked(this.f9113c.e());
            if (this.f9113c.e()) {
                LinearLayout O = ((a) this.f9114d).O();
                O.setContentDescription(this.f9113c.c() + " " + this.f9112b.x().getString(R.string.checked) + " " + this.f9112b.x().getString(R.string.button));
                LinearLayout O2 = ((a) this.f9114d).O();
                O2.announceForAccessibility(this.f9113c.c() + " " + this.f9112b.x().getString(R.string.checked) + " " + this.f9112b.x().getString(R.string.button));
            } else {
                LinearLayout O3 = ((a) this.f9114d).O();
                O3.setContentDescription(this.f9113c.c() + " " + this.f9112b.x().getString(R.string.button));
                LinearLayout O4 = ((a) this.f9114d).O();
                O4.announceForAccessibility(this.f9113c.c() + " " + this.f9112b.x().getString(R.string.button));
            }
            this.f9112b.x().X();
        }
    }

    /* compiled from: Item_Choose_CS_Adapter.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9115b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.a f9116c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9117d;

        c(b bVar, f.a.a.a.b.e.a aVar, RecyclerView.d0 d0Var) {
            this.f9115b = bVar;
            this.f9116c = aVar;
            this.f9117d = d0Var;
        }

        public final void onClick(View view) {
            o.b(this.f9115b.x(), this.f9116c.a());
            this.f9115b.y().remove(((a) this.f9117d).j());
            this.f9115b.k(((a) this.f9117d).j());
            this.f9115b.x().X();
        }
    }

    public b(Act_sp_step2_coping_strategies act_sp_step2_coping_strategies, ArrayList<f.a.a.a.b.e.a> arrayList) {
        f.e(act_sp_step2_coping_strategies, "act");
        f.e(arrayList, "items");
        this.f9110d = act_sp_step2_coping_strategies;
        this.f9111e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9111e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9109c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.a aVar = this.f9111e.get(i2);
            f.d(aVar, "items[position]");
            f.a.a.a.b.e.a aVar2 = aVar;
            a aVar3 = (a) d0Var;
            aVar3.P().setText(aVar2.c());
            aVar3.M().setChecked(aVar2.e());
            aVar3.O().setOnClickListener(new View$OnClickListenerC0185b(this, aVar2, d0Var));
            if (aVar2.f()) {
                aVar3.N().setVisibility(0);
                aVar3.N().setOnClickListener(new c(this, aVar2, d0Var));
                return;
            }
            aVar3.N().setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9110d).inflate(R.layout.item_sp_checkbox, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…_checkbox, parent, false)");
        return new a(this, inflate);
    }

    public final Act_sp_step2_coping_strategies x() {
        return this.f9110d;
    }

    public final ArrayList<f.a.a.a.b.e.a> y() {
        return this.f9111e;
    }
}
