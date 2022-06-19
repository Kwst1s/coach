package b.r;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
/* compiled from: ViewGroupUtilsApi14 */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static LayoutTransition f2945a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f2946b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2947c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2948d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2949e;

    /* access modifiers changed from: package-private */
    /* compiled from: ViewGroupUtilsApi14 */
    public static class a extends LayoutTransition {
        a() {
        }

        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f2949e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f2948d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f2949e = true;
        }
        Method method = f2948d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void b(android.view.ViewGroup r5, boolean r6) {
        /*
        // Method dump skipped, instructions count: 149
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.y.b(android.view.ViewGroup, boolean):void");
    }
}
