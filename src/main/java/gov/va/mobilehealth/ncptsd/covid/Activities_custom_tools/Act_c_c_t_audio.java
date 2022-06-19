package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.IOException;
import vainstrum.Components.FABTracking;

public class Act_c_c_t_audio extends f implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private SeekBar A;
    private EditText B;
    private Button C;
    private Button D;
    private MediaPlayer E;
    private Handler F;
    private Runnable G;
    private String H;
    private String I;
    private Uri J;
    private boolean K = false;
    private Toolbar u;
    private FloatingActionButton v;
    private FABTracking w;
    private LinearLayout x;
    private TextView y;
    private TextView z;

    /* access modifiers changed from: package-private */
    public class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(Act_c_c_t_audio.this, (int) R.string.this_file_cant_be_played, 1).show();
            Act_c_c_t_audio.this.K = false;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            Act_c_c_t_audio.this.w.setTrackingId("41380");
            Act_c_c_t_audio.this.w.setImageResource(R.drawable.icon_play_white);
            Act_c_c_t_audio.this.w.setContentDescription(Act_c_c_t_audio.this.getString(R.string.play_audio));
            Act_c_c_t_audio.this.w.sendAccessibilityEvent(4);
            Act_c_c_t_audio.this.A.setProgress(Act_c_c_t_audio.this.A.getMax());
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements MediaPlayer.OnPreparedListener {
        c() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            Act_c_c_t_audio.this.A.setMax(Act_c_c_t_audio.this.E.getDuration() / 1000);
            Act_c_c_t_audio.this.g0();
            Act_c_c_t_audio.this.K = true;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        d() {
        }

        public void run() {
            if (Act_c_c_t_audio.this.E != null && Act_c_c_t_audio.this.K) {
                try {
                    Act_c_c_t_audio.this.z.setText(m.U((long) Act_c_c_t_audio.this.E.getCurrentPosition()));
                    Act_c_c_t_audio.this.A.setProgress(Act_c_c_t_audio.this.E.getCurrentPosition() / 1000);
                    Act_c_c_t_audio.this.z.setContentDescription(m.V(Act_c_c_t_audio.this.getApplicationContext(), (long) Act_c_c_t_audio.this.E.getCurrentPosition()));
                } catch (Exception unused) {
                }
            }
            Act_c_c_t_audio.this.F.postDelayed(this, 1000);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void d0() {
        String obj = this.B.getText().toString();
        if (this.J != null) {
            Intent intent = new Intent();
            intent.putExtra("caption", obj);
            intent.putExtra("uri", this.J.toString());
            setResult(-1, intent);
            finish();
            return;
        }
        j.V(this, getString(R.string.please_pick_a_music_for_the_tool));
    }

    public void e0() {
        try {
            if (this.E.isPlaying()) {
                this.E.stop();
            }
            this.E.reset();
            this.E.setDataSource(getApplicationContext(), this.J);
            this.E.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void f0() {
        this.K = false;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.E = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.E.setOnErrorListener(new a());
        this.E.setOnCompletionListener(new b());
        this.E.setOnPreparedListener(new c());
        if (this.E.isPlaying()) {
            this.E.stop();
        }
        e0();
    }

    public void g0() {
        this.F = new Handler();
        d dVar = new d();
        this.G = dVar;
        runOnUiThread(dVar);
    }

    public void h0() {
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI), 57);
    }

    public void i0(String str) {
        if (str != null) {
            this.J = Uri.parse(str);
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this, this.J);
        String N = m.N(this.J);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(7);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(2);
        if (extractMetadata != null) {
            N = extractMetadata;
        } else if (N == null) {
            N = getString(R.string.no_title);
        }
        StringBuilder sb = new StringBuilder(N);
        sb.append(" - ");
        if (extractMetadata2 == null) {
            sb.append(getString(R.string.no_artist));
        } else {
            sb.append(extractMetadata2);
        }
        this.y.setText(sb);
        this.x.setVisibility(0);
        this.v.l();
        f0();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 57 && i3 == -1 && intent != null && intent.getData() != null && (data = intent.getData()) != null) {
            this.J = data;
            i0(null);
        }
    }

    public void onClick(View view) {
        MediaPlayer mediaPlayer;
        if (view.getId() == this.w.getId() && this.K && (mediaPlayer = this.E) != null) {
            if (mediaPlayer.isPlaying()) {
                this.E.pause();
                this.w.setTrackingId("41380");
                this.w.setImageResource(R.drawable.icon_play_white);
                this.w.setContentDescription(getString(R.string.only_play_audio));
                this.w.sendAccessibilityEvent(4);
            } else {
                this.E.start();
                this.w.setTrackingId("41504");
                this.w.setImageResource(R.drawable.icon_pause_white);
                this.w.setContentDescription(getString(R.string.only_pause_audio));
                this.w.sendAccessibilityEvent(4);
            }
        }
        if (view.getId() == this.v.getId()) {
            if (b.h.d.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 58);
            } else {
                h0();
            }
        }
        if (view.getId() == this.C.getId()) {
            if (b.h.d.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 58);
            } else {
                h0();
            }
        }
        if (view.getId() == this.D.getId()) {
            d0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.H = getIntent().getStringExtra("uri");
            this.I = getIntent().getStringExtra("caption");
        }
        setContentView(R.layout.act_c_c_t_audio);
        this.u = (Toolbar) findViewById(R.id.c_c_t_audio_toolbar);
        this.D = (Button) findViewById(R.id.c_c_t_audio_btn_save);
        this.v = (FloatingActionButton) findViewById(R.id.c_c_t_audio_add);
        this.w = (FABTracking) findViewById(R.id.c_c_t_audio_play_pause);
        this.x = (LinearLayout) findViewById(R.id.c_c_t_audio_layout_player);
        this.y = (TextView) findViewById(R.id.c_c_t_audio_title_artist);
        this.z = (TextView) findViewById(R.id.c_c_t_audio_txt_time);
        this.C = (Button) findViewById(R.id.c_c_t_audio_btn_change);
        this.A = (SeekBar) findViewById(R.id.c_c_t_audio_seekbar);
        this.B = (EditText) findViewById(R.id.c_c_t_audio_edt_caption);
        m.R0(this, findViewById(R.id.c_c_t_audio_layout));
        this.v.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.A.setOnSeekBarChangeListener(this);
        String str = this.H;
        if (str != null) {
            i0(str);
            String str2 = this.I;
            if (str2 != null) {
                this.B.setText(str2);
            }
        }
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.E;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.E.stop();
            }
            this.E.release();
        }
        Handler handler = this.F;
        if (!(handler == null || (runnable = this.G) == null)) {
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
        MediaPlayer mediaPlayer = this.E;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.E.pause();
            this.w.setTrackingId("41380");
            this.w.setImageResource(R.drawable.icon_play);
            this.w.setContentDescription(getString(R.string.play_audio));
        }
        super.onPause();
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        MediaPlayer mediaPlayer = this.E;
        if (mediaPlayer != null && z2) {
            mediaPlayer.seekTo(i2 * 1000);
        }
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 58 && iArr.length > 0 && iArr[0] == 0) {
            h0();
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
