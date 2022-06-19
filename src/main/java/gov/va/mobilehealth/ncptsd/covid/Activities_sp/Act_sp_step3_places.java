package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.c.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.b.f;
import org.json.JSONArray;
import vainstrum.Components.TextViewTracking;

/* compiled from: Act_sp_step3_places.kt */
public final class Act_sp_step3_places extends vainstrum.Components.a {
    public ArrayList<f.a.a.a.b.e.c> w;
    public z x;
    private HashMap y;

    /* compiled from: Act_sp_step3_places.kt */
    static final class a implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step3_places f9982a;

        a(Act_sp_step3_places act_sp_step3_places) {
            this.f9982a = act_sp_step3_places;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                f.c(textView);
                if (textView.getText().toString().length() > 0) {
                    o.A();
                    this.f9982a.Y().I(textView.getText().toString(), 1);
                    textView.setText(BuildConfig.FLAVOR);
                    this.f9982a.a0();
                }
            }
            return false;
        }
    }

    /* compiled from: Act_sp_step3_places.kt */
    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step3_places f9983a;

        b(Act_sp_step3_places act_sp_step3_places) {
            this.f9983a = act_sp_step3_places;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                Act_sp_step3_places act_sp_step3_places = this.f9983a;
                int i2 = f.a.a.a.b.o.sp_step3_my_places_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) act_sp_step3_places.W(i2);
                f.d(textViewTracking, "sp_step3_my_places_txt_save");
                textViewTracking.setContentDescription(this.f9983a.getString(R.string.save) + " " + this.f9983a.getString(R.string.button) + " " + this.f9983a.getString(R.string.disabled));
                ((TextViewTracking) this.f9983a.W(i2)).setTextColor(b.h.d.a.b(this.f9983a.getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking2 = (TextViewTracking) this.f9983a.W(i2);
                f.d(textViewTracking2, "sp_step3_my_places_txt_save");
                textViewTracking2.setClickable(false);
                return;
            }
            this.f9983a.X();
        }
    }

    /* compiled from: Act_sp_step3_places.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step3_places f9984b;

        c(Act_sp_step3_places act_sp_step3_places) {
            this.f9984b = act_sp_step3_places;
        }

        public final void onClick(View view) {
            this.f9984b.finish();
        }
    }

    /* compiled from: Act_sp_step3_places.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step3_places f9985b;

        /* compiled from: Act_sp_step3_places.kt */
        static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f9986b;

            a(d dVar) {
                this.f9986b = dVar;
            }

            public final void run() {
                Intent intent = new Intent(this.f9986b.f9985b, Act_sp_congrats.class);
                intent.putExtra("step", 3);
                intent.putExtra("step_variant", 2);
                this.f9986b.f9985b.startActivity(intent);
            }
        }

        d(Act_sp_step3_places act_sp_step3_places) {
            this.f9985b = act_sp_step3_places;
        }

        public final void onClick(View view) {
            JSONArray jSONArray = new JSONArray();
            Iterator<f.a.a.a.b.e.c> it = this.f9985b.Z().iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.c next = it.next();
                f.d(next, "ps");
                if (next.d()) {
                    jSONArray.put(next.a());
                }
            }
            o.F(this.f9985b.Z());
            if (!o.q(this.f9985b, 3, 2)) {
                new Handler().postDelayed(new a(this), 150);
            }
            if (o.q(this.f9985b, 3, 1)) {
                o.H(this.f9985b, 3);
            }
            o.I(this.f9985b, 3, 2);
            o.x(this.f9985b.getApplicationContext(), jSONArray);
            this.f9985b.finish();
        }
    }

    public View W(int i2) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.y.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        boolean z;
        boolean z2;
        ArrayList<f.a.a.a.b.e.c> arrayList = this.w;
        if (arrayList != null) {
            Iterator<f.a.a.a.b.e.c> it = arrayList.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                f.a.a.a.b.e.c next = it.next();
                f.d(next, "ps");
                if (next.d()) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                int i2 = f.a.a.a.b.o.sp_step3_my_places_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) W(i2);
                f.d(textViewTracking, "sp_step3_my_places_txt_save");
                textViewTracking.setContentDescription(getString(R.string.save) + " " + getString(R.string.button));
                ((TextViewTracking) W(i2)).setTextColor(-1);
                TextViewTracking textViewTracking2 = (TextViewTracking) W(i2);
                f.d(textViewTracking2, "sp_step3_my_places_txt_save");
                textViewTracking2.setClickable(true);
            } else {
                int i3 = f.a.a.a.b.o.sp_step3_my_places_txt_save;
                TextViewTracking textViewTracking3 = (TextViewTracking) W(i3);
                f.d(textViewTracking3, "sp_step3_my_places_txt_save");
                textViewTracking3.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i3)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking4 = (TextViewTracking) W(i3);
                f.d(textViewTracking4, "sp_step3_my_places_txt_save");
                textViewTracking4.setClickable(false);
            }
            int i4 = f.a.a.a.b.o.sp_step3_my_places_edt;
            ((AppCompatEditText) W(i4)).clearFocus();
            AppCompatEditText appCompatEditText = (AppCompatEditText) W(i4);
            f.d(appCompatEditText, "sp_step3_my_places_edt");
            if (String.valueOf(appCompatEditText.getText()).length() <= 0) {
                z = false;
            }
            if (z) {
                int i5 = f.a.a.a.b.o.sp_step3_my_places_txt_save;
                TextViewTracking textViewTracking5 = (TextViewTracking) W(i5);
                f.d(textViewTracking5, "sp_step3_my_places_txt_save");
                textViewTracking5.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i5)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking6 = (TextViewTracking) W(i5);
                f.d(textViewTracking6, "sp_step3_my_places_txt_save");
                textViewTracking6.setClickable(false);
                return;
            }
            return;
        }
        f.p("list_ps");
        throw null;
    }

    public final z Y() {
        z zVar = this.x;
        if (zVar != null) {
            return zVar;
        }
        f.p("helper");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.c> Z() {
        ArrayList<f.a.a.a.b.e.c> arrayList = this.w;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ps");
        throw null;
    }

    public final void a0() {
        z zVar = this.x;
        if (zVar != null) {
            f.a.a.a.b.e.c Z = zVar.Z();
            f.d(Z, "lastPS");
            Z.h(true);
            ArrayList<f.a.a.a.b.e.c> arrayList = this.w;
            if (arrayList != null) {
                arrayList.add(0, Z);
                b0();
                X();
                return;
            }
            f.p("list_ps");
            throw null;
        }
        f.p("helper");
        throw null;
    }

    public final void b0() {
        ArrayList<f.a.a.a.b.e.c> arrayList = this.w;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                z zVar = this.x;
                if (zVar != null) {
                    ArrayList<f.a.a.a.b.e.c> T = zVar.T();
                    f.d(T, "helper.allPlaces");
                    this.w = T;
                } else {
                    f.p("helper");
                    throw null;
                }
            }
            RecyclerView recyclerView = (RecyclerView) W(f.a.a.a.b.o.sp_step3_my_places_rview);
            f.d(recyclerView, "sp_step3_my_places_rview");
            ArrayList<f.a.a.a.b.e.c> arrayList2 = this.w;
            if (arrayList2 != null) {
                recyclerView.setAdapter(new e(this, arrayList2));
            } else {
                f.p("list_ps");
                throw null;
            }
        } else {
            f.p("list_ps");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_sp_step3_places);
        int i2 = f.a.a.a.b.o.sp_step3_my_places_edt;
        ((AppCompatEditText) W(i2)).setOnEditorActionListener(new a(this));
        ((AppCompatEditText) W(i2)).setOnFocusChangeListener(new b(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        int i3 = f.a.a.a.b.o.sp_step3_my_places_rview;
        ((RecyclerView) W(i3)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i3);
        f.d(recyclerView, "sp_step3_my_places_rview");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step3_my_places_txt_cancel)).setOnClickListener(new c(this));
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step3_my_places_txt_save)).setOnClickListener(new d(this));
        z zVar = new z(this);
        this.x = zVar;
        ArrayList<f.a.a.a.b.e.c> T = zVar.T();
        f.d(T, "helper.allPlaces");
        this.w = T;
        JSONArray k2 = o.k(getApplicationContext());
        ArrayList<f.a.a.a.b.e.c> arrayList = this.w;
        if (arrayList != null) {
            Iterator<f.a.a.a.b.e.c> it = arrayList.iterator();
            while (true) {
                int i4 = 0;
                if (!it.hasNext()) {
                    break;
                }
                f.a.a.a.b.e.c next = it.next();
                int length = k2.length();
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    f.d(next, "ps");
                    int a2 = next.a();
                    Object obj = k2.get(i4);
                    if ((obj instanceof Integer) && a2 == ((Integer) obj).intValue()) {
                        next.h(true);
                        break;
                    }
                    i4++;
                }
            }
            b0();
            X();
            T((Toolbar) W(f.a.a.a.b.o.sp_step3_my_places_toolbar));
            androidx.appcompat.app.a M = M();
            if (M != null) {
                M.x(false);
            }
            androidx.appcompat.app.a M2 = M();
            if (M2 != null) {
                M2.s(false);
            }
            androidx.appcompat.app.a M3 = M();
            if (M3 != null) {
                M3.t(false);
                return;
            }
            return;
        }
        f.p("list_ps");
        throw null;
    }
}
