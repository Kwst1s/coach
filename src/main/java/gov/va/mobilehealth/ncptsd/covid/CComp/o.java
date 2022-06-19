package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.appcompat.app.b;
import b.c.b.b;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.t;
import f.a.a.a.b.e.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: C_F_PTSD_SafetyPlan */
public class o {

    /* compiled from: C_F_PTSD_SafetyPlan */
    static class a implements g.a.a.a.b.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10132a;

        a(Context context) {
            this.f10132a = context;
        }

        @Override // g.a.a.a.b.b.a
        public void a(String str) {
            o.E(this.f10132a, false);
        }

        @Override // g.a.a.a.b.b.a
        public void b(ArrayList<g.a.a.a.b.d.d.a> arrayList, long j2, g.a.a.a.b.d.c cVar) {
            if (!arrayList.isEmpty()) {
                o.E(this.f10132a, ((g.a.a.a.b.d.b.b) arrayList.get(0).a().get("survey-enabled")).e());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: C_F_PTSD_SafetyPlan */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f10133b;

        b(Activity activity) {
            this.f10133b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            o.C(this.f10133b, false);
            j.u(this.f10133b).putBoolean("noMoreAlertSurvey", true).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: C_F_PTSD_SafetyPlan */
    public static class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f10134b;

        c(Activity activity) {
            this.f10134b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            o.t(this.f10134b);
            o.C(this.f10134b, false);
            j.u(this.f10134b).putBoolean("noMoreAlertSurvey", true).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: C_F_PTSD_SafetyPlan */
    public static class d implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f10135b;

        d(Activity activity) {
            this.f10135b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            o.M(this.f10135b, true, false, true);
        }
    }

    public static void A() {
        k.b.d.a("added_new_element");
    }

    public static void B(ArrayList<f.a.a.a.b.e.a> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).e()) {
                if (arrayList.get(i2).f()) {
                    jSONArray.put("custom_element");
                } else if (arrayList.get(i2).d() == -1) {
                    jSONArray.put(arrayList.get(i2).c());
                } else if (arrayList.get(i2).d() > g.W) {
                    jSONArray.put("custom_tool");
                } else {
                    jSONArray.put(arrayList.get(i2).c());
                }
            }
        }
        if (jSONArray.length() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("items_selected", jSONArray.toString());
            k.b.d.c(hashMap);
        }
    }

    public static void C(Context context, boolean z) {
        j.u(context).putBoolean("canDoSurveyRequestFlow", z).apply();
    }

