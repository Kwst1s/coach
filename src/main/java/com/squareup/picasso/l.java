package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.t;

/* access modifiers changed from: package-private */
/* compiled from: ImageViewAction */
public class l extends a<ImageView> {
    e m;

    l(t tVar, ImageView imageView, w wVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(tVar, imageView, wVar, i2, i3, i4, drawable, str, obj, z);
        this.m = eVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.a
    public void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }

    @Override // com.squareup.picasso.a
    public void b(Bitmap bitmap, t.e eVar) {
        if (bitmap != null) {
            T t = this.f8635c.get();
            if (t != null) {
                t tVar = this.f8633a;
                u.c(t, tVar.f8747e, bitmap, eVar, this.f8636d, tVar.m);
                e eVar2 = this.m;
                if (eVar2 != null) {
                    eVar2.b();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
    }

    @Override // com.squareup.picasso.a
    public void c(Exception exc) {
        T t = this.f8635c.get();
        if (t != null) {
            Drawable drawable = t.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i2 = this.f8639g;
            if (i2 != 0) {
                t.setImageResource(i2);
            } else {
                Drawable drawable2 = this.f8640h;
                if (drawable2 != null) {
                    t.setImageDrawable(drawable2);
                }
            }
            e eVar = this.m;
            if (eVar != null) {
                eVar.a(exc);
            }
        }
    }
}
