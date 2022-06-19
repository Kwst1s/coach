package h.a.a.a;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* access modifiers changed from: package-private */
/* compiled from: AudioPlayback */
public class a {
    private static final String p = "a";
    public static long q = Long.MIN_VALUE;

    /* renamed from: a  reason: collision with root package name */
    private MediaFormat f10188a;

    /* renamed from: b  reason: collision with root package name */
    private AudioTrack f10189b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f10190c;

    /* renamed from: d  reason: collision with root package name */
    private int f10191d = 8192;

    /* renamed from: e  reason: collision with root package name */
    private int f10192e;

    /* renamed from: f  reason: collision with root package name */
    private int f10193f;

    /* renamed from: g  reason: collision with root package name */
    private b f10194g = new b();

    /* renamed from: h  reason: collision with root package name */
    private int f10195h;

    /* renamed from: i  reason: collision with root package name */
    private C0230a f10196i;

    /* renamed from: j  reason: collision with root package name */
    private int f10197j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f10198k = 3;
    private float l = 1.0f;
    private float m = 1.0f;
    private long n;
    private long o;

    /* access modifiers changed from: private */
    /* renamed from: h.a.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: AudioPlayback */
    public class C0230a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private final Object f10199b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private boolean f10200c = true;

        C0230a() {
            super(a.p);
        }

