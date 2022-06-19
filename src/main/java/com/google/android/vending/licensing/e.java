package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.vending.licensing.ILicensingService;
import com.google.android.vending.licensing.d;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* compiled from: LicenseChecker */
public class e implements ServiceConnection {

    /* renamed from: j  reason: collision with root package name */
    private static final SecureRandom f8241j = new SecureRandom();

    /* renamed from: a  reason: collision with root package name */
    private ILicensingService f8242a;

    /* renamed from: b  reason: collision with root package name */
    private PublicKey f8243b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8244c;

    /* renamed from: d  reason: collision with root package name */
    private final j f8245d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f8246e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8247f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8248g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<g> f8249h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private final Queue<g> f8250i = new LinkedList();

    /* access modifiers changed from: private */
    /* compiled from: LicenseChecker */
    public class a extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private final g f8251a;

        /* renamed from: b  reason: collision with root package name */
        private Runnable f8252b;

        /* renamed from: com.google.android.vending.licensing.e$a$a  reason: collision with other inner class name */
        /* compiled from: LicenseChecker */
        class RunnableC0163a implements Runnable {
            RunnableC0163a(e eVar) {
            }

            public void run() {
                Log.i("LicenseChecker", "Check timed out.");
                a aVar = a.this;
                e.this.l(aVar.f8251a);
                a aVar2 = a.this;
                e.this.h(aVar2.f8251a);
            }
        }

        /* compiled from: LicenseChecker */
        class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f8255b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f8256c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f8257d;

            b(int i2, String str, String str2) {
                this.f8255b = i2;
                this.f8256c = str;
                this.f8257d = str2;
            }

            public void run() {
                Log.i("LicenseChecker", "Received response.");
                if (e.this.f8249h.contains(a.this.f8251a)) {
                    a.this.k();
                    a.this.f8251a.g(e.this.f8243b, this.f8255b, this.f8256c, this.f8257d);
                    a aVar = a.this;
                    e.this.h(aVar.f8251a);
                }
            }
        }

        public a(g gVar) {
            this.f8251a = gVar;
            this.f8252b = new RunnableC0163a(e.this);
            T();
        }

        private void T() {
            Log.i("LicenseChecker", "Start monitoring timeout.");
            e.this.f8246e.postDelayed(this.f8252b, 10000);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void k() {
            Log.i("LicenseChecker", "Clearing timeout.");
            e.this.f8246e.removeCallbacks(this.f8252b);
        }

        @Override // com.google.android.vending.licensing.d
        public void J(int i2, String str, String str2) {
            e.this.f8246e.post(new b(i2, str, str2));
        }
    }

    public e(Context context, j jVar, String str) {
        this.f8244c = context;
        this.f8245d = jVar;
        this.f8243b = j(str);
        String packageName = context.getPackageName();
        this.f8247f = packageName;
        this.f8248g = k(context, packageName);
        HandlerThread handlerThread = new HandlerThread("background thread");
        handlerThread.start();
        this.f8246e = new Handler(handlerThread.getLooper());
    }

    private void g() {
        if (this.f8242a != null) {
            try {
                this.f8244c.unbindService(this);
            } catch (IllegalArgumentException unused) {
                Log.e("LicenseChecker", "Unable to unbind from licensing service (already unbound)");
            }
            this.f8242a = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void h(g gVar) {
        this.f8249h.remove(gVar);
        if (this.f8249h.isEmpty()) {
            g();
        }
    }

    private int i() {
        return f8241j.nextInt();
    }

    private static PublicKey j(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.google.android.vending.licensing.util.a.a(str)));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (Base64DecoderException e3) {
            Log.e("LicenseChecker", "Could not decode from Base64.");
            throw new IllegalArgumentException(e3);
        } catch (InvalidKeySpecException e4) {
            Log.e("LicenseChecker", "Invalid key specification.");
            throw new IllegalArgumentException(e4);
        }
    }

    private static String k(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("LicenseChecker", "Package not found. could not get version code.");
            return BuildConfig.FLAVOR;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void l(g gVar) {
        this.f8245d.b(291, null);
        if (this.f8245d.a()) {
            gVar.a().a(291);
        } else {
            gVar.a().c(291);
        }
    }

    private void m() {
        while (true) {
            g poll = this.f8250i.poll();
            if (poll != null) {
                try {
                    Log.i("LicenseChecker", "Calling checkLicense on service for " + poll.c());
                    this.f8242a.K((long) poll.b(), poll.c(), new a(poll));
                    this.f8249h.add(poll);
                } catch (RemoteException e2) {
                    Log.w("LicenseChecker", "RemoteException in checkLicense call.", e2);
                    l(poll);
                }
            } else {
                return;
            }
        }
    }

    public synchronized void f(f fVar) {
        if (this.f8245d.a()) {
            Log.i("LicenseChecker", "Using cached license response");
            fVar.a(256);
        } else {
            g gVar = new g(this.f8245d, new h(), fVar, i(), this.f8247f, this.f8248g);
            if (this.f8242a == null) {
                Log.i("LicenseChecker", "Binding to licensing service.");
                try {
                    Intent intent = new Intent(new String(com.google.android.vending.licensing.util.a.a("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=")));
                    intent.setPackage("com.android.vending");
                    if (this.f8244c.bindService(intent, this, 1)) {
                        this.f8250i.offer(gVar);
                    } else {
                        Log.e("LicenseChecker", "Could not bind to service.");
                        l(gVar);
                    }
                } catch (SecurityException unused) {
                    fVar.b(6);
                } catch (Base64DecoderException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.f8250i.offer(gVar);
                m();
            }
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f8242a = ILicensingService.a.e(iBinder);
        m();
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        Log.w("LicenseChecker", "Service unexpectedly disconnected.");
        this.f8242a = null;
    }
}
