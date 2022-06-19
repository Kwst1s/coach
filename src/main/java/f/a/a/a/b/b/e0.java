package f.a.a.a.b.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import de.hdodenhof.circleimageview.CircleImageView;
import f.a.a.a.b.d.u;
import f.a.a.a.b.i.i;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_help_manage_adapter */
public class e0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private String f8923c;

    /* renamed from: d  reason: collision with root package name */
    private i f8924d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<u> f8925e;

    /* compiled from: Item_help_manage_adapter */
    public static class a extends RecyclerView.d0 {
        protected TextView t;

        public a(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.item_learn_screen_header_txt);
        }
    }

    /* compiled from: Item_help_manage_adapter */
    public static class b extends RecyclerView.d0 {
        protected TextView t;
        protected CircleImageView u;

        public b(Activity activity, View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.item_learn_txt);
            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.item_learn_img);
            this.u = circleImageView;
            circleImageView.setVisibility(8);
        }
    }

    public e0(i iVar, ArrayList<u> arrayList, String str) {
        this.f8924d = iVar;
        this.f8925e = arrayList;
        this.f8923c = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(u uVar, View view) {
        d.k(uVar.c());
        this.f8924d.W1(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8925e.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof b) {
            u uVar = this.f8925e.get(i2 - 1);
            b bVar = (b) d0Var;
            bVar.t.setText(uVar.c());
            m.E0(this.f8924d.n(), bVar.t, uVar.c());
            bVar.t.setOnClickListener(new e(this, uVar));
        } else if (d0Var instanceof a) {
            a aVar = (a) d0Var;
            aVar.t.setBackgroundColor(0);
            TextView textView = aVar.t;
            textView.setContentDescription(this.f8923c + " " + this.f8924d.Q(R.string.heading));
            aVar.t.setTextColor(b.h.d.a.b(this.f8924d.n(), R.color.colorAccent));
            aVar.t.setText(this.f8923c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new b(this.f8924d.n(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_learn_screen, viewGroup, false));
        } else if (i2 == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_learn_screen_header, viewGroup, false));
        } else {
            return null;
        }
    }
}
