package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import b.h.k.c0;
import b.h.k.q;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ViewUtils */
public class k {

    /* compiled from: ViewUtils */
    static class a implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f7861a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f7862b;

        a(c cVar, d dVar) {
            this.f7861a = cVar;
            this.f7862b = dVar;
        }

        @Override // b.h.k.q
        public c0 a(View view, c0 c0Var) {
            this.f7861a.a(view, c0Var, new d(this.f7862b));
            return c0Var;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewUtils */
    public static class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            u.j0(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: ViewUtils */
    public interface c {
        c0 a(View view, c0 c0Var, d dVar);
    }

    public static void a(View view, c cVar) {
        u.z0(view, new a(cVar, new d(u.G(view), view.getPaddingTop(), u.F(view), view.getPaddingBottom())));
        f(view);
    }

    public static float b(Context context, int i2) {
        return TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static float c(View view) {
        float f2 = Utils.FLOAT_EPSILON;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += u.w((View) parent);
        }
        return f2;
    }

    public static boolean d(View view) {
        return u.B(view) == 1;
    }

    public static PorterDuff.Mode e(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void f(View view) {
        if (u.R(view)) {
            u.j0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    /* compiled from: ViewUtils */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f7863a;

        /* renamed from: b  reason: collision with root package name */
        public int f7864b;

        /* renamed from: c  reason: collision with root package name */
        public int f7865c;

        /* renamed from: d  reason: collision with root package name */
        public int f7866d;

        public d(int i2, int i3, int i4, int i5) {
            this.f7863a = i2;
            this.f7864b = i3;
            this.f7865c = i4;
            this.f7866d = i5;
        }

        public d(d dVar) {
            this.f7863a = dVar.f7863a;
            this.f7864b = dVar.f7864b;
            this.f7865c = dVar.f7865c;
            this.f7866d = dVar.f7866d;
        }
    }
}
