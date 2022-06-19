package com.rd.b.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.c.b.h;
import java.util.Iterator;

/* compiled from: WormAnimation */
public class k extends b<AnimatorSet> {

    /* renamed from: d  reason: collision with root package name */
    int f8559d;

    /* renamed from: e  reason: collision with root package name */
    int f8560e;

    /* renamed from: f  reason: collision with root package name */
    int f8561f;

    /* renamed from: g  reason: collision with root package name */
    boolean f8562g;

    /* renamed from: h  reason: collision with root package name */
    int f8563h;

    /* renamed from: i  reason: collision with root package name */
    int f8564i;

    /* renamed from: j  reason: collision with root package name */
    private h f8565j = new h();

    /* access modifiers changed from: package-private */
    /* compiled from: WormAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f8566b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f8567c;

        a(h hVar, boolean z) {
            this.f8566b = hVar;
            this.f8567c = z;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            k.this.l(this.f8566b, valueAnimator, this.f8567c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: WormAnimation */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        final int f8569a;

        /* renamed from: b  reason: collision with root package name */
        final int f8570b;

        /* renamed from: c  reason: collision with root package name */
        final int f8571c;

        /* renamed from: d  reason: collision with root package name */
        final int f8572d;

        b(k kVar, int i2, int i3, int i4, int i5) {
            this.f8569a = i2;
            this.f8570b = i3;
            this.f8571c = i4;
            this.f8572d = i5;
        }
    }

    public k(b.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(h hVar, ValueAnimator valueAnimator, boolean z) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.f8562g) {
            if (!z) {
                hVar.c(intValue);
            } else {
                hVar.d(intValue);
            }
        } else if (!z) {
            hVar.d(intValue);
        } else {
            hVar.c(intValue);
        }
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    /* renamed from: g */
    public AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public b h(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.f8559d;
            int i7 = this.f8561f;
            i5 = i6 + i7;
            int i8 = this.f8560e;
            i3 = i8 + i7;
            i2 = i6 - i7;
            i4 = i8 - i7;
        } else {
            int i9 = this.f8559d;
            int i10 = this.f8561f;
            i5 = i9 - i10;
            int i11 = this.f8560e;
            i3 = i11 - i10;
            i2 = i9 + i10;
            i4 = i11 + i10;
        }
        return new b(this, i5, i3, i2, i4);
    }

    /* access modifiers changed from: package-private */
    public ValueAnimator i(int i2, int i3, long j2, boolean z, h hVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new a(hVar, z));
        return ofInt;
    }

    public k j(long j2) {
        super.b(j2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean k(int i2, int i3, int i4, boolean z) {
        if (this.f8559d == i2 && this.f8560e == i3 && this.f8561f == i4 && this.f8562g == z) {
            return false;
        }
        return true;
    }

    /* renamed from: m */
    public k d(float f2) {
        T t = this.f8523c;
        if (t == null) {
            return this;
        }
        long j2 = (long) (f2 * ((float) this.f8521a));
        Iterator<Animator> it = ((AnimatorSet) t).getChildAnimations().iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) it.next();
            long duration = valueAnimator.getDuration();
            if (j2 <= duration) {
                duration = j2;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j2 -= duration;
        }
        return this;
    }

    public k n(int i2, int i3, int i4, boolean z) {
        if (k(i2, i3, i4, z)) {
            this.f8523c = a();
            this.f8559d = i2;
            this.f8560e = i3;
            this.f8561f = i4;
            this.f8562g = z;
            int i5 = i2 - i4;
            this.f8563h = i5;
            this.f8564i = i2 + i4;
            this.f8565j.d(i5);
            this.f8565j.c(this.f8564i);
            b h2 = h(z);
            long j2 = this.f8521a / 2;
            ((AnimatorSet) this.f8523c).playSequentially(i(h2.f8569a, h2.f8570b, j2, false, this.f8565j), i(h2.f8571c, h2.f8572d, j2, true, this.f8565j));
        }
        return this;
    }
}
