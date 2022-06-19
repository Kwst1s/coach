package com.google.android.vending.expansion.downloader.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import com.github.mikephil.charting.R;
import com.google.android.vending.expansion.downloader.impl.e;

/* compiled from: V3CustomNotification */
public class i implements e.a {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f8220a;

    /* renamed from: b  reason: collision with root package name */
    int f8221b;

    /* renamed from: c  reason: collision with root package name */
    long f8222c = -1;

    /* renamed from: d  reason: collision with root package name */
    long f8223d = -1;

    /* renamed from: e  reason: collision with root package name */
    long f8224e;

    /* renamed from: f  reason: collision with root package name */
    PendingIntent f8225f;

    /* renamed from: g  reason: collision with root package name */
    Notification f8226g = new Notification();

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void a(long j2) {
        this.f8222c = j2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void b(long j2) {
        this.f8223d = j2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void c(PendingIntent pendingIntent) {
        this.f8225f = pendingIntent;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public Notification d(Context context) {
        Notification notification = this.f8226g;
        notification.icon = this.f8221b;
        int i2 = notification.flags | 2;
        notification.flags = i2;
        if (Build.VERSION.SDK_INT > 10) {
            notification.flags = i2 | 8;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.status_bar_ongoing_event_progress_bar);
        remoteViews.setTextViewText(R.id.title, this.f8220a);
        remoteViews.setViewVisibility(R.id.description, 0);
        remoteViews.setTextViewText(R.id.description, c.e.a.c.a.a.e.e(this.f8223d, this.f8222c));
        remoteViews.setViewVisibility(R.id.progress_bar_frame, 0);
        long j2 = this.f8222c;
        remoteViews.setProgressBar(R.id.progress_bar, (int) (j2 >> 8), (int) (this.f8223d >> 8), j2 <= 0);
        remoteViews.setViewVisibility(R.id.time_remaining, 0);
        remoteViews.setTextViewText(R.id.time_remaining, context.getString(R.string.time_remaining_notification, c.e.a.c.a.a.e.j(this.f8224e)));
        remoteViews.setTextViewText(R.id.progress_text, c.e.a.c.a.a.e.d(this.f8223d, this.f8222c));
        remoteViews.setImageViewResource(R.id.appIcon, this.f8221b);
        notification.contentView = remoteViews;
        notification.contentIntent = this.f8225f;
        return notification;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void e(CharSequence charSequence) {
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void f(long j2) {
        this.f8224e = j2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void setIcon(int i2) {
        this.f8221b = i2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void setTitle(CharSequence charSequence) {
        this.f8220a = charSequence;
    }
}
