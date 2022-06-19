package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* access modifiers changed from: package-private */
/* compiled from: EndIconDelegate */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f8041a;

    /* renamed from: b  reason: collision with root package name */
    Context f8042b;

    /* renamed from: c  reason: collision with root package name */
    CheckableImageButton f8043c;

    e(TextInputLayout textInputLayout) {
        this.f8041a = textInputLayout;
        this.f8042b = textInputLayout.getContext();
        this.f8043c = textInputLayout.getEndIconView();
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return false;
    }
}
