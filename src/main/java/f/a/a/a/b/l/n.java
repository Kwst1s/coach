package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import com.github.mikephil.charting.R;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_video_player;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.io.IOException;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_custom_tool */
public class n extends vainstrum.Components.b {
    private SeekBar A0;
    private MediaPlayer B0;
    private Handler C0;
    private Runnable D0;
    private boolean E0 = false;
    private boolean F0 = false;
    private f.a.a.a.b.d.g G0;
    private int H0;
    private b0 I0;
    private b0 J0;
    private a0 K0;
    private int L0;
    private String M0;
    private Boolean N0;
    private Boolean O0;
    private BroadcastReceiver P0;
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private Button g0;
    private LinearLayout h0;
    private TextView i0;
    private ImageView j0;
    private LinearLayout k0;
    private ScrollView l0;
    private ImageView m0;
    private TextView n0;
    private LinearLayout o0;
    private ScrollView p0;
    private RelativeLayout q0;
    private ImageView r0;
    private TextView s0;
    private LinearLayout t0;
    private ScrollView u0;
    private FABTracking v0;
    private ImageView w0;
    private TextView x0;
    private TextView y0;
    private TextView z0;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            n.this.A0.setMax(n.this.B0.getDuration() / 1000);
            n.this.v2();
            n.this.E0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class b implements Runnable {
        b() {
        }

        public void run() {
            if (n.this.B0 != null && n.this.E0) {
                try {
                    n.this.y0.setText(gov.va.mobilehealth.ncptsd.covid.CComp.m.U((long) n.this.B0.getCurrentPosition()));
                    int currentPosition = n.this.B0.getCurrentPosition() / 1000;
                    if (n.this.F0) {
                        n.this.A0.setProgress(n.this.A0.getMax());
                    } else {
                        n.this.A0.setProgress(currentPosition);
                    }
                    n.this.y0.setContentDescription(gov.va.mobilehealth.ncptsd.covid.CComp.m.V(n.this.n(), (long) n.this.B0.getCurrentPosition()));
                } catch (Exception unused) {
                }
            }
            n.this.C0.postDelayed(this, 1000);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(n.this.n(), Act_video_player.class);
            intent.putExtra("sUri", n.this.G0.d().toString());
            n.this.F1(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            n.this.n().finish();
        }
    }

    /* compiled from: Frag_custom_tool */
    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            n nVar = n.this;
            nVar.O0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.o(nVar.n(), n.this.J0, n.this.d0, n.this.e0, n.this.O0, n.this.N0));
            n.this.N0 = Boolean.FALSE;
        }
    }

    /* compiled from: Frag_custom_tool */
    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            n nVar = n.this;
            nVar.N0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.n(nVar.n(), n.this.J0, n.this.d0, n.this.e0, n.this.O0, n.this.N0));
            n.this.O0 = Boolean.FALSE;
        }
    }

    /* compiled from: Frag_custom_tool */
    class g implements View.OnClickListener {

        /* compiled from: Frag_custom_tool */
        class a implements DialogInterface.OnClickListener {
            a(g gVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }

        /* compiled from: Frag_custom_tool */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                new u(n.this.n()).e0(gov.va.mobilehealth.ncptsd.covid.CComp.m.C(n.this.I0.d()));
                gov.va.mobilehealth.ncptsd.covid.CComp.m.N0(n.this.n().getApplication(), true);
                gov.va.mobilehealth.ncptsd.covid.CComp.m.M0(n.this.n().getApplication(), true);
                n.this.n().finish();
            }
        }

        g() {
        }

        public void onClick(View view) {
            b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(n.this.n(), n.this.Q(R.string.really_want_delete_tool));
            h2.k(R.string.yes, new b());
            h2.h(R.string.no, new a(this));
            h2.a().show();
        }
    }

    /* compiled from: Frag_custom_tool */
    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View view) {
            gov.va.mobilehealth.ncptsd.covid.CComp.m.c0(true, n.this.c0, n.this.K0, n.this.I0, n.this.L0);
        }
    }

    /* compiled from: Frag_custom_tool */
    class i extends BroadcastReceiver {
        i() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (n.this.L0 == -1) {
                n.this.c0.finish();
                return;
            }
            f.a.a.a.b.i.h W1 = f.a.a.a.b.i.h.W1(n.this.I0, n.this.K0, n.this.L0, n.this.M0);
            W1.V1(n.this.R1());
            n.this.c0.W(W1, n.this.Q(R.string.distress_meter));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View view) {
            if (n.this.E0 && n.this.B0 != null) {
                if (n.this.B0.isPlaying()) {
                    n.this.B0.pause();
                    n.this.v0.setTrackingId("29521");
                    n.this.v0.setImageResource(R.drawable.icon_play_white);
                    n.this.v0.setContentDescription(n.this.Q(R.string.only_play_audio));
                    n.this.v0.announceForAccessibility(n.this.Q(R.string.only_play_audio));
                    return;
                }
                n.this.v0.setTrackingId("30017");
                n.this.B0.start();
                n.this.v0.setImageResource(R.drawable.icon_pause_white);
                n.this.v0.setContentDescription(n.this.Q(R.string.only_pause_audio));
                n.this.v0.announceForAccessibility(n.this.Q(R.string.only_pause_audio));
                n.this.F0 = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class k implements SeekBar.OnSeekBarChangeListener {
        k() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (n.this.B0 != null && z) {
                n.this.B0.seekTo(i2 * 1000);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class l implements MediaPlayer.OnErrorListener {
        l() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(n.this.n(), (int) R.string.this_file_cant_be_played, 1).show();
            n.this.E0 = false;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_custom_tool */
    public class m implements MediaPlayer.OnCompletionListener {
        m() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            n.this.F0 = true;
            n.this.v0.setTrackingId("29521");
            n.this.v0.setImageResource(R.drawable.icon_play_white);
            n.this.v0.setContentDescription(n.this.Q(R.string.play_audio));
            n.this.v0.sendAccessibilityEvent(4);
            n.this.A0.setProgress(n.this.A0.getMax());
        }
    }

    public n() {
        Boolean bool = Boolean.FALSE;
        this.N0 = bool;
        this.O0 = bool;
    }

    public static n w2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        n nVar = new n();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        nVar.v1(bundle);
        return nVar;
    }

    public void A2() {
        if (this.G0.f().equals(gov.va.mobilehealth.ncptsd.covid.CComp.g.X)) {
            D2();
        } else if (this.G0.f().equals(gov.va.mobilehealth.ncptsd.covid.CComp.g.Z) || this.G0.f().equals(gov.va.mobilehealth.ncptsd.covid.CComp.g.Y)) {
            y2();
        } else if (this.G0.f().equals(gov.va.mobilehealth.ncptsd.covid.CComp.g.b0)) {
            E2();
        } else {
            C2();
        }
    }

    public void B2() {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(n(), Q(R.string.media_content_for_this_tool_doesnt_exist_anymore));
        h2.k(R.string.ok, new d());
        h2.a().show();
    }

    public void C2() {
        x i2 = t.g().i(this.G0.d());
        i2.h(gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()), 0);
        i2.e(this.m0);
        z2(this.l0, this.n0);
        this.k0.setVisibility(0);
    }

    public void D2() {
        this.i0.setText(this.G0.a());
        this.h0.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.P0);
        x2();
        super.E0();
    }

    public void E2() {
        if (gov.va.mobilehealth.ncptsd.covid.CComp.m.c1(n(), this.G0.d().toString())) {
            z2(this.p0, this.s0);
            this.o0.setVisibility(0);
            this.q0.setVisibility(0);
            this.q0.setOnClickListener(new c());
            u2();
            return;
        }
        B2();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.P0 = new i();
        try {
            n().registerReceiver(this.P0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.I0);
        bundle.putSerializable("selected_tool", this.J0);
        bundle.putSerializable("symptom", this.K0);
        bundle.putInt("old_distress", this.L0);
        bundle.putString("last_tool_name", this.M0);
        super.K0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.I0 = (b0) bundle.getSerializable("tool");
            this.J0 = (b0) bundle.getSerializable("selected_tool");
            this.K0 = (a0) bundle.getSerializable("symptom");
            this.L0 = bundle.getInt("old_distress");
            this.M0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.I0 = (b0) u().getSerializable("tool");
            this.J0 = (b0) u().getSerializable("selected_tool");
            this.K0 = (a0) u().getSerializable("symptom");
            this.L0 = u().getInt("old_distress");
            this.M0 = u().getString("last_tool_name");
            k.b.d.u(n(), "Custom Tool");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_custom_tool, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_delete);
        this.g0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.H0 = this.J0.d() - gov.va.mobilehealth.ncptsd.covid.CComp.g.W;
        this.h0 = (LinearLayout) inflate.findViewById(R.id.show_c_t_layout_text);
        this.i0 = (TextView) inflate.findViewById(R.id.show_c_t_txt_text);
        this.j0 = (ImageView) inflate.findViewById(R.id.show_c_t_txt_img);
        this.k0 = (LinearLayout) inflate.findViewById(R.id.show_c_t_layout_image);
        this.l0 = (ScrollView) inflate.findViewById(R.id.show_c_t_img_layout_caption);
        this.m0 = (ImageView) inflate.findViewById(R.id.show_c_t_img_image);
        this.n0 = (TextView) inflate.findViewById(R.id.show_c_t_img_txt_caption);
        this.o0 = (LinearLayout) inflate.findViewById(R.id.show_c_t_layout_video);
        this.p0 = (ScrollView) inflate.findViewById(R.id.show_c_t_video_layout_caption);
        this.q0 = (RelativeLayout) inflate.findViewById(R.id.show_c_t_videoplayer_layout);
        this.s0 = (TextView) inflate.findViewById(R.id.show_c_t_video_txt_caption);
        this.r0 = (ImageView) inflate.findViewById(R.id.show_c_t_videoplayer_img);
        this.t0 = (LinearLayout) inflate.findViewById(R.id.show_c_t_layout_audio);
        this.u0 = (ScrollView) inflate.findViewById(R.id.show_c_t_audio_layout_caption);
        this.v0 = (FABTracking) inflate.findViewById(R.id.show_c_t_audio_play_pause);
        this.x0 = (TextView) inflate.findViewById(R.id.show_c_t_audio_title_artist);
        this.y0 = (TextView) inflate.findViewById(R.id.show_c_t_audio_txt_time);
        this.w0 = (ImageView) inflate.findViewById(R.id.show_c_t_audio_img);
        this.A0 = (SeekBar) inflate.findViewById(R.id.show_c_t_audio_seekbar);
        this.z0 = (TextView) inflate.findViewById(R.id.show_c_t_audio_txt_caption);
        if (this.K0 == null) {
            this.g0.setVisibility(8);
        }
        this.d0.setOnClickListener(new e());
        this.e0.setOnClickListener(new f());
        this.f0.setOnClickListener(new g());
        this.g0.setOnClickListener(new h());
        this.j0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
        this.w0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
        f.a.a.a.b.d.g y02 = new u(n()).y0(this.H0);
        this.G0 = y02;
        if (y02 == null) {
            n().finish();
        }
        this.O0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.C0(n(), this.J0.d(), this.d0, false));
        this.N0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.B0(n(), this.J0.d(), this.e0, false));
        A2();
        S1(Q(R.string.custom_tool));
        return inflate;
    }

    public void s2() {
        Runnable runnable;
        MediaPlayer mediaPlayer = this.B0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.B0.stop();
            }
            this.B0.release();
        }
        Handler handler = this.C0;
        if (handler != null && (runnable = this.D0) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        s2();
        super.t0();
    }

    public void t2() {
        try {
            if (this.B0.isPlaying()) {
                this.B0.stop();
            }
            this.B0.reset();
            this.B0.setDataSource(n(), this.G0.d());
            this.B0.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void u2() {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.G0.d().getPath());
            this.r0.setImageBitmap(mediaMetadataRetriever.getFrameAtTime());
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (RuntimeException e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (RuntimeException unused2) {
        }
    }

    public void v2() {
        this.C0 = new Handler();
        this.D0 = new b();
        n().runOnUiThread(this.D0);
    }

    public void x2() {
        MediaPlayer mediaPlayer = this.B0;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.B0.pause();
            this.v0.setTrackingId("29521");
            this.v0.setImageResource(R.drawable.icon_play);
            this.v0.setContentDescription(Q(R.string.play_audio));
        }
    }

    public void y2() {
        if (gov.va.mobilehealth.ncptsd.covid.CComp.m.c1(n(), this.G0.d().toString())) {
            if (this.G0.f().equals(gov.va.mobilehealth.ncptsd.covid.CComp.g.Z)) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(n(), this.G0.d());
                String N = gov.va.mobilehealth.ncptsd.covid.CComp.m.N(this.G0.d());
                String extractMetadata = mediaMetadataRetriever.extractMetadata(7);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(2);
                if (extractMetadata != null) {
                    N = extractMetadata;
                } else if (N == null) {
                    N = Q(R.string.no_title);
                }
                StringBuilder sb = new StringBuilder(N);
                sb.append(" - ");
                if (extractMetadata2 == null) {
                    sb.append(Q(R.string.no_artist));
                } else {
                    sb.append(extractMetadata2);
                }
                this.x0.setText(sb);
            } else {
                this.x0.setVisibility(8);
            }
            this.v0.setOnClickListener(new j());
            this.A0.setOnSeekBarChangeListener(new k());
            this.E0 = false;
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.B0 = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.B0.setOnErrorListener(new l());
            this.B0.setOnCompletionListener(new m());
            this.B0.setOnPreparedListener(new a());
            if (this.B0.isPlaying()) {
                this.B0.stop();
            }
            z2(this.u0, this.z0);
            t2();
            this.t0.setVisibility(0);
            return;
        }
        B2();
    }

    public void z2(View view, TextView textView) {
        if (this.G0.a() == null) {
            view.setVisibility(8);
        } else if (!this.G0.a().isEmpty()) {
            textView.setText(this.G0.a());
        } else {
            view.setVisibility(8);
        }
    }
}
