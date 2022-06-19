package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.r.k;
import com.github.mikephil.charting.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy */
public class n implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f3912d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f3913e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f3914f = {Bitmap.Config.RGB_565};

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f3915g = {Bitmap.Config.ARGB_4444};

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f3916h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    private final c f3917a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final h<b, Bitmap> f3918b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f3919c = new HashMap();

    /* access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3920a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.bumptech.glide.load.engine.z.n.a.f3920a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.bumptech.glide.load.engine.z.n.a.f3920a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.bumptech.glide.load.engine.z.n.a.f3920a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.bumptech.glide.load.engine.z.n.a.f3920a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.z.n.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy */
    public static final class b implements m {

        /* renamed from: a  reason: collision with root package name */
        private final c f3921a;

        /* renamed from: b  reason: collision with root package name */
        int f3922b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f3923c;

        public b(c cVar) {
            this.f3921a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.f3921a.c(this);
        }

        public void b(int i2, Bitmap.Config config) {
            this.f3922b = i2;
            this.f3923c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f3922b != bVar.f3922b || !k.c(this.f3923c, bVar.f3923c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f3922b * 31;
            Bitmap.Config config = this.f3923c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.h(this.f3922b, this.f3923c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy */
    public static class c extends d<b> {
        c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i2, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i2, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f3912d = configArr;
        f3913e = configArr;
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j2 = j(bitmap.getConfig());
        Integer num2 = (Integer) j2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            j2.remove(num);
        } else {
            j2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b g(int i2, Bitmap.Config config) {
        b e2 = this.f3917a.e(i2, config);
        Bitmap.Config[] i3 = i(config);
        for (Bitmap.Config config2 : i3) {
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return e2;
                        }
                    } else if (config2.equals(config)) {
                        return e2;
                    }
                }
                this.f3917a.c(e2);
                return this.f3917a.e(ceilingKey.intValue(), config2);
            }
        }
        return e2;
    }

    static String h(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f3913e;
        }
        int i2 = a.f3920a[config.ordinal()];
        if (i2 == 1) {
            return f3912d;
        }
        if (i2 == 2) {
            return f3914f;
        }
        if (i2 == 3) {
            return f3915g;
        }
        if (i2 == 4) {
            return f3916h;
        }
        return new Bitmap.Config[]{config};
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f3919c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f3919c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String a(int i2, int i3, Bitmap.Config config) {
        return h(k.f(i2, i3, config), config);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int b(Bitmap bitmap) {
        return k.g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        b g2 = g(k.f(i2, i3, config), config);
        Bitmap a2 = this.f3918b.a(g2);
        if (a2 != null) {
            f(Integer.valueOf(g2.f3922b), a2);
            a2.reconfigure(i2, i3, config);
        }
        return a2;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void d(Bitmap bitmap) {
        b e2 = this.f3917a.e(k.g(bitmap), bitmap.getConfig());
        this.f3918b.d(e2, bitmap);
        NavigableMap<Integer, Integer> j2 = j(bitmap.getConfig());
        Integer num = (Integer) j2.get(Integer.valueOf(e2.f3922b));
        Integer valueOf = Integer.valueOf(e2.f3922b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        j2.put(valueOf, Integer.valueOf(i2));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String e(Bitmap bitmap) {
        return h(k.g(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap removeLast() {
        Bitmap f2 = this.f3918b.f();
        if (f2 != null) {
            f(Integer.valueOf(k.g(f2)), f2);
        }
        return f2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f3918b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f3919c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f3919c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), BuildConfig.FLAVOR);
        }
        sb.append(")}");
        return sb.toString();
    }
}
