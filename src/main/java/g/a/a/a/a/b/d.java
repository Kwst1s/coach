package g.a.a.a.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import g.a.a.a.a.b.c;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.m.b.f;

/* compiled from: MBApiManagerUtils.kt */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9758a = new a(null);

    /* compiled from: MBApiManagerUtils.kt */
    public static final class a {
        private a() {
        }

        private final String c(ContentValues contentValues) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (entry != null) {
                    Map.Entry<String, Object> entry2 = entry;
                    String obj = entry2.getKey().toString();
                    Object value = entry2.getValue();
                    if (value != null) {
                        sb.append(obj);
                        sb.append((String) value);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Map.Entry<*, *>");
                }
            }
            String sb2 = sb.toString();
            f.b(sb2, "builder.toString()");
            return sb2;
        }

        public final boolean a(int i2) {
            return 200 <= i2 && 399 >= i2;
        }

        public final String b(String str, ContentValues contentValues) {
            f.f(str, "api");
            f.f(contentValues, "values");
            String str2 = str + c(contentValues);
            f.b(str2, "builder.toString()");
            return str2;
        }

        public final void d(Context context, String str) {
            f.f(context, "context");
            f.f(str, "log");
            if (h(context)) {
                Log.d("MBurgerSDK", str);
            }
        }

        public final String e(ContentValues contentValues) {
            f.f(contentValues, "values");
            StringBuilder sb = new StringBuilder("?");
            Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next != null) {
                    Map.Entry<String, Object> entry = next;
                    String obj = entry.getKey().toString();
                    Object value = entry.getValue();
                    sb.append(URLEncoder.encode(obj, "UTF-8"));
                    sb.append("=");
                    if (value != null) {
                        sb.append(URLEncoder.encode((String) value, "UTF-8"));
                        if (it.hasNext()) {
                            sb.append("&");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Map.Entry<*, *>");
                }
            }
            String sb2 = sb.toString();
            f.b(sb2, "result.toString()");
            return sb2;
        }

        public final String f(ContentValues contentValues) {
            f.f(contentValues, "values");
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next != null) {
                    Map.Entry<String, Object> entry = next;
                    String obj = entry.getKey().toString();
                    Object value = entry.getValue();
                    sb.append(URLEncoder.encode(obj, "UTF-8"));
                    sb.append("=");
                    if (value != null) {
                        sb.append(URLEncoder.encode((String) value, "UTF-8"));
                        if (it.hasNext()) {
                            sb.append("&");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Map.Entry<*, *>");
                }
            }
            String sb2 = sb.toString();
            f.b(sb2, "result.toString()");
            return sb2;
        }

        public final boolean g(Map<String, Object> map, boolean z) {
            if (map == null) {
                return false;
            }
            c.a aVar = c.u;
            if (!map.containsKey(aVar.d())) {
                return false;
            }
            Object obj = map.get(aVar.d());
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            } else if (((Integer) obj).intValue() != aVar.q() || map.containsKey(aVar.a())) {
                return false;
            } else {
                if (!z || map.containsKey(aVar.b())) {
                    return true;
                }
                return false;
            }
        }

        public final boolean h(Context context) {
            f.f(context, "context");
            return (context.getApplicationInfo().flags & 2) != 0;
        }

        public final boolean i(Context context) {
            f.f(context, "context");
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                return ((ConnectivityManager) systemService).getActiveNetworkInfo() != null;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }
}
