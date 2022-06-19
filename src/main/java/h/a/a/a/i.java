package h.a.a.a;

import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.github.mikephil.charting.utils.Utils;
import h.a.a.a.f;
import h.a.a.a.l;
import java.io.IOException;

/* compiled from: MediaPlayer */
public class i {
    private static final String O = "i";
    private l A;
    private d B;
    private f C;
    private PowerManager.WakeLock D = null;
    private boolean E;
    private boolean F;
    private boolean G;
    private a H;
    private c I;
    private boolean J;
    private p K = p.AUTO;
    private final l L = new l();
    private o M = o.IDLE;
    private Object N;

    /* renamed from: a  reason: collision with root package name */
    private n f10232a = n.EXACT;

    /* renamed from: b  reason: collision with root package name */
    private Surface f10233b;

    /* renamed from: c  reason: collision with root package name */
    private SurfaceHolder f10234c;

    /* renamed from: d  reason: collision with root package name */
    private h f10235d;

    /* renamed from: e  reason: collision with root package name */
    private h f10236e;

    /* renamed from: f  reason: collision with root package name */
    private int f10237f;

    /* renamed from: g  reason: collision with root package name */
    private MediaFormat f10238g;

    /* renamed from: h  reason: collision with root package name */
    private long f10239h;

    /* renamed from: i  reason: collision with root package name */
    private int f10240i;

    /* renamed from: j  reason: collision with root package name */
    private MediaFormat f10241j;

    /* renamed from: k  reason: collision with root package name */
    private int f10242k = 0;
    private float l = 1.0f;
    private float m = 1.0f;
    private m n = null;
    private long o;
    private long p;
    private boolean q;
    private int r;
    private k s = new k();
    private c t = new c(this, null);
    private AbstractC0232i u;
    private e v;
    private k w;
    private j x;
    private g y;
    private h z;

    /* access modifiers changed from: package-private */
    /* compiled from: MediaPlayer */
    public class a implements f.b {
        a() {
        }

        @Override // h.a.a.a.f.b
        public void a(f fVar) {
            if (i.this.n != null && !i.this.n.b() && !i.this.J && i.this.I.d() < 2000000 && !i.this.I.i()) {
                i.this.J = true;
                i.this.t.sendMessage(i.this.t.obtainMessage(200, 701, 0));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MediaPlayer */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10244a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                h.a.a.a.i$p[] r0 = h.a.a.a.i.p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                h.a.a.a.i.b.f10244a = r0
                h.a.a.a.i$p r1 = h.a.a.a.i.p.AUTO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = h.a.a.a.i.b.f10244a     // Catch:{ NoSuchFieldError -> 0x001d }
                h.a.a.a.i$p r1 = h.a.a.a.i.p.SLEEP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = h.a.a.a.i.b.f10244a     // Catch:{ NoSuchFieldError -> 0x0028 }
                h.a.a.a.i$p r1 = h.a.a.a.i.p.SURFACEVIEW_TIMESTAMP_API21     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.i.b.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MediaPlayer */
    public class c extends Handler {
        private c() {
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Log.d(i.O, "onPrepared");
                if (i.this.u != null) {
                    i.this.u.a(i.this);
                }
            } else if (i2 == 2) {
                Log.d(i.O, "onPlaybackComplete");
                if (i.this.v != null) {
                    i.this.v.a(i.this);
                }
                i.this.e0(false);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    Log.d(i.O, "onSeekComplete");
                    if (i.this.x != null) {
                        i.this.x.a(i.this);
                    }
                } else if (i2 == 5) {
                    Log.d(i.O, "onVideoSizeChanged");
                    if (i.this.A != null) {
                        i.this.A.a(i.this, message.arg1, message.arg2);
                    }
                } else if (i2 == 100) {
                    String str = i.O;
                    Log.e(str, "Error (" + message.arg1 + "," + message.arg2 + ")");
                    boolean a2 = i.this.y != null ? i.this.y.a(i.this, message.arg1, message.arg2) : false;
                    if (i.this.v != null && !a2) {
                        i.this.v.a(i.this);
                    }
                    i.this.e0(false);
                } else if (i2 == 200) {
                    Log.d(i.O, "onInfo");
                    if (i.this.z != null) {
                        i.this.z.a(i.this, message.arg1, message.arg2);
                    }
                } else if (i2 == 1000 && i.this.C != null) {
                    i.this.C.a(i.this, (b) message.obj);
                }
            } else if (i.this.B != null) {
                i.this.B.a(i.this, message.arg1);
            }
        }

        /* synthetic */ c(i iVar, a aVar) {
            this();
        }
    }

