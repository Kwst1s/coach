package f.a.a.a.b.b;

import android.app.TimePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.a.b;
import f.a.a.a.b.d.v;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.q;
import java.text.DateFormat;
import java.util.ArrayList;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: Item_tool_winding_down_adapter */
public class p0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private f.a.a.a.b.l.h0.b f9000c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<v> f9001d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Integer> f9002e;

    /* renamed from: f  reason: collision with root package name */
    private DateFormat f9003f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9004g = true;

    /* compiled from: Item_tool_winding_down_adapter */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f9005b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f9006c;

        a(v vVar, f fVar) {
            this.f9005b = vVar;
            this.f9006c = fVar;
        }

        public void onClick(View view) {
            if (p0.this.B(this.f9005b)) {
                p0.this.E(this.f9006c, this.f9005b);
            } else {
                p0.this.A(this.f9006c, this.f9005b);
            }
        }
    }

    /* compiled from: Item_tool_winding_down_adapter */
    class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f9008b;

        b(p0 p0Var, g gVar) {
            this.f9008b = gVar;
        }

        public void onClick(View view) {
            SwitchCompat switchCompat = this.f9008b.v;
            switchCompat.setChecked(!switchCompat.isChecked());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_tool_winding_down_adapter */
    public class c implements TimePickerDialog.OnTimeSetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f9009a;

        c(g gVar) {
            this.f9009a = gVar;
        }

        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            p0 p0Var = p0.this;
            g gVar = this.f9009a;
            p0Var.G(i2, i3, gVar.w, gVar.u);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_tool_winding_down_adapter */
    public class d implements b.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f9011a;

        d(g gVar) {
            this.f9011a = gVar;
        }

        @Override // f.a.a.a.b.a.b.f
        public void a(int i2, int i3) {
            p0 p0Var = p0.this;
            g gVar = this.f9011a;
            p0Var.G(i2, i3, gVar.w, gVar.u);
        }
    }

    /* compiled from: Item_tool_winding_down_adapter */
    class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f9013a;

        e(g gVar) {
            this.f9013a = gVar;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f9013a.t.setTrackingId("36916");
                String str = p0.this.f9000c.Q(R.string.reminder_wind_time_switch) + " " + p0.this.f9000c.Q(R.string.on) + " " + p0.this.f9000c.Q(R.string.button);
                this.f9013a.t.setContentDescription(str);
                if (p0.this.f9004g) {
                    this.f9013a.t.announceForAccessibility(str);
                }
                this.f9013a.u.setVisibility(0);
                this.f9013a.u.setVisibility(0);
                this.f9013a.w.setText(p0.this.f9003f.format(Long.valueOf(q.c(p0.this.f9000c.n(), "winding_down_reminder_time"))));
                j.U(p0.this.f9000c.n(), this.f9013a.u, p0.this.f9000c.Q(R.string.winding_down) + " " + j.i(q.c(p0.this.f9000c.n(), "winding_down_reminder_time")));
            } else {
                this.f9013a.t.setTrackingId("37052");
                String str2 = p0.this.f9000c.Q(R.string.reminder_wind_time_switch) + " " + p0.this.f9000c.Q(R.string.off) + " " + p0.this.f9000c.Q(R.string.button);
                this.f9013a.t.setContentDescription(str2);
                if (p0.this.f9004g) {
                    this.f9013a.t.announceForAccessibility(str2);
                }
                this.f9013a.u.setVisibility(8);
            }
            q.I(p0.this.f9000c.n(), z);
        }
    }

    /* compiled from: Item_tool_winding_down_adapter */
    public static class f extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected ImageView v;

        public f(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_list_star_layout);
            this.u = (TextView) view.findViewById(R.id.item_list_star_txt);
            this.v = (ImageView) view.findViewById(R.id.item_list_star_img);
        }
    }

    /* compiled from: Item_tool_winding_down_adapter */
    public static class g extends RecyclerView.d0 {
        protected LinearLayoutTracking t;
        protected LinearLayoutTracking u;
        protected SwitchCompat v;
        protected TextView w;
        protected TextView x;

        public g(View view) {
            super(view);
            this.t = (LinearLayoutTracking) view.findViewById(R.id.winding_down_layout_reminder);
            this.u = (LinearLayoutTracking) view.findViewById(R.id.winding_down_layout_reminding);
            this.v = (SwitchCompat) view.findViewById(R.id.winding_down_switch_reminder);
            this.w = (TextView) view.findViewById(R.id.winding_down_txt_reminder_time);
            this.x = (TextView) view.findViewById(R.id.winding_down_txt_title);
        }
    }

    public p0(f.a.a.a.b.l.h0.b bVar, ArrayList<v> arrayList, ArrayList<Integer> arrayList2) {
        this.f9000c = bVar;
        this.f9001d = arrayList;
        this.f9002e = arrayList2;
        this.f9003f = DateFormat.getTimeInstance(3);
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D(g gVar, View view) {
        q.z(this.f9000c.n(), this.f9000c.Q(R.string.winding_down_reminder), gVar.u, new c(gVar), new d(gVar), q.c(this.f9000c.n(), "winding_down_reminder_time"));
    }

    public void A(f fVar, v vVar) {
        this.f9002e.add(Integer.valueOf(vVar.a()));
        F(fVar, vVar);
        LinearLayout linearLayout = fVar.t;
        linearLayout.announceForAccessibility(vVar.c() + " " + this.f9000c.Q(R.string.favorite) + this.f9000c.Q(R.string.button));
    }

    public boolean B(v vVar) {
        for (int i2 = 0; i2 < this.f9002e.size(); i2++) {
            if (this.f9002e.get(i2).intValue() == vVar.a()) {
                return true;
            }
        }
        return false;
    }

    public void E(f fVar, v vVar) {
        for (int i2 = 0; i2 < this.f9002e.size(); i2++) {
            if (this.f9002e.get(i2).intValue() == vVar.a()) {
                this.f9002e.remove(i2);
                F(fVar, vVar);
                LinearLayout linearLayout = fVar.t;
                linearLayout.announceForAccessibility(vVar.c() + " " + this.f9000c.Q(R.string.button));
                return;
            }
        }
    }

    public void F(f fVar, v vVar) {
        if (B(vVar)) {
            fVar.v.setImageResource(R.drawable.star_full);
            LinearLayout linearLayout = fVar.t;
            linearLayout.setContentDescription(vVar.c() + " " + this.f9000c.Q(R.string.favorite) + this.f9000c.Q(R.string.button));
            return;
        }
        fVar.v.setImageResource(R.drawable.star_empty);
        LinearLayout linearLayout2 = fVar.t;
        linearLayout2.setContentDescription(vVar.c() + " " + this.f9000c.Q(R.string.button));
    }

    public void G(int i2, int i3, TextView textView, LinearLayout linearLayout) {
        long r = q.r(i2, i3);
        q.x(this.f9000c.n(), "winding_down_reminder_time", r);
        q.I(this.f9000c.n(), true);
        textView.setText(this.f9003f.format(Long.valueOf(r)));
        androidx.fragment.app.d n = this.f9000c.n();
        j.U(n, linearLayout, this.f9000c.Q(R.string.daily_winding_down_reminder_at) + " " + j.i(r));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9001d.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (i2 != 0) {
            v vVar = this.f9001d.get(i2 - 1);
            f fVar = (f) d0Var;
            fVar.u.setText(vVar.c());
            F(fVar, vVar);
            a aVar = new a(vVar, fVar);
            fVar.t.setOnClickListener(aVar);
            fVar.v.setOnClickListener(aVar);
            return;
        }
        g gVar = (g) d0Var;
        gVar.x.setTypeface(b.h.d.e.f.b(this.f9000c.n(), R.font.font_semibold));
        gVar.t.setOnClickListener(new b(this, gVar));
        gVar.u.setOnClickListener(new k(this, gVar));
        gVar.v.setOnCheckedChangeListener(new e(gVar));
        this.f9004g = false;
        if (q.k(this.f9000c.n())) {
            gVar.v.setChecked(true);
            gVar.t.setTrackingId("36916");
            androidx.fragment.app.d n = this.f9000c.n();
            LinearLayoutTracking linearLayoutTracking = gVar.u;
            j.U(n, linearLayoutTracking, this.f9000c.Q(R.string.daily_winding_down_reminder_at) + " " + j.i(q.c(this.f9000c.n(), "winding_down_reminder_time")));
        } else {
            gVar.v.setChecked(false);
            gVar.t.setTrackingId("37052");
            gVar.t.setContentDescription(this.f9000c.Q(R.string.reminder_wind_time_switch) + " " + this.f9000c.Q(R.string.off) + " " + this.f9000c.Q(R.string.button));
        }
        this.f9004g = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 != 0) {
            return new f(from.inflate(R.layout.item_list_star, viewGroup, false));
        }
        return new g(from.inflate(R.layout.item_header_winding_down, viewGroup, false));
    }
}
