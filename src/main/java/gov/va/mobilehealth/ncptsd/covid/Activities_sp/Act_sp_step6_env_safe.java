package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
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

/* compiled from: Act_sp_step6_env_safe.kt */
public final class Act_sp_step6_env_safe extends vainstrum.Components.a {
    public z A;
    private HashMap B;
    public ArrayList<f.a.a.a.b.e.b> w;
    public ArrayList<f.a.a.a.b.e.b> x;
    public ArrayList<f.a.a.a.b.e.b> y;
    public ArrayList<f.a.a.a.b.e.b> z;

    /* compiled from: Act_sp_step6_env_safe.kt */
    static final class a implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step6_env_safe f9987a;

        a(Act_sp_step6_env_safe act_sp_step6_env_safe) {
            this.f9987a = act_sp_step6_env_safe;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                f.c(textView);
                if (textView.getText().toString().length() > 0) {
                    o.A();
                    this.f9987a.Z().H(textView.getText().toString());
                    textView.setText(BuildConfig.FLAVOR);
                    this.f9987a.e0();
                }
            }
            return false;
        }
    }

    /* compiled from: Act_sp_step6_env_safe.kt */
    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_sp_step6_env_safe f9988a;

        b(Act_sp_step6_env_safe act_sp_step6_env_safe) {
            this.f9988a = act_sp_step6_env_safe;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                Act_sp_step6_env_safe act_sp_step6_env_safe = this.f9988a;
                int i2 = f.a.a.a.b.o.sp_step6_env_safe_txt_save;
                TextViewTracking textViewTracking = (TextViewTracking) act_sp_step6_env_safe.W(i2);
                f.d(textViewTracking, "sp_step6_env_safe_txt_save");
                textViewTracking.setContentDescription(this.f9988a.getString(R.string.save) + " " + this.f9988a.getString(R.string.button) + " " + this.f9988a.getString(R.string.disabled));
                ((TextViewTracking) this.f9988a.W(i2)).setTextColor(b.h.d.a.b(this.f9988a.getApplicationContext(), R.color.white_alpha));
                TextViewTracking textViewTracking2 = (TextViewTracking) this.f9988a.W(i2);
                f.d(textViewTracking2, "sp_step6_env_safe_txt_save");
                textViewTracking2.setClickable(false);
                return;
            }
            this.f9988a.X();
        }
    }

    /* compiled from: Act_sp_step6_env_safe.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step6_env_safe f9989b;

        c(Act_sp_step6_env_safe act_sp_step6_env_safe) {
            this.f9989b = act_sp_step6_env_safe;
        }

        public final void onClick(View view) {
            this.f9989b.finish();
        }
    }

    /* compiled from: Act_sp_step6_env_safe.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_step6_env_safe f9990b;

        /* compiled from: Act_sp_step6_env_safe.kt */
        static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f9991b;

            a(d dVar) {
                this.f9991b = dVar;
            }

            public final void run() {
                Intent intent = new Intent(this.f9991b.f9990b, Act_sp_congrats.class);
                intent.putExtra("step", 6);
                intent.putExtra("step_variant", 1);
                this.f9991b.f9990b.startActivity(intent);
            }
        }

        d(Act_sp_step6_env_safe act_sp_step6_env_safe) {
            this.f9990b = act_sp_step6_env_safe;
        }

        public final void onClick(View view) {
            JSONArray jSONArray = new JSONArray();
            Iterator<f.a.a.a.b.e.b> it = this.f9990b.d0().iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.b next = it.next();
                f.d(next, "idea");
                if (next.e()) {
                    jSONArray.put(next.c());
                }
            }
            Iterator<f.a.a.a.b.e.b> it2 = this.f9990b.a0().iterator();
            while (it2.hasNext()) {
                f.a.a.a.b.e.b next2 = it2.next();
                f.d(next2, "idea");
                if (next2.e()) {
                    jSONArray.put(next2.c());
                }
            }
            Iterator<f.a.a.a.b.e.b> it3 = this.f9990b.b0().iterator();
            while (it3.hasNext()) {
                f.a.a.a.b.e.b next3 = it3.next();
                f.d(next3, "idea");
                if (next3.e()) {
                    jSONArray.put(next3.c());
                }
            }
            Iterator<f.a.a.a.b.e.b> it4 = this.f9990b.c0().iterator();
            while (it4.hasNext()) {
                f.a.a.a.b.e.b next4 = it4.next();
                f.d(next4, "idea");
                if (next4.e()) {
                    jSONArray.put(next4.c());
                }
            }
            o.D(this.f9990b.d0(), this.f9990b.b0(), this.f9990b.a0(), this.f9990b.c0());
            if (!o.q(this.f9990b, 6, 1)) {
                new Handler().postDelayed(new a(this), 150);
            }
            if (o.q(this.f9990b, 6, 2)) {
                o.H(this.f9990b, 6);
            }
            o.I(this.f9990b, 6, 1);
            o.w(this.f9990b.getApplicationContext(), jSONArray);
            this.f9990b.finish();
        }
    }

    public View W(int i2) {
        if (this.B == null) {
            this.B = new HashMap();
        }
        View view = (View) this.B.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.B.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        boolean z2;
        boolean z3;
        ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
        if (arrayList != null) {
            Iterator<f.a.a.a.b.e.b> it = arrayList.iterator();
            while (true) {
                z2 = true;
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                f.a.a.a.b.e.b next = it.next();
                f.d(next, "ps");
                if (next.e()) {
                    z3 = true;
                    break;
                }
            }
            ArrayList<f.a.a.a.b.e.b> arrayList2 = this.y;
            if (arrayList2 != null) {
                Iterator<f.a.a.a.b.e.b> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    f.a.a.a.b.e.b next2 = it2.next();
                    f.d(next2, "ps");
                    if (next2.e()) {
                        z3 = true;
                        break;
                    }
                }
                ArrayList<f.a.a.a.b.e.b> arrayList3 = this.x;
                if (arrayList3 != null) {
                    Iterator<f.a.a.a.b.e.b> it3 = arrayList3.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        f.a.a.a.b.e.b next3 = it3.next();
                        f.d(next3, "ps");
                        if (next3.e()) {
                            z3 = true;
                            break;
                        }
                    }
                    ArrayList<f.a.a.a.b.e.b> arrayList4 = this.z;
                    if (arrayList4 != null) {
                        Iterator<f.a.a.a.b.e.b> it4 = arrayList4.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            f.a.a.a.b.e.b next4 = it4.next();
                            f.d(next4, "ps");
                            if (next4.e()) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3) {
                            int i2 = f.a.a.a.b.o.sp_step6_env_safe_txt_save;
                            TextViewTracking textViewTracking = (TextViewTracking) W(i2);
                            f.d(textViewTracking, "sp_step6_env_safe_txt_save");
                            textViewTracking.setContentDescription(getString(R.string.save) + " " + getString(R.string.button));
                            ((TextViewTracking) W(i2)).setTextColor(-1);
                            TextViewTracking textViewTracking2 = (TextViewTracking) W(i2);
                            f.d(textViewTracking2, "sp_step6_env_safe_txt_save");
                            textViewTracking2.setClickable(true);
                        } else {
                            int i3 = f.a.a.a.b.o.sp_step6_env_safe_txt_save;
                            TextViewTracking textViewTracking3 = (TextViewTracking) W(i3);
                            f.d(textViewTracking3, "sp_step6_env_safe_txt_save");
                            textViewTracking3.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                            ((TextViewTracking) W(i3)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                            TextViewTracking textViewTracking4 = (TextViewTracking) W(i3);
                            f.d(textViewTracking4, "sp_step6_env_safe_txt_save");
                            textViewTracking4.setClickable(false);
                        }
                        int i4 = f.a.a.a.b.o.sp_step6_env_safe_edt;
                        ((AppCompatEditText) W(i4)).clearFocus();
                        AppCompatEditText appCompatEditText = (AppCompatEditText) W(i4);
                        f.d(appCompatEditText, "sp_step6_env_safe_edt");
                        if (String.valueOf(appCompatEditText.getText()).length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            int i5 = f.a.a.a.b.o.sp_step6_env_safe_txt_save;
                            TextViewTracking textViewTracking5 = (TextViewTracking) W(i5);
                            f.d(textViewTracking5, "sp_step6_env_safe_txt_save");
                            textViewTracking5.setContentDescription(getString(R.string.save) + " " + getString(R.string.button) + " " + getString(R.string.disabled));
                            ((TextViewTracking) W(i5)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.white_alpha));
                            TextViewTracking textViewTracking6 = (TextViewTracking) W(i5);
                            f.d(textViewTracking6, "sp_step6_env_safe_txt_save");
                            textViewTracking6.setClickable(false);
                            return;
                        }
                        return;
                    }
                    f.p("list_ideas_store_medication");
                    throw null;
                }
                f.p("list_ideas_guns_outside_home");
                throw null;
            }
            f.p("list_ideas_guns_home");
            throw null;
        }
        f.p("list_user_ideas");
        throw null;
    }

    public final void Y() {
        z zVar = this.A;
        if (zVar != null) {
            ArrayList<f.a.a.a.b.e.b> U = zVar.U();
            f.d(U, "helper.allUserIdeas");
            this.w = U;
            JSONArray j2 = o.j(getApplicationContext());
            ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
            if (arrayList != null) {
                Iterator<f.a.a.a.b.e.b> it = arrayList.iterator();
                while (true) {
                    int i2 = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    f.a.a.a.b.e.b next = it.next();
                    int length = j2.length();
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        f.d(next, "idea");
                        int c2 = next.c();
                        Object obj = j2.get(i2);
                        if ((obj instanceof Integer) && c2 == ((Integer) obj).intValue()) {
                            next.j(true);
                            break;
                        }
                        i2++;
                    }
                }
                z zVar2 = this.A;
                if (zVar2 != null) {
                    ArrayList<f.a.a.a.b.e.b> S = zVar2.S(0);
                    f.d(S, "helper.getAllNotUserIdeas(idea_guns_home)");
                    this.y = S;
                    z zVar3 = this.A;
                    if (zVar3 != null) {
                        ArrayList<f.a.a.a.b.e.b> S2 = zVar3.S(1);
                        f.d(S2, "helper.getAllNotUserIdeas(idea_guns_outside)");
                        this.x = S2;
                        z zVar4 = this.A;
                        if (zVar4 != null) {
                            ArrayList<f.a.a.a.b.e.b> S3 = zVar4.S(2);
                            f.d(S3, "helper.getAllNotUserIdeas(idea_store_medication)");
                            this.z = S3;
                            ArrayList<f.a.a.a.b.e.b> arrayList2 = this.y;
                            if (arrayList2 != null) {
                                if (arrayList2.isEmpty()) {
                                    JSONArray jSONArray = new JSONArray(j.N(this, h.n));
                                    int length2 = jSONArray.length();
                                    int i3 = 0;
                                    while (i3 < length2) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                                        z zVar5 = this.A;
                                        if (zVar5 != null) {
                                            zVar5.G(jSONObject.getString("text"), 0, jSONObject.getInt("help_id"));
                                            i3++;
                                            jSONArray = jSONArray;
                                        } else {
                                            f.p("helper");
                                            throw null;
                                        }
                                    }
                                    z zVar6 = this.A;
                                    if (zVar6 != null) {
                                        ArrayList<f.a.a.a.b.e.b> S4 = zVar6.S(0);
                                        f.d(S4, "helper.getAllNotUserIdeas(idea_guns_home)");
                                        this.y = S4;
                                    } else {
                                        f.p("helper");
                                        throw null;
                                    }
                                }
                                ArrayList<f.a.a.a.b.e.b> arrayList3 = this.x;
                                if (arrayList3 != null) {
                                    if (arrayList3.isEmpty()) {
                                        JSONArray jSONArray2 = new JSONArray(j.N(this, h.o));
                                        int length3 = jSONArray2.length();
                                        int i4 = 0;
                                        while (i4 < length3) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                                            z zVar7 = this.A;
                                            if (zVar7 != null) {
                                                zVar7.G(jSONObject2.getString("text"), 1, jSONObject2.getInt("help_id"));
                                                i4++;
                                                jSONArray2 = jSONArray2;
                                            } else {
                                                f.p("helper");
                                                throw null;
                                            }
                                        }
                                        z zVar8 = this.A;
                                        if (zVar8 != null) {
                                            ArrayList<f.a.a.a.b.e.b> S5 = zVar8.S(1);
                                            f.d(S5, "helper.getAllNotUserIdeas(idea_guns_outside)");
                                            this.x = S5;
                                        } else {
                                            f.p("helper");
                                            throw null;
                                        }
                                    }
                                    ArrayList<f.a.a.a.b.e.b> arrayList4 = this.z;
                                    if (arrayList4 != null) {
                                        if (arrayList4.isEmpty()) {
                                            JSONArray jSONArray3 = new JSONArray(j.N(this, h.p));
                                            int length4 = jSONArray3.length();
                                            int i5 = 0;
                                            while (i5 < length4) {
                                                JSONObject jSONObject3 = jSONArray3.getJSONObject(i5);
                                                z zVar9 = this.A;
                                                if (zVar9 != null) {
                                                    zVar9.G(jSONObject3.getString("text"), 2, jSONObject3.getInt("help_id"));
                                                    i5++;
                                                    jSONArray3 = jSONArray3;
                                                } else {
                                                    f.p("helper");
                                                    throw null;
                                                }
                                            }
                                            z zVar10 = this.A;
                                            if (zVar10 != null) {
                                                ArrayList<f.a.a.a.b.e.b> S6 = zVar10.S(2);
                                                f.d(S6, "helper.getAllNotUserIdeas(idea_store_medication)");
                                                this.z = S6;
                                            } else {
                                                f.p("helper");
                                                throw null;
                                            }
                                        }
                                        ArrayList<f.a.a.a.b.e.b> arrayList5 = this.y;
                                        if (arrayList5 != null) {
                                            Iterator<f.a.a.a.b.e.b> it2 = arrayList5.iterator();
                                            while (it2.hasNext()) {
                                                f.a.a.a.b.e.b next2 = it2.next();
                                                int length5 = j2.length();
                                                int i6 = 0;
                                                while (true) {
                                                    if (i6 >= length5) {
                                                        break;
                                                    }
                                                    f.d(next2, "idea");
                                                    int c3 = next2.c();
                                                    Object obj2 = j2.get(i6);
                                                    if ((obj2 instanceof Integer) && c3 == ((Integer) obj2).intValue()) {
                                                        next2.j(true);
                                                        break;
                                                    }
                                                    i6++;
                                                }
                                            }
                                            ArrayList<f.a.a.a.b.e.b> arrayList6 = this.x;
                                            if (arrayList6 != null) {
                                                Iterator<f.a.a.a.b.e.b> it3 = arrayList6.iterator();
                                                while (it3.hasNext()) {
                                                    f.a.a.a.b.e.b next3 = it3.next();
                                                    int length6 = j2.length();
                                                    int i7 = 0;
                                                    while (true) {
                                                        if (i7 >= length6) {
                                                            break;
                                                        }
                                                        f.d(next3, "idea");
                                                        int c4 = next3.c();
                                                        Object obj3 = j2.get(i7);
                                                        if ((obj3 instanceof Integer) && c4 == ((Integer) obj3).intValue()) {
                                                            next3.j(true);
                                                            break;
                                                        }
                                                        i7++;
                                                    }
                                                }
                                                ArrayList<f.a.a.a.b.e.b> arrayList7 = this.z;
                                                if (arrayList7 != null) {
                                                    Iterator<f.a.a.a.b.e.b> it4 = arrayList7.iterator();
                                                    while (it4.hasNext()) {
                                                        f.a.a.a.b.e.b next4 = it4.next();
                                                        int length7 = j2.length();
                                                        int i8 = 0;
                                                        while (true) {
                                                            if (i8 >= length7) {
                                                                break;
                                                            }
                                                            f.d(next4, "idea");
                                                            int c5 = next4.c();
                                                            Object obj4 = j2.get(i8);
                                                            if ((obj4 instanceof Integer) && c5 == ((Integer) obj4).intValue()) {
                                                                next4.j(true);
                                                                break;
                                                            }
                                                            i8++;
                                                        }
                                                    }
                                                    f0();
                                                    X();
                                                    return;
                                                }
                                                f.p("list_ideas_store_medication");
                                                throw null;
                                            }
                                            f.p("list_ideas_guns_outside_home");
                                            throw null;
                                        }
                                        f.p("list_ideas_guns_home");
                                        throw null;
                                    }
                                    f.p("list_ideas_store_medication");
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
                f.p("helper");
                throw null;
            }
            f.p("list_user_ideas");
            throw null;
        }
        f.p("helper");
        throw null;
    }

    public final z Z() {
        z zVar = this.A;
        if (zVar != null) {
            return zVar;
        }
        f.p("helper");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.b> a0() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.y;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ideas_guns_home");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.b> b0() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.x;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ideas_guns_outside_home");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.b> c0() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.z;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_ideas_store_medication");
        throw null;
    }

    public final ArrayList<f.a.a.a.b.e.b> d0() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
        if (arrayList != null) {
            return arrayList;
        }
        f.p("list_user_ideas");
        throw null;
    }

    public final void e0() {
        z zVar = this.A;
        if (zVar != null) {
            f.a.a.a.b.e.b Y = zVar.Y();
            f.d(Y, "lastIdea");
            Y.j(true);
            ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
            if (arrayList != null) {
                arrayList.add(0, Y);
                f0();
                X();
                return;
            }
            f.p("list_user_ideas");
            throw null;
        }
        f.p("helper");
        throw null;
    }

    public final void f0() {
        ArrayList<f.a.a.a.b.e.b> arrayList = this.w;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                z zVar = this.A;
                if (zVar != null) {
                    ArrayList<f.a.a.a.b.e.b> U = zVar.U();
                    f.d(U, "helper.allUserIdeas");
                    this.w = U;
                } else {
                    f.p("helper");
                    throw null;
                }
            }
            RecyclerView recyclerView = (RecyclerView) W(f.a.a.a.b.o.sp_step6_env_safe_rview_user_elements);
            f.d(recyclerView, "sp_step6_env_safe_rview_user_elements");
            ArrayList<f.a.a.a.b.e.b> arrayList2 = this.w;
            if (arrayList2 != null) {
                recyclerView.setAdapter(new f.a.a.a.b.c.c(this, arrayList2));
                RecyclerView recyclerView2 = (RecyclerView) W(f.a.a.a.b.o.sp_step6_env_safe_rview_store_guns_within);
                f.d(recyclerView2, "sp_step6_env_safe_rview_store_guns_within");
                ArrayList<f.a.a.a.b.e.b> arrayList3 = this.y;
                if (arrayList3 != null) {
                    recyclerView2.setAdapter(new f.a.a.a.b.c.d(this, arrayList3));
                    RecyclerView recyclerView3 = (RecyclerView) W(f.a.a.a.b.o.sp_step6_env_safe_rview_store_guns_outside);
                    f.d(recyclerView3, "sp_step6_env_safe_rview_store_guns_outside");
                    ArrayList<f.a.a.a.b.e.b> arrayList4 = this.x;
                    if (arrayList4 != null) {
                        recyclerView3.setAdapter(new f.a.a.a.b.c.d(this, arrayList4));
                        RecyclerView recyclerView4 = (RecyclerView) W(f.a.a.a.b.o.sp_step6_env_safe_rview_store_medication);
                        f.d(recyclerView4, "sp_step6_env_safe_rview_store_medication");
                        ArrayList<f.a.a.a.b.e.b> arrayList5 = this.z;
                        if (arrayList5 != null) {
                            recyclerView4.setAdapter(new f.a.a.a.b.c.d(this, arrayList5));
                        } else {
                            f.p("list_ideas_store_medication");
                            throw null;
                        }
                    } else {
                        f.p("list_ideas_guns_outside_home");
                        throw null;
                    }
                } else {
                    f.p("list_ideas_guns_home");
                    throw null;
                }
            } else {
                f.p("list_user_ideas");
                throw null;
            }
        } else {
            f.p("list_user_ideas");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_sp_step6_env_safe);
        this.A = new z(getApplicationContext());
        g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_step6_env_safe_layout_content), j.N(this, h.f10107k), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        int i2 = f.a.a.a.b.o.sp_step6_env_safe_edt;
        ((AppCompatEditText) W(i2)).setOnEditorActionListener(new a(this));
        ((AppCompatEditText) W(i2)).setOnFocusChangeListener(new b(this));
        int i3 = f.a.a.a.b.o.sp_step6_env_safe_rview_user_elements;
        ((RecyclerView) W(i3)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i3);
        f.d(recyclerView, "sp_step6_env_safe_rview_user_elements");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = (RecyclerView) W(i3);
        f.d(recyclerView2, "sp_step6_env_safe_rview_user_elements");
        recyclerView2.setNestedScrollingEnabled(false);
        int i4 = f.a.a.a.b.o.sp_step6_env_safe_rview_store_guns_within;
        ((RecyclerView) W(i4)).setHasFixedSize(true);
        RecyclerView recyclerView3 = (RecyclerView) W(i4);
        f.d(recyclerView3, "sp_step6_env_safe_rview_store_guns_within");
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView4 = (RecyclerView) W(i4);
        f.d(recyclerView4, "sp_step6_env_safe_rview_store_guns_within");
        recyclerView4.setNestedScrollingEnabled(false);
        int i5 = f.a.a.a.b.o.sp_step6_env_safe_rview_store_guns_outside;
        ((RecyclerView) W(i5)).setHasFixedSize(true);
        RecyclerView recyclerView5 = (RecyclerView) W(i5);
        f.d(recyclerView5, "sp_step6_env_safe_rview_store_guns_outside");
        recyclerView5.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView6 = (RecyclerView) W(i5);
        f.d(recyclerView6, "sp_step6_env_safe_rview_store_guns_outside");
        recyclerView6.setNestedScrollingEnabled(false);
        int i6 = f.a.a.a.b.o.sp_step6_env_safe_rview_store_medication;
        ((RecyclerView) W(i6)).setHasFixedSize(true);
        RecyclerView recyclerView7 = (RecyclerView) W(i6);
        f.d(recyclerView7, "sp_step6_env_safe_rview_store_medication");
        recyclerView7.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView8 = (RecyclerView) W(i6);
        f.d(recyclerView8, "sp_step6_env_safe_rview_store_medication");
        recyclerView8.setNestedScrollingEnabled(false);
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step6_env_safe_txt_cancel)).setOnClickListener(new c(this));
        ((TextViewTracking) W(f.a.a.a.b.o.sp_step6_env_safe_txt_save)).setOnClickListener(new d(this));
        Y();
        this.A = new z(this);
        T((Toolbar) W(f.a.a.a.b.o.sp_step6_env_safe_toolbar));
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

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, vainstrum.Components.a
    public void onResume() {
        super.onResume();
    }
}
