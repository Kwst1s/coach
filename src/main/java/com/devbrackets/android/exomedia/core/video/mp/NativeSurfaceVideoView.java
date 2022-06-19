package com.devbrackets.android.exomedia.core.video.mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import c.b.a.a.d;
import c.b.a.a.j.g.b;
import com.devbrackets.android.exomedia.core.video.mp.a;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;
import java.util.Map;

public class NativeSurfaceVideoView extends b implements a.AbstractC0112a, c.b.a.a.j.b.a {
    protected View.OnTouchListener n;
    protected a o;

    /* access modifiers changed from: protected */
    public class a implements SurfaceHolder.Callback {
        protected a() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            NativeSurfaceVideoView.this.o.k(i3, i4);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            NativeSurfaceVideoView.this.o.j(surfaceHolder.getSurface());
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            surfaceHolder.getSurface().release();
            NativeSurfaceVideoView.this.q();
        }
    }

    public NativeSurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p(context, attributeSet);
    }

    @Override // c.b.a.a.j.b.a
    public void a() {
    }

    @Override // c.b.a.a.j.b.a
    public void b(int i2, int i3, float f2) {
        if (m((int) (((float) i2) * f2), i3)) {
            requestLayout();
        }
    }

    @Override // c.b.a.a.j.b.a
    public void c() {
        this.o.m();
    }

    @Override // com.devbrackets.android.exomedia.core.video.mp.a.AbstractC0112a
    public void d(int i2, int i3) {
        if (m(i2, i3)) {
            requestLayout();
        }
    }

    @Override // c.b.a.a.j.b.a
    public void e(long j2) {
        this.o.n(j2);
    }

    @Override // c.b.a.a.j.b.a
    public void g(boolean z) {
        this.o.x(z);
    }

    @Override // c.b.a.a.j.b.a
    public Map<d, c0> getAvailableTracks() {
        return null;
    }

    @Override // c.b.a.a.j.b.a
    public int getBufferedPercent() {
        return this.o.a();
    }

    @Override // c.b.a.a.j.b.a
    public long getCurrentPosition() {
        return this.o.b();
    }

    @Override // c.b.a.a.j.b.a
    public long getDuration() {
        return this.o.c();
    }

    @Override // c.b.a.a.j.b.a
    public float getPlaybackSpeed() {
        return this.o.d();
    }

    @Override // c.b.a.a.j.b.a
    public float getVolume() {
        return this.o.e();
    }

    @Override // c.b.a.a.j.b.a
    public c.b.a.a.j.c.b getWindowInfo() {
        return this.o.f();
    }

    @Override // c.b.a.a.j.b.a
    public boolean h() {
        return this.o.h();
    }

    public void n(Uri uri, Map<String, String> map) {
        this.o.v(uri, map);
        requestLayout();
        invalidate();
    }

    public void o(Uri uri, u uVar) {
        setVideoURI(uri);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.n;
        if ((onTouchListener != null ? onTouchListener.onTouch(this, motionEvent) : false) || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void p(Context context, AttributeSet attributeSet) {
        this.o = new a(context, this, this);
        getHolder().addCallback(new a());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        m(0, 0);
    }

    public void q() {
        this.o.y();
    }

    @Override // c.b.a.a.j.b.a
    public void setCaptionListener(c.b.a.a.j.d.a aVar) {
    }

    @Override // c.b.a.a.j.b.a
    public void setDrmCallback(s sVar) {
    }

    @Override // c.b.a.a.j.b.a
    public void setListenerMux(c.b.a.a.j.a aVar) {
        this.o.o(aVar);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.o.p(onBufferingUpdateListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.o.q(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.o.r(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.o.s(onInfoListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.o.t(onPreparedListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.o.u(onSeekCompleteListener);
    }

    @Override // c.b.a.a.j.b.a
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.n = onTouchListener;
        super.setOnTouchListener(onTouchListener);
    }

    @Override // c.b.a.a.j.b.a
    public void setRepeatMode(int i2) {
    }

    public void setVideoURI(Uri uri) {
        n(uri, null);
    }

    @Override // c.b.a.a.j.b.a
    public void setVideoUri(Uri uri) {
        o(uri, null);
    }

    @Override // c.b.a.a.j.b.a
    public void start() {
        this.o.w();
        requestFocus();
    }
}
