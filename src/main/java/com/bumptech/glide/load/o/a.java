package com.bumptech.glide.load.o;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.q;

/* compiled from: ImageDecoderResourceDecoder */
public abstract class a<T> implements j<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final q f4089a = q.a();

    /* access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.o.a$a  reason: collision with other inner class name */
    /* compiled from: ImageDecoderResourceDecoder */
    public class C0101a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4090a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4091b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f4092c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f4093d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f4094e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ i f4095f;

        /* renamed from: com.bumptech.glide.load.o.a$a$a  reason: collision with other inner class name */
        /* compiled from: ImageDecoderResourceDecoder */
        class C0102a implements ImageDecoder.OnPartialImageListener {
            C0102a(C0101a aVar) {
            }

            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        C0101a(int i2, int i3, boolean z, b bVar, k kVar, i iVar) {
            this.f4090a = i2;
            this.f4091b = i3;
            this.f4092c = z;
            this.f4093d = bVar;
            this.f4094e = kVar;
            this.f4095f = iVar;
        }

        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (a.this.f4089a.c(this.f4090a, this.f4091b, this.f4092c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f4093d == b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0102a(this));
            Size size = imageInfo.getSize();
            int i2 = this.f4090a;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getWidth();
            }
            int i3 = this.f4091b;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getHeight();
            }
            float b2 = this.f4094e.b(size.getWidth(), size.getHeight(), i2, i3);
            int round = Math.round(((float) size.getWidth()) * b2);
            int round2 = Math.round(((float) size.getHeight()) * b2);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b2);
            }
            imageDecoder.setTargetSize(round, round2);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                if (this.f4095f == i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i4 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract u<T> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener);

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: com.bumptech.glide.load.h */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final u<T> a(ImageDecoder.Source source, int i2, int i3, h hVar) {
        b bVar = (b) hVar.c(l.f4197f);
        k kVar = (k) hVar.c(k.f4192f);
        g<Boolean> gVar = l.f4200i;
        return c(source, i2, i3, new C0101a(i2, i3, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), bVar, kVar, (i) hVar.c(l.f4198g)));
    }

    /* renamed from: e */
    public final boolean b(ImageDecoder.Source source, h hVar) {
        return true;
    }
}
