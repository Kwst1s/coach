package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: ClearKeyUtil */
public final class h {
    public static byte[] a(byte[] bArr) {
        if (d0.f7006a >= 27) {
            return bArr;
        }
        return d0.K(c(d0.t(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (d0.f7006a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(d0.t(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return d0.K(sb.toString());
        } catch (JSONException e2) {
            m.d("ClearKeyUtil", "Failed to adjust response data: " + d0.t(bArr), e2);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
