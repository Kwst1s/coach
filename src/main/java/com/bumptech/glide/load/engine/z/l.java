package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;

/* access modifiers changed from: package-private */
/* compiled from: LruPoolStrategy */
public interface l {
    String a(int i2, int i3, Bitmap.Config config);

    int b(Bitmap bitmap);

    Bitmap c(int i2, int i3, Bitmap.Config config);

    void d(Bitmap bitmap);

    String e(Bitmap bitmap);

    Bitmap removeLast();
}
