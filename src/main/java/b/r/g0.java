package b.r;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ViewUtilsApi23 */
class g0 extends f0 {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2874i = true;

    g0() {
    }

    @Override // b.r.i0
    @SuppressLint({"NewApi"})
    public void g(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i2);
        } else if (f2874i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f2874i = false;
            }
        }
    }
}
