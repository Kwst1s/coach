package h.a.a.a;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* compiled from: MediaExtractor */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private MediaExtractor f10231a;

    public h() {
        k();
    }

    public boolean a() {
        return this.f10231a.advance();
    }

    public long b() {
        return this.f10231a.getCachedDuration();
    }

    public long c() {
        return this.f10231a.getSampleTime();
    }

    public int d() {
        return this.f10231a.getSampleTrackIndex();
    }

    public final int e() {
        return this.f10231a.getTrackCount();
    }

    public MediaFormat f(int i2) {
        MediaFormat trackFormat = this.f10231a.getTrackFormat(i2);
        if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("width") && trackFormat.containsKey("height")) {
            trackFormat.setFloat("mpx-dar", ((float) trackFormat.getInteger("width")) / ((float) trackFormat.getInteger("height")));
        }
        return trackFormat;
    }

    public boolean g() {
        return this.f10231a.hasCacheReachedEndOfStream();
    }

    public boolean h() {
        return false;
    }

    public int i(ByteBuffer byteBuffer, int i2) {
        return this.f10231a.readSampleData(byteBuffer, i2);
    }

    public void j() {
        this.f10231a.release();
    }

    /* access modifiers changed from: protected */
    public void k() {
        MediaExtractor mediaExtractor = this.f10231a;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
        this.f10231a = new MediaExtractor();
    }

    public void l(long j2, int i2) {
        this.f10231a.seekTo(j2, i2);
    }

    public void m(int i2) {
        this.f10231a.selectTrack(i2);
    }

    public final void n(String str) {
        this.f10231a.setDataSource(str);
    }
}
