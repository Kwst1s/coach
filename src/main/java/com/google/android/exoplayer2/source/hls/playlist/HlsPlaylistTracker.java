package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.g;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.upstream.t;
import java.io.IOException;

public interface HlsPlaylistTracker {

    public static final class PlaylistResetException extends IOException {
        public PlaylistResetException(String str) {
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public PlaylistStuckException(String str) {
        }
    }

    public interface a {
        HlsPlaylistTracker a(g gVar, t tVar, h hVar);
    }

    public interface b {
        void e();

        boolean h(d.a aVar, long j2);
    }

    public interface c {
        void d(e eVar);
    }

    boolean a();

    e b(d.a aVar);

    void c(d.a aVar);

    d d();

    void e(Uri uri, v.a aVar, c cVar);

    void f();

    void g(b bVar);

    void h(b bVar);

    boolean i(d.a aVar);

    void j(d.a aVar);

    long l();

    void stop();
}
