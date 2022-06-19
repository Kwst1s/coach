package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.i;

/* compiled from: DefaultDataSourceFactory */
public final class o implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6965a;

    /* renamed from: b  reason: collision with root package name */
    private final x f6966b;

    /* renamed from: c  reason: collision with root package name */
    private final i.a f6967c;

    public o(Context context, x xVar, i.a aVar) {
        this.f6965a = context.getApplicationContext();
        this.f6966b = xVar;
        this.f6967c = aVar;
    }

    /* renamed from: b */
    public n a() {
        n nVar = new n(this.f6965a, this.f6967c.a());
        x xVar = this.f6966b;
        if (xVar != null) {
            nVar.d(xVar);
        }
        return nVar;
    }
}
