package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.o f1814a;

    /* renamed from: b  reason: collision with root package name */
    private int f1815b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f1816c;

    /* access modifiers changed from: package-private */
    /* compiled from: OrientationHelper */
    public static class a extends m {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f1814a.U(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1814a.T(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1814a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f1814a.R(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f1814a.p0();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f1814a.p0() - this.f1814a.g0();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f1814a.g0();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f1814a.q0();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f1814a.Y();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f1814a.f0();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f1814a.p0() - this.f1814a.f0()) - this.f1814a.g0();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f1814a.o0(view, true, this.f1816c);
            return this.f1816c.right;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f1814a.o0(view, true, this.f1816c);
            return this.f1816c.left;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i2) {
            this.f1814a.D0(i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: OrientationHelper */
    public static class b extends m {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f1814a.P(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1814a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1814a.T(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f1814a.V(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f1814a.X();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f1814a.X() - this.f1814a.e0();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f1814a.e0();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f1814a.Y();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f1814a.q0();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f1814a.h0();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f1814a.X() - this.f1814a.h0()) - this.f1814a.e0();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f1814a.o0(view, true, this.f1816c);
            return this.f1816c.bottom;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f1814a.o0(view, true, this.f1816c);
            return this.f1816c.top;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i2) {
            this.f1814a.E0(i2);
        }
    }

    /* synthetic */ m(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static m a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static m b(RecyclerView.o oVar, int i2) {
        if (i2 == 0) {
            return a(oVar);
        }
        if (i2 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static m c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f1815b) {
            return 0;
        }
        return n() - this.f1815b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i2);

    public void s() {
        this.f1815b = n();
    }

    private m(RecyclerView.o oVar) {
        this.f1815b = Integer.MIN_VALUE;
        this.f1816c = new Rect();
        this.f1814a = oVar;
    }
}
