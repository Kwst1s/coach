package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.k;

/* compiled from: BitmapTransformation */
public abstract class f implements l<Bitmap> {
    @Override // com.bumptech.glide.load.l
    public final u<Bitmap> a(Context context, u<Bitmap> uVar, int i2, int i3) {
        if (k.r(i2, i3)) {
            e f2 = b.c(context).f();
            Bitmap bitmap = uVar.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap c2 = c(f2, bitmap, i2, i3);
            return bitmap.equals(c2) ? uVar : e.f(c2, f2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap c(e eVar, Bitmap bitmap, int i2, int i3);
}
