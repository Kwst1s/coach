package c.b.a.a.j.f.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.e0.e;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: DefaultMediaSourceBuilder */
public class b extends d {
    @Override // c.b.a.a.j.f.b.d
    public u a(Context context, Uri uri, String str, Handler handler, x xVar) {
        s.b bVar = new s.b(b(context, str, xVar));
        bVar.b(new e());
        return bVar.a(uri);
    }
}
