package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.m;
import b.a.g;

/* compiled from: MenuDialogHelper */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: b  reason: collision with root package name */
    private g f362b;

    /* renamed from: c  reason: collision with root package name */
    private b f363c;

    /* renamed from: d  reason: collision with root package name */
    e f364d;

    /* renamed from: e  reason: collision with root package name */
    private m.a f365e;

    public h(g gVar) {
        this.f362b = gVar;
    }

    public void a() {
        b bVar = this.f363c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(g gVar, boolean z) {
        if (z || gVar == this.f362b) {
            a();
        }
        m.a aVar = this.f365e;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean c(g gVar) {
        m.a aVar = this.f365e;
        if (aVar != null) {
            return aVar.c(gVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        g gVar = this.f362b;
        b.a aVar = new b.a(gVar.u());
        e eVar = new e(aVar.b(), g.abc_list_menu_item_layout);
        this.f364d = eVar;
        eVar.k(this);
        this.f362b.b(this.f364d);
        aVar.c(this.f364d.a(), this);
        View y = gVar.y();
        if (y != null) {
            aVar.e(y);
        } else {
            aVar.f(gVar.w());
            aVar.n(gVar.x());
        }
        aVar.j(this);
        b a2 = aVar.a();
        this.f363c = a2;
        a2.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f363c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f363c.show();
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f362b.L((i) this.f364d.a().getItem(i2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f364d.b(this.f362b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f363c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f363c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f362b.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f362b.performShortcut(i2, keyEvent, 0);
    }
}
