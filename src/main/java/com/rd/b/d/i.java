package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.c.b.f;

/* compiled from: SwapAnimation */
public class i extends b<ValueAnimator> {

    /* renamed from: d  reason: collision with root package name */
    private int f8553d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f8554e = -1;

    /* renamed from: f  reason: collision with root package name */
    private f f8555f = new f();

    /* access modifiers changed from: package-private */
    /* compiled from: SwapAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.this.j(valueAnimator);
        }
    }

    public i(b.a aVar) {
        super(aVar);
    }

    private PropertyValuesHolder h(String str, int i2, int i3) {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean i(int i2, int i3) {
        if (this.f8553d == i2 && this.f8554e == i3) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE_REVERSE")).intValue();
        this.f8555f.c(intValue);
        this.f8555f.d(intValue2);
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8555f);
        }
    }

    @Override // com.rd.b.d.b
    public /* bridge */ /* synthetic */ b d(float f2) {
        k(f2);
        return this;
    }

    /* renamed from: g */
    public ValueAnimator a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }

    public i k(float f2) {
        T t = this.f8523c;
        if (t != null) {
            long j2 = (long) (f2 * ((float) this.f8521a));
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.f8523c).getValues().length > 0) {
                ((ValueAnimator) this.f8523c).setCurrentPlayTime(j2);
            }
        }
        return this;
    }

    public i l(int i2, int i3) {
        if (this.f8523c != null && i(i2, i3)) {
            this.f8553d = i2;
            this.f8554e = i3;
            ((ValueAnimator) this.f8523c).setValues(h("ANIMATION_COORDINATE", i2, i3), h("ANIMATION_COORDINATE_REVERSE", i3, i2));
        }
        return this;
    }
}
