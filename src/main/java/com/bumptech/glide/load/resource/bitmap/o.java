package com.bumptech.glide.load.resource.bitmap;

import b.k.a.a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.z.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ExifInterfaceImageHeaderParser */
public final class o implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(InputStream inputStream, b bVar) {
        int e2 = new a(inputStream).e("Orientation", 1);
        if (e2 == 0) {
            return -1;
        }
        return e2;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
