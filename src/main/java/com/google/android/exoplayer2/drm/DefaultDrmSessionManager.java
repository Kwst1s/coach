package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.drm.o;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class DefaultDrmSessionManager<T extends o> implements m<T>, i.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final UUID f4968a;

    /* renamed from: b  reason: collision with root package name */
    private final p<T> f4969b;

    /* renamed from: c  reason: collision with root package name */
    private final s f4970c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, String> f4971d;

    /* renamed from: e  reason: collision with root package name */
    private final j<k> f4972e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4973f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4974g;

    /* renamed from: h  reason: collision with root package name */
    private final List<i<T>> f4975h;

    /* renamed from: i  reason: collision with root package name */
    private final List<i<T>> f4976i;

    /* renamed from: j  reason: collision with root package name */
    private Looper f4977j;

    /* renamed from: k  reason: collision with root package name */
    private int f4978k;
    private byte[] l;
    volatile DefaultDrmSessionManager<T>.c m;

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    private class b implements p.b<T> {
        private b() {
        }

        @Override // com.google.android.exoplayer2.drm.p.b
        public void a(p<? extends T> pVar, byte[] bArr, int i2, int i3, byte[] bArr2) {
            if (DefaultDrmSessionManager.this.f4978k == 0) {
                DefaultDrmSessionManager.this.m.obtainMessage(i2, bArr).sendToTarget();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (i iVar : DefaultDrmSessionManager.this.f4975h) {
                if (iVar.j(bArr)) {
                    iVar.q(message.what);
                    return;
                }
            }
        }
    }

    public DefaultDrmSessionManager(UUID uuid, p<T> pVar, s sVar, HashMap<String, String> hashMap) {
        this(uuid, pVar, sVar, hashMap, false, 3);
    }

    private static List<l.b> j(l lVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(lVar.f5005e);
        for (int i2 = 0; i2 < lVar.f5005e; i2++) {
            l.b n = lVar.n(i2);
            if ((n.n(uuid) || (d.f4925c.equals(uuid) && n.n(d.f4924b))) && (n.f5010f != null || z)) {
                arrayList.add(n);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public DrmSession<T> a(Looper looper, l lVar) {
        List<l.b> list;
        Looper looper2 = this.f4977j;
        e.f(looper2 == null || looper2 == looper);
        if (this.f4975h.isEmpty()) {
            this.f4977j = looper;
            if (this.m == null) {
                this.m = new c(looper);
            }
        }
        i<T> iVar = null;
        if (this.l == null) {
            List<l.b> j2 = j(lVar, this.f4968a, false);
            if (j2.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f4968a);
                this.f4972e.b(new c(missingSchemeDataException));
                return new n(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
            list = j2;
        } else {
            list = null;
        }
        if (this.f4973f) {
            Iterator<i<T>> it = this.f4975h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i<T> next = it.next();
                if (d0.b(next.f4989a, list)) {
                    iVar = next;
                    break;
                }
            }
        } else if (!this.f4975h.isEmpty()) {
            iVar = this.f4975h.get(0);
        }
        if (iVar == null) {
            i<T> iVar2 = new i<>(this.f4968a, this.f4969b, this, list, this.f4978k, this.l, this.f4971d, this.f4970c, looper, this.f4972e, this.f4974g);
            this.f4975h.add(iVar2);
            iVar = iVar2;
        }
        iVar.g();
        return iVar;
    }

    @Override // com.google.android.exoplayer2.drm.i.c
    public void b(i<T> iVar) {
        this.f4976i.add(iVar);
        if (this.f4976i.size() == 1) {
            iVar.w();
        }
    }

    @Override // com.google.android.exoplayer2.drm.i.c
    public void c(Exception exc) {
        for (i<T> iVar : this.f4976i) {
            iVar.s(exc);
        }
        this.f4976i.clear();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public boolean d(l lVar) {
        if (this.l != null) {
            return true;
        }
        if (j(lVar, this.f4968a, true).isEmpty()) {
            if (lVar.f5005e != 1 || !lVar.n(0).n(d.f4924b)) {
                return false;
            }
            m.f("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f4968a);
        }
        String str = lVar.f5004d;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if (("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) && d0.f7006a < 25) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.drm.i.c
    public void e() {
        for (i<T> iVar : this.f4976i) {
            iVar.r();
        }
        this.f4976i.clear();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void f(DrmSession<T> drmSession) {
        if (!(drmSession instanceof n)) {
            i<T> iVar = (i) drmSession;
            if (iVar.x()) {
                this.f4975h.remove(iVar);
                if (this.f4976i.size() > 1 && this.f4976i.get(0) == iVar) {
                    this.f4976i.get(1).w();
                }
                this.f4976i.remove(iVar);
            }
        }
    }

    public final void i(Handler handler, k kVar) {
        this.f4972e.a(handler, kVar);
    }

    public DefaultDrmSessionManager(UUID uuid, p<T> pVar, s sVar, HashMap<String, String> hashMap, boolean z, int i2) {
        e.e(uuid);
        e.e(pVar);
        e.b(!d.f4924b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f4968a = uuid;
        this.f4969b = pVar;
        this.f4970c = sVar;
        this.f4971d = hashMap;
        this.f4972e = new j<>();
        this.f4973f = z;
        this.f4974g = i2;
        this.f4978k = 0;
        this.f4975h = new ArrayList();
        this.f4976i = new ArrayList();
        if (z && d.f4926d.equals(uuid) && d0.f7006a >= 19) {
            pVar.c("sessionSharing", "enable");
        }
        pVar.e(new b());
    }
}
