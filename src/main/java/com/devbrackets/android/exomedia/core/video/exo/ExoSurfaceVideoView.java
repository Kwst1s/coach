package com.devbrackets.android.exomedia.core.video.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import c.b.a.a.d;
import c.b.a.a.j.g.b;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.c0;
import java.util.Map;

@TargetApi(16)
public class ExoSurfaceVideoView extends b implements c.b.a.a.j.b.a {
    protected a n;

    /* access modifiers changed from: protected */
    public class a implements SurfaceHolder.Callback {
        protected a() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.n.k(surfaceHolder.getSurface());
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.n.j();
            surfaceHolder.getSurface().release();
        }
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
    }

    @Override // c.b.a.a.j.b.a
    public void a() {
        this.n.m();
    }

    @Override // c.b.a.a.j.b.a
    public void b(int i2, int i3, float f2) {
        if (m((int) (((float) i2) * f2), i3)) {
            requestLayout();
        }
    }

    @Override // c.b.a.a.j.b.a
    public void c() {
        this.n.l();
    }

    @Override // c.b.a.a.j.b.a
    public void e(long j2) {
        this.n.n(j2);
    }

    @Override // c.b.a.a.j.b.a
    public void g(boolean z) {
        this.n.w(z);
    }

    @Override // c.b.a.a.j.b.a
    public Map<d, c0> getAvailableTracks() {
        return this.n.a();
    }

    @Override // c.b.a.a.j.b.a
    public int getBufferedPercent() {
        return this.n.b();
    }

    @Override // c.b.a.a.j.b.a
    public long getCurrentPosition() {
        return this.n.c();
    }

    @Override // c.b.a.a.j.b.a
    public long getDuration() {
        return this.n.d();
    }

    @Override // c.b.a.a.j.b.a
    public float getPlaybackSpeed() {
        return this.n.e();
    }

    @Override // c.b.a.a.j.b.a
    public float getVolume() {
        return this.n.f();
    }

    @Override // c.b.a.a.j.b.a
    public c.b.a.a.j.c.b getWindowInfo() {
        return this.n.g();
    }

    @Override // c.b.a.a.j.b.a
    public boolean h() {
        return this.n.i();
    }

    /* access modifiers changed from: protected */
    public void n() {
        this.n = new a(getContext(), this);
        getHolder().addCallback(new a());
        m(0, 0);
    }

    @Override // c.b.a.a.j.b.a
    public void setCaptionListener(c.b.a.a.j.d.a aVar) {
        this.n.o(aVar);
    }

    @Override // c.b.a.a.j.b.a
    public void setDrmCallback(s sVar) {
        this.n.p(sVar);
    }

    @Override // c.b.a.a.j.b.a
    public void setListenerMux(c.b.a.a.j.a aVar) {
        this.n.q(aVar);
    }

    @Override // c.b.a.a.j.b.a
    public void setRepeatMode(int i2) {
        this.n.r(i2);
    }

    @Override // c.b.a.a.j.b.a
    public void setVideoUri(Uri uri) {
        this.n.s(uri);
    }

    @Override // c.b.a.a.j.b.a
    public void start() {
        this.n.v();
    }
}
