package f.a.a.a.b.b;

import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import f.a.a.a.b.b.d0;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: GoalsItemTouchHelper */
public class t extends f.AbstractC0027f {

    /* renamed from: d  reason: collision with root package name */
    private d0 f9033d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f9034e;

    /* renamed from: f  reason: collision with root package name */
    private int f9035f;

    /* access modifiers changed from: package-private */
    /* compiled from: GoalsItemTouchHelper */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f9036b;

        a(t tVar, View view) {
            this.f9036b = view;
        }

        public void run() {
            this.f9036b.sendAccessibilityEvent(8);
            this.f9036b.sendAccessibilityEvent(32768);
            this.f9036b.requestFocus();
        }
    }

    public t(d0 d0Var, LinearLayoutManager linearLayoutManager) {
        this.f9033d = d0Var;
        this.f9034e = linearLayoutManager;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D() {
        View D = this.f9034e.D(this.f9035f);
        if (D != null) {
            Executors.newSingleThreadScheduledExecutor().schedule(new a(this, D), 350, TimeUnit.MILLISECONDS);
        }
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public void A(RecyclerView.d0 d0Var, int i2) {
        super.A(d0Var, i2);
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public void B(RecyclerView.d0 d0Var, int i2) {
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        super.c(recyclerView, d0Var);
        d0Var.f1565a.setAlpha(1.0f);
        if (d0Var instanceof d0.a) {
            d0 d0Var2 = this.f9033d;
            if (d0Var2 != null) {
                d0Var2.h();
            }
            new Handler().postDelayed(new a(this), 200);
        }
        this.f9033d.E();
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public int k(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return f.AbstractC0027f.t(3, 0);
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public boolean q() {
        return true;
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public boolean r() {
        return true;
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f2, float f3, int i2, boolean z) {
        super.u(canvas, recyclerView, d0Var, f2, f3, i2, z);
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0027f
    public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        if (d0Var.l() != d0Var2.l()) {
            return false;
        }
        this.f9035f = d0Var2.j();
        this.f9033d.C(d0Var.j(), d0Var2.j());
        return true;
    }
}
