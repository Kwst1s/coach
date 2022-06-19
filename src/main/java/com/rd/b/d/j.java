package com.rd.b.d;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.c.b.g;
import com.rd.b.d.k;

/* compiled from: ThinWormAnimation */
public class j extends k {

    /* renamed from: k  reason: collision with root package name */
    private g f8557k = new g();

    /* access modifiers changed from: package-private */
    /* compiled from: ThinWormAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.this.r(valueAnimator);
        }
    }

    public j(b.a aVar) {
        super(aVar);
    }

    private ValueAnimator p(int i2, int i3, long j2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new a());
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r(ValueAnimator valueAnimator) {
        this.f8557k.f(((Integer) valueAnimator.getAnimatedValue()).intValue());
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8557k);
        }
    }

    @Override // com.rd.b.d.b, com.rd.b.d.k
    public /* bridge */ /* synthetic */ b d(float f2) {
        s(f2);
        return this;
    }

    @Override // com.rd.b.d.k
    public /* bridge */ /* synthetic */ k j(long j2) {
        q(j2);
        return this;
    }

    @Override // com.rd.b.d.k
    public /* bridge */ /* synthetic */ k m(float f2) {
        s(f2);
        return this;
    }

    @Override // com.rd.b.d.k
    public k n(int i2, int i3, int i4, boolean z) {
        if (k(i2, i3, i4, z)) {
            this.f8523c = a();
            this.f8559d = i2;
            this.f8560e = i3;
            this.f8561f = i4;
            this.f8562g = z;
            int i5 = i4 * 2;
            int i6 = i2 - i4;
            this.f8563h = i6;
            this.f8564i = i2 + i4;
            this.f8557k.d(i6);
            this.f8557k.c(this.f8564i);
            this.f8557k.f(i5);
            k.b h2 = h(z);
            long j2 = this.f8521a;
            double d2 = (double) j2;
            Double.isNaN(d2);
            long j3 = (long) (d2 * 0.8d);
            double d3 = (double) j2;
            Double.isNaN(d3);
            long j4 = (long) (d3 * 0.2d);
            double d4 = (double) j2;
            Double.isNaN(d4);
            long j5 = (long) (d4 * 0.5d);
            double d5 = (double) j2;
            Double.isNaN(d5);
            long j6 = (long) (d5 * 0.5d);
            ValueAnimator i7 = i(h2.f8569a, h2.f8570b, j3, false, this.f8557k);
            ValueAnimator i8 = i(h2.f8571c, h2.f8572d, j3, true, this.f8557k);
            i8.setStartDelay(j4);
            ValueAnimator p = p(i5, i4, j5);
            ValueAnimator p2 = p(i4, i5, j5);
            p2.setStartDelay(j6);
            ((AnimatorSet) this.f8523c).playTogether(i7, i8, p, p2);
        }
        return this;
    }

    public j q(long j2) {
        super.j(j2);
        return this;
    }

    public j s(float f2) {
        T t = this.f8523c;
        if (t != null) {
            long j2 = (long) (f2 * ((float) this.f8521a));
            int size = ((AnimatorSet) t).getChildAnimations().size();
            for (int i2 = 0; i2 < size; i2++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.f8523c).getChildAnimations().get(i2);
                long startDelay = j2 - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay > duration) {
                    startDelay = duration;
                } else if (startDelay < 0) {
                    startDelay = 0;
                }
                if ((i2 != size - 1 || startDelay > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(startDelay);
                }
            }
        }
        return this;
    }
}
