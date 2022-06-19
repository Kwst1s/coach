package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.h.k.u;
import c.e.a.b.b;
import c.e.a.b.f;
import c.e.a.b.l;
import c.e.a.b.s.a;
import com.github.mikephil.charting.utils.Utils;

public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    private TextView f7913b;

    /* renamed from: c  reason: collision with root package name */
    private Button f7914c;

    /* renamed from: d  reason: collision with root package name */
    private int f7915d;

    /* renamed from: e  reason: collision with root package name */
    private int f7916e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.F2);
        this.f7915d = obtainStyledAttributes.getDimensionPixelSize(l.G2, -1);
        this.f7916e = obtainStyledAttributes.getDimensionPixelSize(l.N2, -1);
        obtainStyledAttributes.recycle();
    }

    private static void d(View view, int i2, int i3) {
        if (u.U(view)) {
            u.A0(view, u.G(view), i2, u.F(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean e(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.f7913b.getPaddingTop() == i3 && this.f7913b.getPaddingBottom() == i4) {
            return z;
        }
        d(this.f7913b, i3, i4);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i2, int i3) {
        this.f7913b.setAlpha(Utils.FLOAT_EPSILON);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.f7913b.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f7914c.getVisibility() == 0) {
            this.f7914c.setAlpha(Utils.FLOAT_EPSILON);
            this.f7914c.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i2, int i3) {
        this.f7913b.setAlpha(1.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.f7913b.animate().alpha(Utils.FLOAT_EPSILON).setDuration(j2).setStartDelay(j3).start();
        if (this.f7914c.getVisibility() == 0) {
            this.f7914c.setAlpha(1.0f);
            this.f7914c.animate().alpha(Utils.FLOAT_EPSILON).setDuration(j2).setStartDelay(j3).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        if (f2 != 1.0f) {
            this.f7914c.setTextColor(a.f(a.c(this, b.colorSurface), this.f7914c.getCurrentTextColor(), f2));
        }
    }

    public Button getActionView() {
        return this.f7914c;
    }

    public TextView getMessageView() {
        return this.f7913b;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7913b = (TextView) findViewById(f.snackbar_text);
        this.f7914c = (Button) findViewById(f.snackbar_action);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (e(1, r0, r0 - r1) != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (e(0, r0, r0) != false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f7916e = i2;
    }
}
