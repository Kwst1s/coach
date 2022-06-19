package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import b.a.j;
import b.h.k.h;
import b.h.k.u;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    f H;
    private final ActionMenuView.e I;
    private r0 J;
    private c K;
    private d L;
    private m.a M;
    private g.a N;
    private boolean O;
    private final Runnable P;

    /* renamed from: b  reason: collision with root package name */
    private ActionMenuView f514b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f515c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f516d;

    /* renamed from: e  reason: collision with root package name */
    private ImageButton f517e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f518f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f519g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f520h;

    /* renamed from: i  reason: collision with root package name */
    ImageButton f521i;

    /* renamed from: j  reason: collision with root package name */
    View f522j;

    /* renamed from: k  reason: collision with root package name */
    private Context f523k;
    private int l;
    private int m;
    private int n;
    int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private i0 u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.H;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Toolbar.this.O();
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* access modifiers changed from: private */
    public class d implements m {

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.view.menu.g f527b;

        /* renamed from: c  reason: collision with root package name */
        i f528c;

        d() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void d(Context context, androidx.appcompat.view.menu.g gVar) {
            i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f527b;
            if (!(gVar2 == null || (iVar = this.f528c) == null)) {
                gVar2.f(iVar);
            }
            this.f527b = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean e(r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public void f(boolean z) {
            if (this.f528c != null) {
                androidx.appcompat.view.menu.g gVar = this.f527b;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.f527b.getItem(i2) == this.f528c) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!z2) {
                    i(this.f527b, this.f528c);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean g() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean i(androidx.appcompat.view.menu.g gVar, i iVar) {
            View view = Toolbar.this.f522j;
            if (view instanceof b.a.o.c) {
                ((b.a.o.c) view).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f522j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f521i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f522j = null;
            toolbar3.a();
            this.f528c = null;
            Toolbar.this.requestLayout();
            iVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean j(androidx.appcompat.view.menu.g gVar, i iVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f521i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f521i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f521i);
            }
            Toolbar.this.f522j = iVar.getActionView();
            this.f528c = iVar;
            ViewParent parent2 = Toolbar.this.f522j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f522j);
                }
                e m = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m.f159a = 8388611 | (toolbar4.o & 112);
                m.f530b = 2;
                toolbar4.f522j.setLayoutParams(m);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f522j);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            iVar.r(true);
            View view = Toolbar.this.f522j;
            if (view instanceof b.a.o.c) {
                ((b.a.o.c) view).c();
            }
            return true;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.O);
    }

    private int B(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int q2 = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q2, max + measuredWidth, view.getMeasuredHeight() + q2);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int q2 = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q2, max, view.getMeasuredHeight() + q2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void E(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.P);
        post(this.P);
    }

    private boolean M() {
        if (!this.O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (N(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean N(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z2 = u.B(this) == 1;
        int childCount = getChildCount();
        int b2 = b.h.k.e.b(i2, u.B(this));
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f530b == 0 && N(childAt) && p(eVar.f159a) == b2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f530b == 0 && N(childAt2) && p(eVar2.f159a) == b2) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        e eVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            eVar = generateLayoutParams(layoutParams);
        } else {
            eVar = (e) layoutParams;
        }
        eVar.f530b = 1;
        if (!z2 || this.f522j == null) {
            addView(view, eVar);
            return;
        }
        view.setLayoutParams(eVar);
        this.F.add(view);
    }

    private MenuInflater getMenuInflater() {
        return new b.a.o.g(getContext());
    }

    private void h() {
        if (this.u == null) {
            this.u = new i0();
        }
    }

    private void i() {
        if (this.f518f == null) {
            this.f518f = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f514b.N() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f514b.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f514b.setExpandedActionViewsExclusive(true);
            gVar.c(this.L, this.f523k);
        }
    }

    private void k() {
        if (this.f514b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f514b = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.f514b.setOnMenuItemClickListener(this.I);
            this.f514b.O(this.M, this.N);
            e m2 = generateDefaultLayoutParams();
            m2.f159a = 8388613 | (this.o & 112);
            this.f514b.setLayoutParams(m2);
            c(this.f514b, false);
        }
    }

    private void l() {
        if (this.f517e == null) {
            this.f517e = new j(getContext(), null, b.a.a.toolbarNavigationButtonStyle);
            e m2 = generateDefaultLayoutParams();
            m2.f159a = 8388611 | (this.o & 112);
            this.f517e.setLayoutParams(m2);
        }
    }

    private int p(int i2) {
        int B2 = u.B(this);
        int b2 = b.h.k.e.b(i2, B2) & 7;
        if (b2 == 1 || b2 == 3 || b2 == 5) {
            return b2;
        }
        return B2 == 1 ? 5 : 3;
    }

    private int q(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int r2 = r(eVar.f159a);
        if (r2 == 48) {
            return getPaddingTop() - i3;
        }
        if (r2 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    private int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.x & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return h.b(marginLayoutParams) + h.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            e eVar = (e) view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i2;
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i2 = max3;
        }
        return i5;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f514b;
        return actionMenuView != null && actionMenuView.J();
    }

    /* access modifiers changed from: package-private */
    public void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((e) childAt.getLayoutParams()).f530b == 2 || childAt == this.f514b)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void H(int i2, int i3) {
        h();
        this.u.g(i2, i3);
    }

    public void I(androidx.appcompat.view.menu.g gVar, c cVar) {
        if (gVar != null || this.f514b != null) {
            k();
            androidx.appcompat.view.menu.g N2 = this.f514b.N();
            if (N2 != gVar) {
                if (N2 != null) {
                    N2.O(this.K);
                    N2.O(this.L);
                }
                if (this.L == null) {
                    this.L = new d();
                }
                cVar.G(true);
                if (gVar != null) {
                    gVar.c(cVar, this.f523k);
                    gVar.c(this.L, this.f523k);
                } else {
                    cVar.d(this.f523k, null);
                    this.L.d(this.f523k, null);
                    cVar.f(true);
                    this.L.f(true);
                }
                this.f514b.setPopupTheme(this.l);
                this.f514b.setPresenter(cVar);
                this.K = cVar;
            }
        }
    }

    public void J(m.a aVar, g.a aVar2) {
        this.M = aVar;
        this.N = aVar2;
        ActionMenuView actionMenuView = this.f514b;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void K(Context context, int i2) {
        this.n = i2;
        TextView textView = this.f516d;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void L(Context context, int i2) {
        this.m = i2;
        TextView textView = this.f515c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean O() {
        ActionMenuView actionMenuView = this.f514b;
        return actionMenuView != null && actionMenuView.P();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f514b) != null && actionMenuView.K();
    }

    public void e() {
        i iVar;
        d dVar = this.L;
        if (dVar == null) {
            iVar = null;
        } else {
            iVar = dVar.f528c;
        }
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f514b;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f521i == null) {
            j jVar = new j(getContext(), null, b.a.a.toolbarNavigationButtonStyle);
            this.f521i = jVar;
            jVar.setImageDrawable(this.f519g);
            this.f521i.setContentDescription(this.f520h);
            e m2 = generateDefaultLayoutParams();
            m2.f159a = 8388611 | (this.o & 112);
            m2.f530b = 2;
            this.f521i.setLayoutParams(m2);
            this.f521i.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f521i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f521i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        i0 i0Var = this.u;
        if (i0Var != null) {
            return i0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        i0 i0Var = this.u;
        if (i0Var != null) {
            return i0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        i0 i0Var = this.u;
        if (i0Var != null) {
            return i0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        i0 i0Var = this.u;
        if (i0Var != null) {
            return i0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g N2;
        ActionMenuView actionMenuView = this.f514b;
        if ((actionMenuView == null || (N2 = actionMenuView.N()) == null || !N2.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (u.B(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (u.B(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.v, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f518f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f518f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f514b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f517e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f517e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f514b.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f523k;
    }

    public int getPopupTheme() {
        return this.l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.f516d;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.f515c;
    }

    public w getWrapper() {
        if (this.J == null) {
            this.J = new r0(this, true);
        }
        return this.J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    /* renamed from: n */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof a.C0008a) {
            return new e((a.C0008a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a3 A[LOOP:0: B:101:0x02a1->B:102:0x02a3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c5 A[LOOP:1: B:104:0x02c3->B:105:0x02c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fe A[LOOP:2: B:112:0x02fc->B:113:0x02fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
        // Method dump skipped, instructions count: 787
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        int i11 = 0;
        if (w0.b(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (N(this.f517e)) {
            E(this.f517e, i2, 0, i3, 0, this.p);
            i6 = this.f517e.getMeasuredWidth() + s(this.f517e);
            i5 = Math.max(0, this.f517e.getMeasuredHeight() + t(this.f517e));
            i4 = View.combineMeasuredStates(0, this.f517e.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (N(this.f521i)) {
            E(this.f521i, i2, 0, i3, 0, this.p);
            i6 = this.f521i.getMeasuredWidth() + s(this.f521i);
            i5 = Math.max(i5, this.f521i.getMeasuredHeight() + t(this.f521i));
            i4 = View.combineMeasuredStates(i4, this.f521i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i6);
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (N(this.f514b)) {
            E(this.f514b, i2, max, i3, 0, this.p);
            i7 = this.f514b.getMeasuredWidth() + s(this.f514b);
            i5 = Math.max(i5, this.f514b.getMeasuredHeight() + t(this.f514b));
            i4 = View.combineMeasuredStates(i4, this.f514b.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (N(this.f522j)) {
            max2 += D(this.f522j, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f522j.getMeasuredHeight() + t(this.f522j));
            i4 = View.combineMeasuredStates(i4, this.f522j.getMeasuredState());
        }
        if (N(this.f518f)) {
            max2 += D(this.f518f, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f518f.getMeasuredHeight() + t(this.f518f));
            i4 = View.combineMeasuredStates(i4, this.f518f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((e) childAt.getLayoutParams()).f530b == 0 && N(childAt)) {
                max2 += D(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + t(childAt));
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i13 = this.s + this.t;
        int i14 = this.q + this.r;
        if (N(this.f515c)) {
            D(this.f515c, i2, max2 + i14, i3, i13, iArr);
            int measuredWidth = this.f515c.getMeasuredWidth() + s(this.f515c);
            i8 = this.f515c.getMeasuredHeight() + t(this.f515c);
            i10 = View.combineMeasuredStates(i4, this.f515c.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (N(this.f516d)) {
            i9 = Math.max(i9, D(this.f516d, i2, max2 + i14, i3, i8 + i13, iArr));
            i8 += this.f516d.getMeasuredHeight() + t(this.f516d);
            i10 = View.combineMeasuredStates(i10, this.f516d.getMeasuredState());
        }
        int max3 = Math.max(i5, i8);
        int paddingLeft = max2 + i9 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (!M()) {
            i11 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i11);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.g());
        ActionMenuView actionMenuView = this.f514b;
        androidx.appcompat.view.menu.g N2 = actionMenuView != null ? actionMenuView.N() : null;
        int i2 = gVar.f531d;
        if (!(i2 == 0 || this.L == null || N2 == null || (findItem = N2.findItem(i2)) == null)) {
            findItem.expandActionView();
        }
        if (gVar.f532e) {
            F();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        h();
        i0 i0Var = this.u;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        i0Var.f(z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        i iVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (!(dVar == null || (iVar = dVar.f528c) == null)) {
            gVar.f531d = iVar.getItemId();
        }
        gVar.f532e = A();
        return gVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(b.a.k.a.a.d(getContext(), i2));
    }

    public void setCollapsible(boolean z2) {
        this.O = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.w) {
            this.w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(b.a.k.a.a.d(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(b.a.k.a.a.d(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f517e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f514b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.l != i2) {
            this.l = i2;
            if (i2 == 0) {
                this.f523k = getContext();
            } else {
                this.f523k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean v() {
        d dVar = this.L;
        return (dVar == null || dVar.f528c == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f514b;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f514b;
        return actionMenuView != null && actionMenuView.I();
    }

    public static class e extends a.C0008a {

        /* renamed from: b  reason: collision with root package name */
        int f530b = 0;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.f159a = 8388627;
        }

        public e(e eVar) {
            super((a.C0008a) eVar);
            this.f530b = eVar.f530b;
        }

        public e(a.C0008a aVar) {
            super(aVar);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        Context context2 = getContext();
        int[] iArr = j.W2;
        q0 v2 = q0.v(context2, attributeSet, iArr, i2, 0);
        u.k0(this, context, iArr, attributeSet, v2.r(), i2, 0);
        this.m = v2.n(j.y3, 0);
        this.n = v2.n(j.p3, 0);
        this.x = v2.l(j.X2, this.x);
        this.o = v2.l(j.Y2, 48);
        int e2 = v2.e(j.s3, 0);
        int i3 = j.x3;
        e2 = v2.s(i3) ? v2.e(i3, e2) : e2;
        this.t = e2;
        this.s = e2;
        this.r = e2;
        this.q = e2;
        int e3 = v2.e(j.v3, -1);
        if (e3 >= 0) {
            this.q = e3;
        }
        int e4 = v2.e(j.u3, -1);
        if (e4 >= 0) {
            this.r = e4;
        }
        int e5 = v2.e(j.w3, -1);
        if (e5 >= 0) {
            this.s = e5;
        }
        int e6 = v2.e(j.t3, -1);
        if (e6 >= 0) {
            this.t = e6;
        }
        this.p = v2.f(j.j3, -1);
        int e7 = v2.e(j.f3, Integer.MIN_VALUE);
        int e8 = v2.e(j.b3, Integer.MIN_VALUE);
        int f2 = v2.f(j.d3, 0);
        int f3 = v2.f(j.e3, 0);
        h();
        this.u.e(f2, f3);
        if (!(e7 == Integer.MIN_VALUE && e8 == Integer.MIN_VALUE)) {
            this.u.g(e7, e8);
        }
        this.v = v2.e(j.g3, Integer.MIN_VALUE);
        this.w = v2.e(j.c3, Integer.MIN_VALUE);
        this.f519g = v2.g(j.a3);
        this.f520h = v2.p(j.Z2);
        CharSequence p2 = v2.p(j.r3);
        if (!TextUtils.isEmpty(p2)) {
            setTitle(p2);
        }
        CharSequence p3 = v2.p(j.o3);
        if (!TextUtils.isEmpty(p3)) {
            setSubtitle(p3);
        }
        this.f523k = getContext();
        setPopupTheme(v2.n(j.n3, 0));
        Drawable g2 = v2.g(j.m3);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence p4 = v2.p(j.l3);
        if (!TextUtils.isEmpty(p4)) {
            setNavigationContentDescription(p4);
        }
        Drawable g3 = v2.g(j.h3);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence p5 = v2.p(j.i3);
        if (!TextUtils.isEmpty(p5)) {
            setLogoDescription(p5);
        }
        int i4 = j.z3;
        if (v2.s(i4)) {
            setTitleTextColor(v2.c(i4));
        }
        int i5 = j.q3;
        if (v2.s(i5)) {
            setSubtitleTextColor(v2.c(i5));
        }
        int i6 = j.k3;
        if (v2.s(i6)) {
            x(v2.n(i6, 0));
        }
        v2.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f521i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f521i.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f521i;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f519g);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f518f)) {
                c(this.f518f, true);
            }
        } else {
            ImageView imageView = this.f518f;
            if (imageView != null && y(imageView)) {
                removeView(this.f518f);
                this.F.remove(this.f518f);
            }
        }
        ImageView imageView2 = this.f518f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f518f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f517e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f517e)) {
                c(this.f517e, true);
            }
        } else {
            ImageButton imageButton = this.f517e;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f517e);
                this.F.remove(this.f517e);
            }
        }
        ImageButton imageButton2 = this.f517e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f516d == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f516d = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f516d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.f516d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f516d.setTextColor(colorStateList);
                }
            }
            if (!y(this.f516d)) {
                c(this.f516d, true);
            }
        } else {
            TextView textView = this.f516d;
            if (textView != null && y(textView)) {
                removeView(this.f516d);
                this.F.remove(this.f516d);
            }
        }
        TextView textView2 = this.f516d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f516d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f515c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f515c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f515c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.f515c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f515c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f515c)) {
                c(this.f515c, true);
            }
        } else {
            TextView textView = this.f515c;
            if (textView != null && y(textView)) {
                removeView(this.f515c);
                this.F.remove(this.f515c);
            }
        }
        TextView textView2 = this.f515c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f515c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class g extends b.j.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        int f531d;

        /* renamed from: e  reason: collision with root package name */
        boolean f532e;

        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            /* renamed from: c */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f531d = parcel.readInt();
            this.f532e = parcel.readInt() != 0;
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f531d);
            parcel.writeInt(this.f532e ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
