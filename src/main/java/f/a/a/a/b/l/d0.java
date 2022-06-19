package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.z;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_music;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.io.IOException;
import java.util.ArrayList;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_soothing_audio */
public class d0 extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private Button g0;
    private Button h0;
    private TextView i0;
    private TextView j0;
    private FABTracking k0;
    private MediaPlayer l0;
    private b0 m0;
    private b0 n0;
    private a0 o0;
    private int p0;
    private String q0;
    private u r0;
    private int s0 = -1;
    private ArrayList<z> t0;
    private z u0;
    private boolean v0 = true;
    private Boolean w0;
    private Boolean x0;
    private BroadcastReceiver y0;

    /* compiled from: Frag_tool_soothing_audio */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (d0.this.p0 == -1) {
                d0.this.c0.finish();
                return;
            }
            h W1 = h.W1(d0.this.m0, d0.this.o0, d0.this.p0, d0.this.q0);
            W1.V1(d0.this.R1());
            d0.this.c0.W(W1, d0.this.Q(R.string.distress_meter));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_soothing_audio */
    public class b implements MediaPlayer.OnErrorListener {
        b() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(d0.this.n(), (int) R.string.this_file_cant_be_played, 1).show();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_soothing_audio */
    public class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            d0.this.k0.setImageResource(R.drawable.icon_play_white);
            d0.this.k0.setContentDescription(d0.this.Q(R.string.only_play_audio));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_soothing_audio */
    public class d implements MediaPlayer.OnPreparedListener {
        d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            d0.this.k0.setImageResource(R.drawable.icon_pause_white);
            d0.this.k0.setContentDescription(d0.this.Q(R.string.only_pause_audio));
            d0.this.k0.setEnabled(true);
            d0.this.k0.setBackgroundTintList(b.h.d.a.c(d0.this.n(), R.color.colorPrimary));
            d0.this.v0 = false;
            mediaPlayer.start();
        }
    }

    public d0() {
        Boolean bool = Boolean.FALSE;
        this.w0 = bool;
        this.x0 = bool;
    }

    public static d0 e2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        d0 d0Var = new d0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        d0Var.v1(bundle);
        return d0Var;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.y0);
        MediaPlayer mediaPlayer = this.l0;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.l0.pause();
            this.k0.setImageResource(R.drawable.icon_play_white);
            this.k0.setContentDescription(Q(R.string.only_play_audio));
        }
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.y0 = new a();
        try {
            n().registerReceiver(this.y0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        ArrayList<z> t02 = this.r0.t0(n(), true);
        this.t0 = t02;
        if (t02 == null) {
            this.j0.setVisibility(0);
            this.g0.setVisibility(8);
            this.k0.setEnabled(false);
            this.k0.setBackgroundTintList(b.h.d.a.c(n(), R.color.grey_dark));
        } else if (t02.isEmpty()) {
            this.j0.setVisibility(0);
            this.g0.setVisibility(8);
            this.k0.setEnabled(false);
            this.k0.setBackgroundTintList(b.h.d.a.c(n(), R.color.grey_dark));
        } else {
            this.j0.setVisibility(8);
            this.g0.setVisibility(0);
            this.k0.setEnabled(true);
            this.k0.setBackgroundTintList(b.h.d.a.c(n(), R.color.colorPrimary));
            if (this.s0 == -1) {
                this.s0 = 0;
                this.u0 = this.t0.get(0);
                g2();
            }
        }
        this.j0.sendAccessibilityEvent(32);
        this.g0.sendAccessibilityEvent(32);
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.m0);
        bundle.putSerializable("selected_tool", this.n0);
        bundle.putSerializable("symptom", this.o0);
        bundle.putInt("old_distress", this.p0);
        bundle.putString("last_tool_name", this.q0);
        super.K0(bundle);
    }

    public void d2() {
        try {
            if (this.l0.isPlaying()) {
                this.l0.stop();
            }
            this.l0.reset();
            this.l0.setDataSource(n(), this.u0.d());
            this.l0.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void f2() {
        g2();
        if (this.l0 == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.l0 = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.l0.setOnErrorListener(new b());
            this.l0.setOnCompletionListener(new c());
            this.l0.setOnPreparedListener(new d());
            d2();
            return;
        }
        d2();
    }

    public void g2() {
        StringBuilder sb = new StringBuilder();
        if (this.u0.a() != null) {
            sb.append(this.u0.a());
            sb.append("\n");
        }
        if (this.u0.c() != null) {
            sb.append(this.u0.c());
        } else {
            sb.append(Q(R.string.no_title));
        }
        this.i0.setText(sb);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.m0 = (b0) bundle.getSerializable("tool");
            this.n0 = (b0) bundle.getSerializable("selected_tool");
            this.o0 = (a0) bundle.getSerializable("symptom");
            this.p0 = bundle.getInt("old_distress");
            this.q0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.m0 = (b0) u().getSerializable("tool");
            this.n0 = (b0) u().getSerializable("selected_tool");
            this.o0 = (a0) u().getSerializable("symptom");
            this.p0 = u().getInt("old_distress");
            this.q0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.n0.g());
        }
    }

    public void onClick(View view) {
        ArrayList<z> arrayList;
        if (view.getId() == this.k0.getId()) {
            if (this.v0) {
                f2();
            } else if (this.l0.isPlaying()) {
                this.l0.pause();
                this.k0.setTrackingId("29521");
                this.k0.setImageResource(R.drawable.icon_play_white);
                this.k0.setContentDescription(Q(R.string.only_play_audio));
                this.k0.announceForAccessibility(Q(R.string.only_play_audio));
            } else {
                this.l0.start();
                this.k0.setTrackingId("30017");
                this.k0.setImageResource(R.drawable.icon_pause_white);
                this.k0.setContentDescription(Q(R.string.only_pause_audio));
                this.k0.announceForAccessibility(Q(R.string.only_pause_audio));
            }
        }
        if (view.getId() == this.g0.getId() && (arrayList = this.t0) != null && !arrayList.isEmpty()) {
            int i2 = this.s0 + 1;
            this.s0 = i2;
            if (i2 >= this.t0.size()) {
                this.s0 = 0;
            }
            this.u0 = this.t0.get(this.s0);
            f2();
            g2();
            this.g0.announceForAccessibility(Q(R.string.song_changed));
        }
        if (view.getId() == this.h0.getId()) {
            Intent intent = new Intent(n(), Act_music.class);
            intent.putExtra("soothing", true);
            F1(intent);
        }
        if (view.getId() == this.d0.getId()) {
            this.x0 = Boolean.valueOf(m.o(n(), this.n0, this.d0, this.e0, this.x0, this.w0));
            this.w0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.w0 = Boolean.valueOf(m.n(n(), this.n0, this.d0, this.e0, this.x0, this.w0));
            this.x0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.o0, this.m0, this.p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_audioplayer_audio, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (Button) inflate.findViewById(R.id.audioplayer_btn_next);
        this.h0 = (Button) inflate.findViewById(R.id.audioplayer_btn_edit_list);
        this.j0 = (TextView) inflate.findViewById(R.id.audioplayer_no_audio);
        this.i0 = (TextView) inflate.findViewById(R.id.audioplayer_txt_title);
        this.k0 = (FABTracking) inflate.findViewById(R.id.audioplayer_play_pause);
        inflate.findViewById(R.id.bottom_tool_layout).setVisibility(0);
        if (this.o0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.k0.setOnClickListener(this);
        this.k0.setEnabled(false);
        this.k0.setBackgroundTintList(b.h.d.a.c(n(), R.color.grey_dark));
        m.f0(this.n0.d(), this.d0, this.e0);
        this.x0 = Boolean.valueOf(m.C0(n(), this.n0.d(), this.d0, false));
        this.w0 = Boolean.valueOf(m.B0(n(), this.n0.d(), this.e0, false));
        this.i0.setText(R.string.soothing_audio_title);
        this.r0 = new u(n());
        if (this.u0 != null) {
            g2();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        MediaPlayer mediaPlayer = this.l0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.l0.stop();
            }
            this.l0.release();
        }
        super.t0();
    }
}
