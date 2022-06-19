package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import com.github.mikephil.charting.utils.Utils;

public class TurnLayoutManager extends LinearLayoutManager {
    private Context I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private Point N;

    class a extends j {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public PointF a(int i2) {
            return TurnLayoutManager.this.a(i2);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.j
        public float v(DisplayMetrics displayMetrics) {
            return 50.0f / ((float) displayMetrics.densityDpi);
        }
    }

    private Point P2(int i2, int i3, int i4, int i5, Point point) {
        int i6;
        int i7;
        int i8 = 1;
        int i9 = i2 == 8388611 ? -1 : 1;
        if (i2 == 8388611) {
            i8 = 0;
        }
        if (i3 != 0) {
            i6 = X() / 2;
            i7 = (i8 * p0()) + (i9 * Math.abs(i4 - i5));
        } else {
            i6 = (i8 * X()) + (i9 * Math.abs(i4 - i5));
            i7 = p0() / 2;
        }
        point.set(i7, i6);
        return point;
    }

    private int Q2(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    private double R2(double d2, double d3, Point point, int i2) {
        double d4 = (double) point.y;
        Double.isNaN(d4);
        double abs = Math.abs(d4 - d3);
        double sqrt = Math.sqrt((d2 * d2) - (abs * abs)) - d2;
        double d5 = (double) i2;
        Double.isNaN(d5);
        return sqrt + d5;
    }

    private double S2(double d2, double d3, Point point, int i2) {
        double d4 = (double) point.x;
        Double.isNaN(d4);
        double abs = Math.abs(d4 - d3);
        double sqrt = Math.sqrt((d2 * d2) - (abs * abs)) - d2;
        double d5 = (double) i2;
        Double.isNaN(d5);
        return sqrt + d5;
    }

    private void T2(int i2, int i3, int i4, Point point, int i5) {
        if (i3 == 1) {
            V2(i2, i4, point, i5);
        } else if (i3 == 0) {
            U2(i2, i4, point, i5);
        }
    }

    private void U2(int i2, int i3, Point point, int i4) {
        int i5;
        for (int i6 = 0; i6 < K(); i6++) {
            View J2 = J(i6);
            RecyclerView.p pVar = (RecyclerView.p) J2.getLayoutParams();
            int S2 = (int) S2((double) i3, (double) (J2.getX() + ((float) (J2.getWidth() / 2))), point, i4);
            if (i2 == 8388611) {
                i5 = S2 + Q2(pVar);
            } else {
                i5 = ((X() - S2) - J2.getHeight()) - Q2(pVar);
            }
            J2.layout(J2.getLeft(), i5, J2.getRight(), J2.getHeight() + i5);
            W2(i2, J2, i3, point);
        }
    }

    private void V2(int i2, int i3, Point point, int i4) {
        int i5;
        for (int i6 = 0; i6 < K(); i6++) {
            View J2 = J(i6);
            RecyclerView.p pVar = (RecyclerView.p) J2.getLayoutParams();
            int R2 = (int) R2((double) i3, (double) (J2.getY() + ((float) (J2.getHeight() / 2))), point, i4);
            if (i2 == 8388611) {
                i5 = R2 + Q2(pVar);
            } else {
                i5 = ((p0() - R2) - J2.getWidth()) - Q2(pVar);
            }
            J2.layout(i5, J2.getTop(), J2.getWidth() + i5, J2.getBottom());
            X2(i2, J2, i3, point);
        }
    }

    private void W2(int i2, View view, int i3, Point point) {
        if (!this.M) {
            view.setRotation(Utils.FLOAT_EPSILON);
            return;
        }
        boolean z = view.getX() + ((float) (view.getWidth() / 2)) > ((float) point.x);
        float f2 = -1.0f;
        if (i2 != 8388613 ? !z : z) {
            f2 = 1.0f;
        }
        double d2 = (double) f2;
        double degrees = Math.toDegrees(Math.asin((double) (Math.abs((view.getX() + ((float) (view.getWidth() / 2))) - ((float) point.x)) / ((float) i3))));
        Double.isNaN(d2);
        view.setRotation((float) (d2 * degrees));
    }

    private void X2(int i2, View view, int i3, Point point) {
        if (!this.M) {
            view.setRotation(Utils.FLOAT_EPSILON);
            return;
        }
        boolean z = view.getY() + ((float) (view.getHeight() / 2)) > ((float) point.y);
        float f2 = 1.0f;
        if (i2 != 8388613 ? !z : z) {
            f2 = -1.0f;
        }
        double d2 = (double) f2;
        double degrees = Math.toDegrees(Math.asin((double) (Math.abs((view.getY() + ((float) (view.getHeight() / 2))) - ((float) point.y)) / ((float) i3))));
        Double.isNaN(d2);
        view.setRotation((float) (d2 * degrees));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void J1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i2) {
        a aVar = new a(this.I);
        aVar.p(i2);
        K1(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void Y0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        super.Y0(vVar, a0Var);
        int i2 = this.J;
        int q2 = q2();
        int i3 = this.K;
        int i4 = this.L;
        Point point = this.N;
        P2(i2, q2, i3, i4, point);
        this.N = point;
        T2(this.J, q2(), this.K, this.N, this.L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int x1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int x1 = super.x1(i2, vVar, a0Var);
        U2(this.J, this.K, this.N, this.L);
        return x1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int z1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int z1 = super.z1(i2, vVar, a0Var);
        V2(this.J, this.K, this.N, this.L);
        return z1;
    }
}
