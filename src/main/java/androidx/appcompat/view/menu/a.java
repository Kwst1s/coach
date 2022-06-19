package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.h.f.a.b;

/* compiled from: ActionMenuItem */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f293a;

    /* renamed from: b  reason: collision with root package name */
    private final int f294b;

    /* renamed from: c  reason: collision with root package name */
    private final int f295c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f296d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f297e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f298f;

    /* renamed from: g  reason: collision with root package name */
    private char f299g;

    /* renamed from: h  reason: collision with root package name */
    private int f300h = 4096;

    /* renamed from: i  reason: collision with root package name */
    private char f301i;

    /* renamed from: j  reason: collision with root package name */
    private int f302j = 4096;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f303k;
    private Context l;
    private CharSequence m;
    private CharSequence n;
    private ColorStateList o = null;
    private PorterDuff.Mode p = null;
    private boolean q = false;
    private boolean r = false;
    private int s = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.l = context;
        this.f293a = i3;
        this.f294b = i2;
        this.f295c = i5;
        this.f296d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f303k;
        if (drawable == null) {
            return;
        }
        if (this.q || this.r) {
            Drawable r2 = androidx.core.graphics.drawable.a.r(drawable);
            this.f303k = r2;
            Drawable mutate = r2.mutate();
            this.f303k = mutate;
            if (this.q) {
                androidx.core.graphics.drawable.a.o(mutate, this.o);
            }
            if (this.r) {
                androidx.core.graphics.drawable.a.p(this.f303k, this.p);
            }
        }
    }

    @Override // b.h.f.a.b
    public b a(b.h.k.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // b.h.f.a.b
    public b.h.k.b b() {
        return null;
    }

    @Override // b.h.f.a.b
    public boolean collapseActionView() {
        return false;
    }

    public b d(int i2) {
        throw new UnsupportedOperationException();
    }

    public b e(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // b.h.f.a.b
    public boolean expandActionView() {
        return false;
    }

    public b f(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // b.h.f.a.b
    public View getActionView() {
        return null;
    }

    @Override // b.h.f.a.b
    public int getAlphabeticModifiers() {
        return this.f302j;
    }

    public char getAlphabeticShortcut() {
        return this.f301i;
    }

    @Override // b.h.f.a.b
    public CharSequence getContentDescription() {
        return this.m;
    }

    public int getGroupId() {
        return this.f294b;
    }

    public Drawable getIcon() {
        return this.f303k;
    }

    @Override // b.h.f.a.b
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // b.h.f.a.b
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    public Intent getIntent() {
        return this.f298f;
    }

    public int getItemId() {
        return this.f293a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // b.h.f.a.b
    public int getNumericModifiers() {
        return this.f300h;
    }

    public char getNumericShortcut() {
        return this.f299g;
    }

    public int getOrder() {
        return this.f295c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f296d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f297e;
        return charSequence != null ? charSequence : this.f296d;
    }

    @Override // b.h.f.a.b
    public CharSequence getTooltipText() {
        return this.n;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override // b.h.f.a.b
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // b.h.f.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i2) {
        d(i2);
        throw null;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f301i = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.s = (z ? 1 : 0) | (this.s & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f303k = drawable;
        c();
        return this;
    }

    @Override // b.h.f.a.b
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        c();
        return this;
    }

    @Override // b.h.f.a.b
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f298f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f299g = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f299g = c2;
        this.f301i = Character.toLowerCase(c3);
        return this;
    }

    @Override // b.h.f.a.b
    public void setShowAsAction(int i2) {
    }

    @Override // b.h.f.a.b
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        f(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f296d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f297e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.s & 8;
        if (z) {
            i2 = 0;
        }
        this.s = i3 | i2;
        return this;
    }

    @Override // b.h.f.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        e(view);
        throw null;
    }

    @Override // b.h.f.a.b
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f301i = Character.toLowerCase(c2);
        this.f302j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // b.h.f.a.b
    public b setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // b.h.f.a.b
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f299g = c2;
        this.f300h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f296d = this.l.getResources().getString(i2);
        return this;
    }

    @Override // b.h.f.a.b
    public b setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f303k = b.h.d.a.d(this.l, i2);
        c();
        return this;
    }

    @Override // b.h.f.a.b
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f299g = c2;
        this.f300h = KeyEvent.normalizeMetaState(i2);
        this.f301i = Character.toLowerCase(c3);
        this.f302j = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}
