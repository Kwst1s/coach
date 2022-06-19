package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import b.f.b.k.e;
import b.f.b.k.f;
import b.f.b.k.g;
import b.f.b.k.j;
import b.f.b.k.k;
import b.f.b.k.m.b;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    SparseArray<View> f857b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<b> f858c = new ArrayList<>(4);

    /* renamed from: d  reason: collision with root package name */
    protected f f859d = new f();

    /* renamed from: e  reason: collision with root package name */
    private int f860e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f861f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f862g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private int f863h = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f864i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f865j = 257;

    /* renamed from: k  reason: collision with root package name */
    private d f866k = null;
    protected c l = null;
    private int m = -1;
    private HashMap<String, Integer> n = new HashMap<>();
    private int o = -1;
    private int p = -1;
    private SparseArray<e> q = new SparseArray<>();
    c r = new c(this);
    private int s = 0;
    private int t = 0;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f867a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                b.f.b.k.e$b[] r0 = b.f.b.k.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.constraintlayout.widget.ConstraintLayout.a.f867a = r0
                b.f.b.k.e$b r1 = b.f.b.k.e.b.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.constraintlayout.widget.ConstraintLayout.a.f867a     // Catch:{ NoSuchFieldError -> 0x001d }
                b.f.b.k.e$b r1 = b.f.b.k.e.b.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.constraintlayout.widget.ConstraintLayout.a.f867a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b.f.b.k.e$b r1 = b.f.b.k.e.b.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = androidx.constraintlayout.widget.ConstraintLayout.a.f867a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b.f.b.k.e$b r1 = b.f.b.k.e.b.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements b.AbstractC0036b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f880a;

        /* renamed from: b  reason: collision with root package name */
        int f881b;

        /* renamed from: c  reason: collision with root package name */
        int f882c;

        /* renamed from: d  reason: collision with root package name */
        int f883d;

        /* renamed from: e  reason: collision with root package name */
        int f884e;

        /* renamed from: f  reason: collision with root package name */
        int f885f;

        /* renamed from: g  reason: collision with root package name */
        int f886g;

        public c(ConstraintLayout constraintLayout) {
            this.f880a = constraintLayout;
        }

        private boolean d(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i4 == size) {
                return true;
            }
            return false;
        }

        @Override // b.f.b.k.m.b.AbstractC0036b
        @SuppressLint({"WrongCall"})
        public final void a(e eVar, b.a aVar) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            if (eVar != null) {
                if (eVar.Q() == 8 && !eVar.a0()) {
                    aVar.f2353e = 0;
                    aVar.f2354f = 0;
                    aVar.f2355g = 0;
                } else if (eVar.I() != null) {
                    e.b bVar = aVar.f2349a;
                    e.b bVar2 = aVar.f2350b;
                    int i9 = aVar.f2351c;
                    int i10 = aVar.f2352d;
                    int i11 = this.f881b + this.f882c;
                    int i12 = this.f883d;
                    View view = (View) eVar.q();
                    int[] iArr = a.f867a;
                    int i13 = iArr[bVar.ordinal()];
                    if (i13 == 1) {
                        i2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                    } else if (i13 == 2) {
                        i2 = ViewGroup.getChildMeasureSpec(this.f885f, i12, -2);
                    } else if (i13 == 3) {
                        i2 = ViewGroup.getChildMeasureSpec(this.f885f, i12 + eVar.z(), -1);
                    } else if (i13 != 4) {
                        i2 = 0;
                    } else {
                        i2 = ViewGroup.getChildMeasureSpec(this.f885f, i12, -2);
                        boolean z = eVar.n == 1;
                        int i14 = aVar.f2358j;
                        if (i14 == b.a.l || i14 == b.a.m) {
                            if (aVar.f2358j == b.a.m || !z || (z && (view.getMeasuredHeight() == eVar.v())) || (view instanceof g) || eVar.e0()) {
                                i2 = View.MeasureSpec.makeMeasureSpec(eVar.R(), 1073741824);
                            }
                        }
                    }
                    int i15 = iArr[bVar2.ordinal()];
                    if (i15 == 1) {
                        i3 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                    } else if (i15 == 2) {
                        i3 = ViewGroup.getChildMeasureSpec(this.f886g, i11, -2);
                    } else if (i15 == 3) {
                        i3 = ViewGroup.getChildMeasureSpec(this.f886g, i11 + eVar.P(), -1);
                    } else if (i15 != 4) {
                        i3 = 0;
                    } else {
                        i3 = ViewGroup.getChildMeasureSpec(this.f886g, i11, -2);
                        boolean z2 = eVar.o == 1;
                        int i16 = aVar.f2358j;
                        if (i16 == b.a.l || i16 == b.a.m) {
                            if (aVar.f2358j == b.a.m || !z2 || (z2 && (view.getMeasuredWidth() == eVar.R())) || (view instanceof g) || eVar.f0()) {
                                i3 = View.MeasureSpec.makeMeasureSpec(eVar.v(), 1073741824);
                            }
                        }
                    }
                    f fVar = (f) eVar.I();
                    if (fVar != null && j.b(ConstraintLayout.this.f865j, 256) && view.getMeasuredWidth() == eVar.R() && view.getMeasuredWidth() < fVar.R() && view.getMeasuredHeight() == eVar.v() && view.getMeasuredHeight() < fVar.v() && view.getBaseline() == eVar.n() && !eVar.d0()) {
                        if (d(eVar.A(), i2, eVar.R()) && d(eVar.B(), i3, eVar.v())) {
                            aVar.f2353e = eVar.R();
                            aVar.f2354f = eVar.v();
                            aVar.f2355g = eVar.n();
                            return;
                        }
                    }
                    e.b bVar3 = e.b.MATCH_CONSTRAINT;
                    boolean z3 = bVar == bVar3;
                    boolean z4 = bVar2 == bVar3;
                    e.b bVar4 = e.b.MATCH_PARENT;
                    boolean z5 = bVar2 == bVar4 || bVar2 == e.b.FIXED;
                    boolean z6 = bVar == bVar4 || bVar == e.b.FIXED;
                    boolean z7 = z3 && eVar.U > Utils.FLOAT_EPSILON;
                    boolean z8 = z4 && eVar.U > Utils.FLOAT_EPSILON;
                    if (view != null) {
                        b bVar5 = (b) view.getLayoutParams();
                        int i17 = aVar.f2358j;
                        if (i17 == b.a.l || i17 == b.a.m || !z3 || eVar.n != 0 || !z4 || eVar.o != 0) {
                            if (!(view instanceof j) || !(eVar instanceof k)) {
                                view.measure(i2, i3);
                            } else {
                                ((j) view).o((k) eVar, i2, i3);
                            }
                            eVar.F0(i2, i3);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            i5 = view.getBaseline();
                            int i18 = eVar.q;
                            i4 = i18 > 0 ? Math.max(i18, measuredWidth) : measuredWidth;
                            int i19 = eVar.r;
                            if (i19 > 0) {
                                i4 = Math.min(i19, i4);
                            }
                            int i20 = eVar.t;
                            if (i20 > 0) {
                                i6 = Math.max(i20, measuredHeight);
                                i8 = i2;
                            } else {
                                i8 = i2;
                                i6 = measuredHeight;
                            }
                            int i21 = eVar.u;
                            if (i21 > 0) {
                                i6 = Math.min(i21, i6);
                            }
                            if (!j.b(ConstraintLayout.this.f865j, 1)) {
                                if (z7 && z5) {
                                    i4 = (int) ((((float) i6) * eVar.U) + 0.5f);
                                } else if (z8 && z6) {
                                    i6 = (int) ((((float) i4) / eVar.U) + 0.5f);
                                }
                            }
                            if (!(measuredWidth == i4 && measuredHeight == i6)) {
                                int makeMeasureSpec = measuredWidth != i4 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : i8;
                                if (measuredHeight != i6) {
                                    i3 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                                }
                                view.measure(makeMeasureSpec, i3);
                                eVar.F0(makeMeasureSpec, i3);
                                i4 = view.getMeasuredWidth();
                                i6 = view.getMeasuredHeight();
                                i5 = view.getBaseline();
                            }
                            i7 = -1;
                        } else {
                            i7 = -1;
                            i6 = 0;
                            i5 = 0;
                            i4 = 0;
                        }
                        boolean z9 = i5 != i7;
                        aVar.f2357i = (i4 == aVar.f2351c && i6 == aVar.f2352d) ? false : true;
                        if (bVar5.X) {
                            z9 = true;
                        }
                        if (!(!z9 || i5 == -1 || eVar.n() == i5)) {
                            aVar.f2357i = true;
                        }
                        aVar.f2353e = i4;
                        aVar.f2354f = i6;
                        aVar.f2356h = z9;
                        aVar.f2355g = i5;
                    }
                }
            }
        }

        @Override // b.f.b.k.m.b.AbstractC0036b
        public final void b() {
            int childCount = this.f880a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f880a.getChildAt(i2);
                if (childAt instanceof g) {
                    ((g) childAt).a(this.f880a);
                }
            }
            int size = this.f880a.f858c.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ((b) this.f880a.f858c.get(i3)).k(this.f880a);
                }
            }
        }

        public void c(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f881b = i4;
            this.f882c = i5;
            this.f883d = i6;
            this.f884e = i7;
            this.f885f = i2;
            this.f886g = i3;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int i2 = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i2 > 0 ? i2 : max;
    }

    private final e h(int i2) {
        if (i2 == 0) {
            return this.f859d;
        }
        View view = this.f857b.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f859d;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).m0;
    }

    private void k(AttributeSet attributeSet, int i2, int i3) {
        this.f859d.l0(this);
        this.f859d.D1(this.r);
        this.f857b.put(getId(), this);
        this.f866k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.J0, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == i.O0) {
                    this.f860e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f860e);
                } else if (index == i.P0) {
                    this.f861f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f861f);
                } else if (index == i.M0) {
                    this.f862g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f862g);
                } else if (index == i.N0) {
                    this.f863h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f863h);
                } else if (index == i.W1) {
                    this.f865j = obtainStyledAttributes.getInt(index, this.f865j);
                } else if (index == i.X0) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            n(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == i.U0) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f866k = dVar;
                        dVar.m(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f866k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f859d.E1(this.f865j);
    }

    private void m() {
        this.f864i = true;
        this.o = -1;
        this.p = -1;
    }

    private void q() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e j2 = j(getChildAt(i2));
            if (j2 != null) {
                j2.h0();
            }
        }
        if (isInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    r(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    h(childAt.getId()).m0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.m != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2.getId() == this.m && (childAt2 instanceof e)) {
                    this.f866k = ((e) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.f866k;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.f859d.d1();
        int size = this.f858c.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.f858c.get(i5).m(this);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt3 = getChildAt(i6);
            if (childAt3 instanceof g) {
                ((g) childAt3).b(this);
            }
        }
        this.q.clear();
        this.q.put(0, this.f859d);
        this.q.put(getId(), this.f859d);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt4 = getChildAt(i7);
            this.q.put(childAt4.getId(), j(childAt4));
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt5 = getChildAt(i8);
            e j3 = j(childAt5);
            if (j3 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.f859d.a(j3);
                d(isInEditMode, childAt5, j3, bVar, this.q);
            }
        }
    }

    private boolean t() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            q();
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(boolean r20, android.view.View r21, b.f.b.k.e r22, androidx.constraintlayout.widget.ConstraintLayout.b r23, android.util.SparseArray<b.f.b.k.e> r24) {
        /*
        // Method dump skipped, instructions count: 718
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.d(boolean, android.view.View, b.f.b.k.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<b> arrayList = this.f858c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f858c.get(i2).l(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i4 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i5 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i4;
                        float f3 = (float) i5;
                        float f4 = (float) (i4 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = (float) (i5 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        canvas.drawLine(f4, f3, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f4, f3, paint);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    /* renamed from: f */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void forceLayout() {
        m();
        super.forceLayout();
    }

    public Object g(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public int getMaxHeight() {
        return this.f863h;
    }

    public int getMaxWidth() {
        return this.f862g;
    }

    public int getMinHeight() {
        return this.f861f;
    }

    public int getMinWidth() {
        return this.f860e;
    }

    public int getOptimizationLevel() {
        return this.f859d.s1();
    }

    public View i(int i2) {
        return this.f857b.get(i2);
    }

    public final e j(View view) {
        if (view == this) {
            return this.f859d;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).m0;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void n(int i2) {
        this.l = new c(getContext(), this, i2);
    }

    /* access modifiers changed from: protected */
    public void o(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        c cVar = this.r;
        int i6 = cVar.f884e;
        int i7 = i4 + cVar.f883d;
        int i8 = i5 + i6;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolveSizeAndState = ViewGroup.resolveSizeAndState(i7, i2, 0);
            int min = Math.min(this.f862g, resolveSizeAndState & 16777215);
            int min2 = Math.min(this.f863h, ViewGroup.resolveSizeAndState(i8, i3, 0) & 16777215);
            if (z) {
                min |= 16777216;
            }
            if (z2) {
                min2 |= 16777216;
            }
            setMeasuredDimension(min, min2);
            this.o = min;
            this.p = min2;
            return;
        }
        setMeasuredDimension(i7, i8);
        this.o = i7;
        this.p = i8;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            b bVar = (b) childAt.getLayoutParams();
            e eVar = bVar.m0;
            if ((childAt.getVisibility() != 8 || bVar.Y || bVar.Z || bVar.b0 || isInEditMode) && !bVar.a0) {
                int S = eVar.S();
                int T = eVar.T();
                int R = eVar.R() + S;
                int v = eVar.v() + T;
                childAt.layout(S, T, R, v);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(S, T, R, v);
                }
            }
        }
        int size = this.f858c.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f858c.get(i7).j(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!this.f864i) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                } else if (getChildAt(i4).isLayoutRequested()) {
                    this.f864i = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (!this.f864i) {
            int i5 = this.s;
            if (i5 == i2 && this.t == i3) {
                o(i2, i3, this.f859d.R(), this.f859d.v(), this.f859d.y1(), this.f859d.w1());
                return;
            } else if (i5 == i2 && View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.t) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i3) >= this.f859d.v()) {
                this.s = i2;
                this.t = i3;
                o(i2, i3, this.f859d.R(), this.f859d.v(), this.f859d.y1(), this.f859d.w1());
                return;
            }
        }
        this.s = i2;
        this.t = i3;
        this.f859d.F1(l());
        if (this.f864i) {
            this.f864i = false;
            if (t()) {
                this.f859d.H1();
            }
        }
        p(this.f859d, this.f865j, i2, i3);
        o(i2, i3, this.f859d.R(), this.f859d.v(), this.f859d.y1(), this.f859d.w1());
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        e j2 = j(view);
        if ((view instanceof Guideline) && !(j2 instanceof g)) {
            b bVar = (b) view.getLayoutParams();
            g gVar = new g();
            bVar.m0 = gVar;
            bVar.Y = true;
            gVar.j1(bVar.R);
        }
        if (view instanceof b) {
            b bVar2 = (b) view;
            bVar2.n();
            ((b) view.getLayoutParams()).Z = true;
            if (!this.f858c.contains(bVar2)) {
                this.f858c.add(bVar2);
            }
        }
        this.f857b.put(view.getId(), view);
        this.f864i = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f857b.remove(view.getId());
        this.f859d.c1(j(view));
        this.f858c.remove(view);
        this.f864i = true;
    }

    /* access modifiers changed from: protected */
    public void p(f fVar, int i2, int i3, int i4) {
        int i5;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i6 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.r.c(i3, i4, max, max2, paddingWidth, i6);
        if (Build.VERSION.SDK_INT >= 17) {
            int max3 = Math.max(0, getPaddingStart());
            int max4 = Math.max(0, getPaddingEnd());
            if (max3 <= 0 && max4 <= 0) {
                max3 = Math.max(0, getPaddingLeft());
            } else if (l()) {
                max3 = max4;
            }
            i5 = max3;
        } else {
            i5 = Math.max(0, getPaddingLeft());
        }
        int i7 = size - paddingWidth;
        int i8 = size2 - i6;
        s(fVar, mode, i7, mode2, i8);
        fVar.z1(i2, mode, i7, mode2, i8, this.o, this.p, i5, max);
    }

    public void r(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        m();
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void s(f fVar, int i2, int i3, int i4, int i5) {
        e.b bVar;
        c cVar = this.r;
        int i6 = cVar.f884e;
        int i7 = cVar.f883d;
        e.b bVar2 = e.b.FIXED;
        int childCount = getChildCount();
        if (i2 != Integer.MIN_VALUE) {
            if (i2 == 0) {
                bVar = e.b.WRAP_CONTENT;
                if (childCount == 0) {
                    i3 = Math.max(0, this.f860e);
                }
            } else if (i2 != 1073741824) {
                bVar = bVar2;
            } else {
                i3 = Math.min(this.f862g - i7, i3);
                bVar = bVar2;
            }
            i3 = 0;
        } else {
            bVar = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i3 = Math.max(0, this.f860e);
            }
        }
        if (i4 != Integer.MIN_VALUE) {
            if (i4 == 0) {
                bVar2 = e.b.WRAP_CONTENT;
                if (childCount == 0) {
                    i5 = Math.max(0, this.f861f);
                }
            } else if (i4 == 1073741824) {
                i5 = Math.min(this.f863h - i6, i5);
            }
            i5 = 0;
        } else {
            bVar2 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.f861f);
            }
        }
        if (!(i3 == fVar.R() && i5 == fVar.v())) {
            fVar.v1();
        }
        fVar.V0(0);
        fVar.W0(0);
        fVar.H0(this.f862g - i7);
        fVar.G0(this.f863h - i6);
        fVar.K0(0);
        fVar.J0(0);
        fVar.z0(bVar);
        fVar.U0(i3);
        fVar.Q0(bVar2);
        fVar.v0(i5);
        fVar.K0(this.f860e - i7);
        fVar.J0(this.f861f - i6);
    }

    public void setConstraintSet(d dVar) {
        this.f866k = dVar;
    }

    public void setId(int i2) {
        this.f857b.remove(getId());
        super.setId(i2);
        this.f857b.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.f863h) {
            this.f863h = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f862g) {
            this.f862g = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f861f) {
            this.f861f = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f860e) {
            this.f860e = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(f fVar) {
        c cVar = this.l;
        if (cVar != null) {
            cVar.c(fVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f865j = i2;
        this.f859d.E1(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k(attributeSet, i2, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        int C = 1;
        public float D = -1.0f;
        public float E = -1.0f;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public float N = 1.0f;
        public float O = 1.0f;
        public int P = -1;
        public int Q = -1;
        public int R = -1;
        public boolean S = false;
        public boolean T = false;
        public String U = null;
        boolean V = true;
        boolean W = true;
        boolean X = false;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f868a = -1;
        boolean a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f869b = -1;
        boolean b0 = false;

        /* renamed from: c  reason: collision with root package name */
        public float f870c = -1.0f;
        int c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f871d = -1;
        int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f872e = -1;
        int e0 = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f873f = -1;
        int f0 = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f874g = -1;
        int g0 = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f875h = -1;
        int h0 = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f876i = -1;
        float i0 = 0.5f;

        /* renamed from: j  reason: collision with root package name */
        public int f877j = -1;
        int j0;

        /* renamed from: k  reason: collision with root package name */
        public int f878k = -1;
        int k0;
        public int l = -1;
        float l0;
        public int m = -1;
        e m0 = new e();
        public int n = 0;
        public boolean n0;
        public float o = Utils.FLOAT_EPSILON;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f879a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f879a = sparseIntArray;
                sparseIntArray.append(i.w1, 8);
                sparseIntArray.append(i.x1, 9);
                sparseIntArray.append(i.z1, 10);
                sparseIntArray.append(i.A1, 11);
                sparseIntArray.append(i.G1, 12);
                sparseIntArray.append(i.F1, 13);
                sparseIntArray.append(i.e1, 14);
                sparseIntArray.append(i.d1, 15);
                sparseIntArray.append(i.b1, 16);
                sparseIntArray.append(i.f1, 2);
                sparseIntArray.append(i.h1, 3);
                sparseIntArray.append(i.g1, 4);
                sparseIntArray.append(i.O1, 49);
                sparseIntArray.append(i.P1, 50);
                sparseIntArray.append(i.l1, 5);
                sparseIntArray.append(i.m1, 6);
                sparseIntArray.append(i.n1, 7);
                sparseIntArray.append(i.K0, 1);
                sparseIntArray.append(i.B1, 17);
                sparseIntArray.append(i.C1, 18);
                sparseIntArray.append(i.k1, 19);
                sparseIntArray.append(i.j1, 20);
                sparseIntArray.append(i.S1, 21);
                sparseIntArray.append(i.V1, 22);
                sparseIntArray.append(i.T1, 23);
                sparseIntArray.append(i.Q1, 24);
                sparseIntArray.append(i.U1, 25);
                sparseIntArray.append(i.R1, 26);
                sparseIntArray.append(i.s1, 29);
                sparseIntArray.append(i.H1, 30);
                sparseIntArray.append(i.i1, 44);
                sparseIntArray.append(i.u1, 45);
                sparseIntArray.append(i.J1, 46);
                sparseIntArray.append(i.t1, 47);
                sparseIntArray.append(i.I1, 48);
                sparseIntArray.append(i.Z0, 27);
                sparseIntArray.append(i.Y0, 28);
                sparseIntArray.append(i.K1, 31);
                sparseIntArray.append(i.o1, 32);
                sparseIntArray.append(i.M1, 33);
                sparseIntArray.append(i.L1, 34);
                sparseIntArray.append(i.N1, 35);
                sparseIntArray.append(i.q1, 36);
                sparseIntArray.append(i.p1, 37);
                sparseIntArray.append(i.r1, 38);
                sparseIntArray.append(i.v1, 39);
                sparseIntArray.append(i.E1, 40);
                sparseIntArray.append(i.y1, 41);
                sparseIntArray.append(i.c1, 42);
                sparseIntArray.append(i.a1, 43);
                f879a.append(i.D1, 51);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.J0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = a.f879a.get(index);
                switch (i4) {
                    case 1:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < Utils.FLOAT_EPSILON) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f868a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f868a);
                        break;
                    case 6:
                        this.f869b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f869b);
                        break;
                    case 7:
                        this.f870c = obtainStyledAttributes.getFloat(index, this.f870c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f871d);
                        this.f871d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f871d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f872e);
                        this.f872e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f872e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f873f);
                        this.f873f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f873f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f874g);
                        this.f874g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f874g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f875h);
                        this.f875h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f875h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f876i);
                        this.f876i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f876i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f877j);
                        this.f877j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f877j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f878k);
                        this.f878k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f878k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.S = obtainStyledAttributes.getBoolean(index, this.S);
                        break;
                    case 28:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.H = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i6 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.N = Math.max((float) Utils.FLOAT_EPSILON, obtainStyledAttributes.getFloat(index, this.N));
                        this.H = 2;
                        break;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.O = Math.max((float) Utils.FLOAT_EPSILON, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.C = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.B.substring(i2);
                                        if (substring2.length() > 0) {
                                            Float.parseFloat(substring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.B.substring(i2, indexOf2);
                                        String substring4 = this.B.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > Utils.FLOAT_EPSILON && parseFloat2 > Utils.FLOAT_EPSILON) {
                                                    if (this.C == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                continue;
                            case 46:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 47:
                                this.F = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                continue;
                            case 50:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                            case 51:
                                this.U = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.S) {
                this.V = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.V = false;
                if (i2 == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.W = false;
                if (i3 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f870c != -1.0f || this.f868a != -1 || this.f869b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.m0 instanceof g)) {
                    this.m0 = new g();
                }
                ((g) this.m0).j1(this.R);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003f  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r10) {
            /*
            // Method dump skipped, instructions count: 263
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
