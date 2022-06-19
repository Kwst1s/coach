package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.z;

public class FitWindowsLinearLayout extends LinearLayout implements z {

    /* renamed from: b  reason: collision with root package name */
    private z.a f478b;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        z.a aVar = this.f478b;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.z
    public void setOnFitSystemWindowsListener(z.a aVar) {
        this.f478b = aVar;
    }
}
