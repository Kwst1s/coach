package f.a.a.a.b.f;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.f0;
import com.github.mikephil.charting.R;
import f.a.a.a.b.a.a;
import gov.va.mobilehealth.ncptsd.covid.CComp.c0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.q;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: Frag_reminders */
public class j extends vainstrum.Components.b implements View.OnClickListener {
    private LinearLayout A0;
    private LinearLayout B0;
    private LinearLayout C0;
    private LinearLayout D0;
    private SwitchCompat E0;
    private TextView F0;
    private TextView G0;
    private TextView H0;
    private TextView I0;
    private LinearLayout J0;
    private LinearLayout K0;
    private LinearLayout L0;
    private LinearLayout M0;
    private LinearLayout N0;
    private SwitchCompat O0;
    private TextView P0;
    private TextView Q0;
    private TextView R0;
    private TextView S0;
    private LinearLayout T0;
    private LinearLayout U0;
    private LinearLayout V0;
    private LinearLayout W0;
    private LinearLayout X0;
    private SwitchCompat Y0;
    private TextView Z0;
    private TextView a1;
    private TextView b1;
    private LinearLayout c0;
    private TextView c1;
    private LinearLayout d0;
    private LinearLayout d1;
    private LinearLayout e0;
    private SwitchCompat e1;
    private LinearLayout f0;
    private TextView f1;
    private LinearLayout g0;
    private TextView g1;
    private LinearLayout h0;
    private TextView h1;
    private LinearLayout i0;
    private TextView i1;
    private LinearLayout j0;
    private LinearLayout j1;
    private LinearLayout k0;
    private LinearLayout k1;
    private SwitchCompat l0;
    private LinearLayout l1;
    private TextView m0;
    private LinearLayout m1;
    private TextView n0;
    private LinearLayout n1;
    private TextView o0;
    private LinearLayout o1;
    private TextView p0;
    private LinearLayout p1;
    private LinearLayout q0;
    private LinearLayout q1;
    private LinearLayout r0;
    private LinearLayout r1;
    private LinearLayout s0;
    private LinearLayout s1;
    private LinearLayout t0;
    private AppCompatTextView t1;
    private SwitchCompat u0;
    private SwitchCompat u1;
    private TextView v0;
    private DateFormat v1 = DateFormat.getTimeInstance(3);
    private TextView w0;
    private SimpleDateFormat w1 = new SimpleDateFormat("EEEE", Locale.getDefault());
    private TextView x0;
    private int x1 = -1;
    private TextView y0;
    private LinearLayout z0;

