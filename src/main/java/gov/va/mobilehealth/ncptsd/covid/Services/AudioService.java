package gov.va.mobilehealth.ncptsd.covid.Services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
import androidx.core.app.h;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_splash;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import kotlin.m.b.f;

/* compiled from: AudioService.kt */
public final class AudioService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f10180b;

    /* renamed from: c  reason: collision with root package name */
    private String f10181c;

    /* renamed from: d  reason: collision with root package name */
    private String f10182d;

    /* renamed from: e  reason: collision with root package name */
    private final a f10183e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final int f10184f = 1126;

    /* compiled from: AudioService.kt */
    public final class a extends Binder {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final AudioService a() {
            return AudioService.this;
        }
    }

    /* compiled from: AudioService.kt */
    static final class b implements MediaPlayer.OnErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioService f10186a;

        b(AudioService audioService) {
            this.f10186a = audioService;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(this.f10186a.getApplicationContext(), (int) R.string.this_file_cant_be_played, 1).show();
            return false;
        }
    }

    /* compiled from: AudioService.kt */
    static final class c implements MediaPlayer.OnPreparedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioService f10187a;

        c(AudioService audioService) {
            this.f10187a = audioService;
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            this.f10187a.d();
            mediaPlayer.start();
        }
    }

    public final void a(String str, String str2, boolean z) {
        f.e(str, "audioFile");
        f.e(str2, "tool");
        if ((!f.a(this.f10181c, str)) || this.f10181c == null) {
            this.f10181c = str;
            this.f10182d = str2;
            try {
                gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a.b b2 = gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a.a.b(getApplicationContext(), 12, 0);
                AssetFileDescriptor b3 = b2.b("main.12.gov.va.mobilehealth.ncptsd.covid" + File.separator + str);
                MediaPlayer mediaPlayer = this.f10180b;
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        MediaPlayer mediaPlayer2 = this.f10180b;
                        if (mediaPlayer2 != null) {
                            mediaPlayer2.stop();
                        } else {
                            f.p("mPlayer");
                            throw null;
                        }
                    }
                    MediaPlayer mediaPlayer3 = this.f10180b;
                    if (mediaPlayer3 != null) {
                        mediaPlayer3.reset();
                        MediaPlayer mediaPlayer4 = this.f10180b;
                        if (mediaPlayer4 != null) {
                            mediaPlayer4.setLooping(z);
                            MediaPlayer mediaPlayer5 = this.f10180b;
                            if (mediaPlayer5 != null) {
                                f.d(b3, "audioDescriptor");
                                mediaPlayer5.setDataSource(b3.getFileDescriptor(), b3.getStartOffset(), b3.getLength());
                                MediaPlayer mediaPlayer6 = this.f10180b;
                                if (mediaPlayer6 != null) {
                                    mediaPlayer6.prepareAsync();
                                } else {
                                    f.p("mPlayer");
                                    throw null;
                                }
                            } else {
                                f.p("mPlayer");
                                throw null;
                            }
                        } else {
                            f.p("mPlayer");
                            throw null;
                        }
                    } else {
                        f.p("mPlayer");
                        throw null;
                    }
                } else {
                    f.p("mPlayer");
                    throw null;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean b() {
        MediaPlayer mediaPlayer = this.f10180b;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        f.p("mPlayer");
        throw null;
    }

    public final void c() {
        MediaPlayer mediaPlayer = this.f10180b;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        } else {
            f.p("mPlayer");
            throw null;
        }
    }

    public final void d() {
        h.d dVar = new h.d(getApplicationContext(), getString(R.string.notif_player_channel_id_push));
        dVar.q(R.drawable.icon_notif);
        dVar.h(true);
        dVar.o(true);
        dVar.k(getString(R.string.app_name));
        String string = getString(R.string.audio_playing_from);
        f.d(string, "getString(R.string.audio_playing_from)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.f10182d}, 1));
        f.d(format, "java.lang.String.format(this, *args)");
        dVar.j(format);
        dVar.g(b.h.d.a.b(getApplicationContext(), R.color.colorAccent));
        dVar.e(false);
        Intent intent = new Intent(getApplicationContext(), Act_splash.class);
        intent.putExtra("onNotificationStart", true);
        intent.addFlags(268435456);
        PendingIntent.getActivity(getApplicationContext(), this.f10184f, intent, 0);
        startForeground(this.f10184f, dVar.b());
    }

    public final void e() {
        MediaPlayer mediaPlayer = this.f10180b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        } else {
            f.p("mPlayer");
            throw null;
        }
    }

    public final void f() {
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        f.e(intent, "intent");
        return this.f10183e;
    }

    public void onDestroy() {
        MediaPlayer mediaPlayer = this.f10180b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            MediaPlayer mediaPlayer2 = this.f10180b;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
                super.onDestroy();
                return;
            }
            f.p("mPlayer");
            throw null;
        }
        f.p("mPlayer");
        throw null;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f10180b = mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setAudioStreamType(3);
            MediaPlayer mediaPlayer2 = this.f10180b;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setOnErrorListener(new b(this));
                MediaPlayer mediaPlayer3 = this.f10180b;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setOnPreparedListener(new c(this));
                    m.k(getApplicationContext());
                    return super.onStartCommand(intent, i2, i3);
                }
                f.p("mPlayer");
                throw null;
            }
            f.p("mPlayer");
            throw null;
        }
        f.p("mPlayer");
        throw null;
    }

    public void onTaskRemoved(Intent intent) {
        stopForeground(true);
        stopSelf();
        super.onTaskRemoved(intent);
    }
}
