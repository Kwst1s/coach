package c.b.a.a.j.f.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import c.b.a.a.a;
import c.b.a.a.b;
import c.b.a.a.c;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: MediaSourceBuilder */
public abstract class d {
    public abstract u a(Context context, Uri uri, String str, Handler handler, x xVar);

    /* access modifiers changed from: protected */
    public i.a b(Context context, String str, x xVar) {
        b bVar = a.f3055d;
        HttpDataSource.a aVar = null;
        HttpDataSource.a a2 = bVar != null ? bVar.a(str, xVar) : null;
        if (a2 == null) {
            c cVar = a.f3054c;
            if (cVar != null) {
                aVar = cVar.a(str, xVar);
            }
            a2 = aVar;
        }
        if (a2 == null) {
            a2 = new q(str, xVar);
        }
        return new o(context, xVar, a2);
    }
}
