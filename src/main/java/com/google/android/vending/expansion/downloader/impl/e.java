package com.google.android.vending.expansion.downloader.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Messenger;
import c.e.a.c.a.a.b;
import c.e.a.c.a.a.c;
import c.e.a.c.a.a.f;

/* compiled from: DownloadNotification */
public class e implements f {
    static final int n = -908767821;

    /* renamed from: b  reason: collision with root package name */
    private int f8166b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8167c;

    /* renamed from: d  reason: collision with root package name */
    private final NotificationManager f8168d;

    /* renamed from: e  reason: collision with root package name */
    private String f8169e;

    /* renamed from: f  reason: collision with root package name */
    private f f8170f;

    /* renamed from: g  reason: collision with root package name */
    final a f8171g;

    /* renamed from: h  reason: collision with root package name */
    private Notification f8172h;

    /* renamed from: i  reason: collision with root package name */
    private Notification f8173i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f8174j;

    /* renamed from: k  reason: collision with root package name */
    private String f8175k;
    private PendingIntent l;
    private b m;

    /* compiled from: DownloadNotification */
    public interface a {
        void a(long j2);

        void b(long j2);

        void c(PendingIntent pendingIntent);

        Notification d(Context context);

        void e(CharSequence charSequence);

        void f(long j2);

        void setIcon(int i2);

        void setTitle(CharSequence charSequence);
    }

    e(Context context, CharSequence charSequence) {
        this.f8167c = context;
        this.f8174j = charSequence;
        this.f8168d = (NotificationManager) context.getSystemService("notification");
        this.f8171g = c.a();
        Notification notification = new Notification();
        this.f8172h = notification;
        this.f8173i = notification;
    }

    public void a() {
        f fVar = this.f8170f;
        if (fVar != null) {
            fVar.w(this.f8166b);
        }
    }

    public void b(PendingIntent pendingIntent) {
        this.l = pendingIntent;
    }

    public void c(Messenger messenger) {
        f a2 = c.a(messenger);
        this.f8170f = a2;
        b bVar = this.m;
        if (bVar != null) {
            a2.u(bVar);
        }
        int i2 = this.f8166b;
        if (i2 != -1) {
            this.f8170f.w(i2);
        }
    }

    @Override // c.e.a.c.a.a.f
    public void n(Messenger messenger) {
    }

    @Override // c.e.a.c.a.a.f
    public void u(b bVar) {
        this.m = bVar;
        f fVar = this.f8170f;
        if (fVar != null) {
            fVar.u(bVar);
        }
        if (bVar.f3470b <= 0) {
            Notification notification = this.f8172h;
            notification.tickerText = this.f8169e;
            notification.icon = 17301633;
            notification.contentIntent = this.l;
            this.f8173i = notification;
        } else {
            this.f8171g.b(bVar.f3471c);
            this.f8171g.a(bVar.f3470b);
            this.f8171g.setIcon(17301633);
            this.f8171g.c(this.l);
            a aVar = this.f8171g;
            aVar.e(((Object) this.f8174j) + ": " + this.f8175k);
            this.f8171g.setTitle(this.f8174j);
            this.f8171g.f(bVar.f3472d);
            this.f8173i = this.f8171g.d(this.f8167c);
        }
        this.f8168d.notify(n, this.f8173i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0093  */
    @Override // c.e.a.c.a.a.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w(int r7) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.e.w(int):void");
    }
}
