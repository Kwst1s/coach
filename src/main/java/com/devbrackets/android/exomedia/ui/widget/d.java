package com.devbrackets.android.exomedia.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import c.b.a.a.g;
import c.b.a.a.k.h;
import c.b.a.a.m.f;
import java.util.LinkedList;
import java.util.List;

/* compiled from: VideoControlsMobile */
public class d extends a {
    protected SeekBar B;
    protected LinearLayout C;
    protected boolean D = false;

    /* compiled from: VideoControlsMobile */
    class a implements Runnable {
        a() {
        }

        public void run() {
            d.this.h(false);
        }
    }

    /* compiled from: VideoControlsMobile */
    protected class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private long f4508b;

        protected b() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                long j2 = (long) i2;
                this.f4508b = j2;
                TextView textView = d.this.f4483b;
                if (textView != null) {
                    textView.setText(f.a(j2));
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            d dVar = d.this;
            dVar.D = true;
            h hVar = dVar.r;
            if (hVar == null || !hVar.g()) {
                d.this.u.g();
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            d dVar = d.this;
            dVar.D = false;
            h hVar = dVar.r;
            if (hVar == null || !hVar.a(this.f4508b)) {
                d.this.u.a(this.f4508b);
            }
        }
    }

    public d(Context context) {
        super(context);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void b(boolean z) {
        if (!this.x) {
            this.x = true;
            this.f4491j.setVisibility(0);
            if (z) {
                this.f4492k.setVisibility(8);
            } else {
                this.f4488g.setEnabled(false);
                this.f4489h.setEnabled(false);
                this.f4490i.setEnabled(false);
            }
            a();
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void c() {
        if (this.x) {
            boolean z = false;
            this.x = false;
            this.f4491j.setVisibility(8);
            this.f4492k.setVisibility(0);
            this.f4488g.setEnabled(true);
            this.f4489h.setEnabled(this.v.get(g.exomedia_controls_previous_btn, true));
            this.f4490i.setEnabled(this.v.get(g.exomedia_controls_next_btn, true));
            VideoView videoView = this.q;
            if (videoView != null && videoView.d()) {
                z = true;
            }
            g(z);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public List<View> getExtraViews() {
        int childCount = this.C.getChildCount();
        if (childCount <= 0) {
            return super.getExtraViews();
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < childCount; i2++) {
            linkedList.add(this.C.getChildAt(i2));
        }
        return linkedList;
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public int getLayoutResource() {
        return c.b.a.a.h.exomedia_default_controls_mobile;
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void h(boolean z) {
        if (this.y != z) {
            if (!this.A || !l()) {
                this.l.startAnimation(new c.b.a.a.l.a.b(this.l, z, 300));
            }
            if (!this.x) {
                this.f4492k.startAnimation(new c.b.a.a.l.a.a(this.f4492k, z, 300));
            }
            this.y = z;
            p();
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void k(long j2) {
        this.w = j2;
        if (j2 >= 0 && this.z && !this.x && !this.D) {
            this.o.postDelayed(new a(), j2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void q() {
        super.q();
        this.B.setOnSeekBarChangeListener(new b());
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void r() {
        super.r();
        this.B = (SeekBar) findViewById(g.exomedia_controls_video_seek);
        this.C = (LinearLayout) findViewById(g.exomedia_controls_extra_container);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a, com.devbrackets.android.exomedia.ui.widget.b
    public void setDuration(long j2) {
        if (j2 != ((long) this.B.getMax())) {
            this.f4484c.setText(f.a(j2));
            this.B.setMax((int) j2);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setPosition(long j2) {
        this.f4483b.setText(f.a(j2));
        this.B.setProgress((int) j2);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void w(long j2, long j3, int i2) {
        if (!this.D) {
            SeekBar seekBar = this.B;
            seekBar.setSecondaryProgress((int) (((float) seekBar.getMax()) * (((float) i2) / 100.0f)));
            this.B.setProgress((int) j2);
            this.f4483b.setText(f.a(j2));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void x() {
        if (this.y) {
            boolean l = l();
            if (this.A && l && this.l.getVisibility() == 0) {
                this.l.clearAnimation();
                this.l.startAnimation(new c.b.a.a.l.a.b(this.l, false, 300));
            } else if ((!this.A || !l) && this.l.getVisibility() != 0) {
                this.l.clearAnimation();
                this.l.startAnimation(new c.b.a.a.l.a.b(this.l, true, 300));
            }
        }
    }
}
