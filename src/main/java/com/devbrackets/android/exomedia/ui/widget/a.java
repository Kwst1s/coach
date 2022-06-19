package com.devbrackets.android.exomedia.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.b.a.a.k.g;
import c.b.a.a.k.h;
import c.b.a.a.k.i;
import c.b.a.a.m.c;
import java.util.LinkedList;
import java.util.List;

/* compiled from: VideoControls */
public abstract class a extends RelativeLayout implements b {
    protected boolean A = true;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f4483b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f4484c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f4485d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f4486e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f4487f;

    /* renamed from: g  reason: collision with root package name */
    protected ImageButton f4488g;

    /* renamed from: h  reason: collision with root package name */
    protected ImageButton f4489h;

    /* renamed from: i  reason: collision with root package name */
    protected ImageButton f4490i;

    /* renamed from: j  reason: collision with root package name */
    protected ProgressBar f4491j;

    /* renamed from: k  reason: collision with root package name */
    protected ViewGroup f4492k;
    protected ViewGroup l;
    protected Drawable m;
    protected Drawable n;
    protected Handler o = new Handler();
    protected c.b.a.a.m.c p = new c.b.a.a.m.c();
    protected VideoView q;
    protected h r;
    protected g s;
    protected i t;
    protected f u = new f();
    protected SparseBooleanArray v = new SparseBooleanArray();
    protected long w = 2000;
    protected boolean x = false;
    protected boolean y = true;
    protected boolean z = true;

    /* renamed from: com.devbrackets.android.exomedia.ui.widget.a$a  reason: collision with other inner class name */
    /* compiled from: VideoControls */
    class C0113a implements c.b {
        C0113a() {
        }

