package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.z.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3624b;

        private ImageType(boolean z) {
            this.f3624b = z;
        }

        public boolean hasAlpha() {
            return this.f3624b;
        }
    }

    ImageType a(ByteBuffer byteBuffer);

    int b(InputStream inputStream, b bVar);

    ImageType c(InputStream inputStream);
}
