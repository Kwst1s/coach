package c.e.a.b.n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import b.h.k.u;
import c.e.a.b.b;
import c.e.a.b.c0.g;
import c.e.a.b.d;
import c.e.a.b.i;
import c.e.a.b.k;
import c.e.a.b.l;
import c.e.a.b.z.c;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.material.internal.h;
import com.google.android.material.internal.j;
import java.lang.ref.WeakReference;

/* compiled from: BadgeDrawable */
public class a extends Drawable implements h.b {
    private static final int r = k.Widget_MaterialComponents_Badge;
    private static final int s = b.badgeStyle;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f3398b;

    /* renamed from: c  reason: collision with root package name */
    private final g f3399c = new g();

    /* renamed from: d  reason: collision with root package name */
    private final h f3400d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f3401e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final float f3402f;

    /* renamed from: g  reason: collision with root package name */
    private final float f3403g;

    /* renamed from: h  reason: collision with root package name */
    private final float f3404h;

    /* renamed from: i  reason: collision with root package name */
    private final C0078a f3405i;

    /* renamed from: j  reason: collision with root package name */
    private float f3406j;

    /* renamed from: k  reason: collision with root package name */
    private float f3407k;
    private int l;
    private float m;
    private float n;
    private float o;
    private WeakReference<View> p;
    private WeakReference<ViewGroup> q;

    private a(Context context) {
        this.f3398b = new WeakReference<>(context);
        j.c(context);
        Resources resources = context.getResources();
        this.f3402f = (float) resources.getDimensionPixelSize(d.mtrl_badge_radius);
        this.f3404h = (float) resources.getDimensionPixelSize(d.mtrl_badge_long_text_horizontal_padding);
        this.f3403g = (float) resources.getDimensionPixelSize(d.mtrl_badge_with_text_radius);
        h hVar = new h(this);
        this.f3400d = hVar;
        hVar.e().setTextAlign(Paint.Align.CENTER);
        this.f3405i = new C0078a(context);
        t(k.TextAppearance_MaterialComponents_Badge);
    }

    private void b(Context context, Rect rect, View view) {
        float f2;
        float f3;
        int i2 = this.f3405i.f3416j;
        if (i2 == 8388691 || i2 == 8388693) {
            this.f3407k = (float) (rect.bottom - this.f3405i.l);
        } else {
            this.f3407k = (float) (rect.top + this.f3405i.l);
        }
        if (i() <= 9) {
            float f4 = !j() ? this.f3402f : this.f3403g;
            this.m = f4;
            this.o = f4;
            this.n = f4;
        } else {
            float f5 = this.f3403g;
            this.m = f5;
            this.o = f5;
            this.n = (this.f3400d.f(f()) / 2.0f) + this.f3404h;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(j() ? d.mtrl_badge_text_horizontal_edge_offset : d.mtrl_badge_horizontal_edge_offset);
        int i3 = this.f3405i.f3416j;
        if (i3 == 8388659 || i3 == 8388691) {
            if (u.B(view) == 0) {
                f2 = (((float) rect.left) - this.n) + ((float) dimensionPixelSize) + ((float) this.f3405i.f3417k);
            } else {
                f2 = ((((float) rect.right) + this.n) - ((float) dimensionPixelSize)) - ((float) this.f3405i.f3417k);
            }
            this.f3406j = f2;
            return;
        }
        if (u.B(view) == 0) {
            f3 = ((((float) rect.right) + this.n) - ((float) dimensionPixelSize)) - ((float) this.f3405i.f3417k);
        } else {
            f3 = (((float) rect.left) - this.n) + ((float) dimensionPixelSize) + ((float) this.f3405i.f3417k);
        }
        this.f3406j = f3;
    }

    public static a c(Context context) {
        return d(context, null, s, r);
    }

    private static a d(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context);
        aVar.k(context, attributeSet, i2, i3);
        return aVar;
    }

