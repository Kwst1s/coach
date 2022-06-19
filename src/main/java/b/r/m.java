package b.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import b.h.k.u;
import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Transition */
public abstract class m implements Cloneable {
    private static final int[] H = {2, 1, 3, 4};
    private static final g I = new a();
    private static ThreadLocal<b.e.a<Animator, d>> J = new ThreadLocal<>();
    private boolean A = false;
    private ArrayList<f> B = null;
    private ArrayList<Animator> C = new ArrayList<>();
    p D;
    private e E;
    private b.e.a<String, String> F;
    private g G = I;

    /* renamed from: b  reason: collision with root package name */
    private String f2906b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private long f2907c = -1;

    /* renamed from: d  reason: collision with root package name */
    long f2908d = -1;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f2909e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<Integer> f2910f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<View> f2911g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f2912h = null;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Class<?>> f2913i = null;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Integer> f2914j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<View> f2915k = null;
    private ArrayList<Class<?>> l = null;
    private ArrayList<String> m = null;
    private ArrayList<Integer> n = null;
    private ArrayList<View> o = null;
    private ArrayList<Class<?>> p = null;
    private t q = new t();
    private t r = new t();
    q s = null;
    private int[] t = H;
    private ArrayList<s> u;
    private ArrayList<s> v;
    boolean w = false;
    ArrayList<Animator> x = new ArrayList<>();
    private int y = 0;
    private boolean z = false;

    /* compiled from: Transition */
    static class a extends g {
        a() {
        }

        @Override // b.r.g
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Transition */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.e.a f2916b;

        b(b.e.a aVar) {
            this.f2916b = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2916b.remove(animator);
            m.this.x.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            m.this.x.add(animator);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Transition */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            m.this.q();
            animator.removeListener(this);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Transition */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f2919a;

        /* renamed from: b  reason: collision with root package name */
        String f2920b;

        /* renamed from: c  reason: collision with root package name */
        s f2921c;

        /* renamed from: d  reason: collision with root package name */
        m0 f2922d;

        /* renamed from: e  reason: collision with root package name */
        m f2923e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.f2919a = view;
            this.f2920b = str;
            this.f2921c = sVar;
            this.f2922d = m0Var;
            this.f2923e = mVar;
        }
    }

    /* compiled from: Transition */
    public static abstract class e {
    }

