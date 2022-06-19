package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class v0 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f799b = false;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f800a;

    public v0(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f800a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f799b;
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    public final Drawable c(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        Context context = this.f800a.get();
        if (context != null) {
            return g0.h().t(context, this, i2);
        }
        return super.getDrawable(i2);
    }
}
