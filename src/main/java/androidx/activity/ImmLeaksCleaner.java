package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements g {

    /* renamed from: b  reason: collision with root package name */
    private static int f96b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f97c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f98d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f99e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f100a;

    ImmLeaksCleaner(Activity activity) {
        this.f100a = activity;
    }

    private static void h() {
        try {
            f96b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f98d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f99e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f97c = declaredField3;
            declaredField3.setAccessible(true);
            f96b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            if (f96b == 0) {
                h();
            }
            if (f96b == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f100a.getSystemService("input_method");
                try {
                    Object obj = f97c.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                View view = (View) f98d.get(inputMethodManager);
                                if (view != null) {
                                    if (!view.isAttachedToWindow()) {
                                        try {
                                            f99e.set(inputMethodManager, null);
                                            inputMethodManager.isActive();
                                        } catch (IllegalAccessException unused) {
                                        }
                                    }
                                }
                            } catch (IllegalAccessException unused2) {
                            } catch (ClassCastException unused3) {
                            }
                        }
                    }
                } catch (IllegalAccessException unused4) {
                }
            }
        }
    }
}
