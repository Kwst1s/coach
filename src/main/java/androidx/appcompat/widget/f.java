package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.i;
import b.a.k.a.a;

/* compiled from: AppCompatCheckedTextView */
public class f extends CheckedTextView {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f606c = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final s f607b;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f607b;
        if (sVar != null) {
            sVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.d(getContext(), i2));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.s(this, callback));
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f607b;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    public f(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        s sVar = new s(this);
        this.f607b = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
        q0 v = q0.v(getContext(), attributeSet, f606c, i2, 0);
        setCheckMarkDrawable(v.g(0));
        v.w();
    }
}
