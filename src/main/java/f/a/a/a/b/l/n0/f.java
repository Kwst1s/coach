package f.a.a.a.b.l.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.concurrent.TimeUnit;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_RID_relax */
public class f extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private TextView g0;
    private TextView h0;
    private TextView i0;
    private Button j0;
    private b0 k0;
    private b0 l0;
    private a0 m0;
    private int n0;
    private String o0;
    private CountDownTimer p0;
    private long q0 = 30000;
    private boolean r0 = false;
    private boolean s0 = false;
    private boolean t0 = true;
    private boolean u0 = false;
    private BroadcastReceiver v0;

    /* compiled from: Frag_tool_RID_relax */
    class a extends View.AccessibilityDelegate {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768) {
                f.this.u0 = true;
            } else if (i2 == 65536) {
                f.this.u0 = false;
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_tool_RID_relax */
    class b extends BroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                if (f.this.p0 != null) {
                    f.this.p0.cancel();
                    f.this.p0 = null;
                }
                f.this.t0 = false;
                f.this.c0.W(i.c2(f.this.k0, f.this.l0, f.this.m0, f.this.n0, f.this.o0), f.this.Q(R.string.rid_identify));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_RID_relax */
    public class c extends CountDownTimer {
        c(long j2, long j3) {
            super(j2, j3);
        }

        public void onFinish() {
            f.this.l2();
            f.this.j0.setEnabled(true);
        }

        public void onTick(long j2) {
            f.this.q0 = j2;
            StringBuilder sb = new StringBuilder();
            sb.append(BuildConfig.FLAVOR);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            sb.append(String.format("%02d:%02d", Long.valueOf(timeUnit.toMinutes(j2)), Long.valueOf(timeUnit.toSeconds(j2) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j2)))));
            String sb2 = sb.toString();
            String T = m.T(f.this.n(), f.this.q0);
            f.this.i0.setContentDescription(T);
            if (f.this.u0 && m.t0(f.this.q0)) {
                f.this.i0.announceForAccessibility(T);
            }
            f.this.i0.setText(sb2);
            f.this.j0.setText(R.string.more_seconds_of_relax);
            f.this.j0.setContentDescription(f.this.Q(R.string.more_seconds_of_relax));
            f.this.j0.setEnabled(false);
        }
    }

    public static f m2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        fVar.v1(bundle);
        return fVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.v0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.v0 = new b();
        try {
            n().registerReceiver(this.v0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        this.t0 = true;
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.k0);
        bundle.putSerializable("selected_tool", this.l0);
        bundle.putSerializable("symptom", this.m0);
        bundle.putInt("old_distress", this.n0);
        bundle.putString("last_tool_name", this.o0);
        super.K0(bundle);
    }

    public void l2() {
        if (this.t0) {
            m.V0(n());
            this.i0.setText("00:00");
            this.j0.setTextColor(b.h.d.a.b(n(), 17170444));
            this.j0.announceForAccessibility(Q(R.string.more_seconds_of_relax_activated));
            this.j0.setOnClickListener(this);
        }
    }

    public void n2() {
        this.p0 = new c(this.q0, 1000).start();
        this.j0.announceForAccessibility(Q(R.string.started_30_seconds_of_relax));
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.k0 = (b0) bundle.getSerializable("tool");
            this.l0 = (b0) bundle.getSerializable("selected_tool");
            this.m0 = (a0) bundle.getSerializable("symptom");
            this.n0 = bundle.getInt("old_distress");
            this.o0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.k0 = (b0) u().getSerializable("tool");
            this.l0 = (b0) u().getSerializable("selected_tool");
            this.m0 = (a0) u().getSerializable("symptom");
            this.n0 = u().getInt("old_distress");
            this.o0 = u().getString("last_tool_name");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.j0.getId()) {
            this.q0 = 30000;
            n2();
        }
        if (view.getId() == this.d0.getId()) {
            this.s0 = m.o(n(), this.l0, this.d0, this.e0, Boolean.valueOf(this.s0), Boolean.valueOf(this.r0));
            this.r0 = false;
        }
        if (view.getId() == this.e0.getId()) {
            this.r0 = m.n(n(), this.l0, this.d0, this.e0, Boolean.valueOf(this.s0), Boolean.valueOf(this.r0));
            this.s0 = false;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.m0, this.k0, this.n0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_rid_relax, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (TextView) inflate.findViewById(R.id.rid_relax_txt_title);
        this.h0 = (TextView) inflate.findViewById(R.id.rid_relax_txt_content);
        this.i0 = (TextView) inflate.findViewById(R.id.rid_relax_txt_countdown);
        this.j0 = (Button) inflate.findViewById(R.id.rid_relax_btn_other_30_seconds);
        if (this.m0 == null) {
            this.f0.setVisibility(8);
        }
        this.j0.setOnClickListener(this);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.l0.d(), this.d0, this.e0);
        this.s0 = m.C0(n(), this.l0.d(), this.d0, false);
        this.r0 = m.B0(n(), this.l0.d(), this.e0, false);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Q(R.string.rid));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(b.h.d.a.b(n(), R.color.red)), 0, 1, 33);
        this.g0.setText(spannableStringBuilder);
        this.h0.setText(Html.fromHtml(Q(R.string.rid_relax_text)));
        this.h0.announceForAccessibility(Html.fromHtml(Q(R.string.rid_relax_text)));
        this.i0.setAccessibilityDelegate(new a());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        CountDownTimer countDownTimer = this.p0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.t0();
    }
}
