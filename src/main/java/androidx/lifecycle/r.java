package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.e;

/* compiled from: ReportFragment */
public class r extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private a f1492b;

    /* access modifiers changed from: package-private */
    /* compiled from: ReportFragment */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ReportFragment */
    public static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            r.a(activity, e.a.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            r.a(activity, e.a.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            r.a(activity, e.a.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            r.a(activity, e.a.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            r.a(activity, e.a.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            r.a(activity, e.a.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Activity activity, e.a aVar) {
        if (activity instanceof k) {
            ((k) activity).c().i(aVar);
        } else if (activity instanceof i) {
            e c2 = ((i) activity).c();
            if (c2 instanceof j) {
                ((j) c2).i(aVar);
            }
        }
    }

    private void b(e.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), aVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    private void e(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    static r f(Activity activity) {
        return (r) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(new b());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new r(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: package-private */
    public void h(a aVar) {
        this.f1492b = aVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.f1492b);
        b(e.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(e.a.ON_DESTROY);
        this.f1492b = null;
    }

    public void onPause() {
        super.onPause();
        b(e.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        d(this.f1492b);
        b(e.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        e(this.f1492b);
        b(e.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(e.a.ON_STOP);
    }
}
