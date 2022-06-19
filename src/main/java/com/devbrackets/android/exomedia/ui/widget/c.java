package com.devbrackets.android.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import c.b.a.a.k.g;
import c.b.a.a.k.h;
import com.devbrackets.android.exomedia.ui.widget.a;
import com.github.mikephil.charting.utils.Utils;

@TargetApi(21)
/* compiled from: VideoControlsLeanback */
public class c extends a {
    protected ProgressBar B;
    protected ImageView C;
    protected ViewGroup D;
    protected ImageButton E;
    protected ImageButton F;
    protected View G;
    protected View$OnFocusChangeListenerC0114c H = new View$OnFocusChangeListenerC0114c();

    /* compiled from: VideoControlsLeanback */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            c.this.B();
        }
    }

    /* compiled from: VideoControlsLeanback */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            c.this.A();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: com.devbrackets.android.exomedia.ui.widget.c$c  reason: collision with other inner class name */
    /* compiled from: VideoControlsLeanback */
    public class View$OnFocusChangeListenerC0114c implements View.OnFocusChangeListener {
        protected View$OnFocusChangeListenerC0114c() {
        }

        /* access modifiers changed from: protected */
        public int a(View view) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            c.this.C.getLocationOnScreen(iArr);
            return (i2 - ((c.this.C.getWidth() - view.getWidth()) / 2)) - iArr[0];
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                c.this.C.startAnimation(new f(a(view)));
            }
        }
    }

    /* compiled from: VideoControlsLeanback */
    protected class d extends a.f {
        protected d() {
            super();
        }

        @Override // com.devbrackets.android.exomedia.ui.widget.a.f, c.b.a.a.k.g
        public boolean d() {
            VideoView videoView = c.this.q;
            if (videoView == null) {
                return false;
            }
            long currentPosition = videoView.getCurrentPosition() - 10000;
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            c.this.C(currentPosition);
            return true;
        }

        @Override // com.devbrackets.android.exomedia.ui.widget.a.f, c.b.a.a.k.g
        public boolean f() {
            VideoView videoView = c.this.q;
            if (videoView == null) {
                return false;
            }
            long currentPosition = videoView.getCurrentPosition() + 10000;
            if (currentPosition > ((long) c.this.B.getMax())) {
                currentPosition = (long) c.this.B.getMax();
            }
            c.this.C(currentPosition);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: VideoControlsLeanback */
    public class e implements View.OnKeyListener {
        protected e() {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if (i2 == 4) {
                c cVar = c.this;
                if (cVar.y && cVar.z && !cVar.x) {
                    cVar.i();
                    return true;
                } else if (cVar.D.getAnimation() != null) {
                    return true;
                }
            } else if (i2 == 85) {
                c.this.n();
                return true;
            } else if (i2 == 126) {
                VideoView videoView = c.this.q;
                if (videoView != null && !videoView.d()) {
                    c.this.q.n();
                    return true;
                }
            } else if (i2 != 127) {
                switch (i2) {
                    case 19:
                        c.this.E();
                        return true;
                    case 20:
                        c.this.i();
                        return true;
                    case 21:
                        c.this.E();
                        c cVar2 = c.this;
                        cVar2.z(cVar2.G);
                        return true;
                    case 22:
                        c.this.E();
                        c cVar3 = c.this;
                        cVar3.y(cVar3.G);
                        return true;
                    case 23:
                        c.this.E();
                        c.this.G.callOnClick();
                        return true;
                    default:
                        switch (i2) {
                            case 87:
                                c.this.m();
                                return true;
                            case 88:
                                c.this.o();
                                return true;
                            case 89:
                                c.this.B();
                                return true;
                            case 90:
                                c.this.A();
                                return true;
                        }
                }
            } else {
                VideoView videoView2 = c.this.q;
                if (videoView2 != null && videoView2.d()) {
                    c.this.q.f();
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: VideoControlsLeanback */
    public class f extends TranslateAnimation implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        protected int f4505b;

        public f(int i2) {
            super(Utils.FLOAT_EPSILON, (float) i2, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
            this.f4505b = i2;
            setDuration(250);
            setAnimationListener(this);
        }

        public void onAnimationEnd(Animation animation) {
            ImageView imageView = c.this.C;
            imageView.setX(imageView.getX() + ((float) this.f4505b));
            c.this.C.clearAnimation();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public c(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void A() {
        g gVar = this.s;
        if (gVar == null || !gVar.f()) {
            this.u.f();
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        g gVar = this.s;
        if (gVar == null || !gVar.d()) {
            this.u.d();
        }
    }

    /* access modifiers changed from: protected */
    public void C(long j2) {
        h hVar = this.r;
        if (hVar == null || !hVar.a(j2)) {
            a();
            this.u.a(j2);
        }
    }

    /* access modifiers changed from: protected */
    public void D() {
        e eVar = new e();
        setOnKeyListener(eVar);
        this.f4488g.setOnKeyListener(eVar);
        this.f4489h.setOnKeyListener(eVar);
        this.f4490i.setOnKeyListener(eVar);
        this.F.setOnKeyListener(eVar);
        this.E.setOnKeyListener(eVar);
    }

    /* access modifiers changed from: protected */
    public void E() {
        a();
        VideoView videoView = this.q;
        if (videoView != null && videoView.d()) {
            j();
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void b(boolean z) {
        if (!this.x) {
            this.x = true;
            this.f4492k.setVisibility(8);
            this.C.setVisibility(8);
            this.f4491j.setVisibility(0);
            a();
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void c() {
        if (this.x) {
            boolean z = false;
            this.x = false;
            this.f4492k.setVisibility(0);
            this.C.setVisibility(0);
            this.f4491j.setVisibility(8);
            VideoView videoView = this.q;
            if (videoView != null && videoView.d()) {
                z = true;
            }
            g(z);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public int getLayoutResource() {
        return c.b.a.a.h.exomedia_default_controls_leanback;
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void h(boolean z) {
        if (this.y != z) {
            if (!this.x) {
                this.D.startAnimation(new c.b.a.a.l.a.a(this.D, z, 300));
            }
            this.y = z;
            p();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4488g.requestFocus();
        this.G = this.f4488g;
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void q() {
        super.q();
        this.F.setOnClickListener(new a());
        this.E.setOnClickListener(new b());
        this.f4489h.setOnFocusChangeListener(this.H);
        this.F.setOnFocusChangeListener(this.H);
        this.f4488g.setOnFocusChangeListener(this.H);
        this.E.setOnFocusChangeListener(this.H);
        this.f4490i.setOnFocusChangeListener(this.H);
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void r() {
        super.r();
        this.B = (ProgressBar) findViewById(c.b.a.a.g.exomedia_controls_video_progress);
        this.F = (ImageButton) findViewById(c.b.a.a.g.exomedia_controls_rewind_btn);
        this.E = (ImageButton) findViewById(c.b.a.a.g.exomedia_controls_fast_forward_btn);
        this.C = (ImageView) findViewById(c.b.a.a.g.exomedia_controls_leanback_ripple);
        this.D = (ViewGroup) findViewById(c.b.a.a.g.exomedia_controls_parent);
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void s() {
        t(c.b.a.a.e.exomedia_default_controls_leanback_button_selector);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a, com.devbrackets.android.exomedia.ui.widget.b
    public void setDuration(long j2) {
        if (j2 != ((long) this.B.getMax())) {
            this.f4484c.setText(c.b.a.a.m.f.a(j2));
            this.B.setMax((int) j2);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setFastForwardButtonEnabled(boolean z) {
        ImageButton imageButton = this.E;
        if (imageButton != null) {
            imageButton.setEnabled(z);
            this.v.put(c.b.a.a.g.exomedia_controls_fast_forward_btn, z);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setFastForwardButtonRemoved(boolean z) {
        ImageButton imageButton = this.E;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setFastForwardDrawable(Drawable drawable) {
        ImageButton imageButton = this.E;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setPosition(long j2) {
        this.f4483b.setText(c.b.a.a.m.f.a(j2));
        this.B.setProgress((int) j2);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setRewindButtonEnabled(boolean z) {
        ImageButton imageButton = this.F;
        if (imageButton != null) {
            imageButton.setEnabled(z);
            this.v.put(c.b.a.a.g.exomedia_controls_rewind_btn, z);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setRewindButtonRemoved(boolean z) {
        ImageButton imageButton = this.F;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setRewindDrawable(Drawable drawable) {
        ImageButton imageButton = this.F;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setup(Context context) {
        super.setup(context);
        this.u = new d();
        D();
        setFocusable(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void t(int i2) {
        super.t(i2);
        this.F.setImageDrawable(c.b.a.a.m.d.c(getContext(), c.b.a.a.f.exomedia_ic_rewind_white, i2));
        this.E.setImageDrawable(c.b.a.a.m.d.c(getContext(), c.b.a.a.f.exomedia_ic_fast_forward_white, i2));
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void w(long j2, long j3, int i2) {
        ProgressBar progressBar = this.B;
        progressBar.setSecondaryProgress((int) (((float) progressBar.getMax()) * (((float) i2) / 100.0f)));
        this.B.setProgress((int) j2);
        this.f4483b.setText(c.b.a.a.m.f.a(j2));
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void x() {
        if (this.y) {
            boolean l = l();
            if (this.A && l && this.l.getVisibility() == 0) {
                this.l.clearAnimation();
                this.l.startAnimation(new c.b.a.a.l.a.a(this.l, false, 300));
            } else if ((!this.A || !l) && this.l.getVisibility() != 0) {
                this.l.clearAnimation();
                this.l.startAnimation(new c.b.a.a.l.a.a(this.l, true, 300));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void y(View view) {
        int nextFocusRightId = view.getNextFocusRightId();
        if (nextFocusRightId != -1) {
            View findViewById = findViewById(nextFocusRightId);
            if (findViewById.getVisibility() != 0) {
                y(findViewById);
                return;
            }
            findViewById.requestFocus();
            this.G = findViewById;
            this.H.onFocusChange(findViewById, true);
        }
    }

    /* access modifiers changed from: protected */
    public void z(View view) {
        int nextFocusLeftId = view.getNextFocusLeftId();
        if (nextFocusLeftId != -1) {
            View findViewById = findViewById(nextFocusLeftId);
            if (findViewById.getVisibility() != 0) {
                z(findViewById);
                return;
            }
            findViewById.requestFocus();
            this.G = findViewById;
            this.H.onFocusChange(findViewById, true);
        }
    }
}
