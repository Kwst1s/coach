package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: LinearSnapHelper */
public class k extends q {

    /* renamed from: d  reason: collision with root package name */
    private m f1811d;

    /* renamed from: e  reason: collision with root package name */
    private m f1812e;

    private float m(RecyclerView.o oVar, m mVar) {
        int max;
        int K = oVar.K();
        if (K == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < K; i4++) {
            View J = oVar.J(i4);
            int i0 = oVar.i0(J);
            if (i0 != -1) {
                if (i0 < i2) {
                    view = J;
                    i2 = i0;
                }
                if (i0 > i3) {
                    view2 = J;
                    i3 = i0;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(mVar.d(view), mVar.d(view2)) - Math.min(mVar.g(view), mVar.g(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i3 - i2) + 1));
    }

    private int n(RecyclerView.o oVar, View view, m mVar) {
        return (mVar.g(view) + (mVar.e(view) / 2)) - (mVar.m() + (mVar.n() / 2));
    }

    private int o(RecyclerView.o oVar, m mVar, int i2, int i3) {
        int[] d2 = d(i2, i3);
        float m = m(oVar, mVar);
        if (m <= Utils.FLOAT_EPSILON) {
            return 0;
        }
        return Math.round(((float) (Math.abs(d2[0]) > Math.abs(d2[1]) ? d2[0] : d2[1])) / m);
    }

    private View p(RecyclerView.o oVar, m mVar) {
        int K = oVar.K();
        View view = null;
        if (K == 0) {
            return null;
        }
        int m = mVar.m() + (mVar.n() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < K; i3++) {
            View J = oVar.J(i3);
            int abs = Math.abs((mVar.g(J) + (mVar.e(J) / 2)) - m);
            if (abs < i2) {
                view = J;
                i2 = abs;
            }
        }
        return view;
    }

    private m q(RecyclerView.o oVar) {
        m mVar = this.f1812e;
        if (mVar == null || mVar.f1814a != oVar) {
            this.f1812e = m.a(oVar);
        }
        return this.f1812e;
    }

    private m r(RecyclerView.o oVar) {
        m mVar = this.f1811d;
        if (mVar == null || mVar.f1814a != oVar) {
            this.f1811d = m.c(oVar);
        }
        return this.f1811d;
    }

    @Override // androidx.recyclerview.widget.q
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.l()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.m()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.q
    public View h(RecyclerView.o oVar) {
        if (oVar.m()) {
            return p(oVar, r(oVar));
        }
        if (oVar.l()) {
            return p(oVar, q(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.q
    public int i(RecyclerView.o oVar, int i2, int i3) {
        int Z;
        View h2;
        int i0;
        int i4;
        PointF a2;
        int i5;
        int i6;
        if (!(oVar instanceof RecyclerView.z.b) || (Z = oVar.Z()) == 0 || (h2 = h(oVar)) == null || (i0 = oVar.i0(h2)) == -1 || (a2 = ((RecyclerView.z.b) oVar).a(Z - 1)) == null) {
            return -1;
        }
        int i7 = 0;
        if (oVar.l()) {
            i5 = o(oVar, q(oVar), i2, 0);
            if (a2.x < Utils.FLOAT_EPSILON) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (oVar.m()) {
            i6 = o(oVar, r(oVar), 0, i3);
            if (a2.y < Utils.FLOAT_EPSILON) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (oVar.m()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i8 = i0 + i5;
        if (i8 >= 0) {
            i7 = i8;
        }
        return i7 >= Z ? i4 : i7;
    }
}
