package k.a;

import android.content.ContentValues;
import android.content.Context;
import c.e.a.a.c.a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import k.b.b;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: APIManager3 */
public class h {
    public static Map<String, Object> a(Context context, String str, ContentValues contentValues, int i2, boolean z, boolean z2, boolean z3, boolean z4, String str2) {
        Map<String, Object> hashMap = new HashMap<>();
        d dVar = new d(context);
        if (b.m(context)) {
            e(context);
            hashMap = b(context, str, contentValues, i2, z, z4, str2);
            if (hashMap != null) {
                if (z2 && z && g.g(hashMap, true)) {
                    dVar.E(g.c(str, contentValues, i2, (String) hashMap.get("payload")));
                }
            } else if (b.m(context)) {
                hashMap.put("result", -1003);
            } else if (z3) {
                dVar.l(g.b(str, contentValues, i2));
                hashMap.put("result", -2000);
            } else {
                hashMap.put("result", -1003);
            }
        } else if (z2) {
            String a2 = g.a(str, contentValues);
            if (dVar.J(a2)) {
                f H = dVar.H(a2);
                if (H != null) {
                    hashMap.put("result", 200);
                    hashMap.put("payload", H.d());
                } else {
                    hashMap.put("result", -1004);
                }
            } else {
                hashMap.put("result", -1004);
            }
        } else if (z3) {
            dVar.l(g.b(str, contentValues, i2));
            hashMap.put("result", -2000);
        } else {
            hashMap.put("result", -1004);
        }
        return hashMap;
    }

    private static Map<String, Object> b(Context context, String str, ContentValues contentValues, int i2, boolean z, boolean z2, String str2) {
        IOException e2;
        HashMap hashMap = new HashMap();
        HttpsURLConnection httpsURLConnection = null;
        if (i2 == -3) {
            httpsURLConnection = d(context, str, contentValues, "DELETE", z2, str2);
        } else if (i2 == -2) {
            httpsURLConnection = c(context, str, contentValues, z2, str2);
        } else if (i2 == -1) {
            try {
                httpsURLConnection = d(context, str, contentValues, "POST", z2, str2);
            } catch (SocketTimeoutException e3) {
                hashMap.put("result", -1001);
                e3.printStackTrace();
                return hashMap;
            } catch (IOException e4) {
                if (0 != 0) {
                    try {
                        int responseCode = httpsURLConnection.getResponseCode();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        }
                        HashMap hashMap2 = new HashMap();
                        try {
                            hashMap2.put("result", -1003);
                            if (responseCode == 401) {
                                hashMap2.put("result", 401);
                            } else {
                                hashMap2.put("result", -1003);
                                e4.printStackTrace();
                            }
                            return hashMap2;
                        } catch (IOException e5) {
                            e2 = e5;
                            hashMap = hashMap2;
                            e2.printStackTrace();
                            return hashMap;
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        e2.printStackTrace();
                        return hashMap;
                    }
                } else {
                    hashMap.put("result", -1003);
                    e4.printStackTrace();
                    return hashMap;
                }
            } catch (JSONException e7) {
                hashMap.put("result", -1003);
                e7.printStackTrace();
                return hashMap;
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine2 = bufferedReader2.readLine();
            if (readLine2 == null) {
                return h(httpsURLConnection, sb2, z, z2);
            }
            sb2.append(readLine2);
            sb2.append("\n");
        }
    }

    public static HttpsURLConnection c(Context context, String str, ContentValues contentValues, boolean z, String str2) {
        URL url;
        if (z) {
            url = new URL(c.f10718e + str);
        } else if (b.f10738f) {
            url = new URL(c.f10716c + str);
        } else {
            url = new URL(c.f10714a + str);
        }
        a aVar = new a(z);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setHostnameVerifier(aVar);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(false);
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setRequestProperty("Accept", "application/json");
        if (z) {
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        } else {
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        httpsURLConnection.setRequestProperty(c.f10720g, c.f10721h);
        return httpsURLConnection;
    }

    public static HttpsURLConnection d(Context context, String str, ContentValues contentValues, String str2, boolean z, String str3) {
        URL url;
        if (z) {
            url = new URL(c.f10718e + str);
        } else if (b.f10738f) {
            url = new URL(c.f10716c + str);
        } else {
            url = new URL(c.f10714a + str);
        }
        b bVar = new b(z);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod(str2);
        httpsURLConnection.setHostnameVerifier(bVar);
        httpsURLConnection.setRequestProperty("Accept", "application/json");
        if (z) {
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        } else {
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        httpsURLConnection.setRequestProperty(c.f10720g, c.f10721h);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(false);
        httpsURLConnection.setConnectTimeout(10000);
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        if (z) {
            dataOutputStream.writeBytes(str3);
        } else {
            dataOutputStream.writeBytes(g.f(contentValues));
        }
        dataOutputStream.flush();
        dataOutputStream.close();
        outputStream.close();
        return httpsURLConnection;
    }

    public static void e(Context context) {
        try {
            a.a(context.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e2) {
            e2.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e3) {
            e3.printStackTrace();
        }
    }

    static /* synthetic */ boolean f(boolean z, String str, SSLSession sSLSession) {
        HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        if (z) {
            return defaultHostnameVerifier.verify(c.f10719f, sSLSession);
        }
        if (b.f10738f) {
            return defaultHostnameVerifier.verify(c.f10717d, sSLSession);
        }
        return defaultHostnameVerifier.verify(c.f10715b, sSLSession);
    }

    static /* synthetic */ boolean g(boolean z, String str, SSLSession sSLSession) {
        HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        if (z) {
            return defaultHostnameVerifier.verify(c.f10719f, sSLSession);
        }
        if (b.f10738f) {
            return defaultHostnameVerifier.verify(c.f10717d, sSLSession);
        }
        return defaultHostnameVerifier.verify(c.f10715b, sSLSession);
    }

    public static Map<String, Object> h(HttpsURLConnection httpsURLConnection, StringBuilder sb, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        int responseCode = httpsURLConnection.getResponseCode();
        if (b.a(responseCode)) {
            JSONObject jSONObject = new JSONObject(new JSONTokener(sb.toString().trim()));
            if (z2) {
                int i2 = jSONObject.getInt("status_code");
                if (i2 == 0) {
                    hashMap.put("result", 200);
                } else {
                    String string = jSONObject.getJSONObject("response").getString("message_localized");
                    hashMap.put("result", Integer.valueOf(i2));
                    hashMap.put("error", string);
                }
            } else {
                int i3 = jSONObject.getJSONObject("response").getInt("status_code");
                if (i3 == 0) {
                    hashMap.put("result", 200);
                    if (z) {
                        hashMap.put("payload", jSONObject.getJSONObject("response").toString());
                    }
                } else {
                    String string2 = jSONObject.getJSONObject("response").getString("message_localized");
                    hashMap.put("result", Integer.valueOf(i3));
                    hashMap.put("error", string2);
                }
            }
        } else {
            hashMap.put("result", Integer.valueOf(responseCode));
        }
        return hashMap;
    }
}
