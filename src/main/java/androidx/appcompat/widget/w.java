package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import b.h.k.y;

/* compiled from: DecorToolbar */
public interface w {
    void A(int i2);

    void a(Menu menu, m.a aVar);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    void h();

    void i(m.a aVar, g.a aVar2);

    void j(int i2);

    void k(j0 j0Var);

    ViewGroup l();

    void m(boolean z);

    Context n();

    boolean o();

    void p(int i2);

    int q();

    Menu r();

    void s(int i2);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i2);

    int u();

    y v(int i2, long j2);

    void w();

    void x();

    void y(Drawable drawable);

    void z(boolean z);
}
