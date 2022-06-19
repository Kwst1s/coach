package com.rd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import b.h.i.f;
import com.github.mikephil.charting.utils.Utils;
import com.rd.a;
import com.rd.c.b.b;
import com.rd.c.c.d;

public class PageIndicatorView extends View implements ViewPager.j, a.AbstractC0171a, ViewPager.i, View.OnTouchListener {

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f8464g = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private a f8465b;

    /* renamed from: c  reason: collision with root package name */
    private DataSetObserver f8466c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager f8467d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8468e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f8469f = new b();

    /* access modifiers changed from: package-private */
    public class a extends DataSetObserver {
        a() {
        }

        public void onChanged() {
            PageIndicatorView.this.A();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            PageIndicatorView.this.f8465b.d().H(true);
            PageIndicatorView.this.m();
        }
    }

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8472a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.rd.c.c.d[] r0 = com.rd.c.c.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.rd.PageIndicatorView.c.f8472a = r0
                com.rd.c.c.d r1 = com.rd.c.c.d.On     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.rd.PageIndicatorView.c.f8472a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.rd.c.c.d r1 = com.rd.c.c.d.Off     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.rd.PageIndicatorView.c.f8472a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.rd.c.c.d r1 = com.rd.c.c.d.Auto     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.PageIndicatorView.c.<clinit>():void");
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(attributeSet);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void A() {
        ViewPager viewPager = this.f8467d;
        if (viewPager != null && viewPager.getAdapter() != null) {
            int d2 = this.f8467d.getAdapter().d();
            int currentItem = p() ? (d2 - 1) - this.f8467d.getCurrentItem() : this.f8467d.getCurrentItem();
            this.f8465b.d().V(currentItem);
            this.f8465b.d().W(currentItem);
            this.f8465b.d().K(currentItem);
            this.f8465b.d().D(d2);
            this.f8465b.b().b();
            B();
            requestLayout();
        }
    }

    private void B() {
        if (this.f8465b.d().w()) {
            int c2 = this.f8465b.d().c();
            int visibility = getVisibility();
            if (visibility != 0 && c2 > 1) {
                setVisibility(0);
            } else if (visibility != 4 && c2 <= 1) {
                setVisibility(4);
            }
        }
    }

    private int i(int i2) {
        int c2 = this.f8465b.d().c() - 1;
        if (i2 < 0) {
            return 0;
        }
        return i2 > c2 ? c2 : i2;
    }

    private void j() {
        animate().cancel();
        animate().alpha(1.0f).setDuration(250);
    }

    private ViewPager k(ViewGroup viewGroup, int i2) {
        View findViewById;
        if (viewGroup.getChildCount() > 0 && (findViewById = viewGroup.findViewById(i2)) != null && (findViewById instanceof ViewPager)) {
            return (ViewPager) findViewById;
        }
        return null;
    }

