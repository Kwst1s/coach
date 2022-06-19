package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper */
public abstract class q extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f1822a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f1823b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.t f1824c = new a();

    /* compiled from: SnapHelper */
    class a extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        boolean f1825a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2) {
            super.a(recyclerView, i2);
            if (i2 == 0 && this.f1825a) {
                this.f1825a = false;
                q.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.f1825a = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SnapHelper */
    public class b extends j {
        b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.j, androidx.recyclerview.widget.RecyclerView.z
        public void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            q qVar = q.this;
            RecyclerView recyclerView = qVar.f1822a;
            if (recyclerView != null) {
                int[] c2 = qVar.c(recyclerView.getLayoutManager(), view);
                int i2 = c2[0];
                int i3 = c2[1];
                int w = w(Math.max(Math.abs(i2), Math.abs(i3)));
                if (w > 0) {
                    aVar.d(i2, i3, w, this.f1809j);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.j
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    private void g() {
        this.f1822a.b1(this.f1824c);
        this.f1822a.setOnFlingListener(null);
    }

    private void j() {
        if (this.f1822a.getOnFlingListener() == null) {
            this.f1822a.l(this.f1824c);
            this.f1822a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean k(RecyclerView.o oVar, int i2, int i3) {
        RecyclerView.z e2;
        int i4;
        if (!(oVar instanceof RecyclerView.z.b) || (e2 = e(oVar)) == null || (i4 = i(oVar, i2, i3)) == -1) {
            return false;
        }
        e2.p(i4);
        oVar.K1(e2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i2, int i3) {
        RecyclerView.o layoutManager = this.f1822a.getLayoutManager();
        if (layoutManager == null || this.f1822a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1822a.getMinFlingVelocity();
        if ((Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && k(layoutManager, i2, i3)) {
            return true;
        }
        return false;
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1822a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                g();
            }
            this.f1822a = recyclerView;
            if (recyclerView != null) {
                j();
                this.f1823b = new Scroller(this.f1822a.getContext(), new DecelerateInterpolator());
                l();
            }
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public int[] d(int i2, int i3) {
        this.f1823b.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f1823b.getFinalX(), this.f1823b.getFinalY()};
    }

    /* access modifiers changed from: protected */
    public RecyclerView.z e(RecyclerView.o oVar) {
        return f(oVar);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public j f(RecyclerView.o oVar) {
        if (!(oVar instanceof RecyclerView.z.b)) {
            return null;
        }
        return new b(this.f1822a.getContext());
    }

    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i2, int i3);

    /* access modifiers changed from: package-private */
    public void l() {
        RecyclerView.o layoutManager;
        View h2;
        RecyclerView recyclerView = this.f1822a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (h2 = h(layoutManager)) != null) {
            int[] c2 = c(layoutManager, h2);
            if (c2[0] != 0 || c2[1] != 0) {
                this.f1822a.o1(c2[0], c2[1]);
            }
        }
    }
}
