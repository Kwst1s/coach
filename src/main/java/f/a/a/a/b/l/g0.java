package f.a.a.a.b.l;

import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TimePicker;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.a.b;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.q;
import java.text.DateFormat;
import vainstrum.Components.FABTracking;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: Frag_tool_worry_time */
public class g0 extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private ScrollView g0;
    private AppCompatEditText h0;
    private LinearLayoutTracking i0;
    private LinearLayoutTracking j0;
    private AppCompatTextView k0;
    private SwitchCompat l0;
    private DateFormat m0;
    private boolean n0 = true;
    private b0 o0;
    private b0 p0;
    private a0 q0;
    private int r0;
    private String s0;
    private Boolean t0;
    private Boolean u0;
    private BroadcastReceiver v0;

    /* compiled from: Frag_tool_worry_time */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: f.a.a.a.b.l.g0$a$a  reason: collision with other inner class name */
        /* compiled from: Frag_tool_worry_time */
        class RunnableC0196a implements Runnable {
            RunnableC0196a() {
            }

            public void run() {
                g0.this.g0.fullScroll(130);
            }
        }

        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                g0.this.i0.setTrackingId("35807");
                String str = g0.this.Q(R.string.reminder_worry_time_switch) + " " + g0.this.Q(R.string.on) + " " + g0.this.Q(R.string.button);
                g0.this.i0.setContentDescription(str);
                if (g0.this.n0) {
                    g0.this.i0.announceForAccessibility(str);
                }
                g0.this.j0.setVisibility(0);
                j.U(g0.this.n(), g0.this.j0, g0.this.Q(R.string.daily_worry_time_reminder_at) + " " + j.i(q.c(g0.this.n(), "worry_time_reminder_time")));
                g0.this.k0.setText(g0.this.m0.format(Long.valueOf(q.c(g0.this.n(), "worry_time_reminder_time"))));
                if (g0.this.n0) {
                    new Handler().postDelayed(new RunnableC0196a(), 300);
                }
            } else {
                g0.this.i0.setTrackingId("35902");
                String str2 = g0.this.Q(R.string.reminder_worry_time_switch) + " " + g0.this.Q(R.string.off) + " " + g0.this.Q(R.string.button);
                g0.this.i0.setContentDescription(str2);
                if (g0.this.n0) {
                    g0.this.i0.announceForAccessibility(str2);
                }
                g0.this.j0.setVisibility(8);
            }
            q.J(g0.this.n(), z);
        }
    }

    /* compiled from: Frag_tool_worry_time */
    class b extends BroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (g0.this.r0 == -1) {
                g0.this.c0.finish();
                return;
            }
            h W1 = h.W1(g0.this.o0, g0.this.q0, g0.this.r0, g0.this.s0);
            W1.V1(g0.this.R1());
            g0.this.c0.W(W1, g0.this.Q(R.string.distress_meter));
        }
    }

    /* compiled from: Frag_tool_worry_time */
    class c implements TimePickerDialog.OnTimeSetListener {
        c() {
        }

        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            g0.this.j2(i2, i3);
        }
    }

    /* compiled from: Frag_tool_worry_time */
    class d implements b.f {
        d() {
        }

        @Override // f.a.a.a.b.a.b.f
        public void a(int i2, int i3) {
            g0.this.j2(i2, i3);
        }
    }

    public g0() {
        Boolean bool = Boolean.FALSE;
        this.t0 = bool;
        this.u0 = bool;
    }

    public static g0 h2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        g0 g0Var = new g0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        g0Var.v1(bundle);
        return g0Var;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.v0);
        j.u(n()).putString("wtime_txt", this.h0.getText().toString()).apply();
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        i2();
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.v0 = new b();
        try {
            n().registerReceiver(this.v0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.o0);
        bundle.putSerializable("selected_tool", this.p0);
        bundle.putSerializable("symptom", this.q0);
        bundle.putInt("old_distress", this.r0);
        bundle.putString("last_tool_name", this.s0);
        super.K0(bundle);
    }

    public void i2() {
        this.n0 = false;
        if (q.l(n())) {
            this.l0.setChecked(true);
        } else {
            this.l0.setChecked(false);
        }
        this.n0 = true;
    }

    public void j2(int i2, int i3) {
        long r = q.r(i2, i3);
        q.x(n(), "worry_time_reminder_time", r);
        q.J(n(), true);
        this.k0.setText(this.m0.format(Long.valueOf(r)));
        androidx.fragment.app.d n = n();
        LinearLayoutTracking linearLayoutTracking = this.j0;
        j.U(n, linearLayoutTracking, Q(R.string.daily_worry_time_reminder_at) + " " + j.i(r));
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.o0 = (b0) bundle.getSerializable("tool");
            this.p0 = (b0) bundle.getSerializable("selected_tool");
            this.q0 = (a0) bundle.getSerializable("symptom");
            this.r0 = bundle.getInt("old_distress");
            this.s0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.o0 = (b0) u().getSerializable("tool");
            this.p0 = (b0) u().getSerializable("selected_tool");
            this.q0 = (a0) u().getSerializable("symptom");
            this.r0 = u().getInt("old_distress");
            this.s0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.p0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.u0 = Boolean.valueOf(m.o(n(), this.p0, this.d0, this.e0, this.u0, this.t0));
            this.t0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.t0 = Boolean.valueOf(m.n(n(), this.p0, this.d0, this.e0, this.u0, this.t0));
            this.u0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.q0, this.o0, this.r0);
        }
        if (view.getId() == this.i0.getId()) {
            SwitchCompat switchCompat = this.l0;
            switchCompat.setChecked(!switchCompat.isChecked());
        }
        if (view.getId() == this.j0.getId()) {
            q.z(n(), Q(R.string.schedule_worry_time), this.j0, new c(), new d(), q.c(n(), "worry_time_reminder_time"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_worry_time, viewGroup, false);
        this.g0 = (ScrollView) inflate.findViewById(R.id.schedule_worry_time_sview);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.h0 = (AppCompatEditText) inflate.findViewById(R.id.schedule_worry_time_edt);
        this.i0 = (LinearLayoutTracking) inflate.findViewById(R.id.worry_time_layout_reminder);
        this.j0 = (LinearLayoutTracking) inflate.findViewById(R.id.worry_time_layout_reminding);
        this.k0 = (AppCompatTextView) inflate.findViewById(R.id.worry_time_txt_reminder_time);
        this.l0 = (SwitchCompat) inflate.findViewById(R.id.worry_time_switch_reminder);
        m.R0(n(), inflate.findViewById(R.id.schedule_worry_time_layout));
        if (this.q0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.h0.setText(j.s(n()).getString("wtime_txt", BuildConfig.FLAVOR));
        this.i0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.m0 = DateFormat.getTimeInstance(3);
        m.f0(this.p0.d(), this.d0, this.e0);
        this.u0 = Boolean.valueOf(m.C0(n(), this.p0.d(), this.d0, false));
        this.t0 = Boolean.valueOf(m.B0(n(), this.p0.d(), this.e0, false));
        if (this.l0.isChecked()) {
            this.i0.setTrackingId("35807");
            this.i0.setContentDescription(Q(R.string.reminder_worry_time_switch) + " " + Q(R.string.on) + " " + Q(R.string.button));
        } else {
            this.i0.setTrackingId("35902");
            this.i0.setContentDescription(Q(R.string.reminder_worry_time_switch) + " " + Q(R.string.off) + " " + Q(R.string.button));
        }
        this.l0.setOnCheckedChangeListener(new a());
        return inflate;
    }
}
