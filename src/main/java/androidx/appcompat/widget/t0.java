package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import b.h.k.u;
import b.h.k.v;

/* access modifiers changed from: package-private */
/* compiled from: TooltipCompatHandler */
public class t0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k  reason: collision with root package name */
    private static t0 f779k;
    private static t0 l;

    /* renamed from: b  reason: collision with root package name */
    private final View f780b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f781c;

    /* renamed from: d  reason: collision with root package name */
    private final int f782d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f783e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f784f = new b();

    /* renamed from: g  reason: collision with root package name */
    private int f785g;

    /* renamed from: h  reason: collision with root package name */
    private int f786h;

    /* renamed from: i  reason: collision with root package name */
    private u0 f787i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f788j;

    /* compiled from: TooltipCompatHandler */
    class a implements Runnable {
        a() {
        }

        public void run() {
            t0.this.g(false);
        }
    }

    /* compiled from: TooltipCompatHandler */
    class b implements Runnable {
        b() {
        }

        public void run() {
            t0.this.c();
        }
    }

    private t0(View view, CharSequence charSequence) {
        this.f780b = view;
        this.f781c = charSequence;
        this.f782d = v.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f780b.removeCallbacks(this.f783e);
    }

    private void b() {
        this.f785g = Integer.MAX_VALUE;
        this.f786h = Integer.MAX_VALUE;
    }

    private void d() {
        this.f780b.postDelayed(this.f783e, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void e(t0 t0Var) {
        t0 t0Var2 = f779k;
        if (t0Var2 != null) {
            t0Var2.a();
        }
        f779k = t0Var;
        if (t0Var != null) {
            t0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        t0 t0Var = f779k;
        if (t0Var != null && t0Var.f780b == view) {
            e(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            t0 t0Var2 = l;
            if (t0Var2 != null && t0Var2.f780b == view) {
                t0Var2.c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new t0(view, charSequence);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f785g) <= this.f782d && Math.abs(y - this.f786h) <= this.f782d) {
            return false;
        }
        this.f785g = x;
        this.f786h = y;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (l == this) {
            l = null;
            u0 u0Var = this.f787i;
            if (u0Var != null) {
                u0Var.c();
                this.f787i = null;
                b();
                this.f780b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f779k == this) {
            e(null);
        }
        this.f780b.removeCallbacks(this.f784f);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z) {
        long j2;
        int i2;
        long j3;
        if (u.R(this.f780b)) {
            e(null);
            t0 t0Var = l;
            if (t0Var != null) {
                t0Var.c();
            }
            l = this;
            this.f788j = z;
            u0 u0Var = new u0(this.f780b.getContext());
            this.f787i = u0Var;
            u0Var.e(this.f780b, this.f785g, this.f786h, this.f788j, this.f781c);
            this.f780b.addOnAttachStateChangeListener(this);
            if (this.f788j) {
                j2 = 2500;
            } else {
                if ((u.L(this.f780b) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.f780b.removeCallbacks(this.f784f);
            this.f780b.postDelayed(this.f784f, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f787i != null && this.f788j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f780b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f780b.isEnabled() && this.f787i == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f785g = view.getWidth() / 2;
        this.f786h = view.getHeight() / 2;
        g(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
