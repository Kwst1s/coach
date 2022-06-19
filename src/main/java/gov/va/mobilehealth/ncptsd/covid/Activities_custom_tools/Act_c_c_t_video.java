package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.IOException;
import vainstrum.Components.FABTracking;

public class Act_c_c_t_video extends f implements SurfaceHolder.Callback, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private TextView A;
    private SurfaceView B;
    private SurfaceHolder C;
    private MediaPlayer D;
    private int E = 0;
    private Handler F;
    private Runnable G;
    private boolean H = false;
    private EditText I;
    private Button J;
    private Button K;
    private String L;
    private String M;
    private Uri N;
    private MenuItem O;
    private Toolbar u;
    private FABTracking v;
    private RelativeLayout w;
    private LinearLayout x;
    private FABTracking y;
    private SeekBar z;

    /* access modifiers changed from: package-private */
    public class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            Act_c_c_t_video.this.w.setBackgroundResource(R.drawable.bg_edt_black);
            float videoWidth = ((float) Act_c_c_t_video.this.D.getVideoWidth()) / ((float) Act_c_c_t_video.this.D.getVideoHeight());
            int width = Act_c_c_t_video.this.w.getWidth();
            int height = Act_c_c_t_video.this.w.getHeight();
            float f2 = (float) width;
            float f3 = (float) height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Act_c_c_t_video.this.B.getLayoutParams();
            if (videoWidth > f2 / f3) {
                layoutParams.width = width;
                layoutParams.height = (int) (f2 / videoWidth);
                layoutParams.addRule(15);
            } else {
                layoutParams.width = (int) (videoWidth * f3);
                layoutParams.height = height;
                layoutParams.addRule(14);
            }
            Act_c_c_t_video.this.B.setLayoutParams(layoutParams);
            Act_c_c_t_video.this.D.seekTo(Act_c_c_t_video.this.E);
            Act_c_c_t_video.this.H = true;
            Act_c_c_t_video.this.i0();
            if (Act_c_c_t_video.this.O != null) {
                Act_c_c_t_video.this.O.setVisible(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            Act_c_c_t_video.this.y.setTrackingId("43202");
            Act_c_c_t_video.this.y.setImageResource(R.drawable.icon_play_white);
            Act_c_c_t_video.this.y.setContentDescription(Act_c_c_t_video.this.getString(R.string.only_play_video));
            Act_c_c_t_video.this.y.sendAccessibilityEvent(4);
            Act_c_c_t_video.this.z.setProgress(Act_c_c_t_video.this.z.getMax());
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements MediaPlayer.OnErrorListener {
        c() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Act_c_c_t_video.this.B.announceForAccessibility(Act_c_c_t_video.this.getString(R.string.this_file_cant_be_played));
            Act_c_c_t_video act_c_c_t_video = Act_c_c_t_video.this;
            Toast.makeText(act_c_c_t_video, act_c_c_t_video.getString(R.string.this_file_cant_be_played), 1).show();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        d() {
        }

        public void run() {
            if (Act_c_c_t_video.this.D != null && Act_c_c_t_video.this.H) {
                try {
                    Act_c_c_t_video.this.A.setText(m.U((long) Act_c_c_t_video.this.D.getCurrentPosition()));
                    Act_c_c_t_video.this.z.setProgress(Act_c_c_t_video.this.D.getCurrentPosition() / 1000);
                    Act_c_c_t_video.this.A.setContentDescription(m.V(Act_c_c_t_video.this.getApplicationContext(), (long) Act_c_c_t_video.this.D.getCurrentPosition()));
                } catch (Exception unused) {
                }
            }
            Act_c_c_t_video.this.F.postDelayed(this, 1000);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void h0() {
        String obj = this.I.getText().toString();
        if (this.N != null) {
            Intent intent = new Intent();
            intent.putExtra("caption", obj);
            intent.putExtra("uri", this.N.toString());
            setResult(-1, intent);
            finish();
            return;
        }
        j.V(this, getString(R.string.please_pick_a_video_for_the_tool));
    }

    public void i0() {
        this.z.setMax(this.D.getDuration() / 1000);
        this.F = new Handler();
        d dVar = new d();
        this.G = dVar;
        runOnUiThread(dVar);
    }

    public void j0() {
        startActivityForResult(new Intent(getApplicationContext(), Act_get_video.class), 67);
    }

    public void k0(String str) {
        if (str != null) {
            try {
                this.N = Uri.parse(str);
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.D = mediaPlayer;
        mediaPlayer.setOnPreparedListener(new a());
        this.D.setOnCompletionListener(new b());
        this.D.setOnErrorListener(new c());
        this.D.setScreenOnWhilePlaying(true);
        this.D.setDisplay(this.C);
        this.D.setDataSource(getApplicationContext(), this.N);
        this.D.prepareAsync();
        this.J.setVisibility(0);
        this.x.setVisibility(0);
        this.v.l();
        MenuItem menuItem = this.O;
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri parse;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 67 && i3 == -1 && intent != null && (parse = Uri.parse(intent.getStringExtra("uri"))) != null) {
            this.N = parse;
            this.E = 0;
            this.B.setVisibility(0);
        }
    }

    public void onClick(View view) {
        MediaPlayer mediaPlayer;
        if (view.getId() == this.y.getId() && (mediaPlayer = this.D) != null) {
            if (mediaPlayer.isPlaying()) {
                this.D.pause();
                this.y.setTrackingId("43202");
                this.y.setImageResource(R.drawable.icon_play_white);
                this.y.setContentDescription(getString(R.string.only_play_video));
                this.y.announceForAccessibility(getString(R.string.only_play_video));
            } else {
                this.D.start();
                this.y.setTrackingId("43207");
                this.y.setImageResource(R.drawable.icon_pause_white);
                this.y.setContentDescription(getString(R.string.only_pause_video));
                this.y.announceForAccessibility(getString(R.string.only_pause_video));
            }
        }
        if (view.getId() == this.J.getId() || view.getId() == this.v.getId()) {
            if (b.h.d.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 68);
            } else {
                j0();
            }
        }
        if (view.getId() == this.K.getId()) {
            h0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.L = getIntent().getStringExtra("uri");
            this.M = getIntent().getStringExtra("caption");
        }
        setContentView(R.layout.act_c_c_t_video);
        this.u = (Toolbar) findViewById(R.id.c_c_t_video_toolbar);
        this.K = (Button) findViewById(R.id.c_c_t_video_btn_save);
        this.v = (FABTracking) findViewById(R.id.c_c_t_video_add);
        this.w = (RelativeLayout) findViewById(R.id.c_c_t_videoplayer_layout);
        this.B = (SurfaceView) findViewById(R.id.c_c_t_video_surface);
        this.J = (Button) findViewById(R.id.c_c_t_video_btn_change);
        this.I = (EditText) findViewById(R.id.c_c_t_video_edt_caption);
        this.x = (LinearLayout) findViewById(R.id.c_c_t_videoplayer_layout_controls);
        this.y = (FABTracking) findViewById(R.id.c_c_t_videoplayer_play_pause);
        this.z = (SeekBar) findViewById(R.id.c_c_t_videoplayer_seekbar);
        this.A = (TextView) findViewById(R.id.c_c_t_videoplayer_txt_time);
        m.R0(this, findViewById(R.id.c_c_t_video_layout));
        this.K.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnSeekBarChangeListener(this);
        SurfaceHolder holder = this.B.getHolder();
        this.C = holder;
        holder.addCallback(this);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        String str = this.L;
        if (str != null) {
            this.N = Uri.parse(str);
            String str2 = this.M;
            if (str2 != null) {
                this.I.setText(str2);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_act_video, menu);
        this.O = menu.findItem(R.id.action_video_external);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.D.stop();
                this.D.release();
            }
            this.B.destroyDrawingCache();
        }
        Handler handler = this.F;
        if (!(handler == null || (runnable = this.G) == null)) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.action_video_external) {
                Intent intent = new Intent(new Intent("android.intent.action.VIEW"));
                intent.setDataAndType(this.N, "video/*");
                startActivity(intent);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null) {
            this.E = mediaPlayer.getCurrentPosition();
            if (this.D.isPlaying()) {
                this.D.stop();
            }
            this.D.release();
            this.D = null;
            this.H = false;
            this.y.setTrackingId("43202");
            this.y.setImageResource(R.drawable.icon_play_white);
            this.y.setContentDescription(getString(R.string.only_play_video));
            this.y.announceForAccessibility(getString(R.string.only_play_video));
            this.B.setVisibility(8);
        }
        super.onPause();
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null && z2) {
            mediaPlayer.seekTo(i2 * 1000);
        }
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 68 && iArr.length > 0 && iArr[0] == 0) {
            j0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        if (this.N != null) {
            this.B.setVisibility(0);
        }
        super.onResume();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        k0(null);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
