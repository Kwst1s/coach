package com.devbrackets.android.exomedia.core.video.mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

/* compiled from: NativeVideoDelegate */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, String> f4438a;

    /* renamed from: b  reason: collision with root package name */
    protected c f4439b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f4440c;

    /* renamed from: d  reason: collision with root package name */
    protected AbstractC0112a f4441d;

    /* renamed from: e  reason: collision with root package name */
    protected c.b.a.a.j.g.a f4442e;

    /* renamed from: f  reason: collision with root package name */
    protected MediaPlayer f4443f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f4444g = false;

    /* renamed from: h  reason: collision with root package name */
    protected long f4445h;

    /* renamed from: i  reason: collision with root package name */
    protected int f4446i;

    /* renamed from: j  reason: collision with root package name */
    protected float f4447j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    protected c.b.a.a.j.a f4448k;
    protected b l = new b();
    protected MediaPlayer.OnCompletionListener m;
    protected MediaPlayer.OnPreparedListener n;
    protected MediaPlayer.OnBufferingUpdateListener o;
    protected MediaPlayer.OnSeekCompleteListener p;
    protected MediaPlayer.OnErrorListener q;
    protected MediaPlayer.OnInfoListener r;

    /* renamed from: com.devbrackets.android.exomedia.core.video.mp.a$a  reason: collision with other inner class name */
    /* compiled from: NativeVideoDelegate */
    public interface AbstractC0112a {
        void d(int i2, int i3);
    }

    /* compiled from: NativeVideoDelegate */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            a aVar = a.this;
            aVar.f4446i = i2;
            MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = aVar.o;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener.onBufferingUpdate(mediaPlayer, i2);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            a aVar = a.this;
            aVar.f4439b = c.COMPLETED;
            MediaPlayer.OnCompletionListener onCompletionListener = aVar.m;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(aVar.f4443f);
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Log.d("ContentValues", "Error: " + i2 + "," + i3);
            a aVar = a.this;
            aVar.f4439b = c.ERROR;
            MediaPlayer.OnErrorListener onErrorListener = aVar.q;
            return onErrorListener == null || onErrorListener.onError(aVar.f4443f, i2, i3);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            MediaPlayer.OnInfoListener onInfoListener = a.this.r;
            return onInfoListener == null || onInfoListener.onInfo(mediaPlayer, i2, i3);
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            a aVar = a.this;
            aVar.f4439b = c.PREPARED;
            MediaPlayer.OnPreparedListener onPreparedListener = aVar.n;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(aVar.f4443f);
            }
            a.this.f4441d.d(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            a aVar2 = a.this;
            long j2 = aVar2.f4445h;
            if (j2 != 0) {
                aVar2.n(j2);
            }
            a aVar3 = a.this;
            if (aVar3.f4444g) {
                aVar3.w();
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = a.this.p;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(mediaPlayer);
            }
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            a.this.f4441d.d(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    /* compiled from: NativeVideoDelegate */
    public enum c {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        COMPLETED
    }

    public a(Context context, AbstractC0112a aVar, c.b.a.a.j.g.a aVar2) {
        c cVar = c.IDLE;
        this.f4439b = cVar;
        this.f4440c = context;
        this.f4441d = aVar;
        this.f4442e = aVar2;
        g();
        this.f4439b = cVar;
    }

    public int a() {
        if (this.f4443f != null) {
            return this.f4446i;
        }
        return 0;
    }

    public long b() {
        if (!this.f4448k.S() || !i()) {
            return 0;
        }
        return (long) this.f4443f.getCurrentPosition();
    }

    public long c() {
        if (!this.f4448k.S() || !i()) {
            return 0;
        }
        return (long) this.f4443f.getDuration();
    }

    public float d() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f4443f.getPlaybackParams().getSpeed();
        }
        return 1.0f;
    }

    public float e() {
        return this.f4447j;
    }

    public c.b.a.a.j.c.b f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void g() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f4443f = mediaPlayer;
        mediaPlayer.setOnInfoListener(this.l);
        this.f4443f.setOnErrorListener(this.l);
        this.f4443f.setOnPreparedListener(this.l);
        this.f4443f.setOnCompletionListener(this.l);
        this.f4443f.setOnSeekCompleteListener(this.l);
        this.f4443f.setOnBufferingUpdateListener(this.l);
        this.f4443f.setOnVideoSizeChangedListener(this.l);
        this.f4443f.setAudioStreamType(3);
        this.f4443f.setScreenOnWhilePlaying(true);
    }

    public boolean h() {
        return i() && this.f4443f.isPlaying();
    }

    /* access modifiers changed from: protected */
    public boolean i() {
        c cVar = this.f4439b;
        return (cVar == c.ERROR || cVar == c.IDLE || cVar == c.PREPARING) ? false : true;
    }

    public void j(Surface surface) {
        this.f4443f.setSurface(surface);
        if (this.f4444g) {
            w();
        }
    }

    public void k(int i2, int i3) {
        if (this.f4443f != null && i2 > 0 && i3 > 0) {
            long j2 = this.f4445h;
            if (j2 != 0) {
                n(j2);
            }
            if (this.f4444g) {
                w();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void l(Uri uri) {
        if (uri != null) {
            this.f4446i = 0;
            try {
                this.f4443f.reset();
                this.f4443f.setDataSource(this.f4440c.getApplicationContext(), uri, this.f4438a);
                this.f4443f.prepareAsync();
                this.f4439b = c.PREPARING;
            } catch (IOException | IllegalArgumentException e2) {
                Log.w("ContentValues", "Unable to open content: " + uri, e2);
                this.f4439b = c.ERROR;
                this.l.onError(this.f4443f, 1, 0);
            }
        }
    }

    public void m() {
        if (i() && this.f4443f.isPlaying()) {
            this.f4443f.pause();
            this.f4439b = c.PAUSED;
        }
        this.f4444g = false;
    }

    public void n(long j2) {
        if (i()) {
            this.f4443f.seekTo((int) j2);
            this.f4445h = 0;
            return;
        }
        this.f4445h = j2;
    }

    public void o(c.b.a.a.j.a aVar) {
        this.f4448k = aVar;
        q(aVar);
        t(aVar);
        p(aVar);
        u(aVar);
        r(aVar);
    }

    public void p(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.o = onBufferingUpdateListener;
    }

    public void q(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.m = onCompletionListener;
    }

    public void r(MediaPlayer.OnErrorListener onErrorListener) {
        this.q = onErrorListener;
    }

    public void s(MediaPlayer.OnInfoListener onInfoListener) {
        this.r = onInfoListener;
    }

    public void t(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.n = onPreparedListener;
    }

    public void u(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.p = onSeekCompleteListener;
    }

    public void v(Uri uri, Map<String, String> map) {
        this.f4438a = map;
        this.f4445h = 0;
        this.f4444g = false;
        l(uri);
    }

    public void w() {
        if (i()) {
            this.f4443f.start();
            this.f4439b = c.PLAYING;
        }
        this.f4444g = true;
        this.f4448k.Z(false);
    }

    public void x(boolean z) {
        this.f4439b = c.IDLE;
        if (i()) {
            try {
                this.f4443f.stop();
            } catch (Exception e2) {
                Log.d("ContentValues", "stopPlayback: error calling mediaPlayer.stop()", e2);
            }
        }
        this.f4444g = false;
        if (z) {
            this.f4448k.R(this.f4442e);
        }
    }

    public void y() {
        this.f4439b = c.IDLE;
        try {
            this.f4443f.reset();
            this.f4443f.release();
        } catch (Exception e2) {
            Log.d("ContentValues", "stopPlayback: error calling mediaPlayer.reset() or mediaPlayer.release()", e2);
        }
        this.f4444g = false;
    }
}
