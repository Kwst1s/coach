package i;

import com.github.mikephil.charting.BuildConfig;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl */
public final class i {
    public static final i n;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10411a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10412b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10413c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10414d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10415e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10416f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f10417g;

    /* renamed from: h  reason: collision with root package name */
    private final int f10418h;

    /* renamed from: i  reason: collision with root package name */
    private final int f10419i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f10420j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f10421k;
    private final boolean l;
    @Nullable
    String m;

    /* compiled from: CacheControl */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f10422a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10423b;

        /* renamed from: c  reason: collision with root package name */
        int f10424c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f10425d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f10426e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f10427f;

        /* renamed from: g  reason: collision with root package name */
        boolean f10428g;

        /* renamed from: h  reason: collision with root package name */
        boolean f10429h;

        public i a() {
            return new i(this);
        }

        public a b(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f10425d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public a c() {
            this.f10422a = true;
            return this;
        }

        public a d() {
            this.f10423b = true;
            return this;
        }

        public a e() {
            this.f10427f = true;
            return this;
        }
    }

    static {
        a aVar = new a();
        aVar.c();
        aVar.a();
        a aVar2 = new a();
        aVar2.e();
        aVar2.b(Integer.MAX_VALUE, TimeUnit.SECONDS);
        n = aVar2.a();
    }

    private i(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f10411a = z;
        this.f10412b = z2;
        this.f10413c = i2;
        this.f10414d = i3;
        this.f10415e = z3;
        this.f10416f = z4;
        this.f10417g = z5;
        this.f10418h = i4;
        this.f10419i = i5;
        this.f10420j = z6;
        this.f10421k = z7;
        this.l = z8;
        this.m = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f10411a) {
            sb.append("no-cache, ");
        }
        if (this.f10412b) {
            sb.append("no-store, ");
        }
        if (this.f10413c != -1) {
            sb.append("max-age=");
            sb.append(this.f10413c);
            sb.append(", ");
        }
        if (this.f10414d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f10414d);
            sb.append(", ");
        }
        if (this.f10415e) {
            sb.append("private, ");
        }
        if (this.f10416f) {
            sb.append("public, ");
        }
        if (this.f10417g) {
            sb.append("must-revalidate, ");
        }
        if (this.f10418h != -1) {
            sb.append("max-stale=");
            sb.append(this.f10418h);
            sb.append(", ");
        }
        if (this.f10419i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f10419i);
            sb.append(", ");
        }
        if (this.f10420j) {
            sb.append("only-if-cached, ");
        }
        if (this.f10421k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static i.i k(i.x r22) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: i.i.k(i.x):i.i");
    }

    public boolean b() {
        return this.f10415e;
    }

    public boolean c() {
        return this.f10416f;
    }

    public int d() {
        return this.f10413c;
    }

    public int e() {
        return this.f10418h;
    }

    public int f() {
        return this.f10419i;
    }

    public boolean g() {
        return this.f10417g;
    }

    public boolean h() {
        return this.f10411a;
    }

    public boolean i() {
        return this.f10412b;
    }

    public boolean j() {
        return this.f10420j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.m = a2;
        return a2;
    }

    i(a aVar) {
        this.f10411a = aVar.f10422a;
        this.f10412b = aVar.f10423b;
        this.f10413c = aVar.f10424c;
        this.f10414d = -1;
        this.f10415e = false;
        this.f10416f = false;
        this.f10417g = false;
        this.f10418h = aVar.f10425d;
        this.f10419i = aVar.f10426e;
        this.f10420j = aVar.f10427f;
        this.f10421k = aVar.f10428g;
        this.l = aVar.f10429h;
    }
}
