package c.b.a.a.j.f.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.hls.l;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: HlsMediaSourceBuilder */
public class c extends d {
    @Override // c.b.a.a.j.f.b.d
    public u a(Context context, Uri uri, String str, Handler handler, x xVar) {
        return new l.b(b(context, str, xVar)).a(uri);
    }
}
