package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.m.m;
import com.bumptech.glide.load.resource.bitmap.v;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils */
public final class e {

    /* access modifiers changed from: package-private */
    /* compiled from: ImageHeaderParserUtils */
    public class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f3639a;

        a(InputStream inputStream) {
            this.f3639a = inputStream;
        }

        @Override // com.bumptech.glide.load.e.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.c(this.f3639a);
            } finally {
                this.f3639a.reset();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ImageHeaderParserUtils */
    public class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBuffer f3640a;

        b(ByteBuffer byteBuffer) {
            this.f3640a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.e.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.a(this.f3640a);
        }
    }

    /* compiled from: ImageHeaderParserUtils */
    class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f3641a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.z.b f3642b;

        c(m mVar, com.bumptech.glide.load.engine.z.b bVar) {
            this.f3641a = mVar;
            this.f3642b = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
        @Override // com.bumptech.glide.load.e.g
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser r5) {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.v r1 = new com.bumptech.glide.load.resource.bitmap.v     // Catch:{ all -> 0x0027 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.load.m.m r3 = r4.f3641a     // Catch:{ all -> 0x0027 }
                android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0027 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0027 }
                r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.load.engine.z.b r3 = r4.f3642b     // Catch:{ all -> 0x0027 }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.c(r1)     // Catch:{ all -> 0x0024 }
                r1.close()     // Catch:{ IOException -> 0x001e }
            L_0x001e:
                com.bumptech.glide.load.m.m r0 = r4.f3641a
                r0.a()
                return r5
            L_0x0024:
                r5 = move-exception
                r0 = r1
                goto L_0x0028
            L_0x0027:
                r5 = move-exception
            L_0x0028:
                if (r0 == 0) goto L_0x002d
                r0.close()     // Catch:{ IOException -> 0x002d }
            L_0x002d:
                com.bumptech.glide.load.m.m r0 = r4.f3641a
                r0.a()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.e.c.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType");
        }
    }

    /* compiled from: ImageHeaderParserUtils */
    class d implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f3643a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.z.b f3644b;

        d(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
            this.f3643a = inputStream;
            this.f3644b = bVar;
        }

        @Override // com.bumptech.glide.load.e.f
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.b(this.f3643a, this.f3644b);
            } finally {
                this.f3643a.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.e$e  reason: collision with other inner class name */
    /* compiled from: ImageHeaderParserUtils */
    class C0087e implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f3645a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.z.b f3646b;

        C0087e(m mVar, com.bumptech.glide.load.engine.z.b bVar) {
            this.f3645a = mVar;
            this.f3646b = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
        @Override // com.bumptech.glide.load.e.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(com.bumptech.glide.load.ImageHeaderParser r5) {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.v r1 = new com.bumptech.glide.load.resource.bitmap.v     // Catch:{ all -> 0x0029 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
                com.bumptech.glide.load.m.m r3 = r4.f3645a     // Catch:{ all -> 0x0029 }
                android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0029 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
                r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                com.bumptech.glide.load.engine.z.b r3 = r4.f3646b     // Catch:{ all -> 0x0029 }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
                com.bumptech.glide.load.engine.z.b r0 = r4.f3646b     // Catch:{ all -> 0x0026 }
                int r5 = r5.b(r1, r0)     // Catch:{ all -> 0x0026 }
                r1.close()     // Catch:{ IOException -> 0x0020 }
            L_0x0020:
                com.bumptech.glide.load.m.m r0 = r4.f3645a
                r0.a()
                return r5
            L_0x0026:
                r5 = move-exception
                r0 = r1
                goto L_0x002a
            L_0x0029:
                r5 = move-exception
            L_0x002a:
                if (r0 == 0) goto L_0x002f
                r0.close()     // Catch:{ IOException -> 0x002f }
            L_0x002f:
                com.bumptech.glide.load.m.m r0 = r4.f3645a
                r0.a()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.e.C0087e.a(com.bumptech.glide.load.ImageHeaderParser):int");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ImageHeaderParserUtils */
    public interface f {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* access modifiers changed from: private */
    /* compiled from: ImageHeaderParserUtils */
    public interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List<ImageHeaderParser> list, m mVar, com.bumptech.glide.load.engine.z.b bVar) {
        return c(list, new C0087e(mVar, bVar));
    }

    public static int b(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new v(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, bVar));
    }

    private static int c(List<ImageHeaderParser> list, f fVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int a2 = fVar.a(list.get(i2));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType d(List<ImageHeaderParser> list, m mVar, com.bumptech.glide.load.engine.z.b bVar) {
        return g(list, new c(mVar, bVar));
    }

    public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new v(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return g(list, new a(inputStream));
    }

    public static ImageHeaderParser.ImageType f(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return g(list, new b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType g(List<ImageHeaderParser> list, g gVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType a2 = gVar.a(list.get(i2));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
