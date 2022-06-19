package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.c.b.e;

/* compiled from: SlideAnimation */
public class h extends b<ValueAnimator> {

    /* renamed from: d  reason: collision with root package name */
    private e f8549d = new e();

    /* renamed from: e  reason: collision with root package name */
    private int f8550e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f8551f = -1;

    /* access modifiers changed from: package-private */
    /* compiled from: SlideAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            h.this.j(valueAnimator);
        }
    }

    public h(b.a aVar) {
        super(aVar);
    }

    private PropertyValuesHolder h() {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", this.f8550e, this.f8551f);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean i(int i2, int i3) {
        if (this.f8550e == i2 && this.f8551f == i3) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(ValueAnimator valueAnimator) {
        this.f8549d.b(((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue());
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8549d);
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

    public h k(float f2) {
        T t = this.f8523c;
        if (t != null) {
            long j2 = (long) (f2 * ((float) this.f8521a));
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.f8523c).getValues().length > 0) {
                ((ValueAnimator) this.f8523c).setCurrentPlayTime(j2);
            }
        }
        return this;
    }

    public h l(int i2, int i3) {
        if (this.f8523c != null && i(i2, i3)) {
            this.f8550e = i2;
            this.f8551f = i3;
            ((ValueAnimator) this.f8523c).setValues(h());
        }
        return this;
    }
}
