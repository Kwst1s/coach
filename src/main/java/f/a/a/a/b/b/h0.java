package f.a.a.a.b.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import de.hdodenhof.circleimageview.CircleImageView;
import f.a.a.a.b.d.u;
import f.a.a.a.b.h.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;

/* compiled from: Item_learn_screens_adapter */
public class h0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private e f8947c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<u> f8948d;

    /* compiled from: Item_learn_screens_adapter */
    public static class a extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected CircleImageView v;

        public a(Activity activity, View view) {
            super(view);
            this.u = (TextView) view.findViewById(R.id.item_learn_txt);
            this.v = (CircleImageView) view.findViewById(R.id.item_learn_img);
            this.t = (LinearLayout) view.findViewById(R.id.item_learn_layout_horizontal);
            int r = j.r(activity) / 6;
            this.v.getLayoutParams().width = r;
            this.v.getLayoutParams().height = r;
        }
    }

    public h0(e eVar, ArrayList<u> arrayList) {
        this.f8947c = eVar;
        this.f8948d = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(u uVar, int i2, View view) {
        this.f8947c.K1(uVar, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8948d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof a) {
            u uVar = this.f8948d.get(i2);
            a aVar = (a) d0Var;
            aVar.u.setText(uVar.c());
            if (uVar.e() != -1) {
                aVar.v.setImageResource(uVar.e());
            } else if (uVar.d() != -1) {
                d n1 = this.f8947c.n1();
                aVar.v.setImageResource(j.m(n1, "l" + uVar.d()));
            } else {
                aVar.v.setImageResource(R.drawable.img_feelings);
            }
            m.E0(this.f8947c.n1(), aVar.u, uVar.c());
            aVar.t.setOnClickListener(new h(this, uVar, i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        return new a(this.f8947c.n(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_learn_screen, viewGroup, false));
    }
}
