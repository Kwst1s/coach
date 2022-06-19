package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.widget.i;
import b.a.a;
import b.h.k.t;

public class AppCompatEditText extends EditText implements t {

    /* renamed from: b  reason: collision with root package name */
    private final e f453b;

    /* renamed from: c  reason: collision with root package name */
    private final s f454c;

    /* renamed from: d  reason: collision with root package name */
    private final r f455d;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.A);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f453b;
        if (eVar != null) {
            eVar.b();
        }
        s sVar = this.f454c;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f453b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f453b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public TextClassifier getTextClassifier() {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f455d) == null) {
            return super.getTextClassifier();
        }
        return rVar.a();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f453b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f453b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.s(this, callback));
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f453b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f453b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f454c;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f455d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            rVar.b(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        e eVar = new e(this);
        this.f453b = eVar;
        eVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f454c = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
        this.f455d = new r(this);
    }

    @Override // android.widget.EditText, android.widget.EditText
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}
