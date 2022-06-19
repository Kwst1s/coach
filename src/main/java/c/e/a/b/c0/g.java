package c.e.a.b.c0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import c.e.a.b.c0.k;
import c.e.a.b.c0.l;
import c.e.a.b.c0.m;
import com.github.mikephil.charting.utils.Utils;
import java.util.BitSet;

/* compiled from: MaterialShapeDrawable */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {
    private static final String x = g.class.getSimpleName();
    private static final Paint y = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private c f3273b;

    /* renamed from: c  reason: collision with root package name */
    private final m.g[] f3274c;

    /* renamed from: d  reason: collision with root package name */
    private final m.g[] f3275d;

    /* renamed from: e  reason: collision with root package name */
    private final BitSet f3276e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3277f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f3278g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f3279h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f3280i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f3281j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f3282k;
    private final Region l;
    private final Region m;
    private k n;
    private final Paint o;
    private final Paint p;
    private final c.e.a.b.b0.a q;
    private final l.b r;
    private final l s;
    private PorterDuffColorFilter t;
    private PorterDuffColorFilter u;
    private final RectF v;
    private boolean w;

    /* compiled from: MaterialShapeDrawable */
    class a implements l.b {
        a() {
        }

        @Override // c.e.a.b.c0.l.b
        public void a(m mVar, Matrix matrix, int i2) {
            g.this.f3276e.set(i2 + 4, mVar.e());
            g.this.f3275d[i2] = mVar.f(matrix);
        }

        @Override // c.e.a.b.c0.l.b
        public void b(m mVar, Matrix matrix, int i2) {
            g.this.f3276e.set(i2, mVar.e());
            g.this.f3274c[i2] = mVar.f(matrix);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialShapeDrawable */
    public class b implements k.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f3284a;

        b(g gVar, float f2) {
            this.f3284a = f2;
        }

        @Override // c.e.a.b.c0.k.c
        public c a(c cVar) {
            return cVar instanceof i ? cVar : new b(this.f3284a, cVar);
        }
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    private float D() {
        return L() ? this.p.getStrokeWidth() / 2.0f : Utils.FLOAT_EPSILON;
    }

    private boolean J() {
        c cVar = this.f3273b;
        int i2 = cVar.q;
        if (i2 == 1 || cVar.r <= 0 || (i2 != 2 && !T())) {
            return false;
        }
        return true;
    }

    private boolean K() {
        Paint.Style style = this.f3273b.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean L() {
        Paint.Style style = this.f3273b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > Utils.FLOAT_EPSILON;
    }

    private void N() {
        super.invalidateSelf();
    }

    private void Q(Canvas canvas) {
        if (J()) {
            canvas.save();
            S(canvas);
            if (!this.w) {
                n(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.v.width() - ((float) getBounds().width()));
            int height = (int) (this.v.height() - ((float) getBounds().height()));
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.v.width()) + (this.f3273b.r * 2) + width, ((int) this.v.height()) + (this.f3273b.r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f2 = (float) ((getBounds().left - this.f3273b.r) - width);
            float f3 = (float) ((getBounds().top - this.f3273b.r) - height);
            canvas2.translate(-f2, -f3);
            n(canvas2);
            canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int R(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void S(Canvas canvas) {
        int z = z();
        int A = A();
        if (Build.VERSION.SDK_INT < 21 && this.w) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.f3273b.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(z, A);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate((float) z, (float) A);
    }

    private PorterDuffColorFilter f(Paint paint, boolean z) {
        int color;
        int l2;
        if (!z || (l2 = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l2, PorterDuff.Mode.SRC_IN);
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f3273b.f3294j != 1.0f) {
            this.f3278g.reset();
            Matrix matrix = this.f3278g;
            float f2 = this.f3273b.f3294j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f3278g);
        }
        path.computeBounds(this.v, true);
    }

    private boolean h0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f3273b.f3288d == null || color2 == (colorForState2 = this.f3273b.f3288d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z = false;
        } else {
            this.o.setColor(colorForState2);
            z = true;
        }
        if (this.f3273b.f3289e == null || color == (colorForState = this.f3273b.f3289e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z;
        }
        this.p.setColor(colorForState);
        return true;
    }

    private void i() {
        k y2 = C().y(new b(this, -D()));
        this.n = y2;
        this.s.d(y2, this.f3273b.f3295k, v(), this.f3280i);
    }

    private boolean i0() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        c cVar = this.f3273b;
        this.t = k(cVar.f3291g, cVar.f3292h, this.o, true);
        c cVar2 = this.f3273b;
        this.u = k(cVar2.f3290f, cVar2.f3292h, this.p, false);
        c cVar3 = this.f3273b;
        if (cVar3.u) {
            this.q.d(cVar3.f3291g.getColorForState(getState(), 0));
        }
        if (!b.h.j.c.a(porterDuffColorFilter, this.t) || !b.h.j.c.a(porterDuffColorFilter2, this.u)) {
            return true;
        }
        return false;
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private void j0() {
        float I = I();
        this.f3273b.r = (int) Math.ceil((double) (0.75f * I));
        this.f3273b.s = (int) Math.ceil((double) (I * 0.25f));
        i0();
        N();
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        if (colorStateList == null || mode == null) {
            return f(paint, z);
        }
        return j(colorStateList, mode, z);
    }

    private int l(int i2) {
        float I = I() + y();
        c.e.a.b.v.a aVar = this.f3273b.f3286b;
        return aVar != null ? aVar.c(i2, I) : i2;
    }

    public static g m(Context context, float f2) {
        int b2 = c.e.a.b.s.a.b(context, c.e.a.b.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.M(context);
        gVar.X(ColorStateList.valueOf(b2));
        gVar.W(f2);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.f3276e.cardinality() > 0) {
            Log.w(x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f3273b.s != 0) {
            canvas.drawPath(this.f3279h, this.q.c());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f3274c[i2].b(this.q, this.f3273b.r, canvas);
            this.f3275d[i2].b(this.q, this.f3273b.r, canvas);
        }
        if (this.w) {
            int z = z();
            int A = A();
            canvas.translate((float) (-z), (float) (-A));
            canvas.drawPath(this.f3279h, y);
            canvas.translate((float) z, (float) A);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.o, this.f3279h, this.f3273b.f3285a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (kVar.u(rectF)) {
            float a2 = kVar.t().a(rectF) * this.f3273b.f3295k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void r(Canvas canvas) {
        q(canvas, this.p, this.f3280i, this.n, v());
    }

    private RectF v() {
        this.f3282k.set(u());
        float D = D();
        this.f3282k.inset(D, D);
        return this.f3282k;
    }

    public int A() {
        c cVar = this.f3273b;
        double d2 = (double) cVar.s;
        double cos = Math.cos(Math.toRadians((double) cVar.t));
        Double.isNaN(d2);
        return (int) (d2 * cos);
    }

    public int B() {
        return this.f3273b.r;
    }

    public k C() {
        return this.f3273b.f3285a;
    }

    public ColorStateList E() {
        return this.f3273b.f3291g;
    }

    public float F() {
        return this.f3273b.f3285a.r().a(u());
    }

    public float G() {
        return this.f3273b.f3285a.t().a(u());
    }

    public float H() {
        return this.f3273b.p;
    }

    public float I() {
        return w() + H();
    }

    public void M(Context context) {
        this.f3273b.f3286b = new c.e.a.b.v.a(context);
        j0();
    }

    public boolean O() {
        c.e.a.b.v.a aVar = this.f3273b.f3286b;
        return aVar != null && aVar.d();
    }

    public boolean P() {
        return this.f3273b.f3285a.u(u());
    }

    public boolean T() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 21 || (!P() && !this.f3279h.isConvex() && i2 < 29);
    }

    public void U(float f2) {
        setShapeAppearanceModel(this.f3273b.f3285a.w(f2));
    }

    public void V(c cVar) {
        setShapeAppearanceModel(this.f3273b.f3285a.x(cVar));
    }

    public void W(float f2) {
        c cVar = this.f3273b;
        if (cVar.o != f2) {
            cVar.o = f2;
            j0();
        }
    }

    public void X(ColorStateList colorStateList) {
        c cVar = this.f3273b;
        if (cVar.f3288d != colorStateList) {
            cVar.f3288d = colorStateList;
            onStateChange(getState());
        }
    }

    public void Y(float f2) {
        c cVar = this.f3273b;
        if (cVar.f3295k != f2) {
            cVar.f3295k = f2;
            this.f3277f = true;
            invalidateSelf();
        }
    }

    public void Z(int i2, int i3, int i4, int i5) {
        c cVar = this.f3273b;
        if (cVar.f3293i == null) {
            cVar.f3293i = new Rect();
        }
        this.f3273b.f3293i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    public void a0(float f2) {
        c cVar = this.f3273b;
        if (cVar.n != f2) {
            cVar.n = f2;
            j0();
        }
    }

    public void b0(int i2) {
        this.q.d(i2);
        this.f3273b.u = false;
        N();
    }

    public void c0(int i2) {
        c cVar = this.f3273b;
        if (cVar.t != i2) {
            cVar.t = i2;
            N();
        }
    }

    public void d0(float f2, int i2) {
        g0(f2);
        f0(ColorStateList.valueOf(i2));
    }

    public void draw(Canvas canvas) {
        this.o.setColorFilter(this.t);
        int alpha = this.o.getAlpha();
        this.o.setAlpha(R(alpha, this.f3273b.m));
        this.p.setColorFilter(this.u);
        this.p.setStrokeWidth(this.f3273b.l);
        int alpha2 = this.p.getAlpha();
        this.p.setAlpha(R(alpha2, this.f3273b.m));
        if (this.f3277f) {
            i();
            g(u(), this.f3279h);
            this.f3277f = false;
        }
        Q(canvas);
        if (K()) {
            o(canvas);
        }
        if (L()) {
            r(canvas);
        }
        this.o.setAlpha(alpha);
        this.p.setAlpha(alpha2);
    }

    public void e0(float f2, ColorStateList colorStateList) {
        g0(f2);
        f0(colorStateList);
    }

    public void f0(ColorStateList colorStateList) {
        c cVar = this.f3273b;
        if (cVar.f3289e != colorStateList) {
            cVar.f3289e = colorStateList;
            onStateChange(getState());
        }
    }

    public void g0(float f2) {
        this.f3273b.l = f2;
        invalidateSelf();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f3273b;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f3273b.q != 2) {
            if (P()) {
                outline.setRoundRect(getBounds(), F() * this.f3273b.f3295k);
                return;
            }
            g(u(), this.f3279h);
            if (this.f3279h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f3279h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f3273b.f3293i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.l.set(getBounds());
        g(u(), this.f3279h);
        this.m.setPath(this.f3279h, this.l);
        this.l.op(this.m, Region.Op.DIFFERENCE);
        return this.l;
    }

    /* access modifiers changed from: protected */
    public final void h(RectF rectF, Path path) {
        l lVar = this.s;
        c cVar = this.f3273b;
        lVar.e(cVar.f3285a, cVar.f3295k, rectF, this.r, path);
    }

    public void invalidateSelf() {
        this.f3277f = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f3273b.f3291g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f3273b.f3290f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f3273b.f3289e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f3273b.f3288d) != null && colorStateList4.isStateful())));
    }

    public Drawable mutate() {
        this.f3273b = new c(this.f3273b);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f3277f = true;
        super.onBoundsChange(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = h0(iArr) || i0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f3273b.f3285a, rectF);
    }

    public float s() {
        return this.f3273b.f3285a.j().a(u());
    }

    public void setAlpha(int i2) {
        c cVar = this.f3273b;
        if (cVar.m != i2) {
            cVar.m = i2;
            N();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3273b.f3287c = colorFilter;
        N();
    }

    @Override // c.e.a.b.c0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f3273b.f3285a = kVar;
        invalidateSelf();
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f3273b.f3291g = colorStateList;
        i0();
        N();
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f3273b;
        if (cVar.f3292h != mode) {
            cVar.f3292h = mode;
            i0();
            N();
        }
    }

    public float t() {
        return this.f3273b.f3285a.l().a(u());
    }

    /* access modifiers changed from: protected */
    public RectF u() {
        this.f3281j.set(getBounds());
        return this.f3281j;
    }

    public float w() {
        return this.f3273b.o;
    }

    public ColorStateList x() {
        return this.f3273b.f3288d;
    }

    public float y() {
        return this.f3273b.n;
    }

    public int z() {
        c cVar = this.f3273b;
        double d2 = (double) cVar.s;
        double sin = Math.sin(Math.toRadians((double) cVar.t));
        Double.isNaN(d2);
        return (int) (d2 * sin);
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(k.e(context, attributeSet, i2, i3).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private g(c cVar) {
        this.f3274c = new m.g[4];
        this.f3275d = new m.g[4];
        this.f3276e = new BitSet(8);
        this.f3278g = new Matrix();
        this.f3279h = new Path();
        this.f3280i = new Path();
        this.f3281j = new RectF();
        this.f3282k = new RectF();
        this.l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new c.e.a.b.b0.a();
        this.s = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.v = new RectF();
        this.w = true;
        this.f3273b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = y;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        i0();
        h0(getState());
        this.r = new a();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialShapeDrawable */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public k f3285a;

        /* renamed from: b  reason: collision with root package name */
        public c.e.a.b.v.a f3286b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f3287c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f3288d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f3289e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f3290f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f3291g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f3292h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f3293i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f3294j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f3295k = 1.0f;
        public float l;
        public int m = 255;
        public float n = Utils.FLOAT_EPSILON;
        public float o = Utils.FLOAT_EPSILON;
        public float p = Utils.FLOAT_EPSILON;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Paint.Style v = Paint.Style.FILL_AND_STROKE;

        public c(k kVar, c.e.a.b.v.a aVar) {
            this.f3285a = kVar;
            this.f3286b = aVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f3277f = true;
            return gVar;
        }

        public c(c cVar) {
            this.f3285a = cVar.f3285a;
            this.f3286b = cVar.f3286b;
            this.l = cVar.l;
            this.f3287c = cVar.f3287c;
            this.f3288d = cVar.f3288d;
            this.f3289e = cVar.f3289e;
            this.f3292h = cVar.f3292h;
            this.f3291g = cVar.f3291g;
            this.m = cVar.m;
            this.f3294j = cVar.f3294j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.f3295k = cVar.f3295k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f3290f = cVar.f3290f;
            this.v = cVar.v;
            if (cVar.f3293i != null) {
                this.f3293i = new Rect(cVar.f3293i);
            }
        }
    }
}
