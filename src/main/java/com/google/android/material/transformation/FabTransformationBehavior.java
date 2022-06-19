package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.u;
import c.e.a.b.f;
import c.e.a.b.m.h;
import c.e.a.b.m.i;
import c.e.a.b.m.j;
import c.e.a.b.r.d;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f8107c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f8108d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f8109e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f8110f;

    /* renamed from: g  reason: collision with root package name */
    private float f8111g;

    /* renamed from: h  reason: collision with root package name */
    private float f8112h;

    class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8113b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f8114c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f8115d;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f8113b = z;
            this.f8114c = view;
            this.f8115d = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f8113b) {
                this.f8114c.setVisibility(4);
                this.f8115d.setAlpha(1.0f);
                this.f8115d.setVisibility(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f8113b) {
                this.f8114c.setVisibility(0);
                this.f8115d.setAlpha(Utils.FLOAT_EPSILON);
                this.f8115d.setVisibility(4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f8116b;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f8116b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8116b.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.e.a.b.r.d f8117b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Drawable f8118c;

        c(FabTransformationBehavior fabTransformationBehavior, c.e.a.b.r.d dVar, Drawable drawable) {
            this.f8117b = dVar;
            this.f8118c = drawable;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8117b.setCircularRevealOverlayDrawable(null);
        }

        public void onAnimationStart(Animator animator) {
            this.f8117b.setCircularRevealOverlayDrawable(this.f8118c);
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.e.a.b.r.d f8119b;

        d(FabTransformationBehavior fabTransformationBehavior, c.e.a.b.r.d dVar) {
            this.f8119b = dVar;
        }

        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f8119b.getRevealInfo();
            revealInfo.f3433c = Float.MAX_VALUE;
            this.f8119b.setRevealInfo(revealInfo);
        }
    }

    /* access modifiers changed from: protected */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public h f8120a;

        /* renamed from: b  reason: collision with root package name */
        public j f8121b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f8107c = new Rect();
        this.f8108d = new RectF();
        this.f8109e = new RectF();
        this.f8110f = new int[2];
    }

    private ViewGroup K(View view) {
        View findViewById = view.findViewById(f.mtrl_child_content_container);
        if (findViewById != null) {
            return f0(findViewById);
        }
        if ((view instanceof b) || (view instanceof a)) {
            return f0(((ViewGroup) view).getChildAt(0));
        }
        return f0(view);
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float S = S(eVar, iVar, f2, f4);
        float S2 = S(eVar, iVar2, f3, f5);
        Rect rect = this.f8107c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f8108d;
        rectF2.set(rect);
        RectF rectF3 = this.f8109e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f8111g, this.f8112h);
    }

    private Pair<i, i> N(float f2, float f3, boolean z, e eVar) {
        i iVar;
        i iVar2;
        if (f2 == Utils.FLOAT_EPSILON || f3 == Utils.FLOAT_EPSILON) {
            iVar2 = eVar.f8120a.e("translationXLinear");
            iVar = eVar.f8120a.e("translationYLinear");
        } else if ((!z || f3 >= Utils.FLOAT_EPSILON) && (z || f3 <= Utils.FLOAT_EPSILON)) {
            iVar2 = eVar.f8120a.e("translationXCurveDownwards");
            iVar = eVar.f8120a.e("translationYCurveDownwards");
        } else {
            iVar2 = eVar.f8120a.e("translationXCurveUpwards");
            iVar = eVar.f8120a.e("translationYCurveUpwards");
        }
        return new Pair<>(iVar2, iVar);
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f8108d;
        RectF rectF2 = this.f8109e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), Utils.FLOAT_EPSILON);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f8108d;
        RectF rectF2 = this.f8109e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(Utils.FLOAT_EPSILON, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f8108d;
        RectF rectF2 = this.f8109e;
        M(view, rectF);
        T(view2, rectF2);
        int i2 = jVar.f3395a & 7;
        if (i2 == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i2 == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i2 != 5) {
            f2 = Utils.FLOAT_EPSILON;
            return f2 + jVar.f3396b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f3396b;
    }

    private float R(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f8108d;
        RectF rectF2 = this.f8109e;
        M(view, rectF);
        T(view2, rectF2);
        int i2 = jVar.f3395a & 112;
        if (i2 == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i2 == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i2 != 80) {
            f2 = Utils.FLOAT_EPSILON;
            return f2 + jVar.f3397c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.f3397c;
    }

    private float S(e eVar, i iVar, float f2, float f3) {
        long c2 = iVar.c();
        long d2 = iVar.d();
        i e2 = eVar.f8120a.e("expansion");
        return c.e.a.b.m.a.a(f2, f3, iVar.e().getInterpolation(((float) (((e2.c() + e2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void T(View view, RectF rectF) {
        rectF.set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f8110f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void U(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup K;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof c.e.a.b.r.d) || c.e.a.b.r.c.f3426a != 0) && (K = K(view2)) != null) {
                if (z) {
                    if (!z2) {
                        c.e.a.b.m.d.f3381a.set(K, Float.valueOf((float) Utils.FLOAT_EPSILON));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(K, c.e.a.b.m.d.f3381a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(K, c.e.a.b.m.d.f3381a, 0.0f);
                }
                eVar.f8120a.e("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void V(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof c.e.a.b.r.d) {
            c.e.a.b.r.d dVar = (c.e.a.b.r.d) view2;
            int d0 = d0(view);
            int i2 = 16777215 & d0;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(d0);
                }
                objectAnimator = ObjectAnimator.ofInt(dVar, d.C0082d.f3430a, i2);
            } else {
                objectAnimator = ObjectAnimator.ofInt(dVar, d.C0082d.f3430a, d0);
            }
            objectAnimator.setEvaluator(c.e.a.b.m.c.b());
            eVar.f8120a.e("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void W(View view, View view2, boolean z, e eVar, List<Animator> list) {
        float Q = Q(view, view2, eVar.f8121b);
        float R = R(view, view2, eVar.f8121b);
        Pair<i, i> N = N(Q, R, z, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            Q = this.f8111g;
        }
        fArr[0] = Q;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            R = this.f8112h;
        }
        fArr2[0] = R;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void X(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float w = u.w(view2) - u.w(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-w);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -w);
        }
        eVar.f8120a.e("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    private void Y(View view, View view2, boolean z, boolean z2, e eVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof c.e.a.b.r.d) {
            c.e.a.b.r.d dVar = (c.e.a.b.r.d) view2;
            float O = O(view, view2, eVar.f8121b);
            float P = P(view, view2, eVar.f8121b);
            ((FloatingActionButton) view).i(this.f8107c);
            float width = ((float) this.f8107c.width()) / 2.0f;
            i e2 = eVar.f8120a.e("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.e(O, P, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f3433c;
                }
                animator = c.e.a.b.r.a.a(dVar, O, P, c.e.a.b.x.a.b(O, P, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, f2, f3));
                animator.addListener(new d(this, dVar));
                b0(view2, e2.c(), (int) O, (int) P, width, list);
            } else {
                float f4 = dVar.getRevealInfo().f3433c;
                Animator a2 = c.e.a.b.r.a.a(dVar, O, P, width);
                int i2 = (int) O;
                int i3 = (int) P;
                b0(view2, e2.c(), i2, i3, f4, list);
                a0(view2, e2.c(), e2.d(), eVar.f8120a.f(), i2, i3, width, list);
                animator = a2;
            }
            e2.a(animator);
            list.add(animator);
            list2.add(c.e.a.b.r.a.b(dVar));
        }
    }

    private void Z(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof c.e.a.b.r.d) && (view instanceof ImageView)) {
            c.e.a.b.r.d dVar = (c.e.a.b.r.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, c.e.a.b.m.e.f3382b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, c.e.a.b.m.e.f3382b, 255);
                }
                objectAnimator.addUpdateListener(new b(this, view2));
                eVar.f8120a.e("iconFade").a(objectAnimator);
                list.add(objectAnimator);
                list2.add(new c(this, dVar, drawable));
            }
        }
    }

    private void a0(View view, long j2, long j3, long j4, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void b0(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j2 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j2);
            list.add(createCircularReveal);
        }
    }

    private void c0(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float Q = Q(view, view2, eVar.f8121b);
        float R = R(view, view2, eVar.f8121b);
        Pair<i, i> N = N(Q, R, z, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -Q, -R, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -Q);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -R);
        }
        iVar.a(objectAnimator2);
        iVar2.a(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    private int d0(View view) {
        ColorStateList s = u.s(view);
        if (s != null) {
            return s.getColorForState(view.getDrawableState(), s.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        e e0 = e0(view2.getContext(), z);
        if (z) {
            this.f8111g = view.getTranslationX();
            this.f8112h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            X(view, view2, z, z2, e0, arrayList, arrayList2);
        }
        RectF rectF = this.f8108d;
        c0(view, view2, z, z2, e0, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z, e0, arrayList);
        Z(view, view2, z, z2, e0, arrayList, arrayList2);
        Y(view, view2, z, z2, e0, width, height, arrayList, arrayList2);
        V(view, view2, z, z2, e0, arrayList, arrayList2);
        U(view, view2, z, z2, e0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        c.e.a.b.m.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract e e0(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f1006h == 0) {
            fVar.f1006h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8107c = new Rect();
        this.f8108d = new RectF();
        this.f8109e = new RectF();
        this.f8110f = new int[2];
    }
}
