package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* compiled from: VisibilityAwareImageButton */
public class l extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    private int f7867b;

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f7867b = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f7867b;
    }

    public void setVisibility(int i2) {
        b(i2, true);
    }

    public l(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7867b = getVisibility();
    }
}
