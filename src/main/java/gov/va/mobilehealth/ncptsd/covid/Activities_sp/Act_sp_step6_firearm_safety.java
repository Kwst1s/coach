package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.c.d;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONObject;
import vainstrum.Components.TextViewTracking;

/* compiled from: Act_sp_step6_firearm_safety.kt */
public final class Act_sp_step6_firearm_safety extends vainstrum.Components.a {
    public ArrayList<f.a.a.a.b.e.b> w;
    public ArrayList<f.a.a.a.b.e.b> x;
    public z y;
    private HashMap z;

    /* compiled from: Act_sp_step6_firearm_safety.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step6_firearm_safety f9992b;

        a(Act_sp_step6_firearm_safety act_sp_step6_firearm_safety) {
            this.f9992b = act_sp_step6_firearm_safety;
        }

        public final void onClick(View view) {
            this.f9992b.finish();
        }
    }

    /* compiled from: Act_sp_step6_firearm_safety.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step6_firearm_safety f9993b;

        /* compiled from: Act_sp_step6_firearm_safety.kt */
        static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f9994b;

            a(b bVar) {
                this.f9994b = bVar;
            }

            public final void run() {
                Intent intent = new Intent(this.f9994b.f9993b, Act_sp_congrats.class);
                intent.putExtra("step", 6);
                intent.putExtra("step_variant", 1);
                this.f9994b.f9993b.startActivity(intent);
            }
        }

        b(Act_sp_step6_firearm_safety act_sp_step6_firearm_safety) {
            this.f9993b = act_sp_step6_firearm_safety;
        }

        public final void onClick(View view) {
            JSONArray jSONArray = new JSONArray();
            Iterator<f.a.a.a.b.e.b> it = this.f9993b.Z().iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.b next = it.next();
                f.d(next, "idea");
                if (next.e()) {
                    jSONArray.put(next.c());
                }
            }
            Iterator<f.a.a.a.b.e.b> it2 = this.f9993b.a0().iterator();
            while (it2.hasNext()) {
                f.a.a.a.b.e.b next2 = it2.next();
                f.d(next2, "idea");
                if (next2.e()) {
                    jSONArray.put(next2.c());
                }
            }
            if (!o.q(this.f9993b, 6, 1)) {
                new Handler().postDelayed(new a(this), 150);
            }
            if (o.q(this.f9993b, 6, 2)) {
                o.H(this.f9993b, 6);
            }
            o.I(this.f9993b, 6, 1);
            o.w(this.f9993b.getApplicationContext(), jSONArray);
            this.f9993b.finish();
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
        ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
        if (arrayList != null) {
            Iterator<f.a.a.a.b.e.b> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                f.a.a.a.b.e.b next = it.next();
                f.d(next, "ps");
                if (next.e()) {
                    z2 = true;
                    break;
                }
            }
            ArrayList<f.a.a.a.b.e.b> arrayList2 = this.x;
            if (arrayList2 != null) {
                Iterator<f.a.a.a.b.e.b> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    f.a.a.a.b.e.b next2 = it2.next();
                    f.d(next2, "ps");
                    if (next2.e()) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    int i2 = f.a.a.a.b.o.sp_step6_firearm_safety_txt_save;
                    TextViewTracking textViewTracking = (TextViewTracking) W(i2);
                    f.d(textViewTracking, "sp_step6_firearm_safety_txt_save");
                    textViewTracking.setContentDescription(getString(R.string.save) + " " + getString(R.string.button));
                    ((TextViewTracking) W(i2)).setTextColor(-1);
                    TextViewTracking textViewTracking2 = (TextViewTracking) W(i2);
                    f.d(textViewTracking2, "sp_step6_firearm_safety_txt_save");
                    textViewTracking2.setClickable(true);
                    return;
                }
                int i3 = f.a.a.a.b.o.sp_step6_firearm_safety_txt_save;
                TextViewTracking textViewTracking3 = (TextViewTracking) W(i3);
                f.d(textViewTracking3, "sp_step6_firearm_safety_txt_save");
                textViewTracking3.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                ((TextViewTracking) W(i3)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking4 = (TextViewTracking) W(i3);
                f.d(textViewTracking4, "sp_step6_firearm_safety_txt_save");
                textViewTracking4.setClickable(false);
                return;
            }
            f.p("list_ideas_guns_outside_home");
            throw null;
        }
        f.p("list_ideas_guns_home");
        throw null;
    }

    public final void Y() {
        z zVar = new z(this);
        this.y = zVar;
        if (zVar != null) {
            ArrayList<f.a.a.a.b.e.b> S = zVar.S(0);
            f.d(S, "helper.getAllNotUserIdea…_env_safe.idea_guns_home)");
            this.w = S;
            z zVar2 = this.y;
            if (zVar2 != null) {
                ArrayList<f.a.a.a.b.e.b> S2 = zVar2.S(1);
                f.d(S2, "helper.getAllNotUserIdea…v_safe.idea_guns_outside)");
                this.x = S2;
                ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
                if (arrayList != null) {
                    if (arrayList.isEmpty()) {
                        JSONArray jSONArray = new JSONArray(j.N(this, h.n));
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            z zVar3 = this.y;
                            if (zVar3 != null) {
                                zVar3.G(jSONObject.getString("text"), 1, jSONObject.getInt("help_id"));
                            } else {
                                f.p("helper");
                                throw null;
                            }
                        }
                        z zVar4 = this.y;
                        if (zVar4 != null) {
                            ArrayList<f.a.a.a.b.e.b> S3 = zVar4.S(0);
                            f.d(S3, "helper.getAllNotUserIdea…_env_safe.idea_guns_home)");
                            this.w = S3;
                        } else {
                            f.p("helper");
                            throw null;
                        }
                    }
                    ArrayList<f.a.a.a.b.e.b> arrayList2 = this.x;
                    if (arrayList2 != null) {
                        if (arrayList2.isEmpty()) {
                            JSONArray jSONArray2 = new JSONArray(j.N(this, h.o));
                            int length2 = jSONArray2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                                z zVar5 = this.y;
                                if (zVar5 != null) {
                                    zVar5.G(jSONObject2.getString("text"), 0, jSONObject2.getInt("help_id"));
                                } else {
                                    f.p("helper");
                                    throw null;
                                }
                            }
                            z zVar6 = this.y;
                            if (zVar6 != null) {
                                ArrayList<f.a.a.a.b.e.b> S4 = zVar6.S(1);
                                f.d(S4, "helper.getAllNotUserIdea…v_safe.idea_guns_outside)");
                                this.x = S4;
                            } else {
                                f.p("helper");
                                throw null;
                            }
                        }
                        JSONArray j2 = o.j(getApplicationContext());
                        ArrayList<f.a.a.a.b.e.b> arrayList3 = this.w;
                        if (arrayList3 != null) {
                            Iterator<f.a.a.a.b.e.b> it = arrayList3.iterator();
                            while (it.hasNext()) {
                                f.a.a.a.b.e.b next = it.next();
                                int length3 = j2.length();
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length3) {
                                        break;
                                    }
                                    f.d(next, "idea");
                                    int c2 = next.c();
                                    Object obj = j2.get(i4);
                                    if ((obj instanceof Integer) && c2 == ((Integer) obj).intValue()) {
                                        next.j(true);
                                        break;
                                    }
                                    i4++;
                                }
                            }
                            ArrayList<f.a.a.a.b.e.b> arrayList4 = this.x;
                            if (arrayList4 != null) {
                                Iterator<f.a.a.a.b.e.b> it2 = arrayList4.iterator();
                                while (it2.hasNext()) {
                                    f.a.a.a.b.e.b next2 = it2.next();
                                    int length4 = j2.length();
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= length4) {
                                            break;
                                        }
                                        f.d(next2, "idea");
                                        int c3 = next2.c();
                                        Object obj2 = j2.get(i5);
                                        if ((obj2 instanceof Integer) && c3 == ((Integer) obj2).intValue()) {
                                            next2.j(true);
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                                b0();
                                X();
                                return;
                            }
                            f.p("list_ideas_guns_outside_home");
                            throw null;
                        }
                        f.p("list_ideas_guns_home");
                        throw null;
                    }
                    f.p("list_ideas_guns_outside_home");
                    throw null;
                }
                f.p("list_ideas_guns_home");
                throw null;
            }
            f.p("helper");
            throw null;
        }
        f.p("helper");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.b> Z() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ideas_guns_home");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.b> a0() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.x;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ideas_guns_outside_home");
        throw null;
    }

    public final void b0() {
        RecyclerView recyclerView = (RecyclerView) W(f.a.a.a.b.o.sp_step6_firearm_safety_rview_store_guns_within);
        f.d(recyclerView, "sp_step6_firearm_safety_rview_store_guns_within");
        ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
        if (arrayList != null) {
            recyclerView.setAdapter(new d(this, arrayList));
            RecyclerView recyclerView2 = (RecyclerView) W(f.a.a.a.b.o.sp_step6_firearm_safety_rview_store_guns_outside);
            f.d(recyclerView2, "sp_step6_firearm_safety_rview_store_guns_outside");
            ArrayList<f.a.a.a.b.e.b> arrayList2 = this.x;
            if (arrayList2 != null) {
                recyclerView2.setAdapter(new d(this, arrayList2));
            } else {
                f.p("list_ideas_guns_outside_home");
                throw null;
            }
        } else {
            f.p("list_ideas_guns_home");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_sp_step6_firearm_safety);
        int i2 = f.a.a.a.b.o.sp_step6_firearm_safety_rview_store_guns_within;
        ((RecyclerView) W(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i2);
        f.d(recyclerView, "sp_step6_firearm_safety_rview_store_guns_within");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = (RecyclerView) W(i2);
        f.d(recyclerView2, "sp_step6_firearm_safety_rview_store_guns_within");
        recyclerView2.setNestedScrollingEnabled(false);
        int i3 = f.a.a.a.b.o.sp_step6_firearm_safety_rview_store_guns_outside;
        ((RecyclerView) W(i3)).setHasFixedSize(true);
        RecyclerView recyclerView3 = (RecyclerView) W(i3);
        f.d(recyclerView3, "sp_step6_firearm_safety_rview_store_guns_outside");
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView4 = (RecyclerView) W(i3);
        f.d(recyclerView4, "sp_step6_firearm_safety_rview_store_guns_outside");
        recyclerView4.setNestedScrollingEnabled(false);
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step6_firearm_safety_txt_cancel)).setOnClickListener(new a(this));
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step6_firearm_safety_txt_save)).setOnClickListener(new b(this));
        Y();
        T((Toolbar) W(f.a.a.a.b.o.sp_step6_firearm_safety_toolbar));
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
        }
    }
}
