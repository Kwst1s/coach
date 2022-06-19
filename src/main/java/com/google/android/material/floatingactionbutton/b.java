package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import b.h.k.u;
import c.e.a.b.c0.n;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl */
public class b {
    static final TimeInterpolator F = c.e.a.b.m.a.f3377c;
    static final int[] G = {16842919, 16842910};
    static final int[] H = {16843623, 16842908, 16842910};
    static final int[] I = {16842908, 16842910};
    static final int[] J = {16843623, 16842910};
    static final int[] K = {16842910};
    static final int[] L = new int[0];
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();
    private ViewTreeObserver.OnPreDrawListener E;

    /* renamed from: a  reason: collision with root package name */
    c.e.a.b.c0.k f7780a;

    /* renamed from: b  reason: collision with root package name */
    c.e.a.b.c0.g f7781b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f7782c;

    /* renamed from: d  reason: collision with root package name */
    a f7783d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f7784e;

    /* renamed from: f  reason: collision with root package name */
    boolean f7785f;

    /* renamed from: g  reason: collision with root package name */
    boolean f7786g = true;

    /* renamed from: h  reason: collision with root package name */
    float f7787h;

    /* renamed from: i  reason: collision with root package name */
    float f7788i;

    /* renamed from: j  reason: collision with root package name */
    float f7789j;

    /* renamed from: k  reason: collision with root package name */
    int f7790k;
    private final com.google.android.material.internal.f l;
    private c.e.a.b.m.h m;
    private c.e.a.b.m.h n;
    private Animator o;
    private c.e.a.b.m.h p;
    private c.e.a.b.m.h q;
    private float r;
    private float s = 1.0f;
    private int t;
    private int u = 0;
    private ArrayList<Animator.AnimatorListener> v;
    private ArrayList<Animator.AnimatorListener> w;
    private ArrayList<i> x;
    final FloatingActionButton y;
    final c.e.a.b.b0.b z;

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7791b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f7792c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j f7793d;

        a(boolean z, j jVar) {
            this.f7792c = z;
            this.f7793d = jVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.f7791b = true;
        }

