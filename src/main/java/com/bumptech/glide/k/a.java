package com.bumptech.glide.k;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.github.mikephil.charting.BuildConfig;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache */
public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final File f3556b;

    /* renamed from: c  reason: collision with root package name */
    private final File f3557c;

    /* renamed from: d  reason: collision with root package name */
    private final File f3558d;

    /* renamed from: e  reason: collision with root package name */
    private final File f3559e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3560f;

    /* renamed from: g  reason: collision with root package name */
    private long f3561g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3562h;

    /* renamed from: i  reason: collision with root package name */
    private long f3563i = 0;

    /* renamed from: j  reason: collision with root package name */
    private Writer f3564j;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, d> f3565k = new LinkedHashMap<>(0, 0.75f, true);
    private int l;
    private long m = 0;
    final ThreadPoolExecutor n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> o = new CallableC0085a();

    /* access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.k.a$a  reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    public class CallableC0085a implements Callable<Void> {
        CallableC0085a() {
        }

        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.f3564j == null) {
                    return null;
                }
                a.this.c0();
                if (a.this.U()) {
                    a.this.Z();
                    a.this.l = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache */
    private static final class b implements ThreadFactory {
        private b() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0085a aVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final d f3567a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f3568b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3569c;

        /* synthetic */ c(a aVar, d dVar, CallableC0085a aVar2) {
            this(dVar);
        }

        public void a() {
            a.this.N(this, false);
        }

        public void b() {
            if (!this.f3569c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() {
            a.this.N(this, true);
            this.f3569c = true;
        }

        public File f(int i2) {
            File k2;
            synchronized (a.this) {
                if (this.f3567a.f3576f == this) {
                    if (!this.f3567a.f3575e) {
                        this.f3568b[i2] = true;
                    }
                    k2 = this.f3567a.k(i2);
                    if (!a.this.f3556b.exists()) {
                        a.this.f3556b.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k2;
        }

        private c(d dVar) {
            this.f3567a = dVar;
            this.f3568b = dVar.f3575e ? null : new boolean[a.this.f3562h];
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DiskLruCache */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f3571a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f3572b;

        /* renamed from: c  reason: collision with root package name */
        File[] f3573c;

        /* renamed from: d  reason: collision with root package name */
        File[] f3574d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3575e;

        /* renamed from: f  reason: collision with root package name */
        private c f3576f;

        /* renamed from: g  reason: collision with root package name */
        private long f3577g;

        /* synthetic */ d(a aVar, String str, CallableC0085a aVar2) {
            this(str);
        }

        private IOException m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void n(String[] strArr) {
            if (strArr.length == a.this.f3562h) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f3572b[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        m(strArr);
                        throw null;
                    }
                }
                return;
            }
            m(strArr);
            throw null;
        }

        public File j(int i2) {
            return this.f3573c[i2];
        }

        public File k(int i2) {
            return this.f3574d[i2];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.f3572b;
            for (long j2 : jArr) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f3571a = str;
            this.f3572b = new long[a.this.f3562h];
            this.f3573c = new File[a.this.f3562h];
            this.f3574d = new File[a.this.f3562h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f3562h; i2++) {
                sb.append(i2);
                this.f3573c[i2] = new File(a.this.f3556b, sb.toString());
                sb.append(".tmp");
                this.f3574d[i2] = new File(a.this.f3556b, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private final File[] f3579a;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0085a aVar2) {
            this(aVar, str, j2, fileArr, jArr);
        }

        public File a(int i2) {
            return this.f3579a[i2];
        }

        private e(a aVar, String str, long j2, File[] fileArr, long[] jArr) {
            this.f3579a = fileArr;
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.f3556b = file;
        this.f3560f = i2;
        this.f3557c = new File(file, "journal");
        this.f3558d = new File(file, "journal.tmp");
        this.f3559e = new File(file, "journal.bkp");
        this.f3562h = i3;
        this.f3561g = j2;
    }

    private void L() {
        if (this.f3564j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void M(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void N(c cVar, boolean z) {
        d dVar = cVar.f3567a;
        if (dVar.f3576f == cVar) {
            if (z && !dVar.f3575e) {
                for (int i2 = 0; i2 < this.f3562h; i2++) {
                    if (!cVar.f3568b[i2]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!dVar.k(i2).exists()) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.f3562h; i3++) {
                File k2 = dVar.k(i3);
                if (!z) {
                    P(k2);
                } else if (k2.exists()) {
                    File j2 = dVar.j(i3);
                    k2.renameTo(j2);
                    long j3 = dVar.f3572b[i3];
                    long length = j2.length();
                    dVar.f3572b[i3] = length;
                    this.f3563i = (this.f3563i - j3) + length;
                }
            }
            this.l++;
            dVar.f3576f = null;
            if (dVar.f3575e || z) {
                dVar.f3575e = true;
                this.f3564j.append((CharSequence) "CLEAN");
                this.f3564j.append(' ');
                this.f3564j.append((CharSequence) dVar.f3571a);
                this.f3564j.append((CharSequence) dVar.l());
                this.f3564j.append('\n');
                if (z) {
                    long j4 = this.m;
                    this.m = 1 + j4;
                    dVar.f3577g = j4;
                }
            } else {
                this.f3565k.remove(dVar.f3571a);
                this.f3564j.append((CharSequence) "REMOVE");
                this.f3564j.append(' ');
                this.f3564j.append((CharSequence) dVar.f3571a);
                this.f3564j.append('\n');
            }
            S(this.f3564j);
            if (this.f3563i > this.f3561g || U()) {
                this.n.submit(this.o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void P(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c R(String str, long j2) {
        L();
        d dVar = this.f3565k.get(str);
        if (j2 != -1 && (dVar == null || dVar.f3577g != j2)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, null);
            this.f3565k.put(str, dVar);
        } else if (dVar.f3576f != null) {
            return null;
        }
        c cVar = new c(this, dVar, null);
        dVar.f3576f = cVar;
        this.f3564j.append((CharSequence) "DIRTY");
        this.f3564j.append(' ');
        this.f3564j.append((CharSequence) str);
        this.f3564j.append('\n');
        S(this.f3564j);
        return cVar;
    }

    @TargetApi(26)
    private static void S(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean U() {
        int i2 = this.l;
        return i2 >= 2000 && i2 >= this.f3565k.size();
    }

    public static a V(File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    b0(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f3557c.exists()) {
                try {
                    aVar.X();
                    aVar.W();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.O();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.Z();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void W() {
        P(this.f3558d);
        Iterator<d> it = this.f3565k.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f3576f == null) {
                while (i2 < this.f3562h) {
                    this.f3563i += next.f3572b[i2];
                    i2++;
                }
            } else {
                next.f3576f = null;
                while (i2 < this.f3562h) {
                    P(next.j(i2));
                    P(next.k(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void X() {
        b bVar = new b(new FileInputStream(this.f3557c), c.f3586a);
        try {
            String G = bVar.G();
            String G2 = bVar.G();
            String G3 = bVar.G();
            String G4 = bVar.G();
            String G5 = bVar.G();
            if (!"libcore.io.DiskLruCache".equals(G) || !"1".equals(G2) || !Integer.toString(this.f3560f).equals(G3) || !Integer.toString(this.f3562h).equals(G4) || !BuildConfig.FLAVOR.equals(G5)) {
                throw new IOException("unexpected journal header: [" + G + ", " + G2 + ", " + G4 + ", " + G5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    Y(bVar.G());
                    i2++;
                } catch (EOFException unused) {
                    this.l = i2 - this.f3565k.size();
                    if (bVar.F()) {
                        Z();
                    } else {
                        this.f3564j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3557c, true), c.f3586a));
                    }
                    return;
                }
            }
        } finally {
            c.a(bVar);
        }
    }

    private void Y(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f3565k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            d dVar = this.f3565k.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, null);
                this.f3565k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f3575e = true;
                dVar.f3576f = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f3576f = new c(this, dVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void Z() {
        Writer writer = this.f3564j;
        if (writer != null) {
            M(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3558d), c.f3586a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3560f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3562h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f3565k.values()) {
                if (dVar.f3576f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f3571a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f3571a + dVar.l() + '\n');
                }
            }
            M(bufferedWriter);
            if (this.f3557c.exists()) {
                b0(this.f3557c, this.f3559e, true);
            }
            b0(this.f3558d, this.f3557c, false);
            this.f3559e.delete();
            this.f3564j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3557c, true), c.f3586a));
        } catch (Throwable th) {
            M(bufferedWriter);
            throw th;
        }
    }

    private static void b0(File file, File file2, boolean z) {
        if (z) {
            P(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c0() {
        while (this.f3563i > this.f3561g) {
            a0(this.f3565k.entrySet().iterator().next().getKey());
        }
    }

    public void O() {
        close();
        c.b(this.f3556b);
    }

    public c Q(String str) {
        return R(str, -1);
    }

    public synchronized e T(String str) {
        L();
        d dVar = this.f3565k.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f3575e) {
            return null;
        }
        for (File file : dVar.f3573c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.l++;
        this.f3564j.append((CharSequence) "READ");
        this.f3564j.append(' ');
        this.f3564j.append((CharSequence) str);
        this.f3564j.append('\n');
        if (U()) {
            this.n.submit(this.o);
        }
        return new e(this, str, dVar.f3577g, dVar.f3573c, dVar.f3572b, null);
    }

    public synchronized boolean a0(String str) {
        L();
        d dVar = this.f3565k.get(str);
        if (dVar != null) {
            if (dVar.f3576f == null) {
                for (int i2 = 0; i2 < this.f3562h; i2++) {
                    File j2 = dVar.j(i2);
                    if (j2.exists()) {
                        if (!j2.delete()) {
                            throw new IOException("failed to delete " + j2);
                        }
                    }
                    this.f3563i -= dVar.f3572b[i2];
                    dVar.f3572b[i2] = 0;
                }
                this.l++;
                this.f3564j.append((CharSequence) "REMOVE");
                this.f3564j.append(' ');
                this.f3564j.append((CharSequence) str);
                this.f3564j.append('\n');
                this.f3565k.remove(str);
                if (U()) {
                    this.n.submit(this.o);
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f3564j != null) {
            Iterator it = new ArrayList(this.f3565k.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f3576f != null) {
                    dVar.f3576f.a();
                }
            }
            c0();
            M(this.f3564j);
            this.f3564j = null;
        }
    }
}
