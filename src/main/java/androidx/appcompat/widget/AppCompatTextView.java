package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.b;
import androidx.core.widget.i;
import androidx.core.widget.k;
import b.a.k.a.a;
import b.h.e.d;
import b.h.i.c;
import b.h.k.t;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements t, k, b {

    /* renamed from: b  reason: collision with root package name */
    private final e f462b;

    /* renamed from: c  reason: collision with root package name */
    private final s f463c;

    /* renamed from: d  reason: collision with root package name */
    private final r f464d;

    /* renamed from: e  reason: collision with root package name */
    private Future<c> f465e;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void c() {
        Future<c> future = this.f465e;
        if (future != null) {
            try {
                this.f465e = null;
                i.p(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f462b;
        if (eVar != null) {
            eVar.b();
        }
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f1167a) {
            return super.getAutoSizeMaxTextSize();
        }
        s sVar = this.f463c;
        if (sVar != null) {
            return sVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f1167a) {
            return super.getAutoSizeMinTextSize();
        }
        s sVar = this.f463c;
        if (sVar != null) {
            return sVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f1167a) {
            return super.getAutoSizeStepGranularity();
        }
        s sVar = this.f463c;
        if (sVar != null) {
            return sVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1167a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        s sVar = this.f463c;
        return sVar != null ? sVar.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!b.f1167a) {
            s sVar = this.f463c;
            if (sVar != null) {
                return sVar.i();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getFirstBaselineToTopHeight() {
        return i.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return i.c(this);
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f462b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f462b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f463c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f463c.k();
    }

    public CharSequence getText() {
        c();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f464d) == null) {
            return super.getTextClassifier();
        }
        return rVar.a();
    }

    public c.a getTextMetricsParamsCompat() {
        return i.g(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.o(z, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        c();
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        s sVar = this.f463c;
        if (sVar != null && !b.f1167a && sVar.l()) {
            this.f463c.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (b.f1167a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.s(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (b.f1167a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.t(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.f1167a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.u(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f462b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f462b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.s(this, callback));
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            i.m(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            i.n(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        i.o(this, i2);
    }

    public void setPrecomputedText(c cVar) {
        i.p(this, cVar);
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f462b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f462b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f463c.v(colorStateList);
        this.f463c.b();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f463c.w(mode);
        this.f463c.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f464d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            rVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<c> future) {
        this.f465e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        i.r(this, aVar);
    }

    public void setTextSize(int i2, float f2) {
        if (b.f1167a) {
            super.setTextSize(i2, f2);
            return;
        }
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.z(i2, f2);
        }
    }

    public void setTypeface(Typeface typeface, int i2) {
        Typeface a2 = (typeface == null || i2 <= 0) ? null : d.a(getContext(), typeface, i2);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i2);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        e eVar = new e(this);
        this.f462b = eVar;
        eVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f463c = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
        this.f464d = new r(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable d2 = i2 != 0 ? a.d(context, i2) : null;
        Drawable d3 = i3 != 0 ? a.d(context, i3) : null;
        Drawable d4 = i4 != 0 ? a.d(context, i4) : null;
        if (i5 != 0) {
            drawable = a.d(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(d2, d3, d4, drawable);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable d2 = i2 != 0 ? a.d(context, i2) : null;
        Drawable d3 = i3 != 0 ? a.d(context, i3) : null;
        Drawable d4 = i4 != 0 ? a.d(context, i4) : null;
        if (i5 != 0) {
            drawable = a.d(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(d2, d3, d4, drawable);
        s sVar = this.f463c;
        if (sVar != null) {
            sVar.p();
        }
    }
}
