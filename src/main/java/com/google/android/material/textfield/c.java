package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import c.e.a.b.c0.g;
import c.e.a.b.c0.k;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: CutoutDrawable */
public class c extends g {
    private final RectF A;
    private int B;
    private final Paint z;

    c() {
        this(null);
    }

    private void l0(Canvas canvas) {
        if (!s0(getCallback())) {
            canvas.restoreToCount(this.B);
        }
    }

    private void m0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (s0(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        o0(canvas);
    }

    private void o0(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.B = canvas.saveLayer(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        } else {
            this.B = canvas.saveLayer(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        }
    }

    private void r0() {
        this.z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(-1);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean s0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // c.e.a.b.c0.g
    public void draw(Canvas canvas) {
        m0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.A, this.z);
        l0(canvas);
    }

    /* access modifiers changed from: package-private */
    public boolean k0() {
        return !this.A.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void n0() {
        p0(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
    }

    /* access modifiers changed from: package-private */
    public void p0(float f2, float f3, float f4, float f5) {
        RectF rectF = this.A;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            rectF.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void q0(RectF rectF) {
        p0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c(k kVar) {
        super(kVar == null ? new k() : kVar);
        this.z = new Paint(1);
        r0();
        this.A = new RectF();
    }
}
