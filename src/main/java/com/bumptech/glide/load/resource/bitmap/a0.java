package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder */
public class a0<T> implements j<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final com.bumptech.glide.load.g<Long> f4166d = com.bumptech.glide.load.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e  reason: collision with root package name */
    public static final com.bumptech.glide.load.g<Integer> f4167e = com.bumptech.glide.load.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f  reason: collision with root package name */
    private static final e f4168f = new e();

    /* renamed from: a  reason: collision with root package name */
    private final f<T> f4169a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f4170b;

    /* renamed from: c  reason: collision with root package name */
    private final e f4171c;

    /* access modifiers changed from: package-private */
    /* compiled from: VideoDecoder */
    public class a implements g.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f4172a = ByteBuffer.allocate(8);

        a() {
        }

        /* renamed from: b */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f4172a) {
                this.f4172a.position(0);
                messageDigest.update(this.f4172a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder */
    class b implements g.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f4173a = ByteBuffer.allocate(4);

        b() {
        }

        /* renamed from: b */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f4173a) {
                    this.f4173a.position(0);
                    messageDigest.update(this.f4173a.putInt(num.intValue()).array());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: VideoDecoder */
    public static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoDecoder */
    public static final class d implements f<ByteBuffer> {

        /* access modifiers changed from: package-private */
        /* compiled from: VideoDecoder */
        public class a extends MediaDataSource {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ByteBuffer f4174b;

            a(d dVar, ByteBuffer byteBuffer) {
                this.f4174b = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return (long) this.f4174b.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr, int i2, int i3) {
                if (j2 >= ((long) this.f4174b.limit())) {
                    return -1;
                }
                this.f4174b.position((int) j2);
                int min = Math.min(i3, this.f4174b.remaining());
                this.f4174b.get(bArr, i2, min);
                return min;
            }
        }

        d() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(this, byteBuffer));
        }
    }

    /* compiled from: VideoDecoder */
    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoDecoder */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoDecoder */
    public static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    a0(com.bumptech.glide.load.engine.z.e eVar, f<T> fVar) {
        this(eVar, fVar, f4168f);
    }

    public static j<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.z.e eVar) {
        return new a0(eVar, new c(null));
    }

    public static j<ByteBuffer, Bitmap> d(com.bumptech.glide.load.engine.z.e eVar) {
        return new a0(eVar, new d());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, k kVar) {
        Bitmap g2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || kVar == k.f4190d) ? null : g(mediaMetadataRetriever, j2, i2, i3, i4, kVar);
        return g2 == null ? f(mediaMetadataRetriever, j2, i2) : g2;
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, k kVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b2 = kVar.b(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(((float) parseInt) * b2), Math.round(b2 * ((float) parseInt2)));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static j<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.engine.z.e eVar) {
        return new a0(eVar, new g());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.bumptech.glide.load.h */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.j
    public u<Bitmap> a(T t, int i2, int i3, h hVar) {
        long longValue = ((Long) hVar.c(f4166d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) hVar.c(f4167e);
            if (num == null) {
                num = 2;
            }
            k kVar = (k) hVar.c(k.f4192f);
            if (kVar == null) {
                kVar = k.f4191e;
            }
            MediaMetadataRetriever a2 = this.f4171c.a();
            try {
                this.f4169a.a(a2, t);
                Bitmap e2 = e(a2, longValue, num.intValue(), i2, i3, kVar);
                a2.release();
                return e.f(e2, this.f4170b);
            } catch (RuntimeException e3) {
                throw new IOException(e3);
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    @Override // com.bumptech.glide.load.j
    public boolean b(T t, h hVar) {
        return true;
    }

    a0(com.bumptech.glide.load.engine.z.e eVar, f<T> fVar, e eVar2) {
        this.f4170b = eVar;
        this.f4169a = fVar;
        this.f4171c = eVar2;
    }
}
