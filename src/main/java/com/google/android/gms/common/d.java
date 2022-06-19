package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.core.app.h;
import c.e.a.a.a.b;
import c.e.a.a.b.a.e;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.util.f;
import com.google.android.gms.common.util.g;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class d extends e {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f7283d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final d f7284e = new d();

    /* renamed from: c  reason: collision with root package name */
    private String f7285c;

    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7286a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f7286a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int f2 = d.this.f(this.f7286a);
            if (d.this.h(f2)) {
                d.this.o(this.f7286a, f2);
            }
        }
    }

    public static d m() {
        return f7284e;
    }

    static Dialog p(Context context, int i2, u uVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(v.g(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String i3 = v.i(context, i2);
        if (i3 != null) {
            builder.setPositiveButton(i3, uVar);
        }
        String b2 = v.b(context, i2);
        if (b2 != null) {
            builder.setTitle(b2);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i2)), new IllegalArgumentException());
        return builder.create();
    }

    private final String q() {
        String str;
        synchronized (f7283d) {
            str = this.f7285c;
        }
        return str;
    }

    static void r(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof androidx.fragment.app.d) {
            j.V1(dialog, onCancelListener).U1(((androidx.fragment.app.d) activity).C(), str);
            return;
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void t(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i2), null), new IllegalArgumentException());
        if (i2 == 18) {
            s(context);
        } else if (pendingIntent != null) {
            String f2 = v.f(context, i2);
            String h2 = v.h(context, i2);
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            n.f(systemService);
            NotificationManager notificationManager = (NotificationManager) systemService;
            h.d dVar = new h.d(context);
            dVar.n(true);
            dVar.e(true);
            dVar.k(f2);
            h.b bVar = new h.b();
            bVar.h(h2);
            dVar.s(bVar);
            if (f.c(context)) {
                n.h(g.c());
                dVar.q(context.getApplicationInfo().icon);
                dVar.p(2);
                if (f.e(context)) {
                    dVar.a(c.e.a.a.a.a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    dVar.i(pendingIntent);
                }
            } else {
                dVar.q(17301642);
                dVar.t(resources.getString(b.common_google_play_services_notification_ticker));
                dVar.v(System.currentTimeMillis());
                dVar.i(pendingIntent);
                dVar.j(h2);
            }
            if (g.f()) {
                n.h(g.f());
                String q = q();
                if (q == null) {
                    q = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(q);
                    String a2 = v.a(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(q, a2, 4));
                    } else if (!a2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(a2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                dVar.f(q);
            }
            Notification b2 = dVar.b();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                g.f7291b.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, b2);
        } else if (i2 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    @Override // com.google.android.gms.common.e
    @RecentlyNullable
    public Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    @Override // com.google.android.gms.common.e
    @RecentlyNullable
    public PendingIntent b(@RecentlyNonNull Context context, int i2, int i3) {
        return super.b(context, i2, i3);
    }

    @Override // com.google.android.gms.common.e
    public final String d(int i2) {
        return super.d(i2);
    }

    @Override // com.google.android.gms.common.e
    public int f(@RecentlyNonNull Context context) {
        return super.f(context);
    }

    @Override // com.google.android.gms.common.e
    public int g(@RecentlyNonNull Context context, int i2) {
        return super.g(context, i2);
    }

    @Override // com.google.android.gms.common.e
    public final boolean h(int i2) {
        return super.h(i2);
    }

    @RecentlyNullable
    public Dialog k(@RecentlyNonNull Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i2, u.a(activity, a(activity, i2, "d"), i3), onCancelListener);
    }

    @RecentlyNullable
    public PendingIntent l(@RecentlyNonNull Context context, @RecentlyNonNull a aVar) {
        if (aVar.n()) {
            return aVar.m();
        }
        return b(context, aVar.k(), 0);
    }

    public boolean n(@RecentlyNonNull Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog k2 = k(activity, i2, i3, onCancelListener);
        if (k2 == null) {
            return false;
        }
        r(activity, k2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(@RecentlyNonNull Context context, int i2) {
        t(context, i2, null, c(context, i2, 0, "n"));
    }

    /* access modifiers changed from: package-private */
    public final void s(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean u(@RecentlyNonNull Context context, @RecentlyNonNull a aVar, int i2) {
        PendingIntent l = l(context, aVar);
        if (l == null) {
            return false;
        }
        t(context, aVar.k(), null, GoogleApiActivity.a(context, l, i2));
        return true;
    }
}
