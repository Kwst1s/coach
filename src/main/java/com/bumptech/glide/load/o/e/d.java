package com.bumptech.glide.load.o.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.util.List;

/* compiled from: ResourceDrawableDecoder */
public class d implements j<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4103a;

    public d(Context context) {
        this.f4103a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.f4103a.getPackageName())) {
            return this.f4103a;
        }
        try {
            return this.f4103a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f4103a.getPackageName())) {
                return this.f4103a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* renamed from: c */
    public u<Drawable> a(Uri uri, int i2, int i3, h hVar) {
        Context d2 = d(uri, uri.getAuthority());
        return c.f(a.b(this.f4103a, d2, g(d2, uri)));
    }

    /* renamed from: h */
    public boolean b(Uri uri, h hVar) {
        return uri.getScheme().equals("android.resource");
    }
}
