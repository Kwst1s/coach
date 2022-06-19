package f.a.a.a.b.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step6_env_safe;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step6_firearm_safety;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_Choose_Ideas_Adapter.kt */
public final class c extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9118c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Activity f9119d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.b> f9120e;

    /* compiled from: Item_Choose_Ideas_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;
        private AppCompatCheckBox v;
        private AppCompatImageView w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
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

    /* compiled from: Item_Choose_Ideas_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f9121b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.b f9122c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9123d;

        b(c cVar, f.a.a.a.b.e.b bVar, RecyclerView.d0 d0Var) {
            this.f9121b = cVar;
            this.f9122c = bVar;
            this.f9123d = d0Var;
        }

        public final void onClick(View view) {
            f.a.a.a.b.e.b bVar = this.f9122c;
            bVar.j(!bVar.e());
            ((a) this.f9123d).M().setChecked(this.f9122c.e());
            if (this.f9122c.e()) {
                LinearLayout O = ((a) this.f9123d).O();
                O.setContentDescription(this.f9122c.d() + " " + this.f9121b.x().getString(R.string.checked) + " " + this.f9121b.x().getString(R.string.button));
                LinearLayout O2 = ((a) this.f9123d).O();
                O2.announceForAccessibility(this.f9122c.d() + " " + this.f9121b.x().getString(R.string.checked) + " " + this.f9121b.x().getString(R.string.button));
            } else {
                LinearLayout O3 = ((a) this.f9123d).O();
                O3.setContentDescription(this.f9122c.d() + " " + this.f9121b.x().getString(R.string.button));
                LinearLayout O4 = ((a) this.f9123d).O();
                O4.announceForAccessibility(this.f9122c.d() + " " + this.f9121b.x().getString(R.string.button));
            }
            if (this.f9121b.x() instanceof Act_sp_step6_env_safe) {
                ((Act_sp_step6_env_safe) this.f9121b.x()).X();
            } else if (this.f9121b.x() instanceof Act_sp_step6_firearm_safety) {
                ((Act_sp_step6_firearm_safety) this.f9121b.x()).X();
            }
        }
    }

    /* renamed from: f.a.a.a.b.c.c$c  reason: collision with other inner class name */
    /* compiled from: Item_Choose_Ideas_Adapter.kt */
    static final class View$OnClickListenerC0186c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f9124b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.b f9125c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9126d;

        View$OnClickListenerC0186c(c cVar, f.a.a.a.b.e.b bVar, RecyclerView.d0 d0Var) {
            this.f9124b = cVar;
            this.f9125c = bVar;
            this.f9126d = d0Var;
        }

        public final void onClick(View view) {
            o.c(this.f9124b.x(), this.f9125c.c());
            this.f9124b.y().remove(((a) this.f9126d).j());
            this.f9124b.k(((a) this.f9126d).j());
            if (this.f9124b.x() instanceof Act_sp_step6_env_safe) {
                ((Act_sp_step6_env_safe) this.f9124b.x()).X();
            } else if (this.f9124b.x() instanceof Act_sp_step6_firearm_safety) {
                ((Act_sp_step6_firearm_safety) this.f9124b.x()).X();
            }
        }
    }

    public c(Activity activity, ArrayList<f.a.a.a.b.e.b> arrayList) {
        f.e(activity, "act");
        f.e(arrayList, "items");
        this.f9119d = activity;
        this.f9120e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9120e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9118c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.b bVar = this.f9120e.get(i2);
            f.d(bVar, "items[position]");
            f.a.a.a.b.e.b bVar2 = bVar;
            a aVar = (a) d0Var;
            aVar.P().setText(bVar2.d());
            aVar.M().setChecked(bVar2.e());
            aVar.O().setOnClickListener(new b(this, bVar2, d0Var));
            if (bVar2.f()) {
                aVar.N().setVisibility(0);
                aVar.N().setOnClickListener(new View$OnClickListenerC0186c(this, bVar2, d0Var));
                return;
            }
            aVar.N().setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9119d).inflate(R.layout.item_sp_checkbox, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…_checkbox, parent, false)");
        return new a(this, inflate);
    }

    public final Activity x() {
        return this.f9119d;
    }

    public final ArrayList<f.a.a.a.b.e.b> y() {
        return this.f9120e;
    }
}