    /* compiled from: MediaPlayer */
    public interface d {
        void a(i iVar, int i2);
    }

    /* compiled from: MediaPlayer */
    public interface e {
        void a(i iVar);
    }

    /* compiled from: MediaPlayer */
    public interface f {
        void a(i iVar, b bVar);
    }

    /* compiled from: MediaPlayer */
    public interface g {
        boolean a(i iVar, int i2, int i3);
    }

    /* compiled from: MediaPlayer */
    public interface h {
        boolean a(i iVar, int i2, int i3);
    }

    /* renamed from: h.a.a.a.i$i  reason: collision with other inner class name */
    /* compiled from: MediaPlayer */
    public interface AbstractC0232i {
        void a(i iVar);
    }

    /* compiled from: MediaPlayer */
    public interface j {
        void a(i iVar);
    }

    /* compiled from: MediaPlayer */
    public interface k {
        void a(i iVar);
    }

    /* compiled from: MediaPlayer */
    public interface l {
        void a(i iVar, int i2, int i3);
    }

    /* access modifiers changed from: private */
    /* compiled from: MediaPlayer */
    public class m extends HandlerThread implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private Handler f10246b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10247c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f10248d = false;

        /* renamed from: e  reason: collision with root package name */
        private f.a f10249e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10250f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10251g;

        /* renamed from: h  reason: collision with root package name */
        private double f10252h;

        /* renamed from: i  reason: collision with root package name */
        private long f10253i;

        /* renamed from: j  reason: collision with root package name */
        private long f10254j;

        /* renamed from: k  reason: collision with root package name */
        private l.b f10255k;

        /* compiled from: MediaPlayer */
        class a implements l.b {
            a(i iVar) {
            }

            @Override // h.a.a.a.l.b
            public void a(b bVar) {
                i.this.t.sendMessage(i.this.t.obtainMessage(1000, bVar));
            }
        }

        public m() {
            super(i.O + "#" + m.class.getSimpleName(), -16);
            this.f10250f = i.this.K.a();
            this.f10251g = true;
            this.f10253i = 0;
            this.f10254j = 0;
            this.f10255k = new a(i.this);
        }

