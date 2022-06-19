package c.b.a.a.j.f.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.source.dash.h;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: DashMediaSourceBuilder */
public class a extends d {
    @Override // c.b.a.a.j.f.b.d
    public u a(Context context, Uri uri, String str, Handler handler, x xVar) {
        return new e.d(new h.a(b(context, str, xVar)), b(context, str, null)).a(uri);
    }
}
