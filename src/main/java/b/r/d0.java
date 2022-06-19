package b.r;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19 */
class d0 extends i0 {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2861e = true;

    d0() {
    }

    @Override // b.r.i0
    public void a(View view) {
    }

    @Override // b.r.i0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f2861e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2861e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // b.r.i0
    public void d(View view) {
    }

    @Override // b.r.i0
    @SuppressLint({"NewApi"})
    public void f(View view, float f2) {
        if (f2861e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f2861e = false;
            }
        }
        view.setAlpha(f2);
    }
}
