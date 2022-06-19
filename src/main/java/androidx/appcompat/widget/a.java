package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b.a.j;
import b.h.k.u;
import b.h.k.y;
import b.h.k.z;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: AbsActionBarView */
public abstract class a extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    protected final C0011a f538b;

    /* renamed from: c  reason: collision with root package name */
    protected final Context f539c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuView f540d;

    /* renamed from: e  reason: collision with root package name */
    protected c f541e;

    /* renamed from: f  reason: collision with root package name */
    protected int f542f;

    /* renamed from: g  reason: collision with root package name */
    protected y f543g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f544h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f545i;

    /* access modifiers changed from: protected */
    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AbsActionBarView */
    public class C0011a implements z {

        /* renamed from: a  reason: collision with root package name */
        private boolean f546a = false;

        /* renamed from: b  reason: collision with root package name */
        int f547b;

        protected C0011a() {
        }

        @Override // b.h.k.z
        public void a(View view) {
            this.f546a = true;
        }

        @Override // b.h.k.z
        public void b(View view) {
            if (!this.f546a) {
                a aVar = a.this;
                aVar.f543g = null;
                a.super.setVisibility(this.f547b);
            }
        }

        @Override // b.h.k.z
        public void c(View view) {
            a.super.setVisibility(0);
            this.f546a = false;
        }

        public C0011a d(y yVar, int i2) {
            a.this.f543g = yVar;
            this.f547b = i2;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected static int d(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    /* access modifiers changed from: protected */
    public int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* access modifiers changed from: protected */
    public int e(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public y f(int i2, long j2) {
        y yVar = this.f543g;
        if (yVar != null) {
            yVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(Utils.FLOAT_EPSILON);
            }
            y d2 = u.d(this);
            d2.a(1.0f);
            d2.d(j2);
            C0011a aVar = this.f538b;
            aVar.d(d2, i2);
            d2.f(aVar);
            return d2;
        }
        y d3 = u.d(this);
        d3.a(Utils.FLOAT_EPSILON);
        d3.d(j2);
        C0011a aVar2 = this.f538b;
        aVar2.d(d3, i2);
        d3.f(aVar2);
        return d3;
    }

    public int getAnimatedVisibility() {
        if (this.f543g != null) {
            return this.f538b.f547b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f542f;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.f1998a, b.a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.f2007j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f541e;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f545i = false;
        }
        if (!this.f545i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f545i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f545i = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f544h = false;
        }
        if (!this.f544h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f544h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f544h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            y yVar = this.f543g;
            if (yVar != null) {
                yVar.b();
            }
            super.setVisibility(i2);
        }
    }

    a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f538b = new C0011a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f539c = context;
        } else {
            this.f539c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
