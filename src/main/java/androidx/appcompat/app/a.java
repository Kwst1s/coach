package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import b.a.j;
import b.a.o.b;

/* compiled from: ActionBar */
public abstract class a {

    /* compiled from: ActionBar */
    public interface b {
        void a(boolean z);
    }

    @Deprecated
    /* compiled from: ActionBar */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract void A(CharSequence charSequence);

    public abstract void B(CharSequence charSequence);

    public b.a.o.b C(b.a aVar) {
        return null;
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void n() {
    }

    public abstract boolean o(int i2, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(boolean z);

    public abstract void u(int i2);

    public abstract void v(int i2);

    public abstract void w(Drawable drawable);

    public abstract void x(boolean z);

    public abstract void y(boolean z);

    public abstract void z(int i2);

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    /* compiled from: ActionBar */
    public static class C0008a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f159a;

        public C0008a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f159a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.t);
            this.f159a = obtainStyledAttributes.getInt(j.u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0008a(int i2, int i3) {
            super(i2, i3);
            this.f159a = 0;
            this.f159a = 8388627;
        }

        public C0008a(C0008a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f159a = 0;
            this.f159a = aVar.f159a;
        }

        public C0008a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f159a = 0;
        }
    }
}
