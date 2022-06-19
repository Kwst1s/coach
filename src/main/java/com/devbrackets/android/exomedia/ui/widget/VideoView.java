package com.devbrackets.android.exomedia.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.b.a.a.g;
import c.b.a.a.h;
import c.b.a.a.i;
import c.b.a.a.j.a;
import c.b.a.a.k.f;
import c.b.a.a.m.e;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.c0;
import java.util.Map;

public class VideoView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    protected b f4459b;

    /* renamed from: c  reason: collision with root package name */
    protected ImageView f4460c;

    /* renamed from: d  reason: collision with root package name */
    protected Uri f4461d;

    /* renamed from: e  reason: collision with root package name */
    protected c.b.a.a.j.b.a f4462e;

    /* renamed from: f  reason: collision with root package name */
    protected c.b.a.a.m.a f4463f = new c.b.a.a.m.a();

    /* renamed from: g  reason: collision with root package name */
    protected AudioManager f4464g;

    /* renamed from: h  reason: collision with root package name */
    protected b f4465h = new b();

    /* renamed from: i  reason: collision with root package name */
    protected long f4466i = 0;

    /* renamed from: j  reason: collision with root package name */
    protected long f4467j = -1;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f4468k = false;
    protected boolean l = true;
    protected e m = new e();
    protected c n = new c();
    protected c.b.a.a.j.a o;
    protected boolean p = true;
    protected boolean q = true;

    /* access modifiers changed from: protected */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4469a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4470b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f4471c;

        /* renamed from: d  reason: collision with root package name */
        public int f4472d;

        /* renamed from: e  reason: collision with root package name */
        public c.b.a.a.j.g.d.b f4473e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f4474f;

        public a(VideoView videoView, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes;
            int i2 = h.exomedia_default_exo_texture_video_view;
            this.f4471c = i2;
            int i3 = h.exomedia_default_native_texture_video_view;
            this.f4472d = i3;
            if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f3063a)) != null) {
                this.f4469a = obtainStyledAttributes.getBoolean(i.f3065c, this.f4469a);
                this.f4470b = obtainStyledAttributes.getBoolean(i.f3066d, this.f4470b);
                int i4 = i.f3067e;
                if (obtainStyledAttributes.hasValue(i4)) {
                    this.f4473e = c.b.a.a.j.g.d.b.a(obtainStyledAttributes.getInt(i4, -1));
                }
                int i5 = i.f3064b;
                if (obtainStyledAttributes.hasValue(i5)) {
                    this.f4474f = Boolean.valueOf(obtainStyledAttributes.getBoolean(i5, false));
                }
                boolean z = this.f4470b;
                i2 = !z ? h.exomedia_default_exo_surface_video_view : i2;
                this.f4471c = i2;
                this.f4472d = !z ? h.exomedia_default_native_surface_video_view : i3;
                this.f4471c = obtainStyledAttributes.getResourceId(i.f3068f, i2);
                this.f4472d = obtainStyledAttributes.getResourceId(i.f3069g, this.f4472d);
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f4475a = false;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f4476b = false;

        /* renamed from: c  reason: collision with root package name */
        protected int f4477c = 0;

        protected b() {
        }

        public boolean a() {
            VideoView videoView = VideoView.this;
            if (!videoView.q) {
                return true;
            }
            AudioManager audioManager = videoView.f4464g;
            if (audioManager == null) {
                return false;
            }
            this.f4475a = false;
            if (1 == audioManager.abandonAudioFocus(this)) {
                return true;
            }
            return false;
        }

        public boolean b() {
            VideoView videoView = VideoView.this;
            if (!videoView.q || this.f4477c == 1) {
                return true;
            }
            AudioManager audioManager = videoView.f4464g;
            if (audioManager == null) {
                return false;
            }
            if (1 == audioManager.requestAudioFocus(this, 3, 1)) {
                this.f4477c = 1;
                return true;
            }
            this.f4475a = true;
            return false;
        }

        public void onAudioFocusChange(int i2) {
            VideoView videoView = VideoView.this;
            if (videoView.q && this.f4477c != i2) {
                this.f4477c = i2;
                if (i2 == -3 || i2 == -2) {
                    if (videoView.d()) {
                        this.f4476b = true;
                        VideoView.this.g(true);
                    }
                } else if (i2 != -1) {
                    if (i2 != 1 && i2 != 2) {
                        return;
                    }
                    if (this.f4475a || this.f4476b) {
                        videoView.n();
                        this.f4475a = false;
                        this.f4476b = false;
                    }
                } else if (videoView.d()) {
                    this.f4476b = true;
                    VideoView.this.f();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public class c extends a.c {

        /* renamed from: a  reason: collision with root package name */
        public f f4479a;

        protected c() {
        }

        @Override // c.b.a.a.j.a.c
        public void b(c.b.a.a.j.c.a aVar, Exception exc) {
            VideoView.this.o();
            if (aVar != null) {
                aVar.v();
            }
        }

        @Override // c.b.a.a.j.a.c
        public void c() {
            VideoView.this.setKeepScreenOn(false);
            VideoView.this.e();
        }

        @Override // c.b.a.a.j.a.c
        public void d() {
            VideoView videoView = VideoView.this;
            b bVar = videoView.f4459b;
            if (bVar != null) {
                bVar.setDuration(videoView.getDuration());
                VideoView.this.f4459b.c();
            }
        }

        @Override // c.b.a.a.j.a.c
        public void e(boolean z) {
            ImageView imageView = VideoView.this.f4460c;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
        }

        @Override // c.b.a.a.j.a.c
        public void f() {
            b bVar = VideoView.this.f4459b;
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // c.b.a.a.j.a.c
        public void g(int i2, int i3, int i4, float f2) {
            VideoView.this.f4462e.f(i4, false);
            VideoView.this.f4462e.b(i2, i3, f2);
            f fVar = this.f4479a;
            if (fVar != null) {
                fVar.b(i2, i3, f2);
            }
        }

        @Override // c.b.a.a.j.a.c
        public boolean h(long j2) {
            long currentPosition = VideoView.this.getCurrentPosition();
            long duration = VideoView.this.getDuration();
            return currentPosition > 0 && duration > 0 && currentPosition + j2 >= duration;
        }
    }

    /* access modifiers changed from: protected */
    public class d extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        protected GestureDetector f4481b;

        public d(Context context) {
            this.f4481b = new GestureDetector(context, this);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            b bVar = VideoView.this.f4459b;
            if (bVar == null || !bVar.isVisible()) {
                VideoView.this.m();
                return true;
            }
            VideoView.this.f4459b.f(false);
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4481b.onTouchEvent(motionEvent);
            return true;
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public int a(Context context, a aVar) {
        return this.f4463f.c(context) ^ true ? aVar.f4472d : aVar.f4471c;
    }

    /* access modifiers changed from: protected */
    public void b(Context context, a aVar) {
        View.inflate(context, h.exomedia_video_view_layout, this);
        ViewStub viewStub = (ViewStub) findViewById(g.video_view_api_impl_stub);
        viewStub.setLayoutResource(a(context, aVar));
        viewStub.inflate();
    }

    /* access modifiers changed from: protected */
    public void c(Context context, a aVar) {
        b(context, aVar);
        this.f4460c = (ImageView) findViewById(g.exomedia_video_preview_image);
        this.f4462e = (c.b.a.a.j.b.a) findViewById(g.exomedia_video_view);
        c cVar = new c();
        this.n = cVar;
        c.b.a.a.j.a aVar2 = new c.b.a.a.j.a(cVar);
        this.o = aVar2;
        this.f4462e.setListenerMux(aVar2);
    }

    public boolean d() {
        return this.f4462e.h();
    }

    /* access modifiers changed from: protected */
    public void e() {
        p(false);
    }

    public void f() {
        g(false);
    }

    public void g(boolean z) {
        if (!z) {
            this.f4465h.a();
        }
        this.f4462e.c();
        setKeepScreenOn(false);
        b bVar = this.f4459b;
        if (bVar != null) {
            bVar.g(false);
        }
    }

    public Map<c.b.a.a.d, c0> getAvailableTracks() {
        return this.f4462e.getAvailableTracks();
    }

    public Bitmap getBitmap() {
        c.b.a.a.j.b.a aVar = this.f4462e;
        if (aVar instanceof TextureView) {
            return ((TextureView) aVar).getBitmap();
        }
        return null;
    }

    public int getBufferPercentage() {
        return this.f4462e.getBufferedPercent();
    }

    public long getCurrentPosition() {
        long j2;
        long currentPosition;
        if (this.f4468k) {
            j2 = this.f4466i;
            currentPosition = this.m.a();
        } else {
            j2 = this.f4466i;
            currentPosition = this.f4462e.getCurrentPosition();
        }
        return j2 + currentPosition;
    }

    public long getDuration() {
        long j2 = this.f4467j;
        if (j2 >= 0) {
            return j2;
        }
        return this.f4462e.getDuration();
    }

    public float getPlaybackSpeed() {
        return this.f4462e.getPlaybackSpeed();
    }

    public ImageView getPreviewImageView() {
        return this.f4460c;
    }

    @Deprecated
    public a getVideoControls() {
        b bVar = this.f4459b;
        if (bVar == null || !(bVar instanceof a)) {
            return null;
        }
        return (a) bVar;
    }

    public b getVideoControlsCore() {
        return this.f4459b;
    }

    public Uri getVideoUri() {
        return this.f4461d;
    }

    public float getVolume() {
        return this.f4462e.getVolume();
    }

    public c.b.a.a.j.c.b getWindowInfo() {
        return this.f4462e.getWindowInfo();
    }

    /* access modifiers changed from: protected */
    public void h(a aVar) {
        if (aVar.f4469a) {
            setControls(this.f4463f.a(getContext()) ? new c(getContext()) : new d(getContext()));
        }
        c.b.a.a.j.g.d.b bVar = aVar.f4473e;
        if (bVar != null) {
            setScaleType(bVar);
        }
        Boolean bool = aVar.f4474f;
        if (bool != null) {
            setMeasureBasedOnAspectRatioEnabled(bool.booleanValue());
        }
    }

    public void i() {
        b bVar = this.f4459b;
        if (bVar != null) {
            bVar.d(this);
            this.f4459b = null;
        }
        o();
        this.m.d();
        this.f4462e.a();
    }

    public void j() {
        o();
        setVideoURI(null);
    }

    public void k(long j2) {
        b bVar = this.f4459b;
        if (bVar != null) {
            bVar.b(false);
        }
        this.f4462e.e(j2);
    }

    /* access modifiers changed from: protected */
    public void l(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            this.f4464g = (AudioManager) context.getApplicationContext().getSystemService("audio");
            a aVar = new a(this, context, attributeSet);
            c(context, aVar);
            h(aVar);
        }
    }

    public void m() {
        b bVar = this.f4459b;
        if (bVar != null) {
            bVar.a();
            if (d()) {
                this.f4459b.f(true);
            }
        }
    }

    public void n() {
        if (this.f4465h.b()) {
            this.f4462e.start();
            setKeepScreenOn(true);
            b bVar = this.f4459b;
            if (bVar != null) {
                bVar.g(true);
            }
        }
    }

    public void o() {
        p(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isInEditMode() && this.p) {
            i();
        }
    }

    /* access modifiers changed from: protected */
    public void p(boolean z) {
        this.f4465h.a();
        this.f4462e.g(z);
        setKeepScreenOn(false);
        b bVar = this.f4459b;
        if (bVar != null) {
            bVar.g(false);
        }
    }

    public void setAnalyticsListener(com.google.android.exoplayer2.c0.b bVar) {
        this.o.X(bVar);
    }

    public void setCaptionListener(c.b.a.a.j.d.a aVar) {
        this.f4462e.setCaptionListener(aVar);
    }

    @Deprecated
    public void setControls(a aVar) {
        setControls((b) aVar);
    }

    public void setDrmCallback(s sVar) {
        this.f4462e.setDrmCallback(sVar);
    }

    public void setHandleAudioFocus(boolean z) {
        this.f4465h.a();
        this.q = z;
    }

    public void setId3MetadataListener(c.b.a.a.j.d.d dVar) {
        this.o.Y(dVar);
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z) {
        this.f4462e.setMeasureBasedOnAspectRatioEnabled(z);
    }

    public void setOnBufferUpdateListener(c.b.a.a.k.a aVar) {
        this.o.b0(aVar);
    }

    public void setOnCompletionListener(c.b.a.a.k.b bVar) {
        this.o.c0(bVar);
    }

    public void setOnErrorListener(c.b.a.a.k.c cVar) {
        this.o.d0(cVar);
    }

    public void setOnPreparedListener(c.b.a.a.k.d dVar) {
        this.o.e0(dVar);
    }

    public void setOnSeekCompletionListener(c.b.a.a.k.e eVar) {
        this.o.f0(eVar);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f4462e.setOnTouchListener(onTouchListener);
        super.setOnTouchListener(onTouchListener);
    }

    public void setOnVideoSizedChangedListener(f fVar) {
        this.n.f4479a = fVar;
    }

    public void setOverridePositionMatchesPlaybackSpeed(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (z) {
                this.m.c(getPlaybackSpeed());
            } else {
                this.m.c(1.0f);
            }
        }
    }

    public void setPositionOffset(long j2) {
        this.f4466i = j2;
    }

    public void setPreviewImage(Drawable drawable) {
        ImageView imageView = this.f4460c;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setReleaseOnDetachFromWindow(boolean z) {
        this.p = z;
    }

    public void setRepeatMode(int i2) {
        this.f4462e.setRepeatMode(i2);
    }

    public void setScaleType(c.b.a.a.j.g.d.b bVar) {
        this.f4462e.setScaleType(bVar);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoRotation(int i2) {
        this.f4462e.f(i2, true);
    }

    public void setVideoURI(Uri uri) {
        this.f4461d = uri;
        this.f4462e.setVideoUri(uri);
        b bVar = this.f4459b;
        if (bVar != null) {
            bVar.b(true);
        }
    }

    public void setControls(b bVar) {
        b bVar2 = this.f4459b;
        if (!(bVar2 == null || bVar2 == bVar)) {
            bVar2.d(this);
        }
        this.f4459b = bVar;
        if (bVar != null) {
            bVar.e(this);
        }
        d dVar = new d(getContext());
        if (this.f4459b == null) {
            dVar = null;
        }
        setOnTouchListener(dVar);
    }

    public void setPreviewImage(int i2) {
        ImageView imageView = this.f4460c;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public void setPreviewImage(Bitmap bitmap) {
        ImageView imageView = this.f4460c;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setPreviewImage(Uri uri) {
        ImageView imageView = this.f4460c;
        if (imageView != null) {
            imageView.setImageURI(uri);
        }
    }
}
