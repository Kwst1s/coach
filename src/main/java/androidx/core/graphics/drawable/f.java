package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* access modifiers changed from: package-private */
/* compiled from: WrappedDrawableState */
public final class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f1122a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f1123b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f1124c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f1125d = d.f1114h;

    f(f fVar) {
        if (fVar != null) {
            this.f1122a = fVar.f1122a;
            this.f1123b = fVar.f1123b;
            this.f1124c = fVar.f1124c;
            this.f1125d = fVar.f1125d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f1123b != null;
    }

    public int getChangingConfigurations() {
        int i2 = this.f1122a;
        Drawable.ConstantState constantState = this.f1123b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, resources);
        }
        return new d(this, resources);
    }
}
