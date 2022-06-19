package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.h;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: GapWorker */
public final class e implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    static final ThreadLocal<e> f1750f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    static Comparator<c> f1751g = new a();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f1752b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f1753c;

    /* renamed from: d  reason: collision with root package name */
    long f1754d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<c> f1755e = new ArrayList<>();

    /* compiled from: GapWorker */
    static class a implements Comparator<c> {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f1763d;
            if ((recyclerView == null) != (cVar2.f1763d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.f1760a;
            if (z == cVar2.f1760a) {
                int i2 = cVar2.f1761b - cVar.f1761b;
                if (i2 != 0) {
                    return i2;
                }
                int i3 = cVar.f1762c - cVar2.f1762c;
                if (i3 != 0) {
                    return i3;
                }
                return 0;
            } else if (z) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"VisibleForTests"})
    /* compiled from: GapWorker */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        int f1756a;

        /* renamed from: b  reason: collision with root package name */
        int f1757b;

        /* renamed from: c  reason: collision with root package name */
        int[] f1758c;

        /* renamed from: d  reason: collision with root package name */
        int f1759d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f1759d * 2;
                int[] iArr = this.f1758c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f1758c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[(i4 * 2)];
                    this.f1758c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f1758c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f1759d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f1758c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1759d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView, boolean z) {
            this.f1759d = 0;
            int[] iArr = this.f1758c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.n;
            if (recyclerView.m != null && oVar != null && oVar.v0()) {
                if (z) {
                    if (!recyclerView.f1537e.p()) {
                        oVar.q(recyclerView.m.c(), this);
                    }
                } else if (!recyclerView.o0()) {
                    oVar.p(this.f1756a, this.f1757b, recyclerView.i0, this);
                }
                int i2 = this.f1759d;
                if (i2 > oVar.m) {
                    oVar.m = i2;
                    oVar.n = z;
                    recyclerView.f1535c.K();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (this.f1758c != null) {
                int i3 = this.f1759d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f1758c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3) {
            this.f1756a = i2;
            this.f1757b = i3;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GapWorker */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1760a;

        /* renamed from: b  reason: collision with root package name */
        public int f1761b;

        /* renamed from: c  reason: collision with root package name */
        public int f1762c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f1763d;

        /* renamed from: e  reason: collision with root package name */
        public int f1764e;

        c() {
        }

        public void a() {
            this.f1760a = false;
            this.f1761b = 0;
            this.f1762c = 0;
            this.f1763d = null;
            this.f1764e = 0;
        }
    }

    e() {
    }

    private void b() {
        c cVar;
        int size = this.f1752b.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f1752b.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.h0.c(recyclerView, false);
                i2 += recyclerView.h0.f1759d;
            }
        }
        this.f1755e.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f1752b.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.h0;
                int abs = Math.abs(bVar.f1756a) + Math.abs(bVar.f1757b);
                for (int i6 = 0; i6 < bVar.f1759d * 2; i6 += 2) {
                    if (i4 >= this.f1755e.size()) {
                        cVar = new c();
                        this.f1755e.add(cVar);
                    } else {
                        cVar = this.f1755e.get(i4);
                    }
                    int[] iArr = bVar.f1758c;
                    int i7 = iArr[i6 + 1];
                    cVar.f1760a = i7 <= abs;
                    cVar.f1761b = abs;
                    cVar.f1762c = i7;
                    cVar.f1763d = recyclerView2;
                    cVar.f1764e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f1755e, f1751g);
    }

    private void c(c cVar, long j2) {
        RecyclerView.d0 i2 = i(cVar.f1763d, cVar.f1764e, cVar.f1760a ? Long.MAX_VALUE : j2);
        if (i2 != null && i2.f1566b != null && i2.s() && !i2.t()) {
            h(i2.f1566b.get(), j2);
        }
    }

    private void d(long j2) {
        for (int i2 = 0; i2 < this.f1755e.size(); i2++) {
            c cVar = this.f1755e.get(i2);
            if (cVar.f1763d != null) {
                c(cVar, j2);
                cVar.a();
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int j2 = recyclerView.f1538f.j();
        for (int i3 = 0; i3 < j2; i3++) {
            RecyclerView.d0 i0 = RecyclerView.i0(recyclerView.f1538f.i(i3));
            if (i0.f1567c == i2 && !i0.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView != null) {
            if (recyclerView.E && recyclerView.f1538f.j() != 0) {
                recyclerView.W0();
            }
            b bVar = recyclerView.h0;
            bVar.c(recyclerView, true);
            if (bVar.f1759d != 0) {
                try {
                    h.a("RV Nested Prefetch");
                    recyclerView.i0.f(recyclerView.m);
                    for (int i2 = 0; i2 < bVar.f1759d * 2; i2 += 2) {
                        i(recyclerView, bVar.f1758c[i2], j2);
                    }
                } finally {
                    h.b();
                }
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f1535c;
        try {
            recyclerView.I0();
            RecyclerView.d0 I = vVar.I(i2, false, j2);
            if (I != null) {
                if (!I.s() || I.t()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.f1565a);
                }
            }
            return I;
        } finally {
            recyclerView.K0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f1752b.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f1753c == 0) {
            this.f1753c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.h0.e(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f1752b.remove(recyclerView);
    }

    public void run() {
        try {
            h.a("RV Prefetch");
            if (!this.f1752b.isEmpty()) {
                int size = this.f1752b.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f1752b.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j2) + this.f1754d);
                    this.f1753c = 0;
                    h.b();
                }
            }
        } finally {
            this.f1753c = 0;
            h.b();
        }
    }
}
