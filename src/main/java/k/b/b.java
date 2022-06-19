package k.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: C_F_Tracking */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f10733a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f10734b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10735c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f10736d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10737e = false;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f10738f = false;

    /* renamed from: g  reason: collision with root package name */
    public static String f10739g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f10740h = "public";

    public static boolean a(int i2) {
        return i2 < 400 && i2 >= 200;
    }

    public static void b(String str, String str2) {
        Log.d("VAInstrum_" + str, str2);
    }

    public static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e3);
        }
    }

    public static String d() {
        StringBuilder sb = new StringBuilder(16);
        for (int i2 = 0; i2 < 10; i2++) {
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(new Random().nextInt(36)));
        }
        return c(sb.toString());
    }

    public static String e(Context context, ArrayList<k.c.b> arrayList) {
        JSONArray jSONArray = new JSONArray();
        try {
            ArrayList<k.c.b> o = o(context, arrayList);
            for (int i2 = 0; i2 < o.size(); i2++) {
                k.c.b bVar = o.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", bVar.a());
                String k2 = k(context);
                if (k2 != null) {
                    jSONObject.put("invite_code", k2);
                } else {
                    jSONObject.put("invite_code", BuildConfig.FLAVOR);
                }
                jSONObject.put("timestamp", bVar.h());
                if (bVar.e() != null) {
                    jSONObject.put("metadata", new JSONObject(bVar.e()));
                } else {
                    jSONObject.put("metadata", new JSONObject());
                }
                if (bVar.c() != null) {
                    jSONObject.put("filter_event", bVar.c());
                }
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }

    public static JSONObject f(Context context, String str) {
        String n = n(context, "tracking_buttons.json");
        if (n == null) {
            return null;
        }
        try {
            return new JSONObject(n).getJSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String g(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static SharedPreferences h(Context context) {
        if (context != null) {
            return context.getSharedPreferences("tracking_preferences", 0);
        }
        return null;
    }

    public static SharedPreferences.Editor i(Context context) {
        if (context != null) {
            return context.getSharedPreferences("tracking_preferences", 0).edit();
        }
        return null;
    }

    public static String j(Context context) {
        if (f10736d) {
            return "public";
        }
        return h(context).getString("subject_id", null);
    }

    public static String k(Context context) {
        if (!f10736d) {
            return h(context).getString("invite_code", null);
        }
        String string = h(context).getString("public_invite_code", null);
        if (string != null) {
            return string;
        }
        String d2 = d();
        i(context).putString("public_invite_code", d2).apply();
        return d2;
    }

    public static String l(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i2 = packageInfo.versionCode;
            sb.append(str);
            sb.append("(");
            sb.append(i2);
            sb.append(")");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean m(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static String n(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException | UnsupportedEncodingException unused) {
            return null;
        }
    }

    private static ArrayList<k.c.b> o(Context context, ArrayList<k.c.b> arrayList) {
        ArrayList<k.c.b> arrayList2 = new ArrayList<>();
        ArrayList<k.c.b> arrayList3 = new ArrayList<>();
        Iterator<k.c.b> it = arrayList.iterator();
        while (it.hasNext()) {
            k.c.b next = it.next();
            boolean z = true;
            Iterator<k.c.b> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                k.c.b next2 = it2.next();
                if (next.d() != next2.d() && next.a().equals(next2.a()) && next.e().equals(next2.e()) && next.h() == next2.h()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                arrayList2.add(next);
            } else {
                arrayList3.add(next);
            }
        }
        if (!arrayList3.isEmpty()) {
            new e(context).H(arrayList3);
        }
        return arrayList2;
    }

    public static String p(String str) {
        String[] split = str.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            sb.append((str2.substring(0, 1).toUpperCase() + str2.substring(1)) + " ");
        }
        return sb.toString().trim();
    }
}
