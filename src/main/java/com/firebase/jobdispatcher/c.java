package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.firebase.jobdispatcher.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultJobValidator */
public class c implements u {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4603a;

    public c(Context context) {
        this.f4603a = context;
    }

    private static List<String> b(List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return d(str);
        }
        Collections.addAll(list, str);
        return list;
    }

    private static List<String> c(boolean z, List<String> list, String str) {
        return z ? b(list, str) : list;
    }

    private static List<String> d(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }

    private static int e(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        int dataSize = obtain.dataSize();
        obtain.recycle();
        return dataSize;
    }

    private static List<String> f(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    private static String i(Bundle bundle, String str) {
        Object obj = bundle.get(str);
        Class<?> cls = null;
        if (obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        if (obj != null) {
            cls = obj.getClass();
        }
        objArr[0] = cls;
        objArr[1] = str;
        return String.format(locale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", objArr);
    }

    private static List<String> j(Bundle bundle) {
        List<String> list = null;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                list = b(list, i(bundle, str));
            }
        }
        return list;
    }

    private static List<String> k(Bundle bundle) {
        int e2;
        if (bundle != null && (e2 = e(bundle)) > 10240) {
            return d(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", Integer.valueOf(e2), 10240));
        }
        return null;
    }

    private static List<String> m(String str) {
        if (str == null) {
            return d("Tag can't be null");
        }
        if (str.length() > 100) {
            return d("Tag must be shorter than 100");
        }
        return null;
    }

    @Override // com.firebase.jobdispatcher.u
    public List<String> a(r rVar) {
        List<String> f2 = f(f(null, g(rVar.b())), h(rVar.f()));
        if (rVar.g() && rVar.b() == x.f4675a) {
            f2 = b(f2, "ImmediateTriggers can't be used with recurring jobs");
        }
        List<String> f3 = f(f2, k(rVar.d()));
        if (rVar.e() > 1) {
            f3 = f(f3, j(rVar.d()));
        }
        return f(f(f3, m(rVar.a())), l(rVar.i()));
    }

    public List<String> g(t tVar) {
        if (tVar == x.f4675a || (tVar instanceof t.b) || (tVar instanceof t.a)) {
            return null;
        }
        return d("Unknown trigger provided");
    }

    public List<String> h(w wVar) {
        int c2 = wVar.c();
        int a2 = wVar.a();
        int b2 = wVar.b();
        boolean z = false;
        List<String> c3 = c(300 > b2, c(b2 < a2, c((c2 == 1 || c2 == 2) ? false : true, null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)");
        if (a2 < 30) {
            z = true;
        }
        return c(z, c3, "Initial backoff must be at least 30s");
    }

    /* access modifiers changed from: package-private */
    public List<String> l(String str) {
        if (str == null || str.isEmpty()) {
            return d("Service can't be empty");
        }
        Context context = this.f4603a;
        if (context == null) {
            return d("Context is null, can't query PackageManager");
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return d("PackageManager is null, can't validate service");
        }
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f4603a, str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            Log.e("FJD.GooglePlayReceiver", "Couldn't find a registered service with the name " + str + ". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.");
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            if (serviceInfo != null && serviceInfo.enabled) {
                return null;
            }
        }
        return d(str + " is disabled.");
    }
}
