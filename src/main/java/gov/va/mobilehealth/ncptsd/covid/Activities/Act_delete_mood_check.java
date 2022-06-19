package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import b.a.j;
import com.github.mikephil.charting.R;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import gov.va.mobilehealth.ncptsd.covid.CComp.v;
import java.util.HashMap;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: Act_delete_mood_check.kt */
public final class Act_delete_mood_check extends androidx.appcompat.app.c {
    private HashMap t;

    /* compiled from: Act_delete_mood_check.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9829b;

        a(Act_delete_mood_check act_delete_mood_check) {
            this.f9829b = act_delete_mood_check;
        }

        public final void onClick(View view) {
            Act_delete_mood_check act_delete_mood_check = this.f9829b;
            int i2 = o.delete_switch_set_goal;
            SwitchCompat switchCompat = (SwitchCompat) act_delete_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "delete_switch_set_goal");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9829b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "delete_switch_set_goal");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9829b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "delete_switch_set_goal");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9829b.getString(R.string.set_a_goal) + " unchecked");
                return;
            }
            k.b.d.k(this.f9829b.getString(R.string.set_a_goal) + " checked");
        }
    }

    /* compiled from: Act_delete_mood_check.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9830b;

        b(Act_delete_mood_check act_delete_mood_check) {
            this.f9830b = act_delete_mood_check;
        }

        public final void onClick(View view) {
            Act_delete_mood_check act_delete_mood_check = this.f9830b;
            int i2 = o.delete_switch_track_well_being;
            SwitchCompat switchCompat = (SwitchCompat) act_delete_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "delete_switch_track_well_being");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9830b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "delete_switch_track_well_being");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9830b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "delete_switch_track_well_being");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9830b.getString(R.string.well_being) + " unchecked");
                return;
            }
            k.b.d.k(this.f9830b.getString(R.string.well_being) + " checked");
        }
    }

    /* compiled from: Act_delete_mood_check.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9831b;

        c(Act_delete_mood_check act_delete_mood_check) {
            this.f9831b = act_delete_mood_check;
        }

        public final void onClick(View view) {
            Act_delete_mood_check act_delete_mood_check = this.f9831b;
            int i2 = o.delete_switch_track_anxiety;
            SwitchCompat switchCompat = (SwitchCompat) act_delete_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "delete_switch_track_anxiety");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9831b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "delete_switch_track_anxiety");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9831b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "delete_switch_track_anxiety");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9831b.getString(R.string.track_mood) + " unchecked");
                return;
            }
            k.b.d.k(this.f9831b.getString(R.string.track_mood) + " checked");
        }
    }

    /* compiled from: Act_delete_mood_check.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9832b;

        d(Act_delete_mood_check act_delete_mood_check) {
            this.f9832b = act_delete_mood_check;
        }

        public final void onClick(View view) {
            Act_delete_mood_check act_delete_mood_check = this.f9832b;
            int i2 = o.delete_switch_track_mood;
            SwitchCompat switchCompat = (SwitchCompat) act_delete_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "delete_switch_track_mood");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9832b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "delete_switch_track_mood");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9832b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "delete_switch_track_mood");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9832b.getString(R.string.track_mood) + " unchecked");
                return;
            }
            k.b.d.k(this.f9832b.getString(R.string.track_mood) + " checked");
        }
    }

    /* compiled from: Act_delete_mood_check.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9833b;

        e(Act_delete_mood_check act_delete_mood_check) {
            this.f9833b = act_delete_mood_check;
        }

        public final void onClick(View view) {
            Act_delete_mood_check act_delete_mood_check = this.f9833b;
            int i2 = o.delete_switch_ptsd_symptoms;
            SwitchCompat switchCompat = (SwitchCompat) act_delete_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "delete_switch_ptsd_symptoms");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9833b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "delete_switch_ptsd_symptoms");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9833b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "delete_switch_ptsd_symptoms");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9833b.getString(R.string.track_ptsd_symptoms) + " unchecked");
                return;
            }
            k.b.d.k(this.f9833b.getString(R.string.track_ptsd_symptoms) + " checked");
        }
    }

    /* compiled from: Act_delete_mood_check.kt */
    static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9834b;

