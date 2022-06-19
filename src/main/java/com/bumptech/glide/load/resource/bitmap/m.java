package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.f;
import java.util.concurrent.locks.Lock;

/* access modifiers changed from: package-private */
/* compiled from: DrawableToBitmapConverter */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final e f4208a = new a();

    /* compiled from: DrawableToBitmapConverter */
    class a extends f {
        a() {
        }

        @Override // com.bumptech.glide.load.engine.z.f, com.bumptech.glide.load.engine.z.e
        public void d(Bitmap bitmap) {
        }
    }

    static u<Bitmap> a(e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i2, i3);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            eVar = f4208a;
        }
        return e.f(bitmap, eVar);
    }

    private static Bitmap b(e eVar, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i3 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock f2 = y.f();
            f2.lock();
            Bitmap c2 = eVar.c(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(c2);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return c2;
            } finally {
                f2.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}
