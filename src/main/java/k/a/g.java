package k.a;

import android.content.ContentValues;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AMUtils */
public class g {
    public static String a(String str, ContentValues contentValues) {
        return str + d(contentValues);
    }

    public static e b(String str, ContentValues contentValues, int i2) {
        return new e(System.currentTimeMillis(), e(contentValues), i2, str);
    }

    public static f c(String str, ContentValues contentValues, int i2, String str2) {
        return new f(a(str, contentValues), System.currentTimeMillis(), i2, str, str2);
    }

    public static String d(ContentValues contentValues) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            sb.append(entry.getKey().toString());
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    public static String e(ContentValues contentValues) {
        try {
            Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Object> entry : valueSet) {
                String obj = entry.getKey().toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", obj);
                jSONObject.put("value", (String) entry.getValue());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String f(ContentValues contentValues) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String obj = next.getKey().toString();
            Object value = next.getValue();
            if (!(obj == null || value == null)) {
                sb.append(URLEncoder.encode(obj, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode((String) value, "UTF-8"));
                if (it.hasNext()) {
                    sb.append("&");
                }
            }
        }
        return sb.toString();
    }

    public static boolean g(Map<String, Object> map, boolean z) {
        if (map == null || !map.containsKey("result") || map.get("result") == null || ((Integer) map.get("result")).intValue() != 200 || map.containsKey("error")) {
            return false;
        }
        if (!z || map.containsKey("payload")) {
            return true;
        }
        return false;
    }
}
