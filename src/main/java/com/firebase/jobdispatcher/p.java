package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.jobdispatcher.q;
import com.firebase.jobdispatcher.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: JobCoder */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final String f4640a;

    p(String str) {
        this.f4640a = str;
    }

    private static List<v> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("uri_flags");
            JSONArray jSONArray2 = jSONObject.getJSONArray("uris");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(new v(Uri.parse(jSONArray2.getString(i2)), jSONArray.getInt(i2)));
            }
            return arrayList;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String b(List<v> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (v vVar : list) {
            jSONArray.put(vVar.a());
            jSONArray2.put(vVar.b());
        }
        try {
            jSONObject.put("uri_flags", jSONArray);
            jSONObject.put("uris", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private w e(Bundle bundle) {
        int i2 = bundle.getInt(this.f4640a + "retry_policy");
        if (i2 != 1 && i2 != 2) {
            return w.f4671d;
        }
        int i3 = bundle.getInt(this.f4640a + "initial_backoff_seconds");
        return new w(i2, i3, bundle.getInt(this.f4640a + "maximum_backoff_seconds"));
    }

    private t f(Bundle bundle) {
        int i2 = bundle.getInt(this.f4640a + "trigger_type");
        if (i2 == 1) {
            int i3 = bundle.getInt(this.f4640a + "window_start");
            return x.b(i3, bundle.getInt(this.f4640a + "window_end"));
        } else if (i2 == 2) {
            return x.f4675a;
        } else {
            if (i2 == 3) {
                return x.a(Collections.unmodifiableList(a(bundle.getString(this.f4640a + "observed_uris"))));
            } else if (!Log.isLoggable("FJD.ExternalReceiver", 3)) {
                return null;
            } else {
                Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
                return null;
            }
        }
    }

    private void h(w wVar, Bundle bundle) {
        if (wVar == null) {
            wVar = w.f4671d;
        }
        bundle.putInt(this.f4640a + "retry_policy", wVar.c());
        bundle.putInt(this.f4640a + "initial_backoff_seconds", wVar.a());
        bundle.putInt(this.f4640a + "maximum_backoff_seconds", wVar.b());
    }

    private void i(t tVar, Bundle bundle) {
        if (tVar == x.f4675a) {
            bundle.putInt(this.f4640a + "trigger_type", 2);
        } else if (tVar instanceof t.b) {
            t.b bVar = (t.b) tVar;
            bundle.putInt(this.f4640a + "trigger_type", 1);
            bundle.putInt(this.f4640a + "window_start", bVar.b());
            bundle.putInt(this.f4640a + "window_end", bVar.a());
        } else if (tVar instanceof t.a) {
            bundle.putInt(this.f4640a + "trigger_type", 3);
            String b2 = b(((t.a) tVar).a());
            bundle.putString(this.f4640a + "observed_uris", b2);
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
    }

    public q.b c(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            boolean z = bundle2.getBoolean(this.f4640a + "recurring");
            boolean z2 = bundle2.getBoolean(this.f4640a + "replace_current");
            int i2 = bundle2.getInt(this.f4640a + "persistent");
            int[] b2 = a.b(bundle2.getInt(this.f4640a + "constraints"));
            t f2 = f(bundle2);
            w e2 = e(bundle2);
            String string = bundle2.getString(this.f4640a + "tag");
            String string2 = bundle2.getString(this.f4640a + "service");
            if (string == null || string2 == null || f2 == null || e2 == null) {
                return null;
            }
            q.b bVar = new q.b();
            bVar.s(string);
            bVar.r(string2);
            bVar.t(f2);
            bVar.q(e2);
            bVar.o(z);
            bVar.n(i2);
            bVar.m(b2);
            bVar.p(z2);
            if (!TextUtils.isEmpty(this.f4640a)) {
                Iterator<String> it = bundle2.keySet().iterator();
                while (it.hasNext()) {
                    if (it.next().startsWith(this.f4640a)) {
                        it.remove();
                    }
                }
            }
            bVar.k(bundle2);
            return bVar;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }

    /* access modifiers changed from: package-private */
    public q d(Bundle bundle) {
        if (bundle == null) {
            Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
            return null;
        }
        Bundle bundle2 = bundle.getBundle("extras");
        if (bundle2 == null) {
            return null;
        }
        q.b c2 = c(bundle2);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("triggered_uris");
        if (parcelableArrayList != null) {
            c2.u(new y(parcelableArrayList));
        }
        return c2.l();
    }

    /* access modifiers changed from: package-private */
    public Bundle g(r rVar, Bundle bundle) {
        if (bundle != null) {
            Bundle d2 = rVar.d();
            if (d2 != null) {
                bundle.putAll(d2);
            }
            bundle.putInt(this.f4640a + "persistent", rVar.e());
            bundle.putBoolean(this.f4640a + "recurring", rVar.g());
            bundle.putBoolean(this.f4640a + "replace_current", rVar.h());
            bundle.putString(this.f4640a + "tag", rVar.a());
            bundle.putString(this.f4640a + "service", rVar.i());
            bundle.putInt(this.f4640a + "constraints", a.a(rVar.c()));
            i(rVar.b(), bundle);
            h(rVar.f(), bundle);
            return bundle;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }
}
