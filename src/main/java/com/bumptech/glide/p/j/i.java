package com.bumptech.glide.p.j;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.g;
import com.bumptech.glide.p.c;
import com.bumptech.glide.r.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* compiled from: ViewTarget */
public abstract class i<T extends View, Z> extends a<Z> {

    /* renamed from: g  reason: collision with root package name */
    private static int f4343g = g.glide_custom_view_target_tag;

    /* renamed from: b  reason: collision with root package name */
    protected final T f4344b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4345c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnAttachStateChangeListener f4346d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4347e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4348f;

    /* compiled from: ViewTarget */
    static final class a {

        /* renamed from: e  reason: collision with root package name */
        static Integer f4349e;

        /* renamed from: a  reason: collision with root package name */
        private final View f4350a;

        /* renamed from: b  reason: collision with root package name */
        private final List<g> f4351b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f4352c;

        /* renamed from: d  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0106a f4353d;

        /* access modifiers changed from: private */
        /* renamed from: com.bumptech.glide.p.j.i$a$a  reason: collision with other inner class name */
        /* compiled from: ViewTarget */
        public static final class ViewTreeObserver$OnPreDrawListenerC0106a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: b  reason: collision with root package name */
            private final WeakReference<a> f4354b;

            ViewTreeObserver$OnPreDrawListenerC0106a(a aVar) {
                this.f4354b = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f4354b.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f4350a = view;
        }

        private static int c(Context context) {
            if (f4349e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                j.d(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f4349e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f4349e.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f4352c && this.f4350a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f4350a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f4350a.getContext());
        }

        private int f() {
            int paddingTop = this.f4350a.getPaddingTop() + this.f4350a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f4350a.getLayoutParams();
            return e(this.f4350a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f4350a.getPaddingLeft() + this.f4350a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f4350a.getLayoutParams();
            return e(this.f4350a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean i(int i2, int i3) {
            return h(i2) && h(i3);
        }

        private void j(int i2, int i3) {
            Iterator it = new ArrayList(this.f4351b).iterator();
            while (it.hasNext()) {
                ((g) it.next()).h(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f4351b.isEmpty()) {
                int g2 = g();
                int f2 = f();
                if (i(g2, f2)) {
                    j(g2, f2);
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f4350a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f4353d);
            }
            this.f4353d = null;
            this.f4351b.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(g gVar) {
            int g2 = g();
            int f2 = f();
            if (i(g2, f2)) {
                gVar.h(g2, f2);
                return;
            }
            if (!this.f4351b.contains(gVar)) {
                this.f4351b.add(gVar);
            }
            if (this.f4353d == null) {
                ViewTreeObserver viewTreeObserver = this.f4350a.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0106a aVar = new ViewTreeObserver$OnPreDrawListenerC0106a(this);
                this.f4353d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(g gVar) {
            this.f4351b.remove(gVar);
        }
    }

    public i(T t) {
        j.d(t);
        this.f4344b = t;
        this.f4345c = new a(t);
    }

    private Object l() {
        return this.f4344b.getTag(f4343g);
    }

    private void m() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f4346d;
        if (onAttachStateChangeListener != null && !this.f4348f) {
            this.f4344b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f4348f = true;
        }
    }

    private void n() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f4346d;
        if (onAttachStateChangeListener != null && this.f4348f) {
            this.f4344b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f4348f = false;
        }
    }

    private void o(Object obj) {
        this.f4344b.setTag(f4343g, obj);
    }

    @Override // com.bumptech.glide.p.j.h
    public void b(g gVar) {
        this.f4345c.k(gVar);
    }

    @Override // com.bumptech.glide.p.j.h, com.bumptech.glide.p.j.a
    public void f(Drawable drawable) {
        super.f(drawable);
        m();
    }

    @Override // com.bumptech.glide.p.j.h
    public c g() {
        Object l = l();
        if (l == null) {
            return null;
        }
        if (l instanceof c) {
            return (c) l;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.p.j.h, com.bumptech.glide.p.j.a
    public void h(Drawable drawable) {
        super.h(drawable);
        this.f4345c.b();
        if (!this.f4347e) {
            n();
        }
    }

    @Override // com.bumptech.glide.p.j.h
    public void i(g gVar) {
        this.f4345c.d(gVar);
    }

    @Override // com.bumptech.glide.p.j.h
    public void j(c cVar) {
        o(cVar);
    }

    public String toString() {
        return "Target for: " + this.f4344b;
    }
}
