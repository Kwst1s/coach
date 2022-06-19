package c.b.a.a.j.b;

import android.net.Uri;
import android.view.View;
import c.b.a.a.d;
import c.b.a.a.j.c.b;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.c0;
import java.util.Map;

/* compiled from: VideoViewApi */
public interface a {
    void a();

    void b(int i2, int i3, float f2);

    void c();

    void e(long j2);

    void f(int i2, boolean z);

    void g(boolean z);

    Map<d, c0> getAvailableTracks();

    int getBufferedPercent();

    long getCurrentPosition();

    long getDuration();

    float getPlaybackSpeed();

    float getVolume();

    b getWindowInfo();

    boolean h();

    void setCaptionListener(c.b.a.a.j.d.a aVar);

    void setDrmCallback(s sVar);

    void setListenerMux(c.b.a.a.j.a aVar);

    void setMeasureBasedOnAspectRatioEnabled(boolean z);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRepeatMode(int i2);

    void setScaleType(c.b.a.a.j.g.d.b bVar);

    void setVideoUri(Uri uri);

    void start();
}
