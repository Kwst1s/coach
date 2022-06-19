package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import com.firebase.jobdispatcher.t;

/* access modifiers changed from: package-private */
/* compiled from: GooglePlayJobWriter */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final p f4616a = new p("com.firebase.jobdispatcher.");

    i() {
    }

    private static int a(int i2) {
        int i3 = 2;
        if ((i2 & 2) == 2) {
            i3 = 0;
        }
        if ((i2 & 1) == 1) {
            return 1;
        }
        return i3;
    }

    private static int b(int i2) {
        return i2 != 2 ? 0 : 1;
    }

    private static void c(r rVar, Bundle bundle) {
        int a2 = a.a(rVar.c());
        boolean z = true;
        bundle.putBoolean("requiresCharging", (a2 & 4) == 4);
        if ((a2 & 8) != 8) {
            z = false;
        }
        bundle.putBoolean("requiresIdle", z);
        bundle.putInt("requiredNetwork", a(a2));
    }

    private static void d(Bundle bundle, t.a aVar) {
        bundle.putInt("trigger_type", 3);
        int size = aVar.a().size();
        int[] iArr = new int[size];
        Uri[] uriArr = new Uri[size];
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = aVar.a().get(i2);
            iArr[i2] = vVar.a();
            uriArr[i2] = vVar.b();
        }
        bundle.putIntArray("content_uri_flags_array", iArr);
        bundle.putParcelableArray("content_uri_array", uriArr);
    }

    private static void e(r rVar, Bundle bundle, t.b bVar) {
        bundle.putInt("trigger_type", 1);
        if (rVar.g()) {
            bundle.putLong("period", (long) bVar.a());
            bundle.putLong("period_flex", (long) (bVar.a() - bVar.b()));
            return;
        }
        bundle.putLong("window_start", (long) bVar.b());
        bundle.putLong("window_end", (long) bVar.a());
    }

    private static void f(Bundle bundle) {
        bundle.putInt("trigger_type", 2);
        bundle.putLong("window_start", 0);
        bundle.putLong("window_end", 1);
    }

    private static void g(r rVar, Bundle bundle) {
        w f2 = rVar.f();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", b(f2.c()));
        bundle2.putInt("initial_backoff_seconds", f2.a());
        bundle2.putInt("maximum_backoff_seconds", f2.b());
        bundle.putBundle("retryStrategy", bundle2);
    }

    private static void i(r rVar, Bundle bundle) {
        t b2 = rVar.b();
        if (b2 == x.f4675a) {
            f(bundle);
        } else if (b2 instanceof t.b) {
            e(rVar, bundle, (t.b) b2);
        } else if (b2 instanceof t.a) {
            d(bundle, (t.a) b2);
        } else {
            throw new IllegalArgumentException("Unknown trigger: " + b2.getClass());
        }
    }

    public Bundle h(r rVar, Bundle bundle) {
        bundle.putString("tag", rVar.a());
        bundle.putBoolean("update_current", rVar.h());
        bundle.putBoolean("persisted", rVar.e() == 2);
        bundle.putString("service", GooglePlayReceiver.class.getName());
        i(rVar, bundle);
        c(rVar, bundle);
        g(rVar, bundle);
        Bundle d2 = rVar.d();
        if (d2 == null) {
            d2 = new Bundle();
        }
        this.f4616a.g(rVar, d2);
        bundle.putBundle("extras", d2);
        return bundle;
    }
}