        public void a() {
            synchronized (this.f10199b) {
                this.f10199b.notify();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z) {
            this.f10200c = z;
            synchronized (this) {
                notify();
            }
        }

        public void run() {
            b.C0231a e2;
            while (!isInterrupted()) {
                try {
                    synchronized (this) {
                        while (this.f10200c) {
                            wait();
                        }
                    }
                    synchronized (this.f10199b) {
                        while (true) {
                            e2 = a.this.f10194g.e();
                            if (e2 == null) {
                                this.f10199b.wait();
                            }
                        }
                    }
                    a.this.x(e2.f10206a, e2.f10207b);
                    a.this.f10194g.d(e2);
                    break;
                } catch (InterruptedException unused) {
                    interrupt();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AudioPlayback */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f10202a;

        /* renamed from: b  reason: collision with root package name */
        private Queue<C0231a> f10203b = new LinkedList();

        /* renamed from: c  reason: collision with root package name */
        private List<C0231a> f10204c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private int f10205d;

        /* access modifiers changed from: private */
        /* renamed from: h.a.a.a.a$b$a  reason: collision with other inner class name */
        /* compiled from: AudioPlayback */
        public static class C0231a {

            /* renamed from: a  reason: collision with root package name */
            ByteBuffer f10206a;

            /* renamed from: b  reason: collision with root package name */
            long f10207b;

            C0231a(int i2) {
                this.f10206a = ByteBuffer.allocate(i2);
            }
        }

        b() {
        }

        /* access modifiers changed from: package-private */
        public synchronized void b() {
            while (true) {
                C0231a poll = this.f10203b.poll();
                if (poll != null) {
                    d(poll);
                } else {
                    this.f10205d = 0;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void c(ByteBuffer byteBuffer, long j2) {
            C0231a aVar;
            if (byteBuffer.remaining() > this.f10202a) {
                this.f10204c.clear();
                this.f10202a = byteBuffer.remaining();
            }
            if (!this.f10204c.isEmpty()) {
                aVar = this.f10204c.remove(0);
            } else {
                aVar = new C0231a(byteBuffer.remaining());
            }
            aVar.f10206a.limit(byteBuffer.remaining());
            aVar.f10206a.mark();
            aVar.f10206a.put(byteBuffer);
            aVar.f10206a.reset();
            aVar.f10207b = j2;
            this.f10203b.add(aVar);
            this.f10205d += aVar.f10206a.remaining();
        }

        /* access modifiers changed from: package-private */
        public synchronized void d(C0231a aVar) {
            if (aVar.f10206a.capacity() == this.f10202a) {
                aVar.f10206a.rewind();
                this.f10204c.add(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized C0231a e() {
            C0231a poll;
            poll = this.f10203b.poll();
            if (poll != null) {
                this.f10205d -= poll.f10206a.remaining();
            }
            return poll;
        }
    }

    private boolean d(MediaFormat mediaFormat) {
        return (this.f10188a.getInteger("channel-count") == mediaFormat.getInteger("channel-count") && this.f10188a.getInteger("sample-rate") == mediaFormat.getInteger("sample-rate") && this.f10188a.getString("mime").equals(mediaFormat.getString("mime"))) ? false : true;
    }

    private long j() {
        double playbackHeadPosition = (double) (((long) this.f10189b.getPlaybackHeadPosition()) & 4294967295L);
        double d2 = (double) this.f10193f;
        Double.isNaN(playbackHeadPosition);
        Double.isNaN(d2);
        return (long) ((playbackHeadPosition / d2) * 1000000.0d);
    }

    private void v(boolean z) {
        C0230a aVar;
        if (z && (aVar = this.f10196i) != null) {
            aVar.interrupt();
        }
        if (this.f10189b != null) {
            if (m()) {
                this.f10189b.stop();
            }
            this.f10189b.release();
        }
        this.f10189b = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x(ByteBuffer byteBuffer, long j2) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = this.f10190c;
        if (bArr == null || bArr.length < remaining) {
            this.f10190c = new byte[remaining];
        }
        byteBuffer.get(this.f10190c, 0, remaining);
        this.f10189b.write(this.f10190c, 0, remaining);
    }

    public void e() {
        if (m()) {
            boolean n2 = n();
            if (n2) {
                this.f10189b.pause();
            }
            this.f10189b.flush();
            this.f10194g.b();
            this.n = q;
            if (n2) {
                this.f10189b.play();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public int f() {
        return this.f10197j;
    }

    public int g() {
        return this.f10198k;
    }

    public long h() {
        long j2 = this.n;
        long j3 = q;
        if (j2 == j3) {
            return j3;
        }
        long j4 = j();
        if (j4 < this.o) {
            Log.d(p, "playback head has wrapped");
            long j5 = this.n;
            double d2 = (double) this.f10193f;
            Double.isNaN(d2);
            this.n = j5 + ((long) ((-1.0d / d2) * 1000000.0d));
        }
        this.o = j4;
        return this.n + j4;
    }

    public long i() {
        double d2 = (double) (this.f10195h / this.f10192e);
        double d3 = (double) this.f10193f;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (long) ((d2 / d3) * 1000000.0d);
    }

    public long k() {
        double d2 = (double) (this.f10194g.f10205d / this.f10192e);
        double d3 = (double) this.f10193f;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (long) ((d2 / d3) * 1000000.0d);
    }

    public void l(MediaFormat mediaFormat) {
        Log.d(p, "init");
        boolean z = false;
        if (!m()) {
            C0230a aVar = new C0230a();
            this.f10196i = aVar;
            aVar.b(true);
            this.f10196i.start();
        } else if (!d(mediaFormat)) {
            this.f10188a = mediaFormat;
            return;
        } else {
            boolean n2 = n();
            o();
            v(false);
            z = n2;
        }
        this.f10188a = mediaFormat;
        int integer = mediaFormat.getInteger("channel-count");
        this.f10192e = integer * 2;
        this.f10193f = mediaFormat.getInteger("sample-rate");
        int i2 = integer != 1 ? integer != 2 ? integer != 4 ? integer != 6 ? integer != 8 ? 1 : 1020 : 252 : 204 : 12 : 4;
        this.f10195h = this.f10191d * integer;
        AudioTrack audioTrack = new AudioTrack(this.f10198k, this.f10193f, i2, 2, this.f10195h, 1, this.f10197j);
        this.f10189b = audioTrack;
        if (audioTrack.getState() == 1) {
            this.f10197j = this.f10189b.getAudioSessionId();
            this.f10198k = this.f10189b.getStreamType();
            t(this.l, this.m);
            this.n = q;
            if (z) {
                q();
                return;
            }
            return;
        }
        u();
        throw new IllegalStateException("audio track init failed");
    }

    public boolean m() {
        AudioTrack audioTrack = this.f10189b;
        return audioTrack != null && audioTrack.getState() == 1;
    }

    public boolean n() {
        return this.f10189b.getPlayState() == 3;
    }

    public void o() {
        p(true);
    }

    public void p(boolean z) {
        if (m()) {
            this.f10196i.b(true);
            this.f10189b.pause();
            if (z) {
                e();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void q() {
        if (m()) {
            this.f10189b.play();
            this.f10196i.b(false);
            return;
        }
        throw new IllegalStateException();
    }

    public void r(int i2) {
        if (!m()) {
            this.f10197j = i2;
            return;
        }
        throw new IllegalStateException("cannot set session id on an initialized audio track");
    }

    public void s(float f2) {
        if (m()) {
            this.f10189b.setPlaybackRate((int) (((float) this.f10193f) * f2));
            return;
        }
        throw new IllegalStateException();
    }

    public void t(float f2, float f3) {
        this.l = f2;
        this.m = f3;
        AudioTrack audioTrack = this.f10189b;
        if (audioTrack != null) {
            audioTrack.setStereoVolume(f2, f3);
        }
    }

    public void u() {
        v(true);
    }

    public void w(ByteBuffer byteBuffer, long j2) {
        int remaining = byteBuffer.remaining();
        if (this.f10191d < remaining) {
            Log.d(p, "incoming frame chunk size increased to " + remaining);
            this.f10191d = remaining;
            l(this.f10188a);
        }
        if (this.n == q) {
            this.n = j2;
            this.o = 0;
            long j3 = j();
            if (j3 > 0) {
                this.n -= j3;
                Log.d(p, "playback head not reset");
            }
        }
        this.f10194g.c(byteBuffer, j2);
        this.f10196i.a();
    }
}
