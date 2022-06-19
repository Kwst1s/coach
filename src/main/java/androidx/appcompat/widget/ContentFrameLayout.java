package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import b.h.k.u;

public class ContentFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private TypedValue f469b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f470c;

    /* renamed from: d  reason: collision with root package name */
    private TypedValue f471d;

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f472e;

    /* renamed from: f  reason: collision with root package name */
    private TypedValue f473f;

    /* renamed from: g  reason: collision with root package name */
    private TypedValue f474g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f475h;

    /* renamed from: i  reason: collision with root package name */
    private a f476i;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void b(int i2, int i3, int i4, int i5) {
        this.f475h.set(i2, i3, i4, i5);
        if (u.S(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f473f == null) {
            this.f473f = new TypedValue();
        }
        return this.f473f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f474g == null) {
            this.f474g = new TypedValue();
        }
        return this.f474g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f471d == null) {
            this.f471d = new TypedValue();
        }
        return this.f471d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f472e == null) {
            this.f472e = new TypedValue();
        }
        return this.f472e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f469b == null) {
            this.f469b = new TypedValue();
        }
        return this.f469b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f470c == null) {
            this.f470c = new TypedValue();
        }
        return this.f470c;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f476i;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f476i;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f476i = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f475h = new Rect();
    }
}
