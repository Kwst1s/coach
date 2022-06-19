package b.s.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import b.h.e.c;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat */
public class i extends h {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f2983k = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private h f2984c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f2985d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f2986e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2987f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2988g;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f2989h;

    /* renamed from: i  reason: collision with root package name */
    private final Matrix f2990i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f2991j;

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3011b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3010a = b.h.e.c.d(string2);
            }
            this.f3012c = b.h.d.e.g.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // b.s.a.a.i.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (b.h.d.e.g.j(xmlPullParser, "pathData")) {
                TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, a.f2959d);
                f(k2, xmlPullParser);
                k2.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f3025a;

        /* renamed from: b  reason: collision with root package name */
        g f3026b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f3027c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f3028d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3029e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f3030f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f3031g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f3032h;

        /* renamed from: i  reason: collision with root package name */
        int f3033i;

        /* renamed from: j  reason: collision with root package name */
        boolean f3034j;

        /* renamed from: k  reason: collision with root package name */
        boolean f3035k;
        Paint l;

        public h(h hVar) {
            this.f3027c = null;
            this.f3028d = i.f2983k;
            if (hVar != null) {
                this.f3025a = hVar.f3025a;
                g gVar = new g(hVar.f3026b);
                this.f3026b = gVar;
                if (hVar.f3026b.f3018e != null) {
                    gVar.f3018e = new Paint(hVar.f3026b.f3018e);
                }
                if (hVar.f3026b.f3017d != null) {
                    this.f3026b.f3017d = new Paint(hVar.f3026b.f3017d);
                }
                this.f3027c = hVar.f3027c;
                this.f3028d = hVar.f3028d;
                this.f3029e = hVar.f3029e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f3030f.getWidth() && i3 == this.f3030f.getHeight();
        }

        public boolean b() {
            return !this.f3035k && this.f3031g == this.f3027c && this.f3032h == this.f3028d && this.f3034j == this.f3029e && this.f3033i == this.f3026b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f3030f == null || !a(i2, i3)) {
                this.f3030f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f3035k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3030f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f3026b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean f() {
            return this.f3026b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f3026b.f();
        }

        public int getChangingConfigurations() {
            return this.f3025a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.f3026b.g(iArr);
            this.f3035k |= g2;
            return g2;
        }

        public void i() {
            this.f3031g = this.f3027c;
            this.f3032h = this.f3028d;
            this.f3033i = this.f3026b.getRootAlpha();
            this.f3034j = this.f3029e;
            this.f3035k = false;
        }

        public void j(int i2, int i3) {
            this.f3030f.eraseColor(0);
            this.f3026b.b(new Canvas(this.f3030f), i2, i3, null);
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            this.f3027c = null;
            this.f3028d = i.f2983k;
            this.f3026b = new g();
        }
    }

    i() {
        this.f2988g = true;
        this.f2989h = new float[9];
        this.f2990i = new Matrix();
        this.f2991j = new Rect();
        this.f2984c = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b.s.a.a.i b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0021
            b.s.a.a.i r0 = new b.s.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r6 = b.h.d.e.f.a(r6, r7, r8)
            r0.f2982b = r6
            b.s.a.a.i$i r6 = new b.s.a.a.i$i
            android.graphics.drawable.Drawable r7 = r0.f2982b
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x0021:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0029:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            r4 = 2
            if (r3 == r4) goto L_0x0034
            r5 = 1
            if (r3 == r5) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            if (r3 != r4) goto L_0x003b
            b.s.a.a.i r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            return r6
        L_0x003b:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b.s.a.a.i.b(android.content.res.Resources, int, android.content.res.Resources$Theme):b.s.a.a.i");
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = this.f2984c;
        g gVar = hVar.f3026b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f3021h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3000b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.f3025a = cVar.f3013d | hVar.f3025a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3000b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f3025a = bVar.f3013d | hVar.f3025a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3000b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f3025a = dVar2.f3009k | hVar.f3025a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || androidx.core.graphics.drawable.a.f(this) != 1) {
            return false;
        }
        return true;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f2984c;
        g gVar = hVar.f3026b;
        hVar.f3028d = g(b.h.d.e.g.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c2 = b.h.d.e.g.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c2 != null) {
            hVar.f3027c = c2;
        }
        hVar.f3029e = b.h.d.e.g.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f3029e);
        gVar.f3024k = b.h.d.e.g.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f3024k);
        float f2 = b.h.d.e.g.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        gVar.l = f2;
        if (gVar.f3024k <= Utils.FLOAT_EPSILON) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f2 > Utils.FLOAT_EPSILON) {
            gVar.f3022i = typedArray.getDimension(3, gVar.f3022i);
            float dimension = typedArray.getDimension(2, gVar.f3023j);
            gVar.f3023j = dimension;
            if (gVar.f3022i <= Utils.FLOAT_EPSILON) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > Utils.FLOAT_EPSILON) {
                gVar.setAlpha(b.h.d.e.g.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.n = string;
                    gVar.p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f2982b;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    /* access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f2984c.f3026b.p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2991j);
        if (this.f2991j.width() > 0 && this.f2991j.height() > 0) {
            ColorFilter colorFilter = this.f2986e;
            if (colorFilter == null) {
                colorFilter = this.f2985d;
            }
            canvas.getMatrix(this.f2990i);
            this.f2990i.getValues(this.f2989h);
            float abs = Math.abs(this.f2989h[0]);
            float abs2 = Math.abs(this.f2989h[4]);
            float abs3 = Math.abs(this.f2989h[1]);
            float abs4 = Math.abs(this.f2989h[3]);
            if (!(abs3 == Utils.FLOAT_EPSILON && abs4 == Utils.FLOAT_EPSILON)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f2991j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f2991j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f2991j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.f2991j.width(), Utils.FLOAT_EPSILON);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2991j.offsetTo(0, 0);
                this.f2984c.c(min, min2);
                if (!this.f2988g) {
                    this.f2984c.j(min, min2);
                } else if (!this.f2984c.b()) {
                    this.f2984c.j(min, min2);
                    this.f2984c.i();
                }
                this.f2984c.d(canvas, colorFilter, this.f2991j);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f2984c.f3026b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2984c.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f2986e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2982b != null && Build.VERSION.SDK_INT >= 24) {
            return new C0064i(this.f2982b.getConstantState());
        }
        this.f2984c.f3025a = getChangingConfigurations();
        return this.f2984c;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f2984c.f3026b.f3023j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f2984c.f3026b.f3022i;
    }

    public int getOpacity() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z) {
        this.f2988g = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f2984c.f3029e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f2984c) != null && (hVar.g() || ((colorStateList = this.f2984c.f3027c) != null && colorStateList.isStateful())));
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public Drawable mutate() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2987f && super.mutate() == this) {
            this.f2984c = new h(this.f2984c);
            this.f2987f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f2984c;
        ColorStateList colorStateList = hVar.f3027c;
        if (!(colorStateList == null || (mode = hVar.f3028d) == null)) {
            this.f2985d = j(this.f2985d, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f2984c.f3026b.getRootAlpha() != i2) {
            this.f2984c.f3026b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f2984c.f3029e = z;
        }
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f2984c;
        if (hVar.f3027c != colorStateList) {
            hVar.f3027c = colorStateList;
            this.f2985d = j(this.f2985d, colorStateList, hVar.f3028d);
            invalidateSelf();
        }
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f2984c;
        if (hVar.f3028d != mode) {
            hVar.f3028d = mode;
            this.f2985d = j(this.f2985d, hVar.f3027c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b.s.a.a.i$i  reason: collision with other inner class name */
    /* compiled from: VectorDrawableCompat */
    public static class C0064i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f3036a;

        public C0064i(Drawable.ConstantState constantState) {
            this.f3036a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f3036a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3036a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f2982b = (VectorDrawable) this.f3036a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f2982b = (VectorDrawable) this.f3036a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f2982b = (VectorDrawable) this.f3036a.newDrawable(resources, theme);
            return iVar;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2986e = colorFilter;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected c.b[] f3010a = null;

        /* renamed from: b  reason: collision with root package name */
        String f3011b;

        /* renamed from: c  reason: collision with root package name */
        int f3012c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f3013d;

        public f() {
            super();
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.f3010a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.f3010a;
        }

        public String getPathName() {
            return this.f3011b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!b.h.e.c.b(this.f3010a, bVarArr)) {
                this.f3010a = b.h.e.c.f(bVarArr);
            } else {
                b.h.e.c.j(this.f3010a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f3011b = fVar.f3011b;
            this.f3013d = fVar.f3013d;
            this.f3010a = b.h.e.c.f(fVar.f3010a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f2984c;
        hVar.f3026b = new g();
        TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, a.f2956a);
        i(k2, xmlPullParser, theme);
        k2.recycle();
        hVar.f3025a = getChangingConfigurations();
        hVar.f3035k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f2985d = j(this.f2985d, hVar.f3027c, hVar.f3028d);
    }

    i(h hVar) {
        this.f2988g = true;
        this.f2989h = new float[9];
        this.f2990i = new Matrix();
        this.f2991j = new Rect();
        this.f2984c = hVar;
        this.f2985d = j(this.f2985d, hVar.f3027c, hVar.f3028d);
    }

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f2992e;

        /* renamed from: f  reason: collision with root package name */
        b.h.d.e.b f2993f;

        /* renamed from: g  reason: collision with root package name */
        float f2994g = Utils.FLOAT_EPSILON;

        /* renamed from: h  reason: collision with root package name */
        b.h.d.e.b f2995h;

        /* renamed from: i  reason: collision with root package name */
        float f2996i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        float f2997j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f2998k = Utils.FLOAT_EPSILON;
        float l = 1.0f;
        float m = Utils.FLOAT_EPSILON;
        Paint.Cap n = Paint.Cap.BUTT;
        Paint.Join o = Paint.Join.MITER;
        float p = 4.0f;

        c() {
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2992e = null;
            if (b.h.d.e.g.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3011b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3010a = b.h.e.c.d(string2);
                }
                this.f2995h = b.h.d.e.g.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2997j = b.h.d.e.g.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f2997j);
                this.n = e(b.h.d.e.g.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(b.h.d.e.g.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = b.h.d.e.g.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f2993f = b.h.d.e.g.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2996i = b.h.d.e.g.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2996i);
                this.f2994g = b.h.d.e.g.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f2994g);
                this.l = b.h.d.e.g.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = b.h.d.e.g.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.f2998k = b.h.d.e.g.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f2998k);
                this.f3012c = b.h.d.e.g.g(typedArray, xmlPullParser, "fillType", 13, this.f3012c);
            }
        }

        @Override // b.s.a.a.i.e
        public boolean a() {
            return this.f2995h.i() || this.f2993f.i();
        }

        @Override // b.s.a.a.i.e
        public boolean b(int[] iArr) {
            return this.f2993f.j(iArr) | this.f2995h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, a.f2958c);
            h(k2, xmlPullParser, theme);
            k2.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f2997j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f2995h.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f2996i;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f2993f.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f2994g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f2998k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.f2997j = f2;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.f2995h.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.f2996i = f2;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f2993f.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f2994g = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.f2998k = f2;
        }

        c(c cVar) {
            super(cVar);
            this.f2992e = cVar.f2992e;
            this.f2993f = cVar.f2993f;
            this.f2994g = cVar.f2994g;
            this.f2996i = cVar.f2996i;
            this.f2995h = cVar.f2995h;
            this.f3012c = cVar.f3012c;
            this.f2997j = cVar.f2997j;
            this.f2998k = cVar.f2998k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static class g {
        private static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f3014a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f3015b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f3016c;

        /* renamed from: d  reason: collision with root package name */
        Paint f3017d;

        /* renamed from: e  reason: collision with root package name */
        Paint f3018e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f3019f;

        /* renamed from: g  reason: collision with root package name */
        private int f3020g;

        /* renamed from: h  reason: collision with root package name */
        final d f3021h;

        /* renamed from: i  reason: collision with root package name */
        float f3022i;

        /* renamed from: j  reason: collision with root package name */
        float f3023j;

        /* renamed from: k  reason: collision with root package name */
        float f3024k;
        float l;
        int m;
        String n;
        Boolean o;
        final b.e.a<String, Object> p;

        public g() {
            this.f3016c = new Matrix();
            this.f3022i = Utils.FLOAT_EPSILON;
            this.f3023j = Utils.FLOAT_EPSILON;
            this.f3024k = Utils.FLOAT_EPSILON;
            this.l = Utils.FLOAT_EPSILON;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new b.e.a<>();
            this.f3021h = new d();
            this.f3014a = new Path();
            this.f3015b = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f2999a.set(matrix);
            dVar.f2999a.preConcat(dVar.f3008j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f3000b.size(); i4++) {
                e eVar = dVar.f3000b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f2999a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.f3024k;
            float f3 = ((float) i3) / this.l;
            float min = Math.min(f2, f3);
            Matrix matrix = dVar.f2999a;
            this.f3016c.set(matrix);
            this.f3016c.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 != Utils.FLOAT_EPSILON) {
                fVar.d(this.f3014a);
                Path path = this.f3014a;
                this.f3015b.reset();
                if (fVar.c()) {
                    this.f3015b.setFillType(fVar.f3012c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f3015b.addPath(path, this.f3016c);
                    canvas.clipPath(this.f3015b);
                    return;
                }
                c cVar = (c) fVar;
                float f4 = cVar.f2998k;
                if (!(f4 == Utils.FLOAT_EPSILON && cVar.l == 1.0f)) {
                    float f5 = cVar.m;
                    float f6 = (f4 + f5) % 1.0f;
                    float f7 = (cVar.l + f5) % 1.0f;
                    if (this.f3019f == null) {
                        this.f3019f = new PathMeasure();
                    }
                    this.f3019f.setPath(this.f3014a, false);
                    float length = this.f3019f.getLength();
                    float f8 = f6 * length;
                    float f9 = f7 * length;
                    path.reset();
                    if (f8 > f9) {
                        this.f3019f.getSegment(f8, length, path, true);
                        this.f3019f.getSegment(Utils.FLOAT_EPSILON, f9, path, true);
                    } else {
                        this.f3019f.getSegment(f8, f9, path, true);
                    }
                    path.rLineTo(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
                }
                this.f3015b.addPath(path, this.f3016c);
                if (cVar.f2995h.l()) {
                    b.h.d.e.b bVar = cVar.f2995h;
                    if (this.f3018e == null) {
                        Paint paint = new Paint(1);
                        this.f3018e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f3018e;
                    if (bVar.h()) {
                        Shader f10 = bVar.f();
                        f10.setLocalMatrix(this.f3016c);
                        paint2.setShader(f10);
                        paint2.setAlpha(Math.round(cVar.f2997j * 255.0f));
                    } else {
                        paint2.setShader(null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(bVar.e(), cVar.f2997j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f3015b.setFillType(cVar.f3012c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f3015b, paint2);
                }
                if (cVar.f2993f.l()) {
                    b.h.d.e.b bVar2 = cVar.f2993f;
                    if (this.f3017d == null) {
                        Paint paint3 = new Paint(1);
                        this.f3017d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f3017d;
                    Paint.Join join = cVar.o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.p);
                    if (bVar2.h()) {
                        Shader f11 = bVar2.f();
                        f11.setLocalMatrix(this.f3016c);
                        paint4.setShader(f11);
                        paint4.setAlpha(Math.round(cVar.f2996i * 255.0f));
                    } else {
                        paint4.setShader(null);
                        paint4.setAlpha(255);
                        paint4.setColor(i.a(bVar2.e(), cVar.f2996i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f2994g * min * e2);
                    canvas.drawPath(this.f3015b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {Utils.FLOAT_EPSILON, 1.0f, 1.0f, Utils.FLOAT_EPSILON};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > Utils.FLOAT_EPSILON) {
                return Math.abs(a2) / max;
            }
            return Utils.FLOAT_EPSILON;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f3021h, q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.f3021h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f3021h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public g(g gVar) {
            this.f3016c = new Matrix();
            this.f3022i = Utils.FLOAT_EPSILON;
            this.f3023j = Utils.FLOAT_EPSILON;
            this.f3024k = Utils.FLOAT_EPSILON;
            this.l = Utils.FLOAT_EPSILON;
            this.m = 255;
            this.n = null;
            this.o = null;
            b.e.a<String, Object> aVar = new b.e.a<>();
            this.p = aVar;
            this.f3021h = new d(gVar.f3021h, aVar);
            this.f3014a = new Path(gVar.f3014a);
            this.f3015b = new Path(gVar.f3015b);
            this.f3022i = gVar.f3022i;
            this.f3023j = gVar.f3023j;
            this.f3024k = gVar.f3024k;
            this.l = gVar.l;
            this.f3020g = gVar.f3020g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.o = gVar.o;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f2999a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f3000b;

        /* renamed from: c  reason: collision with root package name */
        float f3001c;

        /* renamed from: d  reason: collision with root package name */
        private float f3002d;

        /* renamed from: e  reason: collision with root package name */
        private float f3003e;

        /* renamed from: f  reason: collision with root package name */
        private float f3004f;

        /* renamed from: g  reason: collision with root package name */
        private float f3005g;

        /* renamed from: h  reason: collision with root package name */
        private float f3006h;

        /* renamed from: i  reason: collision with root package name */
        private float f3007i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f3008j;

        /* renamed from: k  reason: collision with root package name */
        int f3009k;
        private int[] l;
        private String m;

        public d(d dVar, b.e.a<String, Object> aVar) {
            super();
            f fVar;
            this.f2999a = new Matrix();
            this.f3000b = new ArrayList<>();
            this.f3001c = Utils.FLOAT_EPSILON;
            this.f3002d = Utils.FLOAT_EPSILON;
            this.f3003e = Utils.FLOAT_EPSILON;
            this.f3004f = 1.0f;
            this.f3005g = 1.0f;
            this.f3006h = Utils.FLOAT_EPSILON;
            this.f3007i = Utils.FLOAT_EPSILON;
            Matrix matrix = new Matrix();
            this.f3008j = matrix;
            this.m = null;
            this.f3001c = dVar.f3001c;
            this.f3002d = dVar.f3002d;
            this.f3003e = dVar.f3003e;
            this.f3004f = dVar.f3004f;
            this.f3005g = dVar.f3005g;
            this.f3006h = dVar.f3006h;
            this.f3007i = dVar.f3007i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.f3009k = dVar.f3009k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f3008j);
            ArrayList<e> arrayList = dVar.f3000b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f3000b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f3000b.add(fVar);
                    String str2 = fVar.f3011b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.f3008j.reset();
            this.f3008j.postTranslate(-this.f3002d, -this.f3003e);
            this.f3008j.postScale(this.f3004f, this.f3005g);
            this.f3008j.postRotate(this.f3001c, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
            this.f3008j.postTranslate(this.f3006h + this.f3002d, this.f3007i + this.f3003e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f3001c = b.h.d.e.g.f(typedArray, xmlPullParser, "rotation", 5, this.f3001c);
            this.f3002d = typedArray.getFloat(1, this.f3002d);
            this.f3003e = typedArray.getFloat(2, this.f3003e);
            this.f3004f = b.h.d.e.g.f(typedArray, xmlPullParser, "scaleX", 3, this.f3004f);
            this.f3005g = b.h.d.e.g.f(typedArray, xmlPullParser, "scaleY", 4, this.f3005g);
            this.f3006h = b.h.d.e.g.f(typedArray, xmlPullParser, "translateX", 6, this.f3006h);
            this.f3007i = b.h.d.e.g.f(typedArray, xmlPullParser, "translateY", 7, this.f3007i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // b.s.a.a.i.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f3000b.size(); i2++) {
                if (this.f3000b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // b.s.a.a.i.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f3000b.size(); i2++) {
                z |= this.f3000b.get(i2).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, a.f2957b);
            e(k2, xmlPullParser);
            k2.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f3008j;
        }

        public float getPivotX() {
            return this.f3002d;
        }

        public float getPivotY() {
            return this.f3003e;
        }

        public float getRotation() {
            return this.f3001c;
        }

        public float getScaleX() {
            return this.f3004f;
        }

        public float getScaleY() {
            return this.f3005g;
        }

        public float getTranslateX() {
            return this.f3006h;
        }

        public float getTranslateY() {
            return this.f3007i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f3002d) {
                this.f3002d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f3003e) {
                this.f3003e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f3001c) {
                this.f3001c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f3004f) {
                this.f3004f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f3005g) {
                this.f3005g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3006h) {
                this.f3006h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f3007i) {
                this.f3007i = f2;
                d();
            }
        }

        public d() {
            super();
            this.f2999a = new Matrix();
            this.f3000b = new ArrayList<>();
            this.f3001c = Utils.FLOAT_EPSILON;
            this.f3002d = Utils.FLOAT_EPSILON;
            this.f3003e = Utils.FLOAT_EPSILON;
            this.f3004f = 1.0f;
            this.f3005g = 1.0f;
            this.f3006h = Utils.FLOAT_EPSILON;
            this.f3007i = Utils.FLOAT_EPSILON;
            this.f3008j = new Matrix();
            this.m = null;
        }
    }
}
