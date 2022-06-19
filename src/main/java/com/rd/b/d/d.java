package com.rd.b.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import java.util.Iterator;

/* compiled from: DropAnimation */
public class d extends b<AnimatorSet> {

    /* renamed from: d  reason: collision with root package name */
    private int f8528d;

    /* renamed from: e  reason: collision with root package name */
    private int f8529e;

    /* renamed from: f  reason: collision with root package name */
    private int f8530f;

    /* renamed from: g  reason: collision with root package name */
    private int f8531g;

    /* renamed from: h  reason: collision with root package name */
    private int f8532h;

    /* renamed from: i  reason: collision with root package name */
    private com.rd.b.c.b.b f8533i = new com.rd.b.c.b.b();

    /* access modifiers changed from: package-private */
    /* compiled from: DropAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f8534b;

        a(c cVar) {
            this.f8534b = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.k(valueAnimator, this.f8534b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DropAnimation */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8536a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.rd.b.d.d$c[] r0 = com.rd.b.d.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.rd.b.d.d.b.f8536a = r0
                com.rd.b.d.d$c r1 = com.rd.b.d.d.c.Width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.rd.b.d.d.b.f8536a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.rd.b.d.d$c r1 = com.rd.b.d.d.c.Height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.rd.b.d.d.b.f8536a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.rd.b.d.d$c r1 = com.rd.b.d.d.c.Radius     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.b.d.d.b.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DropAnimation */
    public enum c {
        Width,
        Height,
        Radius
    }

    public d(b.a aVar) {
        super(aVar);
    }

    private ValueAnimator h(int i2, int i3, long j2, c cVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new a(cVar));
        return ofInt;
    }

    private boolean j(int i2, int i3, int i4, int i5, int i6) {
        if (this.f8528d == i2 && this.f8529e == i3 && this.f8530f == i4 && this.f8531g == i5 && this.f8532h == i6) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(ValueAnimator valueAnimator, c cVar) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i2 = b.f8536a[cVar.ordinal()];
        if (i2 == 1) {
            this.f8533i.f(intValue);
        } else if (i2 == 2) {
            this.f8533i.d(intValue);
        } else if (i2 == 3) {
            this.f8533i.e(intValue);
        }
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8533i);
        }
    }

    @Override // com.rd.b.d.b
    public /* bridge */ /* synthetic */ b d(float f2) {
        l(f2);
        return this;
    }

    /* renamed from: g */
    public AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    public d i(long j2) {
        super.b(j2);
        return this;
    }

    public d l(float f2) {
        T t = this.f8523c;
        if (t != null) {
            long j2 = (long) (f2 * ((float) this.f8521a));
            boolean z = false;
            Iterator<Animator> it = ((AnimatorSet) t).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                long duration = valueAnimator.getDuration();
                long j3 = z ? j2 - duration : j2;
                if (j3 >= 0) {
                    if (j3 >= duration) {
                        j3 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j3);
                    }
                    if (!z && duration >= this.f8521a) {
                        z = true;
                    }
                }
            }
        }
        return this;
    }

    public d m(int i2, int i3, int i4, int i5, int i6) {
        if (j(i2, i3, i4, i5, i6)) {
            this.f8523c = a();
            this.f8528d = i2;
            this.f8529e = i3;
            this.f8530f = i4;
            this.f8531g = i5;
            this.f8532h = i6;
            double d2 = (double) i6;
            Double.isNaN(d2);
            int i7 = (int) (d2 / 1.5d);
            long j2 = this.f8521a;
            long j3 = j2 / 2;
            ValueAnimator h2 = h(i2, i3, j2, c.Width);
            c cVar = c.Height;
            ValueAnimator h3 = h(i4, i5, j3, cVar);
            c cVar2 = c.Radius;
            ValueAnimator h4 = h(i6, i7, j3, cVar2);
            ValueAnimator h5 = h(i5, i4, j3, cVar);
            ((AnimatorSet) this.f8523c).play(h3).with(h4).with(h2).before(h5).before(h(i7, i6, j3, cVar2));
        }
        return this;
    }
}
