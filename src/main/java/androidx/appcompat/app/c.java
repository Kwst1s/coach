package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.v0;
import androidx.core.app.a;
import androidx.core.app.f;
import androidx.core.app.n;
import androidx.fragment.app.d;
import b.a.o.b;

/* compiled from: AppCompatActivity */
public class c extends d implements d, n.a {
    private e r;
    private Resources s;

    private boolean S(KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // androidx.fragment.app.d
    public void K() {
        L().o();
    }

    public e L() {
        if (this.r == null) {
            this.r = e.g(this, this);
        }
        return this.r;
    }

    public a M() {
        return L().m();
    }

    public void N(n nVar) {
        nVar.b(this);
    }

    /* access modifiers changed from: protected */
    public void O(int i2) {
    }

    public void P(n nVar) {
    }

    @Deprecated
    public void Q() {
    }

    public boolean R() {
        Intent r2 = r();
        if (r2 == null) {
            return false;
        }
        if (V(r2)) {
            n d2 = n.d(this);
            N(d2);
            P(d2);
            d2.e();
            try {
                a.i(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            U(r2);
            return true;
        }
    }

    public void T(Toolbar toolbar) {
        L().D(toolbar);
    }

    public void U(Intent intent) {
        f.e(this, intent);
    }

    public boolean V(Intent intent) {
        return f.f(this, intent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        L().d(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(L().f(context));
    }

    public void closeOptionsMenu() {
        a M = M();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (M == null || !M.g()) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.e
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a M = M();
        if (keyCode != 82 || M == null || !M.p(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) L().i(i2);
    }

    public MenuInflater getMenuInflater() {
        return L().l();
    }

    public Resources getResources() {
        if (this.s == null && v0.b()) {
            this.s = new v0(this, super.getResources());
        }
        Resources resources = this.s;
        return resources == null ? super.getResources() : resources;
    }

    public void invalidateOptionsMenu() {
        L().o();
    }

    @Override // androidx.appcompat.app.d
    public void j(b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void l(b bVar) {
    }

    @Override // androidx.fragment.app.d
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.s != null) {
            this.s.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        L().p(configuration);
    }

    public void onContentChanged() {
        Q();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e
    public void onCreate(Bundle bundle) {
        e L = L();
        L.n();
        L.q(bundle);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        L().r();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (S(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.d
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a M = M();
        if (menuItem.getItemId() != 16908332 || M == null || (M.j() & 4) == 0) {
            return false;
        }
        return R();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.d
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        L().s(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPostResume() {
        super.onPostResume();
        L().t();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        L().u(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onStart() {
        super.onStart();
        L().v();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onStop() {
        super.onStop();
        L().w();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        L().F(charSequence);
    }

    public void openOptionsMenu() {
        a M = M();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (M == null || !M.q()) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.core.app.n.a
    public Intent r() {
        return f.a(this);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        L().A(i2);
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i2) {
        super.setTheme(i2);
        L().E(i2);
    }

    @Override // androidx.appcompat.app.d
    public b v(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        L().B(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        L().C(view, layoutParams);
    }
}
