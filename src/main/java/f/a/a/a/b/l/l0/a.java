package f.a.a.a.b.l.l0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ImageView;
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

/* compiled from: Frag_tool_familyAudio_audio_tool */
public class a extends vainstrum.Components.b implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Act_manage c0;
    private Button d0;
    private ImageView e0;
    private RelativeLayout f0;
    private FABTracking g0;
    private AppCompatSeekBar h0;
    private TextView i0;
    private TextView j0;
    private SubtitleView k0;
    private MediaPlayer l0;
    private Handler m0;
    private Runnable n0;
    private b0 o0;
    private b0 p0;
    private a0 q0;
    private int r0;
    private String s0;
    private boolean t0 = false;
    private f.a.a.a.b.d.d u0;
    private BroadcastReceiver v0;

    /* renamed from: f.a.a.a.b.l.l0.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_tool_familyAudio_audio_tool */
    class C0205a extends View.AccessibilityDelegate {
        C0205a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && a.this.l0 != null) {
                a.this.j0.setContentDescription(s.h(a.this.n(), (long) a.this.l0.getDuration(), (long) a.this.l0.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_tool_familyAudio_audio_tool */
    class b extends View.AccessibilityDelegate {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768 && a.this.l0 != null) {
                a.this.i0.setContentDescription(s.l(a.this.n(), (long) a.this.l0.getCurrentPosition()));
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_tool_familyAudio_audio_tool */
    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                a.this.h2();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_audio_tool */
    public class d implements MediaPlayer.OnErrorListener {
        d() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(a.this.n(), (int) R.string.this_file_cant_be_played, 1).show();
            a.this.t0 = false;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_audio_tool */
    public class e implements MediaPlayer.OnCompletionListener {
        e() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.g0.setTrackingId("29521");
            a.this.g0.setImageResource(R.drawable.icon_play_white);
            a.this.g0.setContentDescription(a.this.Q(R.string.only_play_audio));
            a.this.g0.sendAccessibilityEvent(4);
            a.this.h0.setProgress(a.this.h0.getMax());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_audio_tool */
    public class f implements MediaPlayer.OnPreparedListener {
        f() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.h0.setMax(a.this.l0.getDuration() / 1000);
            a.this.k0.setPlayer(mediaPlayer);
            a.this.k0.j(a.this.u0.g(), "application/x-subrip");
            a.this.j2();
            a.this.t0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_familyAudio_audio_tool */
    public class g implements Runnable {
        g() {
        }

        public void run() {
            if (a.this.l0 != null && a.this.t0) {
                try {
                    a.this.j0.setText(s.j((long) a.this.l0.getDuration(), (long) a.this.l0.getCurrentPosition()));
                    a.this.i0.setText(s.k((long) a.this.l0.getCurrentPosition()));
                    a.this.h0.setContentDescription(a.this.Q(R.string.time_seekbar));
                    a.this.h0.setProgress(a.this.l0.getCurrentPosition() / 1000);
                } catch (Exception unused) {
                }
            }
            a.this.m0.postDelayed(this, 1000);
        }
    }

    public static a k2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, f.a.a.a.b.d.d dVar) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bundle.putSerializable("audiotool", dVar);
        aVar.v1(bundle);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.v0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.v0 = new c();
        try {
            n().registerReceiver(this.v0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        this.e0.setImageResource(this.u0.e());
        if (this.t0) {
            this.k0.setPlayer(this.l0);
            this.k0.j(this.u0.g(), "application/x-subrip");
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.o0);
        bundle.putSerializable("selected_tool", this.p0);
        bundle.putSerializable("symptom", this.q0);
        bundle.putInt("old_distress", this.r0);
        bundle.putString("last_tool_name", this.s0);
        bundle.putSerializable("audiotool", this.u0);
        super.K0(bundle);
    }

    public int g2() {
        b0 b0Var = this.o0;
        if (b0Var != null) {
            return b0Var.d();
        }
        b0 b0Var2 = this.p0;
        if (b0Var2 != null) {
            return b0Var2.d();
        }
        return -1;
    }

    public void h2() {
        if (this.r0 == -1) {
            this.c0.finish();
            return;
        }
        MediaPlayer mediaPlayer = this.l0;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.l0.pause();
        }
        this.c0.W(h.W1(this.o0, this.q0, this.r0, this.s0), Q(R.string.distress_meter));
    }

    public void i2() {
        try {
            this.e0.setImageResource(this.u0.e());
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.l0 = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.l0.setOnErrorListener(new d());
            this.l0.setOnCompletionListener(new e());
            this.l0.setOnPreparedListener(new f());
            if (gov.va.mobilehealth.ncptsd.covid.CComp.b0.a(n()).equals("es")) {
                File file = new File(n().getExternalFilesDir(null), this.u0.d());
                if (file.exists()) {
                    this.l0.setDataSource(n(), Uri.fromFile(file));
                    this.l0.prepareAsync();
                } else {
                    gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a.b b2 = gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a.a.b(n(), 12, 0);
                    AssetFileDescriptor b3 = b2.b("main.12.gov.va.mobilehealth.ncptsd.covid" + File.separator + this.u0.c());
                    this.l0.setDataSource(b3.getFileDescriptor(), b3.getStartOffset(), b3.getLength());
                    this.l0.prepareAsync();
                }
            } else {
                gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a.b b4 = gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a.a.b(n(), 12, 0);
                AssetFileDescriptor b5 = b4.b("main.12.gov.va.mobilehealth.ncptsd.covid" + File.separator + this.u0.c());
                this.l0.setDataSource(b5.getFileDescriptor(), b5.getStartOffset(), b5.getLength());
                this.l0.prepareAsync();
            }
            if (this.l0.isPlaying()) {
                this.l0.stop();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void j2() {
        this.m0 = new Handler();
        this.n0 = new g();
        n().runOnUiThread(this.n0);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.o0 = (b0) bundle.getSerializable("tool");
            this.p0 = (b0) bundle.getSerializable("selected_tool");
            this.q0 = (a0) bundle.getSerializable("symptom");
            this.r0 = bundle.getInt("old_distress");
            this.s0 = bundle.getString("last_tool_name");
            this.u0 = (f.a.a.a.b.d.d) bundle.getSerializable("audiotool");
        } else if (u() != null) {
            this.o0 = (b0) u().getSerializable("tool");
            this.p0 = (b0) u().getSerializable("selected_tool");
            this.q0 = (a0) u().getSerializable("symptom");
            this.r0 = u().getInt("old_distress");
            this.s0 = u().getString("last_tool_name");
            this.u0 = (f.a.a.a.b.d.d) u().getSerializable("audiotool");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            m.c0(true, this.c0, this.q0, this.o0, this.r0);
        }
        if (view.getId() == this.g0.getId() && this.t0) {
            if (this.l0.isPlaying()) {
                this.l0.pause();
                this.g0.setTrackingId("29521");
                this.g0.setImageResource(R.drawable.icon_play);
                this.g0.setContentDescription(Q(R.string.play_audio));
                this.g0.announceForAccessibility(Q(R.string.play_audio));
                return;
            }
            this.l0.start();
            this.g0.setTrackingId("30017");
            this.g0.setImageResource(R.drawable.icon_pause);
            this.g0.setContentDescription(Q(R.string.pause_audio));
            this.g0.announceForAccessibility(Q(R.string.pause_audio));
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        MediaPlayer mediaPlayer = this.l0;
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
        View inflate = layoutInflater.inflate(R.layout.frag_tool_family_audio_tool, viewGroup, false);
        this.d0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.f0 = (RelativeLayout) inflate.findViewById(R.id.audio_tool_layout_top);
        this.e0 = (ImageView) inflate.findViewById(R.id.audio_tool_img);
        this.g0 = (FABTracking) inflate.findViewById(R.id.audio_tool_fab_play_pause);
        this.h0 = (AppCompatSeekBar) inflate.findViewById(R.id.audio_tool_seekbar);
        this.i0 = (TextView) inflate.findViewById(R.id.audio_tool_txt_time_passed);
        this.j0 = (TextView) inflate.findViewById(R.id.audio_tool_txt_time_remaining);
        this.k0 = (SubtitleView) inflate.findViewById(R.id.audio_tool_subtitle_view);
        Button button = (Button) inflate.findViewById(R.id.audio_tool_btn_done);
        this.f0.getLayoutParams().height = j.r(n()) - j.y(n());
        if (this.q0 == null) {
            this.d0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.h0.setOnSeekBarChangeListener(this);
        this.j0.setAccessibilityDelegate(new C0205a());
        this.i0.setAccessibilityDelegate(new b());
        if (!this.t0) {
            i2();
        } else {
            j2();
            this.h0.setMax(this.l0.getDuration() / 1000);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.l0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.l0.stop();
            }
            this.l0.release();
        }
        Handler handler = this.m0;
        if (!(handler == null || (runnable = this.n0) == null)) {
            handler.removeCallbacks(runnable);
        }
        super.t0();
    }
}
