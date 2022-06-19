package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ItemTouchHelper */
public class f extends RecyclerView.n implements RecyclerView.q {
    private g A;
    private final RecyclerView.s B = new b();
    private Rect C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f1765a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1766b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.d0 f1767c = null;

    /* renamed from: d  reason: collision with root package name */
    float f1768d;

    /* renamed from: e  reason: collision with root package name */
    float f1769e;

    /* renamed from: f  reason: collision with root package name */
    private float f1770f;

    /* renamed from: g  reason: collision with root package name */
    private float f1771g;

    /* renamed from: h  reason: collision with root package name */
    float f1772h;

    /* renamed from: i  reason: collision with root package name */
    float f1773i;

    /* renamed from: j  reason: collision with root package name */
    private float f1774j;

    /* renamed from: k  reason: collision with root package name */
    private float f1775k;
    int l = -1;
    AbstractC0027f m;
    private int n = 0;
    int o;
    List<h> p = new ArrayList();
    private int q;
    RecyclerView r;
    final Runnable s = new a();
    VelocityTracker t;
    private List<RecyclerView.d0> u;
    private List<Integer> v;
    private RecyclerView.j w = null;
    View x = null;
    int y = -1;
    b.h.k.d z;

    /* compiled from: ItemTouchHelper */
    class a implements Runnable {
        a() {
        }

        public void run() {
            f fVar = f.this;
            if (fVar.f1767c != null && fVar.E()) {
                f fVar2 = f.this;
                RecyclerView.d0 d0Var = fVar2.f1767c;
                if (d0Var != null) {
                    fVar2.z(d0Var);
                }
                f fVar3 = f.this;
                fVar3.r.removeCallbacks(fVar3.s);
                u.e0(f.this.r, this);
            }
        }
    }

