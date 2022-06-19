package androidx.recyclerview.widget;

import android.view.View;

/* access modifiers changed from: package-private */
/* compiled from: ViewBoundsCheck */
public class r {

    /* renamed from: a  reason: collision with root package name */
    final b f1827a;

    /* renamed from: b  reason: collision with root package name */
    a f1828b = new a();

    /* access modifiers changed from: package-private */
    /* compiled from: ViewBoundsCheck */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1829a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f1830b;

        /* renamed from: c  reason: collision with root package name */
        int f1831c;

        /* renamed from: d  reason: collision with root package name */
        int f1832d;

        /* renamed from: e  reason: collision with root package name */
        int f1833e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f1829a = i2 | this.f1829a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i2 = this.f1829a;
            if ((i2 & 7) != 0 && (i2 & (c(this.f1832d, this.f1830b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f1829a;
            if ((i3 & 112) != 0 && (i3 & (c(this.f1832d, this.f1831c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f1829a;
            if ((i4 & 1792) != 0 && (i4 & (c(this.f1833e, this.f1830b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f1829a;
            if ((i5 & 28672) == 0 || (i5 & (c(this.f1833e, this.f1831c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int c(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f1829a = 0;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3, int i4, int i5) {
            this.f1830b = i2;
            this.f1831c = i3;
            this.f1832d = i4;
            this.f1833e = i5;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewBoundsCheck */
    public interface b {
        View a(int i2);

        int b();

        int c(View view);

        int d();

        int e(View view);
    }

    r(b bVar) {
        this.f1827a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, int i4, int i5) {
        int d2 = this.f1827a.d();
        int b2 = this.f1827a.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a2 = this.f1827a.a(i2);
            this.f1828b.e(d2, b2, this.f1827a.c(a2), this.f1827a.e(a2));
            if (i4 != 0) {
                this.f1828b.d();
                this.f1828b.a(i4);
                if (this.f1828b.b()) {
                    return a2;
                }
            }
            if (i5 != 0) {
                this.f1828b.d();
                this.f1828b.a(i5);
                if (this.f1828b.b()) {
                    view = a2;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i2) {
        this.f1828b.e(this.f1827a.d(), this.f1827a.b(), this.f1827a.c(view), this.f1827a.e(view));
        if (i2 == 0) {
            return false;
        }
        this.f1828b.d();
        this.f1828b.a(i2);
        return this.f1828b.b();
    }
}
