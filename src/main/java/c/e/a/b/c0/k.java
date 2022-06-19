package c.e.a.b.c0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ShapeAppearanceModel */
public class k {
    public static final c m = new i(0.5f);

    /* renamed from: a  reason: collision with root package name */
    d f3298a;

    /* renamed from: b  reason: collision with root package name */
    d f3299b;

    /* renamed from: c  reason: collision with root package name */
    d f3300c;

    /* renamed from: d  reason: collision with root package name */
    d f3301d;

    /* renamed from: e  reason: collision with root package name */
    c f3302e;

    /* renamed from: f  reason: collision with root package name */
    c f3303f;

    /* renamed from: g  reason: collision with root package name */
    c f3304g;

    /* renamed from: h  reason: collision with root package name */
    c f3305h;

    /* renamed from: i  reason: collision with root package name */
    f f3306i;

    /* renamed from: j  reason: collision with root package name */
    f f3307j;

    /* renamed from: k  reason: collision with root package name */
    f f3308k;
    f l;

    /* compiled from: ShapeAppearanceModel */
    public interface c {
        c a(c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i2, int i3) {
        return c(context, i2, i3, 0);
    }

    private static b c(Context context, int i2, int i3, int i4) {
        return d(context, i2, i3, new a((float) i4));
    }

