package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.b.i0;
import f.a.a.a.b.d.z;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.io.IOException;
import java.util.ArrayList;

public class Act_music extends gov.va.mobilehealth.ncptsd.covid.CComp.f implements View.OnClickListener {
    private TextView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private View E;
    private u F;
    private ArrayList<z> G;
    private z H;
    private MediaPlayer I;
    private boolean J = false;
    private boolean K = false;
    private Toolbar u;
    private AppCompatTextView v;
    private RecyclerView w;
    private FloatingActionButton x;
    private LinearLayout y;
    private TextView z;

    /* access modifiers changed from: package-private */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            Act_music.this.x.getViewTreeObserver().removeOnPreDrawListener(this);
            Act_music.this.E.getLayoutParams().width = Act_music.this.x.getWidth() + (((RelativeLayout.LayoutParams) Act_music.this.x.getLayoutParams()).leftMargin * 2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements MediaPlayer.OnErrorListener {
        b() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(Act_music.this, (int) R.string.this_file_cant_be_played, 1).show();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            Act_music.this.B.setImageResource(R.drawable.icon_play);
            Act_music.this.B.setContentDescription(Act_music.this.getString(R.string.play_audio));
            Act_music.this.B.sendAccessibilityEvent(4);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements MediaPlayer.OnPreparedListener {
        d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            Act_music.this.B.setImageResource(R.drawable.icon_pause);
            Act_music.this.B.setContentDescription(Act_music.this.getString(R.string.pause_audio));
            Act_music.this.B.sendAccessibilityEvent(4);
            mediaPlayer.start();
        }
    }

    class e implements DialogInterface.OnClickListener {
        e(Act_music act_music) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    class f implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Uri f9869b;

        f(Uri uri) {
            this.f9869b = uri;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_music.this.F.i0(this.f9869b.toString(), Act_music.this.J);
            int i3 = 0;
            while (true) {
                if (i3 >= Act_music.this.G.size()) {
                    break;
                } else if (((z) Act_music.this.G.get(i3)).d().equals(this.f9869b)) {
                    Act_music.this.G.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            if (!(Act_music.this.I == null || Act_music.this.H == null || !Act_music.this.H.d().equals(this.f9869b))) {
                Act_music.this.I.stop();
                m.S0(Act_music.this.getApplicationContext(), Act_music.this.y, false);
                Act_music.this.K = false;
            }
            Act_music.this.w.announceForAccessibility(Act_music.this.getString(R.string.music_removed));
            Act_music.this.w.getAdapter().h();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void h0() {
        try {
            if (this.I.isPlaying()) {
                this.I.stop();
            }
            this.I.reset();
            this.I.setDataSource(getApplicationContext(), this.H.d());
            this.I.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void i0() {
        this.y = (LinearLayout) findViewById(R.id.bottom_music_player_layout);
        this.z = (TextView) findViewById(R.id.bottom_music_player_txt_title);
        this.A = (TextView) findViewById(R.id.bottom_music_player_txt_artist);
        this.B = (ImageView) findViewById(R.id.bottom_music_player_img_play_pause);
        this.C = (ImageView) findViewById(R.id.bottom_music_player_img_ffw);
        this.D = (ImageView) findViewById(R.id.bottom_music_player_img_fbw);
        this.E = findViewById(R.id.bottom_music_player_right_padding);
        this.x.getViewTreeObserver().addOnPreDrawListener(new a());
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
    }

    public void j0() {
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI), 57);
    }

    public void k0(z zVar) {
        if (!this.K) {
            m.S0(getApplicationContext(), this.y, true);
        }
        this.K = true;
        this.H = zVar;
        m0();
    }

    public void l0(Uri uri) {
        b.a h2 = j.h(this, getString(R.string.really_delete_music));
        h2.k(R.string.yes, new f(uri));
        h2.h(R.string.no, new e(this));
        h2.a().show();
    }

    public void m0() {
        if (this.H.c() != null) {
            this.z.setText(this.H.c());
        } else {
            this.z.setText(R.string.no_title);
        }
        if (this.H.a() != null) {
            this.A.setText(this.H.a());
        } else {
            this.A.setText(R.string.no_artist);
        }
        if (this.I == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.I = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.I.setOnErrorListener(new b());
            this.I.setOnCompletionListener(new c());
            this.I.setOnPreparedListener(new d());
            h0();
        } else {
            h0();
        }
        for (int i2 = 0; i2 < this.G.size(); i2++) {
            if (this.G.get(i2).d().equals(this.H.d())) {
                this.G.get(i2).g(true);
            } else {
                this.G.get(i2).g(false);
            }
        }
        if (this.w.getAdapter() != null) {
            this.w.getAdapter().h();
        }
    }

    public void n0() {
        if (this.G.isEmpty()) {
            this.w.setImportantForAccessibility(2);
        } else {
            this.w.setImportantForAccessibility(0);
        }
        this.w.setAdapter(new i0(this, this.G));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 57 && i3 == -1 && intent != null && intent.getData() != null && (data = intent.getData()) != null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this, data);
            String N = m.N(data);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(7);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(2);
            if (extractMetadata != null) {
                N = extractMetadata;
            }
            z zVar = new z(data, N, extractMetadata2);
            this.G.add(zVar);
            this.F.K(zVar, this.J);
            this.w.announceForAccessibility(getString(R.string.added_new_music));
            n0();
        }
    }

    public void onClick(View view) {
        MediaPlayer mediaPlayer;
        int currentPosition;
        MediaPlayer mediaPlayer2;
        int currentPosition2;
        MediaPlayer mediaPlayer3;
        if (view.getId() == this.x.getId()) {
            if (b.h.d.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 58);
            } else {
                j0();
            }
        }
        if (view.getId() == this.B.getId() && (mediaPlayer3 = this.I) != null) {
            if (mediaPlayer3.isPlaying()) {
                this.I.pause();
                this.B.setImageResource(R.drawable.icon_play);
                this.B.setContentDescription(getString(R.string.play_audio));
                this.B.sendAccessibilityEvent(4);
            } else {
                this.I.start();
                this.B.setImageResource(R.drawable.icon_pause);
                this.B.setContentDescription(getString(R.string.pause_audio));
                this.B.sendAccessibilityEvent(4);
            }
        }
        if (view.getId() == this.C.getId() && (mediaPlayer2 = this.I) != null && (currentPosition2 = mediaPlayer2.getCurrentPosition() + 5000) < this.I.getDuration()) {
            this.I.seekTo(currentPosition2);
        }
        if (view.getId() == this.D.getId() && (mediaPlayer = this.I) != null && mediaPlayer.getCurrentPosition() - 5000 > 0) {
            this.I.seekTo(currentPosition);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.J = getIntent().getBooleanExtra("soothing", false);
        setContentView(R.layout.act_music);
        this.u = (Toolbar) findViewById(R.id.music_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.music_txt_toolbar);
        this.w = (RecyclerView) findViewById(R.id.music_rview);
        this.x = (FloatingActionButton) findViewById(R.id.music_fab_add);
        i0();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.E2(1);
        this.w.setLayoutManager(linearLayoutManager);
        this.w.setHasFixedSize(true);
        this.x.setOnClickListener(this);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        this.v.setText(R.string.soothing_songs);
        m.A0(this, getString(R.string.soothing_songs));
        u uVar = new u(this);
        this.F = uVar;
        this.G = uVar.t0(this, this.J);
        n0();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        MediaPlayer mediaPlayer = this.I;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.I.stop();
            }
            this.I.release();
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
        MediaPlayer mediaPlayer = this.I;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.I.pause();
            this.B.setImageResource(R.drawable.icon_play);
            this.B.setContentDescription(getString(R.string.play_audio));
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 58 && iArr.length > 0 && iArr[0] == 0) {
            j0();
        }
    }
}
