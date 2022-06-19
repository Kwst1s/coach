package c.e.a.b.y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.c;
import c.e.a.b.b;
import c.e.a.b.k;

/* compiled from: MaterialRadioButton */
public class a extends AppCompatRadioButton {

    /* renamed from: g  reason: collision with root package name */
    private static final int f3445g = k.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h  reason: collision with root package name */
    private static final int[][] f3446h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f3447e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3448f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.w);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f3447e == null) {
            int c2 = c.e.a.b.s.a.c(this, b.f3255g);
            int c3 = c.e.a.b.s.a.c(this, b.colorOnSurface);
            int c4 = c.e.a.b.s.a.c(this, b.colorSurface);
            int[][] iArr = f3446h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = c.e.a.b.s.a.f(c4, c2, 1.0f);
            iArr2[1] = c.e.a.b.s.a.f(c4, c3, 0.54f);
            iArr2[2] = c.e.a.b.s.a.f(c4, c3, 0.38f);
            iArr2[3] = c.e.a.b.s.a.f(c4, c3, 0.38f);
            this.f3447e = new ColorStateList(iArr, iArr2);
        }
        return this.f3447e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3448f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f3448f = z;
        if (z) {
            c.c(this, getMaterialThemeColorsTintList());
        } else {
            c.c(this, null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = c.e.a.b.y.a.f3445g
            android.content.Context r8 = com.google.android.material.theme.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = c.e.a.b.l.a2
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.j.h(r0, r1, r2, r3, r4, r5)
            int r10 = c.e.a.b.l.b2
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x0028
            android.content.res.ColorStateList r8 = c.e.a.b.z.c.a(r8, r9, r10)
            androidx.core.widget.c.c(r7, r8)
        L_0x0028:
            int r8 = c.e.a.b.l.c2
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f3448f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.y.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
