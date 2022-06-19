package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.m.k;
import com.bumptech.glide.load.m.m;
import com.bumptech.glide.r.j;
import java.io.InputStream;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: ImageReader */
public interface r {

    /* compiled from: ImageReader */
    public static final class a implements r {

        /* renamed from: a  reason: collision with root package name */
        private final k f4219a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.engine.z.b f4220b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f4221c;

        a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.b bVar) {
            j.d(bVar);
            this.f4220b = bVar;
            j.d(list);
            this.f4221c = list;
            this.f4219a = new k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.f4219a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public void b() {
            this.f4219a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public int c() {
            return e.b(this.f4221c, this.f4219a.a(), this.f4220b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public ImageHeaderParser.ImageType d() {
            return e.e(this.f4221c, this.f4219a.a(), this.f4220b);
        }
    }

    /* compiled from: ImageReader */
    public static final class b implements r {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.engine.z.b f4222a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f4223b;

        /* renamed from: c  reason: collision with root package name */
        private final m f4224c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.b bVar) {
            j.d(bVar);
            this.f4222a = bVar;
            j.d(list);
            this.f4223b = list;
            this.f4224c = new m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f4224c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public void b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public int c() {
            return e.a(this.f4223b, this.f4224c, this.f4222a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public ImageHeaderParser.ImageType d() {
            return e.d(this.f4223b, this.f4224c, this.f4222a);
        }
    }

    Bitmap a(BitmapFactory.Options options);

    void b();

    int c();

    ImageHeaderParser.ImageType d();
}
