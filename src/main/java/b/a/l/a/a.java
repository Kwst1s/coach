package b.a.l.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.g0;
import b.a.l.a.b;
import b.a.l.a.d;
import b.e.h;
import b.s.a.a.i;
import com.github.mikephil.charting.utils.Utils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* compiled from: AnimatedStateListDrawableCompat */
public class a extends d implements androidx.core.graphics.drawable.b {
    private c p;
    private g q;
    private int r;
    private int s;
    private boolean t;

    /* access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f2014a;

        b(Animatable animatable) {
            super();
            this.f2014a = animatable;
        }

        @Override // b.a.l.a.a.g
        public void c() {
            this.f2014a.start();
        }

        @Override // b.a.l.a.a.g
        public void d() {
            this.f2014a.stop();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class c extends d.a {
        b.e.d<Long> K;
        h<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new b.e.d<>();
            this.L = new h<>();
        }

        private static long D(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        /* access modifiers changed from: package-private */
        public int B(int[] iArr, Drawable drawable, int i2) {
            int z = super.z(iArr, drawable);
            this.L.j(z, Integer.valueOf(i2));
            return z;
        }

        /* access modifiers changed from: package-private */
        public int C(int i2, int i3, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long D = D(i2, i3);
            long j2 = z ? 8589934592L : 0;
            long j3 = (long) a2;
            this.K.a(D, Long.valueOf(j3 | j2));
            if (z) {
                this.K.a(D(i3, i2), Long.valueOf(4294967296L | j3 | j2));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int E(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.f(i2, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int F(int[] iArr) {
            int A = super.A(iArr);
            if (A >= 0) {
                return A;
            }
            return super.A(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int G(int i2, int i3) {
            return (int) this.K.f(D(i2, i3), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean H(int i2, int i3) {
            return (this.K.f(D(i2, i3), -1L).longValue() & 4294967296L) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean I(int i2, int i3) {
            return (this.K.f(D(i2, i3), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // b.a.l.a.d.a
        public Drawable newDrawable() {
            return new a(this, null);
        }

        /* access modifiers changed from: package-private */
        @Override // b.a.l.a.d.a, b.a.l.a.b.c
        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // b.a.l.a.d.a
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final b.s.a.a.c f2015a;

        d(b.s.a.a.c cVar) {
            super();
            this.f2015a = cVar;
        }

        @Override // b.a.l.a.a.g
        public void c() {
            this.f2015a.start();
        }

        @Override // b.a.l.a.a.g
        public void d() {
            this.f2015a.stop();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f2016a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2017b;

        e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) fVar.a());
            ofInt.setInterpolator(fVar);
            this.f2017b = z2;
            this.f2016a = ofInt;
        }

        @Override // b.a.l.a.a.g
        public boolean a() {
            return this.f2017b;
        }

        @Override // b.a.l.a.a.g
        public void b() {
            this.f2016a.reverse();
        }

        @Override // b.a.l.a.a.g
        public void c() {
            this.f2016a.start();
        }

        @Override // b.a.l.a.a.g
        public void d() {
            this.f2016a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f2018a;

        /* renamed from: b  reason: collision with root package name */
        private int f2019b;

        /* renamed from: c  reason: collision with root package name */
        private int f2020c;

        f(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f2020c;
        }

        /* access modifiers changed from: package-private */
        public int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f2019b = numberOfFrames;
            int[] iArr = this.f2018a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f2018a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f2018a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f2020c = i2;
            return i2;
        }

        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * ((float) this.f2020c)) + 0.5f);
            int i3 = this.f2019b;
            int[] iArr = this.f2018a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (((float) i4) / ((float) i3)) + (i4 < i3 ? ((float) i2) / ((float) this.f2020c) : Utils.FLOAT_EPSILON);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, b.a.m.b.f2052h);
        int resourceId = k2.getResourceId(b.a.m.b.f2053i, 0);
        int resourceId2 = k2.getResourceId(b.a.m.b.f2054j, -1);
        Drawable j2 = resourceId2 > 0 ? g0.h().j(context, resourceId2) : null;
        k2.recycle();
        int[] k3 = k(attributeSet);
        if (j2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                j2 = i.c(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (j2 != null) {
            return this.p.B(k3, j2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, b.a.m.b.f2055k);
        int resourceId = k2.getResourceId(b.a.m.b.n, -1);
        int resourceId2 = k2.getResourceId(b.a.m.b.m, -1);
        int resourceId3 = k2.getResourceId(b.a.m.b.l, -1);
        Drawable j2 = resourceId3 > 0 ? g0.h().j(context, resourceId3) : null;
        boolean z = k2.getBoolean(b.a.m.b.o, false);
        k2.recycle();
        if (j2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                j2 = b.s.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (j2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.p.C(resourceId, resourceId2, j2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean s(int i2) {
        int i3;
        int G;
        g gVar;
        g gVar2 = this.q;
        if (gVar2 == null) {
            i3 = c();
        } else if (i2 == this.r) {
            return true;
        } else {
            if (i2 != this.s || !gVar2.a()) {
                i3 = this.r;
                gVar2.d();
            } else {
                gVar2.b();
                this.r = this.s;
                this.s = i2;
                return true;
            }
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        c cVar = this.p;
        int E = cVar.E(i3);
        int E2 = cVar.E(i2);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof b.s.a.a.c) {
            gVar = new d((b.s.a.a.c) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.q = gVar;
        this.s = i3;
        this.r = i2;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.p;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f2036d |= typedArray.getChangingConfigurations();
        }
        cVar.x(typedArray.getBoolean(b.a.m.b.f2048d, cVar.f2041i));
        cVar.t(typedArray.getBoolean(b.a.m.b.f2049e, cVar.l));
        cVar.u(typedArray.getInt(b.a.m.b.f2050f, cVar.A));
        cVar.v(typedArray.getInt(b.a.m.b.f2051g, cVar.B));
        setDither(typedArray.getBoolean(b.a.m.b.f2046b, cVar.x));
    }

    /* access modifiers changed from: package-private */
    @Override // b.a.l.a.d, b.a.l.a.b
    public void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof c) {
            this.p = (c) cVar;
        }
    }

    @Override // b.a.l.a.d
    public boolean isStateful() {
        return true;
    }

    @Override // b.a.l.a.b
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            g(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public c j() {
        return new c(this.p, this, null);
    }

    @Override // b.a.l.a.d, b.a.l.a.b
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.r();
                this.t = true;
            }
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, b.a.m.b.f2045a);
        setVisible(k2.getBoolean(b.a.m.b.f2047c, true), true);
        t(k2);
        i(resources);
        k2.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    /* access modifiers changed from: protected */
    @Override // b.a.l.a.d, b.a.l.a.b
    public boolean onStateChange(int[] iArr) {
        int F = this.p.F(iArr);
        boolean z = F != c() && (s(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // b.a.l.a.b
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.q;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    a(c cVar, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
