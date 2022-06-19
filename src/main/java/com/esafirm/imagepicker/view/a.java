package com.esafirm.imagepicker.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: GridSpacingItemDecoration */
public class a extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private int f4589a;

    /* renamed from: b  reason: collision with root package name */
    private int f4590b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4591c;

    public a(int i2, int i3, boolean z) {
        this.f4589a = i2;
        this.f4590b = i3;
        this.f4591c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int f0 = recyclerView.f0(view);
        int i2 = this.f4589a;
        int i3 = f0 % i2;
        if (this.f4591c) {
            int i4 = this.f4590b;
            rect.left = i4 - ((i3 * i4) / i2);
            rect.right = ((i3 + 1) * i4) / i2;
            if (f0 < i2) {
                rect.top = i4;
            }
            rect.bottom = i4;
            return;
        }
        int i5 = this.f4590b;
        rect.left = (i3 * i5) / i2;
        rect.right = i5 - (((i3 + 1) * i5) / i2);
        if (f0 >= i2) {
            rect.top = i5;
        }
    }
}
