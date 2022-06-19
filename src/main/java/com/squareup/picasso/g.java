package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import j.l;
import java.io.InputStream;

/* access modifiers changed from: package-private */
/* compiled from: ContentStreamRequestHandler */
public class g extends y {

    /* renamed from: a  reason: collision with root package name */
    final Context f8693a;

    g(Context context) {
        this.f8693a = context;
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        return "content".equals(wVar.f8789d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        return new y.a(l.k(j(wVar)), t.e.DISK);
    }

    /* access modifiers changed from: package-private */
    public InputStream j(w wVar) {
        return this.f8693a.getContentResolver().openInputStream(wVar.f8789d);
    }
}
