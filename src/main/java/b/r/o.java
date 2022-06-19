package b.r;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b.h.k.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static m f2924a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<b.e.a<ViewGroup, ArrayList<m>>>> f2925b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f2926c = new ArrayList<>();

    /* access modifiers changed from: private */
    /* compiled from: TransitionManager */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        m f2927b;

        /* renamed from: c  reason: collision with root package name */
        ViewGroup f2928c;

        /* renamed from: b.r.o$a$a  reason: collision with other inner class name */
        /* compiled from: TransitionManager */
        class C0062a extends n {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b.e.a f2929b;

            C0062a(b.e.a aVar) {
                this.f2929b = aVar;
            }

            @Override // b.r.m.f
            public void e(m mVar) {
                ((ArrayList) this.f2929b.get(a.this.f2928c)).remove(mVar);
                mVar.Q(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f2927b = mVar;
            this.f2928c = viewGroup;
        }

        private void a() {
            this.f2928c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2928c.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!o.f2926c.remove(this.f2928c)) {
                return true;
            }
            b.e.a<ViewGroup, ArrayList<m>> b2 = o.b();
            ArrayList<m> arrayList = b2.get(this.f2928c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b2.put(this.f2928c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2927b);
            this.f2927b.a(new C0062a(b2));
            this.f2927b.k(this.f2928c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).S(this.f2928c);
                }
            }
            this.f2927b.P(this.f2928c);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            o.f2926c.remove(this.f2928c);
            ArrayList<m> arrayList = o.b().get(this.f2928c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().S(this.f2928c);
                }
            }
            this.f2927b.m(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (!f2926c.contains(viewGroup) && u.S(viewGroup)) {
            f2926c.add(viewGroup);
            if (mVar == null) {
                mVar = f2924a;
            }
            m n = mVar.clone();
            d(viewGroup, n);
            l.c(viewGroup, null);
            c(viewGroup, n);
        }
    }

    static b.e.a<ViewGroup, ArrayList<m>> b() {
        b.e.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<b.e.a<ViewGroup, ArrayList<m>>> weakReference = f2925b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        b.e.a<ViewGroup, ArrayList<m>> aVar2 = new b.e.a<>();
        f2925b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar != null && viewGroup != null) {
            a aVar = new a(mVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().O(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.k(viewGroup, true);
        }
        l b2 = l.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}
