package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: LinearSmoothScroller */
public class j extends RecyclerView.z {

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f1808i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f1809j = new DecelerateInterpolator();

    /* renamed from: k  reason: collision with root package name */
    protected PointF f1810k;
    private final DisplayMetrics l;
    private boolean m = false;
    private float n;
    protected int o = 0;
    protected int p = 0;

    public j(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.m) {
            this.n = v(this.l);
            this.m = true;
        }
        return this.n;
    }

    private int y(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public int B() {
        PointF pointF = this.f1810k;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != Utils.FLOAT_EPSILON) {
                return f2 > Utils.FLOAT_EPSILON ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void C(RecyclerView.z.a aVar) {
        PointF a2 = a(f());
        if (a2 == null || (a2.x == Utils.FLOAT_EPSILON && a2.y == Utils.FLOAT_EPSILON)) {
            aVar.b(f());
            r();
            return;
        }
        i(a2);
        this.f1810k = a2;
        this.o = (int) (a2.x * 10000.0f);
        this.p = (int) (a2.y * 10000.0f);
        aVar.d((int) (((float) this.o) * 1.2f), (int) (((float) this.p) * 1.2f), (int) (((float) x(10000)) * 1.2f), this.f1808i);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void l(int i2, int i3, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.o = y(this.o, i2);
        int y = y(this.p, i3);
        this.p = y;
        if (this.o == 0 && y == 0) {
            C(aVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void m() {
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void n() {
        this.p = 0;
        this.o = 0;
        this.f1810k = null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        int t = t(view, z());
        int u = u(view, B());
        int w = w((int) Math.sqrt((double) ((t * t) + (u * u))));
        if (w > 0) {
            aVar.d(-t, -u, w, this.f1809j);
        }
    }

    public int s(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int t(View view, int i2) {
        RecyclerView.o e2 = e();
        if (e2 == null || !e2.l()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e2.R(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, e2.U(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, e2.f0(), e2.p0() - e2.g0(), i2);
    }

    public int u(View view, int i2) {
        RecyclerView.o e2 = e();
        if (e2 == null || !e2.m()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e2.V(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, e2.P(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, e2.h0(), e2.X() - e2.e0(), i2);
    }

    /* access modifiers changed from: protected */
    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int w(int i2) {
        double x = (double) x(i2);
        Double.isNaN(x);
        return (int) Math.ceil(x / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int x(int i2) {
        return (int) Math.ceil((double) (((float) Math.abs(i2)) * A()));
    }

    /* access modifiers changed from: protected */
    public int z() {
        PointF pointF = this.f1810k;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != Utils.FLOAT_EPSILON) {
                return f2 > Utils.FLOAT_EPSILON ? 1 : -1;
            }
        }
        return 0;
    }
}
