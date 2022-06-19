package com.devbrackets.android.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;

public class FitsSystemWindowRelativeLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    private Rect f4458b;

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private boolean a() {
        return getResources().getConfiguration().smallestScreenWidthDp <= 600;
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 14) {
            setFitsSystemWindows(true);
        }
        if (this.f4458b == null) {
            this.f4458b = new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        c(new Rect());
    }

    private void c(Rect rect) {
        Rect rect2 = this.f4458b;
        setPadding(rect2.left + rect.left, rect2.top + rect.top, rect2.right + rect.right, rect2.bottom + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        c(rect);
        return false;
    }

    @TargetApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        fitSystemWindows(new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()));
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a()) {
            b();
        }
    }
}
