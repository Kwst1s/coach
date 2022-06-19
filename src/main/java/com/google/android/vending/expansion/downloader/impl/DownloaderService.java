package com.google.android.vending.expansion.downloader.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import c.e.a.c.a.a.d;
import c.e.a.c.a.a.g;
import c.e.a.c.a.a.h;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.vending.licensing.e;
import com.google.android.vending.licensing.f;
import java.io.File;

public abstract class DownloaderService extends b implements g {
    private static boolean C;
    private PendingIntent A;
    private PendingIntent B;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8127f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8128g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8129h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8130i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8131j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8132k;
    private int l;
    private int m;
    private ConnectivityManager n;
    private WifiManager o;
    private PackageInfo p;
    long q;
    long r;
    long s;
    long t;
    float u;
    private BroadcastReceiver v;
    private final h w;
    private final Messenger x;
    private Messenger y;
    private e z;

    public static class GenerateSaveFileError extends Exception {

        /* renamed from: b  reason: collision with root package name */
        int f8133b;

        /* renamed from: c  reason: collision with root package name */
        String f8134c;

        public GenerateSaveFileError(int i2, String str) {
            this.f8133b = i2;
            this.f8134c = str;
        }
    }

    private class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final Service f8135a;

        a(Service service) {
            this.f8135a = service;
        }

