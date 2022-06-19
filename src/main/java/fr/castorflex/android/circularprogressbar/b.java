package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: DefaultDelegate */
public class b implements f {
    private static final ArgbEvaluator u = new ArgbEvaluator();
    private static final Interpolator v = new LinearInterpolator();

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f9697a;

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f9698b;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator f9699c;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f9700d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9701e;

    /* renamed from: f  reason: collision with root package name */
    private int f9702f;

    /* renamed from: g  reason: collision with root package name */
    private int f9703g;

    /* renamed from: h  reason: collision with root package name */
    private float f9704h;

    /* renamed from: i  reason: collision with root package name */
    private float f9705i = Utils.FLOAT_EPSILON;

    /* renamed from: j  reason: collision with root package name */
    private float f9706j = Utils.FLOAT_EPSILON;

    /* renamed from: k  reason: collision with root package name */
    private float f9707k = 1.0f;
    private boolean l;
    private final Interpolator m;
    private final Interpolator n;
    private final int[] o;
    private final float p;
    private final float q;
    private final int r;
    private final int s;
    private final a t;

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultDelegate */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.w(o.e(valueAnimator) * 360.0f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: fr.castorflex.android.circularprogressbar.b$b  reason: collision with other inner class name */
    /* compiled from: DefaultDelegate */
    public class C0220b implements ValueAnimator.AnimatorUpdateListener {
        C0220b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            float e2 = o.e(valueAnimator);
            if (b.this.l) {
                f2 = e2 * ((float) b.this.s);
            } else {
                f2 = (e2 * ((float) (b.this.s - b.this.r))) + ((float) b.this.r);
            }
            b.this.x(f2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultDelegate */
    public class c extends n {
        c() {
        }

        /* access modifiers changed from: protected */
        @Override // fr.castorflex.android.circularprogressbar.n
        public void b(Animator animator) {
            if (a()) {
                b.this.l = false;
                b.this.y();
                b.this.f9698b.start();
            }
        }

        @Override // fr.castorflex.android.circularprogressbar.n
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            b.this.f9701e = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultDelegate */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float e2 = o.e(valueAnimator);
            b bVar = b.this;
            bVar.x(((float) bVar.s) - (e2 * ((float) (b.this.s - b.this.r))));
            float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration());
            if (b.this.o.length > 1 && currentPlayTime > 0.7f) {
                b.this.t.a().setColor(((Integer) b.u.evaluate((currentPlayTime - 0.7f) / 0.3f, Integer.valueOf(b.this.f9702f), Integer.valueOf(b.this.o[(b.this.f9703g + 1) % b.this.o.length]))).intValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultDelegate */
    public class e extends n {
        e() {
        }

        /* access modifiers changed from: protected */
        @Override // fr.castorflex.android.circularprogressbar.n
        public void b(Animator animator) {
            if (a()) {
                b.this.v();
                b bVar = b.this;
                bVar.f9703g = (bVar.f9703g + 1) % b.this.o.length;
                b bVar2 = b.this;
                bVar2.f9702f = bVar2.o[b.this.f9703g];
                b.this.t.a().setColor(b.this.f9702f);
                b.this.f9697a.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultDelegate */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.z(1.0f - o.e(valueAnimator));
        }
    }

    b(a aVar, e eVar) {
        this.t = aVar;
        this.n = eVar.f9718b;
        this.m = eVar.f9717a;
        this.f9703g = 0;
        int[] iArr = eVar.f9720d;
        this.o = iArr;
        this.f9702f = iArr[0];
        this.p = eVar.f9721e;
        this.q = eVar.f9722f;
        this.r = eVar.f9723g;
        this.s = eVar.f9724h;
        A();
    }

    private void A() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Utils.FLOAT_EPSILON, 360.0f);
        this.f9699c = ofFloat;
        ofFloat.setInterpolator(this.m);
        this.f9699c.setDuration((long) (2000.0f / this.q));
        this.f9699c.addUpdateListener(new a());
        this.f9699c.setRepeatCount(-1);
        this.f9699c.setRepeatMode(1);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((float) this.r, (float) this.s);
        this.f9697a = ofFloat2;
        ofFloat2.setInterpolator(this.n);
        this.f9697a.setDuration((long) (600.0f / this.p));
        this.f9697a.addUpdateListener(new C0220b());
        this.f9697a.addListener(new c());
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat((float) this.s, (float) this.r);
        this.f9698b = ofFloat3;
        ofFloat3.setInterpolator(this.n);
        this.f9698b.setDuration((long) (600.0f / this.p));
        this.f9698b.addUpdateListener(new d());
        this.f9698b.addListener(new e());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, Utils.FLOAT_EPSILON);
        this.f9700d = ofFloat4;
        ofFloat4.setInterpolator(v);
        this.f9700d.setDuration(200L);
        this.f9700d.addUpdateListener(new f());
    }

    private void B() {
        this.f9699c.cancel();
        this.f9697a.cancel();
        this.f9698b.cancel();
        this.f9700d.cancel();
    }

    private void u() {
        this.l = true;
        this.f9707k = 1.0f;
        this.t.a().setColor(this.f9702f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v() {
        this.f9701e = true;
        this.f9705i += (float) this.r;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void w(float f2) {
        this.f9706j = f2;
        this.t.d();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x(float f2) {
        this.f9704h = f2;
        this.t.d();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y() {
        this.f9701e = false;
        this.f9705i += (float) (360 - this.s);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void z(float f2) {
        this.f9707k = f2;
        this.t.d();
    }

    @Override // fr.castorflex.android.circularprogressbar.f
    public void a(Canvas canvas, Paint paint) {
        float f2;
        float f3;
        float f4 = this.f9706j - this.f9705i;
        float f5 = this.f9704h;
        if (!this.f9701e) {
            f4 += 360.0f - f5;
        }
        float f6 = f4 % 360.0f;
        float f7 = this.f9707k;
        if (f7 < 1.0f) {
            float f8 = f7 * f5;
            f3 = (f6 + (f5 - f8)) % 360.0f;
            f2 = f8;
        } else {
            f3 = f6;
            f2 = f5;
        }
        canvas.drawArc(this.t.b(), f3, f2, false, paint);
    }

    @Override // fr.castorflex.android.circularprogressbar.f
    public void start() {
        this.f9700d.cancel();
        u();
        this.f9699c.start();
        this.f9697a.start();
    }

    @Override // fr.castorflex.android.circularprogressbar.f
    public void stop() {
        B();
    }
}
