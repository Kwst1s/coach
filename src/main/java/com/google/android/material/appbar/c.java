package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* access modifiers changed from: package-private */
/* compiled from: ViewOffsetBehavior */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private d f7517a;

    /* renamed from: b  reason: collision with root package name */
    private int f7518b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f7519c = 0;

    public c() {
    }

    public int E() {
        d dVar = this.f7517a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void F(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.I(v, i2);
    }

    public boolean G(int i2) {
        d dVar = this.f7517a;
        if (dVar != null) {
            return dVar.e(i2);
        }
        this.f7518b = i2;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        F(coordinatorLayout, v, i2);
        if (this.f7517a == null) {
            this.f7517a = new d(v);
        }
        this.f7517a.c();
        this.f7517a.a();
        int i3 = this.f7518b;
        if (i3 != 0) {
            this.f7517a.e(i3);
            this.f7518b = 0;
        }
        int i4 = this.f7519c;
        if (i4 == 0) {
            return true;
        }
        this.f7517a.d(i4);
        this.f7519c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
