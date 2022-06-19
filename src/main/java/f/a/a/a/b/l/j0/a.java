package f.a.a.a.b.l.j0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_thought_shifting_timer */
public class a extends vainstrum.Components.b {
    private Act_manage c0;
    private TextView d0;
    private TextView e0;
    private FABTracking f0;
    private FABTracking g0;
    private b0 h0;
    private b0 i0;
    private a0 j0;
    private int k0;
    private String l0;
    private CountDownTimer m0;
    private long n0 = 300000;
    private ArrayList<String> o0;
    private boolean p0 = false;
    private boolean q0 = true;
    private BroadcastReceiver r0;
    private int s0;

    /* renamed from: f.a.a.a.b.l.j0.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_tool_thought_shifting_timer */
    class View$OnClickListenerC0202a implements View.OnClickListener {
        View$OnClickListenerC0202a() {
        }

        public void onClick(View view) {
            a.this.k2(false);
        }
    }

    /* compiled from: Frag_tool_thought_shifting_timer */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            a.this.k2(true);
        }
    }

    /* compiled from: Frag_tool_thought_shifting_timer */
    class c extends View.AccessibilityDelegate {
        c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768) {
                a.this.p0 = true;
            } else if (i2 == 65536) {
                a.this.p0 = false;
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_tool_thought_shifting_timer */
    class d extends BroadcastReceiver {
        d() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (a.this.k0 == -1) {
                a.this.c0.finish();
                return;
            }
            if (a.this.m0 != null) {
                a.this.m0.cancel();
                a.this.m0 = null;
            }
            a.this.q0 = false;
            a.this.c0.W(h.W1(a.this.h0, a.this.j0, a.this.k0, a.this.l0), a.this.Q(R.string.distress_meter));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_thought_shifting_timer */
    public class e extends CountDownTimer {
        e(long j2, long j3) {
            super(j2, j3);
        }

        public void onFinish() {
            if (a.this.q0) {
                m.V0(a.this.n());
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.Q(R.string.timer_ended));
            a.this.e0.setText("00:00");
            a.this.e0.setContentDescription(sb);
            a.this.m0 = null;
        }

        public void onTick(long j2) {
            a.this.n0 = j2;
            StringBuilder sb = new StringBuilder();
            sb.append(BuildConfig.FLAVOR);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            sb.append(String.format("%02d:%02d", Long.valueOf(timeUnit.toMinutes(j2)), Long.valueOf(timeUnit.toSeconds(j2) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j2)))));
            String sb2 = sb.toString();
            String T = m.T(a.this.n(), a.this.n0);
            a.this.e0.setContentDescription(T);
            if (a.this.p0 && m.t0(a.this.n0)) {
                a.this.e0.announceForAccessibility(T);
            }
            a.this.e0.setText(sb2);
        }
    }

    public static a l2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        aVar.v1(bundle);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.r0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.r0 = new d();
        try {
            n().registerReceiver(this.r0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        this.q0 = true;
        if (this.m0 == null) {
            m2(true);
            n2();
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.h0);
        bundle.putSerializable("selected_tool", this.i0);
        bundle.putSerializable("symptom", this.j0);
        bundle.putInt("old_distress", this.k0);
        bundle.putStringArrayList("texts_to_show", this.o0);
        bundle.putString("last_tool_name", this.l0);
        super.K0(bundle);
    }

    public void k2(boolean z) {
        if (z) {
            int i2 = this.s0 + 1;
            this.s0 = i2;
            if (i2 == this.o0.size()) {
                this.s0 = 0;
            }
        } else {
            int i3 = this.s0 - 1;
            this.s0 = i3;
            if (i3 < 0) {
                this.s0 = this.o0.size() - 1;
            }
        }
        this.d0.setText(this.o0.get(this.s0));
        TextView textView = this.d0;
        textView.announceForAccessibility(textView.getText());
    }

    public void m2(boolean z) {
        int nextInt = new Random().nextInt(this.o0.size());
        this.s0 = nextInt;
        this.d0.setText(this.o0.get(nextInt));
        if (z) {
            TextView textView = this.d0;
            textView.announceForAccessibility(Q(R.string.started_timer) + " " + ((Object) this.d0.getText()));
            return;
        }
        TextView textView2 = this.d0;
        textView2.announceForAccessibility(textView2.getText());
    }

    public void n2() {
        this.m0 = new e(this.n0, 1000).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.h0 = (b0) bundle.getSerializable("tool");
            this.i0 = (b0) bundle.getSerializable("selected_tool");
            this.j0 = (a0) bundle.getSerializable("symptom");
            this.k0 = bundle.getInt("old_distress");
            this.o0 = bundle.getStringArrayList("texts_to_show");
            this.l0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.h0 = (b0) u().getSerializable("tool");
            this.i0 = (b0) u().getSerializable("selected_tool");
            this.j0 = (a0) u().getSerializable("symptom");
            this.k0 = u().getInt("old_distress");
            this.l0 = u().getString("last_tool_name");
        }
    }

    public void o2() {
        try {
            androidx.fragment.app.d n = n();
            JSONArray jSONArray = new JSONArray(j.N(n, g.f10089i + File.separator + this.i0.c()));
            this.o0 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.o0.add(jSONArray.getString(i2));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_thoughts_shifting_timer, (ViewGroup) null);
        this.d0 = (TextView) inflate.findViewById(R.id.thought_shifting_txt_content);
        this.e0 = (TextView) inflate.findViewById(R.id.thought_shifting_txt_countdown);
        this.f0 = (FABTracking) inflate.findViewById(R.id.thought_shifting_btn_previous);
        this.g0 = (FABTracking) inflate.findViewById(R.id.thought_shifting_btn_next);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.thought_shifting_layout_btns_refreshers);
        this.f0.setOnClickListener(new View$OnClickListenerC0202a());
        this.g0.setOnClickListener(new b());
        if (this.o0 == null) {
            o2();
        } else {
            m2(false);
        }
        this.e0.setAccessibilityDelegate(new c());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        CountDownTimer countDownTimer = this.m0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.t0();
    }
}
