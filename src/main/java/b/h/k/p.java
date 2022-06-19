package b.h.k;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f2666a;

    /* renamed from: b  reason: collision with root package name */
    private int f2667b;

    public p(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f2666a | this.f2667b;
    }

    public void b(View view, View view2, int i2) {
        c(view, view2, i2, 0);
    }

    public void c(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f2667b = i2;
        } else {
            this.f2666a = i2;
        }
    }

    public void d(View view, int i2) {
        if (i2 == 1) {
            this.f2667b = 0;
        } else {
            this.f2666a = 0;
        }
    }
}
