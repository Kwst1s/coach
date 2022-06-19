package c.e.a.b.c0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapePath */
public class m {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f3337a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f3338b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f3339c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f3340d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f3341e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f3342f;

    /* renamed from: g  reason: collision with root package name */
    private final List<f> f3343g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<g> f3344h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f3345i;

    /* access modifiers changed from: package-private */
    /* compiled from: ShapePath */
    public class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f3346b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Matrix f3347c;

        a(m mVar, List list, Matrix matrix) {
            this.f3346b = list;
            this.f3347c = matrix;
        }

        @Override // c.e.a.b.c0.m.g
        public void a(Matrix matrix, c.e.a.b.b0.a aVar, int i2, Canvas canvas) {
            for (g gVar : this.f3346b) {
                gVar.a(this.f3347c, aVar, i2, canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ShapePath */
    public static class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final d f3348b;

        public b(d dVar) {
            this.f3348b = dVar;
        }

        @Override // c.e.a.b.c0.m.g
        public void a(Matrix matrix, c.e.a.b.b0.a aVar, int i2, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f3348b.k(), this.f3348b.o(), this.f3348b.l(), this.f3348b.j()), i2, this.f3348b.m(), this.f3348b.n());
        }
    }

    /* compiled from: ShapePath */
    static class c extends g {

        /* renamed from: b  reason: collision with root package name */
        private final e f3349b;

        /* renamed from: c  reason: collision with root package name */
        private final float f3350c;

        /* renamed from: d  reason: collision with root package name */
        private final float f3351d;

        public c(e eVar, float f2, float f3) {
            this.f3349b = eVar;
            this.f3350c = f2;
            this.f3351d = f3;
        }

        @Override // c.e.a.b.c0.m.g
        public void a(Matrix matrix, c.e.a.b.b0.a aVar, int i2, Canvas canvas) {
            RectF rectF = new RectF(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) Math.hypot((double) (this.f3349b.f3360c - this.f3351d), (double) (this.f3349b.f3359b - this.f3350c)), Utils.FLOAT_EPSILON);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f3350c, this.f3351d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i2);
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f3349b.f3360c - this.f3351d) / (this.f3349b.f3359b - this.f3350c))));
        }
    }

    /* compiled from: ShapePath */
    public static class d extends f {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f3352h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f3353b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f3354c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f3355d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f3356e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f3357f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f3358g;

        public d(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private float j() {
            return this.f3356e;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private float k() {
            return this.f3353b;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private float l() {
            return this.f3355d;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private float m() {
            return this.f3357f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private float n() {
            return this.f3358g;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private float o() {
            return this.f3354c;
        }

        private void p(float f2) {
            this.f3356e = f2;
        }

        private void q(float f2) {
            this.f3353b = f2;
        }

        private void r(float f2) {
            this.f3355d = f2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void s(float f2) {
            this.f3357f = f2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void t(float f2) {
            this.f3358g = f2;
        }

        private void u(float f2) {
            this.f3354c = f2;
        }

        @Override // c.e.a.b.c0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f3361a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f3352h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath */
    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        private float f3359b;

        /* renamed from: c  reason: collision with root package name */
        private float f3360c;

        @Override // c.e.a.b.c0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f3361a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f3359b, this.f3360c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f3361a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ShapePath */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f3362a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, c.e.a.b.b0.a aVar, int i2, Canvas canvas);

        public final void b(c.e.a.b.b0.a aVar, int i2, Canvas canvas) {
            a(f3362a, aVar, i2, canvas);
        }
    }

    public m() {
        n(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
    }

    private void b(float f2) {
        if (g() != f2) {
            float g2 = ((f2 - g()) + 360.0f) % 360.0f;
            if (g2 <= 180.0f) {
                d dVar = new d(i(), j(), i(), j());
                dVar.s(g());
                dVar.t(g2);
                this.f3344h.add(new b(dVar));
                p(f2);
            }
        }
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.f3344h.add(gVar);
        p(f3);
    }

    private float g() {
        return this.f3341e;
    }

    private float h() {
        return this.f3342f;
    }

    private void p(float f2) {
        this.f3341e = f2;
    }

    private void q(float f2) {
        this.f3342f = f2;
    }

    private void r(float f2) {
        this.f3339c = f2;
    }

    private void s(float f2) {
        this.f3340d = f2;
    }

    private void t(float f2) {
        this.f3337a = f2;
    }

    private void u(float f2) {
        this.f3338b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.f3343g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < Utils.FLOAT_EPSILON;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = (double) f8;
        r(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f3343g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3343g.get(i2).a(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f3345i;
    }

    /* access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(this, new ArrayList(this.f3344h), new Matrix(matrix));
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f3339c;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f3340d;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f3337a;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f3338b;
    }

    public void m(float f2, float f3) {
        e eVar = new e();
        eVar.f3359b = f2;
        eVar.f3360c = f3;
        this.f3343g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f2);
        s(f3);
    }

    public void n(float f2, float f3) {
        o(f2, f3, 270.0f, Utils.FLOAT_EPSILON);
    }

    public void o(float f2, float f3, float f4, float f5) {
        t(f2);
        u(f3);
        r(f2);
        s(f3);
        p(f4);
        q((f4 + f5) % 360.0f);
        this.f3343g.clear();
        this.f3344h.clear();
        this.f3345i = false;
    }
}
