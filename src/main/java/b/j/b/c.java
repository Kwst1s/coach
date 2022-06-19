package b.j.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* compiled from: ViewDragHelper */
public class c {
    private static final Interpolator w = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f2735a;

    /* renamed from: b  reason: collision with root package name */
    private int f2736b;

    /* renamed from: c  reason: collision with root package name */
    private int f2737c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f2738d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f2739e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f2740f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f2741g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f2742h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f2743i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f2744j;

    /* renamed from: k  reason: collision with root package name */
    private int f2745k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final AbstractC0054c r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable v = new b();

    /* compiled from: ViewDragHelper */
    static class a implements Interpolator {
        a() {
        }

        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper */
    class b implements Runnable {
        b() {
        }

        public void run() {
            c.this.K(0);
        }
    }

    /* renamed from: b.j.b.c$c  reason: collision with other inner class name */
    /* compiled from: ViewDragHelper */
    public static abstract class AbstractC0054c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int c(int i2) {
            return i2;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }

        public void j(int i2) {
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
        }

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0054c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.u = viewGroup;
            this.r = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f2736b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = new OverScroller(context, w);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean D(int i2) {
        if (C(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void G() {
        this.l.computeCurrentVelocity(1000, this.m);
        q(h(this.l.getXVelocity(this.f2737c), this.n, this.m), h(this.l.getYVelocity(this.f2737c), this.n, this.m));
    }

    private void H(float f2, float f3, int i2) {
        int i3 = 1;
        if (!d(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (d(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (d(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (d(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f2743i;
            iArr[i2] = iArr[i2] | i3;
            this.r.f(i3, i2);
        }
    }

    private void I(float f2, float f3, int i2) {
        t(i2);
        float[] fArr = this.f2738d;
        this.f2740f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f2739e;
        this.f2741g[i2] = f3;
        fArr2[i2] = f3;
        this.f2742h[i2] = y((int) f2, (int) f3);
        this.f2745k |= 1 << i2;
    }

    private void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (D(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f2740f[pointerId] = x;
                this.f2741g[pointerId] = y;
            }
        }
    }

    private boolean d(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f2742h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.f2744j[i2] & i3) == i3 || (this.f2743i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f2736b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.r.g(i3)) {
            int[] iArr = this.f2744j;
            iArr[i2] = iArr[i2] | i3;
            return false;
        } else if ((this.f2743i[i2] & i3) != 0 || abs <= ((float) this.f2736b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean g(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.d(view) > 0;
        boolean z2 = this.r.e(view) > 0;
        if (z && z2) {
            int i2 = this.f2736b;
            if ((f2 * f2) + (f3 * f3) > ((float) (i2 * i2))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f2) > ((float) this.f2736b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f3) <= ((float) this.f2736b)) {
            return false;
        } else {
            return true;
        }
    }

    private float h(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return Utils.FLOAT_EPSILON;
        }
        if (abs > f4) {
            return f2 > Utils.FLOAT_EPSILON ? f4 : -f4;
        }
        return f2;
    }

    private int i(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    private void j() {
        float[] fArr = this.f2738d;
        if (fArr != null) {
            Arrays.fill(fArr, (float) Utils.FLOAT_EPSILON);
            Arrays.fill(this.f2739e, (float) Utils.FLOAT_EPSILON);
            Arrays.fill(this.f2740f, (float) Utils.FLOAT_EPSILON);
            Arrays.fill(this.f2741g, (float) Utils.FLOAT_EPSILON);
            Arrays.fill(this.f2742h, 0);
            Arrays.fill(this.f2743i, 0);
            Arrays.fill(this.f2744j, 0);
            this.f2745k = 0;
        }
    }

    private void k(int i2) {
        if (this.f2738d != null && C(i2)) {
            this.f2738d[i2] = 0.0f;
            this.f2739e[i2] = 0.0f;
            this.f2740f[i2] = 0.0f;
            this.f2741g[i2] = 0.0f;
            this.f2742h[i2] = 0;
            this.f2743i[i2] = 0;
            this.f2744j[i2] = 0;
            this.f2745k = ((1 << i2) ^ -1) & this.f2745k;
        }
    }

    private int l(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f2 = (float) (width / 2);
        float r2 = f2 + (r(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(r2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    private int m(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i6 = i(i4, (int) this.n, (int) this.m);
        int i7 = i(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(i6);
        int abs4 = Math.abs(i7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (i6 != 0) {
            f3 = (float) abs3;
            f2 = (float) i8;
        } else {
            f3 = (float) abs;
            f2 = (float) i9;
        }
        float f6 = f3 / f2;
        if (i7 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        float f7 = f5 / f4;
        return (int) ((((float) l(i2, i6, this.r.d(view))) * f6) + (((float) l(i3, i7, this.r.e(view))) * f7));
    }

    public static c o(ViewGroup viewGroup, float f2, AbstractC0054c cVar) {
        c p2 = p(viewGroup, cVar);
        p2.f2736b = (int) (((float) p2.f2736b) * (1.0f / f2));
        return p2;
    }

    public static c p(ViewGroup viewGroup, AbstractC0054c cVar) {
        return new c(viewGroup.getContext(), viewGroup, cVar);
    }

    private void q(float f2, float f3) {
        this.t = true;
        this.r.l(this.s, f2, f3);
        this.t = false;
        if (this.f2735a == 1) {
            K(0);
        }
    }

    private float r(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    private void s(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i4 != 0) {
            i2 = this.r.a(this.s, i2, i4);
            u.X(this.s, i2 - left);
        }
        if (i5 != 0) {
            i3 = this.r.b(this.s, i3, i5);
            u.Y(this.s, i3 - top);
        }
        if (i4 != 0 || i5 != 0) {
            this.r.k(this.s, i2, i3, i2 - left, i3 - top);
        }
    }

    private void t(int i2) {
        float[] fArr = this.f2738d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f2739e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2740f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f2741g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f2742h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2743i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2744j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2738d = fArr2;
            this.f2739e = fArr3;
            this.f2740f = fArr4;
            this.f2741g = fArr5;
            this.f2742h = iArr;
            this.f2743i = iArr2;
            this.f2744j = iArr3;
        }
    }

    private boolean v(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.abortAnimation();
            K(0);
            return false;
        }
        this.q.startScroll(left, top, i6, i7, m(this.s, i6, i7, i4, i5));
        K(2);
        return true;
    }

    private int y(int i2, int i3) {
        int i4 = i2 < this.u.getLeft() + this.o ? 1 : 0;
        if (i3 < this.u.getTop() + this.o) {
            i4 |= 4;
        }
        if (i2 > this.u.getRight() - this.o) {
            i4 |= 2;
        }
        return i3 > this.u.getBottom() - this.o ? i4 | 8 : i4;
    }

    public int A() {
        return this.f2735a;
    }

    public boolean B(int i2, int i3) {
        return E(this.s, i2, i3);
    }

    public boolean C(int i2) {
        return ((1 << i2) & this.f2745k) != 0;
    }

    public boolean E(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void F(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View u2 = u((int) x, (int) y);
            I(x, y, pointerId);
            Q(u2, pointerId);
            int i4 = this.f2742h[pointerId];
            int i5 = this.p;
            if ((i4 & i5) != 0) {
                this.r.h(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f2735a == 1) {
                G();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f2735a == 1) {
                    q(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                I(x2, y2, pointerId2);
                if (this.f2735a == 0) {
                    Q(u((int) x2, (int) y2), pointerId2);
                    int i6 = this.f2742h[pointerId2];
                    int i7 = this.p;
                    if ((i6 & i7) != 0) {
                        this.r.h(i6 & i7, pointerId2);
                    }
                } else if (B((int) x2, (int) y2)) {
                    Q(this.s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f2735a == 1 && pointerId3 == this.f2737c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.f2737c) {
                            View u3 = u((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view = this.s;
                            if (u3 == view && Q(view, pointerId4)) {
                                i2 = this.f2737c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        G();
                    }
                }
                k(pointerId3);
            }
        } else if (this.f2735a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                if (D(pointerId5)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f2738d[pointerId5];
                    float f3 = y3 - this.f2739e[pointerId5];
                    H(f2, f3, pointerId5);
                    if (this.f2735a != 1) {
                        View u4 = u((int) x3, (int) y3);
                        if (g(u4, f2, f3) && Q(u4, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            J(motionEvent);
        } else if (D(this.f2737c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f2737c);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f2740f;
            int i8 = this.f2737c;
            int i9 = (int) (x4 - fArr[i8]);
            int i10 = (int) (y4 - this.f2741g[i8]);
            s(this.s.getLeft() + i9, this.s.getTop() + i10, i9, i10);
            J(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(int i2) {
        this.u.removeCallbacks(this.v);
        if (this.f2735a != i2) {
            this.f2735a = i2;
            this.r.j(i2);
            if (this.f2735a == 0) {
                this.s = null;
            }
        }
    }

    public void L(int i2) {
        this.p = i2;
    }

    public void M(float f2) {
        this.n = f2;
    }

    public boolean N(int i2, int i3) {
        if (this.t) {
            return v(i2, i3, (int) this.l.getXVelocity(this.f2737c), (int) this.l.getYVelocity(this.f2737c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O(android.view.MotionEvent r17) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: b.j.b.c.O(android.view.MotionEvent):boolean");
    }

    public boolean P(View view, int i2, int i3) {
        this.s = view;
        this.f2737c = -1;
        boolean v2 = v(i2, i3, 0, 0);
        if (!v2 && this.f2735a == 0 && this.s != null) {
            this.s = null;
        }
        return v2;
    }

    /* access modifiers changed from: package-private */
    public boolean Q(View view, int i2) {
        if (view == this.s && this.f2737c == i2) {
            return true;
        }
        if (view == null || !this.r.m(view, i2)) {
            return false;
        }
        this.f2737c = i2;
        c(view, i2);
        return true;
    }

    public void a() {
        b();
        if (this.f2735a == 2) {
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            this.q.abortAnimation();
            int currX2 = this.q.getCurrX();
            int currY2 = this.q.getCurrY();
            this.r.k(this.s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        K(0);
    }

    public void b() {
        this.f2737c = -1;
        j();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void c(View view, int i2) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.f2737c = i2;
            this.r.i(view, i2);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public boolean e(int i2) {
        int length = this.f2738d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (f(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i2, int i3) {
        if (!C(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f2 = this.f2740f[i3] - this.f2738d[i3];
        float f3 = this.f2741g[i3] - this.f2739e[i3];
        if (z && z2) {
            int i4 = this.f2736b;
            if ((f2 * f2) + (f3 * f3) > ((float) (i4 * i4))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f2) > ((float) this.f2736b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f3) <= ((float) this.f2736b)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean n(boolean z) {
        if (this.f2735a == 2) {
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                u.X(this.s, left);
            }
            if (top != 0) {
                u.Y(this.s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.r.k(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    K(0);
                }
            }
        }
        if (this.f2735a == 2) {
            return true;
        }
        return false;
    }

    public View u(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.u;
            this.r.c(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View w() {
        return this.s;
    }

    public int x() {
        return this.o;
    }

    public int z() {
        return this.f2736b;
    }
}
