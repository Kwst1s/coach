package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.core.widget.i;
import b.a.a;
import b.h.k.t;

/* compiled from: AppCompatAutoCompleteTextView */
public class d extends AutoCompleteTextView implements t {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f597d = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final e f598b;

    /* renamed from: c  reason: collision with root package name */
    private final s f599c;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.p);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f598b;
        if (eVar != null) {
            eVar.b();
        }
        s sVar = this.f599c;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f598b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f598b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f598b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f598b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.s(this, callback));
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(b.a.k.a.a.d(getContext(), i2));
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f598b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f598b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f599c;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        q0 v = q0.v(getContext(), attributeSet, f597d, i2, 0);
        if (v.s(0)) {
            setDropDownBackgroundDrawable(v.g(0));
        }
        v.w();
        e eVar = new e(this);
        this.f598b = eVar;
        eVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f599c = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
    }
}