        f(Act_delete_mood_check act_delete_mood_check) {
            this.f9834b = act_delete_mood_check;
        }

        public final void onClick(View view) {
            this.f9834b.X();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_delete_mood_check.kt */
    public static final class g implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_delete_mood_check f9835b;

        g(Act_delete_mood_check act_delete_mood_check) {
            this.f9835b = act_delete_mood_check;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            SwitchCompat switchCompat = (SwitchCompat) this.f9835b.W(o.delete_switch_set_goal);
            kotlin.m.b.f.d(switchCompat, "delete_switch_set_goal");
            boolean isChecked = switchCompat.isChecked();
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9835b.W(o.delete_switch_track_well_being);
            kotlin.m.b.f.d(switchCompat2, "delete_switch_track_well_being");
            boolean isChecked2 = switchCompat2.isChecked();
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9835b.W(o.delete_switch_track_anxiety);
            kotlin.m.b.f.d(switchCompat3, "delete_switch_track_anxiety");
            boolean isChecked3 = switchCompat3.isChecked();
            SwitchCompat switchCompat4 = (SwitchCompat) this.f9835b.W(o.delete_switch_track_mood);
            kotlin.m.b.f.d(switchCompat4, "delete_switch_track_mood");
            boolean isChecked4 = switchCompat4.isChecked();
            SwitchCompat switchCompat5 = (SwitchCompat) this.f9835b.W(o.delete_switch_ptsd_symptoms);
            kotlin.m.b.f.d(switchCompat5, "delete_switch_ptsd_symptoms");
            boolean isChecked5 = switchCompat5.isChecked();
            if (isChecked || isChecked2 || isChecked3 || isChecked4 || isChecked5) {
                if (isChecked) {
                    Context applicationContext = this.f9835b.getApplicationContext();
                    kotlin.m.b.f.d(applicationContext, "applicationContext");
                    v vVar = new v(applicationContext);
                    Context applicationContext2 = this.f9835b.getApplicationContext();
                    kotlin.m.b.f.d(applicationContext2, "applicationContext");
                    vVar.E(applicationContext2);
                }
                if (isChecked2) {
                    new u(this.f9835b.getApplicationContext()).P(224);
                }
                if (isChecked3) {
                    new u(this.f9835b.getApplicationContext()).P(411);
                }
                if (isChecked4) {
                    new u(this.f9835b.getApplicationContext()).P(j.D0);
                }
                if (isChecked5) {
                    new u(this.f9835b.getApplicationContext()).P(j.I0);
                }
                Toast.makeText(this.f9835b, (int) R.string.assessment_data_deleted_successfully, 1).show();
                return;
            }
            Act_delete_mood_check act_delete_mood_check = this.f9835b;
            gov.va.mobilehealth.ncptsd.covid.CComp.j.V(act_delete_mood_check, act_delete_mood_check.getString(R.string.check_an_option));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_delete_mood_check.kt */
    public static final class h implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final h f9836b = new h();

        h() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public View W(int i2) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        View view = (View) this.t.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.t.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(this, getString(R.string.do_you_really_want_remove_assessment_data));
        h2.k(R.string.yes, new g(this));
        h2.h(R.string.no, h.f9836b);
        h2.a().show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_delete_mood_check);
        ((LinearLayoutTracking) W(o.delete_layout_set_goal)).setOnClickListener(new a(this));
        ((LinearLayoutTracking) W(o.delete_layout_track_well_being)).setOnClickListener(new b(this));
        ((LinearLayoutTracking) W(o.delete_layout_track_anxiety)).setOnClickListener(new c(this));
        ((LinearLayoutTracking) W(o.delete_layout_track_mood)).setOnClickListener(new d(this));
        ((LinearLayoutTracking) W(o.delete_layout_ptsd_symptoms)).setOnClickListener(new e(this));
        ((ButtonTracking) W(o.delete_btn_delete)).setOnClickListener(new f(this));
        T((Toolbar) W(o.delete_toolbar));
        androidx.appcompat.app.a M = M();
        if (M != null) {
            M.x(true);
        }
        androidx.appcompat.app.a M2 = M();
        if (M2 != null) {
            M2.s(true);
        }
        androidx.appcompat.app.a M3 = M();
        if (M3 != null) {
            M3.t(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }
}
