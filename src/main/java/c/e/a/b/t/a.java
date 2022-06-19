package c.e.a.b.t;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: InsetDialogOnTouchListener */
public class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    private final Dialog f3434b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3435c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3436d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3437e;

    public a(Dialog dialog, Rect rect) {
        this.f3434b = dialog;
        this.f3435c = rect.left;
        this.f3436d = rect.top;
        this.f3437e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f3435c + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f3436d + findViewById.getTop();
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f3437e;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.f3434b.onTouchEvent(obtain);
    }
}
