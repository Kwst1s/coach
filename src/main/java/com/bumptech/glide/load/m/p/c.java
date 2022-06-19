package com.bumptech.glide.load.m.p;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.m.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher */
public class c implements d<InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private final Uri f3964b;

    /* renamed from: c  reason: collision with root package name */
    private final e f3965c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f3966d;

    /* access modifiers changed from: package-private */
    /* compiled from: ThumbFetcher */
    public static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f3967b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f3968a;

        a(ContentResolver contentResolver) {
            this.f3968a = contentResolver;
        }

        @Override // com.bumptech.glide.load.m.p.d
        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f3968a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f3967b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ThumbFetcher */
    public static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f3969b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f3970a;

        b(ContentResolver contentResolver) {
            this.f3970a = contentResolver;
        }

        @Override // com.bumptech.glide.load.m.p.d
        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f3970a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f3969b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f3964b = uri;
        this.f3965c = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.c(context).j().g(), dVar, com.bumptech.glide.b.c(context).e(), context.getContentResolver()));
    }

    public static c d(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() {
        InputStream d2 = this.f3965c.d(this.f3964b);
        int a2 = d2 != null ? this.f3965c.a(this.f3964b) : -1;
        return a2 != -1 ? new g(d2, a2) : d2;
    }

    @Override // com.bumptech.glide.load.m.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        InputStream inputStream = this.f3966d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.m.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.m.d
    public com.bumptech.glide.load.a e() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.m.d
    public void f(f fVar, d.a<? super InputStream> aVar) {
        try {
            InputStream h2 = h();
            this.f3966d = h2;
            aVar.d(h2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.c(e2);
        }
    }
}
