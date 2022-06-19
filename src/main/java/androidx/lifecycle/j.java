package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry */
public class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private b.b.a.b.a<h, b> f1468a = new b.b.a.b.a<>();

    /* renamed from: b  reason: collision with root package name */
    private e.b f1469b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<i> f1470c;

    /* renamed from: d  reason: collision with root package name */
    private int f1471d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1472e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1473f = false;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<e.b> f1474g = new ArrayList<>();

    /* access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1475a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1476b;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0082 */
        static {
            /*
            // Method dump skipped, instructions count: 142
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.j.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        e.b f1477a;

        /* renamed from: b  reason: collision with root package name */
        g f1478b;

        b(h hVar, e.b bVar) {
            this.f1478b = l.f(hVar);
            this.f1477a = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar, e.a aVar) {
            e.b h2 = j.h(aVar);
            this.f1477a = j.l(this.f1477a, h2);
            this.f1478b.d(iVar, aVar);
            this.f1477a = h2;
        }
    }

    public j(i iVar) {
        this.f1470c = new WeakReference<>(iVar);
        this.f1469b = e.b.INITIALIZED;
    }

    private void d(i iVar) {
        Iterator<Map.Entry<h, b>> a2 = this.f1468a.a();
        while (a2.hasNext() && !this.f1473f) {
            Map.Entry<h, b> next = a2.next();
            b value = next.getValue();
            while (value.f1477a.compareTo((Enum) this.f1469b) > 0 && !this.f1473f && this.f1468a.contains(next.getKey())) {
                e.a f2 = f(value.f1477a);
                o(h(f2));
                value.a(iVar, f2);
                n();
            }
        }
    }

    private e.b e(h hVar) {
        Map.Entry<h, b> i2 = this.f1468a.i(hVar);
        e.b bVar = null;
        e.b bVar2 = i2 != null ? i2.getValue().f1477a : null;
        if (!this.f1474g.isEmpty()) {
            ArrayList<e.b> arrayList = this.f1474g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return l(l(this.f1469b, bVar2), bVar);
    }

    private static e.a f(e.b bVar) {
        int i2 = a.f1476b[bVar.ordinal()];
        if (i2 == 1) {
            throw new IllegalArgumentException();
        } else if (i2 == 2) {
            return e.a.ON_DESTROY;
        } else {
            if (i2 == 3) {
                return e.a.ON_STOP;
            }
            if (i2 == 4) {
                return e.a.ON_PAUSE;
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: b.b.a.b.a<androidx.lifecycle.h, androidx.lifecycle.j$b> */
    /* JADX WARN: Multi-variable type inference failed */
    private void g(i iVar) {
        b.b.a.b.b<K, V>.d d2 = this.f1468a.d();
        while (d2.hasNext() && !this.f1473f) {
            Map.Entry entry = (Map.Entry) d2.next();
            b bVar = (b) entry.getValue();
            while (bVar.f1477a.compareTo((Enum) this.f1469b) < 0 && !this.f1473f && this.f1468a.contains(entry.getKey())) {
                o(bVar.f1477a);
                bVar.a(iVar, r(bVar.f1477a));
                n();
            }
        }
    }

    static e.b h(e.a aVar) {
        switch (a.f1475a[aVar.ordinal()]) {
            case 1:
            case 2:
                return e.b.CREATED;
            case 3:
            case 4:
                return e.b.STARTED;
            case 5:
                return e.b.RESUMED;
            case 6:
                return e.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.f1468a.size() == 0) {
            return true;
        }
        e.b bVar = this.f1468a.b().getValue().f1477a;
        e.b bVar2 = this.f1468a.e().getValue().f1477a;
        if (bVar == bVar2 && this.f1469b == bVar2) {
            return true;
        }
        return false;
    }

    static e.b l(e.b bVar, e.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(e.b bVar) {
        if (this.f1469b != bVar) {
            this.f1469b = bVar;
            if (this.f1472e || this.f1471d != 0) {
                this.f1473f = true;
                return;
            }
            this.f1472e = true;
            q();
            this.f1472e = false;
        }
    }

    private void n() {
        ArrayList<e.b> arrayList = this.f1474g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void o(e.b bVar) {
        this.f1474g.add(bVar);
    }

    private void q() {
        i iVar = this.f1470c.get();
        if (iVar != null) {
            while (!j()) {
                this.f1473f = false;
                if (this.f1469b.compareTo((Enum) this.f1468a.b().getValue().f1477a) < 0) {
                    d(iVar);
                }
                Map.Entry<h, b> e2 = this.f1468a.e();
                if (!this.f1473f && e2 != null && this.f1469b.compareTo((Enum) e2.getValue().f1477a) > 0) {
                    g(iVar);
                }
            }
            this.f1473f = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    private static e.a r(e.b bVar) {
        int i2 = a.f1476b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return e.a.ON_START;
            }
            if (i2 == 3) {
                return e.a.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            } else if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return e.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.e
    public void a(h hVar) {
        i iVar;
        e.b bVar = this.f1469b;
        e.b bVar2 = e.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = e.b.INITIALIZED;
        }
        b bVar3 = new b(hVar, bVar2);
        if (this.f1468a.g(hVar, bVar3) == null && (iVar = this.f1470c.get()) != null) {
            boolean z = this.f1471d != 0 || this.f1472e;
            e.b e2 = e(hVar);
            this.f1471d++;
            while (bVar3.f1477a.compareTo((Enum) e2) < 0 && this.f1468a.contains(hVar)) {
                o(bVar3.f1477a);
                bVar3.a(iVar, r(bVar3.f1477a));
                n();
                e2 = e(hVar);
            }
            if (!z) {
                q();
            }
            this.f1471d--;
        }
    }

    @Override // androidx.lifecycle.e
    public e.b b() {
        return this.f1469b;
    }

    @Override // androidx.lifecycle.e
    public void c(h hVar) {
        this.f1468a.h(hVar);
    }

    public void i(e.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(e.b bVar) {
        p(bVar);
    }

    public void p(e.b bVar) {
        m(bVar);
    }
}
