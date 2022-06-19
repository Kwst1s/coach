package c.e.a.b.c0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ShapeAppearancePathProvider */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f3320a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f3321b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f3322c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f3323d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f3324e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f3325f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final m f3326g = new m();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f3327h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f3328i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f3329j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f3330k = new Path();
    private boolean l = true;

    /* access modifiers changed from: private */
    /* compiled from: ShapeAppearancePathProvider */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final l f3331a = new l();
    }

    /* compiled from: ShapeAppearancePathProvider */
    public interface b {
        void a(m mVar, Matrix matrix, int i2);

        void b(m mVar, Matrix matrix, int i2);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ShapeAppearancePathProvider */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k f3332a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f3333b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f3334c;

        /* renamed from: d  reason: collision with root package name */
        public final b f3335d;

        /* renamed from: e  reason: collision with root package name */
        public final float f3336e;

        c(k kVar, float f2, RectF rectF, b bVar, Path path) {
            this.f3335d = bVar;
            this.f3332a = kVar;
            this.f3336e = f2;
            this.f3334c = rectF;
            this.f3333b = path;
        }
    }

    public l() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f3320a[i2] = new m();
            this.f3321b[i2] = new Matrix();
            this.f3322c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (float) ((i2 + 1) * 90);
    }

    private void b(c cVar, int i2) {
        this.f3327h[0] = this.f3320a[i2].k();
        this.f3327h[1] = this.f3320a[i2].l();
        this.f3321b[i2].mapPoints(this.f3327h);
        if (i2 == 0) {
            Path path = cVar.f3333b;
            float[] fArr = this.f3327h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f3333b;
            float[] fArr2 = this.f3327h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f3320a[i2].d(this.f3321b[i2], cVar.f3333b);
        b bVar = cVar.f3335d;
        if (bVar != null) {
            bVar.b(this.f3320a[i2], this.f3321b[i2], i2);
        }
    }

    private void c(c cVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f3327h[0] = this.f3320a[i2].i();
        this.f3327h[1] = this.f3320a[i2].j();
        this.f3321b[i2].mapPoints(this.f3327h);
        this.f3328i[0] = this.f3320a[i3].k();
        this.f3328i[1] = this.f3320a[i3].l();
        this.f3321b[i3].mapPoints(this.f3328i);
        float[] fArr = this.f3327h;
        float f2 = fArr[0];
        float[] fArr2 = this.f3328i;
        float max = Math.max(((float) Math.hypot((double) (f2 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, (float) Utils.FLOAT_EPSILON);
        float i4 = i(cVar.f3334c, i2);
        this.f3326g.n(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        f j2 = j(i2, cVar.f3332a);
        j2.b(max, i4, cVar.f3336e, this.f3326g);
        this.f3329j.reset();
        this.f3326g.d(this.f3322c[i2], this.f3329j);
        if (!this.l || Build.VERSION.SDK_INT < 19 || (!j2.a() && !l(this.f3329j, i2) && !l(this.f3329j, i3))) {
            this.f3326g.d(this.f3322c[i2], cVar.f3333b);
        } else {
            Path path = this.f3329j;
            path.op(path, this.f3325f, Path.Op.DIFFERENCE);
            this.f3327h[0] = this.f3326g.k();
            this.f3327h[1] = this.f3326g.l();
            this.f3322c[i2].mapPoints(this.f3327h);
            Path path2 = this.f3324e;
            float[] fArr3 = this.f3327h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f3326g.d(this.f3322c[i2], this.f3324e);
        }
        b bVar = cVar.f3335d;
        if (bVar != null) {
            bVar.a(this.f3326g, this.f3322c[i2], i2);
        }
    }

    private void f(int i2, RectF rectF, PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private c g(int i2, k kVar) {
        if (i2 == 1) {
            return kVar.l();
        }
        if (i2 == 2) {
            return kVar.j();
        }
        if (i2 != 3) {
            return kVar.t();
        }
        return kVar.r();
    }

    private d h(int i2, k kVar) {
        if (i2 == 1) {
            return kVar.k();
        }
        if (i2 == 2) {
            return kVar.i();
        }
        if (i2 != 3) {
            return kVar.s();
        }
        return kVar.q();
    }

    private float i(RectF rectF, int i2) {
        float[] fArr = this.f3327h;
        m[] mVarArr = this.f3320a;
        fArr[0] = mVarArr[i2].f3339c;
        fArr[1] = mVarArr[i2].f3340d;
        this.f3321b[i2].mapPoints(fArr);
        if (i2 == 1 || i2 == 3) {
            return Math.abs(rectF.centerX() - this.f3327h[0]);
        }
        return Math.abs(rectF.centerY() - this.f3327h[1]);
    }

    private f j(int i2, k kVar) {
        if (i2 == 1) {
            return kVar.h();
        }
        if (i2 == 2) {
            return kVar.n();
        }
        if (i2 != 3) {
            return kVar.o();
        }
        return kVar.p();
    }

    public static l k() {
        return a.f3331a;
    }

    private boolean l(Path path, int i2) {
        this.f3330k.reset();
        this.f3320a[i2].d(this.f3321b[i2], this.f3330k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f3330k.computeBounds(rectF, true);
        path.op(this.f3330k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    private void m(c cVar, int i2) {
        h(i2, cVar.f3332a).b(this.f3320a[i2], 90.0f, cVar.f3336e, cVar.f3334c, g(i2, cVar.f3332a));
        float a2 = a(i2);
        this.f3321b[i2].reset();
        f(i2, cVar.f3334c, this.f3323d);
        Matrix matrix = this.f3321b[i2];
        PointF pointF = this.f3323d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f3321b[i2].preRotate(a2);
    }

    private void n(int i2) {
        this.f3327h[0] = this.f3320a[i2].i();
        this.f3327h[1] = this.f3320a[i2].j();
        this.f3321b[i2].mapPoints(this.f3327h);
        float a2 = a(i2);
        this.f3322c[i2].reset();
        Matrix matrix = this.f3322c[i2];
        float[] fArr = this.f3327h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f3322c[i2].preRotate(a2);
    }

    public void d(k kVar, float f2, RectF rectF, Path path) {
        e(kVar, f2, rectF, null, path);
    }

    public void e(k kVar, float f2, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f3324e.rewind();
        this.f3325f.rewind();
        this.f3325f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f2, rectF, bVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            m(cVar, i2);
            n(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(cVar, i3);
            c(cVar, i3);
        }
        path.close();
        this.f3324e.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.f3324e.isEmpty()) {
            path.op(this.f3324e, Path.Op.UNION);
        }
    }
}
