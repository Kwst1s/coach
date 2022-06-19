package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class n0 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f694c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<n0>> f695d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f696a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f697b;

    private n0(Context context) {
        super(context);
        if (v0.b()) {
            v0 v0Var = new v0(this, context.getResources());
            this.f696a = v0Var;
            Resources.Theme newTheme = v0Var.newTheme();
            this.f697b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f696a = new p0(this, context.getResources());
        this.f697b = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof n0) || (context.getResources() instanceof p0) || (context.getResources() instanceof v0)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || v0.b()) {
            return true;
        }
        return false;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f694c) {
            ArrayList<WeakReference<n0>> arrayList = f695d;
            if (arrayList == null) {
                f695d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<n0> weakReference = f695d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f695d.remove(size);
                    }
                }
                for (int size2 = f695d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<n0> weakReference2 = f695d.get(size2);
                    n0 n0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (n0Var != null && n0Var.getBaseContext() == context) {
                        return n0Var;
                    }
                }
            }
            n0 n0Var2 = new n0(context);
            f695d.add(new WeakReference<>(n0Var2));
            return n0Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f696a.getAssets();
    }

    public Resources getResources() {
        return this.f696a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f697b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i2) {
        Resources.Theme theme = this.f697b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
