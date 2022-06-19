package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import androidx.lifecycle.q;
import b.p.a;
import b.p.b;
import com.github.mikephil.charting.BuildConfig;
import g.a.a.a.d;
import k.b.c;

public class App extends b {

    /* renamed from: b  reason: collision with root package name */
    private String f10049b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10050c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10051d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f10052e = -1;

    public String a() {
        return this.f10049b;
    }

    /* access modifiers changed from: protected */
    @Override // b.p.b
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.l(this);
    }

    public long b() {
        return this.f10052e;
    }

    public boolean c() {
        return this.f10050c;
    }

    public boolean d() {
        return this.f10051d;
    }

    public void e(String str) {
        this.f10049b = str.replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim();
    }

    public void f(boolean z) {
        this.f10050c = z;
    }

    public void g(boolean z) {
        this.f10051d = z;
    }

    public void h(long j2) {
        this.f10052e = j2;
    }

    public void onCreate() {
        String str;
        super.onCreate();
        String a2 = b0.a(getApplicationContext());
        if (a2.equals("en") || a2.equals("es")) {
            str = a2;
        } else {
            str = "en";
        }
        q.k().c().a(new AppLifecycleListener(getApplicationContext()));
        d.f9822a.b(getApplicationContext(), "1d2a9f24d287ce3a76711639dd855f75d0da8a89", false, null, false);
        c.i("7", 6, true, "https://ptsd.vertical.mumbleserver.it/", "ptsd.va.mumbleserver.it", false, "X-PTSD-Token", "4d742eb11f3bc4f5636505f218f127684551029e", str);
    }
}
