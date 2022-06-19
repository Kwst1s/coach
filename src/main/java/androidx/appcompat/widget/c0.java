package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.p;
import androidx.core.widget.h;
import b.a.j;
import b.h.k.u;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class c0 implements p {
    private static Method G;
    private static Method H;
    private static Method I;
    private final b A;
    final Handler B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;

    /* renamed from: b  reason: collision with root package name */
    private Context f581b;

    /* renamed from: c  reason: collision with root package name */
    private ListAdapter f582c;

    /* renamed from: d  reason: collision with root package name */
    y f583d;

    /* renamed from: e  reason: collision with root package name */
    private int f584e;

    /* renamed from: f  reason: collision with root package name */
    private int f585f;

    /* renamed from: g  reason: collision with root package name */
    private int f586g;

    /* renamed from: h  reason: collision with root package name */
    private int f587h;

    /* renamed from: i  reason: collision with root package name */
    private int f588i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f589j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f590k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    int p;
    private View q;
    private int r;
    private DataSetObserver s;
    private View t;
    private Drawable u;
    private AdapterView.OnItemClickListener v;
    private AdapterView.OnItemSelectedListener w;
    final f x;
    private final e y;
    private final d z;

    /* access modifiers changed from: package-private */
    /* compiled from: ListPopupWindow */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            y yVar;
            if (i2 != -1 && (yVar = c0.this.f583d) != null) {
                yVar.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ListPopupWindow */
    public class b implements Runnable {
        b() {
        }

        public void run() {
            c0.this.r();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ListPopupWindow */
    public class c extends DataSetObserver {
        c() {
        }

        public void onChanged() {
            if (c0.this.c()) {
                c0.this.a();
            }
        }

        public void onInvalidated() {
            c0.this.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ListPopupWindow */
    public class d implements AbsListView.OnScrollListener {
        d() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !c0.this.A() && c0.this.F.getContentView() != null) {
                c0 c0Var = c0.this;
                c0Var.B.removeCallbacks(c0Var.x);
                c0.this.x.run();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ListPopupWindow */
    public class e implements View.OnTouchListener {
        e() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = c0.this.F) != null && popupWindow.isShowing() && x >= 0 && x < c0.this.F.getWidth() && y >= 0 && y < c0.this.F.getHeight()) {
                c0 c0Var = c0.this;
                c0Var.B.postDelayed(c0Var.x, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                c0 c0Var2 = c0.this;
                c0Var2.B.removeCallbacks(c0Var2.x);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ListPopupWindow */
    public class f implements Runnable {
        f() {
        }

        public void run() {
            y yVar = c0.this.f583d;
            if (yVar != null && u.R(yVar) && c0.this.f583d.getCount() > c0.this.f583d.getChildCount()) {
                int childCount = c0.this.f583d.getChildCount();
                c0 c0Var = c0.this;
                if (childCount <= c0Var.p) {
                    c0Var.F.setInputMethodMode(2);
                    c0.this.a();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public c0(Context context) {
        this(context, null, b.a.a.listPopupWindowStyle);
    }

    private void C() {
        View view = this.q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.q);
            }
        }
    }

    private void N(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = G;
            if (method != null) {
                try {
                    method.invoke(this.F, Boolean.valueOf(z2));
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.F.setIsClippedToScreen(z2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    private int q() {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2 = true;
        if (this.f583d == null) {
            Context context = this.f581b;
            y s2 = s(context, !this.E);
            this.f583d = s2;
            Drawable drawable = this.u;
            if (drawable != null) {
                s2.setSelector(drawable);
            }
            this.f583d.setAdapter(this.f582c);
            this.f583d.setOnItemClickListener(this.v);
            this.f583d.setFocusable(true);
            this.f583d.setFocusableInTouchMode(true);
            this.f583d.setOnItemSelectedListener(new a());
            this.f583d.setOnScrollListener(this.z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.w;
            if (onItemSelectedListener != null) {
                this.f583d.setOnItemSelectedListener(onItemSelectedListener);
            }
            y yVar = this.f583d;
            View view = this.q;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i6 = this.r;
                if (i6 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(yVar, layoutParams);
                } else if (i6 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.r);
                } else {
                    linearLayout.addView(yVar, layoutParams);
                    linearLayout.addView(view);
                }
                int i7 = this.f585f;
                if (i7 >= 0) {
                    i5 = Integer.MIN_VALUE;
                } else {
                    i7 = 0;
                    i5 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i7, i5), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i2 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                yVar = linearLayout;
            } else {
                i2 = 0;
            }
            this.F.setContentView(yVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.F.getContentView();
            View view2 = this.q;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i8 = rect.top;
            i3 = rect.bottom + i8;
            if (!this.f589j) {
                this.f587h = -i8;
            }
        } else {
            this.C.setEmpty();
            i3 = 0;
        }
        if (this.F.getInputMethodMode() != 2) {
            z2 = false;
        }
        int u2 = u(t(), this.f587h, z2);
        if (this.n || this.f584e == -1) {
            return u2 + i3;
        }
        int i9 = this.f585f;
        if (i9 == -2) {
            int i10 = this.f581b.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            i4 = View.MeasureSpec.makeMeasureSpec(i10 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i9 != -1) {
            i4 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        } else {
            int i11 = this.f581b.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            i4 = View.MeasureSpec.makeMeasureSpec(i11 - (rect3.left + rect3.right), 1073741824);
        }
        int d2 = this.f583d.d(i4, 0, -1, u2 - i2, -1);
        if (d2 > 0) {
            i2 += i3 + this.f583d.getPaddingTop() + this.f583d.getPaddingBottom();
        }
        return d2 + i2;
    }

    private int u(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.F.getMaxAvailableHeight(view, i2, z2);
        }
        Method method = H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.F, view, Integer.valueOf(i2), Boolean.valueOf(z2))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.F.getMaxAvailableHeight(view, i2);
    }

    public boolean A() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.E;
    }

    public void D(View view) {
        this.t = view;
    }

    public void E(int i2) {
        this.F.setAnimationStyle(i2);
    }

    public void F(int i2) {
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            this.f585f = rect.left + rect.right + i2;
            return;
        }
        Q(i2);
    }

    public void G(int i2) {
        this.m = i2;
    }

    public void H(Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    public void I(int i2) {
        this.F.setInputMethodMode(i2);
    }

    public void J(boolean z2) {
        this.E = z2;
        this.F.setFocusable(z2);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void M(boolean z2) {
        this.l = true;
        this.f590k = z2;
    }

    public void O(int i2) {
        this.r = i2;
    }

    public void P(int i2) {
        y yVar = this.f583d;
        if (c() && yVar != null) {
            yVar.setListSelectionHidden(false);
            yVar.setSelection(i2);
            if (yVar.getChoiceMode() != 0) {
                yVar.setItemChecked(i2, true);
            }
        }
    }

    public void Q(int i2) {
        this.f585f = i2;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        int q2 = q();
        boolean A2 = A();
        h.b(this.F, this.f588i);
        boolean z2 = true;
        if (!this.F.isShowing()) {
            int i2 = this.f585f;
            if (i2 == -1) {
                i2 = -1;
            } else if (i2 == -2) {
                i2 = t().getWidth();
            }
            int i3 = this.f584e;
            if (i3 == -1) {
                q2 = -1;
            } else if (i3 != -2) {
                q2 = i3;
            }
            this.F.setWidth(i2);
            this.F.setHeight(q2);
            N(true);
            this.F.setOutsideTouchable(!this.o && !this.n);
            this.F.setTouchInterceptor(this.y);
            if (this.l) {
                h.a(this.F, this.f590k);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = I;
                if (method != null) {
                    try {
                        method.invoke(this.F, this.D);
                    } catch (Exception e2) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                this.F.setEpicenterBounds(this.D);
            }
            h.c(this.F, t(), this.f586g, this.f587h, this.m);
            this.f583d.setSelection(-1);
            if (!this.E || this.f583d.isInTouchMode()) {
                r();
            }
            if (!this.E) {
                this.B.post(this.A);
            }
        } else if (u.R(t())) {
            int i4 = this.f585f;
            if (i4 == -1) {
                i4 = -1;
            } else if (i4 == -2) {
                i4 = t().getWidth();
            }
            int i5 = this.f584e;
            if (i5 == -1) {
                if (!A2) {
                    q2 = -1;
                }
                if (A2) {
                    this.F.setWidth(this.f585f == -1 ? -1 : 0);
                    this.F.setHeight(0);
                } else {
                    this.F.setWidth(this.f585f == -1 ? -1 : 0);
                    this.F.setHeight(-1);
                }
            } else if (i5 != -2) {
                q2 = i5;
            }
            PopupWindow popupWindow = this.F;
            if (this.o || this.n) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.F.update(t(), this.f586g, this.f587h, i4 < 0 ? -1 : i4, q2 < 0 ? -1 : q2);
        }
    }

    public void b(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.F.isShowing();
    }

    public int d() {
        return this.f586g;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.F.dismiss();
        C();
        this.F.setContentView(null);
        this.f583d = null;
        this.B.removeCallbacks(this.x);
    }

    public Drawable g() {
        return this.F.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        return this.f583d;
    }

    public void j(int i2) {
        this.f587h = i2;
        this.f589j = true;
    }

    public void l(int i2) {
        this.f586g = i2;
    }

    public int n() {
        if (!this.f589j) {
            return 0;
        }
        return this.f587h;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.s;
        if (dataSetObserver == null) {
            this.s = new c();
        } else {
            ListAdapter listAdapter2 = this.f582c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f582c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        y yVar = this.f583d;
        if (yVar != null) {
            yVar.setAdapter(this.f582c);
        }
    }

    public void r() {
        y yVar = this.f583d;
        if (yVar != null) {
            yVar.setListSelectionHidden(true);
            yVar.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public y s(Context context, boolean z2) {
        return new y(context, z2);
    }

    public View t() {
        return this.t;
    }

    public Object v() {
        if (!c()) {
            return null;
        }
        return this.f583d.getSelectedItem();
    }

    public long w() {
        if (!c()) {
            return Long.MIN_VALUE;
        }
        return this.f583d.getSelectedItemId();
    }

    public int x() {
        if (!c()) {
            return -1;
        }
        return this.f583d.getSelectedItemPosition();
    }

    public View y() {
        if (!c()) {
            return null;
        }
        return this.f583d.getSelectedView();
    }

    public int z() {
        return this.f585f;
    }

    public c0(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public c0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f584e = -2;
        this.f585f = -2;
        this.f588i = 1002;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = Integer.MAX_VALUE;
        this.r = 0;
        this.x = new f();
        this.y = new e();
        this.z = new d();
        this.A = new b();
        this.C = new Rect();
        this.f581b = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.d1, i2, i3);
        this.f586g = obtainStyledAttributes.getDimensionPixelOffset(j.e1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.f1, 0);
        this.f587h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f589j = true;
        }
        obtainStyledAttributes.recycle();
        m mVar = new m(context, attributeSet, i2, i3);
        this.F = mVar;
        mVar.setInputMethodMode(1);
    }
}
