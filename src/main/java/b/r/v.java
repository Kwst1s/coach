package b.r;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* access modifiers changed from: package-private */
/* compiled from: ViewGroupOverlayApi18 */
public class v implements w {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f2943a;

    v(ViewGroup viewGroup) {
        this.f2943a = viewGroup.getOverlay();
    }

    @Override // b.r.w
    public void a(View view) {
        this.f2943a.add(view);
    }

    @Override // b.r.b0
    public void b(Drawable drawable) {
        this.f2943a.add(drawable);
    }

    @Override // b.r.w
    public void c(View view) {
        this.f2943a.remove(view);
    }

    @Override // b.r.b0
    public void d(Drawable drawable) {
        this.f2943a.remove(drawable);
    }
}
