package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import b.f.b.k.k;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: VirtualLayout */
public abstract class j extends b {

    /* renamed from: j  reason: collision with root package name */
    private boolean f985j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f986k;

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void h(AttributeSet attributeSet) {
        super.h(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.J0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.L0) {
                    this.f985j = true;
                } else if (index == i.Q0) {
                    this.f986k = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o(k kVar, int i2, int i3) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f985j || this.f986k) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : Utils.FLOAT_EPSILON;
            for (int i2 = 0; i2 < this.f905c; i2++) {
                View i3 = constraintLayout.i(this.f904b[i2]);
                if (i3 != null) {
                    if (this.f985j) {
                        i3.setVisibility(visibility);
                    }
                    if (this.f986k && elevation > Utils.FLOAT_EPSILON && Build.VERSION.SDK_INT >= 21) {
                        i3.setTranslationZ(i3.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        d();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        d();
    }
}
