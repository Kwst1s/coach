package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.e.a.b.f;
import c.e.a.b.h;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.i;
import com.google.android.material.textfield.TextInputLayout;

class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: b  reason: collision with root package name */
    private final Chip f8073b;

    /* renamed from: c  reason: collision with root package name */
    private final TextInputLayout f8074c;

    /* renamed from: d  reason: collision with root package name */
    private final EditText f8075d;

    /* renamed from: e  reason: collision with root package name */
    private TextWatcher f8076e;

    private class b extends i {
        private b() {
        }

        @Override // com.google.android.material.internal.i
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.e(chipTextInputComboView.d("00"));
                return;
            }
            ChipTextInputComboView.this.f8074c.getEditText().setHint((CharSequence) null);
            ChipTextInputComboView.this.f8073b.setText(ChipTextInputComboView.this.d(editable));
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String d(CharSequence charSequence) {
        return b.g(getResources(), charSequence);
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f8075d.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void e(CharSequence charSequence) {
        this.f8073b.setText(d(charSequence));
        EditText editText = this.f8074c.getEditText();
        if (!TextUtils.isEmpty(editText.getText())) {
            editText.removeTextChangedListener(this.f8076e);
            editText.setText((CharSequence) null);
            editText.setHint(d("00"));
            editText.addTextChangedListener(this.f8076e);
        }
        editText.setHint(d(charSequence));
    }

    public boolean isChecked() {
        return this.f8073b.isChecked();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f();
    }

    public void setChecked(boolean z) {
        this.f8073b.setChecked(z);
        int i2 = 0;
        this.f8075d.setVisibility(z ? 0 : 4);
        Chip chip = this.f8073b;
        if (z) {
            i2 = 8;
        }
        chip.setVisibility(i2);
        if (isChecked()) {
            this.f8075d.requestFocus();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8073b.setOnClickListener(onClickListener);
    }

    public void setTag(int i2, Object obj) {
        this.f8073b.setTag(i2, obj);
    }

    public void toggle() {
        this.f8073b.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(h.material_time_chip, (ViewGroup) this, false);
        this.f8073b = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(h.material_time_input, (ViewGroup) this, false);
        this.f8074c = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f8075d = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f8076e = bVar;
        editText.addTextChangedListener(bVar);
        f();
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(f.material_label);
    }
}
