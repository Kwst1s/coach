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
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_choose_tool;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.m.b.f;
import org.json.JSONArray;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.TextViewTracking;

/* compiled from: Act_sp_step2_coping_strategies.kt */
public final class Act_sp_step2_coping_strategies extends vainstrum.Components.a {
    private final int w = 43;
    public ArrayList<f.a.a.a.b.e.a> x;
    public z y;
    private HashMap z;

    /* compiled from: Act_sp_step2_coping_strategies.kt */
    static final class a implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step2_coping_strategies f9976a;

        a(Act_sp_step2_coping_strategies act_sp_step2_coping_strategies) {
            this.f9976a = act_sp_step2_coping_strategies;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                f.c(textView);
                if (textView.getText().toString().length() > 0) {
                    o.A();
                    this.f9976a.Y().l(textView.getText().toString(), 1);
                    textView.setText(BuildConfig.FLAVOR);
                    this.f9976a.c0();
                }
            }
            return false;
        }
    }

    /* compiled from: Act_sp_step2_coping_strategies.kt */
    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step2_coping_strategies f9977a;

        b(Act_sp_step2_coping_strategies act_sp_step2_coping_strategies) {
            this.f9977a = act_sp_step2_coping_strategies;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                Act_sp_step2_coping_strategies act_sp_step2_coping_strategies = this.f9977a;
                int i2 = f.a.a.a.b.o.sp_step2_my_cs_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) act_sp_step2_coping_strategies.W(i2);
                f.d(textViewTracking, "sp_step2_my_cs_txt_save");
                textViewTracking.setContentDescription(this.f9977a.getString(R.string.save) + " " + this.f9977a.getString(R.string.button) + " " + this.f9977a.getString(R.string.disabled));
                ((TextViewTracking) this.f9977a.W(i2)).setTextColor(b.h.d.a.b(this.f9977a.getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking2 = (TextViewTracking) this.f9977a.W(i2);
                f.d(textViewTracking2, "sp_step2_my_cs_txt_save");
                textViewTracking2.setClickable(false);
                return;
            }
            this.f9977a.X();
        }
    }

    /* compiled from: Act_sp_step2_coping_strategies.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step2_coping_strategies f9978b;

        c(Act_sp_step2_coping_strategies act_sp_step2_coping_strategies) {
            this.f9978b = act_sp_step2_coping_strategies;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9978b, Act_choose_tool.class);
            Act_sp_step2_coping_strategies act_sp_step2_coping_strategies = this.f9978b;
            act_sp_step2_coping_strategies.startActivityForResult(intent, act_sp_step2_coping_strategies.a0());
        }
    }

    /* compiled from: Act_sp_step2_coping_strategies.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step2_coping_strategies f9979b;

        d(Act_sp_step2_coping_strategies act_sp_step2_coping_strategies) {
            this.f9979b = act_sp_step2_coping_strategies;
        }

        public final void onClick(View view) {
            this.f9979b.finish();
        }
    }

    /* compiled from: Act_sp_step2_coping_strategies.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step2_coping_strategies f9980b;

        /* compiled from: Act_sp_step2_coping_strategies.kt */
        static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ e f9981b;

            a(e eVar) {
                this.f9981b = eVar;
            }

            public final void run() {
                Intent intent = new Intent(this.f9981b.f9980b, Act_sp_congrats.class);
                intent.putExtra("step", 2);
                this.f9981b.f9980b.startActivity(intent);
            }
        }

        e(Act_sp_step2_coping_strategies act_sp_step2_coping_strategies) {
            this.f9980b = act_sp_step2_coping_strategies;
        }

        public final void onClick(View view) {
            JSONArray jSONArray = new JSONArray();
            Iterator<f.a.a.a.b.e.a> it = this.f9980b.Z().iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.a next = it.next();
                f.d(next, "cs");
                if (next.e()) {
                    jSONArray.put(next.a());
                }
            }
            o.B(this.f9980b.Z());
            if (!o.p(this.f9980b, 2)) {
                new Handler().postDelayed(new a(this), 150);
            }
            o.H(this.f9980b, 2);
            o.u(this.f9980b.getApplicationContext(), jSONArray);
            this.f9980b.finish();
        }
    }

    public View W(int i2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.z.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        boolean z2;
        boolean z3;
        ArrayList<f.a.a.a.b.e.a> arrayList = this.x;
        if (arrayList != null) {
            Iterator<f.a.a.a.b.e.a> it = arrayList.iterator();
            while (true) {
                z2 = true;
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                f.a.a.a.b.e.a next = it.next();
                f.d(next, "c");
                if (next.e()) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                int i2 = f.a.a.a.b.o.sp_step2_my_cs_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) W(i2);
                f.d(textViewTracking, "sp_step2_my_cs_txt_save");
                textViewTracking.setContentDescription(getString(R.string.save) + " " + getString(R.string.button));
                ((TextViewTracking) W(i2)).setTextColor(-1);
                TextViewTracking textViewTracking2 = (TextViewTracking) W(i2);
                f.d(textViewTracking2, "sp_step2_my_cs_txt_save");
                textViewTracking2.setClickable(true);
            } else {
                int i3 = f.a.a.a.b.o.sp_step2_my_cs_txt_save;
                TextViewTracking textViewTracking3 = (TextViewTracking) W(i3);
                f.d(textViewTracking3, "sp_step2_my_cs_txt_save");
                textViewTracking3.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i3)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking4 = (TextViewTracking) W(i3);
                f.d(textViewTracking4, "sp_step2_my_cs_txt_save");
                textViewTracking4.setClickable(false);
            }
            int i4 = f.a.a.a.b.o.sp_step2_my_cs_edt_add_own;
            ((AppCompatEditText) W(i4)).clearFocus();
            AppCompatEditText appCompatEditText = (AppCompatEditText) W(i4);
            f.d(appCompatEditText, "sp_step2_my_cs_edt_add_own");
            if (String.valueOf(appCompatEditText.getText()).length() <= 0) {
                z2 = false;
            }
            if (z2) {
                int i5 = f.a.a.a.b.o.sp_step2_my_cs_txt_save;
                TextViewTracking textViewTracking5 = (TextViewTracking) W(i5);
                f.d(textViewTracking5, "sp_step2_my_cs_txt_save");
                textViewTracking5.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i5)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking6 = (TextViewTracking) W(i5);
                f.d(textViewTracking6, "sp_step2_my_cs_txt_save");
                textViewTracking6.setClickable(false);
                return;
            }
            return;
        }
        f.p("list_cs");
        throw null;
    }

    public final z Y() {
        z zVar = this.y;
        if (zVar != null) {
            return zVar;
        }
        f.p("helper");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.a> Z() {
        ArrayList<f.a.a.a.b.e.a> arrayList = this.x;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_cs");
        throw null;
    }

    public final int a0() {
        return this.w;
    }

    public final void b0() {
        z zVar = new z(this);
        JSONArray jSONArray = new JSONArray(j.N(this, h.m));
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            zVar.l(jSONArray.getString(i2), 0);
        }
    }

    public final void c0() {
        z zVar = this.y;
        if (zVar != null) {
            f.a.a.a.b.e.a X = zVar.X();
            f.d(X, "lastCS");
            X.i(true);
            ArrayList<f.a.a.a.b.e.a> arrayList = this.x;
            if (arrayList != null) {
                arrayList.add(0, X);
                d0();
                X();
                return;
            }
            f.p("list_cs");
            throw null;
        }
        f.p("helper");
        throw null;
    }

    public final void d0() {
        ArrayList<f.a.a.a.b.e.a> arrayList = this.x;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                b0();
                z zVar = this.y;
                if (zVar != null) {
                    ArrayList<f.a.a.a.b.e.a> P = zVar.P();
                    f.d(P, "helper.allCS");
                    this.x = P;
                } else {
                    f.p("helper");
                    throw null;
                }
            }
            RecyclerView recyclerView = (RecyclerView) W(f.a.a.a.b.o.sp_step2_my_cs_rview);
            f.d(recyclerView, "sp_step2_my_cs_rview");
            ArrayList<f.a.a.a.b.e.a> arrayList2 = this.x;
            if (arrayList2 != null) {
                recyclerView.setAdapter(new f.a.a.a.b.c.b(this, arrayList2));
            } else {
                f.p("list_cs");
                throw null;
            }
        } else {
            f.p("list_cs");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.w && i3 == -1) {
            f.c(intent);
            Serializable serializableExtra = intent.getSerializableExtra("tool");
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Data.Tool");
            b0 b0Var = (b0) serializableExtra;
            z zVar = this.y;
            if (zVar != null) {
                zVar.E(b0Var.g(), b0Var.d(), 0);
                c0();
                return;
            }
            f.p("helper");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_sp_step2_coping_strategies);
        int i2 = f.a.a.a.b.o.sp_step2_my_cs_edt_add_own;
        ((AppCompatEditText) W(i2)).setOnEditorActionListener(new a(this));
        ((AppCompatEditText) W(i2)).setOnFocusChangeListener(new b(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        int i3 = f.a.a.a.b.o.sp_step2_my_cs_rview;
        ((RecyclerView) W(i3)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i3);
        f.d(recyclerView, "sp_step2_my_cs_rview");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((ButtonTracking) W(f.a.a.a.b.o.sp_step2_my_cs_btn_add_a_tool)).setOnClickListener(new c(this));
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step2_my_cs_txt_cancel)).setOnClickListener(new d(this));
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step2_my_cs_txt_save)).setOnClickListener(new e(this));
        z zVar = new z(this);
        this.y = zVar;
        ArrayList<f.a.a.a.b.e.a> P = zVar.P();
        f.d(P, "helper.allCS");
        this.x = P;
        JSONArray g2 = o.g(getApplicationContext());
        ArrayList<f.a.a.a.b.e.a> arrayList = this.x;
        if (arrayList != null) {
            Iterator<f.a.a.a.b.e.a> it = arrayList.iterator();
            while (true) {
                int i4 = 0;
                if (!it.hasNext()) {
                    break;
                }
                f.a.a.a.b.e.a next = it.next();
                int length = g2.length();
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    f.d(next, "cs");
                    int a2 = next.a();
                    Object obj = g2.get(i4);
                    if ((obj instanceof Integer) && a2 == ((Integer) obj).intValue()) {
                        next.i(true);
                        break;
                    }
                    i4++;
                }
            }
            d0();
            X();
            T((Toolbar) W(f.a.a.a.b.o.sp_step2_my_cs_toolbar));
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
        f.p("list_cs");
        throw null;
    }
}
