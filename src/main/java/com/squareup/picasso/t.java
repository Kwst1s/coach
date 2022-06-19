package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.squareup.picasso.a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Picasso */
public class t {
    static final Handler p = new a(Looper.getMainLooper());
    @SuppressLint({"StaticFieldLeak"})
    static volatile t q = null;

    /* renamed from: a  reason: collision with root package name */
    private final d f8743a;

    /* renamed from: b  reason: collision with root package name */
    private final g f8744b;

    /* renamed from: c  reason: collision with root package name */
    private final c f8745c;

    /* renamed from: d  reason: collision with root package name */
    private final List<y> f8746d;

    /* renamed from: e  reason: collision with root package name */
    final Context f8747e;

    /* renamed from: f  reason: collision with root package name */
    final i f8748f;

    /* renamed from: g  reason: collision with root package name */
    final d f8749g;

    /* renamed from: h  reason: collision with root package name */
    final a0 f8750h;

    /* renamed from: i  reason: collision with root package name */
    final Map<Object, a> f8751i;

    /* renamed from: j  reason: collision with root package name */
    final Map<ImageView, h> f8752j;

    /* renamed from: k  reason: collision with root package name */
    final ReferenceQueue<Object> f8753k;
    final Bitmap.Config l;
    boolean m;
    volatile boolean n;
    boolean o;

