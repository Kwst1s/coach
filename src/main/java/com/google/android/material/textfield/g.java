package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.d;
import c.e.a.b.b;
import c.e.a.b.k;
import c.e.a.b.l;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.material.internal.e;
import com.google.android.material.internal.j;

/* compiled from: MaterialAutoCompleteTextView */
public class g extends d {

    /* renamed from: e  reason: collision with root package name */
    private final c0 f8060e;

    /* renamed from: f  reason: collision with root package name */
    private final AccessibilityManager f8061f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f8062g;

    /* compiled from: MaterialAutoCompleteTextView */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            g.this.e(i2 < 0 ? g.this.f8060e.v() : g.this.getAdapter().getItem(i2));
            AdapterView.OnItemClickListener onItemClickListener = g.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i2 < 0) {
                    view = g.this.f8060e.y();
                    i2 = g.this.f8060e.x();
                    j2 = g.this.f8060e.w();
                }
                onItemClickListener.onItemClick(g.this.f8060e.h(), view, i2, j2);
            }
            g.this.f8060e.dismiss();
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f3253a);
    }

    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout c2 = c();
        int i2 = 0;
        if (adapter == null || c2 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f8060e.x()) + 15);
        View view = null;
        int i3 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(max, view, c2);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        Drawable g2 = this.f8060e.g();
        if (g2 != null) {
            g2.getPadding(this.f8062g);
            Rect rect = this.f8062g;
            i3 += rect.left + rect.right;
        }
        return i3 + c2.getEndIconView().getMeasuredWidth();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.material.textfield.g */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private <T extends ListAdapter & Filterable> void e(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    public CharSequence getHint() {
        TextInputLayout c2 = c();
        if (c2 == null || !c2.O()) {
            return super.getHint();
        }
        return c2.getHint();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout c2 = c();
        if (c2 != null && c2.O() && super.getHint() == null && e.a()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f8060e.p(getAdapter());
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f8061f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f8060e.a();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, 0), attributeSet, i2);
        this.f8062g = new Rect();
        Context context2 = getContext();
        TypedArray h2 = j.h(context2, attributeSet, l.d1, i2, k.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i3 = l.e1;
        if (h2.hasValue(i3) && h2.getInt(i3, 0) == 0) {
            setKeyListener(null);
        }
        this.f8061f = (AccessibilityManager) context2.getSystemService("accessibility");
        c0 c0Var = new c0(context2);
        this.f8060e = c0Var;
        c0Var.J(true);
        c0Var.D(this);
        c0Var.I(2);
        c0Var.p(getAdapter());
        c0Var.L(new a());
        h2.recycle();
    }
}
