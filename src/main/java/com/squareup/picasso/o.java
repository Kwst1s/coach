package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import j.l;

/* access modifiers changed from: package-private */
/* compiled from: MediaStoreRequestHandler */
public class o extends g {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f8721b = {"orientation"};

    /* access modifiers changed from: package-private */
    /* compiled from: MediaStoreRequestHandler */
    public enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        

        /* renamed from: b  reason: collision with root package name */
        final int f8726b;

        /* renamed from: c  reason: collision with root package name */
        final int f8727c;

        /* renamed from: d  reason: collision with root package name */
        final int f8728d;

        private a(int i2, int i3, int i4) {
            this.f8726b = i2;
            this.f8727c = i3;
            this.f8728d = i4;
        }
    }

    o(Context context) {
        super(context);
    }

    static int k(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, f8721b, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i2 = query.getInt(0);
                    if (query != null) {
                        query.close();
                    }
                    return i2;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (0 != 0) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    static a l(int i2, int i3) {
        a aVar = a.MICRO;
        if (i2 <= aVar.f8727c && i3 <= aVar.f8728d) {
            return aVar;
        }
        a aVar2 = a.MINI;
        if (i2 > aVar2.f8727c || i3 > aVar2.f8728d) {
            return a.FULL;
        }
        return aVar2;
    }

    @Override // com.squareup.picasso.g, com.squareup.picasso.y
    public boolean c(w wVar) {
        Uri uri = wVar.f8789d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // com.squareup.picasso.g, com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        Bitmap bitmap;
        ContentResolver contentResolver = this.f8693a.getContentResolver();
        int k2 = k(contentResolver, wVar.f8789d);
        String type = contentResolver.getType(wVar.f8789d);
        boolean z = type != null && type.startsWith("video/");
        if (wVar.c()) {
            a l = l(wVar.f8793h, wVar.f8794i);
            if (!z && l == a.FULL) {
                return new y.a(null, l.k(j(wVar)), t.e.DISK, k2);
            }
            long parseId = ContentUris.parseId(wVar.f8789d);
            BitmapFactory.Options d2 = y.d(wVar);
            d2.inJustDecodeBounds = true;
            y.a(wVar.f8793h, wVar.f8794i, l.f8727c, l.f8728d, d2, wVar);
            if (z) {
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, l == a.FULL ? 1 : l.f8726b, d2);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, l.f8726b, d2);
            }
            if (bitmap != null) {
                return new y.a(bitmap, null, t.e.DISK, k2);
            }
        }
        return new y.a(null, l.k(j(wVar)), t.e.DISK, k2);
    }
}