        public void onAnimationEnd(Animator animator) {
            b.this.u = 0;
            b.this.o = null;
            if (!this.f7791b) {
                FloatingActionButton floatingActionButton = b.this.y;
                boolean z = this.f7792c;
                floatingActionButton.b(z ? 8 : 4, z);
                j jVar = this.f7793d;
                if (jVar != null) {
                    jVar.b();
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            b.this.y.b(0, this.f7792c);
            b.this.u = 1;
            b.this.o = animator;
            this.f7791b = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.floatingactionbutton.b$b  reason: collision with other inner class name */
    /* compiled from: FloatingActionButtonImpl */
    public class C0154b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f7795b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f7796c;

        C0154b(boolean z, j jVar) {
            this.f7795b = z;
            this.f7796c = jVar;
        }

        public void onAnimationEnd(Animator animator) {
            b.this.u = 0;
            b.this.o = null;
            j jVar = this.f7796c;
            if (jVar != null) {
                jVar.a();
            }
        }

        public void onAnimationStart(Animator animator) {
            b.this.y.b(0, this.f7795b);
            b.this.u = 2;
            b.this.o = animator;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl */
    public class c extends c.e.a.b.m.g {
        c() {
        }

        @Override // c.e.a.b.m.g
        public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
            b.this.s = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl */
    public class d implements TypeEvaluator<Float> {

        /* renamed from: a  reason: collision with root package name */
        FloatEvaluator f7799a = new FloatEvaluator();

        d(b bVar) {
        }

        /* renamed from: a */
        public Float evaluate(float f2, Float f3, Float f4) {
            float floatValue = this.f7799a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (floatValue < 0.1f) {
                floatValue = Utils.FLOAT_EPSILON;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        public boolean onPreDraw() {
            b.this.H();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class f extends l {
        f(b bVar) {
            super(bVar, null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.material.floatingactionbutton.b.l
        public float a() {
            return Utils.FLOAT_EPSILON;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class g extends l {
        g() {
            super(b.this, null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.material.floatingactionbutton.b.l
        public float a() {
            b bVar = b.this;
            return bVar.f7787h + bVar.f7788i;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class h extends l {
        h() {
            super(b.this, null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.material.floatingactionbutton.b.l
        public float a() {
            b bVar = b.this;
            return bVar.f7787h + bVar.f7789j;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl */
    public interface i {
        void a();

        void b();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl */
    public interface j {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl */
    private class k extends l {
        k() {
            super(b.this, null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.material.floatingactionbutton.b.l
        public float a() {
            return b.this.f7787h;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7804b;

        /* renamed from: c  reason: collision with root package name */
        private float f7805c;

        /* renamed from: d  reason: collision with root package name */
        private float f7806d;

        private l() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            b.this.g0((float) ((int) this.f7806d));
            this.f7804b = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f7804b) {
                c.e.a.b.c0.g gVar = b.this.f7781b;
                this.f7805c = gVar == null ? Utils.FLOAT_EPSILON : gVar.w();
                this.f7806d = a();
                this.f7804b = true;
            }
            b bVar = b.this;
            float f2 = this.f7805c;
            bVar.g0((float) ((int) (f2 + ((this.f7806d - f2) * valueAnimator.getAnimatedFraction()))));
        }

        /* synthetic */ l(b bVar, a aVar) {
            this();
        }
    }

    b(FloatingActionButton floatingActionButton, c.e.a.b.b0.b bVar) {
        this.y = floatingActionButton;
        this.z = bVar;
        com.google.android.material.internal.f fVar = new com.google.android.material.internal.f();
        this.l = fVar;
        fVar.a(G, i(new h()));
        fVar.a(H, i(new g()));
        fVar.a(I, i(new g()));
        fVar.a(J, i(new g()));
        fVar.a(K, i(new k()));
        fVar.a(L, i(new f(this)));
        this.r = floatingActionButton.getRotation();
    }

    private boolean a0() {
        return u.S(this.y) && !this.y.isInEditMode();
    }

    private void g(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.y.getDrawable();
        if (drawable != null && this.t != 0) {
            RectF rectF = this.B;
            RectF rectF2 = this.C;
            rectF.set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.t;
            rectF2.set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.t;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    private AnimatorSet h(c.e.a.b.m.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, View.ALPHA, f2);
        hVar.e("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, View.SCALE_X, f3);
        hVar.e("scale").a(ofFloat2);
        h0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, View.SCALE_Y, f3);
        hVar.e("scale").a(ofFloat3);
        h0(ofFloat3);
        arrayList.add(ofFloat3);
        g(f4, this.D);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.y, new c.e.a.b.m.f(), new c(), new Matrix(this.D));
        hVar.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        c.e.a.b.m.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void h0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new d(this));
        }
    }

    private ValueAnimator i(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(Utils.FLOAT_EPSILON, 1.0f);
        return valueAnimator;
    }

    private c.e.a.b.m.h l() {
        if (this.n == null) {
            this.n = c.e.a.b.m.h.c(this.y.getContext(), c.e.a.b.a.design_fab_hide_motion_spec);
        }
        c.e.a.b.m.h hVar = this.n;
        b.h.j.h.c(hVar);
        return hVar;
    }

    private c.e.a.b.m.h m() {
        if (this.m == null) {
            this.m = c.e.a.b.m.h.c(this.y.getContext(), c.e.a.b.a.design_fab_show_motion_spec);
        }
        c.e.a.b.m.h hVar = this.m;
        b.h.j.h.c(hVar);
        return hVar;
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.l.c();
    }

    /* access modifiers changed from: package-private */
    public void B() {
        c.e.a.b.c0.g gVar = this.f7781b;
        if (gVar != null) {
            c.e.a.b.c0.h.f(this.y, gVar);
        }
        if (K()) {
            this.y.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    /* access modifiers changed from: package-private */
    public void C() {
    }

    /* access modifiers changed from: package-private */
    public void D() {
        ViewTreeObserver viewTreeObserver = this.y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void E(int[] iArr) {
        this.l.d(iArr);
    }

    /* access modifiers changed from: package-private */
    public void F(float f2, float f3, float f4) {
        f0();
        g0(f2);
    }

    /* access modifiers changed from: package-private */
    public void G(Rect rect) {
        b.h.j.h.d(this.f7784e, "Didn't initialize content background");
        if (Z()) {
            this.z.b(new InsetDrawable(this.f7784e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.z.b(this.f7784e);
    }

    /* access modifiers changed from: package-private */
    public void H() {
        float rotation = this.y.getRotation();
        if (this.r != rotation) {
            this.r = rotation;
            d0();
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void J() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        c.e.a.b.c0.g gVar = this.f7781b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        a aVar = this.f7783d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void M(PorterDuff.Mode mode) {
        c.e.a.b.c0.g gVar = this.f7781b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void N(float f2) {
        if (this.f7787h != f2) {
            this.f7787h = f2;
            F(f2, this.f7788i, this.f7789j);
        }
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z2) {
        this.f7785f = z2;
    }

    /* access modifiers changed from: package-private */
    public final void P(c.e.a.b.m.h hVar) {
        this.q = hVar;
    }

    /* access modifiers changed from: package-private */
    public final void Q(float f2) {
        if (this.f7788i != f2) {
            this.f7788i = f2;
            F(this.f7787h, f2, this.f7789j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void R(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        g(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void S(int i2) {
        if (this.t != i2) {
            this.t = i2;
            e0();
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int i2) {
        this.f7790k = i2;
    }

    /* access modifiers changed from: package-private */
    public final void U(float f2) {
        if (this.f7789j != f2) {
            this.f7789j = f2;
            F(this.f7787h, this.f7788i, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f7782c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, c.e.a.b.a0.b.d(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public void W(boolean z2) {
        this.f7786g = z2;
        f0();
    }

    /* access modifiers changed from: package-private */
    public final void X(c.e.a.b.c0.k kVar) {
        this.f7780a = kVar;
        c.e.a.b.c0.g gVar = this.f7781b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Drawable drawable = this.f7782c;
        if (drawable instanceof n) {
            ((n) drawable).setShapeAppearanceModel(kVar);
        }
        a aVar = this.f7783d;
        if (aVar != null) {
            aVar.f(kVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Y(c.e.a.b.m.h hVar) {
        this.p = hVar;
    }

    /* access modifiers changed from: package-private */
    public boolean Z() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean b0() {
        return !this.f7785f || this.y.getSizeDimension() >= this.f7790k;
    }

    /* access modifiers changed from: package-private */
    public void c0(j jVar, boolean z2) {
        if (!z()) {
            Animator animator = this.o;
            if (animator != null) {
                animator.cancel();
            }
            if (a0()) {
                if (this.y.getVisibility() != 0) {
                    this.y.setAlpha(Utils.FLOAT_EPSILON);
                    this.y.setScaleY(Utils.FLOAT_EPSILON);
                    this.y.setScaleX(Utils.FLOAT_EPSILON);
                    R(Utils.FLOAT_EPSILON);
                }
                c.e.a.b.m.h hVar = this.p;
                if (hVar == null) {
                    hVar = m();
                }
                AnimatorSet h2 = h(hVar, 1.0f, 1.0f, 1.0f);
                h2.addListener(new C0154b(z2, jVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.v;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        h2.addListener(it.next());
                    }
                }
                h2.start();
                return;
            }
            this.y.b(0, z2);
            this.y.setAlpha(1.0f);
            this.y.setScaleY(1.0f);
            this.y.setScaleX(1.0f);
            R(1.0f);
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.r % 90.0f != Utils.FLOAT_EPSILON) {
                if (this.y.getLayerType() != 1) {
                    this.y.setLayerType(1, null);
                }
            } else if (this.y.getLayerType() != 0) {
                this.y.setLayerType(0, null);
            }
        }
        c.e.a.b.c0.g gVar = this.f7781b;
        if (gVar != null) {
            gVar.c0((int) this.r);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Animator.AnimatorListener animatorListener) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public final void e0() {
        R(this.s);
    }

    /* access modifiers changed from: package-private */
    public void f(i iVar) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(iVar);
    }

    /* access modifiers changed from: package-private */
    public final void f0() {
        Rect rect = this.A;
        s(rect);
        G(rect);
        this.z.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void g0(float f2) {
        c.e.a.b.c0.g gVar = this.f7781b;
        if (gVar != null) {
            gVar.W(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public c.e.a.b.c0.g j() {
        c.e.a.b.c0.k kVar = this.f7780a;
        b.h.j.h.c(kVar);
        return new c.e.a.b.c0.g(kVar);
    }

    /* access modifiers changed from: package-private */
    public final Drawable k() {
        return this.f7784e;
    }

    /* access modifiers changed from: package-private */
    public float n() {
        return this.f7787h;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f7785f;
    }

    /* access modifiers changed from: package-private */
    public final c.e.a.b.m.h p() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public float q() {
        return this.f7788i;
    }

    /* access modifiers changed from: package-private */
    public void s(Rect rect) {
        int sizeDimension = this.f7785f ? (this.f7790k - this.y.getSizeDimension()) / 2 : 0;
        float n2 = this.f7786g ? n() + this.f7789j : Utils.FLOAT_EPSILON;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) n2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (n2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    /* access modifiers changed from: package-private */
    public float t() {
        return this.f7789j;
    }

    /* access modifiers changed from: package-private */
    public final c.e.a.b.c0.k u() {
        return this.f7780a;
    }

    /* access modifiers changed from: package-private */
    public final c.e.a.b.m.h v() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public void w(j jVar, boolean z2) {
        if (!y()) {
            Animator animator = this.o;
            if (animator != null) {
                animator.cancel();
            }
            if (a0()) {
                c.e.a.b.m.h hVar = this.q;
                if (hVar == null) {
                    hVar = l();
                }
                AnimatorSet h2 = h(hVar, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
                h2.addListener(new a(z2, jVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.w;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        h2.addListener(it.next());
                    }
                }
                h2.start();
                return;
            }
            this.y.b(z2 ? 8 : 4, z2);
            if (jVar != null) {
                jVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        c.e.a.b.c0.g j2 = j();
        this.f7781b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.f7781b.setTintMode(mode);
        }
        this.f7781b.b0(-12303292);
        this.f7781b.M(this.y.getContext());
        c.e.a.b.a0.a aVar = new c.e.a.b.a0.a(this.f7781b.C());
        aVar.setTintList(c.e.a.b.a0.b.d(colorStateList2));
        this.f7782c = aVar;
        c.e.a.b.c0.g gVar = this.f7781b;
        b.h.j.h.c(gVar);
        this.f7784e = new LayerDrawable(new Drawable[]{gVar, aVar});
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        if (this.y.getVisibility() == 0) {
            if (this.u == 1) {
                return true;
            }
            return false;
        } else if (this.u != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        if (this.y.getVisibility() != 0) {
            if (this.u == 2) {
                return true;
            }
            return false;
        } else if (this.u != 1) {
            return true;
        } else {
            return false;
        }
    }
}
