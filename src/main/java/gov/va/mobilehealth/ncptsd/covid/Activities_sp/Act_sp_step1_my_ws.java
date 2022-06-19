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
import f.a.a.a.b.e.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.b.f;
import org.json.JSONArray;
import vainstrum.Components.TextViewTracking;

/* compiled from: Act_sp_step1_my_ws.kt */
public final class Act_sp_step1_my_ws extends vainstrum.Components.a {
    public ArrayList<e> w;
    public z x;
    private HashMap y;

    /* compiled from: Act_sp_step1_my_ws.kt */
    static final class a implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step1_my_ws f9971a;

        a(Act_sp_step1_my_ws act_sp_step1_my_ws) {
            this.f9971a = act_sp_step1_my_ws;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                f.c(textView);
                if (textView.getText().toString().length() > 0) {
                    o.A();
                    this.f9971a.Y().J(textView.getText().toString(), 1);
                    textView.setText(BuildConfig.FLAVOR);
                    this.f9971a.b0();
                }
            }
            return false;
        }
    }

    /* compiled from: Act_sp_step1_my_ws.kt */
    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step1_my_ws f9972a;

        b(Act_sp_step1_my_ws act_sp_step1_my_ws) {
            this.f9972a = act_sp_step1_my_ws;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                Act_sp_step1_my_ws act_sp_step1_my_ws = this.f9972a;
                int i2 = f.a.a.a.b.o.sp_step1_my_ws_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) act_sp_step1_my_ws.W(i2);
                f.d(textViewTracking, "sp_step1_my_ws_txt_save");
                textViewTracking.setContentDescription(this.f9972a.getString(R.string.save) + " " + this.f9972a.getString(R.string.button) + " " + this.f9972a.getString(R.string.disabled));
                ((TextViewTracking) this.f9972a.W(i2)).setTextColor(b.h.d.a.b(this.f9972a.getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking2 = (TextViewTracking) this.f9972a.W(i2);
                f.d(textViewTracking2, "sp_step1_my_ws_txt_save");
                textViewTracking2.setClickable(false);
                return;
            }
            this.f9972a.X();
        }
    }

    /* compiled from: Act_sp_step1_my_ws.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step1_my_ws f9973b;

        c(Act_sp_step1_my_ws act_sp_step1_my_ws) {
            this.f9973b = act_sp_step1_my_ws;
        }

        public final void onClick(View view) {
            this.f9973b.finish();
        }
    }

    /* compiled from: Act_sp_step1_my_ws.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step1_my_ws f9974b;

        /* compiled from: Act_sp_step1_my_ws.kt */
        static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f9975b;

            a(d dVar) {
                this.f9975b = dVar;
            }

            public final void run() {
                Intent intent = new Intent(this.f9975b.f9974b, Act_sp_congrats.class);
                intent.putExtra("step", 1);
                this.f9975b.f9974b.startActivity(intent);
            }
        }

        d(Act_sp_step1_my_ws act_sp_step1_my_ws) {
            this.f9974b = act_sp_step1_my_ws;
        }

        public final void onClick(View view) {
            JSONArray jSONArray = new JSONArray();
            Iterator<e> it = this.f9974b.Z().iterator();
            while (it.hasNext()) {
                e next = it.next();
                f.d(next, "ws");
                if (next.d()) {
                    jSONArray.put(next.a());
                }
            }
            o.K(this.f9974b.Z());
            if (!o.p(this.f9974b, 1)) {
                new Handler().postDelayed(new a(this), 150);
            }
            o.H(this.f9974b, 1);
            o.z(this.f9974b.getApplicationContext(), jSONArray);
            this.f9974b.finish();
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
        ArrayList<e> arrayList = this.w;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                e next = it.next();
                f.d(next, "w");
                if (next.d()) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                int i2 = f.a.a.a.b.o.sp_step1_my_ws_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) W(i2);
                f.d(textViewTracking, "sp_step1_my_ws_txt_save");
                textViewTracking.setContentDescription(getString(R.string.save) + " " + getString(R.string.button));
                ((TextViewTracking) W(i2)).setTextColor(-1);
                TextViewTracking textViewTracking2 = (TextViewTracking) W(i2);
                f.d(textViewTracking2, "sp_step1_my_ws_txt_save");
                textViewTracking2.setClickable(true);
            } else {
                int i3 = f.a.a.a.b.o.sp_step1_my_ws_txt_save;
                TextViewTracking textViewTracking3 = (TextViewTracking) W(i3);
                f.d(textViewTracking3, "sp_step1_my_ws_txt_save");
                textViewTracking3.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i3)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking4 = (TextViewTracking) W(i3);
                f.d(textViewTracking4, "sp_step1_my_ws_txt_save");
                textViewTracking4.setClickable(false);
            }
            int i4 = f.a.a.a.b.o.sp_step1_my_ws_edt_add_own;
            ((AppCompatEditText) W(i4)).clearFocus();
            AppCompatEditText appCompatEditText = (AppCompatEditText) W(i4);
            f.d(appCompatEditText, "sp_step1_my_ws_edt_add_own");
            if (String.valueOf(appCompatEditText.getText()).length() <= 0) {
                z = false;
            }
            if (z) {
                int i5 = f.a.a.a.b.o.sp_step1_my_ws_txt_save;
                TextViewTracking textViewTracking5 = (TextViewTracking) W(i5);
                f.d(textViewTracking5, "sp_step1_my_ws_txt_save");
                textViewTracking5.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i5)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking6 = (TextViewTracking) W(i5);
                f.d(textViewTracking6, "sp_step1_my_ws_txt_save");
                textViewTracking6.setClickable(false);
                return;
            }
            return;
        }
        f.p("list_ws");
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

    public final ArrayList<e> Z() {
        ArrayList<e> arrayList = this.w;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ws");
        throw null;
    }

    public final void a0() {
        z zVar = new z(this);
        JSONArray jSONArray = new JSONArray(j.N(this, h.l));
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            zVar.J(jSONArray.getString(i2), 0);
        }
    }

    public final void b0() {
        z zVar = this.x;
        if (zVar != null) {
            e a0 = zVar.a0();
            f.d(a0, "lastWS");
            a0.h(true);
            ArrayList<e> arrayList = this.w;
            if (arrayList != null) {
                arrayList.add(0, a0);
                c0();
                X();
                return;
            }
            f.p("list_ws");
            throw null;
        }
        f.p("helper");
        throw null;
    }

    public final void c0() {
        ArrayList<e> arrayList = this.w;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                a0();
                z zVar = this.x;
                if (zVar != null) {
                    ArrayList<e> V = zVar.V();
                    f.d(V, "helper.allWS");
                    this.w = V;
                } else {
                    f.p("helper");
                    throw null;
                }
            }
            RecyclerView recyclerView = (RecyclerView) W(f.a.a.a.b.o.sp_step1_my_ws_rview);
            f.d(recyclerView, "sp_step1_my_ws_rview");
            ArrayList<e> arrayList2 = this.w;
            if (arrayList2 != null) {
                recyclerView.setAdapter(new f.a.a.a.b.c.f(this, arrayList2));
            } else {
                f.p("list_ws");
                throw null;
            }
        } else {
            f.p("list_ws");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_sp_step1_my_ws);
        int i2 = f.a.a.a.b.o.sp_step1_my_ws_edt_add_own;
        ((AppCompatEditText) W(i2)).setOnEditorActionListener(new a(this));
        ((AppCompatEditText) W(i2)).setOnFocusChangeListener(new b(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        int i3 = f.a.a.a.b.o.sp_step1_my_ws_rview;
        ((RecyclerView) W(i3)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i3);
        f.d(recyclerView, "sp_step1_my_ws_rview");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step1_my_ws_txt_cancel)).setOnClickListener(new c(this));
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step1_my_ws_txt_save)).setOnClickListener(new d(this));
        z zVar = new z(this);
        this.x = zVar;
        ArrayList<e> V = zVar.V();
        f.d(V, "helper.allWS");
        this.w = V;
        JSONArray m = o.m(getApplicationContext());
        ArrayList<e> arrayList = this.w;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (true) {
                int i4 = 0;
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                int length = m.length();
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    f.d(next, "ws");
                    int a2 = next.a();
                    Object obj = m.get(i4);
                    if ((obj instanceof Integer) && a2 == ((Integer) obj).intValue()) {
                        next.h(true);
                        break;
                    }
                    i4++;
                }
            }
            c0();
            X();
            T((Toolbar) W(f.a.a.a.b.o.sp_step1_my_ws_toolbar));
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
        f.p("list_ws");
        throw null;
    }
}
