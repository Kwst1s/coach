package b.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.util.Map;

/* compiled from: ChangeBounds */
public class c extends m {
    private static final String[] N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> O = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> P = new C0061c(PointF.class, "topLeft");
    private static final Property<k, PointF> Q = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> R = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> S = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> T = new g(PointF.class, "position");
    private static k U = new k();
    private int[] K = new int[2];
    private boolean L = false;
    private boolean M = false;

    /* compiled from: ChangeBounds */
    class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2834b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f2835c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f2836d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f2837e;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.f2834b = viewGroup;
            this.f2835c = bitmapDrawable;
            this.f2836d = view;
            this.f2837e = f2;
        }

        public void onAnimationEnd(Animator animator) {
            c0.b(this.f2834b).d(this.f2835c);
            c0.g(this.f2836d, this.f2837e);
        }
    }

    /* compiled from: ChangeBounds */
    static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f2838a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2838a);
            Rect rect = this.f2838a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2838a);
            this.f2838a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2838a);
        }
    }

    /* renamed from: b.r.c$c  reason: collision with other inner class name */
    /* compiled from: ChangeBounds */
    static class C0061c extends Property<k, PointF> {
        C0061c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* compiled from: ChangeBounds */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds */
    class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f2839b;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.f2839b = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* compiled from: ChangeBounds */
    class i extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f2840b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2841c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Rect f2842d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f2843e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f2844f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f2845g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f2846h;

        i(c cVar, View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f2841c = view;
            this.f2842d = rect;
            this.f2843e = i2;
            this.f2844f = i3;
            this.f2845g = i4;
            this.f2846h = i5;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2840b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f2840b) {
                u.t0(this.f2841c, this.f2842d);
                c0.f(this.f2841c, this.f2843e, this.f2844f, this.f2845g, this.f2846h);
            }
        }
    }

    /* compiled from: ChangeBounds */
    class j extends n {

        /* renamed from: b  reason: collision with root package name */
        boolean f2847b = false;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2848c;

        j(c cVar, ViewGroup viewGroup) {
            this.f2848c = viewGroup;
        }

        @Override // b.r.m.f, b.r.n
        public void b(m mVar) {
            x.c(this.f2848c, false);
            this.f2847b = true;
        }

        @Override // b.r.m.f, b.r.n
        public void c(m mVar) {
            x.c(this.f2848c, false);
        }

        @Override // b.r.m.f, b.r.n
        public void d(m mVar) {
            x.c(this.f2848c, true);
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            if (!this.f2847b) {
                x.c(this.f2848c, false);
            }
            mVar.Q(this);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ChangeBounds */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f2849a;

        /* renamed from: b  reason: collision with root package name */
        private int f2850b;

        /* renamed from: c  reason: collision with root package name */
        private int f2851c;

        /* renamed from: d  reason: collision with root package name */
        private int f2852d;

        /* renamed from: e  reason: collision with root package name */
        private View f2853e;

        /* renamed from: f  reason: collision with root package name */
        private int f2854f;

        /* renamed from: g  reason: collision with root package name */
        private int f2855g;

        k(View view) {
            this.f2853e = view;
        }

        private void b() {
            c0.f(this.f2853e, this.f2849a, this.f2850b, this.f2851c, this.f2852d);
            this.f2854f = 0;
            this.f2855g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f2851c = Math.round(pointF.x);
            this.f2852d = Math.round(pointF.y);
            int i2 = this.f2855g + 1;
            this.f2855g = i2;
            if (this.f2854f == i2) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f2849a = Math.round(pointF.x);
            this.f2850b = Math.round(pointF.y);
            int i2 = this.f2854f + 1;
            this.f2854f = i2;
            if (i2 == this.f2855g) {
                b();
            }
        }
    }

    private void d0(s sVar) {
        View view = sVar.f2937b;
        if (u.S(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            sVar.f2936a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            sVar.f2936a.put("android:changeBounds:parent", sVar.f2937b.getParent());
            if (this.M) {
                sVar.f2937b.getLocationInWindow(this.K);
                sVar.f2936a.put("android:changeBounds:windowX", Integer.valueOf(this.K[0]));
                sVar.f2936a.put("android:changeBounds:windowY", Integer.valueOf(this.K[1]));
            }
            if (this.L) {
                sVar.f2936a.put("android:changeBounds:clip", u.u(view));
            }
        }
    }

    private boolean e0(View view, View view2) {
        if (!this.M) {
            return true;
        }
        s u = u(view, true);
        if (u == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == u.f2937b) {
            return true;
        }
        return false;
    }

    @Override // b.r.m
    public String[] E() {
        return N;
    }

    @Override // b.r.m
    public void g(s sVar) {
        d0(sVar);
    }

    @Override // b.r.m
    public void j(s sVar) {
        d0(sVar);
    }

    @Override // b.r.m
    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator2;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f2936a;
        Map<String, Object> map2 = sVar2.f2936a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f2937b;
        if (e0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.f2936a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.f2936a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) sVar.f2936a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar2.f2936a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.L) {
                view = view2;
                c0.f(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        animator = f.a(view, T, w().a((float) i4, (float) i6, (float) i5, (float) i7));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a2 = f.a(kVar, P, w().a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator a3 = f.a(kVar, Q, w().a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a2, a3);
                        animatorSet.addListener(new h(this, kVar));
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    animator = f.a(view, R, w().a((float) i8, (float) i10, (float) i9, (float) i11));
                } else {
                    animator = f.a(view, S, w().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
            } else {
                view = view2;
                c0.f(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = f.a(view, T, w().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (!rect.equals(rect6)) {
                    u.t0(view, rect);
                    k kVar2 = U;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", kVar2, objArr);
                    ofObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = r.c(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.c(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) sVar.f2936a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) sVar.f2936a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) sVar2.f2936a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) sVar2.f2936a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.K);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = c0.c(view2);
        c0.g(view2, Utils.FLOAT_EPSILON);
        c0.b(viewGroup).b(bitmapDrawable);
        g w = w();
        int[] iArr = this.K;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, i.a(O, w.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1]))));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c2));
        return ofPropertyValuesHolder;
    }
}
