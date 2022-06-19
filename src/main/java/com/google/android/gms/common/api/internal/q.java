package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final /* synthetic */ class q implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f7252a;

    private q(Handler handler) {
        this.f7252a = handler;
    }

    static Executor a(Handler handler) {
        return new q(handler);
    }

    public final void execute(Runnable runnable) {
        this.f7252a.post(runnable);
    }
}