    private void l(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup) && ((ViewGroup) viewParent).getChildCount() > 0) {
            ViewPager k2 = k((ViewGroup) viewParent, this.f8465b.d().u());
            if (k2 != null) {
                setViewPager(k2);
            } else {
                l(viewParent.getParent());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        animate().cancel();
        animate().alpha(Utils.FLOAT_EPSILON).setDuration(250);
    }

    private void n(AttributeSet attributeSet) {
        w();
        o(attributeSet);
        if (this.f8465b.d().y()) {
            x();
        }
    }

    private void o(AttributeSet attributeSet) {
        a aVar = new a(this);
        this.f8465b = aVar;
        aVar.c().c(getContext(), attributeSet);
        com.rd.c.c.a d2 = this.f8465b.d();
        d2.O(getPaddingLeft());
        d2.Q(getPaddingTop());
        d2.P(getPaddingRight());
        d2.N(getPaddingBottom());
        this.f8468e = d2.z();
    }

    private boolean p() {
        int i2 = c.f8472a[this.f8465b.d().n().ordinal()];
        if (i2 == 1) {
            return true;
        }
        if (i2 == 3 && f.b(getContext().getResources().getConfiguration().locale) == 1) {
            return true;
        }
        return false;
    }

    private boolean q() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    private void r(int i2, float f2) {
        com.rd.c.c.a d2 = this.f8465b.d();
        if (q() && d2.z() && d2.b() != com.rd.b.d.a.NONE) {
            Pair<Integer, Float> e2 = com.rd.e.a.e(d2, i2, f2, p());
            v(((Integer) e2.first).intValue(), ((Float) e2.second).floatValue());
        }
    }

    private void s(int i2) {
        com.rd.c.c.a d2 = this.f8465b.d();
        boolean q = q();
        int c2 = d2.c();
        if (q) {
            if (p()) {
                i2 = (c2 - 1) - i2;
            }
            setSelection(i2);
        }
    }

    private void t() {
        ViewPager viewPager;
        if (this.f8466c == null && (viewPager = this.f8467d) != null && viewPager.getAdapter() != null) {
            this.f8466c = new a();
            try {
                this.f8467d.getAdapter().j(this.f8466c);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void w() {
        if (getId() == -1) {
            setId(com.rd.e.c.b());
        }
    }

    private void x() {
        Handler handler = f8464g;
        handler.removeCallbacks(this.f8469f);
        handler.postDelayed(this.f8469f, this.f8465b.d().e());
    }

    private void y() {
        f8464g.removeCallbacks(this.f8469f);
        j();
    }

    private void z() {
        ViewPager viewPager;
        if (this.f8466c != null && (viewPager = this.f8467d) != null && viewPager.getAdapter() != null) {
            try {
                this.f8467d.getAdapter().r(this.f8466c);
                this.f8466c = null;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void a(int i2, float f2, int i3) {
        r(i2, f2);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void b(int i2) {
        if (i2 == 0) {
            this.f8465b.d().J(this.f8468e);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i2) {
        s(i2);
    }

    @Override // androidx.viewpager.widget.ViewPager.i
    public void d(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        DataSetObserver dataSetObserver;
        if (this.f8465b.d().x()) {
            if (!(aVar == null || (dataSetObserver = this.f8466c) == null)) {
                aVar.r(dataSetObserver);
                this.f8466c = null;
            }
            t();
        }
        A();
    }

    @Override // com.rd.a.AbstractC0171a
    public void e() {
        invalidate();
    }

    public long getAnimationDuration() {
        return this.f8465b.d().a();
    }

    public int getCount() {
        return this.f8465b.d().c();
    }

    public int getPadding() {
        return this.f8465b.d().h();
    }

    public int getRadius() {
        return this.f8465b.d().m();
    }

    public float getScaleFactor() {
        return this.f8465b.d().o();
    }

    public int getSelectedColor() {
        return this.f8465b.d().p();
    }

    public int getSelection() {
        return this.f8465b.d().q();
    }

    public int getStrokeWidth() {
        return this.f8465b.d().s();
    }

    public int getUnselectedColor() {
        return this.f8465b.d().t();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l(getParent());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        z();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f8465b.c().a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Pair<Integer, Integer> d2 = this.f8465b.c().d(i2, i3);
        setMeasuredDimension(((Integer) d2.first).intValue(), ((Integer) d2.second).intValue());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof com.rd.c.c.c) {
            com.rd.c.c.a d2 = this.f8465b.d();
            com.rd.c.c.c cVar = (com.rd.c.c.c) parcelable;
            d2.V(cVar.k());
            d2.W(cVar.l());
            d2.K(cVar.g());
            super.onRestoreInstanceState(cVar.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        com.rd.c.c.a d2 = this.f8465b.d();
        com.rd.c.c.c cVar = new com.rd.c.c.c(super.onSaveInstanceState());
        cVar.n(d2.q());
        cVar.o(d2.r());
        cVar.m(d2.f());
        return cVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f8465b.d().y()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            y();
        } else if (action == 1) {
            x();
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f8465b.c().f(motionEvent);
        return true;
    }

    public void setAnimationDuration(long j2) {
        this.f8465b.d().A(j2);
    }

    public void setAnimationType(com.rd.b.d.a aVar) {
        this.f8465b.a(null);
        if (aVar != null) {
            this.f8465b.d().B(aVar);
        } else {
            this.f8465b.d().B(com.rd.b.d.a.NONE);
        }
        invalidate();
    }

    public void setAutoVisibility(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        this.f8465b.d().C(z);
        B();
    }

    public void setClickListener(b.AbstractC0173b bVar) {
        this.f8465b.c().e(bVar);
    }

    public void setCount(int i2) {
        if (i2 >= 0 && this.f8465b.d().c() != i2) {
            this.f8465b.d().D(i2);
            B();
            requestLayout();
        }
    }

    public void setDynamicCount(boolean z) {
        this.f8465b.d().E(z);
        if (z) {
            t();
        } else {
            z();
        }
    }

    public void setFadeOnIdle(boolean z) {
        this.f8465b.d().F(z);
        if (z) {
            x();
        } else {
            y();
        }
    }

    public void setIdleDuration(long j2) {
        this.f8465b.d().I(j2);
        if (this.f8465b.d().y()) {
            x();
        } else {
            y();
        }
    }

    public void setInteractiveAnimation(boolean z) {
        this.f8465b.d().J(z);
        this.f8468e = z;
    }

    public void setOrientation(com.rd.c.c.b bVar) {
        if (bVar != null) {
            this.f8465b.d().L(bVar);
            requestLayout();
        }
    }

    public void setPadding(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f8465b.d().M(com.rd.e.b.a(i2));
        invalidate();
    }

    public void setRadius(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f8465b.d().R(com.rd.e.b.a(i2));
        invalidate();
    }

    public void setRtlMode(d dVar) {
        com.rd.c.c.a d2 = this.f8465b.d();
        if (dVar == null) {
            d2.S(d.Off);
        } else {
            d2.S(dVar);
        }
        if (this.f8467d != null) {
            int q = d2.q();
            if (p()) {
                q = (d2.c() - 1) - q;
            } else {
                ViewPager viewPager = this.f8467d;
                if (viewPager != null) {
                    q = viewPager.getCurrentItem();
                }
            }
            d2.K(q);
            d2.W(q);
            d2.V(q);
            invalidate();
        }
    }

    public void setScaleFactor(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.3f) {
            f2 = 0.3f;
        }
        this.f8465b.d().T(f2);
    }

    public void setSelected(int i2) {
        com.rd.c.c.a d2 = this.f8465b.d();
        com.rd.b.d.a b2 = d2.b();
        d2.B(com.rd.b.d.a.NONE);
        setSelection(i2);
        d2.B(b2);
    }

    public void setSelectedColor(int i2) {
        this.f8465b.d().U(i2);
        invalidate();
    }

    public void setSelection(int i2) {
        com.rd.c.c.a d2 = this.f8465b.d();
        int i3 = i(i2);
        if (i3 != d2.q() && i3 != d2.r()) {
            d2.J(false);
            d2.K(d2.q());
            d2.W(i3);
            d2.V(i3);
            this.f8465b.b().a();
        }
    }

    public void setStrokeWidth(float f2) {
        int m = this.f8465b.d().m();
        if (f2 < Utils.FLOAT_EPSILON) {
            f2 = Utils.FLOAT_EPSILON;
        } else {
            float f3 = (float) m;
            if (f2 > f3) {
                f2 = f3;
            }
        }
        this.f8465b.d().X((int) f2);
        invalidate();
    }

    public void setUnselectedColor(int i2) {
        this.f8465b.d().Y(i2);
        invalidate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setViewPager(ViewPager viewPager) {
        u();
        if (viewPager != null) {
            this.f8467d = viewPager;
            viewPager.c(this);
            this.f8467d.b(this);
            this.f8467d.setOnTouchListener(this);
            this.f8465b.d().Z(this.f8467d.getId());
            setDynamicCount(this.f8465b.d().x());
            A();
        }
    }

    public void u() {
        ViewPager viewPager = this.f8467d;
        if (viewPager != null) {
            viewPager.J(this);
            this.f8467d.I(this);
            this.f8467d = null;
        }
    }

    public void v(int i2, float f2) {
        com.rd.c.c.a d2 = this.f8465b.d();
        if (d2.z()) {
            int c2 = d2.c();
            if (c2 <= 0 || i2 < 0) {
                i2 = 0;
            } else {
                int i3 = c2 - 1;
                if (i2 > i3) {
                    i2 = i3;
                }
            }
            if (f2 < Utils.FLOAT_EPSILON) {
                f2 = Utils.FLOAT_EPSILON;
            } else if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            if (f2 == 1.0f) {
                d2.K(d2.q());
                d2.V(i2);
            }
            d2.W(i2);
            this.f8465b.b().c(f2);
        }
    }

    public void setPadding(float f2) {
        if (f2 < Utils.FLOAT_EPSILON) {
            f2 = Utils.FLOAT_EPSILON;
        }
        this.f8465b.d().M((int) f2);
        invalidate();
    }

    public void setRadius(float f2) {
        if (f2 < Utils.FLOAT_EPSILON) {
            f2 = Utils.FLOAT_EPSILON;
        }
        this.f8465b.d().R((int) f2);
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        int a2 = com.rd.e.b.a(i2);
        int m = this.f8465b.d().m();
        if (a2 < 0) {
            a2 = 0;
        } else if (a2 > m) {
            a2 = m;
        }
        this.f8465b.d().X(a2);
        invalidate();
    }
}
