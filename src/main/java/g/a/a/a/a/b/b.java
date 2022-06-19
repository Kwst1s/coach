package g.a.a.a.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import g.a.a.a.a.b.c;
import g.a.a.a.a.b.d;
import g.a.a.a.a.e;
import g.a.a.a.a.f.c;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import kotlin.TypeCastException;
import kotlin.m.b.f;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: MBAPIManager4.kt */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9742a = new a(null);

    /* compiled from: MBAPIManager4.kt */
    public static final class a {

        /* access modifiers changed from: package-private */
        /* renamed from: g.a.a.a.a.b.b$a$a  reason: collision with other inner class name */
        /* compiled from: MBAPIManager4.kt */
        public static final class C0222a implements HostnameVerifier {

            /* renamed from: a  reason: collision with root package name */
            public static final C0222a f9743a = new C0222a();

            C0222a() {
            }

            public final boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(c.u.t(), sSLSession);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g.a.a.a.a.b.b$a$b  reason: collision with other inner class name */
        /* compiled from: MBAPIManager4.kt */
        public static final class C0223b implements HostnameVerifier {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f9744a;

            C0223b(String str) {
                this.f9744a = str;
            }

            public final boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f9744a, sSLSession);
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: MBAPIManager4.kt */
        public static final class c implements HostnameVerifier {

            /* renamed from: a  reason: collision with root package name */
            public static final c f9745a = new c();

            c() {
            }

            public final boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(c.u.t(), sSLSession);
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: MBAPIManager4.kt */
        public static final class d implements HostnameVerifier {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f9746a;

            d(String str) {
                this.f9746a = str;
            }

            public final boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f9746a, sSLSession);
            }
        }

        private a() {
        }

        private final void a(Context context, ContentValues contentValues) {
            contentValues.put("device_id", Settings.Secure.getString(context.getContentResolver(), "android_id"));
            contentValues.put("os", "android");
        }

        public static /* synthetic */ Map c(a aVar, Context context, String str, ContentValues contentValues, int i2, boolean z, boolean z2, String str2, String str3, boolean z3, ContentValues contentValues2, String str4, int i3, Object obj) {
            return aVar.b(context, str, contentValues, i2, z, z2, (i3 & 64) != 0 ? c.u.k() : str2, (i3 & 128) != 0 ? c.u.s() : str3, (i3 & 256) != 0 ? false : z3, (i3 & 512) != 0 ? null : contentValues2, (i3 & 1024) != 0 ? null : str4);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
            kotlin.io.a.a(r2, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ad, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00be, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c5, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r2 = r1.getResponseCode();
            r1 = r1.getErrorStream();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f7, code lost:
            if (r1 != null) goto L_0x00f9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f9, code lost:
            r4 = new java.io.BufferedReader(new java.io.InputStreamReader(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            r1 = kotlin.io.b.c(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0107, code lost:
            kotlin.io.a.a(r4, null);
            r4 = new java.lang.StringBuilder(r1);
            r1 = new java.util.HashMap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r5 = g.a.a.a.a.b.d.f9758a;
            r5.d(r15, "ERROR" + ((java.lang.Object) r4));
            r4 = g.a.a.a.a.b.c.u;
            r1.put(r4.a(), r15.getString(g.a.a.a.e.internal_error));
            r1.put(r4.d(), java.lang.Integer.valueOf(r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0148, code lost:
            if (r2 == r4.r()) goto L_0x014a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x014a, code lost:
            r1.put(r4.d(), java.lang.Integer.valueOf(r4.r()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x015a, code lost:
            r1.put(r4.d(), java.lang.Integer.valueOf(r4.g()));
            r5.d(r15, "MBurger " + r0.getStackTrace().toString());
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x018b, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x018c, code lost:
            r12 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0191, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0192, code lost:
            kotlin.io.a.a(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0196, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0197, code lost:
            r1 = g.a.a.a.a.b.c.u;
            r12.put(r1.d(), java.lang.Integer.valueOf(r1.g()));
            g.a.a.a.a.b.d.f9758a.d(r15, r0.getStackTrace().toString());
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b9, code lost:
            r1 = g.a.a.a.a.b.c.u;
            r12.put(r1.d(), java.lang.Integer.valueOf(r1.g()));
            g.a.a.a.a.b.d.f9758a.d(r15, r0.getStackTrace().toString());
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x01db, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01dc, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x01e0, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
            return r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            return r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return r12;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0080 A[SYNTHETIC, Splitter:B:17:0x0080] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00be A[ExcHandler: NameNotFoundException (e android.content.pm.PackageManager$NameNotFoundException), Splitter:B:1:0x0009] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00c5 A[ExcHandler: JSONException (e org.json.JSONException), Splitter:B:1:0x0009] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ef A[SYNTHETIC, Splitter:B:48:0x00ef] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01b9  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01e0 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.Map<java.lang.String, java.lang.Object> d(android.content.Context r15, java.lang.String r16, android.content.ContentValues r17, java.lang.String r18, int r19, boolean r20, java.lang.String r21, java.lang.String r22, boolean r23, android.content.ContentValues r24) {
            /*
            // Method dump skipped, instructions count: 516
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.a.a.a.b.b.a.d(android.content.Context, java.lang.String, android.content.ContentValues, java.lang.String, int, boolean, java.lang.String, java.lang.String, boolean, android.content.ContentValues):java.util.Map");
        }

        private final void i(JSONObject jSONObject, Map<String, Object> map, int i2, boolean z) {
            if (i2 == 200) {
                c.a aVar = c.u;
                map.put(aVar.d(), Integer.valueOf(aVar.q()));
                if (z) {
                    map.put(aVar.b(), jSONObject.toString());
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("errors");
            StringBuilder sb = new StringBuilder();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                try {
                    sb.append(jSONObject2.getJSONArray(keys.next()).getString(0));
                    if (keys.hasNext()) {
                        sb.append("\n");
                    }
                } catch (JSONException unused) {
                }
            }
            c.a aVar2 = c.u;
            map.put(aVar2.d(), Integer.valueOf(i2));
            map.put(aVar2.a(), sb.toString());
        }

        public final Map<String, Object> b(Context context, String str, ContentValues contentValues, int i2, boolean z, boolean z2, String str2, String str3, boolean z3, ContentValues contentValues2, String str4) {
            f.f(context, "context");
            f.f(str, "api");
            f.f(contentValues, "data");
            f.f(str2, "endpoint");
            f.f(str3, "hostname");
            Map<String, Object> hashMap = new HashMap<>();
            g.a.a.a.a.c cVar = new g.a.a.a.a.c(context);
            d.a aVar = d.f9758a;
            if (aVar.i(context)) {
                g(context);
                hashMap = d(context, str, contentValues, str4, i2, z, str2, str3, z3, contentValues2);
                if (hashMap != null) {
                    if (z2 && z && aVar.g(hashMap, true)) {
                        String b2 = aVar.b(str, contentValues);
                        Object obj = hashMap.get(c.u.c());
                        if (obj != null) {
                            cVar.l(b2, (String) obj);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                } else if (!aVar.i(context)) {
                    if (hashMap != null) {
                        c.a aVar2 = c.u;
                        hashMap.put(aVar2.d(), Integer.valueOf(aVar2.g()));
                    }
                } else if (hashMap != null) {
                    c.a aVar3 = c.u;
                    hashMap.put(aVar3.d(), Integer.valueOf(aVar3.g()));
                }
            } else if (g.a.a.a.a.f.c.f9785f.b()) {
                a(context, contentValues);
                String b3 = aVar.b(str, contentValues);
                if (cVar.H(b3)) {
                    String G = cVar.G(b3);
                    if (G != null) {
                        try {
                            i(new JSONObject(new JSONTokener(G)), hashMap, 200, z);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        c.a aVar4 = c.u;
                        hashMap.put(aVar4.d(), Integer.valueOf(aVar4.i()));
                    }
                } else {
                    c.a aVar5 = c.u;
                    hashMap.put(aVar5.d(), Integer.valueOf(aVar5.i()));
                }
            } else {
                c.a aVar6 = c.u;
                hashMap.put(aVar6.d(), Integer.valueOf(aVar6.i()));
            }
            return hashMap;
        }

        public final HttpURLConnection e(Context context, String str, ContentValues contentValues, String str2, String str3, boolean z, ContentValues contentValues2) {
            URL url;
            HostnameVerifier hostnameVerifier;
            f.f(context, "context");
            f.f(str, "api");
            f.f(contentValues, "postData");
            f.f(str2, "endpoint");
            f.f(str3, "sHostname");
            a(context, contentValues);
            c.a aVar = g.a.a.a.a.f.c.f9785f;
            if (!aVar.d() || z) {
                URL url2 = new URL(str2 + str + d.f9758a.e(contentValues));
                hostnameVerifier = new C0223b(str3);
                url = url2;
            } else {
                url = new URL(c.u.l() + str + d.f9758a.e(contentValues));
                hostnameVerifier = C0222a.f9743a;
            }
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(false);
                httpsURLConnection.setRequestMethod("GET");
                if (contentValues2 == null) {
                    httpsURLConnection.setRequestProperty("X-MBurger-Token", aVar.a());
                } else {
                    for (Map.Entry<String, Object> entry : contentValues2.valueSet()) {
                        if (entry != null) {
                            Map.Entry<String, Object> entry2 = entry;
                            httpsURLConnection.setRequestProperty(entry2.getKey().toString(), entry2.getValue().toString());
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.util.Map.Entry<*, *>");
                        }
                    }
                }
                httpsURLConnection.setRequestProperty("X-MBurger-Version", "3");
                httpsURLConnection.setRequestProperty("Accept", "application/json");
                e.a aVar2 = e.f9766a;
                if (aVar2.e(context)) {
                    httpsURLConnection.setRequestProperty("Authorization", "Bearer " + aVar2.b(context));
                }
                return httpsURLConnection;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        }

        public final HttpURLConnection f(Context context, String str, ContentValues contentValues, String str2, String str3, String str4, String str5, boolean z, ContentValues contentValues2) {
            URL url;
            HostnameVerifier hostnameVerifier;
            f.f(context, "context");
            f.f(str, "api");
            f.f(contentValues, "postData");
            f.f(str3, "method");
            f.f(str4, "endpoint");
            f.f(str5, "sHostname");
            c.a aVar = g.a.a.a.a.f.c.f9785f;
            if (!aVar.d() || z) {
                URL url2 = new URL(str4 + str);
                hostnameVerifier = new d(str5);
                url = url2;
            } else {
                url = new URL(c.u.l() + str);
                hostnameVerifier = c.f9745a;
            }
            a(context, contentValues);
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                httpsURLConnection.setRequestMethod(str3);
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                if (contentValues2 == null) {
                    httpsURLConnection.setRequestProperty("X-MBurger-Token", aVar.a());
                } else {
                    for (Map.Entry<String, Object> entry : contentValues2.valueSet()) {
                        if (entry != null) {
                            Map.Entry<String, Object> entry2 = entry;
                            httpsURLConnection.setRequestProperty(entry2.getKey().toString(), entry2.getValue().toString());
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.util.Map.Entry<*, *>");
                        }
                    }
                }
                httpsURLConnection.setRequestProperty("X-MBurger-Version", "3");
                httpsURLConnection.setRequestProperty("Accept", "application/json");
                e.a aVar2 = e.f9766a;
                if (aVar2.e(context)) {
                    httpsURLConnection.setRequestProperty("Authorization", "Bearer " + aVar2.b(context));
                }
                if (str2 != null) {
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                }
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(false);
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
                if (str2 != null) {
                    dataOutputStream.writeBytes(str2);
                } else {
                    dataOutputStream.writeBytes(d.f9758a.f(contentValues));
                }
                dataOutputStream.flush();
                dataOutputStream.close();
                outputStream.close();
                return httpsURLConnection;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        }

        public final void g(Context context) {
            f.f(context, "mContext");
            try {
                c.e.a.a.c.a.a(context.getApplicationContext());
            } catch (GooglePlayServicesRepairableException e2) {
                e2.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e3) {
                e3.printStackTrace();
            }
        }

        public final Map<String, Object> h(Context context, HttpURLConnection httpURLConnection, StringBuilder sb, boolean z) {
            f.f(context, "context");
            f.f(httpURLConnection, "urlConnection");
            f.f(sb, "builder");
            HashMap hashMap = new HashMap();
            int responseCode = httpURLConnection.getResponseCode();
            d.a aVar = d.f9758a;
            aVar.d(context, "MBurger RESPONSE " + responseCode);
            aVar.d(context, "MBurger RESPONSE " + ((Object) sb));
            if (aVar.a(responseCode)) {
                String sb2 = sb.toString();
                f.b(sb2, "builder.toString()");
                int length = sb2.length() - 1;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    boolean z3 = sb2.charAt(!z2 ? i2 : length) <= ' ';
                    if (!z2) {
                        if (!z3) {
                            z2 = true;
                        } else {
                            i2++;
                        }
                    } else if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                }
                i(new JSONObject(new JSONTokener(sb2.subSequence(i2, length + 1).toString())), hashMap, responseCode, z);
            } else {
                hashMap.put(c.u.d(), Integer.valueOf(responseCode));
            }
            hashMap.put(c.u.c(), sb.toString());
            return hashMap;
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }
}
