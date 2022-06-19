package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_sublist;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_Search_Adapter.kt */
public final class u extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f9046c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Activity f9047d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<Object> f9048e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9049f;

    /* compiled from: Item_Search_Adapter.kt */
    public static final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_learn_layout);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.t = (LinearLayout) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_learn_txt);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.u = (AppCompatTextView) findViewById2;
        }

        public final LinearLayout M() {
            return this.t;
        }

        public final AppCompatTextView N() {
            return this.u;
        }
    }

    /* compiled from: Item_Search_Adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f9050b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f9051c;

        b(u uVar, Object obj) {
            this.f9050b = uVar;
            this.f9051c = obj;
        }

        public final void onClick(View view) {
            if (((b0) this.f9051c).e() != null) {
                Intent intent = new Intent(this.f9050b.x(), Act_tool_sublist.class);
                intent.putExtra("tool", (Serializable) this.f9051c);
                this.f9050b.x().startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.f9050b.x(), Act_manage.class);
            intent2.putExtra("tool", (Serializable) this.f9051c);
            this.f9050b.x().startActivity(intent2);
        }
    }

    /* compiled from: Item_Search_Adapter.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f9052b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f9053c;

        c(u uVar, Object obj) {
            this.f9052b = uVar;
            this.f9053c = obj;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9052b.x(), Act_single_covid_learn.class);
            intent.putExtra("screen", (Serializable) this.f9053c);
            intent.putExtra("noImage", this.f9052b.y() == 3);
            this.f9052b.x().startActivity(intent);
        }
    }

    public u(Activity activity, ArrayList<Object> arrayList, int i2) {
        f.e(activity, "act");
        f.e(arrayList, "items");
        this.f9047d = activity;
        this.f9048e = arrayList;
        this.f9049f = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9048e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f9046c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        Object obj = this.f9048e.get(i2);
        f.d(obj, "items[position]");
        if (!(d0Var instanceof a)) {
            return;
        }
        if (obj instanceof b0) {
            a aVar = (a) d0Var;
            b0 b0Var = (b0) obj;
            aVar.N().setText(b0Var.g());
            aVar.M().setContentDescription(b0Var.g());
            aVar.M().setOnClickListener(new b(this, obj));
        } else if (obj instanceof f.a.a.a.b.d.u) {
            a aVar2 = (a) d0Var;
            f.a.a.a.b.d.u uVar = (f.a.a.a.b.d.u) obj;
            aVar2.N().setText(uVar.c());
            aVar2.M().setContentDescription(uVar.c());
            aVar2.M().setOnClickListener(new c(this, obj));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f9047d).inflate(R.layout.item_search, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…em_search, parent, false)");
        return new a(inflate);
    }

    public final Activity x() {
        return this.f9047d;
    }

    public final int y() {
        return this.f9049f;
    }
}
