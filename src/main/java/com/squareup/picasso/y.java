package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.t;

/* compiled from: RequestHandler */
public abstract class y {

    /* compiled from: RequestHandler */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final t.e f8819a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f8820b;

        /* renamed from: c  reason: collision with root package name */
        private final j.t f8821c;

        /* renamed from: d  reason: collision with root package name */
        private final int f8822d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap, t.e eVar) {
            this(bitmap, null, eVar, 0);
            d0.d(bitmap, "bitmap == null");
        }

        public Bitmap a() {
            return this.f8820b;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f8822d;
        }

        public t.e c() {
            return this.f8819a;
        }

        public j.t d() {
            return this.f8821c;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(j.t tVar, t.e eVar) {
            this(null, tVar, eVar, 0);
            d0.d(tVar, "source == null");
        }

        a(Bitmap bitmap, j.t tVar, t.e eVar, int i2) {
            if ((bitmap != null) != (tVar == null ? false : true)) {
                this.f8820b = bitmap;
                this.f8821c = tVar;
                d0.d(eVar, "loadedFrom == null");
                this.f8819a = eVar;
                this.f8822d = i2;
                return;
            }
            throw new AssertionError();
        }
    }

    static void a(int i2, int i3, int i4, int i5, BitmapFactory.Options options, w wVar) {
        int i6;
        double floor;
        if (i5 > i3 || i4 > i2) {
            if (i3 == 0) {
                floor = Math.floor((double) (((float) i4) / ((float) i2)));
            } else if (i2 == 0) {
                floor = Math.floor((double) (((float) i5) / ((float) i3)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i5) / ((float) i3)));
                int floor3 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                i6 = wVar.l ? Math.max(floor2, floor3) : Math.min(floor2, floor3);
            }
            i6 = (int) floor;
        } else {
            i6 = 1;
        }
        options.inSampleSize = i6;
        options.inJustDecodeBounds = false;
    }

    static void b(int i2, int i3, BitmapFactory.Options options, w wVar) {
        a(i2, i3, options.outWidth, options.outHeight, options, wVar);
    }

    static BitmapFactory.Options d(w wVar) {
        boolean c2 = wVar.c();
        boolean z = wVar.s != null;
        BitmapFactory.Options options = null;
        if (c2 || z || wVar.r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = c2;
            boolean z2 = wVar.r;
            options.inInputShareable = z2;
            options.inPurgeable = z2;
            if (z) {
                options.inPreferredConfig = wVar.s;
            }
        }
        return options;
    }

    static boolean g(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean c(w wVar);

    /* access modifiers changed from: package-private */
    public int e() {
        return 0;
    }

    public abstract a f(w wVar, int i2);

    /* access modifiers changed from: package-private */
    public boolean h(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return false;
    }
}
