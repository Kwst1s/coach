package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.s0;
import androidx.viewpager.widget.ViewPager;
import b.h.k.d0.c;
import b.h.k.s;
import b.h.k.u;
import c.e.a.b.k;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.e
public class TabLayout extends HorizontalScrollView {
    private static final int P = k.Widget_Design_TabLayout;
    private static final b.h.j.e<g> Q = new b.h.j.g(16);
    int A;
    boolean B;
    boolean C;
    boolean D;
    private c E;
    private final ArrayList<c> F;
    private c G;
    private ValueAnimator H;
    ViewPager I;
    private androidx.viewpager.widget.a J;
    private DataSetObserver K;
    private h L;
    private b M;
    private boolean N;
    private final b.h.j.e<i> O;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<g> f7926b;

    /* renamed from: c  reason: collision with root package name */
    private g f7927c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f7928d;

    /* renamed from: e  reason: collision with root package name */
    final f f7929e;

    /* renamed from: f  reason: collision with root package name */
    int f7930f;

    /* renamed from: g  reason: collision with root package name */
    int f7931g;

    /* renamed from: h  reason: collision with root package name */
    int f7932h;

    /* renamed from: i  reason: collision with root package name */
    int f7933i;

    /* renamed from: j  reason: collision with root package name */
    int f7934j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f7935k;
    ColorStateList l;
    ColorStateList m;
    Drawable n;
    PorterDuff.Mode o;
    float p;
    float q;
    final int r;
    int s;
    private final int t;
    private final int u;
    private final int v;
    private int w;
    int x;
    int y;
    int z;

    /* access modifiers changed from: package-private */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* access modifiers changed from: private */
    public class b implements ViewPager.i {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7937b;

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f7937b = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void d(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.I == viewPager) {
                tabLayout.F(aVar2, this.f7937b);
            }
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface d extends c<g> {
    }

    /* access modifiers changed from: private */
    public class e extends DataSetObserver {
        e() {
        }

        public void onChanged() {
            TabLayout.this.y();
        }

        public void onInvalidated() {
            TabLayout.this.y();
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private int f7940b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f7941c;

        /* renamed from: d  reason: collision with root package name */
        private final GradientDrawable f7942d;

        /* renamed from: e  reason: collision with root package name */
        int f7943e = -1;

        /* renamed from: f  reason: collision with root package name */
        float f7944f;

        /* renamed from: g  reason: collision with root package name */
        private int f7945g = -1;

        /* renamed from: h  reason: collision with root package name */
        int f7946h = -1;

        /* renamed from: i  reason: collision with root package name */
        int f7947i = -1;

        /* renamed from: j  reason: collision with root package name */
        ValueAnimator f7948j;

        /* renamed from: k  reason: collision with root package name */
        private int f7949k = -1;
        private int l = -1;

        /* access modifiers changed from: package-private */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f7950b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f7951c;

            a(int i2, int i3) {
                this.f7950b = i2;
                this.f7951c = i3;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                f fVar = f.this;
                fVar.f(c.e.a.b.m.a.b(fVar.f7949k, this.f7950b, animatedFraction), c.e.a.b.m.a.b(f.this.l, this.f7951c, animatedFraction));
            }
        }

        /* access modifiers changed from: package-private */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f7953b;

            b(int i2) {
                this.f7953b = i2;
            }

            public void onAnimationEnd(Animator animator) {
                f fVar = f.this;
                fVar.f7943e = this.f7953b;
                fVar.f7944f = Utils.FLOAT_EPSILON;
            }

            public void onAnimationStart(Animator animator) {
                f.this.f7943e = this.f7953b;
            }
        }

        f(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f7942d = new GradientDrawable();
        }

        private void d(i iVar, RectF rectF) {
            int contentWidth = iVar.getContentWidth();
            int b2 = (int) com.google.android.material.internal.k.b(getContext(), 24);
            if (contentWidth < b2) {
                contentWidth = b2;
            }
            int left = (iVar.getLeft() + iVar.getRight()) / 2;
            int i2 = contentWidth / 2;
            rectF.set((float) (left - i2), Utils.FLOAT_EPSILON, (float) (left + i2), Utils.FLOAT_EPSILON);
        }

