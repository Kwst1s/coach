package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import b.h.k.b;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS */
public class j extends c implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    private final b.h.f.a.b f378d;

    /* renamed from: e  reason: collision with root package name */
    private Method f379e;

    /* compiled from: MenuItemWrapperICS */
    private class a extends b.h.k.b {

        /* renamed from: b  reason: collision with root package name */
        final ActionProvider f380b;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f380b = actionProvider;
        }

        @Override // b.h.k.b
        public boolean a() {
            return this.f380b.hasSubMenu();
        }

        @Override // b.h.k.b
        public View c() {
            return this.f380b.onCreateActionView();
        }

        @Override // b.h.k.b
        public boolean e() {
            return this.f380b.onPerformDefaultAction();
        }

        @Override // b.h.k.b
        public void f(SubMenu subMenu) {
            this.f380b.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        private b.AbstractC0047b f382d;

        b(j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // b.h.k.b
        public boolean b() {
            return this.f380b.isVisible();
        }

        @Override // b.h.k.b
        public View d(MenuItem menuItem) {
            return this.f380b.onCreateActionView(menuItem);
        }

        @Override // b.h.k.b
        public boolean g() {
            return this.f380b.overridesItemVisibility();
        }

        @Override // b.h.k.b
        public void j(b.AbstractC0047b bVar) {
            this.f382d = bVar;
            this.f380b.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.AbstractC0047b bVar = this.f382d;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS */
    static class c extends FrameLayout implements b.a.o.c {

        /* renamed from: b  reason: collision with root package name */
        final CollapsibleActionView f383b;

        c(View view) {
            super(view.getContext());
            this.f383b = (CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.f383b;
        }

        @Override // b.a.o.c
        public void c() {
            this.f383b.onActionViewExpanded();
        }

        @Override // b.a.o.c
        public void f() {
            this.f383b.onActionViewCollapsed();
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f384a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f384a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f384a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f384a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f386a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f386a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f386a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, b.h.f.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f378d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f378d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f378d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        b.h.k.b b2 = this.f378d.b();
        if (b2 instanceof a) {
            return ((a) b2).f380b;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f378d.getActionView();
        return actionView instanceof c ? ((c) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f378d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f378d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f378d.getContentDescription();
    }

    public int getGroupId() {
        return this.f378d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f378d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f378d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f378d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f378d.getIntent();
    }

    public int getItemId() {
        return this.f378d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f378d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f378d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f378d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f378d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f378d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f378d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f378d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f378d.getTooltipText();
    }

    public void h(boolean z) {
        try {
            if (this.f379e == null) {
                this.f379e = this.f378d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f379e.invoke(this.f378d, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean hasSubMenu() {
        return this.f378d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f378d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f378d.isCheckable();
    }

    public boolean isChecked() {
        return this.f378d.isChecked();
    }

    public boolean isEnabled() {
        return this.f378d.isEnabled();
    }

    public boolean isVisible() {
        return this.f378d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b.h.k.b bVar;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new b(this, this.f312a, actionProvider);
        } else {
            bVar = new a(this.f312a, actionProvider);
        }
        b.h.f.a.b bVar2 = this.f378d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f378d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f378d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f378d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f378d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f378d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f378d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f378d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f378d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f378d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f378d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f378d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f378d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f378d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f378d.setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i2) {
        this.f378d.setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        this.f378d.setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f378d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f378d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f378d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f378d.setVisible(z);
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f378d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f378d.setIcon(i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f378d.setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f378d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f378d.setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        this.f378d.setActionView(i2);
        View actionView = this.f378d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f378d.setActionView(new c(actionView));
        }
        return this;
    }
}
