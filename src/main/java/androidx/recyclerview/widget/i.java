package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState */
class i {

    /* renamed from: a  reason: collision with root package name */
    boolean f1799a = true;

    /* renamed from: b  reason: collision with root package name */
    int f1800b;

    /* renamed from: c  reason: collision with root package name */
    int f1801c;

    /* renamed from: d  reason: collision with root package name */
    int f1802d;

    /* renamed from: e  reason: collision with root package name */
    int f1803e;

    /* renamed from: f  reason: collision with root package name */
    int f1804f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f1805g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f1806h;

    /* renamed from: i  reason: collision with root package name */
    boolean f1807i;

    i() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.a0 a0Var) {
        int i2 = this.f1801c;
        return i2 >= 0 && i2 < a0Var.b();
    }

    /* access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o = vVar.o(this.f1801c);
        this.f1801c += this.f1802d;
        return o;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1800b + ", mCurrentPosition=" + this.f1801c + ", mItemDirection=" + this.f1802d + ", mLayoutDirection=" + this.f1803e + ", mStartLine=" + this.f1804f + ", mEndLine=" + this.f1805g + '}';
    }
}
