package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: AppCompatToggleButton */
public class u extends ToggleButton {

    /* renamed from: b  reason: collision with root package name */
    private final s f791b;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public u(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l0.a(this, getContext());
        s sVar = new s(this);
        this.f791b = sVar;
        sVar.m(attributeSet, i2);
    }
}
