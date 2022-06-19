package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.p;
import b.h.k.t;
import b.h.k.u;

/* compiled from: AppCompatSpinner */
public class q extends Spinner implements t {

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f710j = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final e f711b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f712c;

    /* renamed from: d  reason: collision with root package name */
    private a0 f713d;

    /* renamed from: e  reason: collision with root package name */
    private SpinnerAdapter f714e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f715f;

    /* renamed from: g  reason: collision with root package name */
    private g f716g;

    /* renamed from: h  reason: collision with root package name */
    int f717h;

    /* renamed from: i  reason: collision with root package name */
    final Rect f718i;

    /* compiled from: AppCompatSpinner */
    class a extends a0 {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ e f719k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f719k = eVar;
        }

        @Override // androidx.appcompat.widget.a0
        public p b() {
            return this.f719k;
        }

        @Override // androidx.appcompat.widget.a0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (q.this.getInternalPopup().c()) {
                return true;
            }
            q.this.b();
            return true;
        }
    }

    /* compiled from: AppCompatSpinner */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!q.this.getInternalPopup().c()) {
                q.this.b();
            }
            ViewTreeObserver viewTreeObserver = q.this.getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: AppCompatSpinner */
    class c implements g, DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.app.b f721b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f722c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f723d;

        c() {
        }

        @Override // androidx.appcompat.widget.q.g
        public void b(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.q.g
        public boolean c() {
            androidx.appcompat.app.b bVar = this.f721b;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.q.g
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.q.g
        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f721b;
            if (bVar != null) {
                bVar.dismiss();
                this.f721b = null;
            }
        }

        @Override // androidx.appcompat.widget.q.g
        public Drawable g() {
            return null;
        }

        @Override // androidx.appcompat.widget.q.g
        public void i(CharSequence charSequence) {
            this.f723d = charSequence;
        }

        @Override // androidx.appcompat.widget.q.g
        public void j(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.q.g
        public void k(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.q.g
        public void l(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.q.g
        public void m(int i2, int i3) {
            if (this.f722c != null) {
                b.a aVar = new b.a(q.this.getPopupContext());
                CharSequence charSequence = this.f723d;
                if (charSequence != null) {
                    aVar.n(charSequence);
                }
                aVar.l(this.f722c, q.this.getSelectedItemPosition(), this);
                androidx.appcompat.app.b a2 = aVar.a();
                this.f721b = a2;
                ListView f2 = a2.f();
                if (Build.VERSION.SDK_INT >= 17) {
                    f2.setTextDirection(i2);
                    f2.setTextAlignment(i3);
                }
                this.f721b.show();
            }
        }

        @Override // androidx.appcompat.widget.q.g
        public int n() {
            return 0;
        }

        @Override // androidx.appcompat.widget.q.g
        public CharSequence o() {
            return this.f723d;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            q.this.setSelection(i2);
            if (q.this.getOnItemClickListener() != null) {
                q.this.performItemClick(null, i2, this.f722c.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.q.g
        public void p(ListAdapter listAdapter) {
            this.f722c = listAdapter;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatSpinner */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private SpinnerAdapter f725b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f726c;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f725b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f726c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof m0) {
                m0 m0Var = (m0) spinnerAdapter;
                if (m0Var.getDropDownViewTheme() == null) {
                    m0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f726c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f725b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f725b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f725b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f725b;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f725b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f726c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f725b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f725b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner */
    class e extends c0 implements g {
        private CharSequence J;
        ListAdapter K;
        private final Rect L = new Rect();
        private int M;

        /* compiled from: AppCompatSpinner */
        class a implements AdapterView.OnItemClickListener {
            a(q qVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                q.this.setSelection(i2);
                if (q.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    q.this.performItemClick(view, i2, eVar.K.getItemId(i2));
                }
                e.this.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.U(q.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.S();
                e.super.a();
            }
        }

        /* compiled from: AppCompatSpinner */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f729b;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f729b = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = q.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f729b);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            D(q.this);
            J(true);
            O(0);
            L(new a(q.this));
        }

        /* access modifiers changed from: package-private */
        public void S() {
            int i2;
            int i3;
            Drawable g2 = g();
            int i4 = 0;
            if (g2 != null) {
                g2.getPadding(q.this.f718i);
                if (w0.b(q.this)) {
                    i3 = q.this.f718i.right;
                } else {
                    i3 = -q.this.f718i.left;
                }
                i4 = i3;
            } else {
                Rect rect = q.this.f718i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = q.this.getPaddingLeft();
            int paddingRight = q.this.getPaddingRight();
            int width = q.this.getWidth();
            q qVar = q.this;
            int i5 = qVar.f717h;
            if (i5 == -2) {
                int a2 = qVar.a((SpinnerAdapter) this.K, g());
                int i6 = q.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = q.this.f718i;
                int i7 = (i6 - rect2.left) - rect2.right;
                if (a2 > i7) {
                    a2 = i7;
                }
                F(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i5 == -1) {
                F((width - paddingLeft) - paddingRight);
            } else {
                F(i5);
            }
            if (w0.b(q.this)) {
                i2 = i4 + (((width - paddingRight) - z()) - T());
            } else {
                i2 = i4 + paddingLeft + T();
            }
            l(i2);
        }

        public int T() {
            return this.M;
        }

        /* access modifiers changed from: package-private */
        public boolean U(View view) {
            return u.R(view) && view.getGlobalVisibleRect(this.L);
        }

        @Override // androidx.appcompat.widget.q.g
        public void i(CharSequence charSequence) {
            this.J = charSequence;
        }

        @Override // androidx.appcompat.widget.q.g
        public void k(int i2) {
            this.M = i2;
        }

        @Override // androidx.appcompat.widget.q.g
        public void m(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean c2 = c();
            S();
            I(2);
            super.a();
            ListView h2 = h();
            h2.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                h2.setTextDirection(i2);
                h2.setTextAlignment(i3);
            }
            P(q.this.getSelectedItemPosition());
            if (!c2 && (viewTreeObserver = q.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                K(new c(bVar));
            }
        }

        @Override // androidx.appcompat.widget.q.g
        public CharSequence o() {
            return this.J;
        }

        @Override // androidx.appcompat.widget.q.g, androidx.appcompat.widget.c0
        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.K = listAdapter;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatSpinner */
    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        boolean f731b;

        /* compiled from: AppCompatSpinner */
        class a implements Parcelable.Creator<f> {
            a() {
            }

            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            /* renamed from: b */
            public f[] newArray(int i2) {
                return new f[i2];
            }
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f731b ? (byte) 1 : 0);
        }

        f(Parcel parcel) {
            super(parcel);
            this.f731b = parcel.readByte() != 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatSpinner */
    public interface g {
        void b(Drawable drawable);

        boolean c();

        int d();

        void dismiss();

        Drawable g();

        void i(CharSequence charSequence);

        void j(int i2);

        void k(int i2);

        void l(int i2);

        void m(int i2, int i3);

        int n();

        CharSequence o();

        void p(ListAdapter listAdapter);
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.spinnerStyle);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f718i);
        Rect rect = this.f718i;
        return i3 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f716g.m(getTextDirection(), getTextAlignment());
        } else {
            this.f716g.m(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f711b;
        if (eVar != null) {
            eVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        g gVar = this.f716g;
        if (gVar != null) {
            return gVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        g gVar = this.f716g;
        if (gVar != null) {
            return gVar.n();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f716g != null) {
            return this.f717h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final g getInternalPopup() {
        return this.f716g;
    }

    public Drawable getPopupBackground() {
        g gVar = this.f716g;
        if (gVar != null) {
            return gVar.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f712c;
    }

    public CharSequence getPrompt() {
        g gVar = this.f716g;
        return gVar != null ? gVar.o() : super.getPrompt();
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f711b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f711b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f716g;
        if (gVar != null && gVar.c()) {
            this.f716g.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f716g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (fVar.f731b && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f716g;
        fVar.f731b = gVar != null && gVar.c();
        return fVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a0 a0Var = this.f713d;
        if (a0Var == null || !a0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        g gVar = this.f716g;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.c()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f711b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f711b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        g gVar = this.f716g;
        if (gVar != null) {
            gVar.k(i2);
            this.f716g.l(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public void setDropDownVerticalOffset(int i2) {
        g gVar = this.f716g;
        if (gVar != null) {
            gVar.j(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.f716g != null) {
            this.f717h = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f716g;
        if (gVar != null) {
            gVar.b(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(b.a.k.a.a.d(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f716g;
        if (gVar != null) {
            gVar.i(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f711b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f711b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public q(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f715f) {
            this.f714e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f716g != null) {
            Context context = this.f712c;
            if (context == null) {
                context = getContext();
            }
            this.f716g.p(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public q(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r11 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r11 != null) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
