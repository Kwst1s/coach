package f.a.a.a.b.l.i0;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.a.a;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.c0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: Frag_seated_practice_intro */
public class c extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private b0 d0;
    private b0 e0;
    private a0 f0;
    private int g0;
    private String h0;
    private TextView i0;
    private ImageView j0;
    private LinearLayoutTracking k0;
    private LinearLayoutTracking l0;
    private LinearLayoutTracking m0;
    private TextView n0;
    private TextView o0;
    private SwitchCompat p0;
    private AppCompatButton q0;
    private AppCompatButton r0;
    private String s0;
    private int t0 = 5;

    /* compiled from: Frag_seated_practice_intro */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (c.this.p0.isChecked()) {
                c.this.c0.W(b.p2(c.this.d0, c.this.e0, c.this.f0, c.this.g0, c.this.h0, c.this.t0, c.this.s0), c.this.Q(R.string.seated_practice));
            } else {
                c.this.c0.W(d.v2(c.this.d0, c.this.e0, c.this.f0, c.this.g0, c.this.h0, c.this.t0, c.this.s0), c.this.Q(R.string.seated_practice));
            }
        }
    }

    /* compiled from: Frag_seated_practice_intro */
    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                c.this.k0.setTrackingId("31330");
                c.this.k0.announceForAccessibility(c.this.Q(R.string.instructions_switch_on));
                c.this.k0.setContentDescription(c.this.Q(R.string.instructions_switch_on));
                return;
            }
            c.this.k0.setTrackingId("31348");
            c.this.k0.announceForAccessibility(c.this.Q(R.string.instructions_switch_off));
            c.this.k0.setContentDescription(c.this.Q(R.string.instructions_switch_off));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.l.i0.c$c  reason: collision with other inner class name */
    /* compiled from: Frag_seated_practice_intro */
    public class C0200c implements a.i {
        C0200c() {
        }

        @Override // f.a.a.a.b.a.a.i
        public void a(int i2) {
            c.this.t0 = i2;
            c.this.j2();
            j.u(c.this.n()).putInt("seated_duration_selected", c.this.t0).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_intro */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            s.a(c.this.l0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_intro */
    public class e implements DialogInterface.OnCancelListener {
        e() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            s.a(c.this.l0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_intro */
    public class f implements c0.g {
        f() {
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.c0.g
        public void a(int i2) {
            c.this.t0 = i2;
            c.this.j2();
            j.u(c.this.n()).putInt("seated_duration_selected", c.this.t0).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_intro */
    public class g implements DialogInterface.OnDismissListener {
        g() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            s.a(c.this.l0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_intro */
    public class h implements DialogInterface.OnCancelListener {
        h() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            s.a(c.this.l0);
        }
    }

    public static c i2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        cVar.v1(bundle);
        return cVar;
    }

    public void j2() {
        if (this.t0 == 1) {
            StringBuilder sb = new StringBuilder(Integer.toString(this.t0) + " " + Q(R.string.minute));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append(Q(R.string.duration_btn));
            sb.append(sb2.toString());
            this.l0.setContentDescription(sb.toString());
            TextView textView = this.n0;
            textView.setText(Integer.toString(this.t0) + " " + Q(R.string.minute));
            return;
        }
        StringBuilder sb3 = new StringBuilder(Integer.toString(this.t0) + " " + Q(R.string.minutes));
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" ");
        sb4.append(Q(R.string.duration_btn));
        sb3.append(sb4.toString());
        this.l0.setContentDescription(sb3.toString());
        TextView textView2 = this.n0;
        textView2.setText(Integer.toString(this.t0) + " " + Q(R.string.minutes));
    }

    public void k2(String str) {
        this.s0 = str;
        String W = m.W(n(), str);
        StringBuilder sb = new StringBuilder();
        sb.append(W);
        sb.append(" " + Q(R.string.tone) + " " + Q(R.string.button));
        this.m0.setContentDescription(sb.toString());
        this.o0.setText(W);
        j.u(n()).putString("seated_tone_selected", str).apply();
    }

    public void l2() {
        if (s.m(n())) {
            f.a.a.a.b.a.a aVar = new f.a.a.a.b.a.a(n());
            aVar.d(Q(R.string.duration), this.t0, 60, new C0200c());
            aVar.setOnDismissListener(new d());
            aVar.setOnCancelListener(new e());
            aVar.show();
            return;
        }
        c0 c0Var = new c0(n());
        c0Var.b(this.t0, 60, new f());
        c0Var.setOnDismissListener(new g());
        c0Var.setOnCancelListener(new h());
        c0Var.show();
    }

    public void m2() {
        a aVar = new a();
        aVar.Y1(this, this.s0);
        aVar.U1(v(), BuildConfig.FLAVOR);
    }

    public void n2() {
        this.i0.setText(R.string.seated_practice_intro);
        String W = m.W(n(), this.s0);
        StringBuilder sb = new StringBuilder();
        sb.append(W);
        sb.append(" " + Q(R.string.tone) + " " + Q(R.string.button));
        this.m0.setContentDescription(sb.toString());
        this.o0.setText(W);
        j2();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.d0 = (b0) bundle.getSerializable("tool");
            this.e0 = (b0) bundle.getSerializable("selected_tool");
            this.f0 = (a0) bundle.getSerializable("symptom");
            this.g0 = bundle.getInt("old_distress");
            this.h0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.d0 = (b0) u().getSerializable("tool");
            this.e0 = (b0) u().getSerializable("selected_tool");
            this.f0 = (a0) u().getSerializable("symptom");
            this.g0 = u().getInt("old_distress");
            this.h0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.e0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.k0.getId()) {
            SwitchCompat switchCompat = this.p0;
            switchCompat.setChecked(!switchCompat.isChecked());
        }
        if (view.getId() == this.l0.getId()) {
            l2();
        }
        if (view.getId() == this.m0.getId()) {
            m2();
        }
        if (view.getId() == this.r0.getId()) {
            m.c0(true, this.c0, this.f0, this.d0, this.g0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_seated_practice_intro, viewGroup, false);
        this.i0 = (TextView) inflate.findViewById(R.id.seated_practice_intro_txt_description);
        this.j0 = (ImageView) inflate.findViewById(R.id.seated_practice_intro_img);
        this.k0 = (LinearLayoutTracking) inflate.findViewById(R.id.seated_practice_intro_layout_instructions);
        this.l0 = (LinearLayoutTracking) inflate.findViewById(R.id.seated_practice_intro_layout_time);
        this.m0 = (LinearLayoutTracking) inflate.findViewById(R.id.seated_practice_intro_layout_tone);
        this.n0 = (TextView) inflate.findViewById(R.id.seated_practice_intro_txt_time);
        this.o0 = (TextView) inflate.findViewById(R.id.seated_practice_intro_txt_tone);
        this.p0 = (SwitchCompat) inflate.findViewById(R.id.seated_practice_intro_switch_instructions);
        this.q0 = (AppCompatButton) inflate.findViewById(R.id.seated_practice_intro_btn_start_exercise);
        AppCompatButton appCompatButton = (AppCompatButton) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.r0 = appCompatButton;
        appCompatButton.setBackgroundResource(R.drawable.custom_bg_green);
        this.r0.setTextColor(-1);
        this.k0.setOnClickListener(this);
        this.l0.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        if (this.f0 == null) {
            this.r0.setVisibility(8);
        }
        this.j0.getLayoutParams().height = j.r(n()) / 2;
        this.s0 = j.s(n()).getString("seated_tone_selected", "ThreeBells.mp3");
        this.t0 = j.s(n()).getInt("seated_duration_selected", 5);
        this.q0.setOnClickListener(new a());
        this.k0.setTrackingId("31330");
        this.p0.setOnCheckedChangeListener(new b());
        n2();
        return inflate;
    }
}
