package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import b.k.a.a;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import j.l;

/* access modifiers changed from: package-private */
/* compiled from: FileRequestHandler */
public class k extends g {
    k(Context context) {
        super(context);
    }

    static int k(Uri uri) {
        return new a(uri.getPath()).e("Orientation", 1);
    }

    @Override // com.squareup.picasso.g, com.squareup.picasso.y
    public boolean c(w wVar) {
        return "file".equals(wVar.f8789d.getScheme());
    }

    @Override // com.squareup.picasso.g, com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        return new y.a(null, l.k(j(wVar)), t.e.DISK, k(wVar.f8789d));
    }
}
