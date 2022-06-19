package b.r;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.h.k.u;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: ViewOverlayApi14 */
public class z implements b0 {

    /* renamed from: a  reason: collision with root package name */
    protected a f2950a;

    /* access modifiers changed from: package-private */
    /* compiled from: ViewOverlayApi14 */
    public static class a extends ViewGroup {

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f2951b;

        /* renamed from: c  reason: collision with root package name */
        View f2952c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f2953d = null;

        /* renamed from: e  reason: collision with root package name */
        z f2954e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2955f;

        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, z zVar) {
            super(context);
            this.f2951b = viewGroup;
            this.f2952c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2954e = zVar;
        }

        private void c() {
            if (this.f2955f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f2953d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f2955f = true;
                    this.f2951b.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f2951b.getLocationOnScreen(iArr2);
            this.f2952c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f2953d == null) {
                this.f2953d = new ArrayList<>();
            }
            if (!this.f2953d.contains(drawable)) {
                this.f2953d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f2951b || viewGroup.getParent() == null || !u.R(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f2951b.getLocationOnScreen(iArr2);
                    u.X(view, iArr[0] - iArr2[0]);
                    u.Y(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f2951b.getLocationOnScreen(iArr);
            this.f2952c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f2952c.getWidth(), this.f2952c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2953d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2953d.get(i2).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void f(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2953d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void g(View view) {
            super.removeView(view);
            d();
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f2951b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f2951b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                e(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        /* access modifiers changed from: protected */
        public boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f2953d) != null && arrayList.contains(drawable));
        }
    }

    z(Context context, ViewGroup viewGroup, View view) {
        this.f2950a = new a(context, viewGroup, view, this);
    }

    static z e(View view) {
        ViewGroup f2 = f(view);
        if (f2 == null) {
            return null;
        }
        int childCount = f2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = f2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f2954e;
            }
        }
        return new u(f2.getContext(), f2, view);
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // b.r.b0
    public void b(Drawable drawable) {
        this.f2950a.a(drawable);
    }

    @Override // b.r.b0
    public void d(Drawable drawable) {
        this.f2950a.f(drawable);
    }
}
