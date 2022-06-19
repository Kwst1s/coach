package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.a.j;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f533b;

    /* renamed from: c  reason: collision with root package name */
    private int f534c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f535d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f536e;

    /* renamed from: f  reason: collision with root package name */
    private a f537f;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f533b != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f536e;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f533b, viewGroup, false);
            int i2 = this.f534c;
            if (i2 != -1) {
                inflate.setId(i2);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f535d = new WeakReference<>(inflate);
            a aVar = this.f537f;
            if (aVar != null) {
                aVar.a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f534c;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f536e;
    }

    public int getLayoutResource() {
        return this.f533b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i2) {
        this.f534c = i2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f536e = layoutInflater;
    }

    public void setLayoutResource(int i2) {
        this.f533b = i2;
    }

    public void setOnInflateListener(a aVar) {
        this.f537f = aVar;
    }

    public void setVisibility(int i2) {
        WeakReference<View> weakReference = this.f535d;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i2);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f533b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.H3, i2, 0);
        this.f534c = obtainStyledAttributes.getResourceId(j.K3, -1);
        this.f533b = obtainStyledAttributes.getResourceId(j.J3, 0);
        setId(obtainStyledAttributes.getResourceId(j.I3, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
