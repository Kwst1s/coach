package com.squareup.picasso;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: DeferredRequestCreator */
public class h implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final x f8694b;

    /* renamed from: c  reason: collision with root package name */
    final WeakReference<ImageView> f8695c;

    /* renamed from: d  reason: collision with root package name */
    e f8696d;

    h(x xVar, ImageView imageView, e eVar) {
        this.f8694b = xVar;
        this.f8695c = new WeakReference<>(imageView);
        this.f8696d = eVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f8694b.b();
        this.f8696d = null;
        ImageView imageView = this.f8695c.get();
        if (imageView != null) {
            this.f8695c.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = this.f8695c.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f8695c.clear();
            x xVar = this.f8694b;
            xVar.j();
            xVar.h(width, height);
            xVar.f(imageView, this.f8696d);
        }
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
