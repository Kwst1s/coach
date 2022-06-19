package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.h.f.a.c;

/* access modifiers changed from: package-private */
/* compiled from: SubMenuWrapperICS */
public class s extends o implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    private final c f413e;

    s(Context context, c cVar) {
        super(context, cVar);
        this.f413e = cVar;
    }

    public void clearHeader() {
        this.f413e.clearHeader();
    }

    public MenuItem getItem() {
        return c(this.f413e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        this.f413e.setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        this.f413e.setHeaderTitle(i2);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f413e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.f413e.setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f413e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f413e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f413e.setIcon(drawable);
        return this;
    }
}
