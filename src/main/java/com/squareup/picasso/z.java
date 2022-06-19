package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* access modifiers changed from: package-private */
/* compiled from: ResourceRequestHandler */
public class z extends y {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8823a;

    z(Context context) {
        this.f8823a = context;
    }

    private static Bitmap j(Resources resources, int i2, w wVar) {
        BitmapFactory.Options d2 = y.d(wVar);
        if (y.g(d2)) {
            BitmapFactory.decodeResource(resources, i2, d2);
            y.b(wVar.f8793h, wVar.f8794i, d2, wVar);
        }
        return BitmapFactory.decodeResource(resources, i2, d2);
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        if (wVar.f8790e != 0) {
            return true;
        }
        return "android.resource".equals(wVar.f8789d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        Resources m = d0.m(this.f8823a, wVar);
        return new y.a(j(m, d0.l(m, wVar), wVar), t.e.DISK);
    }
}
