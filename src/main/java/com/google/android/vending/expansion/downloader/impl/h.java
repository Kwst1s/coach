package com.google.android.vending.expansion.downloader.impl;

import android.app.PendingIntent;
import com.google.android.vending.expansion.downloader.impl.e;

/* compiled from: V14CustomNotification */
public class h implements e.a {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f8213a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f8214b;

    /* renamed from: c  reason: collision with root package name */
    int f8215c;

    /* renamed from: d  reason: collision with root package name */
    long f8216d = -1;

    /* renamed from: e  reason: collision with root package name */
    long f8217e = -1;

    /* renamed from: f  reason: collision with root package name */
    long f8218f;

    /* renamed from: g  reason: collision with root package name */
    PendingIntent f8219g;

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void a(long j2) {
        this.f8216d = j2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void b(long j2) {
        this.f8217e = j2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void c(PendingIntent pendingIntent) {
        this.f8219g = pendingIntent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0051  */
    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Notification d(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.h.d(android.content.Context):android.app.Notification");
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void e(CharSequence charSequence) {
        this.f8214b = charSequence;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void f(long j2) {
        this.f8218f = j2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void setIcon(int i2) {
        this.f8215c = i2;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.e.a
    public void setTitle(CharSequence charSequence) {
        this.f8213a = charSequence;
    }
}
