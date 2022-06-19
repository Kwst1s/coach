package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.b.j;
import com.google.android.material.datepicker.h;
import java.util.Calendar;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: YearGridAdapter */
public class t extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private final h<?> f7740c;

    /* access modifiers changed from: package-private */
    /* compiled from: YearGridAdapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7741b;

        a(int i2) {
            this.f7741b = i2;
        }

        public void onClick(View view) {
            t.this.f7740c.d2(t.this.f7740c.V1().n(l.k(this.f7741b, t.this.f7740c.X1().f7717c)));
            t.this.f7740c.e2(h.k.DAY);
        }
    }

    /* compiled from: YearGridAdapter */
    public static class b extends RecyclerView.d0 {
        final TextView t;

        b(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    t(h<?> hVar) {
        this.f7740c = hVar;
    }

    private View.OnClickListener y(int i2) {
        return new a(i2);
    }

    /* access modifiers changed from: package-private */
    public int A(int i2) {
        return this.f7740c.V1().s().f7718d + i2;
    }

    /* renamed from: B */
    public void m(b bVar, int i2) {
        int A = A(i2);
        String string = bVar.t.getContext().getString(j.mtrl_picker_navigate_to_year_description);
        bVar.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(A)));
        bVar.t.setContentDescription(String.format(string, Integer.valueOf(A)));
        c W1 = this.f7740c.W1();
        Calendar i3 = s.i();
        b bVar2 = i3.get(1) == A ? W1.f7685f : W1.f7683d;
        for (Long l : this.f7740c.Y1().f()) {
            i3.setTimeInMillis(l.longValue());
            if (i3.get(1) == A) {
                bVar2 = W1.f7684e;
            }
        }
        bVar2.d(bVar.t);
        bVar.t.setOnClickListener(y(A));
    }

    /* renamed from: C */
    public b o(ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(c.e.a.b.h.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f7740c.V1().t();
    }

    /* access modifiers changed from: package-private */
    public int z(int i2) {
        return i2 - this.f7740c.V1().s().f7718d;
    }
}
