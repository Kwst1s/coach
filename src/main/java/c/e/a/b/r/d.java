package c.e.a.b.r;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* compiled from: CircularRevealWidget */
public interface d {

    /* compiled from: CircularRevealWidget */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f3427b = new b();

        /* renamed from: a  reason: collision with root package name */
        private final e f3428a = new e();

        /* renamed from: a */
        public e evaluate(float f2, e eVar, e eVar2) {
            this.f3428a.a(c.e.a.b.x.a.c(eVar.f3431a, eVar2.f3431a, f2), c.e.a.b.x.a.c(eVar.f3432b, eVar2.f3432b, f2), c.e.a.b.x.a.c(eVar.f3433c, eVar2.f3433c, f2));
            return this.f3428a;
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class c extends Property<d, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, e> f3429a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        /* renamed from: a */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        /* renamed from: b */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: c.e.a.b.r.d$d  reason: collision with other inner class name */
    /* compiled from: CircularRevealWidget */
    public static class C0082d extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f3430a = new C0082d("circularRevealScrimColor");

        private C0082d(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        /* renamed from: b */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f3431a;

        /* renamed from: b  reason: collision with root package name */
        public float f3432b;

        /* renamed from: c  reason: collision with root package name */
        public float f3433c;

        public void a(float f2, float f3, float f4) {
            this.f3431a = f2;
            this.f3432b = f3;
            this.f3433c = f4;
        }

        private e() {
        }

        public e(float f2, float f3, float f4) {
            this.f3431a = f2;
            this.f3432b = f3;
            this.f3433c = f4;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(e eVar);
}
