package k.b;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k.c.a;
import k.c.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Heartbeat */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f10741a;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f10742b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10743c;

    public static void a(Context context, String str, JSONArray jSONArray, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", String.format("assessment_%s", str).trim());
        hashMap.put("total_score", Integer.toString(i2));
        hashMap.put("answers", jSONArray);
        m(context, "assessment_end", hashMap);
    }

    public static void b(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", b.p(str).trim());
        m(context, "assessment_start", hashMap);
    }

    public static void c(String str) {
        b.f10739g = str;
    }

    public static void d(Context context) {
        b.i(context).putString("sessionID", Settings.Secure.getString(context.getContentResolver(), "android_id")).commit();
        m(context, "first_session_start", null);
        b.b("first_session_start", "first_session_start");
    }

    public static void e(Context context) {
        e eVar = new e(context);
        ArrayList<b> J = eVar.J();
        if (!J.isEmpty()) {
            eVar.O(J);
            new k.f.b(context, J).execute(new Void[0]);
        }
        ArrayList<a> I = eVar.I();
        if (!I.isEmpty()) {
            eVar.N(I);
            new k.f.a(context, I).execute(new Void[0]);
        }
    }

    public static void f(Context context) {
        m(context, "goal_added", new HashMap());
    }

    public static void g(Context context) {
        m(context, "goal_edited", new HashMap());
    }

    public static void h(Context context) {
        m(context, "goal_updated", new HashMap());
    }

    public static void i(String str, int i2, boolean z, String str2, String str3, boolean z2, String str4, String str5, String str6) {
        b.f10733a = str;
        b.f10734b = i2;
        b.f10736d = z;
        b.f10738f = z2;
        b.f10739g = str6;
        k.a.c.f10718e = str2;
        k.a.c.f10719f = str3;
        k.a.c.f10720g = str4;
        k.a.c.f10721h = str5;
        d.d();
        f10743c = null;
    }

    static /* synthetic */ void j(Context context) {
        e(context);
        f10741a.postDelayed(f10742b, TimeUnit.SECONDS.toMillis((long) b.f10734b));
    }

    public static void k(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", b.p(str).trim());
        m(context, "learn_end", hashMap);
    }

    public static void l(Context context, String str, String str2, JSONObject jSONObject) {
        if (b.f10737e) {
            new e(context).l(new a(str, str2, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), jSONObject));
        }
    }

    public static void m(Context context, String str, Map<String, Object> map) {
        JSONObject jSONObject;
        if (b.f10737e) {
            e eVar = new e(context);
            if (map != null) {
                jSONObject = new JSONObject(map);
            } else {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("lang", b.f10739g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            eVar.E(new b(str, jSONObject.toString(), "android", b.k(context), b.j(context), TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), f10743c));
        }
    }

    public static void n(boolean z) {
        b.f10737e = z;
    }

    public static void o(String str) {
        f10743c = str;
    }

    public static void p(Context context) {
        b.i(context).putString("sessionID", Settings.Secure.getString(context.getContentResolver(), "android_id")).commit();
        m(context, "session_start", null);
        b.b("session_start", "session_start");
    }

    public static void q(Context context) {
        b.f10735c = true;
        if (b.f10734b < 5) {
            b.f10734b = 5;
        }
        f10741a = new Handler();
        a aVar = new a(context);
        f10742b = aVar;
        aVar.run();
    }

    public static void r(Context context, boolean z, long j2) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("Audio Playing", Boolean.TRUE);
        }
        hashMap.put("session_time", Long.valueOf(j2));
        m(context, "session_end", hashMap);
        b.b("session_end", hashMap.toString());
    }

    public static void s(Context context) {
        f10741a.removeCallbacks(f10742b);
        e eVar = new e(context);
        ArrayList<b> J = eVar.J();
        if (!J.isEmpty()) {
            eVar.O(J);
            new k.f.b(context, J).execute(new Void[0]);
        }
        ArrayList<a> I = eVar.I();
        if (!I.isEmpty()) {
            eVar.N(I);
            new k.f.a(context, I).execute(new Void[0]);
        }
    }

    public static void t(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", b.p(str).trim());
        m(context, "tool_end", hashMap);
    }
}
