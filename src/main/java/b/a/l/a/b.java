package b.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;

/* access modifiers changed from: package-private */
/* compiled from: DrawableContainer */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    private c f2021b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f2022c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f2023d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f2024e;

    /* renamed from: f  reason: collision with root package name */
    private int f2025f = 255;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2026g;

    /* renamed from: h  reason: collision with root package name */
    private int f2027h = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2028i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f2029j;

    /* renamed from: k  reason: collision with root package name */
    private long f2030k;
    private long l;
    private C0032b m;

    /* access modifiers changed from: package-private */
    /* compiled from: DrawableContainer */
    public class a implements Runnable {
        a() {
        }

        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b.a.l.a.b$b  reason: collision with other inner class name */
    /* compiled from: DrawableContainer */
    public static class C0032b implements Drawable.Callback {

        /* renamed from: b  reason: collision with root package name */
        private Drawable.Callback f2032b;

        C0032b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f2032b;
            this.f2032b = null;
            return callback;
        }

        public C0032b b(Drawable.Callback callback) {
            this.f2032b = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f2032b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f2032b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DrawableContainer */
    public static abstract class c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final b f2033a;

        /* renamed from: b  reason: collision with root package name */
        Resources f2034b;

        /* renamed from: c  reason: collision with root package name */
        int f2035c = 160;

        /* renamed from: d  reason: collision with root package name */
        int f2036d;

        /* renamed from: e  reason: collision with root package name */
        int f2037e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f2038f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f2039g;

        /* renamed from: h  reason: collision with root package name */
        int f2040h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2041i;

        /* renamed from: j  reason: collision with root package name */
        boolean f2042j;

        /* renamed from: k  reason: collision with root package name */
        Rect f2043k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        c(c cVar, b bVar, Resources resources) {
            Resources resources2;
            this.f2041i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f2033a = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.f2034b : null;
            }
            this.f2034b = resources2;
            int f2 = b.f(resources, cVar != null ? cVar.f2035c : 0);
            this.f2035c = f2;
            if (cVar != null) {
                this.f2036d = cVar.f2036d;
                this.f2037e = cVar.f2037e;
                this.v = true;
                this.w = true;
                this.f2041i = cVar.f2041i;
                this.l = cVar.l;
                this.x = cVar.x;
                this.y = cVar.y;
                this.z = cVar.z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.f2035c == f2) {
                    if (cVar.f2042j) {
                        this.f2043k = new Rect(cVar.f2043k);
                        this.f2042j = true;
                    }
                    if (cVar.m) {
                        this.n = cVar.n;
                        this.o = cVar.o;
                        this.p = cVar.p;
                        this.q = cVar.q;
                        this.m = true;
                    }
                }
                if (cVar.r) {
                    this.s = cVar.s;
                    this.r = true;
                }
                if (cVar.t) {
                    this.u = cVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = cVar.f2039g;
                this.f2039g = new Drawable[drawableArr.length];
                this.f2040h = cVar.f2040h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f2038f;
                if (sparseArray != null) {
                    this.f2038f = sparseArray.clone();
                } else {
                    this.f2038f = new SparseArray<>(this.f2040h);
                }
                int i2 = this.f2040h;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f2038f.put(i3, constantState);
                        } else {
                            this.f2039g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f2039g = new Drawable[10];
            this.f2040h = 0;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f2038f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f2039g[this.f2038f.keyAt(i2)] = s(this.f2038f.valueAt(i2).newDrawable(this.f2034b));
                }
                this.f2038f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f2033a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f2040h;
            if (i2 >= this.f2039g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f2033a);
            this.f2039g[i2] = drawable;
            this.f2040h++;
            this.f2037e = drawable.getChangingConfigurations() | this.f2037e;
            p();
            this.f2043k = null;
            this.f2042j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f2040h;
                Drawable[] drawableArr = this.f2039g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        this.f2037e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                y(theme.getResources());
            }
        }

        public synchronized boolean c() {
            if (this.v) {
                return this.w;
            }
            e();
            this.v = true;
            int i2 = this.f2040h;
            Drawable[] drawableArr = this.f2039g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int i2 = this.f2040h;
            Drawable[] drawableArr = this.f2039g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f2038f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void d() {
            this.m = true;
            e();
            int i2 = this.f2040h;
            Drawable[] drawableArr = this.f2039g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int f() {
            return this.f2039g.length;
        }

        public final Drawable g(int i2) {
            int indexOfKey;
            Drawable drawable = this.f2039g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f2038f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable s2 = s(this.f2038f.valueAt(indexOfKey).newDrawable(this.f2034b));
            this.f2039g[i2] = s2;
            this.f2038f.removeAt(indexOfKey);
            if (this.f2038f.size() == 0) {
                this.f2038f = null;
            }
            return s2;
        }

        public int getChangingConfigurations() {
            return this.f2036d | this.f2037e;
        }

        public final int h() {
            return this.f2040h;
        }

        public final int i() {
            if (!this.m) {
                d();
            }
            return this.o;
        }

        public final int j() {
            if (!this.m) {
                d();
            }
            return this.q;
        }

        public final int k() {
            if (!this.m) {
                d();
            }
            return this.p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f2041i) {
                return null;
            }
            Rect rect2 = this.f2043k;
            if (rect2 != null || this.f2042j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f2040h;
            Drawable[] drawableArr = this.f2039g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f2042j = true;
            this.f2043k = rect;
            return rect;
        }

        public final int m() {
            if (!this.m) {
                d();
            }
            return this.n;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            e();
            int i2 = this.f2040h;
            Drawable[] drawableArr = this.f2039g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f2039g, 0, drawableArr, 0, i2);
            this.f2039g = drawableArr;
        }

        /* access modifiers changed from: package-private */
        public void p() {
            this.r = false;
            this.t = false;
        }

        public final boolean q() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public abstract void r();

        public final void t(boolean z2) {
            this.l = z2;
        }

        public final void u(int i2) {
            this.A = i2;
        }

        public final void v(int i2) {
            this.B = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean w(int i2, int i3) {
            int i4 = this.f2040h;
            Drawable[] drawableArr = this.f2039g;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                    if (i5 == i3) {
                        z2 = layoutDirection;
                    }
                }
            }
            this.z = i2;
            return z2;
        }

        public final void x(boolean z2) {
            this.f2041i = z2;
        }

        /* access modifiers changed from: package-private */
        public final void y(Resources resources) {
            if (resources != null) {
                this.f2034b = resources;
                int f2 = b.f(resources, this.f2035c);
                int i2 = this.f2035c;
                this.f2035c = f2;
                if (i2 != f2) {
                    this.m = false;
                    this.f2042j = false;
                }
            }
        }
    }

    b() {
    }

    private void d(Drawable drawable) {
        if (this.m == null) {
            this.m = new C0032b();
        }
        C0032b bVar = this.m;
        bVar.b(drawable.getCallback());
        drawable.setCallback(bVar);
        try {
            if (this.f2021b.A <= 0 && this.f2026g) {
                drawable.setAlpha(this.f2025f);
            }
            c cVar = this.f2021b;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    androidx.core.graphics.drawable.a.o(drawable, cVar.F);
                }
                c cVar2 = this.f2021b;
                if (cVar2.I) {
                    androidx.core.graphics.drawable.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f2021b.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i2 >= 19) {
                drawable.setAutoMirrored(this.f2021b.C);
            }
            Rect rect = this.f2022c;
            if (i2 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    private boolean e() {
        if (!isAutoMirrored() || androidx.core.graphics.drawable.a.f(this) != 1) {
            return false;
        }
        return true;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.l.a.b.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        this.f2021b.b(theme);
    }

    /* access modifiers changed from: package-private */
    public c b() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f2027h;
    }

    public boolean canApplyTheme() {
        return this.f2021b.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f2024e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(int r10) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.l.a.b.g(int):boolean");
    }

    public int getAlpha() {
        return this.f2025f;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f2021b.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f2021b.c()) {
            return null;
        }
        this.f2021b.f2036d = getChangingConfigurations();
        return this.f2021b;
    }

    public Drawable getCurrent() {
        return this.f2023d;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f2022c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f2021b.q()) {
            return this.f2021b.i();
        }
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f2021b.q()) {
            return this.f2021b.m();
        }
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f2021b.q()) {
            return this.f2021b.j();
        }
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f2021b.q()) {
            return this.f2021b.k();
        }
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f2023d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f2021b.n();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        Rect l2 = this.f2021b.l();
        if (l2 != null) {
            rect.set(l2);
            z = (l2.right | ((l2.left | l2.top) | l2.bottom)) != 0;
        } else {
            Drawable drawable = this.f2023d;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void h(c cVar) {
        this.f2021b = cVar;
        int i2 = this.f2027h;
        if (i2 >= 0) {
            Drawable g2 = cVar.g(i2);
            this.f2023d = g2;
            if (g2 != null) {
                d(g2);
            }
        }
        this.f2024e = null;
    }

    /* access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f2021b.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f2021b;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable == this.f2023d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f2021b.C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f2024e;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f2024e = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f2023d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f2026g) {
                this.f2023d.setAlpha(this.f2025f);
            }
        }
        if (this.l != 0) {
            this.l = 0;
            z = true;
        }
        if (this.f2030k != 0) {
            this.f2030k = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f2028i && super.mutate() == this) {
            c b2 = b();
            b2.r();
            h(b2);
            this.f2028i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2024e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f2023d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return this.f2021b.w(i2, c());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f2024e;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f2023d;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2024e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f2023d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f2023d && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f2026g || this.f2025f != i2) {
            this.f2026g = true;
            this.f2025f = i2;
            Drawable drawable = this.f2023d;
            if (drawable == null) {
                return;
            }
            if (this.f2030k == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        c cVar = this.f2021b;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f2023d;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j(drawable, z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f2021b;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f2023d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        c cVar = this.f2021b;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f2023d;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f2022c;
        if (rect == null) {
            this.f2022c = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f2023d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l(drawable, i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f2021b;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            androidx.core.graphics.drawable.a.o(this.f2023d, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f2021b;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            androidx.core.graphics.drawable.a.p(this.f2023d, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f2024e;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f2023d;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f2023d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