    private static b d(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, l.u2);
        try {
            int i4 = obtainStyledAttributes.getInt(l.v2, 0);
            int i5 = obtainStyledAttributes.getInt(l.y2, i4);
            int i6 = obtainStyledAttributes.getInt(l.z2, i4);
            int i7 = obtainStyledAttributes.getInt(l.x2, i4);
            int i8 = obtainStyledAttributes.getInt(l.w2, i4);
            c m2 = m(obtainStyledAttributes, l.A2, cVar);
            c m3 = m(obtainStyledAttributes, l.D2, m2);
            c m4 = m(obtainStyledAttributes, l.E2, m2);
            c m5 = m(obtainStyledAttributes, l.C2, m2);
            c m6 = m(obtainStyledAttributes, l.B2, m2);
            b bVar = new b();
            bVar.y(i5, m3);
            bVar.C(i6, m4);
            bVar.u(i7, m5);
            bVar.q(i8, m6);
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i2, int i3) {
        return f(context, attributeSet, i2, i3, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i2, int i3, int i4) {
        return g(context, attributeSet, i2, i3, new a((float) i4));
    }

    public static b g(Context context, AttributeSet attributeSet, int i2, int i3, c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.d2, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(l.e2, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(l.f2, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static c m(TypedArray typedArray, int i2, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cVar;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f3308k;
    }

    public d i() {
        return this.f3301d;
    }

    public c j() {
        return this.f3305h;
    }

    public d k() {
        return this.f3300c;
    }

    public c l() {
        return this.f3304g;
    }

    public f n() {
        return this.l;
    }

    public f o() {
        return this.f3307j;
    }

    public f p() {
        return this.f3306i;
    }

    public d q() {
        return this.f3298a;
    }

    public c r() {
        return this.f3302e;
    }

    public d s() {
        return this.f3299b;
    }

    public c t() {
        return this.f3303f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.f3307j.getClass().equals(f.class) && this.f3306i.getClass().equals(f.class) && this.f3308k.getClass().equals(f.class);
        float a2 = this.f3302e.a(rectF);
        boolean z2 = this.f3303f.a(rectF) == a2 && this.f3305h.a(rectF) == a2 && this.f3304g.a(rectF) == a2;
        boolean z3 = (this.f3299b instanceof j) && (this.f3298a instanceof j) && (this.f3300c instanceof j) && (this.f3301d instanceof j);
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    public b v() {
        return new b(this);
    }

    public k w(float f2) {
        b v = v();
        v.o(f2);
        return v.m();
    }

    public k x(c cVar) {
        b v = v();
        v.p(cVar);
        return v.m();
    }

    public k y(c cVar) {
        b v = v();
        v.B(cVar.a(r()));
        v.F(cVar.a(t()));
        v.t(cVar.a(j()));
        v.x(cVar.a(l()));
        return v.m();
    }

    private k(b bVar) {
        this.f3298a = bVar.f3309a;
        this.f3299b = bVar.f3310b;
        this.f3300c = bVar.f3311c;
        this.f3301d = bVar.f3312d;
        this.f3302e = bVar.f3313e;
        this.f3303f = bVar.f3314f;
        this.f3304g = bVar.f3315g;
        this.f3305h = bVar.f3316h;
        this.f3306i = bVar.f3317i;
        this.f3307j = bVar.f3318j;
        this.f3308k = bVar.f3319k;
        this.l = bVar.l;
    }

    /* compiled from: ShapeAppearanceModel */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private d f3309a = h.b();

        /* renamed from: b  reason: collision with root package name */
        private d f3310b = h.b();

        /* renamed from: c  reason: collision with root package name */
        private d f3311c = h.b();

        /* renamed from: d  reason: collision with root package name */
        private d f3312d = h.b();

        /* renamed from: e  reason: collision with root package name */
        private c f3313e = new a(Utils.FLOAT_EPSILON);

        /* renamed from: f  reason: collision with root package name */
        private c f3314f = new a(Utils.FLOAT_EPSILON);

        /* renamed from: g  reason: collision with root package name */
        private c f3315g = new a(Utils.FLOAT_EPSILON);

        /* renamed from: h  reason: collision with root package name */
        private c f3316h = new a(Utils.FLOAT_EPSILON);

        /* renamed from: i  reason: collision with root package name */
        private f f3317i = h.c();

        /* renamed from: j  reason: collision with root package name */
        private f f3318j = h.c();

        /* renamed from: k  reason: collision with root package name */
        private f f3319k = h.c();
        private f l = h.c();

        public b() {
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f3297a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f3272a;
            }
            return -1.0f;
        }

        public b A(float f2) {
            this.f3313e = new a(f2);
            return this;
        }

        public b B(c cVar) {
            this.f3313e = cVar;
            return this;
        }

        public b C(int i2, c cVar) {
            D(h.a(i2));
            F(cVar);
            return this;
        }

        public b D(d dVar) {
            this.f3310b = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                E(n);
            }
            return this;
        }

        public b E(float f2) {
            this.f3314f = new a(f2);
            return this;
        }

        public b F(c cVar) {
            this.f3314f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f2) {
            A(f2);
            E(f2);
            w(f2);
            s(f2);
            return this;
        }

        public b p(c cVar) {
            B(cVar);
            F(cVar);
            x(cVar);
            t(cVar);
            return this;
        }

        public b q(int i2, c cVar) {
            r(h.a(i2));
            t(cVar);
            return this;
        }

        public b r(d dVar) {
            this.f3312d = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                s(n);
            }
            return this;
        }

        public b s(float f2) {
            this.f3316h = new a(f2);
            return this;
        }

        public b t(c cVar) {
            this.f3316h = cVar;
            return this;
        }

        public b u(int i2, c cVar) {
            v(h.a(i2));
            x(cVar);
            return this;
        }

        public b v(d dVar) {
            this.f3311c = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                w(n);
            }
            return this;
        }

        public b w(float f2) {
            this.f3315g = new a(f2);
            return this;
        }

        public b x(c cVar) {
            this.f3315g = cVar;
            return this;
        }

        public b y(int i2, c cVar) {
            z(h.a(i2));
            B(cVar);
            return this;
        }

        public b z(d dVar) {
            this.f3309a = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                A(n);
            }
            return this;
        }

        public b(k kVar) {
            this.f3309a = kVar.f3298a;
            this.f3310b = kVar.f3299b;
            this.f3311c = kVar.f3300c;
            this.f3312d = kVar.f3301d;
            this.f3313e = kVar.f3302e;
            this.f3314f = kVar.f3303f;
            this.f3315g = kVar.f3304g;
            this.f3316h = kVar.f3305h;
            this.f3317i = kVar.f3306i;
            this.f3318j = kVar.f3307j;
            this.f3319k = kVar.f3308k;
            this.l = kVar.l;
        }
    }

    public k() {
        this.f3298a = h.b();
        this.f3299b = h.b();
        this.f3300c = h.b();
        this.f3301d = h.b();
        this.f3302e = new a(Utils.FLOAT_EPSILON);
        this.f3303f = new a(Utils.FLOAT_EPSILON);
        this.f3304g = new a(Utils.FLOAT_EPSILON);
        this.f3305h = new a(Utils.FLOAT_EPSILON);
        this.f3306i = h.c();
        this.f3307j = h.c();
        this.f3308k = h.c();
        this.l = h.c();
    }
}
