package com.google.android.vending.expansion.downloader.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: CustomIntentService */
public abstract class b extends Service {

    /* renamed from: b  reason: collision with root package name */
    private String f8150b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8151c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f8152d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Looper f8153e;

    /* access modifiers changed from: private */
    /* compiled from: CustomIntentService */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            b.this.g((Intent) message.obj);
            if (b.this.h()) {
                Log.d("CancellableIntentService", "stopSelf");
                b.this.stopSelf(message.arg1);
                Log.d("CancellableIntentService", "afterStopSelf");
            }
        }
    }

    public b(String str) {
        this.f8150b = str;
    }

    /* access modifiers changed from: protected */
    public abstract void g(Intent intent);

    /* access modifiers changed from: protected */
    public abstract boolean h();

    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("IntentService[" + this.f8150b + "]");
        handlerThread.start();
        this.f8153e = handlerThread.getLooper();
        this.f8152d = new a(this.f8153e);
    }

    public void onDestroy() {
        Thread thread = this.f8153e.getThread();
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        this.f8153e.quit();
        Log.d("CancellableIntentService", "onDestroy");
    }

    public void onStart(Intent intent, int i2) {
        if (!this.f8152d.hasMessages(-10)) {
            Message obtainMessage = this.f8152d.obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = intent;
            obtainMessage.what = -10;
            this.f8152d.sendMessage(obtainMessage);
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return this.f8151c ? 3 : 2;
    }
}
