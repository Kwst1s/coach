package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import b.f.b.k.a;
import b.f.b.k.e;

public class Barrier extends b {

    /* renamed from: j  reason: collision with root package name */
    private int f855j;

    /* renamed from: k  reason: collision with root package name */
    private int f856k;
    private a l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void p(e eVar, int i2, boolean z) {
        this.f856k = i2;
        if (Build.VERSION.SDK_INT < 17) {
            int i3 = this.f855j;
            if (i3 == 5) {
                this.f856k = 0;
            } else if (i3 == 6) {
                this.f856k = 1;
            }
        } else if (z) {
            int i4 = this.f855j;
            if (i4 == 5) {
                this.f856k = 1;
            } else if (i4 == 6) {
                this.f856k = 0;
            }
        } else {
            int i5 = this.f855j;
            if (i5 == 5) {
                this.f856k = 0;
            } else if (i5 == 6) {
                this.f856k = 1;
            }
        }
        if (eVar instanceof a) {
            ((a) eVar).j1(this.f856k);
        }
    }

    public int getMargin() {
        return this.l.f1();
    }

    public int getType() {
        return this.f855j;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void h(AttributeSet attributeSet) {
        super.h(attributeSet);
        this.l = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.J0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.S0) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.R0) {
                    this.l.i1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == i.T0) {
                    this.l.k1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f907e = this.l;
        n();
    }

    @Override // androidx.constraintlayout.widget.b
    public void i(e eVar, boolean z) {
        p(eVar, this.f855j, z);
    }

    public boolean o() {
        return this.l.d1();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.l.i1(z);
    }

    public void setDpMargin(int i2) {
        a aVar = this.l;
        aVar.k1((int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i2) {
        this.l.k1(i2);
    }

    public void setType(int i2) {
        this.f855j = i2;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
