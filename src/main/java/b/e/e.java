package b.e;

import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: LruCache */
public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f2178a;

    /* renamed from: b  reason: collision with root package name */
    private int f2179b;

    /* renamed from: c  reason: collision with root package name */
    private int f2180c;

    /* renamed from: d  reason: collision with root package name */
    private int f2181d;

    /* renamed from: e  reason: collision with root package name */
    private int f2182e;

    /* renamed from: f  reason: collision with root package name */
    private int f2183f;

    /* renamed from: g  reason: collision with root package name */
    private int f2184g;

    /* renamed from: h  reason: collision with root package name */
    private int f2185h;

    public e(int i2) {
        if (i2 > 0) {
            this.f2180c = i2;
            this.f2178a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int e(K k2, V v) {
        int f2 = f(k2, v);
        if (f2 >= 0) {
            return f2;
        }
        throw new IllegalStateException("Negative size: " + ((Object) k2) + "=" + ((Object) v));
    }

    /* access modifiers changed from: protected */
    public V a(K k2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void b(boolean z, K k2, V v, V v2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r0 = a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r0 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.f2182e++;
        r1 = r4.f2178a.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r1 == null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r4.f2178a.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r4.f2179b += e(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r1 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        b(false, r5, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        g(r4.f2180c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V c(K r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key == null"
            java.util.Objects.requireNonNull(r5, r0)
            monitor-enter(r4)
            java.util.LinkedHashMap<K, V> r0 = r4.f2178a     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0016
            int r5 = r4.f2184g     // Catch:{ all -> 0x0054 }
            int r5 = r5 + 1
            r4.f2184g = r5     // Catch:{ all -> 0x0054 }
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            return r0
        L_0x0016:
            int r0 = r4.f2185h     // Catch:{ all -> 0x0054 }
            int r0 = r0 + 1
            r4.f2185h = r0     // Catch:{ all -> 0x0054 }
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r4.a(r5)
            if (r0 != 0) goto L_0x0025
            r5 = 0
            return r5
        L_0x0025:
            monitor-enter(r4)
            int r1 = r4.f2182e     // Catch:{ all -> 0x0051 }
            int r1 = r1 + 1
            r4.f2182e = r1     // Catch:{ all -> 0x0051 }
            java.util.LinkedHashMap<K, V> r1 = r4.f2178a     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.put(r5, r0)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x003a
            java.util.LinkedHashMap<K, V> r2 = r4.f2178a     // Catch:{ all -> 0x0051 }
            r2.put(r5, r1)     // Catch:{ all -> 0x0051 }
            goto L_0x0043
        L_0x003a:
            int r2 = r4.f2179b     // Catch:{ all -> 0x0051 }
            int r3 = r4.e(r5, r0)     // Catch:{ all -> 0x0051 }
            int r2 = r2 + r3
            r4.f2179b = r2     // Catch:{ all -> 0x0051 }
        L_0x0043:
            monitor-exit(r4)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x004b
            r2 = 0
            r4.b(r2, r5, r0, r1)
            return r1
        L_0x004b:
            int r5 = r4.f2180c
            r4.g(r5)
            return r0
        L_0x0051:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0054:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b.e.e.c(java.lang.Object):java.lang.Object");
    }

    public final V d(K k2, V v) {
        V put;
        if (k2 == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2181d++;
            this.f2179b += e(k2, v);
            put = this.f2178a.put(k2, v);
            if (put != null) {
                this.f2179b -= e(k2, put);
            }
        }
        if (put != null) {
            b(false, k2, put, v);
        }
        g(this.f2180c);
        return put;
    }

    /* access modifiers changed from: protected */
    public int f(K k2, V v) {
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(int r5) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: b.e.e.g(int):void");
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f2184g;
        i3 = this.f2185h + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2180c), Integer.valueOf(this.f2184g), Integer.valueOf(this.f2185h), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0));
    }
}
