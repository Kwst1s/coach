package c.e.a.b.z;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import b.h.d.e.f;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: TextAppearance */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f3452a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f3453b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3454c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3455d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3456e;

    /* renamed from: f  reason: collision with root package name */
    public final float f3457f;

    /* renamed from: g  reason: collision with root package name */
    public final float f3458g;

    /* renamed from: h  reason: collision with root package name */
    public final float f3459h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3460i;

    /* renamed from: j  reason: collision with root package name */
    public final float f3461j;

    /* renamed from: k  reason: collision with root package name */
    public float f3462k;
    private final int l;
    private boolean m = false;
    private Typeface n;

    /* access modifiers changed from: package-private */
    /* compiled from: TextAppearance */
    public class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f3463a;

        a(f fVar) {
            this.f3463a = fVar;
        }

        @Override // b.h.d.e.f.a
        public void c(int i2) {
            d.this.m = true;
            this.f3463a.a(i2);
        }

        @Override // b.h.d.e.f.a
        public void d(Typeface typeface) {
            d dVar = d.this;
            dVar.n = Typeface.create(typeface, dVar.f3455d);
            d.this.m = true;
            this.f3463a.b(d.this.n, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TextAppearance */
    public class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextPaint f3465a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f3466b;

        b(TextPaint textPaint, f fVar) {
            this.f3465a = textPaint;
            this.f3466b = fVar;
        }

        @Override // c.e.a.b.z.f
        public void a(int i2) {
            this.f3466b.a(i2);
        }

        @Override // c.e.a.b.z.f
        public void b(Typeface typeface, boolean z) {
            d.this.k(this.f3465a, typeface);
            this.f3466b.b(typeface, z);
        }
    }

    public d(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, l.o3);
        this.f3462k = obtainStyledAttributes.getDimension(l.p3, Utils.FLOAT_EPSILON);
        this.f3452a = c.a(context, obtainStyledAttributes, l.s3);
        c.a(context, obtainStyledAttributes, l.t3);
        c.a(context, obtainStyledAttributes, l.u3);
        this.f3455d = obtainStyledAttributes.getInt(l.r3, 0);
        this.f3456e = obtainStyledAttributes.getInt(l.q3, 1);
        int e2 = c.e(obtainStyledAttributes, l.A3, l.z3);
        this.l = obtainStyledAttributes.getResourceId(e2, 0);
        this.f3454c = obtainStyledAttributes.getString(e2);
        obtainStyledAttributes.getBoolean(l.B3, false);
        this.f3453b = c.a(context, obtainStyledAttributes, l.v3);
        this.f3457f = obtainStyledAttributes.getFloat(l.w3, Utils.FLOAT_EPSILON);
        this.f3458g = obtainStyledAttributes.getFloat(l.x3, Utils.FLOAT_EPSILON);
        this.f3459h = obtainStyledAttributes.getFloat(l.y3, Utils.FLOAT_EPSILON);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, l.g2);
            int i3 = l.h2;
            this.f3460i = obtainStyledAttributes2.hasValue(i3);
            this.f3461j = obtainStyledAttributes2.getFloat(i3, Utils.FLOAT_EPSILON);
            obtainStyledAttributes2.recycle();
            return;
        }
        this.f3460i = false;
        this.f3461j = Utils.FLOAT_EPSILON;
    }

    private void d() {
        String str;
        if (this.n == null && (str = this.f3454c) != null) {
            this.n = Typeface.create(str, this.f3455d);
        }
        if (this.n == null) {
            int i2 = this.f3456e;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, this.f3455d);
        }
    }

    public Typeface e() {
        d();
        return this.n;
    }

    public Typeface f(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface b2 = f.b(context, this.l);
                this.n = b2;
                if (b2 != null) {
                    this.n = Typeface.create(b2, this.f3455d);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f3454c, e2);
            }
        }
        d();
        this.m = true;
        return this.n;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        k(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (e.a()) {
            f(context);
        } else {
            d();
        }
        int i2 = this.l;
        if (i2 == 0) {
            this.m = true;
        }
        if (this.m) {
            fVar.b(this.n, true);
            return;
        }
        try {
            f.d(context, i2, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f3454c, e2);
            this.m = true;
            fVar.a(-3);
        }
    }

    public void i(Context context, TextPaint textPaint, f fVar) {
        j(context, textPaint, fVar);
        ColorStateList colorStateList = this.f3452a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f3459h;
        float f3 = this.f3457f;
        float f4 = this.f3458g;
        ColorStateList colorStateList2 = this.f3453b;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void j(Context context, TextPaint textPaint, f fVar) {
        if (e.a()) {
            k(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void k(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ -1) & this.f3455d;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : Utils.FLOAT_EPSILON);
        textPaint.setTextSize(this.f3462k);
        if (Build.VERSION.SDK_INT >= 21 && this.f3460i) {
            textPaint.setLetterSpacing(this.f3461j);
        }
    }
}
