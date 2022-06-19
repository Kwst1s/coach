package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import b.a.o.b;
import b.h.k.f;

/* compiled from: AppCompatDialog */
public class g extends Dialog implements d {

    /* renamed from: b  reason: collision with root package name */
    private e f206b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f207c = new a();

    /* compiled from: AppCompatDialog */
    class a implements f.a {
        a() {
        }

        @Override // b.h.k.f.a
        public boolean i(KeyEvent keyEvent) {
            return g.this.c(keyEvent);
        }
    }

    public g(Context context, int i2) {
        super(context, b(context, i2));
        e a2 = a();
        a2.E(b(context, i2));
        a2.q(null);
    }

    private static int b(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public e a() {
        if (this.f206b == null) {
            this.f206b = e.h(this, this);
        }
        return this.f206b;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i2) {
        return a().z(i2);
    }

    public void dismiss() {
        super.dismiss();
        a().r();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return f.e(this.f207c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) a().i(i2);
    }

    public void invalidateOptionsMenu() {
        a().o();
    }

    @Override // androidx.appcompat.app.d
    public void j(b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void l(b bVar) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().n();
        super.onCreate(bundle);
        a().q(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        a().A(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().F(charSequence);
    }

    @Override // androidx.appcompat.app.d
    public b v(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().B(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().C(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().F(getContext().getString(i2));
    }
}