    public static void D(ArrayList<f.a.a.a.b.e.b> arrayList, ArrayList<f.a.a.a.b.e.b> arrayList2, ArrayList<f.a.a.a.b.e.b> arrayList3, ArrayList<f.a.a.a.b.e.b> arrayList4) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).e()) {
                jSONArray.put("custom_element");
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (arrayList2.get(i3).e()) {
                if (arrayList2.get(i3).f()) {
                    jSONArray.put("custom_element");
                } else {
                    jSONArray.put(arrayList2.get(i3).d());
                }
            }
        }
        for (int i4 = 0; i4 < arrayList3.size(); i4++) {
            if (arrayList3.get(i4).e()) {
                if (arrayList3.get(i4).f()) {
                    jSONArray.put("custom_element");
                } else {
                    jSONArray.put(arrayList3.get(i4).d());
                }
            }
        }
        for (int i5 = 0; i5 < arrayList4.size(); i5++) {
            if (arrayList4.get(i5).e()) {
                if (arrayList4.get(i5).f()) {
                    jSONArray.put("custom_element");
                } else {
                    jSONArray.put(arrayList4.get(i5).d());
                }
            }
        }
        if (jSONArray.length() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("items_selected", jSONArray.toString());
            k.b.d.c(hashMap);
        }
    }

    public static void E(Context context, boolean z) {
        j.u(context).putBoolean("is_survey_enabled", z).apply();
    }

    public static void F(ArrayList<f.a.a.a.b.e.c> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).d()) {
                if (arrayList.get(i2).e()) {
                    jSONArray.put("custom_element");
                } else {
                    jSONArray.put(arrayList.get(i2).c());
                }
            }
        }
        if (jSONArray.length() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("items_selected", jSONArray.toString());
            k.b.d.c(hashMap);
        }
    }

    public static void G(Context context, boolean z) {
        if (!j.s(context).getBoolean("noMoreAlertSurvey", false)) {
            j.u(context).putBoolean("showSurveyRequestFlow", z).apply();
            j.u(context).putBoolean("canDoSurveyRequestFlow", true).apply();
        }
    }

    public static void H(Context context, int i2) {
        SharedPreferences.Editor u = j.u(context);
        u.putBoolean("sp_step" + i2, true).apply();
    }

    public static void I(Context context, int i2, int i3) {
        SharedPreferences.Editor u = j.u(context);
        u.putBoolean("sp_step" + i2 + "_variant_" + i3, true).apply();
    }

    public static void J(Context context, int i2) {
        SharedPreferences.Editor u = j.u(context);
        u.putBoolean("sp_step_seen" + i2, true).apply();
    }

    public static void K(ArrayList<e> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).d()) {
                if (arrayList.get(i2).e()) {
                    jSONArray.put("custom_element");
                } else {
                    jSONArray.put(arrayList.get(i2).c());
                }
            }
        }
        if (jSONArray.length() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("items_selected", jSONArray.toString());
            k.b.d.c(hashMap);
        }
    }

    public static void L(Activity activity, boolean z) {
        b.a h2 = j.h(activity, activity.getString(R.string.would_like_make_app_better));
        h2.k(R.string.yes_answer_3_questions, new c(activity));
        h2.h(R.string.no_dont_ask_again, new b(activity));
        if (z) {
            h2.i(R.string.maybe_ask_me_later, new d(activity));
        }
        h2.a().show();
    }

    public static void M(Context context, boolean z, boolean z2, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject(j.s(context).getString("surveyFlowData", "{}"));
            if (j.F(jSONObject, "lastDate")) {
                int i2 = jSONObject.getInt("sessions");
                int i3 = jSONObject.getInt("maybeTimes");
                if (z) {
                    jSONObject.put("lastDate", System.currentTimeMillis());
                }
                if (z2) {
                    jSONObject.put("sessions", i2 + 1);
                }
                if (z3) {
                    jSONObject.put("maybeTimes", i3 + 1);
                }
            } else {
                jSONObject.put("lastDate", System.currentTimeMillis());
                jSONObject.put("sessions", 0);
                jSONObject.put("maybeTimes", 1);
                jSONObject.put("lastDate", System.currentTimeMillis());
            }
            j.u(context).putString("surveyFlowData", jSONObject.toString()).apply();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        b0.a(context).equals("es");
        return false;
    }

    public static void b(Context context, int i2) {
        try {
            JSONArray g2 = g(context);
            int i3 = 0;
            while (true) {
                if (i3 >= g2.length()) {
                    break;
                } else if (g2.getInt(i3) == i2) {
                    g2.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            new z(context).L(i2);
            z(context, g2);
        } catch (JSONException unused) {
        }
    }

    public static void c(Context context, int i2) {
        try {
            JSONArray j2 = j(context);
            int i3 = 0;
            while (true) {
                if (i3 >= j2.length()) {
                    break;
                } else if (j2.getInt(i3) == i2) {
                    j2.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            new z(context).M(i2);
            w(context, j2);
        } catch (JSONException unused) {
        }
    }

    public static void d(Context context, int i2) {
        try {
            JSONArray k2 = k(context);
            int i3 = 0;
            while (true) {
                if (i3 >= k2.length()) {
                    break;
                } else if (k2.getInt(i3) == i2) {
                    k2.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            new z(context).N(i2);
            x(context, k2);
        } catch (JSONException unused) {
        }
    }

    public static void e(Context context, int i2) {
        try {
            JSONArray m = m(context);
            int i3 = 0;
            while (true) {
                if (i3 >= m.length()) {
                    break;
                } else if (m.getInt(i3) == i2) {
                    m.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            new z(context).O(i2);
            z(context, m);
        } catch (JSONException unused) {
        }
    }

    public static void f(Context context) {
        if (j.H(context)) {
            g.a.a.a.b.e.f9814a.a(context, 670, null, true, new a(context));
        } else {
            E(context, false);
        }
    }

    public static JSONArray g(Context context) {
        try {
            return new JSONArray(j.s(context).getString("step_2_ids", "[]"));
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static boolean h(Context context) {
        return j.s(context).getBoolean("canDoSurveyRequestFlow", false);
    }

    public static JSONArray i(Context context, int i2) {
        SharedPreferences s = j.s(context);
        try {
            return new JSONArray(s.getString("step_" + i2 + "_contacts_ids", "[]"));
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static JSONArray j(Context context) {
        try {
            return new JSONArray(j.s(context).getString("step_6_env_ids", "[]"));
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static JSONArray k(Context context) {
        try {
            return new JSONArray(j.s(context).getString("step_3_places_ids", "[]"));
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static ArrayList<t> l(Context context) {
        ArrayList<t> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, h.f10099c));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new t(jSONObject.getString("title"), jSONObject.getString("display_title"), jSONObject.getString("content")));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static JSONArray m(Context context) {
        try {
            return new JSONArray(j.s(context).getString("step_1_ids", "[]"));
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static void n(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(j.s(activity).getString("surveyFlowData", "{}"));
            if (j.F(jSONObject, "lastDate")) {
                long j2 = jSONObject.getLong("lastDate");
                int i2 = jSONObject.getInt("sessions");
                int i3 = jSONObject.getInt("maybeTimes");
                if (i3 == 1) {
                    if (i2 >= 2) {
                        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j2) >= 1 && s(activity)) {
                            L(activity, true);
                        }
                    }
                } else if (i3 == 2 && i2 >= 6) {
                    if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j2) >= 7 && s(activity)) {
                        L(activity, false);
                    }
                }
            } else if (s(activity)) {
                L(activity, true);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean o(Context context) {
        return j.t(context, "sp_done", false);
    }

    public static boolean p(Context context, int i2) {
        return j.t(context, "sp_step" + i2, false);
    }

    public static boolean q(Context context, int i2, int i3) {
        return j.t(context, "sp_step" + i2 + "_variant_" + i3, false);
    }

    public static boolean r(Context context, int i2) {
        return j.t(context, "sp_step_seen" + i2, false);
    }

    public static boolean s(Context context) {
        return j.s(context).getBoolean("is_survey_enabled", false);
    }

    public static void t(Activity activity) {
        b.a aVar = new b.a();
        aVar.f(b.h.d.a.b(activity, R.color.colorPrimary));
        aVar.a();
        aVar.e(true);
        aVar.b().a(activity, Uri.parse(h.f10097a));
        n.g(activity, System.currentTimeMillis());
    }

    public static void u(Context context, JSONArray jSONArray) {
        j.u(context).putString("step_2_ids", jSONArray.toString()).apply();
    }

    public static void v(Context context, JSONArray jSONArray, int i2) {
        SharedPreferences.Editor u = j.u(context);
        u.putString("step_" + i2 + "_contacts_ids", jSONArray.toString()).apply();
    }

    public static void w(Context context, JSONArray jSONArray) {
        j.u(context).putString("step_6_env_ids", jSONArray.toString()).apply();
    }

    public static void x(Context context, JSONArray jSONArray) {
        j.u(context).putString("step_3_places_ids", jSONArray.toString()).apply();
    }

    public static void y(Context context) {
        j.u(context).putBoolean("sp_done", true).apply();
    }

    public static void z(Context context, JSONArray jSONArray) {
        j.u(context).putString("step_1_ids", jSONArray.toString()).apply();
    }
}
