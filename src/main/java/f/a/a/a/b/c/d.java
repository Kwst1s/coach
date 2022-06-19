package f.a.a.a.b.c;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step6_env_safe;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step6_firearm_safety;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_Choose_Ideas_Guns_Adapter.kt */
public final class d extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9127c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Activity f9128d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.e.b> f9129e;

    /* compiled from: Item_Choose_Ideas_Guns_Adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;
        private AppCompatCheckBox v;
        private AppCompatImageView w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, View view) {
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
            View findViewById4 = this.f1565a.findViewById(R.id.item_sp_checkbox_txt_img_i);
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

    /* compiled from: Item_Choose_Ideas_Guns_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9130b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.b f9131c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9132d;

        b(d dVar, f.a.a.a.b.e.b bVar, RecyclerView.d0 d0Var) {
            this.f9130b = dVar;
            this.f9131c = bVar;
            this.f9132d = d0Var;
        }

        public final void onClick(View view) {
            f.a.a.a.b.e.b bVar = this.f9131c;
            bVar.j(!bVar.e());
            ((a) this.f9132d).M().setChecked(this.f9131c.e());
            if (this.f9131c.e()) {
                LinearLayout O = ((a) this.f9132d).O();
                O.setContentDescription(this.f9131c.d() + " " + this.f9130b.x().getString(R.string.checked) + " " + this.f9130b.x().getString(R.string.button));
                LinearLayout O2 = ((a) this.f9132d).O();
                O2.announceForAccessibility(this.f9131c.d() + " " + this.f9130b.x().getString(R.string.checked) + " " + this.f9130b.x().getString(R.string.button));
            } else {
                LinearLayout O3 = ((a) this.f9132d).O();
                O3.setContentDescription(this.f9131c.d() + " " + this.f9130b.x().getString(R.string.button));
                LinearLayout O4 = ((a) this.f9132d).O();
                O4.announceForAccessibility(this.f9131c.d() + " " + this.f9130b.x().getString(R.string.button));
            }
            if (this.f9130b.x() instanceof Act_sp_step6_env_safe) {
                ((Act_sp_step6_env_safe) this.f9130b.x()).X();
            } else if (this.f9130b.x() instanceof Act_sp_step6_firearm_safety) {
                ((Act_sp_step6_firearm_safety) this.f9130b.x()).X();
            }
        }
    }

    /* compiled from: Item_Choose_Ideas_Guns_Adapter.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9133b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.e.b f9134c;

        c(d dVar, f.a.a.a.b.e.b bVar) {
            this.f9133b = dVar;
            this.f9134c = bVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9133b.x(), Act_jtext.class);
            intent.putExtra("title", this.f9133b.x().getString(R.string.help));
            intent.putExtra("file", g.p + String.valueOf(this.f9134c.a()) + ".json");
            this.f9133b.x().startActivity(intent);
        }
    }

    public d(Activity activity, ArrayList<f.a.a.a.b.e.b> arrayList) {
        f.e(activity, "act");
        f.e(arrayList, "items");
        this.f9128d = activity;
        this.f9129e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9129e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9127c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        if (d0Var instanceof a) {
            f.a.a.a.b.e.b bVar = this.f9129e.get(i2);
            f.d(bVar, "items[position]");
            f.a.a.a.b.e.b bVar2 = bVar;
            a aVar = (a) d0Var;
            aVar.P().setText(bVar2.d());
            aVar.M().setChecked(bVar2.e());
            aVar.O().setOnClickListener(new b(this, bVar2, d0Var));
            aVar.N().setOnClickListener(new c(this, bVar2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9128d).inflate(R.layout.item_sp_checkbox_i, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…heckbox_i, parent, false)");
        return new a(this, inflate);
    }

    public final Activity x() {
        return this.f9128d;
    }
}
