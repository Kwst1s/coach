package b.r;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29 */
class h0 extends g0 {
    h0() {
    }

    @Override // b.r.d0, b.r.i0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // b.r.f0, b.r.i0
    public void e(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // b.r.d0, b.r.i0
    public void f(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // b.r.g0, b.r.i0
    public void g(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // b.r.e0, b.r.i0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // b.r.e0, b.r.i0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
