package b.s.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import b.h.d.e.g;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AnimatedVectorDrawableCompat */
public class c extends h implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    private b f2967c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2968d;

    /* renamed from: e  reason: collision with root package name */
    private ArgbEvaluator f2969e;

    /* renamed from: f  reason: collision with root package name */
    final Drawable.Callback f2970f;

    /* compiled from: AnimatedVectorDrawableCompat */
    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            c.this.scheduleSelf(runnable, j2);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2972a;

        /* renamed from: b  reason: collision with root package name */
        i f2973b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f2974c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f2975d;

        /* renamed from: e  reason: collision with root package name */
        b.e.a<Animator, String> f2976e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f2972a = bVar.f2972a;
                i iVar = bVar.f2973b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f2973b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f2973b = (i) constantState.newDrawable();
                    }
                    i iVar2 = this.f2973b;
                    iVar2.mutate();
                    i iVar3 = iVar2;
                    this.f2973b = iVar3;
                    iVar3.setCallback(callback);
                    this.f2973b.setBounds(bVar.f2973b.getBounds());
                    this.f2973b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.f2975d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2975d = new ArrayList<>(size);
                    this.f2976e = new b.e.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = bVar.f2975d.get(i2);
                        Animator clone = animator.clone();
                        String str = bVar.f2976e.get(animator);
                        clone.setTarget(this.f2973b.d(str));
                        this.f2975d.add(clone);
                        this.f2976e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f2974c == null) {
                this.f2974c = new AnimatorSet();
            }
            this.f2974c.playTogether(this.f2975d);
        }

        public int getChangingConfigurations() {
            return this.f2972a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    c() {
        this(null, null, null);
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f2967c.f2973b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.f2967c;
        if (bVar.f2975d == null) {
            bVar.f2975d = new ArrayList<>();
            this.f2967c.f2976e = new b.e.a<>();
        }
        this.f2967c.f2975d.add(animator);
        this.f2967c.f2976e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                c(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2969e == null) {
                    this.f2969e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2969e);
            }
        }
    }

    @Override // b.s.a.a.h
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f2967c.f2973b.draw(canvas);
        if (this.f2967c.f2974c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f2967c.f2973b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2967c.f2972a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f2967c.f2973b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2982b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0063c(this.f2982b.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f2967c.f2973b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f2967c.f2973b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f2967c.f2973b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k2 = g.k(resources, theme, attributeSet, a.f2960e);
                    int resourceId = k2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i b2 = i.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.f2970f);
                        i iVar = this.f2967c.f2973b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f2967c.f2973b = b2;
                    }
                    k2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f2961f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2968d;
                        if (context != null) {
                            b(string, e.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2967c.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f2967c.f2973b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f2967c.f2974c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f2967c.f2973b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2967c.f2973b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    @Override // b.s.a.a.h
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        return this.f2967c.f2973b.setLevel(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f2967c.f2973b.setState(iArr);
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f2967c.f2973b.setAlpha(i2);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f2967c.f2973b.setAutoMirrored(z);
        }
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            this.f2967c.f2973b.setTint(i2);
        }
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f2967c.f2973b.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f2967c.f2973b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f2967c.f2973b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f2967c.f2974c.isStarted()) {
            this.f2967c.f2974c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2967c.f2974c.end();
        }
    }

    private c(Context context) {
        this(context, null, null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2982b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2967c.f2973b.setColorFilter(colorFilter);
        }
    }

    /* renamed from: b.s.a.a.c$c  reason: collision with other inner class name */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C0063c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2977a;

        public C0063c(Drawable.ConstantState constantState) {
            this.f2977a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f2977a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2977a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c cVar = new c();
            Drawable newDrawable = this.f2977a.newDrawable();
            cVar.f2982b = newDrawable;
            newDrawable.setCallback(cVar.f2970f);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable newDrawable = this.f2977a.newDrawable(resources);
            cVar.f2982b = newDrawable;
            newDrawable.setCallback(cVar.f2970f);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable newDrawable = this.f2977a.newDrawable(resources, theme);
            cVar.f2982b = newDrawable;
            newDrawable.setCallback(cVar.f2970f);
            return cVar;
        }
    }

    private c(Context context, b bVar, Resources resources) {
        this.f2969e = null;
        a aVar = new a();
        this.f2970f = aVar;
        this.f2968d = context;
        if (bVar != null) {
            this.f2967c = bVar;
        } else {
            this.f2967c = new b(context, bVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
