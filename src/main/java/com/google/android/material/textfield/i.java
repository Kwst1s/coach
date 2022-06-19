package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import c.e.a.b.e;
import c.e.a.b.j;
import com.google.android.material.textfield.TextInputLayout;

/* access modifiers changed from: package-private */
/* compiled from: PasswordToggleEndIconDelegate */
public class i extends e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f8064d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final TextInputLayout.f f8065e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.g f8066f = new c();

    /* compiled from: PasswordToggleEndIconDelegate */
    class a extends com.google.android.material.internal.i {
        a() {
        }

        @Override // com.google.android.material.internal.i
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            i iVar = i.this;
            iVar.f8043c.setChecked(!iVar.g());
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            i iVar = i.this;
            iVar.f8043c.setChecked(!iVar.g());
            editText.removeTextChangedListener(i.this.f8064d);
            editText.addTextChangedListener(i.this.f8064d);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate */
    class c implements TextInputLayout.g {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.removeTextChangedListener(i.this.f8064d);
            }
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate */
    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            EditText editText = i.this.f8041a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                if (i.this.g()) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                i.this.f8041a.V();
            }
        }
    }

    i(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean g() {
        EditText editText = this.f8041a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.f8041a.setEndIconDrawable(b.a.k.a.a.d(this.f8042b, e.design_password_eye));
        TextInputLayout textInputLayout = this.f8041a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.password_toggle_content_description));
        this.f8041a.setEndIconOnClickListener(new d());
        this.f8041a.e(this.f8065e);
        this.f8041a.f(this.f8066f);
        EditText editText = this.f8041a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
