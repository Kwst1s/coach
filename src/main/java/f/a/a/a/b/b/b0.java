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
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_feelings_parent_adapter */
public class b0 extends RecyclerView.g<c> {

    /* renamed from: c  reason: collision with root package name */
    private f.a.a.a.b.l.m0.b f8896c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<h> f8897d;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_feelings_parent_adapter */
    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f8898a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f8899b;

        a(h hVar, c cVar) {
            this.f8898a = hVar;
            this.f8899b = cVar;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f8898a.e(z);
            if (z) {
                LinearLayout linearLayout = this.f8899b.t;
                linearLayout.setContentDescription(this.f8898a.a() + " " + b0.this.f8896c.Q(R.string.selected));
                LinearLayout linearLayout2 = this.f8899b.t;
                linearLayout2.announceForAccessibility(this.f8898a.a() + " " + b0.this.f8896c.Q(R.string.selected));
            } else {
                LinearLayout linearLayout3 = this.f8899b.t;
                linearLayout3.setContentDescription(this.f8898a.a() + " " + b0.this.f8896c.Q(R.string.not_selected));
                LinearLayout linearLayout4 = this.f8899b.t;
                linearLayout4.announceForAccessibility(this.f8898a.a() + " " + b0.this.f8896c.Q(R.string.not_selected));
            }
            b0.this.f8896c.X1();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_feelings_parent_adapter */
    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f8901b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f8902c;

        b(b0 b0Var, c cVar, h hVar) {
            this.f8901b = cVar;
            this.f8902c = hVar;
        }

        public void onClick(View view) {
            AppCompatCheckBox appCompatCheckBox = this.f8901b.u;
            appCompatCheckBox.setChecked(!appCompatCheckBox.isChecked());
            if (this.f8901b.u.isChecked()) {
                d.k("Selected " + this.f8902c.a());
                return;
            }
            d.k("Deselected " + this.f8902c.a());
        }
    }

    /* compiled from: Item_feelings_parent_adapter */
    public static class c extends RecyclerView.d0 {
        protected LinearLayout t;
        protected AppCompatCheckBox u;
        protected TextView v;

        public c(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_my_feelings_parent_layout);
            this.u = (AppCompatCheckBox) view.findViewById(R.id.item_my_feelings_parent_checkbox);
            this.v = (TextView) view.findViewById(R.id.item_my_feelings_parent_txt);
        }
    }

    public b0(f.a.a.a.b.l.m0.b bVar, ArrayList<h> arrayList) {
        this.f8896c = bVar;
        this.f8897d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8897d.size();
    }

    /* renamed from: y */
    public void m(c cVar, int i2) {
        h hVar = this.f8897d.get(i2);
        cVar.v.setText(hVar.a());
        cVar.u.setOnCheckedChangeListener(null);
        cVar.u.setChecked(hVar.d());
        cVar.u.setOnCheckedChangeListener(new a(hVar, cVar));
        if (hVar.d()) {
            LinearLayout linearLayout = cVar.t;
            linearLayout.setContentDescription(hVar.a() + " " + this.f8896c.Q(R.string.selected));
        } else {
            LinearLayout linearLayout2 = cVar.t;
            linearLayout2.setContentDescription(hVar.a() + " " + this.f8896c.Q(R.string.not_selected));
        }
        cVar.t.setOnClickListener(new b(this, cVar, hVar));
    }

    /* renamed from: z */
    public c o(ViewGroup viewGroup, int i2) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_feeling_father, viewGroup, false));
    }
}
