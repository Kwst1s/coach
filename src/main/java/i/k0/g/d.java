package i.k0.g;

import j.l;
import j.s;
import j.t;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: DiskLruCache */
public final class d implements Closeable, Flushable {
    static final Pattern v = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b  reason: collision with root package name */
    final i.k0.j.a f10471b;

    /* renamed from: c  reason: collision with root package name */
    final File f10472c;

    /* renamed from: d  reason: collision with root package name */
    private final File f10473d;

    /* renamed from: e  reason: collision with root package name */
    private final File f10474e;

    /* renamed from: f  reason: collision with root package name */
    private final File f10475f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10476g;

    /* renamed from: h  reason: collision with root package name */
    private long f10477h;

    /* renamed from: i  reason: collision with root package name */
    final int f10478i;

    /* renamed from: j  reason: collision with root package name */
    private long f10479j = 0;

    /* renamed from: k  reason: collision with root package name */
    j.d f10480k;
    final LinkedHashMap<String, C0234d> l = new LinkedHashMap<>(0, 0.75f, true);
    int m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    private long s = 0;
    private final Executor t;
    private final Runnable u = new a();

    /* compiled from: DiskLruCache */
    class a implements Runnable {
        a() {
        }

        public void run() {
            synchronized (d.this) {
                d dVar = d.this;
                if (!(!dVar.o) && !dVar.p) {
                    try {
                        dVar.V();
                    } catch (IOException unused) {
                        d.this.q = true;
                    }
                    try {
                        if (d.this.N()) {
                            d.this.S();
                            d.this.m = 0;
                        }
                    } catch (IOException unused2) {
                        d dVar2 = d.this;
                        dVar2.r = true;
                        dVar2.f10480k = l.c(l.b());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DiskLruCache */
    public class b extends e {
        b(s sVar) {
            super(sVar);
        }

        /* access modifiers changed from: protected */
        @Override // i.k0.g.e
        public void l(IOException iOException) {
            d.this.n = true;
        }
    }

    /* compiled from: DiskLruCache */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        final C0234d f10483a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f10484b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10485c;

        /* access modifiers changed from: package-private */
        /* compiled from: DiskLruCache */
        public class a extends e {
            a(s sVar) {
                super(sVar);
            }

            /* access modifiers changed from: protected */
            @Override // i.k0.g.e
            public void l(IOException iOException) {
                synchronized (d.this) {
                    c.this.c();
                }
            }
        }

        c(C0234d dVar) {
            this.f10483a = dVar;
            this.f10484b = dVar.f10492e ? null : new boolean[d.this.f10478i];
        }

        public void a() {
            synchronized (d.this) {
                if (!this.f10485c) {
                    if (this.f10483a.f10493f == this) {
                        d.this.F(this, false);
                    }
                    this.f10485c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public void b() {
            synchronized (d.this) {
                if (!this.f10485c) {
                    if (this.f10483a.f10493f == this) {
                        d.this.F(this, true);
                    }
                    this.f10485c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f10483a.f10493f == this) {
                int i2 = 0;
                while (true) {
                    d dVar = d.this;
                    if (i2 < dVar.f10478i) {
                        try {
                            dVar.f10471b.a(this.f10483a.f10491d[i2]);
                        } catch (IOException unused) {
                        }
                        i2++;
                    } else {
                        this.f10483a.f10493f = null;
                        return;
                    }
                }
            }
        }

        public s d(int i2) {
            synchronized (d.this) {
                if (!this.f10485c) {
                    C0234d dVar = this.f10483a;
                    if (dVar.f10493f != this) {
                        return l.b();
                    }
                    if (!dVar.f10492e) {
                        this.f10484b[i2] = true;
                    }
                    try {
                        return new a(d.this.f10471b.c(dVar.f10491d[i2]));
                    } catch (FileNotFoundException unused) {
                        return l.b();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i.k0.g.d$d  reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    public final class C0234d {

        /* renamed from: a  reason: collision with root package name */
        final String f10488a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f10489b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f10490c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f10491d;

        /* renamed from: e  reason: collision with root package name */
        boolean f10492e;

        /* renamed from: f  reason: collision with root package name */
        c f10493f;

        /* renamed from: g  reason: collision with root package name */
        long f10494g;

        C0234d(String str) {
            this.f10488a = str;
            int i2 = d.this.f10478i;
            this.f10489b = new long[i2];
            this.f10490c = new File[i2];
            this.f10491d = new File[i2];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i3 = 0; i3 < d.this.f10478i; i3++) {
                sb.append(i3);
                this.f10490c[i3] = new File(d.this.f10472c, sb.toString());
                sb.append(".tmp");
                this.f10491d[i3] = new File(d.this.f10472c, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            if (strArr.length == d.this.f10478i) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f10489b[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        /* access modifiers changed from: package-private */
        public e c() {
            if (Thread.holdsLock(d.this)) {
                t[] tVarArr = new t[d.this.f10478i];
                long[] jArr = (long[]) this.f10489b.clone();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    try {
                        d dVar = d.this;
                        if (i3 >= dVar.f10478i) {
                            return new e(this.f10488a, this.f10494g, tVarArr, jArr);
                        }
                        tVarArr[i3] = dVar.f10471b.b(this.f10490c[i3]);
                        i3++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            d dVar2 = d.this;
                            if (i2 >= dVar2.f10478i || tVarArr[i2] == null) {
                                try {
                                    dVar2.U(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                i.k0.e.d(tVarArr[i2]);
                                i2++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(j.d dVar) {
            for (long j2 : this.f10489b) {
                dVar.p(32).z(j2);
            }
        }
    }

    /* compiled from: DiskLruCache */
    public final class e implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f10496b;

        /* renamed from: c  reason: collision with root package name */
        private final long f10497c;

        /* renamed from: d  reason: collision with root package name */
        private final t[] f10498d;

        e(String str, long j2, t[] tVarArr, long[] jArr) {
            this.f10496b = str;
            this.f10497c = j2;
            this.f10498d = tVarArr;
        }

        public t E(int i2) {
            return this.f10498d[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (t tVar : this.f10498d) {
                i.k0.e.d(tVar);
            }
        }

        @Nullable
        public c l() {
            return d.this.J(this.f10496b, this.f10497c);
        }
    }

    d(i.k0.j.a aVar, File file, int i2, int i3, long j2, Executor executor) {
        this.f10471b = aVar;
        this.f10472c = file;
        this.f10476g = i2;
        this.f10473d = new File(file, "journal");
        this.f10474e = new File(file, "journal.tmp");
        this.f10475f = new File(file, "journal.bkp");
        this.f10478i = i3;
        this.f10477h = j2;
        this.t = executor;
    }

    private synchronized void E() {
        if (M()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static d G(i.k0.j.a aVar, File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            return new d(aVar, file, i2, i3, j2, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), i.k0.e.F("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private j.d O() {
        return l.c(new b(this.f10471b.e(this.f10473d)));
    }

    private void P() {
        this.f10471b.a(this.f10474e);
        Iterator<C0234d> it = this.l.values().iterator();
        while (it.hasNext()) {
            C0234d next = it.next();
            int i2 = 0;
            if (next.f10493f == null) {
                while (i2 < this.f10478i) {
                    this.f10479j += next.f10489b[i2];
                    i2++;
                }
            } else {
                next.f10493f = null;
                while (i2 < this.f10478i) {
                    this.f10471b.a(next.f10490c[i2]);
                    this.f10471b.a(next.f10491d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ad, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        if (r1 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
        l(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Q() {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: i.k0.g.d.Q():void");
    }

    private void R(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.l.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            C0234d dVar = this.l.get(str2);
            if (dVar == null) {
                dVar = new C0234d(str2);
                this.l.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f10492e = true;
                dVar.f10493f = null;
                dVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f10493f = new c(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void W(String str) {
        if (!v.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private static /* synthetic */ void l(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void F(c cVar, boolean z) {
        C0234d dVar = cVar.f10483a;
        if (dVar.f10493f == cVar) {
            if (z && !dVar.f10492e) {
                for (int i2 = 0; i2 < this.f10478i; i2++) {
                    if (!cVar.f10484b[i2]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!this.f10471b.f(dVar.f10491d[i2])) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.f10478i; i3++) {
                File file = dVar.f10491d[i3];
                if (!z) {
                    this.f10471b.a(file);
                } else if (this.f10471b.f(file)) {
                    File file2 = dVar.f10490c[i3];
                    this.f10471b.g(file, file2);
                    long j2 = dVar.f10489b[i3];
                    long h2 = this.f10471b.h(file2);
                    dVar.f10489b[i3] = h2;
                    this.f10479j = (this.f10479j - j2) + h2;
                }
            }
            this.m++;
            dVar.f10493f = null;
            if (dVar.f10492e || z) {
                dVar.f10492e = true;
                this.f10480k.y("CLEAN").p(32);
                this.f10480k.y(dVar.f10488a);
                dVar.d(this.f10480k);
                this.f10480k.p(10);
                if (z) {
                    long j3 = this.s;
                    this.s = 1 + j3;
                    dVar.f10494g = j3;
                }
            } else {
                this.l.remove(dVar.f10488a);
                this.f10480k.y("REMOVE").p(32);
                this.f10480k.y(dVar.f10488a);
                this.f10480k.p(10);
            }
            this.f10480k.flush();
            if (this.f10479j > this.f10477h || N()) {
                this.t.execute(this.u);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void H() {
        close();
        this.f10471b.d(this.f10472c);
    }

    @Nullable
    public c I(String str) {
        return J(str, -1);
    }

    /* access modifiers changed from: package-private */
    public synchronized c J(String str, long j2) {
        L();
        E();
        W(str);
        C0234d dVar = this.l.get(str);
        if (j2 != -1 && (dVar == null || dVar.f10494g != j2)) {
            return null;
        }
        if (dVar != null && dVar.f10493f != null) {
            return null;
        }
        if (this.q || this.r) {
            this.t.execute(this.u);
            return null;
        }
        this.f10480k.y("DIRTY").p(32).y(str).p(10);
        this.f10480k.flush();
        if (this.n) {
            return null;
        }
        if (dVar == null) {
            dVar = new C0234d(str);
            this.l.put(str, dVar);
        }
        c cVar = new c(dVar);
        dVar.f10493f = cVar;
        return cVar;
    }

    public synchronized e K(String str) {
        L();
        E();
        W(str);
        C0234d dVar = this.l.get(str);
        if (dVar != null) {
            if (dVar.f10492e) {
                e c2 = dVar.c();
                if (c2 == null) {
                    return null;
                }
                this.m++;
                this.f10480k.y("READ").p(32).y(str).p(10);
                if (N()) {
                    this.t.execute(this.u);
                }
                return c2;
            }
        }
        return null;
    }

    public synchronized void L() {
        if (!this.o) {
            if (this.f10471b.f(this.f10475f)) {
                if (this.f10471b.f(this.f10473d)) {
                    this.f10471b.a(this.f10475f);
                } else {
                    this.f10471b.g(this.f10475f, this.f10473d);
                }
            }
            if (this.f10471b.f(this.f10473d)) {
                try {
                    Q();
                    P();
                    this.o = true;
                    return;
                } catch (IOException e2) {
                    i.k0.k.e j2 = i.k0.k.e.j();
                    j2.q(5, "DiskLruCache " + this.f10472c + " is corrupt: " + e2.getMessage() + ", removing", e2);
                    H();
                    this.p = false;
                } catch (Throwable th) {
                    this.p = false;
                    throw th;
                }
            }
            S();
            this.o = true;
        }
    }

    public synchronized boolean M() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        int i2 = this.m;
        return i2 >= 2000 && i2 >= this.l.size();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ba, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bb, code lost:
        if (r0 != null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bd, code lost:
        l(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c0, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void S() {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: i.k0.g.d.S():void");
    }

    public synchronized boolean T(String str) {
        L();
        E();
        W(str);
        C0234d dVar = this.l.get(str);
        if (dVar == null) {
            return false;
        }
        boolean U = U(dVar);
        if (U && this.f10479j <= this.f10477h) {
            this.q = false;
        }
        return U;
    }

    /* access modifiers changed from: package-private */
    public boolean U(C0234d dVar) {
        c cVar = dVar.f10493f;
        if (cVar != null) {
            cVar.c();
        }
        for (int i2 = 0; i2 < this.f10478i; i2++) {
            this.f10471b.a(dVar.f10490c[i2]);
            long j2 = this.f10479j;
            long[] jArr = dVar.f10489b;
            this.f10479j = j2 - jArr[i2];
            jArr[i2] = 0;
        }
        this.m++;
        this.f10480k.y("REMOVE").p(32).y(dVar.f10488a).p(10);
        this.l.remove(dVar.f10488a);
        if (N()) {
            this.t.execute(this.u);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void V() {
        while (this.f10479j > this.f10477h) {
            U(this.l.values().iterator().next());
        }
        this.q = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.o) {
            if (!this.p) {
                for (C0234d dVar : (C0234d[]) this.l.values().toArray(new C0234d[this.l.size()])) {
                    c cVar = dVar.f10493f;
                    if (cVar != null) {
                        cVar.a();
                    }
                }
                V();
                this.f10480k.close();
                this.f10480k = null;
                this.p = true;
                return;
            }
        }
        this.p = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.o) {
            E();
            V();
            this.f10480k.flush();
        }
    }
}
