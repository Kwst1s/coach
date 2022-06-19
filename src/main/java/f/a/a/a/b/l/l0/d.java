package f.a.a.a.b.l.l0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.SubtitleView;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.File;
import java.io.IOException;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_familyAudio_video_tool */
public class d extends vainstrum.Components.b implements View.OnClickListener, SurfaceHolder.Callback, SeekBar.OnSeekBarChangeListener {
    private Act_manage c0;
    private Button d0;
    private FABTracking e0;
    private AppCompatSeekBar f0;
    private TextView g0;
    private TextView h0;
    private SubtitleView i0;
    private RelativeLayout j0;
    private SurfaceView k0;
    private SurfaceHolder l0;
    private int m0 = 0;
    private Handler n0;
    private Runnable o0;
    private MediaPlayer p0;
    private boolean q0 = false;
    private boolean r0 = true;
    private b0 s0;
    private b0 t0;
    private a0 u0;
    private int v0;
    private String w0;
    private BroadcastReceiver x0;

    /* compiled from: Frag_tool_familyAudio_video_tool */
    class a extends View.AccessibilityDelegate {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && d.this.p0 != null) {
                d.this.h0.setContentDescription(s.h(d.this.n(), (long) d.this.p0.getDuration(), (long) d.this.p0.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_tool_familyAudio_video_tool */
    class b extends View.AccessibilityDelegate {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && d.this.p0 != null) {
                d.this.g0.setContentDescription(s.l(d.this.n(), (long) d.this.p0.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_tool_familyAudio_video_tool */
    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (d.this.v0 == -1) {
                d.this.c0.finish();
            } else {
                d.this.c0.W(h.W1(d.this.s0, d.this.u0, d.this.v0, d.this.w0), d.this.Q(R.string.distress_meter));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.l.l0.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_tool_familyAudio_video_tool */
    public class C0208d implements MediaPlayer.OnPreparedListener {
        C0208d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            int i2;
            int i3;
            float videoWidth = ((float) d.this.p0.getVideoWidth()) / ((float) d.this.p0.getVideoHeight());
            int width = d.this.k0.getWidth();
            int height = d.this.k0.getHeight();
            if (d.this.t0.d() == 5) {
                double d2 = (double) width;
                Double.isNaN(d2);
                i3 = (int) (d2 / 1.5d);
                double d3 = (double) height;
                Double.isNaN(d3);
                i2 = (int) (d3 / 1.5d);
            } else {
                i3 = width / 1;
                i2 = height / 1;
            }
            float f2 = (float) i3;
            float f3 = (float) i2;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.k0.getLayoutParams();
            if (videoWidth > f2 / f3) {
                layoutParams.width = i3;
                layoutParams.height = (int) (f2 / videoWidth);
                layoutParams.addRule(13);
            } else {
                layoutParams.width = (int) (videoWidth * f3);
                layoutParams.height = i2;
                layoutParams.addRule(13);
            }
            d.this.k0.setLayoutParams(layoutParams);
            d.this.p0.seekTo(d.this.m0);
            d.this.q0 = true;
            d.this.i0.setPlayer(mediaPlayer);
            if (d.this.t0.d() == 5) {
                d.this.i0.j(R.raw.sub_deep_breathing, "application/x-subrip");
            } else {
                d.this.i0.j(R.raw.sub_muscle_relaxation, "application/x-subrip");
            }
            d.this.o2();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_video_tool */
    public class e implements MediaPlayer.OnCompletionListener {
        e() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            d.this.e0.setTrackingId("29521");
            d.this.e0.setImageResource(R.drawable.icon_play_white);
            d.this.e0.setContentDescription(d.this.Q(R.string.only_play_video));
            d.this.e0.sendAccessibilityEvent(4);
            d.this.f0.setProgress(d.this.f0.getMax());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_video_tool */
    public class f implements MediaPlayer.OnErrorListener {
        f() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(d.this.n(), d.this.Q(R.string.this_file_cant_be_played), 1).show();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_video_tool */
    public class g implements Runnable {
        g() {
        }

        public void run() {
            if (d.this.p0 != null && d.this.q0) {
                try {
                    d.this.h0.setText(s.j((long) d.this.p0.getDuration(), (long) d.this.p0.getCurrentPosition()));
                    d.this.g0.setText(s.k((long) d.this.p0.getCurrentPosition()));
                    d.this.f0.setContentDescription(d.this.Q(R.string.time_seekbar));
                    d.this.f0.setProgress(d.this.p0.getCurrentPosition() / 1000);
                } catch (Exception unused) {
                }
            }
            d.this.n0.postDelayed(this, 1000);
        }
    }

    public static d p2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        dVar.v1(bundle);
        return dVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.x0);
        MediaPlayer mediaPlayer = this.p0;
        if (mediaPlayer != null) {
            this.m0 = mediaPlayer.getCurrentPosition();
            if (this.p0.isPlaying()) {
                this.p0.stop();
            }
            this.p0.release();
            this.p0 = null;
            this.q0 = false;
            this.e0.setTrackingId("29521");
            this.e0.setImageResource(R.drawable.icon_play_white);
            this.e0.setContentDescription(Q(R.string.only_play_video));
            this.e0.announceForAccessibility(Q(R.string.only_play_video));
            this.k0.setVisibility(8);
        }
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.x0 = new c();
        try {
            n().registerReceiver(this.x0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        this.k0.setVisibility(0);
        if (this.r0) {
            this.i0.setUserVisible(true);
        } else {
            this.i0.setUserVisible(false);
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.s0);
        bundle.putSerializable("selected_tool", this.t0);
        bundle.putSerializable("symptom", this.u0);
        bundle.putInt("old_distress", this.v0);
        bundle.putString("last_tool_name", this.w0);
        super.K0(bundle);
    }

    public void n2() {
        String str;
        File file;
        String str2;
        try {
            if (this.t0.d() != 5) {
                this.j0.setBackgroundResource(17170444);
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.p0 = mediaPlayer;
            mediaPlayer.setOnPreparedListener(new C0208d());
            this.p0.setOnCompletionListener(new e());
            this.p0.setOnErrorListener(new f());
            this.p0.setScreenOnWhilePlaying(true);
            this.p0.setDisplay(this.l0);
            if (gov.va.mobilehealth.ncptsd.covid.CComp.b0.a(n()).equals("es")) {
                File externalFilesDir = n().getExternalFilesDir(null);
                if (this.t0.d() == 5) {
                    file = new File(externalFilesDir, "Deep-Breathing.mp4");
                } else {
                    file = new File(externalFilesDir, "Muscle-Relaxation.mp4");
                }
                if (file.exists()) {
                    this.p0.setDataSource(n(), Uri.fromFile(file));
                } else {
                    if (this.t0.d() == 5) {
                        str2 = "android.resource://" + n().getPackageName() + "/" + R.raw.deep_breathing;
                    } else {
                        str2 = "android.resource://" + n().getPackageName() + "/" + R.raw.muscle_relaxation;
                    }
                    this.p0.setDataSource(n(), Uri.parse(str2));
                }
            } else {
                if (this.t0.d() == 5) {
                    str = "android.resource://" + n().getPackageName() + "/" + R.raw.deep_breathing;
                } else {
                    str = "android.resource://" + n().getPackageName() + "/" + R.raw.muscle_relaxation;
                }
                this.p0.setDataSource(n(), Uri.parse(str));
            }
            this.p0.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.s0 = (b0) bundle.getSerializable("tool");
            this.t0 = (b0) bundle.getSerializable("selected_tool");
            this.u0 = (a0) bundle.getSerializable("symptom");
            this.v0 = bundle.getInt("old_distress");
            this.w0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.s0 = (b0) u().getSerializable("tool");
            this.t0 = (b0) u().getSerializable("selected_tool");
            this.u0 = (a0) u().getSerializable("symptom");
            this.v0 = u().getInt("old_distress");
            this.w0 = u().getString("last_tool_name");
        }
    }

    public void o2() {
        this.f0.setMax(this.p0.getDuration() / 1000);
        this.n0 = new Handler();
        this.o0 = new g();
        n().runOnUiThread(this.o0);
    }

    public void onClick(View view) {
        MediaPlayer mediaPlayer;
        if (view.getId() == this.e0.getId() && (mediaPlayer = this.p0) != null) {
            if (mediaPlayer.isPlaying()) {
                this.p0.pause();
                this.e0.setTrackingId("29521");
                this.e0.setImageResource(R.drawable.icon_play_white);
                this.e0.setContentDescription(Q(R.string.only_play_video));
                this.e0.announceForAccessibility(Q(R.string.only_play_video));
            } else {
                this.p0.start();
                this.e0.setTrackingId("30017");
                this.e0.setImageResource(R.drawable.icon_pause_white);
                this.e0.setContentDescription(Q(R.string.only_pause_video));
                this.e0.announceForAccessibility(Q(R.string.only_pause_video));
            }
        }
        if (view.getId() == this.d0.getId()) {
            m.c0(true, this.c0, this.u0, this.s0, this.v0);
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        MediaPlayer mediaPlayer = this.p0;
        if (mediaPlayer != null && z) {
            mediaPlayer.seekTo(i2 * 1000);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_family_audio_video_tool, viewGroup, false);
        this.d0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.k0 = (SurfaceView) inflate.findViewById(R.id.video_tool_sview);
        this.e0 = (FABTracking) inflate.findViewById(R.id.video_tool_fab_play_pause);
        this.f0 = (AppCompatSeekBar) inflate.findViewById(R.id.video_tool_seekbar);
        this.g0 = (TextView) inflate.findViewById(R.id.video_tool_txt_time_passed);
        this.h0 = (TextView) inflate.findViewById(R.id.video_tool_txt_time_remaining);
        this.i0 = (SubtitleView) inflate.findViewById(R.id.video_tool_subtitle_view);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.video_tool_layout_top);
        this.j0 = relativeLayout;
        relativeLayout.getLayoutParams().height = j.r(n()) - j.y(n());
        if (this.u0 == null) {
            this.d0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnSeekBarChangeListener(this);
        this.h0.setAccessibilityDelegate(new a());
        this.g0.setAccessibilityDelegate(new b());
        SurfaceHolder holder = this.k0.getHolder();
        this.l0 = holder;
        holder.addCallback(this);
        return inflate;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        n2();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.p0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.p0.stop();
                this.p0.release();
            }
            this.k0.destroyDrawingCache();
        }
        Handler handler = this.n0;
        if (!(handler == null || (runnable = this.o0) == null)) {
            handler.removeCallbacks(runnable);
        }
        super.t0();
    }
}
