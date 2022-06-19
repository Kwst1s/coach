package c.e.a.b.n;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: BadgeUtils */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3418a = (Build.VERSION.SDK_INT < 18);

    public static void a(a aVar, View view, FrameLayout frameLayout) {
        c(aVar, view, frameLayout);
        if (!f3418a) {
            view.getOverlay().add(aVar);
        } else if (frameLayout != null) {
            frameLayout.setForeground(aVar);
        } else {
            throw new IllegalArgumentException("Trying to reference null compatBadgeParent");
        }
    }

    public static void b(a aVar, View view, FrameLayout frameLayout) {
        if (aVar != null) {
            if (f3418a) {
                frameLayout.setForeground(null);
            } else {
                view.getOverlay().remove(aVar);
            }
        }
    }

    public static void c(a aVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        FrameLayout frameLayout2 = f3418a ? frameLayout : view;
        if (frameLayout2 != null) {
            frameLayout2.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.v(view, frameLayout);
            return;
        }
        throw new IllegalArgumentException("Trying to reference null badgeParent");
    }

    public static void d(Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }
}
