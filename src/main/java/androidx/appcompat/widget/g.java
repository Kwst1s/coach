package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatCompoundButtonHelper */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f615a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f616b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f617c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f618d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f619e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f620f;

    g(CompoundButton compoundButton) {
        this.f615a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a2 = c.a(this.f615a);
        if (a2 == null) {
            return;
        }
        if (this.f618d || this.f619e) {
            Drawable mutate = a.r(a2).mutate();
            if (this.f618d) {
                a.o(mutate, this.f616b);
            }
            if (this.f619e) {
                a.p(mutate, this.f617c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f615a.getDrawableState());
            }
            this.f615a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = c.a(this.f615a)) == null) ? i2 : i2 + a2.getIntrinsicWidth();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f616b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f617c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.util.AttributeSet r10, int r11) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g.e(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f620f) {
            this.f620f = false;
            return;
        }
        this.f620f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f616b = colorStateList;
        this.f618d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f617c = mode;
        this.f619e = true;
        a();
    }
}
