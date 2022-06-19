package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import b.a.j;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatTextViewAutoSizeHelper */
public class t {
    private static final RectF l = new RectF();
    private static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private int f768a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f769b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f770c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f771d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f772e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f773f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f774g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f775h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f776i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f777j;

    /* renamed from: k  reason: collision with root package name */
    private final c f778k;

    /* compiled from: AppCompatTextViewAutoSizeHelper */
    private static class a extends c {
        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.appcompat.widget.t.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) t.r(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper */
    private static class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.appcompat.widget.t.c, androidx.appcompat.widget.t.a
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.appcompat.widget.t.c
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    public static class c {
        c() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) t.r(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    t(TextView textView) {
        this.f776i = textView;
        this.f777j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.f778k = new b();
        } else if (i2 >= 23) {
            this.f778k = new a();
        } else {
            this.f778k = new c();
        }
    }

    private void A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f773f = c(iArr);
            B();
        }
    }

    private boolean B() {
        int[] iArr = this.f773f;
        int length = iArr.length;
        boolean z = length > 0;
        this.f774g = z;
        if (z) {
            this.f768a = 1;
            this.f771d = (float) iArr[0];
            this.f772e = (float) iArr[length - 1];
            this.f770c = -1.0f;
        }
        return z;
    }

    private boolean C(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f776i.getText();
        TransformationMethod transformationMethod = this.f776i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f776i)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f776i.getMaxLines() : -1;
        q(i2);
        StaticLayout e2 = e(text, (Layout.Alignment) r(this.f776i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (e2.getLineCount() <= maxLines && e2.getLineEnd(e2.getLineCount() - 1) == text.length())) && ((float) e2.getHeight()) <= rectF.bottom;
    }

    private boolean D() {
        return !(this.f776i instanceof AppCompatEditText);
    }

    private void E(float f2, float f3, float f4) {
        if (f2 <= Utils.FLOAT_EPSILON) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > Utils.FLOAT_EPSILON) {
            this.f768a = 1;
            this.f771d = f2;
            this.f772e = f3;
            this.f770c = f4;
            this.f774g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    private static <T> T a(Object obj, String str, T t) {
        try {
            Field o = o(str);
            return o == null ? t : (T) o.get(obj);
        } catch (IllegalAccessException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return t;
        }
    }

    private int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f768a = 0;
        this.f771d = -1.0f;
        this.f772e = -1.0f;
        this.f770c = -1.0f;
        this.f773f = new int[0];
        this.f769b = false;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f775h, i2);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f776i.getLineSpacingExtra(), this.f776i.getLineSpacingMultiplier()).setIncludePad(this.f776i.getIncludeFontPadding()).setBreakStrategy(this.f776i.getBreakStrategy()).setHyphenationFrequency(this.f776i.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            this.f778k.a(obtain, this.f776i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private StaticLayout g(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f775h, i2, alignment, ((Float) a(this.f776i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f776i, "mSpacingAdd", Float.valueOf((float) Utils.FLOAT_EPSILON))).floatValue(), ((Boolean) a(this.f776i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private StaticLayout h(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f775h, i2, alignment, this.f776i.getLineSpacingMultiplier(), this.f776i.getLineSpacingExtra(), this.f776i.getIncludeFontPadding());
    }

    private int i(RectF rectF) {
        int length = this.f773f.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                if (C(this.f773f[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i3;
                    i3 = i6;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f773f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Field o(String str) {
        try {
            Field field = n.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                n.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }

    private static Method p(String str) {
        try {
            Method method = m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                m.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    static <T> T r(Object obj, String str, T t) {
        try {
            return (T) p(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    private void x(float f2) {
        if (f2 != this.f776i.getPaint().getTextSize()) {
            this.f776i.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f776i.isInLayout() : false;
            if (this.f776i.getLayout() != null) {
                this.f769b = false;
                try {
                    Method p = p("nullLayouts");
                    if (p != null) {
                        p.invoke(this.f776i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f776i.requestLayout();
                } else {
                    this.f776i.forceLayout();
                }
                this.f776i.invalidate();
            }
        }
    }

    private boolean z() {
        if (!D() || this.f768a != 1) {
            this.f769b = false;
        } else {
            if (!this.f774g || this.f773f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f772e - this.f771d) / this.f770c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f771d + (((float) i2) * this.f770c));
                }
                this.f773f = c(iArr);
            }
            this.f769b = true;
        }
        return this.f769b;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2;
        if (s()) {
            if (this.f769b) {
                if (this.f776i.getMeasuredHeight() > 0 && this.f776i.getMeasuredWidth() > 0) {
                    if (this.f778k.b(this.f776i)) {
                        i2 = 1048576;
                    } else {
                        i2 = (this.f776i.getMeasuredWidth() - this.f776i.getTotalPaddingLeft()) - this.f776i.getTotalPaddingRight();
                    }
                    int height = (this.f776i.getHeight() - this.f776i.getCompoundPaddingBottom()) - this.f776i.getCompoundPaddingTop();
                    if (i2 > 0 && height > 0) {
                        RectF rectF = l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i2;
                            rectF.bottom = (float) height;
                            float i3 = (float) i(rectF);
                            if (i3 != this.f776i.getTextSize()) {
                                y(0, i3);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f769b = true;
        }
    }

    /* access modifiers changed from: package-private */
    public StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            return f(charSequence, alignment, i2, i3);
        }
        if (i4 >= 16) {
            return h(charSequence, alignment, i2);
        }
        return g(charSequence, alignment, i2);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return Math.round(this.f772e);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return Math.round(this.f771d);
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return Math.round(this.f770c);
    }

    /* access modifiers changed from: package-private */
    public int[] m() {
        return this.f773f;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f768a;
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        TextPaint textPaint = this.f775h;
        if (textPaint == null) {
            this.f775h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f775h.set(this.f776i.getPaint());
        this.f775h.setTextSize((float) i2);
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return D() && this.f768a != 0;
    }

    /* access modifiers changed from: package-private */
    public void t(AttributeSet attributeSet, int i2) {
        int resourceId;
        Context context = this.f777j;
        int[] iArr = j.d0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f776i;
        u.k0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i2, 0);
        int i3 = j.i0;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f768a = obtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = j.h0;
        float dimension = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = j.f0;
        float dimension2 = obtainStyledAttributes.hasValue(i5) ? obtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = j.e0;
        float dimension3 = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = j.g0;
        if (obtainStyledAttributes.hasValue(i7) && (resourceId = obtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            A(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!D()) {
            this.f768a = 0;
        } else if (this.f768a == 1) {
            if (!this.f774g) {
                DisplayMetrics displayMetrics = this.f777j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                E(dimension2, dimension3, dimension);
            }
            z();
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i2, int i3, int i4, int i5) {
        if (D()) {
            DisplayMetrics displayMetrics = this.f777j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(int[] iArr, int i2) {
        if (D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f777j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.f773f = c(iArr2);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f774g = false;
            }
            if (z()) {
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w(int i2) {
        if (!D()) {
            return;
        }
        if (i2 == 0) {
            d();
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = this.f777j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (z()) {
                b();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void y(int i2, float f2) {
        Resources resources;
        Context context = this.f777j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        x(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }
}
