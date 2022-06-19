package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: TintResources */
public class p0 extends h0 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f709b;

    public p0(Context context, Resources resources) {
        super(resources);
        this.f709b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.h0, android.content.res.Resources
    public Drawable getDrawable(int i2) {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.f709b.get();
        if (!(drawable == null || context == null)) {
            g0.h().x(context, i2, drawable);
        }
        return drawable;
    }
}
