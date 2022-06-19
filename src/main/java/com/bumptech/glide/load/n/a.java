package com.bumptech.glide.load.n;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.m.h;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.n.n;
import java.io.InputStream;

/* compiled from: AssetUriLoader */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final int f3977c = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f3978a;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0096a<Data> f3979b;

    /* renamed from: com.bumptech.glide.load.n.a$a  reason: collision with other inner class name */
    /* compiled from: AssetUriLoader */
    public interface AbstractC0096a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader */
    public static class b implements o<Uri, ParcelFileDescriptor>, AbstractC0096a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f3980a;

        public b(AssetManager assetManager) {
            this.f3980a = assetManager;
        }

        @Override // com.bumptech.glide.load.n.a.AbstractC0096a
        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new a(this.f3980a, this);
        }
    }

    /* compiled from: AssetUriLoader */
    public static class c implements o<Uri, InputStream>, AbstractC0096a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f3981a;

        public c(AssetManager assetManager) {
            this.f3981a = assetManager;
        }

        @Override // com.bumptech.glide.load.n.a.AbstractC0096a
        public d<InputStream> a(AssetManager assetManager, String str) {
            return new n(assetManager, str);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new a(this.f3981a, this);
        }
    }

    public a(AssetManager assetManager, AbstractC0096a<Data> aVar) {
        this.f3978a = assetManager;
        this.f3979b = aVar;
    }

    /* renamed from: c */
    public n.a<Data> a(Uri uri, int i2, int i3, com.bumptech.glide.load.h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(uri), this.f3979b.a(this.f3978a, uri.toString().substring(f3977c)));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
