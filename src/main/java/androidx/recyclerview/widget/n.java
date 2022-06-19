package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import b.h.k.d0.c;
import b.h.k.d0.d;
import b.h.k.u;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class n extends b.h.k.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f1817d;

    /* renamed from: e  reason: collision with root package name */
    private final a f1818e;

    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends b.h.k.a {

        /* renamed from: d  reason: collision with root package name */
        final n f1819d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, b.h.k.a> f1820e = new WeakHashMap();

        public a(n nVar) {
            this.f1819d = nVar;
        }

        @Override // b.h.k.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                return aVar.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // b.h.k.a
        public d b(View view) {
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                return aVar.b(view);
            }
            return super.b(view);
        }

        @Override // b.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // b.h.k.a
        public void g(View view, c cVar) {
            if (this.f1819d.o() || this.f1819d.f1817d.getLayoutManager() == null) {
                super.g(view, cVar);
                return;
            }
            this.f1819d.f1817d.getLayoutManager().P0(view, cVar);
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                aVar.g(view, cVar);
            } else {
                super.g(view, cVar);
            }
        }

        @Override // b.h.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // b.h.k.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            b.h.k.a aVar = this.f1820e.get(viewGroup);
            if (aVar != null) {
                return aVar.i(viewGroup, view, accessibilityEvent);
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // b.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (this.f1819d.o() || this.f1819d.f1817d.getLayoutManager() == null) {
                return super.j(view, i2, bundle);
            }
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i2, bundle)) {
                    return true;
                }
            } else if (super.j(view, i2, bundle)) {
                return true;
            }
            return this.f1819d.f1817d.getLayoutManager().j1(view, i2, bundle);
        }

        @Override // b.h.k.a
        public void l(View view, int i2) {
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                aVar.l(view, i2);
            } else {
                super.l(view, i2);
            }
        }

        @Override // b.h.k.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            b.h.k.a aVar = this.f1820e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* access modifiers changed from: package-private */
        public b.h.k.a n(View view) {
            return this.f1820e.remove(view);
        }

        /* access modifiers changed from: package-private */
        public void o(View view) {
            b.h.k.a l = u.l(view);
            if (l != null && l != this) {
                this.f1820e.put(view, l);
            }
        }
    }

    public n(RecyclerView recyclerView) {
        this.f1817d = recyclerView;
        b.h.k.a n = n();
        if (n == null || !(n instanceof a)) {
            this.f1818e = new a(this);
        } else {
            this.f1818e = (a) n;
        }
    }

    @Override // b.h.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !o()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().L0(accessibilityEvent);
            }
        }
    }

    @Override // b.h.k.a
    public void g(View view, c cVar) {
        super.g(view, cVar);
        if (!o() && this.f1817d.getLayoutManager() != null) {
            this.f1817d.getLayoutManager().N0(cVar);
        }
    }

    @Override // b.h.k.a
    public boolean j(View view, int i2, Bundle bundle) {
        if (super.j(view, i2, bundle)) {
            return true;
        }
        if (o() || this.f1817d.getLayoutManager() == null) {
            return false;
        }
        return this.f1817d.getLayoutManager().h1(i2, bundle);
    }

    public b.h.k.a n() {
        return this.f1818e;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f1817d.o0();
    }
}
