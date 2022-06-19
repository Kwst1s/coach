package com.rd.e;

import android.os.Build;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IdUtils */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f8631a = new AtomicInteger(1);

    private static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = f8631a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static int b() {
        if (Build.VERSION.SDK_INT < 17) {
            return a();
        }
        return View.generateViewId();
    }
}
