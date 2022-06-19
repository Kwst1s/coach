package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import b.a.j;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatSeekBarHelper */
public class p extends n {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f703d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f704e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f705f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f706g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f707h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f708i = false;

    p(SeekBar seekBar) {
        super(seekBar);
        this.f703d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f704e;
        if (drawable == null) {
            return;
        }
        if (this.f707h || this.f708i) {
            Drawable r = a.r(drawable.mutate());
            this.f704e = r;
            if (this.f707h) {
                a.o(r, this.f705f);
            }
            if (this.f708i) {
                a.p(this.f704e, this.f706g);
            }
            if (this.f704e.isStateful()) {
                this.f704e.setState(this.f703d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.n
    public void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        Context context = this.f703d.getContext();
        int[] iArr = j.Q;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f703d;
        u.k0(seekBar, seekBar.getContext(), iArr, attributeSet, v.r(), i2, 0);
        Drawable h2 = v.h(j.R);
        if (h2 != null) {
            this.f703d.setThumb(h2);
        }
        j(v.g(j.S));
        int i3 = j.U;
        if (v.s(i3)) {
            this.f706g = x.e(v.k(i3, -1), this.f706g);
            this.f708i = true;
        }
        int i4 = j.T;
        if (v.s(i4)) {
            this.f705f = v.c(i4);
            this.f707h = true;
        }
        v.w();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f704e != null) {
            int max = this.f703d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f704e.getIntrinsicWidth();
                int intrinsicHeight = this.f704e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f704e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f703d.getWidth() - this.f703d.getPaddingLeft()) - this.f703d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f703d.getPaddingLeft(), (float) (this.f703d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f704e.draw(canvas);
                    canvas.translate(width, Utils.FLOAT_EPSILON);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f704e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f703d.getDrawableState())) {
            this.f703d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f704e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f704e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f704e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f703d);
            a.m(drawable, u.B(this.f703d));
            if (drawable.isStateful()) {
                drawable.setState(this.f703d.getDrawableState());
            }
            f();
        }
        this.f703d.invalidate();
    }
}
