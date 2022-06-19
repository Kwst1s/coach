package b.r;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.x;
import b.r.m;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* compiled from: FragmentTransitionSupport */
public class e extends x {

    /* compiled from: FragmentTransitionSupport */
    class a extends m.e {
        a(e eVar, Rect rect) {
        }
    }

    /* compiled from: FragmentTransitionSupport */
    class b implements m.f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2862b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f2863c;

        b(e eVar, View view, ArrayList arrayList) {
            this.f2862b = view;
            this.f2863c = arrayList;
        }

        @Override // b.r.m.f
        public void a(m mVar) {
        }

        @Override // b.r.m.f
        public void b(m mVar) {
        }

        @Override // b.r.m.f
        public void c(m mVar) {
        }

        @Override // b.r.m.f
        public void d(m mVar) {
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            mVar.Q(this);
            this.f2862b.setVisibility(8);
            int size = this.f2863c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f2863c.get(i2)).setVisibility(0);
            }
        }
    }

    /* compiled from: FragmentTransitionSupport */
    class c extends n {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f2864b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f2865c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f2866d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2867e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f2868f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f2869g;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2864b = obj;
            this.f2865c = arrayList;
            this.f2866d = obj2;
            this.f2867e = arrayList2;
            this.f2868f = obj3;
            this.f2869g = arrayList3;
        }

        @Override // b.r.m.f, b.r.n
        public void a(m mVar) {
            Object obj = this.f2864b;
            if (obj != null) {
                e.this.q(obj, this.f2865c, null);
            }
            Object obj2 = this.f2866d;
            if (obj2 != null) {
                e.this.q(obj2, this.f2867e, null);
            }
            Object obj3 = this.f2868f;
            if (obj3 != null) {
                e.this.q(obj3, this.f2869g, null);
            }
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            mVar.Q(this);
        }
    }

    /* compiled from: FragmentTransitionSupport */
    class d extends m.e {
        d(e eVar, Rect rect) {
        }
    }

    private static boolean C(m mVar) {
        return !x.l(mVar.A()) || !x.l(mVar.B()) || !x.l(mVar.C());
    }

    @Override // androidx.fragment.app.x
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.D().clear();
            qVar.D().addAll(arrayList2);
            q(qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.x
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.f0((m) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.x
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar != null) {
            int i2 = 0;
            if (mVar instanceof q) {
                q qVar = (q) mVar;
                int i0 = qVar.i0();
                while (i2 < i0) {
                    b(qVar.h0(i2), arrayList);
                    i2++;
                }
            } else if (!C(mVar) && x.l(mVar.D())) {
                int size = arrayList.size();
                while (i2 < size) {
                    mVar.b(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    @Override // androidx.fragment.app.x
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.x
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.x
    public Object g(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.x
    public Object m(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            q qVar = new q();
            qVar.f0(mVar);
            qVar.f0(mVar2);
            qVar.n0(1);
            mVar = qVar;
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar2 = new q();
        if (mVar != null) {
            qVar2.f0(mVar);
        }
        qVar2.f0(mVar3);
        return qVar2;
    }

    @Override // androidx.fragment.app.x
    public Object n(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.f0((m) obj);
        }
        if (obj2 != null) {
            qVar.f0((m) obj2);
        }
        if (obj3 != null) {
            qVar.f0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.x
    public void p(Object obj, View view) {
        if (obj != null) {
            ((m) obj).R(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i2;
        m mVar = (m) obj;
        int i3 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int i0 = qVar.i0();
            while (i3 < i0) {
                q(qVar.h0(i3), arrayList, arrayList2);
                i3++;
            }
        } else if (!C(mVar)) {
            List<View> D = mVar.D();
            if (D.size() == arrayList.size() && D.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i2 = 0;
                } else {
                    i2 = arrayList2.size();
                }
                while (i3 < i2) {
                    mVar.b(arrayList2.get(i3));
                    i3++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    mVar.R(arrayList.get(size));
                }
            }
        }
    }

    @Override // androidx.fragment.app.x
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // androidx.fragment.app.x
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.x
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).W(new d(this, rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((m) obj).W(new a(this, rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> D = qVar.D();
        D.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            x.d(D, arrayList.get(i2));
        }
        D.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }
}
