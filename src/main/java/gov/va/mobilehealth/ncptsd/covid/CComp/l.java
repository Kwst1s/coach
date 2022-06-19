package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import com.github.mikephil.charting.BuildConfig;
import java.io.File;
import kotlin.m.b.d;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: C_FKT_OtherAssessments.kt */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10128a = new a(null);

    /* compiled from: C_FKT_OtherAssessments.kt */
    public static final class a {
        private a() {
        }

        public final String a(Context context, int i2, int i3, int i4) {
            JSONArray jSONArray;
            f.e(context, "context");
            if (i4 == 119) {
                jSONArray = new JSONArray(j.N(context, g.f10084d + File.separator + "track_mood_questions.json")).getJSONObject(i2).getJSONArray("answers");
            } else if (i4 == 224) {
                jSONArray = new JSONArray(j.N(context, g.f10084d + File.separator + "well_being_questions.json")).getJSONObject(i2).getJSONArray("answers");
            } else if (i4 != 411) {
                jSONArray = null;
            } else {
                jSONArray = new JSONArray(j.N(context, g.f10084d + File.separator + "track_anxiety_questions.json")).getJSONObject(i2).getJSONArray("answers");
            }
            f.c(jSONArray);
            int length = jSONArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                if (i3 == jSONObject.getInt("points")) {
                    String string = jSONObject.getString("answer");
                    f.d(string, "jA.getString(\"answer\")");
                    return string;
                }
            }
            return BuildConfig.FLAVOR;
        }

        public final String b(Context context, int i2) {
            f.e(context, "context");
            JSONObject jSONObject = new JSONObject(j.N(context, g.f10084d + File.separator + "track_anxiety_results.json"));
            if (i2 < 10) {
                String string = jSONObject.getString("low");
                f.d(string, "jFeedback.getString(\"low\")");
                return string;
            }
            String string2 = jSONObject.getString("high");
            f.d(string2, "jFeedback.getString(\"high\")");
            return string2;
        }

        public final int c(int i2) {
            if (i2 == 119) {
                return 9;
            }
            if (i2 != 224) {
                return i2 != 411 ? 0 : 7;
            }
            return 14;
        }

        public final String d(Context context, int i2, int i3) {
            f.e(context, "context");
            JSONObject jSONObject = new JSONObject(j.N(context, g.f10084d + File.separator + "track_mood_results.json"));
            if (i3 == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("q9_0");
                if (i2 < 10) {
                    String string = jSONObject2.getString("low");
                    f.d(string, "q90Feedbacks.getString(\"low\")");
                    return string;
                }
                String string2 = jSONObject2.getString("medium");
                f.d(string2, "q90Feedbacks.getString(\"medium\")");
                return string2;
            }
            String string3 = jSONObject.getString("high");
            f.d(string3, "jFeedback.getString(\"high\")");
            return string3;
        }

        public final String e(Context context, int i2, int i3) {
            f.e(context, "context");
            if (i3 == 119) {
                String string = new JSONArray(j.N(context, g.f10084d + File.separator + "track_mood_questions.json")).getJSONObject(i2).getString("question");
                f.d(string, "jQuestions.getJSONObject…on).getString(\"question\")");
                return string;
            } else if (i3 == 224) {
                String string2 = new JSONArray(j.N(context, g.f10084d + File.separator + "well_being_questions.json")).getJSONObject(i2).getString("question");
                f.d(string2, "jQuestions.getJSONObject…on).getString(\"question\")");
                return string2;
            } else if (i3 != 411) {
                return "[]";
            } else {
                String string3 = new JSONArray(j.N(context, g.f10084d + File.separator + "track_anxiety_questions.json")).getJSONObject(i2).getString("question");
                f.d(string3, "jQuestions.getJSONObject…on).getString(\"question\")");
                return string3;
            }
        }

        public final String f(Context context, int i2) {
            String str;
            f.e(context, "context");
            JSONObject jSONObject = new JSONObject(j.N(context, g.f10084d + File.separator + "well_being_results.json"));
            if (i2 < 47) {
                String string = jSONObject.getString("low");
                f.d(string, "jFeedback.getString(\"low\")");
                return string;
            }
            if (47 <= i2 && 56 >= i2) {
                str = jSONObject.getString("medium");
            } else {
                str = jSONObject.getString("high");
            }
            f.d(str, "if (points in 47..56) {\n…\"high\")\n                }");
            return str;
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }
}
