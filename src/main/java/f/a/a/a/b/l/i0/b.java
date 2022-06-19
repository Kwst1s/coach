package f.a.a.a.b.l.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.SubtitleView;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.File;
import java.io.IOException;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_seated_practice_instructions */
public class b extends vainstrum.Components.b implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Act_manage c0;
    private b0 d0;
    private b0 e0;
    private a0 f0;
    private int g0;
    private String h0;
    private ImageView i0;
    private RelativeLayout j0;
    private FABTracking k0;
    private AppCompatSeekBar l0;
    private TextView m0;
    private TextView n0;
    private SubtitleView o0;
    private MediaPlayer p0;
    private Handler q0;
    private Runnable r0;
    private boolean s0 = false;
    private BroadcastReceiver t0;
    private int u0;
    private String v0;

    /* compiled from: Frag_seated_practice_instructions */
    class a extends View.AccessibilityDelegate {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && b.this.p0 != null) {
                b.this.n0.setContentDescription(s.h(b.this.n(), (long) b.this.p0.getDuration(), (long) b.this.p0.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* renamed from: f.a.a.a.b.l.i0.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_seated_practice_instructions */
    class C0199b extends View.AccessibilityDelegate {
        C0199b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && b.this.p0 != null) {
                b.this.m0.setContentDescription(s.l(b.this.n(), (long) b.this.p0.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_seated_practice_instructions */
    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                if (b.this.p0 != null && b.this.p0.isPlaying()) {
                    b.this.p0.pause();
                }
                b.this.c0.W(d.v2(b.this.d0, b.this.e0, b.this.f0, b.this.g0, b.this.h0, b.this.u0, b.this.v0), b.this.Q(R.string.seated_practice));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_instructions */
    public class d implements MediaPlayer.OnErrorListener {
        d() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(b.this.n(), (int) R.string.this_file_cant_be_played, 1).show();
            b.this.s0 = false;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_instructions */
    public class e implements MediaPlayer.OnCompletionListener {
        e() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            b.this.k0.setImageResource(R.drawable.icon_play_white);
            b.this.k0.setContentDescription(b.this.Q(R.string.only_play_audio));
            b.this.k0.sendAccessibilityEvent(4);
            b.this.l0.setProgress(b.this.l0.getMax());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_instructions */
    public class f implements MediaPlayer.OnPreparedListener {
        f() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            b.this.l0.setMax(b.this.p0.getDuration() / 1000);
            b.this.o0.setPlayer(mediaPlayer);
            b.this.o0.j(R.raw.sub_seated_practice_instructions, "application/x-subrip");
            b.this.o2();
            b.this.s0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_instructions */
    public class g implements Runnable {
        g() {
        }

        public void run() {
            if (b.this.p0 != null && b.this.s0) {
                try {
                    b.this.n0.setText(s.j((long) b.this.p0.getDuration(), (long) b.this.p0.getCurrentPosition()));
                    b.this.m0.setText(s.k((long) b.this.p0.getCurrentPosition()));
                    b.this.l0.setContentDescription(b.this.Q(R.string.time_seekbar));
                    b.this.l0.setProgress(b.this.p0.getCurrentPosition() / 1000);
                } catch (Exception unused) {
                }
            }
            b.this.q0.postDelayed(this, 1000);
        }
    }

    public static b p2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, int i3, String str2) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bundle.putInt("duration", i3);
        bundle.putString("tone", str2);
        bVar.v1(bundle);
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.t0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.t0 = new c();
        try {
            n().registerReceiver(this.t0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        this.i0.setImageResource(R.drawable.t51_img);
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.d0);
        bundle.putSerializable("selected_tool", this.e0);
        bundle.putSerializable("symptom", this.f0);
        bundle.putInt("old_distress", this.g0);
        bundle.putString("last_tool_name", this.h0);
        super.K0(bundle);
    }

    public void n2() {
        AssetFileDescriptor assetFileDescriptor;
        try {
            this.i0.setImageResource(R.drawable.t51_img);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.p0 = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.p0.setOnErrorListener(new d());
            this.p0.setOnCompletionListener(new e());
            this.p0.setOnPreparedListener(new f());
            if (gov.va.mobilehealth.ncptsd.covid.CComp.b0.a(n()).equals("es")) {
                androidx.fragment.app.d n = n();
                assetFileDescriptor = m.v(n, gov.va.mobilehealth.ncptsd.covid.CComp.g.m + File.separator + "seated_practice_instructions.mp3");
            } else {
                androidx.fragment.app.d n2 = n();
                assetFileDescriptor = m.v(n2, gov.va.mobilehealth.ncptsd.covid.CComp.g.l + File.separator + "seated_practice_instructions.mp3");
            }
            if (this.p0.isPlaying()) {
                this.p0.stop();
            }
            this.p0.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
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
            this.d0 = (b0) bundle.getSerializable("tool");
            this.e0 = (b0) bundle.getSerializable("selected_tool");
            this.f0 = (a0) bundle.getSerializable("symptom");
            this.g0 = bundle.getInt("old_distress");
            this.h0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.d0 = (b0) u().getSerializable("tool");
            this.e0 = (b0) u().getSerializable("selected_tool");
            this.f0 = (a0) u().getSerializable("symptom");
            this.g0 = u().getInt("old_distress");
            this.h0 = u().getString("last_tool_name");
            this.u0 = u().getInt("duration");
            this.v0 = u().getString("tone");
        }
    }

    public void o2() {
        this.q0 = new Handler();
        this.r0 = new g();
        n().runOnUiThread(this.r0);
    }

    public void onClick(View view) {
        if (view.getId() == this.k0.getId() && this.s0) {
            if (this.p0.isPlaying()) {
                this.p0.pause();
                this.k0.setImageResource(R.drawable.icon_play);
                this.k0.setContentDescription(Q(R.string.play_audio));
                this.k0.announceForAccessibility(Q(R.string.play_audio));
                return;
            }
            this.p0.start();
            this.k0.setImageResource(R.drawable.icon_pause);
            this.k0.setContentDescription(Q(R.string.pause_audio));
            this.k0.announceForAccessibility(Q(R.string.pause_audio));
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
        View inflate = layoutInflater.inflate(R.layout.frag_seated_practice_instructions, viewGroup, false);
        this.j0 = (RelativeLayout) inflate.findViewById(R.id.audio_tool_layout_top);
        this.i0 = (ImageView) inflate.findViewById(R.id.audio_tool_img);
        this.k0 = (FABTracking) inflate.findViewById(R.id.audio_tool_fab_play_pause);
        this.l0 = (AppCompatSeekBar) inflate.findViewById(R.id.audio_tool_seekbar);
        this.m0 = (TextView) inflate.findViewById(R.id.audio_tool_txt_time_passed);
        this.n0 = (TextView) inflate.findViewById(R.id.audio_tool_txt_time_remaining);
        this.o0 = (SubtitleView) inflate.findViewById(R.id.audio_tool_subtitle_view);
        this.j0.getLayoutParams().height = j.r(n()) - j.y(n());
        this.k0.setOnClickListener(this);
        this.l0.setOnSeekBarChangeListener(this);
        this.n0.setAccessibilityDelegate(new a());
        this.m0.setAccessibilityDelegate(new C0199b());
        if (!this.s0) {
            n2();
        } else {
            o2();
            this.l0.setMax(this.p0.getDuration() / 1000);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.p0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.p0.stop();
            }
            this.p0.release();
        }
        Handler handler = this.q0;
        if (!(handler == null || (runnable = this.r0) == null)) {
            handler.removeCallbacks(runnable);
        }
        super.t0();
    }
}
