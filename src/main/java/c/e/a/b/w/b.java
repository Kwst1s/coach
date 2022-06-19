package c.e.a.b.w;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final View f3442a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3443b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f3444c = 0;

    public b(a aVar) {
        this.f3442a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f3442a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).f(this.f3442a);
        }
    }

    public int b() {
        return this.f3444c;
    }

    public boolean c() {
        return this.f3443b;
    }

    public void d(Bundle bundle) {
        this.f3443b = bundle.getBoolean("expanded", false);
        this.f3444c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f3443b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f3443b);
        bundle.putInt("expandedComponentIdHint", this.f3444c);
        return bundle;
    }

    public void f(int i2) {
        this.f3444c = i2;
    }
}
