package b.f.b.k;

import b.f.b.c;
import b.f.b.i;
import b.f.b.k.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintAnchor */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private HashSet<d> f2305a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f2306b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2307c;

    /* renamed from: d  reason: collision with root package name */
    public final e f2308d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2309e;

    /* renamed from: f  reason: collision with root package name */
    public d f2310f;

    /* renamed from: g  reason: collision with root package name */
    public int f2311g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f2312h = -1;

    /* renamed from: i  reason: collision with root package name */
    i f2313i;

    /* access modifiers changed from: package-private */
    /* compiled from: ConstraintAnchor */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2314a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
            // Method dump skipped, instructions count: 109
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.d.a.<clinit>():void");
        }
    }

    /* compiled from: ConstraintAnchor */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f2308d = eVar;
        this.f2309e = bVar;
    }

    public boolean a(d dVar, int i2, int i3, boolean z) {
        if (dVar == null) {
            p();
            return true;
        } else if (!z && !o(dVar)) {
            return false;
        } else {
            this.f2310f = dVar;
            if (dVar.f2305a == null) {
                dVar.f2305a = new HashSet<>();
            }
            HashSet<d> hashSet = this.f2310f.f2305a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            if (i2 > 0) {
                this.f2311g = i2;
            } else {
                this.f2311g = 0;
            }
            this.f2312h = i3;
            return true;
        }
    }

    public void b(int i2, ArrayList<o> arrayList, o oVar) {
        HashSet<d> hashSet = this.f2305a;
        if (hashSet != null) {
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                b.f.b.k.m.i.a(it.next().f2308d, i2, arrayList, oVar);
            }
        }
    }

    public HashSet<d> c() {
        return this.f2305a;
    }

    public int d() {
        if (!this.f2307c) {
            return 0;
        }
        return this.f2306b;
    }

    public int e() {
        d dVar;
        if (this.f2308d.Q() == 8) {
            return 0;
        }
        if (this.f2312h <= -1 || (dVar = this.f2310f) == null || dVar.f2308d.Q() != 8) {
            return this.f2311g;
        }
        return this.f2312h;
    }

    public final d f() {
        switch (a.f2314a[this.f2309e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f2308d.H;
            case 3:
                return this.f2308d.F;
            case 4:
                return this.f2308d.I;
            case 5:
                return this.f2308d.G;
            default:
                throw new AssertionError(this.f2309e.name());
        }
    }

    public e g() {
        return this.f2308d;
    }

    public i h() {
        return this.f2313i;
    }

    public d i() {
        return this.f2310f;
    }

    public b j() {
        return this.f2309e;
    }

    public boolean k() {
        HashSet<d> hashSet = this.f2305a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        HashSet<d> hashSet = this.f2305a;
        if (hashSet != null && hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.f2307c;
    }

    public boolean n() {
        return this.f2310f != null;
    }

    public boolean o(d dVar) {
        boolean z = false;
        if (dVar == null) {
            return false;
        }
        b j2 = dVar.j();
        b bVar = this.f2309e;
        if (j2 != bVar) {
            switch (a.f2314a[bVar.ordinal()]) {
                case 1:
                    if (j2 == b.BASELINE || j2 == b.CENTER_X || j2 == b.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    boolean z2 = j2 == b.LEFT || j2 == b.RIGHT;
                    if (!(dVar.g() instanceof g)) {
                        return z2;
                    }
                    if (z2 || j2 == b.CENTER_X) {
                        z = true;
                    }
                    return z;
                case 4:
                case 5:
                    boolean z3 = j2 == b.TOP || j2 == b.BOTTOM;
                    if (!(dVar.g() instanceof g)) {
                        return z3;
                    }
                    if (z3 || j2 == b.CENTER_Y) {
                        z = true;
                    }
                    return z;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f2309e.name());
            }
        } else if (bVar != b.BASELINE || (dVar.g().U() && g().U())) {
            return true;
        } else {
            return false;
        }
    }

    public void p() {
        HashSet<d> hashSet;
        d dVar = this.f2310f;
        if (!(dVar == null || (hashSet = dVar.f2305a) == null)) {
            hashSet.remove(this);
            if (this.f2310f.f2305a.size() == 0) {
                this.f2310f.f2305a = null;
            }
        }
        this.f2305a = null;
        this.f2310f = null;
        this.f2311g = 0;
        this.f2312h = -1;
        this.f2307c = false;
        this.f2306b = 0;
    }

    public void q() {
        this.f2307c = false;
        this.f2306b = 0;
    }

    public void r(c cVar) {
        i iVar = this.f2313i;
        if (iVar == null) {
            this.f2313i = new i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public void s(int i2) {
        this.f2306b = i2;
        this.f2307c = true;
    }

    public String toString() {
        return this.f2308d.r() + ":" + this.f2309e.toString();
    }
}
