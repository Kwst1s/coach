package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import k.b.d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: C_F_PTSD_SP_Tracking */
public class n {
    public static void a(Context context) {
        JSONObject b2 = b(context);
        try {
            if (j.F(b2, "exports_count")) {
                int i2 = b2.getInt("exports_count");
                b2.remove("exports_count");
                b2.put("exports_count", i2 + 1);
            } else {
                b2.put("exports_count", 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, b2);
        i(context);
    }

    private static JSONObject b(Context context) {
        String string = j.s(context).getString(h.f10098b, null);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new JSONObject();
    }

    private static void c(Context context, JSONObject jSONObject) {
        j.u(context).putString(h.f10098b, jSONObject.toString()).commit();
    }

    public static void d(Context context, int i2) {
        JSONObject b2 = b(context);
        try {
            if (!j.F(b2, "highest_step")) {
                b2.put("highest_step", i2);
            } else if (i2 > b2.getInt("highest_step")) {
                b2.put("highest_step", i2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, b2);
        i(context);
    }

    public static void e(Context context, long j2) {
        JSONObject b2 = b(context);
        try {
            if (!j.F(b2, "initial_timestamp")) {
                b2.put("initial_timestamp", TimeUnit.MILLISECONDS.toSeconds(j2));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, b2);
        i(context);
    }

    public static void f(Context context, int i2, long j2) {
        JSONObject b2 = b(context);
        String format = String.format("step%d_timestamp", Integer.valueOf(i2));
        try {
            if (j.F(b2, format)) {
                b2.remove(format);
                b2.put(format, TimeUnit.MILLISECONDS.toSeconds(j2));
            } else {
                b2.put(format, TimeUnit.MILLISECONDS.toSeconds(j2));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, b2);
        i(context);
    }

    public static void g(Context context, long j2) {
        JSONObject b2 = b(context);
        try {
            if (j.F(b2, "survey_timestamp")) {
                b2.remove("survey_timestamp");
                b2.put("survey_timestamp", TimeUnit.MILLISECONDS.toSeconds(j2));
            } else {
                b2.put("survey_timestamp", TimeUnit.MILLISECONDS.toSeconds(j2));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, b2);
        i(context);
    }

    public static void h(Context context, long j2) {
        JSONObject b2 = b(context);
        try {
            if (j.F(b2, "total_time")) {
                b2.remove("total_time");
                b2.put("total_time", b2.getLong("total_time") + j2);
            } else {
                b2.put("total_time", j2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, b2);
        i(context);
    }

    public static void i(Context context) {
        String str;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject b2 = b(context);
            if (j.F(b2, "highest_step")) {
                str = "safety_plan";
                jSONObject.put("highest_step", b2.getInt("highest_step"));
            } else {
                str = "safety_plan";
                jSONObject.put("highest_step", JSONObject.NULL);
            }
            if (j.F(b2, "total_time")) {
                str2 = "exports_count";
                jSONObject.put("total_time", b2.getLong("total_time"));
            } else {
                str2 = "exports_count";
                jSONObject.put("total_time", JSONObject.NULL);
            }
            if (j.F(b2, "safety_count")) {
                jSONObject.put("safety_count", b2.getInt("safety_count"));
            } else {
                jSONObject.put("safety_count", JSONObject.NULL);
            }
            if (j.F(b2, "initial_timestamp")) {
                jSONObject.put("initial_timestamp", b2.getLong("initial_timestamp"));
            } else {
                jSONObject.put("initial_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "highest_step")) {
                jSONObject.put("highest_step", b2.getInt("highest_step"));
            } else {
                jSONObject.put("highest_step", JSONObject.NULL);
            }
            if (j.F(b2, "step1_timestamp")) {
                jSONObject.put("step1_timestamp", b2.getLong("step1_timestamp"));
            } else {
                jSONObject.put("step1_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "step2_timestamp")) {
                jSONObject.put("step2_timestamp", b2.getLong("step2_timestamp"));
            } else {
                jSONObject.put("step2_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "step3_timestamp")) {
                jSONObject.put("step3_timestamp", b2.getLong("step3_timestamp"));
            } else {
                jSONObject.put("step3_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "step4_timestamp")) {
                jSONObject.put("step4_timestamp", b2.getLong("step4_timestamp"));
            } else {
                jSONObject.put("step4_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "step5_timestamp")) {
                jSONObject.put("step5_timestamp", b2.getLong("step5_timestamp"));
            } else {
                jSONObject.put("step5_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "step6_timestamp")) {
                jSONObject.put("step6_timestamp", b2.getLong("step6_timestamp"));
            } else {
                jSONObject.put("step6_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "survey_timestamp")) {
                jSONObject.put("survey_timestamp", b2.getLong("survey_timestamp"));
            } else {
                jSONObject.put("survey_timestamp", JSONObject.NULL);
            }
            if (j.F(b2, "crisis_count")) {
                jSONObject.put("crisis_count", b2.getInt("crisis_count"));
            } else {
                jSONObject.put("crisis_count", JSONObject.NULL);
            }
            if (j.F(b2, str2)) {
                jSONObject.put(str2, b2.getInt(str2));
            } else {
                jSONObject.put(str2, JSONObject.NULL);
            }
            d.l(context, str, str, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
