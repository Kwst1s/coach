package f.a.a.a.b.l.i0;

import android.app.Dialog;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.File;
import java.io.IOException;

/* compiled from: DialogFragTones */
public class a extends androidx.fragment.app.c {
    private c l0;
    private RadioGroup m0;
    private TextView n0;
    private TextView o0;
    private String p0;
    private MediaPlayer q0;

    /* renamed from: f.a.a.a.b.l.i0.a$a  reason: collision with other inner class name */
    /* compiled from: DialogFragTones */
    class View$OnClickListenerC0198a implements View.OnClickListener {
        View$OnClickListenerC0198a() {
        }

        public void onClick(View view) {
            a.this.M1();
        }
    }

    /* compiled from: DialogFragTones */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            a.this.l0.k2(a.this.p0);
            a.this.M1();
        }
    }

    /* compiled from: DialogFragTones */
    class c implements RadioGroup.OnCheckedChangeListener {
        c() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case R.id.dialog_frag_tones_radio_bells /*{ENCODED_INT: 2131296658}*/:
                    a.this.p0 = "ThreeBells.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_chimes_1 /*{ENCODED_INT: 2131296659}*/:
                    a.this.p0 = "Chimes1.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_chimes_2 /*{ENCODED_INT: 2131296660}*/:
                    a.this.p0 = "Chimes2.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_chimes_3 /*{ENCODED_INT: 2131296661}*/:
                    a.this.p0 = "Chimes3.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_long_bell /*{ENCODED_INT: 2131296663}*/:
                    a.this.p0 = "LongBell.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_long_bowl /*{ENCODED_INT: 2131296664}*/:
                    a.this.p0 = "LongBowl.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_no_tone /*{ENCODED_INT: 2131296665}*/:
                    a.this.p0 = g.v0;
                    break;
                case R.id.dialog_frag_tones_radio_short_bell /*{ENCODED_INT: 2131296666}*/:
                    a.this.p0 = "ShortBell.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_singing_bowl /*{ENCODED_INT: 2131296667}*/:
                    a.this.p0 = "SingingBowl.mp3";
                    break;
                case R.id.dialog_frag_tones_radio_uplifting /*{ENCODED_INT: 2131296668}*/:
                    a.this.p0 = "Uplifting.mp3";
                    break;
            }
            a.this.Z1();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DialogFragTones */
    public class d implements MediaPlayer.OnCompletionListener {
        d(a aVar) {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DialogFragTones */
    public class e implements MediaPlayer.OnPreparedListener {
        e(a aVar) {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
        }
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void L0() {
        super.L0();
        Dialog O1 = O1();
        if (O1 != null) {
            O1.getWindow().setLayout(-2, -1);
        }
    }

    public void Y1(c cVar, String str) {
        this.l0 = cVar;
        this.p0 = str.toString();
    }

    public void Z1() {
        try {
            if (!this.p0.equals(g.v0)) {
                AssetFileDescriptor c2 = s.c(n(), g.n + File.separator + this.p0);
                MediaPlayer mediaPlayer = this.q0;
                if (mediaPlayer == null) {
                    MediaPlayer mediaPlayer2 = new MediaPlayer();
                    this.q0 = mediaPlayer2;
                    mediaPlayer2.setAudioStreamType(3);
                    this.q0.setOnCompletionListener(new d(this));
                } else if (mediaPlayer.isPlaying()) {
                    this.q0.stop();
                }
                this.q0.setOnPreparedListener(new e(this));
                this.q0.reset();
                this.q0.setDataSource(c2.getFileDescriptor(), c2.getStartOffset(), c2.getLength());
                this.q0.prepareAsync();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a2() {
        if (this.p0.contains("ThreeBells")) {
            this.m0.check(R.id.dialog_frag_tones_radio_bells);
        } else if (this.p0.contains("Chimes1")) {
            this.m0.check(R.id.dialog_frag_tones_radio_chimes_1);
        } else if (this.p0.contains("Chimes2")) {
            this.m0.check(R.id.dialog_frag_tones_radio_chimes_2);
        } else if (this.p0.contains("Chimes3")) {
            this.m0.check(R.id.dialog_frag_tones_radio_chimes_3);
        } else if (this.p0.contains("LongBell")) {
            this.m0.check(R.id.dialog_frag_tones_radio_long_bell);
        } else if (this.p0.contains("LongBowl")) {
            this.m0.check(R.id.dialog_frag_tones_radio_long_bowl);
        } else if (this.p0.contains("ShortBell")) {
            this.m0.check(R.id.dialog_frag_tones_radio_short_bell);
        } else if (this.p0.contains("SingingBowl")) {
            this.m0.check(R.id.dialog_frag_tones_radio_singing_bowl);
        } else if (this.p0.contains(g.v0)) {
            this.m0.check(R.id.dialog_frag_tones_radio_no_tone);
        } else {
            this.m0.check(R.id.dialog_frag_tones_radio_uplifting);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_frag_tones, viewGroup, false);
        this.m0 = (RadioGroup) inflate.findViewById(R.id.dialog_frag_tones_radio_group);
        this.n0 = (TextView) inflate.findViewById(R.id.dialog_frag_tones_txt_cancel);
        this.o0 = (TextView) inflate.findViewById(R.id.dialog_frag_tones_txt_ok);
        this.n0.setOnClickListener(new View$OnClickListenerC0198a());
        this.o0.setOnClickListener(new b());
        a2();
        this.m0.setOnCheckedChangeListener(new c());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        MediaPlayer mediaPlayer = this.q0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.q0.stop();
            }
            this.q0.release();
        }
        super.t0();
    }
}
