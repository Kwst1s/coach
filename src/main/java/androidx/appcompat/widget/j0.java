package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.b0;

/* compiled from: ScrollingTabContainerView */
public class j0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    Runnable f651b;

    /* renamed from: c  reason: collision with root package name */
    private c f652c;

    /* renamed from: d  reason: collision with root package name */
    b0 f653d;

    /* renamed from: e  reason: collision with root package name */
    private Spinner f654e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f655f;

    /* renamed from: g  reason: collision with root package name */
    int f656g;

    /* renamed from: h  reason: collision with root package name */
    int f657h;

    /* renamed from: i  reason: collision with root package name */
    private int f658i;

    /* renamed from: j  reason: collision with root package name */
    private int f659j;

    /* access modifiers changed from: package-private */
    /* compiled from: ScrollingTabContainerView */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f660b;

        a(View view) {
            this.f660b = view;
        }

        public void run() {
            j0.this.smoothScrollTo(this.f660b.getLeft() - ((j0.this.getWidth() - this.f660b.getWidth()) / 2), 0);
            j0.this.f651b = null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView */
    public class b extends BaseAdapter {
        b() {
        }

        public int getCount() {
            return j0.this.f653d.getChildCount();
        }

        public Object getItem(int i2) {
            return ((d) j0.this.f653d.getChildAt(i2)).b();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return j0.this.c((a.c) getItem(i2), true);
            }
            ((d) view).a((a.c) getItem(i2));
            return view;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = j0.this.f653d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = j0.this.f653d.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView */
    public class d extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int[] f664b;

        /* renamed from: c  reason: collision with root package name */
        private a.c f665c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f666d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f667e;

        /* renamed from: f  reason: collision with root package name */
        private View f668f;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.j0.this = r5
                int r5 = b.a.a.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f664b = r1
                r4.f665c = r7
                androidx.appcompat.widget.q0 r5 = androidx.appcompat.widget.q0.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.w()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.d.<init>(androidx.appcompat.widget.j0, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.f665c = cVar;
            c();
        }

        public a.c b() {
            return this.f665c;
        }

        public void c() {
            a.c cVar = this.f665c;
            View b2 = cVar.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f668f = b2;
                TextView textView = this.f666d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f667e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f667e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f668f;
            if (view != null) {
                removeView(view);
                this.f668f = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f667e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f667e = appCompatImageView;
                }
                this.f667e.setImageDrawable(c2);
                this.f667e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f667e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f667e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f666d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, b.a.a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f666d = appCompatTextView;
                }
                this.f666d.setText(d2);
                this.f666d.setVisibility(0);
            } else {
                TextView textView2 = this.f666d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f666d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f667e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z) {
                charSequence = cVar.a();
            }
            s0.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i2, int i3) {
            int i4;
            super.onMeasure(i2, i3);
            if (j0.this.f656g > 0 && getMeasuredWidth() > (i4 = j0.this.f656g)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        q qVar = new q(getContext(), null, b.a.a.actionDropDownStyle);
        qVar.setLayoutParams(new b0.a(-2, -1));
        qVar.setOnItemSelectedListener(this);
        return qVar;
    }

    private boolean d() {
        Spinner spinner = this.f654e;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.f654e == null) {
                this.f654e = b();
            }
            removeView(this.f653d);
            addView(this.f654e, new ViewGroup.LayoutParams(-2, -1));
            if (this.f654e.getAdapter() == null) {
                this.f654e.setAdapter((SpinnerAdapter) new b());
            }
            Runnable runnable = this.f651b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f651b = null;
            }
            this.f654e.setSelection(this.f659j);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f654e);
        addView(this.f653d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f654e.getSelectedItemPosition());
        return false;
    }

    public void a(int i2) {
        View childAt = this.f653d.getChildAt(i2);
        Runnable runnable = this.f651b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f651b = aVar;
        post(aVar);
    }

    /* access modifiers changed from: package-private */
    public d c(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f658i));
        } else {
            dVar.setFocusable(true);
            if (this.f652c == null) {
                this.f652c = new c();
            }
            dVar.setOnClickListener(this.f652c);
        }
        return dVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f651b;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b.a.o.a b2 = b.a.o.a.b(getContext());
        setContentHeight(b2.f());
        this.f657h = b2.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f651b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((d) view).b().e();
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f653d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f656g = -1;
        } else {
            if (childCount > 2) {
                this.f656g = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.f656g = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f656g = Math.min(this.f656g, this.f657h);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f658i, 1073741824);
        if (z2 || !this.f655f) {
            z = false;
        }
        if (z) {
            this.f653d.measure(0, makeMeasureSpec);
            if (this.f653d.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f659j);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f655f = z;
    }

    public void setContentHeight(int i2) {
        this.f658i = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f659j = i2;
        int childCount = this.f653d.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f653d.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f654e;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }
}
