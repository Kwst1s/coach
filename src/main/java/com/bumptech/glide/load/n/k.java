package com.bumptech.glide.load.n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader */
public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4010a;

    /* compiled from: MediaStoreFileLoader */
    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4011a;

        public a(Context context) {
            this.f4011a = context;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, File> b(r rVar) {
            return new k(this.f4011a);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader */
    public static class b implements d<File> {

        /* renamed from: d  reason: collision with root package name */
        private static final String[] f4012d = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f4013b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f4014c;

        b(Context context, Uri uri) {
            this.f4013b = context;
            this.f4014c = uri;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a e() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void f(f fVar, d.a<? super File> aVar) {
            Cursor query = this.f4013b.getContentResolver().query(this.f4014c, f4012d, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f4014c));
                return;
            }
            aVar.d(new File(str));
        }
    }

    public k(Context context) {
        this.f4010a = context;
    }

    /* renamed from: c */
    public n.a<File> a(Uri uri, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(uri), new b(this.f4010a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return com.bumptech.glide.load.m.p.b.b(uri);
    }
}
