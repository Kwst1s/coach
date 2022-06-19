package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.g;
import f.a.a.a.b.d.u;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.TextViewButtonRole;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.p;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.b.f;
import org.json.JSONArray;
import vainstrum.Components.ImageViewTracking;

/* compiled from: Act_search.kt */
public final class Act_search extends androidx.appcompat.app.c {
    private int t = -1;
    private ArrayList<b0> u;
    private ArrayList<u> v;
    private ArrayList<u> w;
    private HashMap x;

    /* compiled from: Act_search.kt */
    public static final class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_search f9872b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(Act_search act_search) {
            this.f9872b = act_search;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence == null || charSequence.length() != 0) {
                TextViewButtonRole textViewButtonRole = (TextViewButtonRole) this.f9872b.W(o.search_txt_cancel);
                f.d(textViewButtonRole, "search_txt_cancel");
                textViewButtonRole.setVisibility(0);
                this.f9872b.X(String.valueOf(charSequence));
                return;
            }
            TextViewButtonRole textViewButtonRole2 = (TextViewButtonRole) this.f9872b.W(o.search_txt_cancel);
            f.d(textViewButtonRole2, "search_txt_cancel");
            textViewButtonRole2.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) this.f9872b.W(o.search_rview);
            f.d(recyclerView, "search_rview");
            recyclerView.setAdapter(new f.a.a.a.b.b.u(this.f9872b, new ArrayList(), this.f9872b.Y()));
        }
    }

    /* compiled from: Act_search.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_search f9873b;

        b(Act_search act_search) {
            this.f9873b = act_search;
        }

        public final void onClick(View view) {
            this.f9873b.finish();
        }
    }

    /* compiled from: Act_search.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_search f9874b;

        c(Act_search act_search) {
            this.f9874b = act_search;
        }

        public final void onClick(View view) {
            Act_search act_search = this.f9874b;
            int i2 = o.search_edt;
            ((AppCompatEditText) act_search.W(i2)).setText(BuildConfig.FLAVOR);
            Act_search act_search2 = this.f9874b;
            j.d(act_search2, (AppCompatEditText) act_search2.W(i2));
        }
    }

    public View W(int i2) {
        if (this.x == null) {
            this.x = new HashMap();
        }
        View view = (View) this.x.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.x.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X(String str) {
        f.e(str, "text");
        ArrayList arrayList = new ArrayList();
        int i2 = this.t;
        if (i2 == 1) {
            ArrayList<b0> arrayList2 = this.u;
            f.c(arrayList2);
            Iterator<b0> it = arrayList2.iterator();
            while (it.hasNext()) {
                b0 next = it.next();
                f.d(next, "tool");
                String g2 = next.g();
                f.c(g2);
                if (kotlin.o.o.d(g2, str, true)) {
                    arrayList.add(next);
                }
            }
        } else if (i2 == 2) {
            ArrayList<u> arrayList3 = this.v;
            f.c(arrayList3);
            Iterator<u> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                u next2 = it2.next();
                f.d(next2, "learn");
                String c2 = next2.c();
                f.c(c2);
                if (kotlin.o.o.d(c2, str, true)) {
                    arrayList.add(next2);
                }
            }
        } else if (i2 == 3) {
            ArrayList<u> arrayList4 = this.w;
            f.c(arrayList4);
            Iterator<u> it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                u next3 = it3.next();
                f.d(next3, "resource");
                String c3 = next3.c();
                f.c(c3);
                if (kotlin.o.o.d(c3, str, true)) {
                    arrayList.add(next3);
                }
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(arrayList.size()));
        sb.append(" ");
        if (arrayList.size() == 1) {
            sb.append(getString(R.string.result));
        } else {
            sb.append(getString(R.string.results));
        }
        int i3 = o.search_rview;
        ((RecyclerView) W(i3)).announceForAccessibility(sb);
        RecyclerView recyclerView = (RecyclerView) W(i3);
        f.d(recyclerView, "search_rview");
        recyclerView.setAdapter(new f.a.a.a.b.b.u(this, arrayList, this.t));
    }

    public final int Y() {
        return this.t;
    }

    public final void Z() {
        int i2 = this.t;
        if (i2 == 1) {
            ArrayList<g> q0 = new gov.va.mobilehealth.ncptsd.covid.CComp.u(getApplicationContext()).q0();
            this.u = m.p0(getApplicationContext());
            Iterator<g> it = q0.iterator();
            while (it.hasNext()) {
                g next = it.next();
                ArrayList<b0> arrayList = this.u;
                f.c(arrayList);
                f.d(next, "ctool");
                arrayList.add(new b0(next.c(), next.e(), next.e(), null, null));
            }
        } else if (i2 == 2) {
            ArrayList<u> W1 = f.a.a.a.b.h.b.W1(this, "learn_staying_sane.json");
            ArrayList<u> W12 = f.a.a.a.b.h.b.W1(this, "learn_staying_balanced.json");
            ArrayList<u> W13 = f.a.a.a.b.h.b.W1(this, "learn_staying_together.json");
            ArrayList<u> W14 = f.a.a.a.b.h.b.W1(this, "learn_staying_safe.json");
            ArrayList<u> W15 = f.a.a.a.b.h.b.W1(this, "learn_staying_healthy.json");
            ArrayList<u> arrayList2 = new ArrayList<>();
            this.v = arrayList2;
            f.c(arrayList2);
            arrayList2.addAll(W1);
            ArrayList<u> arrayList3 = this.v;
            f.c(arrayList3);
            arrayList3.addAll(W12);
            ArrayList<u> arrayList4 = this.v;
            f.c(arrayList4);
            arrayList4.addAll(W13);
            ArrayList<u> arrayList5 = this.v;
            f.c(arrayList5);
            arrayList5.addAll(W14);
            ArrayList<u> arrayList6 = this.v;
            f.c(arrayList6);
            arrayList6.addAll(W15);
        } else if (i2 == 3) {
            Context applicationContext = getApplicationContext();
            this.w = p.a(new JSONArray(j.N(applicationContext, gov.va.mobilehealth.ncptsd.covid.CComp.g.f10082b + File.separator + "find_resources.json")));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(gov.va.mobilehealth.ncptsd.covid.CComp.b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        this.t = getIntent().getIntExtra("searchType", 1);
        setContentView(R.layout.act_search);
        int i2 = o.search_rview;
        ((RecyclerView) W(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i2);
        f.d(recyclerView, "search_rview");
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ((AppCompatEditText) W(o.search_edt)).addTextChangedListener(new a(this));
        Z();
        ((ImageViewTracking) W(o.search_img_back)).setOnClickListener(new b(this));
        ((TextViewButtonRole) W(o.search_txt_cancel)).setOnClickListener(new c(this));
    }
}
