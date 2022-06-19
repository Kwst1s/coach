package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.u;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* compiled from: MaterialCalendar */
public final class h<S> extends p<S> {
    static final Object i0 = "MONTHS_VIEW_GROUP_TAG";
    static final Object j0 = "NAVIGATION_PREV_TAG";
    static final Object k0 = "NAVIGATION_NEXT_TAG";
    static final Object l0 = "SELECTOR_TOGGLE_TAG";
    private int Y;
    private d<S> Z;
    private a a0;
    private l b0;
    private k c0;
    private c d0;
    private RecyclerView e0;
    private RecyclerView f0;
    private View g0;
    private View h0;

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7693b;

        a(int i2) {
            this.f7693b = i2;
        }

        public void run() {
            h.this.f0.s1(this.f7693b);
        }
    }

    /* compiled from: MaterialCalendar */
    class b extends b.h.k.a {
        b(h hVar) {
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            cVar.c0(null);
        }
    }

    /* compiled from: MaterialCalendar */
    class c extends q {
        final /* synthetic */ int I;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.I = i3;
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void N1(RecyclerView.a0 a0Var, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = h.this.f0.getWidth();
                iArr[1] = h.this.f0.getWidth();
                return;
            }
            iArr[0] = h.this.f0.getHeight();
            iArr[1] = h.this.f0.getHeight();
        }
    }

    /* compiled from: MaterialCalendar */
    class d implements l {
        d() {
        }

        @Override // com.google.android.material.datepicker.h.l
        public void a(long j2) {
            if (h.this.a0.o().d(j2)) {
                h.this.Z.i(j2);
                Iterator<o<S>> it = h.this.X.iterator();
                while (it.hasNext()) {
                    it.next().a((S) h.this.Z.h());
                }
                h.this.f0.getAdapter().h();
                if (h.this.e0 != null) {
                    h.this.e0.getAdapter().h();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public class e extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final Calendar f7696a = s.k();

        /* renamed from: b  reason: collision with root package name */
        private final Calendar f7697b = s.k();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            int i2;
            if ((recyclerView.getAdapter() instanceof t) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                t tVar = (t) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (b.h.j.d<Long, Long> dVar : h.this.Z.c()) {
                    F f2 = dVar.f2586a;
                    if (!(f2 == null || dVar.f2587b == null)) {
                        this.f7696a.setTimeInMillis(f2.longValue());
                        this.f7697b.setTimeInMillis(dVar.f2587b.longValue());
                        int z = tVar.z(this.f7696a.get(1));
                        int z2 = tVar.z(this.f7697b.get(1));
                        View D = gridLayoutManager.D(z);
                        View D2 = gridLayoutManager.D(z2);
                        int Z2 = z / gridLayoutManager.Z2();
                        int Z22 = z2 / gridLayoutManager.Z2();
                        int i3 = Z2;
                        while (i3 <= Z22) {
                            View D3 = gridLayoutManager.D(gridLayoutManager.Z2() * i3);
                            if (D3 != null) {
                                int top = D3.getTop() + h.this.d0.f7683d.c();
                                int bottom = D3.getBottom() - h.this.d0.f7683d.b();
                                int left = i3 == Z2 ? D.getLeft() + (D.getWidth() / 2) : 0;
                                if (i3 == Z22) {
                                    i2 = D2.getLeft() + (D2.getWidth() / 2);
                                } else {
                                    i2 = recyclerView.getWidth();
                                }
                                canvas.drawRect((float) left, (float) top, (float) i2, (float) bottom, h.this.d0.f7687h);
                            }
                            i3++;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public class f extends b.h.k.a {
        f() {
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            String str;
            super.g(view, cVar);
            if (h.this.h0.getVisibility() == 0) {
                str = h.this.Q(c.e.a.b.j.mtrl_picker_toggle_to_year_selection);
            } else {
                str = h.this.Q(c.e.a.b.j.mtrl_picker_toggle_to_day_selection);
            }
            cVar.l0(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public class g extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f7700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialButton f7701b;

        g(n nVar, MaterialButton materialButton) {
            this.f7700a = nVar;
            this.f7701b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.f7701b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            if (i2 < 0) {
                i4 = h.this.a2().a2();
            } else {
                i4 = h.this.a2().d2();
            }
            h.this.b0 = this.f7700a.y(i4);
            this.f7701b.setText(this.f7700a.z(i4));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.h$h  reason: collision with other inner class name */
    /* compiled from: MaterialCalendar */
    public class View$OnClickListenerC0152h implements View.OnClickListener {
        View$OnClickListenerC0152h() {
        }

        public void onClick(View view) {
            h.this.f2();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f7704b;

        i(n nVar) {
            this.f7704b = nVar;
        }

        public void onClick(View view) {
            int a2 = h.this.a2().a2() + 1;
            if (a2 < h.this.f0.getAdapter().c()) {
                h.this.d2(this.f7704b.y(a2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f7706b;

        j(n nVar) {
            this.f7706b = nVar;
        }

        public void onClick(View view) {
            int d2 = h.this.a2().d2() - 1;
            if (d2 >= 0) {
                h.this.d2(this.f7706b.y(d2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public enum k {
        DAY,
        YEAR
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar */
    public interface l {
        void a(long j2);
    }

    private void T1(View view, n nVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(c.e.a.b.f.month_navigation_fragment_toggle);
        materialButton.setTag(l0);
        u.m0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(c.e.a.b.f.month_navigation_previous);
        materialButton2.setTag(j0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(c.e.a.b.f.month_navigation_next);
        materialButton3.setTag(k0);
        this.g0 = view.findViewById(c.e.a.b.f.mtrl_calendar_year_selector_frame);
        this.h0 = view.findViewById(c.e.a.b.f.mtrl_calendar_day_selector_frame);
        e2(k.DAY);
        materialButton.setText(this.b0.q(view.getContext()));
        this.f0.l(new g(nVar, materialButton));
        materialButton.setOnClickListener(new View$OnClickListenerC0152h());
        materialButton3.setOnClickListener(new i(nVar));
        materialButton2.setOnClickListener(new j(nVar));
    }

    private RecyclerView.n U1() {
        return new e();
    }

    static int Z1(Context context) {
        return context.getResources().getDimensionPixelSize(c.e.a.b.d.mtrl_calendar_day_height);
    }

    public static <T> h<T> b2(d<T> dVar, int i2, a aVar) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.r());
        hVar.v1(bundle);
        return hVar;
    }

    private void c2(int i2) {
        this.f0.post(new a(i2));
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        super.K0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Y);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Z);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.b0);
    }

    @Override // com.google.android.material.datepicker.p
    public boolean K1(o<S> oVar) {
        return super.K1(oVar);
    }

    /* access modifiers changed from: package-private */
    public a V1() {
        return this.a0;
    }

    /* access modifiers changed from: package-private */
    public c W1() {
        return this.d0;
    }

    /* access modifiers changed from: package-private */
    public l X1() {
        return this.b0;
    }

    public d<S> Y1() {
        return this.Z;
    }

    /* access modifiers changed from: package-private */
    public LinearLayoutManager a2() {
        return (LinearLayoutManager) this.f0.getLayoutManager();
    }

    /* access modifiers changed from: package-private */
    public void d2(l lVar) {
        n nVar = (n) this.f0.getAdapter();
        int A = nVar.A(lVar);
        int A2 = A - nVar.A(this.b0);
        boolean z = true;
        boolean z2 = Math.abs(A2) > 3;
        if (A2 <= 0) {
            z = false;
        }
        this.b0 = lVar;
        if (z2 && z) {
            this.f0.k1(A - 3);
            c2(A);
        } else if (z2) {
            this.f0.k1(A + 3);
            c2(A);
        } else {
            c2(A);
        }
    }

    /* access modifiers changed from: package-private */
    public void e2(k kVar) {
        this.c0 = kVar;
        if (kVar == k.YEAR) {
            this.e0.getLayoutManager().y1(((t) this.e0.getAdapter()).z(this.b0.f7718d));
            this.g0.setVisibility(0);
            this.h0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.g0.setVisibility(8);
            this.h0.setVisibility(0);
            d2(this.b0);
        }
    }

    /* access modifiers changed from: package-private */
    public void f2() {
        k kVar = this.c0;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            e2(k.DAY);
        } else if (kVar == k.DAY) {
            e2(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (bundle == null) {
            bundle = u();
        }
        this.Y = bundle.getInt("THEME_RES_ID_KEY");
        this.Z = (d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.a0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.b0 = (l) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(w(), this.Y);
        this.d0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        l s = this.a0.s();
        if (i.k2(contextThemeWrapper)) {
            i3 = c.e.a.b.h.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = c.e.a.b.h.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(c.e.a.b.f.mtrl_calendar_days_of_week);
        u.m0(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new g());
        gridView.setNumColumns(s.f7719e);
        gridView.setEnabled(false);
        this.f0 = (RecyclerView) inflate.findViewById(c.e.a.b.f.mtrl_calendar_months);
        this.f0.setLayoutManager(new c(w(), i2, false, i2));
        this.f0.setTag(i0);
        n nVar = new n(contextThemeWrapper, this.Z, this.a0, new d());
        this.f0.setAdapter(nVar);
        int integer = contextThemeWrapper.getResources().getInteger(c.e.a.b.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(c.e.a.b.f.mtrl_calendar_year_selector_frame);
        this.e0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.e0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.e0.setAdapter(new t(this));
            this.e0.h(U1());
        }
        if (inflate.findViewById(c.e.a.b.f.month_navigation_fragment_toggle) != null) {
            T1(inflate, nVar);
        }
        if (!i.k2(contextThemeWrapper)) {
            new androidx.recyclerview.widget.k().b(this.f0);
        }
        this.f0.k1(nVar.A(this.b0));
        return inflate;
    }
}
