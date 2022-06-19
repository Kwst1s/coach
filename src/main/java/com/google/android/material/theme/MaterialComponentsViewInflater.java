package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.h;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d;
import c.e.a.b.q.a;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.g;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater extends h {
    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h
    public d b(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h
    public AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h
    public AppCompatCheckBox d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h
    public AppCompatRadioButton j(Context context, AttributeSet attributeSet) {
        return new c.e.a.b.y.a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h
    public AppCompatTextView n(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