        private void j() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f7943e);
            if (childAt == null || childAt.getWidth() <= 0) {
                i3 = -1;
                i2 = -1;
            } else {
                i3 = childAt.getLeft();
                i2 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.C && (childAt instanceof i)) {
                    d((i) childAt, tabLayout.f7928d);
                    i3 = (int) TabLayout.this.f7928d.left;
                    i2 = (int) TabLayout.this.f7928d.right;
                }
                if (this.f7944f > Utils.FLOAT_EPSILON && this.f7943e < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f7943e + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.C && (childAt2 instanceof i)) {
                        d((i) childAt2, tabLayout2.f7928d);
                        left = (int) TabLayout.this.f7928d.left;
                        right = (int) TabLayout.this.f7928d.right;
                    }
                    float f2 = this.f7944f;
                    i3 = (int) ((((float) left) * f2) + ((1.0f - f2) * ((float) i3)));
                    i2 = (int) ((((float) right) * f2) + ((1.0f - f2) * ((float) i2)));
                }
            }
            f(i3, i2);
        }

        private void k(boolean z, int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                j();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.C && (childAt instanceof i)) {
                d((i) childAt, tabLayout.f7928d);
                left = (int) TabLayout.this.f7928d.left;
                right = (int) TabLayout.this.f7928d.right;
            }
            int i4 = this.f7946h;
            int i5 = this.f7947i;
            if (i4 != left || i5 != right) {
                if (z) {
                    this.f7949k = i4;
                    this.l = i5;
                }
                a aVar = new a(left, right);
                if (z) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.f7948j = valueAnimator;
                    valueAnimator.setInterpolator(c.e.a.b.m.a.f3376b);
                    valueAnimator.setDuration((long) i3);
                    valueAnimator.setFloatValues(Utils.FLOAT_EPSILON, 1.0f);
                    valueAnimator.addUpdateListener(aVar);
                    valueAnimator.addListener(new b(i2));
                    valueAnimator.start();
                    return;
                }
                this.f7948j.removeAllUpdateListeners();
                this.f7948j.addUpdateListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            ValueAnimator valueAnimator = this.f7948j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f7948j.cancel();
            }
            k(true, i2, i3);
        }

        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.n;
            int i2 = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i3 = this.f7940b;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.z;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                if (i4 != 3) {
                    intrinsicHeight = 0;
                } else {
                    intrinsicHeight = getHeight();
                }
            }
            int i5 = this.f7946h;
            if (i5 >= 0 && this.f7947i > i5) {
                Drawable drawable2 = TabLayout.this.n;
                if (drawable2 == null) {
                    drawable2 = this.f7942d;
                }
                Drawable mutate = androidx.core.graphics.drawable.a.r(drawable2).mutate();
                mutate.setBounds(this.f7946h, i2, this.f7947i, intrinsicHeight);
                Paint paint = this.f7941c;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        mutate.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.n(mutate, paint.getColor());
                    }
                }
                mutate.draw(canvas);
            }
            super.draw(canvas);
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void f(int i2, int i3) {
            if (i2 != this.f7946h || i3 != this.f7947i) {
                this.f7946h = i2;
                this.f7947i = i3;
                u.d0(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(int i2, float f2) {
            ValueAnimator valueAnimator = this.f7948j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f7948j.cancel();
            }
            this.f7943e = i2;
            this.f7944f = f2;
            j();
        }

        /* access modifiers changed from: package-private */
        public void h(int i2) {
            if (i2 == 0) {
                this.f7941c = null;
                return;
            }
            if (this.f7941c == null) {
                this.f7941c = new Paint();
            }
            if (this.f7941c.getColor() != i2) {
                this.f7941c.setColor(i2);
                u.d0(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void i(int i2) {
            if (this.f7940b != i2) {
                this.f7940b = i2;
                u.d0(this);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f7948j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                j();
            } else {
                k(false, this.f7943e, -1);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.x == 1 || tabLayout.A == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (((int) com.google.android.material.internal.k.b(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != Utils.FLOAT_EPSILON) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = Utils.FLOAT_EPSILON;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.x = 0;
                            tabLayout2.M(false);
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.f7945g != i2) {
                requestLayout();
                this.f7945g = i2;
            }
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f7955a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f7956b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f7957c;

        /* renamed from: d  reason: collision with root package name */
        private int f7958d = -1;

        /* renamed from: e  reason: collision with root package name */
        private View f7959e;

        /* renamed from: f  reason: collision with root package name */
        private int f7960f = 1;

        /* renamed from: g  reason: collision with root package name */
        public TabLayout f7961g;

        /* renamed from: h  reason: collision with root package name */
        public i f7962h;

        /* renamed from: i  reason: collision with root package name */
        private int f7963i = -1;

        public View e() {
            return this.f7959e;
        }

        public Drawable f() {
            return this.f7955a;
        }

        public int g() {
            return this.f7958d;
        }

        public int h() {
            return this.f7960f;
        }

        public CharSequence i() {
            return this.f7956b;
        }

        public boolean j() {
            TabLayout tabLayout = this.f7961g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f7958d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f7961g = null;
            this.f7962h = null;
            this.f7955a = null;
            this.f7963i = -1;
            this.f7956b = null;
            this.f7957c = null;
            this.f7958d = -1;
            this.f7959e = null;
        }

        public void l() {
            TabLayout tabLayout = this.f7961g;
            if (tabLayout != null) {
                tabLayout.D(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g m(int i2) {
            TabLayout tabLayout = this.f7961g;
            if (tabLayout != null) {
                n(tabLayout.getResources().getText(i2));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g n(CharSequence charSequence) {
            this.f7957c = charSequence;
            u();
            return this;
        }

        public g o(int i2) {
            p(LayoutInflater.from(this.f7962h.getContext()).inflate(i2, (ViewGroup) this.f7962h, false));
            return this;
        }

        public g p(View view) {
            this.f7959e = view;
            u();
            return this;
        }

        public g q(Drawable drawable) {
            this.f7955a = drawable;
            TabLayout tabLayout = this.f7961g;
            if (tabLayout.x == 1 || tabLayout.A == 2) {
                tabLayout.M(true);
            }
            u();
            if (c.e.a.b.n.b.f3418a && this.f7962h.m() && this.f7962h.f7971f.isVisible()) {
                this.f7962h.invalidate();
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void r(int i2) {
            this.f7958d = i2;
        }

        public g s(int i2) {
            TabLayout tabLayout = this.f7961g;
            if (tabLayout != null) {
                t(tabLayout.getResources().getText(i2));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g t(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f7957c) && !TextUtils.isEmpty(charSequence)) {
                this.f7962h.setContentDescription(charSequence);
            }
            this.f7956b = charSequence;
            u();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void u() {
            i iVar = this.f7962h;
            if (iVar != null) {
                iVar.u();
            }
        }
    }

    public static class h implements ViewPager.j {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<TabLayout> f7964b;

        /* renamed from: c  reason: collision with root package name */
        private int f7965c;

        /* renamed from: d  reason: collision with root package name */
        private int f7966d;

        public h(TabLayout tabLayout) {
            this.f7964b = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f7964b.get();
            if (tabLayout != null) {
                int i4 = this.f7966d;
                boolean z = false;
                boolean z2 = i4 != 2 || this.f7965c == 1;
                if (!(i4 == 2 && this.f7965c == 0)) {
                    z = true;
                }
                tabLayout.H(i2, f2, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i2) {
            this.f7965c = this.f7966d;
            this.f7966d = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i2) {
            TabLayout tabLayout = this.f7964b.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.f7966d;
                tabLayout.E(tabLayout.w(i2), i3 == 0 || (i3 == 2 && this.f7965c == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f7966d = 0;
            this.f7965c = 0;
        }
    }

    public final class i extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private g f7967b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f7968c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f7969d;

        /* renamed from: e  reason: collision with root package name */
        private View f7970e;

        /* renamed from: f  reason: collision with root package name */
        private c.e.a.b.n.a f7971f;

        /* renamed from: g  reason: collision with root package name */
        private View f7972g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f7973h;

        /* renamed from: i  reason: collision with root package name */
        private ImageView f7974i;

        /* renamed from: j  reason: collision with root package name */
        private Drawable f7975j;

        /* renamed from: k  reason: collision with root package name */
        private int f7976k = 2;

        /* access modifiers changed from: package-private */
        public class a implements View.OnLayoutChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f7977a;

            a(View view) {
                this.f7977a = view;
            }

            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (this.f7977a.getVisibility() == 0) {
                    i.this.t(this.f7977a);
                }
            }
        }

        public i(Context context) {
            super(context);
            v(context);
            u.A0(this, TabLayout.this.f7930f, TabLayout.this.f7931g, TabLayout.this.f7932h, TabLayout.this.f7933i);
            setGravity(17);
            setOrientation(!TabLayout.this.B ? 1 : 0);
            setClickable(true);
            u.B0(this, s.b(getContext(), 1002));
        }

        private void g(View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new a(view));
            }
        }

        private c.e.a.b.n.a getBadge() {
            return this.f7971f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private int getContentWidth() {
            View[] viewArr = {this.f7968c, this.f7969d, this.f7972g};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        private c.e.a.b.n.a getOrCreateBadge() {
            if (this.f7971f == null) {
                this.f7971f = c.e.a.b.n.a.c(getContext());
            }
            s();
            c.e.a.b.n.a aVar = this.f7971f;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private float h(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        private void i(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        private FrameLayout j() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void k(Canvas canvas) {
            Drawable drawable = this.f7975j;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f7975j.draw(canvas);
            }
        }

        private FrameLayout l(View view) {
            if ((view == this.f7969d || view == this.f7968c) && c.e.a.b.n.b.f3418a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean m() {
            return this.f7971f != null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.material.tabs.TabLayout$i */
        /* JADX WARN: Multi-variable type inference failed */
        private void n() {
            FrameLayout frameLayout;
            if (c.e.a.b.n.b.f3418a) {
                frameLayout = j();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(c.e.a.b.h.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.f7969d = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.material.tabs.TabLayout$i */
        /* JADX WARN: Multi-variable type inference failed */
        private void o() {
            FrameLayout frameLayout;
            if (c.e.a.b.n.b.f3418a) {
                frameLayout = j();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(c.e.a.b.h.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.f7968c = textView;
            frameLayout.addView(textView);
        }

        private void q(View view) {
            if (m() && view != null) {
                i(false);
                c.e.a.b.n.b.a(this.f7971f, view, l(view));
                this.f7970e = view;
            }
        }

        private void r() {
            if (m()) {
                i(true);
                View view = this.f7970e;
                if (view != null) {
                    c.e.a.b.n.b.b(this.f7971f, view, l(view));
                    this.f7970e = null;
                }
            }
        }

        private void s() {
            g gVar;
            g gVar2;
            if (m()) {
                if (this.f7972g != null) {
                    r();
                } else if (this.f7969d != null && (gVar2 = this.f7967b) != null && gVar2.f() != null) {
                    View view = this.f7970e;
                    ImageView imageView = this.f7969d;
                    if (view != imageView) {
                        r();
                        q(this.f7969d);
                        return;
                    }
                    t(imageView);
                } else if (this.f7968c == null || (gVar = this.f7967b) == null || gVar.h() != 1) {
                    r();
                } else {
                    View view2 = this.f7970e;
                    TextView textView = this.f7968c;
                    if (view2 != textView) {
                        r();
                        q(this.f7968c);
                        return;
                    }
                    t(textView);
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void t(View view) {
            if (m() && view == this.f7970e) {
                c.e.a.b.n.b.c(this.f7971f, view, l(view));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void v(android.content.Context r7) {
            /*
            // Method dump skipped, instructions count: 125
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i.v(android.content.Context):void");
        }

        private void x(TextView textView, ImageView imageView) {
            g gVar = this.f7967b;
            CharSequence charSequence = null;
            Drawable mutate = (gVar == null || gVar.f() == null) ? null : androidx.core.graphics.drawable.a.r(this.f7967b.f()).mutate();
            g gVar2 = this.f7967b;
            CharSequence i2 = gVar2 != null ? gVar2.i() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(i2);
            if (textView != null) {
                if (z) {
                    textView.setText(i2);
                    if (this.f7967b.f7960f == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int b2 = (!z || imageView.getVisibility() != 0) ? 0 : (int) com.google.android.material.internal.k.b(getContext(), 8);
                if (TabLayout.this.B) {
                    if (b2 != b.h.k.h.a(marginLayoutParams)) {
                        b.h.k.h.c(marginLayoutParams, b2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (b2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = b2;
                    b.h.k.h.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f7967b;
            CharSequence charSequence2 = gVar3 != null ? gVar3.f7957c : null;
            if (!z) {
                charSequence = charSequence2;
            }
            s0.a(this, charSequence);
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f7975j;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f7975j.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public g getTab() {
            return this.f7967b;
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            c.e.a.b.n.a aVar = this.f7971f;
            if (aVar != null && aVar.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f7971f.g()));
            }
            b.h.k.d0.c E0 = b.h.k.d0.c.E0(accessibilityNodeInfo);
            E0.d0(c.C0048c.a(0, 1, this.f7967b.g(), 1, false, isSelected()));
            if (isSelected()) {
                E0.b0(false);
                E0.S(c.a.f2642g);
            }
            E0.s0("Tab");
        }

        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.s, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f7968c != null) {
                float f2 = TabLayout.this.p;
                int i4 = this.f7976k;
                ImageView imageView = this.f7969d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f7968c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.q;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f7968c.getTextSize();
                int lineCount = this.f7968c.getLineCount();
                int d2 = androidx.core.widget.i.d(this.f7968c);
                if (f2 != textSize || (d2 >= 0 && i4 != d2)) {
                    if (TabLayout.this.A == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f7968c.getLayout()) == null || h(layout, 0, f2) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z = false;
                    }
                    if (z) {
                        this.f7968c.setTextSize(0, f2);
                        this.f7968c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void p() {
            setTab(null);
            setSelected(false);
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f7967b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f7967b.l();
            return true;
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f7968c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f7969d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f7972g;
            if (view != null) {
                view.setSelected(z);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(g gVar) {
            if (gVar != this.f7967b) {
                this.f7967b = gVar;
                u();
            }
        }

        /* access modifiers changed from: package-private */
        public final void u() {
            g gVar = this.f7967b;
            Drawable drawable = null;
            View e2 = gVar != null ? gVar.e() : null;
            if (e2 != null) {
                ViewParent parent = e2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(e2);
                    }
                    addView(e2);
                }
                this.f7972g = e2;
                TextView textView = this.f7968c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f7969d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f7969d.setImageDrawable(null);
                }
                TextView textView2 = (TextView) e2.findViewById(16908308);
                this.f7973h = textView2;
                if (textView2 != null) {
                    this.f7976k = androidx.core.widget.i.d(textView2);
                }
                this.f7974i = (ImageView) e2.findViewById(16908294);
            } else {
                View view = this.f7972g;
                if (view != null) {
                    removeView(view);
                    this.f7972g = null;
                }
                this.f7973h = null;
                this.f7974i = null;
            }
            if (this.f7972g == null) {
                if (this.f7969d == null) {
                    n();
                }
                if (!(gVar == null || gVar.f() == null)) {
                    drawable = androidx.core.graphics.drawable.a.r(gVar.f()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.o(drawable, TabLayout.this.l);
                    PorterDuff.Mode mode = TabLayout.this.o;
                    if (mode != null) {
                        androidx.core.graphics.drawable.a.p(drawable, mode);
                    }
                }
                if (this.f7968c == null) {
                    o();
                    this.f7976k = androidx.core.widget.i.d(this.f7968c);
                }
                androidx.core.widget.i.q(this.f7968c, TabLayout.this.f7934j);
                ColorStateList colorStateList = TabLayout.this.f7935k;
                if (colorStateList != null) {
                    this.f7968c.setTextColor(colorStateList);
                }
                x(this.f7968c, this.f7969d);
                s();
                g(this.f7969d);
                g(this.f7968c);
            } else {
                TextView textView3 = this.f7973h;
                if (!(textView3 == null && this.f7974i == null)) {
                    x(textView3, this.f7974i);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f7957c)) {
                setContentDescription(gVar.f7957c);
            }
            setSelected(gVar != null && gVar.j());
        }

        /* access modifiers changed from: package-private */
        public final void w() {
            setOrientation(!TabLayout.this.B ? 1 : 0);
            TextView textView = this.f7973h;
            if (textView == null && this.f7974i == null) {
                x(this.f7968c, this.f7969d);
            } else {
                x(textView, this.f7974i);
            }
        }
    }

    public static class j implements d {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f7979a;

        public j(ViewPager viewPager) {
            this.f7979a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
            this.f7979a.setCurrentItem(gVar.g());
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.e.a.b.b.tabStyle);
    }

    private void C(int i2) {
        i iVar = (i) this.f7929e.getChildAt(i2);
        this.f7929e.removeViewAt(i2);
        if (iVar != null) {
            iVar.p();
            this.O.a(iVar);
        }
        requestLayout();
    }

    private void J(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.I;
        if (viewPager2 != null) {
            h hVar = this.L;
            if (hVar != null) {
                viewPager2.J(hVar);
            }
            b bVar = this.M;
            if (bVar != null) {
                this.I.I(bVar);
            }
        }
        c cVar = this.G;
        if (cVar != null) {
            B(cVar);
            this.G = null;
        }
        if (viewPager != null) {
            this.I = viewPager;
            if (this.L == null) {
                this.L = new h(this);
            }
            this.L.d();
            viewPager.c(this.L);
            j jVar = new j(viewPager);
            this.G = jVar;
            b(jVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                F(adapter, z2);
            }
            if (this.M == null) {
                this.M = new b();
            }
            this.M.a(z2);
            viewPager.b(this.M);
            G(viewPager.getCurrentItem(), Utils.FLOAT_EPSILON, true);
        } else {
            this.I = null;
            F(null, false);
        }
        this.N = z3;
    }

    private void K() {
        int size = this.f7926b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7926b.get(i2).u();
        }
    }

    private void L(LinearLayout.LayoutParams layoutParams) {
        if (this.A == 1 && this.x == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = Utils.FLOAT_EPSILON;
    }

    private void g(a aVar) {
        g x2 = x();
        CharSequence charSequence = aVar.f7980b;
        if (charSequence != null) {
            x2.t(charSequence);
        }
        Drawable drawable = aVar.f7981c;
        if (drawable != null) {
            x2.q(drawable);
        }
        int i2 = aVar.f7982d;
        if (i2 != 0) {
            x2.o(i2);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            x2.n(aVar.getContentDescription());
        }
        d(x2);
    }

    private int getDefaultHeight() {
        int size = this.f7926b.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f7926b.get(i2);
                if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.i())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.B) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.A;
        if (i3 == 0 || i3 == 2) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f7929e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(g gVar) {
        i iVar = gVar.f7962h;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f7929e.addView(iVar, gVar.g(), p());
    }

    private void i(View view) {
        if (view instanceof a) {
            g((a) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void j(int i2) {
        if (i2 != -1) {
            if (getWindowToken() == null || !u.S(this) || this.f7929e.e()) {
                G(i2, Utils.FLOAT_EPSILON, true);
                return;
            }
            int scrollX = getScrollX();
            int m2 = m(i2, Utils.FLOAT_EPSILON);
            if (scrollX != m2) {
                v();
                this.H.setIntValues(scrollX, m2);
                this.H.start();
            }
            this.f7929e.c(i2, this.y);
        }
    }

    private void k(int i2) {
        if (i2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.f7929e.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.f7929e.setGravity(8388611);
    }

    private void l() {
        int i2;
        int i3 = this.A;
        if (i3 == 0 || i3 == 2) {
            i2 = Math.max(0, this.w - this.f7930f);
        } else {
            i2 = 0;
        }
        u.A0(this.f7929e, i2, 0, 0, 0);
        int i4 = this.A;
        if (i4 == 0) {
            k(this.x);
        } else if (i4 == 1 || i4 == 2) {
            if (this.x == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f7929e.setGravity(1);
        }
        M(true);
    }

    private int m(int i2, float f2) {
        int i3 = this.A;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f7929e.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.f7929e.getChildCount() ? this.f7929e.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        return u.B(this) == 0 ? left + i6 : left - i6;
    }

    private void n(g gVar, int i2) {
        gVar.r(i2);
        this.f7926b.add(i2, gVar);
        int size = this.f7926b.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.f7926b.get(i2).r(i2);
            } else {
                return;
            }
        }
    }

    private static ColorStateList o(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private LinearLayout.LayoutParams p() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        L(layoutParams);
        return layoutParams;
    }

    private i r(g gVar) {
        b.h.j.e<i> eVar = this.O;
        i b2 = eVar != null ? eVar.b() : null;
        if (b2 == null) {
            b2 = new i(getContext());
        }
        b2.setTab(gVar);
        b2.setFocusable(true);
        b2.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f7957c)) {
            b2.setContentDescription(gVar.f7956b);
        } else {
            b2.setContentDescription(gVar.f7957c);
        }
        return b2;
    }

    private void s(g gVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(gVar);
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f7929e.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f7929e.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    private void t(g gVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).c(gVar);
        }
    }

    private void u(g gVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).b(gVar);
        }
    }

    private void v() {
        if (this.H == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.H = valueAnimator;
            valueAnimator.setInterpolator(c.e.a.b.m.a.f3376b);
            this.H.setDuration((long) this.y);
            this.H.addUpdateListener(new a());
        }
    }

    public void A() {
        for (int childCount = this.f7929e.getChildCount() - 1; childCount >= 0; childCount--) {
            C(childCount);
        }
        Iterator<g> it = this.f7926b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.k();
            z(next);
        }
        this.f7927c = null;
    }

    @Deprecated
    public void B(c cVar) {
        this.F.remove(cVar);
    }

    public void D(g gVar) {
        E(gVar, true);
    }

    public void E(g gVar, boolean z2) {
        g gVar2 = this.f7927c;
        if (gVar2 != gVar) {
            int g2 = gVar != null ? gVar.g() : -1;
            if (z2) {
                if ((gVar2 == null || gVar2.g() == -1) && g2 != -1) {
                    G(g2, Utils.FLOAT_EPSILON, true);
                } else {
                    j(g2);
                }
                if (g2 != -1) {
                    setSelectedTabView(g2);
                }
            }
            this.f7927c = gVar;
            if (gVar2 != null) {
                u(gVar2);
            }
            if (gVar != null) {
                t(gVar);
            }
        } else if (gVar2 != null) {
            s(gVar);
            j(gVar.g());
        }
    }

    /* access modifiers changed from: package-private */
    public void F(androidx.viewpager.widget.a aVar, boolean z2) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.J;
        if (!(aVar2 == null || (dataSetObserver = this.K) == null)) {
            aVar2.r(dataSetObserver);
        }
        this.J = aVar;
        if (z2 && aVar != null) {
            if (this.K == null) {
                this.K = new e();
            }
            aVar.j(this.K);
        }
        y();
    }

    public void G(int i2, float f2, boolean z2) {
        H(i2, f2, z2, true);
    }

    public void H(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.f7929e.getChildCount()) {
            if (z3) {
                this.f7929e.g(i2, f2);
            }
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.H.cancel();
            }
            scrollTo(m(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public void I(ViewPager viewPager, boolean z2) {
        J(viewPager, z2, false);
    }

    /* access modifiers changed from: package-private */
    public void M(boolean z2) {
        for (int i2 = 0; i2 < this.f7929e.getChildCount(); i2++) {
            View childAt = this.f7929e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            L((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public void addView(View view) {
        i(view);
    }

    @Deprecated
    public void b(c cVar) {
        if (!this.F.contains(cVar)) {
            this.F.add(cVar);
        }
    }

    public void c(d dVar) {
        b(dVar);
    }

    public void d(g gVar) {
        f(gVar, this.f7926b.isEmpty());
    }

    public void e(g gVar, int i2, boolean z2) {
        if (gVar.f7961g == this) {
            n(gVar, i2);
            h(gVar);
            if (z2) {
                gVar.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void f(g gVar, boolean z2) {
        e(gVar, this.f7926b.size(), z2);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f7927c;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f7926b.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.l;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.m;
    }

    public Drawable getTabSelectedIndicator() {
        return this.n;
    }

    public ColorStateList getTabTextColors() {
        return this.f7935k;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.e.a.b.c0.h.e(this);
        if (this.I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                J((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager(null);
            this.N = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f7929e.getChildCount(); i2++) {
            View childAt = this.f7929e.getChildAt(i2);
            if (childAt instanceof i) {
                ((i) childAt).k(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        b.h.k.d0.c.E0(accessibilityNodeInfo).c0(c.b.a(1, getTabCount(), false, 1));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public g q() {
        g b2 = Q.b();
        return b2 == null ? new g() : b2;
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c.e.a.b.c0.h.d(this, f2);
    }

    public void setInlineLabel(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            for (int i2 = 0; i2 < this.f7929e.getChildCount(); i2++) {
                View childAt = this.f7929e.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).w();
                }
            }
            l();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        v();
        this.H.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.n != drawable) {
            this.n = drawable;
            u.d0(this.f7929e);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.f7929e.h(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            u.d0(this.f7929e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f7929e.i(i2);
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            l();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            K();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(b.a.k.a.a.c(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.C = z2;
        u.d0(this.f7929e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            l();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            for (int i2 = 0; i2 < this.f7929e.getChildCount(); i2++) {
                View childAt = this.f7929e.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).v(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(b.a.k.a.a.c(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f7935k != colorStateList) {
            this.f7935k = colorStateList;
            K();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        F(aVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            for (int i2 = 0; i2 < this.f7929e.getChildCount(); i2++) {
                View childAt = this.f7929e.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).v(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        I(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public g w(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f7926b.get(i2);
    }

    public g x() {
        g q2 = q();
        q2.f7961g = this;
        q2.f7962h = r(q2);
        if (q2.f7963i != -1) {
            q2.f7962h.setId(q2.f7963i);
        }
        return q2;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        int currentItem;
        A();
        androidx.viewpager.widget.a aVar = this.J;
        if (aVar != null) {
            int d2 = aVar.d();
            for (int i2 = 0; i2 < d2; i2++) {
                g x2 = x();
                x2.t(this.J.f(i2));
                f(x2, false);
            }
            ViewPager viewPager = this.I;
            if (viewPager != null && d2 > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                D(w(currentItem));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean z(g gVar) {
        return Q.a(gVar);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        i(view);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.E;
        if (cVar2 != null) {
            B(cVar2);
        }
        this.E = cVar;
        if (cVar != null) {
            b(cVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        i(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        i(view);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(b.a.k.a.a.d(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