    /* compiled from: ItemTouchHelper */
    class b implements RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            h s;
            f.this.z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                f.this.l = motionEvent.getPointerId(0);
                f.this.f1768d = motionEvent.getX();
                f.this.f1769e = motionEvent.getY();
                f.this.A();
                f fVar = f.this;
                if (fVar.f1767c == null && (s = fVar.s(motionEvent)) != null) {
                    f fVar2 = f.this;
                    fVar2.f1768d -= s.f1795j;
                    fVar2.f1769e -= s.f1796k;
                    fVar2.r(s.f1791f, true);
                    if (f.this.f1765a.remove(s.f1791f.f1565a)) {
                        f fVar3 = f.this;
                        fVar3.m.c(fVar3.r, s.f1791f);
                    }
                    f.this.F(s.f1791f, s.f1792g);
                    f fVar4 = f.this;
                    fVar4.L(motionEvent, fVar4.o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                f fVar5 = f.this;
                fVar5.l = -1;
                fVar5.F(null, 0);
            } else {
                int i2 = f.this.l;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    f.this.o(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = f.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (f.this.f1767c != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void c(RecyclerView recyclerView, MotionEvent motionEvent) {
            f.this.z.a(motionEvent);
            VelocityTracker velocityTracker = f.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (f.this.l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(f.this.l);
                if (findPointerIndex >= 0) {
                    f.this.o(actionMasked, motionEvent, findPointerIndex);
                }
                f fVar = f.this;
                RecyclerView.d0 d0Var = fVar.f1767c;
                if (d0Var != null) {
                    int i2 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = fVar.t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                f fVar2 = f.this;
                                if (pointerId == fVar2.l) {
                                    if (actionIndex == 0) {
                                        i2 = 1;
                                    }
                                    fVar2.l = motionEvent.getPointerId(i2);
                                    f fVar3 = f.this;
                                    fVar3.L(motionEvent, fVar3.o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            fVar.L(motionEvent, fVar.o, findPointerIndex);
                            f.this.z(d0Var);
                            f fVar4 = f.this;
                            fVar4.r.removeCallbacks(fVar4.s);
                            f.this.s.run();
                            f.this.r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    f.this.F(null, 0);
                    f.this.l = -1;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
            if (z) {
                f.this.F(null, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper */
    public class c extends h {
        final /* synthetic */ int o;
        final /* synthetic */ RecyclerView.d0 p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RecyclerView.d0 d0Var, int i2, int i3, float f2, float f3, float f4, float f5, int i4, RecyclerView.d0 d0Var2) {
            super(d0Var, i2, i3, f2, f3, f4, f5);
            this.o = i4;
            this.p = d0Var2;
        }

        @Override // androidx.recyclerview.widget.f.h
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.l) {
                if (this.o <= 0) {
                    f fVar = f.this;
                    fVar.m.c(fVar.r, this.p);
                } else {
                    f.this.f1765a.add(this.p.f1565a);
                    this.f1794i = true;
                    int i2 = this.o;
                    if (i2 > 0) {
                        f.this.B(this, i2);
                    }
                }
                f fVar2 = f.this;
                View view = fVar2.x;
                View view2 = this.p.f1565a;
                if (view == view2) {
                    fVar2.D(view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper */
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f1778b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1779c;

        d(h hVar, int i2) {
            this.f1778b = hVar;
            this.f1779c = i2;
        }

        public void run() {
            RecyclerView recyclerView = f.this.r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                h hVar = this.f1778b;
                if (!hVar.l && hVar.f1791f.j() != -1) {
                    RecyclerView.l itemAnimator = f.this.r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.q(null)) && !f.this.x()) {
                        f.this.m.B(this.f1778b.f1791f, this.f1779c);
                    } else {
                        f.this.r.post(this);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper */
    public class e implements RecyclerView.j {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i2, int i3) {
            f fVar = f.this;
            View view = fVar.x;
            if (view == null) {
                return i3;
            }
            int i4 = fVar.y;
            if (i4 == -1) {
                i4 = fVar.r.indexOfChild(view);
                f.this.y = i4;
            }
            if (i3 == i2 - 1) {
                return i4;
            }
            return i3 < i4 ? i3 : i3 + 1;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$f  reason: collision with other inner class name */
    /* compiled from: ItemTouchHelper */
    public static abstract class AbstractC0027f {

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f1782b = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final Interpolator f1783c = new b();

        /* renamed from: a  reason: collision with root package name */
        private int f1784a = -1;

        /* renamed from: androidx.recyclerview.widget.f$f$a */
        /* compiled from: ItemTouchHelper */
        static class a implements Interpolator {
            a() {
            }

            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        }

        /* renamed from: androidx.recyclerview.widget.f$f$b */
        /* compiled from: ItemTouchHelper */
        static class b implements Interpolator {
            b() {
            }

            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        }

        public static int e(int i2, int i3) {
            int i4;
            int i5 = i2 & 789516;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (i5 ^ -1);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= -789517 & i7;
                i4 = (i7 & 789516) << 2;
            }
            return i6 | i4;
        }

        private int i(RecyclerView recyclerView) {
            if (this.f1784a == -1) {
                this.f1784a = recyclerView.getResources().getDimensionPixelSize(b.q.b.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f1784a;
        }

        public static int s(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int t(int i2, int i3) {
            int s = s(0, i3 | i2);
            return s(2, i2) | s(1, i3) | s;
        }

        public void A(RecyclerView.d0 d0Var, int i2) {
            if (d0Var != null) {
                h.f1798a.b(d0Var.f1565a);
            }
        }

        public abstract void B(RecyclerView.d0 d0Var, int i2);

        public boolean a(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            return true;
        }

        public RecyclerView.d0 b(RecyclerView.d0 d0Var, List<RecyclerView.d0> list, int i2, int i3) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i2 + d0Var.f1565a.getWidth();
            int height = i3 + d0Var.f1565a.getHeight();
            int left2 = i2 - d0Var.f1565a.getLeft();
            int top2 = i3 - d0Var.f1565a.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.d0 d0Var3 = list.get(i5);
                if (left2 > 0 && (right = d0Var3.f1565a.getRight() - width) < 0 && d0Var3.f1565a.getRight() > d0Var.f1565a.getRight() && (abs4 = Math.abs(right)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = abs4;
                }
                if (left2 < 0 && (left = d0Var3.f1565a.getLeft() - i2) > 0 && d0Var3.f1565a.getLeft() < d0Var.f1565a.getLeft() && (abs3 = Math.abs(left)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = abs3;
                }
                if (top2 < 0 && (top = d0Var3.f1565a.getTop() - i3) > 0 && d0Var3.f1565a.getTop() < d0Var.f1565a.getTop() && (abs2 = Math.abs(top)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = abs2;
                }
                if (top2 > 0 && (bottom = d0Var3.f1565a.getBottom() - height) < 0 && d0Var3.f1565a.getBottom() > d0Var.f1565a.getBottom() && (abs = Math.abs(bottom)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = abs;
                }
            }
            return d0Var2;
        }

        public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            h.f1798a.a(d0Var.f1565a);
        }

        public int d(int i2, int i3) {
            int i4;
            int i5 = i2 & 3158064;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (i5 ^ -1);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= -3158065 & i7;
                i4 = (i7 & 3158064) >> 2;
            }
            return i6 | i4;
        }

        /* access modifiers changed from: package-private */
        public final int f(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return d(k(recyclerView, d0Var), u.B(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i2, float f2, float f3) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i2 == 8 ? 200 : 250;
            }
            if (i2 == 8) {
                return itemAnimator.n();
            }
            return itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public float j(RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.d0 d0Var);

        public float l(float f2) {
            return f2;
        }

        public float m(RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public float n(float f2) {
            return f2;
        }

        /* access modifiers changed from: package-private */
        public boolean o(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (f(recyclerView, d0Var) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            float f2 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i3)) * i(recyclerView))) * f1783c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2))));
            if (j2 <= 2000) {
                f2 = ((float) j2) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f1782b.getInterpolation(f2));
            if (interpolation == 0) {
                return i3 > 0 ? 1 : -1;
            }
            return interpolation;
        }

        public abstract boolean q();

        public abstract boolean r();

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f2, float f3, int i2, boolean z) {
            h.f1798a.d(canvas, recyclerView, d0Var.f1565a, f2, f3, i2, z);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f2, float f3, int i2, boolean z) {
            h.f1798a.c(canvas, recyclerView, d0Var.f1565a, f2, f3, i2, z);
        }

        /* access modifiers changed from: package-private */
        public void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<h> list, int i2, float f2, float f3) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                h hVar = list.get(i3);
                hVar.e();
                int save = canvas.save();
                u(canvas, recyclerView, hVar.f1791f, hVar.f1795j, hVar.f1796k, hVar.f1792g, false);
                canvas.restoreToCount(save);
            }
            if (d0Var != null) {
                int save2 = canvas.save();
                u(canvas, recyclerView, d0Var, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<h> list, int i2, float f2, float f3) {
            int size = list.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                h hVar = list.get(i3);
                int save = canvas.save();
                v(canvas, recyclerView, hVar.f1791f, hVar.f1795j, hVar.f1796k, hVar.f1792g, false);
                canvas.restoreToCount(save);
            }
            if (d0Var != null) {
                int save2 = canvas.save();
                v(canvas, recyclerView, d0Var, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                h hVar2 = list.get(i4);
                boolean z2 = hVar2.m;
                if (z2 && !hVar2.f1794i) {
                    list.remove(i4);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2);

        public void z(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3, int i4, int i5) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof i) {
                ((i) layoutManager).b(d0Var.f1565a, d0Var2.f1565a, i4, i5);
                return;
            }
            if (layoutManager.l()) {
                if (layoutManager.R(d0Var2.f1565a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.k1(i3);
                }
                if (layoutManager.U(d0Var2.f1565a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.k1(i3);
                }
            }
            if (layoutManager.m()) {
                if (layoutManager.V(d0Var2.f1565a) <= recyclerView.getPaddingTop()) {
                    recyclerView.k1(i3);
                }
                if (layoutManager.P(d0Var2.f1565a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.k1(i3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ItemTouchHelper */
    public class g extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1785b = true;

        g() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1785b = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View t;
            RecyclerView.d0 h0;
            int i2;
            if (this.f1785b && (t = f.this.t(motionEvent)) != null && (h0 = f.this.r.h0(t)) != null) {
                f fVar = f.this;
                if (fVar.m.o(fVar.r, h0) && motionEvent.getPointerId(0) == (i2 = f.this.l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    f fVar2 = f.this;
                    fVar2.f1768d = x;
                    fVar2.f1769e = y;
                    fVar2.f1773i = Utils.FLOAT_EPSILON;
                    fVar2.f1772h = Utils.FLOAT_EPSILON;
                    if (fVar2.m.r()) {
                        f.this.F(h0, 2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ItemTouchHelper */
    public static class h implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        final float f1787b;

        /* renamed from: c  reason: collision with root package name */
        final float f1788c;

        /* renamed from: d  reason: collision with root package name */
        final float f1789d;

        /* renamed from: e  reason: collision with root package name */
        final float f1790e;

        /* renamed from: f  reason: collision with root package name */
        final RecyclerView.d0 f1791f;

        /* renamed from: g  reason: collision with root package name */
        final int f1792g;

        /* renamed from: h  reason: collision with root package name */
        private final ValueAnimator f1793h;

        /* renamed from: i  reason: collision with root package name */
        boolean f1794i;

        /* renamed from: j  reason: collision with root package name */
        float f1795j;

        /* renamed from: k  reason: collision with root package name */
        float f1796k;
        boolean l = false;
        boolean m = false;
        private float n;

        /* compiled from: ItemTouchHelper */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        h(RecyclerView.d0 d0Var, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f1792g = i3;
            this.f1791f = d0Var;
            this.f1787b = f2;
            this.f1788c = f3;
            this.f1789d = f4;
            this.f1790e = f5;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(Utils.FLOAT_EPSILON, 1.0f);
            this.f1793h = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(d0Var.f1565a);
            ofFloat.addListener(this);
            c(Utils.FLOAT_EPSILON);
        }

        public void a() {
            this.f1793h.cancel();
        }

        public void b(long j2) {
            this.f1793h.setDuration(j2);
        }

        public void c(float f2) {
            this.n = f2;
        }

        public void d() {
            this.f1791f.G(false);
            this.f1793h.start();
        }

        public void e() {
            float f2 = this.f1787b;
            float f3 = this.f1789d;
            if (f2 == f3) {
                this.f1795j = this.f1791f.f1565a.getTranslationX();
            } else {
                this.f1795j = f2 + (this.n * (f3 - f2));
            }
            float f4 = this.f1788c;
            float f5 = this.f1790e;
            if (f4 == f5) {
                this.f1796k = this.f1791f.f1565a.getTranslationY();
            } else {
                this.f1796k = f4 + (this.n * (f5 - f4));
            }
        }

        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.m) {
                this.f1791f.G(true);
            }
            this.m = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: ItemTouchHelper */
    public interface i {
        void b(View view, View view2, int i2, int i3);
    }

    public f(AbstractC0027f fVar) {
        this.m = fVar;
    }

    private void C() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void G() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.h(this);
        this.r.k(this.B);
        this.r.j(this);
        I();
    }

    private void I() {
        this.A = new g();
        this.z = new b.h.k.d(this.r.getContext(), this.A);
    }

    private void J() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    private int K(RecyclerView.d0 d0Var) {
        if (this.n == 2) {
            return 0;
        }
        int k2 = this.m.k(this.r, d0Var);
        int d2 = (this.m.d(k2, u.B(this.r)) & 65280) >> 8;
        if (d2 == 0) {
            return 0;
        }
        int i2 = (k2 & 65280) >> 8;
        if (Math.abs(this.f1772h) > Math.abs(this.f1773i)) {
            int n2 = n(d0Var, d2);
            if (n2 > 0) {
                return (i2 & n2) == 0 ? AbstractC0027f.e(n2, u.B(this.r)) : n2;
            }
            int p2 = p(d0Var, d2);
            if (p2 > 0) {
                return p2;
            }
        } else {
            int p3 = p(d0Var, d2);
            if (p3 > 0) {
                return p3;
            }
            int n3 = n(d0Var, d2);
            if (n3 > 0) {
                return (i2 & n3) == 0 ? AbstractC0027f.e(n3, u.B(this.r)) : n3;
            }
        }
        return 0;
    }

    private void l() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.w == null) {
                this.w = new e();
            }
            this.r.setChildDrawingOrderCallback(this.w);
        }
    }

    private int n(RecyclerView.d0 d0Var, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 8;
        int i4 = this.f1772h > Utils.FLOAT_EPSILON ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            AbstractC0027f fVar = this.m;
            float f2 = this.f1771g;
            fVar.n(f2);
            velocityTracker.computeCurrentVelocity(1000, f2);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            if (xVelocity <= Utils.FLOAT_EPSILON) {
                i3 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3) {
                AbstractC0027f fVar2 = this.m;
                float f3 = this.f1770f;
                fVar2.l(f3);
                if (abs >= f3 && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
        }
        float width = ((float) this.r.getWidth()) * this.m.m(d0Var);
        if ((i2 & i4) == 0 || Math.abs(this.f1772h) <= width) {
            return 0;
        }
        return i4;
    }

    private int p(RecyclerView.d0 d0Var, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 2;
        int i4 = this.f1773i > Utils.FLOAT_EPSILON ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            AbstractC0027f fVar = this.m;
            float f2 = this.f1771g;
            fVar.n(f2);
            velocityTracker.computeCurrentVelocity(1000, f2);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            if (yVelocity <= Utils.FLOAT_EPSILON) {
                i3 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4) {
                AbstractC0027f fVar2 = this.m;
                float f3 = this.f1770f;
                fVar2.l(f3);
                if (abs >= f3 && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
        }
        float height = ((float) this.r.getHeight()) * this.m.m(d0Var);
        if ((i2 & i4) == 0 || Math.abs(this.f1773i) <= height) {
            return 0;
        }
        return i4;
    }

    private void q() {
        this.r.Y0(this);
        this.r.a1(this.B);
        this.r.Z0(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.m.c(this.r, this.p.get(0).f1791f);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        C();
        J();
    }

    private List<RecyclerView.d0> u(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List<RecyclerView.d0> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int h2 = this.m.h();
        int round = Math.round(this.f1774j + this.f1772h) - h2;
        int round2 = Math.round(this.f1775k + this.f1773i) - h2;
        int i2 = h2 * 2;
        int width = d0Var2.f1565a.getWidth() + round + i2;
        int height = d0Var2.f1565a.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int K = layoutManager.K();
        int i5 = 0;
        while (i5 < K) {
            View J = layoutManager.J(i5);
            if (J != d0Var2.f1565a && J.getBottom() >= round2 && J.getTop() <= height && J.getRight() >= round && J.getLeft() <= width) {
                RecyclerView.d0 h0 = this.r.h0(J);
                if (this.m.a(this.r, this.f1767c, h0)) {
                    int abs = Math.abs(i3 - ((J.getLeft() + J.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((J.getTop() + J.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.u.size();
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < size && i6 > this.v.get(i7).intValue()) {
                        i8++;
                        i7++;
                    }
                    this.u.add(i8, h0);
                    this.v.add(i8, Integer.valueOf(i6));
                }
            }
            i5++;
            d0Var2 = d0Var;
        }
        return this.u;
    }

    private RecyclerView.d0 v(MotionEvent motionEvent) {
        View t2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int i2 = this.l;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f1768d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f1769e);
        int i3 = this.q;
        if (abs < ((float) i3) && abs2 < ((float) i3)) {
            return null;
        }
        if (abs > abs2 && layoutManager.l()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.m()) && (t2 = t(motionEvent)) != null) {
            return this.r.h0(t2);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.f1774j + this.f1772h) - ((float) this.f1767c.f1565a.getLeft());
        } else {
            fArr[0] = this.f1767c.f1565a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.f1775k + this.f1773i) - ((float) this.f1767c.f1565a.getTop());
        } else {
            fArr[1] = this.f1767c.f1565a.getTranslationY();
        }
    }

    private static boolean y(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    /* access modifiers changed from: package-private */
    public void A() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    /* access modifiers changed from: package-private */
    public void B(h hVar, int i2) {
        this.r.post(new d(hVar, i2));
    }

    /* access modifiers changed from: package-private */
    public void D(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean E() {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.E():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(androidx.recyclerview.widget.RecyclerView.d0 r24, int r25) {
        /*
        // Method dump skipped, instructions count: 335
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.F(androidx.recyclerview.widget.RecyclerView$d0, int):void");
    }

    public void H(RecyclerView.d0 d0Var) {
        if (!this.m.o(this.r, d0Var)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (d0Var.f1565a.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            A();
            this.f1773i = Utils.FLOAT_EPSILON;
            this.f1772h = Utils.FLOAT_EPSILON;
            F(d0Var, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.f1768d;
        this.f1772h = f2;
        this.f1773i = y2 - this.f1769e;
        if ((i2 & 4) == 0) {
            this.f1772h = Math.max((float) Utils.FLOAT_EPSILON, f2);
        }
        if ((i2 & 8) == 0) {
            this.f1772h = Math.min((float) Utils.FLOAT_EPSILON, this.f1772h);
        }
        if ((i2 & 1) == 0) {
            this.f1773i = Math.max((float) Utils.FLOAT_EPSILON, this.f1773i);
        }
        if ((i2 & 2) == 0) {
            this.f1773i = Math.min((float) Utils.FLOAT_EPSILON, this.f1773i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void d(View view) {
        D(view);
        RecyclerView.d0 h0 = this.r.h0(view);
        if (h0 != null) {
            RecyclerView.d0 d0Var = this.f1767c;
            if (d0Var == null || h0 != d0Var) {
                r(h0, false);
                if (this.f1765a.remove(h0.f1565a)) {
                    this.m.c(this.r, h0);
                    return;
                }
                return;
            }
            F(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f2;
        float f3;
        this.y = -1;
        if (this.f1767c != null) {
            w(this.f1766b);
            float[] fArr = this.f1766b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = Utils.FLOAT_EPSILON;
            f2 = Utils.FLOAT_EPSILON;
        }
        this.m.w(canvas, recyclerView, this.f1767c, this.p, this.n, f3, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f2;
        float f3;
        if (this.f1767c != null) {
            w(this.f1766b);
            float[] fArr = this.f1766b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = Utils.FLOAT_EPSILON;
            f2 = Utils.FLOAT_EPSILON;
        }
        this.m.x(canvas, recyclerView, this.f1767c, this.p, this.n, f3, f2);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                q();
            }
            this.r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f1770f = resources.getDimension(b.q.b.item_touch_helper_swipe_escape_velocity);
                this.f1771g = resources.getDimension(b.q.b.item_touch_helper_swipe_escape_max_velocity);
                G();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.d0 v2;
        int f2;
        if (this.f1767c == null && i2 == 2 && this.n != 2 && this.m.q() && this.r.getScrollState() != 1 && (v2 = v(motionEvent)) != null && (f2 = (this.m.f(this.r, v2) & 65280) >> 8) != 0) {
            float x2 = motionEvent.getX(i3);
            float y2 = motionEvent.getY(i3);
            float f3 = x2 - this.f1768d;
            float f4 = y2 - this.f1769e;
            float abs = Math.abs(f3);
            float abs2 = Math.abs(f4);
            int i4 = this.q;
            if (abs >= ((float) i4) || abs2 >= ((float) i4)) {
                if (abs > abs2) {
                    if (f3 < Utils.FLOAT_EPSILON && (f2 & 4) == 0) {
                        return;
                    }
                    if (f3 > Utils.FLOAT_EPSILON && (f2 & 8) == 0) {
                        return;
                    }
                } else if (f4 < Utils.FLOAT_EPSILON && (f2 & 1) == 0) {
                    return;
                } else {
                    if (f4 > Utils.FLOAT_EPSILON && (f2 & 2) == 0) {
                        return;
                    }
                }
                this.f1773i = Utils.FLOAT_EPSILON;
                this.f1772h = Utils.FLOAT_EPSILON;
                this.l = motionEvent.getPointerId(0);
                F(v2, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(RecyclerView.d0 d0Var, boolean z2) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            h hVar = this.p.get(size);
            if (hVar.f1791f == d0Var) {
                hVar.l |= z2;
                if (!hVar.m) {
                    hVar.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public h s(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View t2 = t(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            h hVar = this.p.get(size);
            if (hVar.f1791f.f1565a == t2) {
                return hVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View t(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.d0 d0Var = this.f1767c;
        if (d0Var != null) {
            View view = d0Var.f1565a;
            if (y(view, x2, y2, this.f1774j + this.f1772h, this.f1775k + this.f1773i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            h hVar = this.p.get(size);
            View view2 = hVar.f1791f.f1565a;
            if (y(view2, x2, y2, hVar.f1795j, hVar.f1796k)) {
                return view2;
            }
        }
        return this.r.S(x2, y2);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.p.get(i2).m) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void z(RecyclerView.d0 d0Var) {
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float j2 = this.m.j(d0Var);
            int i2 = (int) (this.f1774j + this.f1772h);
            int i3 = (int) (this.f1775k + this.f1773i);
            if (((float) Math.abs(i3 - d0Var.f1565a.getTop())) >= ((float) d0Var.f1565a.getHeight()) * j2 || ((float) Math.abs(i2 - d0Var.f1565a.getLeft())) >= ((float) d0Var.f1565a.getWidth()) * j2) {
                List<RecyclerView.d0> u2 = u(d0Var);
                if (u2.size() != 0) {
                    RecyclerView.d0 b2 = this.m.b(d0Var, u2, i2, i3);
                    if (b2 == null) {
                        this.u.clear();
                        this.v.clear();
                        return;
                    }
                    int j3 = b2.j();
                    int j4 = d0Var.j();
                    if (this.m.y(this.r, d0Var, b2)) {
                        this.m.z(this.r, d0Var, j4, b2, j3, i2, i3);
                    }
                }
            }
        }
    }
}
