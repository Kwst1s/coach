package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import b.h.j.h;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.lang.reflect.Constructor;

/* compiled from: StaticLayoutBuilderCompat */
final class g {

    /* renamed from: k  reason: collision with root package name */
    private static boolean f7841k;
    private static Constructor<StaticLayout> l;
    private static Object m;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f7842a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f7843b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7844c;

    /* renamed from: d  reason: collision with root package name */
    private int f7845d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f7846e;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f7847f;

    /* renamed from: g  reason: collision with root package name */
    private int f7848g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7849h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7850i;

    /* renamed from: j  reason: collision with root package name */
    private TextUtils.TruncateAt f7851j;

    /* access modifiers changed from: package-private */
    /* compiled from: StaticLayoutBuilderCompat */
    public static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f7842a = charSequence;
        this.f7843b = textPaint;
        this.f7844c = i2;
        this.f7846e = charSequence.length();
        this.f7847f = Layout.Alignment.ALIGN_NORMAL;
        this.f7848g = Integer.MAX_VALUE;
        this.f7849h = true;
        this.f7851j = null;
    }

    private void b() {
        Class<?> cls;
        if (!f7841k) {
            try {
                boolean z = this.f7850i && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    m = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = g.class.getClassLoader();
                    String str = this.f7850i ? "RTL" : "LTR";
                    Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                    Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                    m = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
                l = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f7841k = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
    }

    public static g c(CharSequence charSequence, TextPaint textPaint, int i2) {
        return new g(charSequence, textPaint, i2);
    }

    public StaticLayout a() {
        if (this.f7842a == null) {
            this.f7842a = BuildConfig.FLAVOR;
        }
        int max = Math.max(0, this.f7844c);
        CharSequence charSequence = this.f7842a;
        if (this.f7848g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f7843b, (float) max, this.f7851j);
        }
        int min = Math.min(charSequence.length(), this.f7846e);
        this.f7846e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f7850i) {
                this.f7847f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f7845d, min, this.f7843b, max);
            obtain.setAlignment(this.f7847f);
            obtain.setIncludePad(this.f7849h);
            obtain.setTextDirection(this.f7850i ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f7851j;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f7848g);
            return obtain.build();
        }
        b();
        try {
            Constructor<StaticLayout> constructor = l;
            h.c(constructor);
            Object obj = m;
            h.c(obj);
            return constructor.newInstance(charSequence, Integer.valueOf(this.f7845d), Integer.valueOf(this.f7846e), this.f7843b, Integer.valueOf(max), this.f7847f, obj, Float.valueOf(1.0f), Float.valueOf((float) Utils.FLOAT_EPSILON), Boolean.valueOf(this.f7849h), null, Integer.valueOf(max), Integer.valueOf(this.f7848g));
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public g d(Layout.Alignment alignment) {
        this.f7847f = alignment;
        return this;
    }

    public g e(TextUtils.TruncateAt truncateAt) {
        this.f7851j = truncateAt;
        return this;
    }

    public g f(boolean z) {
        this.f7849h = z;
        return this;
    }

    public g g(boolean z) {
        this.f7850i = z;
        return this;
    }

    public g h(int i2) {
        this.f7848g = i2;
        return this;
    }
}
