package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.widget.f;
import b.a.l.a.c;
import java.lang.reflect.Field;

/* access modifiers changed from: package-private */
/* compiled from: DropDownListView */
public class y extends ListView {

    /* renamed from: b  reason: collision with root package name */
    private final Rect f806b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f807c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f808d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f809e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f810f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f811g;

    /* renamed from: h  reason: collision with root package name */
    private Field f812h;

    /* renamed from: i  reason: collision with root package name */
    private a f813i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f814j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f815k;
    private boolean l;
    private b.h.k.y m;
    private f n;
    b o;

    /* access modifiers changed from: private */
    /* compiled from: DropDownListView */
    public static class a extends c {

        /* renamed from: c  reason: collision with root package name */
        private boolean f816c = true;

        a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z) {
            this.f816c = z;
        }

        @Override // b.a.l.a.c
        public void draw(Canvas canvas) {
            if (this.f816c) {
                super.draw(canvas);
            }
        }

        @Override // b.a.l.a.c
        public void setHotspot(float f2, float f3) {
            if (this.f816c) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // b.a.l.a.c
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f816c) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // b.a.l.a.c
        public boolean setState(int[] iArr) {
            if (this.f816c) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // b.a.l.a.c
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f816c) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DropDownListView */
    public class b implements Runnable {
        b() {
        }

        public void a() {
            y yVar = y.this;
            yVar.o = null;
            yVar.removeCallbacks(this);
        }

        public void b() {
            y.this.post(this);
        }

        public void run() {
            y yVar = y.this;
            yVar.o = null;
            yVar.drawableStateChanged();
        }
    }

    y(Context context, boolean z) {
        super(context, null, b.a.a.dropDownListViewStyle);
        this.f815k = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f812h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        this.l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f811g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        b.h.k.y yVar = this.m;
        if (yVar != null) {
            yVar.b();
            this.m = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f806b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f806b);
            selector.draw(canvas);
        }
    }

    private void f(int i2, View view) {
        Rect rect = this.f806b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f807c;
        rect.top -= this.f808d;
        rect.right += this.f809e;
        rect.bottom += this.f810f;
        try {
            boolean z = this.f812h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f812h.set(this, Boolean.valueOf(!z));
                if (i2 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private void g(int i2, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i2 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z2) {
            Rect rect = this.f806b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            androidx.core.graphics.drawable.a.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i2, View view, float f2, float f3) {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector != null && i2 != -1) {
            androidx.core.graphics.drawable.a.k(selector, f2, f3);
        }
    }

    private void i(View view, int i2, float f2, float f3) {
        View childAt;
        this.l = true;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            drawableHotspotChanged(f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.f811g;
        if (!(i4 == -1 || (childAt = getChildAt(i4 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f811g = i2;
        float left = f2 - ((float) view.getLeft());
        float top = f3 - ((float) view.getTop());
        if (i3 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.l;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.f813i;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i8 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            if (i12 > 0) {
                i7 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else {
                i7 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i2, i7);
            view.forceLayout();
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i5) {
                return (i6 < 0 || i9 <= i6 || i11 <= 0 || i8 == i5) ? i5 : i11;
            }
            if (i6 >= 0 && i9 >= i6) {
                i11 = i8;
            }
            i9++;
        }
        return i8;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.o == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.e(android.view.MotionEvent, int):boolean");
    }

    public boolean hasFocus() {
        return this.f815k || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f815k || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f815k || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f815k && this.f814j) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.o = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.o == null) {
            b bVar = new b();
            this.o = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f811g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.o;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.f814j = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f813i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f807c = rect.left;
        this.f808d = rect.top;
        this.f809e = rect.right;
        this.f810f = rect.bottom;
    }
}
