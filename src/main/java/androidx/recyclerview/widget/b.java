package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: ChildHelper */
public class b {

    /* renamed from: a  reason: collision with root package name */
    final AbstractC0024b f1686a;

    /* renamed from: b  reason: collision with root package name */
    final a f1687b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f1688c = new ArrayList();

    /* access modifiers changed from: package-private */
    /* compiled from: ChildHelper */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f1689a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f1690b;

        a() {
        }

        private void c() {
            if (this.f1690b == null) {
                this.f1690b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (i2 >= 64) {
                a aVar = this.f1690b;
                if (aVar != null) {
                    aVar.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f1689a &= (1 << i2) ^ -1;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            a aVar = this.f1690b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f1689a);
                }
                return Long.bitCount(this.f1689a & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.f1689a & ((1 << i2) - 1));
            } else {
                return aVar.b(i2 - 64) + Long.bitCount(this.f1689a);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (i2 < 64) {
                return (this.f1689a & (1 << i2)) != 0;
            }
            c();
            return this.f1690b.d(i2 - 64);
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, boolean z) {
            if (i2 >= 64) {
                c();
                this.f1690b.e(i2 - 64, z);
                return;
            }
            long j2 = this.f1689a;
            boolean z2 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.f1689a = ((j2 & (j3 ^ -1)) << 1) | (j2 & j3);
            if (z) {
                h(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f1690b != null) {
                c();
                this.f1690b.e(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f1690b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f1689a;
            boolean z = (j3 & j2) != 0;
            long j4 = j3 & (j2 ^ -1);
            this.f1689a = j4;
            long j5 = j2 - 1;
            this.f1689a = (j4 & j5) | Long.rotateRight((j5 ^ -1) & j4, 1);
            a aVar = this.f1690b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1690b.f(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f1689a = 0;
            a aVar = this.f1690b;
            if (aVar != null) {
                aVar.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i2) {
            if (i2 >= 64) {
                c();
                this.f1690b.h(i2 - 64);
                return;
            }
            this.f1689a |= 1 << i2;
        }

        public String toString() {
            if (this.f1690b == null) {
                return Long.toBinaryString(this.f1689a);
            }
            return this.f1690b.toString() + "xx" + Long.toBinaryString(this.f1689a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* compiled from: ChildHelper */
    public interface AbstractC0024b {
        View a(int i2);

        void b(View view);

        RecyclerView.d0 c(View view);

        void d(int i2);

        void e(View view);

        void f(View view, int i2);

        int g();

        void h(int i2);

        void i();

        void j(View view, int i2, ViewGroup.LayoutParams layoutParams);

        int k(View view);
    }

    b(AbstractC0024b bVar) {
        this.f1686a = bVar;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int g2 = this.f1686a.g();
        int i3 = i2;
        while (i3 < g2) {
            int b2 = i2 - (i3 - this.f1687b.b(i3));
            if (b2 == 0) {
                while (this.f1687b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f1688c.add(view);
        this.f1686a.b(view);
    }

    private boolean t(View view) {
        if (!this.f1688c.remove(view)) {
            return false;
        }
        this.f1686a.e(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = this.f1686a.g();
        } else {
            i3 = h(i2);
        }
        this.f1687b.e(i3, z);
        if (z) {
            l(view);
        }
        this.f1686a.f(view, i3);
    }

    /* access modifiers changed from: package-private */
    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = this.f1686a.g();
        } else {
            i3 = h(i2);
        }
        this.f1687b.e(i3, z);
        if (z) {
            l(view);
        }
        this.f1686a.j(view, i3, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        int h2 = h(i2);
        this.f1687b.f(h2);
        this.f1686a.d(h2);
    }

    /* access modifiers changed from: package-private */
    public View e(int i2) {
        int size = this.f1688c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f1688c.get(i3);
            RecyclerView.d0 c2 = this.f1686a.c(view);
            if (!(c2.m() != i2 || c2.t() || c2.v())) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View f(int i2) {
        return this.f1686a.a(h(i2));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1686a.g() - this.f1688c.size();
    }

    /* access modifiers changed from: package-private */
    public View i(int i2) {
        return this.f1686a.a(i2);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f1686a.g();
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        int k2 = this.f1686a.k(view);
        if (k2 >= 0) {
            this.f1687b.h(k2);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int m(View view) {
        int k2 = this.f1686a.k(view);
        if (k2 != -1 && !this.f1687b.d(k2)) {
            return k2 - this.f1687b.b(k2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f1688c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f1687b.g();
        for (int size = this.f1688c.size() - 1; size >= 0; size--) {
            this.f1686a.e(this.f1688c.get(size));
            this.f1688c.remove(size);
        }
        this.f1686a.i();
    }

    /* access modifiers changed from: package-private */
    public void p(View view) {
        int k2 = this.f1686a.k(view);
        if (k2 >= 0) {
            if (this.f1687b.f(k2)) {
                t(view);
            }
            this.f1686a.h(k2);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        int h2 = h(i2);
        View a2 = this.f1686a.a(h2);
        if (a2 != null) {
            if (this.f1687b.f(h2)) {
                t(a2);
            }
            this.f1686a.h(h2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        int k2 = this.f1686a.k(view);
        if (k2 == -1) {
            t(view);
            return true;
        } else if (!this.f1687b.d(k2)) {
            return false;
        } else {
            this.f1687b.f(k2);
            t(view);
            this.f1686a.h(k2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s(View view) {
        int k2 = this.f1686a.k(view);
        if (k2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f1687b.d(k2)) {
            this.f1687b.a(k2);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f1687b.toString() + ", hidden list:" + this.f1688c.size();
    }
}
