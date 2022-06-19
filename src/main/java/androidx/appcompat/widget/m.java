package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.h;
import b.a.j;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatPopupWindow */
public class m extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f689b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a  reason: collision with root package name */
    private boolean f690a;

    public m(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        q0 v = q0.v(context, attributeSet, j.Q1, i2, i3);
        int i4 = j.S1;
        if (v.s(i4)) {
            b(v.a(i4, false));
        }
        setBackgroundDrawable(v.g(j.R1));
        v.w();
    }

    private void b(boolean z) {
        if (f689b) {
            this.f690a = z;
        } else {
            h.a(this, z);
        }
    }

    public void showAsDropDown(View view, int i2, int i3) {
        if (f689b && this.f690a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f689b && this.f690a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f689b && this.f690a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
