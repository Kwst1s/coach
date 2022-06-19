package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.m;
import b.h.k.r;
import b.h.k.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: FragmentTransition */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1364a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final x f1365b = (Build.VERSION.SDK_INT >= 21 ? new w() : null);

    /* renamed from: c  reason: collision with root package name */
    private static final x f1366c = x();

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f1367b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1368c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1369d;

        a(g gVar, Fragment fragment, androidx.core.os.b bVar) {
            this.f1367b = gVar;
            this.f1368c = fragment;
            this.f1369d = bVar;
        }

        public void run() {
            this.f1367b.a(this.f1368c, this.f1369d);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1370b;

        b(ArrayList arrayList) {
            this.f1370b = arrayList;
        }

        public void run() {
            v.B(this.f1370b, 4);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f1371b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1372c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1373d;

        c(g gVar, Fragment fragment, androidx.core.os.b bVar) {
            this.f1371b = gVar;
            this.f1372c = fragment;
            this.f1373d = bVar;
        }

        public void run() {
            this.f1371b.a(this.f1372c, this.f1373d);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f1374b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x f1375c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1376d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Fragment f1377e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f1378f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f1379g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ArrayList f1380h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Object f1381i;

        d(Object obj, x xVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1374b = obj;
            this.f1375c = xVar;
            this.f1376d = view;
            this.f1377e = fragment;
            this.f1378f = arrayList;
            this.f1379g = arrayList2;
            this.f1380h = arrayList3;
            this.f1381i = obj2;
        }

        public void run() {
            Object obj = this.f1374b;
            if (obj != null) {
                this.f1375c.p(obj, this.f1376d);
                this.f1379g.addAll(v.k(this.f1375c, this.f1374b, this.f1377e, this.f1378f, this.f1376d));
            }
            if (this.f1380h != null) {
                if (this.f1381i != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1376d);
                    this.f1375c.q(this.f1381i, this.f1380h, arrayList);
                }
                this.f1380h.clear();
                this.f1380h.add(this.f1376d);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1382b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1383c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f1384d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b.e.a f1385e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f1386f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ x f1387g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Rect f1388h;

        e(Fragment fragment, Fragment fragment2, boolean z, b.e.a aVar, View view, x xVar, Rect rect) {
            this.f1382b = fragment;
            this.f1383c = fragment2;
            this.f1384d = z;
            this.f1385e = aVar;
            this.f1386f = view;
            this.f1387g = xVar;
            this.f1388h = rect;
        }

        public void run() {
            v.f(this.f1382b, this.f1383c, this.f1384d, this.f1385e, false);
            View view = this.f1386f;
            if (view != null) {
                this.f1387g.k(view, this.f1388h);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f1389b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.e.a f1390c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f1391d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ h f1392e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f1393f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ View f1394g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Fragment f1395h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Fragment f1396i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f1397j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ ArrayList f1398k;
        final /* synthetic */ Object l;
        final /* synthetic */ Rect m;

        f(x xVar, b.e.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1389b = xVar;
            this.f1390c = aVar;
            this.f1391d = obj;
            this.f1392e = hVar;
            this.f1393f = arrayList;
            this.f1394g = view;
            this.f1395h = fragment;
            this.f1396i = fragment2;
            this.f1397j = z;
            this.f1398k = arrayList2;
            this.l = obj2;
            this.m = rect;
        }

        public void run() {
            b.e.a<String, View> h2 = v.h(this.f1389b, this.f1390c, this.f1391d, this.f1392e);
            if (h2 != null) {
                this.f1393f.addAll(h2.values());
                this.f1393f.add(this.f1394g);
            }
            v.f(this.f1395h, this.f1396i, this.f1397j, h2, false);
            Object obj = this.f1391d;
            if (obj != null) {
                this.f1389b.A(obj, this.f1398k, this.f1393f);
                View t = v.t(h2, this.f1392e, this.l, this.f1397j);
                if (t != null) {
                    this.f1389b.k(t, this.m);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public interface g {
        void a(Fragment fragment, androidx.core.os.b bVar);

        void b(Fragment fragment, androidx.core.os.b bVar);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransition */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f1399a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1400b;

        /* renamed from: c  reason: collision with root package name */
        public a f1401c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f1402d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1403e;

        /* renamed from: f  reason: collision with root package name */
        public a f1404f;

        h() {
        }
    }

    private static void A(x xVar, Object obj, Object obj2, b.e.a<String, View> aVar, boolean z, a aVar2) {
        String str;
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = aVar2.o.get(0);
            } else {
                str = aVar2.n.get(0);
            }
            View view = aVar.get(str);
            xVar.v(obj, view);
            if (obj2 != null) {
                xVar.v(obj2, view);
            }
        }
    }

    static void B(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    static void C(m mVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, g gVar) {
        if (mVar.n >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i4 = i2; i4 < i3; i4++) {
                a aVar = arrayList.get(i4);
                if (arrayList2.get(i4).booleanValue()) {
                    e(aVar, sparseArray, z);
                } else {
                    c(aVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(mVar.o.h());
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    b.e.a<String, String> d2 = d(keyAt, arrayList, arrayList2, i2, i3);
                    h hVar = (h) sparseArray.valueAt(i5);
                    if (z) {
                        o(mVar, keyAt, hVar, view, d2, gVar);
                    } else {
                        n(mVar, keyAt, hVar, view, d2, gVar);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, b.e.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View m = aVar.m(size);
            if (collection.contains(u.K(m))) {
                arrayList.add(m);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.l != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008a, code lost:
        if (r0.z == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008c, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.u.a r9, android.util.SparseArray<androidx.fragment.app.v.h> r10, boolean r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.v.b(androidx.fragment.app.a, androidx.fragment.app.u$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.f1345a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(aVar, aVar.f1345a.get(i2), sparseArray, false, z);
        }
    }

    private static b.e.a<String, String> d(int i2, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        b.e.a<String, String> aVar = new b.e.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            a aVar2 = arrayList.get(i5);
            if (aVar2.B(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar2.n;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.n;
                        arrayList4 = aVar2.o;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.n;
                        arrayList3 = aVar2.o;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.r.p.d()) {
            for (int size = aVar.f1345a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f1345a.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, b.e.a<String, View> aVar, boolean z2) {
        m mVar;
        int i2;
        if (z) {
            mVar = fragment2.y();
        } else {
            mVar = fragment.y();
        }
        if (mVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar == null) {
                i2 = 0;
            } else {
                i2 = aVar.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList2.add(aVar.i(i3));
                arrayList.add(aVar.m(i3));
            }
            if (z2) {
                mVar.c(arrayList2, arrayList, null);
            } else {
                mVar.b(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean g(x xVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!xVar.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static b.e.a<String, View> h(x xVar, b.e.a<String, String> aVar, Object obj, h hVar) {
        m mVar;
        ArrayList<String> arrayList;
        String q;
        Fragment fragment = hVar.f1399a;
        View T = fragment.T();
        if (aVar.isEmpty() || obj == null || T == null) {
            aVar.clear();
            return null;
        }
        b.e.a<String, View> aVar2 = new b.e.a<>();
        xVar.j(aVar2, T);
        a aVar3 = hVar.f1401c;
        if (hVar.f1400b) {
            mVar = fragment.A();
            arrayList = aVar3.n;
        } else {
            mVar = fragment.y();
            arrayList = aVar3.o;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        if (mVar != null) {
            mVar.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String q2 = q(aVar, str);
                    if (q2 != null) {
                        aVar.remove(q2);
                    }
                } else if (!str.equals(u.K(view)) && (q = q(aVar, str)) != null) {
                    aVar.put(q, u.K(view));
                }
            }
        } else {
            y(aVar, aVar2);
        }
        return aVar2;
    }

    private static b.e.a<String, View> i(x xVar, b.e.a<String, String> aVar, Object obj, h hVar) {
        m mVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f1402d;
        b.e.a<String, View> aVar2 = new b.e.a<>();
        xVar.j(aVar2, fragment.q1());
        a aVar3 = hVar.f1404f;
        if (hVar.f1403e) {
            mVar = fragment.y();
            arrayList = aVar3.o;
        } else {
            mVar = fragment.A();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
        }
        if (mVar != null) {
            mVar.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(u.K(view))) {
                    aVar.put(u.K(view), aVar.remove(str));
                }
            }
        } else {
            aVar.o(aVar2.keySet());
        }
        return aVar2;
    }

    private static x j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object z = fragment.z();
            if (z != null) {
                arrayList.add(z);
            }
            Object M = fragment.M();
            if (M != null) {
                arrayList.add(M);
            }
            Object O = fragment.O();
            if (O != null) {
                arrayList.add(O);
            }
        }
        if (fragment2 != null) {
            Object x = fragment2.x();
            if (x != null) {
                arrayList.add(x);
            }
            Object J = fragment2.J();
            if (J != null) {
                arrayList.add(J);
            }
            Object N = fragment2.N();
            if (N != null) {
                arrayList.add(N);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        x xVar = f1365b;
        if (xVar != null && g(xVar, arrayList)) {
            return xVar;
        }
        x xVar2 = f1366c;
        if (xVar2 != null && g(xVar2, arrayList)) {
            return xVar2;
        }
        if (xVar == null && xVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View T = fragment.T();
        if (T != null) {
            xVar.f(arrayList2, T);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        xVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(x xVar, ViewGroup viewGroup, View view, b.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        b.e.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        Fragment fragment = hVar.f1399a;
        Fragment fragment2 = hVar.f1402d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1400b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = u(xVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        b.e.a<String, View> i2 = i(xVar, aVar2, obj3, hVar);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList.addAll(i2.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z, i2, true);
        if (obj4 != null) {
            rect = new Rect();
            xVar.z(obj4, view, arrayList);
            A(xVar, obj4, obj2, i2, hVar.f1403e, hVar.f1404f);
            if (obj != null) {
                xVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        r.a(viewGroup, new f(xVar, aVar, obj4, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj4;
    }

    private static Object m(x xVar, ViewGroup viewGroup, View view, b.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        Fragment fragment = hVar.f1399a;
        Fragment fragment2 = hVar.f1402d;
        if (fragment != null) {
            fragment.q1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1400b;
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = u(xVar, fragment, fragment2, z);
        }
        b.e.a<String, View> i2 = i(xVar, aVar, obj3, hVar);
        b.e.a<String, View> h2 = h(xVar, aVar, obj3, hVar);
        if (aVar.isEmpty()) {
            if (i2 != null) {
                i2.clear();
            }
            if (h2 != null) {
                h2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList, i2, aVar.keySet());
            a(arrayList2, h2, aVar.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z, i2, true);
        if (obj4 != null) {
            arrayList2.add(view);
            xVar.z(obj4, view, arrayList);
            A(xVar, obj4, obj2, i2, hVar.f1403e, hVar.f1404f);
            Rect rect2 = new Rect();
            View t = t(h2, hVar, obj, z);
            if (t != null) {
                xVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = t;
        } else {
            view2 = null;
            rect = null;
        }
        r.a(viewGroup, new e(fragment, fragment2, z, h2, view2, xVar, rect));
        return obj4;
    }

    private static void n(m mVar, int i2, h hVar, View view, b.e.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        x j2;
        Object obj;
        ViewGroup viewGroup = mVar.p.d() ? (ViewGroup) mVar.p.b(i2) : null;
        if (viewGroup != null && (j2 = j((fragment2 = hVar.f1402d), (fragment = hVar.f1399a))) != null) {
            boolean z = hVar.f1400b;
            boolean z2 = hVar.f1403e;
            Object r = r(j2, fragment, z);
            Object s = s(j2, fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object l = l(j2, viewGroup, view, aVar, hVar, arrayList, arrayList2, r, s);
            if (r == null && l == null) {
                obj = s;
                if (obj == null) {
                    return;
                }
            } else {
                obj = s;
            }
            ArrayList<View> k2 = k(j2, obj, fragment2, arrayList, view);
            Object obj2 = (k2 == null || k2.isEmpty()) ? null : obj;
            j2.a(r, view);
            Object v = v(j2, r, obj2, l, fragment, hVar.f1400b);
            if (!(fragment2 == null || k2 == null || (k2.size() <= 0 && arrayList.size() <= 0))) {
                androidx.core.os.b bVar = new androidx.core.os.b();
                gVar.b(fragment2, bVar);
                j2.w(fragment2, v, bVar, new c(gVar, fragment2, bVar));
            }
            if (v != null) {
                ArrayList<View> arrayList3 = new ArrayList<>();
                j2.t(v, r, arrayList3, obj2, k2, l, arrayList2);
                z(j2, viewGroup, fragment, view, arrayList2, r, arrayList3, obj2, k2);
                j2.x(viewGroup, arrayList2, aVar);
                j2.c(viewGroup, v);
                j2.s(viewGroup, arrayList2, aVar);
            }
        }
    }

    private static void o(m mVar, int i2, h hVar, View view, b.e.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        x j2;
        Object obj;
        ViewGroup viewGroup = mVar.p.d() ? (ViewGroup) mVar.p.b(i2) : null;
        if (viewGroup != null && (j2 = j((fragment2 = hVar.f1402d), (fragment = hVar.f1399a))) != null) {
            boolean z = hVar.f1400b;
            boolean z2 = hVar.f1403e;
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object r = r(j2, fragment, z);
            Object s = s(j2, fragment2, z2);
            Object m = m(j2, viewGroup, view, aVar, hVar, arrayList2, arrayList, r, s);
            if (r == null && m == null) {
                obj = s;
                if (obj == null) {
                    return;
                }
            } else {
                obj = s;
            }
            ArrayList<View> k2 = k(j2, obj, fragment2, arrayList2, view);
            ArrayList<View> k3 = k(j2, r, fragment, arrayList, view);
            B(k3, 4);
            Object v = v(j2, r, obj, m, fragment, z);
            if (!(fragment2 == null || k2 == null || (k2.size() <= 0 && arrayList2.size() <= 0))) {
                androidx.core.os.b bVar = new androidx.core.os.b();
                gVar.b(fragment2, bVar);
                j2.w(fragment2, v, bVar, new a(gVar, fragment2, bVar));
            }
            if (v != null) {
                w(j2, obj, fragment2, k2);
                ArrayList<String> o = j2.o(arrayList);
                j2.t(v, r, k3, obj, k2, m, arrayList);
                j2.c(viewGroup, v);
                j2.y(viewGroup, arrayList2, arrayList, o, aVar);
                B(k3, 0);
                j2.A(m, arrayList2, arrayList);
            }
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i2) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i2, hVar2);
        return hVar2;
    }

    private static String q(b.e.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(aVar.m(i2))) {
                return aVar.i(i2);
            }
        }
        return null;
    }

    private static Object r(x xVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.J();
        } else {
            obj = fragment.x();
        }
        return xVar.g(obj);
    }

    private static Object s(x xVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.M();
        } else {
            obj = fragment.z();
        }
        return xVar.g(obj);
    }

    static View t(b.e.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        a aVar2 = hVar.f1401c;
        if (obj == null || aVar == null || (arrayList = aVar2.n) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.n.get(0);
        } else {
            str = aVar2.o.get(0);
        }
        return aVar.get(str);
    }

    private static Object u(x xVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.O();
        } else {
            obj = fragment.N();
        }
        return xVar.B(xVar.g(obj));
    }

    private static Object v(x xVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.q() : fragment.o();
        }
        if (z2) {
            return xVar.n(obj2, obj, obj3);
        }
        return xVar.m(obj2, obj, obj3);
    }

    private static void w(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.l && fragment.z && fragment.M) {
            fragment.w1(true);
            xVar.r(obj, fragment.T(), arrayList);
            r.a(fragment.G, new b(arrayList));
        }
    }

    private static x x() {
        try {
            return (x) Class.forName("b.r.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void y(b.e.a<String, String> aVar, b.e.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void z(x xVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        r.a(viewGroup, new d(obj, xVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
