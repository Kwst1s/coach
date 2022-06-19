package f.a.a.a.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.h.d.e.f;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.v;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_tool_star_adapter */
public class o0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private f.a.a.a.b.l.h0.b f8991c;

    /* renamed from: d  reason: collision with root package name */
    private String f8992d;

    /* renamed from: e  reason: collision with root package name */
    private String f8993e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<v> f8994f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Integer> f8995g;

    /* compiled from: Item_tool_star_adapter */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f8996b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f8997c;

        a(v vVar, b bVar) {
            this.f8996b = vVar;
            this.f8997c = bVar;
        }

        public void onClick(View view) {
            if (o0.this.y(this.f8996b)) {
                d.k(this.f8996b.c() + " Selected");
                o0.this.z(this.f8997c, this.f8996b);
                return;
            }
            d.k(this.f8996b.c() + " Deselected");
            o0.this.x(this.f8997c, this.f8996b);
        }
    }

    /* compiled from: Item_tool_star_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected ImageView v;

        public b(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_list_star_layout);
            this.u = (TextView) view.findViewById(R.id.item_list_star_txt);
            this.v = (ImageView) view.findViewById(R.id.item_list_star_img);
        }
    }

    /* compiled from: Item_tool_star_adapter */
    public static class c extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;

        public c(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_header_star_welcome_layout);
            this.u = (TextView) view.findViewById(R.id.item_header_star_list_title_txt);
        }
    }

    public o0(f.a.a.a.b.l.h0.b bVar, String str, String str2, ArrayList<v> arrayList, ArrayList<Integer> arrayList2) {
        this.f8991c = bVar;
        this.f8993e = str2;
        this.f8992d = str;
        this.f8994f = arrayList;
        this.f8995g = arrayList2;
    }

    public void A(b bVar, v vVar) {
        if (y(vVar)) {
            bVar.v.setImageResource(R.drawable.star_full);
            LinearLayout linearLayout = bVar.t;
            linearLayout.setContentDescription(vVar.c() + " " + this.f8991c.Q(R.string.favorite) + this.f8991c.Q(R.string.button));
            return;
        }
        bVar.v.setImageResource(R.drawable.star_empty);
        LinearLayout linearLayout2 = bVar.t;
        linearLayout2.setContentDescription(vVar.c() + " " + this.f8991c.Q(R.string.button));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8994f.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (i2 != 0) {
            v vVar = this.f8994f.get(i2 - 1);
            b bVar = (b) d0Var;
            bVar.u.setText(vVar.c());
            A(bVar, vVar);
            a aVar = new a(vVar, bVar);
            bVar.t.setOnClickListener(aVar);
            bVar.v.setOnClickListener(aVar);
            return;
        }
        c cVar = (c) d0Var;
        cVar.u.setText(this.f8993e);
        cVar.u.setTypeface(f.b(this.f8991c.n(), R.font.font_semibold));
        TextView textView = cVar.u;
        textView.setContentDescription(this.f8993e + " " + this.f8991c.Q(R.string.heading));
        m.Q0(this.f8991c.n(), cVar.t, this.f8992d, R.dimen.txt_normal, R.dimen.padding_large);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 != 0) {
            return new b(from.inflate(R.layout.item_list_star, viewGroup, false));
        }
        return new c(from.inflate(R.layout.item_header_star, viewGroup, false));
    }

    public void x(b bVar, v vVar) {
        this.f8995g.add(Integer.valueOf(vVar.a()));
        A(bVar, vVar);
        LinearLayout linearLayout = bVar.t;
        linearLayout.announceForAccessibility(vVar.c() + " " + this.f8991c.Q(R.string.favorite) + this.f8991c.Q(R.string.button));
    }

    public boolean y(v vVar) {
        for (int i2 = 0; i2 < this.f8995g.size(); i2++) {
            if (this.f8995g.get(i2).intValue() == vVar.a()) {
                return true;
            }
        }
        return false;
    }

    public void z(b bVar, v vVar) {
        for (int i2 = 0; i2 < this.f8995g.size(); i2++) {
            if (this.f8995g.get(i2).intValue() == vVar.a()) {
                this.f8995g.remove(i2);
                A(bVar, vVar);
                LinearLayout linearLayout = bVar.t;
                linearLayout.announceForAccessibility(vVar.c() + " " + this.f8991c.Q(R.string.button));
                return;
            }
        }
    }
}
