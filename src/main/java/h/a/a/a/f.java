package h.a.a.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import h.a.a.a.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: MediaCodecDecoder */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    protected String f10215a;

    /* renamed from: b  reason: collision with root package name */
    private h f10216b;

    /* renamed from: c  reason: collision with root package name */
    private int f10217c;

    /* renamed from: d  reason: collision with root package name */
    private MediaFormat f10218d;

    /* renamed from: e  reason: collision with root package name */
    private MediaCodec f10219e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer[] f10220f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer[] f10221g;

    /* renamed from: h  reason: collision with root package name */
    private MediaCodec.BufferInfo f10222h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10223i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10224j;

    /* renamed from: k  reason: collision with root package name */
    private List<a> f10225k;
    private boolean l;
    private boolean m;
    private b n;
    private boolean o;
    private long p;
    private long q;
    private a r;

    /* access modifiers changed from: package-private */
    /* compiled from: MediaCodecDecoder */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f10226a;

        /* renamed from: b  reason: collision with root package name */
        ByteBuffer f10227b;

        /* renamed from: c  reason: collision with root package name */
        long f10228c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10229d;

        /* renamed from: e  reason: collision with root package name */
        boolean f10230e;

        public a() {
            a();
        }

        public void a() {
            this.f10226a = -1;
            this.f10227b = null;
            this.f10228c = -1;
            this.f10229d = false;
            this.f10230e = false;
        }

        public String toString() {
            return "FrameInfo{buffer=" + this.f10226a + ", data=" + this.f10227b + ", presentationTimeUs=" + this.f10228c + ", endOfStream=" + this.f10229d + ", representationChanged=" + this.f10230e + '}';
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MediaCodecDecoder */
    public interface b {
        void a(f fVar);
    }

    public f(h hVar, boolean z, int i2, b bVar) {
        this.f10215a = f.class.getSimpleName();
        this.f10215a = getClass().getSimpleName();
        if (hVar == null || i2 == -1) {
            throw new IllegalArgumentException("no track specified");
        }
        this.f10216b = hVar;
        this.o = z;
        this.f10217c = i2;
        MediaFormat f2 = hVar.f(i2);
        this.f10218d = f2;
        this.n = bVar;
        this.f10219e = MediaCodec.createDecoderByType(f2.getString("mime"));
        this.q = Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
    }

    public final a b(boolean z, boolean z2) {
        while (!this.f10224j) {
            a c2 = c();
            do {
            } while (o(z));
            if (c2 != null) {
                return c2;
            }
            if (!z2) {
                return null;
            }
        }
        Log.d(this.f10215a, "EOS NULL");
        return null;
    }

    public final a c() {
        if (this.f10224j) {
            return null;
        }
        int dequeueOutputBuffer = this.f10219e.dequeueOutputBuffer(this.f10222h, 0);
        boolean z = dequeueOutputBuffer >= 0 && (this.f10222h.flags & 4) != 0;
        this.f10224j = z;
        if (z && this.l) {
            p();
            this.f10224j = false;
            this.l = false;
            this.m = true;
        } else if (dequeueOutputBuffer >= 0) {
            ByteBuffer byteBuffer = this.f10221g[dequeueOutputBuffer];
            if (byteBuffer != null) {
                MediaCodec.BufferInfo bufferInfo = this.f10222h;
                if (bufferInfo.size != 0) {
                    byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.f10222h;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
            }
            a aVar = this.f10225k.get(0);
            aVar.f10226a = dequeueOutputBuffer;
            aVar.f10227b = byteBuffer;
            long j2 = this.f10222h.presentationTimeUs;
            aVar.f10228c = j2;
            boolean z2 = this.f10224j;
            aVar.f10229d = z2;
            if (this.m) {
                this.m = false;
                aVar.f10230e = true;
            }
            if (z2) {
                Log.d(this.f10215a, "EOS output");
            } else {
                this.q = j2;
            }
            return aVar;
        } else if (dequeueOutputBuffer == -3) {
            this.f10221g = this.f10219e.getOutputBuffers();
            Log.d(this.f10215a, "output buffers have changed.");
        } else if (dequeueOutputBuffer == -2) {
            MediaFormat outputFormat = this.f10219e.getOutputFormat();
            String str = this.f10215a;
            Log.d(str, "output format has changed to " + outputFormat);
            n(outputFormat);
        }
        return null;
    }

    public void d() {
        a aVar = this.r;
        if (aVar != null) {
            e(aVar);
        }
    }

    public void e(a aVar) {
        r(aVar);
    }

    public long f() {
        return this.f10216b.b();
    }

    /* access modifiers changed from: protected */
    public final MediaCodec g() {
        return this.f10219e;
    }

    public long h() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public final MediaFormat i() {
        return this.f10218d;
    }

    public long j() {
        return this.p;
    }

    public boolean k() {
        return this.f10216b.g();
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return this.f10224j;
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return this.o;
    }

    /* access modifiers changed from: protected */
    public void n(MediaFormat mediaFormat) {
    }

    public final boolean o(boolean z) {
        boolean z2;
        int i2;
        b bVar;
        b bVar2;
        if (this.f10223i || !x()) {
            return false;
        }
        if (this.f10216b.d() == -1 || this.f10216b.d() == this.f10217c) {
            long j2 = 0;
            int dequeueInputBuffer = this.f10219e.dequeueInputBuffer(0);
            if (dequeueInputBuffer < 0) {
                return false;
            }
            ByteBuffer byteBuffer = this.f10220f[dequeueInputBuffer];
            if (this.f10216b.h()) {
                this.l = true;
                this.f10219e.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                if (this.f10216b.b() <= -1 || (bVar2 = this.n) == null) {
                    return false;
                }
                bVar2.a(this);
                return false;
            }
            if (this.f10216b.b() > -1 && (bVar = this.n) != null) {
                bVar.a(this);
            }
            int i3 = this.f10216b.i(byteBuffer, 0);
            if (i3 < 0) {
                Log.d(this.f10215a, "EOS input");
                this.f10223i = true;
                z2 = false;
                i2 = 0;
            } else {
                j2 = this.f10216b.c();
                i2 = i3;
                z2 = true;
            }
            this.f10219e.queueInputBuffer(dequeueInputBuffer, 0, i2, j2, this.f10223i ? 4 : 0);
            this.p = j2;
            if (!this.f10223i) {
                this.f10216b.a();
            }
            return z2;
        } else if (z) {
            return this.f10216b.a();
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void p() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = Build.VERSION.SDK_INT < 19;
            this.f10218d = this.f10216b.f(this.f10217c);
            this.f10219e.stop();
            if (z) {
                this.f10219e.release();
                this.f10219e = MediaCodec.createDecoderByType(this.f10218d.getString("mime"));
            }
            a(this.f10219e, this.f10218d);
            this.f10219e.start();
            this.f10220f = this.f10219e.getInputBuffers();
            this.f10221g = this.f10219e.getOutputBuffers();
            this.f10222h = new MediaCodec.BufferInfo();
            this.f10223i = false;
            this.f10224j = false;
            this.f10225k = new ArrayList();
            for (int i2 = 0; i2 < this.f10221g.length; i2++) {
                this.f10225k.add(new a());
            }
            String str = this.f10215a;
            Log.d(str, "reinitCodec " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
        } catch (IllegalArgumentException e2) {
            this.f10219e.release();
            Log.e(this.f10215a, "reinitCodec: invalid surface or format");
            throw e2;
        } catch (IllegalStateException e3) {
            this.f10219e.release();
            Log.e(this.f10215a, "reinitCodec: illegal state");
            throw e3;
        }
    }

    public void q() {
        this.f10219e.stop();
        this.f10219e.release();
        Log.d(this.f10215a, "decoder released");
    }

    public void r(a aVar) {
        this.f10219e.releaseOutputBuffer(aVar.f10226a, false);
        s(aVar);
    }

    /* access modifiers changed from: protected */
    public final void s(a aVar) {
        aVar.a();
        this.f10225k.add(aVar);
    }

    public void t() {
        a aVar = this.r;
        if (aVar != null) {
            u(aVar, 0);
        }
    }

    public void u(a aVar, long j2) {
        r(aVar);
    }

    /* access modifiers changed from: protected */
    public a v(i.n nVar, long j2, h hVar, MediaCodec mediaCodec) {
        if (this.o) {
            this.f10223i = false;
            this.f10224j = false;
            mediaCodec.flush();
            return null;
        }
        String str = this.f10215a;
        Log.d(str, "seeking to:                 " + j2);
        String str2 = this.f10215a;
        Log.d(str2, "extractor current position: " + hVar.c());
        hVar.l(j2, nVar.a());
        String str3 = this.f10215a;
        Log.d(str3, "extractor new position:     " + hVar.c());
        this.f10223i = false;
        this.f10224j = false;
        mediaCodec.flush();
        if (hVar.h()) {
            p();
            this.m = true;
        }
        return b(true, true);
    }

    public final void w(i.n nVar, long j2) {
        this.q = Long.MIN_VALUE;
        this.p = -1;
        this.r = v(nVar, j2, this.f10216b, this.f10219e);
    }

    /* access modifiers changed from: protected */
    public boolean x() {
        return true;
    }

    public final void y() {
        if (!this.o) {
            while (true) {
                int d2 = this.f10216b.d();
                if (d2 != -1 && d2 != this.f10217c && !this.f10223i) {
                    this.f10216b.a();
                } else {
                    return;
                }
            }
        }
    }
}
