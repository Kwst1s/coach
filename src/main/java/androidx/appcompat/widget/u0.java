package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import b.a.d;
import b.a.f;
import b.a.g;
import b.a.i;

/* access modifiers changed from: package-private */
/* compiled from: TooltipPopup */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f792a;

    /* renamed from: b  reason: collision with root package name */
    private final View f793b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f794c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f795d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f796e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f797f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f798g = new int[2];

    u0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f795d = layoutParams;
        this.f792a = context;
        View inflate = LayoutInflater.from(context).inflate(g.abc_tooltip, (ViewGroup) null);
        this.f793b = inflate;
        this.f794c = (TextView) inflate.findViewById(f.message);
        layoutParams.setTitle(u0.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int i4;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f792a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f792a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
            i5 = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            i5 = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f792a.getResources().getDimensionPixelOffset(z ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch);
        View b2 = b(view);
        if (b2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b2.getWindowVisibleDisplayFrame(this.f796e);
        Rect rect = this.f796e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f792a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f796e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b2.getLocationOnScreen(this.f798g);
        view.getLocationOnScreen(this.f797f);
        int[] iArr = this.f797f;
        int i6 = iArr[0];
        int[] iArr2 = this.f798g;
        iArr[0] = i6 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i2) - (b2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f793b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f793b.getMeasuredHeight();
        int[] iArr3 = this.f797f;
        int i7 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
        int i8 = iArr3[1] + i5 + dimensionPixelOffset3;
        if (z) {
            if (i7 >= 0) {
                layoutParams.y = i7;
            } else {
                layoutParams.y = i8;
            }
        } else if (measuredHeight + i8 <= this.f796e.height()) {
            layoutParams.y = i8;
        } else {
            layoutParams.y = i7;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f792a.getSystemService("window")).removeView(this.f793b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f793b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    public void e(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f794c.setText(charSequence);
        a(view, i2, i3, z, this.f795d);
        ((WindowManager) this.f792a.getSystemService("window")).addView(this.f793b, this.f795d);
    }
}
