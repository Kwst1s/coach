package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.k;
import java.util.HashMap;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: Act_export_mood_check.kt */
public final class Act_export_mood_check extends gov.va.mobilehealth.ncptsd.covid.CComp.f {
    private final int u = 79;
    private HashMap v;

    /* compiled from: Act_export_mood_check.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9837b;

        a(Act_export_mood_check act_export_mood_check) {
            this.f9837b = act_export_mood_check;
        }

        public final void onClick(View view) {
            Act_export_mood_check act_export_mood_check = this.f9837b;
            int i2 = o.export_switch_set_goal;
            SwitchCompat switchCompat = (SwitchCompat) act_export_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "export_switch_set_goal");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9837b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "export_switch_set_goal");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9837b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "export_switch_set_goal");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9837b.getString(R.string.set_a_goal) + " unchecked");
                return;
            }
            k.b.d.k(this.f9837b.getString(R.string.set_a_goal) + " checked");
        }
    }

    /* compiled from: Act_export_mood_check.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9838b;

        b(Act_export_mood_check act_export_mood_check) {
            this.f9838b = act_export_mood_check;
        }

        public final void onClick(View view) {
            Act_export_mood_check act_export_mood_check = this.f9838b;
            int i2 = o.export_switch_track_well_being;
            SwitchCompat switchCompat = (SwitchCompat) act_export_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "export_switch_track_well_being");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9838b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "export_switch_track_well_being");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9838b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "export_switch_track_well_being");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9838b.getString(R.string.well_being) + " unchecked");
                return;
            }
            k.b.d.k(this.f9838b.getString(R.string.well_being) + " checked");
        }
    }

    /* compiled from: Act_export_mood_check.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9839b;

        c(Act_export_mood_check act_export_mood_check) {
            this.f9839b = act_export_mood_check;
        }

        public final void onClick(View view) {
            Act_export_mood_check act_export_mood_check = this.f9839b;
            int i2 = o.export_switch_track_anxiety;
            SwitchCompat switchCompat = (SwitchCompat) act_export_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "export_switch_track_anxiety");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9839b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "export_switch_track_anxiety");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9839b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "export_switch_track_anxiety");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9839b.getString(R.string.track_mood) + " unchecked");
                return;
            }
            k.b.d.k(this.f9839b.getString(R.string.track_mood) + " checked");
        }
    }

    /* compiled from: Act_export_mood_check.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9840b;

        d(Act_export_mood_check act_export_mood_check) {
            this.f9840b = act_export_mood_check;
        }

        public final void onClick(View view) {
            Act_export_mood_check act_export_mood_check = this.f9840b;
            int i2 = o.export_switch_track_mood;
            SwitchCompat switchCompat = (SwitchCompat) act_export_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "export_switch_track_mood");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9840b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "export_switch_track_mood");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9840b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "export_switch_track_mood");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9840b.getString(R.string.track_mood) + " unchecked");
                return;
            }
            k.b.d.k(this.f9840b.getString(R.string.track_mood) + " checked");
        }
    }

    /* compiled from: Act_export_mood_check.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9841b;

        e(Act_export_mood_check act_export_mood_check) {
            this.f9841b = act_export_mood_check;
        }

        public final void onClick(View view) {
            Act_export_mood_check act_export_mood_check = this.f9841b;
            int i2 = o.export_switch_ptsd_symptoms;
            SwitchCompat switchCompat = (SwitchCompat) act_export_mood_check.W(i2);
            kotlin.m.b.f.d(switchCompat, "export_switch_ptsd_symptoms");
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9841b.W(i2);
            kotlin.m.b.f.d(switchCompat2, "export_switch_ptsd_symptoms");
            switchCompat.setChecked(!switchCompat2.isChecked());
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9841b.W(i2);
            kotlin.m.b.f.d(switchCompat3, "export_switch_ptsd_symptoms");
            if (switchCompat3.isChecked()) {
                k.b.d.k(this.f9841b.getString(R.string.track_ptsd_symptoms) + " unchecked");
                return;
            }
            k.b.d.k(this.f9841b.getString(R.string.track_ptsd_symptoms) + " checked");
        }
    }

    /* compiled from: Act_export_mood_check.kt */
    static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9842b;