    /* compiled from: Picasso */
    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 3) {
                int i3 = 0;
                if (i2 == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i3 < size) {
                        c cVar = (c) list.get(i3);
                        cVar.f8674c.c(cVar);
                        i3++;
                    }
                } else if (i2 == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i3 < size2) {
                        a aVar = (a) list2.get(i3);
                        aVar.f8633a.k(aVar);
                        i3++;
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                a aVar2 = (a) message.obj;
                if (aVar2.g().n) {
                    d0.t("Main", "canceled", aVar2.f8634b.d(), "target got garbage collected");
                }
                aVar2.f8633a.a(aVar2.k());
            }
        }
    }

    /* compiled from: Picasso */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f8754a;

        /* renamed from: b  reason: collision with root package name */
        private j f8755b;

        /* renamed from: c  reason: collision with root package name */
        private ExecutorService f8756c;

        /* renamed from: d  reason: collision with root package name */
        private d f8757d;

        /* renamed from: e  reason: collision with root package name */
        private d f8758e;

        /* renamed from: f  reason: collision with root package name */
        private g f8759f;

        /* renamed from: g  reason: collision with root package name */
        private List<y> f8760g;

        /* renamed from: h  reason: collision with root package name */
        private Bitmap.Config f8761h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8762i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f8763j;

        public b(Context context) {
            if (context != null) {
                this.f8754a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public t a() {
            Context context = this.f8754a;
            if (this.f8755b == null) {
                this.f8755b = new s(context);
            }
            if (this.f8757d == null) {
                this.f8757d = new m(context);
            }
            if (this.f8756c == null) {
                this.f8756c = new v();
            }
            if (this.f8759f == null) {
                this.f8759f = g.f8776a;
            }
            a0 a0Var = new a0(this.f8757d);
            return new t(context, new i(context, this.f8756c, t.p, this.f8755b, this.f8757d, a0Var), this.f8757d, this.f8758e, this.f8759f, this.f8760g, a0Var, this.f8761h, this.f8762i, this.f8763j);
        }
    }

    /* compiled from: Picasso */
    private static class c extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private final ReferenceQueue<Object> f8764b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f8765c;

        /* compiled from: Picasso */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Exception f8766b;

            a(c cVar, Exception exc) {
                this.f8766b = exc;
            }

            public void run() {
                throw new RuntimeException(this.f8766b);
            }
        }

        c(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f8764b = referenceQueue;
            this.f8765c = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0174a aVar = (a.C0174a) this.f8764b.remove(1000);
                    Message obtainMessage = this.f8765c.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f8644a;
                        this.f8765c.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f8765c.post(new a(this, e2));
                    return;
                }
            }
        }
    }

    /* compiled from: Picasso */
    public interface d {
        void a(t tVar, Uri uri, Exception exc);
    }

    /* compiled from: Picasso */
    public enum e {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        

        /* renamed from: b  reason: collision with root package name */
        final int f8771b;

        private e(int i2) {
            this.f8771b = i2;
        }
    }

    /* compiled from: Picasso */
    public enum f {
        LOW,
        NORMAL,
        HIGH
    }

    /* compiled from: Picasso */
    public interface g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f8776a = new a();

        /* compiled from: Picasso */
        static class a implements g {
            a() {
            }

            @Override // com.squareup.picasso.t.g
            public w a(w wVar) {
                return wVar;
            }
        }

        w a(w wVar);
    }

    t(Context context, i iVar, d dVar, d dVar2, g gVar, List<y> list, a0 a0Var, Bitmap.Config config, boolean z, boolean z2) {
        this.f8747e = context;
        this.f8748f = iVar;
        this.f8749g = dVar;
        this.f8743a = dVar2;
        this.f8744b = gVar;
        this.l = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new f(context));
        arrayList.add(new o(context));
        arrayList.add(new g(context));
        arrayList.add(new b(context));
        arrayList.add(new k(context));
        arrayList.add(new r(iVar.f8700d, a0Var));
        this.f8746d = Collections.unmodifiableList(arrayList);
        this.f8750h = a0Var;
        this.f8751i = new WeakHashMap();
        this.f8752j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f8753k = referenceQueue;
        c cVar = new c(referenceQueue, p);
        this.f8745c = cVar;
        cVar.start();
    }

    private void e(Bitmap bitmap, e eVar, a aVar, Exception exc) {
        if (!aVar.l()) {
            if (!aVar.m()) {
                this.f8751i.remove(aVar.k());
            }
            if (bitmap == null) {
                aVar.c(exc);
                if (this.n) {
                    d0.t("Main", "errored", aVar.f8634b.d(), exc.getMessage());
                }
            } else if (eVar != null) {
                aVar.b(bitmap, eVar);
                if (this.n) {
                    String d2 = aVar.f8634b.d();
                    d0.t("Main", "completed", d2, "from " + eVar);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public static t g() {
        if (q == null) {
            synchronized (t.class) {
                if (q == null) {
                    Context context = PicassoProvider.f8632b;
                    if (context != null) {
                        q = new b(context).a();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return q;
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        h remove;
        d0.c();
        a remove2 = this.f8751i.remove(obj);
        if (remove2 != null) {
            remove2.a();
            this.f8748f.c(remove2);
        }
        if ((obj instanceof ImageView) && (remove = this.f8752j.remove((ImageView) obj)) != null) {
            remove.a();
        }
    }

    public void b(ImageView imageView) {
        if (imageView != null) {
            a(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    /* access modifiers changed from: package-private */
    public void c(c cVar) {
        a h2 = cVar.h();
        List<a> i2 = cVar.i();
        boolean z = true;
        boolean z2 = i2 != null && !i2.isEmpty();
        if (h2 == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = cVar.j().f8789d;
            Exception k2 = cVar.k();
            Bitmap s = cVar.s();
            e o2 = cVar.o();
            if (h2 != null) {
                e(s, o2, h2, k2);
            }
            if (z2) {
                int size = i2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e(s, o2, i2.get(i3), k2);
                }
            }
            d dVar = this.f8743a;
            if (!(dVar == null || k2 == null)) {
                dVar.a(this, uri, k2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(ImageView imageView, h hVar) {
        if (this.f8752j.containsKey(imageView)) {
            a(imageView);
        }
        this.f8752j.put(imageView, hVar);
    }

    /* access modifiers changed from: package-private */
    public void f(a aVar) {
        Object k2 = aVar.k();
        if (!(k2 == null || this.f8751i.get(k2) == aVar)) {
            a(k2);
            this.f8751i.put(k2, aVar);
        }
        l(aVar);
    }

    /* access modifiers changed from: package-private */
    public List<y> h() {
        return this.f8746d;
    }

    public x i(Uri uri) {
        return new x(this, uri, 0);
    }

    /* access modifiers changed from: package-private */
    public Bitmap j(String str) {
        Bitmap c2 = this.f8749g.c(str);
        if (c2 != null) {
            this.f8750h.d();
        } else {
            this.f8750h.e();
        }
        return c2;
    }

    /* access modifiers changed from: package-private */
    public void k(a aVar) {
        Bitmap j2 = p.a(aVar.f8637e) ? j(aVar.d()) : null;
        if (j2 != null) {
            e eVar = e.MEMORY;
            e(j2, eVar, aVar, null);
            if (this.n) {
                String d2 = aVar.f8634b.d();
                d0.t("Main", "completed", d2, "from " + eVar);
                return;
            }
            return;
        }
        f(aVar);
        if (this.n) {
            d0.s("Main", "resumed", aVar.f8634b.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void l(a aVar) {
        this.f8748f.h(aVar);
    }

    /* access modifiers changed from: package-private */
    public w m(w wVar) {
        this.f8744b.a(wVar);
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Request transformer " + this.f8744b.getClass().getCanonicalName() + " returned null for " + wVar);
    }
}
