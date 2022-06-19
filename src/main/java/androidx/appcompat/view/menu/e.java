package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import b.a.g;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    Context f334b;

    /* renamed from: c  reason: collision with root package name */
    LayoutInflater f335c;

    /* renamed from: d  reason: collision with root package name */
    g f336d;

    /* renamed from: e  reason: collision with root package name */
    ExpandedMenuView f337e;

    /* renamed from: f  reason: collision with root package name */
    int f338f;

    /* renamed from: g  reason: collision with root package name */
    int f339g;

    /* renamed from: h  reason: collision with root package name */
    int f340h;

    /* renamed from: i  reason: collision with root package name */
    private m.a f341i;

    /* renamed from: j  reason: collision with root package name */
    a f342j;

    /* access modifiers changed from: private */
    /* compiled from: ListMenuPresenter */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f343b = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            i v = e.this.f336d.v();
            if (v != null) {
                ArrayList<i> z = e.this.f336d.z();
                int size = z.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (z.get(i2) == v) {
                        this.f343b = i2;
                        return;
                    }
                }
            }
            this.f343b = -1;
        }

        /* renamed from: b */
        public i getItem(int i2) {
            ArrayList<i> z = e.this.f336d.z();
            int i3 = i2 + e.this.f338f;
            int i4 = this.f343b;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return z.get(i3);
        }

        public int getCount() {
            int size = e.this.f336d.z().size() - e.this.f338f;
            return this.f343b < 0 ? size : size - 1;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f335c.inflate(eVar.f340h, viewGroup, false);
            }
            ((n.a) view).e(getItem(i2), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i2) {
        this(i2, 0);
        this.f334b = context;
        this.f335c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f342j == null) {
            this.f342j = new a();
        }
        return this.f342j;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.f341i;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public n c(ViewGroup viewGroup) {
        if (this.f337e == null) {
            this.f337e = (ExpandedMenuView) this.f335c.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f342j == null) {
                this.f342j = new a();
            }
            this.f337e.setAdapter((ListAdapter) this.f342j);
            this.f337e.setOnItemClickListener(this);
        }
        return this.f337e;
    }

    @Override // androidx.appcompat.view.menu.m
    public void d(Context context, g gVar) {
        if (this.f339g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f339g);
            this.f334b = contextThemeWrapper;
            this.f335c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f334b != null) {
            this.f334b = context;
            if (this.f335c == null) {
                this.f335c = LayoutInflater.from(context);
            }
        }
        this.f336d = gVar;
        a aVar = this.f342j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).d(null);
        m.a aVar = this.f341i;
        if (aVar == null) {
            return true;
        }
        aVar.c(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        a aVar = this.f342j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.f341i = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f336d.M(this.f342j.getItem(i2), this, 0);
    }

    public e(int i2, int i3) {
        this.f340h = i2;
        this.f339g = i3;
    }
}
