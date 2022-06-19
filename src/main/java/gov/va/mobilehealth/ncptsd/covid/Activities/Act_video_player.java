package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.github.mikephil.charting.R;
import com.github.mikephil.charting.utils.Utils;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;

public class Act_video_player extends gov.va.mobilehealth.ncptsd.covid.CComp.f implements c.b.a.a.k.d, SeekBar.OnSeekBarChangeListener {
    private Handler A;
    private Runnable B;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private String F;
    private ImageView u;
    private LinearLayout v;
    private ImageView w;
    private SeekBar x;
    private AppCompatTextView y;
    private VideoView z;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Act_video_player.this.g0();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Act_video_player.this.finish();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            if (!Act_video_player.this.C) {
                return;
            }
            if (Act_video_player.this.z.d()) {
                Act_video_player.this.z.f();
                Act_video_player.this.w.setImageResource(R.drawable.icon_play);
                Act_video_player.this.w.setContentDescription(Act_video_player.this.getString(R.string.play_video_button));
                Act_video_player.this.w.announceForAccessibility(Act_video_player.this.getString(R.string.play_video_button));
                return;
            }
            Act_video_player.this.z.n();
            Act_video_player.this.w.setImageResource(R.drawable.icon_pause);
            Act_video_player.this.w.setContentDescription(Act_video_player.this.getString(R.string.pause_video_btn));
            Act_video_player.this.w.announceForAccessibility(Act_video_player.this.getString(R.string.pause_video_btn));
        }
    }

    class d extends View.AccessibilityDelegate {
        d() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && Act_video_player.this.z != null) {
                Act_video_player.this.y.setContentDescription(s.l(Act_video_player.this.getApplicationContext(), Act_video_player.this.z.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    class e implements c.b.a.a.k.b {
        e() {
        }

        @Override // c.b.a.a.k.b
        public void a() {
            Act_video_player.this.z.f();
            Act_video_player.this.z.j();
            Act_video_player.this.z.setVideoURI(Uri.parse(Act_video_player.this.F));
            Act_video_player.this.w.setImageResource(R.drawable.icon_play);
            Act_video_player.this.w.setContentDescription(Act_video_player.this.getString(R.string.play_video_button));
            Act_video_player.this.E = true;
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements Animator.AnimatorListener {
        f() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            Act_video_player.this.v.setVisibility(8);
            Act_video_player.this.z.setContentDescription(Act_video_player.this.getString(R.string.video_tap_to_show_commands));
            Act_video_player.this.z.announceForAccessibility(Act_video_player.this.getString(R.string.controls_hidden));
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: package-private */
    public class g implements Animator.AnimatorListener {
        g() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            Act_video_player.this.z.setContentDescription(Act_video_player.this.getString(R.string.video_tap_to_hide_commands));
            Act_video_player.this.z.announceForAccessibility(Act_video_player.this.getString(R.string.controls_shown));
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            Act_video_player.this.v.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public class h implements Runnable {
        h() {
        }

        public void run() {
            if (Act_video_player.this.z != null && Act_video_player.this.C) {
                try {
                    Act_video_player.this.y.setText(s.k(Act_video_player.this.z.getCurrentPosition()));
                    Act_video_player.this.x.setContentDescription(Act_video_player.this.getString(R.string.time_seekbar));
                    Act_video_player.this.x.setProgress((int) (Act_video_player.this.z.getCurrentPosition() / 1000));
                } catch (Exception unused) {
                }
            }
            Act_video_player.this.A.postDelayed(this, 1000);
        }
    }

    @Override // c.b.a.a.k.d
    public void a() {
        this.x.setMax((int) (this.z.getDuration() / 1000));
        f0();
        this.C = true;
        if (!this.E) {
            this.z.n();
            this.E = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void f0() {
        this.A = new Handler();
        h hVar = new h();
        this.B = hVar;
        runOnUiThread(hVar);
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("firstTime", this.D);
        setResult(-1, intent);
        super.finish();
    }

    public void g0() {
        if (this.v.getVisibility() == 0) {
            this.v.animate().alpha(Utils.FLOAT_EPSILON).setDuration(300).setListener(new f()).start();
        } else {
            this.v.animate().alpha(1.0f).setDuration(300).setListener(new g()).start();
        }
    }

    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 2) {
            this.u.setColorFilter(b.h.d.a.b(getApplicationContext(), 17170444));
        } else if (i2 == 1) {
            this.u.clearColorFilter();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.F = getIntent().getStringExtra("sUri");
        setContentView(R.layout.act_video_player);
        this.u = (ImageView) findViewById(R.id.video_player_img_back);
        this.v = (LinearLayout) findViewById(R.id.video_player_layout_controls);
        this.z = (VideoView) findViewById(R.id.video_player_videoview);
        this.w = (ImageView) findViewById(R.id.video_player_img_play_pause);
        this.x = (SeekBar) findViewById(R.id.video_player_seekbar);
        this.y = (AppCompatTextView) findViewById(R.id.video_player_timing);
        this.z.setOnClickListener(new a());
        this.u.setOnClickListener(new b());
        this.w.setOnClickListener(new c());
        this.y.setAccessibilityDelegate(new d());
        this.x.setOnSeekBarChangeListener(this);
        this.z.setOnPreparedListener(this);
        this.z.setOnCompletionListener(new e());
        this.z.setVideoURI(Uri.parse(this.F));
    }

    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        Runnable runnable;
        Handler handler = this.A;
        if (!(handler == null || (runnable = this.B) == null)) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        super.onPause();
        if (this.z.d()) {
            this.z.f();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        VideoView videoView = this.z;
        if (videoView != null && z2) {
            videoView.k((long) (i2 * 1000));
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