    /* compiled from: Frag_reminders */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                k.b.d.k(j.this.Q(R.string.assessment_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
                q.E(j.this.n(), z, "ptsd_symptoms_lastday");
                j.this.M2(false);
                LinearLayout linearLayout = j.this.c0;
                linearLayout.announceForAccessibility(j.this.Q(R.string.assessment_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
            } else if (m.b(j.this.n())) {
                k.b.d.k(j.this.Q(R.string.ptsd_symptoms_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                q.E(j.this.n(), z, "ptsd_symptoms_lastday");
                j.this.M2(false);
                LinearLayout linearLayout2 = j.this.c0;
                linearLayout2.announceForAccessibility(j.this.Q(R.string.ptsd_symptoms_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                k.b.d.l(j.this.n(), "assessment", "reminder", null);
            } else {
                j.this.Y0.setChecked(false);
                j.this.G2(5);
            }
        }
    }

    /* compiled from: Frag_reminders */
    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                k.b.d.k(j.this.Q(R.string.track_mood_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
                q.G(j.this.n(), z, "track_mood_lastday");
                j.this.L2(false);
                LinearLayout linearLayout = j.this.T0;
                linearLayout.announceForAccessibility(j.this.Q(R.string.track_mood_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
            } else if (m.b(j.this.n())) {
                k.b.d.k(j.this.Q(R.string.track_mood_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                q.G(j.this.n(), z, "track_mood_lastday");
                j.this.L2(false);
                LinearLayout linearLayout2 = j.this.T0;
                linearLayout2.announceForAccessibility(j.this.Q(R.string.track_mood_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                k.b.d.l(j.this.n(), "assessment", "reminder", null);
            } else {
                j.this.O0.setChecked(false);
                j.this.G2(4);
            }
        }
    }

    /* compiled from: Frag_reminders */
    class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                k.b.d.k(j.this.Q(R.string.try_manage_stress_tool) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
                q.F(j.this.n(), z, "try_tool_lastday");
                j.this.O2(false);
                LinearLayout linearLayout = j.this.T0;
                linearLayout.announceForAccessibility(j.this.Q(R.string.try_manage_stress_tool) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
            } else if (m.b(j.this.n())) {
                k.b.d.k(j.this.Q(R.string.try_manage_stress_tool) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                q.F(j.this.n(), z, "try_tool_lastday");
                j.this.O2(false);
                LinearLayout linearLayout2 = j.this.j1;
                linearLayout2.announceForAccessibility(j.this.Q(R.string.try_manage_stress_tool) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                k.b.d.l(j.this.n(), "assessment", "reminder", null);
            } else {
                j.this.e1.setChecked(false);
                j.this.G2(6);
            }
        }
    }

    /* compiled from: Frag_reminders */
    class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                k.b.d.k(j.this.Q(R.string.daily_inspiring_quote_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
                q.C(j.this.n(), z);
                j.this.N2(false);
                LinearLayout linearLayout = j.this.h0;
                linearLayout.announceForAccessibility(j.this.Q(R.string.daily_inspiring_quote_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
            } else if (m.b(j.this.n())) {
                q.C(j.this.n(), z);
                j.this.N2(false);
                k.b.d.k(j.this.Q(R.string.daily_inspiring_quote_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                LinearLayout linearLayout2 = j.this.h0;
                StringBuilder sb = new StringBuilder();
                sb.append(j.this.Q(R.string.daily_inspiring_quote_reminder));
                sb.append(j.this.Q(R.string.is_switch));
                sb.append(j.this.Q(R.string.on));
                linearLayout2.announceForAccessibility(sb.toString());
                k.b.d.l(j.this.n(), "inspiring_quote", "reminder", null);
            } else {
                j.this.u1.setChecked(false);
                j.this.G2(0);
            }
        }
    }

    /* compiled from: Frag_reminders */
    class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                k.b.d.k(j.this.Q(R.string.goal_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.off));
                q.D(j.this.n(), z, "goal_lastday");
                j.this.K2(false);
                LinearLayout linearLayout = j.this.j0;
                linearLayout.announceForAccessibility(j.this.Q(R.string.goal_reminder) + j.this.Q(R.string.is_switch) + j.this.Q(R.string.off));
            } else if (m.b(j.this.n())) {
                k.b.d.k(j.this.Q(R.string.goal_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                q.D(j.this.n(), z, "goal_lastday");
                j.this.K2(false);
                LinearLayout linearLayout2 = j.this.j0;
                linearLayout2.announceForAccessibility(j.this.Q(R.string.goal_reminder) + " " + j.this.Q(R.string.is_switch) + ": " + j.this.Q(R.string.on));
                k.b.d.l(j.this.n(), "goals", "reminder", null);
            } else {
                j.this.l0.setChecked(false);
                j.this.G2(1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_reminders */
    public class f implements f0.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9333c;

        f(String str, int i2, String str2) {
            this.f9331a = str;
            this.f9332b = i2;
            this.f9333c = str2;
        }

        @Override // androidx.appcompat.widget.f0.d
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.fr_daily /*{ENCODED_INT: 2131296811}*/:
                    gov.va.mobilehealth.ncptsd.covid.CComp.j.u(j.this.n()).putString(this.f9331a, "daily").commit();
                    switch (this.f9332b) {
                        case 1:
                            q.D(j.this.n(), true, this.f9333c);
                            break;
                        case 2:
                            q.H(j.this.n(), true, this.f9333c);
                            break;
                        case 3:
                            q.B(j.this.n(), true, this.f9333c);
                            break;
                        case 4:
                            q.G(j.this.n(), true, this.f9333c);
                            break;
                        case 5:
                            q.E(j.this.n(), true, this.f9333c);
                            break;
                        case 6:
                            q.F(j.this.n(), true, this.f9333c);
                            break;
                    }
                case R.id.fr_monthly /*{ENCODED_INT: 2131296812}*/:
                    gov.va.mobilehealth.ncptsd.covid.CComp.j.u(j.this.n()).putString(this.f9331a, "monthly").commit();
                    switch (this.f9332b) {
                        case 1:
                            q.D(j.this.n(), true, this.f9333c);
                            break;
                        case 2:
                            q.H(j.this.n(), true, this.f9333c);
                            break;
                        case 3:
                            q.B(j.this.n(), true, this.f9333c);
                            break;
                        case 4:
                            q.G(j.this.n(), true, this.f9333c);
                            break;
                        case 5:
                            q.E(j.this.n(), true, this.f9333c);
                            break;
                        case 6:
                            q.F(j.this.n(), true, this.f9333c);
                            break;
                    }
                case R.id.fr_weekly /*{ENCODED_INT: 2131296813}*/:
                    gov.va.mobilehealth.ncptsd.covid.CComp.j.u(j.this.n()).putString(this.f9331a, "weekly").commit();
                    switch (this.f9332b) {
                        case 1:
                            q.D(j.this.n(), true, this.f9333c);
                            break;
                        case 2:
                            q.H(j.this.n(), true, this.f9333c);
                            break;
                        case 3:
                            q.B(j.this.n(), true, this.f9333c);
                            break;
                        case 4:
                            q.G(j.this.n(), true, this.f9333c);
                            break;
                        case 5:
                            q.E(j.this.n(), true, this.f9333c);
                            break;
                        case 6:
                            q.F(j.this.n(), true, this.f9333c);
                            break;
                    }
            }
            switch (this.f9332b) {
                case 1:
                    j.this.K2(false);
                    j.this.m0.setText(menuItem.getTitle());
                    LinearLayout linearLayout = j.this.q0;
                    linearLayout.announceForAccessibility(j.this.Q(R.string.selected) + " " + j.this.Q(R.string.frequency) + " " + ((Object) menuItem.getTitle()));
                    s.a(j.this.q0);
                    break;
                case 2:
                    j.this.P2(false);
                    j.this.v0.setText(menuItem.getTitle());
                    LinearLayout linearLayout2 = j.this.A0;
                    linearLayout2.announceForAccessibility(j.this.Q(R.string.selected) + " " + j.this.Q(R.string.frequency) + " " + ((Object) menuItem.getTitle()));
                    s.a(j.this.A0);
                    break;
                case 3:
                    j.this.J2(false);
                    j.this.F0.setText(menuItem.getTitle());
                    LinearLayout linearLayout3 = j.this.K0;
                    linearLayout3.announceForAccessibility(j.this.Q(R.string.selected) + " " + j.this.Q(R.string.frequency) + " " + ((Object) menuItem.getTitle()));
                    s.a(j.this.K0);
                    break;
                case 4:
                    j.this.L2(false);
                    j.this.P0.setText(menuItem.getTitle());
                    LinearLayout linearLayout4 = j.this.U0;
                    linearLayout4.announceForAccessibility(j.this.Q(R.string.selected) + " " + j.this.Q(R.string.frequency) + " " + ((Object) menuItem.getTitle()));
                    s.a(j.this.U0);
                    break;
                case 5:
                    j.this.M2(false);
                    j.this.Z0.setText(menuItem.getTitle());
                    LinearLayout linearLayout5 = j.this.d0;
                    linearLayout5.announceForAccessibility(j.this.Q(R.string.selected) + " " + j.this.Q(R.string.frequency) + " " + ((Object) menuItem.getTitle()));
                    s.a(j.this.d0);
                    break;
                case 6:
                    j.this.O2(false);
                    j.this.f1.setText(menuItem.getTitle());
                    LinearLayout linearLayout6 = j.this.k1;
                    linearLayout6.announceForAccessibility(j.this.Q(R.string.selected) + " " + j.this.Q(R.string.frequency) + " " + ((Object) menuItem.getTitle()));
                    s.a(j.this.k1);
                    break;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_reminders */
    public class g implements c0.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9335a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9336b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LinearLayout f9337c;

        g(String str, int i2, LinearLayout linearLayout) {
            this.f9335a = str;
            this.f9336b = i2;
            this.f9337c = linearLayout;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.c0.g
        public void a(int i2) {
            q.x(j.this.n(), this.f9335a, q.v(gov.va.mobilehealth.ncptsd.covid.CComp.g.p0[i2].intValue(), q.c(j.this.n(), this.f9335a)));
            switch (this.f9336b) {
                case 1:
                    q.D(j.this.n(), true, "goal_lastday");
                    j.this.K2(false);
                    break;
                case 2:
                    q.H(j.this.n(), true, "well_being_lastday");
                    j.this.P2(false);
                    break;
                case 3:
                    q.B(j.this.n(), true, "anxiety_lastday");
                    j.this.J2(false);
                    break;
                case 4:
                    q.B(j.this.n(), true, "track_mood_lastday");
                    j.this.L2(false);
                    break;
                case 5:
                    q.E(j.this.n(), true, "ptsd_symptoms_lastday");
                    j.this.M2(false);
                    break;
                case 6:
                    q.F(j.this.n(), true, "try_tool_lastday");
                    j.this.O2(false);
                    break;
            }
            s.a(this.f9337c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_reminders */
    public class h implements a.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9339a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9340b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9341c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9342d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LinearLayout f9343e;

        h(String str, String str2, String str3, int i2, LinearLayout linearLayout) {
            this.f9339a = str;
            this.f9340b = str2;
            this.f9341c = str3;
            this.f9342d = i2;
            this.f9343e = linearLayout;
        }

        @Override // f.a.a.a.b.a.a.i
        public void a(int i2) {
            if (this.f9339a.equals("weekly")) {
                q.x(j.this.n(), this.f9340b, q.v(gov.va.mobilehealth.ncptsd.covid.CComp.g.p0[i2].intValue(), q.c(j.this.n(), this.f9340b)));
            } else if (i2 == 29) {
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(j.this.n()).putBoolean(this.f9341c, true).commit();
                q.x(j.this.n(), this.f9340b, q.t(j.this.n(), i2, q.c(j.this.n(), this.f9340b), this.f9341c));
            } else {
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(j.this.n()).putBoolean(this.f9341c, false).commit();
                q.x(j.this.n(), this.f9340b, q.t(j.this.n(), i2, q.c(j.this.n(), this.f9340b), this.f9341c));
            }
            switch (this.f9342d) {
                case 1:
                    q.D(j.this.n(), true, "goal_lastday");
                    j.this.K2(false);
                    break;
                case 2:
                    q.H(j.this.n(), true, "ptsd_symptoms_lastday");
                    j.this.P2(false);
                    break;
                case 3:
                    q.B(j.this.n(), true, "anxiety_lastday");
                    j.this.J2(false);
                    break;
                case 4:
                    q.G(j.this.n(), true, "track_mood_lastday");
                    j.this.L2(false);
                    break;
                case 5:
                    q.E(j.this.n(), true, "ptsd_symptoms_lastday");
                    j.this.M2(false);
                    break;
                case 6:
                    q.F(j.this.n(), true, "try_tool_lastday");
                    j.this.O2(false);
                    break;
            }
            s.a(this.f9343e);
        }
    }

    public static j D2(int i2) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putInt("showOnly", i2);
        jVar.v1(bundle);
        return jVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: s2 */
    public /* synthetic */ void t2(CompoundButton compoundButton, boolean z) {
        if (!z) {
            k.b.d.j(n(), "26149");
            q.H(n(), z, "well_being_lastday");
            P2(false);
            LinearLayout linearLayout = this.z0;
            linearLayout.announceForAccessibility(Q(R.string.track_well_being_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        } else if (m.b(n())) {
            k.b.d.k(Q(R.string.track_well_being_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            q.H(n(), z, "well_being_lastday");
            P2(false);
            LinearLayout linearLayout2 = this.z0;
            linearLayout2.announceForAccessibility(Q(R.string.track_well_being_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            k.b.d.l(n(), "assessment", "reminder", null);
        } else {
            this.u0.setChecked(false);
            G2(2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u2 */
    public /* synthetic */ void v2(CompoundButton compoundButton, boolean z) {
        if (!z) {
            k.b.d.k(Q(R.string.track_anxiety_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
            q.B(n(), z, "anxiety_lastday");
            J2(false);
            LinearLayout linearLayout = this.J0;
            linearLayout.announceForAccessibility(Q(R.string.track_anxiety_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        } else if (m.b(n())) {
            k.b.d.j(n(), "25356");
            q.B(n(), z, "anxiety_lastday");
            J2(false);
            LinearLayout linearLayout2 = this.J0;
            linearLayout2.announceForAccessibility(Q(R.string.track_anxiety_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            k.b.d.l(n(), "assessment", "reminder", null);
        } else {
            this.E0.setChecked(false);
            G2(3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w2 */
    public /* synthetic */ void x2(int i2, DialogInterface dialogInterface, int i3) {
        gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("notificationson", true).commit();
        switch (i2) {
            case 0:
                this.u1.setChecked(true);
                return;
            case 1:
                this.l0.setChecked(true);
                return;
            case 2:
                this.u0.setChecked(true);
                return;
            case 3:
                this.E0.setChecked(true);
                return;
            case 4:
                this.O0.setChecked(true);
                return;
            case 5:
                this.Y0.setChecked(true);
                return;
            case 6:
                this.e1.setChecked(true);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z2 */
    public /* synthetic */ void A2(String str, int i2, TimePicker timePicker, int i3, int i4) {
        B2(i3, i4, str, i2);
    }

    /* renamed from: E2 */
    public void B2(int i2, int i3, String str, int i4) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        switch (i4) {
            case 0:
                q.x(n(), str, q.r(i2, i3));
                q.C(n(), true);
                N2(false);
                return;
            case 1:
                String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_goal_frequency", "daily");
                long c2 = q.c(n(), "reminder_goal_time");
                if (string.equals("weekly")) {
                    j2 = q.w(c2, i2, i3);
                } else if (string.equals("daily")) {
                    j2 = q.r(i2, i3);
                } else {
                    j2 = q.u(n(), c2, i2, i3, "goal_lastday");
                }
                q.x(n(), str, j2);
                q.D(n(), true, "goal_lastday");
                K2(false);
                return;
            case 2:
                String string2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_well_being_frequency", "weekly");
                long c3 = q.c(n(), "reminder_well_being_time");
                if (string2.equals("weekly")) {
                    j3 = q.w(c3, i2, i3);
                } else if (string2.equals("daily")) {
                    j3 = q.r(i2, i3);
                } else {
                    j3 = q.u(n(), c3, i2, i3, "well_being_lastday");
                }
                q.x(n(), str, j3);
                q.H(n(), true, "well_being_lastday");
                P2(false);
                return;
            case 3:
                String string3 = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_anxiety_frequency", "weekly");
                long c4 = q.c(n(), "reminder_anxiety_time");
                if (string3.equals("weekly")) {
                    j4 = q.w(c4, i2, i3);
                } else if (string3.equals("daily")) {
                    j4 = q.r(i2, i3);
                } else {
                    j4 = q.u(n(), c4, i2, i3, "anxiety_lastday");
                }
                q.x(n(), str, j4);
                q.B(n(), true, "anxiety_lastday");
                J2(false);
                return;
            case 4:
                String string4 = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_track_mood_frequency", "weekly");
                long c5 = q.c(n(), "reminder_track_mood_time");
                if (string4.equals("weekly")) {
                    j5 = q.w(c5, i2, i3);
                } else if (string4.equals("daily")) {
                    j5 = q.r(i2, i3);
                } else {
                    j5 = q.u(n(), c5, i2, i3, "track_mood_lastday");
                }
                q.x(n(), str, j5);
                q.G(n(), true, "track_mood_lastday");
                L2(false);
                return;
            case 5:
                String string5 = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_ptsd_symptoms_frequency", "weekly");
                long c6 = q.c(n(), "reminder_ptsd_symptoms_time");
                if (string5.equals("weekly")) {
                    j6 = q.w(c6, i2, i3);
                } else if (string5.equals("daily")) {
                    j6 = q.r(i2, i3);
                } else {
                    j6 = q.u(n(), c6, i2, i3, "ptsd_symptoms_lastday");
                }
                q.x(n(), str, j6);
                q.E(n(), true, "ptsd_symptoms_lastday");
                M2(false);
                return;
            case 6:
                String string6 = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_try_tool_frequency", "daily");
                long c7 = q.c(n(), "reminder_try_tool_time");
                if (string6.equals("weekly")) {
                    j7 = q.w(c7, i2, i3);
                } else if (string6.equals("daily")) {
                    j7 = q.r(i2, i3);
                } else {
                    j7 = q.u(n(), c7, i2, i3, "try_tool_lastday");
                }
                q.x(n(), str, j7);
                q.F(n(), true, "try_tool_lastday");
                O2(false);
                return;
            default:
                return;
        }
    }

    public void F2(String str, String str2, String str3, LinearLayout linearLayout, int i2, int i3) {
        String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString(str2, "weekly");
        g gVar = new g(str, i3, linearLayout);
        h hVar = new h(string, str, str3, i3, linearLayout);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(q.c(n(), str));
        if (string.equals("weekly")) {
            q.A(n(), Q(i2), linearLayout, s.g(instance.get(7)), gVar, hVar);
        } else if (gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getBoolean(str3, false)) {
            q.y(n(), Q(i2), linearLayout, 29, hVar);
        } else {
            q.y(n(), Q(i2), linearLayout, instance.get(5), hVar);
        }
    }

    public void G2(int i2) {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(n(), Q(R.string.enable_notifications));
        h2.k(R.string.yes, new d(this, i2));
        h2.h(R.string.no, e.f9317b);
        h2.a().show();
    }

    public void H2(String str, String str2, int i2) {
        f0 f0Var;
        switch (i2) {
            case 1:
                f0Var = new f0(n(), this.q0, 5);
                break;
            case 2:
                f0Var = new f0(n(), this.A0, 5);
                break;
            case 3:
                f0Var = new f0(n(), this.K0, 5);
                break;
            case 4:
                f0Var = new f0(n(), this.U0, 5);
                break;
            case 5:
                f0Var = new f0(n(), this.d0, 5);
                break;
            case 6:
                f0Var = new f0(n(), this.k1, 5);
                break;
            default:
                f0Var = null;
                break;
        }
        f0Var.b().inflate(R.menu.menu_frequency, f0Var.a());
        f0Var.d(new f(str, i2, str2));
        f0Var.e();
    }

    public void I2(String str, View view, int i2) {
        g gVar = new g(this, str, i2);
        f fVar = new f(this, str, i2);
        switch (i2) {
            case 0:
                q.z(n(), Q(R.string.daily_quote_reminder), view, gVar, fVar, q.c(n(), str));
                return;
            case 1:
                q.z(n(), Q(R.string.goal_reminder), view, gVar, fVar, q.c(n(), str));
                return;
            case 2:
                q.z(n(), Q(R.string.track_well_being_reminder), view, gVar, fVar, q.c(n(), str));
                return;
            case 3:
                q.z(n(), Q(R.string.track_anxiety_reminder), view, gVar, fVar, q.c(n(), str));
                return;
            case 4:
                q.z(n(), Q(R.string.track_mood_reminder), view, gVar, fVar, q.c(n(), str));
                return;
            case 5:
                q.z(n(), Q(R.string.ptsd_symptoms_reminder), view, gVar, fVar, q.c(n(), str));
                return;
            case 6:
                q.z(n(), Q(R.string.try_manage_stress_tool), view, gVar, fVar, q.c(n(), str));
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
    }

    public void J2(boolean z) {
        if (q.d(n())) {
            if (z) {
                this.E0.setChecked(true);
            }
            boolean t = gov.va.mobilehealth.ncptsd.covid.CComp.j.t(n(), "anxiety_lastday", false);
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout = this.J0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout, Q(R.string.track_anxiety) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            this.D0.setVisibility(0);
            String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_anxiety_frequency", "weekly");
            if (string.equals("weekly")) {
                this.I0.setText(R.string.day_s);
                this.L0.setVisibility(0);
                this.F0.setText(R.string.weekly);
                androidx.fragment.app.d n2 = n();
                LinearLayout linearLayout2 = this.K0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n2, linearLayout2, Q(R.string.track_anxiety) + " " + Q(R.string.frequency) + Q(R.string.weekly));
            } else if (string.equals("monthly")) {
                this.I0.setText(R.string.day_of_month);
                this.L0.setVisibility(0);
                this.F0.setText(R.string.monthly);
                androidx.fragment.app.d n3 = n();
                LinearLayout linearLayout3 = this.K0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n3, linearLayout3, Q(R.string.track_anxiety) + " " + Q(R.string.frequency) + Q(R.string.monthly));
            } else {
                this.L0.setVisibility(8);
                this.F0.setText(R.string.daily);
                androidx.fragment.app.d n4 = n();
                LinearLayout linearLayout4 = this.K0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n4, linearLayout4, Q(R.string.track_anxiety) + " " + Q(R.string.frequency) + Q(R.string.daily));
            }
            this.H0.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_anxiety_time"))));
            androidx.fragment.app.d n5 = n();
            LinearLayout linearLayout5 = this.M0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n5, linearLayout5, Q(R.string.track_anxiety) + " " + Q(R.string.f11071at) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_anxiety_time")));
            if (string.equals("weekly")) {
                this.G0.setText(gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_anxiety_time")))));
                androidx.fragment.app.d n6 = n();
                LinearLayout linearLayout6 = this.L0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n6, linearLayout6, Q(R.string.track_anxiety) + " " + Q(R.string.on) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_anxiety_time")))));
                return;
            }
            long c2 = q.c(n(), "reminder_anxiety_time");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (t) {
                this.G0.setText(R.string.last_day_of_month);
                androidx.fragment.app.d n7 = n();
                LinearLayout linearLayout7 = this.L0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n7, linearLayout7, Q(R.string.track_anxiety) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            int i2 = instance.get(5);
            if (i2 > 28) {
                this.G0.setText(R.string.last_day_of_month);
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("anxiety_lastday", true).commit();
                q.B(n(), true, "anxiety_lastday");
                androidx.fragment.app.d n8 = n();
                LinearLayout linearLayout8 = this.L0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n8, linearLayout8, Q(R.string.track_anxiety) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            this.G0.setText(Integer.toString(i2));
            androidx.fragment.app.d n9 = n();
            LinearLayout linearLayout9 = this.L0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n9, linearLayout9, Q(R.string.track_anxiety) + " " + Q(R.string.on) + " " + Integer.toString(i2));
            return;
        }
        androidx.fragment.app.d n10 = n();
        LinearLayout linearLayout10 = this.J0;
        gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n10, linearLayout10, Q(R.string.track_anxiety) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        this.D0.setVisibility(8);
    }

    public void K2(boolean z) {
        if (q.f(n())) {
            if (z) {
                this.l0.setChecked(true);
            }
            boolean t = gov.va.mobilehealth.ncptsd.covid.CComp.j.t(n(), "goal_lastday", false);
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout = this.j0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout, Q(R.string.goal_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            this.k0.setVisibility(0);
            String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_goal_frequency", "weekly");
            if (string.equals("weekly")) {
                this.p0.setText(R.string.day_s);
                this.r0.setVisibility(0);
                this.m0.setText(R.string.weekly);
                androidx.fragment.app.d n2 = n();
                LinearLayout linearLayout2 = this.q0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n2, linearLayout2, Q(R.string.goal_reminder) + " " + Q(R.string.frequency) + Q(R.string.weekly));
            } else if (string.equals("monthly")) {
                this.p0.setText(R.string.day_of_month);
                this.r0.setVisibility(0);
                this.m0.setText(R.string.monthly);
                androidx.fragment.app.d n3 = n();
                LinearLayout linearLayout3 = this.q0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n3, linearLayout3, Q(R.string.goal_reminder) + " " + Q(R.string.frequency) + Q(R.string.monthly));
            } else {
                this.r0.setVisibility(8);
                this.m0.setText(R.string.daily);
                androidx.fragment.app.d n4 = n();
                LinearLayout linearLayout4 = this.q0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n4, linearLayout4, Q(R.string.goal_reminder) + " " + Q(R.string.frequency) + Q(R.string.daily));
            }
            this.o0.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_goal_time"))));
            androidx.fragment.app.d n5 = n();
            LinearLayout linearLayout5 = this.s0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n5, linearLayout5, Q(R.string.goal_reminder) + " " + Q(R.string.f11071at) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_goal_time")));
            if (string.equals("weekly")) {
                this.n0.setText(gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_goal_time")))));
                androidx.fragment.app.d n6 = n();
                LinearLayout linearLayout6 = this.r0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n6, linearLayout6, Q(R.string.goal_reminder) + " " + Q(R.string.on) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_goal_time")))));
                return;
            }
            long c2 = q.c(n(), "reminder_goal_time");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (t) {
                this.n0.setText(R.string.last_day_of_month);
                androidx.fragment.app.d n7 = n();
                LinearLayout linearLayout7 = this.r0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n7, linearLayout7, Q(R.string.goal_reminder) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            int i2 = instance.get(5);
            if (i2 > 28) {
                this.n0.setText(R.string.last_day_of_month);
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("goal_lastday", true).commit();
                q.D(n(), true, "goal_lastday");
                androidx.fragment.app.d n8 = n();
                LinearLayout linearLayout8 = this.r0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n8, linearLayout8, Q(R.string.goal_reminder) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            this.n0.setText(Integer.toString(i2));
            androidx.fragment.app.d n9 = n();
            LinearLayout linearLayout9 = this.r0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n9, linearLayout9, Q(R.string.goal_reminder) + " " + Q(R.string.on) + " " + Integer.toString(i2));
            return;
        }
        androidx.fragment.app.d n10 = n();
        LinearLayout linearLayout10 = this.j0;
        gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n10, linearLayout10, Q(R.string.goal_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        this.k0.setVisibility(8);
    }

    public void L2(boolean z) {
        if (q.i(n())) {
            if (z) {
                this.O0.setChecked(true);
            }
            boolean t = gov.va.mobilehealth.ncptsd.covid.CComp.j.t(n(), "track_mood_lastday", false);
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout = this.T0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout, Q(R.string.track_mood) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            this.N0.setVisibility(0);
            String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_track_mood_frequency", "weekly");
            if (string.equals("weekly")) {
                this.S0.setText(R.string.day_s);
                this.V0.setVisibility(0);
                this.P0.setText(R.string.weekly);
                androidx.fragment.app.d n2 = n();
                LinearLayout linearLayout2 = this.U0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n2, linearLayout2, Q(R.string.track_mood) + " " + Q(R.string.frequency) + Q(R.string.weekly));
            } else if (string.equals("monthly")) {
                this.S0.setText(R.string.day_of_month);
                this.V0.setVisibility(0);
                this.P0.setText(R.string.monthly);
                androidx.fragment.app.d n3 = n();
                LinearLayout linearLayout3 = this.U0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n3, linearLayout3, Q(R.string.track_mood) + " " + Q(R.string.frequency) + Q(R.string.monthly));
            } else {
                this.V0.setVisibility(8);
                this.P0.setText(R.string.daily);
                androidx.fragment.app.d n4 = n();
                LinearLayout linearLayout4 = this.U0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n4, linearLayout4, Q(R.string.track_mood) + " " + Q(R.string.frequency) + Q(R.string.daily));
            }
            this.R0.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_track_mood_time"))));
            androidx.fragment.app.d n5 = n();
            LinearLayout linearLayout5 = this.W0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n5, linearLayout5, Q(R.string.track_mood) + " " + Q(R.string.f11071at) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_track_mood_time")));
            if (string.equals("weekly")) {
                this.Q0.setText(gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_track_mood_time")))));
                androidx.fragment.app.d n6 = n();
                LinearLayout linearLayout6 = this.V0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n6, linearLayout6, Q(R.string.track_mood) + " " + Q(R.string.on) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_track_mood_time")))));
                return;
            }
            long c2 = q.c(n(), "reminder_track_mood_time");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (t) {
                this.Q0.setText(R.string.last_day_of_month);
                androidx.fragment.app.d n7 = n();
                LinearLayout linearLayout7 = this.V0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n7, linearLayout7, Q(R.string.track_mood) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            int i2 = instance.get(5);
            if (i2 > 28) {
                this.Q0.setText(R.string.last_day_of_month);
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("track_mood_lastday", true).commit();
                q.G(n(), true, "track_mood_lastday");
                androidx.fragment.app.d n8 = n();
                LinearLayout linearLayout8 = this.V0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n8, linearLayout8, Q(R.string.track_mood) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            this.Q0.setText(Integer.toString(i2));
            androidx.fragment.app.d n9 = n();
            LinearLayout linearLayout9 = this.V0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n9, linearLayout9, Q(R.string.track_mood) + " " + Q(R.string.on) + " " + Integer.toString(i2));
            return;
        }
        androidx.fragment.app.d n10 = n();
        LinearLayout linearLayout10 = this.T0;
        gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n10, linearLayout10, Q(R.string.track_mood) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        this.N0.setVisibility(8);
    }

    public void M2(boolean z) {
        if (q.g(n())) {
            if (z) {
                this.Y0.setChecked(true);
            }
            boolean t = gov.va.mobilehealth.ncptsd.covid.CComp.j.t(n(), "ptsd_symptoms_lastday", false);
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout = this.c0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            this.X0.setVisibility(0);
            String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_ptsd_symptoms_frequency", "weekly");
            if (string.equals("weekly")) {
                this.c1.setText(R.string.day_s);
                this.e0.setVisibility(0);
                this.Z0.setText(R.string.weekly);
                androidx.fragment.app.d n2 = n();
                LinearLayout linearLayout2 = this.d0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n2, linearLayout2, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.frequency) + Q(R.string.weekly));
            } else if (string.equals("monthly")) {
                this.c1.setText(R.string.day_of_month);
                this.e0.setVisibility(0);
                this.Z0.setText(R.string.monthly);
                androidx.fragment.app.d n3 = n();
                LinearLayout linearLayout3 = this.d0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n3, linearLayout3, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.frequency) + Q(R.string.monthly));
            } else {
                this.e0.setVisibility(8);
                this.Z0.setText(R.string.daily);
                androidx.fragment.app.d n4 = n();
                LinearLayout linearLayout4 = this.d0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n4, linearLayout4, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.frequency) + Q(R.string.daily));
            }
            this.b1.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_ptsd_symptoms_time"))));
            androidx.fragment.app.d n5 = n();
            LinearLayout linearLayout5 = this.f0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n5, linearLayout5, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.f11071at) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_ptsd_symptoms_time")));
            if (string.equals("weekly")) {
                this.a1.setText(gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_ptsd_symptoms_time")))));
                androidx.fragment.app.d n6 = n();
                LinearLayout linearLayout6 = this.e0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n6, linearLayout6, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.on) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_ptsd_symptoms_time")))));
                return;
            }
            long c2 = q.c(n(), "reminder_ptsd_symptoms_time");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (t) {
                this.a1.setText(R.string.last_day_of_month);
                androidx.fragment.app.d n7 = n();
                LinearLayout linearLayout7 = this.e0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n7, linearLayout7, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            int i2 = instance.get(5);
            if (i2 > 28) {
                this.a1.setText(R.string.last_day_of_month);
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("ptsd_symptoms_lastday", true).commit();
                q.E(n(), true, "ptsd_symptoms_lastday");
                androidx.fragment.app.d n8 = n();
                LinearLayout linearLayout8 = this.e0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n8, linearLayout8, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            this.a1.setText(Integer.toString(i2));
            androidx.fragment.app.d n9 = n();
            LinearLayout linearLayout9 = this.e0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n9, linearLayout9, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.on) + " " + Integer.toString(i2));
            return;
        }
        androidx.fragment.app.d n10 = n();
        LinearLayout linearLayout10 = this.c0;
        gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n10, linearLayout10, Q(R.string.ptsd_symptoms_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        this.X0.setVisibility(8);
    }

    public void N2(boolean z) {
        if (q.e(n())) {
            this.h0.setContentDescription(Q(R.string.daily_inspiring_quote) + " " + Q(R.string.is_switch) + " " + Q(R.string.on) + " " + Q(R.string.button));
            if (!z) {
                LinearLayout linearLayout = this.h0;
                linearLayout.announceForAccessibility(Q(R.string.daily_inspiring_quote) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            } else {
                this.u1.setChecked(true);
            }
            this.i0.setVisibility(0);
            this.t1.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_quote_time"))));
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout2 = this.i0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout2, Q(R.string.daily_inspiring_quote) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_quote_time")));
            return;
        }
        this.h0.setContentDescription(Q(R.string.daily_inspiring_quote) + " " + Q(R.string.is_switch) + " " + Q(R.string.off) + " " + Q(R.string.button));
        if (!z) {
            LinearLayout linearLayout3 = this.h0;
            linearLayout3.announceForAccessibility(Q(R.string.daily_inspiring_quote) + " " + Q(R.string.is_switch) + " " + Q(R.string.off));
        } else {
            this.u1.setChecked(false);
        }
        this.i0.setVisibility(8);
    }

    public void O2(boolean z) {
        if (q.h(n())) {
            if (z) {
                this.e1.setChecked(true);
            }
            boolean t = gov.va.mobilehealth.ncptsd.covid.CComp.j.t(n(), "try_tool_lastday", false);
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout = this.j1;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            this.d1.setVisibility(0);
            String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_try_tool_frequency", "daily");
            if (string.equals("weekly")) {
                this.i1.setText(R.string.day_s);
                this.l1.setVisibility(0);
                this.f1.setText(R.string.weekly);
                androidx.fragment.app.d n2 = n();
                LinearLayout linearLayout2 = this.k1;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n2, linearLayout2, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.frequency) + Q(R.string.weekly));
            } else if (string.equals("monthly")) {
                this.i1.setText(R.string.day_of_month);
                this.l1.setVisibility(0);
                this.f1.setText(R.string.monthly);
                androidx.fragment.app.d n3 = n();
                LinearLayout linearLayout3 = this.k1;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n3, linearLayout3, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.frequency) + Q(R.string.monthly));
            } else {
                this.l1.setVisibility(8);
                this.f1.setText(R.string.daily);
                androidx.fragment.app.d n4 = n();
                LinearLayout linearLayout4 = this.k1;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n4, linearLayout4, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.frequency) + Q(R.string.daily));
            }
            this.h1.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_try_tool_time"))));
            androidx.fragment.app.d n5 = n();
            LinearLayout linearLayout5 = this.m1;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n5, linearLayout5, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.f11071at) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_try_tool_time")));
            if (string.equals("weekly")) {
                this.g1.setText(gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_try_tool_time")))));
                androidx.fragment.app.d n6 = n();
                LinearLayout linearLayout6 = this.l1;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n6, linearLayout6, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.on) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_try_tool_time")))));
                return;
            }
            long c2 = q.c(n(), "reminder_try_tool_time");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (t) {
                this.g1.setText(R.string.last_day_of_month);
                androidx.fragment.app.d n7 = n();
                LinearLayout linearLayout7 = this.l1;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n7, linearLayout7, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            int i2 = instance.get(5);
            if (i2 > 28) {
                this.g1.setText(R.string.last_day_of_month);
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("try_tool_lastday", true).commit();
                q.F(n(), true, "try_tool_lastday");
                androidx.fragment.app.d n8 = n();
                LinearLayout linearLayout8 = this.l1;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n8, linearLayout8, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            this.g1.setText(Integer.toString(i2));
            androidx.fragment.app.d n9 = n();
            LinearLayout linearLayout9 = this.l1;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n9, linearLayout9, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.on) + " " + Integer.toString(i2));
            return;
        }
        androidx.fragment.app.d n10 = n();
        LinearLayout linearLayout10 = this.j1;
        gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n10, linearLayout10, Q(R.string.try_manage_stress_tool) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        this.d1.setVisibility(8);
    }

    public void P2(boolean z) {
        if (q.j(n())) {
            if (z) {
                this.u0.setChecked(true);
            }
            boolean t = gov.va.mobilehealth.ncptsd.covid.CComp.j.t(n(), "well_being_lastday", false);
            androidx.fragment.app.d n = n();
            LinearLayout linearLayout = this.z0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n, linearLayout, Q(R.string.track_well_being_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.on));
            this.t0.setVisibility(0);
            String string = gov.va.mobilehealth.ncptsd.covid.CComp.j.s(n()).getString("reminder_well_being_frequency", "weekly");
            if (string.equals("weekly")) {
                this.y0.setText(R.string.day_s);
                this.B0.setVisibility(0);
                this.v0.setText(R.string.weekly);
                androidx.fragment.app.d n2 = n();
                LinearLayout linearLayout2 = this.A0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n2, linearLayout2, Q(R.string.track_well_being_reminder) + " " + Q(R.string.frequency) + Q(R.string.weekly));
            } else if (string.equals("monthly")) {
                this.y0.setText(R.string.day_of_month);
                this.B0.setVisibility(0);
                this.v0.setText(R.string.monthly);
                androidx.fragment.app.d n3 = n();
                LinearLayout linearLayout3 = this.A0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n3, linearLayout3, Q(R.string.track_well_being_reminder) + " " + Q(R.string.frequency) + Q(R.string.monthly));
            } else {
                this.B0.setVisibility(8);
                this.v0.setText(R.string.daily);
                androidx.fragment.app.d n4 = n();
                LinearLayout linearLayout4 = this.A0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n4, linearLayout4, Q(R.string.track_well_being_reminder) + " " + Q(R.string.frequency) + Q(R.string.daily));
            }
            this.x0.setText(this.v1.format(Long.valueOf(q.c(n(), "reminder_well_being_time"))));
            androidx.fragment.app.d n5 = n();
            LinearLayout linearLayout5 = this.C0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n5, linearLayout5, Q(R.string.track_well_being_reminder) + " " + Q(R.string.f11071at) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.i(q.c(n(), "reminder_well_being_time")));
            if (string.equals("weekly")) {
                this.w0.setText(gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_well_being_time")))));
                androidx.fragment.app.d n6 = n();
                LinearLayout linearLayout6 = this.B0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n6, linearLayout6, Q(R.string.track_well_being_reminder) + " " + Q(R.string.on) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.j.c(this.w1.format(Long.valueOf(q.c(n(), "reminder_well_being_time")))));
                return;
            }
            long c2 = q.c(n(), "reminder_ptsd_symptoms_time");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (t) {
                this.w0.setText(R.string.last_day_of_month);
                androidx.fragment.app.d n7 = n();
                LinearLayout linearLayout7 = this.B0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n7, linearLayout7, Q(R.string.track_well_being_reminder) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            int i2 = instance.get(5);
            if (i2 > 28) {
                this.w0.setText(R.string.last_day_of_month);
                gov.va.mobilehealth.ncptsd.covid.CComp.j.u(n()).putBoolean("well_being_lastday", true).commit();
                q.H(n(), true, "well_being_lastday");
                androidx.fragment.app.d n8 = n();
                LinearLayout linearLayout8 = this.B0;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n8, linearLayout8, Q(R.string.track_well_being_reminder) + " " + Q(R.string.on) + " " + Q(R.string.last_day_of_month));
                return;
            }
            this.w0.setText(Integer.toString(i2));
            androidx.fragment.app.d n9 = n();
            LinearLayout linearLayout9 = this.B0;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n9, linearLayout9, Q(R.string.track_well_being_reminder) + " " + Q(R.string.on) + " " + Integer.toString(i2));
            return;
        }
        androidx.fragment.app.d n10 = n();
        LinearLayout linearLayout10 = this.z0;
        gov.va.mobilehealth.ncptsd.covid.CComp.j.U(n10, linearLayout10, Q(R.string.track_well_being_reminder) + " " + Q(R.string.is_switch) + ": " + Q(R.string.off));
        this.t0.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        if (u() != null) {
            this.x1 = u().getInt("showOnly");
        }
        super.o0(bundle);
    }

    public void onClick(View view) {
        if (view.getId() == this.h0.getId()) {
            SwitchCompat switchCompat = this.u1;
            switchCompat.setChecked(!switchCompat.isChecked());
        }
        if (view.getId() == this.j0.getId()) {
            SwitchCompat switchCompat2 = this.l0;
            switchCompat2.setChecked(!switchCompat2.isChecked());
        }
        if (view.getId() == this.r0.getId()) {
            F2("reminder_goal_time", "reminder_goal_frequency", "goal_lastday", this.r0, R.string.what_day_of_the_month, 1);
        }
        if (view.getId() == this.s0.getId()) {
            I2("reminder_goal_time", this.s0, 1);
        }
        if (view.getId() == this.q0.getId()) {
            H2("reminder_goal_frequency", "goal_lastday", 1);
        }
        if (view.getId() == this.i0.getId()) {
            I2("reminder_quote_time", this.i0, 0);
        }
        if (view.getId() == this.c0.getId()) {
            SwitchCompat switchCompat3 = this.Y0;
            switchCompat3.setChecked(!switchCompat3.isChecked());
        }
        if (view.getId() == this.e0.getId()) {
            F2("reminder_ptsd_symptoms_time", "reminder_ptsd_symptoms_frequency", "ptsd_symptoms_lastday", this.e0, R.string.what_day_of_the_month, 5);
        }
        if (view.getId() == this.f0.getId()) {
            I2("reminder_ptsd_symptoms_time", this.f0, 5);
        }
        if (view.getId() == this.d0.getId()) {
            H2("reminder_ptsd_symptoms_frequency", "ptsd_symptoms_lastday", 5);
        }
        if (view.getId() == this.z0.getId()) {
            SwitchCompat switchCompat4 = this.u0;
            switchCompat4.setChecked(!switchCompat4.isChecked());
        }
        if (view.getId() == this.B0.getId()) {
            F2("reminder_well_being_time", "reminder_well_being_frequency", "well_being_lastday", this.B0, R.string.what_day_of_the_month, 2);
        }
        if (view.getId() == this.C0.getId()) {
            I2("reminder_well_being_time", this.C0, 2);
        }
        if (view.getId() == this.A0.getId()) {
            H2("reminder_well_being_frequency", "well_being_lastday", 2);
        }
        if (view.getId() == this.J0.getId()) {
            SwitchCompat switchCompat5 = this.E0;
            switchCompat5.setChecked(!switchCompat5.isChecked());
        }
        if (view.getId() == this.L0.getId()) {
            F2("reminder_anxiety_time", "reminder_anxiety_frequency", "anxiety_lastday", this.L0, R.string.what_day_of_the_month, 3);
        }
        if (view.getId() == this.M0.getId()) {
            I2("reminder_anxiety_time", this.M0, 3);
        }
        if (view.getId() == this.K0.getId()) {
            H2("reminder_anxiety_frequency", "anxiety_lastday", 3);
        }
        if (view.getId() == this.T0.getId()) {
            SwitchCompat switchCompat6 = this.O0;
            switchCompat6.setChecked(!switchCompat6.isChecked());
        }
        if (view.getId() == this.V0.getId()) {
            F2("reminder_track_mood_time", "reminder_track_mood_frequency", "track_mood_lastday", this.V0, R.string.what_day_of_the_month, 4);
        }
        if (view.getId() == this.W0.getId()) {
            I2("reminder_track_mood_time", this.W0, 4);
        }
        if (view.getId() == this.U0.getId()) {
            H2("reminder_track_mood_frequency", "track_mood_lastday", 4);
        }
        if (view.getId() == this.j1.getId()) {
            SwitchCompat switchCompat7 = this.e1;
            switchCompat7.setChecked(!switchCompat7.isChecked());
        }
        if (view.getId() == this.l1.getId()) {
            F2("reminder_try_tool_time", "reminder_try_tool_frequency", "try_tool_lastday", this.l1, R.string.what_day_of_the_month, 6);
        }
        if (view.getId() == this.m1.getId()) {
            I2("reminder_try_tool_time", this.m1, 6);
        }
        if (view.getId() == this.k1.getId()) {
            H2("reminder_try_tool_frequency", "try_tool_lastday", 6);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_reminders, viewGroup, false);
        this.c0 = (LinearLayout) inflate.findViewById(R.id.ptsd_symptoms_layout_reminder);
        this.X0 = (LinearLayout) inflate.findViewById(R.id.ptsd_symptoms_reminder_control_layout);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.ptsd_symptoms_reminder_frequency_layout);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.ptsd_symptoms_reminder_day_layout);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.ptsd_symptoms_reminder_time_layout);
        this.Y0 = (SwitchCompat) inflate.findViewById(R.id.ptsd_symptoms_switch_reminder);
        this.Z0 = (TextView) inflate.findViewById(R.id.ptsd_symptoms_reminder_frequency_txt);
        this.a1 = (TextView) inflate.findViewById(R.id.ptsd_symptoms_reminder_day_txt);
        this.b1 = (TextView) inflate.findViewById(R.id.ptsd_symptoms_reminder_time_txt);
        this.c1 = (TextView) inflate.findViewById(R.id.ptsd_symptoms_reminder_day_txt_txt);
        this.z0 = (LinearLayout) inflate.findViewById(R.id.well_being_layout_reminder);
        this.t0 = (LinearLayout) inflate.findViewById(R.id.well_being_reminder_control_layout);
        this.A0 = (LinearLayout) inflate.findViewById(R.id.well_being_reminder_frequency_layout);
        this.B0 = (LinearLayout) inflate.findViewById(R.id.well_being_reminder_day_layout);
        this.C0 = (LinearLayout) inflate.findViewById(R.id.well_being_reminder_time_layout);
        this.u0 = (SwitchCompat) inflate.findViewById(R.id.well_being_switch_reminder);
        this.v0 = (TextView) inflate.findViewById(R.id.well_being_reminder_frequency_txt);
        this.w0 = (TextView) inflate.findViewById(R.id.well_being_reminder_day_txt);
        this.x0 = (TextView) inflate.findViewById(R.id.well_being_reminder_time_txt);
        this.y0 = (TextView) inflate.findViewById(R.id.well_being_reminder_day_txt_txt);
        this.J0 = (LinearLayout) inflate.findViewById(R.id.anxiety_layout_reminder);
        this.D0 = (LinearLayout) inflate.findViewById(R.id.anxiety_reminder_control_layout);
        this.K0 = (LinearLayout) inflate.findViewById(R.id.anxiety_reminder_frequency_layout);
        this.L0 = (LinearLayout) inflate.findViewById(R.id.anxiety_reminder_day_layout);
        this.M0 = (LinearLayout) inflate.findViewById(R.id.anxiety_reminder_time_layout);
        this.E0 = (SwitchCompat) inflate.findViewById(R.id.anxiety_switch_reminder);
        this.F0 = (TextView) inflate.findViewById(R.id.anxiety_reminder_frequency_txt);
        this.G0 = (TextView) inflate.findViewById(R.id.anxiety_reminder_day_txt);
        this.H0 = (TextView) inflate.findViewById(R.id.anxiety_reminder_time_txt);
        this.I0 = (TextView) inflate.findViewById(R.id.anxiety_reminder_day_txt_txt);
        this.T0 = (LinearLayout) inflate.findViewById(R.id.mood_layout_reminder);
        this.N0 = (LinearLayout) inflate.findViewById(R.id.mood_reminder_control_layout);
        this.U0 = (LinearLayout) inflate.findViewById(R.id.mood_reminder_frequency_layout);
        this.V0 = (LinearLayout) inflate.findViewById(R.id.mood_reminder_day_layout);
        this.W0 = (LinearLayout) inflate.findViewById(R.id.mood_reminder_time_layout);
        this.O0 = (SwitchCompat) inflate.findViewById(R.id.mood_switch_reminder);
        this.P0 = (TextView) inflate.findViewById(R.id.mood_reminder_frequency_txt);
        this.Q0 = (TextView) inflate.findViewById(R.id.mood_reminder_day_txt);
        this.R0 = (TextView) inflate.findViewById(R.id.mood_reminder_time_txt);
        this.S0 = (TextView) inflate.findViewById(R.id.mood_reminder_day_txt_txt);
        this.j1 = (LinearLayout) inflate.findViewById(R.id.try_tool_layout_reminder);
        this.d1 = (LinearLayout) inflate.findViewById(R.id.try_tool_reminder_control_layout);
        this.k1 = (LinearLayout) inflate.findViewById(R.id.try_tool_reminder_frequency_layout);
        this.l1 = (LinearLayout) inflate.findViewById(R.id.try_tool_reminder_day_layout);
        this.m1 = (LinearLayout) inflate.findViewById(R.id.try_tool_reminder_time_layout);
        this.e1 = (SwitchCompat) inflate.findViewById(R.id.try_tool_switch_reminder);
        this.f1 = (TextView) inflate.findViewById(R.id.try_tool_reminder_frequency_txt);
        this.g1 = (TextView) inflate.findViewById(R.id.try_tool_reminder_day_txt);
        this.h1 = (TextView) inflate.findViewById(R.id.try_tool_reminder_time_txt);
        this.i1 = (TextView) inflate.findViewById(R.id.try_tool_reminder_day_txt_txt);
        this.h0 = (LinearLayout) inflate.findViewById(R.id.daily_quote_layout_reminder);
        this.i0 = (LinearLayout) inflate.findViewById(R.id.daily_quote_layout_control);
        this.t1 = (AppCompatTextView) inflate.findViewById(R.id.daily_quote_txt_reminder_time);
        this.u1 = (SwitchCompat) inflate.findViewById(R.id.daily_quote_switch_reminder);
        this.j0 = (LinearLayout) inflate.findViewById(R.id.goal_layout_reminder);
        this.q0 = (LinearLayout) inflate.findViewById(R.id.goal_reminder_frequency_layout);
        this.r0 = (LinearLayout) inflate.findViewById(R.id.goal_reminder_day_layout);
        this.s0 = (LinearLayout) inflate.findViewById(R.id.goal_reminder_time_layout);
        this.k0 = (LinearLayout) inflate.findViewById(R.id.goal_reminder_control_layout);
        this.l0 = (SwitchCompat) inflate.findViewById(R.id.goal_switch_reminder);
        this.m0 = (TextView) inflate.findViewById(R.id.goal_reminder_frequency_txt);
        this.n0 = (TextView) inflate.findViewById(R.id.goal_reminder_day_txt);
        this.o0 = (TextView) inflate.findViewById(R.id.goal_reminder_time_txt);
        this.p0 = (TextView) inflate.findViewById(R.id.goal_reminder_day_txt_txt);
        this.n1 = (LinearLayout) inflate.findViewById(R.id.ptsd_symptoms_reminder_layout);
        this.p1 = (LinearLayout) inflate.findViewById(R.id.well_being_reminder_layout);
        this.q1 = (LinearLayout) inflate.findViewById(R.id.anxiety_reminder_layout);
        this.r1 = (LinearLayout) inflate.findViewById(R.id.mood_reminder_layout);
        this.o1 = (LinearLayout) inflate.findViewById(R.id.goal_reminder_layout);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.daily_quote_reminder_layout);
        this.s1 = (LinearLayout) inflate.findViewById(R.id.try_tool_reminder_layout);
        this.c0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.d0.setOnClickListener(this);
        this.z0.setOnClickListener(this);
        this.B0.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.A0.setOnClickListener(this);
        this.J0.setOnClickListener(this);
        this.L0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
        this.K0.setOnClickListener(this);
        this.T0.setOnClickListener(this);
        this.V0.setOnClickListener(this);
        this.W0.setOnClickListener(this);
        this.U0.setOnClickListener(this);
        this.j1.setOnClickListener(this);
        this.l1.setOnClickListener(this);
        this.m1.setOnClickListener(this);
        this.k1.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        this.s0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        int i2 = this.x1;
        if (i2 == 1) {
            this.g0.setVisibility(8);
            this.p1.setVisibility(8);
            this.q1.setVisibility(8);
            this.r1.setVisibility(8);
            this.n1.setVisibility(8);
            this.s1.setVisibility(8);
        } else if (i2 == 2) {
            this.g0.setVisibility(8);
            this.o1.setVisibility(8);
            this.q1.setVisibility(8);
            this.r1.setVisibility(8);
            this.n1.setVisibility(8);
            this.s1.setVisibility(8);
        } else if (i2 == 3) {
            this.g0.setVisibility(8);
            this.o1.setVisibility(8);
            this.p1.setVisibility(8);
            this.r1.setVisibility(8);
            this.n1.setVisibility(8);
            this.s1.setVisibility(8);
        } else if (i2 == 4) {
            this.g0.setVisibility(8);
            this.o1.setVisibility(8);
            this.p1.setVisibility(8);
            this.q1.setVisibility(8);
            this.n1.setVisibility(8);
            this.s1.setVisibility(8);
        } else if (i2 == 5) {
            this.g0.setVisibility(8);
            this.o1.setVisibility(8);
            this.p1.setVisibility(8);
            this.q1.setVisibility(8);
            this.r1.setVisibility(8);
            this.s1.setVisibility(8);
        }
        N2(true);
        K2(true);
        P2(true);
        J2(true);
        L2(true);
        O2(true);
        M2(true);
        this.Y0.setOnClickListener(null);
        this.Y0.setOnTouchListener(null);
        this.Y0.setOnCheckedChangeListener(new a());
        this.u0.setOnClickListener(null);
        this.u0.setOnTouchListener(null);
        this.u0.setOnCheckedChangeListener(new c(this));
        this.E0.setOnClickListener(null);
        this.E0.setOnTouchListener(null);
        this.E0.setOnCheckedChangeListener(new b(this));
        this.O0.setOnClickListener(null);
        this.O0.setOnTouchListener(null);
        this.O0.setOnCheckedChangeListener(new b());
        this.e1.setOnClickListener(null);
        this.e1.setOnTouchListener(null);
        this.e1.setOnCheckedChangeListener(new c());
        this.u1.setOnCheckedChangeListener(new d());
        this.l0.setOnClickListener(null);
        this.l0.setOnTouchListener(null);
        this.l0.setOnCheckedChangeListener(new e());
        return inflate;
    }
}
