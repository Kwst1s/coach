package b.h.k;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private Object f2671a;

    private s(Object obj) {
        this.f2671a = obj;
    }

    public static s b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new s(PointerIcon.getSystemIcon(context, i2));
        }
        return new s(null);
    }

    public Object a() {
        return this.f2671a;
    }
}
