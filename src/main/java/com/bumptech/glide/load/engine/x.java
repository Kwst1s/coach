package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* access modifiers changed from: package-private */
/* compiled from: ResourceRecycler */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3869a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3870b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler */
    private static final class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((u) message.obj).e();
            return true;
        }
    }

    x() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(u<?> uVar, boolean z) {
        if (!this.f3869a) {
            if (!z) {
                this.f3869a = true;
                uVar.e();
                this.f3869a = false;
            }
        }
        this.f3870b.obtainMessage(1, uVar).sendToTarget();
    }
}
