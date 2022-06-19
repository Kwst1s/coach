package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.drm.o;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* access modifiers changed from: package-private */
@TargetApi(18)
/* compiled from: DefaultDrmSession */
public class i<T extends o> implements DrmSession<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l.b> f4989a;

    /* renamed from: b  reason: collision with root package name */
    private final p<T> f4990b;

    /* renamed from: c  reason: collision with root package name */
    private final c<T> f4991c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4992d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, String> f4993e;

    /* renamed from: f  reason: collision with root package name */
    private final j<k> f4994f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4995g;

    /* renamed from: h  reason: collision with root package name */
    final s f4996h;

    /* renamed from: i  reason: collision with root package name */
    final UUID f4997i;

    /* renamed from: j  reason: collision with root package name */
    final i<T>.b f4998j;

    /* renamed from: k  reason: collision with root package name */
    private int f4999k;
    private int l;
    private HandlerThread m;
    private i<T>.a n;
    private T o;
    private DrmSession.DrmSessionException p;
    private byte[] q;
    private byte[] r;
    private p.a s;
    private p.c t;

    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* compiled from: DefaultDrmSession */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private long a(int i2) {
            return (long) Math.min((i2 - 1) * 1000, 5000);
        }

        private boolean b(Message message) {
            int i2;
            if (!(message.arg1 == 1) || (i2 = message.arg2 + 1) > i.this.f4995g) {
                return false;
            }
            Message obtain = Message.obtain(message);
            obtain.arg2 = i2;
            sendMessageDelayed(obtain, a(i2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, Object obj, boolean z) {
            obtainMessage(i2, z ? 1 : 0, 0, obj).sendToTarget();
        }

        public void handleMessage(Message message) {
            Object e2;
            Object obj = message.obj;
            try {
                int i2 = message.what;
                if (i2 == 0) {
                    i iVar = i.this;
                    e2 = iVar.f4996h.b(iVar.f4997i, (p.c) obj);
                } else if (i2 == 1) {
                    i iVar2 = i.this;
                    e2 = iVar2.f4996h.a(iVar2.f4997i, (p.a) obj);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e3) {
                e2 = e3;
                if (b(message)) {
                    return;
                }
            }
            i.this.f4998j.obtainMessage(message.what, Pair.create(obj, e2)).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* compiled from: DefaultDrmSession */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 0) {
                i.this.t(obj, obj2);
            } else if (i2 == 1) {
                i.this.n(obj, obj2);
            }
        }
    }

    /* compiled from: DefaultDrmSession */
    public interface c<T extends o> {
        void b(i<T> iVar);

        void c(Exception exc);

        void e();
    }

    public i(UUID uuid, p<T> pVar, c<T> cVar, List<l.b> list, int i2, byte[] bArr, HashMap<String, String> hashMap, s sVar, Looper looper, j<k> jVar, int i3) {
        this.f4997i = uuid;
        this.f4991c = cVar;
        this.f4990b = pVar;
        this.f4992d = i2;
        this.r = bArr;
        this.f4989a = bArr == null ? Collections.unmodifiableList(list) : null;
        this.f4993e = hashMap;
        this.f4996h = sVar;
        this.f4995g = i3;
        this.f4994f = jVar;
        this.f4999k = 2;
        this.f4998j = new b(looper);
        HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new a(this.m.getLooper());
    }

    private void h(boolean z) {
        int i2 = this.f4992d;
        if (i2 == 0 || i2 == 1) {
            if (this.r == null) {
                v(1, z);
            } else if (this.f4999k == 4 || y()) {
                long i3 = i();
                if (this.f4992d == 0 && i3 <= 60) {
                    m.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + i3);
                    v(2, z);
                } else if (i3 <= 0) {
                    m(new KeysExpiredException());
                } else {
                    this.f4999k = 4;
                    this.f4994f.b(e.f4986a);
                }
            }
        } else if (i2 != 2) {
            if (i2 == 3 && y()) {
                v(3, z);
            }
        } else if (this.r == null) {
            v(2, z);
        } else if (y()) {
            v(2, z);
        }
    }

    private long i() {
        if (!d.f4926d.equals(this.f4997i)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> b2 = t.b(this);
        return Math.min(((Long) b2.first).longValue(), ((Long) b2.second).longValue());
    }

    private boolean k() {
        int i2 = this.f4999k;
        return i2 == 3 || i2 == 4;
    }

    private void m(Exception exc) {
        this.p = new DrmSession.DrmSessionException(exc);
        this.f4994f.b(new b(exc));
        if (this.f4999k != 4) {
            this.f4999k = 1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(Object obj, Object obj2) {
        if (obj == this.s && k()) {
            this.s = null;
            if (obj2 instanceof Exception) {
                o((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f4992d == 3) {
                    this.f4990b.f(this.r, bArr);
                    this.f4994f.b(e.f4986a);
                    return;
                }
                byte[] f2 = this.f4990b.f(this.q, bArr);
                int i2 = this.f4992d;
                if (!((i2 != 2 && (i2 != 0 || this.r == null)) || f2 == null || f2.length == 0)) {
                    this.r = f2;
                }
                this.f4999k = 4;
                this.f4994f.b(f.f4987a);
            } catch (Exception e2) {
                o(e2);
            }
        }
    }

    private void o(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.f4991c.b(this);
        } else {
            m(exc);
        }
    }

    private void p() {
        if (this.f4999k == 4) {
            this.f4999k = 3;
            m(new KeysExpiredException());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t(Object obj, Object obj2) {
        if (obj != this.t) {
            return;
        }
        if (this.f4999k == 2 || k()) {
            this.t = null;
            if (obj2 instanceof Exception) {
                this.f4991c.c((Exception) obj2);
                return;
            }
            try {
                this.f4990b.i((byte[]) obj2);
                this.f4991c.e();
            } catch (Exception e2) {
                this.f4991c.c(e2);
            }
        }
    }

    private boolean u(boolean z) {
        if (k()) {
            return true;
        }
        try {
            this.q = this.f4990b.k();
            this.f4994f.b(g.f4988a);
            this.o = this.f4990b.g(this.q);
            this.f4999k = 3;
            return true;
        } catch (NotProvisionedException e2) {
            if (z) {
                this.f4991c.b(this);
                return false;
            }
            m(e2);
            return false;
        } catch (Exception e3) {
            m(e3);
            return false;
        }
    }

    private void v(int i2, boolean z) {
        try {
            p.a j2 = this.f4990b.j(i2 == 3 ? this.r : this.q, this.f4989a, i2, this.f4993e);
            this.s = j2;
            this.n.c(1, j2, z);
        } catch (Exception e2) {
            o(e2);
        }
    }

    private boolean y() {
        try {
            this.f4990b.a(this.q, this.r);
            return true;
        } catch (Exception e2) {
            m.d("DefaultDrmSession", "Error trying to restore Widevine keys.", e2);
            m(e2);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> a() {
        byte[] bArr = this.q;
        if (bArr == null) {
            return null;
        }
        return this.f4990b.b(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final T b() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException c() {
        if (this.f4999k == 1) {
            return this.p;
        }
        return null;
    }

    public void g() {
        int i2 = this.l + 1;
        this.l = i2;
        if (i2 == 1 && this.f4999k != 1 && u(true)) {
            h(true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f4999k;
    }

    public boolean j(byte[] bArr) {
        return Arrays.equals(this.q, bArr);
    }

    public void q(int i2) {
        if (k()) {
            if (i2 == 1) {
                this.f4999k = 3;
                this.f4991c.b(this);
            } else if (i2 == 2) {
                h(false);
            } else if (i2 == 3) {
                p();
            }
        }
    }

    public void r() {
        if (u(false)) {
            h(true);
        }
    }

    public void s(Exception exc) {
        m(exc);
    }

    public void w() {
        p.c h2 = this.f4990b.h();
        this.t = h2;
        this.n.c(0, h2, true);
    }

    public boolean x() {
        int i2 = this.l - 1;
        this.l = i2;
        if (i2 != 0) {
            return false;
        }
        this.f4999k = 0;
        this.f4998j.removeCallbacksAndMessages(null);
        this.n.removeCallbacksAndMessages(null);
        this.n = null;
        this.m.quit();
        this.m = null;
        this.o = null;
        this.p = null;
        this.s = null;
        this.t = null;
        byte[] bArr = this.q;
        if (bArr != null) {
            this.f4990b.d(bArr);
            this.q = null;
            this.f4994f.b(a.f4981a);
        }
        return true;
    }
}
