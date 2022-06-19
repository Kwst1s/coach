package b.r;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21 */
class e0 extends d0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2871f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f2872g = true;

    e0() {
    }

    @Override // b.r.i0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f2871f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2871f = false;
            }
        }
    }

    @Override // b.r.i0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f2872g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2872g = false;
            }
        }
    }
}
