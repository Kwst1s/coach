package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.m;
import b.a.f;
import b.h.k.c0;
import b.h.k.m;
import b.h.k.n;
import b.h.k.o;
import b.h.k.p;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements v, o, m, n {
    static final int[] G = {b.a.a.actionBarSize, 16842841};
    private OverScroller A;
    ViewPropertyAnimator B;
    final AnimatorListenerAdapter C;
    private final Runnable D;
    private final Runnable E;
    private final p F;

    /* renamed from: b  reason: collision with root package name */
    private int f427b;

    /* renamed from: c  reason: collision with root package name */
    private int f428c = 0;

    /* renamed from: d  reason: collision with root package name */
    private ContentFrameLayout f429d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f430e;

    /* renamed from: f  reason: collision with root package name */
    private w f431f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f432g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f433h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f434i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f435j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f436k;
    boolean l;
    private int m;
    private int n;
    private final Rect o = new Rect();
    private final Rect p = new Rect();
    private final Rect q = new Rect();
    private final Rect r = new Rect();
    private final Rect s = new Rect();
    private final Rect t = new Rect();
    private final Rect u = new Rect();
    private c0 v;
    private c0 w;
    private c0 x;
    private c0 y;
    private d z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f430e.animate().translationY(Utils.FLOAT_EPSILON).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f430e.animate().translationY((float) (-ActionBarOverlayLayout.this.f430e.getHeight())).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
        void a();

        void b();

        void c(int i2);

        void d();

        void e(boolean z);

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c0 c0Var = c0.f2597b;
        this.v = c0Var;
        this.w = c0Var;
        this.x = c0Var;
        this.y = c0Var;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        v(context);
        this.F = new p(this);
    }

    private void A() {
        u();
        this.D.run();
    }

    private boolean B(float f2) {
        this.A.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.A.getFinalY() > this.f430e.getHeight();
    }

    private void p() {
        u();
        this.E.run();
    }

    private boolean q(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        e eVar = (e) view.getLayoutParams();
        if (!z2 || ((ViewGroup.MarginLayoutParams) eVar).leftMargin == (i5 = rect.left)) {
            z6 = false;
        } else {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i5;
            z6 = true;
        }
        if (z3 && ((ViewGroup.MarginLayoutParams) eVar).topMargin != (i4 = rect.top)) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i4;
            z6 = true;
        }
        if (z5 && ((ViewGroup.MarginLayoutParams) eVar).rightMargin != (i3 = rect.right)) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i3;
            z6 = true;
        }
        if (!z4 || ((ViewGroup.MarginLayoutParams) eVar).bottomMargin == (i2 = rect.bottom)) {
            return z6;
        }
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i2;
        return true;
    }

    private w t(View view) {
        if (view instanceof w) {
            return (w) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z2 = false;
        this.f427b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f432g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.f433h = z2;
        this.A = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.E, 600);
    }

    private void y() {
        u();
        postDelayed(this.D, 600);
    }

    @Override // androidx.appcompat.widget.v
    public void a(Menu menu, m.a aVar) {
        z();
        this.f431f.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.v
    public boolean b() {
        z();
        return this.f431f.b();
    }

    @Override // androidx.appcompat.widget.v
    public void c() {
        z();
        this.f431f.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.v
    public boolean d() {
        z();
        return this.f431f.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f432g != null && !this.f433h) {
            int bottom = this.f430e.getVisibility() == 0 ? (int) (((float) this.f430e.getBottom()) + this.f430e.getTranslationY() + 0.5f) : 0;
            this.f432g.setBounds(0, bottom, getWidth(), this.f432g.getIntrinsicHeight() + bottom);
            this.f432g.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.v
    public boolean e() {
        z();
        return this.f431f.e();
    }

    @Override // androidx.appcompat.widget.v
    public boolean f() {
        z();
        return this.f431f.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean q2 = q(this.f430e, rect, true, true, false, true);
        this.r.set(rect);
        w0.a(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            q2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            q2 = true;
        }
        if (q2) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.v
    public boolean g() {
        z();
        return this.f431f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f430e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f431f.getTitle();
    }

    @Override // b.h.k.m
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // b.h.k.m
    public void i(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // b.h.k.m
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // androidx.appcompat.widget.v
    public void k(int i2) {
        z();
        if (i2 == 2) {
            this.f431f.w();
        } else if (i2 == 5) {
            this.f431f.x();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.v
    public void l() {
        z();
        this.f431f.h();
    }

    @Override // b.h.k.n
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        n(view, i2, i3, i4, i5, i6);
    }

    @Override // b.h.k.m
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // b.h.k.m
    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        c0 q2 = c0.q(windowInsets);
        boolean q3 = q(this.f430e, new Rect(q2.g(), q2.i(), q2.h(), q2.f()), true, true, false, true);
        u.g(this, q2, this.o);
        Rect rect = this.o;
        c0 j2 = q2.j(rect.left, rect.top, rect.right, rect.bottom);
        this.v = j2;
        boolean z2 = true;
        if (!this.w.equals(j2)) {
            this.w = this.v;
            q3 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
        } else {
            z2 = q3;
        }
        if (z2) {
            requestLayout();
        }
        return q2.a().c().b().p();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        u.j0(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        z();
        measureChildWithMargins(this.f430e, i2, 0, i3, 0);
        e eVar = (e) this.f430e.getLayoutParams();
        int max = Math.max(0, this.f430e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f430e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f430e.getMeasuredState());
        boolean z2 = (u.L(this) & 256) != 0;
        if (z2) {
            i4 = this.f427b;
            if (this.f435j && this.f430e.getTabContainer() != null) {
                i4 += this.f427b;
            }
        } else {
            i4 = this.f430e.getVisibility() != 8 ? this.f430e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            this.x = this.v;
        } else {
            this.t.set(this.r);
        }
        if (!this.f434i && !z2) {
            Rect rect = this.q;
            rect.top += i4;
            rect.bottom += 0;
            if (i5 >= 21) {
                this.x = this.x.j(0, i4, 0, 0);
            }
        } else if (i5 >= 21) {
            b.h.e.b b2 = b.h.e.b.b(this.x.g(), this.x.i() + i4, this.x.h(), this.x.f() + 0);
            c0.a aVar = new c0.a(this.x);
            aVar.c(b2);
            this.x = aVar.a();
        } else {
            Rect rect2 = this.t;
            rect2.top += i4;
            rect2.bottom += 0;
        }
        q(this.f429d, this.q, true, true, true, true);
        if (i5 >= 21 && !this.y.equals(this.x)) {
            c0 c0Var = this.x;
            this.y = c0Var;
            u.h(this.f429d, c0Var);
        } else if (i5 < 21 && !this.u.equals(this.t)) {
            this.u.set(this.t);
            this.f429d.a(this.t);
        }
        measureChildWithMargins(this.f429d, i2, 0, i3, 0);
        e eVar2 = (e) this.f429d.getLayoutParams();
        int max3 = Math.max(max, this.f429d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f429d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f429d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // b.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f436k || !z2) {
            return false;
        }
        if (B(f3)) {
            p();
        } else {
            A();
        }
        this.l = true;
        return true;
    }

    @Override // b.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // b.h.k.o
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // b.h.k.o
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.m + i3;
        this.m = i6;
        setActionBarHideOffset(i6);
    }

    @Override // b.h.k.o
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.F.b(view, view2, i2);
        this.m = getActionBarHideOffset();
        u();
        d dVar = this.z;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // b.h.k.o
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f430e.getVisibility() != 0) {
            return false;
        }
        return this.f436k;
    }

    @Override // b.h.k.o
    public void onStopNestedScroll(View view) {
        if (this.f436k && !this.l) {
            if (this.m <= this.f430e.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        z();
        int i3 = this.n ^ i2;
        this.n = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z2 = true;
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.e(!z2);
            if (z3 || !z2) {
                this.z.a();
            } else {
                this.z.f();
            }
        }
        if ((i3 & 256) != 0 && this.z != null) {
            u.j0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f428c = i2;
        d dVar = this.z;
        if (dVar != null) {
            dVar.c(i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i2) {
        u();
        this.f430e.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f430e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.z = dVar;
        if (getWindowToken() != null) {
            this.z.c(this.f428c);
            int i2 = this.n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                u.j0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f435j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f436k) {
            this.f436k = z2;
            if (!z2) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        z();
        this.f431f.setIcon(i2);
    }

    public void setLogo(int i2) {
        z();
        this.f431f.s(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f434i = z2;
        this.f433h = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.v
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f431f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.v
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f431f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f434i;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.f429d == null) {
            this.f429d = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f430e = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f431f = t(findViewById(f.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f431f.setIcon(drawable);
    }
}
