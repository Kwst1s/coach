package app.minimize.com.seek_bar_compat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSeekBar;
import java.util.concurrent.Callable;
import kotlin.TypeCastException;
import kotlin.m.b.d;
import kotlin.m.b.f;

/* compiled from: SeekBarCompat.kt */
public final class SeekBarCompat extends AppCompatSeekBar implements View.OnTouchListener {
    private static final String r = "SeekBarCompat";
    public static final b s = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private int f1897c;

    /* renamed from: d  reason: collision with root package name */
    private int f1898d;

    /* renamed from: e  reason: collision with root package name */
    private int f1899e;

    /* renamed from: f  reason: collision with root package name */
    private int f1900f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1901g;

    /* renamed from: h  reason: collision with root package name */
    private int[][] f1902h = {new int[]{16842910}, new int[]{16842919}, new int[]{-16842910}, new int[0]};

    /* renamed from: i  reason: collision with root package name */
    private int[] f1903i = {-16777216, -16777216, -3355444, -16777216};

    /* renamed from: j  reason: collision with root package name */
    private int[] f1904j = {-16777216, -16777216, -3355444, -16777216};

    /* renamed from: k  reason: collision with root package name */
    private int[] f1905k = {-16777216, -16777216, -3355444, -16777216};
    private ColorStateList l;
    private ColorStateList m;
    private ColorStateList n;
    private int o;
    private int p = 255;
    private GradientDrawable q = new GradientDrawable();

    /* compiled from: SeekBarCompat.kt */
    static final class a<V> implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeekBarCompat f1906a;

        a(SeekBarCompat seekBarCompat) {
            this.f1906a = seekBarCompat;
        }

