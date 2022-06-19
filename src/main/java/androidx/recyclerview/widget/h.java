package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import b.h.k.u;
import b.q.c;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: ItemTouchUIUtilImpl */
public class h implements g {

    /* renamed from: a  reason: collision with root package name */
    static final g f1798a = new h();

    h() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f2 = Utils.FLOAT_EPSILON;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != view) {
                float w = u.w(childAt);
                if (w > f2) {
                    f2 = w;
                }
            }
        }
        return f2;
    }

    @Override // androidx.recyclerview.widget.g
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i2 = c.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i2);
            if (tag instanceof Float) {
                u.u0(view, ((Float) tag).floatValue());
            }
            view.setTag(i2, null);
        }
        view.setTranslationX(Utils.FLOAT_EPSILON);
        view.setTranslationY(Utils.FLOAT_EPSILON);
    }

    @Override // androidx.recyclerview.widget.g
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.g
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z) {
    }

    @Override // androidx.recyclerview.widget.g
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z) {
            int i3 = c.item_touch_helper_previous_elevation;
            if (view.getTag(i3) == null) {
                Float valueOf = Float.valueOf(u.w(view));
                u.u0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i3, valueOf);
            }
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }
}
