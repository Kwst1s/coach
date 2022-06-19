package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: FastScroller */
public class d extends RecyclerView.n implements RecyclerView.s {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;

    /* renamed from: a  reason: collision with root package name */
    private final int f1734a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1735b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f1736c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f1737d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1738e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1739f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f1740g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f1741h;

    /* renamed from: i  reason: collision with root package name */
    private final int f1742i;

    /* renamed from: j  reason: collision with root package name */
    private final int f1743j;

    /* renamed from: k  reason: collision with root package name */
    int f1744k;
    int l;
    float m;
    int n;
    int o;
    float p;
    private int q = 0;
    private int r = 0;
    private RecyclerView s;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    private final int[] x = new int[2];
    private final int[] y = new int[2];
    final ValueAnimator z;

    /* compiled from: FastScroller */
    class a implements Runnable {
        a() {
        }

        public void run() {
            d.this.s(500);
        }
    }

    /* compiled from: FastScroller */
    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            d.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: FastScroller */
    private class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1747b = false;

        c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f1747b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f1747b) {
                this.f1747b = false;
            } else if (((Float) d.this.z.getAnimatedValue()).floatValue() == Utils.FLOAT_EPSILON) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.A(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.x();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d  reason: collision with other inner class name */
    /* compiled from: FastScroller */
    private class C0026d implements ValueAnimator.AnimatorUpdateListener {
        C0026d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f1736c.setAlpha(floatValue);
            d.this.f1737d.setAlpha(floatValue);
            d.this.x();
        }
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Utils.FLOAT_EPSILON, 1.0f);
        this.z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f1736c = stateListDrawable;
        this.f1737d = drawable;
        this.f1740g = stateListDrawable2;
        this.f1741h = drawable2;
        this.f1738e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f1739f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f1742i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f1743j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f1734a = i3;
        this.f1735b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0026d());
        l(recyclerView);
    }

    private void B() {
        this.s.h(this);
        this.s.k(this);
        this.s.l(this.C);
    }

    private void E(float f2) {
        int[] r2 = r();
        float max = Math.max((float) r2[0], Math.min((float) r2[1], f2));
        if (Math.abs(((float) this.l) - max) >= 2.0f) {
            int z2 = z(this.m, max, r2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
            if (z2 != 0) {
                this.s.scrollBy(0, z2);
            }
            this.m = max;
        }
    }

    private void m() {
        this.s.removeCallbacks(this.B);
    }

    private void n() {
        this.s.Y0(this);
        this.s.a1(this);
        this.s.b1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i2 = this.r;
        int i3 = this.f1742i;
        int i4 = i2 - i3;
        int i5 = this.o;
        int i6 = this.n;
        int i7 = i5 - (i6 / 2);
        this.f1740g.setBounds(0, 0, i6, i3);
        this.f1741h.setBounds(0, 0, this.q, this.f1743j);
        canvas.translate(Utils.FLOAT_EPSILON, (float) i4);
        this.f1741h.draw(canvas);
        canvas.translate((float) i7, Utils.FLOAT_EPSILON);
        this.f1740g.draw(canvas);
        canvas.translate((float) (-i7), (float) (-i4));
    }

    private void p(Canvas canvas) {
        int i2 = this.q;
        int i3 = this.f1738e;
        int i4 = i2 - i3;
        int i5 = this.l;
        int i6 = this.f1744k;
        int i7 = i5 - (i6 / 2);
        this.f1736c.setBounds(0, 0, i3, i6);
        this.f1737d.setBounds(0, 0, this.f1739f, this.r);
        if (u()) {
            this.f1737d.draw(canvas);
            canvas.translate((float) this.f1738e, (float) i7);
            canvas.scale(-1.0f, 1.0f);
            this.f1736c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f1738e), (float) (-i7));
            return;
        }
        canvas.translate((float) i4, Utils.FLOAT_EPSILON);
        this.f1737d.draw(canvas);
        canvas.translate(Utils.FLOAT_EPSILON, (float) i7);
        this.f1736c.draw(canvas);
        canvas.translate((float) (-i4), (float) (-i7));
    }

    private int[] q() {
        int[] iArr = this.y;
        int i2 = this.f1735b;
        iArr[0] = i2;
        iArr[1] = this.q - i2;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.x;
        int i2 = this.f1735b;
        iArr[0] = i2;
        iArr[1] = this.r - i2;
        return iArr;
    }

    private void t(float f2) {
        int[] q2 = q();
        float max = Math.max((float) q2[0], Math.min((float) q2[1], f2));
        if (Math.abs(((float) this.o) - max) >= 2.0f) {
            int z2 = z(this.p, max, q2, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
            if (z2 != 0) {
                this.s.scrollBy(z2, 0);
            }
            this.p = max;
        }
    }

    private boolean u() {
        return u.B(this.s) == 1;
    }

    private void y(int i2) {
        m();
        this.s.postDelayed(this.B, (long) i2);
    }

    private int z(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    /* access modifiers changed from: package-private */
    public void A(int i2) {
        if (i2 == 2 && this.v != 2) {
            this.f1736c.setState(D);
            m();
        }
        if (i2 == 0) {
            x();
        } else {
            C();
        }
        if (this.v == 2 && i2 != 2) {
            this.f1736c.setState(E);
            y(1200);
        } else if (i2 == 1) {
            y(1500);
        }
        this.v = i2;
    }

    public void C() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 == 3) {
                this.z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0);
        this.z.start();
    }

    /* access modifiers changed from: package-private */
    public void D(int i2, int i3) {
        int computeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i4 = this.r;
        this.t = computeVerticalScrollRange - i4 > 0 && i4 >= this.f1734a;
        int computeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i5 = this.q;
        boolean z2 = computeHorizontalScrollRange - i5 > 0 && i5 >= this.f1734a;
        this.u = z2;
        boolean z3 = this.t;
        if (z3 || z2) {
            if (z3) {
                float f2 = (float) i4;
                this.l = (int) ((f2 * (((float) i3) + (f2 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f1744k = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
            }
            if (this.u) {
                float f3 = (float) i5;
                this.o = (int) ((f3 * (((float) i2) + (f3 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.n = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
            }
            int i6 = this.v;
            if (i6 == 0 || i6 == 1) {
                A(1);
            }
        } else if (this.v != 0) {
            A(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 == 1) {
            boolean w2 = w(motionEvent.getX(), motionEvent.getY());
            boolean v2 = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!w2 && !v2) {
                return false;
            }
            if (v2) {
                this.w = 1;
                this.p = (float) ((int) motionEvent.getX());
            } else if (w2) {
                this.w = 2;
                this.m = (float) ((int) motionEvent.getY());
            }
            A(2);
        } else if (i2 == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean w2 = w(motionEvent.getX(), motionEvent.getY());
                boolean v2 = v(motionEvent.getX(), motionEvent.getY());
                if (w2 || v2) {
                    if (v2) {
                        this.w = 1;
                        this.p = (float) ((int) motionEvent.getX());
                    } else if (w2) {
                        this.w = 2;
                        this.m = (float) ((int) motionEvent.getY());
                    }
                    A(2);
                }
            } else if (motionEvent.getAction() == 1 && this.v == 2) {
                this.m = Utils.FLOAT_EPSILON;
                this.p = Utils.FLOAT_EPSILON;
                A(1);
                this.w = 0;
            } else if (motionEvent.getAction() == 2 && this.v == 2) {
                C();
                if (this.w == 1) {
                    t(motionEvent.getX());
                }
                if (this.w == 2) {
                    E(motionEvent.getY());
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.t) {
                p(canvas);
            }
            if (this.u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                n();
            }
            this.s = recyclerView;
            if (recyclerView != null) {
                B();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(int i2) {
        int i3 = this.A;
        if (i3 == 1) {
            this.z.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.z.setDuration((long) i2);
        this.z.start();
    }

    /* access modifiers changed from: package-private */
    public boolean v(float f2, float f3) {
        if (f3 >= ((float) (this.r - this.f1742i))) {
            int i2 = this.o;
            int i3 = this.n;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) (i2 + (i3 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean w(float f2, float f3) {
        if (!u() ? f2 >= ((float) (this.q - this.f1738e)) : f2 <= ((float) (this.f1738e / 2))) {
            int i2 = this.l;
            int i3 = this.f1744k;
            return f3 >= ((float) (i2 - (i3 / 2))) && f3 <= ((float) (i2 + (i3 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.s.invalidate();
    }
}