        /* renamed from: a */
        public final Void call() {
            ViewGroup.LayoutParams layoutParams = this.f1906a.getLayoutParams();
            SeekBarCompat seekBarCompat = this.f1906a;
            Drawable mThumb$seekbar_compat_release = seekBarCompat.getMThumb$seekbar_compat_release();
            if (mThumb$seekbar_compat_release != null) {
                seekBarCompat.o = mThumb$seekbar_compat_release.getIntrinsicHeight();
                this.f1906a.getGradientDrawable$seekbar_compat_release().setSize(this.f1906a.o / 3, this.f1906a.o / 3);
                this.f1906a.getGradientDrawable$seekbar_compat_release().setAlpha(this.f1906a.p);
                SeekBarCompat seekBarCompat2 = this.f1906a;
                seekBarCompat2.setThumb(seekBarCompat2.getGradientDrawable$seekbar_compat_release());
                if (layoutParams.height < this.f1906a.o) {
                    layoutParams.height = this.f1906a.o;
                }
                this.f1906a.l();
                return null;
            }
            f.l();
            throw null;
        }
    }

    /* compiled from: SeekBarCompat.kt */
    public static final class b {

        /* compiled from: SeekBarCompat.kt */
        public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f1907b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Callable f1908c;

            a(View view, Callable callable) {
                this.f1907b = view;
                this.f1908c = callable;
            }

            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    this.f1907b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    this.f1907b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                try {
                    this.f1908c.call();
                } catch (Exception e2) {
                    String c2 = SeekBarCompat.s.c();
                    Log.e(c2, "onGlobalLayout " + e2.toString());
                }
            }
        }

        private b() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final String c() {
            return SeekBarCompat.r;
        }

        public final int b(Context context) {
            f.f(context, "context");
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{a.f1911a, a.colorPrimaryDark});
            int color = obtainStyledAttributes.getColor(0, -16777216);
            obtainStyledAttributes.recycle();
            return color;
        }

        public final void d(View view, Callable<Void> callable) {
            f.f(view, "view");
            f.f(callable, "method");
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, callable));
        }

        public /* synthetic */ b(d dVar) {
            this();
        }
    }

    /* compiled from: SeekBarCompat.kt */
    static final class c<V> implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeekBarCompat f1909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1910b;

        c(SeekBarCompat seekBarCompat, boolean z) {
            this.f1909a = seekBarCompat;
            this.f1910b = z;
        }

        /* renamed from: a */
        public final Void call() {
            if (!this.f1909a.k()) {
                this.f1909a.setGradientDrawable$seekbar_compat_release(new GradientDrawable());
                this.f1909a.getGradientDrawable$seekbar_compat_release().setShape(1);
                this.f1909a.getGradientDrawable$seekbar_compat_release().setSize(this.f1909a.o / 3, this.f1909a.o / 3);
                this.f1909a.getGradientDrawable$seekbar_compat_release().setColor(this.f1910b ? this.f1909a.getMThumbColor$seekbar_compat_release() : -3355444);
                this.f1909a.getGradientDrawable$seekbar_compat_release().setDither(true);
                this.f1909a.getGradientDrawable$seekbar_compat_release().setAlpha(this.f1909a.p);
                SeekBarCompat seekBarCompat = this.f1909a;
                seekBarCompat.setThumb(seekBarCompat.getGradientDrawable$seekbar_compat_release());
                Drawable progressDrawable = this.f1909a.getProgressDrawable();
                if (progressDrawable != null) {
                    LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
                    Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
                    if (findDrawableByLayerId != null) {
                        ((ScaleDrawable) findDrawableByLayerId).setColorFilter(this.f1910b ? this.f1909a.getMProgressColor$seekbar_compat_release() : -3355444, PorterDuff.Mode.SRC_IN);
                        Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                        if (findDrawableByLayerId2 != null) {
                            ((NinePatchDrawable) findDrawableByLayerId2).setColorFilter(0, PorterDuff.Mode.SRC_IN);
                            Context context = this.f1909a.getContext();
                            f.b(context, "context");
                            d dVar = new d(context, this.f1910b ? this.f1909a.getMProgressBackgroundColor$seekbar_compat_release() : -3355444, this.f1909a.f1897c, (float) this.f1909a.getPaddingLeft(), (float) this.f1909a.getPaddingRight());
                            if (this.f1909a.j()) {
                                this.f1909a.setBackgroundDrawable(dVar);
                            } else {
                                this.f1909a.setBackground(dVar);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.NinePatchDrawable");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ScaleDrawable");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
                }
            }
            SeekBarCompat.super.setEnabled(this.f1910b);
            return null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public SeekBarCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f.f(context, "context");
        f.f(attributeSet, "attrs");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.f1912a, 0, 0);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964, 16842766}, 0, 0);
        try {
            int i2 = c.f1916e;
            b bVar = s;
            this.f1898d = obtainStyledAttributes.getColor(i2, bVar.b(context));
            this.f1899e = obtainStyledAttributes.getColor(c.f1914c, bVar.b(context));
            this.f1900f = obtainStyledAttributes.getColor(c.f1913b, -16777216);
            this.p = (int) (obtainStyledAttributes.getFloat(c.f1915d, 1.0f) * ((float) 255));
            this.f1897c = obtainStyledAttributes2.getColor(0, 0);
            if (k()) {
                setSplitTrack(false);
                p();
                o();
                m();
                Drawable thumb = getThumb();
                f.b(thumb, "thumb");
                thumb.setAlpha(this.p);
            } else {
                n();
                setOnTouchListener(this);
                this.q.setShape(1);
                this.q.setSize(50, 50);
                this.q.setColor(isEnabled() ? this.f1898d : -3355444);
                bVar.d(this, new a(this));
            }
        } finally {
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean j() {
        return Build.VERSION.SDK_INT < 16;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean k() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @TargetApi(16)
    private final void l() {
        Context context = getContext();
        f.b(context, "context");
        d dVar = new d(context, this.f1900f, this.f1897c, (float) getPaddingLeft(), (float) getPaddingRight());
        if (j()) {
            setBackgroundDrawable(dVar);
        } else {
            setBackground(dVar);
        }
    }

    @TargetApi(21)
    private final void m() {
        int[] iArr = this.f1905k;
        int i2 = this.f1900f;
        iArr[0] = i2;
        iArr[1] = i2;
        ColorStateList colorStateList = new ColorStateList(this.f1902h, this.f1905k);
        this.n = colorStateList;
        setProgressBackgroundTintList(colorStateList);
    }

    private final void n() {
        try {
            Drawable progressDrawable = getProgressDrawable();
            if (progressDrawable != null) {
                LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
                if (findDrawableByLayerId != null) {
                    ((ScaleDrawable) findDrawableByLayerId).setColorFilter(this.f1899e, PorterDuff.Mode.SRC_IN);
                    Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                    if (findDrawableByLayerId2 != null) {
                        ((NinePatchDrawable) findDrawableByLayerId2).setColorFilter(0, PorterDuff.Mode.SRC_IN);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.NinePatchDrawable");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ScaleDrawable");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        } catch (NullPointerException unused) {
        }
    }

    @TargetApi(21)
    private final void o() {
        int[] iArr = this.f1904j;
        int i2 = this.f1899e;
        iArr[0] = i2;
        iArr[1] = i2;
        ColorStateList colorStateList = new ColorStateList(this.f1902h, this.f1904j);
        this.m = colorStateList;
        setProgressTintList(colorStateList);
    }

    @TargetApi(21)
    private final void p() {
        if (k()) {
            int[] iArr = this.f1903i;
            int i2 = this.f1898d;
            iArr[0] = i2;
            iArr[1] = i2;
            iArr[2] = -3355444;
            ColorStateList colorStateList = new ColorStateList(this.f1902h, this.f1903i);
            this.l = colorStateList;
            setThumbTintList(colorStateList);
        }
    }

    public final int[] getColorsProgress$seekbar_compat_release() {
        return this.f1904j;
    }

    public final int[] getColorsProgressBackground$seekbar_compat_release() {
        return this.f1905k;
    }

    public final int[] getColorsThumb$seekbar_compat_release() {
        return this.f1903i;
    }

    public final GradientDrawable getGradientDrawable$seekbar_compat_release() {
        return this.q;
    }

    public final ColorStateList getMColorStateListProgress$seekbar_compat_release() {
        return this.m;
    }

    public final ColorStateList getMColorStateListProgressBackground$seekbar_compat_release() {
        return this.n;
    }

    public final ColorStateList getMColorStateListThumb$seekbar_compat_release() {
        return this.l;
    }

    public final int getMProgressBackgroundColor$seekbar_compat_release() {
        return this.f1900f;
    }

    public final int getMProgressColor$seekbar_compat_release() {
        return this.f1899e;
    }

    public final Drawable getMThumb$seekbar_compat_release() {
        return this.f1901g;
    }

    public final int getMThumbColor$seekbar_compat_release() {
        return this.f1898d;
    }

    public final int[][] getStates$seekbar_compat_release() {
        return this.f1902h;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        f.f(view, "v");
        f.f(motionEvent, "event");
        if (k()) {
            return false;
        }
        int action = motionEvent.getAction();
        int i2 = -3355444;
        if (action == 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.q = gradientDrawable;
            gradientDrawable.setShape(1);
            GradientDrawable gradientDrawable2 = this.q;
            int i3 = this.o;
            gradientDrawable2.setSize(i3 / 2, i3 / 2);
            GradientDrawable gradientDrawable3 = this.q;
            if (isEnabled()) {
                i2 = this.f1898d;
            }
            gradientDrawable3.setColor(i2);
            this.q.setDither(true);
            this.q.setAlpha(this.p);
            setThumb(this.q);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            this.q = gradientDrawable4;
            gradientDrawable4.setShape(1);
            GradientDrawable gradientDrawable5 = this.q;
            int i4 = this.o;
            gradientDrawable5.setSize(i4 / 3, i4 / 3);
            GradientDrawable gradientDrawable6 = this.q;
            if (isEnabled()) {
                i2 = this.f1898d;
            }
            gradientDrawable6.setColor(i2);
            this.q.setDither(true);
            this.q.setAlpha(this.p);
            setThumb(this.q);
            return false;
        }
    }

    public final void setColorsProgress$seekbar_compat_release(int[] iArr) {
        f.f(iArr, "<set-?>");
        this.f1904j = iArr;
    }

    public final void setColorsProgressBackground$seekbar_compat_release(int[] iArr) {
        f.f(iArr, "<set-?>");
        this.f1905k = iArr;
    }

    public final void setColorsThumb$seekbar_compat_release(int[] iArr) {
        f.f(iArr, "<set-?>");
        this.f1903i = iArr;
    }

    public void setEnabled(boolean z) {
        s.d(this, new c(this, z));
    }

    public final void setGradientDrawable$seekbar_compat_release(GradientDrawable gradientDrawable) {
        f.f(gradientDrawable, "<set-?>");
        this.q = gradientDrawable;
    }

    public final void setMColorStateListProgress$seekbar_compat_release(ColorStateList colorStateList) {
        this.m = colorStateList;
    }

    public final void setMColorStateListProgressBackground$seekbar_compat_release(ColorStateList colorStateList) {
        this.n = colorStateList;
    }

    public final void setMColorStateListThumb$seekbar_compat_release(ColorStateList colorStateList) {
        this.l = colorStateList;
    }

    public final void setMProgressBackgroundColor$seekbar_compat_release(int i2) {
        this.f1900f = i2;
    }

    public final void setMProgressColor$seekbar_compat_release(int i2) {
        this.f1899e = i2;
    }

    public final void setMThumb$seekbar_compat_release(Drawable drawable) {
        this.f1901g = drawable;
    }

    public final void setMThumbColor$seekbar_compat_release(int i2) {
        this.f1898d = i2;
    }

    @TargetApi(16)
    public final void setProgressBackgroundColor(int i2) {
        this.f1900f = i2;
        if (k()) {
            m();
        } else {
            l();
        }
        invalidate();
        requestLayout();
    }

    public final void setProgressColor(int i2) {
        this.f1899e = i2;
        if (k()) {
            o();
        } else {
            n();
        }
        invalidate();
        requestLayout();
    }

    public final void setStates$seekbar_compat_release(int[][] iArr) {
        f.f(iArr, "<set-?>");
        this.f1902h = iArr;
    }

    public void setThumb(Drawable drawable) {
        f.f(drawable, "thumb");
        super.setThumb(drawable);
        this.f1901g = drawable;
    }

    @TargetApi(16)
    public final void setThumbAlpha(int i2) {
        this.p = i2;
        if (!j()) {
            Drawable thumb = getThumb();
            f.b(thumb, "thumb");
            thumb.setAlpha(this.p);
        }
        setLayoutParams(getLayoutParams());
    }

    public final void setThumbColor(int i2) {
        this.f1898d = i2;
        if (k()) {
            p();
        } else {
            GradientDrawable gradientDrawable = this.q;
            if (!isEnabled()) {
                i2 = -3355444;
            }
            gradientDrawable.setColor(i2);
        }
        invalidate();
        requestLayout();
    }
}
