package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class c extends p {
    private static TimeInterpolator s;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f1691h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f1692i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<j> f1693j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<i> f1694k = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.d0>> l = new ArrayList<>();
    ArrayList<ArrayList<j>> m = new ArrayList<>();
    ArrayList<ArrayList<i>> n = new ArrayList<>();
    ArrayList<RecyclerView.d0> o = new ArrayList<>();
    ArrayList<RecyclerView.d0> p = new ArrayList<>();
    ArrayList<RecyclerView.d0> q = new ArrayList<>();
    ArrayList<RecyclerView.d0> r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1695b;

        a(ArrayList arrayList) {
            this.f1695b = arrayList;
        }

        public void run() {
            Iterator it = this.f1695b.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.T(jVar.f1729a, jVar.f1730b, jVar.f1731c, jVar.f1732d, jVar.f1733e);
            }
            this.f1695b.clear();
            c.this.m.remove(this.f1695b);
        }
    }

    /* compiled from: DefaultItemAnimator */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1697b;

        b(ArrayList arrayList) {
            this.f1697b = arrayList;
        }

        public void run() {
            Iterator it = this.f1697b.iterator();
            while (it.hasNext()) {
                c.this.S((i) it.next());
            }
            this.f1697b.clear();
            c.this.n.remove(this.f1697b);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c  reason: collision with other inner class name */
    /* compiled from: DefaultItemAnimator */
    class RunnableC0025c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1699b;

        RunnableC0025c(ArrayList arrayList) {
            this.f1699b = arrayList;
        }

        public void run() {
            Iterator it = this.f1699b.iterator();
            while (it.hasNext()) {
                c.this.R((RecyclerView.d0) it.next());
            }
            this.f1699b.clear();
            c.this.l.remove(this.f1699b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1702c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1703d;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1701b = d0Var;
            this.f1702c = viewPropertyAnimator;
            this.f1703d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1702c.setListener(null);
            this.f1703d.setAlpha(1.0f);
            c.this.H(this.f1701b);
            c.this.q.remove(this.f1701b);
            c.this.W();
        }

        public void onAnimationStart(Animator animator) {
            c.this.I(this.f1701b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1705b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f1706c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1707d;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1705b = d0Var;
            this.f1706c = view;
            this.f1707d = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1706c.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f1707d.setListener(null);
            c.this.B(this.f1705b);
            c.this.o.remove(this.f1705b);
            c.this.W();
        }

        public void onAnimationStart(Animator animator) {
            c.this.C(this.f1705b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1709b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1710c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1711d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f1712e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1713f;

        f(RecyclerView.d0 d0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1709b = d0Var;
            this.f1710c = i2;
            this.f1711d = view;
            this.f1712e = i3;
            this.f1713f = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f1710c != 0) {
                this.f1711d.setTranslationX(Utils.FLOAT_EPSILON);
            }
            if (this.f1712e != 0) {
                this.f1711d.setTranslationY(Utils.FLOAT_EPSILON);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f1713f.setListener(null);
            c.this.F(this.f1709b);
            c.this.p.remove(this.f1709b);
            c.this.W();
        }

        public void onAnimationStart(Animator animator) {
            c.this.G(this.f1709b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f1715b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1716c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1717d;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1715b = iVar;
            this.f1716c = viewPropertyAnimator;
            this.f1717d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1716c.setListener(null);
            this.f1717d.setAlpha(1.0f);
            this.f1717d.setTranslationX(Utils.FLOAT_EPSILON);
            this.f1717d.setTranslationY(Utils.FLOAT_EPSILON);
            c.this.D(this.f1715b.f1723a, true);
            c.this.r.remove(this.f1715b.f1723a);
            c.this.W();
        }

        public void onAnimationStart(Animator animator) {
            c.this.E(this.f1715b.f1723a, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f1719b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1720c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1721d;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1719b = iVar;
            this.f1720c = viewPropertyAnimator;
            this.f1721d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1720c.setListener(null);
            this.f1721d.setAlpha(1.0f);
            this.f1721d.setTranslationX(Utils.FLOAT_EPSILON);
            this.f1721d.setTranslationY(Utils.FLOAT_EPSILON);
            c.this.D(this.f1719b.f1724b, false);
            c.this.r.remove(this.f1719b.f1724b);
            c.this.W();
        }

        public void onAnimationStart(Animator animator) {
            c.this.E(this.f1719b.f1724b, false);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f1729a;

        /* renamed from: b  reason: collision with root package name */
        public int f1730b;

        /* renamed from: c  reason: collision with root package name */
        public int f1731c;

        /* renamed from: d  reason: collision with root package name */
        public int f1732d;

        /* renamed from: e  reason: collision with root package name */
        public int f1733e;

        j(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
            this.f1729a = d0Var;
            this.f1730b = i2;
            this.f1731c = i3;
            this.f1732d = i4;
            this.f1733e = i5;
        }
    }

    private void U(RecyclerView.d0 d0Var) {
        View view = d0Var.f1565a;
        ViewPropertyAnimator animate = view.animate();
        this.q.add(d0Var);
        animate.setDuration(o()).alpha(Utils.FLOAT_EPSILON).setListener(new d(d0Var, animate, view)).start();
    }

    private void X(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Z(iVar, d0Var) && iVar.f1723a == null && iVar.f1724b == null) {
                list.remove(iVar);
            }
        }
    }

    private void Y(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1723a;
        if (d0Var != null) {
            Z(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f1724b;
        if (d0Var2 != null) {
            Z(iVar, d0Var2);
        }
    }

    private boolean Z(i iVar, RecyclerView.d0 d0Var) {
        boolean z = false;
        if (iVar.f1724b == d0Var) {
            iVar.f1724b = null;
        } else if (iVar.f1723a != d0Var) {
            return false;
        } else {
            iVar.f1723a = null;
            z = true;
        }
        d0Var.f1565a.setAlpha(1.0f);
        d0Var.f1565a.setTranslationX(Utils.FLOAT_EPSILON);
        d0Var.f1565a.setTranslationY(Utils.FLOAT_EPSILON);
        D(d0Var, z);
        return true;
    }

    private void a0(RecyclerView.d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.f1565a.animate().setInterpolator(s);
        j(d0Var);
    }

    @Override // androidx.recyclerview.widget.p
    public boolean A(RecyclerView.d0 d0Var) {
        a0(d0Var);
        this.f1691h.add(d0Var);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void R(RecyclerView.d0 d0Var) {
        View view = d0Var.f1565a;
        ViewPropertyAnimator animate = view.animate();
        this.o.add(d0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, animate)).start();
    }

    /* access modifiers changed from: package-private */
    public void S(i iVar) {
        View view;
        RecyclerView.d0 d0Var = iVar.f1723a;
        View view2 = null;
        if (d0Var == null) {
            view = null;
        } else {
            view = d0Var.f1565a;
        }
        RecyclerView.d0 d0Var2 = iVar.f1724b;
        if (d0Var2 != null) {
            view2 = d0Var2.f1565a;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.r.add(iVar.f1723a);
            duration.translationX((float) (iVar.f1727e - iVar.f1725c));
            duration.translationY((float) (iVar.f1728f - iVar.f1726d));
            duration.alpha(Utils.FLOAT_EPSILON).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.r.add(iVar.f1724b);
            animate.translationX(Utils.FLOAT_EPSILON).translationY(Utils.FLOAT_EPSILON).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void T(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.f1565a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(Utils.FLOAT_EPSILON);
        }
        if (i7 != 0) {
            view.animate().translationY(Utils.FLOAT_EPSILON);
        }
        ViewPropertyAnimator animate = view.animate();
        this.p.add(d0Var);
        animate.setDuration(n()).setListener(new f(d0Var, i6, view, i7, animate)).start();
    }

    /* access modifiers changed from: package-private */
    public void V(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1565a.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        if (!p()) {
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f1565a;
        view.animate().cancel();
        int size = this.f1693j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f1693j.get(size).f1729a == d0Var) {
                view.setTranslationY(Utils.FLOAT_EPSILON);
                view.setTranslationX(Utils.FLOAT_EPSILON);
                F(d0Var);
                this.f1693j.remove(size);
            }
        }
        X(this.f1694k, d0Var);
        if (this.f1691h.remove(d0Var)) {
            view.setAlpha(1.0f);
            H(d0Var);
        }
        if (this.f1692i.remove(d0Var)) {
            view.setAlpha(1.0f);
            B(d0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.n.get(size2);
            X(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f1729a == d0Var) {
                    view.setTranslationY(Utils.FLOAT_EPSILON);
                    view.setTranslationX(Utils.FLOAT_EPSILON);
                    F(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                B(d0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(d0Var);
        this.o.remove(d0Var);
        this.r.remove(d0Var);
        this.p.remove(d0Var);
        W();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f1693j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f1693j.get(size);
            View view = jVar.f1729a.f1565a;
            view.setTranslationY(Utils.FLOAT_EPSILON);
            view.setTranslationX(Utils.FLOAT_EPSILON);
            F(jVar.f1729a);
            this.f1693j.remove(size);
        }
        for (int size2 = this.f1691h.size() - 1; size2 >= 0; size2--) {
            H(this.f1691h.get(size2));
            this.f1691h.remove(size2);
        }
        int size3 = this.f1692i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f1692i.get(size3);
            d0Var.f1565a.setAlpha(1.0f);
            B(d0Var);
            this.f1692i.remove(size3);
        }
        for (int size4 = this.f1694k.size() - 1; size4 >= 0; size4--) {
            Y(this.f1694k.get(size4));
        }
        this.f1694k.clear();
        if (p()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f1729a.f1565a;
                    view2.setTranslationY(Utils.FLOAT_EPSILON);
                    view2.setTranslationX(Utils.FLOAT_EPSILON);
                    F(jVar2.f1729a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f1565a.setAlpha(1.0f);
                    B(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Y(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            V(this.q);
            V(this.p);
            V(this.o);
            V(this.r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return !this.f1692i.isEmpty() || !this.f1694k.isEmpty() || !this.f1693j.isEmpty() || !this.f1691h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean z = !this.f1691h.isEmpty();
        boolean z2 = !this.f1693j.isEmpty();
        boolean z3 = !this.f1694k.isEmpty();
        boolean z4 = !this.f1692i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.d0> it = this.f1691h.iterator();
            while (it.hasNext()) {
                U(it.next());
            }
            this.f1691h.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1693j);
                this.m.add(arrayList);
                this.f1693j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    u.f0(arrayList.get(0).f1729a.f1565a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f1694k);
                this.n.add(arrayList2);
                this.f1694k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    u.f0(arrayList2.get(0).f1723a.f1565a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1692i);
                this.l.add(arrayList3);
                this.f1692i.clear();
                RunnableC0025c cVar = new RunnableC0025c(arrayList3);
                if (z || z2 || z3) {
                    long j2 = 0;
                    long o2 = z ? o() : 0;
                    long n2 = z2 ? n() : 0;
                    if (z3) {
                        j2 = m();
                    }
                    u.f0(arrayList3.get(0).f1565a, cVar, o2 + Math.max(n2, j2));
                    return;
                }
                cVar.run();
            }
        }
    }

    @Override // androidx.recyclerview.widget.p
    public boolean x(RecyclerView.d0 d0Var) {
        a0(d0Var);
        d0Var.f1565a.setAlpha(Utils.FLOAT_EPSILON);
        this.f1692i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.p
    public boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
        if (d0Var == d0Var2) {
            return z(d0Var, i2, i3, i4, i5);
        }
        float translationX = d0Var.f1565a.getTranslationX();
        float translationY = d0Var.f1565a.getTranslationY();
        float alpha = d0Var.f1565a.getAlpha();
        a0(d0Var);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        d0Var.f1565a.setTranslationX(translationX);
        d0Var.f1565a.setTranslationY(translationY);
        d0Var.f1565a.setAlpha(alpha);
        if (d0Var2 != null) {
            a0(d0Var2);
            d0Var2.f1565a.setTranslationX((float) (-i6));
            d0Var2.f1565a.setTranslationY((float) (-i7));
            d0Var2.f1565a.setAlpha(Utils.FLOAT_EPSILON);
        }
        this.f1694k.add(new i(d0Var, d0Var2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.p
    public boolean z(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.f1565a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) d0Var.f1565a.getTranslationY());
        a0(d0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            F(d0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.f1693j.add(new j(d0Var, translationX, translationY, i4, i5));
        return true;
    }

    /* access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f1723a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.d0 f1724b;

        /* renamed from: c  reason: collision with root package name */
        public int f1725c;

        /* renamed from: d  reason: collision with root package name */
        public int f1726d;

        /* renamed from: e  reason: collision with root package name */
        public int f1727e;

        /* renamed from: f  reason: collision with root package name */
        public int f1728f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f1723a = d0Var;
            this.f1724b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1723a + ", newHolder=" + this.f1724b + ", fromX=" + this.f1725c + ", fromY=" + this.f1726d + ", toX=" + this.f1727e + ", toY=" + this.f1728f + '}';
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
            this(d0Var, d0Var2);
            this.f1725c = i2;
            this.f1726d = i3;
            this.f1727e = i4;
            this.f1728f = i5;
        }
    }
}
