package f.a.a.a.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.h;
import f.a.a.a.b.d.x;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_feelings_children_adapter */
public class a0 extends RecyclerView.g<c> {

    /* renamed from: c  reason: collision with root package name */
    private f.a.a.a.b.l.m0.a f8887c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<h> f8888d;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_feelings_children_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppCompatCheckBox f8889b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x f8890c;

        a(a0 a0Var, AppCompatCheckBox appCompatCheckBox, x xVar) {
            this.f8889b = appCompatCheckBox;
            this.f8890c = xVar;
        }

        public void onClick(View view) {
            AppCompatCheckBox appCompatCheckBox = this.f8889b;
            appCompatCheckBox.setChecked(!appCompatCheckBox.isChecked());
            if (this.f8889b.isChecked()) {
                d.k("Selected " + this.f8890c.a());
                return;
            }
            d.k("Deselected " + this.f8890c.a());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_feelings_children_adapter */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f8891a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8892b;

        b(x xVar, LinearLayout linearLayout) {
            this.f8891a = xVar;
            this.f8892b = linearLayout;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f8891a.d(z);
            if (z) {
                LinearLayout linearLayout = this.f8892b;
                linearLayout.setContentDescription(this.f8891a.a() + " " + a0.this.f8887c.Q(R.string.selected));
                LinearLayout linearLayout2 = this.f8892b;
                linearLayout2.announceForAccessibility(this.f8891a.a() + " " + a0.this.f8887c.Q(R.string.selected));
            } else {
                LinearLayout linearLayout3 = this.f8892b;
                linearLayout3.setContentDescription(this.f8891a.a() + " " + a0.this.f8887c.Q(R.string.not_selected));
                LinearLayout linearLayout4 = this.f8892b;
                linearLayout4.announceForAccessibility(this.f8891a.a() + " " + a0.this.f8887c.Q(R.string.not_selected));
            }
            a0.this.f8887c.X1();
        }
    }

    /* compiled from: Item_feelings_children_adapter */
    public static class c extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;

        public c(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_my_feelings_children_layout);
            this.u = (TextView) view.findViewById(R.id.item_my_feelings_children_parent_txt);
        }
    }

    public a0(f.a.a.a.b.l.m0.a aVar, ArrayList<h> arrayList) {
        this.f8887c = aVar;
        this.f8888d = arrayList;
    }

    public void A(h hVar, c cVar) {
        LayoutInflater layoutInflater = this.f8887c.n().getLayoutInflater();
        cVar.t.removeAllViews();
        for (int i2 = 0; i2 < hVar.c().size(); i2++) {
            View inflate = layoutInflater.inflate(R.layout.item_feeling_child, (ViewGroup) null);
            x xVar = hVar.c().get(i2);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_feeling_child_layout);
            TextView textView = (TextView) inflate.findViewById(R.id.item_feeling_child_txt);
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) inflate.findViewById(R.id.item_feeling_child_checkbox);
            linearLayout.setImportantForAccessibility(1);
            linearLayout.setOnClickListener(new a(this, appCompatCheckBox, xVar));
            if (xVar.c()) {
                linearLayout.setContentDescription(xVar.a() + " " + this.f8887c.Q(R.string.selected));
            } else {
                linearLayout.setContentDescription(xVar.a() + " " + this.f8887c.Q(R.string.not_selected));
            }
            textView.setText(xVar.a());
            if (xVar.c()) {
                appCompatCheckBox.setChecked(true);
            }
            appCompatCheckBox.setOnCheckedChangeListener(new b(xVar, linearLayout));
            cVar.t.addView(inflate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8888d.size();
    }

    /* renamed from: y */
    public void m(c cVar, int i2) {
        h hVar = this.f8888d.get(i2);
        cVar.u.setText(hVar.a());
        TextView textView = cVar.u;
        textView.setContentDescription(hVar.a() + " " + this.f8887c.Q(R.string.heading));
        A(hVar, cVar);
    }

    /* renamed from: z */
    public c o(ViewGroup viewGroup, int i2) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_feeling_children, viewGroup, false));
    }
}
