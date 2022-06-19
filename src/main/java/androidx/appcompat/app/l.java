package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import b.h.d.d;
import java.util.Calendar;

/* access modifiers changed from: package-private */
/* compiled from: TwilightManager */
public class l {

    /* renamed from: d  reason: collision with root package name */
    private static l f244d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f245a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f246b;

    /* renamed from: c  reason: collision with root package name */
    private final a f247c = new a();

    /* access modifiers changed from: private */
    /* compiled from: TwilightManager */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f248a;

        /* renamed from: b  reason: collision with root package name */
        long f249b;

        /* renamed from: c  reason: collision with root package name */
        long f250c;

        /* renamed from: d  reason: collision with root package name */
        long f251d;

        /* renamed from: e  reason: collision with root package name */
        long f252e;

        /* renamed from: f  reason: collision with root package name */
        long f253f;

        a() {
        }
    }

    l(Context context, LocationManager locationManager) {
        this.f245a = context;
        this.f246b = locationManager;
    }

    static l a(Context context) {
        if (f244d == null) {
            Context applicationContext = context.getApplicationContext();
            f244d = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f244d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location c2 = d.b(this.f245a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (d.b(this.f245a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c2 == null) ? location != null ? location : c2 : location.getTime() > c2.getTime() ? location : c2;
    }

    private Location c(String str) {
        try {
            if (this.f246b.isProviderEnabled(str)) {
                return this.f246b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f247c.f253f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j2;
        a aVar = this.f247c;
        long currentTimeMillis = System.currentTimeMillis();
        k b2 = k.b();
        b2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = b2.f241a;
        b2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b2.f243c == 1;
        long j4 = b2.f242b;
        long j5 = b2.f241a;
        b2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = b2.f242b;
        if (j4 == -1 || j5 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            j2 = (currentTimeMillis > j5 ? 0 + j6 : currentTimeMillis > j4 ? 0 + j5 : 0 + j4) + 60000;
        }
        aVar.f248a = z;
        aVar.f249b = j3;
        aVar.f250c = j4;
        aVar.f251d = j5;
        aVar.f252e = j6;
        aVar.f253f = j2;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f247c;
        if (e()) {
            return aVar.f248a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return aVar.f248a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
