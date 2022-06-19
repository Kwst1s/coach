package com.bumptech.glide.load.m.p;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.z.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener */
class e {

    /* renamed from: f  reason: collision with root package name */
    private static final a f3971f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final a f3972a;

    /* renamed from: b  reason: collision with root package name */
    private final d f3973b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3974c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f3975d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f3976e;

    e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f3971f, dVar, bVar, contentResolver);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.m.p.d r2 = r6.f3973b     // Catch:{ SecurityException -> 0x0026, all -> 0x0024 }
            android.database.Cursor r2 = r2.a(r7)     // Catch:{ SecurityException -> 0x0026, all -> 0x0024 }
            if (r2 == 0) goto L_0x001e
            boolean r3 = r2.moveToFirst()     // Catch:{ SecurityException -> 0x001c }
            if (r3 == 0) goto L_0x001e
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch:{ SecurityException -> 0x001c }
            if (r2 == 0) goto L_0x001b
            r2.close()
        L_0x001b:
            return r7
        L_0x001c:
            r3 = move-exception
            goto L_0x0028
        L_0x001e:
            if (r2 == 0) goto L_0x0023
            r2.close()
        L_0x0023:
            return r1
        L_0x0024:
            r7 = move-exception
            goto L_0x004b
        L_0x0026:
            r3 = move-exception
            r2 = r1
        L_0x0028:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x0043
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch:{ all -> 0x0049 }
            r4.append(r7)     // Catch:{ all -> 0x0049 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0049 }
            android.util.Log.d(r0, r7, r3)     // Catch:{ all -> 0x0049 }
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()
        L_0x0048:
            return r1
        L_0x0049:
            r7 = move-exception
            r1 = r2
        L_0x004b:
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.m.p.e.b(android.net.Uri):java.lang.String");
    }

    private boolean c(File file) {
        return this.f3972a.a(file) && 0 < this.f3972a.c(file);
    }

    /* access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            inputStream = this.f3975d.openInputStream(uri);
            int b2 = com.bumptech.glide.load.e.b(this.f3976e, inputStream, this.f3974c);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return b2;
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream d(Uri uri) {
        String b2 = b(uri);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        File b3 = this.f3972a.b(b2);
        if (!c(b3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b3);
        try {
            return this.f3975d.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f3972a = aVar;
        this.f3973b = dVar;
        this.f3974c = bVar;
        this.f3975d = contentResolver;
        this.f3976e = list;
    }
}
