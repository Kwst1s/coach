package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
import b.a.d;
import b.h.k.e;
import b.h.k.u;

/* compiled from: MenuPopupHelper */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Context f389a;

    /* renamed from: b  reason: collision with root package name */
    private final g f390b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f391c;

    /* renamed from: d  reason: collision with root package name */
    private final int f392d;

    /* renamed from: e  reason: collision with root package name */
    private final int f393e;

    /* renamed from: f  reason: collision with root package name */
    private View f394f;

    /* renamed from: g  reason: collision with root package name */
    private int f395g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f396h;

    /* renamed from: i  reason: collision with root package name */
    private m.a f397i;

    /* renamed from: j  reason: collision with root package name */
    private k f398j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f399k;
    private final PopupWindow.OnDismissListener l;

    /* compiled from: MenuPopupHelper */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2) {
        this(context, gVar, view, z, i2, 0);
    }

    private k a() {
        k kVar;
        Display defaultDisplay = ((WindowManager) this.f389a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f389a.getResources().getDimensionPixelSize(d.abc_cascading_menus_min_smallest_width)) {
            kVar = new d(this.f389a, this.f394f, this.f392d, this.f393e, this.f391c);
        } else {
            kVar = new q(this.f389a, this.f390b, this.f394f, this.f392d, this.f393e, this.f391c);
        }
        kVar.l(this.f390b);
        kVar.u(this.l);
        kVar.p(this.f394f);
        kVar.k(this.f397i);
        kVar.r(this.f396h);
        kVar.s(this.f395g);
        return kVar;
    }

    private void l(int i2, int i3, boolean z, boolean z2) {
        k c2 = c();
        c2.v(z2);
        if (z) {
            if ((e.b(this.f395g, u.B(this.f394f)) & 7) == 5) {
                i2 -= this.f394f.getWidth();
            }
            c2.t(i2);
            c2.w(i3);
            int i4 = (int) ((this.f389a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.q(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.a();
    }

    public void b() {
        if (d()) {
            this.f398j.dismiss();
        }
    }

    public k c() {
        if (this.f398j == null) {
            this.f398j = a();
        }
        return this.f398j;
    }

    public boolean d() {
        k kVar = this.f398j;
        return kVar != null && kVar.c();
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f398j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f399k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f394f = view;
    }

    public void g(boolean z) {
        this.f396h = z;
        k kVar = this.f398j;
        if (kVar != null) {
            kVar.r(z);
        }
    }

    public void h(int i2) {
        this.f395g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f399k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f397i = aVar;
        k kVar = this.f398j;
        if (kVar != null) {
            kVar.k(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f394f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f394f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f395g = 8388611;
        this.l = new a();
        this.f389a = context;
        this.f390b = gVar;
        this.f394f = view;
        this.f391c = z;
        this.f392d = i2;
        this.f393e = i3;
    }
}
