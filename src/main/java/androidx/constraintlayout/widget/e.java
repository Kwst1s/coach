package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: Constraints */
public class e extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    d f970b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public d getConstraintSet() {
        if (this.f970b == null) {
            this.f970b = new d();
        }
        this.f970b.h(this);
        return this.f970b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    /* compiled from: Constraints */
    public static class a extends ConstraintLayout.b {
        public float A0;
        public float o0;
        public boolean p0;
        public float q0;
        public float r0;
        public float s0;
        public float t0;
        public float u0;
        public float v0;
        public float w0;
        public float x0;
        public float y0;
        public float z0;

        public a(int i2, int i3) {
            super(i2, i3);
            this.o0 = 1.0f;
            this.p0 = false;
            this.q0 = Utils.FLOAT_EPSILON;
            this.r0 = Utils.FLOAT_EPSILON;
            this.s0 = Utils.FLOAT_EPSILON;
            this.t0 = Utils.FLOAT_EPSILON;
            this.u0 = 1.0f;
            this.v0 = 1.0f;
            this.w0 = Utils.FLOAT_EPSILON;
            this.x0 = Utils.FLOAT_EPSILON;
            this.y0 = Utils.FLOAT_EPSILON;
            this.z0 = Utils.FLOAT_EPSILON;
            this.A0 = Utils.FLOAT_EPSILON;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.o0 = 1.0f;
            this.p0 = false;
            this.q0 = Utils.FLOAT_EPSILON;
            this.r0 = Utils.FLOAT_EPSILON;
            this.s0 = Utils.FLOAT_EPSILON;
            this.t0 = Utils.FLOAT_EPSILON;
            this.u0 = 1.0f;
            this.v0 = 1.0f;
            this.w0 = Utils.FLOAT_EPSILON;
            this.x0 = Utils.FLOAT_EPSILON;
            this.y0 = Utils.FLOAT_EPSILON;
            this.z0 = Utils.FLOAT_EPSILON;
            this.A0 = Utils.FLOAT_EPSILON;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.X1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.Y1) {
                    this.o0 = obtainStyledAttributes.getFloat(index, this.o0);
                } else if (index == i.j2) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.q0 = obtainStyledAttributes.getFloat(index, this.q0);
                        this.p0 = true;
                    }
                } else if (index == i.g2) {
                    this.s0 = obtainStyledAttributes.getFloat(index, this.s0);
                } else if (index == i.h2) {
                    this.t0 = obtainStyledAttributes.getFloat(index, this.t0);
                } else if (index == i.f2) {
                    this.r0 = obtainStyledAttributes.getFloat(index, this.r0);
                } else if (index == i.d2) {
                    this.u0 = obtainStyledAttributes.getFloat(index, this.u0);
                } else if (index == i.e2) {
                    this.v0 = obtainStyledAttributes.getFloat(index, this.v0);
                } else if (index == i.Z1) {
                    this.w0 = obtainStyledAttributes.getFloat(index, this.w0);
                } else if (index == i.a2) {
                    this.x0 = obtainStyledAttributes.getFloat(index, this.x0);
                } else if (index == i.b2) {
                    this.y0 = obtainStyledAttributes.getFloat(index, this.y0);
                } else if (index == i.c2) {
                    this.z0 = obtainStyledAttributes.getFloat(index, this.z0);
                } else if (index == i.i2 && Build.VERSION.SDK_INT >= 21) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
