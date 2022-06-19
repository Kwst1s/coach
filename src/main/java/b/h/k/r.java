package b.h.k;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* compiled from: OneShotPreDrawListener */
public final class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final View f2668b;

    /* renamed from: c  reason: collision with root package name */
    private ViewTreeObserver f2669c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f2670d;

    private r(View view, Runnable runnable) {
        this.f2668b = view;
        this.f2669c = view.getViewTreeObserver();
        this.f2670d = runnable;
    }

    public static r a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        r rVar = new r(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    public void b() {
        if (this.f2669c.isAlive()) {
            this.f2669c.removeOnPreDrawListener(this);
        } else {
            this.f2668b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2668b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f2670d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2669c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
