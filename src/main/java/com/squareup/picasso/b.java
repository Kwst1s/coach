package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import j.l;

/* access modifiers changed from: package-private */
/* compiled from: AssetRequestHandler */
public class b extends y {

    /* renamed from: d  reason: collision with root package name */
    private static final int f8658d = 22;

    /* renamed from: a  reason: collision with root package name */
    private final Context f8659a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8660b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private AssetManager f8661c;

    b(Context context) {
        this.f8659a = context;
    }

    static String j(w wVar) {
        return wVar.f8789d.toString().substring(f8658d);
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        Uri uri = wVar.f8789d;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        if (this.f8661c == null) {
            synchronized (this.f8660b) {
                if (this.f8661c == null) {
                    this.f8661c = this.f8659a.getAssets();
                }
            }
        }
        return new y.a(l.k(this.f8661c.open(j(wVar))), t.e.DISK);
    }
}
