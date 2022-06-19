package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;

/* access modifiers changed from: package-private */
/* compiled from: MonthAdapter */
public class m extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    static final int f7723g = s.k().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    final l f7724b;

    /* renamed from: c  reason: collision with root package name */
    final d<?> f7725c;

    /* renamed from: d  reason: collision with root package name */
    private Collection<Long> f7726d;

    /* renamed from: e  reason: collision with root package name */
    c f7727e;

    /* renamed from: f  reason: collision with root package name */
    final a f7728f;

    m(l lVar, d<?> dVar, a aVar) {
        this.f7724b = lVar;
        this.f7725c = dVar;
        this.f7728f = aVar;
        this.f7726d = dVar.f();
    }

    private void e(Context context) {
        if (this.f7727e == null) {
            this.f7727e = new c(context);
        }
    }

    private TextView j(TextView textView, long j2) {
        if (this.f7728f.o().d(j2)) {
            textView.setEnabled(true);
            for (Long l : this.f7725c.f()) {
                if (s.a(j2) == s.a(l.longValue())) {
                    this.f7727e.f7681b.d(textView);
                    return textView;
                }
            }
            if (s.i().getTimeInMillis() == j2) {
                this.f7727e.f7682c.d(textView);
                return textView;
            }
            this.f7727e.f7680a.d(textView);
            return textView;
        }
        textView.setEnabled(false);
        this.f7727e.f7686g.d(textView);
        return textView;
    }

    private void k(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (l.l(j2).equals(this.f7724b)) {
            j((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f7724b.p(j2))), j2);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return b() + (i2 - 1);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f7724b.n();
    }

    /* renamed from: c */
    public Long getItem(int i2) {
        if (i2 < this.f7724b.n() || i2 > h()) {
            return null;
        }
        return Long.valueOf(this.f7724b.o(i(i2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.m.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i2) {
        return i2 % this.f7724b.f7719e == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g(int i2) {
        return (i2 + 1) % this.f7724b.f7719e == 0;
    }

    public int getCount() {
        return this.f7724b.f7720f + b();
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.f7724b.f7719e);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return (this.f7724b.n() + this.f7724b.f7720f) - 1;
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public int i(int i2) {
        return (i2 - this.f7724b.n()) + 1;
    }

    public void l(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l : this.f7726d) {
            k(materialCalendarGridView, l.longValue());
        }
        d<?> dVar = this.f7725c;
        if (dVar != null) {
            for (Long l2 : dVar.f()) {
                k(materialCalendarGridView, l2.longValue());
            }
            this.f7726d = this.f7725c.f();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m(int i2) {
        return i2 >= b() && i2 <= h();
    }
}
