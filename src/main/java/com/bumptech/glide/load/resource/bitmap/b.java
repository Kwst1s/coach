package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import java.io.File;

/* compiled from: BitmapDrawableEncoder */
public class b implements k<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f4175a;

    /* renamed from: b  reason: collision with root package name */
    private final k<Bitmap> f4176b;

    public b(e eVar, k<Bitmap> kVar) {
        this.f4175a = eVar;
        this.f4176b = kVar;
    }

    @Override // com.bumptech.glide.load.k
    public c b(h hVar) {
        return this.f4176b.b(hVar);
    }

    /* renamed from: c */
    public boolean a(u<BitmapDrawable> uVar, File file, h hVar) {
        return this.f4176b.a(new e(uVar.get().getBitmap(), this.f4175a), file, hVar);
    }
}
