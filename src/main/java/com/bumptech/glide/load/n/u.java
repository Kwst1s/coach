package com.bumptech.glide.load.n;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader */
public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f4052a;

    /* compiled from: StringLoader */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.n.o
        public n<String, AssetFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.n.o
        public n<String, ParcelFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    public static class c implements o<String, InputStream> {
        @Override // com.bumptech.glide.load.n.o
        public n<String, InputStream> b(r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f4052a = nVar;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? f(str) : parse;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: c */
    public n.a<Data> a(String str, int i2, int i3, h hVar) {
        Uri e2 = e(str);
        if (e2 == null || !this.f4052a.b(e2)) {
            return null;
        }
        return this.f4052a.a(e2, i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(String str) {
        return true;
    }
}
