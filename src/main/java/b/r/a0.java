package b.r;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18 */
class a0 implements b0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f2833a;

    a0(View view) {
        this.f2833a = view.getOverlay();
    }

    @Override // b.r.b0
    public void b(Drawable drawable) {
        this.f2833a.add(drawable);
    }

    @Override // b.r.b0
    public void d(Drawable drawable) {
        this.f2833a.remove(drawable);
    }
}