    /* compiled from: Transition */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean I(s sVar, s sVar2, String str) {
        Object obj = sVar.f2936a.get(str);
        Object obj2 = sVar2.f2936a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void J(b.e.a<View, s> aVar, b.e.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && H(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && H(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void K(b.e.a<View, s> aVar, b.e.a<View, s> aVar2) {
        s remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View i2 = aVar.i(size);
            if (i2 != null && H(i2) && (remove = aVar2.remove(i2)) != null && H(remove.f2937b)) {
                this.u.add(aVar.k(size));
                this.v.add(remove);
            }
        }
    }

    private void L(b.e.a<View, s> aVar, b.e.a<View, s> aVar2, b.e.d<View> dVar, b.e.d<View> dVar2) {
        View e2;
        int m2 = dVar.m();
        for (int i2 = 0; i2 < m2; i2++) {
            View n2 = dVar.n(i2);
            if (n2 != null && H(n2) && (e2 = dVar2.e(dVar.h(i2))) != null && H(e2)) {
                s sVar = aVar.get(n2);
                s sVar2 = aVar2.get(e2);
                if (!(sVar == null || sVar2 == null)) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(n2);
                    aVar2.remove(e2);
                }
            }
        }
    }

    private void M(b.e.a<View, s> aVar, b.e.a<View, s> aVar2, b.e.a<String, View> aVar3, b.e.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View m2 = aVar3.m(i2);
            if (m2 != null && H(m2) && (view = aVar4.get(aVar3.i(i2))) != null && H(view)) {
                s sVar = aVar.get(m2);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(m2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void N(t tVar, t tVar2) {
        b.e.a<View, s> aVar = new b.e.a<>(tVar.f2939a);
        b.e.a<View, s> aVar2 = new b.e.a<>(tVar2.f2939a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.t;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    K(aVar, aVar2);
                } else if (i3 == 2) {
                    M(aVar, aVar2, tVar.f2942d, tVar2.f2942d);
                } else if (i3 == 3) {
                    J(aVar, aVar2, tVar.f2940b, tVar2.f2940b);
                } else if (i3 == 4) {
                    L(aVar, aVar2, tVar.f2941c, tVar2.f2941c);
                }
                i2++;
            } else {
                c(aVar, aVar2);
                return;
            }
        }
    }

    private void T(Animator animator, b.e.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(b.e.a<View, s> aVar, b.e.a<View, s> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            s m2 = aVar.m(i2);
            if (H(m2.f2937b)) {
                this.u.add(m2);
                this.v.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            s m3 = aVar2.m(i3);
            if (H(m3.f2937b)) {
                this.v.add(m3);
                this.u.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f2939a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f2940b.indexOfKey(id) >= 0) {
                tVar.f2940b.put(id, null);
            } else {
                tVar.f2940b.put(id, view);
            }
        }
        String K = u.K(view);
        if (K != null) {
            if (tVar.f2942d.containsKey(K)) {
                tVar.f2942d.put(K, null);
            } else {
                tVar.f2942d.put(K, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f2941c.g(itemIdAtPosition) >= 0) {
                    View e2 = tVar.f2941c.e(itemIdAtPosition);
                    if (e2 != null) {
                        u.w0(e2, false);
                        tVar.f2941c.i(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                u.w0(view, true);
                tVar.f2941c.i(itemIdAtPosition, view);
            }
        }
    }

    private void h(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.f2914j;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.f2915k;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.l;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.l.get(i2).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        s sVar = new s(view);
                        if (z2) {
                            j(sVar);
                        } else {
                            g(sVar);
                        }
                        sVar.f2938c.add(this);
                        i(sVar);
                        if (z2) {
                            d(this.q, view, sVar);
                        } else {
                            d(this.r, view, sVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.n;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.o;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.p;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        if (this.p.get(i3).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    h(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static b.e.a<Animator, d> y() {
        b.e.a<Animator, d> aVar = J.get();
        if (aVar != null) {
            return aVar;
        }
        b.e.a<Animator, d> aVar2 = new b.e.a<>();
        J.set(aVar2);
        return aVar2;
    }

    public List<Integer> A() {
        return this.f2910f;
    }

    public List<String> B() {
        return this.f2912h;
    }

    public List<Class<?>> C() {
        return this.f2913i;
    }

    public List<View> D() {
        return this.f2911g;
    }

    public String[] E() {
        return null;
    }

    public s F(View view, boolean z2) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.F(view, z2);
        }
        return (z2 ? this.q : this.r).f2939a.get(view);
    }

    public boolean G(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] E2 = E();
        if (E2 != null) {
            for (String str : E2) {
                if (!I(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : sVar.f2936a.keySet()) {
            if (I(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean H(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f2914j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f2915k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.l.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.m == null || u.K(view) == null || !this.m.contains(u.K(view)))) {
            return false;
        }
        if ((this.f2910f.size() == 0 && this.f2911g.size() == 0 && (((arrayList = this.f2913i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f2912h) == null || arrayList2.isEmpty()))) || this.f2910f.contains(Integer.valueOf(id)) || this.f2911g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f2912h;
        if (arrayList6 != null && arrayList6.contains(u.K(view))) {
            return true;
        }
        if (this.f2913i != null) {
            for (int i3 = 0; i3 < this.f2913i.size(); i3++) {
                if (this.f2913i.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void O(View view) {
        if (!this.A) {
            b.e.a<Animator, d> y2 = y();
            int size = y2.size();
            m0 d2 = c0.d(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d m2 = y2.m(i2);
                if (m2.f2919a != null && d2.equals(m2.f2922d)) {
                    a.b(y2.i(i2));
                }
            }
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((f) arrayList2.get(i3)).c(this);
                }
            }
            this.z = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void P(ViewGroup viewGroup) {
        d dVar;
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        N(this.q, this.r);
        b.e.a<Animator, d> y2 = y();
        int size = y2.size();
        m0 d2 = c0.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator i3 = y2.i(i2);
            if (!(i3 == null || (dVar = y2.get(i3)) == null || dVar.f2919a == null || !d2.equals(dVar.f2922d))) {
                s sVar = dVar.f2921c;
                View view = dVar.f2919a;
                s F2 = F(view, true);
                s u2 = u(view, true);
                if (F2 == null && u2 == null) {
                    u2 = this.r.f2939a.get(view);
                }
                if (!(F2 == null && u2 == null) && dVar.f2923e.G(sVar, u2)) {
                    if (i3.isRunning() || i3.isStarted()) {
                        i3.cancel();
                    } else {
                        y2.remove(i3);
                    }
                }
            }
        }
        p(viewGroup, this.q, this.r, this.u, this.v);
        U();
    }

    public m Q(f fVar) {
        ArrayList<f> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public m R(View view) {
        this.f2911g.remove(view);
        return this;
    }

    public void S(View view) {
        if (this.z) {
            if (!this.A) {
                b.e.a<Animator, d> y2 = y();
                int size = y2.size();
                m0 d2 = c0.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    d m2 = y2.m(i2);
                    if (m2.f2919a != null && d2.equals(m2.f2922d)) {
                        a.c(y2.i(i2));
                    }
                }
                ArrayList<f> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((f) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.z = false;
        }
    }

    /* access modifiers changed from: protected */
    public void U() {
        b0();
        b.e.a<Animator, d> y2 = y();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (y2.containsKey(next)) {
                b0();
                T(next, y2);
            }
        }
        this.C.clear();
        q();
    }

    public m V(long j2) {
        this.f2908d = j2;
        return this;
    }

    public void W(e eVar) {
        this.E = eVar;
    }

    public m X(TimeInterpolator timeInterpolator) {
        this.f2909e = timeInterpolator;
        return this;
    }

    public void Y(g gVar) {
        if (gVar == null) {
            this.G = I;
        } else {
            this.G = gVar;
        }
    }

    public void Z(p pVar) {
    }

    public m a(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(fVar);
        return this;
    }

    public m a0(long j2) {
        this.f2907c = j2;
        return this;
    }

    public m b(View view) {
        this.f2911g.add(view);
        return this;
    }

    /* access modifiers changed from: protected */
    public void b0() {
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).a(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    /* access modifiers changed from: package-private */
    public String c0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2908d != -1) {
            str2 = str2 + "dur(" + this.f2908d + ") ";
        }
        if (this.f2907c != -1) {
            str2 = str2 + "dly(" + this.f2907c + ") ";
        }
        if (this.f2909e != null) {
            str2 = str2 + "interp(" + this.f2909e + ") ";
        }
        if (this.f2910f.size() <= 0 && this.f2911g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f2910f.size() > 0) {
            for (int i2 = 0; i2 < this.f2910f.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2910f.get(i2);
            }
        }
        if (this.f2911g.size() > 0) {
            for (int i3 = 0; i3 < this.f2911g.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2911g.get(i3);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: protected */
    public void e(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (z() >= 0) {
            animator.setStartDelay(z() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void f() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).cancel();
        }
        ArrayList<f> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((f) arrayList2.get(i2)).b(this);
            }
        }
    }

    public abstract void g(s sVar);

    /* access modifiers changed from: package-private */
    public void i(s sVar) {
        String[] b2;
        if (this.D != null && !sVar.f2936a.isEmpty() && (b2 = this.D.b()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= b2.length) {
                    z2 = true;
                    break;
                } else if (!sVar.f2936a.containsKey(b2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.D.a(sVar);
            }
        }
    }

    public abstract void j(s sVar);

    /* access modifiers changed from: package-private */
    public void k(ViewGroup viewGroup, boolean z2) {
        b.e.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        m(z2);
        if ((this.f2910f.size() > 0 || this.f2911g.size() > 0) && (((arrayList = this.f2912h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f2913i) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f2910f.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f2910f.get(i2).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z2) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f2938c.add(this);
                    i(sVar);
                    if (z2) {
                        d(this.q, findViewById, sVar);
                    } else {
                        d(this.r, findViewById, sVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f2911g.size(); i3++) {
                View view = this.f2911g.get(i3);
                s sVar2 = new s(view);
                if (z2) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.f2938c.add(this);
                i(sVar2);
                if (z2) {
                    d(this.q, view, sVar2);
                } else {
                    d(this.r, view, sVar2);
                }
            }
        } else {
            h(viewGroup, z2);
        }
        if (!(z2 || (aVar = this.F) == null)) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.q.f2942d.remove(this.F.i(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.q.f2942d.put(this.F.m(i5), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z2) {
        if (z2) {
            this.q.f2939a.clear();
            this.q.f2940b.clear();
            this.q.f2941c.b();
            return;
        }
        this.r.f2939a.clear();
        this.r.f2940b.clear();
        this.r.f2941c.b();
    }

    /* renamed from: n */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.C = new ArrayList<>();
            mVar.q = new t();
            mVar.r = new t();
            mVar.u = null;
            mVar.v = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void p(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i2;
        int i3;
        Animator o2;
        View view;
        Animator animator;
        s sVar;
        s sVar2;
        Animator animator2;
        b.e.a<Animator, d> y2 = y();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            s sVar3 = arrayList.get(i4);
            s sVar4 = arrayList2.get(i4);
            if (sVar3 != null && !sVar3.f2938c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f2938c.contains(this)) {
                sVar4 = null;
            }
            if (!(sVar3 == null && sVar4 == null)) {
                if ((sVar3 == null || sVar4 == null || G(sVar3, sVar4)) && (o2 = o(viewGroup, sVar3, sVar4)) != null) {
                    if (sVar4 != null) {
                        view = sVar4.f2937b;
                        String[] E2 = E();
                        if (E2 != null && E2.length > 0) {
                            sVar2 = new s(view);
                            i3 = size;
                            s sVar5 = tVar2.f2939a.get(view);
                            if (sVar5 != null) {
                                int i5 = 0;
                                while (i5 < E2.length) {
                                    sVar2.f2936a.put(E2[i5], sVar5.f2936a.get(E2[i5]));
                                    i5++;
                                    i4 = i4;
                                    sVar5 = sVar5;
                                }
                            }
                            i2 = i4;
                            int size2 = y2.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = o2;
                                    break;
                                }
                                d dVar = y2.get(y2.i(i6));
                                if (dVar.f2921c != null && dVar.f2919a == view && dVar.f2920b.equals(v()) && dVar.f2921c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i3 = size;
                            i2 = i4;
                            animator2 = o2;
                            sVar2 = null;
                        }
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        i3 = size;
                        i2 = i4;
                        view = sVar3.f2937b;
                        animator = o2;
                        sVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.D;
                        if (pVar != null) {
                            long c2 = pVar.c(viewGroup, this, sVar3, sVar4);
                            sparseIntArray.put(this.C.size(), (int) c2);
                            j2 = Math.min(c2, j2);
                        }
                        y2.put(animator, new d(view, v(), this, c0.d(viewGroup), sVar));
                        this.C.add(animator);
                        j2 = j2;
                    }
                    i4 = i2 + 1;
                    size = i3;
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i7)) - j2) + animator3.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        int i2 = this.y - 1;
        this.y = i2;
        if (i2 == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((f) arrayList2.get(i3)).e(this);
                }
            }
            for (int i4 = 0; i4 < this.q.f2941c.m(); i4++) {
                View n2 = this.q.f2941c.n(i4);
                if (n2 != null) {
                    u.w0(n2, false);
                }
            }
            for (int i5 = 0; i5 < this.r.f2941c.m(); i5++) {
                View n3 = this.r.f2941c.n(i5);
                if (n3 != null) {
                    u.w0(n3, false);
                }
            }
            this.A = true;
        }
    }

    public long r() {
        return this.f2908d;
    }

    public e s() {
        return this.E;
    }

    public TimeInterpolator t() {
        return this.f2909e;
    }

    public String toString() {
        return c0(BuildConfig.FLAVOR);
    }

    /* access modifiers changed from: package-private */
    public s u(View view, boolean z2) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.u(view, z2);
        }
        ArrayList<s> arrayList = z2 ? this.u : this.v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            s sVar = arrayList.get(i3);
            if (sVar == null) {
                return null;
            }
            if (sVar.f2937b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.v : this.u).get(i2);
    }

    public String v() {
        return this.f2906b;
    }

    public g w() {
        return this.G;
    }

    public p x() {
        return this.D;
    }

    public long z() {
        return this.f2907c;
    }
}
