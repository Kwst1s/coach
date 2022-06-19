package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m.m;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.j;
import com.bumptech.glide.r.k;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler */
public final class l {

    /* renamed from: f  reason: collision with root package name */
    public static final g<com.bumptech.glide.load.b> f4197f = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.b.f3633d);

    /* renamed from: g  reason: collision with root package name */
    public static final g<i> f4198g = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", i.SRGB);

    /* renamed from: h  reason: collision with root package name */
    public static final g<Boolean> f4199h;

    /* renamed from: i  reason: collision with root package name */
    public static final g<Boolean> f4200i;

    /* renamed from: j  reason: collision with root package name */
    private static final Set<String> f4201j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));

    /* renamed from: k  reason: collision with root package name */
    private static final b f4202k = new a();
    private static final Set<ImageHeaderParser.ImageType> l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> m = k.e(0);

    /* renamed from: a  reason: collision with root package name */
    private final e f4203a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f4204b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f4205c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f4206d;

    /* renamed from: e  reason: collision with root package name */
    private final q f4207e = q.a();

    /* compiled from: Downsampler */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void a(e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void b() {
        }
    }

    /* compiled from: Downsampler */
    public interface b {
        void a(e eVar, Bitmap bitmap);

        void b();
    }

    static {
        g<k> gVar = k.f4192f;
        Boolean bool = Boolean.FALSE;
        f4199h = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f4200i = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public l(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.f4206d = list;
        j.d(displayMetrics);
        this.f4204b = displayMetrics;
        j.d(eVar);
        this.f4203a = eVar;
        j.d(bVar);
        this.f4205c = bVar;
    }

    private static int a(double d2) {
        int l2 = l(d2);
        double d3 = (double) l2;
        Double.isNaN(d3);
        int x = x(d3 * d2);
        double d4 = (double) (((float) x) / ((float) l2));
        Double.isNaN(d4);
        double d5 = (double) x;
        Double.isNaN(d5);
        return x((d2 / d4) * d5);
    }

    private void b(r rVar, com.bumptech.glide.load.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (!this.f4207e.e(i2, i3, options, z, z2)) {
            if (bVar == com.bumptech.glide.load.b.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = rVar.d().hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, r rVar, b bVar, e eVar, k kVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        double d2;
        if (i3 > 0 && i4 > 0) {
            if (r(i2)) {
                i7 = i3;
                i8 = i4;
            } else {
                i8 = i3;
                i7 = i4;
            }
            float b2 = kVar.b(i8, i7, i5, i6);
            if (b2 > Utils.FLOAT_EPSILON) {
                k.e a2 = kVar.a(i8, i7, i5, i6);
                if (a2 != null) {
                    float f2 = (float) i8;
                    float f3 = (float) i7;
                    int x = i8 / x((double) (b2 * f2));
                    int x2 = i7 / x((double) (b2 * f3));
                    k.e eVar2 = k.e.MEMORY;
                    if (a2 == eVar2) {
                        i9 = Math.max(x, x2);
                    } else {
                        i9 = Math.min(x, x2);
                    }
                    int i13 = Build.VERSION.SDK_INT;
                    if (i13 > 23 || !f4201j.contains(options.outMimeType)) {
                        int max = Math.max(1, Integer.highestOneBit(i9));
                        if (a2 == eVar2 && ((float) max) < 1.0f / b2) {
                            max <<= 1;
                        }
                        i10 = max;
                    } else {
                        i10 = 1;
                    }
                    options.inSampleSize = i10;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(i10, 8);
                        i11 = (int) Math.ceil((double) (f2 / min));
                        i12 = (int) Math.ceil((double) (f3 / min));
                        int i14 = i10 / 8;
                        if (i14 > 0) {
                            i11 /= i14;
                            i12 /= i14;
                        }
                    } else {
                        if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                            float f4 = (float) i10;
                            i11 = (int) Math.floor((double) (f2 / f4));
                            d2 = Math.floor((double) (f3 / f4));
                        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i13 >= 24) {
                                float f5 = (float) i10;
                                i11 = Math.round(f2 / f5);
                                i12 = Math.round(f3 / f5);
                            } else {
                                float f6 = (float) i10;
                                i11 = (int) Math.floor((double) (f2 / f6));
                                d2 = Math.floor((double) (f3 / f6));
                            }
                        } else if (i8 % i10 == 0 && i7 % i10 == 0) {
                            i11 = i8 / i10;
                            i12 = i7 / i10;
                        } else {
                            int[] m2 = m(rVar, options, bVar, eVar);
                            i11 = m2[0];
                            i12 = m2[1];
                        }
                        i12 = (int) d2;
                    }
                    double b3 = (double) kVar.b(i11, i12, i5, i6);
                    if (i13 >= 19) {
                        options.inTargetDensity = a(b3);
                        options.inDensity = l(b3);
                    }
                    if (s(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + i11 + "x" + i12 + "], exact scale factor: " + b2 + ", power of 2 sample size: " + i10 + ", adjusted scale factor: " + b3 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + kVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
        }
    }

    private u<Bitmap> e(r rVar, int i2, int i3, h hVar, b bVar) {
        byte[] bArr = (byte[]) this.f4205c.e(65536, byte[].class);
        BitmapFactory.Options k2 = k();
        k2.inTempStorage = bArr;
        com.bumptech.glide.load.b bVar2 = (com.bumptech.glide.load.b) hVar.c(f4197f);
        i iVar = (i) hVar.c(f4198g);
        k kVar = (k) hVar.c(k.f4192f);
        boolean booleanValue = ((Boolean) hVar.c(f4199h)).booleanValue();
        g<Boolean> gVar = f4200i;
        try {
            return e.f(h(rVar, k2, kVar, bVar2, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i2, i3, booleanValue, bVar), this.f4203a);
        } finally {
            v(k2);
            this.f4205c.d(bArr);
        }
    }

    private Bitmap h(r rVar, BitmapFactory.Options options, k kVar, com.bumptech.glide.load.b bVar, i iVar, boolean z, int i2, int i3, boolean z2, b bVar2) {
        int i4;
        int i5;
        l lVar;
        int i6;
        ColorSpace colorSpace;
        int i7;
        int i8;
        long b2 = f.b();
        int[] m2 = m(rVar, options, bVar2, this.f4203a);
        boolean z3 = false;
        int i9 = m2[0];
        int i10 = m2[1];
        String str = options.outMimeType;
        boolean z4 = (i9 == -1 || i10 == -1) ? false : z;
        int c2 = rVar.c();
        int g2 = y.g(c2);
        boolean j2 = y.j(c2);
        if (i2 == Integer.MIN_VALUE) {
            i5 = i3;
            i4 = r(g2) ? i10 : i9;
        } else {
            i5 = i3;
            i4 = i2;
        }
        int i11 = i5 == Integer.MIN_VALUE ? r(g2) ? i9 : i10 : i5;
        ImageHeaderParser.ImageType d2 = rVar.d();
        c(d2, rVar, bVar2, this.f4203a, kVar, g2, i9, i10, i4, i11, options);
        b(rVar, bVar, z4, j2, options, i4, i11);
        int i12 = Build.VERSION.SDK_INT;
        boolean z5 = i12 >= 19;
        if (options.inSampleSize == 1 || z5) {
            lVar = this;
            if (lVar.z(d2)) {
                if (i9 < 0 || i10 < 0 || !z2 || !z5) {
                    float f2 = s(options) ? ((float) options.inTargetDensity) / ((float) options.inDensity) : 1.0f;
                    int i13 = options.inSampleSize;
                    float f3 = (float) i13;
                    i8 = Math.round(((float) ((int) Math.ceil((double) (((float) i9) / f3)))) * f2);
                    i7 = Math.round(((float) ((int) Math.ceil((double) (((float) i10) / f3)))) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i8 + "x" + i7 + "] for source [" + i9 + "x" + i10 + "], sampleSize: " + i13 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    i8 = i4;
                    i7 = i11;
                }
                if (i8 > 0 && i7 > 0) {
                    y(options, lVar.f4203a, i8, i7);
                }
            }
        } else {
            lVar = this;
        }
        if (i12 >= 28) {
            if (iVar == i.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i12 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i14 = i(rVar, options, bVar2, lVar.f4203a);
        bVar2.a(lVar.f4203a, i14);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = c2;
            t(i9, i10, str, options, i14, i2, i3, b2);
        } else {
            i6 = c2;
        }
        Bitmap bitmap = null;
        if (i14 != null) {
            i14.setDensity(lVar.f4204b.densityDpi);
            bitmap = y.k(lVar.f4203a, i14, i6);
            if (!i14.equals(bitmap)) {
                lVar.f4203a.d(i14);
            }
        }
        return bitmap;
    }

    private static Bitmap i(r rVar, BitmapFactory.Options options, b bVar, e eVar) {
        if (!options.inJustDecodeBounds) {
            bVar.b();
            rVar.b();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        y.f().lock();
        try {
            return rVar.a(options);
        } catch (IllegalArgumentException e2) {
            IOException u = u(e2, i2, i3, str, options);
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", u);
            }
            Bitmap bitmap = options.inBitmap;
            if (bitmap != null) {
                try {
                    eVar.d(bitmap);
                    options.inBitmap = null;
                    return i(rVar, options, bVar, eVar);
                } catch (IOException unused) {
                    throw u;
                }
            } else {
                throw u;
            }
        } finally {
            y.f().unlock();
        }
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = BuildConfig.FLAVOR;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (l.class) {
            Queue<BitmapFactory.Options> queue = m;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] m(r rVar, BitmapFactory.Options options, b bVar, e eVar) {
        options.inJustDecodeBounds = true;
        i(rVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + f.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = m;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return l.contains(imageType);
    }

    public u<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, h hVar) {
        return e(new r.b(parcelFileDescriptor, this.f4206d, this.f4205c), i2, i3, hVar, f4202k);
    }

    public u<Bitmap> f(InputStream inputStream, int i2, int i3, h hVar) {
        return g(inputStream, i2, i3, hVar, f4202k);
    }

    public u<Bitmap> g(InputStream inputStream, int i2, int i3, h hVar, b bVar) {
        return e(new r.a(inputStream, this.f4206d, this.f4205c), i2, i3, hVar, bVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return m.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
