package com.esafirm.imagepicker.features.w;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.f;
import c.c.a.g.g;
import c.c.a.g.h;
import com.esafirm.imagepicker.features.l;
import com.esafirm.imagepicker.features.r;
import com.esafirm.imagepicker.helper.c;
import com.esafirm.imagepicker.view.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecyclerViewManager */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4568a;

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView f4569b;

    /* renamed from: c  reason: collision with root package name */
    private final l f4570c;

    /* renamed from: d  reason: collision with root package name */
    private GridLayoutManager f4571d;

    /* renamed from: e  reason: collision with root package name */
    private a f4572e;

    /* renamed from: f  reason: collision with root package name */
    private h f4573f;

    /* renamed from: g  reason: collision with root package name */
    private g f4574g;

    /* renamed from: h  reason: collision with root package name */
    private Parcelable f4575h;

    /* renamed from: i  reason: collision with root package name */
    private int f4576i;

    /* renamed from: j  reason: collision with root package name */
    private int f4577j;

    public b(RecyclerView recyclerView, l lVar, int i2) {
        this.f4569b = recyclerView;
        this.f4570c = lVar;
        this.f4568a = recyclerView.getContext();
        a(i2);
    }

    private void b() {
        if (this.f4573f == null) {
            throw new IllegalStateException("Must call setupAdapters first!");
        }
    }

    private boolean g() {
        return this.f4569b.getAdapter() == null || (this.f4569b.getAdapter() instanceof g);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(c.c.a.h.a aVar, c.c.a.i.a aVar2) {
        this.f4575h = this.f4569b.getLayoutManager().e1();
        aVar.a(aVar2);
    }

    private void p(int i2) {
        a aVar = this.f4572e;
        if (aVar != null) {
            this.f4569b.Y0(aVar);
        }
        a aVar2 = new a(i2, this.f4568a.getResources().getDimensionPixelSize(c.c.a.a.ef_item_padding), false);
        this.f4572e = aVar2;
        this.f4569b.h(aVar2);
        this.f4571d.g3(i2);
    }

    public void a(int i2) {
        this.f4576i = i2 == 1 ? 3 : 5;
        this.f4577j = i2 == 1 ? 2 : 4;
        int i3 = this.f4570c.v() && g() ? this.f4577j : this.f4576i;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f4568a, i3);
        this.f4571d = gridLayoutManager;
        this.f4569b.setLayoutManager(gridLayoutManager);
        this.f4569b.setHasFixedSize(true);
        p(i3);
    }

    public Parcelable c() {
        return this.f4571d.e1();
    }

    public List<c.c.a.i.b> d() {
        b();
        return this.f4573f.B();
    }

    public String e() {
        if (g()) {
            return com.esafirm.imagepicker.helper.a.b(this.f4568a, this.f4570c);
        }
        if (this.f4570c.s() == 1) {
            return com.esafirm.imagepicker.helper.a.c(this.f4568a, this.f4570c);
        }
        int size = this.f4573f.B().size();
        if (!c.f(this.f4570c.q()) && size == 0) {
            return com.esafirm.imagepicker.helper.a.c(this.f4568a, this.f4570c);
        }
        if (this.f4570c.r() == 999) {
            return String.format(this.f4568a.getString(f.ef_selected), Integer.valueOf(size));
        }
        return String.format(this.f4568a.getString(f.ef_selected_with_limit), Integer.valueOf(size), Integer.valueOf(this.f4570c.r()));
    }

    public boolean f() {
        if (!this.f4570c.v() || g()) {
            return false;
        }
        m(null);
        return true;
    }

    public boolean h() {
        return !g() && !this.f4573f.B().isEmpty() && this.f4570c.k() != r.ALL && this.f4570c.k() != r.GALLERY_ONLY;
    }

    public void k(Parcelable parcelable) {
        this.f4571d.d1(parcelable);
    }

    public boolean l(boolean z) {
        if (this.f4570c.s() == 2) {
            if (this.f4573f.B().size() >= this.f4570c.r() && !z) {
                Toast.makeText(this.f4568a, f.ef_msg_limit_images, 0).show();
                return false;
            }
        } else if (this.f4570c.s() == 1 && this.f4573f.B().size() > 0) {
            this.f4573f.O();
        }
        return true;
    }

    public void m(List<c.c.a.i.a> list) {
        this.f4574g.E(list);
        p(this.f4577j);
        this.f4569b.setAdapter(this.f4574g);
        if (this.f4575h != null) {
            this.f4571d.g3(this.f4577j);
            this.f4569b.getLayoutManager().d1(this.f4575h);
        }
    }

    public void n(List<c.c.a.i.b> list) {
        this.f4573f.Q(list);
        p(this.f4576i);
        this.f4569b.setAdapter(this.f4573f);
    }

    public void o(c.c.a.h.c cVar) {
        b();
        this.f4573f.R(cVar);
    }

    public void q(ArrayList<c.c.a.i.b> arrayList, c.c.a.h.b bVar, c.c.a.h.a aVar) {
        if (this.f4570c.s() == 1 && arrayList != null && arrayList.size() > 1) {
            arrayList = null;
        }
        com.esafirm.imagepicker.features.v.a p = this.f4570c.p();
        this.f4573f = new h(this.f4568a, p, arrayList, bVar);
        this.f4574g = new g(this.f4568a, p, new a(this, aVar));
    }
}
