package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.d.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Act_fullscreen_slideshow extends f {
    private ArrayList<m> A;
    private Handler B;
    private Runnable C;
    private boolean D = false;
    private ViewSwitcher u;
    private ImageView v;
    private ImageView w;
    private FloatingActionButton x;
    private int y = -1;
    private int z = -1;

    class a extends c.d.a.a {
        a(Context context) {
            super(context);
        }

        @Override // c.d.a.a
        public void a() {
            Act_fullscreen_slideshow.this.D = false;
            Act_fullscreen_slideshow.this.l0();
        }

        @Override // c.d.a.a
        public void e() {
            Act_fullscreen_slideshow.this.D = false;
            Act_fullscreen_slideshow.this.l0();
        }

        @Override // c.d.a.a
        public void f() {
            Act_fullscreen_slideshow.this.D = true;
            Act_fullscreen_slideshow.this.l0();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void Z() {
        this.D = false;
        l0();
        this.B.postDelayed(this.C, TimeUnit.SECONDS.toMillis((long) gov.va.mobilehealth.ncptsd.covid.CComp.m.B(getApplicationContext())));
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0() {
        runOnUiThread(new e(this));
    }

    public void X() {
        if (this.y == this.v.getId()) {
            this.y = this.w.getId();
            this.u.showNext();
            return;
        }
        this.y = this.v.getId();
        this.u.showPrevious();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void e0() {
        i0(this.w);
        ViewSwitcher viewSwitcher = this.u;
        viewSwitcher.announceForAccessibility(getString(R.string.image) + " " + Integer.toString(this.z + 1));
        ViewSwitcher viewSwitcher2 = this.u;
        viewSwitcher2.setContentDescription(getString(R.string.image) + " " + Integer.toString(this.z + 1));
        X();
    }

    public void f0() {
        this.B.removeCallbacks(this.C);
    }

    public void g0() {
        i0(this.v);
        ViewSwitcher viewSwitcher = this.u;
        viewSwitcher.announceForAccessibility(getString(R.string.image) + " " + Integer.toString(this.z + 1));
        ViewSwitcher viewSwitcher2 = this.u;
        viewSwitcher2.setContentDescription(getString(R.string.image) + " " + Integer.toString(this.z + 1));
        X();
    }

    public void h0() {
        this.B.removeCallbacks(this.C);
        this.B.postDelayed(this.C, TimeUnit.SECONDS.toMillis((long) gov.va.mobilehealth.ncptsd.covid.CComp.m.B(getApplicationContext())));
    }

    public void i0(ImageView imageView) {
        if (!this.D) {
            int i2 = this.z + 1;
            this.z = i2;
            if (i2 >= this.A.size()) {
                this.z = 0;
            }
        } else {
            int i3 = this.z - 1;
            this.z = i3;
            if (i3 == -1) {
                this.z = this.A.size() - 1;
            }
        }
        Uri c2 = this.A.get(this.z).c();
        if (j.I(this)) {
            if (gov.va.mobilehealth.ncptsd.covid.CComp.m.j0(c2)) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        } else if (gov.va.mobilehealth.ncptsd.covid.CComp.m.j0(c2)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageView.setImageURI(c2);
    }

    public void j0() {
        Animation animation;
        Animation animation2;
        int A2 = gov.va.mobilehealth.ncptsd.covid.CComp.m.A(getApplicationContext());
        if (A2 == 2) {
            animation2 = AnimationUtils.loadAnimation(this, R.anim.cross_fade_in);
            animation = AnimationUtils.loadAnimation(this, R.anim.cross_fade_out);
            animation2.setDuration(1000);
            animation.setDuration(1000);
        } else if (A2 != 3) {
            if (this.D) {
                animation2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_left_img);
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right_img);
            } else {
                animation2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right_img);
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left_img);
            }
            animation2.setDuration(500);
            animation.setDuration(500);
        } else {
            animation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            animation2.setDuration(500);
            animation.setDuration(500);
            animation2.setStartOffset(500);
        }
        this.u.setInAnimation(animation2);
        this.u.setOutAnimation(animation);
    }

    public void k0() {
        if (this.y == -1) {
            this.y = this.v.getId();
            i0(this.v);
        }
        this.B = new Handler();
        this.C = new g(this);
        h0();
        j0();
    }

    public void l0() {
        j0();
        if (this.y == this.v.getId()) {
            e0();
        } else {
            g0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        if (bundle == null) {
            this.z = getIntent().getIntExtra("curImgPos", 0) - 1;
        } else {
            this.z = bundle.getInt("curImgPos", 0) - 1;
        }
        this.A = new u(getApplicationContext()).r0(getApplicationContext(), true);
        getWindow().addFlags(128);
        setContentView(R.layout.act_fullscreen_slideshow);
        this.u = (ViewSwitcher) findViewById(R.id.fullscreen_viewswitcher);
        this.v = (ImageView) findViewById(R.id.fullscreen_img_slideshow_1);
        this.w = (ImageView) findViewById(R.id.fullscreen_img_slideshow_2);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fullscreen_btn_close);
        this.x = floatingActionButton;
        ((RelativeLayout.LayoutParams) floatingActionButton.getLayoutParams()).setMargins(0, j.v(getApplicationContext()), 0, 0);
        this.x.setOnClickListener(new f(this));
        this.u.setOnTouchListener(new a(this));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        f0();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        k0();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("curImgPos", this.z);
        super.onSaveInstanceState(bundle);
    }
}
