package k.b;

import android.content.Context;
import com.google.gson.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NewTrackingManager */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static JSONArray f10744a = null;

    /* renamed from: b  reason: collision with root package name */
    private static JSONObject f10745b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10746c = "total_time_on_app";

    public static void a(String str) {
        try {
            if (f10744a == null) {
                f10744a = new JSONArray();
            }
            f10744a.put(new JSONObject().put("name", str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Map<String, Object> map) {
        if (f10744a == null) {
            f10744a = new JSONArray();
        }
        try {
            f10744a.put(new JSONObject(new g().b().l(map)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Map<String, Object> map) {
        try {
            f10745b = new JSONObject(new g().b().l(map));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d() {
        f10744a = new JSONArray();
        f10745b = null;
    }

    public static void e(String str) {
        c.o(str);
    }

    private static String f(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (i2 == 0 || !Character.isWhitespace(c2)) {
                sb.append(Character.toLowerCase(c2));
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    public static void g(Context context, String str, JSONArray jSONArray, int i2) {
        c.a(context, str, jSONArray, i2);
    }

    public static void h(Context context, String str) {
        c.b(context, str);
    }

    public static void i() {
        a("Back");
    }

    public static void j(Context context, String str) {
        try {
            JSONObject f2 = b.f(context, str);
            if (f2 != null) {
                a(f2.getString("name"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void k(String str) {
        a(str);
    }

    public static void l(Context context, String str, String str2, JSONObject jSONObject) {
        c.l(context, f(str).trim(), f(str2).trim(), jSONObject);
    }

    public static void m(Context context, boolean z, long j2) {
        c.r(context, z, j2);
    }

    public static void n(Context context, String str, String str2, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", str);
        if (str2 != null) {
            hashMap.put("parent_name", str2);
        }
        JSONArray jSONArray = f10744a;
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            hashMap.put("actions", f10744a);
        }
        JSONObject jSONObject = f10745b;
        if (jSONObject != null) {
            hashMap.put("results", jSONObject);
        }
        hashMap.put("time", Long.valueOf(j2));
        c.m(context, str, hashMap);
    }

    public static void o(Context context) {
        c.f(context);
    }

    public static void p(Context context) {
        c.g(context);
    }

    public static void q(Context context) {
        c.h(context);
    }

    public static void r(Context context, String str) {
        c.k(context, str);
        l(context, "learn", "view", null);
    }

    public static void s(Context context) {
        c.d(context);
    }

    public static void t(Context context) {
        c.p(context);
    }

    public static void u(Context context, String str) {
        c.t(context, str);
        l(context, "tools", "view", null);
    }

    public static void v(Context context, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", Long.valueOf(j2));
        c.m(context, f10746c, hashMap);
    }
}