        @Override // c.b.a.a.m.c.b
        public void a() {
            a.this.v();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoControls */
    public class b implements Runnable {
        b() {
        }

        public void run() {
            a.this.i();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoControls */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            a.this.n();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoControls */
    public class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            a.this.o();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VideoControls */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            a.this.m();
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: VideoControls */
    public class f implements h, g {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f4498a = false;

        protected f() {
        }

        @Override // c.b.a.a.k.h
        public boolean a(long j2) {
            VideoView videoView = a.this.q;
            if (videoView == null) {
                return false;
            }
            videoView.k(j2);
            if (!this.f4498a) {
                return true;
            }
            this.f4498a = false;
            a.this.q.n();
            a.this.j();
            return true;
        }

        @Override // c.b.a.a.k.g
        public boolean b() {
            VideoView videoView = a.this.q;
            if (videoView == null) {
                return false;
            }
            if (videoView.d()) {
                a.this.q.f();
                return true;
            }
            a.this.q.n();
            return true;
        }

        @Override // c.b.a.a.k.g
        public boolean c() {
            return false;
        }

        @Override // c.b.a.a.k.g
        public boolean d() {
            return false;
        }

        @Override // c.b.a.a.k.g
        public boolean e() {
            return false;
        }

        @Override // c.b.a.a.k.g
        public boolean f() {
            return false;
        }

        @Override // c.b.a.a.k.h
        public boolean g() {
            VideoView videoView = a.this.q;
            if (videoView == null) {
                return false;
            }
            if (videoView.d()) {
                this.f4498a = true;
                a.this.q.g(true);
            }
            a.this.a();
            return true;
        }
    }

    public a(Context context) {
        super(context);
        setup(context);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void a() {
        this.o.removeCallbacksAndMessages(null);
        clearAnimation();
        h(true);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void d(VideoView videoView) {
        videoView.removeView(this);
        setVideoView(null);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void e(VideoView videoView) {
        videoView.addView(this);
        setVideoView(videoView);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void f(boolean z2) {
        if (z2) {
            j();
        } else {
            i();
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void g(boolean z2) {
        u(z2);
        this.p.c();
        if (z2) {
            j();
        } else {
            a();
        }
    }

    public List<View> getExtraViews() {
        return new LinkedList();
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutResource();

    /* access modifiers changed from: protected */
    public abstract void h(boolean z2);

    public void i() {
        if (this.z && !this.x) {
            this.o.removeCallbacksAndMessages(null);
            clearAnimation();
            h(false);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public boolean isVisible() {
        return this.y;
    }

    public void j() {
        k(this.w);
    }

    public void k(long j2) {
        this.w = j2;
        if (j2 >= 0 && this.z && !this.x) {
            this.o.postDelayed(new b(), j2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        if (this.f4485d.getText() != null && this.f4485d.getText().length() > 0) {
            return false;
        }
        if (this.f4486e.getText() != null && this.f4486e.getText().length() > 0) {
            return false;
        }
        if (this.f4487f.getText() == null || this.f4487f.getText().length() <= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void m() {
        g gVar = this.s;
        if (gVar == null || !gVar.e()) {
            this.u.e();
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        g gVar = this.s;
        if (gVar == null || !gVar.b()) {
            this.u.b();
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        g gVar = this.s;
        if (gVar == null || !gVar.c()) {
            this.u.c();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p.a(new C0113a());
        VideoView videoView = this.q;
        if (videoView != null && videoView.d()) {
            g(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.p.d();
        this.p.a(null);
    }

    /* access modifiers changed from: protected */
    public void p() {
        i iVar = this.t;
        if (iVar != null) {
            if (this.y) {
                iVar.b();
            } else {
                iVar.a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        this.f4488g.setOnClickListener(new c());
        this.f4489h.setOnClickListener(new d());
        this.f4490i.setOnClickListener(new e());
    }

    /* access modifiers changed from: protected */
    public void r() {
        this.f4483b = (TextView) findViewById(c.b.a.a.g.exomedia_controls_current_time);
        this.f4484c = (TextView) findViewById(c.b.a.a.g.exomedia_controls_end_time);
        this.f4485d = (TextView) findViewById(c.b.a.a.g.exomedia_controls_title);
        this.f4486e = (TextView) findViewById(c.b.a.a.g.exomedia_controls_sub_title);
        this.f4487f = (TextView) findViewById(c.b.a.a.g.exomedia_controls_description);
        this.f4488g = (ImageButton) findViewById(c.b.a.a.g.exomedia_controls_play_pause_btn);
        this.f4489h = (ImageButton) findViewById(c.b.a.a.g.exomedia_controls_previous_btn);
        this.f4490i = (ImageButton) findViewById(c.b.a.a.g.exomedia_controls_next_btn);
        this.f4491j = (ProgressBar) findViewById(c.b.a.a.g.exomedia_controls_video_loading);
        this.f4492k = (ViewGroup) findViewById(c.b.a.a.g.exomedia_controls_interactive_container);
        this.l = (ViewGroup) findViewById(c.b.a.a.g.exomedia_controls_text_container);
    }

    /* access modifiers changed from: protected */
    public void s() {
        t(c.b.a.a.e.exomedia_default_controls_button_selector);
    }

    public void setButtonListener(g gVar) {
        this.s = gVar;
    }

    public void setCanHide(boolean z2) {
        this.z = z2;
    }

    public void setDescription(CharSequence charSequence) {
        this.f4487f.setText(charSequence);
        x();
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public abstract /* synthetic */ void setDuration(long j2);

    public void setFastForwardButtonEnabled(boolean z2) {
    }

    public void setFastForwardButtonRemoved(boolean z2) {
    }

    public void setFastForwardDrawable(Drawable drawable) {
    }

    public void setHideDelay(long j2) {
        this.w = j2;
    }

    public void setHideEmptyTextContainer(boolean z2) {
        this.A = z2;
        x();
    }

    public void setNextButtonEnabled(boolean z2) {
        this.f4490i.setEnabled(z2);
        this.v.put(c.b.a.a.g.exomedia_controls_next_btn, z2);
    }

    public void setNextButtonRemoved(boolean z2) {
        this.f4490i.setVisibility(z2 ? 8 : 0);
    }

    public void setNextDrawable(Drawable drawable) {
        this.f4490i.setImageDrawable(drawable);
    }

    public abstract void setPosition(long j2);

    public void setPreviousButtonEnabled(boolean z2) {
        this.f4489h.setEnabled(z2);
        this.v.put(c.b.a.a.g.exomedia_controls_previous_btn, z2);
    }

    public void setPreviousButtonRemoved(boolean z2) {
        this.f4489h.setVisibility(z2 ? 8 : 0);
    }

    public void setPreviousDrawable(Drawable drawable) {
        this.f4489h.setImageDrawable(drawable);
    }

    public void setRewindButtonEnabled(boolean z2) {
    }

    public void setRewindButtonRemoved(boolean z2) {
    }

    public void setRewindDrawable(Drawable drawable) {
    }

    public void setSeekListener(h hVar) {
        this.r = hVar;
    }

    public void setSubTitle(CharSequence charSequence) {
        this.f4486e.setText(charSequence);
        x();
    }

    public void setTitle(CharSequence charSequence) {
        this.f4485d.setText(charSequence);
        x();
    }

    @Deprecated
    public void setVideoView(VideoView videoView) {
        this.q = videoView;
    }

    public void setVisibilityListener(i iVar) {
        this.t = iVar;
    }

    /* access modifiers changed from: protected */
    public void setup(Context context) {
        View.inflate(context, getLayoutResource(), this);
        r();
        q();
        s();
    }

    /* access modifiers changed from: protected */
    public void t(int i2) {
        this.m = c.b.a.a.m.d.c(getContext(), c.b.a.a.f.exomedia_ic_play_arrow_white, i2);
        this.n = c.b.a.a.m.d.c(getContext(), c.b.a.a.f.exomedia_ic_pause_white, i2);
        this.f4488g.setImageDrawable(this.m);
        this.f4489h.setImageDrawable(c.b.a.a.m.d.c(getContext(), c.b.a.a.f.exomedia_ic_skip_previous_white, i2));
        this.f4490i.setImageDrawable(c.b.a.a.m.d.c(getContext(), c.b.a.a.f.exomedia_ic_skip_next_white, i2));
    }

    public void u(boolean z2) {
        this.f4488g.setImageDrawable(z2 ? this.n : this.m);
    }

    /* access modifiers changed from: protected */
    public void v() {
        VideoView videoView = this.q;
        if (videoView != null) {
            w(videoView.getCurrentPosition(), this.q.getDuration(), this.q.getBufferPercentage());
        }
    }

    public abstract void w(long j2, long j3, int i2);

    /* access modifiers changed from: protected */
    public abstract void x();
}
