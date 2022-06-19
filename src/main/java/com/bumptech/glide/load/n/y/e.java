package com.bumptech.glide.load.n.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: QMediaStoreUriLoader */
public final class e<DataT> implements n<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4072a;

    /* renamed from: b  reason: collision with root package name */
    private final n<File, DataT> f4073b;

    /* renamed from: c  reason: collision with root package name */
    private final n<Uri, DataT> f4074c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f4075d;

    /* compiled from: QMediaStoreUriLoader */
    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4076a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f4077b;

        a(Context context, Class<DataT> cls) {
            this.f4076a = context;
            this.f4077b = cls;
        }

        @Override // com.bumptech.glide.load.n.o
        public final n<Uri, DataT> b(r rVar) {
            return new e(this.f4076a, rVar.d(File.class, this.f4077b), rVar.d(Uri.class, this.f4077b), this.f4077b);
        }
    }

    /* compiled from: QMediaStoreUriLoader */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: QMediaStoreUriLoader */
    public static final class d<DataT> implements com.bumptech.glide.load.m.d<DataT> {
        private static final String[] l = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f4078b;

        /* renamed from: c  reason: collision with root package name */
        private final n<File, DataT> f4079c;

        /* renamed from: d  reason: collision with root package name */
        private final n<Uri, DataT> f4080d;

        /* renamed from: e  reason: collision with root package name */
        private final Uri f4081e;

        /* renamed from: f  reason: collision with root package name */
        private final int f4082f;

        /* renamed from: g  reason: collision with root package name */
        private final int f4083g;

        /* renamed from: h  reason: collision with root package name */
        private final h f4084h;

        /* renamed from: i  reason: collision with root package name */
        private final Class<DataT> f4085i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f4086j;

        /* renamed from: k  reason: collision with root package name */
        private volatile com.bumptech.glide.load.m.d<DataT> f4087k;

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, h hVar, Class<DataT> cls) {
            this.f4078b = context.getApplicationContext();
            this.f4079c = nVar;
            this.f4080d = nVar2;
            this.f4081e = uri;
            this.f4082f = i2;
            this.f4083g = i3;
            this.f4084h = hVar;
            this.f4085i = cls;
        }

        private n.a<DataT> c() {
            if (Environment.isExternalStorageLegacy()) {
                return this.f4079c.a(h(this.f4081e), this.f4082f, this.f4083g, this.f4084h);
            }
            return this.f4080d.a(g() ? MediaStore.setRequireOriginal(this.f4081e) : this.f4081e, this.f4082f, this.f4083g, this.f4084h);
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.m.d<Data>, com.bumptech.glide.load.m.d<DataT> */
        private com.bumptech.glide.load.m.d<DataT> d() {
            n.a<DataT> c2 = c();
            if (c2 != null) {
                return (com.bumptech.glide.load.m.d<Data>) c2.f4022c;
            }
            return null;
        }

        private boolean g() {
            return this.f4078b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        private File h(Uri uri) {
            Cursor cursor = null;
            try {
                cursor = this.f4078b.getContentResolver().query(uri, l, null, null, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<DataT> a() {
            return this.f4085i;
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            com.bumptech.glide.load.m.d<DataT> dVar = this.f4087k;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
            this.f4086j = true;
            com.bumptech.glide.load.m.d<DataT> dVar = this.f4087k;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a e() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void f(f fVar, d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.m.d<DataT> d2 = d();
                if (d2 == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f4081e));
                    return;
                }
                this.f4087k = d2;
                if (this.f4086j) {
                    cancel();
                } else {
                    d2.f(fVar, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.c(e2);
            }
        }
    }

    e(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f4072a = context.getApplicationContext();
        this.f4073b = nVar;
        this.f4074c = nVar2;
        this.f4075d = cls;
    }

    /* renamed from: c */
    public n.a<DataT> a(Uri uri, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(uri), new d(this.f4072a, this.f4073b, this.f4074c, uri, i2, i3, hVar, this.f4075d));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.m.p.b.b(uri);
    }
}
