package com.bumptech.glide.load.n;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.i;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.n.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f4056b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a  reason: collision with root package name */
    private final c<Data> f4057a;

    /* compiled from: UriLoader */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4058a;

        public a(ContentResolver contentResolver) {
            this.f4058a = contentResolver;
        }

        @Override // com.bumptech.glide.load.n.w.c
        public com.bumptech.glide.load.m.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.m.a(this.f4058a, uri);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4059a;

        public b(ContentResolver contentResolver) {
            this.f4059a = contentResolver;
        }

        @Override // com.bumptech.glide.load.n.w.c
        public com.bumptech.glide.load.m.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.f4059a, uri);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader */
    public interface c<Data> {
        com.bumptech.glide.load.m.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4060a;

        public d(ContentResolver contentResolver) {
            this.f4060a = contentResolver;
        }

        @Override // com.bumptech.glide.load.n.w.c
        public com.bumptech.glide.load.m.d<InputStream> a(Uri uri) {
            return new o(this.f4060a, uri);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f4057a = cVar;
    }

    /* renamed from: c */
    public n.a<Data> a(Uri uri, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(uri), this.f4057a.a(uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f4056b.contains(uri.getScheme());
    }
}
