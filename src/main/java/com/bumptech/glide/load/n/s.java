package com.bumptech.glide.load.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.n;
import java.io.InputStream;

/* compiled from: ResourceLoader */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f4045a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f4046b;

    /* compiled from: ResourceLoader */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4047a;

        public a(Resources resources) {
            this.f4047a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.f4047a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4048a;

        public b(Resources resources) {
            this.f4048a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.f4048a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4049a;

        public c(Resources resources) {
            this.f4049a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, InputStream> b(r rVar) {
            return new s(this.f4049a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4050a;

        public d(Resources resources) {
            this.f4050a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, Uri> b(r rVar) {
            return new s(this.f4050a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f4046b = resources;
        this.f4045a = nVar;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f4046b.getResourcePackageName(num.intValue()) + '/' + this.f4046b.getResourceTypeName(num.intValue()) + '/' + this.f4046b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    /* renamed from: c */
    public n.a<Data> a(Integer num, int i2, int i3, h hVar) {
        Uri d2 = d(num);
        if (d2 == null) {
            return null;
        }
        return this.f4045a.a(d2, i2, i3, hVar);
    }

    /* renamed from: e */
    public boolean b(Integer num) {
        return true;
    }
}