        public void onReceive(Context context, Intent intent) {
            DownloaderService.this.E();
            if (DownloaderService.this.f8132k && !DownloaderService.z()) {
                Log.d("LVLDL", "InnerBroadcastReceiver Called");
                Intent intent2 = new Intent(context, this.f8135a.getClass());
                intent2.putExtra("EPI", DownloaderService.this.A);
                context.startService(intent2);
            }
        }
    }

    /* access modifiers changed from: private */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Context f8137b;

        class a implements f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.android.vending.licensing.b f8139a;

            a(com.google.android.vending.licensing.b bVar) {
                this.f8139a = bVar;
            }

            @Override // com.google.android.vending.licensing.f
            public void a(int i2) {
                int i3;
                try {
                    int g2 = this.f8139a.g();
                    g a2 = g.a(b.this.f8137b);
                    if (g2 != 0) {
                        i3 = 0;
                        for (int i4 = 0; i4 < g2; i4++) {
                            String d2 = this.f8139a.d(i4);
                            if (d2 != null) {
                                d dVar = new d(i4, d2, b.this.f8137b.getPackageName());
                                long e2 = this.f8139a.e(i4);
                                if (DownloaderService.this.x(a2, i4, d2, e2)) {
                                    i3 |= -1;
                                    dVar.a();
                                    dVar.f8155a = this.f8139a.f(i4);
                                    dVar.f8159e = e2;
                                    dVar.f8162h = i3;
                                    a2.j(dVar);
                                } else {
                                    d c2 = a2.c(dVar.f8157c);
                                    if (c2 == null) {
                                        Log.d("LVLDL", "file " + dVar.f8157c + " found. Not downloading.");
                                        dVar.f8162h = 200;
                                        dVar.f8159e = e2;
                                        dVar.f8160f = e2;
                                        dVar.f8155a = this.f8139a.f(i4);
                                        a2.j(dVar);
                                    } else if (c2.f8162h != 200) {
                                        c2.f8155a = this.f8139a.f(i4);
                                        a2.j(c2);
                                        i3 |= -1;
                                    }
                                }
                            }
                        }
                    } else {
                        i3 = 0;
                    }
                    try {
                        a2.o(b.this.f8137b.getPackageManager().getPackageInfo(b.this.f8137b.getPackageName(), 0).versionCode, i3);
                        Class<?> cls = DownloaderService.this.getClass();
                        b bVar = b.this;
                        int H = DownloaderService.H(bVar.f8137b, DownloaderService.this.A, cls);
                        if (H == 0) {
                            DownloaderService.this.z.w(5);
                        } else if (H == 1) {
                            Log.e("LVLDL", "In LVL checking loop!");
                            DownloaderService.this.z.w(15);
                            throw new RuntimeException("Error with LVL checking and database integrity");
                        }
                    } catch (PackageManager.NameNotFoundException e3) {
                        e3.printStackTrace();
                        throw new RuntimeException("Error with getting information from package name");
                    }
                } finally {
                    DownloaderService.G(false);
                }
            }

            @Override // com.google.android.vending.licensing.f
            public void b(int i2) {
                try {
                    DownloaderService.this.z.w(16);
                } finally {
                    DownloaderService.G(false);
                }
            }

            @Override // com.google.android.vending.licensing.f
            public void c(int i2) {
                if (i2 == 291) {
                    DownloaderService.this.z.w(16);
                } else if (i2 == 561) {
                    try {
                        DownloaderService.this.z.w(15);
                    } catch (Throwable th) {
                        DownloaderService.G(false);
                        throw th;
                    }
                }
                DownloaderService.G(false);
            }
        }

        b(Context context, PendingIntent pendingIntent) {
            this.f8137b = context;
            DownloaderService.this.A = pendingIntent;
        }

        public void run() {
            DownloaderService.G(true);
            DownloaderService.this.z.w(2);
            com.google.android.vending.licensing.b bVar = new com.google.android.vending.licensing.b(this.f8137b, new com.google.android.vending.licensing.a(DownloaderService.this.v(), this.f8137b.getPackageName(), Settings.Secure.getString(this.f8137b.getContentResolver(), "android_id")));
            bVar.h();
            new e(this.f8137b, bVar, DownloaderService.this.u()).f(new a(bVar));
        }
    }

    public DownloaderService() {
        super("LVLDownloadService");
        h b2 = d.b(this);
        this.w = b2;
        this.x = b2.b();
    }

    public static boolean A(int i2) {
        return (i2 >= 200 && i2 < 300) || (i2 >= 400 && i2 < 600);
    }

    public static boolean B(int i2) {
        return i2 >= 400 && i2 < 600;
    }

    private void F(long j2) {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("LVLDL", "couldn't get alarm manager");
            return;
        }
        String r2 = r();
        Intent intent = new Intent("android.intent.action.DOWNLOAD_WAKEUP");
        intent.putExtra("EPI", this.A);
        intent.setClassName(getPackageName(), r2);
        this.B = PendingIntent.getBroadcast(this, 0, intent, 1073741824);
        alarmManager.set(0, System.currentTimeMillis() + j2, this.B);
    }

    /* access modifiers changed from: private */
    public static synchronized void G(boolean z2) {
        synchronized (DownloaderService.class) {
            C = z2;
        }
    }

    public static int H(Context context, PendingIntent pendingIntent, Class<?> cls) {
        return I(context, pendingIntent, context.getPackageName(), cls.getName());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0039 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int I(android.content.Context r11, android.app.PendingIntent r12, java.lang.String r13, java.lang.String r14) {
        /*
            android.content.pm.PackageManager r0 = r11.getPackageManager()
            java.lang.String r1 = r11.getPackageName()
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)
            com.google.android.vending.expansion.downloader.impl.g r1 = com.google.android.vending.expansion.downloader.impl.g.a(r11)
            boolean r0 = y(r1, r0)
            int r3 = r1.f8207f
            r4 = 1
            r5 = 2
            if (r3 != 0) goto L_0x0034
            com.google.android.vending.expansion.downloader.impl.d[] r3 = r1.e()
            if (r3 == 0) goto L_0x0039
            int r6 = r3.length
        L_0x0022:
            if (r2 >= r6) goto L_0x0039
            r7 = r3[r2]
            java.lang.String r8 = r7.f8157c
            long r9 = r7.f8159e
            boolean r7 = c.e.a.c.a.a.e.a(r11, r8, r9, r4)
            if (r7 != 0) goto L_0x0036
            r0 = -1
            r1.q(r0)
        L_0x0034:
            r0 = 2
            goto L_0x0039
        L_0x0036:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0039:
            if (r0 == r4) goto L_0x003e
            if (r0 == r5) goto L_0x003e
            goto L_0x004e
        L_0x003e:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            r1.setClassName(r13, r14)
            java.lang.String r13 = "EPI"
            r1.putExtra(r13, r12)
            r11.startService(r1)
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.DownloaderService.I(android.content.Context, android.app.PendingIntent, java.lang.String, java.lang.String):int");
    }

    public static int J(Context context, Intent intent, Class<?> cls) {
        return H(context, (PendingIntent) intent.getParcelableExtra("EPI"), cls);
    }

    private void L(NetworkInfo networkInfo) {
        boolean z2 = this.f8127f;
        boolean z3 = this.f8128g;
        boolean z4 = this.f8129h;
        boolean z5 = this.f8130i;
        boolean z6 = this.f8131j;
        boolean z7 = false;
        if (networkInfo != null) {
            this.f8130i = networkInfo.isRoaming();
            this.f8128g = networkInfo.isFailover();
            this.f8127f = networkInfo.isConnected();
            M(networkInfo.getType(), networkInfo.getSubtype());
        } else {
            this.f8130i = false;
            this.f8128g = false;
            this.f8127f = false;
            M(-1, -1);
        }
        if (!(!this.f8132k && z2 == this.f8127f && z3 == this.f8128g && z4 == this.f8129h && z5 == this.f8130i && z6 == this.f8131j)) {
            z7 = true;
        }
        this.f8132k = z7;
    }

    private void M(int i2, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 6) {
                    this.f8129h = true;
                    this.f8131j = true;
                    return;
                } else if (!(i2 == 7 || i2 == 9)) {
                    return;
                }
            }
            this.f8129h = false;
            this.f8131j = false;
            return;
        }
        this.f8129h = true;
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                this.f8131j = false;
                return;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                this.f8131j = true;
                return;
            case 12:
            default:
                this.f8129h = false;
                this.f8131j = false;
                return;
            case 13:
            case 14:
            case 15:
                this.f8131j = true;
                return;
        }
    }

    private void o() {
        if (this.B != null) {
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            if (alarmManager == null) {
                Log.e("LVLDL", "couldn't get alarm manager");
                return;
            }
            alarmManager.cancel(this.B);
            this.B = null;
        }
    }

    private static boolean y(g gVar, PackageInfo packageInfo) {
        return gVar.f8206e != packageInfo.versionCode;
    }

    /* access modifiers changed from: private */
    public static synchronized boolean z() {
        boolean z2;
        synchronized (DownloaderService.class) {
            z2 = C;
        }
        return z2;
    }

    public boolean C() {
        return this.f8127f && !this.f8129h;
    }

    public void D(long j2) {
        long j3;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j4 = this.t;
        if (0 != j4) {
            float f2 = ((float) (j2 - this.s)) / ((float) (uptimeMillis - j4));
            float f3 = this.u;
            if (Utils.FLOAT_EPSILON != f3) {
                this.u = (f2 * 0.005f) + (f3 * 0.995f);
            } else {
                this.u = f2;
            }
            j3 = (long) (((float) (this.r - j2)) / this.u);
        } else {
            j3 = -1;
        }
        this.t = uptimeMillis;
        this.s = j2;
        this.z.u(new c.e.a.c.a.a.b(this.r, j2, j3, this.u));
    }

    /* access modifiers changed from: package-private */
    public void E() {
        if (this.n == null) {
            this.n = (ConnectivityManager) getSystemService("connectivity");
        }
        if (this.o == null) {
            this.o = (WifiManager) getSystemService("wifi");
        }
        ConnectivityManager connectivityManager = this.n;
        if (connectivityManager == null) {
            Log.w("LVLDL", "couldn't get connectivity manager to poll network state");
        } else {
            L(connectivityManager.getActiveNetworkInfo());
        }
    }

    public void K(Context context) {
        Context applicationContext = context.getApplicationContext();
        new Handler(applicationContext.getMainLooper()).post(new b(applicationContext, this.A));
    }

    @Override // c.e.a.c.a.a.g
    public void a() {
        this.z.a();
    }

    @Override // c.e.a.c.a.a.g
    public void b(Messenger messenger) {
        this.y = messenger;
        this.z.c(messenger);
    }

    @Override // c.e.a.c.a.a.g
    public void c(int i2) {
        g.a(this).m(i2);
    }

    @Override // c.e.a.c.a.a.g
    public void d() {
        this.l = 1;
        this.m = 490;
    }

    @Override // c.e.a.c.a.a.g
    public void e() {
        this.l = 1;
        this.m = 193;
    }

    @Override // c.e.a.c.a.a.g
    public void f() {
        if (this.l == 1) {
            this.l = 0;
        }
        Intent intent = new Intent(this, getClass());
        intent.putExtra("EPI", this.A);
        startService(intent);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.vending.expansion.downloader.impl.b
    public void g(Intent intent) {
        int i2;
        boolean z2 = true;
        G(true);
        try {
            g a2 = g.a(this);
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("EPI");
            if (pendingIntent != null) {
                this.z.b(pendingIntent);
                this.A = pendingIntent;
            } else {
                PendingIntent pendingIntent2 = this.A;
                if (pendingIntent2 != null) {
                    this.z.b(pendingIntent2);
                } else {
                    Log.e("LVLDL", "Downloader started in bad state without notification intent.");
                    G(false);
                    return;
                }
            }
            if (y(a2, this.p)) {
                K(this);
                return;
            }
            d[] e2 = a2.e();
            long j2 = 0;
            this.q = 0;
            this.r = 0;
            int length = e2.length;
            for (d dVar : e2) {
                if (dVar.f8162h == 200 && !c.e.a.c.a.a.e.a(this, dVar.f8157c, dVar.f8159e, true)) {
                    dVar.f8162h = 0;
                    dVar.f8160f = 0;
                }
                this.r += dVar.f8159e;
                this.q += dVar.f8160f;
            }
            E();
            if (this.v == null) {
                this.v = new a(this);
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                registerReceiver(this.v, intentFilter);
            }
            int length2 = e2.length;
            int i3 = 0;
            while (i3 < length2) {
                d dVar2 = e2[i3];
                long j3 = dVar2.f8160f;
                if (dVar2.f8162h != 200) {
                    f fVar = new f(dVar2, this, this.z);
                    o();
                    F(5000);
                    fVar.x();
                    o();
                }
                a2.n(dVar2);
                int i4 = dVar2.f8162h;
                if (i4 == 200) {
                    this.q += dVar2.f8160f - j3;
                    a2.o(this.p.versionCode, 0);
                    i3++;
                    j2 = 0;
                } else if (i4 != 403) {
                    if (i4 == 487) {
                        dVar2.f8160f = j2;
                        a2.j(dVar2);
                        i2 = 13;
                    } else if (i4 == 490) {
                        i2 = 18;
                    } else if (i4 == 498) {
                        i2 = 17;
                    } else if (i4 != 499) {
                        switch (i4) {
                            case 193:
                                z2 = false;
                                i2 = 7;
                                break;
                            case 194:
                            case 195:
                                i2 = 6;
                                break;
                            case 196:
                            case 197:
                                WifiManager wifiManager = this.o;
                                if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                                    i2 = 8;
                                    break;
                                } else {
                                    i2 = 9;
                                    break;
                                }
                                break;
                            default:
                                z2 = false;
                                i2 = 19;
                                break;
                        }
                    } else {
                        i2 = 14;
                    }
                    if (z2) {
                        F(60000);
                    } else {
                        o();
                    }
                    this.z.w(i2);
                    G(false);
                    return;
                } else {
                    K(this);
                    G(false);
                    return;
                }
            }
            this.z.w(5);
            G(false);
        } finally {
            G(false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.vending.expansion.downloader.impl.b
    public boolean h() {
        return g.a(this).f8207f == 0;
    }

    public IBinder onBind(Intent intent) {
        Log.d("LVLDL", "Service Bound");
        return this.x.getBinder();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.b
    public void onCreate() {
        super.onCreate();
        try {
            this.p = getPackageManager().getPackageInfo(getPackageName(), 0);
            this.z = new e(this, getPackageManager().getApplicationLabel(getApplicationInfo()));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.google.android.vending.expansion.downloader.impl.b
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.v;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.v = null;
        }
        this.w.c(this);
        super.onDestroy();
    }

    public String p(String str, long j2) {
        String q2 = q(str);
        File file = new File(q2);
        if (!c.e.a.c.a.a.e.k()) {
            Log.d("LVLDL", "External media not mounted: " + q2);
            throw new GenerateSaveFileError(499, "external media gov not yet mounted");
        } else if (file.exists()) {
            Log.d("LVLDL", "File already exists: " + q2);
            throw new GenerateSaveFileError(488, "requested destination file already exists");
        } else if (c.e.a.c.a.a.e.c(c.e.a.c.a.a.e.h(q2)) >= j2) {
            return q2;
        } else {
            throw new GenerateSaveFileError(498, "insufficient space on external storage");
        }
    }

    public String q(String str) {
        return c.e.a.c.a.a.e.i(this) + File.separator + str + ".tmp";
    }

    public abstract String r();

    public int s() {
        return this.l;
    }

    public int t(g gVar) {
        if (!this.f8127f) {
            return 2;
        }
        if (!this.f8129h) {
            return 1;
        }
        int i2 = gVar.f8208g;
        if (this.f8130i) {
            return 5;
        }
        if ((i2 & 1) != 0) {
            return 1;
        }
        return 6;
    }

    public abstract String u();

    public abstract byte[] v();

    public int w() {
        return this.m;
    }

    public boolean x(g gVar, int i2, String str, long j2) {
        String str2;
        d c2 = gVar.c(str);
        if (!(c2 == null || (str2 = c2.f8157c) == null)) {
            if (str.equals(str2)) {
                return false;
            }
            File file = new File(c.e.a.c.a.a.e.b(this, str2));
            if (file.exists()) {
                file.delete();
            }
        }
        return true ^ c.e.a.c.a.a.e.a(this, str, j2, true);
    }
}
