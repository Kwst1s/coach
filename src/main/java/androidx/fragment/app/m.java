package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.v;
import androidx.lifecycle.e;
import androidx.lifecycle.w;
import com.github.mikephil.charting.utils.Utils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FragmentManager */
public abstract class m {
    private static boolean F = false;
    private ArrayList<Boolean> A;
    private ArrayList<Fragment> B;
    private ArrayList<k> C;
    private p D;
    private Runnable E = new d();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<i> f1285a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1286b;

    /* renamed from: c  reason: collision with root package name */
    private final t f1287c = new t();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f1288d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f1289e;

    /* renamed from: f  reason: collision with root package name */
    private final k f1290f = new k(this);

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f1291g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.activity.b f1292h = new a(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f1293i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<h> f1294j;

    /* renamed from: k  reason: collision with root package name */
    private ConcurrentHashMap<Fragment, HashSet<androidx.core.os.b>> f1295k = new ConcurrentHashMap<>();
    private final v.g l = new b();
    private final l m = new l(this);
    int n = -1;
    j<?> o;
    f p;
    private Fragment q;
    Fragment r;
    private i s = null;
    private i t = new c();
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private ArrayList<a> z;

    /* compiled from: FragmentManager */
    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            m.this.p0();
        }
    }

    /* compiled from: FragmentManager */
    class b implements v.g {
        b() {
        }

        @Override // androidx.fragment.app.v.g
        public void a(Fragment fragment, androidx.core.os.b bVar) {
            if (!bVar.b()) {
                m.this.O0(fragment, bVar);
            }
        }

        @Override // androidx.fragment.app.v.g
        public void b(Fragment fragment, androidx.core.os.b bVar) {
            m.this.c(fragment, bVar);
        }
    }

    /* compiled from: FragmentManager */
    class c extends i {
        c() {
        }

        @Override // androidx.fragment.app.i
        public Fragment a(ClassLoader classLoader, String str) {
            j<?> jVar = m.this.o;
            return jVar.a(jVar.h(), str, null);
        }
    }

    /* compiled from: FragmentManager */
    class d implements Runnable {
        d() {
        }

        public void run() {
            m.this.R(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentManager */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1300b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f1301c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Fragment f1302d;

        e(m mVar, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1300b = viewGroup;
            this.f1301c = view;
            this.f1302d = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1300b.endViewTransition(this.f1301c);
            animator.removeListener(this);
            Fragment fragment = this.f1302d;
            View view = fragment.H;
            if (view != null && fragment.z) {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: FragmentManager */
    public interface f {
        String a();
    }

    /* compiled from: FragmentManager */
    public static abstract class g {
        public abstract void a(m mVar, Fragment fragment, Bundle bundle);

        public abstract void b(m mVar, Fragment fragment, Context context);

        public abstract void c(m mVar, Fragment fragment, Bundle bundle);

        public abstract void d(m mVar, Fragment fragment);

        public abstract void e(m mVar, Fragment fragment);

        public abstract void f(m mVar, Fragment fragment);

        public abstract void g(m mVar, Fragment fragment, Context context);

        public abstract void h(m mVar, Fragment fragment, Bundle bundle);

        public abstract void i(m mVar, Fragment fragment);

        public abstract void j(m mVar, Fragment fragment, Bundle bundle);

        public abstract void k(m mVar, Fragment fragment);

        public abstract void l(m mVar, Fragment fragment);

        public abstract void m(m mVar, Fragment fragment, View view, Bundle bundle);

        public abstract void n(m mVar, Fragment fragment);
    }

    /* compiled from: FragmentManager */
    public interface h {
        void a();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentManager */
    public interface i {
        boolean b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager */
    private class j implements i {

        /* renamed from: a  reason: collision with root package name */
        final String f1303a;

        /* renamed from: b  reason: collision with root package name */
        final int f1304b;

        /* renamed from: c  reason: collision with root package name */
        final int f1305c;

        j(String str, int i2, int i3) {
            this.f1303a = str;
            this.f1304b = i2;
            this.f1305c = i3;
        }

        @Override // androidx.fragment.app.m.i
        public boolean b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = m.this.r;
            if (fragment == null || this.f1304b >= 0 || this.f1303a != null || !fragment.v().J0()) {
                return m.this.L0(arrayList, arrayList2, this.f1303a, this.f1304b, this.f1305c);
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentManager */
    public static class k implements Fragment.d {

        /* renamed from: a  reason: collision with root package name */
        final boolean f1307a;

        /* renamed from: b  reason: collision with root package name */
        final a f1308b;

        /* renamed from: c  reason: collision with root package name */
        private int f1309c;

        k(a aVar, boolean z) {
            this.f1307a = z;
            this.f1308b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.d
        public void a() {
            int i2 = this.f1309c - 1;
            this.f1309c = i2;
            if (i2 == 0) {
                this.f1308b.r.X0();
            }
        }

        @Override // androidx.fragment.app.Fragment.d
        public void b() {
            this.f1309c++;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            a aVar = this.f1308b;
            aVar.r.o(aVar, this.f1307a, false, false);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z = this.f1309c > 0;
            for (Fragment fragment : this.f1308b.r.i0()) {
                fragment.B1(null);
                if (z && fragment.c0()) {
                    fragment.J1();
                }
            }
            a aVar = this.f1308b;
            aVar.r.o(aVar, this.f1307a, !z, true);
        }

        public boolean e() {
            return this.f1309c == 0;
        }
    }

    private void A0(b.e.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment h2 = bVar.h(i2);
            if (!h2.l) {
                View q1 = h2.q1();
                h2.N = q1.getAlpha();
                q1.setAlpha(Utils.FLOAT_EPSILON);
            }
        }
    }

    private void D(Fragment fragment) {
        if (fragment != null && fragment.equals(W(fragment.f1214f))) {
            fragment.h1();
        }
    }

    /* JADX INFO: finally extract failed */
    private void K(int i2) {
        try {
            this.f1286b = true;
            this.f1287c.d(i2);
            C0(i2, false);
            this.f1286b = false;
            R(true);
        } catch (Throwable th) {
            this.f1286b = false;
            throw th;
        }
    }

    private boolean K0(String str, int i2, int i3) {
        R(false);
        Q(true);
        Fragment fragment = this.r;
        if (fragment != null && i2 < 0 && str == null && fragment.v().J0()) {
            return true;
        }
        boolean L0 = L0(this.z, this.A, str, i2, i3);
        if (L0) {
            this.f1286b = true;
            try {
                Q0(this.z, this.A);
            } finally {
                n();
            }
        }
        f1();
        M();
        this.f1287c.b();
        return L0;
    }

    private void M() {
        if (this.y) {
            this.y = false;
            d1();
        }
    }

    private int M0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, b.e.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.E() && !aVar.C(arrayList, i5 + 1, i3)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                k kVar = new k(aVar, booleanValue);
                this.C.add(kVar);
                aVar.G(kVar);
                if (booleanValue) {
                    aVar.y();
                } else {
                    aVar.z(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(bVar);
            }
        }
        return i4;
    }

    private void O() {
        if (!this.f1295k.isEmpty()) {
            for (Fragment fragment : this.f1295k.keySet()) {
                k(fragment);
                E0(fragment, fragment.P());
            }
        }
    }

    private void Q(boolean z2) {
        if (this.f1286b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.o == null) {
            if (this.x) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.o.i().getLooper()) {
            if (!z2) {
                m();
            }
            if (this.z == null) {
                this.z = new ArrayList<>();
                this.A = new ArrayList<>();
            }
            this.f1286b = true;
            try {
                V(null, null);
            } finally {
                this.f1286b = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private void Q0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                V(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).p) {
                        if (i3 != i2) {
                            U(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                                i3++;
                            }
                        }
                        U(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    U(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void S0() {
        if (this.f1294j != null) {
            for (int i2 = 0; i2 < this.f1294j.size(); i2++) {
                this.f1294j.get(i2).a();
            }
        }
    }

    private static void T(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.u(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.z(z2);
            } else {
                aVar.u(1);
                aVar.y();
            }
            i2++;
        }
    }

    private void U(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5 = i2;
        boolean z2 = arrayList.get(i5).p;
        ArrayList<Fragment> arrayList3 = this.B;
        if (arrayList3 == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.B.addAll(this.f1287c.m());
        Fragment m0 = m0();
        boolean z3 = false;
        for (int i6 = i5; i6 < i3; i6++) {
            a aVar = arrayList.get(i6);
            if (!arrayList2.get(i6).booleanValue()) {
                m0 = aVar.A(this.B, m0);
            } else {
                m0 = aVar.H(this.B, m0);
            }
            z3 = z3 || aVar.f1351g;
        }
        this.B.clear();
        if (!z2) {
            v.C(this, arrayList, arrayList2, i2, i3, false, this.l);
        }
        T(arrayList, arrayList2, i2, i3);
        if (z2) {
            b.e.b<Fragment> bVar = new b.e.b<>();
            a(bVar);
            int M0 = M0(arrayList, arrayList2, i2, i3, bVar);
            A0(bVar);
            i4 = M0;
        } else {
            i4 = i3;
        }
        if (i4 != i5 && z2) {
            v.C(this, arrayList, arrayList2, i2, i4, true, this.l);
            C0(this.n, true);
        }
        while (i5 < i3) {
            a aVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && aVar2.t >= 0) {
                aVar2.t = -1;
            }
            aVar2.F();
            i5++;
        }
        if (z3) {
            S0();
        }
    }

    static int U0(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void V(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<k> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            k kVar = this.C.get(i2);
            if (arrayList != null && !kVar.f1307a && (indexOf2 = arrayList.indexOf(kVar.f1308b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.C.remove(i2);
                i2--;
                size--;
                kVar.c();
            } else if (kVar.e() || (arrayList != null && kVar.f1308b.C(arrayList, 0, arrayList.size()))) {
                this.C.remove(i2);
                i2--;
                size--;
                if (arrayList == null || kVar.f1307a || (indexOf = arrayList.indexOf(kVar.f1308b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    kVar.d();
                } else {
                    kVar.c();
                }
            }
            i2++;
        }
    }

    private void a(b.e.b<Fragment> bVar) {
        int i2 = this.n;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            for (Fragment fragment : this.f1287c.m()) {
                if (fragment.f1210b < min) {
                    E0(fragment, min);
                    if (fragment.H != null && !fragment.z && fragment.L) {
                        bVar.add(fragment);
                    }
                }
            }
        }
    }

    private void a0() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private boolean b0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f1285a) {
            if (this.f1285a.isEmpty()) {
                return false;
            }
            int size = this.f1285a.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                z2 |= this.f1285a.get(i2).b(arrayList, arrayList2);
            }
            this.f1285a.clear();
            this.o.i().removeCallbacks(this.E);
            return z2;
        }
    }

    private void b1(Fragment fragment) {
        ViewGroup g0 = g0(fragment);
        if (g0 != null) {
            int i2 = b.l.b.visible_removing_fragment_view_tag;
            if (g0.getTag(i2) == null) {
                g0.setTag(i2, fragment);
            }
            ((Fragment) g0.getTag(i2)).z1(fragment.F());
        }
    }

    private void d1() {
        for (Fragment fragment : this.f1287c.k()) {
            if (fragment != null) {
                G0(fragment);
            }
        }
    }

    private p e0(Fragment fragment) {
        return this.D.h(fragment);
    }

    private void e1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new b.h.j.b("FragmentManager"));
        j<?> jVar = this.o;
        if (jVar != null) {
            try {
                jVar.k("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                N("  ", null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (d0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (v0(r3.q) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f1292h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.m$i> r0 = r3.f1285a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.m$i> r1 = r3.f1285a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.b r1 = r3.f1292h     // Catch:{ all -> 0x002a }
            r1.f(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.b r0 = r3.f1292h
            int r1 = r3.d0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.q
            boolean r1 = r3.v0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.f(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.f1():void");
    }

    private ViewGroup g0(Fragment fragment) {
        if (fragment.x > 0 && this.p.d()) {
            View b2 = this.p.b(fragment.x);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
        }
        return null;
    }

    private void k(Fragment fragment) {
        HashSet<androidx.core.os.b> hashSet = this.f1295k.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.os.b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            q(fragment);
            this.f1295k.remove(fragment);
        }
    }

    private void m() {
        if (x0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void n() {
        this.f1286b = false;
        this.A.clear();
        this.z.clear();
    }

    static Fragment n0(View view) {
        Object tag = view.getTag(b.l.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void p(Fragment fragment) {
        Animator animator;
        if (fragment.H != null) {
            e.d b2 = e.b(this.o.h(), this.p, fragment, !fragment.z);
            if (b2 == null || (animator = b2.f1265b) == null) {
                if (b2 != null) {
                    fragment.H.startAnimation(b2.f1264a);
                    b2.f1264a.start();
                }
                fragment.H.setVisibility((!fragment.z || fragment.Z()) ? 0 : 8);
                if (fragment.Z()) {
                    fragment.w1(false);
                }
            } else {
                animator.setTarget(fragment.H);
                if (!fragment.z) {
                    fragment.H.setVisibility(0);
                } else if (fragment.Z()) {
                    fragment.w1(false);
                } else {
                    ViewGroup viewGroup = fragment.G;
                    View view = fragment.H;
                    viewGroup.startViewTransition(view);
                    b2.f1265b.addListener(new e(this, viewGroup, view, fragment));
                }
                b2.f1265b.start();
            }
        }
        if (fragment.l && t0(fragment)) {
            this.u = true;
        }
        fragment.M = false;
        fragment.y0(fragment.z);
    }

    private void q(Fragment fragment) {
        fragment.X0();
        this.m.n(fragment, false);
        fragment.G = null;
        fragment.H = null;
        fragment.S = null;
        fragment.T.h(null);
        fragment.o = false;
    }

    static boolean s0(int i2) {
        return F || Log.isLoggable("FragmentManager", i2);
    }

    private boolean t0(Fragment fragment) {
        return (fragment.D && fragment.E) || fragment.u.l();
    }

    private void z0(r rVar) {
        Fragment i2 = rVar.i();
        if (this.f1287c.c(i2.f1214f)) {
            if (s0(2)) {
                Log.v("FragmentManager", "Removed fragment from active set " + i2);
            }
            this.f1287c.o(rVar);
            R0(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z2) {
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null) {
                fragment.b1(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean B(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null && fragment.c1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void B0(Fragment fragment) {
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (this.f1287c.c(fragment.f1214f)) {
            D0(fragment);
            if (fragment.H != null) {
                Fragment j2 = this.f1287c.j(fragment);
                if (j2 != null && (indexOfChild2 = viewGroup.indexOfChild(fragment.H)) < (indexOfChild = (viewGroup = fragment.G).indexOfChild(j2.H))) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.H, indexOfChild);
                }
                if (fragment.L && fragment.G != null) {
                    float f2 = fragment.N;
                    if (f2 > Utils.FLOAT_EPSILON) {
                        fragment.H.setAlpha(f2);
                    }
                    fragment.N = Utils.FLOAT_EPSILON;
                    fragment.L = false;
                    e.d b2 = e.b(this.o.h(), this.p, fragment, true);
                    if (b2 != null) {
                        Animation animation = b2.f1264a;
                        if (animation != null) {
                            fragment.H.startAnimation(animation);
                        } else {
                            b2.f1265b.setTarget(fragment.H);
                            b2.f1265b.start();
                        }
                    }
                }
            }
            if (fragment.M) {
                p(fragment);
            }
        } else if (s0(3)) {
            Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.n + "since it is not added to " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void C(Menu menu) {
        if (this.n >= 1) {
            for (Fragment fragment : this.f1287c.m()) {
                if (fragment != null) {
                    fragment.d1(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void C0(int i2, boolean z2) {
        j<?> jVar;
        if (this.o == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.n) {
            this.n = i2;
            for (Fragment fragment : this.f1287c.m()) {
                B0(fragment);
            }
            for (Fragment fragment2 : this.f1287c.k()) {
                if (fragment2 != null && !fragment2.L) {
                    B0(fragment2);
                }
            }
            d1();
            if (this.u && (jVar = this.o) != null && this.n == 4) {
                jVar.q();
                this.u = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(Fragment fragment) {
        E0(fragment, this.n);
    }

    /* access modifiers changed from: package-private */
    public void E() {
        K(3);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r2 != 3) goto L_0x01f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E0(androidx.fragment.app.Fragment r13, int r14) {
        /*
        // Method dump skipped, instructions count: 552
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.E0(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    public void F(boolean z2) {
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null) {
                fragment.f1(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F0() {
        if (this.o != null) {
            this.v = false;
            this.w = false;
            for (Fragment fragment : this.f1287c.m()) {
                if (fragment != null) {
                    fragment.h0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean G(Menu menu) {
        boolean z2 = false;
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null && fragment.g1(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void G0(Fragment fragment) {
        if (!fragment.I) {
            return;
        }
        if (this.f1286b) {
            this.y = true;
            return;
        }
        fragment.I = false;
        E0(fragment, this.n);
    }

    /* access modifiers changed from: package-private */
    public void H() {
        f1();
        D(this.r);
    }

    public void H0(int i2, int i3) {
        if (i2 >= 0) {
            P(new j(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* access modifiers changed from: package-private */
    public void I() {
        this.v = false;
        this.w = false;
        K(4);
    }

    public void I0(String str, int i2) {
        P(new j(str, -1, i2), false);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        this.v = false;
        this.w = false;
        K(3);
    }

    public boolean J0() {
        return K0(null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public void L() {
        this.w = true;
        K(2);
    }

    /* access modifiers changed from: package-private */
    public boolean L0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = this.f1288d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1288d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f1288d.get(size2);
                    if ((str != null && str.equals(aVar.a())) || (i2 >= 0 && i2 == aVar.t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.f1288d.get(size2);
                        if ((str == null || !str.equals(aVar2.a())) && (i2 < 0 || i2 != aVar2.t)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f1288d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1288d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1288d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void N(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f1287c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f1289e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f1289e.get(i2).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f1288d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f1288d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.w(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1293i.get());
        synchronized (this.f1285a) {
            int size3 = this.f1285a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f1285a.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.v);
        printWriter.print(" mStopped=");
        printWriter.print(this.w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.x);
        if (this.u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.u);
        }
    }

    public void N0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.s == this) {
            bundle.putString(str, fragment.f1214f);
            return;
        }
        e1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void O0(Fragment fragment, androidx.core.os.b bVar) {
        HashSet<androidx.core.os.b> hashSet = this.f1295k.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.f1295k.remove(fragment);
            if (fragment.f1210b < 3) {
                q(fragment);
                E0(fragment, fragment.P());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P(i iVar, boolean z2) {
        if (!z2) {
            if (this.o != null) {
                m();
            } else if (this.x) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f1285a) {
            if (this.o != null) {
                this.f1285a.add(iVar);
                X0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P0(Fragment fragment) {
        if (s0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.r);
        }
        boolean z2 = !fragment.a0();
        if (!fragment.A || z2) {
            this.f1287c.p(fragment);
            if (t0(fragment)) {
                this.u = true;
            }
            fragment.m = true;
            b1(fragment);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean R(boolean z2) {
        Q(z2);
        boolean z3 = false;
        while (b0(this.z, this.A)) {
            this.f1286b = true;
            try {
                Q0(this.z, this.A);
                n();
                z3 = true;
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        f1();
        M();
        this.f1287c.b();
        return z3;
    }

    /* access modifiers changed from: package-private */
    public void R0(Fragment fragment) {
        if (x0()) {
            if (s0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.D.m(fragment) && s0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(i iVar, boolean z2) {
        if (!z2 || (this.o != null && !this.x)) {
            Q(z2);
            if (iVar.b(this.z, this.A)) {
                this.f1286b = true;
                try {
                    Q0(this.z, this.A);
                } finally {
                    n();
                }
            }
            f1();
            M();
            this.f1287c.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void T0(Parcelable parcelable) {
        r rVar;
        if (parcelable != null) {
            o oVar = (o) parcelable;
            if (oVar.f1310b != null) {
                this.f1287c.q();
                Iterator<q> it = oVar.f1310b.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null) {
                        Fragment g2 = this.D.g(next.f1323c);
                        if (g2 != null) {
                            if (s0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + g2);
                            }
                            rVar = new r(this.m, g2, next);
                        } else {
                            rVar = new r(this.m, this.o.h().getClassLoader(), h0(), next);
                        }
                        Fragment i2 = rVar.i();
                        i2.s = this;
                        if (s0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + i2.f1214f + "): " + i2);
                        }
                        rVar.k(this.o.h().getClassLoader());
                        this.f1287c.n(rVar);
                        rVar.r(this.n);
                    }
                }
                for (Fragment fragment : this.D.j()) {
                    if (!this.f1287c.c(fragment.f1214f)) {
                        if (s0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + oVar.f1310b);
                        }
                        E0(fragment, 1);
                        fragment.m = true;
                        E0(fragment, -1);
                    }
                }
                this.f1287c.r(oVar.f1311c);
                if (oVar.f1312d != null) {
                    this.f1288d = new ArrayList<>(oVar.f1312d.length);
                    int i3 = 0;
                    while (true) {
                        b[] bVarArr = oVar.f1312d;
                        if (i3 >= bVarArr.length) {
                            break;
                        }
                        a g3 = bVarArr[i3].g(this);
                        if (s0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + g3.t + "): " + g3);
                            PrintWriter printWriter = new PrintWriter(new b.h.j.b("FragmentManager"));
                            g3.x("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1288d.add(g3);
                        i3++;
                    }
                } else {
                    this.f1288d = null;
                }
                this.f1293i.set(oVar.f1313e);
                String str = oVar.f1314f;
                if (str != null) {
                    Fragment W = W(str);
                    this.r = W;
                    D(W);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Parcelable V0() {
        int size;
        a0();
        O();
        R(true);
        this.v = true;
        ArrayList<q> s2 = this.f1287c.s();
        b[] bVarArr = null;
        if (s2.isEmpty()) {
            if (s0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> t2 = this.f1287c.t();
        ArrayList<a> arrayList = this.f1288d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new b[size];
            for (int i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new b(this.f1288d.get(i2));
                if (s0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1288d.get(i2));
                }
            }
        }
        o oVar = new o();
        oVar.f1310b = s2;
        oVar.f1311c = t2;
        oVar.f1312d = bVarArr;
        oVar.f1313e = this.f1293i.get();
        Fragment fragment = this.r;
        if (fragment != null) {
            oVar.f1314f = fragment.f1214f;
        }
        return oVar;
    }

    /* access modifiers changed from: package-private */
    public Fragment W(String str) {
        return this.f1287c.f(str);
    }

    public Fragment.e W0(Fragment fragment) {
        r l2 = this.f1287c.l(fragment.f1214f);
        if (l2 != null && l2.i().equals(fragment)) {
            return l2.o();
        }
        e1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public Fragment X(int i2) {
        return this.f1287c.g(i2);
    }

    /* access modifiers changed from: package-private */
    public void X0() {
        synchronized (this.f1285a) {
            ArrayList<k> arrayList = this.C;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            if (this.f1285a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.o.i().removeCallbacks(this.E);
                this.o.i().post(this.E);
                f1();
            }
        }
    }

    public Fragment Y(String str) {
        return this.f1287c.h(str);
    }

    /* access modifiers changed from: package-private */
    public void Y0(Fragment fragment, boolean z2) {
        ViewGroup g0 = g0(fragment);
        if (g0 != null && (g0 instanceof g)) {
            ((g) g0).setDrawDisappearingViewsLast(!z2);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment Z(String str) {
        return this.f1287c.i(str);
    }

    /* access modifiers changed from: package-private */
    public void Z0(Fragment fragment, e.b bVar) {
        if (!fragment.equals(W(fragment.f1214f)) || !(fragment.t == null || fragment.s == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.Q = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a1(Fragment fragment) {
        if (fragment == null || (fragment.equals(W(fragment.f1214f)) && (fragment.t == null || fragment.s == this))) {
            Fragment fragment2 = this.r;
            this.r = fragment;
            D(fragment2);
            D(this.r);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        if (this.f1288d == null) {
            this.f1288d = new ArrayList<>();
        }
        this.f1288d.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, androidx.core.os.b bVar) {
        if (this.f1295k.get(fragment) == null) {
            this.f1295k.put(fragment, new HashSet<>());
        }
        this.f1295k.get(fragment).add(bVar);
    }

    public f c0(int i2) {
        return this.f1288d.get(i2);
    }

    /* access modifiers changed from: package-private */
    public void c1(Fragment fragment) {
        if (s0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.z) {
            fragment.z = false;
            fragment.M = !fragment.M;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        if (s0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        y0(fragment);
        if (!fragment.A) {
            this.f1287c.a(fragment);
            fragment.m = false;
            if (fragment.H == null) {
                fragment.M = false;
            }
            if (t0(fragment)) {
                this.u = true;
            }
        }
    }

    public int d0() {
        ArrayList<a> arrayList = this.f1288d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void e(h hVar) {
        if (this.f1294j == null) {
            this.f1294j = new ArrayList<>();
        }
        this.f1294j.add(hVar);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (x0()) {
            if (s0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.D.e(fragment) && s0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public Fragment f0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment W = W(string);
        if (W != null) {
            return W;
        }
        e1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1293i.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public void h(j<?> jVar, f fVar, Fragment fragment) {
        if (this.o == null) {
            this.o = jVar;
            this.p = fVar;
            this.q = fragment;
            if (fragment != null) {
                f1();
            }
            if (jVar instanceof androidx.activity.c) {
                androidx.activity.c cVar = (androidx.activity.c) jVar;
                OnBackPressedDispatcher e2 = cVar.e();
                this.f1291g = e2;
                androidx.lifecycle.i iVar = cVar;
                if (fragment != null) {
                    iVar = fragment;
                }
                e2.a(iVar, this.f1292h);
            }
            if (fragment != null) {
                this.D = fragment.s.e0(fragment);
            } else if (jVar instanceof w) {
                this.D = p.i(((w) jVar).t());
            } else {
                this.D = new p(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public i h0() {
        i iVar = this.s;
        if (iVar != null) {
            return iVar;
        }
        Fragment fragment = this.q;
        if (fragment != null) {
            return fragment.s.h0();
        }
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        if (s0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            if (!fragment.l) {
                this.f1287c.a(fragment);
                if (s0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (t0(fragment)) {
                    this.u = true;
                }
            }
        }
    }

    public List<Fragment> i0() {
        return this.f1287c.m();
    }

    public u j() {
        return new a(this);
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 j0() {
        return this.f1290f;
    }

    /* access modifiers changed from: package-private */
    public l k0() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        boolean z2 = false;
        for (Fragment fragment : this.f1287c.k()) {
            if (fragment != null) {
                z2 = t0(fragment);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Fragment l0() {
        return this.q;
    }

    public Fragment m0() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public void o(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.z(z4);
        } else {
            aVar.y();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            v.C(this, arrayList, arrayList2, 0, 1, true, this.l);
        }
        if (z4) {
            C0(this.n, true);
        }
        for (Fragment fragment : this.f1287c.k()) {
            if (fragment != null && fragment.H != null && fragment.L && aVar.B(fragment.x)) {
                float f2 = fragment.N;
                if (f2 > Utils.FLOAT_EPSILON) {
                    fragment.H.setAlpha(f2);
                }
                if (z4) {
                    fragment.N = Utils.FLOAT_EPSILON;
                } else {
                    fragment.N = -1.0f;
                    fragment.L = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public androidx.lifecycle.v o0(Fragment fragment) {
        return this.D.k(fragment);
    }

    /* access modifiers changed from: package-private */
    public void p0() {
        R(true);
        if (this.f1292h.c()) {
            J0();
        } else {
            this.f1291g.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void q0(Fragment fragment) {
        if (s0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.z) {
            fragment.z = true;
            fragment.M = true ^ fragment.M;
            b1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(Fragment fragment) {
        if (s0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.A) {
            fragment.A = true;
            if (fragment.l) {
                if (s0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f1287c.p(fragment);
                if (t0(fragment)) {
                    this.u = true;
                }
                b1(fragment);
            }
        }
    }

    public boolean r0() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.v = false;
        this.w = false;
        K(2);
    }

    /* access modifiers changed from: package-private */
    public void t(Configuration configuration) {
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null) {
                fragment.R0(configuration);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.q;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.q)));
            sb.append("}");
        } else {
            j<?> jVar = this.o;
            if (jVar != null) {
                sb.append(jVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.o)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean u(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null && fragment.S0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean u0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.b0();
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.v = false;
        this.w = false;
        K(1);
    }

    /* access modifiers changed from: package-private */
    public boolean v0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        m mVar = fragment.s;
        if (!fragment.equals(mVar.m0()) || !v0(mVar.q)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean w(Menu menu, MenuInflater menuInflater) {
        if (this.n < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null && u0(fragment) && fragment.U0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f1289e != null) {
            for (int i2 = 0; i2 < this.f1289e.size(); i2++) {
                Fragment fragment2 = this.f1289e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.u0();
                }
            }
        }
        this.f1289e = arrayList;
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean w0(int i2) {
        return this.n >= i2;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.x = true;
        R(true);
        O();
        K(-1);
        this.o = null;
        this.p = null;
        this.q = null;
        if (this.f1291g != null) {
            this.f1292h.d();
            this.f1291g = null;
        }
    }

    public boolean x0() {
        return this.v || this.w;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        K(1);
    }

    /* access modifiers changed from: package-private */
    public void y0(Fragment fragment) {
        if (!this.f1287c.c(fragment.f1214f)) {
            r rVar = new r(this.m, fragment);
            rVar.k(this.o.h().getClassLoader());
            this.f1287c.n(rVar);
            if (fragment.C) {
                if (fragment.B) {
                    f(fragment);
                } else {
                    R0(fragment);
                }
                fragment.C = false;
            }
            rVar.r(this.n);
            if (s0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z() {
        for (Fragment fragment : this.f1287c.m()) {
            if (fragment != null) {
                fragment.a1();
            }
        }
    }
}
