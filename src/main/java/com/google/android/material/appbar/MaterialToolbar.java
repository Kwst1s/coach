package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.a;
import b.h.k.u;
import c.e.a.b.b;
import c.e.a.b.c0.g;
import c.e.a.b.c0.h;
import c.e.a.b.k;

public class MaterialToolbar extends Toolbar {
    private static final int R = k.Widget_MaterialComponents_Toolbar;
    private Integer Q;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.J);
    }

    private void P(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.X(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.M(context);
            gVar.W(u.w(this));
            u.q0(this, gVar);
        }
    }

    private Drawable Q(Drawable drawable) {
        if (drawable == null || this.Q == null) {
            return drawable;
        }
        Drawable r = a.r(drawable);
        a.n(r, this.Q.intValue());
        return r;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        h.d(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(Q(drawable));
    }

    public void setNavigationIconColor(int i2) {
        this.Q = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialToolbar(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.appbar.MaterialToolbar.R
            android.content.Context r7 = com.google.android.material.theme.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r7 = r6.getContext()
            int[] r2 = c.e.a.b.l.o2
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r7
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.j.h(r0, r1, r2, r3, r4, r5)
            int r9 = c.e.a.b.l.p2
            boolean r0 = r8.hasValue(r9)
            if (r0 == 0) goto L_0x0029
            r0 = -1
            int r9 = r8.getColor(r9, r0)
            r6.setNavigationIconColor(r9)
        L_0x0029:
            r8.recycle()
            r6.P(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
