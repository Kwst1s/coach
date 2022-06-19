package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;

/* compiled from: BitmapEncoder */
public class c implements k<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public static final g<Integer> f4177b = g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c  reason: collision with root package name */
    public static final g<Bitmap.CompressFormat> f4178c = g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a  reason: collision with root package name */
    private final b f4179a;

    public c(b bVar) {
        this.f4179a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, h hVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) hVar.c(f4178c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.k
    public com.bumptech.glide.load.c b(h hVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r6 == null) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[Catch:{ all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc A[SYNTHETIC, Splitter:B:34:0x00bc] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.bumptech.glide.load.engine.u<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.h r11) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.c.a(com.bumptech.glide.load.engine.u, java.io.File, com.bumptech.glide.load.h):boolean");
    }
}
