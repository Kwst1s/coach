package b.h.k.d0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat */
public final class a extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    private final int f2633b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2634c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2635d;

    public a(int i2, c cVar, int i3) {
        this.f2633b = i2;
        this.f2634c = cVar;
        this.f2635d = i3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2633b);
        this.f2634c.Q(this.f2635d, bundle);
    }
}
