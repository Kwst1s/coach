package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LifecycleDispatcher */
class f {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f1467a = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher */
    static class a extends b {
        a() {
        }

        @Override // androidx.lifecycle.b
        public void onActivityCreated(Activity activity, Bundle bundle) {
            r.g(activity);
        }

        @Override // androidx.lifecycle.b
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.b
        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Context context) {
        if (!f1467a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }
}
