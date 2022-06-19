package f.a.a.a.b.j;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.z0;
import f.a.a.a.b.c.i;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_congrats;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_steps;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import vainstrum.Components.ButtonTracking;

/* compiled from: Frag_sp_step_4.kt */
public final class d extends vainstrum.Components.b {
    private final int c0 = 27;
    private final int d0 = 28;
    private final int e0 = 29;
    private ArrayList<f.a.a.a.b.e.d> f0;
    public Act_sp_steps g0;
    public z h0;
    public LinearLayoutManager i0;
    private androidx.recyclerview.widget.f j0;
    private HashMap k0;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_4.kt */
    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9411b;

        a(d dVar) {
            this.f9411b = dVar;
        }

        public final void run() {
            Intent intent = new Intent(this.f9411b.Z1(), Act_sp_congrats.class);
            intent.putExtra("step", 4);
            this.f9411b.F1(intent);
        }
    }

    /* compiled from: Frag_sp_step_4.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9412b;

        b(d dVar) {
            this.f9412b = dVar;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f9412b.Z1(), "android.permission.READ_CONTACTS") != 0) {
                d dVar = this.f9412b;
                dVar.m1(new String[]{"android.permission.READ_CONTACTS"}, dVar.c2());
                return;
            }
            this.f9412b.g2();
        }
    }

    /* compiled from: Frag_sp_step_4.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9413b;

        c(d dVar) {
            this.f9413b = dVar;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f9413b.Z1(), "android.permission.READ_CONTACTS") != 0) {
                d dVar = this.f9413b;
                dVar.m1(new String[]{"android.permission.READ_CONTACTS"}, dVar.c2());
                return;
            }
            this.f9413b.g2();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.j.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_sp_step_4.kt */
    public static final class C0191d implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f9414a;

        C0191d(d dVar) {
            this.f9414a = dVar;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.d0
        public final void a(RecyclerView.d0 d0Var) {
            androidx.recyclerview.widget.f d2 = this.f9414a.d2();
            if (d2 != null) {
                kotlin.m.b.f.c(d0Var);
                d2.H(d0Var);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_4.kt */
    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f9416c;

        e(d dVar, TextView textView) {
            this.f9415b = dVar;
            this.f9416c = textView;
        }

        public final void onClick(View view) {
            TextView textView = this.f9416c;
            kotlin.m.b.f.d(textView, "txt_choose");
            k.b.d.k(textView.getText().toString());
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
            d dVar = this.f9415b;
            dVar.H1(intent, dVar.b2());
            this.f9415b.Z1().Y().q();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_4.kt */
    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9417b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f9418c;

        f(d dVar, TextView textView) {
            this.f9417b = dVar;
            this.f9418c = textView;
        }

        public final void onClick(View view) {
            TextView textView = this.f9418c;
            kotlin.m.b.f.d(textView, "txt_create");
            k.b.d.k(textView.getText().toString());
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/raw_contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            d dVar = this.f9417b;
            dVar.H1(intent, dVar.a2());
            this.f9417b.Z1().Y().q();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_4.kt */
    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9419b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f9420c;

        g(d dVar, TextView textView) {
            this.f9419b = dVar;
            this.f9420c = textView;
        }

        public final void onClick(View view) {
            TextView textView = this.f9420c;
            kotlin.m.b.f.d(textView, "txt_cancel");
            k.b.d.k(textView.getText().toString());
            this.f9419b.Z1().Y().q();
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
        e2();
    }

    @Override // androidx.fragment.app.Fragment
    public void I0(int i2, String[] strArr, int[] iArr) {
        kotlin.m.b.f.e(strArr, "permissions");
        kotlin.m.b.f.e(iArr, "grantResults");
        if (i2 == this.e0) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                g2();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        h2();
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        kotlin.m.b.f.e(view, "view");
        super.N0(view, bundle);
        androidx.fragment.app.d n = n();
        kotlin.m.b.f.c(n);
        String N = j.N(n, h.f10103g);
        androidx.fragment.app.d n2 = n();
        kotlin.m.b.f.c(n2);
        g0.k(n2, D(), (LinearLayout) X1(o.sp_step_4_intro_content), N, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        ((ButtonTracking) X1(o.sp_step_4_btn_add_contacts)).setOnClickListener(new b(this));
        ((ButtonTracking) X1(o.sp_step_4_btn_edit_contacts)).setOnClickListener(new c(this));
        androidx.fragment.app.d n3 = n();
        kotlin.m.b.f.c(n3);
        this.h0 = new z(n3);
        androidx.fragment.app.d n4 = n();
        kotlin.m.b.f.c(n4);
        this.i0 = new LinearLayoutManager(n4);
        int i2 = o.sp_step_4_layout_rview;
        ((RecyclerView) X1(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) X1(i2);
        kotlin.m.b.f.d(recyclerView, "sp_step_4_layout_rview");
        LinearLayoutManager linearLayoutManager = this.i0;
        if (linearLayoutManager != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView2 = (RecyclerView) X1(i2);
            kotlin.m.b.f.d(recyclerView2, "sp_step_4_layout_rview");
            recyclerView2.setNestedScrollingEnabled(false);
            return;
        }
        kotlin.m.b.f.p("layoutManager");
        throw null;
    }

    public void W1() {
        HashMap hashMap = this.k0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.k0 == null) {
            this.k0 = new HashMap();
        }
        View view = (View) this.k0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.k0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void Y1(String str, String str2, String str3) {
        kotlin.m.b.f.e(str, "id");
        kotlin.m.b.f.e(str2, "name");
        z zVar = this.h0;
        if (zVar != null) {
            zVar.F(str2, str, str3, 4, null);
            z zVar2 = this.h0;
            if (zVar2 != null) {
                f.a.a.a.b.e.d W = zVar2.W(4);
                if (this.f0 == null) {
                    this.f0 = new ArrayList<>();
                }
                ArrayList<f.a.a.a.b.e.d> arrayList = this.f0;
                kotlin.m.b.f.c(arrayList);
                arrayList.add(0, W);
                JSONArray jSONArray = new JSONArray();
                ArrayList<f.a.a.a.b.e.d> arrayList2 = this.f0;
                kotlin.m.b.f.c(arrayList2);
                Iterator<f.a.a.a.b.e.d> it = arrayList2.iterator();
                while (it.hasNext()) {
                    f.a.a.a.b.e.d next = it.next();
                    kotlin.m.b.f.d(next, "contact");
                    jSONArray.put(next.c());
                }
                Act_sp_steps act_sp_steps = this.g0;
                if (act_sp_steps != null) {
                    if (!gov.va.mobilehealth.ncptsd.covid.CComp.o.p(act_sp_steps, 4)) {
                        new Handler().postDelayed(new a(this), 150);
                    }
                    Act_sp_steps act_sp_steps2 = this.g0;
                    if (act_sp_steps2 != null) {
                        gov.va.mobilehealth.ncptsd.covid.CComp.o.H(act_sp_steps2, 4);
                        Act_sp_steps act_sp_steps3 = this.g0;
                        if (act_sp_steps3 != null) {
                            gov.va.mobilehealth.ncptsd.covid.CComp.o.v(act_sp_steps3, jSONArray, 4);
                            h2();
                            return;
                        }
                        kotlin.m.b.f.p("act");
                        throw null;
                    }
                    kotlin.m.b.f.p("act");
                    throw null;
                }
                kotlin.m.b.f.p("act");
                throw null;
            }
            kotlin.m.b.f.p("helper");
            throw null;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    public final Act_sp_steps Z1() {
        Act_sp_steps act_sp_steps = this.g0;
        if (act_sp_steps != null) {
            return act_sp_steps;
        }
        kotlin.m.b.f.p("act");
        throw null;
    }

    public final int a2() {
        return this.d0;
    }

    public final int b2() {
        return this.c0;
    }

    public final int c2() {
        return this.e0;
    }

    public final androidx.recyclerview.widget.f d2() {
        return this.j0;
    }

    public final void e2() {
        if (this.f0 != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList<f.a.a.a.b.e.d> arrayList = this.f0;
            kotlin.m.b.f.c(arrayList);
            Iterator<f.a.a.a.b.e.d> it = arrayList.iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.d next = it.next();
                kotlin.m.b.f.d(next, "contact");
                jSONArray.put(next.c());
            }
            androidx.fragment.app.d n = n();
            kotlin.m.b.f.c(n);
            gov.va.mobilehealth.ncptsd.covid.CComp.o.v(n, jSONArray, 4);
        }
    }

    public final void f2() {
        z zVar = this.h0;
        if (zVar != null) {
            ArrayList<f.a.a.a.b.e.d> Q = zVar.Q(4);
            this.f0 = new ArrayList<>();
            androidx.fragment.app.d n = n();
            kotlin.m.b.f.c(n);
            JSONArray i2 = gov.va.mobilehealth.ncptsd.covid.CComp.o.i(n, 4);
            int length = i2.length();
            for (int i3 = 0; i3 < length; i3++) {
                Iterator<f.a.a.a.b.e.d> it = Q.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f.a.a.a.b.e.d next = it.next();
                    kotlin.m.b.f.d(next, "contact");
                    int c2 = next.c();
                    Object obj = i2.get(i3);
                    if ((obj instanceof Integer) && c2 == ((Integer) obj).intValue()) {
                        ArrayList<f.a.a.a.b.e.d> arrayList = this.f0;
                        kotlin.m.b.f.c(arrayList);
                        arrayList.add(next);
                        break;
                    }
                }
            }
            ArrayList<f.a.a.a.b.e.d> arrayList2 = this.f0;
            kotlin.m.b.f.c(arrayList2);
            i iVar = new i(this, arrayList2, new C0191d(this));
            int i4 = o.sp_step_4_layout_rview;
            RecyclerView recyclerView = (RecyclerView) X1(i4);
            kotlin.m.b.f.d(recyclerView, "sp_step_4_layout_rview");
            recyclerView.setAdapter(iVar);
            androidx.recyclerview.widget.f fVar = this.j0;
            if (!(fVar == null || fVar == null)) {
                fVar.m(null);
            }
            androidx.recyclerview.widget.f fVar2 = new androidx.recyclerview.widget.f(new z0(iVar));
            this.j0 = fVar2;
            if (fVar2 != null) {
                fVar2.m((RecyclerView) X1(i4));
                return;
            }
            return;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    public final void g2() {
        Act_sp_steps act_sp_steps = this.g0;
        if (act_sp_steps != null) {
            View inflate = LayoutInflater.from(act_sp_steps).inflate(R.layout.bs_contacts, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.bs_contacts_txt_pick);
            TextView textView2 = (TextView) inflate.findViewById(R.id.bs_contacts_txt_create);
            TextView textView3 = (TextView) inflate.findViewById(R.id.bs_contacts_txt_cancel);
            textView.setOnClickListener(new e(this, textView));
            textView2.setOnClickListener(new f(this, textView2));
            textView3.setOnClickListener(new g(this, textView3));
            Act_sp_steps act_sp_steps2 = this.g0;
            if (act_sp_steps2 != null) {
                act_sp_steps2.Y().C(inflate);
                s.b(textView);
                return;
            }
            kotlin.m.b.f.p("act");
            throw null;
        }
        kotlin.m.b.f.p("act");
        throw null;
    }

    public final void h2() {
        androidx.fragment.app.d n = n();
        kotlin.m.b.f.c(n);
        if (gov.va.mobilehealth.ncptsd.covid.CComp.o.i(n, 4).length() != 0) {
            LinearLayout linearLayout = (LinearLayout) X1(o.sp_step_4_layout_intro);
            kotlin.m.b.f.d(linearLayout, "sp_step_4_layout_intro");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) X1(o.sp_step_4_layout_contents);
            kotlin.m.b.f.d(linearLayout2, "sp_step_4_layout_contents");
            linearLayout2.setVisibility(0);
            f2();
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) X1(o.sp_step_4_layout_intro);
        kotlin.m.b.f.d(linearLayout3, "sp_step_4_layout_intro");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = (LinearLayout) X1(o.sp_step_4_layout_contents);
        kotlin.m.b.f.d(linearLayout4, "sp_step_4_layout_contents");
        linearLayout4.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(int i2, int i3, Intent intent) {
        super.j0(i2, i3, intent);
        if ((i2 == this.c0 || i2 == this.d0) && i3 == -1) {
            kotlin.m.b.f.c(intent);
            Uri data = intent.getData();
            Act_sp_steps act_sp_steps = this.g0;
            String str = null;
            if (act_sp_steps != null) {
                ContentResolver contentResolver = act_sp_steps.getContentResolver();
                kotlin.m.b.f.c(data);
                Cursor query = contentResolver.query(data, null, null, null, null);
                kotlin.m.b.f.c(query);
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndex("display_name"));
                    Act_sp_steps act_sp_steps2 = this.g0;
                    if (act_sp_steps2 != null) {
                        ContentResolver contentResolver2 = act_sp_steps2.getContentResolver();
                        Uri uri = ContactsContract.Contacts.CONTENT_URI;
                        Cursor query2 = contentResolver2.query(uri, null, "DISPLAY_NAME = '" + string2 + '\'', null, null);
                        kotlin.m.b.f.c(query2);
                        if (query2.moveToFirst()) {
                            String string3 = query2.getString(query2.getColumnIndex("_id"));
                            Uri uri2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                            Cursor query3 = contentResolver2.query(uri2, null, "contact_id = " + string3, null, null);
                            while (true) {
                                kotlin.m.b.f.c(query3);
                                if (!query3.moveToNext()) {
                                    break;
                                }
                                str = query3.getString(query3.getColumnIndex("data1"));
                            }
                            query3.close();
                        }
                        query2.close();
                        kotlin.m.b.f.d(string, "id");
                        kotlin.m.b.f.d(string2, "name");
                        Y1(string, string2, str);
                        gov.va.mobilehealth.ncptsd.covid.CComp.o.A();
                        return;
                    }
                    kotlin.m.b.f.p("act");
                    throw null;
                }
                return;
            }
            kotlin.m.b.f.p("act");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        androidx.fragment.app.d n = n();
        Objects.requireNonNull(n, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_steps");
        this.g0 = (Act_sp_steps) n;
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.m.b.f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_sp_step_4, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
