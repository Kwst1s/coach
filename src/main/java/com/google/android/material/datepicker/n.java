package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.u;
import c.e.a.b.f;
import com.google.android.material.datepicker.h;

/* access modifiers changed from: package-private */
/* compiled from: MonthsPagerAdapter */
public class n extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private final Context f7729c;

    /* renamed from: d  reason: collision with root package name */
    private final a f7730d;

    /* renamed from: e  reason: collision with root package name */
    private final d<?> f7731e;

    /* renamed from: f  reason: collision with root package name */
    private final h.l f7732f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7733g;

    /* access modifiers changed from: package-private */
    /* compiled from: MonthsPagerAdapter */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f7734b;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f7734b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (this.f7734b.getAdapter().m(i2)) {
                n.this.f7732f.a(this.f7734b.getAdapter().getItem(i2).longValue());
            }
        }
    }

    /* compiled from: MonthsPagerAdapter */
    public static class b extends RecyclerView.d0 {
        final TextView t;
        final MaterialCalendarGridView u;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(f.month_title);
            this.t = textView;
            u.n0(textView, true);
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(f.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    n(Context context, d<?> dVar, a aVar, h.l lVar) {
        l s = aVar.s();
        l p = aVar.p();
        l r = aVar.r();
        if (s.compareTo(r) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (r.compareTo(p) <= 0) {
            int Z1 = m.f7723g * h.Z1(context);
            int Z12 = i.k2(context) ? h.Z1(context) : 0;
            this.f7729c = context;
            this.f7733g = Z1 + Z12;
            this.f7730d = aVar;
            this.f7731e = dVar;
            this.f7732f = lVar;
            v(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    /* access modifiers changed from: package-private */
    public int A(l lVar) {
        return this.f7730d.s().t(lVar);
    }

    /* renamed from: B */
    public void m(b bVar, int i2) {
        l s = this.f7730d.s().s(i2);
        bVar.t.setText(s.q(bVar.f1565a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.u.findViewById(f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !s.equals(materialCalendarGridView.getAdapter().f7724b)) {
            m mVar = new m(s, this.f7731e, this.f7730d);
            materialCalendarGridView.setNumColumns(s.f7719e);
            materialCalendarGridView.setAdapter((ListAdapter) mVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().l(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    /* renamed from: C */
    public b o(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(c.e.a.b.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!i.k2(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f7733g));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f7730d.q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long d(int i2) {
        return this.f7730d.s().s(i2).r();
    }

    /* access modifiers changed from: package-private */
    public l y(int i2) {
        return this.f7730d.s().s(i2);
    }

    /* access modifiers changed from: package-private */
    public CharSequence z(int i2) {
        return y(i2).q(this.f7729c);
    }
}