    private void e(Canvas canvas) {
        Rect rect = new Rect();
        String f2 = f();
        this.f3400d.e().getTextBounds(f2, 0, f2.length(), rect);
        canvas.drawText(f2, this.f3406j, this.f3407k + ((float) (rect.height() / 2)), this.f3400d.e());
    }

    private String f() {
        if (i() <= this.l) {
            return Integer.toString(i());
        }
        Context context = this.f3398b.get();
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        return context.getString(c.e.a.b.j.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.l), "+");
    }

    private void k(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray h2 = j.h(context, attributeSet, l.f3367d, i2, i3, new int[0]);
        q(h2.getInt(l.f3372i, 4));
        int i4 = l.f3373j;
        if (h2.hasValue(i4)) {
            r(h2.getInt(i4, 0));
        }
        m(l(context, h2, l.f3368e));
        int i5 = l.f3370g;
        if (h2.hasValue(i5)) {
            o(l(context, h2, i5));
        }
        n(h2.getInt(l.f3369f, 8388661));
        p(h2.getDimensionPixelOffset(l.f3371h, 0));
        u(h2.getDimensionPixelOffset(l.f3374k, 0));
        h2.recycle();
    }

    private static int l(Context context, TypedArray typedArray, int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    private void s(c.e.a.b.z.d dVar) {
        Context context;
        if (this.f3400d.d() != dVar && (context = this.f3398b.get()) != null) {
            this.f3400d.h(dVar, context);
            w();
        }
    }

    private void t(int i2) {
        Context context = this.f3398b.get();
        if (context != null) {
            s(new c.e.a.b.z.d(context, i2));
        }
    }

    private void w() {
        Context context = this.f3398b.get();
        WeakReference<View> weakReference = this.p;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f3401e);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<ViewGroup> weakReference2 = this.q;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null || b.f3418a) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            b(context, rect2, view);
            b.d(this.f3401e, this.f3406j, this.f3407k, this.n, this.o);
            this.f3399c.U(this.m);
            if (!rect.equals(this.f3401e)) {
                this.f3399c.setBounds(this.f3401e);
            }
        }
    }

    private void x() {
        double h2 = (double) h();
        Double.isNaN(h2);
        this.l = ((int) Math.pow(10.0d, h2 - 1.0d)) - 1;
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f3399c.draw(canvas);
            if (j()) {
                e(canvas);
            }
        }
    }

    public CharSequence g() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!j()) {
            return this.f3405i.f3413g;
        }
        if (this.f3405i.f3414h <= 0 || (context = this.f3398b.get()) == null) {
            return null;
        }
        if (i() <= this.l) {
            return context.getResources().getQuantityString(this.f3405i.f3414h, i(), Integer.valueOf(i()));
        }
        return context.getString(this.f3405i.f3415i, Integer.valueOf(this.l));
    }

    public int getAlpha() {
        return this.f3405i.f3410d;
    }

    public int getIntrinsicHeight() {
        return this.f3401e.height();
    }

    public int getIntrinsicWidth() {
        return this.f3401e.width();
    }

    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f3405i.f3412f;
    }

    public int i() {
        if (!j()) {
            return 0;
        }
        return this.f3405i.f3411e;
    }

    public boolean isStateful() {
        return false;
    }

    public boolean j() {
        return this.f3405i.f3411e != -1;
    }

    public void m(int i2) {
        this.f3405i.f3408b = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.f3399c.x() != valueOf) {
            this.f3399c.X(valueOf);
            invalidateSelf();
        }
    }

    public void n(int i2) {
        if (this.f3405i.f3416j != i2) {
            this.f3405i.f3416j = i2;
            WeakReference<View> weakReference = this.p;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.p.get();
                WeakReference<ViewGroup> weakReference2 = this.q;
                v(view, weakReference2 != null ? weakReference2.get() : null);
            }
        }
    }

    public void o(int i2) {
        this.f3405i.f3409c = i2;
        if (this.f3400d.e().getColor() != i2) {
            this.f3400d.e().setColor(i2);
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p(int i2) {
        this.f3405i.f3417k = i2;
        w();
    }

    public void q(int i2) {
        if (this.f3405i.f3412f != i2) {
            this.f3405i.f3412f = i2;
            x();
            this.f3400d.i(true);
            w();
            invalidateSelf();
        }
    }

    public void r(int i2) {
        int max = Math.max(0, i2);
        if (this.f3405i.f3411e != max) {
            this.f3405i.f3411e = max;
            this.f3400d.i(true);
            w();
            invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        this.f3405i.f3410d = i2;
        this.f3400d.e().setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void u(int i2) {
        this.f3405i.l = i2;
        w();
    }

    public void v(View view, ViewGroup viewGroup) {
        this.p = new WeakReference<>(view);
        this.q = new WeakReference<>(viewGroup);
        w();
        invalidateSelf();
    }

    /* renamed from: c.e.a.b.n.a$a  reason: collision with other inner class name */
    /* compiled from: BadgeDrawable */
    public static final class C0078a implements Parcelable {
        public static final Parcelable.Creator<C0078a> CREATOR = new C0079a();

        /* renamed from: b  reason: collision with root package name */
        private int f3408b;

        /* renamed from: c  reason: collision with root package name */
        private int f3409c;

        /* renamed from: d  reason: collision with root package name */
        private int f3410d = 255;

        /* renamed from: e  reason: collision with root package name */
        private int f3411e = -1;

        /* renamed from: f  reason: collision with root package name */
        private int f3412f;

        /* renamed from: g  reason: collision with root package name */
        private CharSequence f3413g;

        /* renamed from: h  reason: collision with root package name */
        private int f3414h;

        /* renamed from: i  reason: collision with root package name */
        private int f3415i;

        /* renamed from: j  reason: collision with root package name */
        private int f3416j;

        /* renamed from: k  reason: collision with root package name */
        private int f3417k;
        private int l;

        /* renamed from: c.e.a.b.n.a$a$a  reason: collision with other inner class name */
        /* compiled from: BadgeDrawable */
        static class C0079a implements Parcelable.Creator<C0078a> {
            C0079a() {
            }

            /* renamed from: a */
            public C0078a createFromParcel(Parcel parcel) {
                return new C0078a(parcel);
            }

            /* renamed from: b */
            public C0078a[] newArray(int i2) {
                return new C0078a[i2];
            }
        }

        public C0078a(Context context) {
            this.f3409c = new c.e.a.b.z.d(context, k.TextAppearance_MaterialComponents_Badge).f3452a.getDefaultColor();
            this.f3413g = context.getString(c.e.a.b.j.mtrl_badge_numberless_content_description);
            this.f3414h = i.mtrl_badge_content_description;
            this.f3415i = c.e.a.b.j.mtrl_exceed_max_badge_number_content_description;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f3408b);
            parcel.writeInt(this.f3409c);
            parcel.writeInt(this.f3410d);
            parcel.writeInt(this.f3411e);
            parcel.writeInt(this.f3412f);
            parcel.writeString(this.f3413g.toString());
            parcel.writeInt(this.f3414h);
            parcel.writeInt(this.f3416j);
            parcel.writeInt(this.f3417k);
            parcel.writeInt(this.l);
        }

        protected C0078a(Parcel parcel) {
            this.f3408b = parcel.readInt();
            this.f3409c = parcel.readInt();
            this.f3410d = parcel.readInt();
            this.f3411e = parcel.readInt();
            this.f3412f = parcel.readInt();
            this.f3413g = parcel.readString();
            this.f3414h = parcel.readInt();
            this.f3416j = parcel.readInt();
            this.f3417k = parcel.readInt();
            this.l = parcel.readInt();
        }
    }
}