        f(Act_export_mood_check act_export_mood_check) {
            this.f9842b = act_export_mood_check;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f9842b, "android.permission.READ_EXTERNAL_STORAGE") == 0 && b.h.d.a.a(this.f9842b, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                this.f9842b.Y();
                return;
            }
            Act_export_mood_check act_export_mood_check = this.f9842b;
            androidx.core.app.a.l(act_export_mood_check, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, act_export_mood_check.u);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_export_mood_check.kt */
    public static final class g implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_export_mood_check f9843b;

        g(Act_export_mood_check act_export_mood_check) {
            this.f9843b = act_export_mood_check;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            SwitchCompat switchCompat = (SwitchCompat) this.f9843b.W(o.export_switch_set_goal);
            kotlin.m.b.f.d(switchCompat, "export_switch_set_goal");
            boolean isChecked = switchCompat.isChecked();
            SwitchCompat switchCompat2 = (SwitchCompat) this.f9843b.W(o.export_switch_track_well_being);
            kotlin.m.b.f.d(switchCompat2, "export_switch_track_well_being");
            boolean isChecked2 = switchCompat2.isChecked();
            SwitchCompat switchCompat3 = (SwitchCompat) this.f9843b.W(o.export_switch_track_anxiety);
            kotlin.m.b.f.d(switchCompat3, "export_switch_track_anxiety");
            boolean isChecked3 = switchCompat3.isChecked();
            SwitchCompat switchCompat4 = (SwitchCompat) this.f9843b.W(o.export_switch_track_mood);
            kotlin.m.b.f.d(switchCompat4, "export_switch_track_mood");
            boolean isChecked4 = switchCompat4.isChecked();
            SwitchCompat switchCompat5 = (SwitchCompat) this.f9843b.W(o.export_switch_ptsd_symptoms);
            kotlin.m.b.f.d(switchCompat5, "export_switch_ptsd_symptoms");
            boolean isChecked5 = switchCompat5.isChecked();
            if (isChecked || isChecked2 || isChecked3 || isChecked4 || isChecked5) {
                k.f10124a.f(this.f9843b, isChecked, isChecked2, isChecked3, isChecked4, isChecked5);
                return;
            }
            Act_export_mood_check act_export_mood_check = this.f9843b;
            j.V(act_export_mood_check, act_export_mood_check.getString(R.string.check_an_option));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_export_mood_check.kt */
    public static final class h implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final h f9844b = new h();

        h() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public View W(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void Y() {
        b.a h2 = j.h(this, getString(R.string.do_you_really_want_export_assessment_data));
        h2.k(R.string.yes, new g(this));
        h2.h(R.string.no, h.f9844b);
        h2.a().show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_export_mood_check);
        ((LinearLayoutTracking) W(o.export_layout_set_goal)).setOnClickListener(new a(this));
        ((LinearLayoutTracking) W(o.export_layout_track_well_being)).setOnClickListener(new b(this));
        ((LinearLayoutTracking) W(o.export_layout_track_anxiety)).setOnClickListener(new c(this));
        ((LinearLayoutTracking) W(o.export_layout_track_mood)).setOnClickListener(new d(this));
        ((LinearLayoutTracking) W(o.export_layout_ptsd_symptoms)).setOnClickListener(new e(this));
        ((ButtonTracking) W(o.export_btn_share)).setOnClickListener(new f(this));
        T((Toolbar) W(o.export_toolbar));
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

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.m.b.f.e(strArr, "permissions");
        kotlin.m.b.f.e(iArr, "grantResults");
        if (i2 == this.u) {
            if ((!(iArr.length == 0)) && iArr[0] == 0 && iArr[1] == 0) {
                Y();
            }
        }
    }
}
