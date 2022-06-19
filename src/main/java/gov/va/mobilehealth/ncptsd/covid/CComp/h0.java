package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.m;
import kotlin.m.b.f;

/* compiled from: SnapHelperFirst.kt */
public final class h0 extends k {

    /* renamed from: f  reason: collision with root package name */
    private Context f10108f;

    /* renamed from: g  reason: collision with root package name */
    private m f10109g;

    /* renamed from: h  reason: collision with root package name */
    private Scroller f10110h;

    /* renamed from: i  reason: collision with root package name */
    private int f10111i;

    /* compiled from: SnapHelperFirst.kt */
    public static final class a extends j {
        final /* synthetic */ h0 q;
        final /* synthetic */ RecyclerView.o r;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h0 h0Var, RecyclerView.o oVar, Context context, Context context2) {
            super(context2);
            this.q = h0Var;
            this.r = oVar;
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.j, androidx.recyclerview.widget.RecyclerView.z
        public void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            f.e(view, "targetView");
            f.e(a0Var, "state");
            f.e(aVar, "action");
            int[] c2 = this.q.c(this.r, view);
            int i2 = c2[0];
            aVar.d(i2, c2[1], Math.max(1, Math.min(1000, w(Math.abs(i2)))), this.f1809j);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.j
        public float v(DisplayMetrics displayMetrics) {
            f.e(displayMetrics, "displayMetrics");
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    private final int s(View view, m mVar) {
        return mVar.g(view) - mVar.m();
    }

    private final View t(RecyclerView.o oVar, m mVar) {
        int K;
        View view = null;
        if (oVar == null || (K = oVar.K()) == 0) {
            return null;
        }
        int i2 = Integer.MAX_VALUE;
        int m = mVar.m();
        for (int i3 = 0; i3 < K; i3++) {
            View J = oVar.J(i3);
            int abs = Math.abs(mVar.g(J) - m);
            if (abs < i2) {
                view = J;
                i2 = abs;
            }
        }
        return view;
    }

    private final m u(RecyclerView.o oVar) {
        if (this.f10109g == null) {
            this.f10109g = m.a(oVar);
        }
        m mVar = this.f10109g;
        f.c(mVar);
        return mVar;
    }

    @Override // androidx.recyclerview.widget.q
    public void b(RecyclerView recyclerView) {
        if (recyclerView != null) {
            this.f10108f = recyclerView.getContext();
            this.f10110h = new Scroller(this.f10108f, new DecelerateInterpolator());
        } else {
            this.f10110h = null;
            this.f10108f = null;
        }
        super.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.q
    public int[] c(RecyclerView.o oVar, View view) {
        f.e(oVar, "layoutManager");
        f.e(view, "targetView");
        int[] iArr = new int[2];
        iArr[0] = s(view, u(oVar));
        return iArr;
    }

    @Override // androidx.recyclerview.widget.q
    public int[] d(int i2, int i3) {
        int[] iArr = new int[2];
        m mVar = this.f10109g;
        if (mVar != null) {
            if (this.f10111i == 0) {
                this.f10111i = (mVar.i() - mVar.m()) / 2;
            }
            Scroller scroller = this.f10110h;
            if (scroller != null) {
                int i4 = this.f10111i;
                scroller.fling(0, 0, i2, i3, -i4, i4, 0, 0);
            }
            Scroller scroller2 = this.f10110h;
            int i5 = 0;
            iArr[0] = scroller2 != null ? scroller2.getFinalX() : 0;
            Scroller scroller3 = this.f10110h;
            if (scroller3 != null) {
                i5 = scroller3.getFinalY();
            }
            iArr[1] = i5;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.q
    public RecyclerView.z e(RecyclerView.o oVar) {
        if (!(oVar instanceof RecyclerView.z.b)) {
            return super.e(oVar);
        }
        Context context = this.f10108f;
        if (context != null) {
            return new a(this, oVar, context, context);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.q
    public View h(RecyclerView.o oVar) {
        return t(oVar, u(oVar));
    }
}
