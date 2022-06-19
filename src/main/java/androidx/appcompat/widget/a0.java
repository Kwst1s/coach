package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.p;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ForwardingListener */
public abstract class a0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final float f549b;

    /* renamed from: c  reason: collision with root package name */
    private final int f550c;

    /* renamed from: d  reason: collision with root package name */
    private final int f551d;

    /* renamed from: e  reason: collision with root package name */
    final View f552e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f553f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f554g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f555h;

    /* renamed from: i  reason: collision with root package name */
    private int f556i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f557j = new int[2];

    /* access modifiers changed from: private */
    /* compiled from: ForwardingListener */
    public class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = a0.this.f552e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ForwardingListener */
    public class b implements Runnable {
        b() {
        }

        public void run() {
            a0.this.e();
        }
    }

    public a0(View view) {
        this.f552e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f549b = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f550c = tapTimeout;
        this.f551d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f554g;
        if (runnable != null) {
            this.f552e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f553f;
        if (runnable2 != null) {
            this.f552e.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        y yVar;
        View view = this.f552e;
        p b2 = b();
        if (b2 == null || !b2.c() || (yVar = (y) b2.h()) == null || !yVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(yVar, obtainNoHistory);
        boolean e2 = yVar.e(obtainNoHistory, this.f556i);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
        if (!e2 || !z) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r6) {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a0.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f557j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f557j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public abstract p b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public boolean d() {
        p b2 = b();
        if (b2 == null || !b2.c()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a();
        View view = this.f552e;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f555h = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f555h;
        if (z2) {
            z = f(motionEvent) || !d();
        } else {
            z = g(motionEvent) && c();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0);
                this.f552e.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f555h = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f555h = false;
        this.f556i = -1;
        Runnable runnable = this.f553f;
        if (runnable != null) {
            this.f552e.removeCallbacks(runnable);
        }
    }
}
