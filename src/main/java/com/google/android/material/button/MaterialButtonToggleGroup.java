package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import b.h.k.d0.c;
import b.h.k.h;
import b.h.k.u;
import c.e.a.b.c0.k;
import c.e.a.b.k;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    private static final String l = MaterialButtonToggleGroup.class.getSimpleName();
    private static final int m = k.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f7613b;

    /* renamed from: c  reason: collision with root package name */
    private final c f7614c;

    /* renamed from: d  reason: collision with root package name */
    private final f f7615d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<e> f7616e;

    /* renamed from: f  reason: collision with root package name */
    private final Comparator<MaterialButton> f7617f;

    /* renamed from: g  reason: collision with root package name */
    private Integer[] f7618g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7619h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7620i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7621j;

    /* renamed from: k  reason: collision with root package name */
    private int f7622k;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends b.h.k.a {
        b() {
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            cVar.d0(c.C0048c.a(0, 1, MaterialButtonToggleGroup.this.n(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* access modifiers changed from: private */
    public class c implements MaterialButton.a {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            if (!MaterialButtonToggleGroup.this.f7619h) {
                if (MaterialButtonToggleGroup.this.f7620i) {
                    MaterialButtonToggleGroup.this.f7622k = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.u(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup.this.l(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static class d {

        /* renamed from: e  reason: collision with root package name */
        private static final c.e.a.b.c0.c f7626e = new c.e.a.b.c0.a(Utils.FLOAT_EPSILON);

        /* renamed from: a  reason: collision with root package name */
        c.e.a.b.c0.c f7627a;

        /* renamed from: b  reason: collision with root package name */
        c.e.a.b.c0.c f7628b;

        /* renamed from: c  reason: collision with root package name */
        c.e.a.b.c0.c f7629c;

        /* renamed from: d  reason: collision with root package name */
        c.e.a.b.c0.c f7630d;

        d(c.e.a.b.c0.c cVar, c.e.a.b.c0.c cVar2, c.e.a.b.c0.c cVar3, c.e.a.b.c0.c cVar4) {
            this.f7627a = cVar;
            this.f7628b = cVar3;
            this.f7629c = cVar4;
            this.f7630d = cVar2;
        }

        public static d a(d dVar) {
            c.e.a.b.c0.c cVar = f7626e;
            return new d(cVar, dVar.f7630d, cVar, dVar.f7629c);
        }

        public static d b(d dVar, View view) {
            return com.google.android.material.internal.k.d(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            c.e.a.b.c0.c cVar = dVar.f7627a;
            c.e.a.b.c0.c cVar2 = dVar.f7630d;
            c.e.a.b.c0.c cVar3 = f7626e;
            return new d(cVar, cVar2, cVar3, cVar3);
        }

        public static d d(d dVar) {
            c.e.a.b.c0.c cVar = f7626e;
            return new d(cVar, cVar, dVar.f7628b, dVar.f7629c);
        }

        public static d e(d dVar, View view) {
            return com.google.android.material.internal.k.d(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            c.e.a.b.c0.c cVar = dVar.f7627a;
            c.e.a.b.c0.c cVar2 = f7626e;
            return new d(cVar, cVar2, dVar.f7628b, cVar2);
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z);
    }

    /* access modifiers changed from: private */
    public class f implements MaterialButton.b {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.e.a.b.b.materialButtonToggleGroupStyle);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (p(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (p(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && p(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton m2 = m(i2);
                int min = Math.min(m2.getStrokeWidth(), m(i2 - 1).getStrokeWidth());
                LinearLayout.LayoutParams i3 = i(m2);
                if (getOrientation() == 0) {
                    h.c(i3, 0);
                    h.d(i3, -min);
                    i3.topMargin = 0;
                } else {
                    i3.bottomMargin = 0;
                    i3.topMargin = -min;
                    h.d(i3, 0);
                }
                m2.setLayoutParams(i3);
            }
            r(firstVisibleChildIndex);
        }
    }

    private LinearLayout.LayoutParams i(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void j(int i2) {
        s(i2, true);
        u(i2, true);
        setCheckedId(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(int i2, boolean z) {
        Iterator<e> it = this.f7616e.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    private MaterialButton m(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int n(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return i2;
            }
            if ((getChildAt(i3) instanceof MaterialButton) && p(i3)) {
                i2++;
            }
        }
        return -1;
    }

    private d o(int i2, int i3, int i4) {
        d dVar = this.f7613b.get(i2);
        if (i3 == i4) {
            return dVar;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? d.e(dVar, this) : d.f(dVar);
        }
        if (i2 == i4) {
            return z ? d.b(dVar, this) : d.a(dVar);
        }
        return null;
    }

    private boolean p(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private void r(int i2) {
        if (getChildCount() != 0 && i2 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) m(i2).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            h.c(layoutParams, 0);
            h.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void s(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f7619h = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f7619h = false;
        }
    }

    private void setCheckedId(int i2) {
        this.f7622k = i2;
        l(i2, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(u.k());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.f7614c);
        materialButton.setOnPressedChangeListenerInternal(this.f7615d);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static void t(k.b bVar, d dVar) {
        if (dVar == null) {
            bVar.o(Utils.FLOAT_EPSILON);
            return;
        }
        bVar.B(dVar.f7627a);
        bVar.t(dVar.f7630d);
        bVar.F(dVar.f7628b);
        bVar.x(dVar.f7629c);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean u(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.f7621j || !checkedButtonIds.isEmpty()) {
            if (z && this.f7620i) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    s(intValue, false);
                    l(intValue, false);
                }
            }
            return true;
        }
        s(i2, true);
        this.f7622k = i2;
        return false;
    }

    private void v() {
        TreeMap treeMap = new TreeMap(this.f7617f);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(m(i2), Integer.valueOf(i2));
        }
        this.f7618g = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(l, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            u(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        c.e.a.b.c0.k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f7613b.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        u.m0(materialButton, new b());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        v();
        super.dispatchDraw(canvas);
    }

    public void g(e eVar) {
        this.f7616e.add(eVar);
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f7620i) {
            return this.f7622k;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton m2 = m(i2);
            if (m2.isChecked()) {
                arrayList.add(Integer.valueOf(m2.getId()));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f7618g;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(l, "Child order wasn't updated");
        return i3;
    }

    public void k() {
        this.f7619h = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton m2 = m(i2);
            m2.setChecked(false);
            l(m2.getId(), false);
        }
        this.f7619h = false;
        setCheckedId(-1);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f7622k;
        if (i2 != -1) {
            j(i2);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        b.h.k.d0.c.E0(accessibilityNodeInfo).c0(c.b.a(1, getVisibleButtonCount(), false, q() ? 1 : 2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        w();
        h();
        super.onMeasure(i2, i3);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.h(this.f7614c);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f7613b.remove(indexOfChild);
        }
        w();
        h();
    }

    public boolean q() {
        return this.f7620i;
    }

    public void setSelectionRequired(boolean z) {
        this.f7621j = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f7620i != z) {
            this.f7620i = z;
            k();
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton m2 = m(i2);
            if (m2.getVisibility() != 8) {
                k.b v = m2.getShapeAppearanceModel().v();
                t(v, o(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                m2.setShapeAppearanceModel(v.m());
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.m
            android.content.Context r7 = com.google.android.material.theme.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f7613b = r7
            com.google.android.material.button.MaterialButtonToggleGroup$c r7 = new com.google.android.material.button.MaterialButtonToggleGroup$c
            r0 = 0
            r7.<init>(r6, r0)
            r6.f7614c = r7
            com.google.android.material.button.MaterialButtonToggleGroup$f r7 = new com.google.android.material.button.MaterialButtonToggleGroup$f
            r7.<init>(r6, r0)
            r6.f7615d = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f7616e = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f7617f = r7
            r7 = 0
            r6.f7619h = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = c.e.a.b.l.z1
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.j.h(r0, r1, r2, r3, r4, r5)
            int r9 = c.e.a.b.l.C1
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = c.e.a.b.l.A1
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f7622k = r9
            int r9 = c.e.a.b.l.B1
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f7621j = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            b.h.k.u.x0(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
