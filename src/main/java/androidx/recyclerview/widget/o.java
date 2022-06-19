package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* access modifiers changed from: package-private */
/* compiled from: ScrollbarHelper */
public class o {
    static int a(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.K() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1;
        }
        return Math.min(mVar.n(), mVar.d(view2) - mVar.g(view));
    }

    static int b(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        int i2;
        if (oVar.K() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.i0(view), oVar.i0(view2));
        int max = Math.max(oVar.i0(view), oVar.i0(view2));
        if (z2) {
            i2 = Math.max(0, (a0Var.b() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(mVar.d(view2) - mVar.g(view))) / ((float) (Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1)))) + ((float) (mVar.m() - mVar.g(view))));
    }

    static int c(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.K() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.b();
        }
        return (int) ((((float) (mVar.d(view2) - mVar.g(view))) / ((float) (Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1))) * ((float) a0Var.b()));
    }
}