        private void c() {
            f.a aVar;
            long d2 = i.this.I.d();
            if (d2 != -1) {
                long g2 = i.this.I.g();
                if (g2 == -1) {
                    g2 = i.this.o;
                }
                double G = (double) (i.this.G() * 1000);
                Double.isNaN(G);
                double d3 = (double) (g2 + d2);
                Double.isNaN(d3);
                s((int) ((100.0d / G) * d3));
            }
            if (!i.this.J || d2 <= -1 || d2 >= 2000000 || i.this.I.i()) {
                if (i.this.I.h() != null && this.f10249e == null) {
                    f.a b2 = i.this.I.b(false);
                    this.f10249e = b2;
                    if (b2 == null && !i.this.I.j()) {
                        this.f10246b.sendEmptyMessageDelayed(4, 10);
                        return;
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (i.this.J) {
                    i.this.J = false;
                    i.this.t.sendMessage(i.this.t.obtainMessage(200, 702, 0));
                    i.this.s.g(i.this.I.e());
                }
                if (this.f10249e == null || i.this.s.b(this.f10249e.f10228c) <= 60000) {
                    i iVar = i.this;
                    iVar.o = iVar.I.e();
                    if (i.this.L.a() > 0 && elapsedRealtime - this.f10254j > 100) {
                        this.f10254j = elapsedRealtime;
                        i.this.L.b((int) (i.this.o / 1000), this.f10255k);
                    }
                    if (!(i.this.I.h() == null || (aVar = this.f10249e) == null)) {
                        n(aVar);
                        this.f10249e = null;
                        if (this.f10251g) {
                            this.f10251g = false;
                            i.this.t.sendMessage(i.this.t.obtainMessage(200, 3, 0));
                        }
                    }
                    if (i.this.H != null) {
                        if (this.f10252h != i.this.s.c()) {
                            this.f10252h = i.this.s.c();
                            i.this.H.s((float) this.f10252h);
                        }
                        long h2 = i.this.H.h();
                        if (h2 > a.q) {
                            i.this.s.g(h2);
                        }
                    }
                    if (i.this.I.j()) {
                        i.this.t.sendEmptyMessage(2);
                        if (i.this.G) {
                            if (i.this.H != null) {
                                i.this.H.e();
                            }
                            i.this.I.m(n.FAST_TO_PREVIOUS_SYNC, 0);
                            i.this.L.d(0);
                            i.this.I.l();
                        } else {
                            this.f10247c = true;
                            f(true);
                        }
                    } else {
                        this.f10249e = i.this.I.b(false);
                    }
                    if (!this.f10247c) {
                        double d4 = (double) 10;
                        double c2 = i.this.s.c();
                        Double.isNaN(d4);
                        long elapsedRealtime2 = ((long) (d4 / c2)) - (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (elapsedRealtime2 > 0) {
                            this.f10246b.sendEmptyMessageDelayed(4, elapsedRealtime2);
                        } else {
                            this.f10246b.sendEmptyMessage(4);
                        }
                    }
                } else {
                    this.f10246b.sendEmptyMessageDelayed(4, 50);
                }
            } else {
                this.f10246b.sendEmptyMessageDelayed(4, 100);
            }
        }

        private void e() {
            f(false);
        }

        private void f(boolean z) {
            this.f10246b.removeMessages(4);
            if (i.this.H == null) {
                return;
            }
            if (z) {
                this.f10246b.sendEmptyMessageDelayed(7, ((i.this.H.k() + i.this.H.i()) / 1000) + 1);
            } else {
                i.this.H.p(false);
            }
        }

        private void g() {
            if (i.this.H != null) {
                i.this.H.o();
            }
        }

        private void i() {
            if (i.this.I.j()) {
                i.this.o = 0;
                i.this.I.m(n.FAST_TO_PREVIOUS_SYNC, 0);
                i.this.L.d(0);
            }
            i.this.s.g(i.this.I.e());
            if (i.this.H != null) {
                this.f10246b.removeMessages(7);
                i.this.H.q();
            }
            this.f10252h = i.this.s.c();
            if (i.this.H != null) {
                i.this.H.s((float) this.f10252h);
            }
            this.f10246b.removeMessages(4);
            c();
        }

        private void k() {
            try {
                i.this.N();
                i.this.M = o.PREPARED;
                i.this.t.sendEmptyMessage(1);
            } catch (IOException e2) {
                Log.e(i.O, "prepareAsync() failed: cannot decode stream(s)", e2);
                i.this.t.sendMessage(i.this.t.obtainMessage(100, 1, -1004));
                m();
            } catch (IllegalStateException e3) {
                Log.e(i.O, "prepareAsync() failed: something is in a wrong state", e3);
                i.this.t.sendMessage(i.this.t.obtainMessage(100, 1, 0));
                m();
            } catch (IllegalArgumentException e4) {
                Log.e(i.O, "prepareAsync() failed: surface might be gone", e4);
                i.this.t.sendMessage(i.this.t.obtainMessage(100, 1, 0));
                m();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean l() {
            if (!isAlive()) {
                return false;
            }
            this.f10247c = true;
            this.f10248d = true;
            this.f10246b.sendEmptyMessage(6);
            return true;
        }

        private void m() {
            interrupt();
            quit();
            if (!(i.this.I == null || this.f10249e == null)) {
                i.this.I.h().r(this.f10249e);
                this.f10249e = null;
            }
            if (i.this.I != null) {
                i.this.I.k();
            }
            if (i.this.H != null) {
                i.this.H.u();
            }
            i.this.P();
            Log.d(i.O, "PlaybackThread destroyed");
            if (i.this.N != null) {
                synchronized (i.this.N) {
                    i.this.N.notify();
                    i.this.N = null;
                }
            }
        }

        private void n(f.a aVar) {
            if (aVar.f10229d) {
                i.this.I.h().e(aVar);
                return;
            }
            long b2 = i.this.s.b(aVar.f10228c);
            if (b2 < -1000) {
                String str = i.O;
                Log.d(str, "LAGGING " + b2);
                i.this.t.sendMessage(i.this.t.obtainMessage(200, 700, 0));
            }
            if (aVar.f10230e) {
                i.this.t.sendMessage(i.this.t.obtainMessage(5, i.this.I.h().C(), i.this.I.h().A()));
            }
            if (!this.f10250f && b2 > 5000) {
                Thread.sleep(b2 / 1000);
            }
            i.this.I.h().u(aVar, b2);
        }

        private void o(long j2) {
            if (this.f10249e != null) {
                i.this.I.h().e(this.f10249e);
                this.f10249e = null;
            }
            if (i.this.H != null) {
                i.this.H.p(true);
            }
            i.this.I.m(i.this.f10232a, j2);
            i.this.s.g(i.this.I.e());
            boolean hasMessages = this.f10246b.hasMessages(5);
            if (hasMessages) {
                i.this.I.c();
            } else {
                i.this.I.l();
            }
            if (!hasMessages) {
                i iVar = i.this;
                iVar.o = iVar.I.e();
                i.this.q = false;
                i.this.t.sendEmptyMessage(4);
                if (!this.f10247c) {
                    i();
                }
                i.this.L.d((int) (i.this.o / 1000));
            }
        }

        private void r(Surface surface) {
            if (i.this.I != null && i.this.I.h() != null) {
                if (this.f10249e != null) {
                    i.this.I.h().e(this.f10249e);
                    this.f10249e = null;
                }
                i.this.I.h().F(surface);
            }
        }

        private void s(int i2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f10253i > 1000 && i2 != i.this.r) {
                this.f10253i = elapsedRealtime;
                i.this.t.sendMessage(i.this.t.obtainMessage(3, Math.min(i2, 100), 0));
            }
            i.this.r = i2;
        }

        public boolean b() {
            return this.f10247c;
        }

        public void d() {
            this.f10247c = true;
            this.f10246b.sendEmptyMessage(3);
        }

        public void h() {
            this.f10247c = false;
            this.f10246b.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            try {
                if (this.f10248d) {
                    m();
                    return true;
                }
                int i2 = message.what;
                if (i2 != 100) {
                    switch (i2) {
                        case 1:
                            k();
                            return true;
                        case 2:
                            i();
                            return true;
                        case 3:
                            e();
                            return true;
                        case 4:
                            c();
                            return true;
                        case 5:
                            o(((Long) message.obj).longValue());
                            return true;
                        case 6:
                            m();
                            return true;
                        case 7:
                            g();
                            return true;
                        default:
                            Log.d(i.O, "unknown/invalid message");
                            return false;
                    }
                } else {
                    r((Surface) message.obj);
                    return true;
                }
            } catch (InterruptedException e2) {
                Log.d(i.O, "decoder interrupted", e2);
                i.this.t.sendMessage(i.this.t.obtainMessage(100, 1, 0));
                m();
                return true;
            } catch (IllegalStateException e3) {
                Log.e(i.O, "decoder error, too many instances?", e3);
                i.this.t.sendMessage(i.this.t.obtainMessage(100, 1, 0));
                m();
                return true;
            } catch (IOException e4) {
                Log.e(i.O, "decoder error, codec can not be created", e4);
                i.this.t.sendMessage(i.this.t.obtainMessage(100, 1, -1004));
                m();
                return true;
            }
        }

        public void j() {
            this.f10246b.sendEmptyMessage(1);
        }

        public void p(long j2) {
            this.f10246b.removeMessages(5);
            this.f10246b.obtainMessage(5, Long.valueOf(j2)).sendToTarget();
        }

        public void q(Surface surface) {
            Handler handler = this.f10246b;
            handler.sendMessage(handler.obtainMessage(100, surface));
        }

        public synchronized void start() {
            super.start();
            this.f10246b = new Handler(getLooper(), this);
            Log.d(i.O, "PlaybackThread started");
        }
    }

    /* compiled from: MediaPlayer */
    public enum n {
        FAST(0),
        FAST_TO_PREVIOUS_SYNC(0),
        FAST_TO_NEXT_SYNC(1),
        FAST_TO_CLOSEST_SYNC(2),
        PRECISE(0),
        EXACT(0),
        FAST_EXACT(0);
        

        /* renamed from: b  reason: collision with root package name */
        private int f10265b = 0;

        private n(int i2) {
            this.f10265b = i2;
        }

        public int a() {
            return this.f10265b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MediaPlayer */
    public enum o {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STOPPED,
        RELEASING,
        RELEASED,
        ERROR
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MediaPlayer */
    public enum p {
        AUTO,
        SLEEP,
        SURFACEVIEW_TIMESTAMP_API21;

        public boolean a() {
            int i2 = b.f10244a[ordinal()];
            if (i2 != 1) {
                return i2 == 3;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        }
    }

    private int H(h hVar, String str) {
        if (hVar == null) {
            return -1;
        }
        for (int i2 = 0; i2 < hVar.e(); i2++) {
            MediaFormat f2 = hVar.f(i2);
            Log.d(O, f2.toString());
            if (f2.getString("mime").startsWith(str)) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[Catch:{ Exception -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void N() {
        /*
        // Method dump skipped, instructions count: 312
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.i.N():void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void P() {
        h hVar = this.f10236e;
        if (hVar != null) {
            hVar.j();
            this.f10236e = null;
        }
        h hVar2 = this.f10235d;
        if (hVar2 != null) {
            hVar2.j();
            this.f10235d = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e0(boolean z2) {
        PowerManager.WakeLock wakeLock = this.D;
        if (wakeLock != null) {
            if (z2 && !wakeLock.isHeld()) {
                this.D.acquire();
            } else if (!z2 && this.D.isHeld()) {
                this.D.release();
            }
        }
        this.F = z2;
        g0();
    }

    private void g0() {
        SurfaceHolder surfaceHolder = this.f10234c;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.E && this.F);
        }
    }

    public int F() {
        if (this.M.ordinal() < o.RELEASING.ordinal()) {
            return (int) ((this.q ? this.p : this.o) / 1000);
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public int G() {
        long j2;
        if (this.M.ordinal() > o.PREPARING.ordinal() || this.M.ordinal() < o.RELEASING.ordinal()) {
            MediaFormat mediaFormat = this.f10238g;
            if (mediaFormat != null) {
                j2 = mediaFormat.getLong("durationUs") / 1000;
            } else {
                MediaFormat mediaFormat2 = this.f10241j;
                if (mediaFormat2 == null || !mediaFormat2.containsKey("durationUs")) {
                    return 0;
                }
                j2 = this.f10241j.getLong("durationUs") / 1000;
            }
            return (int) j2;
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public int I() {
        if (this.M.ordinal() < o.RELEASING.ordinal()) {
            MediaFormat mediaFormat = this.f10238g;
            if (mediaFormat != null) {
                return mediaFormat.getInteger("height");
            }
            return 0;
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public int J() {
        if (this.M.ordinal() < o.RELEASING.ordinal()) {
            MediaFormat mediaFormat = this.f10238g;
            if (mediaFormat != null) {
                return (int) (((float) mediaFormat.getInteger("height")) * this.f10238g.getFloat("mpx-dar"));
            }
            return 0;
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public boolean K() {
        if (this.M.ordinal() < o.RELEASING.ordinal()) {
            m mVar = this.n;
            return mVar != null && !mVar.b();
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public void L() {
        if (this.M == o.PREPARED) {
            this.n.d();
            e0(false);
            return;
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public void M() {
        o oVar = this.M;
        if (oVar == o.INITIALIZED || oVar == o.STOPPED) {
            this.M = o.PREPARING;
            m mVar = new m();
            this.n = mVar;
            mVar.start();
            this.n.j();
            return;
        }
        throw new IllegalStateException();
    }

    public void O() {
        o oVar;
        o oVar2 = this.M;
        o oVar3 = o.RELEASING;
        if (oVar2 != oVar3 && oVar2 != (oVar = o.RELEASED)) {
            this.M = oVar3;
            f0();
            P();
            this.M = oVar;
            this.B = null;
            this.v = null;
            this.y = null;
            this.z = null;
            this.u = null;
            this.x = null;
            this.w = null;
            this.A = null;
        }
    }

    public void Q(int i2) {
        R(((long) i2) * 1000);
    }

    public void R(long j2) {
        if (this.M.ordinal() >= o.PREPARED.ordinal() || this.M.ordinal() < o.RELEASING.ordinal()) {
            String str = O;
            Log.d(str, "seekTo " + j2 + " with video sample offset " + this.f10239h);
            k kVar = this.w;
            if (kVar != null) {
                kVar.a(this);
            }
            this.q = true;
            long j3 = this.f10239h + j2;
            this.p = j3;
            this.n.p(j3);
            return;
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    public void S(j jVar) {
        T(jVar, -2, -2);
    }

    public void T(j jVar, int i2, int i3) {
        if (this.M == o.IDLE) {
            P();
            this.f10235d = jVar.b();
            h a2 = jVar.a();
            this.f10236e = a2;
            h hVar = this.f10235d;
            if (hVar != null && a2 == null) {
                this.f10236e = hVar;
            }
            if (i2 == -2) {
                this.f10237f = H(hVar, "video/");
            } else if (i2 != -1) {
                this.f10237f = i2;
            } else {
                this.f10237f = -1;
            }
            if (i3 == -2) {
                this.f10240i = H(this.f10236e, "audio/");
            } else if (i3 != -1) {
                this.f10240i = i3;
            } else {
                this.f10240i = -1;
            }
            int i4 = this.f10237f;
            if (i4 != -1) {
                this.f10235d.m(i4);
                this.f10238g = this.f10235d.f(this.f10237f);
                this.f10239h = this.f10235d.c();
                String str = O;
                Log.d(str, "selected video track #" + this.f10237f + " " + this.f10238g.toString());
            }
            int i5 = this.f10240i;
            if (i5 != -1) {
                this.f10236e.m(i5);
                this.f10241j = this.f10236e.f(this.f10240i);
                this.f10236e.c();
                String str2 = O;
                Log.d(str2, "selected audio track #" + this.f10240i + " " + this.f10241j.toString());
            }
            int i6 = this.f10237f;
            if (i6 == -1) {
                this.f10235d = null;
            }
            if (i6 == -1 && this.f10240i == -1) {
                throw new IOException("invalid data source, no supported stream found");
            }
            if (i6 != -1 && this.n == null && this.f10233b == null) {
                Log.i(O, "no video output surface specified");
            }
            this.M = o.INITIALIZED;
            return;
        }
        throw new IllegalStateException();
    }

    public void U(boolean z2) {
        this.G = z2;
    }

    public void V(e eVar) {
        this.v = eVar;
    }

    public void W(g gVar) {
        this.y = gVar;
    }

    public void X(AbstractC0232i iVar) {
        this.u = iVar;
    }

    public void Y(float f2) {
        if (f2 >= Utils.FLOAT_EPSILON) {
            this.s.e((double) f2);
            this.s.g(this.o);
            return;
        }
        throw new IllegalArgumentException("speed cannot be negative");
    }

    public void Z(boolean z2) {
        if (this.E != z2) {
            if (z2 && this.f10234c == null) {
                Log.w(O, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.E = z2;
            g0();
        }
    }

    public void a0(Surface surface) {
        this.f10233b = surface;
        if (this.E && surface != null) {
            Log.w(O, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.f10234c = null;
        m mVar = this.n;
        if (mVar == null) {
            b0(p.SLEEP);
            g0();
            return;
        }
        mVar.q(this.f10233b);
    }

    /* access modifiers changed from: package-private */
    public void b0(p pVar) {
        if (this.n != null) {
            throw new IllegalStateException("called after prepare/prepareAsync");
        } else if (pVar != p.SURFACEVIEW_TIMESTAMP_API21 || Build.VERSION.SDK_INT >= 21) {
            String str = O;
            Log.d(str, "setVideoRenderTimingMode " + pVar);
            this.K = pVar;
        } else {
            throw new IllegalArgumentException("this mode needs min API 21");
        }
    }

    public void c0(float f2, float f3) {
        this.l = f2;
        this.m = f3;
        a aVar = this.H;
        if (aVar != null) {
            aVar.t(f2, f3);
        }
    }

    public void d0() {
        if (this.M == o.PREPARED) {
            this.n.h();
            e0(true);
            return;
        }
        this.M = o.ERROR;
        throw new IllegalStateException();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f0() {
        /*
            r3 = this;
            h.a.a.a.i$m r0 = r3.n
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.N = r0
            monitor-enter(r0)
            r1 = 0
            h.a.a.a.i$m r2 = r3.n     // Catch:{ InterruptedException -> 0x001f }
            boolean r2 = h.a.a.a.i.m.a(r2)     // Catch:{ InterruptedException -> 0x001f }
            r3.n = r1     // Catch:{ InterruptedException -> 0x001f }
            if (r2 == 0) goto L_0x001f
            java.lang.Object r2 = r3.N     // Catch:{ InterruptedException -> 0x001f }
            r2.wait()     // Catch:{ InterruptedException -> 0x001f }
            goto L_0x001f
        L_0x001d:
            r1 = move-exception
            goto L_0x0023
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            r3.N = r1
            goto L_0x0025
        L_0x0023:
            monitor-exit(r0)
            throw r1
        L_0x0025:
            r0 = 0
            r3.e0(r0)
            h.a.a.a.i$o r0 = h.a.a.a.i.o.STOPPED
            r3.M = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.i.f0():void");
    }
}
