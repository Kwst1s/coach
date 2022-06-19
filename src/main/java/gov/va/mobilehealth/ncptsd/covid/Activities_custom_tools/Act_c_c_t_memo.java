package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import java.io.IOException;
import vainstrum.Components.FABTracking;

public class Act_c_c_t_memo extends gov.va.mobilehealth.ncptsd.covid.CComp.f implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static String T;
    private static String U;
    private static String V;
    private MediaRecorder A;
    private boolean B = false;
    private CountDownTimer C;
    private FABTracking D;
    private TextView E;
    private TextView F;
    private Button G;
    private SeekBar H;
    private MediaPlayer I;
    private EditText J;
    private Button K;
    private Handler L;
    private Runnable M;
    private boolean N = true;
    private boolean O = false;
    private String P;
    private String Q;
    private Uri R;
    private boolean S = false;
    private Toolbar u;
    private RelativeLayout v;
    private LinearLayout w;
    private FABTracking x;
    private TextView y;
    private ImageView z;

    /* access modifiers changed from: package-private */
    public class a implements Runnable {

        /* renamed from: gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools.Act_c_c_t_memo$a$a  reason: collision with other inner class name */
        class RunnableC0227a implements Runnable {
            RunnableC0227a() {
            }

            public void run() {
                Act_c_c_t_memo.this.A.reset();
                Act_c_c_t_memo.this.A.release();
                Act_c_c_t_memo.this.A = null;
                if (Act_c_c_t_memo.this.C != null) {
                    Act_c_c_t_memo.this.C.cancel();
                }
                Act_c_c_t_memo.this.x.announceForAccessibility(Act_c_c_t_memo.this.getString(R.string.stopped_recording));
                Act_c_c_t_memo.this.R = Uri.fromFile(new File(Act_c_c_t_memo.V));
                Act_c_c_t_memo.this.t0(null);
                Act_c_c_t_memo.this.F.setText(R.string.tap_the_microphone_to_start_recording);
                Act_c_c_t_memo.this.B = false;
            }
        }

        a() {
        }

        public void run() {
            Act_c_c_t_memo.this.A.stop();
            new Handler().postDelayed(new RunnableC0227a(), 100);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        int f9953a = 0;

        b(long j2, long j3) {
            super(j2, j3);
        }

        public void onFinish() {
        }

        public void onTick(long j2) {
            int i2 = this.f9953a + 1;
            this.f9953a = i2;
            long j3 = (long) i2;
            int i3 = (int) (j3 / 60);
            Act_c_c_t_memo.this.y.setText(String.format("%d:%02d:%02d", Integer.valueOf(i3 / 60), Integer.valueOf(i3 % 60), Long.valueOf(j3)));
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements MediaPlayer.OnErrorListener {
        c() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(Act_c_c_t_memo.this, (int) R.string.this_file_cant_be_played, 1).show();
            Act_c_c_t_memo.this.O = false;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements MediaPlayer.OnCompletionListener {
        d() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            Act_c_c_t_memo.this.S = true;
            Act_c_c_t_memo.this.D.setTrackingId("41380");
            Act_c_c_t_memo.this.D.setImageResource(R.drawable.icon_play_white);
            Act_c_c_t_memo.this.D.setContentDescription(Act_c_c_t_memo.this.getString(R.string.only_play_audio));
            Act_c_c_t_memo.this.D.sendAccessibilityEvent(4);
            Act_c_c_t_memo.this.H.setProgress(Act_c_c_t_memo.this.H.getMax());
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements MediaPlayer.OnPreparedListener {
        e() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            Act_c_c_t_memo.this.H.setMax(Act_c_c_t_memo.this.I.getDuration() / 1000);
            Act_c_c_t_memo.this.H.setProgress(0);
            Act_c_c_t_memo.this.r0();
            Act_c_c_t_memo.this.O = true;
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements Runnable {
        f() {
        }

        public void run() {
            if (Act_c_c_t_memo.this.I != null && Act_c_c_t_memo.this.O) {
                try {
                    Act_c_c_t_memo.this.E.setText(m.U((long) Act_c_c_t_memo.this.I.getCurrentPosition()));
                    int currentPosition = Act_c_c_t_memo.this.I.getCurrentPosition() / 1000;
                    Act_c_c_t_memo.this.E.setContentDescription(m.V(Act_c_c_t_memo.this.getApplicationContext(), (long) Act_c_c_t_memo.this.I.getCurrentPosition()));
                    if (Act_c_c_t_memo.this.S) {
                        Act_c_c_t_memo.this.H.setProgress(Act_c_c_t_memo.this.H.getMax());
                    } else {
                        Act_c_c_t_memo.this.H.setProgress(currentPosition);
                    }
                } catch (Exception unused) {
                }
            }
            Act_c_c_t_memo.this.L.postDelayed(this, 1000);
        }
    }

    private void w0() {
        new Handler().postDelayed(new a(), 500);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void o0() {
        String obj = this.J.getText().toString();
        if (this.R != null) {
            Intent intent = new Intent();
            intent.putExtra("caption", obj);
            intent.putExtra("uri", this.R.toString());
            setResult(-1, intent);
            finish();
            return;
        }
        j.V(this, getString(R.string.please_record_an_audio_for_the_tool));
    }

    public void onClick(View view) {
        MediaPlayer mediaPlayer;
        if (view.getId() == this.D.getId() && this.O && (mediaPlayer = this.I) != null) {
            if (mediaPlayer.isPlaying()) {
                this.I.pause();
                this.D.setTrackingId("41380");
                this.D.setImageResource(R.drawable.icon_play_white);
                this.D.setContentDescription(getString(R.string.only_play_audio));
                this.D.sendAccessibilityEvent(4);
            } else {
                this.I.start();
                this.D.setTrackingId("41504");
                this.D.setImageResource(R.drawable.icon_pause_white);
                this.D.setContentDescription(getString(R.string.only_pause_audio));
                this.D.sendAccessibilityEvent(4);
                this.S = false;
            }
        }
        if (view.getId() == this.x.getId() && this.N) {
            if (this.B) {
                w0();
            } else if (b.h.d.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && b.h.d.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && b.h.d.a.a(this, "android.permission.RECORD_AUDIO") == 0) {
                v0();
            } else {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO"}, 68);
            }
        }
        if (view.getId() == this.G.getId()) {
            u0(true);
        }
        if (view.getId() == this.K.getId()) {
            o0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.P = getIntent().getStringExtra("uri");
            this.Q = getIntent().getStringExtra("caption");
        }
        setContentView(R.layout.act_c_c_t_memo);
        this.u = (Toolbar) findViewById(R.id.c_c_t_memo_toolbar);
        this.J = (EditText) findViewById(R.id.c_c_t_memo_edt_notes);
        this.K = (Button) findViewById(R.id.c_c_t_memo_btn_save);
        this.v = (RelativeLayout) findViewById(R.id.c_c_t_memo_layout_record_memo);
        this.x = (FABTracking) findViewById(R.id.c_c_t_memo_fab_mic_stop);
        this.y = (TextView) findViewById(R.id.c_c_t_memo_txt_time_recording);
        this.z = (ImageView) findViewById(R.id.c_c_t_memo_img_recording);
        this.F = (TextView) findViewById(R.id.c_c_t_memo_txt_tap_to_start);
        this.w = (LinearLayout) findViewById(R.id.c_c_t_memo_layout_player);
        this.D = (FABTracking) findViewById(R.id.c_c_t_memo_play_pause);
        this.E = (TextView) findViewById(R.id.c_c_t_memo_txt_time);
        this.H = (SeekBar) findViewById(R.id.c_c_t_memo_seekbar);
        this.G = (Button) findViewById(R.id.c_c_t_memo_btn_redo);
        m.R0(this, findViewById(R.id.c_c_t_memo_layout));
        this.x.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnSeekBarChangeListener(this);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("Recordings");
        T = sb.toString();
        V = T + str + U;
        String str2 = this.P;
        if (str2 != null) {
            t0(str2);
            String str3 = this.Q;
            if (str3 != null) {
                this.J.setText(str3);
                return;
            }
            return;
        }
        u0(false);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.I;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.I.stop();
            }
            this.I.release();
        }
        Handler handler = this.L;
        if (!(handler == null || (runnable = this.M) == null)) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        if (this.B) {
            w0();
        }
        MediaPlayer mediaPlayer = this.I;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.I.pause();
            this.D.setTrackingId("41380");
            this.D.setImageResource(R.drawable.icon_play_white);
            this.D.setContentDescription(getString(R.string.only_play_audio));
        }
        super.onPause();
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        MediaPlayer mediaPlayer = this.I;
        if (mediaPlayer != null && z2) {
            mediaPlayer.seekTo(i2 * 1000);
        }
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 68 && iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0 && iArr[2] == 0) {
            v0();
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void p0() {
        try {
            if (this.I.isPlaying()) {
                this.I.stop();
            }
            this.I.reset();
            this.I.setDataSource(getApplicationContext(), this.R);
            this.I.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void q0() {
        b bVar = new b(Long.MAX_VALUE, 1000);
        this.C = bVar;
        bVar.start();
    }

    public void r0() {
        this.L = new Handler();
        f fVar = new f();
        this.M = fVar;
        runOnUiThread(fVar);
    }

    public void s0() {
        this.O = false;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.I = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.I.setOnErrorListener(new c());
        this.I.setOnCompletionListener(new d());
        this.I.setOnPreparedListener(new e());
        if (this.I.isPlaying()) {
            this.I.stop();
        }
        p0();
    }

    public void t0(String str) {
        if (str != null) {
            this.R = Uri.parse(str);
        }
        this.w.setVisibility(0);
        this.v.setVisibility(8);
        this.K.setVisibility(0);
        s0();
    }

    public void u0(boolean z2) {
        Runnable runnable;
        this.w.setVisibility(8);
        this.v.setVisibility(0);
        if (z2) {
            v0();
        } else {
            this.x.setTrackingId("41823");
            this.x.setImageResource(R.drawable.icon_mic);
            this.x.setContentDescription(getString(R.string.record_memo));
            this.y.setText("00:00");
        }
        Handler handler = this.L;
        if (handler != null && (runnable = this.M) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void v0() {
        U = Long.toString(System.currentTimeMillis()) + ".3gp";
        V = T + File.separator + U;
        File file = new File(T);
        if (!file.exists()) {
            file.mkdirs();
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.A = mediaRecorder;
        mediaRecorder.setAudioSource(1);
        this.A.setOutputFormat(1);
        this.A.setAudioEncoder(3);
        this.A.setOutputFile(V);
        try {
            this.A.prepare();
        } catch (IOException unused) {
        }
        this.A.start();
        this.B = true;
        this.x.setTrackingId("41825");
        this.x.setImageResource(R.drawable.icon_stop);
        this.x.announceForAccessibility(getString(R.string.recording_start_double_tap_to_stop));
        this.x.setContentDescription(getString(R.string.end_recording));
        this.z.setVisibility(0);
        this.F.setText(R.string.tap_the_button_to_stop_recording);
        q0();
    }
}
